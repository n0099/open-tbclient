package androidx.webkit;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.webkit.internal.AssetHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class WebViewAssetLoader {
    public static final String DEFAULT_DOMAIN = "appassets.androidplatform.net";
    public static final String TAG = "WebViewAssetLoader";
    public final List<PathMatcher> mMatchers;

    /* loaded from: classes.dex */
    public interface PathHandler {
        @Nullable
        @WorkerThread
        WebResourceResponse handle(@NonNull String str);
    }

    /* loaded from: classes.dex */
    public static final class AssetsPathHandler implements PathHandler {
        public AssetHelper mAssetHelper;

        public AssetsPathHandler(@NonNull Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @Nullable
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            return new WebResourceResponse(AssetHelper.guessMimeType(str), null, this.mAssetHelper.openAsset(str));
        }

        @VisibleForTesting
        public AssetsPathHandler(@NonNull AssetHelper assetHelper) {
            this.mAssetHelper = assetHelper;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        public boolean mHttpAllowed = false;
        public String mDomain = WebViewAssetLoader.DEFAULT_DOMAIN;
        @NonNull
        public List<PathMatcher> mBuilderMatcherList = new ArrayList();

        @NonNull
        public WebViewAssetLoader build() {
            return new WebViewAssetLoader(this.mBuilderMatcherList);
        }

        @NonNull
        public Builder addPathHandler(@NonNull String str, @NonNull PathHandler pathHandler) {
            this.mBuilderMatcherList.add(new PathMatcher(this.mDomain, str, this.mHttpAllowed, pathHandler));
            return this;
        }

        @NonNull
        public Builder setDomain(@NonNull String str) {
            this.mDomain = str;
            return this;
        }

        @NonNull
        public Builder setHttpAllowed(boolean z) {
            this.mHttpAllowed = z;
            return this;
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class PathMatcher {
        public static final String HTTPS_SCHEME = "https";
        public static final String HTTP_SCHEME = "http";
        @NonNull
        public final String mAuthority;
        @NonNull
        public final PathHandler mHandler;
        public final boolean mHttpEnabled;
        @NonNull
        public final String mPath;

        public PathMatcher(@NonNull String str, @NonNull String str2, boolean z, @NonNull PathHandler pathHandler) {
            if (!str2.isEmpty() && str2.charAt(0) == '/') {
                if (str2.endsWith("/")) {
                    this.mAuthority = str;
                    this.mPath = str2;
                    this.mHttpEnabled = z;
                    this.mHandler = pathHandler;
                    return;
                }
                throw new IllegalArgumentException("Path should end with a slash '/'");
            }
            throw new IllegalArgumentException("Path should start with a slash '/'.");
        }

        @NonNull
        @WorkerThread
        public String getSuffixPath(@NonNull String str) {
            return str.replaceFirst(this.mPath, "");
        }

        @Nullable
        @WorkerThread
        public PathHandler match(@NonNull Uri uri) {
            if (uri.getScheme().equals("http") && !this.mHttpEnabled) {
                return null;
            }
            if ((!uri.getScheme().equals("http") && !uri.getScheme().equals("https")) || !uri.getAuthority().equals(this.mAuthority) || !uri.getPath().startsWith(this.mPath)) {
                return null;
            }
            return this.mHandler;
        }
    }

    /* loaded from: classes.dex */
    public static final class ResourcesPathHandler implements PathHandler {
        public AssetHelper mAssetHelper;

        public ResourcesPathHandler(@NonNull Context context) {
            this.mAssetHelper = new AssetHelper(context);
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @Nullable
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            return new WebResourceResponse(AssetHelper.guessMimeType(str), null, this.mAssetHelper.openResource(str));
        }

        @VisibleForTesting
        public ResourcesPathHandler(@NonNull AssetHelper assetHelper) {
            this.mAssetHelper = assetHelper;
        }
    }

    public WebViewAssetLoader(@NonNull List<PathMatcher> list) {
        this.mMatchers = list;
    }

    @Nullable
    @WorkerThread
    public WebResourceResponse shouldInterceptRequest(@NonNull Uri uri) {
        WebResourceResponse handle;
        for (PathMatcher pathMatcher : this.mMatchers) {
            PathHandler match = pathMatcher.match(uri);
            if (match != null && (handle = match.handle(pathMatcher.getSuffixPath(uri.getPath()))) != null) {
                return handle;
            }
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static final class InternalStoragePathHandler implements PathHandler {
        public static final String[] FORBIDDEN_DATA_DIRS = {"app_webview/", "databases/", "lib/", "shared_prefs/", "code_cache/"};
        @NonNull
        public final File mDirectory;

        public InternalStoragePathHandler(@NonNull Context context, @NonNull File file) {
            if (isAllowedInternalStorageDir(context, file)) {
                this.mDirectory = file;
                return;
            }
            throw new IllegalArgumentException("The given directory \"" + file + "\" doesn't exist under an allowed app internal storage directory");
        }

        public static boolean isAllowedInternalStorageDir(@NonNull Context context, @NonNull File file) {
            String[] strArr;
            try {
                String canonicalPath = AssetHelper.getCanonicalPath(file);
                String canonicalPath2 = AssetHelper.getCanonicalPath(context.getCacheDir());
                String canonicalPath3 = AssetHelper.getCanonicalPath(AssetHelper.getDataDir(context));
                if ((canonicalPath.startsWith(canonicalPath2) || canonicalPath.startsWith(canonicalPath3)) && !canonicalPath.equals(canonicalPath2) && !canonicalPath.equals(canonicalPath3)) {
                    for (String str : FORBIDDEN_DATA_DIRS) {
                        if (canonicalPath.startsWith(canonicalPath3 + str)) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (IOException unused) {
            }
            return false;
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @NonNull
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            InputStream inputStream;
            File file = new File(this.mDirectory, str);
            if (AssetHelper.isCanonicalChildOf(this.mDirectory, file)) {
                inputStream = AssetHelper.openFile(file);
            } else {
                Log.e(WebViewAssetLoader.TAG, "The requested file: " + str + " is outside the mounted directory: " + this.mDirectory);
                inputStream = null;
            }
            return new WebResourceResponse(AssetHelper.guessMimeType(str), null, inputStream);
        }
    }
}

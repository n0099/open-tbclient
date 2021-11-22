package androidx.webkit;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.webkit.internal.AssetHelper;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class WebViewAssetLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_DOMAIN = "appassets.androidplatform.net";
    public static final String TAG = "WebViewAssetLoader";
    public transient /* synthetic */ FieldHolder $fh;
    public final List<PathMatcher> mMatchers;

    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public List<PathMatcher> mBuilderMatcherList;
        public String mDomain;
        public boolean mHttpAllowed;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mHttpAllowed = false;
            this.mDomain = WebViewAssetLoader.DEFAULT_DOMAIN;
            this.mBuilderMatcherList = new ArrayList();
        }

        @NonNull
        public Builder addPathHandler(@NonNull String str, @NonNull PathHandler pathHandler) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, pathHandler)) == null) {
                this.mBuilderMatcherList.add(new PathMatcher(this.mDomain, str, this.mHttpAllowed, pathHandler));
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        @NonNull
        public WebViewAssetLoader build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new WebViewAssetLoader(this.mBuilderMatcherList) : (WebViewAssetLoader) invokeV.objValue;
        }

        @NonNull
        public Builder setDomain(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.mDomain = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setHttpAllowed(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                this.mHttpAllowed = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class InternalStoragePathHandler implements PathHandler {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] FORBIDDEN_DATA_DIRS;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final File mDirectory;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(897832333, "Landroidx/webkit/WebViewAssetLoader$InternalStoragePathHandler;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(897832333, "Landroidx/webkit/WebViewAssetLoader$InternalStoragePathHandler;");
                    return;
                }
            }
            FORBIDDEN_DATA_DIRS = new String[]{"app_webview/", "databases/", PluginInstallerService.APK_LIB_DIR_PREFIX, "shared_prefs/", "code_cache/"};
        }

        public InternalStoragePathHandler(@NonNull Context context, @NonNull File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, file};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (isAllowedInternalStorageDir(context, file)) {
                this.mDirectory = file;
                return;
            }
            throw new IllegalArgumentException("The given directory \"" + file + "\" doesn't exist under an allowed app internal storage directory");
        }

        public static boolean isAllowedInternalStorageDir(@NonNull Context context, @NonNull File file) {
            InterceptResult invokeLL;
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, file)) == null) {
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
            return invokeLL.booleanValue;
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @NonNull
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            InterceptResult invokeL;
            InputStream inputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                File file = new File(this.mDirectory, str);
                if (AssetHelper.isCanonicalChildOf(this.mDirectory, file)) {
                    inputStream = AssetHelper.openFile(file);
                } else {
                    String str2 = "The requested file: " + str + " is outside the mounted directory: " + this.mDirectory;
                    inputStream = null;
                }
                return new WebResourceResponse(AssetHelper.guessMimeType(str), null, inputStream);
            }
            return (WebResourceResponse) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface PathHandler {
        @Nullable
        @WorkerThread
        WebResourceResponse handle(@NonNull String str);
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class PathMatcher {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String HTTPS_SCHEME = "https";
        public static final String HTTP_SCHEME = "http";
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final String mAuthority;
        @NonNull
        public final PathHandler mHandler;
        public final boolean mHttpEnabled;
        @NonNull
        public final String mPath;

        public PathMatcher(@NonNull String str, @NonNull String str2, boolean z, @NonNull PathHandler pathHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Boolean.valueOf(z), pathHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? str.replaceFirst(this.mPath, "") : (String) invokeL.objValue;
        }

        @Nullable
        @WorkerThread
        public PathHandler match(@NonNull Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
                if (!uri.getScheme().equals("http") || this.mHttpEnabled) {
                    if ((uri.getScheme().equals("http") || uri.getScheme().equals("https")) && uri.getAuthority().equals(this.mAuthority) && uri.getPath().startsWith(this.mPath)) {
                        return this.mHandler;
                    }
                    return null;
                }
                return null;
            }
            return (PathHandler) invokeL.objValue;
        }
    }

    public WebViewAssetLoader(@NonNull List<PathMatcher> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMatchers = list;
    }

    @Nullable
    @WorkerThread
    public WebResourceResponse shouldInterceptRequest(@NonNull Uri uri) {
        InterceptResult invokeL;
        WebResourceResponse handle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) {
            for (PathMatcher pathMatcher : this.mMatchers) {
                PathHandler match = pathMatcher.match(uri);
                if (match != null && (handle = match.handle(pathMatcher.getSuffixPath(uri.getPath()))) != null) {
                    return handle;
                }
            }
            return null;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    /* loaded from: classes.dex */
    public static final class AssetsPathHandler implements PathHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AssetHelper mAssetHelper;

        public AssetsPathHandler(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAssetHelper = new AssetHelper(context);
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @Nullable
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new WebResourceResponse(AssetHelper.guessMimeType(str), null, this.mAssetHelper.openAsset(str)) : (WebResourceResponse) invokeL.objValue;
        }

        @VisibleForTesting
        public AssetsPathHandler(@NonNull AssetHelper assetHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assetHelper};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mAssetHelper = assetHelper;
        }
    }

    /* loaded from: classes.dex */
    public static final class ResourcesPathHandler implements PathHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AssetHelper mAssetHelper;

        public ResourcesPathHandler(@NonNull Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAssetHelper = new AssetHelper(context);
        }

        @Override // androidx.webkit.WebViewAssetLoader.PathHandler
        @Nullable
        @WorkerThread
        public WebResourceResponse handle(@NonNull String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new WebResourceResponse(AssetHelper.guessMimeType(str), null, this.mAssetHelper.openResource(str)) : (WebResourceResponse) invokeL.objValue;
        }

        @VisibleForTesting
        public ResourcesPathHandler(@NonNull AssetHelper assetHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assetHelper};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mAssetHelper = assetHelper;
        }
    }
}

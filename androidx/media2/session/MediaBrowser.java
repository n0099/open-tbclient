package androidx.media2.session;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class MediaBrowser extends MediaController {
    public static final String TAG = "MediaBrowser";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);

    /* loaded from: classes.dex */
    public static class BrowserCallback extends MediaController.ControllerCallback {
        public void onChildrenChanged(@NonNull MediaBrowser mediaBrowser, @NonNull String str, @IntRange(from = 0) int i, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        }

        public void onSearchResultChanged(@NonNull MediaBrowser mediaBrowser, @NonNull String str, @IntRange(from = 0) int i, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        }
    }

    /* loaded from: classes.dex */
    public interface BrowserCallbackRunnable {
        void run(@NonNull BrowserCallback browserCallback);
    }

    /* loaded from: classes.dex */
    public interface MediaBrowserImpl extends MediaController.MediaControllerImpl {
        ListenableFuture<LibraryResult> getChildren(@NonNull String str, int i, int i2, @Nullable MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture<LibraryResult> getItem(@NonNull String str);

        ListenableFuture<LibraryResult> getLibraryRoot(@Nullable MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture<LibraryResult> getSearchResult(@NonNull String str, int i, int i2, @Nullable MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture<LibraryResult> search(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture<LibraryResult> subscribe(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture<LibraryResult> unsubscribe(@NonNull String str);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends MediaController.BuilderBase<MediaBrowser, Builder, BrowserCallback> {
        public Builder(@NonNull Context context) {
            super(context);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setConnectionHints(@NonNull Bundle bundle) {
            return (Builder) super.setConnectionHints(bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setSessionCompatToken(@NonNull MediaSessionCompat.Token token) {
            return (Builder) super.setSessionCompatToken(token);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setSessionToken(@NonNull SessionToken sessionToken) {
            return (Builder) super.setSessionToken(sessionToken);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public MediaBrowser build() {
            if (this.mToken == null && this.mCompatToken == null) {
                throw new IllegalArgumentException("token and compat token shouldn't be both null");
            }
            if (this.mToken != null) {
                return new MediaBrowser(this.mContext, this.mToken, this.mConnectionHints, this.mCallbackExecutor, (BrowserCallback) this.mCallback);
            }
            return new MediaBrowser(this.mContext, this.mCompatToken, this.mConnectionHints, this.mCallbackExecutor, (BrowserCallback) this.mCallback);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.media2.session.MediaController.BuilderBase
        @NonNull
        public Builder setControllerCallback(@NonNull Executor executor, @NonNull BrowserCallback browserCallback) {
            return (Builder) super.setControllerCallback(executor, (Executor) browserCallback);
        }
    }

    public static ListenableFuture<LibraryResult> createDisconnectedFuture() {
        return LibraryResult.createFutureWithResult(-100);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.media2.session.MediaController
    public MediaBrowserImpl getImpl() {
        return (MediaBrowserImpl) super.getImpl();
    }

    public MediaBrowser(@NonNull Context context, @NonNull MediaSessionCompat.Token token, @Nullable Bundle bundle, @Nullable Executor executor, @Nullable BrowserCallback browserCallback) {
        super(context, token, bundle, executor, browserCallback);
    }

    public MediaBrowser(@NonNull Context context, @NonNull SessionToken sessionToken, @Nullable Bundle bundle, @Nullable Executor executor, @Nullable BrowserCallback browserCallback) {
        super(context, sessionToken, bundle, executor, browserCallback);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.media2.session.MediaController
    public MediaBrowserImpl createImpl(@NonNull Context context, @NonNull SessionToken sessionToken, @Nullable Bundle bundle) {
        if (sessionToken.isLegacySession()) {
            return new MediaBrowserImplLegacy(context, this, sessionToken);
        }
        return new MediaBrowserImplBase(context, this, sessionToken, bundle);
    }

    @NonNull
    public ListenableFuture<LibraryResult> getChildren(@NonNull String str, @IntRange(from = 0) int i, @IntRange(from = 1) int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (!TextUtils.isEmpty(str)) {
            if (i >= 0) {
                if (i2 >= 1) {
                    if (isConnected()) {
                        return getImpl().getChildren(str, i, i2, libraryParams);
                    }
                    return createDisconnectedFuture();
                }
                throw new IllegalArgumentException("pageSize shouldn't be less than 1");
            }
            throw new IllegalArgumentException("page shouldn't be negative");
        }
        throw new IllegalArgumentException("parentId shouldn't be empty");
    }

    @NonNull
    public ListenableFuture<LibraryResult> getSearchResult(@NonNull String str, @IntRange(from = 0) int i, @IntRange(from = 1) int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (!TextUtils.isEmpty(str)) {
            if (i >= 0) {
                if (i2 >= 1) {
                    if (isConnected()) {
                        return getImpl().getSearchResult(str, i, i2, libraryParams);
                    }
                    return createDisconnectedFuture();
                }
                throw new IllegalArgumentException("pageSize shouldn't be less than 1");
            }
            throw new IllegalArgumentException("page shouldn't be negative");
        }
        throw new IllegalArgumentException("query shouldn't be empty");
    }

    @NonNull
    public ListenableFuture<LibraryResult> getItem(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            if (isConnected()) {
                return getImpl().getItem(str);
            }
            return createDisconnectedFuture();
        }
        throw new IllegalArgumentException("mediaId shouldn't be empty");
    }

    @NonNull
    public ListenableFuture<LibraryResult> getLibraryRoot(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (isConnected()) {
            return getImpl().getLibraryRoot(libraryParams);
        }
        return createDisconnectedFuture();
    }

    public void notifyBrowserCallback(final BrowserCallbackRunnable browserCallbackRunnable) {
        Executor executor;
        if (this.mPrimaryCallback != null && (executor = this.mPrimaryCallbackExecutor) != null) {
            executor.execute(new Runnable() { // from class: androidx.media2.session.MediaBrowser.1
                @Override // java.lang.Runnable
                public void run() {
                    browserCallbackRunnable.run((BrowserCallback) MediaBrowser.this.mPrimaryCallback);
                }
            });
        }
    }

    @NonNull
    public ListenableFuture<LibraryResult> unsubscribe(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            if (isConnected()) {
                return getImpl().unsubscribe(str);
            }
            return createDisconnectedFuture();
        }
        throw new IllegalArgumentException("parentId shouldn't be empty");
    }

    @NonNull
    public ListenableFuture<LibraryResult> search(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (!TextUtils.isEmpty(str)) {
            if (isConnected()) {
                return getImpl().search(str, libraryParams);
            }
            return createDisconnectedFuture();
        }
        throw new IllegalArgumentException("query shouldn't be empty");
    }

    @NonNull
    public ListenableFuture<LibraryResult> subscribe(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (!TextUtils.isEmpty(str)) {
            if (isConnected()) {
                return getImpl().subscribe(str, libraryParams);
            }
            return createDisconnectedFuture();
        }
        throw new IllegalArgumentException("parentId shouldn't be empty");
    }
}

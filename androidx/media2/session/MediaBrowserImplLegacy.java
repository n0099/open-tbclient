package androidx.media2.session;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.session.MediaBrowser;
import androidx.media2.session.MediaLibraryService;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class MediaBrowserImplLegacy extends MediaControllerImplLegacy implements MediaBrowser.MediaBrowserImpl {
    public static final String TAG = "MB2ImplLegacy";
    @GuardedBy("mLock")
    public final HashMap<MediaLibraryService.LibraryParams, MediaBrowserCompat> mBrowserCompats;
    @GuardedBy("mLock")
    public final HashMap<String, List<SubscribeCallback>> mSubscribeCallbacks;

    /* loaded from: classes.dex */
    public class GetChildrenCallback extends MediaBrowserCompat.SubscriptionCallback {
        public final ResolvableFuture<LibraryResult> mFuture;
        public final String mParentId;

        public GetChildrenCallback(ResolvableFuture<LibraryResult> resolvableFuture, String str) {
            this.mFuture = resolvableFuture;
            this.mParentId = str;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowserCompat.MediaItem> list, @NonNull Bundle bundle) {
            onChildrenLoadedInternal(str, list);
        }

        private void onChildrenLoadedInternal(@NonNull String str, @NonNull List<MediaBrowserCompat.MediaItem> list) {
            if (TextUtils.isEmpty(str)) {
                Log.w(MediaBrowserImplLegacy.TAG, "GetChildrenCallback.onChildrenLoaded(): Ignoring empty parentId");
                return;
            }
            MediaBrowserCompat browserCompat = MediaBrowserImplLegacy.this.getBrowserCompat();
            if (browserCompat == null) {
                this.mFuture.set(new LibraryResult(-100));
                return;
            }
            browserCompat.unsubscribe(this.mParentId, this);
            ArrayList arrayList = new ArrayList();
            if (list == null) {
                this.mFuture.set(new LibraryResult(-1));
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(MediaUtils.convertToMediaItem(list.get(i)));
            }
            this.mFuture.set(new LibraryResult(0, arrayList, (MediaLibraryService.LibraryParams) null));
        }

        private void onErrorInternal() {
            this.mFuture.set(new LibraryResult(-1));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowserCompat.MediaItem> list) {
            onChildrenLoadedInternal(str, list);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(@NonNull String str, @NonNull Bundle bundle) {
            onErrorInternal();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(@NonNull String str) {
            onErrorInternal();
        }
    }

    /* loaded from: classes.dex */
    public class GetLibraryRootCallback extends MediaBrowserCompat.ConnectionCallback {
        public final MediaLibraryService.LibraryParams mParams;
        public final ResolvableFuture<LibraryResult> mResult;

        public GetLibraryRootCallback(ResolvableFuture<LibraryResult> resolvableFuture, MediaLibraryService.LibraryParams libraryParams) {
            this.mResult = resolvableFuture;
            this.mParams = libraryParams;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat mediaBrowserCompat;
            synchronized (MediaBrowserImplLegacy.this.mLock) {
                mediaBrowserCompat = MediaBrowserImplLegacy.this.mBrowserCompats.get(this.mParams);
            }
            if (mediaBrowserCompat == null) {
                this.mResult.set(new LibraryResult(-1));
            } else {
                this.mResult.set(new LibraryResult(0, MediaBrowserImplLegacy.this.createRootMediaItem(mediaBrowserCompat), MediaUtils.convertToLibraryParams(MediaBrowserImplLegacy.this.mContext, mediaBrowserCompat.getExtras())));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            this.mResult.set(new LibraryResult(-3));
            MediaBrowserImplLegacy.this.close();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            onConnectionFailed();
        }
    }

    /* loaded from: classes.dex */
    public class SubscribeCallback extends MediaBrowserCompat.SubscriptionCallback {
        public final ResolvableFuture<LibraryResult> mFuture;

        public SubscribeCallback(ResolvableFuture<LibraryResult> resolvableFuture) {
            this.mFuture = resolvableFuture;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowserCompat.MediaItem> list) {
            onChildrenLoadedInternal(str, list);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(@NonNull String str, @NonNull Bundle bundle) {
            onErrorInternal();
        }

        private void onChildrenLoadedInternal(@NonNull final String str, @Nullable List<MediaBrowserCompat.MediaItem> list) {
            if (TextUtils.isEmpty(str)) {
                Log.w(MediaBrowserImplLegacy.TAG, "SubscribeCallback.onChildrenLoaded(): Ignoring empty parentId");
                return;
            }
            MediaBrowserCompat browserCompat = MediaBrowserImplLegacy.this.getBrowserCompat();
            if (browserCompat != null && list != null) {
                final int size = list.size();
                final MediaLibraryService.LibraryParams convertToLibraryParams = MediaUtils.convertToLibraryParams(MediaBrowserImplLegacy.this.mContext, browserCompat.getNotifyChildrenChangedOptions());
                MediaBrowserImplLegacy.this.getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable() { // from class: androidx.media2.session.MediaBrowserImplLegacy.SubscribeCallback.1
                    @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
                    public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                        browserCallback.onChildrenChanged(MediaBrowserImplLegacy.this.getMediaBrowser(), str, size, convertToLibraryParams);
                    }
                });
                this.mFuture.set(new LibraryResult(0));
            }
        }

        private void onErrorInternal() {
            this.mFuture.set(new LibraryResult(-1));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowserCompat.MediaItem> list, @NonNull Bundle bundle) {
            onChildrenLoadedInternal(str, list);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(@NonNull String str) {
            onErrorInternal();
        }
    }

    public MediaBrowserImplLegacy(@NonNull Context context, MediaBrowser mediaBrowser, @NonNull SessionToken sessionToken) {
        super(context, mediaBrowser, sessionToken);
        this.mBrowserCompats = new HashMap<>();
        this.mSubscribeCallbacks = new HashMap<>();
    }

    public static Bundle createOptions(@Nullable MediaLibraryService.LibraryParams libraryParams, int i, int i2) {
        Bundle createOptions = createOptions(libraryParams);
        createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE, i);
        createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, i2);
        return createOptions;
    }

    public static Bundle createOptions(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams != null && libraryParams.getExtras() != null) {
            return new Bundle(libraryParams.getExtras());
        }
        return new Bundle();
    }

    private MediaBrowserCompat getBrowserCompat(MediaLibraryService.LibraryParams libraryParams) {
        MediaBrowserCompat mediaBrowserCompat;
        synchronized (this.mLock) {
            mediaBrowserCompat = this.mBrowserCompats.get(libraryParams);
        }
        return mediaBrowserCompat;
    }

    public static Bundle getExtras(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams != null) {
            return libraryParams.getExtras();
        }
        return null;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getItem(@NonNull String str) {
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return LibraryResult.createFutureWithResult(-100);
        }
        final ResolvableFuture create = ResolvableFuture.create();
        browserCompat.getItem(str, new MediaBrowserCompat.ItemCallback() { // from class: androidx.media2.session.MediaBrowserImplLegacy.2
            @Override // android.support.v4.media.MediaBrowserCompat.ItemCallback
            public void onError(@NonNull String str2) {
                MediaBrowserImplLegacy.this.mHandler.post(new Runnable() { // from class: androidx.media2.session.MediaBrowserImplLegacy.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        create.set(new LibraryResult(-1));
                    }
                });
            }

            @Override // android.support.v4.media.MediaBrowserCompat.ItemCallback
            public void onItemLoaded(final MediaBrowserCompat.MediaItem mediaItem) {
                MediaBrowserImplLegacy.this.mHandler.post(new Runnable() { // from class: androidx.media2.session.MediaBrowserImplLegacy.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaBrowserCompat.MediaItem mediaItem2 = mediaItem;
                        if (mediaItem2 != null) {
                            create.set(new LibraryResult(0, MediaUtils.convertToMediaItem(mediaItem2), (MediaLibraryService.LibraryParams) null));
                        } else {
                            create.set(new LibraryResult(-3));
                        }
                    }
                });
            }
        });
        return create;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getLibraryRoot(@Nullable final MediaLibraryService.LibraryParams libraryParams) {
        final ResolvableFuture create = ResolvableFuture.create();
        MediaBrowserCompat browserCompat = getBrowserCompat(libraryParams);
        if (browserCompat != null) {
            create.set(new LibraryResult(0, createRootMediaItem(browserCompat), (MediaLibraryService.LibraryParams) null));
        } else {
            this.mHandler.post(new Runnable() { // from class: androidx.media2.session.MediaBrowserImplLegacy.1
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(MediaBrowserImplLegacy.this.getContext(), MediaBrowserImplLegacy.this.getConnectedToken().getComponentName(), new GetLibraryRootCallback(create, libraryParams), MediaUtils.convertToRootHints(libraryParams));
                    synchronized (MediaBrowserImplLegacy.this.mLock) {
                        MediaBrowserImplLegacy.this.mBrowserCompats.put(libraryParams, mediaBrowserCompat);
                    }
                    mediaBrowserCompat.connect();
                }
            });
        }
        return create;
    }

    @Override // androidx.media2.session.MediaControllerImplLegacy, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.mLock) {
            for (MediaBrowserCompat mediaBrowserCompat : this.mBrowserCompats.values()) {
                mediaBrowserCompat.disconnect();
            }
            this.mBrowserCompats.clear();
            super.close();
        }
    }

    @NonNull
    public MediaBrowser getMediaBrowser() {
        return (MediaBrowser) this.mInstance;
    }

    public MediaItem createRootMediaItem(@NonNull MediaBrowserCompat mediaBrowserCompat) {
        return new MediaItem.Builder().setMetadata(new MediaMetadata.Builder().putString("android.media.metadata.MEDIA_ID", mediaBrowserCompat.getRoot()).putLong(MediaMetadata.METADATA_KEY_BROWSABLE, 0L).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 0L).setExtras(mediaBrowserCompat.getExtras()).build()).build();
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> unsubscribe(@NonNull String str) {
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return LibraryResult.createFutureWithResult(-100);
        }
        synchronized (this.mLock) {
            List<SubscribeCallback> list = this.mSubscribeCallbacks.get(str);
            if (list == null) {
                return LibraryResult.createFutureWithResult(-3);
            }
            for (int i = 0; i < list.size(); i++) {
                browserCompat.unsubscribe(str, list.get(i));
            }
            return LibraryResult.createFutureWithResult(0);
        }
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getChildren(@NonNull String str, int i, int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return LibraryResult.createFutureWithResult(-100);
        }
        ResolvableFuture create = ResolvableFuture.create();
        browserCompat.subscribe(str, createOptions(libraryParams, i, i2), new GetChildrenCallback(create, str));
        return create;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getSearchResult(@NonNull String str, int i, int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return LibraryResult.createFutureWithResult(-100);
        }
        final ResolvableFuture create = ResolvableFuture.create();
        browserCompat.search(str, createOptions(libraryParams, i, i2), new MediaBrowserCompat.SearchCallback() { // from class: androidx.media2.session.MediaBrowserImplLegacy.4
            @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
            public void onError(@NonNull String str2, Bundle bundle) {
                MediaBrowserImplLegacy.this.mHandler.post(new Runnable() { // from class: androidx.media2.session.MediaBrowserImplLegacy.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        create.set(new LibraryResult(-1));
                    }
                });
            }

            @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
            public void onSearchResult(@NonNull String str2, Bundle bundle, @NonNull final List<MediaBrowserCompat.MediaItem> list) {
                MediaBrowserImplLegacy.this.mHandler.post(new Runnable() { // from class: androidx.media2.session.MediaBrowserImplLegacy.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        create.set(new LibraryResult(0, MediaUtils.convertMediaItemListToMediaItemList(list), (MediaLibraryService.LibraryParams) null));
                    }
                });
            }
        });
        return create;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> search(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return LibraryResult.createFutureWithResult(-100);
        }
        browserCompat.search(str, getExtras(libraryParams), new MediaBrowserCompat.SearchCallback() { // from class: androidx.media2.session.MediaBrowserImplLegacy.3
            @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
            public void onError(@NonNull final String str2, Bundle bundle) {
                MediaBrowserImplLegacy.this.getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable() { // from class: androidx.media2.session.MediaBrowserImplLegacy.3.2
                    @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
                    public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                        browserCallback.onSearchResultChanged(MediaBrowserImplLegacy.this.getMediaBrowser(), str2, 0, null);
                    }
                });
            }

            @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
            public void onSearchResult(@NonNull final String str2, Bundle bundle, @NonNull final List<MediaBrowserCompat.MediaItem> list) {
                MediaBrowserImplLegacy.this.getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable() { // from class: androidx.media2.session.MediaBrowserImplLegacy.3.1
                    @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
                    public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                        browserCallback.onSearchResultChanged(MediaBrowserImplLegacy.this.getMediaBrowser(), str2, list.size(), null);
                    }
                });
            }
        });
        return LibraryResult.createFutureWithResult(0);
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> subscribe(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return LibraryResult.createFutureWithResult(-100);
        }
        ResolvableFuture create = ResolvableFuture.create();
        SubscribeCallback subscribeCallback = new SubscribeCallback(create);
        synchronized (this.mLock) {
            List<SubscribeCallback> list = this.mSubscribeCallbacks.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.mSubscribeCallbacks.put(str, list);
            }
            list.add(subscribeCallback);
        }
        browserCompat.subscribe(str, createOptions(libraryParams), subscribeCallback);
        return create;
    }
}

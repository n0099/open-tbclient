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
import androidx.core.view.InputDeviceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.session.MediaBrowser;
import androidx.media2.session.MediaLibraryService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class MediaBrowserImplLegacy extends MediaControllerImplLegacy implements MediaBrowser.MediaBrowserImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "MB2ImplLegacy";
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("mLock")
    public final HashMap<MediaLibraryService.LibraryParams, MediaBrowserCompat> mBrowserCompats;
    @GuardedBy("mLock")
    public final HashMap<String, List<SubscribeCallback>> mSubscribeCallbacks;

    /* loaded from: classes.dex */
    public class GetChildrenCallback extends MediaBrowserCompat.SubscriptionCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResolvableFuture<LibraryResult> mFuture;
        public final String mParentId;
        public final /* synthetic */ MediaBrowserImplLegacy this$0;

        public GetChildrenCallback(MediaBrowserImplLegacy mediaBrowserImplLegacy, ResolvableFuture<LibraryResult> resolvableFuture, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserImplLegacy, resolvableFuture, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaBrowserImplLegacy;
            this.mFuture = resolvableFuture;
            this.mParentId = str;
        }

        private void onChildrenLoadedInternal(@NonNull String str, @NonNull List<MediaBrowserCompat.MediaItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, str, list) == null) {
                if (TextUtils.isEmpty(str)) {
                    Log.w(MediaBrowserImplLegacy.TAG, "GetChildrenCallback.onChildrenLoaded(): Ignoring empty parentId");
                    return;
                }
                MediaBrowserCompat browserCompat = this.this$0.getBrowserCompat();
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
        }

        private void onErrorInternal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.mFuture.set(new LibraryResult(-1));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowserCompat.MediaItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                onChildrenLoadedInternal(str, list);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                onErrorInternal();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowserCompat.MediaItem> list, @NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, bundle) == null) {
                onChildrenLoadedInternal(str, list);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(@NonNull String str, @NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, bundle) == null) {
                onErrorInternal();
            }
        }
    }

    /* loaded from: classes.dex */
    public class GetLibraryRootCallback extends MediaBrowserCompat.ConnectionCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaLibraryService.LibraryParams mParams;
        public final ResolvableFuture<LibraryResult> mResult;
        public final /* synthetic */ MediaBrowserImplLegacy this$0;

        public GetLibraryRootCallback(MediaBrowserImplLegacy mediaBrowserImplLegacy, ResolvableFuture<LibraryResult> resolvableFuture, MediaLibraryService.LibraryParams libraryParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserImplLegacy, resolvableFuture, libraryParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaBrowserImplLegacy;
            this.mResult = resolvableFuture;
            this.mParams = libraryParams;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat mediaBrowserCompat;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.this$0.mLock) {
                    mediaBrowserCompat = this.this$0.mBrowserCompats.get(this.mParams);
                }
                if (mediaBrowserCompat == null) {
                    this.mResult.set(new LibraryResult(-1));
                } else {
                    this.mResult.set(new LibraryResult(0, this.this$0.createRootMediaItem(mediaBrowserCompat), MediaUtils.convertToLibraryParams(this.this$0.mContext, mediaBrowserCompat.getExtras())));
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mResult.set(new LibraryResult(-3));
                this.this$0.close();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                onConnectionFailed();
            }
        }
    }

    /* loaded from: classes.dex */
    public class SubscribeCallback extends MediaBrowserCompat.SubscriptionCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ResolvableFuture<LibraryResult> mFuture;
        public final /* synthetic */ MediaBrowserImplLegacy this$0;

        public SubscribeCallback(MediaBrowserImplLegacy mediaBrowserImplLegacy, ResolvableFuture<LibraryResult> resolvableFuture) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserImplLegacy, resolvableFuture};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaBrowserImplLegacy;
            this.mFuture = resolvableFuture;
        }

        private void onChildrenLoadedInternal(@NonNull String str, @Nullable List<MediaBrowserCompat.MediaItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, this, str, list) == null) {
                if (TextUtils.isEmpty(str)) {
                    Log.w(MediaBrowserImplLegacy.TAG, "SubscribeCallback.onChildrenLoaded(): Ignoring empty parentId");
                    return;
                }
                MediaBrowserCompat browserCompat = this.this$0.getBrowserCompat();
                if (browserCompat == null || list == null) {
                    return;
                }
                this.this$0.getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable(this, str, list.size(), MediaUtils.convertToLibraryParams(this.this$0.mContext, browserCompat.getNotifyChildrenChangedOptions())) { // from class: androidx.media2.session.MediaBrowserImplLegacy.SubscribeCallback.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SubscribeCallback this$1;
                    public final /* synthetic */ int val$itemCount;
                    public final /* synthetic */ MediaLibraryService.LibraryParams val$params;
                    public final /* synthetic */ String val$parentId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, Integer.valueOf(r8), r9};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$parentId = str;
                        this.val$itemCount = r8;
                        this.val$params = r9;
                    }

                    @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
                    public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, browserCallback) == null) {
                            browserCallback.onChildrenChanged(this.this$1.this$0.getMediaBrowser(), this.val$parentId, this.val$itemCount, this.val$params);
                        }
                    }
                });
                this.mFuture.set(new LibraryResult(0));
            }
        }

        private void onErrorInternal() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.mFuture.set(new LibraryResult(-1));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowserCompat.MediaItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, list) == null) {
                onChildrenLoadedInternal(str, list);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                onErrorInternal();
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowserCompat.MediaItem> list, @NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, bundle) == null) {
                onChildrenLoadedInternal(str, list);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.SubscriptionCallback
        public void onError(@NonNull String str, @NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, str, bundle) == null) {
                onErrorInternal();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaBrowserImplLegacy(@NonNull Context context, MediaBrowser mediaBrowser, @NonNull SessionToken sessionToken) {
        super(context, mediaBrowser, sessionToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaBrowser, sessionToken};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (MediaController) objArr2[1], (SessionToken) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBrowserCompats = new HashMap<>();
        this.mSubscribeCallbacks = new HashMap<>();
    }

    public static Bundle createOptions(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, libraryParams)) == null) ? (libraryParams == null || libraryParams.getExtras() == null) ? new Bundle() : new Bundle(libraryParams.getExtras()) : (Bundle) invokeL.objValue;
    }

    private MediaBrowserCompat getBrowserCompat(MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeL;
        MediaBrowserCompat mediaBrowserCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, libraryParams)) == null) {
            synchronized (this.mLock) {
                mediaBrowserCompat = this.mBrowserCompats.get(libraryParams);
            }
            return mediaBrowserCompat;
        }
        return (MediaBrowserCompat) invokeL.objValue;
    }

    public static Bundle getExtras(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, libraryParams)) == null) {
            if (libraryParams != null) {
                return libraryParams.getExtras();
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaControllerImplLegacy, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.mLock) {
                for (MediaBrowserCompat mediaBrowserCompat : this.mBrowserCompats.values()) {
                    mediaBrowserCompat.disconnect();
                }
                this.mBrowserCompats.clear();
                super.close();
            }
        }
    }

    public MediaItem createRootMediaItem(@NonNull MediaBrowserCompat mediaBrowserCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaBrowserCompat)) == null) ? new MediaItem.Builder().setMetadata(new MediaMetadata.Builder().putString("android.media.metadata.MEDIA_ID", mediaBrowserCompat.getRoot()).putLong(MediaMetadata.METADATA_KEY_BROWSABLE, 0L).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 0L).setExtras(mediaBrowserCompat.getExtras()).build()).build() : (MediaItem) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getChildren(@NonNull String str, int i, int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams})) == null) {
            MediaBrowserCompat browserCompat = getBrowserCompat();
            if (browserCompat == null) {
                return LibraryResult.createFutureWithResult(-100);
            }
            ResolvableFuture create = ResolvableFuture.create();
            browserCompat.subscribe(str, createOptions(libraryParams, i, i2), new GetChildrenCallback(this, create, str));
            return create;
        }
        return (ListenableFuture) invokeCommon.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getItem(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            MediaBrowserCompat browserCompat = getBrowserCompat();
            if (browserCompat == null) {
                return LibraryResult.createFutureWithResult(-100);
            }
            ResolvableFuture create = ResolvableFuture.create();
            browserCompat.getItem(str, new MediaBrowserCompat.ItemCallback(this, create) { // from class: androidx.media2.session.MediaBrowserImplLegacy.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplLegacy this$0;
                public final /* synthetic */ ResolvableFuture val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, create};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$result = create;
                }

                @Override // android.support.v4.media.MediaBrowserCompat.ItemCallback
                public void onError(@NonNull String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                        this.this$0.mHandler.post(new Runnable(this) { // from class: androidx.media2.session.MediaBrowserImplLegacy.2.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.this$1.val$result.set(new LibraryResult(-1));
                                }
                            }
                        });
                    }
                }

                @Override // android.support.v4.media.MediaBrowserCompat.ItemCallback
                public void onItemLoaded(MediaBrowserCompat.MediaItem mediaItem) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaItem) == null) {
                        this.this$0.mHandler.post(new Runnable(this, mediaItem) { // from class: androidx.media2.session.MediaBrowserImplLegacy.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ MediaBrowserCompat.MediaItem val$item;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, mediaItem};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$item = mediaItem;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    MediaBrowserCompat.MediaItem mediaItem2 = this.val$item;
                                    if (mediaItem2 != null) {
                                        this.this$1.val$result.set(new LibraryResult(0, MediaUtils.convertToMediaItem(mediaItem2), (MediaLibraryService.LibraryParams) null));
                                    } else {
                                        this.this$1.val$result.set(new LibraryResult(-3));
                                    }
                                }
                            }
                        });
                    }
                }
            });
            return create;
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getLibraryRoot(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, libraryParams)) == null) {
            ResolvableFuture create = ResolvableFuture.create();
            MediaBrowserCompat browserCompat = getBrowserCompat(libraryParams);
            if (browserCompat != null) {
                create.set(new LibraryResult(0, createRootMediaItem(browserCompat), (MediaLibraryService.LibraryParams) null));
            } else {
                this.mHandler.post(new Runnable(this, libraryParams, create) { // from class: androidx.media2.session.MediaBrowserImplLegacy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaBrowserImplLegacy this$0;
                    public final /* synthetic */ MediaLibraryService.LibraryParams val$params;
                    public final /* synthetic */ ResolvableFuture val$result;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, libraryParams, create};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$params = libraryParams;
                        this.val$result = create;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(this.this$0.getContext(), this.this$0.getConnectedToken().getComponentName(), new GetLibraryRootCallback(this.this$0, this.val$result, this.val$params), MediaUtils.convertToRootHints(this.val$params));
                            synchronized (this.this$0.mLock) {
                                this.this$0.mBrowserCompats.put(this.val$params, mediaBrowserCompat);
                            }
                            mediaBrowserCompat.connect();
                        }
                    }
                });
            }
            return create;
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @NonNull
    public MediaBrowser getMediaBrowser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (MediaBrowser) this.mInstance : (MediaBrowser) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> getSearchResult(@NonNull String str, int i, int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), libraryParams})) == null) {
            MediaBrowserCompat browserCompat = getBrowserCompat();
            if (browserCompat == null) {
                return LibraryResult.createFutureWithResult(-100);
            }
            ResolvableFuture create = ResolvableFuture.create();
            browserCompat.search(str, createOptions(libraryParams, i, i2), new MediaBrowserCompat.SearchCallback(this, create) { // from class: androidx.media2.session.MediaBrowserImplLegacy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplLegacy this$0;
                public final /* synthetic */ ResolvableFuture val$future;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, create};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$future = create;
                }

                @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
                public void onError(@NonNull String str2, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str2, bundle) == null) {
                        this.this$0.mHandler.post(new Runnable(this) { // from class: androidx.media2.session.MediaBrowserImplLegacy.4.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass4 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.this$1.val$future.set(new LibraryResult(-1));
                                }
                            }
                        });
                    }
                }

                @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
                public void onSearchResult(@NonNull String str2, Bundle bundle, @NonNull List<MediaBrowserCompat.MediaItem> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, bundle, list) == null) {
                        this.this$0.mHandler.post(new Runnable(this, list) { // from class: androidx.media2.session.MediaBrowserImplLegacy.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass4 this$1;
                            public final /* synthetic */ List val$items;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, list};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$items = list;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.this$1.val$future.set(new LibraryResult(0, MediaUtils.convertMediaItemListToMediaItemList(this.val$items), (MediaLibraryService.LibraryParams) null));
                                }
                            }
                        });
                    }
                }
            });
            return create;
        }
        return (ListenableFuture) invokeCommon.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> search(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, libraryParams)) == null) {
            MediaBrowserCompat browserCompat = getBrowserCompat();
            if (browserCompat == null) {
                return LibraryResult.createFutureWithResult(-100);
            }
            browserCompat.search(str, getExtras(libraryParams), new MediaBrowserCompat.SearchCallback(this) { // from class: androidx.media2.session.MediaBrowserImplLegacy.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaBrowserImplLegacy this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
                public void onError(@NonNull String str2, Bundle bundle) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str2, bundle) == null) {
                        this.this$0.getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable(this, str2) { // from class: androidx.media2.session.MediaBrowserImplLegacy.3.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;
                            public final /* synthetic */ String val$query;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str2};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$query = str2;
                            }

                            @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
                            public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, browserCallback) == null) {
                                    browserCallback.onSearchResultChanged(this.this$1.this$0.getMediaBrowser(), this.val$query, 0, null);
                                }
                            }
                        });
                    }
                }

                @Override // android.support.v4.media.MediaBrowserCompat.SearchCallback
                public void onSearchResult(@NonNull String str2, Bundle bundle, @NonNull List<MediaBrowserCompat.MediaItem> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, bundle, list) == null) {
                        this.this$0.getMediaBrowser().notifyBrowserCallback(new MediaBrowser.BrowserCallbackRunnable(this, str2, list) { // from class: androidx.media2.session.MediaBrowserImplLegacy.3.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass3 this$1;
                            public final /* synthetic */ List val$items;
                            public final /* synthetic */ String val$query;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str2, list};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$query = str2;
                                this.val$items = list;
                            }

                            @Override // androidx.media2.session.MediaBrowser.BrowserCallbackRunnable
                            public void run(@NonNull MediaBrowser.BrowserCallback browserCallback) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, browserCallback) == null) {
                                    browserCallback.onSearchResultChanged(this.this$1.this$0.getMediaBrowser(), this.val$query, this.val$items.size(), null);
                                }
                            }
                        });
                    }
                }
            });
            return LibraryResult.createFutureWithResult(0);
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> subscribe(@NonNull String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, libraryParams)) == null) {
            MediaBrowserCompat browserCompat = getBrowserCompat();
            if (browserCompat == null) {
                return LibraryResult.createFutureWithResult(-100);
            }
            ResolvableFuture create = ResolvableFuture.create();
            SubscribeCallback subscribeCallback = new SubscribeCallback(this, create);
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
        return (ListenableFuture) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture<LibraryResult> unsubscribe(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
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
        return (ListenableFuture) invokeL.objValue;
    }

    public static Bundle createOptions(@Nullable MediaLibraryService.LibraryParams libraryParams, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, libraryParams, i, i2)) == null) {
            Bundle createOptions = createOptions(libraryParams);
            createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE, i);
            createOptions.putInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, i2);
            return createOptions;
        }
        return (Bundle) invokeLII.objValue;
    }
}

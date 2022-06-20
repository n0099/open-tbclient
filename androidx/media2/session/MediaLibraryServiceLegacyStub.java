package androidx.media2.session;

import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MediaLibraryServiceLegacyStub extends MediaSessionServiceLegacyStub {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "MLS2LegacyStub";
    public transient /* synthetic */ FieldHolder $fh;
    public final MediaSession.ControllerCb mBrowserLegacyCbForBroadcast;
    public final MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl mLibrarySessionImpl;

    /* loaded from: classes.dex */
    public static abstract class BaseBrowserLegacyCb extends MediaSession.ControllerCb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public BaseBrowserLegacyCb() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onAllowedCommandsChanged(int i, @NonNull SessionCommandGroup sessionCommandGroup) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, sessionCommandGroup) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onBufferingStateChanged(int i, @NonNull MediaItem mediaItem, int i2, long j, long j2, long j3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), mediaItem, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onCurrentMediaItemChanged(int i, MediaItem mediaItem, int i2, int i3, int i4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), mediaItem, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onDisconnected(int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onLibraryResult(int i, LibraryResult libraryResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, libraryResult) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaybackCompleted(int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaybackInfoChanged(int i, @NonNull MediaController.PlaybackInfo playbackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i, playbackInfo) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f)}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerResult(int i, SessionPlayer.PlayerResult playerResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, playerResult) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaylistChanged(int i, @NonNull List<MediaItem> list, MediaMetadata mediaMetadata, int i2, int i3, int i4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), list, mediaMetadata, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048587, this, i, mediaMetadata) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSessionResult(int i, SessionResult sessionResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048590, this, i, sessionResult) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onSubtitleData(int i, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), mediaItem, trackInfo, subtitleData}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048593, this, i, trackInfo) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void onTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048594, this, i, trackInfo) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), list, trackInfo, trackInfo2, trackInfo3, trackInfo4}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onVideoSizeChanged(int i, @NonNull VideoSize videoSize) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048596, this, i, videoSize) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void sendCustomCommand(int i, @NonNull SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048597, this, i, sessionCommand, bundle) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public final void setCustomLayout(int i, @NonNull List<MediaSession.CommandButton> list) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048598, this, i, list) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public final class BrowserLegacyCb extends BaseBrowserLegacyCb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object mLock;
        public final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        @GuardedBy("mLock")
        public final List<SearchRequest> mSearchRequests;
        public final /* synthetic */ MediaLibraryServiceLegacyStub this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BrowserLegacyCb(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub, MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaLibraryServiceLegacyStub, remoteUserInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaLibraryServiceLegacyStub;
            this.mLock = new Object();
            this.mSearchRequests = new ArrayList();
            this.mRemoteUserInfo = remoteUserInfo;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BrowserLegacyCb) {
                    return ObjectsCompat.equals(this.mRemoteUserInfo, ((BrowserLegacyCb) obj).mRemoteUserInfo);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ObjectsCompat.hash(this.mRemoteUserInfo) : invokeV.intValue;
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), libraryParams}) == null) {
                this.this$0.notifyChildrenChanged(this.mRemoteUserInfo, str, libraryParams != null ? libraryParams.getExtras() : null);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), libraryParams}) == null) {
                ArrayList arrayList = new ArrayList();
                synchronized (this.mLock) {
                    for (int size = this.mSearchRequests.size() - 1; size >= 0; size--) {
                        SearchRequest searchRequest = this.mSearchRequests.get(size);
                        if (ObjectsCompat.equals(this.mRemoteUserInfo, searchRequest.mRemoteUserInfo) && searchRequest.mQuery.equals(str)) {
                            arrayList.add(searchRequest);
                            this.mSearchRequests.remove(size);
                        }
                    }
                    if (arrayList.size() == 0) {
                        return;
                    }
                    this.this$0.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable(this, arrayList) { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.BrowserLegacyCb.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BrowserLegacyCb this$1;
                        public final /* synthetic */ List val$searchRequests;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$searchRequests = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            int i3;
                            int i4;
                            int i5;
                            int i6;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                for (int i7 = 0; i7 < this.val$searchRequests.size(); i7++) {
                                    SearchRequest searchRequest2 = (SearchRequest) this.val$searchRequests.get(i7);
                                    Bundle bundle = searchRequest2.mExtras;
                                    if (bundle != null) {
                                        try {
                                            bundle.setClassLoader(this.this$1.this$0.mLibrarySessionImpl.getContext().getClassLoader());
                                            i3 = searchRequest2.mExtras.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                                            i4 = searchRequest2.mExtras.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                                        } catch (BadParcelableException unused) {
                                            searchRequest2.mResult.sendResult(null);
                                            return;
                                        }
                                    } else {
                                        i3 = 0;
                                        i4 = Integer.MAX_VALUE;
                                    }
                                    if (i3 < 0 || i4 < 1) {
                                        i5 = 0;
                                        i6 = Integer.MAX_VALUE;
                                    } else {
                                        i5 = i3;
                                        i6 = i4;
                                    }
                                    LibraryResult onGetSearchResult = this.this$1.this$0.mLibrarySessionImpl.getCallback().onGetSearchResult(this.this$1.this$0.mLibrarySessionImpl.getInstance(), searchRequest2.mController, searchRequest2.mQuery, i5, i6, MediaUtils.convertToLibraryParams(this.this$1.this$0.mLibrarySessionImpl.getContext(), searchRequest2.mExtras));
                                    if (onGetSearchResult != null && onGetSearchResult.getResultCode() == 0) {
                                        searchRequest2.mResult.sendResult(MediaUtils.truncateListBySize(MediaUtils.convertToMediaItemList(onGetSearchResult.getMediaItems()), 262144));
                                    } else {
                                        searchRequest2.mResult.sendResult(null);
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }

        public void registerSearchRequest(MediaSession.ControllerInfo controllerInfo, String str, Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048580, this, controllerInfo, str, bundle, result) == null) {
                synchronized (this.mLock) {
                    this.mSearchRequests.add(new SearchRequest(controllerInfo, controllerInfo.getRemoteUserInfo(), str, bundle, result));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class BrowserLegacyCbForBroadcast extends BaseBrowserLegacyCb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaBrowserServiceCompat mService;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BrowserLegacyCbForBroadcast(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaBrowserServiceCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mService = mediaBrowserServiceCompat;
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), libraryParams}) == null) {
                if (libraryParams != null && libraryParams.getExtras() != null) {
                    this.mService.notifyChildrenChanged(str, libraryParams.getExtras());
                } else {
                    this.mService.notifyChildrenChanged(str);
                }
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), libraryParams}) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SearchRequest {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaSession.ControllerInfo mController;
        public final Bundle mExtras;
        public final String mQuery;
        public final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        public final MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> mResult;

        public SearchRequest(MediaSession.ControllerInfo controllerInfo, MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {controllerInfo, remoteUserInfo, str, bundle, result};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mController = controllerInfo;
            this.mRemoteUserInfo = remoteUserInfo;
            this.mQuery = str;
            this.mExtras = bundle;
            this.mResult = result;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaLibraryServiceLegacyStub(Context context, MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl mediaLibrarySessionImpl, MediaSessionCompat.Token token) {
        super(context, mediaLibrarySessionImpl, token);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaLibrarySessionImpl, token};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (MediaSession.MediaSessionImpl) objArr2[1], (MediaSessionCompat.Token) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLibrarySessionImpl = mediaLibrarySessionImpl;
        this.mBrowserLegacyCbForBroadcast = new BrowserLegacyCbForBroadcast(this);
    }

    private MediaSession.ControllerInfo getCurrentController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? getConnectedControllersManager().getController(getCurrentBrowserInfo()) : (MediaSession.ControllerInfo) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSessionServiceLegacyStub
    public MediaSession.ControllerInfo createControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, remoteUserInfo)) == null) ? new MediaSession.ControllerInfo(remoteUserInfo, -1, this.mManager.isTrustedForMediaControl(remoteUserInfo), new BrowserLegacyCb(this, remoteUserInfo), null) : (MediaSession.ControllerInfo) invokeL.objValue;
    }

    public MediaSession.ControllerCb getBrowserLegacyCbForBroadcast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBrowserLegacyCbForBroadcast : (MediaSession.ControllerCb) invokeV.objValue;
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onCustomAction(String str, Bundle bundle, MediaBrowserServiceCompat.Result<Bundle> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle, result) == null) {
            if (result != null) {
                result.detach();
            }
            this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable(this, str, getCurrentController(), result, bundle) { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaLibraryServiceLegacyStub this$0;
                public final /* synthetic */ String val$action;
                public final /* synthetic */ MediaSession.ControllerInfo val$controller;
                public final /* synthetic */ Bundle val$extras;
                public final /* synthetic */ MediaBrowserServiceCompat.Result val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, r8, result, bundle};
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
                    this.val$action = str;
                    this.val$controller = r8;
                    this.val$result = result;
                    this.val$extras = bundle;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SessionCommand sessionCommand = new SessionCommand(this.val$action, null);
                        if (!this.this$0.getConnectedControllersManager().isAllowedCommand(this.val$controller, sessionCommand)) {
                            MediaBrowserServiceCompat.Result result2 = this.val$result;
                            if (result2 != null) {
                                result2.sendError(null);
                                return;
                            }
                            return;
                        }
                        SessionResult onCustomCommand = this.this$0.mLibrarySessionImpl.getCallback().onCustomCommand(this.this$0.mLibrarySessionImpl.getInstance(), this.val$controller, sessionCommand, this.val$extras);
                        if (onCustomCommand != null) {
                            this.val$result.sendResult(onCustomCommand.getCustomCommandResult());
                        }
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.MediaSessionServiceLegacyStub, androidx.media.MediaBrowserServiceCompat
    public MediaBrowserServiceCompat.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
        InterceptResult invokeLIL;
        MediaSession.ControllerInfo currentController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, str, i, bundle)) == null) {
            if (super.onGetRoot(str, i, bundle) == null || (currentController = getCurrentController()) == null) {
                return null;
            }
            if (getConnectedControllersManager().isAllowedCommand(currentController, 50000)) {
                LibraryResult onGetLibraryRoot = this.mLibrarySessionImpl.getCallback().onGetLibraryRoot(this.mLibrarySessionImpl.getInstance(), currentController, MediaUtils.convertToLibraryParams(this.mLibrarySessionImpl.getContext(), bundle));
                if (onGetLibraryRoot != null && onGetLibraryRoot.getResultCode() == 0 && onGetLibraryRoot.getMediaItem() != null) {
                    MediaMetadata metadata = onGetLibraryRoot.getMediaItem().getMetadata();
                    return new MediaBrowserServiceCompat.BrowserRoot(metadata != null ? metadata.getString("android.media.metadata.MEDIA_ID") : "", MediaUtils.convertToRootHints(onGetLibraryRoot.getLibraryParams()));
                }
            }
            return MediaUtils.sDefaultBrowserRoot;
        }
        return (MediaBrowserServiceCompat.BrowserRoot) invokeLIL.objValue;
    }

    @Override // androidx.media2.session.MediaSessionServiceLegacyStub, androidx.media.MediaBrowserServiceCompat
    public void onLoadChildren(String str, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, result) == null) {
            onLoadChildren(str, result, null);
        }
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onLoadItem(String str, MediaBrowserServiceCompat.Result<MediaBrowserCompat.MediaItem> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, result) == null) {
            MediaSession.ControllerInfo currentController = getCurrentController();
            if (TextUtils.isEmpty(str)) {
                Log.w(TAG, "Ignoring empty itemId from " + currentController);
                result.sendError(null);
                return;
            }
            result.detach();
            this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable(this, currentController, result, str) { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaLibraryServiceLegacyStub this$0;
                public final /* synthetic */ MediaSession.ControllerInfo val$controller;
                public final /* synthetic */ String val$itemId;
                public final /* synthetic */ MediaBrowserServiceCompat.Result val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, currentController, result, str};
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
                    this.val$controller = currentController;
                    this.val$result = result;
                    this.val$itemId = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.this$0.getConnectedControllersManager().isAllowedCommand(this.val$controller, (int) SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM)) {
                            this.val$result.sendError(null);
                            return;
                        }
                        LibraryResult onGetItem = this.this$0.mLibrarySessionImpl.getCallback().onGetItem(this.this$0.mLibrarySessionImpl.getInstance(), this.val$controller, this.val$itemId);
                        if (onGetItem != null && onGetItem.getResultCode() == 0) {
                            this.val$result.sendResult(MediaUtils.convertToMediaItem(onGetItem.getMediaItem()));
                        } else {
                            this.val$result.sendResult(null);
                        }
                    }
                }
            });
        }
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onSearch(String str, Bundle bundle, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, bundle, result) == null) {
            MediaSession.ControllerInfo currentController = getCurrentController();
            if (TextUtils.isEmpty(str)) {
                Log.w(TAG, "Ignoring empty query from " + currentController);
                result.sendError(null);
            } else if (currentController.getControllerCb() instanceof BrowserLegacyCb) {
                result.detach();
                this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable(this, currentController, result, str, bundle) { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaLibraryServiceLegacyStub this$0;
                    public final /* synthetic */ MediaSession.ControllerInfo val$controller;
                    public final /* synthetic */ Bundle val$extras;
                    public final /* synthetic */ String val$query;
                    public final /* synthetic */ MediaBrowserServiceCompat.Result val$result;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, currentController, result, str, bundle};
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
                        this.val$controller = currentController;
                        this.val$result = result;
                        this.val$query = str;
                        this.val$extras = bundle;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!this.this$0.getConnectedControllersManager().isAllowedCommand(this.val$controller, (int) SessionCommand.COMMAND_CODE_LIBRARY_SEARCH)) {
                                this.val$result.sendError(null);
                                return;
                            }
                            ((BrowserLegacyCb) this.val$controller.getControllerCb()).registerSearchRequest(this.val$controller, this.val$query, this.val$extras, this.val$result);
                            this.this$0.mLibrarySessionImpl.getCallback().onSearch(this.this$0.mLibrarySessionImpl.getInstance(), this.val$controller, this.val$query, MediaUtils.convertToLibraryParams(this.this$0.mLibrarySessionImpl.getContext(), this.val$extras));
                        }
                    }
                });
            }
        }
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onSubscribe(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bundle) == null) {
            MediaSession.ControllerInfo currentController = getCurrentController();
            if (TextUtils.isEmpty(str)) {
                Log.w(TAG, "onSubscribe(): Ignoring empty id from " + currentController);
                return;
            }
            this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable(this, currentController, bundle, str) { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaLibraryServiceLegacyStub this$0;
                public final /* synthetic */ MediaSession.ControllerInfo val$controller;
                public final /* synthetic */ String val$id;
                public final /* synthetic */ Bundle val$option;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, currentController, bundle, str};
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
                    this.val$controller = currentController;
                    this.val$option = bundle;
                    this.val$id = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.getConnectedControllersManager().isAllowedCommand(this.val$controller, (int) SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE)) {
                        this.this$0.mLibrarySessionImpl.getCallback().onSubscribe(this.this$0.mLibrarySessionImpl.getInstance(), this.val$controller, this.val$id, MediaUtils.convertToLibraryParams(this.this$0.mLibrarySessionImpl.getContext(), this.val$option));
                    }
                }
            });
        }
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onUnsubscribe(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            MediaSession.ControllerInfo currentController = getCurrentController();
            if (TextUtils.isEmpty(str)) {
                Log.w(TAG, "onUnsubscribe(): Ignoring empty id from " + currentController);
                return;
            }
            this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable(this, currentController, str) { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaLibraryServiceLegacyStub this$0;
                public final /* synthetic */ MediaSession.ControllerInfo val$controller;
                public final /* synthetic */ String val$id;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, currentController, str};
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
                    this.val$controller = currentController;
                    this.val$id = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.getConnectedControllersManager().isAllowedCommand(this.val$controller, (int) SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE)) {
                        this.this$0.mLibrarySessionImpl.getCallback().onUnsubscribe(this.this$0.mLibrarySessionImpl.getInstance(), this.val$controller, this.val$id);
                    }
                }
            });
        }
    }

    @Override // androidx.media.MediaBrowserServiceCompat
    public void onLoadChildren(String str, MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> result, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, str, result, bundle) == null) {
            MediaSession.ControllerInfo currentController = getCurrentController();
            if (TextUtils.isEmpty(str)) {
                Log.w(TAG, "onLoadChildren(): Ignoring empty parentId from " + currentController);
                result.sendError(null);
                return;
            }
            result.detach();
            this.mLibrarySessionImpl.getCallbackExecutor().execute(new Runnable(this, currentController, result, bundle, str) { // from class: androidx.media2.session.MediaLibraryServiceLegacyStub.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaLibraryServiceLegacyStub this$0;
                public final /* synthetic */ MediaSession.ControllerInfo val$controller;
                public final /* synthetic */ Bundle val$options;
                public final /* synthetic */ String val$parentId;
                public final /* synthetic */ MediaBrowserServiceCompat.Result val$result;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, currentController, result, bundle, str};
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
                    this.val$controller = currentController;
                    this.val$result = result;
                    this.val$options = bundle;
                    this.val$parentId = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!this.this$0.getConnectedControllersManager().isAllowedCommand(this.val$controller, (int) SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN)) {
                            this.val$result.sendError(null);
                            return;
                        }
                        Bundle bundle2 = this.val$options;
                        if (bundle2 != null) {
                            bundle2.setClassLoader(this.this$0.mLibrarySessionImpl.getContext().getClassLoader());
                            try {
                                int i = this.val$options.getInt(MediaBrowserCompat.EXTRA_PAGE);
                                int i2 = this.val$options.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE);
                                if (i > 0 && i2 > 0) {
                                    LibraryResult onGetChildren = this.this$0.mLibrarySessionImpl.getCallback().onGetChildren(this.this$0.mLibrarySessionImpl.getInstance(), this.val$controller, this.val$parentId, i, i2, MediaUtils.convertToLibraryParams(this.this$0.mLibrarySessionImpl.getContext(), this.val$options));
                                    if (onGetChildren != null && onGetChildren.getResultCode() == 0) {
                                        this.val$result.sendResult(MediaUtils.truncateListBySize(MediaUtils.convertToMediaItemList(onGetChildren.getMediaItems()), 262144));
                                        return;
                                    }
                                    this.val$result.sendResult(null);
                                    return;
                                }
                            } catch (BadParcelableException unused) {
                            }
                        }
                        LibraryResult onGetChildren2 = this.this$0.mLibrarySessionImpl.getCallback().onGetChildren(this.this$0.mLibrarySessionImpl.getInstance(), this.val$controller, this.val$parentId, 0, Integer.MAX_VALUE, null);
                        if (onGetChildren2 != null && onGetChildren2.getResultCode() == 0) {
                            this.val$result.sendResult(MediaUtils.truncateListBySize(MediaUtils.convertToMediaItemList(onGetChildren2.getMediaItems()), 262144));
                        } else {
                            this.val$result.sendResult(null);
                        }
                    }
                }
            });
        }
    }
}

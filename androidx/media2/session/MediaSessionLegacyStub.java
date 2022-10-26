package androidx.media2.session;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SessionCommandGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public class MediaSessionLegacyStub extends MediaSessionCompat.Callback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int DEFAULT_CONNECTION_TIMEOUT_MS = 300000;
    public static final String TAG = "MediaSessionLegacyStub";
    public static final SparseArray<SessionCommand> sCommandsForOnCommandRequest;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> mConnectedControllersManager;
    public final ConnectionTimeoutHandler mConnectionTimeoutHandler;
    public volatile long mConnectionTimeoutMs;
    public final Context mContext;
    public final MediaSession.ControllerCb mControllerLegacyCbForBroadcast;
    public final MediaSession.MediaSessionImpl mSessionImpl;
    public final androidx.media.MediaSessionManager mSessionManager;

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface SessionTask {
        void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCustomAction(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, bundle) == null) {
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetCaptioningEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
        }
    }

    /* loaded from: classes.dex */
    public class ConnectionTimeoutHandler extends Handler {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MSG_CONNECTION_TIMED_OUT = 1001;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaSessionLegacyStub this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConnectionTimeoutHandler(MediaSessionLegacyStub mediaSessionLegacyStub, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSessionLegacyStub, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaSessionLegacyStub;
        }

        public void disconnectControllerAfterTimeout(MediaSession.ControllerInfo controllerInfo, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, controllerInfo, j) == null) {
                removeMessages(1001, controllerInfo);
                sendMessageDelayed(obtainMessage(1001, controllerInfo), j);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                MediaSession.ControllerInfo controllerInfo = (MediaSession.ControllerInfo) message.obj;
                if (this.this$0.mConnectedControllersManager.isConnected(controllerInfo)) {
                    try {
                        controllerInfo.getControllerCb().onDisconnected(0);
                    } catch (RemoteException unused) {
                    }
                    this.this$0.mConnectedControllersManager.removeController(controllerInfo);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public final class ControllerLegacyCb extends MediaSession.ControllerCb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        public final /* synthetic */ MediaSessionLegacyStub this$0;

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onAllowedCommandsChanged(int i, SessionCommandGroup sessionCommandGroup) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, sessionCommandGroup) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), libraryParams}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onDisconnected(int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onLibraryResult(int i, LibraryResult libraryResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048583, this, i, libraryResult) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerResult(int i, SessionPlayer.PlayerResult playerResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048587, this, i, playerResult) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), libraryParams}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSessionResult(int i, SessionResult sessionResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048594, this, i, sessionResult) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSubtitleData(int i, MediaItem mediaItem, SessionPlayer.TrackInfo trackInfo, SubtitleData subtitleData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), mediaItem, trackInfo, subtitleData}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048597, this, i, trackInfo) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048598, this, i, trackInfo) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), list, trackInfo, trackInfo2, trackInfo3, trackInfo4}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onVideoSizeChanged(int i, VideoSize videoSize) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048600, this, i, videoSize) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i, SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048601, this, i, sessionCommand, bundle) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void setCustomLayout(int i, List<MediaSession.CommandButton> list) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048602, this, i, list) == null) {
            }
        }

        public ControllerLegacyCb(MediaSessionLegacyStub mediaSessionLegacyStub, MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSessionLegacyStub, remoteUserInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaSessionLegacyStub;
            this.mRemoteUserInfo = remoteUserInfo;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && obj.getClass() == ControllerLegacyCb.class) {
                    return ObjectsCompat.equals(this.mRemoteUserInfo, ((ControllerLegacyCb) obj).mRemoteUserInfo);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackCompleted(int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return ObjectsCompat.hash(this.mRemoteUserInfo);
            }
            return invokeV.intValue;
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onBufferingStateChanged(int i, MediaItem mediaItem, int i2, long j, long j2, long j3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), mediaItem, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onCurrentMediaItemChanged(int i, MediaItem mediaItem, int i2, int i3, int i4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), mediaItem, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackInfoChanged(int i, MediaController.PlaybackInfo playbackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048585, this, i, playbackInfo) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048590, this, i, mediaMetadata) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f)}) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistChanged(int i, List<MediaItem> list, MediaMetadata mediaMetadata, int i2, int i3, int i4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), list, mediaMetadata, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }
    }

    /* loaded from: classes.dex */
    public final class ControllerLegacyCbForBroadcast extends MediaSession.ControllerCb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaSessionLegacyStub this$0;

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), libraryParams}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onDisconnected(int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onLibraryResult(int i, LibraryResult libraryResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048581, this, i, libraryResult) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackInfoChanged(int i, MediaController.PlaybackInfo playbackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048583, this, i, playbackInfo) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerResult(int i, SessionPlayer.PlayerResult playerResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048585, this, i, playerResult) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), libraryParams}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSessionResult(int i, SessionResult sessionResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048592, this, i, sessionResult) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSubtitleData(int i, MediaItem mediaItem, SessionPlayer.TrackInfo trackInfo, SubtitleData subtitleData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), mediaItem, trackInfo, subtitleData}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048595, this, i, trackInfo) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048596, this, i, trackInfo) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), list, trackInfo, trackInfo2, trackInfo3, trackInfo4}) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onVideoSizeChanged(int i, VideoSize videoSize) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048598, this, i, videoSize) == null) {
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i, SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048599, this, i, sessionCommand, bundle) == null) {
            }
        }

        public ControllerLegacyCbForBroadcast(MediaSessionLegacyStub mediaSessionLegacyStub) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSessionLegacyStub};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaSessionLegacyStub;
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onAllowedCommandsChanged(int i, SessionCommandGroup sessionCommandGroup) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, sessionCommandGroup) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void setCustomLayout(int i, List<MediaSession.CommandButton> list) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048600, this, i, list) == null) {
                throw new AssertionError("This shouldn't be called");
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onBufferingStateChanged(int i, MediaItem mediaItem, int i2, long j, long j2, long j3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), mediaItem, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.this$0.mSessionImpl.getSessionCompat().setPlaybackState(this.this$0.mSessionImpl.createPlaybackStateCompat());
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onCurrentMediaItemChanged(int i, MediaItem mediaItem, int i2, int i3, int i4) throws RemoteException {
            MediaMetadataCompat convertToMediaMetadataCompat;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), mediaItem, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                MediaSessionCompat sessionCompat = this.this$0.mSessionImpl.getSessionCompat();
                if (mediaItem == null) {
                    convertToMediaMetadataCompat = null;
                } else {
                    convertToMediaMetadataCompat = MediaUtils.convertToMediaMetadataCompat(mediaItem.getMetadata());
                }
                sessionCompat.setMetadata(convertToMediaMetadataCompat);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.this$0.mSessionImpl.getSessionCompat().setRepeatMode(i2);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.this$0.mSessionImpl.getSessionCompat().setShuffleMode(i2);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackCompleted(int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                PlaybackStateCompat createPlaybackStateCompat = this.this$0.mSessionImpl.createPlaybackStateCompat();
                if (createPlaybackStateCompat.getState() != 2) {
                    createPlaybackStateCompat = new PlaybackStateCompat.Builder(createPlaybackStateCompat).setState(2, createPlaybackStateCompat.getPosition(), createPlaybackStateCompat.getPlaybackSpeed()).build();
                }
                this.this$0.mSessionImpl.getSessionCompat().setPlaybackState(createPlaybackStateCompat);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f)}) == null) {
                this.this$0.mSessionImpl.getSessionCompat().setPlaybackState(this.this$0.mSessionImpl.createPlaybackStateCompat());
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                this.this$0.mSessionImpl.getSessionCompat().setPlaybackState(this.this$0.mSessionImpl.createPlaybackStateCompat());
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.this$0.mSessionImpl.getSessionCompat().setPlaybackState(this.this$0.mSessionImpl.createPlaybackStateCompat());
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistChanged(int i, List<MediaItem> list, MediaMetadata mediaMetadata, int i2, int i3, int i4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), list, mediaMetadata, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                if (Build.VERSION.SDK_INT < 21) {
                    if (list == null) {
                        this.this$0.mSessionImpl.getSessionCompat().setQueue(null);
                    } else {
                        List truncateListBySize = MediaUtils.truncateListBySize(MediaUtils.convertToQueueItemList(list), 262144);
                        if (truncateListBySize.size() != list.size()) {
                            Log.i(MediaSessionLegacyStub.TAG, "Sending " + truncateListBySize.size() + " items out of " + list.size());
                        }
                        this.this$0.mSessionImpl.getSessionCompat().setQueue(truncateListBySize);
                    }
                } else {
                    this.this$0.mSessionImpl.getSessionCompat().setQueue(MediaUtils.convertToQueueItemList(list));
                }
                onPlaylistMetadataChanged(i, mediaMetadata);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
            CharSequence charSequence;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048588, this, i, mediaMetadata) == null) {
                CharSequence queueTitle = this.this$0.mSessionImpl.getSessionCompat().getController().getQueueTitle();
                if (mediaMetadata != null) {
                    charSequence = mediaMetadata.getText("android.media.metadata.DISPLAY_TITLE");
                    if (charSequence == null) {
                        charSequence = mediaMetadata.getText("android.media.metadata.TITLE");
                    }
                } else {
                    charSequence = null;
                }
                if (!TextUtils.equals(queueTitle, charSequence)) {
                    this.this$0.mSessionImpl.getSessionCompat().setQueueTitle(charSequence);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1233723694, "Landroidx/media2/session/MediaSessionLegacyStub;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1233723694, "Landroidx/media2/session/MediaSessionLegacyStub;");
                return;
            }
        }
        DEBUG = Log.isLoggable(TAG, 3);
        sCommandsForOnCommandRequest = new SparseArray<>();
        for (SessionCommand sessionCommand : new SessionCommandGroup.Builder().addAllPlayerCommands(2).addAllVolumeCommands(2).build().getCommands()) {
            sCommandsForOnCommandRequest.append(sessionCommand.getCommandCode(), sessionCommand);
        }
    }

    public MediaSessionLegacyStub(MediaSession.MediaSessionImpl mediaSessionImpl, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSessionImpl, handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSessionImpl = mediaSessionImpl;
        Context context = mediaSessionImpl.getContext();
        this.mContext = context;
        this.mSessionManager = androidx.media.MediaSessionManager.getSessionManager(context);
        this.mControllerLegacyCbForBroadcast = new ControllerLegacyCbForBroadcast(this);
        this.mConnectionTimeoutHandler = new ConnectionTimeoutHandler(this, handler.getLooper());
        this.mConnectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
        this.mConnectionTimeoutMs = 300000L;
    }

    private void dispatchSessionTask(int i, SessionTask sessionTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i, sessionTask) == null) {
            dispatchSessionTaskInternal(null, i, sessionTask);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048580, this, mediaDescriptionCompat, i) != null) || mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTask(10013, new SessionTask(this, mediaDescriptionCompat, i) { // from class: androidx.media2.session.MediaSessionLegacyStub.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionLegacyStub this$0;
            public final /* synthetic */ MediaDescriptionCompat val$description;
            public final /* synthetic */ int val$index;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, mediaDescriptionCompat, Integer.valueOf(i)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$description = mediaDescriptionCompat;
                this.val$index = i;
            }

            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                    String mediaId = this.val$description.getMediaId();
                    if (TextUtils.isEmpty(mediaId)) {
                        Log.w(MediaSessionLegacyStub.TAG, "onAddQueueItem(): Media ID shouldn't be empty");
                        return;
                    }
                    this.this$0.mSessionImpl.addPlaylistItem(this.val$index, this.this$0.mSessionImpl.getCallback().onCreateMediaItem(this.this$0.mSessionImpl.getInstance(), controllerInfo, mediaId));
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromUri(Uri uri, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, uri, bundle) == null) {
            dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, new SessionTask(this, uri, bundle) { // from class: androidx.media2.session.MediaSessionLegacyStub.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;
                public final /* synthetic */ Bundle val$extras;
                public final /* synthetic */ Uri val$mediaUri;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, uri, bundle};
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
                    this.val$mediaUri = uri;
                    this.val$extras = bundle;
                }

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) && this.this$0.mSessionImpl.getCallback().onSetMediaUri(this.this$0.mSessionImpl.getInstance(), controllerInfo, this.val$mediaUri, this.val$extras) == 0) {
                        this.this$0.mSessionImpl.play();
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromUri(Uri uri, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, uri, bundle) == null) {
            dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, new SessionTask(this, uri, bundle) { // from class: androidx.media2.session.MediaSessionLegacyStub.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;
                public final /* synthetic */ Bundle val$extras;
                public final /* synthetic */ Uri val$mediaUri;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, uri, bundle};
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
                    this.val$mediaUri = uri;
                    this.val$extras = bundle;
                }

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) && this.this$0.mSessionImpl.getCallback().onSetMediaUri(this.this$0.mSessionImpl.getInstance(), controllerInfo, this.val$mediaUri, this.val$extras) == 0) {
                        this.this$0.mSessionImpl.prepare();
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, ratingCompat, bundle) != null) || ratingCompat == null) {
            return;
        }
        dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new SessionTask(this, ratingCompat) { // from class: androidx.media2.session.MediaSessionLegacyStub.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionLegacyStub this$0;
            public final /* synthetic */ RatingCompat val$rating;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, ratingCompat};
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
                this.val$rating = ratingCompat;
            }

            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                MediaItem currentMediaItem;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, controllerInfo) != null) || (currentMediaItem = this.this$0.mSessionImpl.getCurrentMediaItem()) == null) {
                    return;
                }
                this.this$0.mSessionImpl.getCallback().onSetRating(this.this$0.mSessionImpl.getInstance(), controllerInfo, currentMediaItem.getMediaId(), MediaUtils.convertToRating(this.val$rating));
            }
        });
    }

    private void dispatchSessionTask(SessionCommand sessionCommand, SessionTask sessionTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, sessionCommand, sessionTask) == null) {
            dispatchSessionTaskInternal(sessionCommand, 0, sessionTask);
        }
    }

    private void dispatchSessionTaskInternal(SessionCommand sessionCommand, int i, SessionTask sessionTask) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, this, sessionCommand, i, sessionTask) != null) || this.mSessionImpl.isClosed()) {
            return;
        }
        MediaSessionManager.RemoteUserInfo currentControllerInfo = this.mSessionImpl.getSessionCompat().getCurrentControllerInfo();
        if (currentControllerInfo == null) {
            Log.d(TAG, "RemoteUserInfo is null, ignoring command=" + sessionCommand + ", commandCode=" + i);
            return;
        }
        this.mSessionImpl.getCallbackExecutor().execute(new Runnable(this, currentControllerInfo, sessionCommand, i, sessionTask) { // from class: androidx.media2.session.MediaSessionLegacyStub.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionLegacyStub this$0;
            public final /* synthetic */ int val$commandCode;
            public final /* synthetic */ MediaSessionManager.RemoteUserInfo val$remoteUserInfo;
            public final /* synthetic */ SessionCommand val$sessionCommand;
            public final /* synthetic */ SessionTask val$task;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, currentControllerInfo, sessionCommand, Integer.valueOf(i), sessionTask};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$remoteUserInfo = currentControllerInfo;
                this.val$sessionCommand = sessionCommand;
                this.val$commandCode = i;
                this.val$task = sessionTask;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mSessionImpl.isClosed()) {
                    return;
                }
                MediaSession.ControllerInfo controller = this.this$0.mConnectedControllersManager.getController(this.val$remoteUserInfo);
                if (controller == null) {
                    MediaSessionManager.RemoteUserInfo remoteUserInfo = this.val$remoteUserInfo;
                    controller = new MediaSession.ControllerInfo(remoteUserInfo, -1, this.this$0.mSessionManager.isTrustedForMediaControl(remoteUserInfo), new ControllerLegacyCb(this.this$0, this.val$remoteUserInfo), null);
                    SessionCommandGroup onConnect = this.this$0.mSessionImpl.getCallback().onConnect(this.this$0.mSessionImpl.getInstance(), controller);
                    if (onConnect == null) {
                        try {
                            controller.getControllerCb().onDisconnected(0);
                            return;
                        } catch (RemoteException unused) {
                            return;
                        }
                    }
                    this.this$0.mConnectedControllersManager.addController(controller.getRemoteUserInfo(), controller, onConnect);
                }
                MediaSessionLegacyStub mediaSessionLegacyStub = this.this$0;
                mediaSessionLegacyStub.mConnectionTimeoutHandler.disconnectControllerAfterTimeout(controller, mediaSessionLegacyStub.mConnectionTimeoutMs);
                this.this$0.handleTaskOnExecutor(controller, this.val$sessionCommand, this.val$commandCode, this.val$task);
            }
        });
    }

    public ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> getConnectedControllersManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mConnectedControllersManager;
        }
        return (ConnectedControllersManager) invokeV.objValue;
    }

    public MediaSession.ControllerCb getControllerLegacyCbForBroadcast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mControllerLegacyCbForBroadcast;
        }
        return (MediaSession.ControllerCb) invokeV.objValue;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onFastForward() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, new SessionTask(this) { // from class: androidx.media2.session.MediaSessionLegacyStub.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;

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

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.mSessionImpl.getCallback().onFastForward(this.this$0.mSessionImpl.getInstance(), controllerInfo);
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            dispatchSessionTask(10001, new SessionTask(this) { // from class: androidx.media2.session.MediaSessionLegacyStub.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;

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

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.mSessionImpl.pause();
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            dispatchSessionTask(10000, new SessionTask(this) { // from class: androidx.media2.session.MediaSessionLegacyStub.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;

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

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.mSessionImpl.play();
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            dispatchSessionTask(10002, new SessionTask(this) { // from class: androidx.media2.session.MediaSessionLegacyStub.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;

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

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.mSessionImpl.prepare();
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRewind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            dispatchSessionTask(SessionCommand.COMMAND_CODE_SESSION_REWIND, new SessionTask(this) { // from class: androidx.media2.session.MediaSessionLegacyStub.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;

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

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.mSessionImpl.getCallback().onRewind(this.this$0.mSessionImpl.getInstance(), controllerInfo);
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            dispatchSessionTask(10009, new SessionTask(this) { // from class: androidx.media2.session.MediaSessionLegacyStub.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;

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

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.mSessionImpl.skipToNextItem();
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToPrevious() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            dispatchSessionTask(10008, new SessionTask(this) { // from class: androidx.media2.session.MediaSessionLegacyStub.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;

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

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.mSessionImpl.skipToPreviousItem();
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            dispatchSessionTask(10001, new SessionTask(this) { // from class: androidx.media2.session.MediaSessionLegacyStub.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;

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

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.handleTaskOnExecutor(controllerInfo, null, 10003, new SessionTask(this) { // from class: androidx.media2.session.MediaSessionLegacyStub.7.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass7 this$1;

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

                            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                            public void run(MediaSession.ControllerInfo controllerInfo2) throws RemoteException {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, controllerInfo2) == null) {
                                    this.this$1.this$0.mSessionImpl.pause();
                                    this.this$1.this$0.mSessionImpl.seekTo(0L);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void handleTaskOnExecutor(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand, int i, SessionTask sessionTask) {
        SessionCommand sessionCommand2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, controllerInfo, sessionCommand, i, sessionTask) == null) {
            if (sessionCommand != null) {
                if (!this.mConnectedControllersManager.isAllowedCommand(controllerInfo, sessionCommand)) {
                    return;
                }
                sessionCommand2 = sCommandsForOnCommandRequest.get(sessionCommand.getCommandCode());
            } else if (!this.mConnectedControllersManager.isAllowedCommand(controllerInfo, i)) {
                return;
            } else {
                sessionCommand2 = sCommandsForOnCommandRequest.get(i);
            }
            if (sessionCommand2 != null && this.mSessionImpl.getCallback().onCommandRequest(this.mSessionImpl.getInstance(), controllerInfo, sessionCommand2) != 0) {
                if (DEBUG) {
                    Log.d(TAG, "Command (" + sessionCommand2 + ") from " + controllerInfo + " was rejected by " + this.mSessionImpl);
                    return;
                }
                return;
            }
            try {
                sessionTask.run(controllerInfo);
            } catch (RemoteException e) {
                Log.w(TAG, "Exception in " + controllerInfo, e);
            }
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mediaDescriptionCompat) == null) {
            onAddQueueItem(mediaDescriptionCompat, Integer.MAX_VALUE);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, mediaDescriptionCompat) != null) || mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTask(10014, new SessionTask(this, mediaDescriptionCompat) { // from class: androidx.media2.session.MediaSessionLegacyStub.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionLegacyStub this$0;
            public final /* synthetic */ MediaDescriptionCompat val$description;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, mediaDescriptionCompat};
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
                this.val$description = mediaDescriptionCompat;
            }

            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                    String mediaId = this.val$description.getMediaId();
                    if (TextUtils.isEmpty(mediaId)) {
                        Log.w(MediaSessionLegacyStub.TAG, "onRemoveQueueItem(): Media ID shouldn't be null");
                        return;
                    }
                    List playlist = this.this$0.mSessionImpl.getPlaylist();
                    for (int i = 0; i < playlist.size(); i++) {
                        if (TextUtils.equals(((MediaItem) playlist.get(i)).getMediaId(), mediaId)) {
                            this.this$0.mSessionImpl.removePlaylistItem(i);
                            return;
                        }
                    }
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItemAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            dispatchSessionTask(10014, new SessionTask(this, i) { // from class: androidx.media2.session.MediaSessionLegacyStub.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;
                public final /* synthetic */ int val$index;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$index = i;
                }

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        int i2 = this.val$index;
                        if (i2 < 0) {
                            Log.w(MediaSessionLegacyStub.TAG, "onRemoveQueueItem(): index shouldn't be negative");
                        } else {
                            this.this$0.mSessionImpl.removePlaylistItem(i2);
                        }
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSeekTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            dispatchSessionTask(10003, new SessionTask(this, j) { // from class: androidx.media2.session.MediaSessionLegacyStub.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;
                public final /* synthetic */ long val$pos;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j)};
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
                    this.val$pos = j;
                }

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.mSessionImpl.seekTo(this.val$pos);
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetPlaybackSpeed(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f) == null) {
            dispatchSessionTask(10004, new SessionTask(this, f) { // from class: androidx.media2.session.MediaSessionLegacyStub.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;
                public final /* synthetic */ float val$speed;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Float.valueOf(f)};
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
                    this.val$speed = f;
                }

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.mSessionImpl.setPlaybackSpeed(this.val$speed);
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, ratingCompat) == null) {
            onSetRating(ratingCompat, null);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRepeatMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            dispatchSessionTask(10011, new SessionTask(this, i) { // from class: androidx.media2.session.MediaSessionLegacyStub.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;
                public final /* synthetic */ int val$repeatMode;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$repeatMode = i;
                }

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.mSessionImpl.setRepeatMode(this.val$repeatMode);
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetShuffleMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            dispatchSessionTask(10010, new SessionTask(this, i) { // from class: androidx.media2.session.MediaSessionLegacyStub.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;
                public final /* synthetic */ int val$shuffleMode;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$shuffleMode = i;
                }

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                        this.this$0.mSessionImpl.setShuffleMode(this.val$shuffleMode);
                    }
                }
            });
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToQueueItem(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j) == null) {
            dispatchSessionTask(10007, new SessionTask(this, j) { // from class: androidx.media2.session.MediaSessionLegacyStub.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionLegacyStub this$0;
                public final /* synthetic */ long val$queueId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j)};
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
                    this.val$queueId = j;
                }

                @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
                public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeL(1048576, this, controllerInfo) != null) || this.this$0.mSessionImpl.getPlayer().getPlaylist() == null) {
                        return;
                    }
                    this.this$0.mSessionImpl.skipToPlaylistItem((int) this.val$queueId);
                }
            });
        }
    }

    public void setLegacyControllerDisconnectTimeoutMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j) == null) {
            this.mConnectionTimeoutMs = j;
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048581, this, str, bundle, resultReceiver) != null) || str == null) {
            return;
        }
        SessionCommand sessionCommand = new SessionCommand(str, null);
        dispatchSessionTask(sessionCommand, new SessionTask(this, sessionCommand, bundle, resultReceiver) { // from class: androidx.media2.session.MediaSessionLegacyStub.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionLegacyStub this$0;
            public final /* synthetic */ Bundle val$args;
            public final /* synthetic */ ResultReceiver val$cb;
            public final /* synthetic */ SessionCommand val$command;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, sessionCommand, bundle, resultReceiver};
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
                this.val$command = sessionCommand;
                this.val$args = bundle;
                this.val$cb = resultReceiver;
            }

            @Override // androidx.media2.session.MediaSessionLegacyStub.SessionTask
            public void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerInfo) == null) {
                    SessionResult onCustomCommand = this.this$0.mSessionImpl.getCallback().onCustomCommand(this.this$0.mSessionImpl.getInstance(), controllerInfo, this.val$command, this.val$args);
                    ResultReceiver resultReceiver2 = this.val$cb;
                    if (resultReceiver2 != null) {
                        resultReceiver2.send(onCustomCommand.getResultCode(), onCustomCommand.getCustomCommandResult());
                    }
                }
            }
        });
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromMediaId(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, bundle) == null) {
            onPlayFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PLAY_FROM_MEDIA_ID).appendQueryParameter("id", str).build(), bundle);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromSearch(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, bundle) == null) {
            onPlayFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PLAY_FROM_SEARCH).appendQueryParameter("query", str).build(), bundle);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromMediaId(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, bundle) == null) {
            onPrepareFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PREPARE_FROM_MEDIA_ID).appendQueryParameter("id", str).build(), bundle);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromSearch(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, bundle) == null) {
            onPrepareFromUri(new Uri.Builder().scheme(MediaConstants.MEDIA_URI_SCHEME).authority(MediaConstants.MEDIA_URI_AUTHORITY).path(MediaConstants.MEDIA_URI_PATH_PREPARE_FROM_SEARCH).appendQueryParameter("query", str).build(), bundle);
        }
    }
}

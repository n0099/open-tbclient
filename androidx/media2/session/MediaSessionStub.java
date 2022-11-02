package androidx.media2.session;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.IMediaSession;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SessionCommandGroup;
import androidx.versionedparcelable.ParcelImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class MediaSessionStub extends IMediaSession.Stub {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final boolean RETHROW_EXCEPTION = true;
    public static final String TAG = "MediaSessionStub";
    public static final SparseArray<SessionCommand> sCommandsForOnCommandRequest;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConnectedControllersManager<IBinder> mConnectedControllersManager;
    public final Context mContext;
    public final Object mLock;
    public final MediaSession.MediaSessionImpl mSessionImpl;
    public final androidx.media.MediaSessionManager mSessionManager;

    /* loaded from: classes.dex */
    public interface LibrarySessionCallbackTask<T> extends SessionTask {
        T run(MediaSession.ControllerInfo controllerInfo) throws RemoteException;
    }

    /* loaded from: classes.dex */
    public interface SessionCallbackTask<T> extends SessionTask {
        T run(MediaSession.ControllerInfo controllerInfo) throws RemoteException;
    }

    /* loaded from: classes.dex */
    public interface SessionPlayerTask extends SessionTask {
        ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) throws RemoteException;
    }

    /* loaded from: classes.dex */
    public interface SessionTask {
    }

    /* loaded from: classes.dex */
    public final class Controller2Cb extends MediaSession.ControllerCb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final IMediaController mIControllerCallback;
        public final /* synthetic */ MediaSessionStub this$0;

        public Controller2Cb(@NonNull MediaSessionStub mediaSessionStub, IMediaController iMediaController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSessionStub, iMediaController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaSessionStub;
            this.mIControllerCallback = iMediaController;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && obj.getClass() == Controller2Cb.class) {
                    return ObjectsCompat.equals(getCallbackBinder(), ((Controller2Cb) obj).getCallbackBinder());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onDisconnected(int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.mIControllerCallback.onDisconnected(i);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackCompleted(int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
                this.mIControllerCallback.onPlaybackCompleted(i);
            }
        }

        @NonNull
        public IBinder getCallbackBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mIControllerCallback.asBinder();
            }
            return (IBinder) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return ObjectsCompat.hash(getCallbackBinder());
            }
            return invokeV.intValue;
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onAllowedCommandsChanged(int i, @NonNull SessionCommandGroup sessionCommandGroup) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, sessionCommandGroup) == null) {
                this.mIControllerCallback.onAllowedCommandsChanged(i, MediaParcelUtils.toParcelable(sessionCommandGroup));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onLibraryResult(int i, LibraryResult libraryResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, libraryResult) == null) {
                if (libraryResult == null) {
                    libraryResult = new LibraryResult(-1);
                }
                this.mIControllerCallback.onLibraryResult(i, MediaParcelUtils.toParcelable(libraryResult));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackInfoChanged(int i, @NonNull MediaController.PlaybackInfo playbackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048586, this, i, playbackInfo) == null) {
                this.mIControllerCallback.onPlaybackInfoChanged(i, MediaParcelUtils.toParcelable(playbackInfo));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerResult(int i, @Nullable SessionPlayer.PlayerResult playerResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048588, this, i, playerResult) == null) {
                onSessionResult(i, SessionResult.from(playerResult));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048591, this, i, mediaMetadata) == null) {
                if (this.this$0.mConnectedControllersManager.isAllowedCommand(this.this$0.mConnectedControllersManager.getController(getCallbackBinder()), 10012)) {
                    this.mIControllerCallback.onPlaylistMetadataChanged(i, MediaParcelUtils.toParcelable(mediaMetadata));
                }
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSessionResult(int i, @Nullable SessionResult sessionResult) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048595, this, i, sessionResult) == null) {
                if (sessionResult == null) {
                    sessionResult = new SessionResult(-1, null);
                }
                this.mIControllerCallback.onSessionResult(i, MediaParcelUtils.toParcelable(sessionResult));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048598, this, i, trackInfo) == null) {
                this.mIControllerCallback.onTrackDeselected(i, MediaParcelUtils.toParcelable(trackInfo));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048599, this, i, trackInfo) == null) {
                this.mIControllerCallback.onTrackSelected(i, MediaParcelUtils.toParcelable(trackInfo));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onVideoSizeChanged(int i, @NonNull VideoSize videoSize) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048601, this, i, videoSize) == null) {
                this.mIControllerCallback.onVideoSizeChanged(i, MediaParcelUtils.toParcelable(new MediaItem.Builder().build()), MediaParcelUtils.toParcelable(videoSize));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void setCustomLayout(int i, @NonNull List<MediaSession.CommandButton> list) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048603, this, i, list) == null) {
                this.mIControllerCallback.onSetCustomLayout(i, MediaUtils.convertCommandButtonListToParcelImplList(list));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onBufferingStateChanged(int i, @NonNull MediaItem mediaItem, int i2, long j, long j2, long j3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), mediaItem, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.mIControllerCallback.onBufferingStateChanged(i, MediaParcelUtils.toParcelable(mediaItem), i2, j, j2, j3);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), list, trackInfo, trackInfo2, trackInfo3, trackInfo4}) == null) {
                this.mIControllerCallback.onTrackInfoChanged(i, MediaParcelUtils.toParcelableList(list), MediaParcelUtils.toParcelable(trackInfo), MediaParcelUtils.toParcelable(trackInfo2), MediaParcelUtils.toParcelable(trackInfo3), MediaParcelUtils.toParcelable(trackInfo4));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), libraryParams}) == null) {
                this.mIControllerCallback.onChildrenChanged(i, str, i2, MediaParcelUtils.toParcelable(libraryParams));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f)}) == null) {
                this.mIControllerCallback.onPlaybackSpeedChanged(i, j, j2, f);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                this.mIControllerCallback.onPlayerStateChanged(i, j, j2, i2);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, @NonNull String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), libraryParams}) == null) {
                this.mIControllerCallback.onSearchResultChanged(i, str, i2, MediaParcelUtils.toParcelable(libraryParams));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                this.mIControllerCallback.onSeekCompleted(i, j, j2, j3);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onSubtitleData(int i, @NonNull MediaItem mediaItem, @NonNull SessionPlayer.TrackInfo trackInfo, @NonNull SubtitleData subtitleData) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), mediaItem, trackInfo, subtitleData}) == null) {
                this.mIControllerCallback.onSubtitleData(i, MediaParcelUtils.toParcelable(mediaItem), MediaParcelUtils.toParcelable(trackInfo), MediaParcelUtils.toParcelable(subtitleData));
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onCurrentMediaItemChanged(int i, MediaItem mediaItem, int i2, int i3, int i4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), mediaItem, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                this.mIControllerCallback.onCurrentMediaItemChanged(i, MediaParcelUtils.toParcelable(mediaItem), i2, i3, i4);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.mIControllerCallback.onRepeatModeChanged(i, i2, i3, i4, i5);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                this.mIControllerCallback.onShuffleModeChanged(i, i2, i3, i4, i5);
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void onPlaylistChanged(int i, @NonNull List<MediaItem> list, MediaMetadata mediaMetadata, int i2, int i3, int i4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), list, mediaMetadata, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                MediaSession.ControllerInfo controller = this.this$0.mConnectedControllersManager.getController(getCallbackBinder());
                if (this.this$0.mConnectedControllersManager.isAllowedCommand(controller, 10005)) {
                    this.mIControllerCallback.onPlaylistChanged(i, MediaUtils.convertMediaItemListToParcelImplListSlice(list), MediaParcelUtils.toParcelable(mediaMetadata), i2, i3, i4);
                } else if (this.this$0.mConnectedControllersManager.isAllowedCommand(controller, 10012)) {
                    this.mIControllerCallback.onPlaylistMetadataChanged(i, MediaParcelUtils.toParcelable(mediaMetadata));
                }
            }
        }

        @Override // androidx.media2.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i, @NonNull SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048602, this, i, sessionCommand, bundle) == null) {
                this.mIControllerCallback.onCustomCommand(i, MediaParcelUtils.toParcelable(sessionCommand), bundle);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1163365, "Landroidx/media2/session/MediaSessionStub;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1163365, "Landroidx/media2/session/MediaSessionStub;");
                return;
            }
        }
        DEBUG = Log.isLoggable(TAG, 3);
        sCommandsForOnCommandRequest = new SparseArray<>();
        for (SessionCommand sessionCommand : new SessionCommandGroup.Builder().addAllPlayerCommands(2).addAllVolumeCommands(2).build().getCommands()) {
            sCommandsForOnCommandRequest.append(sessionCommand.getCommandCode(), sessionCommand);
        }
    }

    public MediaSessionStub(MediaSession.MediaSessionImpl mediaSessionImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSessionImpl};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mSessionImpl = mediaSessionImpl;
        Context context = mediaSessionImpl.getContext();
        this.mContext = context;
        this.mSessionManager = androidx.media.MediaSessionManager.getSessionManager(context);
        this.mConnectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
    }

    private void dispatchLibrarySessionTask(@NonNull IMediaController iMediaController, int i, int i2, @NonNull LibrarySessionCallbackTask<?> librarySessionCallbackTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{iMediaController, Integer.valueOf(i), Integer.valueOf(i2), librarySessionCallbackTask}) == null) {
            if (this.mSessionImpl instanceof MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl) {
                dispatchSessionTaskInternal(iMediaController, i, null, i2, librarySessionCallbackTask);
                return;
            }
            throw new RuntimeException("MediaSession cannot handle MediaLibrarySession command");
        }
    }

    private void dispatchSessionTask(@NonNull IMediaController iMediaController, int i, int i2, @NonNull SessionTask sessionTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{iMediaController, Integer.valueOf(i), Integer.valueOf(i2), sessionTask}) == null) {
            dispatchSessionTaskInternal(iMediaController, i, null, i2, sessionTask);
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void addPlaylistItem(IMediaController iMediaController, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{iMediaController, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10013, new SessionPlayerTask(this, str, i2) { // from class: androidx.media2.session.MediaSessionStub.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ int val$index;
            public final /* synthetic */ String val$mediaId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, Integer.valueOf(i2)};
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
                this.val$mediaId = str;
                this.val$index = i2;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    if (TextUtils.isEmpty(this.val$mediaId)) {
                        Log.w(MediaSessionStub.TAG, "addPlaylistItem(): Ignoring empty mediaId from " + controllerInfo);
                        return SessionPlayer.PlayerResult.createFuture(-3);
                    }
                    MediaItem convertMediaItemOnExecutor = this.this$0.convertMediaItemOnExecutor(controllerInfo, this.val$mediaId);
                    if (convertMediaItemOnExecutor == null) {
                        return SessionPlayer.PlayerResult.createFuture(-3);
                    }
                    return this.this$0.mSessionImpl.addPlaylistItem(this.val$index, convertMediaItemOnExecutor);
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void replacePlaylistItem(IMediaController iMediaController, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048597, this, new Object[]{iMediaController, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10015, new SessionPlayerTask(this, str, i2) { // from class: androidx.media2.session.MediaSessionStub.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ int val$index;
            public final /* synthetic */ String val$mediaId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, Integer.valueOf(i2)};
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
                this.val$mediaId = str;
                this.val$index = i2;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    if (TextUtils.isEmpty(this.val$mediaId)) {
                        Log.w(MediaSessionStub.TAG, "replacePlaylistItem(): Ignoring empty mediaId from " + controllerInfo);
                        return SessionPlayer.PlayerResult.createFuture(-3);
                    }
                    MediaItem convertMediaItemOnExecutor = this.this$0.convertMediaItemOnExecutor(controllerInfo, this.val$mediaId);
                    if (convertMediaItemOnExecutor == null) {
                        return SessionPlayer.PlayerResult.createFuture(-3);
                    }
                    return this.this$0.mSessionImpl.replacePlaylistItem(this.val$index, convertMediaItemOnExecutor);
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    private void dispatchSessionTask(@NonNull IMediaController iMediaController, int i, @NonNull SessionCommand sessionCommand, @NonNull SessionTask sessionTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, this, iMediaController, i, sessionCommand, sessionTask) == null) {
            dispatchSessionTaskInternal(iMediaController, i, sessionCommand, 0, sessionTask);
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void adjustVolume(IMediaController iMediaController, int i, int i2, int i3) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iMediaController, i, i2, i3) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_VOLUME_ADJUST_VOLUME, new SessionCallbackTask<Integer>(this, i2, i3) { // from class: androidx.media2.session.MediaSessionStub.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ int val$direction;
            public final /* synthetic */ int val$flags;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$direction = i2;
                this.val$flags = i3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    MediaSessionCompat sessionCompat = this.this$0.mSessionImpl.getSessionCompat();
                    if (sessionCompat != null) {
                        sessionCompat.getController().adjustVolume(this.val$direction, this.val$flags);
                    }
                    return 0;
                }
                return (Integer) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void movePlaylistItem(IMediaController iMediaController, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(1048589, this, iMediaController, i, i2, i3) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_PLAYER_MOVE_PLAYLIST_ITEM, new SessionPlayerTask(this, i2, i3) { // from class: androidx.media2.session.MediaSessionStub.23
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ int val$fromIndex;
            public final /* synthetic */ int val$toIndex;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$fromIndex = i2;
                this.val$toIndex = i3;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.movePlaylistItem(this.val$fromIndex, this.val$toIndex);
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void onCustomCommand(IMediaController iMediaController, int i, ParcelImpl parcelImpl, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048591, this, iMediaController, i, parcelImpl, bundle) == null) && iMediaController != null && parcelImpl != null) {
            SessionCommand sessionCommand = (SessionCommand) MediaParcelUtils.fromParcelable(parcelImpl);
            dispatchSessionTask(iMediaController, i, sessionCommand, new SessionCallbackTask<SessionResult>(this, sessionCommand, bundle) { // from class: androidx.media2.session.MediaSessionStub.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ Bundle val$args;
                public final /* synthetic */ SessionCommand val$sessionCommand;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sessionCommand, bundle};
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
                    this.val$sessionCommand = sessionCommand;
                    this.val$args = bundle;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
                public SessionResult run(MediaSession.ControllerInfo controllerInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                        SessionResult onCustomCommand = this.this$0.mSessionImpl.getCallback().onCustomCommand(this.this$0.mSessionImpl.getInstance(), controllerInfo, this.val$sessionCommand, this.val$args);
                        if (onCustomCommand != null) {
                            return onCustomCommand;
                        }
                        throw new RuntimeException("SessionCallback#onCustomCommand has returned null, command=" + this.val$sessionCommand);
                    }
                    return (SessionResult) invokeL.objValue;
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void search(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048599, this, iMediaController, i, str, parcelImpl) == null) && iMediaController != null && parcelImpl != null) {
            dispatchLibrarySessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, new LibrarySessionCallbackTask<Integer>(this, str, parcelImpl) { // from class: androidx.media2.session.MediaSessionStub.35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ ParcelImpl val$libraryParams;
                public final /* synthetic */ String val$query;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, parcelImpl};
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
                    this.val$query = str;
                    this.val$libraryParams = parcelImpl;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
                public Integer run(MediaSession.ControllerInfo controllerInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                        if (TextUtils.isEmpty(this.val$query)) {
                            Log.w(MediaSessionStub.TAG, "search(): Ignoring empty query from " + controllerInfo);
                            return -3;
                        }
                        return Integer.valueOf(this.this$0.getLibrarySession().onSearchOnExecutor(controllerInfo, this.val$query, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(this.val$libraryParams)));
                    }
                    return (Integer) invokeL.objValue;
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void setMediaUri(IMediaController iMediaController, int i, Uri uri, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(1048603, this, iMediaController, i, uri, bundle) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, new SessionCallbackTask<Integer>(this, uri, bundle) { // from class: androidx.media2.session.MediaSessionStub.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ Bundle val$extras;
            public final /* synthetic */ Uri val$uri;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, uri, bundle};
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
                this.val$uri = uri;
                this.val$extras = bundle;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    if (this.val$uri == null) {
                        Log.w(MediaSessionStub.TAG, "setMediaUri(): Ignoring null uri from " + controllerInfo);
                        return -3;
                    }
                    return Integer.valueOf(this.this$0.mSessionImpl.getCallback().onSetMediaUri(this.this$0.mSessionImpl.getInstance(), controllerInfo, this.val$uri, this.val$extras));
                }
                return (Integer) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setPlaylist(IMediaController iMediaController, int i, List<String> list, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048605, this, iMediaController, i, list, parcelImpl) == null) && iMediaController != null && parcelImpl != null) {
            dispatchSessionTask(iMediaController, i, 10006, new SessionPlayerTask(this, list, parcelImpl) { // from class: androidx.media2.session.MediaSessionStub.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ ParcelImpl val$metadata;
                public final /* synthetic */ List val$playlist;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list, parcelImpl};
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
                    this.val$playlist = list;
                    this.val$metadata = parcelImpl;
                }

                @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                        if (this.val$playlist == null) {
                            Log.w(MediaSessionStub.TAG, "setPlaylist(): Ignoring null playlist from " + controllerInfo);
                            return SessionPlayer.PlayerResult.createFuture(-3);
                        }
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < this.val$playlist.size(); i2++) {
                            MediaItem convertMediaItemOnExecutor = this.this$0.convertMediaItemOnExecutor(controllerInfo, (String) this.val$playlist.get(i2));
                            if (convertMediaItemOnExecutor != null) {
                                arrayList.add(convertMediaItemOnExecutor);
                            }
                        }
                        return this.this$0.mSessionImpl.setPlaylist(arrayList, (MediaMetadata) MediaParcelUtils.fromParcelable(this.val$metadata));
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void setRating(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048606, this, iMediaController, i, str, parcelImpl) == null) && iMediaController != null && parcelImpl != null) {
            dispatchSessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new SessionCallbackTask<Integer>(this, str, (Rating) MediaParcelUtils.fromParcelable(parcelImpl)) { // from class: androidx.media2.session.MediaSessionStub.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ String val$mediaId;
                public final /* synthetic */ Rating val$rating;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, r8};
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
                    this.val$mediaId = str;
                    this.val$rating = r8;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
                public Integer run(MediaSession.ControllerInfo controllerInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                        if (TextUtils.isEmpty(this.val$mediaId)) {
                            Log.w(MediaSessionStub.TAG, "setRating(): Ignoring empty mediaId from " + controllerInfo);
                            return -3;
                        } else if (this.val$rating == null) {
                            Log.w(MediaSessionStub.TAG, "setRating(): Ignoring null rating from " + controllerInfo);
                            return -3;
                        } else {
                            return Integer.valueOf(this.this$0.mSessionImpl.getCallback().onSetRating(this.this$0.mSessionImpl.getInstance(), controllerInfo, this.val$mediaId, this.val$rating));
                        }
                    }
                    return (Integer) invokeL.objValue;
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void setVolumeTo(IMediaController iMediaController, int i, int i2, int i3) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(1048610, this, iMediaController, i, i2, i3) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 30000, new SessionCallbackTask<Integer>(this, i2, i3) { // from class: androidx.media2.session.MediaSessionStub.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ int val$flags;
            public final /* synthetic */ int val$value;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$value = i2;
                this.val$flags = i3;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    MediaSessionCompat sessionCompat = this.this$0.mSessionImpl.getSessionCompat();
                    if (sessionCompat != null) {
                        sessionCompat.getController().setVolumeTo(this.val$value, this.val$flags);
                    }
                    return 0;
                }
                return (Integer) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void subscribe(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(1048616, this, iMediaController, i, str, parcelImpl) == null) && iMediaController != null && parcelImpl != null) {
            dispatchLibrarySessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE, new LibrarySessionCallbackTask<Integer>(this, str, parcelImpl) { // from class: androidx.media2.session.MediaSessionStub.37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ ParcelImpl val$libraryParams;
                public final /* synthetic */ String val$parentId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, parcelImpl};
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
                    this.val$parentId = str;
                    this.val$libraryParams = parcelImpl;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
                public Integer run(MediaSession.ControllerInfo controllerInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                        if (TextUtils.isEmpty(this.val$parentId)) {
                            Log.w(MediaSessionStub.TAG, "subscribe(): Ignoring empty parentId from " + controllerInfo);
                            return -3;
                        }
                        return Integer.valueOf(this.this$0.getLibrarySession().onSubscribeOnExecutor(controllerInfo, this.val$parentId, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(this.val$libraryParams)));
                    }
                    return (Integer) invokeL.objValue;
                }
            });
        }
    }

    private void dispatchSessionTaskInternal(@NonNull IMediaController iMediaController, int i, @Nullable SessionCommand sessionCommand, int i2, @NonNull SessionTask sessionTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{iMediaController, Integer.valueOf(i), sessionCommand, Integer.valueOf(i2), sessionTask}) == null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                MediaSession.ControllerInfo controller = this.mConnectedControllersManager.getController(iMediaController.asBinder());
                if (!this.mSessionImpl.isClosed() && controller != null) {
                    this.mSessionImpl.getCallbackExecutor().execute(new Runnable(this, controller, sessionCommand, i, i2, sessionTask) { // from class: androidx.media2.session.MediaSessionStub.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaSessionStub this$0;
                        public final /* synthetic */ int val$commandCode;
                        public final /* synthetic */ MediaSession.ControllerInfo val$controller;
                        public final /* synthetic */ int val$seq;
                        public final /* synthetic */ SessionCommand val$sessionCommand;
                        public final /* synthetic */ SessionTask val$task;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, controller, sessionCommand, Integer.valueOf(i), Integer.valueOf(i2), sessionTask};
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
                            this.val$controller = controller;
                            this.val$sessionCommand = sessionCommand;
                            this.val$seq = i;
                            this.val$commandCode = i2;
                            this.val$task = sessionTask;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            SessionCommand sessionCommand2;
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || !this.this$0.mConnectedControllersManager.isConnected(this.val$controller)) {
                                return;
                            }
                            SessionCommand sessionCommand3 = this.val$sessionCommand;
                            if (sessionCommand3 != null) {
                                if (!this.this$0.mConnectedControllersManager.isAllowedCommand(this.val$controller, sessionCommand3)) {
                                    if (MediaSessionStub.DEBUG) {
                                        Log.d(MediaSessionStub.TAG, "Command (" + this.val$sessionCommand + ") from " + this.val$controller + " isn't allowed.");
                                    }
                                    MediaSessionStub.sendSessionResult(this.val$controller, this.val$seq, -4);
                                    return;
                                }
                                sessionCommand2 = MediaSessionStub.sCommandsForOnCommandRequest.get(this.val$sessionCommand.getCommandCode());
                            } else if (!this.this$0.mConnectedControllersManager.isAllowedCommand(this.val$controller, this.val$commandCode)) {
                                if (MediaSessionStub.DEBUG) {
                                    Log.d(MediaSessionStub.TAG, "Command (" + this.val$commandCode + ") from " + this.val$controller + " isn't allowed.");
                                }
                                MediaSessionStub.sendSessionResult(this.val$controller, this.val$seq, -4);
                                return;
                            } else {
                                sessionCommand2 = MediaSessionStub.sCommandsForOnCommandRequest.get(this.val$commandCode);
                            }
                            if (sessionCommand2 != null) {
                                try {
                                    int onCommandRequest = this.this$0.mSessionImpl.getCallback().onCommandRequest(this.this$0.mSessionImpl.getInstance(), this.val$controller, sessionCommand2);
                                    if (onCommandRequest != 0) {
                                        if (MediaSessionStub.DEBUG) {
                                            Log.d(MediaSessionStub.TAG, "Command (" + sessionCommand2 + ") from " + this.val$controller + " was rejected by " + this.this$0.mSessionImpl + ", code=" + onCommandRequest);
                                        }
                                        MediaSessionStub.sendSessionResult(this.val$controller, this.val$seq, onCommandRequest);
                                        return;
                                    }
                                } catch (RemoteException e) {
                                    Log.w(MediaSessionStub.TAG, "Exception in " + this.val$controller.toString(), e);
                                    return;
                                } catch (Exception e2) {
                                    throw e2;
                                }
                            }
                            if (this.val$task instanceof SessionPlayerTask) {
                                ListenableFuture<SessionPlayer.PlayerResult> run = ((SessionPlayerTask) this.val$task).run(this.val$controller);
                                if (run != null) {
                                    run.addListener(new Runnable(this, run) { // from class: androidx.media2.session.MediaSessionStub.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass1 this$1;
                                        public final /* synthetic */ ListenableFuture val$future;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, run};
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
                                            this.val$future = run;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                try {
                                                    MediaSessionStub.sendPlayerResult(this.this$1.val$controller, this.this$1.val$seq, (SessionPlayer.PlayerResult) this.val$future.get(0L, TimeUnit.MILLISECONDS));
                                                } catch (Exception e3) {
                                                    Log.w(MediaSessionStub.TAG, "Cannot obtain PlayerResult after the command is finished", e3);
                                                    AnonymousClass1 anonymousClass1 = this.this$1;
                                                    MediaSessionStub.sendSessionResult(anonymousClass1.val$controller, anonymousClass1.val$seq, -2);
                                                }
                                            }
                                        }
                                    }, MediaUtils.DIRECT_EXECUTOR);
                                    return;
                                }
                                throw new RuntimeException("SessionPlayer has returned null, commandCode=" + this.val$commandCode);
                            } else if (this.val$task instanceof SessionCallbackTask) {
                                Object run2 = ((SessionCallbackTask) this.val$task).run(this.val$controller);
                                if (run2 != null) {
                                    if (run2 instanceof Integer) {
                                        MediaSessionStub.sendSessionResult(this.val$controller, this.val$seq, ((Integer) run2).intValue());
                                        return;
                                    } else if (run2 instanceof SessionResult) {
                                        MediaSessionStub.sendSessionResult(this.val$controller, this.val$seq, (SessionResult) run2);
                                        return;
                                    } else if (MediaSessionStub.DEBUG) {
                                        throw new RuntimeException("Unexpected return type " + run2 + ". Fix bug");
                                    } else {
                                        return;
                                    }
                                }
                                throw new RuntimeException("SessionCallback has returned null, commandCode=" + this.val$commandCode);
                            } else if (this.val$task instanceof LibrarySessionCallbackTask) {
                                Object run3 = ((LibrarySessionCallbackTask) this.val$task).run(this.val$controller);
                                if (run3 != null) {
                                    if (run3 instanceof Integer) {
                                        MediaSessionStub.sendLibraryResult(this.val$controller, this.val$seq, ((Integer) run3).intValue());
                                        return;
                                    } else if (run3 instanceof LibraryResult) {
                                        MediaSessionStub.sendLibraryResult(this.val$controller, this.val$seq, (LibraryResult) run3);
                                        return;
                                    } else if (MediaSessionStub.DEBUG) {
                                        throw new RuntimeException("Unexpected return type " + run3 + ". Fix bug");
                                    } else {
                                        return;
                                    }
                                }
                                throw new RuntimeException("LibrarySessionCallback has returned null, commandCode=" + this.val$commandCode);
                            } else if (MediaSessionStub.DEBUG) {
                                throw new RuntimeException("Unknown task " + this.val$task + ". Fix bug");
                            }
                        }
                    });
                }
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public static void sendLibraryResult(@NonNull MediaSession.ControllerInfo controllerInfo, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65542, null, controllerInfo, i, i2) == null) {
            sendLibraryResult(controllerInfo, i, new LibraryResult(i2));
        }
    }

    public static void sendSessionResult(@NonNull MediaSession.ControllerInfo controllerInfo, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65545, null, controllerInfo, i, i2) == null) {
            sendSessionResult(controllerInfo, i, new SessionResult(i2));
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void deselectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048581, this, iMediaController, i, parcelImpl) == null) && iMediaController != null && parcelImpl != null) {
            dispatchSessionTask(iMediaController, i, 11002, new SessionPlayerTask(this, parcelImpl) { // from class: androidx.media2.session.MediaSessionStub.31
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ ParcelImpl val$trackInfoParcel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, parcelImpl};
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
                    this.val$trackInfoParcel = parcelImpl;
                }

                @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                        SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(this.val$trackInfoParcel);
                        if (trackInfo == null) {
                            return SessionPlayer.PlayerResult.createFuture(-3);
                        }
                        return this.this$0.mSessionImpl.deselectTrack(trackInfo);
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void getItem(IMediaController iMediaController, int i, String str) throws RuntimeException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, iMediaController, i, str) == null) {
            dispatchLibrarySessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, new LibrarySessionCallbackTask<LibraryResult>(this, str) { // from class: androidx.media2.session.MediaSessionStub.33
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ String val$mediaId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
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
                    this.val$mediaId = str;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
                public LibraryResult run(MediaSession.ControllerInfo controllerInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                        if (TextUtils.isEmpty(this.val$mediaId)) {
                            Log.w(MediaSessionStub.TAG, "getItem(): Ignoring empty mediaId from " + controllerInfo);
                            return new LibraryResult(-3);
                        }
                        return this.this$0.getLibrarySession().onGetItemOnExecutor(controllerInfo, this.val$mediaId);
                    }
                    return (LibraryResult) invokeL.objValue;
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void getLibraryRoot(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048586, this, iMediaController, i, parcelImpl) == null) && iMediaController != null && parcelImpl != null) {
            dispatchLibrarySessionTask(iMediaController, i, 50000, new LibrarySessionCallbackTask<LibraryResult>(this, parcelImpl) { // from class: androidx.media2.session.MediaSessionStub.32
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ ParcelImpl val$libraryParams;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, parcelImpl};
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
                    this.val$libraryParams = parcelImpl;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
                public LibraryResult run(MediaSession.ControllerInfo controllerInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                        return this.this$0.getLibrarySession().onGetLibraryRootOnExecutor(controllerInfo, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(this.val$libraryParams));
                    }
                    return (LibraryResult) invokeL.objValue;
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void removePlaylistItem(IMediaController iMediaController, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048596, this, iMediaController, i, i2) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10014, new SessionPlayerTask(this, i2) { // from class: androidx.media2.session.MediaSessionStub.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ int val$index;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2)};
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
                this.val$index = i2;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.removePlaylistItem(this.val$index);
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void selectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048601, this, iMediaController, i, parcelImpl) == null) && iMediaController != null && parcelImpl != null) {
            dispatchSessionTask(iMediaController, i, 11001, new SessionPlayerTask(this, parcelImpl) { // from class: androidx.media2.session.MediaSessionStub.30
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ ParcelImpl val$trackInfoParcel;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, parcelImpl};
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
                    this.val$trackInfoParcel = parcelImpl;
                }

                @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                        SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(this.val$trackInfoParcel);
                        if (trackInfo == null) {
                            return SessionPlayer.PlayerResult.createFuture(-3);
                        }
                        return this.this$0.mSessionImpl.selectTrack(trackInfo);
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void setMediaItem(IMediaController iMediaController, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048602, this, iMediaController, i, str) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_PLAYER_SET_MEDIA_ITEM, new SessionPlayerTask(this, str) { // from class: androidx.media2.session.MediaSessionStub.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ String val$mediaId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str};
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
                this.val$mediaId = str;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    if (TextUtils.isEmpty(this.val$mediaId)) {
                        Log.w(MediaSessionStub.TAG, "setMediaItem(): Ignoring empty mediaId from " + controllerInfo);
                        return SessionPlayer.PlayerResult.createFuture(-3);
                    }
                    MediaItem convertMediaItemOnExecutor = this.this$0.convertMediaItemOnExecutor(controllerInfo, this.val$mediaId);
                    if (convertMediaItemOnExecutor == null) {
                        return SessionPlayer.PlayerResult.createFuture(-3);
                    }
                    return this.this$0.mSessionImpl.setMediaItem(convertMediaItemOnExecutor);
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setRepeatMode(IMediaController iMediaController, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048607, this, iMediaController, i, i2) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10011, new SessionPlayerTask(this, i2) { // from class: androidx.media2.session.MediaSessionStub.27
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ int val$repeatMode;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2)};
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
                this.val$repeatMode = i2;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.setRepeatMode(this.val$repeatMode);
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setShuffleMode(IMediaController iMediaController, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048608, this, iMediaController, i, i2) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10010, new SessionPlayerTask(this, i2) { // from class: androidx.media2.session.MediaSessionStub.28
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ int val$shuffleMode;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2)};
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
                this.val$shuffleMode = i2;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.setShuffleMode(this.val$shuffleMode);
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setSurface(IMediaController iMediaController, int i, Surface surface) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048609, this, iMediaController, i, surface) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 11000, new SessionPlayerTask(this, surface) { // from class: androidx.media2.session.MediaSessionStub.29
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ Surface val$surface;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, surface};
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
                this.val$surface = surface;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.setSurface(this.val$surface);
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void skipToPlaylistItem(IMediaController iMediaController, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048614, this, iMediaController, i, i2) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10007, new SessionPlayerTask(this, i2) { // from class: androidx.media2.session.MediaSessionStub.24
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ int val$index;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2)};
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
                this.val$index = i2;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    int i3 = this.val$index;
                    if (i3 < 0) {
                        Log.w(MediaSessionStub.TAG, "skipToPlaylistItem(): Ignoring negative index from " + controllerInfo);
                        return SessionPlayer.PlayerResult.createFuture(-3);
                    }
                    return this.this$0.mSessionImpl.skipToPlaylistItem(i3);
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void unsubscribe(IMediaController iMediaController, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048617, this, iMediaController, i, str) != null) || iMediaController == null) {
            return;
        }
        dispatchLibrarySessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE, new LibrarySessionCallbackTask<Integer>(this, str) { // from class: androidx.media2.session.MediaSessionStub.38
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ String val$parentId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str};
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
                this.val$parentId = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    if (TextUtils.isEmpty(this.val$parentId)) {
                        Log.w(MediaSessionStub.TAG, "unsubscribe(): Ignoring empty parentId from " + controllerInfo);
                        return -3;
                    }
                    return Integer.valueOf(this.this$0.getLibrarySession().onUnsubscribeOnExecutor(controllerInfo, this.val$parentId));
                }
                return (Integer) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void updatePlaylistMetadata(IMediaController iMediaController, int i, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048618, this, iMediaController, i, parcelImpl) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA, new SessionPlayerTask(this, parcelImpl) { // from class: androidx.media2.session.MediaSessionStub.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ ParcelImpl val$metadata;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, parcelImpl};
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
                this.val$metadata = parcelImpl;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.updatePlaylistMetadata((MediaMetadata) MediaParcelUtils.fromParcelable(this.val$metadata));
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    public static void sendLibraryResult(@NonNull MediaSession.ControllerInfo controllerInfo, int i, @NonNull LibraryResult libraryResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65543, null, controllerInfo, i, libraryResult) == null) {
            try {
                controllerInfo.getControllerCb().onLibraryResult(i, libraryResult);
            } catch (RemoteException e) {
                Log.w(TAG, "Exception in " + controllerInfo.toString(), e);
            }
        }
    }

    public static void sendPlayerResult(@NonNull MediaSession.ControllerInfo controllerInfo, int i, @NonNull SessionPlayer.PlayerResult playerResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65544, null, controllerInfo, i, playerResult) == null) {
            try {
                controllerInfo.getControllerCb().onPlayerResult(i, playerResult);
            } catch (RemoteException e) {
                Log.w(TAG, "Exception in " + controllerInfo.toString(), e);
            }
        }
    }

    public static void sendSessionResult(@NonNull MediaSession.ControllerInfo controllerInfo, int i, @NonNull SessionResult sessionResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65546, null, controllerInfo, i, sessionResult) == null) {
            try {
                controllerInfo.getControllerCb().onSessionResult(i, sessionResult);
            } catch (RemoteException e) {
                Log.w(TAG, "Exception in " + controllerInfo.toString(), e);
            }
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void onControllerResult(IMediaController iMediaController, int i, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048590, this, iMediaController, i, parcelImpl) == null) && iMediaController != null && parcelImpl != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                SequencedFutureManager sequencedFutureManager = this.mConnectedControllersManager.getSequencedFutureManager((ConnectedControllersManager<IBinder>) iMediaController.asBinder());
                if (sequencedFutureManager == null) {
                    return;
                }
                sequencedFutureManager.setFutureResult(i, (SessionResult) MediaParcelUtils.fromParcelable(parcelImpl));
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void seekTo(IMediaController iMediaController, int i, long j) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048600, this, new Object[]{iMediaController, Integer.valueOf(i), Long.valueOf(j)}) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10003, new SessionPlayerTask(this, j) { // from class: androidx.media2.session.MediaSessionStub.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ long val$pos;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(j)};
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
                this.val$pos = j;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.seekTo(this.val$pos);
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void setPlaybackSpeed(IMediaController iMediaController, int i, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048604, this, new Object[]{iMediaController, Integer.valueOf(i), Float.valueOf(f)}) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10004, new SessionPlayerTask(this, f) { // from class: androidx.media2.session.MediaSessionStub.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;
            public final /* synthetic */ float val$speed;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Float.valueOf(f)};
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
                this.val$speed = f;
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.setPlaybackSpeed(this.val$speed);
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void connect(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, iMediaController, i, parcelImpl) == null) && iMediaController != null && parcelImpl != null) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            long clearCallingIdentity = Binder.clearCallingIdentity();
            ConnectionRequest connectionRequest = (ConnectionRequest) MediaParcelUtils.fromParcelable(parcelImpl);
            if (callingPid == 0) {
                callingPid = connectionRequest.getPid();
            }
            try {
                connect(iMediaController, connectionRequest.getVersion(), connectionRequest.getPackageName(), callingPid, callingUid, connectionRequest.getConnectionHints());
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public void connect(IMediaController iMediaController, int i, String str, int i2, int i3, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{iMediaController, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), bundle}) == null) {
            MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
            this.mSessionImpl.getCallbackExecutor().execute(new Runnable(this, new MediaSession.ControllerInfo(remoteUserInfo, i, this.mSessionManager.isTrustedForMediaControl(remoteUserInfo), new Controller2Cb(this, iMediaController), bundle), iMediaController) { // from class: androidx.media2.session.MediaSessionStub.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ IMediaController val$caller;
                public final /* synthetic */ MediaSession.ControllerInfo val$controllerInfo;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, iMediaController};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$controllerInfo = r7;
                    this.val$caller = iMediaController;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    SequencedFutureManager sequencedFutureManager;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mSessionImpl.isClosed()) {
                        return;
                    }
                    IBinder callbackBinder = ((Controller2Cb) this.val$controllerInfo.getControllerCb()).getCallbackBinder();
                    SessionCommandGroup onConnect = this.this$0.mSessionImpl.getCallback().onConnect(this.this$0.mSessionImpl.getInstance(), this.val$controllerInfo);
                    if (onConnect == null && !this.val$controllerInfo.isTrusted()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        if (MediaSessionStub.DEBUG) {
                            Log.d(MediaSessionStub.TAG, "Accepting connection, controllerInfo=" + this.val$controllerInfo + " allowedCommands=" + onConnect);
                        }
                        if (onConnect == null) {
                            onConnect = new SessionCommandGroup();
                        }
                        synchronized (this.this$0.mLock) {
                            if (this.this$0.mConnectedControllersManager.isConnected(this.val$controllerInfo)) {
                                Log.w(MediaSessionStub.TAG, "Controller " + this.val$controllerInfo + " has sent connection request multiple times");
                            }
                            this.this$0.mConnectedControllersManager.addController(callbackBinder, this.val$controllerInfo, onConnect);
                            sequencedFutureManager = this.this$0.mConnectedControllersManager.getSequencedFutureManager(this.val$controllerInfo);
                        }
                        MediaSessionStub mediaSessionStub = this.this$0;
                        ConnectionResult connectionResult = new ConnectionResult(mediaSessionStub, mediaSessionStub.mSessionImpl, onConnect);
                        if (this.this$0.mSessionImpl.isClosed()) {
                            return;
                        }
                        try {
                            this.val$caller.onConnected(sequencedFutureManager.obtainNextSequenceNumber(), MediaParcelUtils.toParcelable(connectionResult));
                        } catch (RemoteException unused) {
                        }
                        this.this$0.mSessionImpl.getCallback().onPostConnect(this.this$0.mSessionImpl.getInstance(), this.val$controllerInfo);
                        return;
                    }
                    if (MediaSessionStub.DEBUG) {
                        Log.d(MediaSessionStub.TAG, "Rejecting connection, controllerInfo=" + this.val$controllerInfo);
                    }
                    try {
                        this.val$caller.onDisconnected(0);
                    } catch (RemoteException unused2) {
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{iMediaController, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), parcelImpl}) == null) && iMediaController != null && parcelImpl != null) {
            dispatchLibrarySessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, new LibrarySessionCallbackTask<LibraryResult>(this, str, i2, i3, parcelImpl) { // from class: androidx.media2.session.MediaSessionStub.34
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ ParcelImpl val$libraryParams;
                public final /* synthetic */ int val$page;
                public final /* synthetic */ int val$pageSize;
                public final /* synthetic */ String val$parentId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2), Integer.valueOf(i3), parcelImpl};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$parentId = str;
                    this.val$page = i2;
                    this.val$pageSize = i3;
                    this.val$libraryParams = parcelImpl;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
                public LibraryResult run(MediaSession.ControllerInfo controllerInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                        if (TextUtils.isEmpty(this.val$parentId)) {
                            Log.w(MediaSessionStub.TAG, "getChildren(): Ignoring empty parentId from " + controllerInfo);
                            return new LibraryResult(-3);
                        } else if (this.val$page < 0) {
                            Log.w(MediaSessionStub.TAG, "getChildren(): Ignoring negative page from " + controllerInfo);
                            return new LibraryResult(-3);
                        } else if (this.val$pageSize < 1) {
                            Log.w(MediaSessionStub.TAG, "getChildren(): Ignoring pageSize less than 1 from " + controllerInfo);
                            return new LibraryResult(-3);
                        } else {
                            return this.this$0.getLibrarySession().onGetChildrenOnExecutor(controllerInfo, this.val$parentId, this.val$page, this.val$pageSize, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(this.val$libraryParams));
                        }
                    }
                    return (LibraryResult) invokeL.objValue;
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{iMediaController, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), parcelImpl}) == null) && iMediaController != null && parcelImpl != null) {
            dispatchLibrarySessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, new LibrarySessionCallbackTask<LibraryResult>(this, str, i2, i3, parcelImpl) { // from class: androidx.media2.session.MediaSessionStub.36
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionStub this$0;
                public final /* synthetic */ ParcelImpl val$libraryParams;
                public final /* synthetic */ int val$page;
                public final /* synthetic */ int val$pageSize;
                public final /* synthetic */ String val$query;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2), Integer.valueOf(i3), parcelImpl};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$query = str;
                    this.val$page = i2;
                    this.val$pageSize = i3;
                    this.val$libraryParams = parcelImpl;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.media2.session.MediaSessionStub.LibrarySessionCallbackTask
                public LibraryResult run(MediaSession.ControllerInfo controllerInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                        if (TextUtils.isEmpty(this.val$query)) {
                            Log.w(MediaSessionStub.TAG, "getSearchResult(): Ignoring empty query from " + controllerInfo);
                            return new LibraryResult(-3);
                        } else if (this.val$page < 0) {
                            Log.w(MediaSessionStub.TAG, "getSearchResult(): Ignoring negative page from " + controllerInfo);
                            return new LibraryResult(-3);
                        } else if (this.val$pageSize < 1) {
                            Log.w(MediaSessionStub.TAG, "getSearchResult(): Ignoring pageSize less than 1 from " + controllerInfo);
                            return new LibraryResult(-3);
                        } else {
                            return this.this$0.getLibrarySession().onGetSearchResultOnExecutor(controllerInfo, this.val$query, this.val$page, this.val$pageSize, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(this.val$libraryParams));
                        }
                    }
                    return (LibraryResult) invokeL.objValue;
                }
            });
        }
    }

    @Nullable
    public MediaItem convertMediaItemOnExecutor(MediaSession.ControllerInfo controllerInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, controllerInfo, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            MediaItem onCreateMediaItem = this.mSessionImpl.getCallback().onCreateMediaItem(this.mSessionImpl.getInstance(), controllerInfo, str);
            if (onCreateMediaItem == null) {
                Log.w(TAG, "onCreateMediaItem(mediaId=" + str + ") returned null. Ignoring");
            } else if (onCreateMediaItem.getMetadata() == null || !TextUtils.equals(str, onCreateMediaItem.getMetadata().getString("android.media.metadata.MEDIA_ID"))) {
                throw new RuntimeException("onCreateMediaItem(mediaId=" + str + "): media ID in the returned media item should match");
            }
            return onCreateMediaItem;
        }
        return (MediaItem) invokeLL.objValue;
    }

    @Override // androidx.media2.session.IMediaSession
    public void fastForward(IMediaController iMediaController, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, iMediaController, i) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, new SessionCallbackTask<Integer>(this) { // from class: androidx.media2.session.MediaSessionStub.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return Integer.valueOf(this.this$0.mSessionImpl.getCallback().onFastForward(this.this$0.mSessionImpl.getInstance(), controllerInfo));
                }
                return (Integer) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void pause(IMediaController iMediaController, int i) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048592, this, iMediaController, i) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10001, new SessionPlayerTask(this) { // from class: androidx.media2.session.MediaSessionStub.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.pause();
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void play(IMediaController iMediaController, int i) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048593, this, iMediaController, i) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10000, new SessionPlayerTask(this) { // from class: androidx.media2.session.MediaSessionStub.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.play();
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void prepare(IMediaController iMediaController, int i) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048594, this, iMediaController, i) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10002, new SessionPlayerTask(this) { // from class: androidx.media2.session.MediaSessionStub.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.prepare();
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void release(IMediaController iMediaController, int i) throws RemoteException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048595, this, iMediaController, i) != null) || iMediaController == null) {
            return;
        }
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            this.mConnectedControllersManager.removeController((ConnectedControllersManager<IBinder>) iMediaController.asBinder());
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    @Override // androidx.media2.session.IMediaSession
    public void rewind(IMediaController iMediaController, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048598, this, iMediaController, i) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_SESSION_REWIND, new SessionCallbackTask<Integer>(this) { // from class: androidx.media2.session.MediaSessionStub.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return Integer.valueOf(this.this$0.mSessionImpl.getCallback().onRewind(this.this$0.mSessionImpl.getInstance(), controllerInfo));
                }
                return (Integer) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void skipBackward(IMediaController iMediaController, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048611, this, iMediaController, i) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_SESSION_SKIP_BACKWARD, new SessionCallbackTask<Integer>(this) { // from class: androidx.media2.session.MediaSessionStub.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return Integer.valueOf(this.this$0.mSessionImpl.getCallback().onSkipBackward(this.this$0.mSessionImpl.getInstance(), controllerInfo));
                }
                return (Integer) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void skipForward(IMediaController iMediaController, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048612, this, iMediaController, i) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, SessionCommand.COMMAND_CODE_SESSION_SKIP_FORWARD, new SessionCallbackTask<Integer>(this) { // from class: androidx.media2.session.MediaSessionStub.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.media2.session.MediaSessionStub.SessionCallbackTask
            public Integer run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return Integer.valueOf(this.this$0.mSessionImpl.getCallback().onSkipForward(this.this$0.mSessionImpl.getInstance(), controllerInfo));
                }
                return (Integer) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void skipToNextItem(IMediaController iMediaController, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048613, this, iMediaController, i) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10009, new SessionPlayerTask(this) { // from class: androidx.media2.session.MediaSessionStub.26
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.skipToNextItem();
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    @Override // androidx.media2.session.IMediaSession
    public void skipToPreviousItem(IMediaController iMediaController, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048615, this, iMediaController, i) != null) || iMediaController == null) {
            return;
        }
        dispatchSessionTask(iMediaController, i, 10008, new SessionPlayerTask(this) { // from class: androidx.media2.session.MediaSessionStub.25
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaSessionStub this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
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
            }

            @Override // androidx.media2.session.MediaSessionStub.SessionPlayerTask
            public ListenableFuture<SessionPlayer.PlayerResult> run(MediaSession.ControllerInfo controllerInfo) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, controllerInfo)) == null) {
                    return this.this$0.mSessionImpl.skipToPreviousItem();
                }
                return (ListenableFuture) invokeL.objValue;
            }
        });
    }

    public ConnectedControllersManager<IBinder> getConnectedControllersManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mConnectedControllersManager;
        }
        return (ConnectedControllersManager) invokeV.objValue;
    }

    public MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl getLibrarySession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            MediaSession.MediaSessionImpl mediaSessionImpl = this.mSessionImpl;
            if (mediaSessionImpl instanceof MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl) {
                return (MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl) mediaSessionImpl;
            }
            throw new RuntimeException("Session cannot be casted to library session");
        }
        return (MediaLibraryService.MediaLibrarySession.MediaLibrarySessionImpl) invokeV.objValue;
    }
}

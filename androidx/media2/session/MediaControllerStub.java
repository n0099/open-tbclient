package androidx.media2.session;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.IMediaController;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.versionedparcelable.ParcelImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MediaControllerStub extends IMediaController.Stub {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = true;
    public static final String TAG = "MediaControllerStub";
    public transient /* synthetic */ FieldHolder $fh;
    public final WeakReference<MediaControllerImplBase> mController;
    public final SequencedFutureManager mSequencedFutureManager;

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface BrowserTask {
        void run(MediaBrowserImplBase mediaBrowserImplBase);
    }

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface ControllerTask {
        void run(MediaControllerImplBase mediaControllerImplBase);
    }

    public MediaControllerStub(MediaControllerImplBase mediaControllerImplBase, SequencedFutureManager sequencedFutureManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaControllerImplBase, sequencedFutureManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mController = new WeakReference<>(mediaControllerImplBase);
        this.mSequencedFutureManager = sequencedFutureManager;
    }

    private void dispatchBrowserTask(BrowserTask browserTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, browserTask) == null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                MediaControllerImplBase mediaControllerImplBase = this.mController.get();
                if ((mediaControllerImplBase instanceof MediaBrowserImplBase) && mediaControllerImplBase.isConnected()) {
                    browserTask.run((MediaBrowserImplBase) mediaControllerImplBase);
                }
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    private void dispatchControllerTask(ControllerTask controllerTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, controllerTask) == null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                MediaControllerImplBase mediaControllerImplBase = this.mController.get();
                if (mediaControllerImplBase != null && mediaControllerImplBase.isConnected()) {
                    controllerTask.run(mediaControllerImplBase);
                }
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onDisconnected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                MediaControllerImplBase mediaControllerImplBase = this.mController.get();
                if (mediaControllerImplBase == null) {
                    Log.d(TAG, "onDisconnected after MediaController.close()");
                } else {
                    mediaControllerImplBase.mInstance.close();
                }
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mController.clear();
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onAllowedCommandsChanged(int i, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, parcelImpl) != null) || parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask(this, parcelImpl) { // from class: androidx.media2.session.MediaControllerStub.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ ParcelImpl val$commands;

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
                this.val$commands = parcelImpl;
            }

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                    SessionCommandGroup sessionCommandGroup = (SessionCommandGroup) MediaParcelUtils.fromParcelable(this.val$commands);
                    if (sessionCommandGroup == null) {
                        Log.w(MediaControllerStub.TAG, "onAllowedCommandsChanged(): Ignoring null commands");
                    } else {
                        mediaControllerImplBase.onAllowedCommandsChanged(sessionCommandGroup);
                    }
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onLibraryResult(int i, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, parcelImpl) != null) || parcelImpl == null) {
            return;
        }
        dispatchBrowserTask(new BrowserTask(this, parcelImpl, i) { // from class: androidx.media2.session.MediaControllerStub.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ ParcelImpl val$libraryResult;
            public final /* synthetic */ int val$seq;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, parcelImpl, Integer.valueOf(i)};
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
                this.val$libraryResult = parcelImpl;
                this.val$seq = i;
            }

            @Override // androidx.media2.session.MediaControllerStub.BrowserTask
            public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                LibraryResult libraryResult;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, mediaBrowserImplBase) != null) || (libraryResult = (LibraryResult) MediaParcelUtils.fromParcelable(this.val$libraryResult)) == null) {
                    return;
                }
                this.this$0.mSequencedFutureManager.setFutureResult(this.val$seq, libraryResult);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaybackInfoChanged(int i, ParcelImpl parcelImpl) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048586, this, i, parcelImpl) != null) || parcelImpl == null) {
            return;
        }
        Log.d(TAG, "onPlaybackInfoChanged");
        dispatchControllerTask(new ControllerTask(this, parcelImpl) { // from class: androidx.media2.session.MediaControllerStub.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ ParcelImpl val$playbackInfo;

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
                this.val$playbackInfo = parcelImpl;
            }

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                    MediaController.PlaybackInfo playbackInfo = (MediaController.PlaybackInfo) MediaParcelUtils.fromParcelable(this.val$playbackInfo);
                    if (playbackInfo == null) {
                        Log.w(MediaControllerStub.TAG, "onPlaybackInfoChanged(): Ignoring null playbackInfo");
                    } else {
                        mediaControllerImplBase.notifyPlaybackInfoChanges(playbackInfo);
                    }
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaylistMetadataChanged(int i, ParcelImpl parcelImpl) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048590, this, i, parcelImpl) != null) || parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask(this, parcelImpl) { // from class: androidx.media2.session.MediaControllerStub.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
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

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                    mediaControllerImplBase.notifyPlaylistMetadataChanges((MediaMetadata) MediaParcelUtils.fromParcelable(this.val$metadata));
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSessionResult(int i, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048594, this, i, parcelImpl) != null) || parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask(this, parcelImpl, i) { // from class: androidx.media2.session.MediaControllerStub.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ int val$seq;
            public final /* synthetic */ ParcelImpl val$sessionResult;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, parcelImpl, Integer.valueOf(i)};
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
                this.val$sessionResult = parcelImpl;
                this.val$seq = i;
            }

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                SessionResult sessionResult;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 != null && interceptable2.invokeL(1048576, this, mediaControllerImplBase) != null) || (sessionResult = (SessionResult) MediaParcelUtils.fromParcelable(this.val$sessionResult)) == null) {
                    return;
                }
                this.this$0.mSequencedFutureManager.setFutureResult(this.val$seq, sessionResult);
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onSetCustomLayout(int i, List<ParcelImpl> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, list) == null) {
            if (list == null) {
                Log.w(TAG, "setCustomLayout(): Ignoring null commandButtonList");
            } else {
                dispatchControllerTask(new ControllerTask(this, list, i) { // from class: androidx.media2.session.MediaControllerStub.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaControllerStub this$0;
                    public final /* synthetic */ List val$commandButtonList;
                    public final /* synthetic */ int val$seq;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, list, Integer.valueOf(i)};
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
                        this.val$commandButtonList = list;
                        this.val$seq = i;
                    }

                    @Override // androidx.media2.session.MediaControllerStub.ControllerTask
                    public void run(MediaControllerImplBase mediaControllerImplBase) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                            ArrayList arrayList = new ArrayList();
                            for (int i2 = 0; i2 < this.val$commandButtonList.size(); i2++) {
                                MediaSession.CommandButton commandButton = (MediaSession.CommandButton) MediaParcelUtils.fromParcelable((ParcelImpl) this.val$commandButtonList.get(i2));
                                if (commandButton != null) {
                                    arrayList.add(commandButton);
                                }
                            }
                            mediaControllerImplBase.onSetCustomLayout(this.val$seq, arrayList);
                        }
                    }
                });
            }
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onTrackDeselected(int i, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048598, this, i, parcelImpl) != null) || parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask(this, parcelImpl, i) { // from class: androidx.media2.session.MediaControllerStub.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ int val$seq;
            public final /* synthetic */ ParcelImpl val$trackInfoParcel;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, parcelImpl, Integer.valueOf(i)};
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
                this.val$seq = i;
            }

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                    SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(this.val$trackInfoParcel);
                    if (trackInfo == null) {
                        Log.w(MediaControllerStub.TAG, "onTrackSelected(): Ignoring null track info");
                    } else {
                        mediaControllerImplBase.notifyTrackDeselected(this.val$seq, trackInfo);
                    }
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onTrackSelected(int i, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048600, this, i, parcelImpl) != null) || parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask(this, parcelImpl, i) { // from class: androidx.media2.session.MediaControllerStub.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ int val$seq;
            public final /* synthetic */ ParcelImpl val$trackInfoParcel;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, parcelImpl, Integer.valueOf(i)};
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
                this.val$seq = i;
            }

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                    SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(this.val$trackInfoParcel);
                    if (trackInfo == null) {
                        Log.w(MediaControllerStub.TAG, "onTrackSelected(): Ignoring null track info");
                    } else {
                        mediaControllerImplBase.notifyTrackSelected(this.val$seq, trackInfo);
                    }
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onBufferingStateChanged(int i, ParcelImpl parcelImpl, int i2, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), parcelImpl, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) != null) || parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask(this, parcelImpl, i2, j, j2, j3) { // from class: androidx.media2.session.MediaControllerStub.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ long val$bufferedPositionMs;
            public final /* synthetic */ long val$eventTimeMs;
            public final /* synthetic */ ParcelImpl val$item;
            public final /* synthetic */ long val$positionMs;
            public final /* synthetic */ int val$state;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, parcelImpl, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
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
                this.val$item = parcelImpl;
                this.val$state = i2;
                this.val$bufferedPositionMs = j;
                this.val$eventTimeMs = j2;
                this.val$positionMs = j3;
            }

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                    MediaItem mediaItem = (MediaItem) MediaParcelUtils.fromParcelable(this.val$item);
                    if (mediaItem == null) {
                        Log.w(MediaControllerStub.TAG, "onBufferingStateChanged(): Ignoring null item");
                    } else {
                        mediaControllerImplBase.notifyBufferingStateChanged(mediaItem, this.val$state, this.val$bufferedPositionMs, this.val$eventTimeMs, this.val$positionMs);
                    }
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaylistChanged(int i, ParcelImplListSlice parcelImplListSlice, ParcelImpl parcelImpl, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), parcelImplListSlice, parcelImpl, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) != null) || parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask(this, parcelImplListSlice, parcelImpl, i2, i3, i4) { // from class: androidx.media2.session.MediaControllerStub.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ int val$currentIdx;
            public final /* synthetic */ ParcelImplListSlice val$listSlice;
            public final /* synthetic */ ParcelImpl val$metadata;
            public final /* synthetic */ int val$nextIdx;
            public final /* synthetic */ int val$previousIdx;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, parcelImplListSlice, parcelImpl, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$listSlice = parcelImplListSlice;
                this.val$metadata = parcelImpl;
                this.val$currentIdx = i2;
                this.val$previousIdx = i3;
                this.val$nextIdx = i4;
            }

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                    mediaControllerImplBase.notifyPlaylistChanges(MediaUtils.convertParcelImplListSliceToMediaItemList(this.val$listSlice), (MediaMetadata) MediaParcelUtils.fromParcelable(this.val$metadata), this.val$currentIdx, this.val$previousIdx, this.val$nextIdx);
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onChildrenChanged(int i, String str, int i2, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), parcelImpl}) != null) || parcelImpl == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onChildrenChanged(): Ignoring empty parentId");
        } else if (i2 < 0) {
            Log.w(TAG, "onChildrenChanged(): Ignoring negative itemCount: " + i2);
        } else {
            dispatchBrowserTask(new BrowserTask(this, str, i2, parcelImpl) { // from class: androidx.media2.session.MediaControllerStub.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerStub this$0;
                public final /* synthetic */ int val$itemCount;
                public final /* synthetic */ ParcelImpl val$libraryParams;
                public final /* synthetic */ String val$parentId;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2), parcelImpl};
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
                    this.val$parentId = str;
                    this.val$itemCount = i2;
                    this.val$libraryParams = parcelImpl;
                }

                @Override // androidx.media2.session.MediaControllerStub.BrowserTask
                public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaBrowserImplBase) == null) {
                        mediaBrowserImplBase.notifyChildrenChanged(this.val$parentId, this.val$itemCount, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(this.val$libraryParams));
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onSearchResultChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RuntimeException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), parcelImpl}) != null) || parcelImpl == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onSearchResultChanged(): Ignoring empty query");
        } else if (i2 < 0) {
            Log.w(TAG, "onSearchResultChanged(): Ignoring negative itemCount: " + i2);
        } else {
            dispatchBrowserTask(new BrowserTask(this, str, i2, parcelImpl) { // from class: androidx.media2.session.MediaControllerStub.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerStub this$0;
                public final /* synthetic */ int val$itemCount;
                public final /* synthetic */ ParcelImpl val$libraryParams;
                public final /* synthetic */ String val$query;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, Integer.valueOf(i2), parcelImpl};
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
                    this.val$query = str;
                    this.val$itemCount = i2;
                    this.val$libraryParams = parcelImpl;
                }

                @Override // androidx.media2.session.MediaControllerStub.BrowserTask
                public void run(MediaBrowserImplBase mediaBrowserImplBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaBrowserImplBase) == null) {
                        mediaBrowserImplBase.notifySearchResultChanged(this.val$query, this.val$itemCount, (MediaLibraryService.LibraryParams) MediaParcelUtils.fromParcelable(this.val$libraryParams));
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onConnected(int i, ParcelImpl parcelImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, parcelImpl) == null) {
            if (parcelImpl == null) {
                onDisconnected(i);
                return;
            }
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                MediaControllerImplBase mediaControllerImplBase = this.mController.get();
                if (mediaControllerImplBase == null) {
                    Log.d(TAG, "onConnected after MediaController.close()");
                    return;
                }
                ConnectionResult connectionResult = (ConnectionResult) MediaParcelUtils.fromParcelable(parcelImpl);
                mediaControllerImplBase.onConnectedNotLocked(connectionResult.getVersion(), connectionResult.getSessionStub(), connectionResult.getAllowedCommands(), connectionResult.getPlayerState(), connectionResult.getCurrentMediaItem(), connectionResult.getPositionEventTimeMs(), connectionResult.getPositionMs(), connectionResult.getPlaybackSpeed(), connectionResult.getBufferedPositionMs(), connectionResult.getPlaybackInfo(), connectionResult.getRepeatMode(), connectionResult.getShuffleMode(), MediaUtils.convertParcelImplListSliceToMediaItemList(connectionResult.getPlaylistSlice()), connectionResult.getSessionActivity(), connectionResult.getCurrentMediaItemIndex(), connectionResult.getPreviousMediaItemIndex(), connectionResult.getNextMediaItemIndex(), connectionResult.getTokenExtras(), connectionResult.getVideoSize(), connectionResult.getTracks(), connectionResult.getSelectedVideoTrack(), connectionResult.getSelectedAudioTrack(), connectionResult.getSelectedSubtitleTrack(), connectionResult.getSelectedMetadataTrack());
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onCurrentMediaItemChanged(int i, ParcelImpl parcelImpl, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), parcelImpl, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) != null) || parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask(this, parcelImpl, i2, i3, i4) { // from class: androidx.media2.session.MediaControllerStub.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ int val$currentIdx;
            public final /* synthetic */ ParcelImpl val$item;
            public final /* synthetic */ int val$nextIdx;
            public final /* synthetic */ int val$previousIdx;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, parcelImpl, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$item = parcelImpl;
                this.val$currentIdx = i2;
                this.val$previousIdx = i3;
                this.val$nextIdx = i4;
            }

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                    mediaControllerImplBase.notifyCurrentMediaItemChanged((MediaItem) MediaParcelUtils.fromParcelable(this.val$item), this.val$currentIdx, this.val$previousIdx, this.val$nextIdx);
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchControllerTask(new ControllerTask(this, i2, i3, i4, i5) { // from class: androidx.media2.session.MediaControllerStub.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerStub this$0;
                public final /* synthetic */ int val$currentIdx;
                public final /* synthetic */ int val$nextIdx;
                public final /* synthetic */ int val$previousIdx;
                public final /* synthetic */ int val$repeatMode;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i6 = newInitContext.flag;
                        if ((i6 & 1) != 0) {
                            int i7 = i6 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$repeatMode = i2;
                    this.val$currentIdx = i3;
                    this.val$previousIdx = i4;
                    this.val$nextIdx = i5;
                }

                @Override // androidx.media2.session.MediaControllerStub.ControllerTask
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                        mediaControllerImplBase.notifyRepeatModeChanges(this.val$repeatMode, this.val$currentIdx, this.val$previousIdx, this.val$nextIdx);
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            dispatchControllerTask(new ControllerTask(this, i2, i3, i4, i5) { // from class: androidx.media2.session.MediaControllerStub.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerStub this$0;
                public final /* synthetic */ int val$currentIdx;
                public final /* synthetic */ int val$nextIdx;
                public final /* synthetic */ int val$previousIdx;
                public final /* synthetic */ int val$shuffleMode;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i6 = newInitContext.flag;
                        if ((i6 & 1) != 0) {
                            int i7 = i6 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$shuffleMode = i2;
                    this.val$currentIdx = i3;
                    this.val$previousIdx = i4;
                    this.val$nextIdx = i5;
                }

                @Override // androidx.media2.session.MediaControllerStub.ControllerTask
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                        mediaControllerImplBase.notifyShuffleModeChanges(this.val$shuffleMode, this.val$currentIdx, this.val$previousIdx, this.val$nextIdx);
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onCustomCommand(int i, ParcelImpl parcelImpl, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(1048582, this, i, parcelImpl, bundle) != null) || parcelImpl == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask(this, parcelImpl, i, bundle) { // from class: androidx.media2.session.MediaControllerStub.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ Bundle val$args;
            public final /* synthetic */ ParcelImpl val$commandParcel;
            public final /* synthetic */ int val$seq;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, parcelImpl, Integer.valueOf(i), bundle};
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
                this.val$commandParcel = parcelImpl;
                this.val$seq = i;
                this.val$args = bundle;
            }

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                    SessionCommand sessionCommand = (SessionCommand) MediaParcelUtils.fromParcelable(this.val$commandParcel);
                    if (sessionCommand == null) {
                        Log.w(MediaControllerStub.TAG, "sendCustomCommand(): Ignoring null command");
                    } else {
                        mediaControllerImplBase.onCustomCommand(this.val$seq, sessionCommand, this.val$args);
                    }
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onVideoSizeChanged(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(1048601, this, i, parcelImpl, parcelImpl2) != null) || parcelImpl2 == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask(this, parcelImpl2) { // from class: androidx.media2.session.MediaControllerStub.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ ParcelImpl val$videoSize;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, parcelImpl2};
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
                this.val$videoSize = parcelImpl2;
            }

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                    VideoSize videoSize = (VideoSize) MediaParcelUtils.fromParcelable(this.val$videoSize);
                    if (videoSize == null) {
                        Log.w(MediaControllerStub.TAG, "onVideoSizeChanged(): Ignoring null VideoSize");
                    } else {
                        mediaControllerImplBase.notifyVideoSizeChanged(videoSize);
                    }
                }
            }
        });
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaybackCompleted(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            dispatchControllerTask(new ControllerTask(this) { // from class: androidx.media2.session.MediaControllerStub.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerStub this$0;

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

                @Override // androidx.media2.session.MediaControllerStub.ControllerTask
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                        mediaControllerImplBase.notifyPlaybackCompleted();
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlaybackSpeedChanged(int i, long j, long j2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f)}) == null) {
            dispatchControllerTask(new ControllerTask(this, j, j2, f) { // from class: androidx.media2.session.MediaControllerStub.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerStub this$0;
                public final /* synthetic */ long val$eventTimeMs;
                public final /* synthetic */ long val$positionMs;
                public final /* synthetic */ float val$speed;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f)};
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
                    this.val$eventTimeMs = j;
                    this.val$positionMs = j2;
                    this.val$speed = f;
                }

                @Override // androidx.media2.session.MediaControllerStub.ControllerTask
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                        mediaControllerImplBase.notifyPlaybackSpeedChanges(this.val$eventTimeMs, this.val$positionMs, this.val$speed);
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onPlayerStateChanged(int i, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            dispatchControllerTask(new ControllerTask(this, j, j2, i2) { // from class: androidx.media2.session.MediaControllerStub.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerStub this$0;
                public final /* synthetic */ long val$eventTimeMs;
                public final /* synthetic */ long val$positionMs;
                public final /* synthetic */ int val$state;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)};
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
                    this.val$eventTimeMs = j;
                    this.val$positionMs = j2;
                    this.val$state = i2;
                }

                @Override // androidx.media2.session.MediaControllerStub.ControllerTask
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                        mediaControllerImplBase.notifyPlayerStateChanges(this.val$eventTimeMs, this.val$positionMs, this.val$state);
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onSeekCompleted(int i, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            dispatchControllerTask(new ControllerTask(this, j, j2, j3) { // from class: androidx.media2.session.MediaControllerStub.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerStub this$0;
                public final /* synthetic */ long val$eventTimeMs;
                public final /* synthetic */ long val$positionMs;
                public final /* synthetic */ long val$seekPositionMs;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
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
                    this.val$eventTimeMs = j;
                    this.val$positionMs = j2;
                    this.val$seekPositionMs = j3;
                }

                @Override // androidx.media2.session.MediaControllerStub.ControllerTask
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                        mediaControllerImplBase.notifySeekCompleted(this.val$eventTimeMs, this.val$positionMs, this.val$seekPositionMs);
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onSubtitleData(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), parcelImpl, parcelImpl2, parcelImpl3}) == null) && parcelImpl != null && parcelImpl2 != null && parcelImpl3 != null) {
            dispatchControllerTask(new ControllerTask(this, parcelImpl, parcelImpl2, parcelImpl3) { // from class: androidx.media2.session.MediaControllerStub.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerStub this$0;
                public final /* synthetic */ ParcelImpl val$data;
                public final /* synthetic */ ParcelImpl val$item;
                public final /* synthetic */ ParcelImpl val$track;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, parcelImpl, parcelImpl2, parcelImpl3};
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
                    this.val$item = parcelImpl;
                    this.val$track = parcelImpl2;
                    this.val$data = parcelImpl3;
                }

                @Override // androidx.media2.session.MediaControllerStub.ControllerTask
                public void run(MediaControllerImplBase mediaControllerImplBase) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                        MediaItem mediaItem = (MediaItem) MediaParcelUtils.fromParcelable(this.val$item);
                        if (mediaItem == null) {
                            Log.w(MediaControllerStub.TAG, "onSubtitleData(): Ignoring null MediaItem");
                            return;
                        }
                        SessionPlayer.TrackInfo trackInfo = (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(this.val$track);
                        if (trackInfo == null) {
                            Log.w(MediaControllerStub.TAG, "onSubtitleData(): Ignoring null TrackInfo");
                            return;
                        }
                        SubtitleData subtitleData = (SubtitleData) MediaParcelUtils.fromParcelable(this.val$data);
                        if (subtitleData == null) {
                            Log.w(MediaControllerStub.TAG, "onSubtitleData(): Ignoring null SubtitleData");
                        } else {
                            mediaControllerImplBase.notifySubtitleData(mediaItem, trackInfo, subtitleData);
                        }
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.IMediaController
    public void onTrackInfoChanged(int i, List<ParcelImpl> list, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3, ParcelImpl parcelImpl4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), list, parcelImpl, parcelImpl2, parcelImpl3, parcelImpl4}) != null) || list == null) {
            return;
        }
        dispatchControllerTask(new ControllerTask(this, list, parcelImpl, parcelImpl2, parcelImpl3, parcelImpl4, i) { // from class: androidx.media2.session.MediaControllerStub.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerStub this$0;
            public final /* synthetic */ ParcelImpl val$selectedAudioParcel;
            public final /* synthetic */ ParcelImpl val$selectedMetadataParcel;
            public final /* synthetic */ ParcelImpl val$selectedSubtitleParcel;
            public final /* synthetic */ ParcelImpl val$selectedVideoParcel;
            public final /* synthetic */ int val$seq;
            public final /* synthetic */ List val$trackInfoList;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, list, parcelImpl, parcelImpl2, parcelImpl3, parcelImpl4, Integer.valueOf(i)};
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
                this.val$trackInfoList = list;
                this.val$selectedVideoParcel = parcelImpl;
                this.val$selectedAudioParcel = parcelImpl2;
                this.val$selectedSubtitleParcel = parcelImpl3;
                this.val$selectedMetadataParcel = parcelImpl4;
                this.val$seq = i;
            }

            @Override // androidx.media2.session.MediaControllerStub.ControllerTask
            public void run(MediaControllerImplBase mediaControllerImplBase) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, mediaControllerImplBase) == null) {
                    mediaControllerImplBase.notifyTracksChanged(this.val$seq, MediaParcelUtils.fromParcelableList(this.val$trackInfoList), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(this.val$selectedVideoParcel), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(this.val$selectedAudioParcel), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(this.val$selectedSubtitleParcel), (SessionPlayer.TrackInfo) MediaParcelUtils.fromParcelable(this.val$selectedMetadataParcel));
                }
            }
        });
    }
}

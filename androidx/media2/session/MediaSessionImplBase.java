package androidx.media2.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Surface;
import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.VolumeProviderCompat;
import androidx.media2.common.BaseResult;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
import androidx.media2.session.RemoteSessionPlayer;
import androidx.media2.session.SequencedFutureManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class MediaSessionImplBase implements MediaSession.MediaSessionImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String DEFAULT_MEDIA_SESSION_TAG_DELIM = ".";
    public static final String DEFAULT_MEDIA_SESSION_TAG_PREFIX = "androidx.media2.session.id";
    public static final int ITEM_NONE = -1;
    public static final SessionResult RESULT_WHEN_CLOSED;
    public static final Object STATIC_LOCK;
    public static final String TAG = "MSImplBase";
    public static boolean sComponentNamesInitialized;
    public static ComponentName sServiceComponentName;
    public transient /* synthetic */ FieldHolder $fh;
    public final AudioManager mAudioManager;
    public final BroadcastReceiver mBroadcastReceiver;
    public MediaBrowserServiceCompat mBrowserServiceLegacyStub;
    public final MediaSession.SessionCallback mCallback;
    public final Executor mCallbackExecutor;
    public final Context mContext;
    public final Handler mHandler;
    public final HandlerThread mHandlerThread;
    public final MediaSession mInstance;
    public final Object mLock;
    public final PendingIntent mMediaButtonIntent;
    public MediaController.PlaybackInfo mPlaybackInfo;
    public SessionPlayer mPlayer;
    public final SessionPlayerCallback mPlayerCallback;
    public final PendingIntent mSessionActivity;
    public final MediaSessionCompat mSessionCompat;
    public final String mSessionId;
    public final MediaSessionLegacyStub mSessionLegacyStub;
    public final MediaSessionStub mSessionStub;
    public final SessionToken mSessionToken;
    public final Uri mSessionUri;
    public VolumeProviderCompat mVolumeProviderCompat;

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface PlayerTask {
        Object run(SessionPlayer sessionPlayer) throws Exception;
    }

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface RemoteControllerTask {
        void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void updatePlayer(SessionPlayer sessionPlayer, SessionPlayer sessionPlayer2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, sessionPlayer, sessionPlayer2) == null) {
        }
    }

    /* loaded from: classes.dex */
    public static final class CombinedCommandResultFuture<T extends BaseResult> extends AbstractResolvableFuture<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ListenableFuture<T>[] mFutures;
        public AtomicInteger mSuccessCount;

        public CombinedCommandResultFuture(Executor executor, ListenableFuture<T>[] listenableFutureArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {executor, listenableFutureArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int i3 = 0;
            this.mSuccessCount = new AtomicInteger(0);
            this.mFutures = listenableFutureArr;
            while (true) {
                ListenableFuture<T>[] listenableFutureArr2 = this.mFutures;
                if (i3 < listenableFutureArr2.length) {
                    listenableFutureArr2[i3].addListener(new Runnable(this, i3) { // from class: androidx.media2.session.MediaSessionImplBase.CombinedCommandResultFuture.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ CombinedCommandResultFuture this$0;
                        public final /* synthetic */ int val$cur;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this, Integer.valueOf(i3)};
                                interceptable2.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$cur = i3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                int i4 = 0;
                                try {
                                    BaseResult baseResult = (BaseResult) this.this$0.mFutures[this.val$cur].get();
                                    int resultCode = baseResult.getResultCode();
                                    if (resultCode != 0 && resultCode != 1) {
                                        for (int i5 = 0; i5 < this.this$0.mFutures.length; i5++) {
                                            if (!this.this$0.mFutures[i5].isCancelled() && !this.this$0.mFutures[i5].isDone() && this.val$cur != i5) {
                                                this.this$0.mFutures[i5].cancel(true);
                                            }
                                        }
                                        this.this$0.set(baseResult);
                                    } else if (this.this$0.mSuccessCount.incrementAndGet() == this.this$0.mFutures.length) {
                                        this.this$0.set(baseResult);
                                    }
                                } catch (Exception e) {
                                    while (true) {
                                        CombinedCommandResultFuture combinedCommandResultFuture = this.this$0;
                                        ListenableFuture<T>[] listenableFutureArr3 = combinedCommandResultFuture.mFutures;
                                        if (i4 >= listenableFutureArr3.length) {
                                            combinedCommandResultFuture.setException(e);
                                            return;
                                        }
                                        if (!listenableFutureArr3[i4].isCancelled() && !this.this$0.mFutures[i4].isDone() && this.val$cur != i4) {
                                            this.this$0.mFutures[i4].cancel(true);
                                        }
                                        i4++;
                                    }
                                }
                            }
                        }
                    }, executor);
                    i3++;
                } else {
                    return;
                }
            }
        }

        @SafeVarargs
        public static <U extends BaseResult> CombinedCommandResultFuture<U> create(Executor executor, ListenableFuture<U>... listenableFutureArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, executor, listenableFutureArr)) == null) {
                return new CombinedCommandResultFuture<>(executor, listenableFutureArr);
            }
            return (CombinedCommandResultFuture) invokeLL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public final class MediaButtonReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaSessionImplBase this$0;

        public MediaButtonReceiver(MediaSessionImplBase mediaSessionImplBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSessionImplBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaSessionImplBase;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, context, intent) != null) || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !ObjectsCompat.equals(intent.getData(), this.this$0.mSessionUri) || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null) {
                return;
            }
            this.this$0.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
        }
    }

    /* loaded from: classes.dex */
    public static class PlaylistItemListener implements MediaItem.OnMetadataChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<MediaSessionImplBase> mSession;

        public PlaylistItemListener(MediaSessionImplBase mediaSessionImplBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSessionImplBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSession = new WeakReference<>(mediaSessionImplBase);
        }

        @Override // androidx.media2.common.MediaItem.OnMetadataChangedListener
        public void onMetadataChanged(MediaItem mediaItem, MediaMetadata mediaMetadata) {
            MediaSessionImplBase mediaSessionImplBase;
            List<MediaItem> playlist;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, mediaItem, mediaMetadata) != null) || (mediaSessionImplBase = this.mSession.get()) == null || mediaItem == null || (playlist = mediaSessionImplBase.getPlaylist()) == null) {
                return;
            }
            for (int i = 0; i < playlist.size(); i++) {
                if (mediaItem.equals(playlist.get(i))) {
                    mediaSessionImplBase.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, playlist, mediaSessionImplBase) { // from class: androidx.media2.session.MediaSessionImplBase.PlaylistItemListener.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PlaylistItemListener this$0;
                        public final /* synthetic */ List val$list;
                        public final /* synthetic */ MediaSessionImplBase val$session;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, playlist, mediaSessionImplBase};
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
                            this.val$list = playlist;
                            this.val$session = mediaSessionImplBase;
                        }

                        @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                        public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i2) == null) {
                                controllerCb.onPlaylistChanged(i2, this.val$list, this.val$session.getPlaylistMetadata(), this.val$session.getCurrentMediaItemIndex(), this.val$session.getPreviousMediaItemIndex(), this.val$session.getNextMediaItemIndex());
                            }
                        }
                    });
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class SessionPlayerCallback extends RemoteSessionPlayer.Callback implements MediaItem.OnMetadataChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<MediaItem> mList;
        public MediaItem mMediaItem;
        public final PlaylistItemListener mPlaylistItemChangedListener;
        public final WeakReference<MediaSessionImplBase> mSession;

        public SessionPlayerCallback(MediaSessionImplBase mediaSessionImplBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSessionImplBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSession = new WeakReference<>(mediaSessionImplBase);
            this.mPlaylistItemChangedListener = new PlaylistItemListener(mediaSessionImplBase);
        }

        private void dispatchRemoteControllerTask(SessionPlayer sessionPlayer, RemoteControllerTask remoteControllerTask) {
            MediaSessionImplBase session;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65537, this, sessionPlayer, remoteControllerTask) == null) && (session = getSession()) != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                session.dispatchRemoteControllerTaskWithoutReturn(remoteControllerTask);
            }
        }

        @Override // androidx.media2.common.MediaItem.OnMetadataChangedListener
        public void onMetadataChanged(MediaItem mediaItem, MediaMetadata mediaMetadata) {
            MediaSessionImplBase session;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048579, this, mediaItem, mediaMetadata) == null) && (session = getSession()) != null && !updateCurrentMediaItemMetadataWithDuration(session.getPlayer(), mediaItem, mediaMetadata)) {
                notifyCurrentMediaItemChanged(mediaItem);
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaybackSpeedChanged(SessionPlayer sessionPlayer, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048581, this, sessionPlayer, f) == null) {
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, sessionPlayer, f) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ SessionPlayer val$player;
                    public final /* synthetic */ float val$speed;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sessionPlayer, Float.valueOf(f)};
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
                        this.val$player = sessionPlayer;
                        this.val$speed = f;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onPlaybackSpeedChanged(i, SystemClock.elapsedRealtime(), this.val$player.getCurrentPosition(), this.val$speed);
                        }
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaylistMetadataChanged(SessionPlayer sessionPlayer, MediaMetadata mediaMetadata) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sessionPlayer, mediaMetadata) == null) {
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, mediaMetadata) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ MediaMetadata val$metadata;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, mediaMetadata};
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
                        this.val$metadata = mediaMetadata;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onPlaylistMetadataChanged(i, this.val$metadata);
                        }
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onRepeatModeChanged(SessionPlayer sessionPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, sessionPlayer, i) == null) {
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, i, getSession()) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ int val$repeatMode;
                    public final /* synthetic */ MediaSessionImplBase val$session;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i), r8};
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
                        this.val$session = r8;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i2) == null) {
                            controllerCb.onRepeatModeChanged(i2, this.val$repeatMode, this.val$session.getCurrentMediaItemIndex(), this.val$session.getPreviousMediaItemIndex(), this.val$session.getNextMediaItemIndex());
                        }
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onSeekCompleted(SessionPlayer sessionPlayer, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048586, this, sessionPlayer, j) == null) {
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, sessionPlayer, j) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ SessionPlayer val$player;
                    public final /* synthetic */ long val$position;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sessionPlayer, Long.valueOf(j)};
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
                        this.val$player = sessionPlayer;
                        this.val$position = j;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onSeekCompleted(i, SystemClock.elapsedRealtime(), this.val$player.getCurrentPosition(), this.val$position);
                        }
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onShuffleModeChanged(SessionPlayer sessionPlayer, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048587, this, sessionPlayer, i) == null) {
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, i, getSession()) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ MediaSessionImplBase val$session;
                    public final /* synthetic */ int val$shuffleMode;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i), r8};
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
                        this.val$session = r8;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i2) == null) {
                            controllerCb.onShuffleModeChanged(i2, this.val$shuffleMode, this.val$session.getCurrentMediaItemIndex(), this.val$session.getPreviousMediaItemIndex(), this.val$session.getNextMediaItemIndex());
                        }
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTrackDeselected(SessionPlayer sessionPlayer, SessionPlayer.TrackInfo trackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048589, this, sessionPlayer, trackInfo) == null) {
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, trackInfo) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ SessionPlayer.TrackInfo val$trackInfo;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, trackInfo};
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
                        this.val$trackInfo = trackInfo;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onTrackDeselected(i, MediaUtils.upcastForPreparceling(this.val$trackInfo));
                        }
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTrackSelected(SessionPlayer sessionPlayer, SessionPlayer.TrackInfo trackInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, sessionPlayer, trackInfo) == null) {
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, trackInfo) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ SessionPlayer.TrackInfo val$trackInfo;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, trackInfo};
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
                        this.val$trackInfo = trackInfo;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onTrackSelected(i, MediaUtils.upcastForPreparceling(this.val$trackInfo));
                        }
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onTracksChanged(SessionPlayer sessionPlayer, List<SessionPlayer.TrackInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, sessionPlayer, list) == null) {
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, list, getSession()) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ MediaSessionImplBase val$session;
                    public final /* synthetic */ List val$tracks;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, list, r8};
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
                        this.val$tracks = list;
                        this.val$session = r8;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onTracksChanged(i, MediaUtils.upcastForPreparceling(this.val$tracks), MediaUtils.upcastForPreparceling(this.val$session.getSelectedTrack(1)), MediaUtils.upcastForPreparceling(this.val$session.getSelectedTrack(2)), MediaUtils.upcastForPreparceling(this.val$session.getSelectedTrack(4)), MediaUtils.upcastForPreparceling(this.val$session.getSelectedTrack(5)));
                        }
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onVideoSizeChanged(SessionPlayer sessionPlayer, VideoSize videoSize) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048592, this, sessionPlayer, videoSize) == null) {
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, videoSize) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ VideoSize val$size;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, videoSize};
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
                        this.val$size = videoSize;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onVideoSizeChanged(i, MediaUtils.upcastForPreparceling(this.val$size));
                        }
                    }
                });
            }
        }

        private MediaSessionImplBase getSession() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                MediaSessionImplBase mediaSessionImplBase = this.mSession.get();
                if (mediaSessionImplBase == null && MediaSessionImplBase.DEBUG) {
                    Log.d(MediaSessionImplBase.TAG, "Session is closed", new IllegalStateException());
                }
                return mediaSessionImplBase;
            }
            return (MediaSessionImplBase) invokeV.objValue;
        }

        private void notifyCurrentMediaItemChanged(MediaItem mediaItem) {
            MediaSessionImplBase session;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65539, this, mediaItem) != null) || (session = getSession()) == null) {
                return;
            }
            dispatchRemoteControllerTask(session.getPlayer(), new RemoteControllerTask(this, mediaItem, session) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SessionPlayerCallback this$0;
                public final /* synthetic */ MediaItem val$currentMediaItem;
                public final /* synthetic */ MediaSessionImplBase val$session;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, mediaItem, session};
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
                    this.val$currentMediaItem = mediaItem;
                    this.val$session = session;
                }

                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                        controllerCb.onCurrentMediaItemChanged(i, this.val$currentMediaItem, this.val$session.getCurrentMediaItemIndex(), this.val$session.getPreviousMediaItemIndex(), this.val$session.getNextMediaItemIndex());
                    }
                }
            });
        }

        private boolean updateCurrentMediaItemMetadataWithDuration(SessionPlayer sessionPlayer) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, sessionPlayer)) == null) {
                MediaItem currentMediaItem = sessionPlayer.getCurrentMediaItem();
                if (currentMediaItem == null) {
                    return false;
                }
                return updateCurrentMediaItemMetadataWithDuration(sessionPlayer, currentMediaItem, currentMediaItem.getMetadata());
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaybackCompleted(SessionPlayer sessionPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, sessionPlayer) == null) {
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;

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

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onPlaybackCompleted(i);
                        }
                    }
                });
            }
        }

        private boolean updateCurrentMediaItemMetadataWithDuration(SessionPlayer sessionPlayer, MediaItem mediaItem, MediaMetadata mediaMetadata) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, this, sessionPlayer, mediaItem, mediaMetadata)) == null) {
                long duration = sessionPlayer.getDuration();
                if (mediaItem == sessionPlayer.getCurrentMediaItem() && sessionPlayer.getPlayerState() != 0 && duration > 0 && duration != Long.MIN_VALUE) {
                    MediaMetadata mediaMetadata2 = null;
                    if (mediaMetadata != null) {
                        if (!mediaMetadata.containsKey("android.media.metadata.DURATION")) {
                            mediaMetadata2 = new MediaMetadata.Builder(mediaMetadata).putLong("android.media.metadata.DURATION", duration).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1L).build();
                        } else {
                            long j = mediaMetadata.getLong("android.media.metadata.DURATION");
                            if (duration != j) {
                                Log.w(MediaSessionImplBase.TAG, "duration mismatch for an item. duration from player=" + duration + " duration from metadata=" + j + ". May be a timing issue?");
                            }
                        }
                    } else {
                        mediaMetadata2 = new MediaMetadata.Builder().putLong("android.media.metadata.DURATION", duration).putString("android.media.metadata.MEDIA_ID", mediaItem.getMediaId()).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1L).build();
                    }
                    if (mediaMetadata2 != null) {
                        mediaItem.setMetadata(mediaMetadata2);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onAudioAttributesChanged(SessionPlayer sessionPlayer, AudioAttributesCompat audioAttributesCompat) {
            MediaSessionImplBase session;
            MediaController.PlaybackInfo playbackInfo;
            AudioAttributesCompat audioAttributes;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, sessionPlayer, audioAttributesCompat) == null) && (session = getSession()) != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                MediaController.PlaybackInfo createPlaybackInfo = session.createPlaybackInfo(sessionPlayer, audioAttributesCompat);
                synchronized (session.mLock) {
                    playbackInfo = session.mPlaybackInfo;
                    session.mPlaybackInfo = createPlaybackInfo;
                }
                if (!ObjectsCompat.equals(createPlaybackInfo, playbackInfo)) {
                    session.notifyPlaybackInfoChangedNotLocked(createPlaybackInfo);
                    if (!(sessionPlayer instanceof RemoteSessionPlayer)) {
                        if (playbackInfo == null) {
                            audioAttributes = null;
                        } else {
                            audioAttributes = playbackInfo.getAudioAttributes();
                        }
                        int legacyStreamType = MediaSessionImplBase.getLegacyStreamType(audioAttributes);
                        int legacyStreamType2 = MediaSessionImplBase.getLegacyStreamType(createPlaybackInfo.getAudioAttributes());
                        if (legacyStreamType != legacyStreamType2) {
                            session.getSessionCompat().setPlaybackToLocal(legacyStreamType2);
                        }
                    }
                }
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onCurrentMediaItemChanged(SessionPlayer sessionPlayer, MediaItem mediaItem) {
            MediaSessionImplBase session;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sessionPlayer, mediaItem) == null) && (session = getSession()) != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                synchronized (session.mLock) {
                    if (this.mMediaItem != null) {
                        this.mMediaItem.removeOnMetadataChangedListener(this);
                    }
                    if (mediaItem != null) {
                        mediaItem.addOnMetadataChangedListener(session.mCallbackExecutor, this);
                    }
                    this.mMediaItem = mediaItem;
                }
                boolean z = false;
                if (mediaItem != null) {
                    z = updateCurrentMediaItemMetadataWithDuration(sessionPlayer, mediaItem, mediaItem.getMetadata());
                }
                if (!z) {
                    notifyCurrentMediaItemChanged(mediaItem);
                }
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onBufferingStateChanged(SessionPlayer sessionPlayer, MediaItem mediaItem, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sessionPlayer, mediaItem, i) == null) {
                updateCurrentMediaItemMetadataWithDuration(sessionPlayer);
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, mediaItem, i, sessionPlayer) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ MediaItem val$item;
                    public final /* synthetic */ SessionPlayer val$player;
                    public final /* synthetic */ int val$state;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, mediaItem, Integer.valueOf(i), sessionPlayer};
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
                        this.val$item = mediaItem;
                        this.val$state = i;
                        this.val$player = sessionPlayer;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i2) == null) {
                            controllerCb.onBufferingStateChanged(i2, this.val$item, this.val$state, this.val$player.getBufferedPosition(), SystemClock.elapsedRealtime(), this.val$player.getCurrentPosition());
                        }
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlayerStateChanged(SessionPlayer sessionPlayer, int i) {
            MediaSessionImplBase session;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048582, this, sessionPlayer, i) == null) && (session = getSession()) != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                session.getCallback().onPlayerStateChanged(session.getInstance(), i);
                updateCurrentMediaItemMetadataWithDuration(sessionPlayer);
                session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, sessionPlayer, i) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ SessionPlayer val$player;
                    public final /* synthetic */ int val$state;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sessionPlayer, Integer.valueOf(i)};
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
                        this.val$player = sessionPlayer;
                        this.val$state = i;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i2) == null) {
                            controllerCb.onPlayerStateChanged(i2, SystemClock.elapsedRealtime(), this.val$player.getCurrentPosition(), this.val$state);
                        }
                    }
                });
            }
        }

        @Override // androidx.media2.session.RemoteSessionPlayer.Callback
        public void onVolumeChanged(RemoteSessionPlayer remoteSessionPlayer, int i) {
            MediaSessionImplBase session;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048593, this, remoteSessionPlayer, i) != null) || (session = getSession()) == null) {
                return;
            }
            MediaController.PlaybackInfo createPlaybackInfo = session.createPlaybackInfo(remoteSessionPlayer, null);
            synchronized (session.mLock) {
                if (session.mPlayer != remoteSessionPlayer) {
                    return;
                }
                MediaController.PlaybackInfo playbackInfo = session.mPlaybackInfo;
                session.mPlaybackInfo = createPlaybackInfo;
                VolumeProviderCompat volumeProviderCompat = session.mVolumeProviderCompat;
                if (!ObjectsCompat.equals(createPlaybackInfo, playbackInfo)) {
                    session.notifyPlaybackInfoChangedNotLocked(createPlaybackInfo);
                }
                if (volumeProviderCompat != null) {
                    volumeProviderCompat.setCurrentVolume(i);
                }
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onPlaylistChanged(SessionPlayer sessionPlayer, List<MediaItem> list, MediaMetadata mediaMetadata) {
            MediaSessionImplBase session;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048583, this, sessionPlayer, list, mediaMetadata) == null) && (session = getSession()) != null && sessionPlayer != null && session.getPlayer() == sessionPlayer) {
                synchronized (session.mLock) {
                    if (this.mList != null) {
                        for (int i = 0; i < this.mList.size(); i++) {
                            this.mList.get(i).removeOnMetadataChangedListener(this.mPlaylistItemChangedListener);
                        }
                    }
                    if (list != null) {
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            list.get(i2).addOnMetadataChangedListener(session.mCallbackExecutor, this.mPlaylistItemChangedListener);
                        }
                    }
                    this.mList = list;
                }
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, list, mediaMetadata, session) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ List val$list;
                    public final /* synthetic */ MediaMetadata val$metadata;
                    public final /* synthetic */ MediaSessionImplBase val$session;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, list, mediaMetadata, session};
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
                        this.val$list = list;
                        this.val$metadata = mediaMetadata;
                        this.val$session = session;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i3) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i3) == null) {
                            controllerCb.onPlaylistChanged(i3, this.val$list, this.val$metadata, this.val$session.getCurrentMediaItemIndex(), this.val$session.getPreviousMediaItemIndex(), this.val$session.getNextMediaItemIndex());
                        }
                    }
                });
            }
        }

        @Override // androidx.media2.common.SessionPlayer.PlayerCallback
        public void onSubtitleData(SessionPlayer sessionPlayer, MediaItem mediaItem, SessionPlayer.TrackInfo trackInfo, SubtitleData subtitleData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048588, this, sessionPlayer, mediaItem, trackInfo, subtitleData) == null) {
                dispatchRemoteControllerTask(sessionPlayer, new RemoteControllerTask(this, mediaItem, trackInfo, subtitleData) { // from class: androidx.media2.session.MediaSessionImplBase.SessionPlayerCallback.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SessionPlayerCallback this$0;
                    public final /* synthetic */ SubtitleData val$data;
                    public final /* synthetic */ MediaItem val$item;
                    public final /* synthetic */ SessionPlayer.TrackInfo val$track;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, mediaItem, trackInfo, subtitleData};
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
                        this.val$item = mediaItem;
                        this.val$track = trackInfo;
                        this.val$data = subtitleData;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onSubtitleData(i, this.val$item, this.val$track, this.val$data);
                        }
                    }
                });
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1082929304, "Landroidx/media2/session/MediaSessionImplBase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1082929304, "Landroidx/media2/session/MediaSessionImplBase;");
                return;
            }
        }
        STATIC_LOCK = new Object();
        DEBUG = Log.isLoggable(TAG, 3);
        RESULT_WHEN_CLOSED = new SessionResult(1);
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mSessionStub.getConnectedControllersManager().getConnectedControllers());
            arrayList.addAll(this.mSessionLegacyStub.getConnectedControllersManager().getConnectedControllers());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public IBinder getLegacyBrowserServiceBinder() {
        InterceptResult invokeV;
        MediaBrowserServiceCompat mediaBrowserServiceCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this.mLock) {
                if (this.mBrowserServiceLegacyStub == null) {
                    this.mBrowserServiceLegacyStub = createLegacyBrowserService(this.mContext, this.mSessionToken, this.mSessionCompat.getSessionToken());
                }
                mediaBrowserServiceCompat = this.mBrowserServiceLegacyStub;
            }
            return mediaBrowserServiceCompat.onBind(new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE));
        }
        return (IBinder) invokeV.objValue;
    }

    public MediaSessionImplBase(MediaSession mediaSession, Context context, String str, SessionPlayer sessionPlayer, PendingIntent pendingIntent, Executor executor, MediaSession.SessionCallback sessionCallback, Bundle bundle) {
        ComponentName componentName;
        ComponentName componentName2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaSession, context, str, sessionPlayer, pendingIntent, executor, sessionCallback, bundle};
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
        this.mContext = context;
        this.mInstance = mediaSession;
        HandlerThread handlerThread = new HandlerThread("MediaSession_Thread");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mSessionStub = new MediaSessionStub(this);
        this.mSessionActivity = pendingIntent;
        this.mCallback = sessionCallback;
        this.mCallbackExecutor = executor;
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mPlayerCallback = new SessionPlayerCallback(this);
        this.mSessionId = str;
        this.mSessionUri = new Uri.Builder().scheme(MediaSessionImplBase.class.getName()).appendPath(str).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.mSessionToken = new SessionToken(new SessionTokenImplBase(Process.myUid(), 0, context.getPackageName(), this.mSessionStub, bundle));
        String join = TextUtils.join(".", new String[]{DEFAULT_MEDIA_SESSION_TAG_PREFIX, str});
        synchronized (STATIC_LOCK) {
            if (!sComponentNamesInitialized) {
                ComponentName serviceComponentByAction = getServiceComponentByAction(MediaLibraryService.SERVICE_INTERFACE);
                sServiceComponentName = serviceComponentByAction;
                if (serviceComponentByAction == null) {
                    sServiceComponentName = getServiceComponentByAction(MediaSessionService.SERVICE_INTERFACE);
                }
                sComponentNamesInitialized = true;
            }
            componentName = sServiceComponentName;
        }
        if (componentName == null) {
            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON", this.mSessionUri);
            intent.setPackage(context.getPackageName());
            this.mMediaButtonIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
            ComponentName componentName3 = new ComponentName(context, context.getClass());
            this.mBroadcastReceiver = new MediaButtonReceiver(this);
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
            intentFilter.addDataScheme(this.mSessionUri.getScheme());
            context.registerReceiver(this.mBroadcastReceiver, intentFilter);
            componentName2 = componentName3;
        } else {
            Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON", this.mSessionUri);
            intent2.setComponent(componentName);
            if (Build.VERSION.SDK_INT >= 26) {
                this.mMediaButtonIntent = PendingIntent.getForegroundService(this.mContext, 0, intent2, 0);
            } else {
                this.mMediaButtonIntent = PendingIntent.getService(this.mContext, 0, intent2, 0);
            }
            this.mBroadcastReceiver = null;
            componentName2 = componentName;
        }
        this.mSessionCompat = new MediaSessionCompat(context, join, componentName2, this.mMediaButtonIntent, this.mSessionToken.getExtras(), this.mSessionToken);
        this.mSessionLegacyStub = new MediaSessionLegacyStub(this, this.mHandler);
        this.mSessionCompat.setSessionActivity(pendingIntent);
        this.mSessionCompat.setFlags(4);
        updatePlayer(sessionPlayer);
        this.mSessionCompat.setCallback(this.mSessionLegacyStub, this.mHandler);
        this.mSessionCompat.setActive(true);
    }

    public static VolumeProviderCompat createVolumeProviderCompat(RemoteSessionPlayer remoteSessionPlayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, remoteSessionPlayer)) == null) {
            return new VolumeProviderCompat(remoteSessionPlayer.getVolumeControlType(), remoteSessionPlayer.getMaxVolume(), remoteSessionPlayer.getVolume(), remoteSessionPlayer) { // from class: androidx.media2.session.MediaSessionImplBase.53
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RemoteSessionPlayer val$player;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, r11);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Integer.valueOf(r9), Integer.valueOf(r10), Integer.valueOf(r11), remoteSessionPlayer};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$player = remoteSessionPlayer;
                }

                @Override // androidx.media.VolumeProviderCompat
                public void onAdjustVolume(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        this.val$player.adjustVolume(i);
                    }
                }

                @Override // androidx.media.VolumeProviderCompat
                public void onSetVolumeTo(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                        this.val$player.setVolume(i);
                    }
                }
            };
        }
        return (VolumeProviderCompat) invokeL.objValue;
    }

    private ListenableFuture<SessionPlayer.PlayerResult> dispatchPlayerTask(PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>> playerTask) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, playerTask)) == null) {
            ResolvableFuture create = ResolvableFuture.create();
            create.set(new SessionPlayer.PlayerResult(-2, null));
            return (ListenableFuture) dispatchPlayerTask(playerTask, create);
        }
        return (ListenableFuture) invokeL.objValue;
    }

    public static int getLegacyStreamType(AudioAttributesCompat audioAttributesCompat) {
        InterceptResult invokeL;
        int legacyStreamType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, audioAttributesCompat)) == null) {
            if (audioAttributesCompat == null || (legacyStreamType = audioAttributesCompat.getLegacyStreamType()) == Integer.MIN_VALUE) {
                return 3;
            }
            return legacyStreamType;
        }
        return invokeL.intValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public ListenableFuture<SessionPlayer.PlayerResult> deselectTrack(SessionPlayer.TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, trackInfo)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, trackInfo) { // from class: androidx.media2.session.MediaSessionImplBase.42
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
                public final /* synthetic */ SessionPlayer.TrackInfo val$trackInfo;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, trackInfo};
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
                    this.val$trackInfo = trackInfo;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.deselectTrack(this.val$trackInfo);
                    }
                    return (ListenableFuture) invokeL2.objValue;
                }
            });
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
            return (SessionPlayer.TrackInfo) dispatchPlayerTask(new PlayerTask<SessionPlayer.TrackInfo>(this, i) { // from class: androidx.media2.session.MediaSessionImplBase.43
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
                public final /* synthetic */ int val$trackType;

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
                    this.val$trackType = i;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public SessionPlayer.TrackInfo run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return MediaUtils.upcastForPreparceling(sessionPlayer.getSelectedTrack(this.val$trackType));
                    }
                    return (SessionPlayer.TrackInfo) invokeL.objValue;
                }
            }, null);
        }
        return (SessionPlayer.TrackInfo) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, controllerInfo)) == null) {
            if (controllerInfo == null) {
                return false;
            }
            if (!this.mSessionStub.getConnectedControllersManager().isConnected(controllerInfo) && !this.mSessionLegacyStub.getConnectedControllersManager().isConnected(controllerInfo)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean isInPlaybackState(SessionPlayer sessionPlayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, sessionPlayer)) == null) {
            if (!isClosed() && sessionPlayer.getPlayerState() != 0 && sessionPlayer.getPlayerState() != 3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void notifyPlaybackInfoChangedNotLocked(MediaController.PlaybackInfo playbackInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, playbackInfo) == null) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, playbackInfo) { // from class: androidx.media2.session.MediaSessionImplBase.52
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
                public final /* synthetic */ MediaController.PlaybackInfo val$info;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, playbackInfo};
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
                    this.val$info = playbackInfo;
                }

                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                        controllerCb.onPlaybackInfoChanged(i, this.val$info);
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> removePlaylistItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i)) == null) {
            if (i >= 0) {
                return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, i) { // from class: androidx.media2.session.MediaSessionImplBase.26
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
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

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                    public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                            if (this.val$index >= sessionPlayer.getPlaylist().size()) {
                                return SessionPlayer.PlayerResult.createFuture(-3);
                            }
                            return sessionPlayer.removePlaylistItem(this.val$index);
                        }
                        return (ListenableFuture) invokeL.objValue;
                    }
                });
            }
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> seekTo(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048627, this, j)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, j) { // from class: androidx.media2.session.MediaSessionImplBase.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.seekTo(this.val$pos);
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
        return (ListenableFuture) invokeJ.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public ListenableFuture<SessionPlayer.PlayerResult> selectTrack(SessionPlayer.TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, trackInfo)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, trackInfo) { // from class: androidx.media2.session.MediaSessionImplBase.41
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
                public final /* synthetic */ SessionPlayer.TrackInfo val$trackInfo;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, trackInfo};
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
                    this.val$trackInfo = trackInfo;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.selectTrack(this.val$trackInfo);
                    }
                    return (ListenableFuture) invokeL2.objValue;
                }
            });
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void setLegacyControllerConnectionTimeoutMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048632, this, j) == null) {
            this.mSessionLegacyStub.setLegacyControllerDisconnectTimeoutMs(j);
        }
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setMediaItem(MediaItem mediaItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, mediaItem)) == null) {
            if (mediaItem != null) {
                return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, mediaItem) { // from class: androidx.media2.session.MediaSessionImplBase.20
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
                    public final /* synthetic */ MediaItem val$item;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, mediaItem};
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
                        this.val$item = mediaItem;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                    public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                        InterceptResult invokeL2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                            return sessionPlayer.setMediaItem(this.val$item);
                        }
                        return (ListenableFuture) invokeL2.objValue;
                    }
                });
            }
            throw new NullPointerException("item shouldn't be null");
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> setPlaybackSpeed(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048634, this, f)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, f) { // from class: androidx.media2.session.MediaSessionImplBase.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.setPlaybackSpeed(this.val$speed);
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
        return (ListenableFuture) invokeF.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setRepeatMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, i) { // from class: androidx.media2.session.MediaSessionImplBase.35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.setRepeatMode(this.val$repeatMode);
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setShuffleMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, i) { // from class: androidx.media2.session.MediaSessionImplBase.37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.setShuffleMode(this.val$shuffleMode);
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public ListenableFuture<SessionPlayer.PlayerResult> setSurface(Surface surface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, surface)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, surface) { // from class: androidx.media2.session.MediaSessionImplBase.39
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
                public final /* synthetic */ Surface val$surface;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, surface};
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
                    this.val$surface = surface;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.setSurface(this.val$surface);
                    }
                    return (ListenableFuture) invokeL2.objValue;
                }
            });
        }
        return (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> skipToPlaylistItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048640, this, i)) == null) {
            if (i >= 0) {
                return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, i) { // from class: androidx.media2.session.MediaSessionImplBase.21
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
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

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                    public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                            if (this.val$index >= sessionPlayer.getPlaylist().size()) {
                                return SessionPlayer.PlayerResult.createFuture(-3);
                            }
                            return sessionPlayer.skipToPlaylistItem(this.val$index);
                        }
                        return (ListenableFuture) invokeL.objValue;
                    }
                });
            }
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        return (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> updatePlaylistMetadata(MediaMetadata mediaMetadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, mediaMetadata)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, mediaMetadata) { // from class: androidx.media2.session.MediaSessionImplBase.33
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
                public final /* synthetic */ MediaMetadata val$metadata;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, mediaMetadata};
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
                    this.val$metadata = mediaMetadata;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.updatePlaylistMetadata(this.val$metadata);
                    }
                    return (ListenableFuture) invokeL2.objValue;
                }
            });
        }
        return (ListenableFuture) invokeL.objValue;
    }

    private <T> T dispatchPlayerTask(PlayerTask<T> playerTask, T t) {
        InterceptResult invokeLL;
        SessionPlayer sessionPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, playerTask, t)) == null) {
            synchronized (this.mLock) {
                sessionPlayer = this.mPlayer;
            }
            try {
                if (!isClosed()) {
                    T t2 = (T) playerTask.run(sessionPlayer);
                    if (t2 != null) {
                        return t2;
                    }
                } else if (DEBUG) {
                    Log.d(TAG, "API calls after the close()", new IllegalStateException());
                }
            } catch (Exception unused) {
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }

    private void onDeadObjectException(MediaSession.ControllerInfo controllerInfo, DeadObjectException deadObjectException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, controllerInfo, deadObjectException) == null) {
            if (DEBUG) {
                Log.d(TAG, controllerInfo.toString() + " is gone", deadObjectException);
            }
            this.mSessionStub.getConnectedControllersManager().removeController(controllerInfo);
        }
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void setAllowedCommands(MediaSession.ControllerInfo controllerInfo, SessionCommandGroup sessionCommandGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, controllerInfo, sessionCommandGroup) == null) {
            if (this.mSessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
                this.mSessionStub.getConnectedControllersManager().updateAllowedCommands(controllerInfo, sessionCommandGroup);
                dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask(this, sessionCommandGroup) { // from class: androidx.media2.session.MediaSessionImplBase.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
                    public final /* synthetic */ SessionCommandGroup val$commands;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sessionCommandGroup};
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
                        this.val$commands = sessionCommandGroup;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onAllowedCommandsChanged(i, this.val$commands);
                        }
                    }
                });
                return;
            }
            this.mSessionLegacyStub.getConnectedControllersManager().updateAllowedCommands(controllerInfo, sessionCommandGroup);
        }
    }

    private ListenableFuture<SessionResult> dispatchRemoteControllerTask(MediaSession.ControllerInfo controllerInfo, RemoteControllerTask remoteControllerTask) {
        InterceptResult invokeLL;
        SequencedFutureManager.SequencedFuture sequencedFuture;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, controllerInfo, remoteControllerTask)) == null) {
            try {
                SequencedFutureManager sequencedFutureManager = this.mSessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
                int i = 0;
                if (sequencedFutureManager != null) {
                    SequencedFutureManager.SequencedFuture createSequencedFuture = sequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
                    i = createSequencedFuture.getSequenceNumber();
                    sequencedFuture = createSequencedFuture;
                } else if (!isConnected(controllerInfo)) {
                    return SessionResult.createFutureWithResult(-100);
                } else {
                    sequencedFuture = SessionResult.createFutureWithResult(0);
                }
                remoteControllerTask.run(controllerInfo.getControllerCb(), i);
                return sequencedFuture;
            } catch (DeadObjectException e) {
                onDeadObjectException(controllerInfo, e);
                return SessionResult.createFutureWithResult(-100);
            } catch (RemoteException e2) {
                Log.w(TAG, "Exception in " + controllerInfo.toString(), e2);
                return SessionResult.createFutureWithResult(-1);
            }
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    public void dispatchRemoteControllerTaskWithoutReturn(MediaSession.ControllerInfo controllerInfo, RemoteControllerTask remoteControllerTask) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, controllerInfo, remoteControllerTask) == null) {
            try {
                SequencedFutureManager sequencedFutureManager = this.mSessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
                if (sequencedFutureManager != null) {
                    i = sequencedFutureManager.obtainNextSequenceNumber();
                } else if (!isConnected(controllerInfo)) {
                    if (DEBUG) {
                        Log.d(TAG, "Skipping dispatching task to disconnected controller, controller=" + controllerInfo);
                        return;
                    }
                    return;
                } else {
                    i = 0;
                }
                remoteControllerTask.run(controllerInfo.getControllerCb(), i);
            } catch (DeadObjectException e) {
                onDeadObjectException(controllerInfo, e);
            } catch (RemoteException e2) {
                Log.w(TAG, "Exception in " + controllerInfo.toString(), e2);
            }
        }
    }

    private MediaItem getCurrentMediaItemOrNull() {
        InterceptResult invokeV;
        SessionPlayer sessionPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            synchronized (this.mLock) {
                sessionPlayer = this.mPlayer;
            }
            if (sessionPlayer != null) {
                return sessionPlayer.getCurrentMediaItem();
            }
            return null;
        }
        return (MediaItem) invokeV.objValue;
    }

    private List<MediaItem> getPlaylistOrNull() {
        InterceptResult invokeV;
        SessionPlayer sessionPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            synchronized (this.mLock) {
                sessionPlayer = this.mPlayer;
            }
            if (sessionPlayer != null) {
                return sessionPlayer.getPlaylist();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getBufferedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ((Long) dispatchPlayerTask(new PlayerTask<Long>(this) { // from class: androidx.media2.session.MediaSessionImplBase.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public Long run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        if (this.this$0.isInPlaybackState(sessionPlayer)) {
                            return Long.valueOf(sessionPlayer.getBufferedPosition());
                        }
                        return null;
                    }
                    return (Long) invokeL.objValue;
                }
            }, Long.MIN_VALUE)).longValue();
        }
        return invokeV.longValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public int getBufferingState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>(this) { // from class: androidx.media2.session.MediaSessionImplBase.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public Integer run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return Integer.valueOf(sessionPlayer.getBufferingState());
                    }
                    return (Integer) invokeL.objValue;
                }
            }, 0)).intValue();
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaSession.SessionCallback getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mCallback;
        }
        return (MediaSession.SessionCallback) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public Executor getCallbackExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mCallbackExecutor;
        }
        return (Executor) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public MediaItem getCurrentMediaItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return (MediaItem) dispatchPlayerTask(new PlayerTask<MediaItem>(this) { // from class: androidx.media2.session.MediaSessionImplBase.29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public MediaItem run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.getCurrentMediaItem();
                    }
                    return (MediaItem) invokeL.objValue;
                }
            }, null);
        }
        return (MediaItem) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getCurrentMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>(this) { // from class: androidx.media2.session.MediaSessionImplBase.30
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public Integer run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return Integer.valueOf(sessionPlayer.getCurrentMediaItemIndex());
                    }
                    return (Integer) invokeL.objValue;
                }
            }, -1)).intValue();
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return ((Long) dispatchPlayerTask(new PlayerTask<Long>(this) { // from class: androidx.media2.session.MediaSessionImplBase.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public Long run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        if (this.this$0.isInPlaybackState(sessionPlayer)) {
                            return Long.valueOf(sessionPlayer.getCurrentPosition());
                        }
                        return null;
                    }
                    return (Long) invokeL.objValue;
                }
            }, Long.MIN_VALUE)).longValue();
        }
        return invokeV.longValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return ((Long) dispatchPlayerTask(new PlayerTask<Long>(this) { // from class: androidx.media2.session.MediaSessionImplBase.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public Long run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        if (this.this$0.isInPlaybackState(sessionPlayer)) {
                            return Long.valueOf(sessionPlayer.getDuration());
                        }
                        return null;
                    }
                    return (Long) invokeL.objValue;
                }
            }, Long.MIN_VALUE)).longValue();
        }
        return invokeV.longValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mSessionId;
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaSession getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mInstance;
        }
        return (MediaSession) invokeV.objValue;
    }

    public MediaBrowserServiceCompat getLegacyBrowserService() {
        InterceptResult invokeV;
        MediaBrowserServiceCompat mediaBrowserServiceCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this.mLock) {
                mediaBrowserServiceCompat = this.mBrowserServiceLegacyStub;
            }
            return mediaBrowserServiceCompat;
        }
        return (MediaBrowserServiceCompat) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getNextMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>(this) { // from class: androidx.media2.session.MediaSessionImplBase.32
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public Integer run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return Integer.valueOf(sessionPlayer.getNextMediaItemIndex());
                    }
                    return (Integer) invokeL.objValue;
                }
            }, -1)).intValue();
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaController.PlaybackInfo getPlaybackInfo() {
        InterceptResult invokeV;
        MediaController.PlaybackInfo playbackInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            synchronized (this.mLock) {
                playbackInfo = this.mPlaybackInfo;
            }
            return playbackInfo;
        }
        return (MediaController.PlaybackInfo) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public float getPlaybackSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return ((Float) dispatchPlayerTask(new PlayerTask<Float>(this) { // from class: androidx.media2.session.MediaSessionImplBase.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public Float run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        if (this.this$0.isInPlaybackState(sessionPlayer)) {
                            return Float.valueOf(sessionPlayer.getPlaybackSpeed());
                        }
                        return null;
                    }
                    return (Float) invokeL.objValue;
                }
            }, Float.valueOf(1.0f))).floatValue();
        }
        return invokeV.floatValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public SessionPlayer getPlayer() {
        InterceptResult invokeV;
        SessionPlayer sessionPlayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            synchronized (this.mLock) {
                sessionPlayer = this.mPlayer;
            }
            return sessionPlayer;
        }
        return (SessionPlayer) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public int getPlayerState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>(this) { // from class: androidx.media2.session.MediaSessionImplBase.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public Integer run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return Integer.valueOf(sessionPlayer.getPlayerState());
                    }
                    return (Integer) invokeL.objValue;
                }
            }, 3)).intValue();
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public List<MediaItem> getPlaylist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return (List) dispatchPlayerTask(new PlayerTask<List<MediaItem>>(this) { // from class: androidx.media2.session.MediaSessionImplBase.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public List<MediaItem> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sessionPlayer)) == null) {
                        return sessionPlayer.getPlaylist();
                    }
                    return (List) invokeL.objValue;
                }
            }, null);
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public MediaMetadata getPlaylistMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return (MediaMetadata) dispatchPlayerTask(new PlayerTask<MediaMetadata>(this) { // from class: androidx.media2.session.MediaSessionImplBase.24
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public MediaMetadata run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.getPlaylistMetadata();
                    }
                    return (MediaMetadata) invokeL.objValue;
                }
            }, null);
        }
        return (MediaMetadata) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getPreviousMediaItemIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>(this) { // from class: androidx.media2.session.MediaSessionImplBase.31
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public Integer run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return Integer.valueOf(sessionPlayer.getPreviousMediaItemIndex());
                    }
                    return (Integer) invokeL.objValue;
                }
            }, -1)).intValue();
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getRepeatMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>(this) { // from class: androidx.media2.session.MediaSessionImplBase.34
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public Integer run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return Integer.valueOf(sessionPlayer.getRepeatMode());
                    }
                    return (Integer) invokeL.objValue;
                }
            }, 0)).intValue();
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public PendingIntent getSessionActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mSessionActivity;
        }
        return (PendingIntent) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public MediaSessionCompat getSessionCompat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mSessionCompat;
        }
        return (MediaSessionCompat) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public int getShuffleMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return ((Integer) dispatchPlayerTask(new PlayerTask<Integer>(this) { // from class: androidx.media2.session.MediaSessionImplBase.36
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public Integer run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return Integer.valueOf(sessionPlayer.getShuffleMode());
                    }
                    return (Integer) invokeL.objValue;
                }
            }, 0)).intValue();
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public SessionToken getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mSessionToken;
        }
        return (SessionToken) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public List<SessionPlayer.TrackInfo> getTracks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return (List) dispatchPlayerTask(new PlayerTask<List<SessionPlayer.TrackInfo>>(this) { // from class: androidx.media2.session.MediaSessionImplBase.40
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public List<SessionPlayer.TrackInfo> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sessionPlayer)) == null) {
                        return MediaUtils.upcastForPreparceling(sessionPlayer.getTracks());
                    }
                    return (List) invokeL.objValue;
                }
            }, null);
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.mSessionUri;
        }
        return (Uri) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlayer
    public VideoSize getVideoSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return (VideoSize) dispatchPlayerTask(new PlayerTask<VideoSize>(this) { // from class: androidx.media2.session.MediaSessionImplBase.38
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public VideoSize run(SessionPlayer sessionPlayer) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return MediaUtils.upcastForPreparceling(sessionPlayer.getVideoSize());
                    }
                    return (VideoSize) invokeL.objValue;
                }
            }, new VideoSize(0, 0));
        }
        return (VideoSize) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return !this.mHandlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this) { // from class: androidx.media2.session.MediaSessionImplBase.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.pause();
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> play() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this) { // from class: androidx.media2.session.MediaSessionImplBase.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        if (sessionPlayer.getPlayerState() != 0) {
                            return sessionPlayer.play();
                        }
                        ListenableFuture<SessionPlayer.PlayerResult> prepare = sessionPlayer.prepare();
                        ListenableFuture<SessionPlayer.PlayerResult> play = sessionPlayer.play();
                        if (prepare != null && play != null) {
                            return CombinedCommandResultFuture.create(MediaUtils.DIRECT_EXECUTOR, prepare, play);
                        }
                        return null;
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaybackControl
    public ListenableFuture<SessionPlayer.PlayerResult> prepare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this) { // from class: androidx.media2.session.MediaSessionImplBase.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.prepare();
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> skipToNextItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this) { // from class: androidx.media2.session.MediaSessionImplBase.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.skipToNextPlaylistItem();
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
        return (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> skipToPreviousItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this) { // from class: androidx.media2.session.MediaSessionImplBase.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;

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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                        return sessionPlayer.skipToPreviousPlaylistItem();
                    }
                    return (ListenableFuture) invokeL.objValue;
                }
            });
        }
        return (ListenableFuture) invokeV.objValue;
    }

    private ComponentName getServiceComponentByAction(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            PackageManager packageManager = this.mContext.getPackageManager();
            Intent intent = new Intent(str);
            intent.setPackage(this.mContext.getPackageName());
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                return new ComponentName(serviceInfo.packageName, serviceInfo.name);
            }
            return null;
        }
        return (ComponentName) invokeL.objValue;
    }

    private void notifyPlayerUpdatedNotLocked(SessionPlayer sessionPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, sessionPlayer) == null) {
            List<MediaItem> playlist = sessionPlayer.getPlaylist();
            List<MediaItem> playlistOrNull = getPlaylistOrNull();
            if (!ObjectsCompat.equals(playlist, playlistOrNull)) {
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, playlistOrNull) { // from class: androidx.media2.session.MediaSessionImplBase.44
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
                    public final /* synthetic */ List val$newPlaylist;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, playlistOrNull};
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
                        this.val$newPlaylist = playlistOrNull;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onPlaylistChanged(i, this.val$newPlaylist, this.this$0.getPlaylistMetadata(), this.this$0.getCurrentMediaItemIndex(), this.this$0.getPreviousMediaItemIndex(), this.this$0.getNextMediaItemIndex());
                        }
                    }
                });
            } else {
                MediaMetadata playlistMetadata = sessionPlayer.getPlaylistMetadata();
                MediaMetadata playlistMetadata2 = getPlaylistMetadata();
                if (!ObjectsCompat.equals(playlistMetadata, playlistMetadata2)) {
                    dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, playlistMetadata2) { // from class: androidx.media2.session.MediaSessionImplBase.45
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaSessionImplBase this$0;
                        public final /* synthetic */ MediaMetadata val$newMetadata;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, playlistMetadata2};
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
                            this.val$newMetadata = playlistMetadata2;
                        }

                        @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                        public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                                controllerCb.onPlaylistMetadataChanged(i, this.val$newMetadata);
                            }
                        }
                    });
                }
            }
            MediaItem currentMediaItem = sessionPlayer.getCurrentMediaItem();
            MediaItem currentMediaItemOrNull = getCurrentMediaItemOrNull();
            if (!ObjectsCompat.equals(currentMediaItem, currentMediaItemOrNull)) {
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, currentMediaItemOrNull) { // from class: androidx.media2.session.MediaSessionImplBase.46
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
                    public final /* synthetic */ MediaItem val$newCurrentItem;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, currentMediaItemOrNull};
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
                        this.val$newCurrentItem = currentMediaItemOrNull;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onCurrentMediaItemChanged(i, this.val$newCurrentItem, this.this$0.getCurrentMediaItemIndex(), this.this$0.getPreviousMediaItemIndex(), this.this$0.getNextMediaItemIndex());
                        }
                    }
                });
            }
            int repeatMode = getRepeatMode();
            if (sessionPlayer.getRepeatMode() != repeatMode) {
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, repeatMode) { // from class: androidx.media2.session.MediaSessionImplBase.47
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
                    public final /* synthetic */ int val$repeatMode;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(repeatMode)};
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
                        this.val$repeatMode = repeatMode;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onRepeatModeChanged(i, this.val$repeatMode, this.this$0.getCurrentMediaItemIndex(), this.this$0.getPreviousMediaItemIndex(), this.this$0.getNextMediaItemIndex());
                        }
                    }
                });
            }
            int shuffleMode = getShuffleMode();
            if (sessionPlayer.getShuffleMode() != shuffleMode) {
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, shuffleMode) { // from class: androidx.media2.session.MediaSessionImplBase.48
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
                    public final /* synthetic */ int val$shuffleMode;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(shuffleMode)};
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
                        this.val$shuffleMode = shuffleMode;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onShuffleModeChanged(i, this.val$shuffleMode, this.this$0.getCurrentMediaItemIndex(), this.this$0.getPreviousMediaItemIndex(), this.this$0.getNextMediaItemIndex());
                        }
                    }
                });
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long currentPosition = getCurrentPosition();
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, elapsedRealtime, currentPosition, getPlayerState()) { // from class: androidx.media2.session.MediaSessionImplBase.49
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
                public final /* synthetic */ long val$currentTimeMs;
                public final /* synthetic */ int val$playerState;
                public final /* synthetic */ long val$positionMs;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(elapsedRealtime), Long.valueOf(currentPosition), Integer.valueOf(r11)};
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
                    this.val$currentTimeMs = elapsedRealtime;
                    this.val$positionMs = currentPosition;
                    this.val$playerState = r11;
                }

                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                        controllerCb.onPlayerStateChanged(i, this.val$currentTimeMs, this.val$positionMs, this.val$playerState);
                    }
                }
            });
            MediaItem currentMediaItemOrNull2 = getCurrentMediaItemOrNull();
            if (currentMediaItemOrNull2 != null) {
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, currentMediaItemOrNull2, getBufferingState(), getBufferedPosition()) { // from class: androidx.media2.session.MediaSessionImplBase.50
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
                    public final /* synthetic */ long val$bufferedPositionMs;
                    public final /* synthetic */ int val$bufferingState;
                    public final /* synthetic */ MediaItem val$item;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, currentMediaItemOrNull2, Integer.valueOf(r8), Long.valueOf(r9)};
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
                        this.val$item = currentMediaItemOrNull2;
                        this.val$bufferingState = r8;
                        this.val$bufferedPositionMs = r9;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onBufferingStateChanged(i, this.val$item, this.val$bufferingState, this.val$bufferedPositionMs, SystemClock.elapsedRealtime(), this.this$0.getCurrentPosition());
                        }
                    }
                });
            }
            float playbackSpeed = getPlaybackSpeed();
            if (playbackSpeed != sessionPlayer.getPlaybackSpeed()) {
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, elapsedRealtime, currentPosition, playbackSpeed) { // from class: androidx.media2.session.MediaSessionImplBase.51
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
                    public final /* synthetic */ long val$currentTimeMs;
                    public final /* synthetic */ long val$positionMs;
                    public final /* synthetic */ float val$speed;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(elapsedRealtime), Long.valueOf(currentPosition), Float.valueOf(playbackSpeed)};
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
                        this.val$currentTimeMs = elapsedRealtime;
                        this.val$positionMs = currentPosition;
                        this.val$speed = playbackSpeed;
                    }

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onPlaybackSpeedChanged(i, this.val$currentTimeMs, this.val$positionMs, this.val$speed);
                        }
                    }
                });
            }
        }
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> addPlaylistItem(int i, MediaItem mediaItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, mediaItem)) == null) {
            if (i >= 0) {
                if (mediaItem != null) {
                    return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, i, mediaItem) { // from class: androidx.media2.session.MediaSessionImplBase.25
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaSessionImplBase this$0;
                        public final /* synthetic */ int val$index;
                        public final /* synthetic */ MediaItem val$item;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i), mediaItem};
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
                            this.val$item = mediaItem;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                        public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                                return sessionPlayer.addPlaylistItem(this.val$index, this.val$item);
                            }
                            return (ListenableFuture) invokeL.objValue;
                        }
                    });
                }
                throw new NullPointerException("item shouldn't be null");
            }
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        return (ListenableFuture) invokeIL.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void broadcastCustomCommand(SessionCommand sessionCommand, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sessionCommand, bundle) == null) {
            dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this, sessionCommand, bundle) { // from class: androidx.media2.session.MediaSessionImplBase.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
                public final /* synthetic */ Bundle val$args;
                public final /* synthetic */ SessionCommand val$command;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sessionCommand, bundle};
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
                }

                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                        controllerCb.sendCustomCommand(i, this.val$command, this.val$args);
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> movePlaylistItem(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048620, this, i, i2)) == null) {
            if (i >= 0 && i2 >= 0) {
                return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, i, i2) { // from class: androidx.media2.session.MediaSessionImplBase.28
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
                    public final /* synthetic */ int val$fromIndex;
                    public final /* synthetic */ int val$toIndex;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2)};
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
                        this.val$fromIndex = i;
                        this.val$toIndex = i2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                    public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                            return sessionPlayer.movePlaylistItem(this.val$fromIndex, this.val$toIndex);
                        }
                        return (ListenableFuture) invokeL.objValue;
                    }
                });
            }
            throw new IllegalArgumentException("indices shouldn't be negative");
        }
        return (ListenableFuture) invokeII.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> replacePlaylistItem(int i, MediaItem mediaItem) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048626, this, i, mediaItem)) == null) {
            if (i >= 0) {
                if (mediaItem != null) {
                    return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, i, mediaItem) { // from class: androidx.media2.session.MediaSessionImplBase.27
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaSessionImplBase this$0;
                        public final /* synthetic */ int val$index;
                        public final /* synthetic */ MediaItem val$item;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i), mediaItem};
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
                            this.val$item = mediaItem;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                        public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                                return sessionPlayer.replacePlaylistItem(this.val$index, this.val$item);
                            }
                            return (ListenableFuture) invokeL.objValue;
                        }
                    });
                }
                throw new NullPointerException("item shouldn't be null");
            }
            throw new IllegalArgumentException("index shouldn't be negative");
        }
        return (ListenableFuture) invokeIL.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public ListenableFuture<SessionResult> setCustomLayout(MediaSession.ControllerInfo controllerInfo, List<MediaSession.CommandButton> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048631, this, controllerInfo, list)) == null) {
            return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask(this, list) { // from class: androidx.media2.session.MediaSessionImplBase.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
                public final /* synthetic */ List val$layout;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list};
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
                    this.val$layout = list;
                }

                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                        controllerCb.setCustomLayout(i, this.val$layout);
                    }
                }
            });
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaInterface.SessionPlaylistControl
    public ListenableFuture<SessionPlayer.PlayerResult> setPlaylist(List<MediaItem> list, MediaMetadata mediaMetadata) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048635, this, list, mediaMetadata)) == null) {
            if (list != null) {
                return dispatchPlayerTask(new PlayerTask<ListenableFuture<SessionPlayer.PlayerResult>>(this, list, mediaMetadata) { // from class: androidx.media2.session.MediaSessionImplBase.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;
                    public final /* synthetic */ List val$list;
                    public final /* synthetic */ MediaMetadata val$metadata;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, list, mediaMetadata};
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
                        this.val$list = list;
                        this.val$metadata = mediaMetadata;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.media2.session.MediaSessionImplBase.PlayerTask
                    public ListenableFuture<SessionPlayer.PlayerResult> run(SessionPlayer sessionPlayer) throws Exception {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, sessionPlayer)) == null) {
                            return sessionPlayer.setPlaylist(this.val$list, this.val$metadata);
                        }
                        return (ListenableFuture) invokeL.objValue;
                    }
                });
            }
            throw new NullPointerException("list shouldn't be null");
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.mLock) {
                if (isClosed()) {
                    return;
                }
                if (DEBUG) {
                    Log.d(TAG, "Closing session, id=" + getId() + ", token=" + getToken());
                }
                this.mPlayer.unregisterPlayerCallback(this.mPlayerCallback);
                this.mSessionCompat.release();
                this.mMediaButtonIntent.cancel();
                if (this.mBroadcastReceiver != null) {
                    this.mContext.unregisterReceiver(this.mBroadcastReceiver);
                }
                this.mCallback.onSessionClosed(this.mInstance);
                dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask(this) { // from class: androidx.media2.session.MediaSessionImplBase.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaSessionImplBase this$0;

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

                    @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                    public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                            controllerCb.onDisconnected(i);
                        }
                    }
                });
                this.mHandler.removeCallbacksAndMessages(null);
                if (this.mHandlerThread.isAlive()) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        this.mHandlerThread.quitSafely();
                    } else {
                        this.mHandlerThread.quit();
                    }
                }
            }
        }
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void connectFromService(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{iMediaController, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), bundle}) == null) {
            this.mSessionStub.connect(iMediaController, i, str, i2, i3, bundle);
        }
    }

    public MediaBrowserServiceCompat createLegacyBrowserService(Context context, SessionToken sessionToken, MediaSessionCompat.Token token) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, sessionToken, token)) == null) {
            return new MediaSessionServiceLegacyStub(context, this, token);
        }
        return (MediaBrowserServiceCompat) invokeLLL.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public ListenableFuture<SessionResult> sendCustomCommand(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048629, this, controllerInfo, sessionCommand, bundle)) == null) {
            return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask(this, sessionCommand, bundle) { // from class: androidx.media2.session.MediaSessionImplBase.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaSessionImplBase this$0;
                public final /* synthetic */ Bundle val$args;
                public final /* synthetic */ SessionCommand val$command;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sessionCommand, bundle};
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
                }

                @Override // androidx.media2.session.MediaSessionImplBase.RemoteControllerTask
                public void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, controllerCb, i) == null) {
                        controllerCb.sendCustomCommand(i, this.val$command, this.val$args);
                    }
                }
            });
        }
        return (ListenableFuture) invokeLLL.objValue;
    }

    public MediaController.PlaybackInfo createPlaybackInfo(SessionPlayer sessionPlayer, AudioAttributesCompat audioAttributesCompat) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, sessionPlayer, audioAttributesCompat)) == null) {
            if (audioAttributesCompat == null) {
                audioAttributesCompat = sessionPlayer.getAudioAttributes();
            }
            int i = 2;
            if (!(sessionPlayer instanceof RemoteSessionPlayer)) {
                int legacyStreamType = getLegacyStreamType(audioAttributesCompat);
                if (Build.VERSION.SDK_INT >= 21 && this.mAudioManager.isVolumeFixed()) {
                    i = 0;
                }
                return MediaController.PlaybackInfo.createPlaybackInfo(1, audioAttributesCompat, i, this.mAudioManager.getStreamMaxVolume(legacyStreamType), this.mAudioManager.getStreamVolume(legacyStreamType));
            }
            RemoteSessionPlayer remoteSessionPlayer = (RemoteSessionPlayer) sessionPlayer;
            return MediaController.PlaybackInfo.createPlaybackInfo(2, audioAttributesCompat, remoteSessionPlayer.getVolumeControlType(), remoteSessionPlayer.getMaxVolume(), remoteSessionPlayer.getVolume());
        }
        return (MediaController.PlaybackInfo) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public PlaybackStateCompat createPlaybackStateCompat() {
        InterceptResult invokeV;
        PlaybackStateCompat build;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.mLock) {
                build = new PlaybackStateCompat.Builder().setState(MediaUtils.convertToPlaybackStateCompatState(getPlayerState(), getBufferingState()), getCurrentPosition(), getPlaybackSpeed(), SystemClock.elapsedRealtime()).setActions(3670015L).setBufferedPosition(getBufferedPosition()).build();
            }
            return build;
        }
        return (PlaybackStateCompat) invokeV.objValue;
    }

    public void dispatchRemoteControllerTaskWithoutReturn(RemoteControllerTask remoteControllerTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, remoteControllerTask) == null) {
            List<MediaSession.ControllerInfo> connectedControllers = this.mSessionStub.getConnectedControllersManager().getConnectedControllers();
            for (int i = 0; i < connectedControllers.size(); i++) {
                dispatchRemoteControllerTaskWithoutReturn(connectedControllers.get(i), remoteControllerTask);
            }
            try {
                remoteControllerTask.run(this.mSessionLegacyStub.getControllerLegacyCbForBroadcast(), 0);
            } catch (RemoteException e) {
                Log.e(TAG, "Exception in using media1 API", e);
            }
        }
    }

    @Override // androidx.media2.session.MediaSession.MediaSessionImpl
    public void updatePlayer(SessionPlayer sessionPlayer) {
        boolean z;
        SessionPlayer sessionPlayer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, sessionPlayer) == null) {
            VolumeProviderCompat volumeProviderCompat = null;
            MediaController.PlaybackInfo createPlaybackInfo = createPlaybackInfo(sessionPlayer, null);
            boolean z2 = sessionPlayer instanceof RemoteSessionPlayer;
            if (z2) {
                volumeProviderCompat = createVolumeProviderCompat((RemoteSessionPlayer) sessionPlayer);
            }
            synchronized (this.mLock) {
                if (!createPlaybackInfo.equals(this.mPlaybackInfo)) {
                    z = true;
                } else {
                    z = false;
                }
                sessionPlayer2 = this.mPlayer;
                this.mPlayer = sessionPlayer;
                this.mPlaybackInfo = createPlaybackInfo;
                this.mVolumeProviderCompat = volumeProviderCompat;
                if (sessionPlayer2 != sessionPlayer) {
                    if (sessionPlayer2 != null) {
                        sessionPlayer2.unregisterPlayerCallback(this.mPlayerCallback);
                    }
                    this.mPlayer.registerPlayerCallback(this.mCallbackExecutor, this.mPlayerCallback);
                }
            }
            if (sessionPlayer2 == null) {
                this.mSessionCompat.setPlaybackState(createPlaybackStateCompat());
            } else {
                if (sessionPlayer != sessionPlayer2) {
                    this.mCallbackExecutor.execute(new Runnable(this, getPlayerState()) { // from class: androidx.media2.session.MediaSessionImplBase.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaSessionImplBase this$0;
                        public final /* synthetic */ int val$state;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(r7)};
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
                            this.val$state = r7;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                MediaSessionImplBase mediaSessionImplBase = this.this$0;
                                mediaSessionImplBase.mCallback.onPlayerStateChanged(mediaSessionImplBase.getInstance(), this.val$state);
                            }
                        }
                    });
                    notifyPlayerUpdatedNotLocked(sessionPlayer2);
                }
                if (z) {
                    notifyPlaybackInfoChangedNotLocked(createPlaybackInfo);
                }
            }
            if (z2) {
                this.mSessionCompat.setPlaybackToRemote(volumeProviderCompat);
                return;
            }
            this.mSessionCompat.setPlaybackToLocal(getLegacyStreamType(sessionPlayer.getAudioAttributes()));
        }
    }
}

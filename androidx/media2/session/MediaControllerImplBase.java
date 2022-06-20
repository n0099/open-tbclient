package androidx.media2.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.SubtitleData;
import androidx.media2.common.VideoSize;
import androidx.media2.session.IMediaSession;
import androidx.media2.session.IMediaSessionService;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaSession;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class MediaControllerImplBase implements MediaController.MediaControllerImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final SessionResult RESULT_WHEN_CLOSED;
    public static final String TAG = "MC2ImplBase";
    public static final boolean THROW_EXCEPTION_FOR_NULL_RESULT = true;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("mLock")
    public SessionCommandGroup mAllowedCommands;
    @GuardedBy("mLock")
    public long mBufferedPositionMs;
    @GuardedBy("mLock")
    public int mBufferingState;
    @GuardedBy("mLock")
    public SessionToken mConnectedToken;
    public final Context mContext;
    public final MediaControllerStub mControllerStub;
    @GuardedBy("mLock")
    public MediaItem mCurrentMediaItem;
    @GuardedBy("mLock")
    public int mCurrentMediaItemIndex;
    public final IBinder.DeathRecipient mDeathRecipient;
    @GuardedBy("mLock")
    public volatile IMediaSession mISession;
    public final MediaController mInstance;
    @GuardedBy("mLock")
    public boolean mIsReleased;
    public final Object mLock;
    @GuardedBy("mLock")
    public int mNextMediaItemIndex;
    @GuardedBy("mLock")
    public MediaController.PlaybackInfo mPlaybackInfo;
    @GuardedBy("mLock")
    public float mPlaybackSpeed;
    @GuardedBy("mLock")
    public int mPlayerState;
    @GuardedBy("mLock")
    public List<MediaItem> mPlaylist;
    @GuardedBy("mLock")
    public MediaMetadata mPlaylistMetadata;
    @GuardedBy("mLock")
    public long mPositionEventTimeMs;
    @GuardedBy("mLock")
    public long mPositionMs;
    @GuardedBy("mLock")
    public int mPreviousMediaItemIndex;
    @GuardedBy("mLock")
    public int mRepeatMode;
    @GuardedBy("mLock")
    public SparseArray<SessionPlayer.TrackInfo> mSelectedTracks;
    public final SequencedFutureManager mSequencedFutureManager;
    @GuardedBy("mLock")
    public SessionServiceConnection mServiceConnection;
    @GuardedBy("mLock")
    public PendingIntent mSessionActivity;
    @GuardedBy("mLock")
    public int mShuffleMode;
    public final SessionToken mToken;
    @GuardedBy("mLock")
    public List<SessionPlayer.TrackInfo> mTracks;
    @GuardedBy("mLock")
    public VideoSize mVideoSize;

    @FunctionalInterface
    /* loaded from: classes.dex */
    public interface RemoteSessionTask {
        void run(IMediaSession iMediaSession, int i) throws RemoteException;
    }

    /* loaded from: classes.dex */
    public class SessionServiceConnection implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle mConnectionHints;
        public final /* synthetic */ MediaControllerImplBase this$0;

        public SessionServiceConnection(@Nullable MediaControllerImplBase mediaControllerImplBase, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaControllerImplBase, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mediaControllerImplBase;
            this.mConnectionHints = bundle;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, componentName) == null) {
                this.this$0.mInstance.close();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName, iBinder) == null) {
                try {
                    if (MediaControllerImplBase.DEBUG) {
                        Log.d(MediaControllerImplBase.TAG, "onServiceConnected " + componentName + " " + this);
                    }
                    if (!this.this$0.mToken.getPackageName().equals(componentName.getPackageName())) {
                        Log.wtf(MediaControllerImplBase.TAG, "Expected connection to " + this.this$0.mToken.getPackageName() + " but is connected to " + componentName);
                        return;
                    }
                    IMediaSessionService asInterface = IMediaSessionService.Stub.asInterface(iBinder);
                    if (asInterface == null) {
                        Log.wtf(MediaControllerImplBase.TAG, "Service interface is missing.");
                        return;
                    }
                    asInterface.connect(this.this$0.mControllerStub, MediaParcelUtils.toParcelable(new ConnectionRequest(this.this$0.getContext().getPackageName(), Process.myPid(), this.mConnectionHints)));
                } catch (RemoteException unused) {
                    Log.w(MediaControllerImplBase.TAG, "Service " + componentName + " has died prematurely");
                } finally {
                    this.this$0.mInstance.close();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
                if (MediaControllerImplBase.DEBUG) {
                    Log.w(MediaControllerImplBase.TAG, "Session service " + componentName + " is disconnected.");
                }
                this.this$0.mInstance.close();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1860728138, "Landroidx/media2/session/MediaControllerImplBase;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1860728138, "Landroidx/media2/session/MediaControllerImplBase;");
                return;
            }
        }
        RESULT_WHEN_CLOSED = new SessionResult(1);
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaControllerImplBase(Context context, MediaController mediaController, SessionToken sessionToken, @Nullable Bundle bundle) {
        boolean requestConnectToService;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mediaController, sessionToken, bundle};
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
        this.mCurrentMediaItemIndex = -1;
        this.mPreviousMediaItemIndex = -1;
        this.mNextMediaItemIndex = -1;
        this.mVideoSize = new VideoSize(0, 0);
        this.mTracks = Collections.emptyList();
        this.mSelectedTracks = new SparseArray<>();
        this.mInstance = mediaController;
        if (context == null) {
            throw new NullPointerException("context shouldn't be null");
        }
        if (sessionToken != null) {
            this.mContext = context;
            this.mSequencedFutureManager = new SequencedFutureManager();
            this.mControllerStub = new MediaControllerStub(this, this.mSequencedFutureManager);
            this.mToken = sessionToken;
            this.mDeathRecipient = new IBinder.DeathRecipient(this) { // from class: androidx.media2.session.MediaControllerImplBase.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mInstance.close();
                    }
                }
            };
            if (this.mToken.getType() == 0) {
                this.mServiceConnection = null;
                requestConnectToService = requestConnectToSession(bundle);
            } else {
                this.mServiceConnection = new SessionServiceConnection(this, bundle);
                requestConnectToService = requestConnectToService();
            }
            if (requestConnectToService) {
                return;
            }
            this.mInstance.close();
            return;
        }
        throw new NullPointerException("token shouldn't be null");
    }

    private ListenableFuture<SessionResult> dispatchRemoteSessionTask(int i, RemoteSessionTask remoteSessionTask) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65538, this, i, remoteSessionTask)) == null) ? dispatchRemoteSessionTaskInternal(i, null, remoteSessionTask) : (ListenableFuture) invokeIL.objValue;
    }

    private ListenableFuture<SessionResult> dispatchRemoteSessionTaskInternal(int i, SessionCommand sessionCommand, RemoteSessionTask remoteSessionTask) {
        InterceptResult invokeILL;
        IMediaSession sessionInterfaceIfAble;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, sessionCommand, remoteSessionTask)) == null) {
            if (sessionCommand != null) {
                sessionInterfaceIfAble = getSessionInterfaceIfAble(sessionCommand);
            } else {
                sessionInterfaceIfAble = getSessionInterfaceIfAble(i);
            }
            if (sessionInterfaceIfAble != null) {
                SequencedFutureManager.SequencedFuture createSequencedFuture = this.mSequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
                try {
                    remoteSessionTask.run(sessionInterfaceIfAble, createSequencedFuture.getSequenceNumber());
                } catch (RemoteException e) {
                    Log.w(TAG, "Cannot connect to the service or the session is gone", e);
                    createSequencedFuture.set(new SessionResult(-100));
                }
                return createSequencedFuture;
            }
            return SessionResult.createFutureWithResult(-4);
        }
        return (ListenableFuture) invokeILL.objValue;
    }

    private boolean requestConnectToService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Intent intent = new Intent(MediaSessionService.SERVICE_INTERFACE);
            intent.setClassName(this.mToken.getPackageName(), this.mToken.getServiceName());
            synchronized (this.mLock) {
                if (!this.mContext.bindService(intent, this.mServiceConnection, 1)) {
                    Log.w(TAG, "bind to " + this.mToken + " failed");
                    return false;
                }
                if (DEBUG) {
                    Log.d(TAG, "bind to " + this.mToken + " succeeded");
                }
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean requestConnectToSession(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, bundle)) == null) {
            try {
                IMediaSession.Stub.asInterface((IBinder) this.mToken.getBinder()).connect(this.mControllerStub, this.mSequencedFutureManager.obtainNextSequenceNumber(), MediaParcelUtils.toParcelable(new ConnectionRequest(this.mContext.getPackageName(), Process.myPid(), bundle)));
                return true;
            } catch (RemoteException e) {
                Log.w(TAG, "Failed to call connection request.", e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> addPlaylistItem(int i, @NonNull String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, str)) == null) ? dispatchRemoteSessionTask(10013, new RemoteSessionTask(this, i, str) { // from class: androidx.media2.session.MediaControllerImplBase.20
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
            public final /* synthetic */ int val$index;
            public final /* synthetic */ String val$mediaId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i), str};
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
                this.val$mediaId = str;
            }

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i2) == null) {
                    iMediaSession.addPlaylistItem(this.this$0.mControllerStub, i2, this.val$index, this.val$mediaId);
                }
            }
        }) : (ListenableFuture) invokeIL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> adjustVolume(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) ? dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_VOLUME_ADJUST_VOLUME, new RemoteSessionTask(this, i, i2) { // from class: androidx.media2.session.MediaControllerImplBase.12
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
            public final /* synthetic */ int val$direction;
            public final /* synthetic */ int val$flags;

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
                this.val$direction = i;
                this.val$flags = i2;
            }

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i3) == null) {
                    iMediaSession.adjustVolume(this.this$0.mControllerStub, i3, this.val$direction, this.val$flags);
                }
            }
        }) : (ListenableFuture) invokeII.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (DEBUG) {
                Log.d(TAG, "release from " + this.mToken);
            }
            synchronized (this.mLock) {
                IMediaSession iMediaSession = this.mISession;
                if (this.mIsReleased) {
                    return;
                }
                this.mIsReleased = true;
                if (this.mServiceConnection != null) {
                    this.mContext.unbindService(this.mServiceConnection);
                    this.mServiceConnection = null;
                }
                this.mISession = null;
                this.mControllerStub.destroy();
                if (iMediaSession != null) {
                    int obtainNextSequenceNumber = this.mSequencedFutureManager.obtainNextSequenceNumber();
                    try {
                        iMediaSession.asBinder().unlinkToDeath(this.mDeathRecipient, 0);
                        iMediaSession.release(this.mControllerStub, obtainNextSequenceNumber);
                    } catch (RemoteException unused) {
                    }
                }
                this.mSequencedFutureManager.close();
                this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this) { // from class: androidx.media2.session.MediaControllerImplBase.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaControllerImplBase this$0;

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

                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                    public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                            controllerCallback.onDisconnected(this.this$0.mInstance);
                        }
                    }
                });
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public ListenableFuture<SessionResult> deselectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, trackInfo)) == null) ? dispatchRemoteSessionTask(11002, new RemoteSessionTask(this, trackInfo) { // from class: androidx.media2.session.MediaControllerImplBase.30
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.deselectTrack(this.this$0.mControllerStub, i, MediaParcelUtils.toParcelable(this.val$trackInfo));
                }
            }
        }) : (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> fastForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_FAST_FORWARD, new RemoteSessionTask(this) { // from class: androidx.media2.session.MediaControllerImplBase.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;

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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.fastForward(this.this$0.mControllerStub, i);
                }
            }
        }) : (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public SessionCommandGroup getAllowedCommands() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.mLock) {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return null;
                }
                return this.mAllowedCommands;
            }
        }
        return (SessionCommandGroup) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public MediaBrowserCompat getBrowserCompat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (MediaBrowserCompat) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getBufferedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.mLock) {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return Long.MIN_VALUE;
                }
                return this.mBufferedPositionMs;
            }
        }
        return invokeV.longValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getBufferingState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.mLock) {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0;
                }
                return this.mBufferingState;
            }
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public SessionToken getConnectedToken() {
        InterceptResult invokeV;
        SessionToken sessionToken;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this.mLock) {
                sessionToken = isConnected() ? this.mConnectedToken : null;
            }
            return sessionToken;
        }
        return (SessionToken) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public MediaItem getCurrentMediaItem() {
        InterceptResult invokeV;
        MediaItem mediaItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this.mLock) {
                mediaItem = this.mCurrentMediaItem;
            }
            return mediaItem;
        }
        return (MediaItem) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getCurrentMediaItemIndex() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this.mLock) {
                i = this.mCurrentMediaItemIndex;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this.mLock) {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return Long.MIN_VALUE;
                } else if (this.mPlayerState == 2 && this.mBufferingState != 2) {
                    return Math.max(0L, this.mPositionMs + (this.mPlaybackSpeed * ((float) (this.mInstance.mTimeDiff != null ? this.mInstance.mTimeDiff.longValue() : SystemClock.elapsedRealtime() - this.mPositionEventTimeMs))));
                } else {
                    return this.mPositionMs;
                }
            }
        }
        return invokeV.longValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this.mLock) {
                MediaMetadata metadata = this.mCurrentMediaItem == null ? null : this.mCurrentMediaItem.getMetadata();
                if (metadata == null || !metadata.containsKey("android.media.metadata.DURATION")) {
                    return Long.MIN_VALUE;
                }
                return metadata.getLong("android.media.metadata.DURATION");
            }
        }
        return invokeV.longValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getNextMediaItemIndex() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            synchronized (this.mLock) {
                i = this.mNextMediaItemIndex;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public MediaController.PlaybackInfo getPlaybackInfo() {
        InterceptResult invokeV;
        MediaController.PlaybackInfo playbackInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this.mLock) {
                playbackInfo = this.mPlaybackInfo;
            }
            return playbackInfo;
        }
        return (MediaController.PlaybackInfo) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public float getPlaybackSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            synchronized (this.mLock) {
                if (this.mISession == null) {
                    Log.w(TAG, "Session isn't active", new IllegalStateException());
                    return 0.0f;
                }
                return this.mPlaybackSpeed;
            }
        }
        return invokeV.floatValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPlayerState() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this.mLock) {
                i = this.mPlayerState;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public List<MediaItem> getPlaylist() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this.mLock) {
                arrayList = new ArrayList(this.mPlaylist);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public MediaMetadata getPlaylistMetadata() {
        InterceptResult invokeV;
        MediaMetadata mediaMetadata;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            synchronized (this.mLock) {
                mediaMetadata = this.mPlaylistMetadata;
            }
            return mediaMetadata;
        }
        return (MediaMetadata) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getPreviousMediaItemIndex() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (this.mLock) {
                i = this.mPreviousMediaItemIndex;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getRepeatMode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this.mLock) {
                i = this.mRepeatMode;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @Nullable
    public SessionPlayer.TrackInfo getSelectedTrack(int i) {
        InterceptResult invokeI;
        SessionPlayer.TrackInfo trackInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            synchronized (this.mLock) {
                trackInfo = this.mSelectedTracks.get(i);
            }
            return trackInfo;
        }
        return (SessionPlayer.TrackInfo) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public PendingIntent getSessionActivity() {
        InterceptResult invokeV;
        PendingIntent pendingIntent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            synchronized (this.mLock) {
                pendingIntent = this.mSessionActivity;
            }
            return pendingIntent;
        }
        return (PendingIntent) invokeV.objValue;
    }

    public IMediaSession getSessionInterfaceIfAble(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            synchronized (this.mLock) {
                if (!this.mAllowedCommands.hasCommand(i)) {
                    Log.w(TAG, "Controller isn't allowed to call command, commandCode=" + i);
                    return null;
                }
                return this.mISession;
            }
        }
        return (IMediaSession) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public int getShuffleMode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            synchronized (this.mLock) {
                i = this.mShuffleMode;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public List<SessionPlayer.TrackInfo> getTracks() {
        InterceptResult invokeV;
        List<SessionPlayer.TrackInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            synchronized (this.mLock) {
                list = this.mTracks;
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public VideoSize getVideoSize() {
        InterceptResult invokeV;
        VideoSize videoSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            synchronized (this.mLock) {
                videoSize = this.mVideoSize;
            }
            return videoSize;
        }
        return (VideoSize) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public boolean isConnected() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            synchronized (this.mLock) {
                z = this.mISession != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> movePlaylistItem(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048607, this, i, i2)) == null) ? dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_MOVE_PLAYLIST_ITEM, new RemoteSessionTask(this, i, i2) { // from class: androidx.media2.session.MediaControllerImplBase.23
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i3) == null) {
                    iMediaSession.movePlaylistItem(this.this$0.mControllerStub, i3, this.val$fromIndex, this.val$toIndex);
                }
            }
        }) : (ListenableFuture) invokeII.objValue;
    }

    public void notifyBufferingStateChanged(MediaItem mediaItem, int i, long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{mediaItem, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            synchronized (this.mLock) {
                this.mBufferingState = i;
                this.mBufferedPositionMs = j;
                this.mPositionEventTimeMs = j2;
                this.mPositionMs = j3;
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, mediaItem, i) { // from class: androidx.media2.session.MediaControllerImplBase.35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ MediaItem val$item;
                public final /* synthetic */ int val$state;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, mediaItem, Integer.valueOf(i)};
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
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onBufferingStateChanged(this.this$0.mInstance, this.val$item, this.val$state);
                    }
                }
            });
        }
    }

    public void notifyCurrentMediaItemChanged(MediaItem mediaItem, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048609, this, mediaItem, i, i2, i3) == null) {
            synchronized (this.mLock) {
                this.mCurrentMediaItem = mediaItem;
                this.mCurrentMediaItemIndex = i;
                this.mPreviousMediaItemIndex = i2;
                this.mNextMediaItemIndex = i3;
                if (this.mPlaylist != null && i >= 0 && i < this.mPlaylist.size()) {
                    this.mPlaylist.set(i, mediaItem);
                }
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, mediaItem) { // from class: androidx.media2.session.MediaControllerImplBase.32
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ MediaItem val$item;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, mediaItem};
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
                    this.val$item = mediaItem;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onCurrentMediaItemChanged(this.this$0.mInstance, this.val$item);
                    }
                }
            });
        }
    }

    public void notifyPlaybackCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this) { // from class: androidx.media2.session.MediaControllerImplBase.41
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;

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

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onPlaybackCompleted(this.this$0.mInstance);
                    }
                }
            });
        }
    }

    public void notifyPlaybackInfoChanges(MediaController.PlaybackInfo playbackInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, playbackInfo) == null) {
            synchronized (this.mLock) {
                this.mPlaybackInfo = playbackInfo;
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, playbackInfo) { // from class: androidx.media2.session.MediaControllerImplBase.38
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
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

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onPlaybackInfoChanged(this.this$0.mInstance, this.val$info);
                    }
                }
            });
        }
    }

    public void notifyPlaybackSpeedChanges(long j, long j2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f)}) == null) {
            synchronized (this.mLock) {
                this.mPositionEventTimeMs = j;
                this.mPositionMs = j2;
                this.mPlaybackSpeed = f;
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, f) { // from class: androidx.media2.session.MediaControllerImplBase.34
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
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

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onPlaybackSpeedChanged(this.this$0.mInstance, this.val$speed);
                    }
                }
            });
        }
    }

    public void notifyPlayerStateChanges(long j, long j2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
            synchronized (this.mLock) {
                this.mPositionEventTimeMs = j;
                this.mPositionMs = j2;
                this.mPlayerState = i;
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, i) { // from class: androidx.media2.session.MediaControllerImplBase.33
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ int val$state;

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
                    this.val$state = i;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onPlayerStateChanged(this.this$0.mInstance, this.val$state);
                    }
                }
            });
        }
    }

    public void notifyPlaylistChanges(List<MediaItem> list, MediaMetadata mediaMetadata, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{list, mediaMetadata, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            synchronized (this.mLock) {
                this.mPlaylist = list;
                this.mPlaylistMetadata = mediaMetadata;
                this.mCurrentMediaItemIndex = i;
                this.mPreviousMediaItemIndex = i2;
                this.mNextMediaItemIndex = i3;
                if (i >= 0 && list != null && i < list.size()) {
                    this.mCurrentMediaItem = list.get(i);
                }
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, list, mediaMetadata) { // from class: androidx.media2.session.MediaControllerImplBase.36
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ MediaMetadata val$metadata;
                public final /* synthetic */ List val$playlist;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list, mediaMetadata};
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
                    this.val$playlist = list;
                    this.val$metadata = mediaMetadata;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onPlaylistChanged(this.this$0.mInstance, this.val$playlist, this.val$metadata);
                    }
                }
            });
        }
    }

    public void notifyPlaylistMetadataChanges(MediaMetadata mediaMetadata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, mediaMetadata) == null) {
            synchronized (this.mLock) {
                this.mPlaylistMetadata = mediaMetadata;
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, mediaMetadata) { // from class: androidx.media2.session.MediaControllerImplBase.37
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
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

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onPlaylistMetadataChanged(this.this$0.mInstance, this.val$metadata);
                    }
                }
            });
        }
    }

    public void notifyRepeatModeChanges(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048616, this, i, i2, i3, i4) == null) {
            synchronized (this.mLock) {
                this.mRepeatMode = i;
                this.mCurrentMediaItemIndex = i2;
                this.mPreviousMediaItemIndex = i3;
                this.mNextMediaItemIndex = i4;
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, i) { // from class: androidx.media2.session.MediaControllerImplBase.39
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ int val$repeatMode;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
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
                    this.val$repeatMode = i;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onRepeatModeChanged(this.this$0.mInstance, this.val$repeatMode);
                    }
                }
            });
        }
    }

    public void notifySeekCompleted(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            synchronized (this.mLock) {
                this.mPositionEventTimeMs = j;
                this.mPositionMs = j2;
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, j3) { // from class: androidx.media2.session.MediaControllerImplBase.42
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ long val$seekPositionMs;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j3)};
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
                    this.val$seekPositionMs = j3;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onSeekCompleted(this.this$0.mInstance, this.val$seekPositionMs);
                    }
                }
            });
        }
    }

    public void notifyShuffleModeChanges(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048618, this, i, i2, i3, i4) == null) {
            synchronized (this.mLock) {
                this.mShuffleMode = i;
                this.mCurrentMediaItemIndex = i2;
                this.mPreviousMediaItemIndex = i3;
                this.mNextMediaItemIndex = i4;
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, i) { // from class: androidx.media2.session.MediaControllerImplBase.40
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ int val$shuffleMode;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
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
                    this.val$shuffleMode = i;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onShuffleModeChanged(this.this$0.mInstance, this.val$shuffleMode);
                    }
                }
            });
        }
    }

    public void notifySubtitleData(MediaItem mediaItem, SessionPlayer.TrackInfo trackInfo, SubtitleData subtitleData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048619, this, mediaItem, trackInfo, subtitleData) == null) {
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, mediaItem, trackInfo, subtitleData) { // from class: androidx.media2.session.MediaControllerImplBase.47
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
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

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onSubtitleData(this.this$0.mInstance, this.val$item, this.val$track, this.val$data);
                    }
                }
            });
        }
    }

    public void notifyTrackDeselected(int i, SessionPlayer.TrackInfo trackInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048620, this, i, trackInfo) == null) {
            synchronized (this.mLock) {
                this.mSelectedTracks.remove(trackInfo.getTrackType());
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, trackInfo) { // from class: androidx.media2.session.MediaControllerImplBase.46
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ SessionPlayer.TrackInfo val$trackInfo;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, trackInfo};
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
                    this.val$trackInfo = trackInfo;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onTrackDeselected(this.this$0.mInstance, this.val$trackInfo);
                    }
                }
            });
        }
    }

    public void notifyTrackSelected(int i, SessionPlayer.TrackInfo trackInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048621, this, i, trackInfo) == null) {
            synchronized (this.mLock) {
                this.mSelectedTracks.put(trackInfo.getTrackType(), trackInfo);
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, trackInfo) { // from class: androidx.media2.session.MediaControllerImplBase.45
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ SessionPlayer.TrackInfo val$trackInfo;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, trackInfo};
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
                    this.val$trackInfo = trackInfo;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onTrackSelected(this.this$0.mInstance, this.val$trackInfo);
                    }
                }
            });
        }
    }

    public void notifyTracksChanged(int i, List<SessionPlayer.TrackInfo> list, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Integer.valueOf(i), list, trackInfo, trackInfo2, trackInfo3, trackInfo4}) == null) {
            synchronized (this.mLock) {
                this.mTracks = list;
                this.mSelectedTracks.put(1, trackInfo);
                this.mSelectedTracks.put(2, trackInfo2);
                this.mSelectedTracks.put(4, trackInfo3);
                this.mSelectedTracks.put(5, trackInfo4);
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, list) { // from class: androidx.media2.session.MediaControllerImplBase.44
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ List val$tracks;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list};
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
                    this.val$tracks = list;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        controllerCallback.onTracksChanged(this.this$0.mInstance, this.val$tracks);
                    }
                }
            });
        }
    }

    public void notifyVideoSizeChanged(VideoSize videoSize) {
        MediaItem mediaItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, videoSize) == null) {
            synchronized (this.mLock) {
                this.mVideoSize = videoSize;
                mediaItem = this.mCurrentMediaItem;
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, mediaItem, videoSize) { // from class: androidx.media2.session.MediaControllerImplBase.43
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ MediaItem val$currentItem;
                public final /* synthetic */ VideoSize val$videoSize;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, mediaItem, videoSize};
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
                    this.val$currentItem = mediaItem;
                    this.val$videoSize = videoSize;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) && this.this$0.mInstance.isConnected()) {
                        MediaItem mediaItem2 = this.val$currentItem;
                        if (mediaItem2 != null) {
                            controllerCallback.onVideoSizeChanged(this.this$0.mInstance, mediaItem2, this.val$videoSize);
                        }
                        controllerCallback.onVideoSizeChanged(this.this$0.mInstance, this.val$videoSize);
                    }
                }
            });
        }
    }

    public void onAllowedCommandsChanged(SessionCommandGroup sessionCommandGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, sessionCommandGroup) == null) {
            synchronized (this.mLock) {
                this.mAllowedCommands = sessionCommandGroup;
            }
            this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, sessionCommandGroup) { // from class: androidx.media2.session.MediaControllerImplBase.50
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
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

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                        controllerCallback.onAllowedCommandsChanged(this.this$0.mInstance, this.val$commands);
                    }
                }
            });
        }
    }

    public void onConnectedNotLocked(int i, IMediaSession iMediaSession, SessionCommandGroup sessionCommandGroup, int i2, MediaItem mediaItem, long j, long j2, float f, long j3, MediaController.PlaybackInfo playbackInfo, int i3, int i4, List<MediaItem> list, PendingIntent pendingIntent, int i5, int i6, int i7, Bundle bundle, VideoSize videoSize, List<SessionPlayer.TrackInfo> list2, SessionPlayer.TrackInfo trackInfo, SessionPlayer.TrackInfo trackInfo2, SessionPlayer.TrackInfo trackInfo3, SessionPlayer.TrackInfo trackInfo4) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048625, this, new Object[]{Integer.valueOf(i), iMediaSession, sessionCommandGroup, Integer.valueOf(i2), mediaItem, Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f), Long.valueOf(j3), playbackInfo, Integer.valueOf(i3), Integer.valueOf(i4), list, pendingIntent, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), bundle, videoSize, list2, trackInfo, trackInfo2, trackInfo3, trackInfo4}) != null) {
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "onConnectedNotLocked sessionBinder=" + iMediaSession + ", allowedCommands=" + sessionCommandGroup);
        }
        if (iMediaSession != null && sessionCommandGroup != null) {
            try {
                synchronized (this.mLock) {
                    try {
                        if (this.mIsReleased) {
                            return;
                        }
                        try {
                            if (this.mISession != null) {
                                Log.e(TAG, "Cannot be notified about the connection result many times. Probably a bug or malicious app.");
                                this.mInstance.close();
                                return;
                            }
                            this.mAllowedCommands = sessionCommandGroup;
                            this.mPlayerState = i2;
                            this.mCurrentMediaItem = mediaItem;
                            this.mPositionEventTimeMs = j;
                            this.mPositionMs = j2;
                            this.mPlaybackSpeed = f;
                            this.mBufferedPositionMs = j3;
                            this.mPlaybackInfo = playbackInfo;
                            this.mRepeatMode = i3;
                            this.mShuffleMode = i4;
                            this.mPlaylist = list;
                            this.mSessionActivity = pendingIntent;
                            this.mISession = iMediaSession;
                            this.mCurrentMediaItemIndex = i5;
                            this.mPreviousMediaItemIndex = i6;
                            this.mNextMediaItemIndex = i7;
                            this.mVideoSize = videoSize;
                            this.mTracks = list2;
                            this.mSelectedTracks.put(1, trackInfo);
                            this.mSelectedTracks.put(2, trackInfo2);
                            this.mSelectedTracks.put(4, trackInfo3);
                            this.mSelectedTracks.put(5, trackInfo4);
                            try {
                                this.mISession.asBinder().linkToDeath(this.mDeathRecipient, 0);
                                this.mConnectedToken = new SessionToken(new SessionTokenImplBase(this.mToken.getUid(), 0, this.mToken.getPackageName(), iMediaSession, bundle));
                                this.mInstance.notifyAllControllerCallbacks(new MediaController.ControllerCallbackRunnable(this, sessionCommandGroup) { // from class: androidx.media2.session.MediaControllerImplBase.48
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ MediaControllerImplBase this$0;
                                    public final /* synthetic */ SessionCommandGroup val$allowedCommands;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, sessionCommandGroup};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i8 = newInitContext.flag;
                                            if ((i8 & 1) != 0) {
                                                int i9 = i8 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                        this.val$allowedCommands = sessionCommandGroup;
                                    }

                                    @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                                    public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                                            controllerCallback.onConnected(this.this$0.mInstance, this.val$allowedCommands);
                                        }
                                    }
                                });
                            } catch (RemoteException e) {
                                if (DEBUG) {
                                    Log.d(TAG, "Session died too early.", e);
                                }
                                this.mInstance.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                if (0 != 0) {
                    this.mInstance.close();
                }
                throw th3;
            }
        } else {
            this.mInstance.close();
        }
    }

    public void onCustomCommand(int i, SessionCommand sessionCommand, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048626, this, i, sessionCommand, bundle) == null) {
            if (DEBUG) {
                Log.d(TAG, "onCustomCommand cmd=" + sessionCommand.getCustomAction());
            }
            this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable(this, sessionCommand, bundle, i) { // from class: androidx.media2.session.MediaControllerImplBase.49
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ Bundle val$args;
                public final /* synthetic */ SessionCommand val$command;
                public final /* synthetic */ int val$seq;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sessionCommand, bundle, Integer.valueOf(i)};
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
                    this.val$command = sessionCommand;
                    this.val$args = bundle;
                    this.val$seq = i;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                        SessionResult onCustomCommand = controllerCallback.onCustomCommand(this.this$0.mInstance, this.val$command, this.val$args);
                        if (onCustomCommand != null) {
                            this.this$0.sendControllerResult(this.val$seq, onCustomCommand);
                            return;
                        }
                        throw new RuntimeException("ControllerCallback#onCustomCommand() has returned null, command=" + this.val$command.getCustomAction());
                    }
                }
            });
        }
    }

    public void onSetCustomLayout(int i, List<MediaSession.CommandButton> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048627, this, i, list) == null) {
            this.mInstance.notifyPrimaryControllerCallback(new MediaController.ControllerCallbackRunnable(this, list, i) { // from class: androidx.media2.session.MediaControllerImplBase.51
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MediaControllerImplBase this$0;
                public final /* synthetic */ List val$layout;
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
                    this.val$layout = list;
                    this.val$seq = i;
                }

                @Override // androidx.media2.session.MediaController.ControllerCallbackRunnable
                public void run(@NonNull MediaController.ControllerCallback controllerCallback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, controllerCallback) == null) {
                        this.this$0.sendControllerResult(this.val$seq, new SessionResult(controllerCallback.onSetCustomLayout(this.this$0.mInstance, this.val$layout)));
                    }
                }
            });
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> pause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? dispatchRemoteSessionTask(10001, new RemoteSessionTask(this) { // from class: androidx.media2.session.MediaControllerImplBase.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;

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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.pause(this.this$0.mControllerStub, i);
                }
            }
        }) : (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> play() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? dispatchRemoteSessionTask(10000, new RemoteSessionTask(this) { // from class: androidx.media2.session.MediaControllerImplBase.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;

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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.play(this.this$0.mControllerStub, i);
                }
            }
        }) : (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> prepare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? dispatchRemoteSessionTask(10002, new RemoteSessionTask(this) { // from class: androidx.media2.session.MediaControllerImplBase.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;

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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.prepare(this.this$0.mControllerStub, i);
                }
            }
        }) : (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> removePlaylistItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i)) == null) ? dispatchRemoteSessionTask(10014, new RemoteSessionTask(this, i) { // from class: androidx.media2.session.MediaControllerImplBase.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i2) == null) {
                    iMediaSession.removePlaylistItem(this.this$0.mControllerStub, i2, this.val$index);
                }
            }
        }) : (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> replacePlaylistItem(int i, @NonNull String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048632, this, i, str)) == null) ? dispatchRemoteSessionTask(10015, new RemoteSessionTask(this, i, str) { // from class: androidx.media2.session.MediaControllerImplBase.22
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
            public final /* synthetic */ int val$index;
            public final /* synthetic */ String val$mediaId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i), str};
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
                this.val$mediaId = str;
            }

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i2) == null) {
                    iMediaSession.replacePlaylistItem(this.this$0.mControllerStub, i2, this.val$index, this.val$mediaId);
                }
            }
        }) : (ListenableFuture) invokeIL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> rewind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_REWIND, new RemoteSessionTask(this) { // from class: androidx.media2.session.MediaControllerImplBase.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;

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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.rewind(this.this$0.mControllerStub, i);
                }
            }
        }) : (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> seekTo(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048634, this, j)) == null) {
            if (j >= 0) {
                return dispatchRemoteSessionTask(10003, new RemoteSessionTask(this, j) { // from class: androidx.media2.session.MediaControllerImplBase.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaControllerImplBase this$0;
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

                    @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
                    public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                            iMediaSession.seekTo(this.this$0.mControllerStub, i, this.val$pos);
                        }
                    }
                });
            }
            throw new IllegalArgumentException("position shouldn't be negative");
        }
        return (ListenableFuture) invokeJ.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    @NonNull
    public ListenableFuture<SessionResult> selectTrack(@NonNull SessionPlayer.TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, trackInfo)) == null) ? dispatchRemoteSessionTask(11001, new RemoteSessionTask(this, trackInfo) { // from class: androidx.media2.session.MediaControllerImplBase.29
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.selectTrack(this.this$0.mControllerStub, i, MediaParcelUtils.toParcelable(this.val$trackInfo));
                }
            }
        }) : (ListenableFuture) invokeL.objValue;
    }

    public void sendControllerResult(int i, @NonNull SessionResult sessionResult) {
        IMediaSession iMediaSession;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048636, this, i, sessionResult) == null) {
            synchronized (this.mLock) {
                iMediaSession = this.mISession;
            }
            if (iMediaSession == null) {
                return;
            }
            try {
                iMediaSession.onControllerResult(this.mControllerStub, i, MediaParcelUtils.toParcelable(sessionResult));
            } catch (RemoteException unused) {
                Log.w(TAG, "Error in sending");
            }
        }
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> sendCustomCommand(@NonNull SessionCommand sessionCommand, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, sessionCommand, bundle)) == null) ? dispatchRemoteSessionTask(sessionCommand, new RemoteSessionTask(this, sessionCommand, bundle) { // from class: androidx.media2.session.MediaControllerImplBase.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.onCustomCommand(this.this$0.mControllerStub, i, MediaParcelUtils.toParcelable(this.val$command), this.val$args);
                }
            }
        }) : (ListenableFuture) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setMediaItem(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, str)) == null) ? dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_SET_MEDIA_ITEM, new RemoteSessionTask(this, str) { // from class: androidx.media2.session.MediaControllerImplBase.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
            public final /* synthetic */ String val$mediaId;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str};
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
                this.val$mediaId = str;
            }

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.setMediaItem(this.this$0.mControllerStub, i, this.val$mediaId);
                }
            }
        }) : (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setMediaUri(@NonNull Uri uri, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048639, this, uri, bundle)) == null) ? dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_MEDIA_URI, new RemoteSessionTask(this, uri, bundle) { // from class: androidx.media2.session.MediaControllerImplBase.18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
            public final /* synthetic */ Bundle val$extras;
            public final /* synthetic */ Uri val$uri;

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
                this.val$uri = uri;
                this.val$extras = bundle;
            }

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.setMediaUri(this.this$0.mControllerStub, i, this.val$uri, this.val$extras);
                }
            }
        }) : (ListenableFuture) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setPlaybackSpeed(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048640, this, f)) == null) ? dispatchRemoteSessionTask(10004, new RemoteSessionTask(this, f) { // from class: androidx.media2.session.MediaControllerImplBase.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.setPlaybackSpeed(this.this$0.mControllerStub, i, this.val$speed);
                }
            }
        }) : (ListenableFuture) invokeF.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setPlaylist(@NonNull List<String> list, @Nullable MediaMetadata mediaMetadata) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048641, this, list, mediaMetadata)) == null) ? dispatchRemoteSessionTask(10006, new RemoteSessionTask(this, list, mediaMetadata) { // from class: androidx.media2.session.MediaControllerImplBase.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.setPlaylist(this.this$0.mControllerStub, i, this.val$list, MediaParcelUtils.toParcelable(this.val$metadata));
                }
            }
        }) : (ListenableFuture) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setRating(@NonNull String str, @NonNull Rating rating) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048642, this, str, rating)) == null) ? dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new RemoteSessionTask(this, str, rating) { // from class: androidx.media2.session.MediaControllerImplBase.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
            public final /* synthetic */ String val$mediaId;
            public final /* synthetic */ Rating val$rating;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, rating};
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
                this.val$mediaId = str;
                this.val$rating = rating;
            }

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.setRating(this.this$0.mControllerStub, i, this.val$mediaId, MediaParcelUtils.toParcelable(this.val$rating));
                }
            }
        }) : (ListenableFuture) invokeLL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setRepeatMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048643, this, i)) == null) ? dispatchRemoteSessionTask(10011, new RemoteSessionTask(this, i) { // from class: androidx.media2.session.MediaControllerImplBase.27
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i2) == null) {
                    iMediaSession.setRepeatMode(this.this$0.mControllerStub, i2, this.val$repeatMode);
                }
            }
        }) : (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setShuffleMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048644, this, i)) == null) ? dispatchRemoteSessionTask(10010, new RemoteSessionTask(this, i) { // from class: androidx.media2.session.MediaControllerImplBase.28
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i2) == null) {
                    iMediaSession.setShuffleMode(this.this$0.mControllerStub, i2, this.val$shuffleMode);
                }
            }
        }) : (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setSurface(@Nullable Surface surface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, surface)) == null) ? dispatchRemoteSessionTask(11000, new RemoteSessionTask(this, surface) { // from class: androidx.media2.session.MediaControllerImplBase.31
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.setSurface(this.this$0.mControllerStub, i, this.val$surface);
                }
            }
        }) : (ListenableFuture) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> setVolumeTo(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048646, this, i, i2)) == null) ? dispatchRemoteSessionTask(30000, new RemoteSessionTask(this, i, i2) { // from class: androidx.media2.session.MediaControllerImplBase.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
            public final /* synthetic */ int val$flags;
            public final /* synthetic */ int val$value;

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
                this.val$value = i;
                this.val$flags = i2;
            }

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i3) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i3) == null) {
                    iMediaSession.setVolumeTo(this.this$0.mControllerStub, i3, this.val$value, this.val$flags);
                }
            }
        }) : (ListenableFuture) invokeII.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_SKIP_BACKWARD, new RemoteSessionTask(this) { // from class: androidx.media2.session.MediaControllerImplBase.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;

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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.skipBackward(this.this$0.mControllerStub, i);
                }
            }
        }) : (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_SESSION_SKIP_FORWARD, new RemoteSessionTask(this) { // from class: androidx.media2.session.MediaControllerImplBase.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;

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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.skipForward(this.this$0.mControllerStub, i);
                }
            }
        }) : (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToNextItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? dispatchRemoteSessionTask(10009, new RemoteSessionTask(this) { // from class: androidx.media2.session.MediaControllerImplBase.25
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;

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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.skipToNextItem(this.this$0.mControllerStub, i);
                }
            }
        }) : (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToPlaylistItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048650, this, i)) == null) ? dispatchRemoteSessionTask(10007, new RemoteSessionTask(this, i) { // from class: androidx.media2.session.MediaControllerImplBase.26
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i2) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i2) == null) {
                    iMediaSession.skipToPlaylistItem(this.this$0.mControllerStub, i2, this.val$index);
                }
            }
        }) : (ListenableFuture) invokeI.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> skipToPreviousItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? dispatchRemoteSessionTask(10008, new RemoteSessionTask(this) { // from class: androidx.media2.session.MediaControllerImplBase.24
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;

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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.skipToPreviousItem(this.this$0.mControllerStub, i);
                }
            }
        }) : (ListenableFuture) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaController.MediaControllerImpl
    public ListenableFuture<SessionResult> updatePlaylistMetadata(@Nullable MediaMetadata mediaMetadata) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, mediaMetadata)) == null) ? dispatchRemoteSessionTask(SessionCommand.COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA, new RemoteSessionTask(this, mediaMetadata) { // from class: androidx.media2.session.MediaControllerImplBase.19
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ MediaControllerImplBase this$0;
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

            @Override // androidx.media2.session.MediaControllerImplBase.RemoteSessionTask
            public void run(IMediaSession iMediaSession, int i) throws RemoteException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, iMediaSession, i) == null) {
                    iMediaSession.updatePlaylistMetadata(this.this$0.mControllerStub, i, MediaParcelUtils.toParcelable(this.val$metadata));
                }
            }
        }) : (ListenableFuture) invokeL.objValue;
    }

    private ListenableFuture<SessionResult> dispatchRemoteSessionTask(SessionCommand sessionCommand, RemoteSessionTask remoteSessionTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, sessionCommand, remoteSessionTask)) == null) ? dispatchRemoteSessionTaskInternal(0, sessionCommand, remoteSessionTask) : (ListenableFuture) invokeLL.objValue;
    }

    public IMediaSession getSessionInterfaceIfAble(SessionCommand sessionCommand) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, sessionCommand)) == null) {
            synchronized (this.mLock) {
                if (!this.mAllowedCommands.hasCommand(sessionCommand)) {
                    Log.w(TAG, "Controller isn't allowed to call command, command=" + sessionCommand);
                    return null;
                }
                return this.mISession;
            }
        }
        return (IMediaSession) invokeL.objValue;
    }
}

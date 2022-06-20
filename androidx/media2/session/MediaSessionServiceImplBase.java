package androidx.media2.session;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.session.IMediaSessionService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionService;
import androidx.versionedparcelable.ParcelImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class MediaSessionServiceImplBase implements MediaSessionService.MediaSessionServiceImpl {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = true;
    public static final String TAG = "MSS2ImplBase";
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("mLock")
    public MediaSessionService mInstance;
    public final Object mLock;
    @GuardedBy("mLock")
    public MediaNotificationHandler mNotificationHandler;
    @GuardedBy("mLock")
    public Map<String, MediaSession> mSessions;
    @GuardedBy("mLock")
    public MediaSessionServiceStub mStub;

    /* loaded from: classes.dex */
    public static final class MediaSessionServiceStub extends IMediaSessionService.Stub implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler mHandler;
        public final androidx.media.MediaSessionManager mMediaSessionManager;
        public final WeakReference<MediaSessionServiceImplBase> mServiceImpl;

        public MediaSessionServiceStub(MediaSessionServiceImplBase mediaSessionServiceImplBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaSessionServiceImplBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mServiceImpl = new WeakReference<>(mediaSessionServiceImplBase);
            this.mHandler = new Handler(mediaSessionServiceImplBase.getInstance().getMainLooper());
            this.mMediaSessionManager = androidx.media.MediaSessionManager.getSessionManager(mediaSessionServiceImplBase.getInstance());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mServiceImpl.clear();
                this.mHandler.removeCallbacksAndMessages(null);
            }
        }

        @Override // androidx.media2.session.IMediaSessionService
        public void connect(IMediaController iMediaController, ParcelImpl parcelImpl) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iMediaController, parcelImpl) == null) {
                if (this.mServiceImpl.get() == null) {
                    Log.d(MediaSessionServiceImplBase.TAG, "ServiceImpl isn't available");
                    return;
                }
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                long clearCallingIdentity = Binder.clearCallingIdentity();
                ConnectionRequest connectionRequest = (ConnectionRequest) MediaParcelUtils.fromParcelable(parcelImpl);
                if (callingPid == 0) {
                    callingPid = connectionRequest.getPid();
                }
                try {
                    this.mHandler.post(new Runnable(this, parcelImpl == null ? null : connectionRequest.getPackageName(), callingPid, callingUid, connectionRequest, parcelImpl == null ? null : connectionRequest.getConnectionHints(), iMediaController) { // from class: androidx.media2.session.MediaSessionServiceImplBase.MediaSessionServiceStub.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MediaSessionServiceStub this$0;
                        public final /* synthetic */ IMediaController val$caller;
                        public final /* synthetic */ Bundle val$connectionHints;
                        public final /* synthetic */ String val$packageName;
                        public final /* synthetic */ int val$pid;
                        public final /* synthetic */ ConnectionRequest val$request;
                        public final /* synthetic */ int val$uid;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, r7, Integer.valueOf(callingPid), Integer.valueOf(callingUid), connectionRequest, r11, iMediaController};
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
                            this.val$packageName = r7;
                            this.val$pid = callingPid;
                            this.val$uid = callingUid;
                            this.val$request = connectionRequest;
                            this.val$connectionHints = r11;
                            this.val$caller = iMediaController;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:34:0x00c1  */
                        /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void run() {
                            MediaSession onGetSession;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                                return;
                            }
                            boolean z = true;
                            try {
                                MediaSessionServiceImplBase mediaSessionServiceImplBase = this.this$0.mServiceImpl.get();
                                if (mediaSessionServiceImplBase == null) {
                                    Log.d(MediaSessionServiceImplBase.TAG, "ServiceImpl isn't available");
                                    Log.d(MediaSessionServiceImplBase.TAG, "Notifying the controller of its disconnection");
                                    try {
                                        this.val$caller.onDisconnected(0);
                                        return;
                                    } catch (RemoteException unused) {
                                        return;
                                    }
                                }
                                MediaSessionService mediaSessionServiceImplBase2 = mediaSessionServiceImplBase.getInstance();
                                if (mediaSessionServiceImplBase2 == null) {
                                    Log.d(MediaSessionServiceImplBase.TAG, "Service isn't available");
                                    Log.d(MediaSessionServiceImplBase.TAG, "Notifying the controller of its disconnection");
                                    try {
                                        this.val$caller.onDisconnected(0);
                                        return;
                                    } catch (RemoteException unused2) {
                                        return;
                                    }
                                }
                                MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(this.val$packageName, this.val$pid, this.val$uid);
                                MediaSession.ControllerInfo controllerInfo = new MediaSession.ControllerInfo(remoteUserInfo, this.val$request.getVersion(), this.this$0.mMediaSessionManager.isTrustedForMediaControl(remoteUserInfo), null, this.val$connectionHints);
                                Log.d(MediaSessionServiceImplBase.TAG, "Handling incoming connection request from the controller=" + controllerInfo);
                                try {
                                    onGetSession = mediaSessionServiceImplBase2.onGetSession(controllerInfo);
                                } catch (Exception e) {
                                    e = e;
                                }
                                if (onGetSession == null) {
                                    Log.w(MediaSessionServiceImplBase.TAG, "Rejecting incoming connection request from the controller=" + controllerInfo);
                                    Log.d(MediaSessionServiceImplBase.TAG, "Notifying the controller of its disconnection");
                                    try {
                                        this.val$caller.onDisconnected(0);
                                        return;
                                    } catch (RemoteException unused3) {
                                        return;
                                    }
                                }
                                mediaSessionServiceImplBase2.addSession(onGetSession);
                                try {
                                    onGetSession.handleControllerConnectionFromService(this.val$caller, this.val$request.getVersion(), this.val$packageName, this.val$pid, this.val$uid, this.val$connectionHints);
                                    z = false;
                                } catch (Exception e2) {
                                    e = e2;
                                    z = false;
                                    Log.w(MediaSessionServiceImplBase.TAG, "Failed to add a session to session service", e);
                                    if (z) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                    if (z) {
                                        Log.d(MediaSessionServiceImplBase.TAG, "Notifying the controller of its disconnection");
                                        try {
                                            this.val$caller.onDisconnected(0);
                                        } catch (RemoteException unused4) {
                                        }
                                    }
                                    throw th;
                                }
                                if (z) {
                                    return;
                                }
                                Log.d(MediaSessionServiceImplBase.TAG, "Notifying the controller of its disconnection");
                                try {
                                    this.val$caller.onDisconnected(0);
                                } catch (RemoteException unused5) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    });
                } finally {
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                }
            }
        }
    }

    public MediaSessionServiceImplBase() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mSessions = new ArrayMap();
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void addSession(MediaSession mediaSession) {
        MediaSession mediaSession2;
        MediaNotificationHandler mediaNotificationHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mediaSession) == null) {
            synchronized (this.mLock) {
                mediaSession2 = this.mSessions.get(mediaSession.getId());
                if (mediaSession2 != null && mediaSession2 != mediaSession) {
                    throw new IllegalArgumentException("Session ID should be unique");
                }
                this.mSessions.put(mediaSession.getId(), mediaSession);
            }
            if (mediaSession2 == null) {
                synchronized (this.mLock) {
                    mediaNotificationHandler = this.mNotificationHandler;
                }
                mediaNotificationHandler.onPlayerStateChanged(mediaSession, mediaSession.getPlayer().getPlayerState());
                mediaSession.getCallback().setForegroundServiceEventCallback(mediaNotificationHandler);
            }
        }
    }

    public MediaSessionService getInstance() {
        InterceptResult invokeV;
        MediaSessionService mediaSessionService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.mLock) {
                mediaSessionService = this.mInstance;
            }
            return mediaSessionService;
        }
        return (MediaSessionService) invokeV.objValue;
    }

    public IBinder getServiceBinder() {
        InterceptResult invokeV;
        IBinder asBinder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.mLock) {
                asBinder = this.mStub != null ? this.mStub.asBinder() : null;
            }
            return asBinder;
        }
        return (IBinder) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public List<MediaSession> getSessions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.mLock) {
                arrayList.addAll(this.mSessions.values());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, intent)) == null) {
            MediaSessionService mediaSessionServiceImplBase = getInstance();
            if (mediaSessionServiceImplBase == null) {
                Log.w(TAG, "Service hasn't created before onBind()");
                return null;
            }
            String action = intent.getAction();
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -2044151856) {
                if (hashCode == 1665850838 && action.equals(MediaBrowserServiceCompat.SERVICE_INTERFACE)) {
                    c = 1;
                }
            } else if (action.equals(MediaSessionService.SERVICE_INTERFACE)) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    return null;
                }
                MediaSession onGetSession = mediaSessionServiceImplBase.onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
                if (onGetSession == null) {
                    Log.d(TAG, "Rejecting incoming connection request from legacy media browsers.");
                    return null;
                }
                addSession(onGetSession);
                return onGetSession.getLegacyBrowerServiceBinder();
            }
            return getServiceBinder();
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void onCreate(MediaSessionService mediaSessionService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mediaSessionService) == null) {
            synchronized (this.mLock) {
                this.mInstance = mediaSessionService;
                this.mStub = new MediaSessionServiceStub(this);
                this.mNotificationHandler = new MediaNotificationHandler(mediaSessionService);
            }
        }
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.mLock) {
                this.mInstance = null;
                if (this.mStub != null) {
                    this.mStub.close();
                    this.mStub = null;
                }
            }
        }
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, intent, i, i2)) == null) {
            if (intent != null && intent.getAction() != null) {
                String action = intent.getAction();
                char c = 65535;
                if (action.hashCode() == 1997055314 && action.equals("android.intent.action.MEDIA_BUTTON")) {
                    c = 0;
                }
                if (c == 0) {
                    MediaSessionService mediaSessionServiceImplBase = getInstance();
                    if (mediaSessionServiceImplBase == null) {
                        Log.wtf(TAG, "Service hasn't created");
                    }
                    MediaSession session = MediaSession.getSession(intent.getData());
                    if (session == null) {
                        session = mediaSessionServiceImplBase.onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
                    }
                    if (session == null) {
                        Log.d(TAG, "Rejecting wake-up of the service from media key events.");
                    } else {
                        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                        if (keyEvent != null) {
                            session.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
                        }
                    }
                }
            }
            return 1;
        }
        return invokeLII.intValue;
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public MediaSessionService.MediaNotification onUpdateNotification(MediaSession mediaSession) {
        InterceptResult invokeL;
        MediaNotificationHandler mediaNotificationHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaSession)) == null) {
            synchronized (this.mLock) {
                mediaNotificationHandler = this.mNotificationHandler;
            }
            if (mediaNotificationHandler != null) {
                return mediaNotificationHandler.onUpdateNotification(mediaSession);
            }
            throw new IllegalStateException("Service hasn't created");
        }
        return (MediaSessionService.MediaNotification) invokeL.objValue;
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void removeSession(MediaSession mediaSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mediaSession) == null) {
            synchronized (this.mLock) {
                this.mSessions.remove(mediaSession.getId());
            }
        }
    }
}

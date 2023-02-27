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
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.session.IMediaSessionService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.MediaSessionService;
import androidx.versionedparcelable.ParcelImpl;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class MediaSessionServiceImplBase implements MediaSessionService.MediaSessionServiceImpl {
    public static final boolean DEBUG = true;
    public static final String TAG = "MSS2ImplBase";
    @GuardedBy("mLock")
    public MediaSessionService mInstance;
    @GuardedBy("mLock")
    public MediaNotificationHandler mNotificationHandler;
    @GuardedBy("mLock")
    public MediaSessionServiceStub mStub;
    public final Object mLock = new Object();
    @GuardedBy("mLock")
    public Map<String, MediaSession> mSessions = new ArrayMap();

    /* loaded from: classes.dex */
    public static final class MediaSessionServiceStub extends IMediaSessionService.Stub implements Closeable {
        public final Handler mHandler;
        public final androidx.media.MediaSessionManager mMediaSessionManager;
        public final WeakReference<MediaSessionServiceImplBase> mServiceImpl;

        public MediaSessionServiceStub(MediaSessionServiceImplBase mediaSessionServiceImplBase) {
            this.mServiceImpl = new WeakReference<>(mediaSessionServiceImplBase);
            this.mHandler = new Handler(mediaSessionServiceImplBase.getInstance().getMainLooper());
            this.mMediaSessionManager = androidx.media.MediaSessionManager.getSessionManager(mediaSessionServiceImplBase.getInstance());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mServiceImpl.clear();
            this.mHandler.removeCallbacksAndMessages(null);
        }

        @Override // androidx.media2.session.IMediaSessionService
        public void connect(final IMediaController iMediaController, ParcelImpl parcelImpl) {
            final String packageName;
            final Bundle connectionHints;
            if (this.mServiceImpl.get() == null) {
                Log.d(MediaSessionServiceImplBase.TAG, "ServiceImpl isn't available");
                return;
            }
            int callingPid = Binder.getCallingPid();
            final int callingUid = Binder.getCallingUid();
            long clearCallingIdentity = Binder.clearCallingIdentity();
            final ConnectionRequest connectionRequest = (ConnectionRequest) MediaParcelUtils.fromParcelable(parcelImpl);
            if (callingPid == 0) {
                callingPid = connectionRequest.getPid();
            }
            final int i = callingPid;
            if (parcelImpl == null) {
                packageName = null;
            } else {
                packageName = connectionRequest.getPackageName();
            }
            if (parcelImpl == null) {
                connectionHints = null;
            } else {
                connectionHints = connectionRequest.getConnectionHints();
            }
            try {
                this.mHandler.post(new Runnable() { // from class: androidx.media2.session.MediaSessionServiceImplBase.MediaSessionServiceStub.1
                    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd  */
                    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        MediaSession onGetSession;
                        boolean z = true;
                        try {
                            MediaSessionServiceImplBase mediaSessionServiceImplBase = MediaSessionServiceStub.this.mServiceImpl.get();
                            if (mediaSessionServiceImplBase == null) {
                                Log.d(MediaSessionServiceImplBase.TAG, "ServiceImpl isn't available");
                                Log.d(MediaSessionServiceImplBase.TAG, "Notifying the controller of its disconnection");
                                try {
                                    iMediaController.onDisconnected(0);
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
                                    iMediaController.onDisconnected(0);
                                    return;
                                } catch (RemoteException unused2) {
                                    return;
                                }
                            }
                            MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(packageName, i, callingUid);
                            MediaSession.ControllerInfo controllerInfo = new MediaSession.ControllerInfo(remoteUserInfo, connectionRequest.getVersion(), MediaSessionServiceStub.this.mMediaSessionManager.isTrustedForMediaControl(remoteUserInfo), null, connectionHints);
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
                                    iMediaController.onDisconnected(0);
                                    return;
                                } catch (RemoteException unused3) {
                                    return;
                                }
                            }
                            mediaSessionServiceImplBase2.addSession(onGetSession);
                            try {
                                onGetSession.handleControllerConnectionFromService(iMediaController, connectionRequest.getVersion(), packageName, i, callingUid, connectionHints);
                                z = false;
                            } catch (Exception e2) {
                                e = e2;
                                z = false;
                                Log.w(MediaSessionServiceImplBase.TAG, "Failed to add a session to session service", e);
                                if (!z) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                z = false;
                                if (z) {
                                    Log.d(MediaSessionServiceImplBase.TAG, "Notifying the controller of its disconnection");
                                    try {
                                        iMediaController.onDisconnected(0);
                                    } catch (RemoteException unused4) {
                                    }
                                }
                                throw th;
                            }
                            if (!z) {
                                Log.d(MediaSessionServiceImplBase.TAG, "Notifying the controller of its disconnection");
                                try {
                                    iMediaController.onDisconnected(0);
                                } catch (RemoteException unused5) {
                                }
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

    public MediaSessionService getInstance() {
        MediaSessionService mediaSessionService;
        synchronized (this.mLock) {
            mediaSessionService = this.mInstance;
        }
        return mediaSessionService;
    }

    public IBinder getServiceBinder() {
        IBinder iBinder;
        synchronized (this.mLock) {
            if (this.mStub != null) {
                iBinder = this.mStub.asBinder();
            } else {
                iBinder = null;
            }
        }
        return iBinder;
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public List<MediaSession> getSessions() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            arrayList.addAll(this.mSessions.values());
        }
        return arrayList;
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void onDestroy() {
        synchronized (this.mLock) {
            this.mInstance = null;
            if (this.mStub != null) {
                this.mStub.close();
                this.mStub = null;
            }
        }
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void addSession(MediaSession mediaSession) {
        MediaSession mediaSession2;
        MediaNotificationHandler mediaNotificationHandler;
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

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public IBinder onBind(Intent intent) {
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

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void onCreate(MediaSessionService mediaSessionService) {
        synchronized (this.mLock) {
            this.mInstance = mediaSessionService;
            this.mStub = new MediaSessionServiceStub(this);
            this.mNotificationHandler = new MediaNotificationHandler(mediaSessionService);
        }
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public MediaSessionService.MediaNotification onUpdateNotification(MediaSession mediaSession) {
        MediaNotificationHandler mediaNotificationHandler;
        synchronized (this.mLock) {
            mediaNotificationHandler = this.mNotificationHandler;
        }
        if (mediaNotificationHandler != null) {
            return mediaNotificationHandler.onUpdateNotification(mediaSession);
        }
        throw new IllegalStateException("Service hasn't created");
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public void removeSession(MediaSession mediaSession) {
        synchronized (this.mLock) {
            this.mSessions.remove(mediaSession.getId());
        }
    }

    @Override // androidx.media2.session.MediaSessionService.MediaSessionServiceImpl
    public int onStartCommand(Intent intent, int i, int i2) {
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
}

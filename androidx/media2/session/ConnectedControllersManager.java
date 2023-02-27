package androidx.media2.session;

import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.media2.session.MediaSession;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ConnectedControllersManager<T> {
    public final MediaSession.MediaSessionImpl mSessionImpl;
    public static final String TAG = "MS2ControllerMgr";
    public static final boolean DEBUG = Log.isLoggable(TAG, 3);
    public final Object mLock = new Object();
    @GuardedBy("mLock")
    public final ArrayMap<T, MediaSession.ControllerInfo> mControllerInfoMap = new ArrayMap<>();
    @GuardedBy("mLock")
    public final ArrayMap<MediaSession.ControllerInfo, ConnectedControllersManager<T>.ConnectedControllerRecord> mControllerRecords = new ArrayMap<>();

    /* loaded from: classes.dex */
    public class ConnectedControllerRecord {
        public SessionCommandGroup allowedCommands;
        public final T controllerKey;
        public final SequencedFutureManager sequencedFutureManager;

        public ConnectedControllerRecord(T t, SequencedFutureManager sequencedFutureManager, SessionCommandGroup sessionCommandGroup) {
            this.controllerKey = t;
            this.sequencedFutureManager = sequencedFutureManager;
            this.allowedCommands = sessionCommandGroup;
            if (sessionCommandGroup == null) {
                this.allowedCommands = new SessionCommandGroup();
            }
        }
    }

    public final List<MediaSession.ControllerInfo> getConnectedControllers() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            arrayList.addAll(this.mControllerInfoMap.values());
        }
        return arrayList;
    }

    public ConnectedControllersManager(MediaSession.MediaSessionImpl mediaSessionImpl) {
        this.mSessionImpl = mediaSessionImpl;
    }

    public MediaSession.ControllerInfo getController(T t) {
        MediaSession.ControllerInfo controllerInfo;
        synchronized (this.mLock) {
            controllerInfo = this.mControllerInfoMap.get(t);
        }
        return controllerInfo;
    }

    @Nullable
    public final SequencedFutureManager getSequencedFutureManager(@Nullable MediaSession.ControllerInfo controllerInfo) {
        ConnectedControllersManager<T>.ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.mLock) {
            connectedControllerRecord = this.mControllerRecords.get(controllerInfo);
        }
        if (connectedControllerRecord != null) {
            return connectedControllerRecord.sequencedFutureManager;
        }
        return null;
    }

    public final boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        boolean z;
        synchronized (this.mLock) {
            if (this.mControllerRecords.get(controllerInfo) != null) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public void removeController(T t) {
        if (t == null) {
            return;
        }
        removeController(getController(t));
    }

    public void addController(T t, MediaSession.ControllerInfo controllerInfo, SessionCommandGroup sessionCommandGroup) {
        if (t != null && controllerInfo != null) {
            synchronized (this.mLock) {
                MediaSession.ControllerInfo controller = getController(t);
                if (controller == null) {
                    this.mControllerInfoMap.put(t, controllerInfo);
                    this.mControllerRecords.put(controllerInfo, new ConnectedControllerRecord(t, new SequencedFutureManager(), sessionCommandGroup));
                } else {
                    this.mControllerRecords.get(controller).allowedCommands = sessionCommandGroup;
                }
            }
        } else if (!DEBUG) {
        } else {
            throw new IllegalArgumentException("controllerKey and controllerInfo shouldn't be null");
        }
    }

    public SequencedFutureManager getSequencedFutureManager(@Nullable T t) {
        ConnectedControllersManager<T>.ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.mLock) {
            connectedControllerRecord = this.mControllerRecords.get(getController(t));
        }
        if (connectedControllerRecord != null) {
            return connectedControllerRecord.sequencedFutureManager;
        }
        return null;
    }

    public boolean isAllowedCommand(MediaSession.ControllerInfo controllerInfo, int i) {
        ConnectedControllersManager<T>.ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.mLock) {
            connectedControllerRecord = this.mControllerRecords.get(controllerInfo);
        }
        if (connectedControllerRecord != null && connectedControllerRecord.allowedCommands.hasCommand(i)) {
            return true;
        }
        return false;
    }

    public void updateAllowedCommands(MediaSession.ControllerInfo controllerInfo, SessionCommandGroup sessionCommandGroup) {
        if (controllerInfo == null) {
            return;
        }
        synchronized (this.mLock) {
            ConnectedControllersManager<T>.ConnectedControllerRecord connectedControllerRecord = this.mControllerRecords.get(controllerInfo);
            if (connectedControllerRecord != null) {
                connectedControllerRecord.allowedCommands = sessionCommandGroup;
            }
        }
    }

    public boolean isAllowedCommand(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand) {
        ConnectedControllersManager<T>.ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.mLock) {
            connectedControllerRecord = this.mControllerRecords.get(controllerInfo);
        }
        if (connectedControllerRecord != null && connectedControllerRecord.allowedCommands.hasCommand(sessionCommand)) {
            return true;
        }
        return false;
    }

    public void removeController(final MediaSession.ControllerInfo controllerInfo) {
        if (controllerInfo == null) {
            return;
        }
        synchronized (this.mLock) {
            ConnectedControllersManager<T>.ConnectedControllerRecord remove = this.mControllerRecords.remove(controllerInfo);
            if (remove == null) {
                return;
            }
            this.mControllerInfoMap.remove(remove.controllerKey);
            if (DEBUG) {
                Log.d(TAG, "Controller " + controllerInfo + " is disconnected");
            }
            remove.sequencedFutureManager.close();
            this.mSessionImpl.getCallbackExecutor().execute(new Runnable() { // from class: androidx.media2.session.ConnectedControllersManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ConnectedControllersManager.this.mSessionImpl.isClosed()) {
                        return;
                    }
                    ConnectedControllersManager.this.mSessionImpl.getCallback().onDisconnected(ConnectedControllersManager.this.mSessionImpl.getInstance(), controllerInfo);
                }
            });
        }
    }
}

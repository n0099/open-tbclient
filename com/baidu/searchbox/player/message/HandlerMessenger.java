package com.baidu.searchbox.player.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.session.VideoSession;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.searchbox.player.utils.MainThreadUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class HandlerMessenger implements IMessenger {
    public static final int KEY_MESSAGE_EVENT = 153;
    public static final String TAG = "HandlerMessenger";
    @Nullable
    public PrivateHandler mHandler;
    public HandlerThread mHandlerThread;
    public IVideoEventInterceptor mInterceptor;
    public ConcurrentHashMap<Integer, CopyOnWriteArrayList<INeuron>> mSubscribers = new ConcurrentHashMap<>();
    public VideoSession mVideoSession;

    /* loaded from: classes2.dex */
    public class PrivateHandler extends Handler {
        public WeakReference<IVideoEventInterceptor> mWeakControl;

        public PrivateHandler(Looper looper) {
            super(looper);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean handleInterceptorEvent(VideoEvent videoEvent) {
            IVideoEventInterceptor iVideoEventInterceptor;
            WeakReference<IVideoEventInterceptor> weakReference = this.mWeakControl;
            if (weakReference == null || (iVideoEventInterceptor = weakReference.get()) == null || iVideoEventInterceptor.getInterceptorLayer() == videoEvent.getSender() || !HandlerMessenger.this.mInterceptor.onInterceptorEvent(videoEvent.getAction())) {
                return false;
            }
            videoEvent.recycle();
            return true;
        }

        public void clearWeakControl() {
            WeakReference<IVideoEventInterceptor> weakReference = this.mWeakControl;
            if (weakReference != null) {
                weakReference.clear();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (obj instanceof VideoEvent) {
                final VideoEvent videoEvent = (VideoEvent) obj;
                MainThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.player.message.HandlerMessenger.PrivateHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PrivateHandler.this.handleInterceptorEvent(videoEvent)) {
                            return;
                        }
                        HandlerMessenger.this.dispatchEvent(videoEvent);
                    }
                });
            }
        }

        public void setWeakControl(@Nullable IVideoEventInterceptor iVideoEventInterceptor) {
            this.mWeakControl = new WeakReference<>(iVideoEventInterceptor);
        }
    }

    public HandlerMessenger(@NonNull VideoSession videoSession) {
        this.mVideoSession = videoSession;
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new PrivateHandler(this.mHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchEvent(VideoEvent videoEvent) {
        BdVideoLog.d(this + " dispatch event :" + videoEvent);
        this.mVideoSession.getState().receivePlayerEvent(videoEvent);
        if (this.mVideoSession.getTargetPlayer() != null) {
            this.mVideoSession.getTargetPlayer().getPlayerCallbackManager().dispatchPlayerAction(videoEvent);
        }
        CopyOnWriteArrayList<INeuron> copyOnWriteArrayList = this.mSubscribers.get(Integer.valueOf(videoEvent.getType()));
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<INeuron> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            INeuron next = it.next();
            if (!videoEvent.filter(next)) {
                switch (videoEvent.getType()) {
                    case -1:
                    case 6:
                        next.onVideoEventNotify(videoEvent);
                        continue;
                    case 1:
                        next.onSystemEventNotify(videoEvent);
                        continue;
                    case 2:
                        next.onControlEventNotify(videoEvent);
                        continue;
                    case 3:
                        next.onLayerEventNotify(videoEvent);
                        continue;
                    case 4:
                        next.onPlayerEventNotify(videoEvent);
                        continue;
                    case 5:
                        next.onPlayerStatusChanged((PlayerStatus) videoEvent.getExtra(2), (PlayerStatus) videoEvent.getExtra(1));
                        continue;
                }
            }
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public String getType() {
        return TAG;
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void notifyEvent(@NonNull VideoEvent videoEvent) {
        BdVideoLog.d(this + " notifyEvent " + videoEvent);
        if (videoEvent.getPriority() == 1) {
            dispatchEvent(videoEvent);
            videoEvent.recycle();
            return;
        }
        PrivateHandler privateHandler = this.mHandler;
        if (privateHandler != null) {
            privateHandler.obtainMessage(153, videoEvent).sendToTarget();
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void register(int i, @NonNull INeuron iNeuron) {
        CopyOnWriteArrayList<INeuron> copyOnWriteArrayList = this.mSubscribers.get(Integer.valueOf(i));
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        if (!copyOnWriteArrayList.contains(iNeuron)) {
            copyOnWriteArrayList.add(iNeuron);
        }
        this.mSubscribers.put(Integer.valueOf(i), copyOnWriteArrayList);
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void release() {
        this.mSubscribers.clear();
        this.mHandlerThread.quit();
        PrivateHandler privateHandler = this.mHandler;
        if (privateHandler != null) {
            privateHandler.clearWeakControl();
            this.mHandler.removeMessages(153);
        }
        this.mHandler = null;
        this.mInterceptor = null;
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void setInterceptor(IVideoEventInterceptor iVideoEventInterceptor) {
        this.mInterceptor = iVideoEventInterceptor;
        PrivateHandler privateHandler = this.mHandler;
        if (privateHandler != null) {
            privateHandler.setWeakControl(iVideoEventInterceptor);
        }
    }

    @Override // com.baidu.searchbox.player.message.IMessenger
    public void unregister(INeuron iNeuron) {
        for (CopyOnWriteArrayList<INeuron> copyOnWriteArrayList : this.mSubscribers.values()) {
            copyOnWriteArrayList.remove(iNeuron);
        }
    }
}

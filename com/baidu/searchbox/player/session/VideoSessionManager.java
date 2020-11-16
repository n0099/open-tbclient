package com.baidu.searchbox.player.session;

import android.support.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.event.SystemEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.pool.SynchronizedFIFOPool;
/* loaded from: classes11.dex */
public class VideoSessionManager {
    private SynchronizedFIFOPool<VideoSession> mSessionCache;
    private SystemEventTrigger mSystemEventTrigger;

    private VideoSessionManager() {
        this.mSessionCache = new SynchronizedFIFOPool<>(10);
    }

    @PublicMethod
    public static VideoSessionManager getInstance() {
        return Holder.mInstance;
    }

    private void setupSystemEventTrigger() {
        this.mSystemEventTrigger = new SystemEventTrigger();
        this.mSystemEventTrigger.registerReceiver();
    }

    private void triggerValidCheck() {
        if (this.mSystemEventTrigger == null) {
            setupSystemEventTrigger();
        }
    }

    @PublicMethod
    public VideoSession getVideoSession() {
        triggerValidCheck();
        VideoSession acquire = this.mSessionCache.acquire();
        if (acquire == null) {
            acquire = new VideoSession();
        }
        this.mSystemEventTrigger.register(acquire.getMessenger());
        return acquire;
    }

    @PublicMethod
    public void recycle(@NonNull VideoSession videoSession) {
        if (this.mSystemEventTrigger != null) {
            this.mSystemEventTrigger.unregister(videoSession.getMessenger());
        }
        this.mSessionCache.release((SynchronizedFIFOPool<VideoSession>) videoSession);
    }

    @PublicMethod
    public void sendEventToAll(@NonNull VideoEvent videoEvent) {
        if (this.mSystemEventTrigger != null) {
            this.mSystemEventTrigger.triggerEvent(videoEvent);
        }
    }

    @PublicMethod
    public void release() {
        if (this.mSystemEventTrigger != null) {
            this.mSystemEventTrigger.clear();
            this.mSystemEventTrigger.unregisterReceiver();
            this.mSystemEventTrigger = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static final class Holder {
        public static final VideoSessionManager mInstance = new VideoSessionManager();

        private Holder() {
        }
    }
}

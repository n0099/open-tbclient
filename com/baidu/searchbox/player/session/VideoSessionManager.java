package com.baidu.searchbox.player.session;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.event.SystemEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.pool.SynchronizedFIFOPool;
/* loaded from: classes3.dex */
public class VideoSessionManager {
    public SynchronizedFIFOPool<VideoSession> mSessionCache;
    public SystemEventTrigger mSystemEventTrigger;

    /* loaded from: classes3.dex */
    public static final class Holder {
        public static final VideoSessionManager mInstance = new VideoSessionManager();
    }

    @PublicMethod
    public static VideoSessionManager getInstance() {
        return Holder.mInstance;
    }

    private void setupSystemEventTrigger() {
        SystemEventTrigger systemEventTrigger = new SystemEventTrigger();
        this.mSystemEventTrigger = systemEventTrigger;
        systemEventTrigger.registerReceiver();
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
        SystemEventTrigger systemEventTrigger = this.mSystemEventTrigger;
        if (systemEventTrigger != null) {
            systemEventTrigger.unregister(videoSession.getMessenger());
        }
        this.mSessionCache.release((SynchronizedFIFOPool<VideoSession>) videoSession);
    }

    @PublicMethod
    public void release() {
        SystemEventTrigger systemEventTrigger = this.mSystemEventTrigger;
        if (systemEventTrigger != null) {
            systemEventTrigger.clear();
            this.mSystemEventTrigger.unregisterReceiver();
            this.mSystemEventTrigger = null;
        }
    }

    @PublicMethod
    public void sendEventToAll(@NonNull VideoEvent videoEvent) {
        SystemEventTrigger systemEventTrigger = this.mSystemEventTrigger;
        if (systemEventTrigger != null) {
            systemEventTrigger.triggerEvent(videoEvent);
        }
    }

    public VideoSessionManager() {
        this.mSessionCache = new SynchronizedFIFOPool<>(10);
    }
}

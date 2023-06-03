package com.baidu.searchbox.player.session;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.event.SystemEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes4.dex */
public class VideoSessionManager {
    public static final String TAG = "VideoSessionManager";
    public final ArrayMap<String, String> mSessionIdCache;
    public SystemEventTrigger mSystemEventTrigger;

    /* loaded from: classes4.dex */
    public static final class Holder {
        public static final VideoSessionManager mInstance = new VideoSessionManager();
    }

    public VideoSessionManager() {
        this.mSessionIdCache = new ArrayMap<>();
    }

    @NonNull
    private String generateSessionId() {
        String replace = UUID.randomUUID().toString().toLowerCase(Locale.ROOT).replace("-", "");
        BdVideoLog.d(TAG, "generateSessionId:" + replace);
        return replace;
    }

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

    public VideoSession createVideoSession() {
        return new VideoSession();
    }

    public boolean isBatteryCharging() {
        SystemEventTrigger systemEventTrigger = this.mSystemEventTrigger;
        if (systemEventTrigger != null) {
            return systemEventTrigger.isBatteryCharging();
        }
        return false;
    }

    public void release() {
        SystemEventTrigger systemEventTrigger = this.mSystemEventTrigger;
        if (systemEventTrigger != null) {
            systemEventTrigger.clear();
            this.mSystemEventTrigger.unregisterReceiver();
            this.mSystemEventTrigger = null;
        }
        this.mSessionIdCache.clear();
    }

    public void bindPlayer(@NonNull BDVideoPlayer bDVideoPlayer) {
        triggerValidCheck();
        BdVideoLog.d("session manager bind player =>" + bDVideoPlayer);
        this.mSystemEventTrigger.bindMessenger(bDVideoPlayer.getMessenger());
    }

    public void recycle(@NonNull VideoSession videoSession) {
        videoSession.reset();
    }

    public void sendEventToAll(@NonNull VideoEvent videoEvent) {
        SystemEventTrigger systemEventTrigger = this.mSystemEventTrigger;
        if (systemEventTrigger != null) {
            systemEventTrigger.triggerEvent(videoEvent);
        }
    }

    public void unbindPlayer(@NonNull BDVideoPlayer bDVideoPlayer) {
        BdVideoLog.d("session manager unbind player =>" + bDVideoPlayer);
        SystemEventTrigger systemEventTrigger = this.mSystemEventTrigger;
        if (systemEventTrigger != null) {
            systemEventTrigger.unbindMessenger(bDVideoPlayer.getMessenger());
        }
    }

    @NonNull
    public String getSessionId(@NonNull String str) {
        String remove = this.mSessionIdCache.remove(str);
        if (TextUtils.isEmpty(remove)) {
            remove = generateSessionId();
            this.mSessionIdCache.put(str, remove);
        }
        BdVideoLog.d(TAG, "getSessionId:" + remove + ",key:" + str);
        return remove;
    }
}

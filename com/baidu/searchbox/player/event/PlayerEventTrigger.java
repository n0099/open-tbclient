package com.baidu.searchbox.player.event;

import android.support.annotation.NonNull;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class PlayerEventTrigger extends AbsEventTrigger {
    private ArrayList<Integer> mAttentionEventArray = new ArrayList<>(9);

    public PlayerEventTrigger() {
        initAttentionArray();
    }

    public void onBufferingUpdate(int i) {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_BUFFER_UPDATE));
    }

    public void onCompletion() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_COMPLETE));
    }

    public boolean onError(int i, int i2, Object obj) {
        VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_ERROR);
        obtainEvent.putExtra(1, Integer.valueOf(i));
        obtainEvent.putExtra(2, Integer.valueOf(i2));
        obtainEvent.putExtra(3, obj);
        triggerEvent(obtainEvent);
        return true;
    }

    public boolean onInfo(int i, int i2, Object obj) {
        BdVideoLog.d("player trigger on info what:" + i);
        if (filterOnInfoEvent(i)) {
            VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_INFO);
            obtainEvent.putExtra(1, Integer.valueOf(i));
            obtainEvent.putExtra(2, Integer.valueOf(i2));
            obtainEvent.putExtra(3, obj);
            triggerEvent(obtainEvent);
            return false;
        }
        return false;
    }

    public void onPrepared() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_PREPARED));
    }

    public void onSeekComplete() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_SEEK_COMPLETE));
    }

    public void onPlayerDetach() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_PLAYER_DETACH));
    }

    public void onPlayerAttach() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_PLAYER_ATTACH));
    }

    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED);
        obtainEvent.putExtra(5, Integer.valueOf(i));
        obtainEvent.putExtra(6, Integer.valueOf(i2));
        triggerEvent(obtainEvent);
    }

    @Override // com.baidu.searchbox.player.event.AbsEventTrigger, com.baidu.searchbox.player.event.IEventTrigger
    public void triggerEvent(@NonNull VideoEvent videoEvent) {
        super.triggerEvent(videoEvent);
    }

    private void initAttentionArray() {
        this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL));
        this.mAttentionEventArray.add(701);
        this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_BUFFERING_END));
        this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_EXTEND_VIDEO_CACHE_PROGRESS));
        this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_EXTEND_VIDEO_DOWNLOAD_SPEED));
        this.mAttentionEventArray.add(5000);
        this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_STREAM_RECONNECED));
        this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_STREAM_RECONNECTING));
        this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_LOOP_REPLAYED));
        this.mAttentionEventArray.add(Integer.valueOf((int) CyberPlayerManager.MEDIA_INFO_RESTART_PLAYED));
    }

    private boolean filterOnInfoEvent(int i) {
        return this.mAttentionEventArray.contains(Integer.valueOf(i));
    }
}

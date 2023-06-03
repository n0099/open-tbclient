package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class PlayerEventTrigger extends SingleTargetTrigger {
    public final ArrayList<Integer> mAttentionEventArray = new ArrayList<>(25);
    public boolean ignoreInfoEventFilter = false;

    public PlayerEventTrigger() {
        initAttentionArray();
    }

    public void onCompletion() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_COMPLETE));
    }

    public void onPlayerAttach() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_PLAYER_ATTACH));
    }

    public void onPlayerDetach() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_PLAYER_DETACH));
    }

    public void onPrepared() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_PREPARED));
    }

    public void onSeekComplete() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_SEEK_COMPLETE));
    }

    public void sendAttachKernelLayerEvent() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_KERNEL_LAYER_ATTACH));
    }

    public void updateDataSource() {
        triggerEvent(PlayerEvent.obtainEvent(PlayerEvent.ACTION_UPDATE_DATA_SOURCE));
    }

    private boolean filterOnInfoEvent(int i) {
        return this.mAttentionEventArray.contains(Integer.valueOf(i));
    }

    public void goBackOrForeground(boolean z) {
        VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_GO_BACK_OR_FOREGROUND);
        obtainEvent.putExtra(4, Boolean.valueOf(z));
        triggerEvent(obtainEvent);
    }

    public void ignoreInfoEventFilter(boolean z) {
        this.ignoreInfoEventFilter = z;
    }

    public void onBufferingUpdate(int i) {
        VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_BUFFER_UPDATE);
        obtainEvent.putExtra(2, Integer.valueOf(i));
        obtainEvent.setLogLevel(1);
        triggerEvent(obtainEvent);
    }

    public void setDataSource(@NonNull BasicVideoSeries basicVideoSeries) {
        VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_SET_DATA_SOURCE);
        obtainEvent.putExtra(3, basicVideoSeries);
        obtainEvent.setPriority(1);
        triggerEvent(obtainEvent);
    }

    @Override // com.baidu.searchbox.player.event.SingleTargetTrigger, com.baidu.searchbox.player.event.IEventTrigger
    public void triggerEvent(@NonNull VideoEvent videoEvent) {
        super.triggerEvent(videoEvent);
    }

    private void initAttentionArray() {
        this.mAttentionEventArray.add(904);
        this.mAttentionEventArray.add(701);
        this.mAttentionEventArray.add(702);
        this.mAttentionEventArray.add(11004);
        this.mAttentionEventArray.add(11005);
        this.mAttentionEventArray.add(946);
        this.mAttentionEventArray.add(924);
        this.mAttentionEventArray.add(5000);
        this.mAttentionEventArray.add(937);
        this.mAttentionEventArray.add(936);
        this.mAttentionEventArray.add(955);
        this.mAttentionEventArray.add(956);
        this.mAttentionEventArray.add(910);
        this.mAttentionEventArray.add(10103);
        this.mAttentionEventArray.add(12005);
        this.mAttentionEventArray.add(12006);
        this.mAttentionEventArray.add(10009);
        this.mAttentionEventArray.add(11008);
        this.mAttentionEventArray.add(11006);
        this.mAttentionEventArray.add(10102);
        this.mAttentionEventArray.add(11011);
        this.mAttentionEventArray.add(11012);
        this.mAttentionEventArray.add(11013);
        this.mAttentionEventArray.add(11014);
        this.mAttentionEventArray.add(11016);
        this.mAttentionEventArray.add(12009);
        this.mAttentionEventArray.add(12010);
    }

    public boolean onError(int i, int i2, Object obj) {
        VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_ERROR);
        obtainEvent.putExtra(1, Integer.valueOf(i));
        obtainEvent.putExtra(2, Integer.valueOf(i2));
        obtainEvent.putExtra(3, obj);
        triggerEvent(obtainEvent);
        return true;
    }

    public void onMediaSourceChanged(int i, int i2, Object obj) {
        VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_MEDIA_SOURCE_CHANGED);
        obtainEvent.putExtra(7, Integer.valueOf(i));
        obtainEvent.putExtra(8, Integer.valueOf(i2));
        obtainEvent.putExtra(3, obj);
        triggerEvent(obtainEvent);
    }

    public boolean onInfo(int i, int i2, Object obj) {
        BdVideoLog.v("player trigger on info what:" + i);
        if (this.ignoreInfoEventFilter || filterOnInfoEvent(i)) {
            VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_ON_INFO);
            if (i == 910) {
                obtainEvent.setLogLevel(1);
            }
            obtainEvent.putExtra(1, Integer.valueOf(i));
            obtainEvent.putExtra(2, Integer.valueOf(i2));
            obtainEvent.putExtra(3, obj);
            triggerEvent(obtainEvent);
            return false;
        }
        return false;
    }

    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        VideoEvent obtainEvent = PlayerEvent.obtainEvent(PlayerEvent.ACTION_VIDEO_SIZE_CHANGED);
        obtainEvent.putExtra(5, Integer.valueOf(i));
        obtainEvent.putExtra(6, Integer.valueOf(i2));
        triggerEvent(obtainEvent);
    }
}

package com.baidu.searchbox.player.plugin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.helper.PlayPerRecord;
/* loaded from: classes2.dex */
public class SpeedMonitorPlugin extends AbsPlugin {
    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        return new int[]{6};
    }

    private void addPlaySpeedRecord(long j, String str, String str2) {
        PlayPerRecord.putRecord(new PlayPerRecord.PerRecord(j, System.currentTimeMillis(), str, str2));
    }

    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
        super.onVideoEventNotify(videoEvent);
        if (StatisticsEvent.ACTION_ADD_PLAY_SPEED_RECORD.equals(videoEvent.getAction())) {
            addPlaySpeedRecord(videoEvent.getLongExtra(5), videoEvent.getStringExtra(6), videoEvent.getStringExtra(7));
        }
    }
}

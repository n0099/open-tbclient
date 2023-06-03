package com.baidu.searchbox.player.helper;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDVideoPlayer;
/* loaded from: classes4.dex */
public class ProgressHelper extends AbsHandlerTask {
    public final BDVideoPlayer mPlayer;

    public ProgressHelper(@NonNull BDVideoPlayer bDVideoPlayer) {
        this.mPlayer = bDVideoPlayer;
    }

    private void callPlayerBack(int i, int i2, int i3) {
        if (i2 > 0) {
            this.mPlayer.getPlayerCallbackManager().onUpdateProgress(i, (i3 * 100) / i2, i2);
        }
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    public void doTask() {
        int position = this.mPlayer.getPosition();
        int positionMs = this.mPlayer.getPositionMs();
        int duration = this.mPlayer.getDuration();
        int bufferingPosition = this.mPlayer.getBufferingPosition();
        this.mPlayer.getControlEventTrigger().syncPos(position, positionMs, duration, bufferingPosition);
        callPlayerBack(position, duration, bufferingPosition);
    }
}

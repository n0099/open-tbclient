package com.baidu.searchbox.player.helper;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes14.dex */
public class ProgressHelper extends AbsHandlerTask {
    private BDVideoPlayer mPlayer;

    public ProgressHelper(@NonNull BDVideoPlayer bDVideoPlayer) {
        this.mPlayer = bDVideoPlayer;
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    @PublicMethod
    public void doTask() {
        int position = this.mPlayer.getPosition();
        int duration = this.mPlayer.getDuration();
        int bufferingPosition = this.mPlayer.getBufferingPosition();
        this.mPlayer.getVideoSession().getControlEventTrigger().syncPos(position, duration, bufferingPosition);
        callPlayerBack(position, duration, bufferingPosition);
    }

    private void callPlayerBack(int i, int i2, int i3) {
        if (i2 > 0) {
            this.mPlayer.getPlayerCallbackManager().onUpdateProgress(i, (i3 * 100) / i2, i2);
        }
    }
}

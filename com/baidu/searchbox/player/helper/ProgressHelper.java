package com.baidu.searchbox.player.helper;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes2.dex */
public class ProgressHelper extends AbsHandlerTask {
    public BDVideoPlayer mPlayer;

    public ProgressHelper(@NonNull BDVideoPlayer bDVideoPlayer) {
        this.mPlayer = bDVideoPlayer;
    }

    private void callPlayerBack(int i2, int i3, int i4) {
        if (i3 > 0) {
            this.mPlayer.getPlayerCallbackManager().onUpdateProgress(i2, (i4 * 100) / i3, i3);
        }
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
}

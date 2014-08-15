package com.baidu.tbadk.core.util;

import android.media.MediaPlayer;
/* loaded from: classes.dex */
class aq implements MediaPlayer.OnCompletionListener {
    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
    }
}

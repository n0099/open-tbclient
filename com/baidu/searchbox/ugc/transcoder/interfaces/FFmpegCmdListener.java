package com.baidu.searchbox.ugc.transcoder.interfaces;
/* loaded from: classes4.dex */
public interface FFmpegCmdListener {
    void onCompletion();

    boolean onError(int i, int i2, Object obj);

    boolean onInfo(int i, int i2, Object obj);
}

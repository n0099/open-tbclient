package com.baidu.media.transcoder;

import com.baidu.media.transcoder.cyber.MediaTranscoder;
/* loaded from: classes6.dex */
public class e {
    private c aMH = null;

    public c dj(int i) {
        if (i == 0) {
            this.aMH = new com.baidu.media.transcoder.a.c();
        } else {
            this.aMH = new MediaTranscoder();
        }
        return this.aMH;
    }
}

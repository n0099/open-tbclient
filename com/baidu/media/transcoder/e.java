package com.baidu.media.transcoder;

import com.baidu.media.transcoder.cyber.MediaTranscoder;
/* loaded from: classes6.dex */
public class e {
    private c aMI = null;

    public c dj(int i) {
        if (i == 0) {
            this.aMI = new com.baidu.media.transcoder.a.c();
        } else {
            this.aMI = new MediaTranscoder();
        }
        return this.aMI;
    }
}

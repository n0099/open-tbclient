package com.baidu.media.transcoder;

import com.baidu.media.transcoder.cyber.MediaTranscoder;
/* loaded from: classes5.dex */
public class e {
    private c aIC = null;

    public c cT(int i) {
        if (i == 0) {
            this.aIC = new com.baidu.media.transcoder.a.c();
        } else {
            this.aIC = new MediaTranscoder();
        }
        return this.aIC;
    }
}

package com.baidu.media.transcoder;

import com.baidu.media.transcoder.cyber.MediaTranscoder;
/* loaded from: classes4.dex */
public class e {
    private c aHK = null;

    public c cS(int i) {
        if (i == 0) {
            this.aHK = new com.baidu.media.transcoder.a.c();
        } else {
            this.aHK = new MediaTranscoder();
        }
        return this.aHK;
    }
}

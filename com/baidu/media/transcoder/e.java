package com.baidu.media.transcoder;

import com.baidu.media.transcoder.cyber.MediaTranscoder;
/* loaded from: classes6.dex */
public class e {
    private c aMJ = null;

    public c dj(int i) {
        if (i == 0) {
            this.aMJ = new com.baidu.media.transcoder.a.c();
        } else {
            this.aMJ = new MediaTranscoder();
        }
        return this.aMJ;
    }
}

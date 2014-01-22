package com.baidu.adp.lib.gif;

import com.baidu.adp.lib.gif.GifView;
/* loaded from: classes.dex */
/* synthetic */ class e {
    static final /* synthetic */ int[] a = new int[GifView.GifImageType.values().length];

    static {
        try {
            a[GifView.GifImageType.WAIT_FINISH.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[GifView.GifImageType.COVER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[GifView.GifImageType.SYNC_DECODER.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}

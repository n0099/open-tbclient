package com.baidu.adp.lib.gif;

import com.baidu.adp.lib.gif.GifView;
/* loaded from: classes.dex */
/* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f492a = new int[GifView.GifImageType.values().length];

    static {
        try {
            f492a[GifView.GifImageType.WAIT_FINISH.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f492a[GifView.GifImageType.COVER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f492a[GifView.GifImageType.SYNC_DECODER.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}

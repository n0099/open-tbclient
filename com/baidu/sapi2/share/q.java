package com.baidu.sapi2.share;
/* loaded from: classes19.dex */
/* synthetic */ class q {
    static final /* synthetic */ int[] a = new int[ShareEvent.values().length];

    static {
        try {
            a[ShareEvent.VALIDATE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[ShareEvent.INVALIDATE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[ShareEvent.SYNC_REQ.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}

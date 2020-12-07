package com.baidu.helios.ids.gaid;

import com.baidu.helios.common.a.b;
/* loaded from: classes17.dex */
class c {

    /* loaded from: classes17.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }

        public a(Throwable th) {
            super(th);
        }
    }

    public static String a(byte[] bArr) {
        return new String(new b().B(bArr));
    }
}

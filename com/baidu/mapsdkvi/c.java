package com.baidu.mapsdkvi;

import android.net.NetworkInfo;
/* loaded from: classes4.dex */
public class c {
    public String a;
    public int b;
    public int c;

    /* renamed from: com.baidu.mapsdkvi.c$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[NetworkInfo.State.values().length];

        static {
            try {
                a[NetworkInfo.State.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[NetworkInfo.State.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[NetworkInfo.State.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[NetworkInfo.State.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[NetworkInfo.State.SUSPENDED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public c(NetworkInfo networkInfo) {
        this.a = networkInfo.getTypeName();
        this.b = networkInfo.getType();
        switch (AnonymousClass1.a[networkInfo.getState().ordinal()]) {
            case 1:
                this.c = 2;
                return;
            case 2:
                this.c = 1;
                return;
            default:
                this.c = 0;
                return;
        }
    }
}

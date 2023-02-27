package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.PanoStateError;
/* loaded from: classes2.dex */
public /* synthetic */ class b {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[HttpClient.HttpStateError.values().length];
        b = iArr;
        try {
            iArr[HttpClient.HttpStateError.NETWORK_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[HttpClient.HttpStateError.INNER_ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[PanoStateError.values().length];
        a = iArr2;
        try {
            iArr2[PanoStateError.b.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[PanoStateError.c.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[PanoStateError.d.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[PanoStateError.a.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
    }
}

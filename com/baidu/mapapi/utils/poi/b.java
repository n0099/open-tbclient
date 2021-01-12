package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.PanoStateError;
/* loaded from: classes6.dex */
/* synthetic */ class b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f2971a;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ int[] f2972b = new int[HttpClient.HttpStateError.values().length];

    static {
        try {
            f2972b[HttpClient.HttpStateError.NETWORK_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2972b[HttpClient.HttpStateError.INNER_ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        f2971a = new int[PanoStateError.values().length];
        try {
            f2971a[PanoStateError.PANO_UID_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2971a[PanoStateError.PANO_NOT_FOUND.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f2971a[PanoStateError.PANO_NO_TOKEN.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f2971a[PanoStateError.PANO_NO_ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError e6) {
        }
    }
}

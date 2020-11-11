package com.baidu.mapapi.utils.poi;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.platform.comapi.pano.PanoStateError;
/* loaded from: classes7.dex */
/* synthetic */ class b {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f2165a;
    static final /* synthetic */ int[] b = new int[HttpClient.HttpStateError.values().length];

    static {
        try {
            b[HttpClient.HttpStateError.NETWORK_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            b[HttpClient.HttpStateError.INNER_ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        f2165a = new int[PanoStateError.values().length];
        try {
            f2165a[PanoStateError.PANO_UID_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2165a[PanoStateError.PANO_NOT_FOUND.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f2165a[PanoStateError.PANO_NO_TOKEN.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f2165a[PanoStateError.PANO_NO_ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError e6) {
        }
    }
}

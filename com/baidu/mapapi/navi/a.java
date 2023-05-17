package com.baidu.mapapi.navi;

import com.baidu.mapapi.navi.NaviParaOption;
/* loaded from: classes3.dex */
public /* synthetic */ class a {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[NaviParaOption.NaviRoutePolicy.values().length];
        a = iArr;
        try {
            iArr[NaviParaOption.NaviRoutePolicy.BLK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[NaviParaOption.NaviRoutePolicy.TIME.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[NaviParaOption.NaviRoutePolicy.DIS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[NaviParaOption.NaviRoutePolicy.FEE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[NaviParaOption.NaviRoutePolicy.HIGHWAY.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            a[NaviParaOption.NaviRoutePolicy.DEFAULT.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
    }
}

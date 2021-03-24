package com.baidu.ar.npc;

import com.baidu.ar.npc.BaiduArView;
/* loaded from: classes2.dex */
public /* synthetic */ class ae {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f4165a;

    static {
        int[] iArr = new int[BaiduArView.i.values().length];
        f4165a = iArr;
        try {
            iArr[BaiduArView.i.EStatSingleFingerCandidate.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4165a[BaiduArView.i.EStatTwoFingersCandidate.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f4165a[BaiduArView.i.EStatScroll.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f4165a[BaiduArView.i.EStatTwoFingersScroll.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f4165a[BaiduArView.i.EStatPinchAndUnpinch.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f4165a[BaiduArView.i.EStatLongPresss.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f4165a[BaiduArView.i.EScrollAfterLongPress.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f4165a[BaiduArView.i.EStatPinch.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f4165a[BaiduArView.i.EStatUnPinch.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f4165a[BaiduArView.i.EStatUnknown.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}

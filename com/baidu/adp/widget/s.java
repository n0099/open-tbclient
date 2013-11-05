package com.baidu.adp.widget;

import com.baidu.adp.widget.VerticalTranslateLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public /* synthetic */ class s {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f605a = new int[VerticalTranslateLayout.TrackDirection.values().length];

    static {
        try {
            f605a[VerticalTranslateLayout.TrackDirection.top.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f605a[VerticalTranslateLayout.TrackDirection.bottom.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f605a[VerticalTranslateLayout.TrackDirection.vertical.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}

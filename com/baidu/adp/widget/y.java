package com.baidu.adp.widget;

import com.baidu.adp.widget.VerticalTranslateLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public /* synthetic */ class y {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f621a = new int[VerticalTranslateLayout.TrackDirection.values().length];

    static {
        try {
            f621a[VerticalTranslateLayout.TrackDirection.top.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f621a[VerticalTranslateLayout.TrackDirection.bottom.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f621a[VerticalTranslateLayout.TrackDirection.vertical.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}

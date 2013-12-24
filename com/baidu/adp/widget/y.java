package com.baidu.adp.widget;

import com.baidu.adp.widget.VerticalTranslateLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public /* synthetic */ class y {
    static final /* synthetic */ int[] a = new int[VerticalTranslateLayout.TrackDirection.values().length];

    static {
        try {
            a[VerticalTranslateLayout.TrackDirection.top.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[VerticalTranslateLayout.TrackDirection.bottom.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[VerticalTranslateLayout.TrackDirection.vertical.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}

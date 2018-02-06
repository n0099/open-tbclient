package com.baidu.ar.recorder.filter;

import android.content.Context;
/* loaded from: classes3.dex */
public class FilterManager {

    /* renamed from: com.baidu.ar.recorder.filter.FilterManager$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[FilterType.values().length];

        static {
            try {
                a[FilterType.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum FilterType {
        Normal,
        Blend,
        SoftLight,
        ToneCurve
    }

    public static c a(Context context, FilterType filterType) {
        int i = AnonymousClass1.a[filterType.ordinal()];
        return new b(context);
    }

    public static c b(Context context, FilterType filterType) {
        int i = AnonymousClass1.a[filterType.ordinal()];
        return new d(context);
    }
}

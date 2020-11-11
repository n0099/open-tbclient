package com.baidu.pano.platform.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Bitmap f2667a;

    public static void a(Context context) {
        f2667a = a("com/baidu/pano/platform/res/indoor_in.png");
    }

    private static Bitmap a(String str) {
        return BitmapFactory.decodeStream(a.class.getClassLoader().getResourceAsStream(str));
    }
}

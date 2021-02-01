package com.baidu.pano.platform.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Bitmap f3903a;

    public static void a(Context context) {
        f3903a = a("com/baidu/pano/platform/res/indoor_in.png");
    }

    private static Bitmap a(String str) {
        return BitmapFactory.decodeStream(a.class.getClassLoader().getResourceAsStream(str));
    }
}

package com.baidu.pano.platform.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/* loaded from: classes5.dex */
public class a {
    public static Bitmap a;

    public static void a(Context context) {
        a = a("com/baidu/pano/platform/res/indoor_in.png");
    }

    private static Bitmap a(String str) {
        return BitmapFactory.decodeStream(a.class.getClassLoader().getResourceAsStream(str));
    }
}

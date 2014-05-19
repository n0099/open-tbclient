package com.baidu.tbadk.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.x;
/* loaded from: classes.dex */
public class g {
    public static int a(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 3:
                    return 180;
                case 4:
                case 5:
                case 7:
                default:
                    return 0;
                case 6:
                    return 90;
                case 8:
                    return 270;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return 0;
        }
    }

    private static Bitmap a(int i) {
        Exception e;
        try {
            int a = a(x.c("camera.jpg"));
            Bitmap a2 = com.baidu.tbadk.core.util.g.a("camera.jpg", i);
            if (a != 0 && a2 != null) {
                try {
                    return com.baidu.tbadk.core.util.g.e(a2, a);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e("WriteUtil", "photoResult", "error = " + e.getMessage());
                    return null;
                }
            }
            return a2;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static Bitmap a(Context context, Uri uri, int i) {
        try {
            return com.baidu.tbadk.core.util.g.a(context, uri, i);
        } catch (Exception e) {
            BdLog.e("WriteUtil", "AlbumImageResult", "error = " + e.getMessage());
            return null;
        }
    }

    public static Bitmap a(int i, Context context, Uri uri, int i2) {
        if (i == 12001) {
            return a(i2);
        }
        return a(context, uri, i2);
    }
}

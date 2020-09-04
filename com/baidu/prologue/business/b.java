package com.baidu.prologue.business;

import android.graphics.Point;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class b {
    private static final b bKC = new b();
    private int bKA;
    private final int bKB;
    private final int bKx;
    private final int bKy;
    private int bKz;
    private final com.baidu.prologue.a.b.a bKw = com.baidu.prologue.a.b.a.bKm.get();
    private final boolean DEBUG = this.bKw.UU();

    private b() {
        DisplayMetrics displayMetrics = this.bKw.UK().getResources().getDisplayMetrics();
        this.bKy = displayMetrics.heightPixels;
        this.bKx = displayMetrics.widthPixels;
        this.bKB = displayMetrics.densityDpi;
    }

    public static b Vj() {
        return bKC;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point ad = ad(view);
        int i2 = this.bKx;
        int i3 = this.bKy;
        if (ad != null) {
            i2 = ad.x;
            i3 = ad.y;
            this.bKz = ad.x;
            this.bKA = ad.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.bKw.UW() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.bKB);
        String join = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, strArr);
        if (this.DEBUG) {
            Log.d("ClickInfoProvider", "createHotPictureParams info:" + join);
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                throw new IllegalStateException("May not got clickInfo.");
            }
        }
        return join;
    }

    public int[] Vk() {
        return this.bKz != 0 ? new int[]{this.bKz, this.bKA, this.bKB} : new int[]{this.bKx, this.bKy, this.bKB};
    }

    private Point ad(@NonNull View view) {
        Display display;
        if (Build.VERSION.SDK_INT < 17 || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}

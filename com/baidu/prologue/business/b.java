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
    private static final b bKy = new b();
    private final int bKt;
    private final int bKu;
    private int bKv;
    private int bKw;
    private final int bKx;
    private final com.baidu.prologue.a.b.a bKs = com.baidu.prologue.a.b.a.bKi.get();
    private final boolean DEBUG = this.bKs.UU();

    private b() {
        DisplayMetrics displayMetrics = this.bKs.UK().getResources().getDisplayMetrics();
        this.bKu = displayMetrics.heightPixels;
        this.bKt = displayMetrics.widthPixels;
        this.bKx = displayMetrics.densityDpi;
    }

    public static b Vj() {
        return bKy;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point ad = ad(view);
        int i2 = this.bKt;
        int i3 = this.bKu;
        if (ad != null) {
            i2 = ad.x;
            i3 = ad.y;
            this.bKv = ad.x;
            this.bKw = ad.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.bKs.UW() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.bKx);
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
        return this.bKv != 0 ? new int[]{this.bKv, this.bKw, this.bKx} : new int[]{this.bKt, this.bKu, this.bKx};
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

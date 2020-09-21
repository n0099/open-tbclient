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
/* loaded from: classes10.dex */
public class b {
    private static final b bMC = new b();
    private int bMA;
    private final int bMB;
    private final int bMx;
    private final int bMy;
    private int bMz;
    private final com.baidu.prologue.a.b.a bMw = com.baidu.prologue.a.b.a.bMm.get();
    private final boolean DEBUG = this.bMw.VD();

    private b() {
        DisplayMetrics displayMetrics = this.bMw.Vt().getResources().getDisplayMetrics();
        this.bMy = displayMetrics.heightPixels;
        this.bMx = displayMetrics.widthPixels;
        this.bMB = displayMetrics.densityDpi;
    }

    public static b VS() {
        return bMC;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point af = af(view);
        int i2 = this.bMx;
        int i3 = this.bMy;
        if (af != null) {
            i2 = af.x;
            i3 = af.y;
            this.bMz = af.x;
            this.bMA = af.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.bMw.VF() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.bMB);
        String join = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, strArr);
        if (this.DEBUG) {
            Log.d("ClickInfoProvider", "createHotPictureParams info:" + join);
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                throw new IllegalStateException("May not got clickInfo.");
            }
        }
        return join;
    }

    public int[] VT() {
        return this.bMz != 0 ? new int[]{this.bMz, this.bMA, this.bMB} : new int[]{this.bMx, this.bMy, this.bMB};
    }

    private Point af(@NonNull View view) {
        Display display;
        if (Build.VERSION.SDK_INT < 17 || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}

package com.baidu.prologue.business;

import android.graphics.Point;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
/* loaded from: classes14.dex */
public class b {
    private static final b cmq = new b();
    private final int cml;
    private final int cmm;
    private int cmn;
    private int cmo;
    private final int cmp;
    private final com.baidu.prologue.a.b.a cmk = com.baidu.prologue.a.b.a.clZ.get();
    private final boolean DEBUG = this.cmk.aes();

    private b() {
        DisplayMetrics displayMetrics = this.cmk.aei().getResources().getDisplayMetrics();
        this.cmm = displayMetrics.heightPixels;
        this.cml = displayMetrics.widthPixels;
        this.cmp = displayMetrics.densityDpi;
    }

    public static b aeH() {
        return cmq;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point ao = ao(view);
        int i2 = this.cml;
        int i3 = this.cmm;
        if (ao != null) {
            i2 = ao.x;
            i3 = ao.y;
            this.cmn = ao.x;
            this.cmo = ao.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.cmk.aeu() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.cmp);
        String join = TextUtils.join(",", strArr);
        if (this.DEBUG) {
            Log.d("ClickInfoProvider", "createHotPictureParams info:" + join);
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                throw new IllegalStateException("May not got clickInfo.");
            }
        }
        return join;
    }

    public int[] aeI() {
        return this.cmn != 0 ? new int[]{this.cmn, this.cmo, this.cmp} : new int[]{this.cml, this.cmm, this.cmp};
    }

    private Point ao(@NonNull View view) {
        Display display;
        if (Build.VERSION.SDK_INT < 17 || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}

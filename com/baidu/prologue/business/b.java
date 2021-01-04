package com.baidu.prologue.business;

import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public class b {
    private static final b ctv = new b();
    private final int cto;
    private final int ctp;
    private int ctq;
    private int cts;
    private final int ctu;
    private final com.baidu.prologue.a.b.a ctn = com.baidu.prologue.a.b.a.ctd.get();
    private final boolean DEBUG = this.ctn.ago();

    private b() {
        DisplayMetrics displayMetrics = this.ctn.age().getResources().getDisplayMetrics();
        this.ctp = displayMetrics.heightPixels;
        this.cto = displayMetrics.widthPixels;
        this.ctu = displayMetrics.densityDpi;
    }

    public static b agD() {
        return ctv;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point aq = aq(view);
        int i2 = this.cto;
        int i3 = this.ctp;
        if (aq != null) {
            i2 = aq.x;
            i3 = aq.y;
            this.ctq = aq.x;
            this.cts = aq.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.ctn.agq() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.ctu);
        String join = TextUtils.join(",", strArr);
        if (this.DEBUG) {
            Log.d("ClickInfoProvider", "createHotPictureParams info:" + join);
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                throw new IllegalStateException("May not got clickInfo.");
            }
        }
        return join;
    }

    public int[] agE() {
        return this.ctq != 0 ? new int[]{this.ctq, this.cts, this.ctu} : new int[]{this.cto, this.ctp, this.ctu};
    }

    private Point aq(@NonNull View view) {
        Display display;
        if (Build.VERSION.SDK_INT < 17 || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}

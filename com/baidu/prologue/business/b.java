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
    private static final b coF = new b();
    private final int coA;
    private final int coB;
    private int coC;
    private int coD;
    private final int coE;
    private final com.baidu.prologue.a.b.a coz = com.baidu.prologue.a.b.a.cop.get();
    private final boolean DEBUG = this.coz.acv();

    private b() {
        DisplayMetrics displayMetrics = this.coz.acl().getResources().getDisplayMetrics();
        this.coB = displayMetrics.heightPixels;
        this.coA = displayMetrics.widthPixels;
        this.coE = displayMetrics.densityDpi;
    }

    public static b acK() {
        return coF;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point aq = aq(view);
        int i2 = this.coA;
        int i3 = this.coB;
        if (aq != null) {
            i2 = aq.x;
            i3 = aq.y;
            this.coC = aq.x;
            this.coD = aq.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.coz.acx() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.coE);
        String join = TextUtils.join(",", strArr);
        if (this.DEBUG) {
            Log.d("ClickInfoProvider", "createHotPictureParams info:" + join);
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                throw new IllegalStateException("May not got clickInfo.");
            }
        }
        return join;
    }

    public int[] acL() {
        return this.coC != 0 ? new int[]{this.coC, this.coD, this.coE} : new int[]{this.coA, this.coB, this.coE};
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

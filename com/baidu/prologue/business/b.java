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
/* loaded from: classes6.dex */
public class b {
    private static final b bzN = new b();
    private final int bzI;
    private final int bzJ;
    private int bzK;
    private int bzL;
    private final int bzM;
    private final com.baidu.prologue.a.b.a bzH = com.baidu.prologue.a.b.a.bzx.get();
    private final boolean DEBUG = this.bzH.ND();

    private b() {
        DisplayMetrics displayMetrics = this.bzH.Nt().getResources().getDisplayMetrics();
        this.bzJ = displayMetrics.heightPixels;
        this.bzI = displayMetrics.widthPixels;
        this.bzM = displayMetrics.densityDpi;
    }

    public static b NS() {
        return bzN;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point Z = Z(view);
        int i2 = this.bzI;
        int i3 = this.bzJ;
        if (Z != null) {
            i2 = Z.x;
            i3 = Z.y;
            this.bzK = Z.x;
            this.bzL = Z.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.bzH.NF() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.bzM);
        String join = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, strArr);
        if (this.DEBUG) {
            Log.d("ClickInfoProvider", "createHotPictureParams info:" + join);
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                throw new IllegalStateException("May not got clickInfo.");
            }
        }
        return join;
    }

    public int[] NT() {
        return this.bzK != 0 ? new int[]{this.bzK, this.bzL, this.bzM} : new int[]{this.bzI, this.bzJ, this.bzM};
    }

    private Point Z(@NonNull View view) {
        Display display;
        if (Build.VERSION.SDK_INT < 17 || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}

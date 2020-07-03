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
    private static final b bEB = new b();
    private final int bEA;
    private final int bEw;
    private final int bEx;
    private int bEy;
    private int bEz;
    private final com.baidu.prologue.a.b.a bEv = com.baidu.prologue.a.b.a.bEl.get();
    private final boolean DEBUG = this.bEv.OJ();

    private b() {
        DisplayMetrics displayMetrics = this.bEv.Oz().getResources().getDisplayMetrics();
        this.bEx = displayMetrics.heightPixels;
        this.bEw = displayMetrics.widthPixels;
        this.bEA = displayMetrics.densityDpi;
    }

    public static b OY() {
        return bEB;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point Z = Z(view);
        int i2 = this.bEw;
        int i3 = this.bEx;
        if (Z != null) {
            i2 = Z.x;
            i3 = Z.y;
            this.bEy = Z.x;
            this.bEz = Z.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.bEv.OL() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.bEA);
        String join = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, strArr);
        if (this.DEBUG) {
            Log.d("ClickInfoProvider", "createHotPictureParams info:" + join);
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                throw new IllegalStateException("May not got clickInfo.");
            }
        }
        return join;
    }

    public int[] OZ() {
        return this.bEy != 0 ? new int[]{this.bEy, this.bEz, this.bEA} : new int[]{this.bEw, this.bEx, this.bEA};
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

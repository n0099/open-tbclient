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
/* loaded from: classes19.dex */
public class b {
    private static final b bTl = new b();
    private final int bTg;
    private final int bTh;
    private int bTi;
    private int bTj;
    private final int bTk;
    private final com.baidu.prologue.a.b.a bTf = com.baidu.prologue.a.b.a.bSV.get();
    private final boolean DEBUG = this.bTf.XA();

    private b() {
        DisplayMetrics displayMetrics = this.bTf.Xq().getResources().getDisplayMetrics();
        this.bTh = displayMetrics.heightPixels;
        this.bTg = displayMetrics.widthPixels;
        this.bTk = displayMetrics.densityDpi;
    }

    public static b XP() {
        return bTl;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point ag = ag(view);
        int i2 = this.bTg;
        int i3 = this.bTh;
        if (ag != null) {
            i2 = ag.x;
            i3 = ag.y;
            this.bTi = ag.x;
            this.bTj = ag.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.bTf.XC() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.bTk);
        String join = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, strArr);
        if (this.DEBUG) {
            Log.d("ClickInfoProvider", "createHotPictureParams info:" + join);
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                throw new IllegalStateException("May not got clickInfo.");
            }
        }
        return join;
    }

    public int[] XQ() {
        return this.bTi != 0 ? new int[]{this.bTi, this.bTj, this.bTk} : new int[]{this.bTg, this.bTh, this.bTk};
    }

    private Point ag(@NonNull View view) {
        Display display;
        if (Build.VERSION.SDK_INT < 17 || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}

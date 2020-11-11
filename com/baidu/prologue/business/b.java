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
    private static final b chu = new b();
    private final int chp;
    private final int chq;
    private int chr;
    private int chs;
    private final int cht;
    private final com.baidu.prologue.a.b.a cho = com.baidu.prologue.a.b.a.che.get();
    private final boolean DEBUG = this.cho.abT();

    private b() {
        DisplayMetrics displayMetrics = this.cho.abJ().getResources().getDisplayMetrics();
        this.chq = displayMetrics.heightPixels;
        this.chp = displayMetrics.widthPixels;
        this.cht = displayMetrics.densityDpi;
    }

    public static b aci() {
        return chu;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point am = am(view);
        int i2 = this.chp;
        int i3 = this.chq;
        if (am != null) {
            i2 = am.x;
            i3 = am.y;
            this.chr = am.x;
            this.chs = am.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.cho.abV() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.cht);
        String join = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, strArr);
        if (this.DEBUG) {
            Log.d("ClickInfoProvider", "createHotPictureParams info:" + join);
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                throw new IllegalStateException("May not got clickInfo.");
            }
        }
        return join;
    }

    public int[] acj() {
        return this.chr != 0 ? new int[]{this.chr, this.chs, this.cht} : new int[]{this.chp, this.chq, this.cht};
    }

    private Point am(@NonNull View view) {
        Display display;
        if (Build.VERSION.SDK_INT < 17 || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}

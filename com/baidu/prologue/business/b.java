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
    private static final b bsg = new b();
    private final int bsb;
    private final int bsc;
    private int bsd;
    private int bse;
    private final int bsf;
    private final com.baidu.prologue.a.b.a bsa = com.baidu.prologue.a.b.a.brQ.get();
    private final boolean DEBUG = this.bsa.Lr();

    private b() {
        DisplayMetrics displayMetrics = this.bsa.Lh().getResources().getDisplayMetrics();
        this.bsc = displayMetrics.heightPixels;
        this.bsb = displayMetrics.widthPixels;
        this.bsf = displayMetrics.densityDpi;
    }

    public static b LG() {
        return bsg;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point aa = aa(view);
        int i2 = this.bsb;
        int i3 = this.bsc;
        if (aa != null) {
            i2 = aa.x;
            i3 = aa.y;
            this.bsd = aa.x;
            this.bse = aa.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.bsa.Lt() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.bsf);
        String join = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, strArr);
        if (this.DEBUG) {
            Log.d("ClickInfoProvider", "createHotPictureParams info:" + join);
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                throw new IllegalStateException("May not got clickInfo.");
            }
        }
        return join;
    }

    public int[] LH() {
        return this.bsd != 0 ? new int[]{this.bsd, this.bse, this.bsf} : new int[]{this.bsb, this.bsc, this.bsf};
    }

    private Point aa(@NonNull View view) {
        Display display;
        if (Build.VERSION.SDK_INT < 17 || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}

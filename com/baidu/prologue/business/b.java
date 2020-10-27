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
    private static final b cbI = new b();
    private final int cbD;
    private final int cbE;
    private int cbF;
    private int cbG;
    private final int cbH;
    private final com.baidu.prologue.a.b.a cbC = com.baidu.prologue.a.b.a.cbs.get();
    private final boolean DEBUG = this.cbC.Zu();

    private b() {
        DisplayMetrics displayMetrics = this.cbC.Zk().getResources().getDisplayMetrics();
        this.cbE = displayMetrics.heightPixels;
        this.cbD = displayMetrics.widthPixels;
        this.cbH = displayMetrics.densityDpi;
    }

    public static b ZJ() {
        return cbI;
    }

    public String a(@NonNull View view, @NonNull int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i = iArr2[1];
        int height = i + view.getHeight();
        Point ai = ai(view);
        int i2 = this.cbD;
        int i3 = this.cbE;
        if (ai != null) {
            i2 = ai.x;
            i3 = ai.y;
            this.cbF = ai.x;
            this.cbG = ai.y;
        }
        String[] strArr = new String[9];
        strArr[0] = "v2";
        strArr[1] = this.cbC.Zw() ? "1" : "0";
        strArr[2] = String.valueOf(iArr[0]);
        strArr[3] = String.valueOf(iArr[1]);
        strArr[4] = String.valueOf(i);
        strArr[5] = String.valueOf(height);
        strArr[6] = String.valueOf(i2);
        strArr[7] = String.valueOf(i3);
        strArr[8] = String.valueOf(this.cbH);
        String join = TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, strArr);
        if (this.DEBUG) {
            Log.d("ClickInfoProvider", "createHotPictureParams info:" + join);
            if (iArr[0] <= 0 && iArr[1] <= 0) {
                throw new IllegalStateException("May not got clickInfo.");
            }
        }
        return join;
    }

    public int[] ZK() {
        return this.cbF != 0 ? new int[]{this.cbF, this.cbG, this.cbH} : new int[]{this.cbD, this.cbE, this.cbH};
    }

    private Point ai(@NonNull View view) {
        Display display;
        if (Build.VERSION.SDK_INT < 17 || (display = view.getDisplay()) == null) {
            return null;
        }
        Point point = new Point();
        display.getRealSize(point);
        return point;
    }
}

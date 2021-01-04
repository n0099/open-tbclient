package com.baidu.tbadk.core.elementsMaven;

import android.app.Application;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a {
    public static int getColor(int i) {
        return ao.getColor(i);
    }

    public static int pp(int i) {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
    }

    public static float pq(int i) {
        return com.baidu.adp.lib.f.b.toFloat(getString(i), 0.0f);
    }

    public static String getString(int i) {
        return TbadkCoreApplication.getInst().getResources().getString(i);
    }

    public static String[] getStringArray(int i) {
        return TbadkCoreApplication.getInst().getResources().getStringArray(i);
    }

    public static Typeface Bu(String str) {
        return "bold".equals(str) ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT;
    }

    public static ColorStateList pr(int i) {
        return ao.qd(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b bt(View view) {
        Drawable background = view.getBackground();
        return background instanceof b ? (b) background : b.but();
    }

    private static b j(Drawable drawable) {
        return drawable instanceof b ? (b) drawable : b.but();
    }

    public static Drawable a(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).pB(getColor(i));
    }

    public static Drawable a(Drawable drawable, int[] iArr) {
        return ((b) j(drawable).clone()).k(j(iArr));
    }

    public static Drawable b(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).pv(i);
    }

    public static Drawable c(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).x(L(getString(i).split(",")));
    }

    public static Drawable a(View view, Drawable drawable, String[] strArr) {
        String[] split = strArr[2].split(",");
        return ((b) j(drawable).clone()).pw(Bw(strArr[0])).px(Bv(strArr[1])).py(Bv(split[0])).pz(Bv(split[1])).bu(view);
    }

    public static float[] ps(int i) {
        String[] stringArray = getStringArray(i);
        String[] split = stringArray[2].split(",");
        float[] fArr = {Bw(stringArray[0]), Bv(stringArray[1]), Bv(split[0]), Bv(split[1])};
        if (fArr[1] == 0.0f) {
            fArr[1] = 0.01f;
        }
        return fArr;
    }

    public static Drawable a(Drawable drawable, String[] strArr) {
        String[] split = strArr[0].split(",");
        String[] split2 = strArr[1].split(",");
        return ((b) j(drawable).clone()).k(N(split)).y(M(split2)).Bx(strArr[2]);
    }

    public static Drawable b(Drawable drawable, int i, int i2) {
        b j = j(drawable);
        j.release();
        GradientDrawable buy = j.buy();
        buy.setColor(getColor(i));
        GradientDrawable buy2 = j.buy();
        buy2.setColor(getColor(i2));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, buy2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, buy2);
        stateListDrawable.addState(new int[0], buy);
        return stateListDrawable;
    }

    public static Drawable d(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).pA(getColor(i));
    }

    public static Drawable e(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).ac(pp(i));
    }

    public static Drawable f(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).ad(pq(i));
    }

    public static float[] m(float f) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, f);
        return fArr;
    }

    public static float[] aI(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        if (app == null) {
            return m(0.0f);
        }
        String[] split = app.getString(i).split(",");
        int min = Math.min(split.length, 4);
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < min; i2++) {
            float ci = ci(split[i2]);
            fArr[i2 * 2] = ci;
            fArr[(i2 * 2) + 1] = ci;
        }
        return fArr;
    }

    private static float[] L(String[] strArr) {
        int min = Math.min(strArr.length, 4);
        float[] fArr = new float[8];
        for (int i = 0; i < min; i++) {
            float ci = ci(strArr[i]);
            fArr[i * 2] = ci;
            fArr[(i * 2) + 1] = ci;
        }
        return fArr;
    }

    private static float[] M(String[] strArr) {
        int min = Math.min(strArr.length, 4);
        float[] fArr = new float[min];
        for (int i = 0; i < min; i++) {
            fArr[i] = com.baidu.adp.lib.f.b.toFloat(strArr[i], 0.0f);
        }
        return fArr;
    }

    private static int[] j(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = getColor(iArr[i]);
        }
        return iArr;
    }

    private static int[] N(String[] strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = Bw(strArr[i]);
        }
        return iArr;
    }

    private static float ci(String str) {
        return str.endsWith("H") ? Float.parseFloat(str.substring(0, str.length() - 1)) : Bv(str);
    }

    private static int Bv(String str) {
        return pp(dN("tbds" + str, "dimen"));
    }

    private static int Bw(String str) {
        return getColor(dN(str, "color"));
    }

    private static int dN(String str, String str2) {
        return TbadkCoreApplication.getInst().getResources().getIdentifier(str, str2, TbadkCoreApplication.getInst().getPackageName());
    }
}

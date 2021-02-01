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
import com.baidu.tbadk.core.util.ap;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a {
    public static int getColor(int i) {
        return ap.getColor(i);
    }

    public static int nL(int i) {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
    }

    public static float nM(int i) {
        return com.baidu.adp.lib.f.b.toFloat(getString(i), 0.0f);
    }

    public static String getString(int i) {
        return TbadkCoreApplication.getInst().getResources().getString(i);
    }

    public static String[] getStringArray(int i) {
        return TbadkCoreApplication.getInst().getResources().getStringArray(i);
    }

    public static Typeface Az(String str) {
        return "bold".equals(str) ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT;
    }

    public static ColorStateList nN(int i) {
        return ap.oB(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b bp(View view) {
        Drawable background = view.getBackground();
        return background instanceof b ? (b) background : b.bqT();
    }

    private static b j(Drawable drawable) {
        return drawable instanceof b ? (b) drawable : b.bqT();
    }

    public static Drawable a(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).nX(getColor(i));
    }

    public static Drawable a(Drawable drawable, int[] iArr) {
        return ((b) j(drawable).clone()).k(j(iArr));
    }

    public static Drawable b(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).nR(i);
    }

    public static Drawable c(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).x(L(getString(i).split(",")));
    }

    public static Drawable a(View view, Drawable drawable, String[] strArr) {
        String[] split = strArr[2].split(",");
        return ((b) j(drawable).clone()).nS(AB(strArr[0])).nT(AA(strArr[1])).nU(AA(split[0])).nV(AA(split[1])).bq(view);
    }

    public static float[] nO(int i) {
        String[] stringArray = getStringArray(i);
        String[] split = stringArray[2].split(",");
        float[] fArr = {AB(stringArray[0]), AA(stringArray[1]), AA(split[0]), AA(split[1])};
        if (fArr[1] == 0.0f) {
            fArr[1] = 0.01f;
        }
        return fArr;
    }

    public static Drawable a(Drawable drawable, String[] strArr) {
        String[] split = strArr[0].split(",");
        String[] split2 = strArr[1].split(",");
        return ((b) j(drawable).clone()).k(N(split)).y(M(split2)).AC(strArr[2]);
    }

    public static Drawable b(Drawable drawable, int i, int i2) {
        b j = j(drawable);
        j.release();
        GradientDrawable bqY = j.bqY();
        bqY.setColor(getColor(i));
        GradientDrawable bqY2 = j.bqY();
        bqY2.setColor(getColor(i2));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, bqY2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, bqY2);
        stateListDrawable.addState(new int[0], bqY);
        return stateListDrawable;
    }

    public static Drawable d(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).nW(getColor(i));
    }

    public static Drawable e(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).ad(nL(i));
    }

    public static Drawable f(Drawable drawable, int i) {
        return ((b) j(drawable).clone()).ae(nM(i));
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
            iArr[i] = AB(strArr[i]);
        }
        return iArr;
    }

    private static float ci(String str) {
        return str.endsWith("H") ? Float.parseFloat(str.substring(0, str.length() - 1)) : AA(str);
    }

    private static int AA(String str) {
        return nL(dG("tbds" + str, "dimen"));
    }

    private static int AB(String str) {
        return getColor(dG(str, "color"));
    }

    private static int dG(String str, String str2) {
        return TbadkCoreApplication.getInst().getResources().getIdentifier(str, str2, TbadkCoreApplication.getInst().getPackageName());
    }
}

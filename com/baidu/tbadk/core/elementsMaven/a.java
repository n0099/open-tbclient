package com.baidu.tbadk.core.elementsMaven;

import android.app.Application;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.searchbox.ui.animview.praise.element.eruption.strategy.IEruptionStrategyGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a {
    public static int getColor(int i) {
        return ap.getColor(i);
    }

    public static int pe(int i) {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
    }

    public static float pf(int i) {
        return com.baidu.adp.lib.f.b.toFloat(getString(i), 0.0f);
    }

    public static String getString(int i) {
        return TbadkCoreApplication.getInst().getResources().getString(i);
    }

    public static String[] getStringArray(int i) {
        return TbadkCoreApplication.getInst().getResources().getStringArray(i);
    }

    public static Typeface Bv(String str) {
        return "bold".equals(str) ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT;
    }

    public static ColorStateList pg(int i) {
        return ap.createColorStateList(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b bk(View view) {
        Drawable background = view.getBackground();
        return background instanceof b ? (b) background : b.brR();
    }

    private static b e(Drawable drawable) {
        return drawable instanceof b ? (b) drawable : b.brR();
    }

    public static Drawable a(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).pr(getColor(i));
    }

    public static Drawable a(Drawable drawable, int[] iArr) {
        return ((b) e(drawable).clone()).j(i(iArr));
    }

    public static Drawable b(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).pk(i);
    }

    public static Drawable c(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).y(E(getString(i).split(",")));
    }

    public static Drawable a(View view, Drawable drawable, String[] strArr) {
        String[] split = strArr[2].split(",");
        return ((b) e(drawable).clone()).pl(Bx(strArr[0])).pm(Bw(strArr[1])).po(Bw(split[0])).pp(Bw(split[1])).bl(view);
    }

    public static float[] ph(int i) {
        String[] stringArray = getStringArray(i);
        String[] split = stringArray[2].split(",");
        float[] fArr = {Bx(stringArray[0]), Bw(stringArray[1]), Bw(split[0]), Bw(split[1])};
        if (fArr[1] == 0.0f) {
            fArr[1] = 0.01f;
        }
        return fArr;
    }

    public static Drawable a(Drawable drawable, String[] strArr) {
        String[] split = strArr[0].split(",");
        String[] split2 = strArr[1].split(",");
        return ((b) e(drawable).clone()).j(G(split)).z(F(split2)).By(strArr[2]);
    }

    public static Drawable a(Drawable drawable, int i, int i2) {
        b e = e(drawable);
        e.release();
        GradientDrawable brW = e.brW();
        brW.setColor(getColor(i));
        GradientDrawable brW2 = e.brW();
        brW2.setColor(getColor(i2));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, brW2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, brW2);
        stateListDrawable.addState(new int[0], brW);
        return stateListDrawable;
    }

    public static Drawable d(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).pq(getColor(i));
    }

    public static Drawable e(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).aa(pe(i));
    }

    public static Drawable f(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).ab(pf(i));
    }

    public static float[] m(float f) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, f);
        return fArr;
    }

    public static float[] aH(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        if (app == null) {
            return m(0.0f);
        }
        String[] split = app.getString(i).split(",");
        int min = Math.min(split.length, 4);
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < min; i2++) {
            float cp = cp(split[i2]);
            fArr[i2 * 2] = cp;
            fArr[(i2 * 2) + 1] = cp;
        }
        return fArr;
    }

    private static float[] E(String[] strArr) {
        int min = Math.min(strArr.length, 4);
        float[] fArr = new float[8];
        for (int i = 0; i < min; i++) {
            float cp = cp(strArr[i]);
            fArr[i * 2] = cp;
            fArr[(i * 2) + 1] = cp;
        }
        return fArr;
    }

    private static float[] F(String[] strArr) {
        int min = Math.min(strArr.length, 4);
        float[] fArr = new float[min];
        for (int i = 0; i < min; i++) {
            fArr[i] = com.baidu.adp.lib.f.b.toFloat(strArr[i], 0.0f);
        }
        return fArr;
    }

    private static int[] i(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = getColor(iArr[i]);
        }
        return iArr;
    }

    private static int[] G(String[] strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = Bx(strArr[i]);
        }
        return iArr;
    }

    private static float cp(String str) {
        return str.endsWith(IEruptionStrategyGroup.STRATEGY_MODIFIER_H) ? Float.parseFloat(str.substring(0, str.length() - 1)) : Bw(str);
    }

    private static int Bw(String str) {
        return pe(dO("tbds" + str, "dimen"));
    }

    private static int Bx(String str) {
        return getColor(dO(str, "color"));
    }

    private static int dO(String str, String str2) {
        return TbadkCoreApplication.getInst().getResources().getIdentifier(str, str2, TbadkCoreApplication.getInst().getPackageName());
    }
}

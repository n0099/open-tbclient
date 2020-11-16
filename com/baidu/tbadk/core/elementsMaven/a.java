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
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a {
    public static int getColor(int i) {
        return ap.getColor(i);
    }

    public static int oG(int i) {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
    }

    public static float oH(int i) {
        return com.baidu.adp.lib.f.b.toFloat(getString(i), 0.0f);
    }

    public static String getString(int i) {
        return TbadkCoreApplication.getInst().getResources().getString(i);
    }

    public static String[] getStringArray(int i) {
        return TbadkCoreApplication.getInst().getResources().getStringArray(i);
    }

    public static Typeface AO(String str) {
        return "bold".equals(str) ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT;
    }

    public static ColorStateList oI(int i) {
        return ap.createColorStateList(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b bi(View view) {
        Drawable background = view.getBackground();
        return background instanceof b ? (b) background : b.boy();
    }

    private static b e(Drawable drawable) {
        return drawable instanceof b ? (b) drawable : b.boy();
    }

    public static Drawable a(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).oS(getColor(i));
    }

    public static Drawable a(Drawable drawable, int[] iArr) {
        return ((b) e(drawable).clone()).j(i(iArr));
    }

    public static Drawable b(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).oM(i);
    }

    public static Drawable c(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).z(E(getString(i).split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
    }

    public static float[] oJ(int i) {
        String[] stringArray = getStringArray(i);
        String[] split = stringArray[2].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        float[] fArr = {AQ(stringArray[0]), AP(stringArray[1]), AP(split[0]), AP(split[1])};
        if (fArr[1] == 0.0f) {
            fArr[1] = 0.01f;
        }
        return fArr;
    }

    public static Drawable a(Drawable drawable, String[] strArr) {
        String[] split = strArr[0].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        String[] split2 = strArr[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        return ((b) e(drawable).clone()).j(G(split)).A(F(split2)).AR(strArr[2]);
    }

    public static Drawable a(Drawable drawable, int i, int i2) {
        b e = e(drawable);
        e.release();
        GradientDrawable boD = e.boD();
        boD.setColor(getColor(i));
        GradientDrawable boD2 = e.boD();
        boD2.setColor(getColor(i2));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, boD2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, boD2);
        stateListDrawable.addState(new int[0], boD);
        return stateListDrawable;
    }

    public static Drawable d(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).oR(getColor(i));
    }

    public static Drawable e(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).aa(oG(i));
    }

    public static Drawable f(Drawable drawable, int i) {
        return ((b) e(drawable).clone()).ab(oH(i));
    }

    public static float[] n(float f) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, f);
        return fArr;
    }

    public static float[] aD(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        if (app == null) {
            return n(0.0f);
        }
        String[] split = app.getString(i).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int min = Math.min(split.length, 4);
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < min; i2++) {
            float cm = cm(split[i2]);
            fArr[i2 * 2] = cm;
            fArr[(i2 * 2) + 1] = cm;
        }
        return fArr;
    }

    private static float[] E(String[] strArr) {
        int min = Math.min(strArr.length, 4);
        float[] fArr = new float[8];
        for (int i = 0; i < min; i++) {
            float cm = cm(strArr[i]);
            fArr[i * 2] = cm;
            fArr[(i * 2) + 1] = cm;
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
            iArr[i] = AQ(strArr[i]);
        }
        return iArr;
    }

    private static float cm(String str) {
        return str.endsWith(IEruptionStrategyGroup.STRATEGY_MODIFIER_H) ? Float.parseFloat(str.substring(0, str.length() - 1)) : AP(str);
    }

    private static int AP(String str) {
        return oG(dH("tbds" + str, "dimen"));
    }

    private static int AQ(String str) {
        return getColor(dH(str, "color"));
    }

    private static int dH(String str, String str2) {
        return TbadkCoreApplication.getInst().getResources().getIdentifier(str, str2, TbadkCoreApplication.getInst().getPackageName());
    }
}

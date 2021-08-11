package c.a.o0.s.u;

import android.app.Application;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, HashMap<String, Integer>> f14215a;

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<String> f14216b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(964113272, "Lc/a/o0/s/u/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(964113272, "Lc/a/o0/s/u/a;");
                return;
            }
        }
        f14215a = new HashMap<>();
        f14216b = new SparseArray<>();
    }

    public static float[] A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            String[] E = E(i2);
            String[] split = E[2].split(",");
            float[] fArr = {j(E[0]), n(E[1]), n(split[0]), n(split[1])};
            if (fArr[1] == 0.0f) {
                fArr[1] = 0.01f;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public static Drawable B(Drawable drawable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, drawable, i2, i3)) == null) {
            b c2 = c(drawable);
            c2.A();
            GradientDrawable m = c2.m(i3);
            m.setColor(h(i2));
            m.setStroke((int) c2.u(), c.a.p0.i3.c.a(c2.t(), c2.s()));
            GradientDrawable m2 = c2.m(i3);
            m2.setColor(c.a.p0.i3.c.a(h(i2), SkinManager.RESOURCE_ALPHA_PRESS));
            m2.setStroke((int) c2.u(), c.a.p0.i3.c.a(c2.t(), SkinManager.RESOURCE_ALPHA_PRESS * c2.s()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, m2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, m2);
            stateListDrawable.addState(new int[0], m);
            return stateListDrawable;
        }
        return (Drawable) invokeLII.objValue;
    }

    public static Drawable C(Drawable drawable, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65539, null, drawable, i2, i3, i4)) == null) {
            b c2 = c(drawable);
            c2.A();
            GradientDrawable m = c2.m(i4);
            m.setColor(h(i2));
            m.setStroke((int) c2.u(), c.a.p0.i3.c.a(c2.t(), c2.s()));
            GradientDrawable m2 = c2.m(i4);
            m2.setColor(h(i3));
            m2.setStroke((int) c2.u(), c.a.p0.i3.c.a(c2.t(), SkinManager.RESOURCE_ALPHA_PRESS * c2.s()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, m2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, m2);
            stateListDrawable.addState(new int[0], m);
            return stateListDrawable;
        }
        return (Drawable) invokeLIII.objValue;
    }

    public static String D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            int idByABTest = EMABTest.getIdByABTest(i2, "string");
            return idByABTest == 0 ? "" : TbadkCoreApplication.getInst().getResources().getString(idByABTest);
        }
        return (String) invokeI.objValue;
    }

    public static String[] E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? TbadkCoreApplication.getInst().getResources().getStringArray(EMABTest.getIdByABTest(i2, "array")) : (String[]) invokeI.objValue;
    }

    public static ColorStateList F(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? SkinManager.createColorStateList(i2) : (ColorStateList) invokeI.objValue;
    }

    public static Typeface G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if ("bold".equals(str)) {
                return Typeface.DEFAULT_BOLD;
            }
            return Typeface.DEFAULT;
        }
        return (Typeface) invokeL.objValue;
    }

    public static float[] H(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65544, null, f2)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f2);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public static float a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? c.a.e.e.m.b.c(D(i2), 0.0f) : invokeI.floatValue;
    }

    public static Drawable b(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.B(a(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static b c(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, drawable)) == null) {
            if (drawable instanceof b) {
                return (b) drawable;
            }
            return b.z();
        }
        return (b) invokeL.objValue;
    }

    public static b d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, view)) == null) {
            Drawable background = view.getBackground();
            if (background instanceof b) {
                return (b) background;
            }
            return b.z();
        }
        return (b) invokeL.objValue;
    }

    public static Drawable e(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.E(a(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable f(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.F(h(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable g(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.G(m(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i2)) == null) ? SkinManager.getColor(i2) : invokeI.intValue;
    }

    public static Drawable i(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.C(h(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) ? h(s(str, "color")) : invokeL.intValue;
    }

    public static Drawable k(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65555, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.Q(y(D(i2).split(",")));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable l(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.H(i2);
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i2)) == null) ? UtilHelper.getDimenPixelSize(i2) : invokeI.intValue;
    }

    public static int n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            return m(s("tbds" + str, "dimen"));
        }
        return invokeL.intValue;
    }

    public static String o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i2)) == null) {
            String str = f14216b.get(i2);
            if (str == null) {
                str = i2 == 0 ? "" : TbadkCoreApplication.getInst().getResources().getResourceEntryName(i2);
                f14216b.put(i2, str);
            }
            return str;
        }
        return (String) invokeI.objValue;
    }

    public static Drawable p(Drawable drawable, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, drawable, iArr)) == null) {
            b bVar = (b) c(drawable).clone();
            q(iArr);
            bVar.D(iArr);
            return bVar;
        }
        return (Drawable) invokeLL.objValue;
    }

    public static int[] q(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, iArr)) == null) {
            int length = iArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = h(iArr[i2]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int[] r(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, strArr)) == null) {
            int length = strArr.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = j(strArr[i2]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, str, str2)) == null) {
            HashMap<String, Integer> hashMap = f14215a.get(str2);
            if (hashMap == null) {
                hashMap = new HashMap<>();
                f14215a.put(str2, hashMap);
            }
            Integer num = hashMap.get(str);
            if (num == null) {
                num = Integer.valueOf(TbadkCoreApplication.getInst().getResources().getIdentifier(str, str2, TbadkCoreApplication.getInst().getPackageName()));
                hashMap.put(str, num);
            }
            return num.intValue();
        }
        return invokeLL.intValue;
    }

    public static Drawable t(Drawable drawable, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, drawable, strArr)) == null) {
            String[] split = strArr[0].split(",");
            String[] split2 = strArr[1].split(",");
            String str = strArr[2];
            b bVar = (b) c(drawable).clone();
            bVar.D(r(split));
            bVar.L(u(split2));
            bVar.I(str);
            return bVar;
        }
        return (Drawable) invokeLL.objValue;
    }

    public static float[] u(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[min];
            for (int i2 = 0; i2 < min; i2++) {
                fArr[i2] = c.a.e.e.m.b.c(strArr[i2], 0.0f);
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static Drawable v(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65566, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.C(i2);
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static float w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            if (str.endsWith("H")) {
                return Float.parseFloat(str.substring(0, str.length() - 1));
            }
            return n(str);
        }
        return invokeL.floatValue;
    }

    public static float[] x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65568, null, i2)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return H(0.0f);
            }
            String[] split = app.getString(i2).split(",");
            int min = Math.min(split.length, 4);
            float[] fArr = new float[8];
            for (int i3 = 0; i3 < min; i3++) {
                float w = w(split[i3]);
                int i4 = i3 * 2;
                fArr[i4] = w;
                fArr[i4 + 1] = w;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public static float[] y(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[8];
            for (int i2 = 0; i2 < min; i2++) {
                float w = w(strArr[i2]);
                int i3 = i2 * 2;
                fArr[i3] = w;
                fArr[i3 + 1] = w;
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static Drawable z(View view, Drawable drawable, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65570, null, view, drawable, strArr)) == null) {
            String[] split = strArr[2].split(",");
            b bVar = (b) c(drawable).clone();
            bVar.M(j(strArr[0]));
            bVar.N(n(strArr[1]));
            bVar.J(n(split[0]));
            bVar.K(n(split[1]));
            return bVar.o(view);
        }
        return (Drawable) invokeLLL.objValue;
    }
}

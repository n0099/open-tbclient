package c.a.q0.s.u;

import android.app.Application;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.Direction;
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
    public static final HashMap<String, HashMap<String, Integer>> f14486a;

    /* renamed from: b  reason: collision with root package name */
    public static final SparseArray<String> f14487b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1644171642, "Lc/a/q0/s/u/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1644171642, "Lc/a/q0/s/u/a;");
                return;
            }
        }
        f14486a = new HashMap<>();
        f14487b = new SparseArray<>();
    }

    public static float[] A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return K(0.0f);
            }
            String[] split = app.getString(i2).split(",");
            int min = Math.min(split.length, 4);
            float[] fArr = new float[8];
            for (int i3 = 0; i3 < min; i3++) {
                float z = z(split[i3]);
                int i4 = i3 * 2;
                fArr[i4] = z;
                fArr[i4 + 1] = z;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public static float[] B(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[8];
            for (int i2 = 0; i2 < min; i2++) {
                float z = z(strArr[i2]);
                int i3 = i2 * 2;
                fArr[i3] = z;
                fArr[i3 + 1] = z;
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static Drawable C(View view, Drawable drawable, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, view, drawable, strArr)) == null) {
            String[] split = strArr[2].split(",");
            b bVar = (b) c(drawable).clone();
            bVar.M(l(strArr[0]));
            bVar.N(p(strArr[1]));
            bVar.J(p(split[0]));
            bVar.K(p(split[1]));
            return bVar.o(view);
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static float[] D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            String[] H = H(i2);
            String[] split = H[2].split(",");
            float[] fArr = {l(H[0]), p(H[1]), p(split[0]), p(split[1])};
            if (fArr[1] == 0.0f) {
                fArr[1] = 0.01f;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public static Drawable E(Drawable drawable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.AD_TEXT_ID, null, drawable, i2, i3)) == null) {
            b c2 = c(drawable);
            c2.A();
            GradientDrawable m = c2.m(i3);
            m.setColor(h(i2));
            m.setStroke((int) c2.u(), c.a.r0.j3.c.a(c2.t(), c2.s()));
            GradientDrawable m2 = c2.m(i3);
            m2.setColor(c.a.r0.j3.c.a(h(i2), SkinManager.RESOURCE_ALPHA_PRESS));
            m2.setStroke((int) c2.u(), c.a.r0.j3.c.a(c2.t(), SkinManager.RESOURCE_ALPHA_PRESS * c2.s()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, m2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, m2);
            stateListDrawable.addState(new int[0], m);
            return stateListDrawable;
        }
        return (Drawable) invokeLII.objValue;
    }

    public static Drawable F(Drawable drawable, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(AdIconUtil.BAIDU_LOGO_ID, null, drawable, i2, i3, i4)) == null) {
            b c2 = c(drawable);
            c2.A();
            GradientDrawable m = c2.m(i4);
            m.setColor(h(i2));
            m.setStroke((int) c2.u(), c.a.r0.j3.c.a(c2.t(), c2.s()));
            GradientDrawable m2 = c2.m(i4);
            m2.setColor(h(i3));
            m2.setStroke((int) c2.u(), c.a.r0.j3.c.a(c2.t(), SkinManager.RESOURCE_ALPHA_PRESS * c2.s()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, m2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, m2);
            stateListDrawable.addState(new int[0], m);
            return stateListDrawable;
        }
        return (Drawable) invokeLIII.objValue;
    }

    public static String G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            int idByABTest = EMABTest.getIdByABTest(i2, "string");
            return idByABTest == 0 ? "" : TbadkCoreApplication.getInst().getResources().getString(idByABTest);
        }
        return (String) invokeI.objValue;
    }

    public static String[] H(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? TbadkCoreApplication.getInst().getResources().getStringArray(EMABTest.getIdByABTest(i2, "array")) : (String[]) invokeI.objValue;
    }

    public static ColorStateList I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? SkinManager.createColorStateList(i2) : (ColorStateList) invokeI.objValue;
    }

    public static Typeface J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if ("bold".equals(str)) {
                return Typeface.DEFAULT_BOLD;
            }
            return Typeface.DEFAULT;
        }
        return (Typeface) invokeL.objValue;
    }

    public static float[] K(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65547, null, f2)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f2);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public static float a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) ? c.a.e.e.m.b.d(G(i2), 0.0f) : invokeI.floatValue;
    }

    public static Drawable b(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.B(a(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static b c(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, drawable)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, view)) == null) {
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.E(a(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable f(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.F(h(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable g(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.G(o(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) ? SkinManager.getColor(i2) : invokeI.intValue;
    }

    public static int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) ? c.a.r0.j3.c.c(str) : invokeL.intValue;
    }

    public static Drawable j(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.C(h(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable k(Drawable drawable, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, drawable, str)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.C(i(str));
            return bVar;
        }
        return (Drawable) invokeLL.objValue;
    }

    public static int l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) ? h(u(str, "color")) : invokeL.intValue;
    }

    public static Drawable m(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65560, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.Q(B(G(i2).split(",")));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable n(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65561, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.H(i2);
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65562, null, i2)) == null) ? UtilHelper.getDimenPixelSize(i2) : invokeI.intValue;
    }

    public static int p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            return o(u("tbds" + str, "dimen"));
        }
        return invokeL.intValue;
    }

    public static String q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65564, null, i2)) == null) {
            String str = f14487b.get(i2);
            if (str == null) {
                str = i2 == 0 ? "" : TbadkCoreApplication.getInst().getResources().getResourceEntryName(i2);
                f14487b.put(i2, str);
            }
            return str;
        }
        return (String) invokeI.objValue;
    }

    public static Drawable r(Drawable drawable, Direction direction, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65565, null, drawable, direction, iArr)) == null) {
            b bVar = (b) c(drawable).clone();
            s(iArr);
            bVar.D(iArr);
            bVar.I(direction);
            return bVar;
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static int[] s(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, iArr)) == null) {
            int length = iArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = h(iArr[i2]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int[] t(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, strArr)) == null) {
            int length = strArr.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = l(strArr[i2]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int u(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, str, str2)) == null) {
            HashMap<String, Integer> hashMap = f14486a.get(str2);
            if (hashMap == null) {
                hashMap = new HashMap<>();
                f14486a.put(str2, hashMap);
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

    public static Drawable v(Drawable drawable, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, drawable, strArr)) == null) {
            String[] split = strArr[0].split(",");
            String[] split2 = strArr[1].split(",");
            String str = strArr[2];
            b bVar = (b) c(drawable).clone();
            if (!TextUtils.isEmpty(str)) {
                bVar.I(Direction.valueOf(str.toUpperCase()));
            }
            bVar.D(t(split));
            bVar.L(w(split2));
            return bVar;
        }
        return (Drawable) invokeLL.objValue;
    }

    public static float[] w(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[min];
            for (int i2 = 0; i2 < min; i2++) {
                fArr[i2] = c.a.e.e.m.b.d(strArr[i2], 0.0f);
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static Drawable x(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65571, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.F(i2);
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable y(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65572, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.C(i2);
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static float z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, str)) == null) {
            if (str.endsWith("H")) {
                return Float.parseFloat(str.substring(0, str.length() - 1));
            }
            return p(str);
        }
        return invokeL.floatValue;
    }
}

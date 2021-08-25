package c.a.e.c.e.c;

import android.app.Application;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.fsg.face.liveness.result.LivenessRecogResult;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int A;
    public static String B = null;
    public static String C = null;
    public static int[] D = null;
    public static ArrayList<BasicNameValuePair> E = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f2026a = -100000000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f2027b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f2028c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f2029d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f2030e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f2031f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f2032g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f2033h;

    /* renamed from: i  reason: collision with root package name */
    public static final int f2034i;

    /* renamed from: j  reason: collision with root package name */
    public static final int f2035j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(994308837, "Lc/a/e/c/e/c/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(994308837, "Lc/a/e/c/e/c/h;");
                return;
            }
        }
        f2027b = (-100000000) - 200;
        f2028c = (-100000000) - 211;
        f2029d = (-100000000) - 213;
        f2030e = (-100000000) - 214;
        f2031f = (-100000000) - 221;
        f2032g = (-100000000) - 230;
        f2033h = (-100000000) - 232;
        f2034i = (-100000000) - 233;
        f2035j = (-100000000) - 234;
        k = (-100000000) - 235;
        l = (-100000000) - 236;
        m = (-100000000) - 301;
        n = (-100000000) - 302;
        o = (-100000000) - 303;
        p = (-100000000) - 306;
        q = (-100000000) - 307;
        r = (-100000000) + LivenessRecogResult.ERROR_CODE_MAY_BE_NO_RECORD_AUDIO_PERMISSION;
        s = (-100000000) + LivenessRecogResult.ERROR_CODE_VIDEO_IS_REVIEWING;
        t = (-100000000) - 310;
        u = (-100000000) - 311;
        v = (-100000000) - 312;
        w = (-100000000) - 313;
        x = (-100000000) - 314;
        y = (-100000000) - 310;
        z = (-100000000) - 311;
        A = (-100000000) + ErrorCode.ARGS_ERROR;
        D = c.a.e.c.c.f1991a;
        E = null;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? C : (String) invokeV.objValue;
    }

    public static ArrayList<BasicNameValuePair> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? E : (ArrayList) invokeV.objValue;
    }

    public static int[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? D : (int[]) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? B : (String) invokeV.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            C = str;
        }
    }

    public static void f(ArrayList<BasicNameValuePair> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, arrayList) == null) {
            E = arrayList;
        }
    }

    public static void g(int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, iArr) == null) || iArr == null) {
            return;
        }
        D = iArr;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            B = str;
        }
    }

    public static String i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            int i3 = f2026a - i2;
            Application app = BdBaseApplication.getInst().getApp();
            if (i3 > -300 && i3 <= -200) {
                return app.getString(R.string.im_error_codec);
            }
            return app.getString(R.string.im_error_default);
        }
        return (String) invokeI.objValue;
    }
}

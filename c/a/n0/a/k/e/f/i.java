package c.a.n0.a.k.e.f;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.q0;
import c.a.n0.a.s1.b.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i extends c.a.n0.a.k.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5062b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f5063c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f5064d;

        public a(i iVar, String str, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5064d = iVar;
            this.a = str;
            this.f5062b = i;
            this.f5063c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i iVar = this.f5064d;
                iVar.P(iVar.getContext(), this.a, this.f5062b, this.f5063c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5065b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Drawable f5066c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f5067d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f5068e;

        public b(i iVar, String str, int i, Drawable drawable, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, Integer.valueOf(i), drawable, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5068e = iVar;
            this.a = str;
            this.f5065b = i;
            this.f5066c = drawable;
            this.f5067d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i iVar = this.f5068e;
                iVar.N(iVar.getContext(), this.a, this.f5065b, this.f5066c, this.f5067d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5069b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f5070c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f5071d;

        public c(i iVar, String str, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5071d = iVar;
            this.a = str;
            this.f5069b = i;
            this.f5070c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i iVar = this.f5071d;
                iVar.O(iVar.getContext(), this.a, this.f5069b, this.f5070c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5072b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5073c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5074d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f5075e;

        public d(i iVar, String str, int i, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, Integer.valueOf(i), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5075e = iVar;
            this.a = str;
            this.f5072b = i;
            this.f5073c = str2;
            this.f5074d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i iVar = this.f5075e;
                iVar.M(iVar.getContext(), this.a, this.f5072b, this.f5073c, this.f5074d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.s1.b.f.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f5076b;

        public f(i iVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5076b = iVar;
            this.a = str;
        }

        @Override // c.a.n0.a.s1.b.f.e.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.a)) {
                return;
            }
            this.f5076b.d(this.a, new c.a.n0.a.k.h.b(0));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static int F(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONObject)) == null) {
            int R = R(jSONObject.optString("time")) / 1000;
            if (R < 1) {
                return 2;
            }
            return R;
        }
        return invokeL.intValue;
    }

    public static ExifInterface G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new ExifInterface(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (ExifInterface) invokeL.objValue;
    }

    public static String H(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i)) == null) ? I(str, i, false) : (String) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
        r0.append(com.baidu.tbadk.core.util.StringHelper.STRING_MORE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String I(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            char[] charArray = str.trim().toCharArray();
            int i2 = z ? i : i - 2;
            int i3 = z ? i : i - 1;
            int length = charArray.length;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 < length) {
                    char c2 = charArray[i4];
                    int i6 = c2 > 161 ? 2 : 1;
                    int i7 = i6 + i5;
                    if (i7 == i && i4 == length - 1) {
                        stringBuffer.append(c2);
                        break;
                    } else if ((i6 != 2 || i5 < i2) && (i6 != 1 || i5 < i3)) {
                        stringBuffer.append(c2);
                        i4++;
                        i5 = i7;
                    }
                } else {
                    break;
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static Drawable L(Context context, String str, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLL;
        ExifInterface G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, str, eVar)) == null) {
            if (TextUtils.isEmpty(str) || eVar == null || context == null || (G = G(str)) == null) {
                return null;
            }
            Integer.valueOf(G.getAttribute("ImageWidth")).intValue();
            Integer.valueOf(G.getAttribute("ImageLength")).intValue();
            File file = new File(str);
            if (file.exists()) {
                if (file.isFile()) {
                    try {
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(new FileInputStream(file)));
            }
            return null;
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static int R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return (int) Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public c.a.n0.a.k.h.b K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideToast", false);
            if (c.a.n0.a.t1.e.a0() == null) {
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            }
            q0.e0(new e(this));
            return c.a.n0.a.k.h.b.f();
        }
        return (c.a.n0.a.k.h.b) invokeV.objValue;
    }

    public final void M(Context context, @NonNull String str, int i, @NonNull String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, Integer.valueOf(i), str2, str3}) == null) {
            c.a.n0.a.s1.b.f.e e2 = c.a.n0.a.s1.b.f.e.e(context);
            e2.r(str);
            e2.k(str2);
            e2.l(i);
            e2.u(new f(this, str3));
            e2.w();
        }
    }

    public final void N(Context context, @NonNull String str, int i, Drawable drawable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, Integer.valueOf(i), drawable, Boolean.valueOf(z)}) == null) {
            c.a.n0.a.s1.b.f.e g2 = c.a.n0.a.s1.b.f.e.g(context, H(str, 14));
            g2.n(drawable);
            g2.l(i);
            g2.s(z);
            g2.B();
        }
    }

    public final void O(Context context, @NonNull String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            c.a.n0.a.s1.b.f.e g2 = c.a.n0.a.s1.b.f.e.g(context, H(str, 14));
            g2.l(i);
            g2.s(z);
            g2.z();
        }
    }

    public final void P(Context context, @NonNull String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            c.a.n0.a.s1.b.f.e g2 = c.a.n0.a.s1.b.f.e.g(context, str);
            g2.l(i);
            g2.s(z);
            g2.q(2);
            g2.G();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00dc, code lost:
        if (r2.equals("1") != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c.a.n0.a.k.h.b Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            char c2 = 0;
            q("#showToast", false);
            if (n()) {
                c.a.n0.a.u.d.c("ToastApi", "ToastApi does not supported when app is invisible.");
                return new c.a.n0.a.k.h.b(1001, "ToastApi does not supported when app is invisible.");
            }
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            }
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("type", "1");
                int F = F(jSONObject);
                String optString2 = jSONObject.optString("message");
                if (TextUtils.isEmpty(optString2)) {
                    c.a.n0.a.u.d.c("ToastApi", "message is null");
                    return new c.a.n0.a.k.h.b(202, "message is null");
                }
                boolean optBoolean = jSONObject.optBoolean("mask");
                String optString3 = jSONObject.optString("image", "-1");
                if (!TextUtils.equals(optString3, "-1") && !optString3.startsWith(q0.x(a0).getPath())) {
                    optString3 = q0.w(a0, optString3);
                }
                Drawable L = L(getContext(), optString3, a0);
                if (!TextUtils.equals(optString3, "-1") && L == null && TextUtils.equals(optString, "2")) {
                    optString = "1";
                }
                String optString4 = jSONObject.optString("cb");
                String optString5 = jSONObject.optString("buttonText");
                switch (optString.hashCode()) {
                    case 49:
                        break;
                    case 50:
                        if (optString.equals("2")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 51:
                        if (optString.equals("3")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 52:
                        if (optString.equals("4")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    q0.e0(new a(this, optString2, F, optBoolean));
                } else if (c2 == 1) {
                    q0.e0(new b(this, optString2, F, L, optBoolean));
                } else if (c2 == 2) {
                    q0.e0(new c(this, optString2, F, optBoolean));
                } else if (c2 != 3) {
                    J();
                    return new c.a.n0.a.k.h.b(302, "the toast type is unknown");
                } else {
                    q0.e0(new d(this, optString2, F, optString5, optString4));
                }
                return c.a.n0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "ToastApi" : (String) invokeV.objValue;
    }
}

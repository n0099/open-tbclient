package b.a.p0.a.u.e.g;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.v2.q0;
import b.a.p0.a.z1.b.f.e;
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
public class h extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8168e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8169f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8170g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h f8171h;

        public a(h hVar, String str, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8171h = hVar;
            this.f8168e = str;
            this.f8169f = i2;
            this.f8170g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f8171h;
                hVar.I(hVar.getContext(), this.f8168e, this.f8169f, this.f8170g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8172e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8173f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f8174g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f8175h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f8176i;

        public b(h hVar, String str, int i2, Drawable drawable, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Integer.valueOf(i2), drawable, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8176i = hVar;
            this.f8172e = str;
            this.f8173f = i2;
            this.f8174g = drawable;
            this.f8175h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f8176i;
                hVar.G(hVar.getContext(), this.f8172e, this.f8173f, this.f8174g, this.f8175h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8177e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8178f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8179g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h f8180h;

        public c(h hVar, String str, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8180h = hVar;
            this.f8177e = str;
            this.f8178f = i2;
            this.f8179g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f8180h;
                hVar.H(hVar.getContext(), this.f8177e, this.f8178f, this.f8179g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8181e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8182f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8183g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8184h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f8185i;

        public d(h hVar, String str, int i2, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Integer.valueOf(i2), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8185i = hVar;
            this.f8181e = str;
            this.f8182f = i2;
            this.f8183g = str2;
            this.f8184h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f8185i;
                hVar.F(hVar.getContext(), this.f8181e, this.f8182f, this.f8183g, this.f8184h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.z1.b.f.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f8186a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f8187b;

        public f(h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8187b = hVar;
            this.f8186a = str;
        }

        @Override // b.a.p0.a.z1.b.f.e.c
        public void onToastClick() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f8186a)) {
                return;
            }
            this.f8187b.d(this.f8186a, new b.a.p0.a.u.h.b(0));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String A(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) ? B(str, i2, false) : (String) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
        r0.append("...");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String B(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            char[] charArray = str.trim().toCharArray();
            int i3 = z ? i2 : i2 - 2;
            int i4 = z ? i2 : i2 - 1;
            int length = charArray.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i5 < length) {
                    char c2 = charArray[i5];
                    int i7 = c2 > 161 ? 2 : 1;
                    int i8 = i7 + i6;
                    if (i8 == i2 && i5 == length - 1) {
                        stringBuffer.append(c2);
                        break;
                    } else if ((i7 != 2 || i6 < i3) && (i7 != 1 || i6 < i4)) {
                        stringBuffer.append(c2);
                        i5++;
                        i6 = i8;
                    }
                } else {
                    break;
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static Drawable E(Context context, String str, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, eVar)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null && context != null) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str2 = "imagePath = " + str;
                }
                ExifInterface z = z(str);
                if (z == null) {
                    boolean z2 = b.a.p0.a.u.c.d.f8000c;
                    return null;
                }
                int intValue = Integer.valueOf(z.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH)).intValue();
                int intValue2 = Integer.valueOf(z.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH)).intValue();
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str3 = "width = " + intValue + "， height = " + intValue2;
                }
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    try {
                        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(new FileInputStream(file)));
                    } catch (FileNotFoundException e2) {
                        if (b.a.p0.a.u.c.d.f8000c) {
                            e2.printStackTrace();
                            return null;
                        }
                        return null;
                    }
                }
                boolean z3 = b.a.p0.a.u.c.d.f8000c;
            }
            return null;
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static int K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
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

    public static int y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, jSONObject)) == null) {
            int K = K(jSONObject.optString("time")) / 1000;
            if (K < 1) {
                return 2;
            }
            return K;
        }
        return invokeL.intValue;
    }

    public static ExifInterface z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
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

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
        }
    }

    public b.a.p0.a.u.h.b D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            if (b.a.p0.a.a2.e.P() == null) {
                return new b.a.p0.a.u.h.b(1001, "SwanApp is null");
            }
            q0.b0(new e(this));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public final void F(Context context, @NonNull String str, int i2, @NonNull String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, Integer.valueOf(i2), str2, str3}) == null) {
            b.a.p0.a.z1.b.f.e e2 = b.a.p0.a.z1.b.f.e.e(context);
            e2.q(str);
            e2.k(str2);
            e2.l(i2);
            e2.t(new f(this, str3));
            e2.v();
        }
    }

    public final void G(Context context, @NonNull String str, int i2, Drawable drawable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, Integer.valueOf(i2), drawable, Boolean.valueOf(z)}) == null) {
            b.a.p0.a.z1.b.f.e g2 = b.a.p0.a.z1.b.f.e.g(context, A(str, 14));
            g2.n(drawable);
            g2.l(i2);
            g2.r(z);
            g2.A();
        }
    }

    public final void H(Context context, @NonNull String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            b.a.p0.a.z1.b.f.e g2 = b.a.p0.a.z1.b.f.e.g(context, A(str, 14));
            g2.l(i2);
            g2.r(z);
            g2.y();
        }
    }

    public final void I(Context context, @NonNull String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            b.a.p0.a.z1.b.f.e g2 = b.a.p0.a.z1.b.f.e.g(context, str);
            g2.l(i2);
            g2.r(z);
            g2.p(2);
            g2.F();
        }
    }

    public b.a.p0.a.u.h.b J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "handle: " + str;
            }
            if (k()) {
                b.a.p0.a.e0.d.b("Api-ToastApi", "Api-ToastApi does not supported when app is invisible.");
                return new b.a.p0.a.u.h.b(1001, "Api-ToastApi does not supported when app is invisible.");
            }
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P == null) {
                return new b.a.p0.a.u.h.b(1001, "SwanApp is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-ToastApi", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-ToastApi", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("type", "1");
            int y = y(jSONObject);
            String optString2 = jSONObject.optString("message");
            if (TextUtils.isEmpty(optString2)) {
                b.a.p0.a.e0.d.b("Api-ToastApi", "message is null");
                return new b.a.p0.a.u.h.b(202, "message is null");
            }
            boolean optBoolean = jSONObject.optBoolean("mask");
            String optString3 = jSONObject.optString("image", "-1");
            if (!TextUtils.equals(optString3, "-1") && !optString3.startsWith(q0.x(P).getPath())) {
                optString3 = q0.w(P, optString3);
            }
            Drawable E = E(getContext(), optString3, P);
            if (b.a.p0.a.u.c.d.f8000c) {
                String str3 = "imagepath = " + optString3;
            }
            if (!TextUtils.equals(optString3, "-1") && E == null && TextUtils.equals(optString, "2")) {
                optString = "1";
            }
            String optString4 = jSONObject.optString("cb");
            String optString5 = jSONObject.optString("buttonText");
            char c2 = 65535;
            switch (optString.hashCode()) {
                case 49:
                    if (optString.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (optString.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 51:
                    if (optString.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 52:
                    if (optString.equals("4")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                q0.b0(new a(this, optString2, y, optBoolean));
            } else if (c2 == 1) {
                q0.b0(new b(this, optString2, y, E, optBoolean));
            } else if (c2 == 2) {
                q0.b0(new c(this, optString2, y, optBoolean));
            } else if (c2 != 3) {
                C();
                return new b.a.p0.a.u.h.b(302, "the toast type is unknown");
            } else {
                q0.b0(new d(this, optString2, y, optString5, optString4));
            }
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}

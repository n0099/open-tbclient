package com.baidu.android.pushservice.w.m;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(62382197, "Lcom/baidu/android/pushservice/w/m/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(62382197, "Lcom/baidu/android/pushservice/w/m/e$a;");
                    return;
                }
            }
            int[] iArr = new int[com.baidu.android.pushservice.k.c.values().length];
            a = iArr;
            try {
                iArr[com.baidu.android.pushservice.k.c.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static PublicMsg a(Context context, String str, String str2, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, str, str2, bArr, bArr2)) == null) {
            if (Utility.a(context, bArr, str2, bArr2)) {
                PublicMsg a2 = j.a(context, str2, str, bArr2);
                a2.mPkgName = context.getPackageName();
                if (TextUtils.isEmpty(a2.mTitle)) {
                    a2.mTitle = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
                }
                return a2;
            }
            return null;
        }
        return (PublicMsg) invokeLLLLL.objValue;
    }

    public static String a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, str, str2, i)) == null) {
            try {
                JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
                jSONObject.put(str2, i);
                return jSONObject.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeLLI.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    @Override // com.baidu.android.pushservice.w.m.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.android.pushservice.w.g a(com.baidu.android.pushservice.w.k kVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bArr)) == null) {
            String a2 = kVar.a();
            String h = kVar.h();
            int q = kVar.q();
            int i = kVar.i();
            byte[] n = kVar.n();
            String j = kVar.j();
            PublicMsg a3 = j.a(this.a, h, a2, bArr);
            int i2 = 1;
            if (a3 == null || TextUtils.isEmpty(a3.mDescription)) {
                i2 = 2;
            } else {
                com.baidu.android.pushservice.k.d a4 = com.baidu.android.pushservice.k.d.a(this.a, a2);
                if (TextUtils.isEmpty(j) || !Utility.m(this.a, j)) {
                    if (a4.a() == com.baidu.android.pushservice.k.c.a) {
                        j = a4.b.b();
                    }
                    Utility.b(this.a, a3);
                    if (a.a[a4.a().ordinal()] == 1) {
                        i2 = 7;
                    } else {
                        PackageManager packageManager = this.a.getPackageManager();
                        try {
                            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a3.mPkgName, 128);
                            if (TextUtils.isEmpty(a3.mTitle)) {
                                a3.mTitle = packageManager.getApplicationLabel(applicationInfo).toString();
                            }
                            f.a(this.a, a3, h, a2, q, n, bArr, i, kVar);
                            String str = h + " is showing Notification!";
                        } catch (PackageManager.NameNotFoundException unused) {
                            i2 = 8;
                        }
                    }
                }
                a3.mPkgName = j;
                Utility.b(this.a, a3);
                if (a.a[a4.a().ordinal()] == 1) {
                }
            }
            com.baidu.android.pushservice.w.g gVar = new com.baidu.android.pushservice.w.g();
            gVar.a(i2);
            return gVar;
        }
        return (com.baidu.android.pushservice.w.g) invokeLL.objValue;
    }
}

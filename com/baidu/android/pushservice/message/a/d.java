package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.message.a.d$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053594686, "Lcom/baidu/android/pushservice/message/a/d$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1053594686, "Lcom/baidu/android/pushservice/message/a/d$1;");
                    return;
                }
            }
            int[] iArr = new int[com.baidu.android.pushservice.a.c.a().length];
            a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
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
            if (m.a(context, bArr, str2, bArr2)) {
                PublicMsg a = i.a(context, str2, str, bArr2);
                a.mPkgName = context.getPackageName();
                if (TextUtils.isEmpty(a.mTitle)) {
                    a.mTitle = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
                }
                return a;
            }
            return null;
        }
        return (PublicMsg) invokeLLLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    @Override // com.baidu.android.pushservice.message.a.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bArr)) == null) {
            String e = kVar.e();
            String h = kVar.h();
            int i2 = kVar.i();
            int b = kVar.b();
            byte[] k = kVar.k();
            String f = kVar.f();
            PublicMsg a = i.a(this.a, h, e, bArr);
            if (a == null || TextUtils.isEmpty(a.mDescription)) {
                i = 2;
            } else {
                com.baidu.android.pushservice.a.d a2 = com.baidu.android.pushservice.a.d.a(this.a, e);
                if (TextUtils.isEmpty(f) || !m.b(this.a, f)) {
                    if (a2.a() == com.baidu.android.pushservice.a.c.a) {
                        f = a2.a.b();
                    }
                    m.a(this.a, a);
                    i = 1;
                    if (AnonymousClass1.a[a2.a().ordinal()] == 1) {
                        i = 7;
                    } else {
                        PackageManager packageManager = this.a.getPackageManager();
                        try {
                            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a.mPkgName, 128);
                            if (TextUtils.isEmpty(a.mTitle)) {
                                a.mTitle = packageManager.getApplicationLabel(applicationInfo).toString();
                            }
                            e.a(this.a, a, h, e, i2, k, bArr, b, kVar.c());
                            String str = h + " is showing Notification!";
                        } catch (PackageManager.NameNotFoundException e2) {
                            new b.c(this.a).a(Log.getStackTraceString(e2)).a();
                            i = 8;
                        }
                    }
                }
                a.mPkgName = f;
                m.a(this.a, a);
                i = 1;
                if (AnonymousClass1.a[a2.a().ordinal()] == 1) {
                }
            }
            com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
            gVar.a(i);
            return gVar;
        }
        return (com.baidu.android.pushservice.message.g) invokeLL.objValue;
    }
}

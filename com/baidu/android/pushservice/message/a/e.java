package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.PublicMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.message.a.e$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37733a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053564895, "Lcom/baidu/android/pushservice/message/a/e$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1053564895, "Lcom/baidu/android/pushservice/message/a/e$1;");
                    return;
                }
            }
            int[] iArr = new int[com.baidu.android.pushservice.a.c.a().length];
            f37733a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.f36923a.ordinal()] = 1;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    @Override // com.baidu.android.pushservice.message.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bArr)) == null) {
            String c2 = kVar.c();
            String f2 = kVar.f();
            int g2 = kVar.g();
            int a2 = kVar.a();
            byte[] i3 = kVar.i();
            String d2 = kVar.d();
            PublicMsg a3 = j.a(this.f37732a, f2, c2, bArr);
            if (a3 == null || TextUtils.isEmpty(a3.mDescription)) {
                m.a("MultiPrivateNotificationHandler*BBind*>>> pMsg JSON parsing error!", this.f37732a);
                i2 = 2;
            } else {
                com.baidu.android.pushservice.a.d a4 = com.baidu.android.pushservice.a.d.a(this.f37732a, c2);
                if (TextUtils.isEmpty(d2) || !m.b(this.f37732a, d2)) {
                    if (a4.a() == com.baidu.android.pushservice.a.c.f36923a) {
                        d2 = a4.f36926a.b();
                    }
                    m.a(this.f37732a, a3);
                    i2 = 1;
                    if (AnonymousClass1.f37733a[a4.a().ordinal()] == 1) {
                        m.a("MultiPrivateNotificationHandler*BBind*>>> Don't Show pMsg private Notification! package name is null", this.f37732a);
                        i2 = 7;
                    } else {
                        PackageManager packageManager = this.f37732a.getPackageManager();
                        try {
                            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(a3.mPkgName, 128);
                            if (TextUtils.isEmpty(a3.mTitle)) {
                                a3.mTitle = packageManager.getApplicationLabel(applicationInfo).toString();
                            }
                            f.a(this.f37732a, a3, f2, c2, g2, i3, bArr, a2);
                            m.a(f2 + " is showing Notification!", this.f37732a);
                        } catch (PackageManager.NameNotFoundException e2) {
                            new b.c(this.f37732a).a(Log.getStackTraceString(e2)).a();
                            i2 = 8;
                        }
                    }
                }
                a3.mPkgName = d2;
                m.a(this.f37732a, a3);
                i2 = 1;
                if (AnonymousClass1.f37733a[a4.a().ordinal()] == 1) {
                }
            }
            com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
            gVar.a(i2);
            return gVar;
        }
        return (com.baidu.android.pushservice.message.g) invokeLL.objValue;
    }
}

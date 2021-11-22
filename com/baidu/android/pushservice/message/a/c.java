package com.baidu.android.pushservice.message.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.message.CrossPushMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.message.a.c$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36584a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1053624477, "Lcom/baidu/android/pushservice/message/a/c$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1053624477, "Lcom/baidu/android/pushservice/message/a/c$1;");
                    return;
                }
            }
            int[] iArr = new int[com.baidu.android.pushservice.a.c.a().length];
            f36584a = iArr;
            try {
                iArr[com.baidu.android.pushservice.a.c.f35801a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
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

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Build.VERSION.SDK_INT <= 26 && (m.j() || m.k()) : invokeV.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        List<ResolveInfo> list;
        Intent parseUri;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                parseUri = Intent.parseUri("baidupush://bdpush/cross", 0);
                parseUri.setPackage(str);
                packageManager = context.getPackageManager();
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                list = null;
            }
            if (packageManager == null) {
                return false;
            }
            list = packageManager.queryIntentActivities(parseUri, 0);
            return (list == null || list.isEmpty()) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.android.pushservice.message.a.d
    public com.baidu.android.pushservice.message.g a(com.baidu.android.pushservice.message.k kVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kVar, bArr)) == null) {
            int i2 = 20;
            if (a()) {
                String c2 = kVar.c();
                String f2 = kVar.f();
                int a2 = kVar.a();
                byte[] h2 = kVar.h();
                CrossPushMessage b2 = j.b(this.f36585a, f2, c2, bArr);
                if (!this.f36585a.getPackageName().equals(b2.mPkgName) || TextUtils.isEmpty(b2.f36573a)) {
                    i2 = 2;
                } else if (!m.b(this.f36585a, b2.f36573a)) {
                    i2 = 8;
                } else if (a(this.f36585a, b2.f36573a)) {
                    if (AnonymousClass1.f36584a[com.baidu.android.pushservice.a.d.a(this.f36585a, c2).a().ordinal()] != 1) {
                        i2 = 7;
                    } else {
                        f.a(this.f36585a, b2, c2, h2, bArr, a2);
                        i2 = 1;
                    }
                }
            }
            com.baidu.android.pushservice.message.g gVar = new com.baidu.android.pushservice.message.g();
            gVar.a(i2);
            return gVar;
        }
        return (com.baidu.android.pushservice.message.g) invokeLL.objValue;
    }
}

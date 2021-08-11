package c.r.a.a.a.b.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.f.a f35282a;

    /* renamed from: b  reason: collision with root package name */
    public String f35283b;

    /* renamed from: c  reason: collision with root package name */
    public String f35284c;

    /* renamed from: d  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f35285d;

    /* renamed from: e  reason: collision with root package name */
    public Context f35286e;

    /* renamed from: f  reason: collision with root package name */
    public CountDownLatch f35287f;

    /* renamed from: g  reason: collision with root package name */
    public ServiceConnection f35288g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35289h;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35282a = null;
        this.f35283b = null;
        this.f35284c = null;
        this.f35287f = new CountDownLatch(1);
        this.f35288g = new b(this);
        this.f35289h = false;
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
            } catch (PackageManager.NameNotFoundException e2) {
                c.r.a.a.c.b.c.c(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                if (!TextUtils.isEmpty(this.f35284c) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f35283b)) {
                    String a2 = this.f35282a.a(this.f35283b, this.f35284c, str);
                    return TextUtils.isEmpty(a2) ? "" : a2;
                }
                return "";
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final void d(Context context) {
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || (serviceConnection = this.f35288g) == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void e(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) {
            try {
                this.f35285d = bVar;
                this.f35286e = context;
                boolean h2 = h(context);
                this.f35289h = h2;
                if (!h2) {
                    f(false);
                    return;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (!context.bindService(intent, this.f35288g, 1)) {
                    f(false);
                    return;
                }
                if (TextUtils.isEmpty(this.f35283b)) {
                    this.f35283b = context.getPackageName();
                }
                if (TextUtils.isEmpty(this.f35284c) && (signatureArr = context.getPackageManager().getPackageInfo(this.f35283b, 64).signatures) != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        this.f35284c = sb.toString();
                    }
                }
                this.f35287f.await(10L, TimeUnit.SECONDS);
                if (this.f35282a != null) {
                    f(true);
                } else {
                    f(false);
                }
            } catch (Throwable th) {
                c.r.a.a.c.b.c.c(th);
                f(false);
            }
        }
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                try {
                    String b2 = b("OUID");
                    if (!TextUtils.isEmpty(b2)) {
                        this.f35285d.a(b2);
                        return;
                    }
                } catch (Throwable th) {
                    c.r.a.a.c.b.c.c(th);
                    return;
                }
            }
            this.f35285d.e();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35289h : invokeV.booleanValue;
    }
}

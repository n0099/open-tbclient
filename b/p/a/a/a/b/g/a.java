package b.p.a.a.a.b.g;

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
/* loaded from: classes6.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.f.a f34466a;

    /* renamed from: b  reason: collision with root package name */
    public String f34467b;

    /* renamed from: c  reason: collision with root package name */
    public String f34468c;

    /* renamed from: d  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f34469d;

    /* renamed from: e  reason: collision with root package name */
    public Context f34470e;

    /* renamed from: f  reason: collision with root package name */
    public CountDownLatch f34471f;

    /* renamed from: g  reason: collision with root package name */
    public ServiceConnection f34472g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34473h;

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
        this.f34466a = null;
        this.f34467b = null;
        this.f34468c = null;
        this.f34471f = new CountDownLatch(1);
        this.f34472g = new b(this);
        this.f34473h = false;
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
            } catch (PackageManager.NameNotFoundException e2) {
                b.p.a.a.c.b.c.c(e2);
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
                if (!TextUtils.isEmpty(this.f34468c) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f34467b)) {
                    String a2 = this.f34466a.a(this.f34467b, this.f34468c, str);
                    return TextUtils.isEmpty(a2) ? "" : a2;
                }
                return "";
            } catch (Throwable th) {
                b.p.a.a.c.b.c.c(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final void d(Context context) {
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || (serviceConnection = this.f34472g) == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void e(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar) == null) {
            try {
                this.f34469d = bVar;
                this.f34470e = context;
                boolean h2 = h(context);
                this.f34473h = h2;
                if (!h2) {
                    f(false);
                    return;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (!context.bindService(intent, this.f34472g, 1)) {
                    f(false);
                    return;
                }
                if (TextUtils.isEmpty(this.f34467b)) {
                    this.f34467b = context.getPackageName();
                }
                if (TextUtils.isEmpty(this.f34468c) && (signatureArr = context.getPackageManager().getPackageInfo(this.f34467b, 64).signatures) != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        this.f34468c = sb.toString();
                    }
                }
                this.f34471f.await(10L, TimeUnit.SECONDS);
                if (this.f34466a != null) {
                    f(true);
                } else {
                    f(false);
                }
            } catch (Throwable th) {
                b.p.a.a.c.b.c.c(th);
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
                        this.f34469d.a(b2);
                        return;
                    }
                } catch (Throwable th) {
                    b.p.a.a.c.b.c.c(th);
                    return;
                }
            }
            this.f34469d.e();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34473h : invokeV.booleanValue;
    }
}

package c.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import c.b.a.c1;
import c.b.a.v0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.bi;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public final class a1 implements v0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final v0 f31317a;

    /* renamed from: b  reason: collision with root package name */
    public j0<Boolean> f31318b;

    /* loaded from: classes4.dex */
    public class a extends j0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(a1 a1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.a.j0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            InterceptResult invokeL;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) {
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return Boolean.FALSE;
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        j2 = packageInfo.getLongVersionCode();
                    } else {
                        j2 = packageInfo.versionCode;
                    }
                    return Boolean.valueOf(j2 >= 1);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return Boolean.FALSE;
                }
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c1.b<bi, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f31319a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a1 f31320b;

        public b(a1 a1Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a1Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31320b = a1Var;
            this.f31319a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.a.c1.b
        /* renamed from: b */
        public bi a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iBinder)) == null) ? bi.a.a(iBinder) : (bi) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.a.c1.b
        /* renamed from: c */
        public String a(bi biVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, biVar)) == null) {
                if (biVar == null) {
                    return null;
                }
                String c2 = this.f31320b.c(this.f31319a);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                return biVar.a(this.f31319a.getPackageName(), c2, "OUID");
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a1() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((v0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.b.a.v0
    public v0.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (this.f31317a != null && !this.f31318b.b(new Object[0]).booleanValue()) {
                return this.f31317a.b(context);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            v0.a aVar = new v0.a();
            aVar.f31438a = (String) new c1(context, intent, new b(this, context)).a();
            return aVar;
        }
        return (v0.a) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0031 A[Catch: Exception -> 0x0058, TryCatch #0 {Exception -> 0x0058, blocks: (B:16:0x0029, B:18:0x0031, B:20:0x003d, B:21:0x0053), top: B:30:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(Context context) {
        InterceptResult invokeL;
        Signature[] signatureArr;
        MessageDigest messageDigest;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (packageInfo != null) {
                signatureArr = packageInfo.signatures;
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b2 : digest) {
                                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                            }
                            return sb.toString();
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            }
            signatureArr = null;
            if (signatureArr != null) {
                byte[] byteArray2 = signatureArr[0].toByteArray();
                messageDigest = MessageDigest.getInstance("SHA1");
                if (messageDigest != null) {
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public a1(v0 v0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31318b = new a(this);
        this.f31317a = v0Var;
    }

    @Override // c.b.a.v0
    public boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (context == null) {
                return false;
            }
            Boolean b2 = this.f31318b.b(context);
            if (this.f31317a != null && !b2.booleanValue()) {
                return this.f31317a.a(context);
            }
            return b2.booleanValue();
        }
        return invokeL.booleanValue;
    }
}

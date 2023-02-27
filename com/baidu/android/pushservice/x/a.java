package com.baidu.android.pushservice.x;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.NotificationBuilderManager;
import com.baidu.android.pushservice.PushMessageReceiver;
import com.baidu.android.pushservice.PushServiceReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a c;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<Long, String> a;
    public final HashMap<Long, PushMessageReceiver.PushCallBackExtra> b;

    /* renamed from: com.baidu.android.pushservice.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0037a extends com.baidu.android.pushservice.z.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ PushMessageReceiver.PushCallBackExtra f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0037a(a aVar, String str, short s, Context context, String str2, int i, PushMessageReceiver.PushCallBackExtra pushCallBackExtra) {
            super(str, s);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Short.valueOf(s), context, str2, Integer.valueOf(i), pushCallBackExtra};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Short) objArr2[1]).shortValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = context;
            this.d = str2;
            this.e = i;
            this.f = pushCallBackExtra;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NotificationBuilderManager.a(this.c, this.d, this.e, this.f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-676453165, "Lcom/baidu/android/pushservice/x/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-676453165, "Lcom/baidu/android/pushservice/x/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = new HashMap<>();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (a.class) {
                    if (c == null) {
                        c = new a();
                    }
                }
            }
            return c;
        }
        return (a) invokeV.objValue;
    }

    public static void a(Context context, long j, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, Long.valueOf(j), Integer.valueOf(i)}) == null) || context == null || j <= 0) {
            return;
        }
        Intent intent = new Intent("com.baidu.android.pushservice.action.receiver.SHOW_ASYNC_NOTIFICATION");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, PushServiceReceiver.class);
        intent.putExtra("com.baidu.android.pushservice.SHOW_ASYNC_NOTIFICATION_KEY", j);
        intent.putExtra("com.baidu.android.pushservice.SHOW_ASYNC_NOTIFICATION_NOTIFY_ID", i);
        context.sendBroadcast(intent);
    }

    public long a(String str, int i, boolean z, String str2) {
        int i2;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), str2})) == null) {
            try {
                i2 = new JSONObject(str).optInt("notification_builder_id");
            } catch (JSONException unused) {
                i2 = 0;
            }
            if (i2 >= 100) {
                long currentTimeMillis = System.currentTimeMillis();
                PushMessageReceiver.PushCallBackExtra pushCallBackExtra = new PushMessageReceiver.PushCallBackExtra();
                pushCallBackExtra.connectSource = i;
                pushCallBackExtra.fromLocal = z;
                pushCallBackExtra.logExt = str2;
                pushCallBackExtra.asyncMsgKey = currentTimeMillis;
                pushCallBackExtra.isLongConnection = true;
                this.b.put(Long.valueOf(currentTimeMillis), pushCallBackExtra);
                this.a.put(Long.valueOf(currentTimeMillis), str);
                return currentTimeMillis;
            }
            return 0L;
        }
        return invokeCommon.longValue;
    }

    public void b(Context context, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            String remove = this.a.remove(Long.valueOf(j));
            PushMessageReceiver.PushCallBackExtra remove2 = this.b.remove(Long.valueOf(j));
            if (TextUtils.isEmpty(remove)) {
                return;
            }
            com.baidu.android.pushservice.z.e.a().a(new C0037a(this, "showAsyncNotify", (short) 99, context, remove, i, remove2));
        }
    }
}

package c.a.x0.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f31097c = "UnionIDHelper";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f31098d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f31099e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f31100f;

    /* renamed from: g  reason: collision with root package name */
    public static final Object f31101g;

    /* renamed from: h  reason: collision with root package name */
    public static e f31102h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile c.a.x0.e.f.c f31103a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f31104b;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f31105e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f31106f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f31107g;

        public a(e eVar, Context context, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31107g = eVar;
            this.f31105e = context;
            this.f31106f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e.f31098d) {
                    String unused = e.f31097c;
                }
                c.a.x0.e.f.a m = this.f31107g.m(this.f31105e);
                if (e.f31098d) {
                    String unused2 = e.f31097c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("asyncRequest, cachedBean == null ？");
                    sb.append(m == null);
                    sb.toString();
                }
                if (m == null || this.f31107g.q(m)) {
                    if (e.f31098d) {
                        String unused3 = e.f31097c;
                    }
                    this.f31107g.r();
                    if (e.f31098d) {
                        String unused4 = e.f31097c;
                    }
                    this.f31107g.f31104b.set(this.f31107g.t(this.f31105e));
                    if (e.f31098d) {
                        String unused5 = e.f31097c;
                    }
                }
                if (e.f31098d) {
                    String unused6 = e.f31097c;
                }
                this.f31106f.obtainMessage(100, this.f31107g.f31103a).sendToTarget();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.x0.e.f.b f31108a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, c.a.x0.e.f.b bVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31108a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what != 100) {
                    return;
                }
                c.a.x0.e.f.c cVar = (c.a.x0.e.f.c) message.obj;
                if (e.f31098d) {
                    String unused = e.f31097c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("handleMessage ，what：");
                    sb.append(cVar == null ? "" : cVar.getOAID());
                    sb.toString();
                }
                c.a.x0.e.f.b bVar = this.f31108a;
                if (bVar != null) {
                    bVar.a(cVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(394831153, "Lc/a/x0/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(394831153, "Lc/a/x0/e/e;");
                return;
            }
        }
        f31098d = c.a.x0.e.a.e();
        f31099e = j(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, Constants.SHORT_PING_CMD_TYPE, 49, 107, 61});
        f31100f = j(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
        f31101g = new Object();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new AtomicBoolean(false);
        this.f31104b = new AtomicBoolean(false);
    }

    public static String j(byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr2 : bArr) {
                sb.append(new String(c.a.x0.e.h.c.a(bArr2)));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new String(c.a.x0.e.h.a.a(f31099e, f31100f, c.a.x0.e.h.c.a(str.getBytes())));
            } catch (Exception e2) {
                if (f31098d) {
                    String str2 = "getCacheObject ，decryptUnionID：" + e2.getMessage();
                    return "";
                }
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return c.a.x0.e.h.c.c(c.a.x0.e.h.a.b(f31099e, f31100f, str.getBytes()), "utf-8");
            } catch (UnsupportedEncodingException | Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static e o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            if (f31102h == null) {
                synchronized (e.class) {
                    if (f31102h == null) {
                        f31102h = new e();
                    }
                }
            }
            return f31102h;
        }
        return (e) invokeV.objValue;
    }

    public synchronized void i(Context context, @NonNull Looper looper, @Nullable c.a.x0.e.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, looper, bVar) == null) {
            synchronized (this) {
                if (looper != null) {
                    b bVar2 = new b(looper, bVar);
                    if (p()) {
                        bVar2.obtainMessage(100, null).sendToTarget();
                        return;
                    }
                    if (this.f31103a != null && this.f31104b.get()) {
                        if (f31098d) {
                            String str = "asyncRequest, mIUnionId.getOAID：" + this.f31103a.getOAID();
                            String str2 = "asyncRequest, mIUnionId.isTrackLimited：" + this.f31103a.c();
                            String str3 = "asyncRequest, mIUnionId.getStatusCode：" + this.f31103a.getStatusCode();
                        }
                        bVar2.obtainMessage(100, this.f31103a).sendToTarget();
                    } else {
                        if (!this.f31104b.get()) {
                            this.f31103a = new c(context).f31094a;
                        }
                        new Thread(new a(this, context, bVar2)).start();
                    }
                    return;
                }
                throw new NullPointerException("param looper not null");
            }
        }
    }

    public final c.a.x0.e.f.a m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
            if (!file.exists()) {
                boolean z = f31098d;
                return null;
            }
            File file2 = new File(file, ".bd_un_info.so");
            if (!file2.exists()) {
                boolean z2 = f31098d;
                return null;
            }
            String a2 = c.a.x0.e.h.e.a(file2, f31101g);
            if (f31098d) {
                String str = "getCacheObject ，content：" + a2;
            }
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            String k = k(a2);
            if (f31098d) {
                String str2 = "getCacheObject ，json：" + k;
            }
            try {
                JSONObject jSONObject = new JSONObject(k);
                c.a.x0.e.f.a aVar = new c.a.x0.e.f.a();
                s(aVar, jSONObject);
                return aVar;
            } catch (Exception e2) {
                if (f31098d) {
                    String str3 = "getCacheObject , " + e2.getMessage();
                }
                return null;
            }
        }
        return (c.a.x0.e.f.a) invokeL.objValue;
    }

    public final long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.x0.e.a.a(c.a.x0.e.b.a()) * 60 * 1000 : invokeV.longValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.x0.e.a.d(c.a.x0.e.b.a()) : invokeV.booleanValue;
    }

    public final boolean q(@NonNull c.a.x0.e.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (Math.abs(System.currentTimeMillis() - aVar.f31109a) > n()) {
                boolean z = f31098d;
                return true;
            }
            boolean z2 = f31098d;
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f31103a = this.f31103a.d();
            if (f31098d) {
                String str = "asyncRequest, requestFromManufacturer done :" + this.f31103a.getOAID();
            }
        }
    }

    public final boolean s(c.a.x0.e.f.a aVar, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, aVar, jSONObject)) == null) {
            try {
                long optLong = jSONObject.optLong(new String(c.a.x0.e.h.c.a("dGltZQ==".getBytes())));
                aVar.f31109a = optLong;
                if (f31098d) {
                    String str = "tryParseCacheJsonObject ，time：" + optLong;
                    String str2 = "tryParseCacheJsonObject ，System.currentTimeMillis() - time：" + (System.currentTimeMillis() - optLong);
                }
                String str3 = new String(c.a.x0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
                if (f31098d) {
                    String str4 = "tryParseCacheJsonObject objKey：" + str3;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                if (f31098d) {
                    String str5 = "tryParseCacheJsonObject ，jsonObject：" + optJSONObject;
                }
                if (optJSONObject != null) {
                    String str6 = new String(c.a.x0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str7 = new String(c.a.x0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                    String str8 = new String(c.a.x0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str9 = new String(c.a.x0.e.h.c.a("b2FpZA==".getBytes()));
                    String str10 = new String(c.a.x0.e.h.c.a("YWFpZA==".getBytes()));
                    String str11 = new String(c.a.x0.e.h.c.a("dmFpZA==".getBytes()));
                    boolean optBoolean = optJSONObject.optBoolean(str6);
                    boolean optBoolean2 = optJSONObject.optBoolean(str7);
                    int optInt = optJSONObject.optInt(str8);
                    String optString = optJSONObject.optString(str9);
                    String optString2 = optJSONObject.optString(str10);
                    String optString3 = optJSONObject.optString(str11);
                    this.f31103a.i(optBoolean);
                    this.f31103a.e(optBoolean2);
                    this.f31103a.a(optInt);
                    this.f31103a.g(optString);
                    this.f31103a.f(optString2);
                    this.f31103a.b(optString3);
                    aVar.f31110b = this.f31103a;
                    return true;
                }
                aVar.f31110b = null;
                boolean z = f31098d;
                return false;
            } catch (Exception e2) {
                if (f31098d) {
                    String str12 = "tryParseCacheJsonObject ：" + e2.getMessage();
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            try {
                if (this.f31103a != null && !TextUtils.isEmpty(this.f31103a.getOAID())) {
                    File file = new File(context.getFilesDir().getAbsolutePath() + "/bdunionid/");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(file, ".bd_un_info.so");
                    String str = new String(c.a.x0.e.h.c.a("dGltZQ==".getBytes()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, System.currentTimeMillis());
                    String str2 = new String(c.a.x0.e.h.c.a("dW5pb25JRG9iag==".getBytes()));
                    JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    String str3 = new String(c.a.x0.e.h.c.a("aXNUcmFja0xpbWl0ZWQ=".getBytes()));
                    String str4 = new String(c.a.x0.e.h.c.a("aXNTdXBwb3J0".getBytes()));
                    String str5 = new String(c.a.x0.e.h.c.a("c3RhdHVzY29kZQ==".getBytes()));
                    String str6 = new String(c.a.x0.e.h.c.a("b2FpZA==".getBytes()));
                    String str7 = new String(c.a.x0.e.h.c.a("YWFpZA==".getBytes()));
                    String str8 = new String(c.a.x0.e.h.c.a("dmFpZA==".getBytes()));
                    optJSONObject.put(str3, this.f31103a.c());
                    optJSONObject.put(str4, this.f31103a.h());
                    optJSONObject.put(str5, this.f31103a.getStatusCode());
                    optJSONObject.put(str6, this.f31103a.getOAID());
                    optJSONObject.put(str7, this.f31103a.getAAID());
                    optJSONObject.put(str8, this.f31103a.getVAID());
                    jSONObject.put(str2, optJSONObject);
                    c.a.x0.e.h.e.b(l(jSONObject.toString()), file2, false, f31101g);
                    if (f31098d) {
                        String str9 = "trySaveFiles, app: " + jSONObject.toString();
                        return true;
                    }
                    return true;
                }
                return false;
            } catch (Exception e2) {
                if (f31098d) {
                    String str10 = "trySaveFiles, error " + e2.getMessage();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}

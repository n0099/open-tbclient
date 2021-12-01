package c.q.b.f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.open.activity.AssistActivity;
import com.yy.open.activity.BridgeActivity;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<c> a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f31035b;

    /* renamed from: c  reason: collision with root package name */
    public Context f31036c;

    /* renamed from: d  reason: collision with root package name */
    public String f31037d;

    /* renamed from: e  reason: collision with root package name */
    public c.q.b.g.a f31038e;

    /* renamed from: c.q.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1632a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f31039e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.q.b.b f31040f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Intent f31041g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f31042h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f31043i;

        public RunnableC1632a(a aVar, int i2, c.q.b.b bVar, Intent intent, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), bVar, intent, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31043i = aVar;
            this.f31039e = i2;
            this.f31040f = bVar;
            this.f31041g = intent;
            this.f31042h = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f31039e == 0) {
                        this.f31040f.onCancel();
                        return;
                    }
                    String stringExtra = this.f31041g.getStringExtra("resjson");
                    this.f31043i.f31038e.a(stringExtra);
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    if (jSONObject.has("resCode") && jSONObject.has("resMsg")) {
                        String optString = jSONObject.optString("resMsg");
                        int optInt = jSONObject.optInt("resCode");
                        if (optInt != 1000006 && optInt != 1290001) {
                            optInt = this.f31039e;
                            this.f31043i.f(this.f31041g, this.f31040f, this.f31042h, optInt, optString);
                            return;
                        }
                        String str2 = "resCode:" + optInt;
                        this.f31043i.f(this.f31041g, this.f31040f, this.f31042h, optInt, optString);
                        return;
                    }
                    if (jSONObject.has("openid") && jSONObject.has("access_code")) {
                        i2 = this.f31039e;
                        str = "success";
                    } else {
                        str = "handleAuthLoginResult--default error!";
                        i2 = 444222199;
                    }
                    this.f31043i.f(this.f31041g, this.f31040f, this.f31042h, i2, str);
                } catch (Exception unused) {
                    this.f31040f.onError(new c.q.b.d(444222105, d.h(444222105)));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.q.b.b f31044e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.q.b.d f31045f;

        public b(a aVar, c.q.b.b bVar, c.q.b.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31044e = bVar;
            this.f31045f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f31044e.onError(this.f31045f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.q.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public long f31046b;

        public c(a aVar, c.q.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f31046b = System.currentTimeMillis();
        }
    }

    public a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31038e = c.q.b.g.a.b();
        this.f31036c = context;
        this.f31037d = str;
        this.a = new SparseArray<>();
        this.f31035b = new Handler(Looper.getMainLooper());
    }

    public final void c(Activity activity, String str, c.q.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, bVar) == null) {
            if (c.q.b.f.c.d(activity, BridgeActivity.class) && c.q.b.f.c.d(activity, AssistActivity.class)) {
                int a = d.a(activity);
                if (a != 0) {
                    try {
                        this.a.put(62345, new c(this, bVar));
                        String c2 = d.c(this.f31036c, this.f31037d, str, true);
                        Intent intent = new Intent(activity, AssistActivity.class);
                        intent.putExtra("type", AssistActivity.TYPE_WEB);
                        intent.putExtra("url", c2);
                        activity.startActivityForResult(intent, 62345);
                        return;
                    } catch (Exception unused) {
                        g(new c.q.b.d(a), bVar);
                        return;
                    }
                }
                Intent e2 = d.e(activity);
                this.a.put(62345, new c(this, bVar));
                Bundle d2 = d.d(activity, this.f31037d);
                e2.putExtra("action", "action_login");
                e2.putExtra("bundle", d2);
                i(activity, e2, 62345);
                return;
            }
            g(new c.q.b.d(3), bVar);
        }
    }

    public final boolean d(int i2, int i3, Intent intent, c.q.b.b bVar) {
        InterceptResult invokeCommon;
        long currentTimeMillis;
        c.q.b.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), intent, bVar})) == null) {
            if (i2 == 62345 || i2 == 62347) {
                c cVar = this.a.get(i2);
                if (cVar != null) {
                    currentTimeMillis = cVar.f31046b;
                    bVar2 = cVar.a;
                    this.a.remove(i2);
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                    bVar2 = bVar;
                }
                if (i2 == 62345) {
                    e(i3, intent, bVar2, currentTimeMillis);
                    return true;
                } else if (i2 == 62347) {
                    h(i3, intent, bVar2, currentTimeMillis);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void e(int i2, Intent intent, c.q.b.b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), intent, bVar, Long.valueOf(j2)}) == null) {
            this.f31035b.postDelayed(new RunnableC1632a(this, i2, bVar, intent, j2), 10L);
        }
    }

    public final void f(Intent intent, c.q.b.b bVar, long j2, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{intent, bVar, Long.valueOf(j2), Integer.valueOf(i2), str}) == null) {
            switch (i2) {
                case 1000006:
                    bVar.onError(new c.q.b.d(1000006, str));
                    return;
                case 1290001:
                    bVar.onError(new c.q.b.d(1290001, str));
                    return;
                case 444111001:
                    try {
                        String stringExtra = intent.getStringExtra("resjson");
                        this.f31038e.a(stringExtra);
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        jSONObject.optString("openid");
                        jSONObject.optString("uid");
                        jSONObject.optString("access_code");
                        bVar.onComplete(jSONObject);
                        return;
                    } catch (Exception unused) {
                        bVar.onError(new c.q.b.d(444222105, d.h(444222105)));
                        return;
                    }
                case 444111002:
                    bVar.onCancel();
                    return;
                case 444111003:
                    try {
                        JSONObject jSONObject2 = new JSONObject(intent.getStringExtra("resjson"));
                        if ("1".equals(jSONObject2.optString("appType"))) {
                            jSONObject2.optString("uid");
                        } else {
                            jSONObject2.optString("openid");
                        }
                        bVar.onComplete(jSONObject2);
                        return;
                    } catch (Exception unused2) {
                        bVar.onError(new c.q.b.d(444222105, d.h(444222105)));
                        return;
                    }
                case 444222000:
                    bVar.onError(new c.q.b.d(444222000, str));
                    return;
                case 444222001:
                    bVar.onError(new c.q.b.d(444222001, str));
                    return;
                case 444222002:
                    bVar.onError(new c.q.b.d(444222002, str));
                    return;
                case 444222003:
                    bVar.onError(new c.q.b.d(444222003, str));
                    return;
                case 444222104:
                    bVar.onError(new c.q.b.d(444222104, str));
                    return;
                case 444222105:
                    bVar.onError(new c.q.b.d(444222105, str));
                    return;
                case 444222106:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        bVar.onError(new c.q.b.d(444222106, str));
                        return;
                    } catch (Exception unused3) {
                        bVar.onError(new c.q.b.d(444222105, d.h(444222105)));
                        return;
                    }
                case 444222108:
                    try {
                        bVar.onComplete(new JSONObject(intent.getStringExtra("resjson")));
                        return;
                    } catch (Exception unused4) {
                        bVar.onError(new c.q.b.d(444222105, d.h(444222105)));
                        return;
                    }
                case 444222110:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        bVar.onError(new c.q.b.d(444222110, str));
                        return;
                    } catch (Exception unused5) {
                        bVar.onError(new c.q.b.d(444222105, d.h(444222105)));
                        return;
                    }
                default:
                    bVar.onError(new c.q.b.d(i2, d.h(i2)));
                    return;
            }
        }
    }

    public final void g(c.q.b.d dVar, c.q.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, dVar, bVar) == null) || bVar == null) {
            return;
        }
        this.f31035b.postDelayed(new b(this, bVar, dVar), 50L);
    }

    public final void h(int i2, Intent intent, c.q.b.b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), intent, bVar, Long.valueOf(j2)}) == null) {
        }
    }

    public final void i(Activity activity, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, activity, intent, i2) == null) {
            intent.putExtra("request_code", i2);
            Intent intent2 = new Intent(activity.getApplicationContext(), BridgeActivity.class);
            intent2.putExtra("intent", intent);
            activity.startActivityForResult(intent2, i2);
        }
    }
}

package c.n.b.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
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
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<c> a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f23629b;

    /* renamed from: c  reason: collision with root package name */
    public Context f23630c;

    /* renamed from: d  reason: collision with root package name */
    public String f23631d;

    /* renamed from: e  reason: collision with root package name */
    public c.n.b.f.a f23632e;

    /* renamed from: c.n.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1662a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.n.b.b f23633b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Intent f23634c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f23635d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f23636e;

        public RunnableC1662a(a aVar, int i, c.n.b.b bVar, Intent intent, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), bVar, intent, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23636e = aVar;
            this.a = i;
            this.f23633b = bVar;
            this.f23634c = intent;
            this.f23635d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a == 0) {
                        this.f23633b.onCancel();
                        return;
                    }
                    String stringExtra = this.f23634c.getStringExtra("resjson");
                    this.f23636e.f23632e.a(stringExtra);
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    if (jSONObject.has("resCode") && jSONObject.has("resMsg")) {
                        String optString = jSONObject.optString("resMsg");
                        int optInt = jSONObject.optInt("resCode");
                        if (optInt != 1000006 && optInt != 1290001) {
                            optInt = this.a;
                            this.f23636e.f(this.f23634c, this.f23633b, this.f23635d, optInt, optString);
                            return;
                        }
                        Log.e("chenqiang", "resCode:" + optInt);
                        this.f23636e.f(this.f23634c, this.f23633b, this.f23635d, optInt, optString);
                        return;
                    }
                    Log.e("chenqiang", "please update yy new version！");
                    if (jSONObject.has("openid") && jSONObject.has("access_code")) {
                        i = this.a;
                        str = "success";
                    } else {
                        str = "handleAuthLoginResult--default error!";
                        i = 444222199;
                    }
                    this.f23636e.f(this.f23634c, this.f23633b, this.f23635d, i, str);
                } catch (Exception unused) {
                    this.f23633b.onError(new c.n.b.c(444222105, d.h(444222105)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.n.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.n.b.c f23637b;

        public b(a aVar, c.n.b.b bVar, c.n.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f23637b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onError(this.f23637b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.n.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public long f23638b;

        public c(a aVar, c.n.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f23638b = System.currentTimeMillis();
        }
    }

    public a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23632e = c.n.b.f.a.b();
        this.f23630c = context;
        this.f23631d = str;
        this.a = new SparseArray<>();
        this.f23629b = new Handler(Looper.getMainLooper());
    }

    public final void c(Activity activity, String str, c.n.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, bVar) == null) {
            if (c.n.b.e.c.d(activity, BridgeActivity.class) && c.n.b.e.c.d(activity, AssistActivity.class)) {
                int a = d.a(activity);
                if (a != 0) {
                    try {
                        this.a.put(62345, new c(this, bVar));
                        String c2 = d.c(this.f23630c, this.f23631d, str, true);
                        Intent intent = new Intent(activity, AssistActivity.class);
                        intent.putExtra("type", AssistActivity.TYPE_WEB);
                        intent.putExtra("url", c2);
                        activity.startActivityForResult(intent, 62345);
                        return;
                    } catch (Exception unused) {
                        g(new c.n.b.c(a), bVar);
                        return;
                    }
                }
                Intent e2 = d.e(activity);
                this.a.put(62345, new c(this, bVar));
                Bundle d2 = d.d(activity, this.f23631d);
                e2.putExtra("action", "action_login");
                e2.putExtra("bundle", d2);
                i(activity, e2, 62345);
                return;
            }
            g(new c.n.b.c(3), bVar);
        }
    }

    public final boolean d(int i, int i2, Intent intent, c.n.b.b bVar) {
        InterceptResult invokeCommon;
        long currentTimeMillis;
        c.n.b.b bVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent, bVar})) == null) {
            if (i == 62345 || i == 62347) {
                c cVar = this.a.get(i);
                if (cVar != null) {
                    currentTimeMillis = cVar.f23638b;
                    bVar2 = cVar.a;
                    this.a.remove(i);
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                    bVar2 = bVar;
                }
                if (i == 62345) {
                    e(i2, intent, bVar2, currentTimeMillis);
                    return true;
                } else if (i == 62347) {
                    h(i2, intent, bVar2, currentTimeMillis);
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void e(int i, Intent intent, c.n.b.b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), intent, bVar, Long.valueOf(j)}) == null) {
            this.f23629b.postDelayed(new RunnableC1662a(this, i, bVar, intent, j), 10L);
        }
    }

    public final void f(Intent intent, c.n.b.b bVar, long j, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{intent, bVar, Long.valueOf(j), Integer.valueOf(i), str}) == null) {
            switch (i) {
                case 1000006:
                    bVar.onError(new c.n.b.c(1000006, str));
                    return;
                case 1290001:
                    bVar.onError(new c.n.b.c(1290001, str));
                    return;
                case 444111001:
                    try {
                        String stringExtra = intent.getStringExtra("resjson");
                        this.f23632e.a(stringExtra);
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        jSONObject.optString("openid");
                        jSONObject.optString("uid");
                        jSONObject.optString("access_code");
                        bVar.onComplete(jSONObject);
                        return;
                    } catch (Exception unused) {
                        bVar.onError(new c.n.b.c(444222105, d.h(444222105)));
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
                        bVar.onError(new c.n.b.c(444222105, d.h(444222105)));
                        return;
                    }
                case 444222000:
                    bVar.onError(new c.n.b.c(444222000, str));
                    return;
                case 444222001:
                    bVar.onError(new c.n.b.c(444222001, str));
                    return;
                case 444222002:
                    bVar.onError(new c.n.b.c(444222002, str));
                    return;
                case 444222003:
                    bVar.onError(new c.n.b.c(444222003, str));
                    return;
                case 444222104:
                    bVar.onError(new c.n.b.c(444222104, str));
                    return;
                case 444222105:
                    bVar.onError(new c.n.b.c(444222105, str));
                    return;
                case 444222106:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        bVar.onError(new c.n.b.c(444222106, str));
                        return;
                    } catch (Exception unused3) {
                        bVar.onError(new c.n.b.c(444222105, d.h(444222105)));
                        return;
                    }
                case 444222108:
                    try {
                        bVar.onComplete(new JSONObject(intent.getStringExtra("resjson")));
                        return;
                    } catch (Exception unused4) {
                        bVar.onError(new c.n.b.c(444222105, d.h(444222105)));
                        return;
                    }
                case 444222110:
                    try {
                        new JSONObject(intent.getStringExtra("resjson"));
                        bVar.onError(new c.n.b.c(444222110, str));
                        return;
                    } catch (Exception unused5) {
                        bVar.onError(new c.n.b.c(444222105, d.h(444222105)));
                        return;
                    }
                default:
                    Log.e("chenqiang", "default  error");
                    bVar.onError(new c.n.b.c(i, d.h(i)));
                    return;
            }
        }
    }

    public final void g(c.n.b.c cVar, c.n.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, cVar, bVar) == null) || bVar == null) {
            return;
        }
        this.f23629b.postDelayed(new b(this, bVar, cVar), 50L);
    }

    public final void h(int i, Intent intent, c.n.b.b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), intent, bVar, Long.valueOf(j)}) == null) {
        }
    }

    public final void i(Activity activity, Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, activity, intent, i) == null) {
            intent.putExtra("request_code", i);
            Intent intent2 = new Intent(activity.getApplicationContext(), BridgeActivity.class);
            intent2.putExtra("intent", intent);
            activity.startActivityForResult(intent2, i);
        }
    }
}

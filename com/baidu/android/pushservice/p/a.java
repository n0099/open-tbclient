package com.baidu.android.pushservice.p;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.c;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a extends com.baidu.android.pushservice.z.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;
    public i d;
    public String e;

    /* renamed from: com.baidu.android.pushservice.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0030a implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0030a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.android.pushservice.c.d
        public void a(int i, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, list) == null) {
                String str = this.a.e.startsWith("https://") ? "https://" : "http://";
                a aVar = this.a;
                aVar.e = aVar.e.replace(str, "");
                int indexOf = this.a.e.indexOf("/");
                if (indexOf > 0) {
                    a aVar2 = this.a;
                    aVar2.e = aVar2.e.substring(indexOf);
                }
                String a = com.baidu.android.pushservice.g.a(this.a.c);
                if (list != null && list.size() > 0) {
                    a = list.get(0);
                }
                a aVar3 = this.a;
                aVar3.e = "https://" + a + this.a.e;
            }
        }
    }

    public a(i iVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = iVar;
        this.c = context.getApplicationContext();
        this.e = com.baidu.android.pushservice.g.a();
        a((short) 100);
        a("http-" + iVar.a);
    }

    @Override // com.baidu.android.pushservice.z.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c();
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            a(i, PushConstants.a(i).getBytes());
        }
    }

    public void a(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr) == null) && this.d.i) {
            Intent intent = new Intent();
            intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
            intent.putExtra("method", this.d.a);
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, i);
            intent.putExtra("content", bArr);
            intent.setFlags(32);
            a(intent);
            if (this.d.a.equals("method_bind")) {
                intent.putExtra("access_token", this.d.b);
                intent.putExtra("secret_key", this.d.f);
                intent.putExtra("real_bind", "real_bind");
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                    if (i != 0) {
                        jSONObject.getString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                    } else {
                        com.baidu.android.pushservice.a0.m.a(this.c, new Intent());
                    }
                } catch (JSONException unused) {
                }
            } else if (bArr != null) {
                this.d.a.equals("method_unbind");
            }
            if (TextUtils.isEmpty(this.d.c)) {
                return;
            }
            String str = "> sendResult to " + this.d.f + ", method:" + this.d.a + ", errorCode : " + i + ", content : " + new String(bArr);
            intent.setPackage(this.d.c);
            Utility.c(this.c, intent, intent.getAction(), this.d.c);
        }
    }

    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
        }
    }

    public void a(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hashMap) == null) {
            hashMap.put("Host", com.baidu.android.pushservice.g.b());
        }
    }

    public final int b(int i) {
        InterceptResult invokeI;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048581, this, i)) != null) {
            return invokeI.intValue;
        }
        InputStream inputStream = null;
        try {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                b(hashMap);
                HashMap<String, String> hashMap2 = new HashMap<>();
                a(hashMap2);
                com.baidu.android.pushservice.q.b a = com.baidu.android.pushservice.q.c.a(this.c, this.e, "POST", com.baidu.android.pushservice.q.c.a(hashMap), hashMap2, "application/x-www-form-urlencoded");
                System.currentTimeMillis();
                int a2 = a.a();
                inputStream = a.b();
                if (a2 == 200) {
                    a(0, b(Utility.a(this.c, inputStream)).getBytes());
                    z = false;
                    i2 = 0;
                } else {
                    z = a2 == 503;
                    try {
                        c(Utility.a(this.c, inputStream));
                        i2 = a2;
                    } catch (Exception e) {
                        e = e;
                        com.baidu.android.pushservice.u.a.b("AbstractProcessor", "error : " + e.getMessage(), this.c);
                        if (z) {
                            a(10003);
                        } else {
                            a(ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                        }
                        com.baidu.android.pushservice.q.c.a(this.c, inputStream);
                        return -1;
                    }
                }
                if (inputStream == null || a2 == 0) {
                    if (i >= 2) {
                        a(10002);
                    }
                    i2 = 10002;
                }
                com.baidu.android.pushservice.q.c.a(this.c, inputStream);
                return i2;
            } catch (Throwable th) {
                com.baidu.android.pushservice.q.c.a(this.c, null);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? str : (String) invokeL.objValue;
    }

    public void b(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hashMap) == null) {
            b.a(this.c, hashMap);
            if (TextUtils.isEmpty(this.d.f)) {
                return;
            }
            hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.d.f);
        }
    }

    public void c() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (iVar = this.d) == null || TextUtils.isEmpty(iVar.a)) {
            return;
        }
        if (this.d.a.equals("com.baidu.android.pushservice.action.UNBIND") || !TextUtils.isEmpty(this.d.c)) {
            if (!com.baidu.android.pushservice.a0.g.d(this.c)) {
                com.baidu.android.pushservice.u.a.b("AbstractProcessor", "Network is not useful!", this.c);
                a(10001);
                com.baidu.android.pushservice.a0.m.a(this.c, new Intent());
                return;
            }
            boolean d = d();
            com.baidu.android.pushservice.u.a.c("AbstractProcessor", "netWorkConnect connectResult: " + d, this.c);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || str == null) {
            return;
        }
        if (!str.startsWith("{\"")) {
            str = str.substring(str.indexOf("{\""));
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("error_code");
            String string = jSONObject.getString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            String string2 = jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, string);
            jSONObject2.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, string2);
            a(i, jSONObject2.toString().getBytes());
        } catch (JSONException e) {
            com.baidu.android.pushservice.u.a.b("AbstractProcessor", "error : " + e.getMessage(), this.c);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (TextUtils.isEmpty(this.e)) {
                com.baidu.android.pushservice.u.a.b("AbstractProcessor", "mUrl is null", this.c);
                return false;
            }
            for (int i = 0; i <= 2; i++) {
                int b = b(i);
                if (b == 0) {
                    return true;
                }
                if (b != 10002) {
                    return false;
                }
                e();
                try {
                    Thread.sleep(5000L);
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.baidu.android.pushservice.c.a(this.c).a(0, new C0030a(this));
        }
    }
}

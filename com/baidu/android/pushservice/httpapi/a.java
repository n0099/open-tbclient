package com.baidu.android.pushservice.httpapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.c;
import com.baidu.android.pushservice.h.a.b;
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
public abstract class a extends com.baidu.android.pushservice.g.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public i b;
    public String c;
    public long d;

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
        this.d = 0L;
        this.b = iVar;
        this.a = context.getApplicationContext();
        this.c = com.baidu.android.pushservice.g.e();
        a((short) 100);
        c("http-" + iVar.a);
    }

    private int b(int i) {
        InterceptResult invokeI;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65537, this, i)) != null) {
            return invokeI.intValue;
        }
        InputStream inputStream = null;
        try {
            try {
                HashMap hashMap = new HashMap();
                b(hashMap);
                HashMap hashMap2 = new HashMap();
                a(hashMap2);
                com.baidu.android.pushservice.d.b a = com.baidu.android.pushservice.d.c.a(this.a, this.c, "POST", com.baidu.android.pushservice.d.c.a(hashMap), hashMap2, "application/x-www-form-urlencoded");
                this.d = System.currentTimeMillis();
                int b = a.b();
                inputStream = a.a();
                if (b == 200) {
                    a(0, b(com.baidu.android.pushservice.i.m.a(this.a, inputStream)).getBytes());
                    z = false;
                    i2 = 0;
                } else {
                    z = b == 503;
                    try {
                        a(com.baidu.android.pushservice.i.m.a(this.a, inputStream));
                        i2 = b;
                    } catch (Exception e) {
                        e = e;
                        com.baidu.android.pushservice.f.a.b("AbstractProcessor", "error : " + e.getMessage(), this.a);
                        new b.c(this.a).a(Log.getStackTraceString(e)).a();
                        if (z) {
                            a(10003);
                        } else {
                            a(ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                        }
                        com.baidu.android.pushservice.d.c.a(this.a, inputStream);
                        return -1;
                    }
                }
                if (inputStream == null || b == 0) {
                    if (i >= 2) {
                        a(10002);
                    }
                    i2 = 10002;
                }
                com.baidu.android.pushservice.d.c.a(this.a, inputStream);
                return i2;
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
        } catch (Throwable th) {
            com.baidu.android.pushservice.d.c.a(this.a, null);
            throw th;
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.baidu.android.pushservice.c.a(this.a).a(0, new c.a(this) { // from class: com.baidu.android.pushservice.httpapi.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.android.pushservice.c.a
                public void a(int i, List list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, list) == null) {
                        String str = this.a.c.startsWith("https://") ? "https://" : "http://";
                        a aVar = this.a;
                        aVar.c = aVar.c.replace(str, "");
                        int indexOf = this.a.c.indexOf("/");
                        if (indexOf > 0) {
                            a aVar2 = this.a;
                            aVar2.c = aVar2.c.substring(indexOf);
                        }
                        String d = com.baidu.android.pushservice.g.d(this.a.a);
                        if (list != null && list.size() > 0) {
                            d = (String) list.get(0);
                        }
                        a aVar3 = this.a;
                        aVar3.c = "https://" + d + this.a.c;
                    }
                }
            });
        }
    }

    @Override // com.baidu.android.pushservice.g.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b();
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            a(i, PushConstants.a(i).getBytes());
        }
    }

    public void a(int i, byte[] bArr) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr) == null) && this.b.j) {
            Intent intent = new Intent();
            intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
            intent.putExtra("method", this.b.a);
            intent.putExtra(GameCodeGetResponseMsg.PARAM_ERROR_MSG, i);
            intent.putExtra("content", bArr);
            intent.setFlags(32);
            a(intent);
            if (this.b.a.equals("method_bind")) {
                intent.putExtra("access_token", this.b.c);
                intent.putExtra("secret_key", this.b.g);
                intent.putExtra("real_bind", "real_bind");
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    String string = jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                    if (i != 0) {
                        str = jSONObject.getString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                    } else {
                        com.baidu.android.pushservice.i.l.a(this.a, new Intent(), 0);
                        str = "";
                    }
                    new b.d(this.a).a("bindForBD").c(i).d(501003L).b(string).b(System.currentTimeMillis()).a(this.d).c(i != 0 ? str : "").a();
                } catch (JSONException unused) {
                }
            } else if (bArr != null) {
                this.b.a.equals("method_unbind");
            }
            if (TextUtils.isEmpty(this.b.d)) {
                return;
            }
            String str2 = "> sendResult to " + this.b.g + ", method:" + this.b.a + ", errorCode : " + i + ", content : " + new String(bArr);
            intent.setPackage(this.b.d);
            com.baidu.android.pushservice.i.m.b(this.a, intent, intent.getAction(), this.b.d);
        }
    }

    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null) {
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
            com.baidu.android.pushservice.f.a.b("AbstractProcessor", "error : " + e.getMessage(), this.a);
        }
    }

    public void a(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            hashMap.put("Host", com.baidu.android.pushservice.g.c());
        }
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? str : (String) invokeL.objValue;
    }

    public void b() {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (iVar = this.b) == null || TextUtils.isEmpty(iVar.a)) {
            return;
        }
        if (this.b.a.equals("com.baidu.android.pushservice.action.UNBIND") || !TextUtils.isEmpty(this.b.d)) {
            if (!com.baidu.android.pushservice.i.g.a(this.a)) {
                com.baidu.android.pushservice.f.a.b("AbstractProcessor", "Network is not useful!", this.a);
                a(10001);
                com.baidu.android.pushservice.i.l.a(this.a, new Intent(), 0);
                return;
            }
            boolean c = c();
            com.baidu.android.pushservice.f.a.c("AbstractProcessor", "netWorkConnect connectResult: " + c, this.a);
        }
    }

    public void b(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hashMap) == null) {
            b.a(this.a, hashMap);
            if (TextUtils.isEmpty(this.b.g)) {
                return;
            }
            hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.b.g);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (TextUtils.isEmpty(this.c)) {
                com.baidu.android.pushservice.f.a.b("AbstractProcessor", "mUrl is null", this.a);
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
}

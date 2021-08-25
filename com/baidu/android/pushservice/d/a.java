package com.baidu.android.pushservice.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.c;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.sapi2.share.ShareCallPacking;
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
/* loaded from: classes4.dex */
public abstract class a extends com.baidu.android.pushservice.h.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f37032a;

    /* renamed from: b  reason: collision with root package name */
    public i f37033b;

    /* renamed from: c  reason: collision with root package name */
    public String f37034c;

    /* renamed from: d  reason: collision with root package name */
    public long f37035d;

    public a(i iVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVar, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37035d = 0L;
        this.f37033b = iVar;
        this.f37032a = context.getApplicationContext();
        this.f37034c = com.baidu.android.pushservice.h.e();
        a((short) 100);
        c("http-" + iVar.f37048a);
    }

    private int b(int i2) {
        InterceptResult invokeI;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65537, this, i2)) != null) {
            return invokeI.intValue;
        }
        InputStream inputStream = null;
        try {
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                b(hashMap);
                HashMap<String, String> hashMap2 = new HashMap<>();
                a(hashMap2);
                com.baidu.android.pushservice.e.b a2 = com.baidu.android.pushservice.e.c.a(this.f37032a, this.f37034c, "POST", com.baidu.android.pushservice.e.c.a(hashMap), hashMap2, "application/x-www-form-urlencoded");
                this.f37035d = System.currentTimeMillis();
                int b2 = a2.b();
                inputStream = a2.a();
                if (b2 == 200) {
                    a(0, b(com.baidu.android.pushservice.j.m.a(this.f37032a, inputStream)).getBytes());
                    z = false;
                    i3 = 0;
                } else {
                    z = b2 == 503;
                    try {
                        a(com.baidu.android.pushservice.j.m.a(this.f37032a, inputStream));
                        i3 = b2;
                    } catch (Exception e2) {
                        e = e2;
                        com.baidu.android.pushservice.g.a.b("AbstractProcessor", "error : " + e.getMessage(), this.f37032a);
                        new b.c(this.f37032a).a(Log.getStackTraceString(e)).a();
                        if (z) {
                            a(10003);
                        } else {
                            com.baidu.android.pushservice.j.m.a("tryConnect failed setResult UnKnown " + e.getMessage(), this.f37032a);
                            a(ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT);
                        }
                        com.baidu.android.pushservice.e.c.a(this.f37032a, inputStream);
                        return -1;
                    }
                }
                if (inputStream == null || b2 == 0) {
                    if (i2 >= 2) {
                        a(10002);
                    }
                    i3 = 10002;
                }
                com.baidu.android.pushservice.e.c.a(this.f37032a, inputStream);
                return i3;
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
        } catch (Throwable th) {
            com.baidu.android.pushservice.e.c.a(this.f37032a, null);
            throw th;
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.baidu.android.pushservice.c.a(this.f37032a).a(0, new c.a(this) { // from class: com.baidu.android.pushservice.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f37036a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37036a = this;
                }

                @Override // com.baidu.android.pushservice.c.a
                public void a(int i2, List<String> list) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, list) == null) {
                        String str = this.f37036a.f37034c.startsWith("https://") ? "https://" : "http://";
                        a aVar = this.f37036a;
                        aVar.f37034c = aVar.f37034c.replace(str, "");
                        int indexOf = this.f37036a.f37034c.indexOf("/");
                        if (indexOf > 0) {
                            a aVar2 = this.f37036a;
                            aVar2.f37034c = aVar2.f37034c.substring(indexOf);
                        }
                        String d2 = com.baidu.android.pushservice.h.d(this.f37036a.f37032a);
                        if (list != null && list.size() > 0) {
                            d2 = list.get(0);
                        }
                        a aVar3 = this.f37036a;
                        aVar3.f37034c = "https://" + d2 + this.f37036a.f37034c;
                    }
                }
            });
        }
    }

    @Override // com.baidu.android.pushservice.h.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b();
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            a(i2, PushConstants.a(i2).getBytes());
        }
    }

    public void a(int i2, byte[] bArr) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bArr) == null) && this.f37033b.f37057j) {
            Intent intent = new Intent();
            intent.setAction("com.baidu.android.pushservice.action.RECEIVE");
            intent.putExtra("method", this.f37033b.f37048a);
            intent.putExtra("error_msg", i2);
            intent.putExtra("content", bArr);
            intent.setFlags(32);
            a(intent);
            if (this.f37033b.f37048a.equals("method_bind")) {
                intent.putExtra("access_token", this.f37033b.f37050c);
                intent.putExtra("secret_key", this.f37033b.f37054g);
                intent.putExtra("real_bind", "real_bind");
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    String string = jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                    if (i2 != 0) {
                        str = jSONObject.getString("error_msg");
                    } else {
                        com.baidu.android.pushservice.j.l.a(this.f37032a, new Intent());
                        str = "";
                    }
                    new b.d(this.f37032a).a("bindForBD").c(i2).d(501003L).b(string).b(System.currentTimeMillis()).a(this.f37035d).c(i2 != 0 ? str : "").a();
                } catch (JSONException unused) {
                }
            } else if (bArr != null) {
                this.f37033b.f37048a.equals("method_unbind");
            }
            if (TextUtils.isEmpty(this.f37033b.f37051d)) {
                return;
            }
            com.baidu.android.pushservice.j.m.a("> sendResult to " + this.f37033b.f37054g + ", method:" + this.f37033b.f37048a + ", errorCode : " + i2 + ", content : " + new String(bArr), this.f37032a);
            intent.setPackage(this.f37033b.f37051d);
            com.baidu.android.pushservice.j.m.b(this.f37032a, intent, intent.getAction(), this.f37033b.f37051d);
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
            int i2 = jSONObject.getInt("error_code");
            String string = jSONObject.getString("error_msg");
            String string2 = jSONObject.getString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error_msg", string);
            jSONObject2.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, string2);
            a(i2, jSONObject2.toString().getBytes());
        } catch (JSONException e2) {
            com.baidu.android.pushservice.g.a.b("AbstractProcessor", "error : " + e2.getMessage(), this.f37032a);
        }
    }

    public void a(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            hashMap.put("Host", com.baidu.android.pushservice.h.c());
        }
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? str : (String) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            i iVar = this.f37033b;
            if (iVar == null || TextUtils.isEmpty(iVar.f37048a)) {
                com.baidu.android.pushservice.j.m.a("AbstractProcessor#execute#mEvent = null or mEvent.method = null", this.f37032a);
            } else if (!this.f37033b.f37048a.equals("com.baidu.android.pushservice.action.UNBIND") && TextUtils.isEmpty(this.f37033b.f37051d)) {
                com.baidu.android.pushservice.j.m.a("AbstractProcessor#execute#Unknown method", this.f37032a);
            } else if (!com.baidu.android.pushservice.j.g.a(this.f37032a)) {
                com.baidu.android.pushservice.g.a.b("AbstractProcessor", "Network is not useful!", this.f37032a);
                com.baidu.android.pushservice.j.m.a("AbstractProcessor#execute#Network is unuseful!", this.f37032a);
                a(10001);
                com.baidu.android.pushservice.j.l.a(this.f37032a, new Intent());
            } else {
                boolean c2 = c();
                com.baidu.android.pushservice.g.a.c("AbstractProcessor", "netWorkConnect connectResult: " + c2, this.f37032a);
            }
        }
    }

    public void b(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hashMap) == null) {
            b.a(this.f37032a, hashMap);
            if (TextUtils.isEmpty(this.f37033b.f37054g)) {
                return;
            }
            hashMap.put(TableDefine.ZhiDaColumns.COLUMN_APIKEY, this.f37033b.f37054g);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (TextUtils.isEmpty(this.f37034c)) {
                com.baidu.android.pushservice.g.a.b("AbstractProcessor", "mUrl is null", this.f37032a);
                return false;
            }
            for (int i2 = 0; i2 <= 2; i2++) {
                int b2 = b(i2);
                if (b2 == 0) {
                    return true;
                }
                if (b2 != 10002) {
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

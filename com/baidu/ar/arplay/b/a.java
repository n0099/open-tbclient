package com.baidu.ar.arplay.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.a.a.c;
import com.baidu.ar.arplay.a.e;
import com.baidu.ar.arplay.c.d;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import com.baidu.ar.arplay.core.message.ARPMessage;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.arplay.d.a;
import com.baidu.ar.arplay.d.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DelayTB;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a implements ARPMessage.MessageHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ARPDataInteraction.c fO;
    public Context mContext;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fO = new ARPDataInteraction.c(this) { // from class: com.baidu.ar.arplay.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a fP;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.fP = this;
            }

            @Override // com.baidu.ar.arplay.core.engine.ARPDataInteraction.c
            public void a(String str, int i4, String str2, String str3) {
                SurfaceTexture E;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLILL(1048576, this, str, i4, str2, str3) == null) || (E = e.aL().E(str)) == null) {
                    return;
                }
                try {
                    if (e.aL().D(str) != i4) {
                        e.aL().a(str, i4);
                    }
                    E.updateTexImage();
                } catch (RuntimeException unused) {
                    e.aL().a(str, i4);
                }
            }
        };
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        d.e(applicationContext);
        bi();
    }

    private void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, str) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("type", str);
            handleMessage(ARPMessageType.MSG_TYPE_STATISTICS, 0, hashMap);
        }
    }

    private void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, cVar) == null) {
            I("phone_call");
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setFlags(268435456);
            intent.setData(Uri.parse("tel:" + cVar.getNumber()));
            if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
                this.mContext.startActivity(intent);
            }
        }
    }

    private void a(com.baidu.ar.arplay.a.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, dVar) == null) {
            I("vibrate");
            int type = dVar.getType();
            if (type == 0) {
                com.baidu.ar.arplay.a.d.d(this.mContext).c(dVar.getInterval());
            } else if (type == 1) {
                long[] jArr = null;
                String[] split = dVar.getPattern() != null ? dVar.getPattern().split(",") : null;
                if (split != null && split.length > 0) {
                    int length = split.length;
                    jArr = new long[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        try {
                            jArr[i2] = Long.parseLong(split[i2]);
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                com.baidu.ar.arplay.a.d.d(this.mContext).a(jArr);
            }
        }
    }

    private void a(HashMap<String, Object> hashMap, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, hashMap, i2) == null) || hashMap == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.a aVar = new com.baidu.ar.arplay.a.a.a();
        if (hashMap.get("url") != null) {
            aVar.setUrl(com.baidu.ar.arplay.c.c.a(hashMap.get("url"), (String) null));
        }
        if (hashMap.get(DelayTB.DELAY) != null) {
            aVar.setDelay(((Float) hashMap.get(DelayTB.DELAY)).floatValue());
        }
        if (hashMap.get("id") != null) {
            aVar.setId(com.baidu.ar.arplay.c.c.a(hashMap.get("id"), (String) null));
        }
        if (hashMap.get("loop") != null) {
            int intValue = ((Integer) hashMap.get("loop")).intValue();
            aVar.i(intValue);
            if (intValue <= 0) {
                aVar.g(true);
            }
        }
        if (hashMap.get("target") != null) {
            aVar.F(com.baidu.ar.arplay.c.c.a(hashMap.get("target"), (String) null));
        }
        if (hashMap.get("from_time") != null) {
            aVar.d(com.baidu.ar.arplay.c.c.a(hashMap.get("from_time"), 0));
        }
        if (i2 == 1001) {
            com.baidu.ar.arplay.a.a.aA().a(aVar, hashMap);
        } else if (i2 == 1003) {
            com.baidu.ar.arplay.a.a.aA().b(aVar, hashMap);
        } else if (i2 == 1005) {
            com.baidu.ar.arplay.a.a.aA().c(aVar, hashMap);
        } else if (i2 == 1007) {
            com.baidu.ar.arplay.a.a.aA().d(aVar, hashMap);
        } else if (i2 != 1012) {
        } else {
            com.baidu.ar.arplay.a.a.aA().e(aVar, hashMap);
        }
    }

    private void b(HashMap<String, Object> hashMap, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, hashMap, i2) == null) || hashMap == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.e eVar = new com.baidu.ar.arplay.a.a.e();
        if (hashMap.get("url") != null) {
            eVar.setUrl(com.baidu.ar.arplay.c.c.a(hashMap.get("url"), (String) null));
        }
        if (hashMap.get("id") != null) {
            eVar.setId(com.baidu.ar.arplay.c.c.a(hashMap.get("id"), (String) null));
        }
        if (hashMap.get("texture_id") != null) {
            eVar.k(com.baidu.ar.arplay.c.c.a(hashMap.get("texture_id"), -1));
        }
        if (hashMap.get("loop") != null) {
            int a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("loop"), 0);
            eVar.i(com.baidu.ar.arplay.c.c.a(hashMap.get("loop"), 0));
            if (a2 <= 0) {
                eVar.g(true);
            }
        }
        if (hashMap.get("target") != null) {
            eVar.F(com.baidu.ar.arplay.c.c.a(hashMap.get("target"), (String) null));
        }
        if (hashMap.get("from_time") != null) {
            eVar.d(com.baidu.ar.arplay.c.c.a(hashMap.get("from_time"), 0));
            String str = "bean fromTime: " + eVar.aO();
        }
        if (i2 == 1021) {
            e.aL().a(eVar, hashMap);
        } else if (i2 == 1023) {
            e.aL().b(eVar, hashMap);
        } else if (i2 == 1025) {
            e.aL().c(eVar, hashMap);
        } else if (i2 != 1027) {
        } else {
            e.aL().d(eVar, hashMap);
        }
    }

    private void bi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            ARPEngine.getInstance().setVideoUpdateCallback(this.fO);
        }
    }

    private void e(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, hashMap) == null) || hashMap == null) {
            return;
        }
        String a2 = com.baidu.ar.arplay.c.c.a(hashMap.get("event_name"), "");
        a.C1585a c1585a = new a.C1585a();
        if ("load_webview".equals(a2)) {
            c1585a.dM = com.baidu.ar.arplay.c.c.a(hashMap.get("texture_id"), 0);
            c1585a.width = com.baidu.ar.arplay.c.c.a(hashMap.get("width"), 0);
            c1585a.height = com.baidu.ar.arplay.c.c.a(hashMap.get("height"), 0);
            c1585a.url = com.baidu.ar.arplay.c.c.a(hashMap.get("url"), (String) null);
            c1585a.gd = com.baidu.ar.arplay.c.c.a(hashMap.get("is_remote"), 0) == 1;
            b.bm().c(c1585a);
        } else if ("update_webview_js".equals(a2)) {
            c1585a.dM = com.baidu.ar.arplay.c.c.a(hashMap.get("texture_id"), 0);
            c1585a.ge = com.baidu.ar.arplay.c.c.a(hashMap.get("js_code"), (String) null);
            b.bm().e(c1585a);
        } else if ("load_native_webview".equals(a2)) {
            c1585a.url = com.baidu.ar.arplay.c.c.a(hashMap.get("url"), (String) null);
            c1585a.gd = com.baidu.ar.arplay.c.c.a(hashMap.get("is_remote"), 0) == 1;
            b.bm().d(c1585a);
        }
    }

    private void f(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, hashMap) == null) || hashMap == null) {
            return;
        }
        com.baidu.ar.arplay.a.a.d dVar = new com.baidu.ar.arplay.a.a.d();
        if (hashMap.get("type") != null) {
            dVar.setType(com.baidu.ar.arplay.c.c.a(hashMap.get("type"), 0));
        }
        if (hashMap.get("interval") != null) {
            dVar.j(com.baidu.ar.arplay.c.c.a(hashMap.get("interval"), 0));
        }
        if (hashMap.get("pattern") != null) {
            dVar.setPattern(com.baidu.ar.arplay.c.c.a(hashMap.get("pattern"), (String) null));
        }
        a(dVar);
    }

    private void g(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, hashMap) == null) || hashMap == null) {
            return;
        }
        c cVar = new c();
        Object obj = hashMap.get("number");
        if (obj != null) {
            cVar.G((String) obj);
        }
        a(cVar);
    }

    public void bh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ARPMessage.getInstance().registerMessageHandler(0, this);
            ARPEngine.getInstance().initDataStore(this.mContext.getSharedPreferences("baiduar_lua_data_store", 0));
        }
    }

    @Override // com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
    public void handleMessage(int i2, int i3, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, hashMap) == null) {
            switch (i2) {
                case 0:
                    if (i3 == -2) {
                        e.aL().aB();
                        com.baidu.ar.arplay.a.a.aA().aB();
                        return;
                    }
                    return;
                case 8:
                    ARPEngine.getInstance().onCaseLoadCompleted(hashMap);
                    return;
                case 9:
                    ARPEngine.getInstance().onCaseUnloadCompleted();
                    return;
                case 13:
                    ARPEngine.getInstance().onTempleLoadCompleted(hashMap);
                    return;
                case 1001:
                case 1003:
                case 1005:
                case 1007:
                case 1012:
                    a(hashMap, i2);
                    return;
                case 1021:
                case 1023:
                case 1025:
                case 1027:
                    b(hashMap, i2);
                    return;
                case 1401:
                    g(hashMap);
                    return;
                case 1501:
                    f(hashMap);
                    return;
                case 1901:
                    e(hashMap);
                    return;
                default:
                    return;
            }
        }
    }
}

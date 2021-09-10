package c.a.v0.a.e;

import android.os.Build;
import android.os.Environment;
import c.a.v0.a.c;
import c.a.v0.a.e.d;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.a.n;
import com.baidu.ubs.analytics.b;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class k extends c.a.v0.a.f.c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static String f30329e;
    public transient /* synthetic */ FieldHolder $fh;

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void b(c.h hVar, c.l lVar, c.j jVar, c.b bVar, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{hVar, lVar, jVar, bVar, list, list2, list3}) == null) {
            hVar.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
            lVar.a(m.e().I());
            jVar.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
            bVar.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
        }
    }

    @Override // c.a.v0.a.f.c
    public final void a() {
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dVar = d.a.f30308a;
            if (dVar.a().size() == 0) {
                c.a.v0.a.f.a.b(" 线程轮询  app 应该是退出了");
            }
            if (f30329e == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(i.l(c.a.v0.a.c.i().g()));
                stringBuffer.append("/");
                f30329e = stringBuffer.toString();
            }
            c.h hVar = new c.h();
            c.l lVar = new c.l();
            c.j jVar = new c.j();
            c.b bVar = new c.b();
            List<com.baidu.ubs.analytics.a.i> a2 = hVar.a();
            List<n> d2 = lVar.d();
            List<com.baidu.ubs.analytics.a.l> a3 = jVar.a();
            List<com.baidu.ubs.analytics.a.a> a4 = bVar.a();
            c.a.v0.a.f.a.b("这次查询结果       session ：    " + d2.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                c.a.v0.a.f.a.b("这次记录 json 为空的，就不传了  ………………");
                if (d2.size() > 1) {
                    for (int i2 = 0; i2 < d2.size(); i2++) {
                        if (d2.get(i2).O() == null) {
                            lVar.c(d2.get(i2).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String k = c.a.v0.a.c.i().k();
            if (c.a.v0.a.c.i().l() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : c.a.v0.a.c.i().l().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        c.a.v0.a.f.i.d(e2);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar2 = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(i.l(c.a.v0.a.c.i().g()));
            aVar.b(k);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(i.g(c.a.v0.a.c.i().g()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(i.h(c.a.v0.a.c.i().g()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            aVar.j(f.d() ? "1" : "0");
            aVar.k(i.i(c.a.v0.a.c.i().g()));
            aVar.m(i.j(c.a.v0.a.c.i().g()));
            aVar.n(i.m());
            aVar.o(i.n());
            aVar.p(i.a());
            int f2 = i.f(c.a.v0.a.c.i().g());
            aVar.l(f2 == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : f2 == 2 ? "2G" : f2 == 3 ? "3G" : f2 == 4 ? "4G" : f2 == 5 ? "unKnow" : "noNet");
            c.a.v0.a.c.i();
            aVar.setPhone("");
            bVar2.a(aVar);
            bVar2.c(a4);
            bVar2.e(a2);
            bVar2.b(d2);
            bVar2.d(a3);
            String a5 = c.a.v0.a.f.g.a(bVar2);
            String e3 = c.a.v0.a.f.f.e(f30329e, "ABJson.log");
            if (!e3.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e3);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (c.a.v0.a.d.a.a(c.a.v0.a.c.i().g(), stringBuffer2.toString())) {
                    c.a.v0.a.f.a.b("上传成功，删除本地文件的       ");
                    c.a.v0.a.f.f.b(f30329e + "ABJson.log");
                    b(hVar, lVar, jVar, bVar, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (c.a.v0.a.d.a.a(c.a.v0.a.c.i().g(), stringBuffer3.toString())) {
                    b(hVar, lVar, jVar, bVar, a3, a2, a4);
                    return;
                } else if (c.a.v0.a.f.f.d(a5, f30329e, "ABJson.log")) {
                    b(hVar, lVar, jVar, bVar, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (c.a.v0.a.d.a.a(c.a.v0.a.c.i().g(), stringBuffer4.toString())) {
                b(hVar, lVar, jVar, bVar, a3, a2, a4);
            } else if (c.a.v0.a.f.f.d(a5, f30329e, "ABJson.log")) {
                b(hVar, lVar, jVar, bVar, a3, a2, a4);
            }
        }
    }
}

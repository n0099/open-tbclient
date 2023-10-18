package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class bf extends Observable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "b_f";
    public static final String b = "XAbstractProdTemplate";
    public static final String c = "error_message";
    public static final String d = "error_code";
    public static final String e = "instanceInfo";
    public static final String f = "showState";
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout g;
    public Context h;
    public br i;
    public IOAdEventListener j;
    public IAdInterListener k;
    public boolean l;
    public HashMap<String, String> m;
    public String n;
    public String o;
    public int p;

    public abstract void a();

    public void a(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iOAdEvent) == null) {
        }
    }

    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
        }
    }

    public void b(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, iOAdEvent) == null) {
        }
    }

    public void b(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, str, z) == null) {
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
        }
    }

    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    public void c(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iOAdEvent) == null) {
        }
    }

    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public void d(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, iOAdEvent) == null) {
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
        }
    }

    public void e(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, iOAdEvent) == null) {
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
        }
    }

    public void f(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, iOAdEvent) == null) {
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
        }
    }

    public void h(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, iOAdEvent) == null) {
        }
    }

    public void i(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, iOAdEvent) == null) {
        }
    }

    public void j(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, iOAdEvent) == null) {
        }
    }

    public void k(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, iOAdEvent) == null) {
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements IOAdEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bf a;

        public a(bf bfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bfVar;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iOAdEvent) == null) {
                bf.a(new bi(this, iOAdEvent));
            }
        }

        private String a(IOAdEvent iOAdEvent) {
            InterceptResult invokeL;
            Map<String, Object> data;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, iOAdEvent)) == null) {
                if (iOAdEvent != null) {
                    String message = iOAdEvent.getMessage();
                    if (TextUtils.isEmpty(message) && (data = iOAdEvent.getData()) != null && (obj = data.get("msg")) != null && (obj instanceof String)) {
                        return (String) obj;
                    }
                    return message;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    public bf(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = br.a();
        this.k = null;
        this.l = true;
        this.p = -1;
        this.h = context;
        this.j = new a(this);
        z.a().a(this.h, new bg(this));
    }

    private String a(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, jSONObject)) == null) {
            if (jSONObject == null) {
                try {
                    jSONObject = new JSONObject();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
        }
        return (String) invokeLL.objValue;
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, runnable) != null) || runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new bh(runnable));
            }
        } catch (Exception unused) {
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                b("bidding data is empty", 2);
            }
            if (this.k != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("bidding_data", str);
                a("load_bidding_data", (Map<String, Object>) hashMap);
                return;
            }
            b("Initialization doesn't finish yet.", 1);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                b("bidding id is empty", 2);
            }
            if (this.k != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("bid_id", str);
                a("load_bidding_ad", (Map<String, Object>) hashMap);
                return;
            }
            b("Initialization doesn't finish yet.", 1);
        }
    }

    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            r();
        }
    }

    public void b(View view2, JSONObject jSONObject) {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, view2, jSONObject) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.onAdTaskProcess(view2, a(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) && this.k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("setActivity", activity);
            this.k.onAdTaskProcess(a(IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new JSONObject()), hashMap);
        }
    }

    public JSONObject b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, map)) == null) {
            if (map == null) {
                return null;
            }
            if (!map.isEmpty()) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return new JSONObject(map);
        }
        return (JSONObject) invokeL.objValue;
    }

    public void g(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, iOAdEvent) == null) {
            r();
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.o = str;
        }
    }

    public String i(String str) {
        InterceptResult invokeL;
        IXAdContainerFactory c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
            z a2 = z.a();
            if (a2 != null && (c2 = a2.c()) != null) {
                Object remoteParam = c2.getRemoteParam(str, new Object[0]);
                if (remoteParam instanceof String) {
                    return (String) remoteParam;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void a(View view2, JSONObject jSONObject) {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, view2, jSONObject) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.onAdTaskProcess(view2, a(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, str, i) == null) {
            r();
        }
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, hashMap) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, str);
                if (this.k != null) {
                    this.k.onAdTaskProcess(a(IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), hashMap);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, map) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY, "server_bidding");
                jSONObject.put("msg", str);
                if (this.k != null) {
                    this.k.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Boolean.valueOf(z), str2}) == null) {
            a(str, z, str2, null);
        }
    }

    public void a(String str, boolean z, String str2, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), str2, hashMap}) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uniqueId", str);
                jSONObject.put("result", z);
                jSONObject.put("replacement", str2);
                if (hashMap != null) {
                    for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                        jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                    }
                }
                if (this.k != null) {
                    this.k.onAdTaskProcess(a("onBiddingResult", jSONObject), (Map<String, Object>) null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, map) == null) && map != null && !map.isEmpty()) {
            this.m = (HashMap) map;
        }
    }

    public void b(int i) {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.onWindowVisibilityChanged(i);
        }
    }

    public void a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public void b(JSONObject jSONObject) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, jSONObject) == null) && (i = this.p) >= 0 && jSONObject != null) {
            try {
                jSONObject.put(a, i);
            } catch (Throwable th) {
                this.i.a(th);
            }
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, jSONObject, map) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    public void a(boolean z) {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.onWindowFocusChanged(z);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, keyEvent)) == null) {
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener != null) {
                return iAdInterListener.onKeyDown(i, keyEvent);
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void e() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.destroyAd();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            b("SDK未初始化", 1);
        }
    }

    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    public void o() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void p() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    public void r() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048629, this) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener != null) {
                return iAdInterListener.getAdContainerView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.k = (IAdInterListener) ar.a(w.k, bq.a(this.h), new Class[]{Context.class}, this.h);
            if (!this.l) {
                a();
            }
        }
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            JSONObject k = k();
            JSONObject l = l();
            HashMap hashMap = new HashMap();
            hashMap.put("param_info", k);
            hashMap.put("ad_buss_param", l);
            a("get_request_token", (Map<String, Object>) hashMap);
            Object obj = hashMap.get("request_token");
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void n() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && (iAdInterListener = this.k) != null) {
            iAdInterListener.addEventListener(com.baidu.mobads.sdk.internal.a.c.h, new c.a());
            this.k.addEventListener(w.H, this.j);
            this.k.addEventListener(w.J, this.j);
            this.k.addEventListener(w.L, this.j);
            this.k.addEventListener(w.M, this.j);
            this.k.addEventListener(w.W, this.j);
            this.k.addEventListener(w.r, this.j);
            this.k.addEventListener(w.X, this.j);
            this.k.addEventListener(w.s, this.j);
            this.k.addEventListener(w.N, this.j);
            this.k.addEventListener(w.O, this.j);
            this.k.addEventListener(w.K, this.j);
            this.k.addEventListener(w.D, this.j);
            this.k.addEventListener(w.ac, this.j);
            this.k.addEventListener(w.ad, this.j);
            this.k.addEventListener(w.aa, this.j);
            this.k.addEventListener(w.V, this.j);
            this.k.addEventListener(w.ae, this.j);
            this.k.addEventListener(w.af, this.j);
            this.k.addEventListener(w.ag, this.j);
            this.k.addEventListener(w.ah, this.j);
            this.k.addEventListener(w.ai, this.j);
            this.k.addEventListener(w.aj, this.j);
            this.k.addEventListener(w.ak, this.j);
            this.k.addEventListener(w.al, this.j);
            this.k.addEventListener(w.ab, this.j);
            this.k.addEventListener(w.am, this.j);
            this.k.addEventListener(w.Y, this.j);
            this.k.addEventListener(w.an, this.j);
            this.k.addEventListener(w.ao, this.j);
        }
    }
}

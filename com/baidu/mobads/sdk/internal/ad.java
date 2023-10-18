package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.NativeCPUAdData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ad extends bf {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 17;
    public static final String q = "javascript:";
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public String C;
    public int r;
    public int s;
    public int[] t;
    public boolean u;
    public int v;
    public HashMap<String, Object> w;
    public NativeCPUManager.CPUAdListener x;
    public NativeCPUManager y;
    public int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = 5;
        this.A = 60;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void c(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, iOAdEvent) == null) && iOAdEvent != null) {
            Map<String, Object> data = iOAdEvent.getData();
            Integer num = (Integer) data.get(CriusAttrConstants.POSITION);
            String str = (String) data.get("mislikereason");
            NativeCPUManager.CPUAdListener cPUAdListener = this.x;
            if (cPUAdListener != null && num != null && str != null) {
                cPUAdListener.onDisLikeAdClick(num.intValue(), str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(Context context, String str, NativeCPUManager nativeCPUManager) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, nativeCPUManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z = 5;
        this.A = 60;
        this.o = str;
        this.y = nativeCPUManager;
    }

    private String j(String str) {
        InterceptResult invokeL;
        IXAdContainerFactory c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            z a2 = z.a();
            if (a2 != null && (c = a2.c()) != null) {
                Object remoteParam = c.getRemoteParam(str, new Object[0]);
                if (remoteParam instanceof String) {
                    return (String) remoteParam;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void d(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iOAdEvent) == null) {
            try {
                if (this.x != null && iOAdEvent != null) {
                    HashMap<String, Object> hashMap = (HashMap) iOAdEvent.getData();
                    this.x.onLpCustomEventCallBack(hashMap, new ag(this, hashMap.get("activity")));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, str, i) == null) {
            super.b(str, i);
            NativeCPUManager.CPUAdListener cPUAdListener = this.x;
            if (cPUAdListener != null) {
                cPUAdListener.onAdError(str, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, map) == null) && map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                an.a(((Integer) obj).intValue());
                an.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                an.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                if (((Integer) obj5).intValue() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                an.a(z);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                an.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            an.b();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b_() {
        NativeCPUManager.CPUAdListener cPUAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (cPUAdListener = this.x) != null) {
            cPUAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void c_() {
        NativeCPUManager.CPUAdListener cPUAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (cPUAdListener = this.x) != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void d() {
        NativeCPUManager.CPUAdListener cPUAdListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (cPUAdListener = this.x) != null) {
            cPUAdListener.onExitLp();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            an.a(this.z);
            an.b(this.A);
            an.a(new ai(this));
        }
    }

    public Activity g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return an.c();
        }
        return (Activity) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return an.d();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.k == null) {
                this.l = false;
                return;
            }
            this.l = true;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu");
                this.k.createProdHandler(jSONObject3);
                n();
                this.k.addEventListener("Update_fbReader_Setting", new ae(this));
                this.k.addEventListener("closeInterstitialAd", new af(this));
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu");
                jSONObject.put("appsid", this.o);
                jSONObject.put("pageIndex", this.s);
                jSONObject.put("pageSize", this.r);
                jSONObject.put("channels", this.t);
                jSONObject.put("showAd", this.u);
                jSONObject.put("openActivitylink", this.C);
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("appid", this.o);
                }
                jSONObject2.put("timeout", this.v);
                if (this.w == null || this.w.isEmpty()) {
                    av.c().e("内容联盟元素需要传入 CPUAdRequest配置信息");
                }
                jSONObject2 = j.a(this.w);
                if (jSONObject2 != null) {
                    jSONObject2.put("isInitNovelSDK", this.B);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.k.loadAd(jSONObject, jSONObject2);
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.v = i;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iOAdEvent) == null) {
            notifyObservers(iOAdEvent);
            setChanged();
        }
    }

    public void a(int i, int i2, int[] iArr, boolean z, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, Boolean.valueOf(z), hashMap}) == null) {
            this.s = i;
            this.r = i2;
            this.t = iArr;
            this.u = z;
            this.w = hashMap;
            this.B = an.f();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            super.a(i, str);
            NativeCPUManager.CPUAdListener cPUAdListener = this.x;
            if (cPUAdListener != null) {
                cPUAdListener.onAdError(str, i);
            }
        }
    }

    public void a(WebView webView, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, webView, jSONObject) == null) {
            bf.a(new ah(this, jSONObject, webView));
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, iOAdEvent) == null) && this.x != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : (List) iOAdEvent.getData().get("cpuAdList")) {
                NativeCPUAdData nativeCPUAdData = new NativeCPUAdData(this.h, obj, this.w);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.x.onAdLoaded(arrayList);
        }
    }

    public void a(NativeCPUManager.CPUAdListener cPUAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cPUAdListener) == null) {
            this.x = cPUAdListener;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.C = str;
        }
    }
}

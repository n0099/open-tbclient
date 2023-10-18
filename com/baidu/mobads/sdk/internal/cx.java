package com.baidu.mobads.sdk.internal;

import android.app.Fragment;
import android.content.Context;
import android.net.http.Headers;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.CPUAdType;
import com.baidu.mobads.sdk.api.CPUDramaDetailConfig;
import com.baidu.mobads.sdk.api.CPUDramaListener;
import com.baidu.mobads.sdk.api.CPUDramaRequestParams;
import com.baidu.mobads.sdk.api.CPUDramaResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cx extends bf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CPUDramaRequestParams a;
    public CPUDramaResponse q;
    public boolean r;
    public CPUDramaListener s;

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iOAdEvent) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cx(Context context, CPUDramaRequestParams cPUDramaRequestParams, CPUDramaListener cPUDramaListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cPUDramaRequestParams, cPUDramaListener};
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
        this.a = cPUDramaRequestParams;
        this.s = cPUDramaListener;
        this.r = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cx(Context context, CPUDramaRequestParams cPUDramaRequestParams, CPUDramaResponse cPUDramaResponse, CPUDramaListener cPUDramaListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cPUDramaRequestParams, cPUDramaResponse, cPUDramaListener};
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
        this.a = cPUDramaRequestParams;
        this.q = cPUDramaResponse;
        this.s = cPUDramaListener;
        this.r = false;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, iOAdEvent) == null) && this.s != null && iOAdEvent != null && (data = iOAdEvent.getData()) != null) {
            Object obj = data.get("adType");
            if (obj instanceof String) {
                this.s.onADExposed(CPUAdType.parse((String) obj));
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void f(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iOAdEvent) == null) && this.s != null && iOAdEvent != null && (data = iOAdEvent.getData()) != null) {
            Object obj = data.get("adType");
            if (obj instanceof String) {
                this.s.onADExposureFailed(CPUAdType.parse((String) obj));
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, iOAdEvent) == null) && this.s != null && iOAdEvent != null && (data = iOAdEvent.getData()) != null) {
            Object obj = data.get("adType");
            if (obj instanceof String) {
                this.s.onAdClick(CPUAdType.parse((String) obj));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, this, iOAdEvent) == null) && this.s != null) {
            CPUDramaResponse cPUDramaResponse = null;
            if (iOAdEvent != null) {
                try {
                    Map<String, Object> data = iOAdEvent.getData();
                    cPUDramaResponse = new CPUDramaResponse().setContentId((String) data.get("contentId")).setSubVideoId((String) data.get("subVideoId")).setTitle((String) data.get("title")).setRepresent(((Integer) data.get("represent")).intValue()).setCoverImageUrl((String) data.get("coverImageUrl"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.s.onVideoCollect(cPUDramaResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, this, iOAdEvent) == null) && this.s != null) {
            CPUDramaResponse cPUDramaResponse = null;
            if (iOAdEvent != null) {
                try {
                    Map<String, Object> data = iOAdEvent.getData();
                    cPUDramaResponse = new CPUDramaResponse().setContentId((String) data.get("contentId")).setSubVideoId((String) data.get("subVideoId")).setTitle((String) data.get("title")).setRepresent(((Integer) data.get("represent")).intValue()).setCoverImageUrl((String) data.get("coverImageUrl"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.s.onVideoPlay(cPUDramaResponse);
        }
    }

    public Fragment a(com.baidu.mobads.sdk.internal.a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "getFragment");
                a(jSONObject, hashMap);
                Object obj = hashMap.get("frag");
                if (obj instanceof FragmentDelegate) {
                    FragmentDelegate fragmentDelegate = (FragmentDelegate) obj;
                    fragmentDelegate.setProxy(eVar);
                    return fragmentDelegate;
                }
                return null;
            } catch (JSONException e) {
                br.a().a(e);
                return null;
            }
        }
        return (Fragment) invokeL.objValue;
    }

    public androidx.fragment.app.Fragment b(com.baidu.mobads.sdk.internal.a.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "getSupportFragment");
                a(jSONObject, hashMap);
                Object obj = hashMap.get("frag");
                if (obj instanceof FragmentV4Delegate) {
                    FragmentV4Delegate fragmentV4Delegate = (FragmentV4Delegate) obj;
                    fragmentV4Delegate.setProxy(eVar);
                    return fragmentV4Delegate;
                }
                return null;
            } catch (JSONException e) {
                br.a().a(e);
                return null;
            }
        }
        return (androidx.fragment.app.Fragment) invokeL.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        HashMap hashMap;
        String str;
        Object remove;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.k != null && this.a != null) {
                this.l = true;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu_drama");
                    this.k.createProdHandler(jSONObject3);
                    n();
                    cy cyVar = new cy(this);
                    this.k.addEventListener("onContentLoaded", cyVar);
                    this.k.addEventListener("onContentFailed", cyVar);
                    this.k.addEventListener(w.ar, cyVar);
                    this.k.addEventListener(w.as, cyVar);
                    hashMap = new HashMap(this.a.getExtras());
                    str = (String) hashMap.remove("subChannelId");
                    remove = hashMap.remove("dramaDetailConfig");
                    str2 = (String) hashMap.remove("appsid");
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_drama");
                    jSONObject.put("subChannelId", str);
                    jSONObject.put("appid", str2);
                    jSONObject.put("isDramaListRequest", this.r);
                    if (this.q != null) {
                        jSONObject.put("dramaContentId", this.q.getDramaContentId());
                        jSONObject.put("dramaSubVideoId", this.q.getDramaSubVideoId());
                        jSONObject.put("dramaRepresent", this.q.getRepresent());
                    }
                    jSONObject2 = j.a((HashMap<String, Object>) hashMap);
                    if (remove instanceof CPUDramaDetailConfig) {
                        jSONObject2.put("freeCount", ((CPUDramaDetailConfig) remove).mFreeCount);
                        jSONObject2.put("unLockCount", ((CPUDramaDetailConfig) remove).mUnLockCount);
                    }
                    this.k.loadAd(jSONObject, jSONObject2);
                    return;
                }
                if (this.s != null) {
                    this.s.onContentFailed(-2, "短剧请求缺少sid 或 scid！");
                }
                av.c().e("短剧请求缺少sid 或 scid！");
                return;
            }
            this.l = false;
            CPUDramaListener cPUDramaListener = this.s;
            if (cPUDramaListener != null) {
                cPUDramaListener.onContentFailed(-2, "短剧请求缺少必要参数！");
            }
            av.c().e("短剧请求缺少必要参数！");
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", Headers.REFRESH);
            } catch (JSONException e) {
                br.a().a(e);
            }
            a(jSONObject, hashMap);
        }
    }
}

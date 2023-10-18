package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdEntryResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class di extends bf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e.a A;
    public BaiduNativeManager.ExpressAdListener B;
    public BaiduNativeManager.EntryAdListener C;
    public e.b D;
    public int E;
    public List<NativeResponse> a;
    public List<ExpressResponse> q;
    public List<EntryResponse> r;
    public int s;
    public boolean t;
    public String u;
    public String v;
    public int w;
    public int x;
    public RequestParameters y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public di(Context context, String str, String str2, boolean z, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = 8000;
        this.z = false;
        this.E = 0;
        this.v = str;
        this.u = str2;
        this.t = z;
        this.s = i;
        this.w = 600;
        this.x = 500;
    }

    public ViewGroup a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "initExpressContainer");
                jSONObject.put("uniqueId", aVar.H());
            } catch (JSONException e) {
                br.a().a(e);
            }
            a(jSONObject, hashMap);
            Object obj = hashMap.get("container");
            if (obj instanceof ViewGroup) {
                return (ViewGroup) obj;
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public void c(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, map) == null) {
            try {
                HashMap<String, String> a = j.a(map);
                if (this.m == null) {
                    this.m = new HashMap<>();
                }
                if (!a.isEmpty()) {
                    for (String str : a.keySet()) {
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = a.get(str);
                            if (!TextUtils.isEmpty(str2)) {
                                this.m.put(str, str2);
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void g(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, iOAdEvent) == null) && this.B != null && iOAdEvent != null && this.q != null && (data = iOAdEvent.getData()) != null) {
            String str = (String) data.get("uniqueId");
            for (int i = 0; i < this.q.size(); i++) {
                bo boVar = (bo) this.q.get(i);
                if (TextUtils.equals(boVar.a(), str)) {
                    boVar.a(boVar);
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void k(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, iOAdEvent) == null) && iOAdEvent != null && this.a != null && (data = iOAdEvent.getData()) != null) {
            String str = (String) data.get("uniqueId");
            String str2 = (String) data.get("type");
            for (int i = 0; i < this.a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i);
                if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str) && TextUtils.equals("dismiss", str2)) {
                    xAdNativeResponse.onShakeViewDismiss();
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            IAdInterListener iAdInterListener = this.k;
            if (iAdInterListener == null) {
                this.l = false;
                return;
            }
            this.l = true;
            iAdInterListener.loadAd(k(), l());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            e.a aVar = this.A;
            if (aVar != null) {
                aVar.b();
                return;
            }
            BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
            if (expressAdListener != null) {
                expressAdListener.onVideoDownloadSuccess();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            e.a aVar = this.A;
            if (aVar != null) {
                aVar.c();
                return;
            }
            BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
            if (expressAdListener != null) {
                expressAdListener.onVideoDownloadFailed();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            e.a aVar = this.A;
            if (aVar != null) {
                aVar.a();
                return;
            }
            BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
            if (expressAdListener != null) {
                expressAdListener.onLpClosed();
                return;
            }
            BaiduNativeManager.EntryAdListener entryAdListener = this.C;
            if (entryAdListener != null) {
                entryAdListener.onLpClosed();
            }
        }
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public RequestParameters g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.y;
        }
        return (RequestParameters) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.E = i;
        }
    }

    public void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, activity) == null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "bindExpressActivity");
                hashMap.put("activity", activity);
            } catch (JSONException e) {
                br.a().a(e);
            }
            a(jSONObject, hashMap);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.z = z;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            e.a aVar = this.A;
            if (aVar != null) {
                aVar.a(i, str);
            }
            BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
            if (expressAdListener != null) {
                expressAdListener.onNoAd(i, str);
            }
            BaiduNativeManager.EntryAdListener entryAdListener = this.C;
            if (entryAdListener != null) {
                entryAdListener.onNoAd(i, str);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, str, i) == null) {
            e.a aVar = this.A;
            if (aVar != null) {
                aVar.b(i, str);
            }
            BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
            if (expressAdListener != null) {
                expressAdListener.onNativeFail(i, str);
            }
            BaiduNativeManager.EntryAdListener entryAdListener = this.C;
            if (entryAdListener != null) {
                entryAdListener.onNativeFail(i, str);
            }
        }
    }

    public void a(ViewGroup viewGroup, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, viewGroup, aVar) == null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "renderExpressView");
                jSONObject.put("uniqueId", aVar.H());
                hashMap.put("container", viewGroup);
            } catch (JSONException e) {
                br.a().a(e);
            }
            a(jSONObject, hashMap);
        }
    }

    public void a(BaiduNativeManager.EntryAdListener entryAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, entryAdListener) == null) {
            this.C = entryAdListener;
        }
    }

    public void a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, expressAdListener) == null) {
            this.B = expressAdListener;
        }
    }

    public void a(RequestParameters requestParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, requestParameters) == null) {
            int width = requestParameters.getWidth();
            int height = requestParameters.getHeight();
            if (width > 0 && height > 0) {
                this.w = width;
                this.x = height;
            }
            this.y = requestParameters;
            a(requestParameters.getExtras());
            c(requestParameters.getExt());
        }
    }

    public void a(e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.A = aVar;
        }
    }

    public void a(e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.D = bVar;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            if (!TextUtils.isEmpty(str) && this.a != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i);
                    if (xAdNativeResponse.getUniqueId().equals(str)) {
                        xAdNativeResponse.onADPermissionShow(z);
                    }
                }
            }
            if (!TextUtils.isEmpty(str) && this.q != null) {
                for (int i2 = 0; i2 < this.q.size(); i2++) {
                    bo boVar = (bo) this.q.get(i2);
                    if (TextUtils.equals(str, boVar.a())) {
                        boVar.a(z);
                    }
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, str, z) == null) {
            if (!TextUtils.isEmpty(str) && this.a != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i);
                    if (xAdNativeResponse.getUniqueId().equals(str)) {
                        xAdNativeResponse.onAdDownloadWindow(z);
                    }
                }
            }
            if (!TextUtils.isEmpty(str) && this.q != null) {
                for (int i2 = 0; i2 < this.q.size(); i2++) {
                    bo boVar = (bo) this.q.get(i2);
                    if (TextUtils.equals(str, boVar.a())) {
                        boVar.b(z);
                    }
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void a(Map<String, String> map) {
        String[] strArr;
        int length;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, map) == null) && map != null && !map.isEmpty()) {
            HashMap hashMap = new HashMap(map);
            HashMap<String, String> hashMap2 = new HashMap<>();
            int i = 0;
            for (String str : ArticleInfo.PREDEFINED_KEYS) {
                if (hashMap.containsKey(str)) {
                    String str2 = (String) hashMap.remove(str);
                    if (!TextUtils.isEmpty(str2) && (length = str2.length() + i) < 150) {
                        hashMap2.put(str, str2);
                        i = length;
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                for (String str3 : hashMap.keySet()) {
                    if (!TextUtils.isEmpty(str3)) {
                        String str4 = (String) hashMap.get(str3);
                        if (!TextUtils.isEmpty(str4)) {
                            int length2 = i + str3.length() + str4.length();
                            if (length2 >= 150) {
                                break;
                            }
                            hashMap2.put("c_" + str3, str4);
                            i = length2 + 2;
                        } else {
                            continue;
                        }
                    }
                }
            }
            this.m = hashMap2;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, iOAdEvent) == null) {
            String message = iOAdEvent.getMessage();
            int i = 0;
            if (this.A != null && !TextUtils.isEmpty(message) && this.a != null) {
                while (i < this.a.size()) {
                    XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i);
                    if (xAdNativeResponse.getUniqueId().equals(message)) {
                        this.A.a(xAdNativeResponse);
                    }
                    i++;
                }
            } else if (this.B != null && !TextUtils.isEmpty(message) && this.q != null) {
                while (i < this.q.size()) {
                    bo boVar = (bo) this.q.get(i);
                    if (TextUtils.equals(message, boVar.a())) {
                        boVar.c();
                    }
                    i++;
                }
            } else if (this.C != null && !TextUtils.isEmpty(message) && this.r != null) {
                while (i < this.r.size()) {
                    XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i);
                    if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                        xAdEntryResponse.onADExposed();
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void f(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, iOAdEvent) != null) || iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        int i = 0;
        if (this.A != null && data != null && this.a != null) {
            String str = (String) data.get(bf.e);
            while (i < this.a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.A.a(xAdNativeResponse, Integer.parseInt((String) data.get(bf.f)));
                }
                i++;
            }
        } else if (this.C != null && data != null && this.r != null) {
            String str2 = (String) data.get(bf.e);
            while (i < this.r.size()) {
                XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i);
                if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                    xAdEntryResponse.onADExposureFailed(Integer.parseInt((String) data.get(bf.f)));
                }
                i++;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void h(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, iOAdEvent) == null) {
            String message = iOAdEvent.getMessage();
            int i = 0;
            if (this.A != null && !TextUtils.isEmpty(message) && this.a != null) {
                while (i < this.a.size()) {
                    XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i);
                    if (xAdNativeResponse.getUniqueId().equals(message)) {
                        this.A.b(xAdNativeResponse);
                    }
                    i++;
                }
            } else if (this.B != null && !TextUtils.isEmpty(message) && this.q != null) {
                while (i < this.q.size()) {
                    bo boVar = (bo) this.q.get(i);
                    if (TextUtils.equals(message, boVar.a())) {
                        boVar.b();
                    }
                    i++;
                }
            } else if (this.C != null && !TextUtils.isEmpty(message) && this.r != null) {
                while (i < this.r.size()) {
                    XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i);
                    if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                        xAdEntryResponse.onAdClick();
                    }
                    i++;
                }
            }
        }
    }

    public boolean a(View view2, a aVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048588, this, view2, aVar, i)) == null) {
            JSONObject jSONObject = new JSONObject();
            HashMap hashMap = new HashMap();
            try {
                jSONObject.put("msg", "switchTheme");
                hashMap.put("view", view2);
                hashMap.put("code", Integer.valueOf(i));
            } catch (JSONException e) {
                br.a().a(e);
            }
            a(jSONObject, hashMap);
            Object obj = hashMap.get("result");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void b(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, iOAdEvent) == null) && this.D != null && iOAdEvent != null && this.a != null) {
            String message = iOAdEvent.getMessage();
            for (int i = 0; i < this.a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.D.a(xAdNativeResponse);
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, iOAdEvent) == null) && this.B != null && iOAdEvent != null && this.q != null && (data = iOAdEvent.getData()) != null) {
            String str2 = (String) data.get("uniqueId");
            String str3 = (String) data.get("type");
            for (int i = 0; i < this.q.size(); i++) {
                bo boVar = (bo) this.q.get(i);
                if (TextUtils.equals(boVar.a(), str2)) {
                    if (TextUtils.equals("show", str3)) {
                        boVar.d();
                    } else if (TextUtils.equals("click", str3)) {
                        Object obj = data.get("reason");
                        if (obj instanceof String) {
                            str = (String) obj;
                        } else {
                            str = "";
                        }
                        boVar.a(str);
                    } else if (TextUtils.equals("close", str3)) {
                        boVar.e();
                    }
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            if (!TextUtils.isEmpty(str) && this.a != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i);
                    if (xAdNativeResponse.getUniqueId().equals(str)) {
                        xAdNativeResponse.onAdUnionClick();
                    }
                }
            }
            if (!TextUtils.isEmpty(str) && this.q != null) {
                for (int i2 = 0; i2 < this.q.size(); i2++) {
                    bo boVar = (bo) this.q.get(i2);
                    if (TextUtils.equals(str, boVar.a())) {
                        boVar.f();
                    }
                }
            }
            if (!TextUtils.isEmpty(str) && this.r != null) {
                for (int i3 = 0; i3 < this.r.size(); i3++) {
                    XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.r.get(i3);
                    if (TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                        xAdEntryResponse.onAdUnionClick();
                    }
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            if (!TextUtils.isEmpty(str) && this.a != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i);
                    if (xAdNativeResponse.getUniqueId().equals(str)) {
                        xAdNativeResponse.onADPrivacyClick();
                    }
                }
            }
            if (!TextUtils.isEmpty(str) && this.q != null) {
                for (int i2 = 0; i2 < this.q.size(); i2++) {
                    bo boVar = (bo) this.q.get(i2);
                    if (TextUtils.equals(str, boVar.a())) {
                        boVar.g();
                    }
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            if (!TextUtils.isEmpty(str) && this.a != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i);
                    if (xAdNativeResponse.getUniqueId().equals(str)) {
                        xAdNativeResponse.onADFunctionClick();
                    }
                }
            }
            if (!TextUtils.isEmpty(str) && this.q != null) {
                for (int i2 = 0; i2 < this.q.size(); i2++) {
                    bo boVar = (bo) this.q.get(i2);
                    if (TextUtils.equals(str, boVar.a())) {
                        boVar.h();
                    }
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, iOAdEvent) == null) && this.B != null && iOAdEvent != null && this.q != null && (data = iOAdEvent.getData()) != null) {
            String str = (String) data.get("uniqueId");
            View view2 = (View) data.get("expressView");
            int intValue = ((Integer) data.get("viewWidth")).intValue();
            int intValue2 = ((Integer) data.get("viewHeight")).intValue();
            for (int i = 0; i < this.q.size(); i++) {
                bo boVar = (bo) this.q.get(i);
                if (TextUtils.equals(boVar.a(), str)) {
                    boVar.a(view2, intValue, intValue2);
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public void j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, iOAdEvent) == null) && this.B != null && iOAdEvent != null && this.q != null && (data = iOAdEvent.getData()) != null) {
            String str = (String) data.get("uniqueId");
            View view2 = (View) data.get("expressView");
            int intValue = ((Integer) data.get("error_code")).intValue();
            String str2 = (String) data.get("error_message");
            for (int i = 0; i < this.q.size(); i++) {
                bo boVar = (bo) this.q.get(i);
                if (TextUtils.equals(boVar.a(), str)) {
                    boVar.a(view2, str2, intValue);
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.u);
                this.k.createProdHandler(jSONObject2);
                this.k.setAdContainer(this.g);
                n();
                jSONObject.put(IAdInterListener.AdReqParam.PROD, this.u);
                jSONObject.put(IAdInterListener.AdReqParam.APID, this.v);
                if (co.a().b()) {
                    jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
                } else {
                    jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
                }
                jSONObject.put("n", "1");
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("appid", this.o);
                }
                if ("video".equals(this.u)) {
                    jSONObject.put("at", "10");
                    jSONObject.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
                    jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
                } else {
                    jSONObject.put("at", "2");
                }
                jSONObject.put("w", "" + this.w);
                jSONObject.put("h", "" + this.x);
                jSONObject.put("msa", Cea708Decoder.COMMAND_RST);
                jSONObject = j.a(jSONObject, b(this.m));
                jSONObject.put("opt", this.E);
                if (this.E == 0) {
                    jSONObject.put("optn", 1);
                }
                b(jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007a, code lost:
        if (com.baidu.mobads.sdk.internal.bs.a(r16.h, r9) != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fe A[SYNTHETIC] */
    @Override // com.baidu.mobads.sdk.internal.bf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q() {
        int i;
        boolean z;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.A != null || this.B != null || this.C != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                b a = b.a(this.n);
                HashSet hashSet = new HashSet();
                int i2 = 0;
                int i3 = 0;
                while (i3 < a.a().size()) {
                    a aVar = a.a().get(i3);
                    String m = aVar.m();
                    int i4 = 3;
                    boolean z2 = true;
                    if (aVar.p() != 1) {
                        if (aVar.p() == 2) {
                            if (m != null && !m.equals("") && !m.equals(StringUtil.NULL_STRING) && !hashSet.contains(m)) {
                                hashSet.add(m);
                            } else {
                                i2 = 1;
                            }
                        } else {
                            if (aVar.p() == 512) {
                                try {
                                    jSONObject = new JSONObject(aVar.q());
                                    i = jSONObject.optInt("fb_act", i2);
                                } catch (Throwable unused) {
                                    i = 0;
                                }
                                try {
                                    z = bs.b(this.h, jSONObject.optString("page", ""));
                                } catch (Throwable unused2) {
                                    z = false;
                                    if (!z) {
                                    }
                                    i2 = 0;
                                    if (i2 == 0) {
                                    }
                                    i3++;
                                    i2 = 0;
                                }
                                if (!z) {
                                    if (i != 1 && i == 2) {
                                        if (TextUtils.isEmpty(m) || !bs.a(this.h, m)) {
                                            i2 = 0;
                                            i4 = 2;
                                        }
                                    }
                                }
                                i2 = 0;
                            }
                            i2 = 0;
                        }
                        if (i2 == 0) {
                            if (this.A != null) {
                                XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(this.h, this, aVar);
                                if (i4 != 2) {
                                    z2 = false;
                                }
                                xAdNativeResponse.setIsDownloadApp(z2);
                                xAdNativeResponse.setAdActionType(i4);
                                arrayList.add(xAdNativeResponse);
                            } else if (this.B != null) {
                                bo boVar = new bo(this.h, this, aVar);
                                boVar.a(i4);
                                arrayList2.add(boVar);
                            } else if (this.C != null) {
                                arrayList3.add(new XAdEntryResponse(this.h, this, aVar));
                            }
                        }
                        i3++;
                        i2 = 0;
                    }
                    i4 = 1;
                    if (i2 == 0) {
                    }
                    i3++;
                    i2 = 0;
                }
                e.a aVar2 = this.A;
                if (aVar2 != null) {
                    this.a = arrayList;
                    aVar2.a(arrayList);
                    return;
                }
                BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
                if (expressAdListener != null) {
                    this.q = arrayList2;
                    expressAdListener.onNativeLoad(arrayList2);
                    return;
                }
                BaiduNativeManager.EntryAdListener entryAdListener = this.C;
                if (entryAdListener != null) {
                    this.r = arrayList3;
                    entryAdListener.onNativeLoad(arrayList3);
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bf
    public JSONObject l() {
        InterceptResult invokeV;
        int aPPConfirmPolicy;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("timeout", this.s);
                jSONObject.put("isCacheVideo", this.t);
                jSONObject.put("cacheVideoOnlyWifi", this.z);
                if (this.y == null) {
                    aPPConfirmPolicy = 1;
                } else {
                    aPPConfirmPolicy = this.y.getAPPConfirmPolicy();
                }
                jSONObject.put("appConfirmPolicy", aPPConfirmPolicy);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}

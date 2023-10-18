package com.baidu.mobads.sdk.internal;

import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cv implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ cr d;

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jSONObject) == null) {
        }
    }

    public cv(cr crVar, int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {crVar, Integer.valueOf(i), Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = crVar;
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String i = this.d.i("get_cuid");
            String i2 = this.d.i("get_imei");
            String i3 = this.d.i("get_oaid");
            try {
                jSONObject.put("cuid", i);
                jSONObject.put("imei", i2);
                jSONObject.put("oaid", i3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            br brVar = this.d.i;
            brVar.a("单次阅读器打开时长 = " + j);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", this.d.f());
            hashMap.put("interstitial_container", viewGroup);
            hashMap.put("entry", Integer.valueOf(this.a));
            hashMap.put("channelId", Integer.valueOf(this.b));
            hashMap.put("novel_id", this.c);
            this.d.a(da.r, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", viewGroup.getContext());
            hashMap.put("banner_container", viewGroup);
            hashMap.put("entry", Integer.valueOf(this.a));
            hashMap.put("channelId", Integer.valueOf(this.b));
            hashMap.put("novel_id", this.c);
            this.d.a(da.v, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, viewGroup, i) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", this.d.f());
            hashMap.put("interstitial_container", viewGroup);
            hashMap.put("isnight", Boolean.valueOf(this.d.g()));
            hashMap.put("entry", Integer.valueOf(this.a));
            hashMap.put("channelId", Integer.valueOf(this.b));
            hashMap.put("novel_id", this.c);
            hashMap.put("count_down", Integer.valueOf(i));
            this.d.a(da.x, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, viewGroup, jSONObject) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", this.d.f());
            hashMap.put("banner_container", viewGroup);
            hashMap.put("isnight", Boolean.valueOf(this.d.g()));
            hashMap.put("entry", Integer.valueOf(this.a));
            hashMap.put("channelId", Integer.valueOf(this.b));
            hashMap.put("novel_id", this.c);
            hashMap.put("novel_info", jSONObject);
            this.d.a(da.t, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, viewGroup, viewGroup2, i) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", this.d.f());
            hashMap.put("banner_container", viewGroup2);
            hashMap.put("interstitial_container", viewGroup);
            hashMap.put("isnight", Boolean.valueOf(this.d.g()));
            hashMap.put("entry", Integer.valueOf(this.a));
            hashMap.put("channelId", Integer.valueOf(this.b));
            hashMap.put("novel_id", this.c);
            hashMap.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, Integer.valueOf(i));
            this.d.a(da.w, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, viewGroup, jSONObject) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", this.d.f());
            hashMap.put("interstitial_container", viewGroup);
            hashMap.put("isnight", Boolean.valueOf(this.d.g()));
            hashMap.put("entry", Integer.valueOf(this.a));
            hashMap.put("channelId", Integer.valueOf(this.b));
            hashMap.put("novel_id", this.c);
            hashMap.put("novel_info", jSONObject);
            this.d.a(da.s, hashMap);
        }
    }
}

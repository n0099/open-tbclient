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
public class ai implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ad a;

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

    public ai(ad adVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adVar;
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            br brVar = this.a.i;
            brVar.a("单次阅读器打开时长 = " + j);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String i = this.a.i("get_cuid");
            String i2 = this.a.i("get_imei");
            String i3 = this.a.i("get_oaid");
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
    public void a(ViewGroup viewGroup) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", this.a.g());
            hashMap.put("interstitial_container", viewGroup);
            hashMap.put("entry", 2);
            iArr = this.a.t;
            hashMap.put("channelId", Integer.valueOf(iArr[0]));
            this.a.a(da.r, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, int i) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, viewGroup, i) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", this.a.g());
            hashMap.put("interstitial_container", viewGroup);
            hashMap.put("isnight", Boolean.valueOf(this.a.h()));
            hashMap.put("entry", 2);
            iArr = this.a.t;
            hashMap.put("channelId", Integer.valueOf(iArr[0]));
            hashMap.put("count_down", Integer.valueOf(i));
            this.a.a(da.x, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, viewGroup, jSONObject) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", this.a.g());
            hashMap.put("banner_container", viewGroup);
            hashMap.put("isnight", Boolean.valueOf(this.a.h()));
            hashMap.put("entry", 2);
            iArr = this.a.t;
            hashMap.put("channelId", Integer.valueOf(iArr[0]));
            hashMap.put("novel_info", jSONObject);
            this.a.a(da.t, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, ViewGroup viewGroup2, int i) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, viewGroup, viewGroup2, i) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", this.a.g());
            hashMap.put("banner_container", viewGroup2);
            hashMap.put("interstitial_container", viewGroup);
            hashMap.put("isnight", Boolean.valueOf(this.a.h()));
            hashMap.put("entry", 2);
            iArr = this.a.t;
            hashMap.put("channelId", Integer.valueOf(iArr[0]));
            hashMap.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, Integer.valueOf(i));
            this.a.a(da.w, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void a(ViewGroup viewGroup, JSONObject jSONObject) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, viewGroup, jSONObject) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", this.a.g());
            hashMap.put("interstitial_container", viewGroup);
            hashMap.put("isnight", Boolean.valueOf(this.a.h()));
            hashMap.put("entry", 2);
            iArr = this.a.t;
            hashMap.put("channelId", Integer.valueOf(iArr[0]));
            hashMap.put("novel_info", jSONObject);
            this.a.a(da.s, hashMap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.t
    public void b(ViewGroup viewGroup) {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", viewGroup.getContext());
            hashMap.put("banner_container", viewGroup);
            hashMap.put("entry", 2);
            iArr = this.a.t;
            hashMap.put("channelId", Integer.valueOf(iArr[0]));
            this.a.a(da.v, hashMap);
        }
    }
}

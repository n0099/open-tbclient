package c.a.s0.j3.i0.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f18404b;

    /* renamed from: c  reason: collision with root package name */
    public String f18405c;

    /* renamed from: d  reason: collision with root package name */
    public String f18406d;

    /* renamed from: e  reason: collision with root package name */
    public String f18407e;

    /* renamed from: f  reason: collision with root package name */
    public String f18408f;

    /* renamed from: g  reason: collision with root package name */
    public String f18409g;

    /* renamed from: h  reason: collision with root package name */
    public int f18410h;

    /* renamed from: i  reason: collision with root package name */
    public String f18411i;

    /* renamed from: j  reason: collision with root package name */
    public String f18412j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f18413k;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18413k = false;
    }

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, adCard) == null) || advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.s4;
        if (i2 == 3) {
            this.a = "apk_download";
            this.f18408f = advertAppInfo.v4;
            this.f18409g = advertAppInfo.u4;
        } else if (i2 == 1) {
            this.a = "jump";
        }
        this.f18407e = adCard.getButtonText();
        this.f18404b = adCard.userName;
        this.f18405c = adCard.userImage;
        this.f18406d = adCard.scheme;
        this.f18411i = adCard.threadTitle;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("style");
        this.f18404b = jSONObject.optString("user_name");
        this.f18405c = jSONObject.optString("user_portrait");
        this.f18406d = jSONObject.optString("scheme");
        this.f18407e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f18410h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f18408f = optJSONObject.optString("pkgname");
            this.f18409g = optJSONObject.optString("download_url");
        }
        jSONObject.optString("content");
        this.f18413k = true;
        this.f18412j = jSONObject.optString("cmd_scheme");
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b(new JSONObject(str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style", this.a);
                jSONObject.put("user_name", this.f18404b);
                jSONObject.put("user_portrait", this.f18405c);
                jSONObject.put("scheme", this.f18406d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f18407e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f18408f);
                jSONObject2.put("download_url", this.f18409g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f18410h);
                jSONObject.put("cmd_scheme", this.f18412j);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style", this.a);
                jSONObject.put("user_name", this.f18404b);
                jSONObject.put("user_portrait", this.f18405c);
                jSONObject.put("scheme", this.f18406d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f18407e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f18408f);
                jSONObject2.put("download_url", this.f18409g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f18410h);
                jSONObject.put("cmd_scheme", this.f18412j);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}

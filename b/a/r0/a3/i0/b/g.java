package b.a.r0.a3.i0.b;

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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15752a;

    /* renamed from: b  reason: collision with root package name */
    public String f15753b;

    /* renamed from: c  reason: collision with root package name */
    public String f15754c;

    /* renamed from: d  reason: collision with root package name */
    public String f15755d;

    /* renamed from: e  reason: collision with root package name */
    public String f15756e;

    /* renamed from: f  reason: collision with root package name */
    public String f15757f;

    /* renamed from: g  reason: collision with root package name */
    public String f15758g;

    /* renamed from: h  reason: collision with root package name */
    public int f15759h;

    /* renamed from: i  reason: collision with root package name */
    public String f15760i;
    public boolean j;

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
        this.j = false;
    }

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, adCard) == null) || advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.n4;
        if (i2 == 3) {
            this.f15752a = "apk_download";
            this.f15757f = advertAppInfo.q4;
            this.f15758g = advertAppInfo.p4;
        } else if (i2 == 1) {
            this.f15752a = "jump";
        }
        this.f15756e = adCard.getButtonText();
        this.f15753b = adCard.userName;
        this.f15754c = adCard.userImage;
        this.f15755d = adCard.scheme;
        this.f15760i = adCard.threadTitle;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f15752a = jSONObject.optString("style");
        this.f15753b = jSONObject.optString("user_name");
        this.f15754c = jSONObject.optString("user_portrait");
        this.f15755d = jSONObject.optString("scheme");
        this.f15756e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f15759h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f15757f = optJSONObject.optString("pkgname");
            this.f15758g = optJSONObject.optString("download_url");
        }
        jSONObject.optString("content");
        this.j = true;
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
                jSONObject.put("style", this.f15752a);
                jSONObject.put("user_name", this.f15753b);
                jSONObject.put("user_portrait", this.f15754c);
                jSONObject.put("scheme", this.f15755d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f15756e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f15757f);
                jSONObject2.put("download_url", this.f15758g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f15759h);
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
                jSONObject.put("style", this.f15752a);
                jSONObject.put("user_name", this.f15753b);
                jSONObject.put("user_portrait", this.f15754c);
                jSONObject.put("scheme", this.f15755d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f15756e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f15757f);
                jSONObject2.put("download_url", this.f15758g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f15759h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}

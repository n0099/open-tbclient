package c.a.r0.z2.i0.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
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
    public String f29704a;

    /* renamed from: b  reason: collision with root package name */
    public String f29705b;

    /* renamed from: c  reason: collision with root package name */
    public String f29706c;

    /* renamed from: d  reason: collision with root package name */
    public String f29707d;

    /* renamed from: e  reason: collision with root package name */
    public String f29708e;

    /* renamed from: f  reason: collision with root package name */
    public String f29709f;

    /* renamed from: g  reason: collision with root package name */
    public String f29710g;

    /* renamed from: h  reason: collision with root package name */
    public int f29711h;

    /* renamed from: i  reason: collision with root package name */
    public String f29712i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29713j;

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
        this.f29713j = false;
    }

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, adCard) == null) || advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.m4;
        if (i2 == 3) {
            this.f29704a = "apk_download";
            this.f29709f = advertAppInfo.p4;
            this.f29710g = advertAppInfo.o4;
        } else if (i2 == 1) {
            this.f29704a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f29708e = adCard.getButtonText();
        this.f29705b = adCard.userName;
        this.f29706c = adCard.userImage;
        this.f29707d = adCard.scheme;
        this.f29712i = adCard.threadTitle;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f29704a = jSONObject.optString("style");
        this.f29705b = jSONObject.optString("user_name");
        this.f29706c = jSONObject.optString("user_portrait");
        this.f29707d = jSONObject.optString("scheme");
        this.f29708e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f29711h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f29709f = optJSONObject.optString("pkgname");
            this.f29710g = optJSONObject.optString("download_url");
        }
        jSONObject.optString("content");
        this.f29713j = true;
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
                jSONObject.put("style", this.f29704a);
                jSONObject.put("user_name", this.f29705b);
                jSONObject.put("user_portrait", this.f29706c);
                jSONObject.put("scheme", this.f29707d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f29708e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f29709f);
                jSONObject2.put("download_url", this.f29710g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f29711h);
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
                jSONObject.put("style", this.f29704a);
                jSONObject.put("user_name", this.f29705b);
                jSONObject.put("user_portrait", this.f29706c);
                jSONObject.put("scheme", this.f29707d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f29708e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f29709f);
                jSONObject2.put("download_url", this.f29710g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f29711h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}

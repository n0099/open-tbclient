package c.a.t0.j3.i0.b;

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
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f18878b;

    /* renamed from: c  reason: collision with root package name */
    public String f18879c;

    /* renamed from: d  reason: collision with root package name */
    public String f18880d;

    /* renamed from: e  reason: collision with root package name */
    public String f18881e;

    /* renamed from: f  reason: collision with root package name */
    public String f18882f;

    /* renamed from: g  reason: collision with root package name */
    public String f18883g;

    /* renamed from: h  reason: collision with root package name */
    public int f18884h;

    /* renamed from: i  reason: collision with root package name */
    public String f18885i;

    /* renamed from: j  reason: collision with root package name */
    public String f18886j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f18887k;

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
        this.f18887k = false;
    }

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, adCard) == null) || advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.u4;
        if (i2 == 3) {
            this.a = "apk_download";
            this.f18882f = advertAppInfo.x4;
            this.f18883g = advertAppInfo.w4;
        } else if (i2 == 1) {
            this.a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f18881e = adCard.getButtonText();
        this.f18878b = adCard.userName;
        this.f18879c = adCard.userImage;
        this.f18880d = adCard.scheme;
        this.f18885i = adCard.threadTitle;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("style");
        this.f18878b = jSONObject.optString("user_name");
        this.f18879c = jSONObject.optString("user_portrait");
        this.f18880d = jSONObject.optString("scheme");
        this.f18881e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f18884h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f18882f = optJSONObject.optString("pkgname");
            this.f18883g = optJSONObject.optString("download_url");
        }
        jSONObject.optString("content");
        this.f18887k = true;
        this.f18886j = jSONObject.optString("cmd_scheme");
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
                jSONObject.put("user_name", this.f18878b);
                jSONObject.put("user_portrait", this.f18879c);
                jSONObject.put("scheme", this.f18880d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f18881e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f18882f);
                jSONObject2.put("download_url", this.f18883g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f18884h);
                jSONObject.put("cmd_scheme", this.f18886j);
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
                jSONObject.put("user_name", this.f18878b);
                jSONObject.put("user_portrait", this.f18879c);
                jSONObject.put("scheme", this.f18880d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f18881e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f18882f);
                jSONObject2.put("download_url", this.f18883g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f18884h);
                jSONObject.put("cmd_scheme", this.f18886j);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}

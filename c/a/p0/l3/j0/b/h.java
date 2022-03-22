package c.a.p0.l3.j0.b;

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
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f16242b;

    /* renamed from: c  reason: collision with root package name */
    public String f16243c;

    /* renamed from: d  reason: collision with root package name */
    public String f16244d;

    /* renamed from: e  reason: collision with root package name */
    public String f16245e;

    /* renamed from: f  reason: collision with root package name */
    public String f16246f;

    /* renamed from: g  reason: collision with root package name */
    public String f16247g;

    /* renamed from: h  reason: collision with root package name */
    public int f16248h;
    public String i;
    public String j;
    public boolean k;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
    }

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, adCard) == null) || advertAppInfo == null) {
            return;
        }
        int i = advertAppInfo.p;
        if (i == 3) {
            this.a = "apk_download";
            this.f16246f = advertAppInfo.s;
            this.f16247g = advertAppInfo.r;
        } else if (i == 1) {
            this.a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f16245e = adCard.getButtonText();
        this.f16242b = adCard.userName;
        this.f16243c = adCard.userImage;
        this.f16244d = adCard.scheme;
        this.i = adCard.threadTitle;
        this.j = adCard.getButtonCmdScheme();
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("style");
        this.f16242b = jSONObject.optString("user_name");
        this.f16243c = jSONObject.optString("user_portrait");
        this.f16244d = jSONObject.optString("scheme");
        this.f16245e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f16248h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f16246f = optJSONObject.optString("pkgname");
            this.f16247g = optJSONObject.optString("download_url");
        }
        jSONObject.optString("content");
        this.k = true;
        this.j = jSONObject.optString("button_scheme");
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
                jSONObject.put("user_name", this.f16242b);
                jSONObject.put("user_portrait", this.f16243c);
                jSONObject.put("scheme", this.f16244d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f16245e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f16246f);
                jSONObject2.put("download_url", this.f16247g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f16248h);
                jSONObject.put("button_scheme", this.j);
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
                jSONObject.put("user_name", this.f16242b);
                jSONObject.put("user_portrait", this.f16243c);
                jSONObject.put("scheme", this.f16244d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f16245e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f16246f);
                jSONObject2.put("download_url", this.f16247g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f16248h);
                jSONObject.put("button_scheme", this.j);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}

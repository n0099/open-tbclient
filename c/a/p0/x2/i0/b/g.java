package c.a.p0.x2.i0.b;

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
    public String f28552a;

    /* renamed from: b  reason: collision with root package name */
    public String f28553b;

    /* renamed from: c  reason: collision with root package name */
    public String f28554c;

    /* renamed from: d  reason: collision with root package name */
    public String f28555d;

    /* renamed from: e  reason: collision with root package name */
    public String f28556e;

    /* renamed from: f  reason: collision with root package name */
    public String f28557f;

    /* renamed from: g  reason: collision with root package name */
    public String f28558g;

    /* renamed from: h  reason: collision with root package name */
    public int f28559h;

    /* renamed from: i  reason: collision with root package name */
    public String f28560i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f28561j;

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
        this.f28561j = false;
    }

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, adCard) == null) || advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.i4;
        if (i2 == 3) {
            this.f28552a = "apk_download";
            this.f28557f = advertAppInfo.l4;
            this.f28558g = advertAppInfo.k4;
        } else if (i2 == 1) {
            this.f28552a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f28556e = adCard.getButtonText();
        this.f28553b = adCard.userName;
        this.f28554c = adCard.userImage;
        this.f28555d = adCard.scheme;
        this.f28560i = adCard.threadTitle;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f28552a = jSONObject.optString("style");
        this.f28553b = jSONObject.optString("user_name");
        this.f28554c = jSONObject.optString("user_portrait");
        this.f28555d = jSONObject.optString("scheme");
        this.f28556e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f28559h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f28557f = optJSONObject.optString("pkgname");
            this.f28558g = optJSONObject.optString("download_url");
        }
        jSONObject.optString("content");
        this.f28561j = true;
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
                jSONObject.put("style", this.f28552a);
                jSONObject.put("user_name", this.f28553b);
                jSONObject.put("user_portrait", this.f28554c);
                jSONObject.put("scheme", this.f28555d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f28556e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f28557f);
                jSONObject2.put("download_url", this.f28558g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f28559h);
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
                jSONObject.put("style", this.f28552a);
                jSONObject.put("user_name", this.f28553b);
                jSONObject.put("user_portrait", this.f28554c);
                jSONObject.put("scheme", this.f28555d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f28556e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f28557f);
                jSONObject2.put("download_url", this.f28558g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f28559h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}

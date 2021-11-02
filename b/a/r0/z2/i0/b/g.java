package b.a.r0.z2.i0.b;

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
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f28117a;

    /* renamed from: b  reason: collision with root package name */
    public String f28118b;

    /* renamed from: c  reason: collision with root package name */
    public String f28119c;

    /* renamed from: d  reason: collision with root package name */
    public String f28120d;

    /* renamed from: e  reason: collision with root package name */
    public String f28121e;

    /* renamed from: f  reason: collision with root package name */
    public String f28122f;

    /* renamed from: g  reason: collision with root package name */
    public String f28123g;

    /* renamed from: h  reason: collision with root package name */
    public int f28124h;

    /* renamed from: i  reason: collision with root package name */
    public String f28125i;
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
        int i2 = advertAppInfo.m4;
        if (i2 == 3) {
            this.f28117a = "apk_download";
            this.f28122f = advertAppInfo.p4;
            this.f28123g = advertAppInfo.o4;
        } else if (i2 == 1) {
            this.f28117a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f28121e = adCard.getButtonText();
        this.f28118b = adCard.userName;
        this.f28119c = adCard.userImage;
        this.f28120d = adCard.scheme;
        this.f28125i = adCard.threadTitle;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f28117a = jSONObject.optString("style");
        this.f28118b = jSONObject.optString("user_name");
        this.f28119c = jSONObject.optString("user_portrait");
        this.f28120d = jSONObject.optString("scheme");
        this.f28121e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f28124h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f28122f = optJSONObject.optString("pkgname");
            this.f28123g = optJSONObject.optString("download_url");
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
                jSONObject.put("style", this.f28117a);
                jSONObject.put("user_name", this.f28118b);
                jSONObject.put("user_portrait", this.f28119c);
                jSONObject.put("scheme", this.f28120d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f28121e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f28122f);
                jSONObject2.put("download_url", this.f28123g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f28124h);
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
                jSONObject.put("style", this.f28117a);
                jSONObject.put("user_name", this.f28118b);
                jSONObject.put("user_portrait", this.f28119c);
                jSONObject.put("scheme", this.f28120d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f28121e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f28122f);
                jSONObject2.put("download_url", this.f28123g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f28124h);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}

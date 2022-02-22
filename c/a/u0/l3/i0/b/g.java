package c.a.u0.l3.i0.b;

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
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f19319b;

    /* renamed from: c  reason: collision with root package name */
    public String f19320c;

    /* renamed from: d  reason: collision with root package name */
    public String f19321d;

    /* renamed from: e  reason: collision with root package name */
    public String f19322e;

    /* renamed from: f  reason: collision with root package name */
    public String f19323f;

    /* renamed from: g  reason: collision with root package name */
    public String f19324g;

    /* renamed from: h  reason: collision with root package name */
    public int f19325h;

    /* renamed from: i  reason: collision with root package name */
    public String f19326i;

    /* renamed from: j  reason: collision with root package name */
    public String f19327j;
    public boolean k;

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
        this.k = false;
    }

    public void a(AdvertAppInfo advertAppInfo, @NonNull AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, adCard) == null) || advertAppInfo == null) {
            return;
        }
        int i2 = advertAppInfo.v4;
        if (i2 == 3) {
            this.a = "apk_download";
            this.f19323f = advertAppInfo.y4;
            this.f19324g = advertAppInfo.x4;
        } else if (i2 == 1) {
            this.a = TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT;
        }
        this.f19322e = adCard.getButtonText();
        this.f19319b = adCard.userName;
        this.f19320c = adCard.userImage;
        this.f19321d = adCard.scheme;
        this.f19326i = adCard.threadTitle;
        this.f19327j = adCard.getButtonCmdScheme();
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("style");
        this.f19319b = jSONObject.optString("user_name");
        this.f19320c = jSONObject.optString("user_portrait");
        this.f19321d = jSONObject.optString("scheme");
        this.f19322e = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
        this.f19325h = jSONObject.optInt("close_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext_data");
        if (optJSONObject != null) {
            this.f19323f = optJSONObject.optString("pkgname");
            this.f19324g = optJSONObject.optString("download_url");
        }
        jSONObject.optString("content");
        this.k = true;
        this.f19327j = jSONObject.optString("button_scheme");
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
                jSONObject.put("user_name", this.f19319b);
                jSONObject.put("user_portrait", this.f19320c);
                jSONObject.put("scheme", this.f19321d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f19322e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f19323f);
                jSONObject2.put("download_url", this.f19324g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f19325h);
                jSONObject.put("button_scheme", this.f19327j);
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
                jSONObject.put("user_name", this.f19319b);
                jSONObject.put("user_portrait", this.f19320c);
                jSONObject.put("scheme", this.f19321d);
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, this.f19322e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pkgname", this.f19323f);
                jSONObject2.put("download_url", this.f19324g);
                jSONObject.put("ext_data", jSONObject2);
                jSONObject.put("content", this.f19325h);
                jSONObject.put("button_scheme", this.f19327j);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}

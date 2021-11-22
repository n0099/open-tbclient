package b.a.q0.s.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import org.json.JSONObject;
import tbclient.FrsPage.TopCode;
/* loaded from: classes4.dex */
public class f2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14089a;

    /* renamed from: b  reason: collision with root package name */
    public String f14090b;

    /* renamed from: c  reason: collision with root package name */
    public String f14091c;

    /* renamed from: d  reason: collision with root package name */
    public int f14092d;

    /* renamed from: e  reason: collision with root package name */
    public String f14093e;

    /* renamed from: f  reason: collision with root package name */
    public long f14094f;

    /* renamed from: g  reason: collision with root package name */
    public String f14095g;

    /* renamed from: h  reason: collision with root package name */
    public String f14096h;

    public f2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14095g : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14091c : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14092d : invokeV.intValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14094f : invokeV.longValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14089a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14096h : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14090b : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14093e : (String) invokeV.objValue;
    }

    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f14089a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optString("game_link");
            this.f14090b = jSONObject.optString("summary");
            this.f14091c = jSONObject.optString("code_link");
            this.f14092d = jSONObject.optInt("get_type", 1);
            this.f14093e = jSONObject.optString("surplusgift");
            this.f14094f = jSONObject.optLong("giftworth", 0L);
            this.f14095g = jSONObject.optString("type_text");
            this.f14096h = jSONObject.optString(SubtitleLog.TAG);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(TopCode topCode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, topCode) == null) || topCode == null) {
            return;
        }
        this.f14089a = topCode.img_url;
        String str = topCode.game_link;
        this.f14090b = topCode.summary;
        this.f14091c = topCode.code_link;
        this.f14092d = topCode.get_type.intValue();
        this.f14093e = topCode.surplusgift;
        if (topCode.giftworth.longValue() < 0) {
            this.f14094f = 0L;
        } else {
            this.f14094f = topCode.giftworth.longValue();
        }
        this.f14095g = topCode.type_text;
        this.f14096h = topCode.subtitle;
    }
}

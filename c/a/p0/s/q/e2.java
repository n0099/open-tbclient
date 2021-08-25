package c.a.p0.s.q;

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
/* loaded from: classes3.dex */
public class e2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f14210a;

    /* renamed from: b  reason: collision with root package name */
    public String f14211b;

    /* renamed from: c  reason: collision with root package name */
    public String f14212c;

    /* renamed from: d  reason: collision with root package name */
    public int f14213d;

    /* renamed from: e  reason: collision with root package name */
    public String f14214e;

    /* renamed from: f  reason: collision with root package name */
    public long f14215f;

    /* renamed from: g  reason: collision with root package name */
    public String f14216g;

    /* renamed from: h  reason: collision with root package name */
    public String f14217h;

    public e2() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14216g : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14212c : (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14213d : invokeV.intValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f14215f : invokeV.longValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14210a : (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f14217h : (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14211b : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f14214e : (String) invokeV.objValue;
    }

    public void i(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.f14210a = jSONObject.optString(BigdayActivityConfig.IMG_URL);
            jSONObject.optString("game_link");
            this.f14211b = jSONObject.optString("summary");
            this.f14212c = jSONObject.optString("code_link");
            this.f14213d = jSONObject.optInt("get_type", 1);
            this.f14214e = jSONObject.optString("surplusgift");
            this.f14215f = jSONObject.optLong("giftworth", 0L);
            this.f14216g = jSONObject.optString("type_text");
            this.f14217h = jSONObject.optString(SubtitleLog.TAG);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(TopCode topCode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, topCode) == null) || topCode == null) {
            return;
        }
        this.f14210a = topCode.img_url;
        String str = topCode.game_link;
        this.f14211b = topCode.summary;
        this.f14212c = topCode.code_link;
        this.f14213d = topCode.get_type.intValue();
        this.f14214e = topCode.surplusgift;
        if (topCode.giftworth.longValue() < 0) {
            this.f14215f = 0L;
        } else {
            this.f14215f = topCode.giftworth.longValue();
        }
        this.f14216g = topCode.type_text;
        this.f14217h = topCode.subtitle;
    }
}

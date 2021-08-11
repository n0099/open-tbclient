package c.a.o0.t.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.homepage.tabfeed.h5.TabWebFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f14455a;

    /* renamed from: b  reason: collision with root package name */
    public String f14456b;

    /* renamed from: c  reason: collision with root package name */
    public String f14457c;

    /* renamed from: d  reason: collision with root package name */
    public String f14458d;

    /* renamed from: e  reason: collision with root package name */
    public String f14459e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14460f;

    public y() {
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

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TextUtils.isEmpty(this.f14456b) || this.f14455a <= 0 : invokeV.booleanValue;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null || jSONObject == null) {
            return;
        }
        this.f14455a = jSONObject.optInt("tab_type");
        this.f14456b = jSONObject.optString("tab_name");
        this.f14457c = jSONObject.optString("tab_code");
        this.f14458d = jSONObject.optString(TabWebFragment.TAB_URL);
        this.f14459e = jSONObject.optString("tab_version");
    }
}

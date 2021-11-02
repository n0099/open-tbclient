package b.a.q0.t.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.homepage.tabfeed.h5.TabWebFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f13735a;

    /* renamed from: b  reason: collision with root package name */
    public String f13736b;

    /* renamed from: c  reason: collision with root package name */
    public String f13737c;

    /* renamed from: d  reason: collision with root package name */
    public String f13738d;

    /* renamed from: e  reason: collision with root package name */
    public String f13739e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13740f;

    public a0() {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TextUtils.isEmpty(this.f13736b) || this.f13735a <= 0 : invokeV.booleanValue;
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null || jSONObject == null) {
            return;
        }
        this.f13735a = jSONObject.optInt("tab_type");
        this.f13736b = jSONObject.optString("tab_name");
        this.f13737c = jSONObject.optString("tab_code");
        this.f13738d = jSONObject.optString(TabWebFragment.TAB_URL);
        this.f13739e = jSONObject.optString("tab_version");
    }
}

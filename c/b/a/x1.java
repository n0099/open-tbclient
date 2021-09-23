package c.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import io.reactivex.annotations.SchedulerSupport;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class x1 extends s1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f31470e;

    /* renamed from: f  reason: collision with root package name */
    public final y1 f31471f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(Context context, y1 y1Var) {
        super(false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, y1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31470e = context;
        this.f31471f = y1Var;
    }

    @Override // c.b.a.s1
    public boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 336);
            jSONObject.put(HttpConstants.SDK_VERSION_NAME, "3.8.0-rc.2-embed");
            jSONObject.put("channel", this.f31471f.L());
            z1.g(jSONObject, "aid", this.f31471f.K());
            z1.g(jSONObject, "release_build", this.f31471f.b0());
            z1.g(jSONObject, "app_region", this.f31471f.O());
            z1.g(jSONObject, "app_language", this.f31471f.N());
            z1.g(jSONObject, com.alipay.sdk.cons.b.f35968b, this.f31471f.a());
            z1.g(jSONObject, "ab_sdk_version", this.f31471f.Q());
            z1.g(jSONObject, "ab_version", this.f31471f.U());
            z1.g(jSONObject, "aliyun_uuid", this.f31471f.q());
            String M = this.f31471f.M();
            if (TextUtils.isEmpty(M)) {
                M = c0.a(this.f31470e, this.f31471f);
            }
            if (!TextUtils.isEmpty(M)) {
                z1.g(jSONObject, "google_aid", M);
            }
            String a0 = this.f31471f.a0();
            if (!TextUtils.isEmpty(a0)) {
                try {
                    jSONObject.put("app_track", new JSONObject(a0));
                } catch (Throwable th) {
                    h0.b(th);
                }
            }
            String P = this.f31471f.P();
            if (P != null && P.length() > 0) {
                jSONObject.put(SchedulerSupport.CUSTOM, new JSONObject(P));
            }
            z1.g(jSONObject, "user_unique_id", this.f31471f.R());
            return true;
        }
        return invokeL.booleanValue;
    }
}

package c.a.s0.a.y0.k.e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class t extends c.a.s0.a.y0.a<c.a.s0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f9914b;

    /* renamed from: c  reason: collision with root package name */
    public int f9915c;

    public t() {
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
        this.f9914b = 1;
        this.f9915c = 3;
    }

    @Override // c.a.s0.a.y0.a
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setZeusVideoExt" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.a.y0.a
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull c.a.s0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, aVar) == null) {
            Object obj = command.obj;
            if (!(obj instanceof String)) {
                if (c.a.s0.a.y0.a.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("setZeusVideoExt with a illegal obj ");
                    sb.append(obj == null);
                    throw new RuntimeException(sb.toString());
                }
                return;
            }
            d(aVar, command.what, "setZeusVideoExt:" + obj, false);
            try {
                JSONObject jSONObject = new JSONObject((String) obj);
                if (jSONObject.has("instance-error")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("instance-error", jSONObject.optString("instance-error"));
                    aVar.T(hashMap);
                }
                String optString = jSONObject.optString("firstPlayStatus");
                if (!TextUtils.isEmpty(optString)) {
                    aVar.b0(optString);
                }
                this.f9914b = jSONObject.optInt("min-cache", this.f9914b);
                int optInt = jSONObject.optInt("max-cache", this.f9915c);
                this.f9915c = optInt;
                if (this.f9914b <= optInt) {
                    if (jSONObject.has("min-cache")) {
                        aVar.G(this.f9914b);
                    }
                    if (jSONObject.has("max-cache")) {
                        aVar.g0(this.f9915c);
                    }
                } else if (c.a.s0.a.y0.a.a) {
                    String str = "setZeusVideoExt: minCache " + this.f9914b + " > maxCache " + this.f9915c;
                }
            } catch (Exception e2) {
                if (c.a.s0.a.y0.a.a) {
                    throw new RuntimeException("setZeusVideoExt with a illegal str", e2);
                }
            }
        }
    }
}

package c.a.c0.a0.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.c0.h.h;
import c.a.c0.u.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f1727b;

    public c() {
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
        this.f1727b = null;
    }

    public final void d(StringBuilder sb, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, sb, str, str2) == null) {
            if (sb.length() > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            sb.append(com.alipay.sdk.encrypt.a.f30893h);
            sb.append(str2);
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h d2 = c.a.c0.h.a.d();
            StringBuilder sb = new StringBuilder();
            d(sb, "productId", d2.l());
            d(sb, HttpRequest.CLIENT_TYPE, "2");
            d(sb, AdUploadHttpRequest.KEY_OS_TYPE, "2");
            d(sb, AdUploadHttpRequest.KEY_OS_VERSION, d2.c());
            d(sb, "_client_version", d2.q());
            d(sb, "_sdk_version", "4.4.3.3");
            d(sb, "model", d2.j());
            d(sb, "cuid", d2.b());
            d(sb, "net_type", String.valueOf(new n().c()));
            if (c.a.c0.a.a) {
                d(sb, "rd", d2.r());
                d(sb, "qa", d2.s());
                d(sb, "story_id", d2.n());
            }
            String sb2 = sb.toString();
            this.f1727b = sb2;
            return !TextUtils.isEmpty(sb2);
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.c0.a0.c.d
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.f1727b)) {
                return e();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.c0.a0.c.a, c.a.c0.a0.c.d
    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.f1727b)) {
                e();
            }
            if (this.a.toString().contains(this.f1727b)) {
                return this.a.toString();
            }
            if (this.a.length() > 0) {
                this.a.append(Typography.amp);
            }
            this.a.append(this.f1727b);
            return this.a.toString();
        }
        return (String) invokeV.objValue;
    }
}

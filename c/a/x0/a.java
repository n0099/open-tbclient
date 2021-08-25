package c.a.x0;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f31078a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31079b;

    /* renamed from: c  reason: collision with root package name */
    public String f31080c;

    /* renamed from: d  reason: collision with root package name */
    public String f31081d;

    /* renamed from: e  reason: collision with root package name */
    public String f31082e;

    /* renamed from: f  reason: collision with root package name */
    public int f31083f;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31078a = z;
        this.f31079b = z2;
        this.f31080c = str;
        this.f31081d = str2;
        this.f31082e = str3;
        this.f31083f = i2;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f31080c)) {
                return this.f31080c;
            }
            return new c.a.x0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f31080c.getBytes());
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "UnionIDInfo{isTrackLimited=" + this.f31078a + ", isSupport=" + this.f31079b + ", OAID='" + this.f31080c + ExtendedMessageFormat.QUOTE + ", EncodedOAID='" + a() + ExtendedMessageFormat.QUOTE + ", AAID='" + this.f31081d + ExtendedMessageFormat.QUOTE + ", VAID='" + this.f31082e + ExtendedMessageFormat.QUOTE + ", StatusCode='" + this.f31083f + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}

package c.a.y0;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27215b;

    /* renamed from: c  reason: collision with root package name */
    public String f27216c;

    /* renamed from: d  reason: collision with root package name */
    public String f27217d;

    /* renamed from: e  reason: collision with root package name */
    public String f27218e;

    /* renamed from: f  reason: collision with root package name */
    public int f27219f;

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
        this.a = z;
        this.f27215b = z2;
        this.f27216c = str;
        this.f27217d = str2;
        this.f27218e = str3;
        this.f27219f = i2;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f27216c)) {
                return this.f27216c;
            }
            return new c.a.y0.e.h.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f27216c.getBytes());
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "UnionIDInfo{isTrackLimited=" + this.a + ", isSupport=" + this.f27215b + ", OAID='" + this.f27216c + ExtendedMessageFormat.QUOTE + ", EncodedOAID='" + a() + ExtendedMessageFormat.QUOTE + ", AAID='" + this.f27217d + ExtendedMessageFormat.QUOTE + ", VAID='" + this.f27218e + ExtendedMessageFormat.QUOTE + ", StatusCode='" + this.f27219f + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}

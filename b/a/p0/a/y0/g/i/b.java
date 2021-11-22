package b.a.p0.a.y0.g.i;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f9362a;

    /* renamed from: b  reason: collision with root package name */
    public long f9363b;

    /* renamed from: c  reason: collision with root package name */
    public String f9364c;

    /* renamed from: d  reason: collision with root package name */
    public String f9365d;

    /* renamed from: e  reason: collision with root package name */
    public String f9366e;

    public b(String str, long j, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9362a = str;
        this.f9363b = j;
        this.f9364c = str2;
        this.f9365d = str3;
        this.f9366e = str4;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f9362a) || TextUtils.isEmpty(this.f9364c) || TextUtils.isEmpty(this.f9365d) || TextUtils.isEmpty(this.f9366e) || !b.a.p0.a.y0.g.g.a.a(this.f9363b)) ? false : true : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "roomName=" + this.f9362a + ";localUserId=" + this.f9363b + ";displayName=" + this.f9364c + ";rtcAppId=" + this.f9365d + ";token=" + this.f9366e;
        }
        return (String) invokeV.objValue;
    }
}

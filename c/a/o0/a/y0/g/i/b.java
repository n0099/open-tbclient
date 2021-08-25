package c.a.o0.a.y0.g.i;

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
    public String f9745a;

    /* renamed from: b  reason: collision with root package name */
    public long f9746b;

    /* renamed from: c  reason: collision with root package name */
    public String f9747c;

    /* renamed from: d  reason: collision with root package name */
    public String f9748d;

    /* renamed from: e  reason: collision with root package name */
    public String f9749e;

    public b(String str, long j2, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j2), str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9745a = str;
        this.f9746b = j2;
        this.f9747c = str2;
        this.f9748d = str3;
        this.f9749e = str4;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.f9745a) || TextUtils.isEmpty(this.f9747c) || TextUtils.isEmpty(this.f9748d) || TextUtils.isEmpty(this.f9749e) || !c.a.o0.a.y0.g.g.a.a(this.f9746b)) ? false : true : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "roomName=" + this.f9745a + ";localUserId=" + this.f9746b + ";displayName=" + this.f9747c + ";rtcAppId=" + this.f9748d + ";token=" + this.f9749e;
        }
        return (String) invokeV.objValue;
    }
}

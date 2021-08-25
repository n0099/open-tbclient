package c.a.w.e.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f30438a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30439b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f30440c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30441d;

    public a(String packageName, int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {packageName, Integer.valueOf(i2), Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.f30438a = packageName;
        this.f30439b = i2;
        this.f30440c = z;
        this.f30441d = str;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30439b : invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.areEqual(this.f30438a, aVar.f30438a) && this.f30439b == aVar.f30439b && this.f30440c == aVar.f30440c && Intrinsics.areEqual(this.f30441d, aVar.f30441d);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String str = this.f30438a;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.f30439b) * 31;
            boolean z = this.f30440c;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            int i3 = (hashCode + i2) * 31;
            String str2 = this.f30441d;
            return i3 + (str2 != null ? str2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "YYPluginBundleInfo { packageName=" + this.f30438a + " versionCode=" + this.f30439b + " needUpdate=" + this.f30440c + " ext=" + this.f30441d + " }";
        }
        return (String) invokeV.objValue;
    }
}

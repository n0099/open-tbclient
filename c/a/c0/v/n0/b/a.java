package c.a.c0.v.n0.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Object> a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2484b;

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f2485c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2486d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2487e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2488f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ArrayList<Object> arrayList, String str, Boolean bool, String str2, String str3, String str4) {
        super(bool, str2, str3, str4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, str, bool, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Boolean) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = arrayList;
        this.f2484b = str;
        this.f2485c = bool;
        this.f2486d = str2;
        this.f2487e = str3;
        this.f2488f = str4;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2488f : (String) invokeV.objValue;
    }

    public Boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2485c : (Boolean) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2486d : (String) invokeV.objValue;
    }

    public final ArrayList<Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2487e : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.f2484b, aVar.f2484b) && Intrinsics.areEqual(b(), aVar.b()) && Intrinsics.areEqual(c(), aVar.c()) && Intrinsics.areEqual(e(), aVar.e()) && Intrinsics.areEqual(a(), aVar.a());
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2484b : (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList<Object> arrayList = this.a;
            int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
            String str = this.f2484b;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            Boolean b2 = b();
            int hashCode3 = (hashCode2 + (b2 != null ? b2.hashCode() : 0)) * 31;
            String c2 = c();
            int hashCode4 = (hashCode3 + (c2 != null ? c2.hashCode() : 0)) * 31;
            String e2 = e();
            int hashCode5 = (hashCode4 + (e2 != null ? e2.hashCode() : 0)) * 31;
            String a = a();
            return hashCode5 + (a != null ? a.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "AdaptationSet(representationList=" + this.a + ", type=" + this.f2484b + ", frmAlign=" + b() + ", pre=" + c() + ", suf=" + e() + ", codecs=" + a() + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ a(ArrayList arrayList, String str, Boolean bool, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, str, (i2 & 4) != 0 ? null : bool, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "" : str4);
    }
}

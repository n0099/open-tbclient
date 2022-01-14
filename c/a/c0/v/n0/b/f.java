package c.a.c0.v.n0.b;

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
public final class f extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<a> a;

    /* renamed from: b  reason: collision with root package name */
    public final Boolean f2490b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2491c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2492d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2493e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ArrayList<a> arrayList, Boolean bool, String str, String str2, String str3) {
        super(bool, str, str2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, bool, str, str2, str3};
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
        this.f2490b = bool;
        this.f2491c = str;
        this.f2492d = str2;
        this.f2493e = str3;
    }

    public final ArrayList<a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2493e : (String) invokeV.objValue;
    }

    public Boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2490b : (Boolean) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2491c : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2492d : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof f) {
                    f fVar = (f) obj;
                    return Intrinsics.areEqual(this.a, fVar.a) && Intrinsics.areEqual(c(), fVar.c()) && Intrinsics.areEqual(d(), fVar.d()) && Intrinsics.areEqual(e(), fVar.e()) && Intrinsics.areEqual(b(), fVar.b());
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<a> arrayList = this.a;
            int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
            Boolean c2 = c();
            int hashCode2 = (hashCode + (c2 != null ? c2.hashCode() : 0)) * 31;
            String d2 = d();
            int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 31;
            String e2 = e();
            int hashCode4 = (hashCode3 + (e2 != null ? e2.hashCode() : 0)) * 31;
            String b2 = b();
            return hashCode4 + (b2 != null ? b2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "Video(adaptationSetList=" + this.a + ", frmAlign=" + c() + ", pre=" + d() + ", suf=" + e() + ", codecs=" + b() + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ f(ArrayList arrayList, Boolean bool, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, (i2 & 2) != 0 ? null : bool, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? "" : str2, (i2 & 16) != 0 ? "" : str3);
    }
}

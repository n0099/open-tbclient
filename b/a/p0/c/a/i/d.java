package b.a.p0.c.a.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$ClientHello;
import com.baidu.swan.bdtls.impl.model.Bdtls$ServerHello;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bdtls$ClientHello f9562a;

    /* renamed from: b  reason: collision with root package name */
    public Bdtls$ServerHello f9563b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f9564c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d() {
        this(null, null, null, 7, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Bdtls$ClientHello) objArr[0], (Bdtls$ServerHello) objArr[1], (byte[]) objArr[2], ((Integer) objArr[3]).intValue(), (DefaultConstructorMarker) objArr[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdtls$ClientHello, bdtls$ServerHello, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9562a = bdtls$ClientHello;
        this.f9563b = bdtls$ServerHello;
        this.f9564c = bArr;
    }

    public final void a(Bdtls$ServerHello bdtls$ServerHello) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bdtls$ServerHello) == null) {
            this.f9563b = bdtls$ServerHello;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof d) {
                    d dVar = (d) obj;
                    return Intrinsics.areEqual(this.f9562a, dVar.f9562a) && Intrinsics.areEqual(this.f9563b, dVar.f9563b) && Intrinsics.areEqual(this.f9564c, dVar.f9564c);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Bdtls$ClientHello bdtls$ClientHello = this.f9562a;
            int hashCode = (bdtls$ClientHello != null ? bdtls$ClientHello.hashCode() : 0) * 31;
            Bdtls$ServerHello bdtls$ServerHello = this.f9563b;
            int hashCode2 = (hashCode + (bdtls$ServerHello != null ? bdtls$ServerHello.hashCode() : 0)) * 31;
            byte[] bArr = this.f9564c;
            return hashCode2 + (bArr != null ? Arrays.hashCode(bArr) : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "HandshakeParams(clientHello=" + this.f9562a + ", serverHello=" + this.f9563b + ", encodeDHPublicKey=" + Arrays.toString(this.f9564c) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ d(Bdtls$ClientHello bdtls$ClientHello, Bdtls$ServerHello bdtls$ServerHello, byte[] bArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : bdtls$ClientHello, (i2 & 2) != 0 ? null : bdtls$ServerHello, (i2 & 4) != 0 ? null : bArr);
    }
}

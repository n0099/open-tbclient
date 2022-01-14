package c.i.b.a.e0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public abstract class c extends c.i.b.a.y.g<h, i, SubtitleDecoderException> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str) {
        super(new h[2], new i[2]);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((c.i.b.a.y.e[]) objArr2[0], (c.i.b.a.y.f[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        t(1024);
    }

    @Override // c.i.b.a.e0.f
    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.y.g
    /* renamed from: u */
    public final h g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new h() : (h) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.y.g
    /* renamed from: v */
    public final i h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new d(this) : (i) invokeV.objValue;
    }

    public abstract e w(byte[] bArr, int i2, boolean z) throws SubtitleDecoderException;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.y.g
    /* renamed from: x */
    public final SubtitleDecoderException i(h hVar, i iVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, hVar, iVar, z)) == null) {
            try {
                ByteBuffer byteBuffer = hVar.f29956g;
                iVar.n(hVar.f29957h, w(byteBuffer.array(), byteBuffer.limit(), z), hVar.f29404j);
                iVar.g(Integer.MIN_VALUE);
                return null;
            } catch (SubtitleDecoderException e2) {
                return e2;
            }
        }
        return (SubtitleDecoderException) invokeLLZ.objValue;
    }

    public final void y(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar) == null) {
            super.q(iVar);
        }
    }
}

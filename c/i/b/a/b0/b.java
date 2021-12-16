package c.i.b.a.b0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
/* loaded from: classes9.dex */
public interface b {
    public static final b a = new a();

    /* loaded from: classes9.dex */
    public static class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.i.b.a.b0.b
        public c.i.b.a.b0.a a(String str, boolean z) throws MediaCodecUtil.DecoderQueryException {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) ? MediaCodecUtil.f(str, z) : (c.i.b.a.b0.a) invokeLZ.objValue;
        }

        @Override // c.i.b.a.b0.b
        public c.i.b.a.b0.a b() throws MediaCodecUtil.DecoderQueryException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? MediaCodecUtil.j() : (c.i.b.a.b0.a) invokeV.objValue;
        }
    }

    c.i.b.a.b0.a a(String str, boolean z) throws MediaCodecUtil.DecoderQueryException;

    c.i.b.a.b0.a b() throws MediaCodecUtil.DecoderQueryException;
}

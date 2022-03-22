package c.a.z.b.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.ShaderConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class j implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e a;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new h();
    }

    @Override // c.a.z.b.a.e
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.a() : invokeV.longValue;
    }

    @Override // c.a.z.b.a.e
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            this.a.b(i, i2);
        }
    }

    @Override // c.a.z.b.a.e
    public int c(int i, int i2, Map<String, float[]> map) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, map)) == null) ? this.a.c(i, i2, map) : invokeIIL.intValue;
    }

    @Override // c.a.z.b.a.e
    public int d(MediaTrack mediaTrack, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, mediaTrack, i, map)) == null) ? this.a.d(mediaTrack, i, map) : invokeLIL.intValue;
    }

    @Override // c.a.z.b.a.e
    public void e(List<MediaTrack> list, Map<String, ShaderConfig> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, map) == null) {
            this.a.e(list, map);
        }
    }

    @Override // c.a.z.b.a.e
    public int f(MediaTrack mediaTrack, int i, int i2, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{mediaTrack, Integer.valueOf(i), Integer.valueOf(i2), map})) == null) ? this.a.f(mediaTrack, i, i2, map) : invokeCommon.intValue;
    }

    @Override // c.a.z.b.a.e
    public void g(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.a.g(i, j);
        }
    }

    @Override // c.a.z.b.a.e
    public int h(MediaSegment mediaSegment, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, mediaSegment, i, map)) == null) ? this.a.h(mediaSegment, i, map) : invokeLIL.intValue;
    }

    @Override // c.a.z.b.a.e
    public int i(MediaTrack mediaTrack, int i, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaTrack, i, map)) == null) ? this.a.i(mediaTrack, i, map) : invokeLIL.intValue;
    }

    @Override // c.a.z.b.a.e
    public void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            this.a.j(context);
        }
    }

    @Override // c.a.z.b.a.e
    public int k(int i, float[] fArr, float[] fArr2, int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) ? this.a.k(i, fArr, fArr2, i2, i3, f2) : invokeCommon.intValue;
    }

    @Override // c.a.z.b.a.e
    public List<MediaTrack> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a.l() : (List) invokeV.objValue;
    }

    @Override // c.a.z.b.a.e
    public int m(int i, float[] fArr, float[] fArr2, int i2, int i3, int i4, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), fArr, fArr2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), map})) == null) ? this.a.m(i, fArr, fArr2, i2, i3, i4, map) : invokeCommon.intValue;
    }

    @Override // c.a.z.b.a.e
    public void n(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.a.n(list);
        }
    }

    @Override // c.a.z.b.a.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a.release();
        }
    }
}

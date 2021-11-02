package b.a.a0.b.a;

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
/* loaded from: classes.dex */
public class j implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f1327a;

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1327a = new h();
    }

    @Override // b.a.a0.b.a.e
    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1327a.a() : invokeV.longValue;
    }

    @Override // b.a.a0.b.a.e
    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.f1327a.b(i2, i3);
        }
    }

    @Override // b.a.a0.b.a.e
    public int c(int i2, int i3, Map<String, float[]> map) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, map)) == null) ? this.f1327a.c(i2, i3, map) : invokeIIL.intValue;
    }

    @Override // b.a.a0.b.a.e
    public int d(MediaTrack mediaTrack, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, mediaTrack, i2, map)) == null) ? this.f1327a.d(mediaTrack, i2, map) : invokeLIL.intValue;
    }

    @Override // b.a.a0.b.a.e
    public void e(List<MediaTrack> list, Map<String, ShaderConfig> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, map) == null) {
            this.f1327a.e(list, map);
        }
    }

    @Override // b.a.a0.b.a.e
    public int f(MediaTrack mediaTrack, int i2, int i3, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{mediaTrack, Integer.valueOf(i2), Integer.valueOf(i3), map})) == null) ? this.f1327a.f(mediaTrack, i2, i3, map) : invokeCommon.intValue;
    }

    @Override // b.a.a0.b.a.e
    public void g(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            this.f1327a.g(i2, j);
        }
    }

    @Override // b.a.a0.b.a.e
    public int h(MediaSegment mediaSegment, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, mediaSegment, i2, map)) == null) ? this.f1327a.h(mediaSegment, i2, map) : invokeLIL.intValue;
    }

    @Override // b.a.a0.b.a.e
    public int i(MediaTrack mediaTrack, int i2, Map<String, float[]> map) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaTrack, i2, map)) == null) ? this.f1327a.i(mediaTrack, i2, map) : invokeLIL.intValue;
    }

    @Override // b.a.a0.b.a.e
    public void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            this.f1327a.j(context);
        }
    }

    @Override // b.a.a0.b.a.e
    public int k(int i2, float[] fArr, float[] fArr2, int i3, int i4, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), fArr, fArr2, Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)})) == null) ? this.f1327a.k(i2, fArr, fArr2, i3, i4, f2) : invokeCommon.intValue;
    }

    @Override // b.a.a0.b.a.e
    public List<MediaTrack> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f1327a.l() : (List) invokeV.objValue;
    }

    @Override // b.a.a0.b.a.e
    public int m(int i2, float[] fArr, float[] fArr2, int i3, int i4, int i5, Map<String, float[]> map) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), fArr, fArr2, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), map})) == null) ? this.f1327a.m(i2, fArr, fArr2, i3, i4, i5, map) : invokeCommon.intValue;
    }

    @Override // b.a.a0.b.a.e
    public void n(List<MediaTrack> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.f1327a.n(list);
        }
    }

    @Override // b.a.a0.b.a.e
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f1327a.release();
        }
    }
}

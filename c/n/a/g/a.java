package c.n.a.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.opensource.svgaplayer.proto.AudioEntity;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f34391a;

    /* renamed from: b  reason: collision with root package name */
    public final int f34392b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f34393c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f34394d;

    public a(AudioEntity audioEntity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {audioEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String str = audioEntity.audioKey;
        Integer num = audioEntity.startFrame;
        this.f34391a = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.endFrame;
        this.f34392b = num2 != null ? num2.intValue() : 0;
        Integer num3 = audioEntity.startTime;
        if (num3 != null) {
            num3.intValue();
        }
        Integer num4 = audioEntity.totalTime;
        if (num4 != null) {
            num4.intValue();
        }
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34392b : invokeV.intValue;
    }

    public final Integer b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34394d : (Integer) invokeV.objValue;
    }

    public final Integer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34393c : (Integer) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34391a : invokeV.intValue;
    }

    public final void e(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, num) == null) {
            this.f34394d = num;
        }
    }

    public final void f(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, num) == null) {
            this.f34393c = num;
        }
    }
}

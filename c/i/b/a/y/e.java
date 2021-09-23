package c.i.b.a.y;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final b f34111f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f34112g;

    /* renamed from: h  reason: collision with root package name */
    public long f34113h;

    /* renamed from: i  reason: collision with root package name */
    public final int f34114i;

    public e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34111f = new b();
        this.f34114i = i2;
    }

    public static e r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new e(0) : (e) invokeV.objValue;
    }

    @Override // c.i.b.a.y.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.f();
            ByteBuffer byteBuffer = this.f34112g;
            if (byteBuffer != null) {
                byteBuffer.clear();
            }
        }
    }

    public final ByteBuffer m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int i3 = this.f34114i;
            if (i3 == 1) {
                return ByteBuffer.allocate(i2);
            }
            if (i3 == 2) {
                return ByteBuffer.allocateDirect(i2);
            }
            ByteBuffer byteBuffer = this.f34112g;
            int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
            throw new IllegalStateException("Buffer too small (" + capacity + " < " + i2 + SmallTailInfo.EMOTION_SUFFIX);
        }
        return (ByteBuffer) invokeI.objValue;
    }

    public void n(int i2) throws IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            ByteBuffer byteBuffer = this.f34112g;
            if (byteBuffer == null) {
                this.f34112g = m(i2);
                return;
            }
            int capacity = byteBuffer.capacity();
            int position = this.f34112g.position();
            int i3 = i2 + position;
            if (capacity >= i3) {
                return;
            }
            ByteBuffer m = m(i3);
            if (position > 0) {
                this.f34112g.position(0);
                this.f34112g.limit(position);
                m.put(this.f34112g);
            }
            this.f34112g = m;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f34112g.flip();
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h(1073741824) : invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f34112g == null && this.f34114i == 0 : invokeV.booleanValue;
    }
}

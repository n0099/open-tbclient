package c.d.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import javax.annotation.Nullable;
import okio.BufferedSink;
/* loaded from: classes4.dex */
public abstract class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a extends a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v f31498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f31499b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ byte[] f31500c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f31501d;

        public a(v vVar, int i2, byte[] bArr, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vVar, Integer.valueOf(i2), bArr, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31498a = vVar;
            this.f31499b = i2;
            this.f31500c = bArr;
            this.f31501d = i3;
        }

        @Override // c.d.b.a0
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31499b : invokeV.longValue;
        }

        @Override // c.d.b.a0
        @Nullable
        public v b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31498a : (v) invokeV.objValue;
        }

        @Override // c.d.b.a0
        public void e(BufferedSink bufferedSink) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                bufferedSink.write(this.f31500c, this.f31501d, this.f31499b);
            }
        }
    }

    public a0() {
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

    public static a0 c(@Nullable v vVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, vVar, bArr)) == null) ? d(vVar, bArr, 0, bArr.length) : (a0) invokeLL.objValue;
    }

    public static a0 d(@Nullable v vVar, byte[] bArr, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65538, null, vVar, bArr, i2, i3)) == null) {
            if (bArr != null) {
                c.d.b.e0.e.e(bArr.length, i2, i3);
                return new a(vVar, i3, bArr, i2);
            }
            throw new NullPointerException("content == null");
        }
        return (a0) invokeLLII.objValue;
    }

    public abstract long a() throws IOException;

    @Nullable
    public abstract v b();

    public abstract void e(BufferedSink bufferedSink) throws IOException;
}

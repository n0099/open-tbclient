package c.d.b.e0.k;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.internal.http2.ErrorCode;
import java.io.IOException;
import java.util.List;
import okio.BufferedSource;
/* loaded from: classes4.dex */
public interface j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f31798a = new a();

    /* loaded from: classes4.dex */
    public class a implements j {
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

        @Override // c.d.b.e0.k.j
        public void a(int i2, ErrorCode errorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, errorCode) == null) {
            }
        }

        @Override // c.d.b.e0.k.j
        public boolean onData(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), bufferedSource, Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
                bufferedSource.skip(i3);
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // c.d.b.e0.k.j
        public boolean onHeaders(int i2, List<c.d.b.e0.k.a> list, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), list, Boolean.valueOf(z)})) == null) {
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // c.d.b.e0.k.j
        public boolean onRequest(int i2, List<c.d.b.e0.k.a> list) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, list)) == null) {
                return true;
            }
            return invokeIL.booleanValue;
        }
    }

    void a(int i2, ErrorCode errorCode);

    boolean onData(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException;

    boolean onHeaders(int i2, List<c.d.b.e0.k.a> list, boolean z);

    boolean onRequest(int i2, List<c.d.b.e0.k.a> list);
}

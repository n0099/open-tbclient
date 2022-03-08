package c.d.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public interface o {
    public static final o a = new a();

    /* loaded from: classes3.dex */
    public class a implements o {
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

        @Override // c.d.b.o
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str != null) {
                    try {
                        return Arrays.asList(InetAddress.getAllByName(str));
                    } catch (NullPointerException e2) {
                        UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                        unknownHostException.initCause(e2);
                        throw unknownHostException;
                    }
                }
                throw new UnknownHostException("hostname == null");
            }
            return (List) invokeL.objValue;
        }
    }

    List<InetAddress> lookup(String str) throws UnknownHostException;
}

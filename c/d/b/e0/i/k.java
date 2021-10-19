package c.d.b.e0.i;

import c.d.b.b0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.duxiaoman.okhttp3.Protocol;
import java.io.IOException;
import java.net.ProtocolException;
/* loaded from: classes4.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Protocol f31877a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31878b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31879c;

    public k(Protocol protocol, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {protocol, Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31877a = protocol;
        this.f31878b = i2;
        this.f31879c = str;
    }

    public static k a(b0 b0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, b0Var)) == null) ? new k(b0Var.B(), b0Var.code(), b0Var.x()) : (k) invokeL.objValue;
    }

    public static k b(String str) throws IOException {
        InterceptResult invokeL;
        Protocol protocol;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int i2 = 9;
            if (str.startsWith("HTTP/1.")) {
                if (str.length() >= 9 && str.charAt(8) == ' ') {
                    int charAt = str.charAt(7) - '0';
                    if (charAt == 0) {
                        protocol = Protocol.HTTP_1_0;
                    } else if (charAt == 1) {
                        protocol = Protocol.HTTP_1_1;
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else if (str.startsWith("ICY ")) {
                protocol = Protocol.HTTP_1_0;
                i2 = 4;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int i3 = i2 + 3;
            if (str.length() >= i3) {
                try {
                    int parseInt = Integer.parseInt(str.substring(i2, i3));
                    if (str.length() <= i3) {
                        str2 = "";
                    } else if (str.charAt(i3) == ' ') {
                        str2 = str.substring(i2 + 4);
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    return new k(protocol, parseInt, str2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            }
            throw new ProtocolException("Unexpected status line: " + str);
        }
        return (k) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f31877a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
            sb.append(' ');
            sb.append(this.f31878b);
            if (this.f31879c != null) {
                sb.append(' ');
                sb.append(this.f31879c);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}

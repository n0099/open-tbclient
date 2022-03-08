package c.a.q0.s.j;

import android.text.TextUtils;
import c.a.d.f.p.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetSocketAddress;
import java.net.Socket;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f13909b;

    public f() {
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
        this.a = false;
        this.f13909b = 0;
    }

    public void a(String str) {
        int lastIndexOf;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.a = false;
            this.f13909b = 0;
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
                String str3 = null;
                try {
                    str2 = str.substring(5, lastIndexOf);
                } catch (Exception e2) {
                    e = e2;
                    str2 = null;
                }
                try {
                    str3 = str.substring(lastIndexOf + 1);
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    return;
                }
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    return;
                }
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < 3; i4++) {
                    Socket socket = new Socket();
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        try {
                            socket.connect(new InetSocketAddress(str2, c.a.d.f.m.b.e(String.valueOf(str3), 8000)), c());
                            if (socket.isConnected()) {
                                i2++;
                                i3 = (int) (i3 + (System.currentTimeMillis() - currentTimeMillis));
                                this.a = true;
                            }
                            try {
                                socket.close();
                            } catch (Exception e4) {
                                BdLog.e(e4.getMessage());
                            }
                        } catch (Throwable th) {
                            try {
                                socket.close();
                            } catch (Exception e5) {
                                BdLog.e(e5.getMessage());
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        BdLog.e(e6.getMessage());
                        socket.close();
                    }
                }
                if (!this.a || i2 <= 0) {
                    return;
                }
                this.f13909b = i3 / i2;
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13909b : invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int I = l.I();
            if (I != 1) {
                return I != 2 ? 5000 : 10000;
            }
            return 3000;
        }
        return invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
    }
}

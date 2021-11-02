package b.a.p0.h.k0;

import android.annotation.SuppressLint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/* loaded from: classes4.dex */
public final class a extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public g f10489e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f10490f;

    @SuppressLint({"MobilebdThread"})
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

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10490f : invokeV.booleanValue;
    }

    public final void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f10490f = z;
        }
    }

    public final void c(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f10489e = gVar;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        DatagramSocket B;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            while (this.f10490f) {
                try {
                    DatagramPacket datagramPacket = new DatagramPacket(new byte[4096], 4096);
                    g gVar = this.f10489e;
                    if (gVar != null && (B = gVar.B()) != null) {
                        B.receive(datagramPacket);
                    }
                    g gVar2 = this.f10489e;
                    if (gVar2 != null) {
                        gVar2.y(datagramPacket);
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Throwable unused2) {
                    g gVar3 = this.f10489e;
                    if (gVar3 != null) {
                        gVar3.C("receive", "receive failed");
                    }
                }
            }
        }
    }
}

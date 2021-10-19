package c.a.r0.k3.p0;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.a2.g;
import c.a.r0.k3.p0.d.d;
import c.a.r0.k3.p0.d.e;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.tbadk.switchs.ChunkUploadSwitch;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f21188c = 524288;

    /* renamed from: d  reason: collision with root package name */
    public static int f21189d = 6144000;

    /* renamed from: e  reason: collision with root package name */
    public static int f21190e = 524288;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.r0.k3.p0.d.b f21191a;

    /* renamed from: b  reason: collision with root package name */
    public g f21192b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1749014323, "Lc/a/r0/k3/p0/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1749014323, "Lc/a/r0/k3/p0/a;");
        }
    }

    public a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21192b = gVar;
    }

    public static void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            if (i2 <= 0) {
                f21189d = 6144000;
            } else {
                f21189d = i2;
            }
        }
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            if (i2 <= 0) {
                f21188c = 524288;
            } else {
                f21188c = i2;
            }
        }
    }

    public static void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2) == null) {
            if (i2 <= 0) {
                f21190e = 524288;
            } else {
                f21190e = i2;
            }
        }
    }

    public void a() {
        c.a.r0.k3.p0.d.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f21191a) == null) {
            return;
        }
        bVar.cancel();
    }

    public VideoFinishResult e(String str, String str2, int i2, e eVar) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, i2, eVar)) == null) {
            try {
                if (SwitchManager.getInstance().findType(ChunkUploadSwitch.KEY) == 1) {
                    this.f21191a = new d(str2, f21190e, this.f21192b);
                } else {
                    this.f21191a = new c.a.r0.k3.p0.d.c(str, f21188c, f21189d, this.f21192b);
                }
                this.f21191a.a(eVar);
                return this.f21191a.b(str2, i2);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                g gVar = this.f21192b;
                if (gVar != null) {
                    gVar.f(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA, -4399, c.a.r0.a2.a.a(e2));
                    return null;
                }
                return null;
            }
        }
        return (VideoFinishResult) invokeLLIL.objValue;
    }
}

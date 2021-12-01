package c.a.q0.f1.k;

import android.graphics.Bitmap;
import c.a.d.f.l.d;
import c.a.d.f.p.k;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.resourceLoaderProc.LocalFileImageLoaderProc;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a implements ImageAssetDelegate {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f12121d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public LocalFileImageLoaderProc f12122b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12123c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(771419864, "Lc/a/q0/f1/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(771419864, "Lc/a/q0/f1/k/a;");
                return;
            }
        }
        f12121d = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12123c = false;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f12121d + "/" + TbConfig.getTempDirName() + "/animation/";
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12123c : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f12123c = z;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a = a() + str + "/";
        }
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lottieImageAsset)) == null) {
            if (k.isEmpty(this.a)) {
                return null;
            }
            String str = this.a + lottieImageAsset.getDirName().replace("/", "") + "/" + lottieImageAsset.getFileName();
            c.a.d.m.d.a aVar = (c.a.d.m.d.a) d.h().n(str, 36, new Object[0]);
            if (aVar == null && b()) {
                if (this.f12122b == null) {
                    this.f12122b = new LocalFileImageLoaderProc();
                }
                aVar = this.f12122b.getBitmapFromFile(str, 0, 0);
            }
            if (aVar != null && aVar.p() != null) {
                Bitmap p = aVar.p();
                try {
                    return p.copy(p.getConfig(), false);
                } catch (OutOfMemoryError e2) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    BdLog.e(e2);
                }
            }
            d.h().m(str, 36, null, null);
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }
}

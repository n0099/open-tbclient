package c.a.o0.e1.k;

import android.graphics.Bitmap;
import c.a.d.f.l.d;
import c.a.d.f.p.m;
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
/* loaded from: classes2.dex */
public class a implements ImageAssetDelegate {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f10138d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public LocalFileImageLoaderProc f10139b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10140c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(276943193, "Lc/a/o0/e1/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(276943193, "Lc/a/o0/e1/k/a;");
                return;
            }
        }
        f10138d = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10140c = false;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f10138d + "/" + TbConfig.getTempDirName() + "/animation/";
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f10140c : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f10140c = z;
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
            if (m.isEmpty(this.a)) {
                return null;
            }
            String str = this.a + lottieImageAsset.getDirName().replace("/", "") + "/" + lottieImageAsset.getFileName();
            c.a.d.o.d.a aVar = (c.a.d.o.d.a) d.h().n(str, 36, new Object[0]);
            if (aVar == null && b()) {
                if (this.f10139b == null) {
                    this.f10139b = new LocalFileImageLoaderProc();
                }
                aVar = this.f10139b.getBitmapFromFile(str, 0, 0);
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

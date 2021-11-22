package b.a.q0.e1.k;

import android.graphics.Bitmap;
import b.a.e.f.l.d;
import b.a.e.f.p.k;
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
/* loaded from: classes4.dex */
public class a implements ImageAssetDelegate {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f13094d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13095a;

    /* renamed from: b  reason: collision with root package name */
    public LocalFileImageLoaderProc f13096b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13097c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(389474808, "Lb/a/q0/e1/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(389474808, "Lb/a/q0/e1/k/a;");
                return;
            }
        }
        f13094d = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
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
        this.f13097c = false;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f13094d + "/" + TbConfig.getTempDirName() + "/animation/";
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13097c : invokeV.booleanValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f13097c = z;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f13095a = a() + str + "/";
        }
    }

    @Override // com.airbnb.lottie.ImageAssetDelegate
    public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lottieImageAsset)) == null) {
            if (k.isEmpty(this.f13095a)) {
                return null;
            }
            String str = this.f13095a + lottieImageAsset.getDirName().replace("/", "") + "/" + lottieImageAsset.getFileName();
            b.a.e.m.d.a aVar = (b.a.e.m.d.a) d.h().n(str, 36, new Object[0]);
            if (aVar == null && b()) {
                if (this.f13096b == null) {
                    this.f13096b = new LocalFileImageLoaderProc();
                }
                aVar = this.f13096b.getBitmapFromFile(str, 0, 0);
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

package c.a.r0.w0.a.f;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24984d = z;
    }

    @Override // c.a.r0.w0.a.f.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.r0.w0.a.g.b bVar = this.a;
            if (bVar.f24992h == null) {
                this.f24982b.onError(bVar.f24990f, "cover config is null !!");
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bVar.a, bVar.f24986b, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(this.a.f24992h);
            g(new c.a.r0.w0.a.g.a(), createBitmap);
        }
    }
}

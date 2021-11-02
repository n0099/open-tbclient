package b.a.r0.q0.a.f;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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
        this.f22508d = z;
    }

    @Override // b.a.r0.q0.a.f.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.r0.q0.a.g.b bVar = this.f22505a;
            if (bVar.f22518h == null) {
                this.f22506b.onError(bVar.f22516f, "cover config is null !!");
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bVar.f22511a, bVar.f22512b, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(this.f22505a.f22518h);
            g(new b.a.r0.q0.a.g.a(), createBitmap);
        }
    }
}

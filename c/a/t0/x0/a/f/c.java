package c.a.t0.x0.a.f;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
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
        this.f24921d = z;
    }

    @Override // c.a.t0.x0.a.f.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.t0.x0.a.g.b bVar = this.a;
            if (bVar.f24929h == null) {
                this.f24919b.onError(bVar.f24927f, "cover config is null !!");
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bVar.a, bVar.f24923b, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(this.a.f24929h);
            g(new c.a.t0.x0.a.g.a(), createBitmap);
        }
    }
}

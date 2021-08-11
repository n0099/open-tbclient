package c.a.p0.o0.a.f;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
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
        this.f22492d = z;
    }

    @Override // c.a.p0.o0.a.f.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.p0.o0.a.g.c cVar = this.f22489a;
            if (cVar.f22511h == null) {
                this.f22490b.onError(cVar.f22509f, "cover config is null !!");
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(cVar.f22504a, cVar.f22505b, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(this.f22489a.f22511h);
            g(new c.a.p0.o0.a.g.b(), createBitmap);
        }
    }
}

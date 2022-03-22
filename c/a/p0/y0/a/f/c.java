package c.a.p0.y0.a.f;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20732d = z;
    }

    @Override // c.a.p0.y0.a.f.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.p0.y0.a.g.b bVar = this.a;
            if (bVar.f20739h == null) {
                this.f20730b.onError(bVar.f20737f, "cover config is null !!");
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bVar.a, bVar.f20733b, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(this.a.f20739h);
            g(new c.a.p0.y0.a.g.a(), createBitmap);
        }
    }
}

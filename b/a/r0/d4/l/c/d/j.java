package b.a.r0.d4.l.c.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
/* loaded from: classes4.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f17178e;

    /* renamed from: f  reason: collision with root package name */
    public String f17179f;

    /* renamed from: g  reason: collision with root package name */
    public String f17180g;

    public j(String str, String str2, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17179f = str;
        this.f17180g = str2;
        this.f17178e = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f17179f) || TextUtils.isEmpty(this.f17180g) || (bitmap = this.f17178e) == null || bitmap.isRecycled()) {
            return;
        }
        FileUtils.saveBitmap2JPG(this.f17179f, a.a(this.f17180g), this.f17178e, 100);
    }
}

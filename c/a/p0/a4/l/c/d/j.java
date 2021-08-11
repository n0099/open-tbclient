package c.a.p0.a4.l.c.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
/* loaded from: classes3.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f15545e;

    /* renamed from: f  reason: collision with root package name */
    public String f15546f;

    /* renamed from: g  reason: collision with root package name */
    public String f15547g;

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
        this.f15546f = str;
        this.f15547g = str2;
        this.f15545e = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f15546f) || TextUtils.isEmpty(this.f15547g) || (bitmap = this.f15545e) == null || bitmap.isRecycled()) {
            return;
        }
        FileUtils.saveBitmap2JPG(this.f15546f, a.a(this.f15547g), this.f15545e, 100);
    }
}

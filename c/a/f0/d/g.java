package c.a.f0.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class g implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f3293e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f3294f;

    /* renamed from: g  reason: collision with root package name */
    public String f3295g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f3296h;

    /* renamed from: i  reason: collision with root package name */
    public int f3297i;

    /* renamed from: j  reason: collision with root package name */
    public int f3298j;

    public g(Context context, Handler handler, String str, ImageView imageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler, str, imageView, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3293e = context.getApplicationContext();
        this.f3294f = handler;
        this.f3295g = str;
        this.f3296h = imageView;
        this.f3297i = i2;
        this.f3298j = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap a(String str, int i2, int i3) {
        Bitmap bitmap;
        Bitmap bitmap2;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, str, i2, i3)) == null) {
            try {
                bitmap = a.b(this.f3293e).c(str, i2, i3);
            } catch (IOException e2) {
                e = e2;
                bitmap = null;
            }
            try {
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                bitmap2 = bitmap;
                if (bitmap2 != null) {
                }
            }
            if (bitmap != null) {
                a.c().a(str, bitmap);
                return bitmap;
            }
            a.b(this.f3293e).a(str);
            bitmap2 = a.b(this.f3293e).c(str, i2, i3);
            return bitmap2 != null ? d.a(str) : bitmap2;
        }
        return (Bitmap) invokeLII.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Bitmap a = a(this.f3295g, this.f3297i, this.f3298j);
            if (this.f3294f != null) {
                this.f3294f.obtainMessage(1, new f(this.f3296h, this.f3295g, a)).sendToTarget();
            }
        }
    }
}

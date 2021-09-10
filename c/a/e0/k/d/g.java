package c.a.e0.k.d;

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
    public Context f3138e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f3139f;

    /* renamed from: g  reason: collision with root package name */
    public String f3140g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f3141h;

    /* renamed from: i  reason: collision with root package name */
    public int f3142i;

    /* renamed from: j  reason: collision with root package name */
    public int f3143j;

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
        this.f3138e = context.getApplicationContext();
        this.f3139f = handler;
        this.f3140g = str;
        this.f3141h = imageView;
        this.f3142i = i2;
        this.f3143j = i3;
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
                bitmap = a.c(this.f3138e).a(str, i2, i3);
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
                a.b().a(str, bitmap);
                return bitmap;
            }
            a.c(this.f3138e).c(str);
            bitmap2 = a.c(this.f3138e).a(str, i2, i3);
            return bitmap2 != null ? d.b(str) : bitmap2;
        }
        return (Bitmap) invokeLII.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Bitmap a2 = a(this.f3140g, this.f3142i, this.f3143j);
            if (this.f3139f != null) {
                this.f3139f.obtainMessage(1, new f(this.f3141h, this.f3140g, a2)).sendToTarget();
            }
        }
    }
}

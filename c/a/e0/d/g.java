package c.a.e0.d;

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
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f2748b;

    /* renamed from: c  reason: collision with root package name */
    public String f2749c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f2750d;

    /* renamed from: e  reason: collision with root package name */
    public int f2751e;

    /* renamed from: f  reason: collision with root package name */
    public int f2752f;

    public g(Context context, Handler handler, String str, ImageView imageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler, str, imageView, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
        this.f2748b = handler;
        this.f2749c = str;
        this.f2750d = imageView;
        this.f2751e = i;
        this.f2752f = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bitmap a(String str, int i, int i2) {
        Bitmap bitmap;
        Bitmap bitmap2;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, str, i, i2)) == null) {
            try {
                bitmap = a.b(this.a).c(str, i, i2);
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
            a.b(this.a).a(str);
            bitmap2 = a.b(this.a).c(str, i, i2);
            return bitmap2 != null ? d.a(str) : bitmap2;
        }
        return (Bitmap) invokeLII.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Bitmap a = a(this.f2749c, this.f2751e, this.f2752f);
            if (this.f2748b != null) {
                this.f2748b.obtainMessage(1, new f(this.f2750d, this.f2749c, a)).sendToTarget();
            }
        }
    }
}

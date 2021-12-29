package c.a.s0.s.s;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f13881b;

    /* renamed from: c  reason: collision with root package name */
    public View f13882c;

    public b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13881b = activity;
    }

    public void a() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (alertDialog = this.a) != null && alertDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1280;
        }
        return invokeV.intValue;
    }

    public final boolean c(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) ? (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) ? false : true : invokeL.booleanValue;
    }

    public final Bitmap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View decorView = this.f13881b.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache.getWidth() >= 600 || drawingCache.getHeight() >= 600) {
                int round = Math.round(drawingCache.getWidth() / 2);
                int round2 = Math.round(drawingCache.getHeight() / 2);
                if (round <= 0 || round2 <= 0) {
                    return null;
                }
                drawingCache = Bitmap.createScaledBitmap(drawingCache, round, round2, false);
                if (!c(drawingCache)) {
                    return null;
                }
            }
            Bitmap a = c.a.s0.e1.n.a(drawingCache, 20, false);
            decorView.setDrawingCacheEnabled(false);
            return a;
        }
        return (Bitmap) invokeV.objValue;
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.f13882c = view;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.a == null) {
                AlertDialog create = new AlertDialog.Builder(this.f13881b).create();
                this.a = create;
                Window window = create.getWindow();
                window.getDecorView().setSystemUiVisibility(b());
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                window.setBackgroundDrawable(new BitmapDrawable(this.f13881b.getResources(), d()));
                attributes.width = -1;
                attributes.height = -1;
                window.setNavigationBarColor(0);
                window.setAttributes(attributes);
                this.a.setCanceledOnTouchOutside(true);
                this.a.setCancelable(true);
                View view = this.f13882c;
                if (view != null) {
                    this.a.setView(view);
                }
            }
            if (this.a.isShowing()) {
                this.a.dismiss();
            }
            this.a.show();
        }
    }
}

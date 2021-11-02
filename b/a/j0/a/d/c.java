package b.a.j0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.widget.AdView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b.a.j0.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView c0;
    public Bitmap i0;

    /* loaded from: classes.dex */
    public class a implements b.a.j0.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f3061a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3061a = cVar;
        }

        @Override // b.a.j0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
                c cVar = this.f3061a;
                cVar.H("StaticImage Load Failed: " + materialLoadErrorCode.toString());
            }
        }

        @Override // b.a.j0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
                this.f3061a.i0 = bitmap;
                this.f3061a.Q();
                this.f3061a.I();
            }
        }

        @Override // b.a.j0.a.e.a
        public void onLoadingStarted(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f3062e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3062e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3062e.G();
            }
        }
    }

    /* renamed from: b.a.j0.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0079c implements b.a.j0.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f3063a;

        public C0079c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3063a = cVar;
        }

        @Override // b.a.j0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
                c cVar = this.f3063a;
                cVar.H("Get Static Image error: " + materialLoadErrorCode.getMessage());
            }
        }

        @Override // b.a.j0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
                this.f3063a.i0 = bitmap;
            }
        }

        @Override // b.a.j0.a.e.a
        public void onLoadingStarted(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (JSONObject) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = "image";
    }

    @Override // b.a.j0.a.d.a
    public void C() {
        RelativeLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f3033f != 2) {
                try {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    ImageView imageView = new ImageView(this.f3032e);
                    this.c0 = imageView;
                    imageView.setVisibility(0);
                    this.c0.setOnClickListener(new b(this));
                    this.c0.setLayoutParams(layoutParams);
                    U();
                } catch (Exception e2) {
                    this.j.c(b.a.j0.a.d.a.b0, e2);
                    H(b.a.j0.a.d.a.b0 + " exception=" + Log.getStackTraceString(e2));
                }
                if (this.i0 == null) {
                    return;
                }
                this.c0.setDrawingCacheEnabled(true);
                this.c0.setImageBitmap(this.i0);
                k(this.c0, layoutParams);
                this.c0.requestLayout();
                super.C();
                this.c0.requestFocus();
                K();
                return;
            }
            this.j.a("XPureStaticImageAdContainer: ad state is stopped, so can not show ad");
        }
    }

    @Override // b.a.j0.a.d.a
    public void D() {
        AdView adView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j.j(b.a.j0.a.d.a.b0, "doStopOnUIThread");
            ImageView imageView = this.c0;
            if (imageView != null && (adView = this.p) != null && adView.indexOfChild(imageView) >= 0) {
                this.j.j(b.a.j0.a.d.a.b0, "doStopOnUIThread release imageView");
                if (this.c0.getDrawingCache() != null) {
                    this.c0.getDrawingCache().recycle();
                }
                this.p.removeAllViews();
            }
            Bitmap bitmap = this.i0;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            b.a.j0.a.k.b bVar = this.j;
            String str = b.a.j0.a.d.a.b0;
            bVar.j(str, "doStopOnUIThread release newBitmap->" + this.i0.toString());
            this.i0.recycle();
            this.i0 = null;
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ImageView imageView = this.c0;
            if (imageView != null) {
                imageView.setScaleType(this.K == 17 ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_XY);
            }
            if (this.i0 != null) {
                return;
            }
            this.i0 = this.m.a(this.y, new C0079c(this));
        }
    }

    @Override // b.a.j0.a.d.a, b.a.j0.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.a();
            if (this.m.c(this.y, MaterialLoader.MaterialCacheType.PICTURE)) {
                Q();
                I();
                return;
            }
            try {
                MaterialLoader.k(this.f3032e).f(this.y, new a(this));
            } catch (Exception e2) {
                H("StaticImage,Exception: " + e2.toString());
            }
        }
    }

    @Override // b.a.j0.a.d.a, b.a.j0.a.g.b
    public void b(b.a.j0.a.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            super.b(cVar);
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
        }
    }

    @Override // b.a.j0.a.d.a, b.a.j0.a.g.b
    public void d(b.a.j0.a.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            super.d(aVar);
        }
    }

    @Override // b.a.j0.a.d.a, b.a.j0.a.g.b
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? super.getAdView() : (View) invokeV.objValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            R();
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
        }
    }

    @Override // b.a.j0.a.d.a
    public void z() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (imageView = this.c0) == null) {
            return;
        }
        imageView.setOnClickListener(null);
    }
}

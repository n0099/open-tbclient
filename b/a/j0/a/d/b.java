package b.a.j0.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.j0.a.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.gif.GifAnimView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileInputStream;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends b.a.j0.a.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FileInputStream c0;
    public GifAnimView i0;

    /* loaded from: classes.dex */
    public class a implements b.a.j0.a.e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f3151a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3151a = bVar;
        }

        @Override // b.a.j0.a.e.a
        public void a(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, materialLoadErrorCode) == null) {
                this.f3151a.H("cache gif, load failed");
            }
        }

        @Override // b.a.j0.a.e.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, bitmap) == null) {
                b bVar = this.f3151a;
                bVar.U(MaterialLoader.k(bVar.f3125e).l(str));
            }
        }

        @Override // b.a.j0.a.e.a
        public void onLoadingStarted(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
            }
        }
    }

    /* renamed from: b.a.j0.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0080b implements b.a.j0.a.f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0080b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.j0.a.f.d
        public void callback() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f3152e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3152e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f3152e.G();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f3153a;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3153a = bVar;
        }

        @Override // b.a.j0.a.f.e
        public void onAdPresent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3153a.K();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, JSONObject jSONObject) {
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
        this.w = "gif";
    }

    @Override // b.a.j0.a.d.a
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f3126f != 2) {
                GifAnimView gifAnimView = new GifAnimView(this.f3125e, new C0080b(this));
                this.i0 = gifAnimView;
                gifAnimView.setGifImage(this.c0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                this.i0.setLayoutParams(layoutParams);
                this.i0.setShowDimension(this.p.getWidth(), this.p.getHeight());
                this.i0.setAlpha(255);
                this.i0.setOnClickListener(new c(this));
                this.i0.startAnimation();
                k(this.i0, layoutParams);
                this.i0.requestLayout();
                this.i0.gifViewListener = new d(this);
                super.C();
                return;
            }
            this.j.a("XGifAdContainer: ad state is stopped, so can not show ad");
        }
    }

    @Override // b.a.j0.a.d.a
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                this.c0 = new FileInputStream(str);
                I();
            } catch (Exception unused) {
            }
            Q();
        }
    }

    @Override // b.a.j0.a.d.a, b.a.j0.a.g.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.a();
            String optString = this.n.optString("cached_path");
            if (!TextUtils.isEmpty(optString)) {
                U(optString);
                return;
            }
            try {
                if (!this.m.c(this.y, MaterialLoader.MaterialCacheType.VIDEO)) {
                    MaterialLoader.k(this.f3125e).f(this.y, new a(this));
                } else {
                    U(this.m.b(this.y, MaterialLoader.MaterialCacheType.VIDEO));
                }
            } catch (Throwable unused) {
                H("gif渲染失败");
            }
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
        }
    }

    @Override // b.a.j0.a.d.a, b.a.j0.a.g.b
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? super.getAdView() : (View) invokeV.objValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    @Override // b.a.j0.a.d.a
    public void z() {
        GifAnimView gifAnimView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (gifAnimView = this.i0) == null) {
            return;
        }
        gifAnimView.setOnClickListener(null);
    }
}

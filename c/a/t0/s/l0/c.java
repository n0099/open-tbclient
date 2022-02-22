package c.a.t0.s.l0;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public Context f13548b;

    /* renamed from: c  reason: collision with root package name */
    public View f13549c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13550d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13551e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f13552f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f13553g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f13554h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13555e;

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
            this.f13555e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13555e.f13552f == null) {
                return;
            }
            this.f13555e.f13552f.cancel();
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3000L;
        this.f13548b = null;
        this.f13549c = null;
        this.f13550d = null;
        this.f13551e = null;
        this.f13554h = new a(this);
        this.f13548b = TbadkCoreApplication.getInst().getContext();
        this.f13553g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13548b).inflate(c.a.u0.a4.h.image_toast_view, (ViewGroup) null);
            this.f13549c = inflate;
            this.f13550d = (TextView) inflate.findViewById(c.a.u0.a4.g.tip_text);
            this.f13551e = (ImageView) this.f13549c.findViewById(c.a.u0.a4.g.tip_iamge);
            this.f13549c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13548b, c.a.u0.a4.e.tbds32), SkinManager.getColor(c.a.u0.a4.d.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13550d, c.a.u0.a4.d.CAM_X0101);
            this.f13550d.setText(charSequence);
            this.f13551e.setImageResource(c.a.u0.a4.f.icon_toast_game_error);
            e(this.f13549c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13548b).inflate(c.a.u0.a4.h.image_toast_view, (ViewGroup) null);
            this.f13549c = inflate;
            this.f13550d = (TextView) inflate.findViewById(c.a.u0.a4.g.tip_text);
            this.f13551e = (ImageView) this.f13549c.findViewById(c.a.u0.a4.g.tip_iamge);
            this.f13549c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13548b, c.a.u0.a4.e.tbds32), SkinManager.getColor(c.a.u0.a4.d.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13550d, c.a.u0.a4.d.CAM_X0101);
            this.f13550d.setText(charSequence);
            this.f13551e.setImageResource(c.a.u0.a4.f.icon_toast_game_ok);
            e(this.f13549c);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f13548b).inflate(c.a.u0.a4.h.image_toast_view, (ViewGroup) null);
            this.f13549c = inflate;
            this.f13550d = (TextView) inflate.findViewById(c.a.u0.a4.g.tip_text);
            this.f13551e = (ImageView) this.f13549c.findViewById(c.a.u0.a4.g.tip_iamge);
            this.f13549c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13548b, c.a.u0.a4.e.tbds32), SkinManager.getColor(c.a.u0.a4.d.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13550d, c.a.u0.a4.d.CAM_X0101);
            this.f13550d.setText(i3);
            this.f13551e.setImageResource(i2);
            e(this.f13549c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f13553g.removeCallbacks(this.f13554h);
            if (this.f13552f == null) {
                this.f13552f = new Toast(this.f13548b);
            }
            this.f13553g.postDelayed(this.f13554h, this.a);
            this.f13552f.setView(view);
            this.f13552f.setDuration(1);
            this.f13552f.setGravity(17, 0, 0);
            this.f13552f.show();
        }
    }
}

package c.a.s0.s.k0;

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
import com.baidu.tieba.R;
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
    public Context f13264b;

    /* renamed from: c  reason: collision with root package name */
    public View f13265c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13266d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13267e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f13268f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f13269g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f13270h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13271e;

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
            this.f13271e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13271e.f13268f == null) {
                return;
            }
            this.f13271e.f13268f.cancel();
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
        this.f13264b = null;
        this.f13265c = null;
        this.f13266d = null;
        this.f13267e = null;
        this.f13270h = new a(this);
        this.f13264b = TbadkCoreApplication.getInst().getContext();
        this.f13269g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13264b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13265c = inflate;
            this.f13266d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13267e = (ImageView) this.f13265c.findViewById(R.id.tip_iamge);
            this.f13265c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13264b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13266d, R.color.CAM_X0101);
            this.f13266d.setText(charSequence);
            this.f13267e.setImageResource(R.drawable.icon_toast_game_error);
            e(this.f13265c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13264b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13265c = inflate;
            this.f13266d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13267e = (ImageView) this.f13265c.findViewById(R.id.tip_iamge);
            this.f13265c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13264b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13266d, R.color.CAM_X0101);
            this.f13266d.setText(charSequence);
            this.f13267e.setImageResource(R.drawable.icon_toast_game_ok);
            e(this.f13265c);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f13264b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13265c = inflate;
            this.f13266d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13267e = (ImageView) this.f13265c.findViewById(R.id.tip_iamge);
            this.f13265c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13264b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13266d, R.color.CAM_X0101);
            this.f13266d.setText(i3);
            this.f13267e.setImageResource(i2);
            e(this.f13265c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f13269g.removeCallbacks(this.f13270h);
            if (this.f13268f == null) {
                this.f13268f = new Toast(this.f13264b);
            }
            this.f13269g.postDelayed(this.f13270h, this.a);
            this.f13268f.setView(view);
            this.f13268f.setDuration(1);
            this.f13268f.setGravity(17, 0, 0);
            this.f13268f.show();
        }
    }
}

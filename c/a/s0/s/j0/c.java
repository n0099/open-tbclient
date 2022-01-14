package c.a.s0.s.j0;

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
    public Context f13073b;

    /* renamed from: c  reason: collision with root package name */
    public View f13074c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13075d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13076e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f13077f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f13078g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f13079h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13080e;

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
            this.f13080e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13080e.f13077f == null) {
                return;
            }
            this.f13080e.f13077f.cancel();
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
        this.f13073b = null;
        this.f13074c = null;
        this.f13075d = null;
        this.f13076e = null;
        this.f13079h = new a(this);
        this.f13073b = TbadkCoreApplication.getInst().getContext();
        this.f13078g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13073b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13074c = inflate;
            this.f13075d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13076e = (ImageView) this.f13074c.findViewById(R.id.tip_iamge);
            this.f13074c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13073b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13075d, R.color.CAM_X0101);
            this.f13075d.setText(charSequence);
            this.f13076e.setImageResource(R.drawable.icon_toast_game_error);
            e(this.f13074c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13073b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13074c = inflate;
            this.f13075d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13076e = (ImageView) this.f13074c.findViewById(R.id.tip_iamge);
            this.f13074c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13073b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13075d, R.color.CAM_X0101);
            this.f13075d.setText(charSequence);
            this.f13076e.setImageResource(R.drawable.icon_toast_game_ok);
            e(this.f13074c);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f13073b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13074c = inflate;
            this.f13075d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13076e = (ImageView) this.f13074c.findViewById(R.id.tip_iamge);
            this.f13074c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13073b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13075d, R.color.CAM_X0101);
            this.f13075d.setText(i3);
            this.f13076e.setImageResource(i2);
            e(this.f13074c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f13078g.removeCallbacks(this.f13079h);
            if (this.f13077f == null) {
                this.f13077f = new Toast(this.f13073b);
            }
            this.f13078g.postDelayed(this.f13079h, this.a);
            this.f13077f.setView(view);
            this.f13077f.setDuration(1);
            this.f13077f.setGravity(17, 0, 0);
            this.f13077f.show();
        }
    }
}

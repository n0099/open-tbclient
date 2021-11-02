package b.a.q0.s.g0;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f12958a;

    /* renamed from: b  reason: collision with root package name */
    public Context f12959b;

    /* renamed from: c  reason: collision with root package name */
    public View f12960c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f12961d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f12962e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f12963f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f12964g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f12965h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f12966e;

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
            this.f12966e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12966e.f12963f == null) {
                return;
            }
            this.f12966e.f12963f.cancel();
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
        this.f12958a = 3000L;
        this.f12959b = null;
        this.f12960c = null;
        this.f12961d = null;
        this.f12962e = null;
        this.f12965h = new a(this);
        this.f12959b = TbadkCoreApplication.getInst().getContext();
        this.f12964g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f12959b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f12960c = inflate;
            this.f12961d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f12962e = (ImageView) this.f12960c.findViewById(R.id.tip_iamge);
            this.f12960c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(b.a.e.e.p.l.g(this.f12959b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f12961d, R.color.CAM_X0101);
            this.f12961d.setText(charSequence);
            this.f12962e.setImageResource(R.drawable.icon_toast_game_error);
            e(this.f12960c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f12959b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f12960c = inflate;
            this.f12961d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f12962e = (ImageView) this.f12960c.findViewById(R.id.tip_iamge);
            this.f12960c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(b.a.e.e.p.l.g(this.f12959b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f12961d, R.color.CAM_X0101);
            this.f12961d.setText(charSequence);
            this.f12962e.setImageResource(R.drawable.icon_toast_game_ok);
            e(this.f12960c);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f12959b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f12960c = inflate;
            this.f12961d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f12962e = (ImageView) this.f12960c.findViewById(R.id.tip_iamge);
            this.f12960c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(b.a.e.e.p.l.g(this.f12959b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f12961d, R.color.CAM_X0101);
            this.f12961d.setText(i3);
            this.f12962e.setImageResource(i2);
            e(this.f12960c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f12964g.removeCallbacks(this.f12965h);
            if (this.f12963f == null) {
                this.f12963f = new Toast(this.f12959b);
            }
            this.f12964g.postDelayed(this.f12965h, this.f12958a);
            this.f12963f.setView(view);
            this.f12963f.setDuration(1);
            this.f12963f.setGravity(17, 0, 0);
            this.f12963f.show();
        }
    }
}

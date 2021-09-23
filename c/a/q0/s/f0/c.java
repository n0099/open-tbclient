package c.a.q0.s.f0;

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
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f13812a;

    /* renamed from: b  reason: collision with root package name */
    public Context f13813b;

    /* renamed from: c  reason: collision with root package name */
    public View f13814c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13815d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13816e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f13817f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f13818g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f13819h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13820e;

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
            this.f13820e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13820e.f13817f == null) {
                return;
            }
            this.f13820e.f13817f.cancel();
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
        this.f13812a = 3000L;
        this.f13813b = null;
        this.f13814c = null;
        this.f13815d = null;
        this.f13816e = null;
        this.f13819h = new a(this);
        this.f13813b = TbadkCoreApplication.getInst().getContext();
        this.f13818g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13813b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13814c = inflate;
            this.f13815d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13816e = (ImageView) this.f13814c.findViewById(R.id.tip_iamge);
            this.f13814c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(this.f13813b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13815d, R.color.CAM_X0101);
            this.f13815d.setText(charSequence);
            this.f13816e.setImageResource(R.drawable.icon_toast_game_error);
            e(this.f13814c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13813b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13814c = inflate;
            this.f13815d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13816e = (ImageView) this.f13814c.findViewById(R.id.tip_iamge);
            this.f13814c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(this.f13813b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13815d, R.color.CAM_X0101);
            this.f13815d.setText(charSequence);
            this.f13816e.setImageResource(R.drawable.icon_toast_game_ok);
            e(this.f13814c);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f13813b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13814c = inflate;
            this.f13815d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13816e = (ImageView) this.f13814c.findViewById(R.id.tip_iamge);
            this.f13814c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(this.f13813b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13815d, R.color.CAM_X0101);
            this.f13815d.setText(i3);
            this.f13816e.setImageResource(i2);
            e(this.f13814c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f13818g.removeCallbacks(this.f13819h);
            if (this.f13817f == null) {
                this.f13817f = new Toast(this.f13813b);
            }
            this.f13818g.postDelayed(this.f13819h, this.f13812a);
            this.f13817f.setView(view);
            this.f13817f.setDuration(1);
            this.f13817f.setGravity(17, 0, 0);
            this.f13817f.show();
        }
    }
}

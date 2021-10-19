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
    public long f13832a;

    /* renamed from: b  reason: collision with root package name */
    public Context f13833b;

    /* renamed from: c  reason: collision with root package name */
    public View f13834c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13835d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13836e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f13837f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f13838g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f13839h;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13840e;

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
            this.f13840e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13840e.f13837f == null) {
                return;
            }
            this.f13840e.f13837f.cancel();
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
        this.f13832a = 3000L;
        this.f13833b = null;
        this.f13834c = null;
        this.f13835d = null;
        this.f13836e = null;
        this.f13839h = new a(this);
        this.f13833b = TbadkCoreApplication.getInst().getContext();
        this.f13838g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13833b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13834c = inflate;
            this.f13835d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13836e = (ImageView) this.f13834c.findViewById(R.id.tip_iamge);
            this.f13834c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(this.f13833b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13835d, R.color.CAM_X0101);
            this.f13835d.setText(charSequence);
            this.f13836e.setImageResource(R.drawable.icon_toast_game_error);
            e(this.f13834c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13833b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13834c = inflate;
            this.f13835d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13836e = (ImageView) this.f13834c.findViewById(R.id.tip_iamge);
            this.f13834c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(this.f13833b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13835d, R.color.CAM_X0101);
            this.f13835d.setText(charSequence);
            this.f13836e.setImageResource(R.drawable.icon_toast_game_ok);
            e(this.f13834c);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f13833b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13834c = inflate;
            this.f13835d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13836e = (ImageView) this.f13834c.findViewById(R.id.tip_iamge);
            this.f13834c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(c.a.e.e.p.l.g(this.f13833b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13835d, R.color.CAM_X0101);
            this.f13835d.setText(i3);
            this.f13836e.setImageResource(i2);
            e(this.f13834c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f13838g.removeCallbacks(this.f13839h);
            if (this.f13837f == null) {
                this.f13837f = new Toast(this.f13833b);
            }
            this.f13838g.postDelayed(this.f13839h, this.f13832a);
            this.f13837f.setView(view);
            this.f13837f.setDuration(1);
            this.f13837f.setGravity(17, 0, 0);
            this.f13837f.show();
        }
    }
}

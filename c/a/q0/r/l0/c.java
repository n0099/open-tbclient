package c.a.q0.r.l0;

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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public Context f12964b;

    /* renamed from: c  reason: collision with root package name */
    public View f12965c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f12966d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f12967e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f12968f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f12969g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f12970h;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f12971e;

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
            this.f12971e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f12971e.f12968f == null) {
                return;
            }
            this.f12971e.f12968f.cancel();
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
        this.f12964b = null;
        this.f12965c = null;
        this.f12966d = null;
        this.f12967e = null;
        this.f12970h = new a(this);
        this.f12964b = TbadkCoreApplication.getInst().getContext();
        this.f12969g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f12964b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f12965c = inflate;
            this.f12966d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f12967e = (ImageView) this.f12965c.findViewById(R.id.tip_iamge);
            this.f12965c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f12964b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f12966d, (int) R.color.CAM_X0101);
            this.f12966d.setText(charSequence);
            this.f12967e.setImageResource(R.drawable.icon_toast_game_error);
            e(this.f12965c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f12964b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f12965c = inflate;
            this.f12966d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f12967e = (ImageView) this.f12965c.findViewById(R.id.tip_iamge);
            this.f12965c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f12964b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f12966d, (int) R.color.CAM_X0101);
            this.f12966d.setText(charSequence);
            this.f12967e.setImageResource(R.drawable.icon_toast_game_ok);
            e(this.f12965c);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f12964b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f12965c = inflate;
            this.f12966d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f12967e = (ImageView) this.f12965c.findViewById(R.id.tip_iamge);
            this.f12965c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f12964b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f12966d, (int) R.color.CAM_X0101);
            this.f12966d.setText(i3);
            this.f12967e.setImageResource(i2);
            e(this.f12965c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f12969g.removeCallbacks(this.f12970h);
            if (this.f12968f == null) {
                this.f12968f = new Toast(this.f12964b);
            }
            this.f12969g.postDelayed(this.f12970h, this.a);
            this.f12968f.setView(view);
            this.f12968f.setDuration(1);
            this.f12968f.setGravity(17, 0, 0);
            this.f12968f.show();
        }
    }
}

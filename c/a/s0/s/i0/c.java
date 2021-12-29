package c.a.s0.s.i0;

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
    public Context f13379b;

    /* renamed from: c  reason: collision with root package name */
    public View f13380c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f13381d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f13382e;

    /* renamed from: f  reason: collision with root package name */
    public Toast f13383f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f13384g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f13385h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f13386e;

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
            this.f13386e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13386e.f13383f == null) {
                return;
            }
            this.f13386e.f13383f.cancel();
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
        this.f13379b = null;
        this.f13380c = null;
        this.f13381d = null;
        this.f13382e = null;
        this.f13385h = new a(this);
        this.f13379b = TbadkCoreApplication.getInst().getContext();
        this.f13384g = new Handler();
    }

    public void b(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13379b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13380c = inflate;
            this.f13381d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13382e = (ImageView) this.f13380c.findViewById(R.id.tip_iamge);
            this.f13380c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13379b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13381d, R.color.CAM_X0101);
            this.f13381d.setText(charSequence);
            this.f13382e.setImageResource(R.drawable.icon_toast_game_error);
            e(this.f13380c);
        }
    }

    public void c(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence) == null) {
            View inflate = LayoutInflater.from(this.f13379b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13380c = inflate;
            this.f13381d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13382e = (ImageView) this.f13380c.findViewById(R.id.tip_iamge);
            this.f13380c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13379b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13381d, R.color.CAM_X0101);
            this.f13381d.setText(charSequence);
            this.f13382e.setImageResource(R.drawable.icon_toast_game_ok);
            e(this.f13380c);
        }
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            View inflate = LayoutInflater.from(this.f13379b).inflate(R.layout.image_toast_view, (ViewGroup) null);
            this.f13380c = inflate;
            this.f13381d = (TextView) inflate.findViewById(R.id.tip_text);
            this.f13382e = (ImageView) this.f13380c.findViewById(R.id.tip_iamge);
            this.f13380c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(n.f(this.f13379b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
            SkinManager.setViewTextColor(this.f13381d, R.color.CAM_X0101);
            this.f13381d.setText(i3);
            this.f13382e.setImageResource(i2);
            e(this.f13380c);
        }
    }

    public void e(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f13384g.removeCallbacks(this.f13385h);
            if (this.f13383f == null) {
                this.f13383f = new Toast(this.f13379b);
            }
            this.f13384g.postDelayed(this.f13385h, this.a);
            this.f13383f.setView(view);
            this.f13383f.setDuration(1);
            this.f13383f.setGravity(17, 0, 0);
            this.f13383f.show();
        }
    }
}

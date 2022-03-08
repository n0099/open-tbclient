package c.a.r0.a0.f.i;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.q0.c1.o0;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.k2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class g extends c.a.r0.f0.b<c.a.r0.a0.f.a.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClickableHeaderImageView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public View E;
    public c.a.r0.a0.f.a.g F;
    public boolean G;
    public int H;
    public int I;
    public k2 J;
    public a K;
    public b L;
    public TextView M;
    public int m;
    public TbImageView n;
    public TextView o;
    public LinearLayout p;
    public ImageView q;
    public TextView r;
    public LinearLayout s;
    public RelativeLayout t;
    public ClickableHeaderImageView u;
    public TextView v;
    public TextView w;
    public RelativeLayout x;
    public TextView y;
    public RelativeLayout z;

    /* loaded from: classes2.dex */
    public interface a {
        void a(c.a.r0.a0.f.a.g gVar);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(c.a.r0.a0.f.a.g gVar, View view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 3;
        this.H = 0;
        this.I = 0;
        p();
    }

    @Override // c.a.r0.f0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_video_layout : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.t, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.y, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0106);
        SkinManager.setBackgroundResource(this.M, R.drawable.good_video_label_bg);
        SkinManager.setViewTextColor(this.M, (int) R.color.CAM_X0111);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == j()) {
            a aVar = this.K;
            if (aVar != null) {
                aVar.a(this.F);
            }
            b bVar = this.L;
            if (bVar != null) {
                bVar.a(this.F, view);
            }
            c.a.r0.a0.f.e.a.c().h(true);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.n = (TbImageView) j().findViewById(R.id.imgSquareView);
            this.o = (TextView) j().findViewById(R.id.tvSquareTip);
            this.p = (LinearLayout) j().findViewById(R.id.llLiveTipPanel);
            this.q = (ImageView) j().findViewById(R.id.imgLiveCountLabel);
            this.r = (TextView) j().findViewById(R.id.tvLiveCount);
            this.s = (LinearLayout) j().findViewById(R.id.llLiveBottomPanel);
            this.t = (RelativeLayout) j().findViewById(R.id.rlSquareLivePanel);
            this.u = (ClickableHeaderImageView) j().findViewById(R.id.imgUserCover);
            this.v = (TextView) j().findViewById(R.id.tvUserName);
            this.w = (TextView) j().findViewById(R.id.tvCreateTime);
            this.x = (RelativeLayout) j().findViewById(R.id.rlSquareUserInfo);
            this.y = (TextView) j().findViewById(R.id.tvSquareTitle);
            this.M = (TextView) j().findViewById(R.id.good_video_label);
            this.E = j().findViewById(R.id.llSquareTitlePanel);
            this.z = (RelativeLayout) j().findViewById(R.id.rlSquareNewUserInfo);
            this.A = (ClickableHeaderImageView) j().findViewById(R.id.imgNewUserCover);
            this.B = (TextView) j().findViewById(R.id.tvNewUserName);
            this.C = (TextView) j().findViewById(R.id.tvNewCount);
            this.D = (TextView) j().findViewById(R.id.tvSquareNewTitle);
            this.A.setIsRound(true);
            this.C.setCompoundDrawablesWithIntrinsicBounds(this.f17262g.getResources().getDrawable(R.drawable.icon_home_card_like_grey), (Drawable) null, (Drawable) null, (Drawable) null);
            this.n.setDefaultBgResource(c.a.r0.a0.f.i.a.a());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.t.getLayoutParams();
            int k = n.k(this.f17262g) / 2;
            this.H = k;
            int i2 = (k * 9) / 16;
            this.I = i2;
            layoutParams.width = k;
            layoutParams.height = i2;
            this.t.setLayoutParams(layoutParams);
            this.q.setImageResource(R.drawable.icon_video_recommend_like);
            j().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: q */
    public void k(c.a.r0.a0.f.a.g gVar) {
        e2 e2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || gVar == null || gVar.f14180e == null) {
            return;
        }
        this.F = gVar;
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        if (this.G) {
            int i2 = this.I;
            if (gVar != null && (e2Var = gVar.f14180e) != null && e2Var.u1() != null && gVar.f14180e.u1().thumbnail_width != null && gVar.f14180e.u1().thumbnail_width.intValue() > 0) {
                i2 = (this.H * gVar.f14180e.u1().thumbnail_height.intValue()) / gVar.f14180e.u1().thumbnail_width.intValue();
            }
            ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
            layoutParams.width = this.H;
            layoutParams.height = i2;
            this.t.setLayoutParams(layoutParams);
        }
        String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(gVar.f14180e.C());
        this.r.setText(numberUniformFormatExtra);
        this.u.setVisibility(0);
        this.u.setData(gVar.f14180e);
        this.u.setIsRound(true);
        this.y.setText(gVar.f14180e.getTitle());
        this.n.startLoad(gVar.f14180e.u1().thumbnail_url, 10, false);
        this.v.setVisibility(0);
        this.J = gVar.f14180e.t1();
        this.w.setText(StringHelper.getFormatTime(gVar.f14180e.P()));
        k2 k2Var = this.J;
        if (k2Var != null) {
            String str = k2Var.f13330b;
            if (o0.d(str) > 10) {
                str = o0.n(str, 10) + "...";
            }
            this.v.setText(str);
            this.B.setText(str);
        } else if (gVar.f14180e.J() != null && !StringUtils.isNull(gVar.f14180e.J().getName_show())) {
            String name_show = gVar.f14180e.J().getName_show();
            if (o0.d(name_show) > 10) {
                name_show = o0.n(name_show, 10) + "...";
            }
            this.v.setText(name_show);
            this.B.setText(name_show);
        }
        this.A.setData(gVar.f14180e, false);
        this.C.setText(numberUniformFormatExtra);
        this.D.setText(gVar.f14180e.getTitle());
        if (gVar.k()) {
            this.M.setVisibility(0);
        } else {
            this.M.setVisibility(8);
        }
        l(this.f17261f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.G = z;
        }
    }

    public void t(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.L = bVar;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.z.setVisibility(z ? 0 : 8);
            this.D.setVisibility(z ? 0 : 8);
            if (z) {
                this.x.setVisibility(8);
                this.E.setVisibility(8);
                this.s.setVisibility(8);
            }
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.x.setVisibility(z ? 0 : 8);
            if (z) {
                this.E.setVisibility(0);
                this.s.setVisibility(0);
                this.z.setVisibility(8);
                this.D.setVisibility(8);
            }
        }
    }
}

package b.a.r0.w.f.i;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.d1.m0;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.k2;
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
/* loaded from: classes5.dex */
public class g extends b.a.r0.b0.b<b.a.r0.w.f.a.g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClickableHeaderImageView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public View E;
    public b.a.r0.w.f.a.g F;
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

    /* loaded from: classes5.dex */
    public interface a {
        void a(b.a.r0.w.f.a.g gVar);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(b.a.r0.w.f.a.g gVar, View view);
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
        o();
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_video_layout : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.t, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.y, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.B, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.D, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.C, R.color.CAM_X0106);
        SkinManager.setBackgroundResource(this.M, R.drawable.good_video_label_bg);
        SkinManager.setViewTextColor(this.M, R.color.CAM_X0111);
        this.m = i2;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.n = (TbImageView) i().findViewById(R.id.imgSquareView);
            this.o = (TextView) i().findViewById(R.id.tvSquareTip);
            this.p = (LinearLayout) i().findViewById(R.id.llLiveTipPanel);
            this.q = (ImageView) i().findViewById(R.id.imgLiveCountLabel);
            this.r = (TextView) i().findViewById(R.id.tvLiveCount);
            this.s = (LinearLayout) i().findViewById(R.id.llLiveBottomPanel);
            this.t = (RelativeLayout) i().findViewById(R.id.rlSquareLivePanel);
            this.u = (ClickableHeaderImageView) i().findViewById(R.id.imgUserCover);
            this.v = (TextView) i().findViewById(R.id.tvUserName);
            this.w = (TextView) i().findViewById(R.id.tvCreateTime);
            this.x = (RelativeLayout) i().findViewById(R.id.rlSquareUserInfo);
            this.y = (TextView) i().findViewById(R.id.tvSquareTitle);
            this.M = (TextView) i().findViewById(R.id.good_video_label);
            this.E = i().findViewById(R.id.llSquareTitlePanel);
            this.z = (RelativeLayout) i().findViewById(R.id.rlSquareNewUserInfo);
            this.A = (ClickableHeaderImageView) i().findViewById(R.id.imgNewUserCover);
            this.B = (TextView) i().findViewById(R.id.tvNewUserName);
            this.C = (TextView) i().findViewById(R.id.tvNewCount);
            this.D = (TextView) i().findViewById(R.id.tvSquareNewTitle);
            this.A.setIsRound(true);
            this.C.setCompoundDrawablesWithIntrinsicBounds(this.f14738g.getResources().getDrawable(R.drawable.icon_home_card_like_grey), (Drawable) null, (Drawable) null, (Drawable) null);
            this.n.setDefaultBgResource(b.a.r0.w.f.i.a.a());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.t.getLayoutParams();
            int k = l.k(this.f14738g) / 2;
            this.H = k;
            int i2 = (k * 9) / 16;
            this.I = i2;
            layoutParams.width = k;
            layoutParams.height = i2;
            this.t.setLayoutParams(layoutParams);
            this.q.setImageResource(R.drawable.icon_video_recommend_like);
            i().setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == i()) {
            a aVar = this.K;
            if (aVar != null) {
                aVar.a(this.F);
            }
            b bVar = this.L;
            if (bVar != null) {
                bVar.a(this.F, view);
            }
            b.a.r0.w.f.e.a.c().h(true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: p */
    public void j(b.a.r0.w.f.a.g gVar) {
        d2 d2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || gVar == null || gVar.f24516e == null) {
            return;
        }
        this.F = gVar;
        this.p.setVisibility(8);
        this.q.setVisibility(0);
        if (this.G) {
            int i2 = this.I;
            if (gVar != null && (d2Var = gVar.f24516e) != null && d2Var.q1() != null && gVar.f24516e.q1().thumbnail_width != null && gVar.f24516e.q1().thumbnail_width.intValue() > 0) {
                i2 = (this.H * gVar.f24516e.q1().thumbnail_height.intValue()) / gVar.f24516e.q1().thumbnail_width.intValue();
            }
            ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
            layoutParams.width = this.H;
            layoutParams.height = i2;
            this.t.setLayoutParams(layoutParams);
        }
        String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(gVar.f24516e.C());
        this.r.setText(numberUniformFormatExtra);
        this.u.setVisibility(0);
        this.u.setData(gVar.f24516e);
        this.u.setIsRound(true);
        this.y.setText(gVar.f24516e.getTitle());
        this.n.startLoad(gVar.f24516e.q1().thumbnail_url, 10, false);
        this.v.setVisibility(0);
        this.J = gVar.f24516e.p1();
        this.w.setText(StringHelper.getFormatTime(gVar.f24516e.P()));
        k2 k2Var = this.J;
        if (k2Var != null) {
            String str = k2Var.f13386b;
            if (m0.d(str) > 10) {
                str = m0.m(str, 10) + "...";
            }
            this.v.setText(str);
            this.B.setText(str);
        } else if (gVar.f24516e.J() != null && !StringUtils.isNull(gVar.f24516e.J().getName_show())) {
            String name_show = gVar.f24516e.J().getName_show();
            if (m0.d(name_show) > 10) {
                name_show = m0.m(name_show, 10) + "...";
            }
            this.v.setText(name_show);
            this.B.setText(name_show);
        }
        this.A.setData(gVar.f24516e, false);
        this.C.setText(numberUniformFormatExtra);
        this.D.setText(gVar.f24516e.getTitle());
        if (gVar.k()) {
            this.M.setVisibility(0);
        } else {
            this.M.setVisibility(8);
        }
        k(this.f14737f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.G = z;
        }
    }

    public void s(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.L = bVar;
        }
    }

    public void t(boolean z) {
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

    public void u(boolean z) {
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

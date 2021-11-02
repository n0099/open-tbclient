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
public class f extends b.a.r0.b0.b<b.a.r0.w.f.a.f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClickableHeaderImageView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public View E;
    public b.a.r0.w.f.a.f F;
    public boolean G;
    public int H;
    public int I;
    public a J;
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
        void a(b.a.r0.w.f.a.f fVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<?> tbPageContext) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_record_layout : invokeV.intValue;
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
            this.E = i().findViewById(R.id.llSquareTitlePanel);
            this.z = (RelativeLayout) i().findViewById(R.id.rlSquareNewUserInfo);
            this.A = (ClickableHeaderImageView) i().findViewById(R.id.imgNewUserCover);
            this.B = (TextView) i().findViewById(R.id.tvNewUserName);
            this.C = (TextView) i().findViewById(R.id.tvNewCount);
            this.D = (TextView) i().findViewById(R.id.tvSquareNewTitle);
            this.A.setIsRound(true);
            this.C.setCompoundDrawablesWithIntrinsicBounds(this.f14738g.getResources().getDrawable(R.drawable.icon_home_card_like_grey), (Drawable) null, (Drawable) null, (Drawable) null);
            this.n.setDefaultBgResource(b.a.r0.w.f.i.a.a());
            this.u.setIsRound(true);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.t.getLayoutParams();
            int k = l.k(this.f14738g) / 2;
            this.H = k;
            int i2 = (k * 9) / 16;
            this.I = i2;
            layoutParams.width = k;
            layoutParams.height = i2;
            this.t.setLayoutParams(layoutParams);
            this.y.setMaxLines(2);
            this.q.setImageResource(R.drawable.icon_video_recommend_like);
            i().setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == i()) {
            a aVar = this.J;
            if (aVar != null) {
                aVar.a(this.F);
            }
            b.a.r0.w.f.e.a.c().h(true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: p */
    public void j(b.a.r0.w.f.a.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) || fVar == null || fVar.f24513e == null) {
            return;
        }
        this.F = fVar;
        this.p.setVisibility(0);
        this.q.setVisibility(0);
        if (this.G) {
            int i2 = this.I;
            if (fVar.f24513e.q1().thumbnail_width.intValue() > 0) {
                i2 = (this.H * fVar.f24513e.q1().thumbnail_height.intValue()) / fVar.f24513e.q1().thumbnail_width.intValue();
            }
            ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
            layoutParams.width = this.H;
            layoutParams.height = i2;
            this.t.setLayoutParams(layoutParams);
        }
        this.o.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_video_direct_seeding_replay, 0, 0, 0);
        this.o.setText(this.f14738g.getResources().getString(R.string.square_record_tip));
        this.n.startLoad(fVar.f24513e.q1().thumbnail_url, 10, false);
        String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(fVar.f24513e.C());
        this.r.setText(numberUniformFormatExtra);
        this.u.setVisibility(0);
        this.u.setData(fVar.f24513e);
        this.v.setVisibility(0);
        if (fVar.f24513e.J() != null && !StringUtils.isNull(fVar.f24513e.J().getName_show())) {
            String name_show = fVar.f24513e.J().getName_show();
            if (m0.d(name_show) > 10) {
                name_show = m0.m(name_show, 10) + "...";
            }
            this.v.setText(name_show);
            this.B.setText(name_show);
        }
        this.w.setText(StringHelper.getFormatTime(fVar.f24513e.P()));
        this.y.setText(fVar.f24513e.getTitle());
        this.A.setData(fVar.f24513e, false);
        this.C.setText(numberUniformFormatExtra);
        this.D.setText(fVar.f24513e.getTitle());
        k(this.f14737f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void q(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.J = aVar;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.G = z;
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
        }
    }
}

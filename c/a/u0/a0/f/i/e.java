package c.a.u0.a0.f.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.t0.d1.p0;
import c.a.t0.s.r.e2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
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
/* loaded from: classes6.dex */
public class e extends c.a.u0.g0.b<c.a.u0.a0.f.a.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClickableHeaderImageView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public View E;
    public e2 F;
    public String G;
    public int H;
    public c.a.u0.a0.f.a.e I;
    public d J;
    public int K;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
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
        this.G = AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_RECOMMEND;
        this.H = (n.k(this.f17876g) - this.f17876g.getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
        p();
    }

    @Override // c.a.u0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_live_layout : invokeV.intValue;
    }

    @Override // c.a.u0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.t, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.B, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.y, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.D, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.C, R.color.CAM_X0106);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == j()) {
            if (!l.z()) {
                Context context = this.f17876g;
                n.K(context, context.getString(R.string.no_network_guide));
                return;
            }
            d dVar = this.J;
            if (dVar != null) {
                dVar.a(view, this.I);
            }
            c.a.u0.a0.f.e.a.c().h(true);
            q(this.f17875f, this.F);
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
            this.E = j().findViewById(R.id.llSquareTitlePanel);
            this.z = (RelativeLayout) j().findViewById(R.id.rlSquareNewUserInfo);
            this.A = (ClickableHeaderImageView) j().findViewById(R.id.imgNewUserCover);
            this.B = (TextView) j().findViewById(R.id.tvNewUserName);
            this.C = (TextView) j().findViewById(R.id.tvNewCount);
            this.D = (TextView) j().findViewById(R.id.tvSquareNewTitle);
            this.A.setIsRound(true);
            int i2 = this.K;
            if (i2 == 0) {
                this.n.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            } else {
                this.n.setDefaultBgResource(i2);
            }
            this.n.setDrawerType(0);
            this.n.setBorderSurroundContent(true);
            this.n.setDrawBorder(true);
            this.u.setIsRound(true);
            this.u.setBorderSurroundContent(true);
            j().setOnClickListener(this);
        }
    }

    public void q(TbPageContext<?> tbPageContext, e2 e2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, tbPageContext, e2Var) == null) || tbPageContext == null || e2Var == null || e2Var.J() == null || e2Var.p1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = e2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(e2Var.p1());
        alaLiveInfoCoreData.userName = e2Var.J().getUserName();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, this.G, str, z, "")));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.u0.g0.b
    /* renamed from: s */
    public void k(c.a.u0.a0.f.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            if (eVar != null && eVar.f14758h != null) {
                j().setVisibility(0);
                this.I = eVar;
                this.F = eVar.f14758h;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                this.s.setVisibility(0);
                this.y.setMaxLines(1);
                ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
                int i2 = this.H;
                layoutParams.width = i2;
                layoutParams.height = i2;
                this.t.setLayoutParams(layoutParams);
                this.o.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_video_direct_seeding, 0, 0, 0);
                this.o.setText(this.f17876g.getResources().getString(R.string.square_live_tip));
                this.n.startLoad(this.F.p1().cover, 10, false);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(this.F.p1().audience_count);
                this.r.setText(this.f17876g.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
                this.u.setData(this.F);
                this.y.setText(this.F.getTitle());
                if (this.F.J() != null) {
                    String name_show = eVar.f14758h.J().getName_show();
                    if (p0.d(name_show) > 10) {
                        name_show = p0.n(name_show, 10) + "...";
                    }
                    this.v.setText(name_show);
                    this.B.setText(name_show);
                }
                this.w.setText(StringHelper.getFormatTime(this.F.P()));
                this.A.setData(this.F, false);
                this.C.setText(this.f17876g.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
                this.D.setText(this.F.getTitle());
                l(this.f17875f, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            j().setVisibility(4);
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.J = dVar;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.G = str;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.z.setVisibility(z ? 0 : 8);
            this.D.setVisibility(z ? 0 : 8);
            if (z) {
                this.x.setVisibility(8);
                this.E.setVisibility(8);
                this.s.setVisibility(8);
            }
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.x.setVisibility(z ? 0 : 8);
            if (z) {
                this.E.setVisibility(0);
                this.s.setVisibility(0);
                this.z.setVisibility(8);
                this.D.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext, int i2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = 3;
        this.G = AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_RECOMMEND;
        this.H = (n.k(this.f17876g) - this.f17876g.getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
        this.K = i2;
        p();
    }
}

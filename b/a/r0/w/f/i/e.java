package b.a.r0.w.f.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.q0.c1.m0;
import b.a.q0.s.q.d2;
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
/* loaded from: classes5.dex */
public class e extends b.a.r0.b0.b<b.a.r0.w.f.a.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ClickableHeaderImageView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public View E;
    public d2 F;
    public String G;
    public int H;
    public b.a.r0.w.f.a.e I;
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
        this.H = (l.k(this.f16225g) - this.f16225g.getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
        o();
    }

    @Override // b.a.r0.b0.b
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.square_live_layout : invokeV.intValue;
    }

    @Override // b.a.r0.b0.b
    public void k(TbPageContext<?> tbPageContext, int i2) {
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
            i().setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view) == null) && view == i()) {
            if (!j.z()) {
                Context context = this.f16225g;
                l.J(context, context.getString(R.string.no_network_guide));
                return;
            }
            d dVar = this.J;
            if (dVar != null) {
                dVar.a(view, this.I);
            }
            b.a.r0.w.f.e.a.c().h(true);
            p(this.f16224f, this.F);
        }
    }

    public void p(TbPageContext<?> tbPageContext, d2 d2Var) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, tbPageContext, d2Var) == null) || tbPageContext == null || d2Var == null || d2Var.J() == null || d2Var.m1() == null) {
            return;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = d2Var.J().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str = currentAccount;
        } else {
            str = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(d2Var.m1());
        alaLiveInfoCoreData.userName = d2Var.J().getUserName();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity(), alaLiveInfoCoreData, this.G, str, z, "")));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.b0.b
    /* renamed from: q */
    public void j(b.a.r0.w.f.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            if (eVar != null && eVar.f26027h != null) {
                i().setVisibility(0);
                this.I = eVar;
                this.F = eVar.f26027h;
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
                this.o.setText(this.f16225g.getResources().getString(R.string.square_live_tip));
                this.n.startLoad(this.F.m1().cover, 10, false);
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(this.F.m1().audience_count);
                this.r.setText(this.f16225g.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
                this.u.setData(this.F);
                this.y.setText(this.F.getTitle());
                if (this.F.J() != null) {
                    String name_show = eVar.f26027h.J().getName_show();
                    if (m0.d(name_show) > 10) {
                        name_show = m0.m(name_show, 10) + "...";
                    }
                    this.v.setText(name_show);
                    this.B.setText(name_show);
                }
                this.w.setText(StringHelper.getFormatTime(this.F.P()));
                this.A.setData(this.F, false);
                this.C.setText(this.f16225g.getResources().getString(R.string.square_audience_label, numberUniformFormatExtra));
                this.D.setText(this.F.getTitle());
                k(this.f16224f, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            i().setVisibility(4);
        }
    }

    public void s(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.J = dVar;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.G = str;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    public void v(boolean z) {
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

    public void w(boolean z) {
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
        this.H = (l.k(this.f16225g) - this.f16225g.getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
        this.K = i2;
        o();
    }
}

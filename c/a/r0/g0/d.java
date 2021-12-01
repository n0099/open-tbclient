package c.a.r0.g0;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d extends b<c.a.r0.n0.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public LinearLayout m;
    public TextView n;
    public RelativeLayout o;
    public TbImageView p;
    public ImageView q;
    public TextView r;
    public RelativeLayout s;
    public ClickableHeaderImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public View x;
    public c.a.r0.n0.a y;
    public String z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2};
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
        this.z = str;
        this.A = str2;
        p(j());
    }

    @Override // c.a.r0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_frs_game_common_big_view_item : invokeV.intValue;
    }

    @Override // c.a.r0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f17232e != i2) {
                SkinManager.setBackgroundResource(j(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.x, R.color.CAM_X0204);
                c.a.r0.t3.p0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && readThreadHistory.d(this.y.getThreadData().g0())) {
                    SkinManager.setViewTextColor(this.n, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, 1);
                }
                SkinManager.setViewTextColor(this.u, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.v, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0101, 1);
            }
            this.f17232e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.w) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 4).param("fid", this.z));
                FrsGameStrategyActivity.startActivity(this.f17233f.getPageActivity(), this.z, this.A);
            } else if (g() != null) {
                g().a(j(), this.y);
            }
        }
    }

    public final void p(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
            this.n = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
            this.o = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
            this.p = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
            this.q = (ImageView) view.findViewById(R.id.img_play);
            this.r = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
            this.s = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
            this.t = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
            this.u = (TextView) view.findViewById(R.id.card_frs_game_user_name);
            this.v = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
            this.w = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
            this.x = view.findViewById(R.id.card_frs_game_bottom_divider);
            this.p.setDefaultBgResource(R.drawable.icon_morenpic);
            int dimensionPixelSize = c.a.d.f.p.l.p(this.f17234g)[0] - (this.f17234g.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = (dimensionPixelSize * 9) / 21;
            this.o.setLayoutParams(layoutParams);
            this.w.setOnClickListener(this);
            this.t.setDefaultResource(17170445);
            this.t.setDefaultBgResource(R.color.CAM_X0205);
            this.t.setIsRound(true);
            this.t.setDrawBorder(true);
            this.t.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.t.setBorderWidth(this.f17234g.getResources().getDimensionPixelSize(R.dimen.tbds1));
            j().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.g0.b
    /* renamed from: q */
    public void k(c.a.r0.n0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        this.y = aVar;
        String str = null;
        if (aVar.getThreadData().H2()) {
            this.q.setVisibility(0);
            this.r.setVisibility(0);
            if (aVar.getThreadData().t1() != null) {
                this.r.setText(StringHelper.stringForVideoTime(aVar.getThreadData().t1().video_duration.intValue() * 1000));
                str = aVar.getThreadData().t1().thumbnail_url;
            }
        } else {
            this.q.setVisibility(8);
            this.r.setVisibility(4);
            if (aVar.getThreadData().F0() != null && aVar.getThreadData().F0().size() >= 1) {
                str = aVar.getThreadData().F0().get(0).origin_pic;
            }
        }
        this.p.startLoad(str, 10, false);
        this.n.setText(aVar.getThreadData().getTitle());
        c.a.r0.t3.p0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(aVar.getThreadData().g0())) {
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
        }
        this.t.setData(aVar.getThreadData(), false);
        w(aVar.getThreadData());
        this.v.setText(StringHelper.getFormatTimeShort(aVar.getThreadData().I()));
        if (AuthoritySharedPreferences.KEY_CONFIG_FIRSTSHOT_GUIDE.equals(aVar.getThreadData().c0())) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(8);
        }
    }

    public String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, "...") : (String) invokeL.objValue;
    }

    public void t(int i2, int i3, int i4, int i5) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) || (linearLayout = this.m) == null) {
            return;
        }
        linearLayout.setPadding(i2, i3, i4, i5);
    }

    public void u(int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (relativeLayout = this.s) == null) {
            return;
        }
        relativeLayout.setVisibility(i2);
    }

    public void v(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (view = this.x) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public final void w(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, d2Var) == null) || this.u == null || d2Var == null || StringUtils.isNull(d2Var.J().getName_show())) {
            return;
        }
        this.u.setText(s(d2Var.J().getName_show()));
    }
}

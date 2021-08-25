package c.a.q0.a0;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
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
/* loaded from: classes3.dex */
public class e extends b<c.a.q0.g0.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout m;
    public RelativeLayout n;
    public TbImageView o;
    public ImageView p;
    public TextView q;
    public TextView r;
    public ClickableHeaderImageView s;
    public TextView t;
    public TextView u;
    public View v;
    public c.a.q0.g0.b w;

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
        p(j());
    }

    @Override // c.a.q0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_frs_game_common_small_view_item : invokeV.intValue;
    }

    @Override // c.a.q0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            if (this.f15231e != i2) {
                SkinManager.setBackgroundResource(j(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.v, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0101, 1);
                c.a.q0.i3.o0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && readThreadHistory.d(this.w.getThreadData().f0())) {
                    SkinManager.setViewTextColor(this.r, R.color.CAM_X0108);
                } else {
                    SkinManager.setViewTextColor(this.r, R.color.CAM_X0105);
                }
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.u, R.color.CAM_X0109, 1);
            }
            this.f15231e = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || g() == null) {
            return;
        }
        g().a(j(), this.w);
    }

    public final void p(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.m = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
            this.n = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
            this.o = (TbImageView) view.findViewById(R.id.img_thumbnail);
            this.p = (ImageView) view.findViewById(R.id.img_play);
            this.q = (TextView) view.findViewById(R.id.card_frs_game_video_time);
            this.r = (TextView) view.findViewById(R.id.card_frs_game_video_title);
            this.s = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
            this.t = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
            this.u = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
            this.v = view.findViewById(R.id.card_frs_game_bottom_divider);
            this.o.setDefaultBgResource(R.drawable.icon_morenpic);
            int dimensionPixelSize = this.f15233g.getResources().getDimensionPixelSize(R.dimen.tbds326);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = (dimensionPixelSize * 9) / 16;
            this.n.setLayoutParams(layoutParams);
            this.s.setDefaultResource(17170445);
            this.s.setDefaultBgResource(R.color.CAM_X0205);
            this.s.setIsRound(true);
            this.s.setDrawBorder(true);
            this.s.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.s.setBorderWidth(this.f15233g.getResources().getDimensionPixelSize(R.dimen.tbds1));
            j().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.a0.b
    /* renamed from: q */
    public void k(c.a.q0.g0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || bVar == null || bVar.getThreadData() == null) {
            return;
        }
        this.w = bVar;
        String str = null;
        if (bVar.getThreadData().A2()) {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            if (bVar.getThreadData().o1() != null) {
                this.q.setText(StringHelper.stringForVideoTime(bVar.getThreadData().o1().video_duration.intValue() * 1000));
                str = bVar.getThreadData().o1().thumbnail_url;
            }
        } else {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            if (bVar.getThreadData().C0() != null && bVar.getThreadData().C0().size() >= 1) {
                str = bVar.getThreadData().C0().get(0).origin_pic;
            }
        }
        this.o.startLoad(str, 10, false);
        this.r.setText(bVar.getThreadData().getTitle());
        c.a.q0.i3.o0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(bVar.getThreadData().f0())) {
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105);
        }
        this.s.setData(bVar.getThreadData(), false);
        this.u.setText(StringHelper.getFormatTimeShort(bVar.getThreadData().I()));
        if ("news".equals(bVar.getThreadData().b0())) {
            this.s.setVisibility(8);
            this.t.setText(this.f15232f.getPageActivity().getResources().getString(R.string.person_view_num, StringHelper.numberUniformFormat(bVar.getThreadData().A1())));
            return;
        }
        this.s.setVisibility(0);
        w(bVar.getThreadData());
    }

    public String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, "...") : (String) invokeL.objValue;
    }

    public void t(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (view = this.v) == null) {
            return;
        }
        view.setVisibility(i2);
    }

    public void u(int i2, int i3, int i4, int i5) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) || (linearLayout = this.m) == null) {
            return;
        }
        linearLayout.setPadding(i2, i3, i4, i5);
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.s.setVisibility(i2);
        }
    }

    public final void w(c2 c2Var) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, c2Var) == null) || (textView = this.t) == null || c2Var == null) {
            return;
        }
        textView.setVisibility(0);
        if (StringUtils.isNull(c2Var.J().getName_show())) {
            return;
        }
        this.t.setText(s(c2Var.J().getName_show()));
    }
}

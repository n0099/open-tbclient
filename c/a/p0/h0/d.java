package c.a.p0.h0;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class d extends b<c.a.p0.o0.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public TextView j;
    public RelativeLayout k;
    public TbImageView l;
    public ImageView m;
    public TextView n;
    public RelativeLayout o;
    public ClickableHeaderImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public View t;
    public c.a.p0.o0.a u;
    public String v;
    public String w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = str;
        this.w = str2;
        q(k());
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0188 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(k(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.t, R.color.CAM_X0204);
                c.a.p0.a4.q0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && readThreadHistory.d(this.u.getThreadData().getId())) {
                    SkinManager.setViewTextColor(this.j, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
                }
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.r, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.s, R.color.CAM_X0304, 1);
                SkinManager.setViewTextColor(this.n, R.color.CAM_X0101, 1);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.s) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 4).param("fid", this.v));
                FrsGameStrategyActivity.startActivity(this.f15304b.getPageActivity(), this.v, this.w);
            } else if (h() != null) {
                h().a(k(), this.u);
            }
        }
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.i = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f09051d);
            this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090520);
            this.k = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f09051c);
            this.l = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f09051b);
            this.m = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ec8);
            this.n = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090521);
            this.o = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f090522);
            this.p = (ClickableHeaderImageView) view.findViewById(R.id.obfuscated_res_0x7f090523);
            this.q = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090524);
            this.r = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09051f);
            this.s = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09051e);
            this.t = view.findViewById(R.id.obfuscated_res_0x7f0904fd);
            this.l.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080858);
            int dimensionPixelSize = c.a.d.f.p.n.p(this.f15305c)[0] - (this.f15305c.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = (dimensionPixelSize * 9) / 21;
            this.k.setLayoutParams(layoutParams);
            this.s.setOnClickListener(this);
            this.p.setDefaultResource(17170445);
            this.p.setDefaultBgResource(R.color.CAM_X0205);
            this.p.setIsRound(true);
            this.p.setDrawBorder(true);
            this.p.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.p.setBorderWidth(this.f15305c.getResources().getDimensionPixelSize(R.dimen.tbds1));
            k().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: s */
    public void l(c.a.p0.o0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        this.u = aVar;
        String str = null;
        if (aVar.getThreadData().isVideoThreadType()) {
            this.m.setVisibility(0);
            this.n.setVisibility(0);
            if (aVar.getThreadData().getThreadVideoInfo() != null) {
                this.n.setText(StringHelper.stringForVideoTime(aVar.getThreadData().getThreadVideoInfo().video_duration.intValue() * 1000));
                str = aVar.getThreadData().getThreadVideoInfo().thumbnail_url;
            }
        } else {
            this.m.setVisibility(8);
            this.n.setVisibility(4);
            if (aVar.getThreadData().getMedias() != null && aVar.getThreadData().getMedias().size() >= 1) {
                str = aVar.getThreadData().getMedias().get(0).origin_pic;
            }
        }
        this.l.J(str, 10, false);
        this.j.setText(aVar.getThreadData().getTitle());
        c.a.p0.a4.q0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(aVar.getThreadData().getId())) {
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
        }
        this.p.setData(aVar.getThreadData(), false);
        x(aVar.getThreadData());
        this.r.setText(StringHelper.getFormatTimeShort(aVar.getThreadData().getAuditTime()));
        if ("guide".equals(aVar.getThreadData().getGameInformationSource())) {
            this.s.setVisibility(0);
        } else {
            this.s.setVisibility(8);
        }
    }

    public String t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE) : (String) invokeL.objValue;
    }

    public void u(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) || (linearLayout = this.i) == null) {
            return;
        }
        linearLayout.setPadding(i, i2, i3, i4);
    }

    public void v(int i) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (relativeLayout = this.o) == null) {
            return;
        }
        relativeLayout.setVisibility(i);
    }

    public void w(int i) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (view = this.t) == null) {
            return;
        }
        view.setVisibility(i);
    }

    public final void x(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) || this.q == null || threadData == null || StringUtils.isNull(threadData.getAuthor().getName_show())) {
            return;
        }
        this.q.setText(t(threadData.getAuthor().getName_show()));
    }
}

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
public class e extends b<c.a.p0.o0.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public RelativeLayout j;
    public TbImageView k;
    public ImageView l;
    public TextView m;
    public TextView n;
    public ClickableHeaderImageView o;
    public TextView p;
    public TextView q;
    public View r;
    public c.a.p0.o0.b s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        q(k());
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0189 : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(k(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.r, R.color.CAM_X0204);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1);
                c.a.p0.a4.q0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                if (readThreadHistory != null && readThreadHistory.d(this.s.getThreadData().getId())) {
                    SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0108);
                } else {
                    SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
                }
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1);
                SkinManager.setViewTextColor(this.q, R.color.CAM_X0109, 1);
            }
            this.a = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || h() == null) {
            return;
        }
        h().a(k(), this.s);
    }

    public final void q(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            this.i = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f09051d);
            this.j = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f09051c);
            this.k = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090edb);
            this.l = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090ec8);
            this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090525);
            this.n = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090526);
            this.o = (ClickableHeaderImageView) view.findViewById(R.id.obfuscated_res_0x7f090523);
            this.p = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090505);
            this.q = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090504);
            this.r = view.findViewById(R.id.obfuscated_res_0x7f0904fd);
            this.k.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080858);
            int dimensionPixelSize = this.f15305c.getResources().getDimensionPixelSize(R.dimen.tbds326);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = (dimensionPixelSize * 9) / 16;
            this.j.setLayoutParams(layoutParams);
            this.o.setDefaultResource(17170445);
            this.o.setDefaultBgResource(R.color.CAM_X0205);
            this.o.setIsRound(true);
            this.o.setDrawBorder(true);
            this.o.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.o.setBorderWidth(this.f15305c.getResources().getDimensionPixelSize(R.dimen.tbds1));
            k().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: s */
    public void l(c.a.p0.o0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || bVar == null || bVar.getThreadData() == null) {
            return;
        }
        this.s = bVar;
        String str = null;
        if (bVar.getThreadData().isVideoThreadType()) {
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            if (bVar.getThreadData().getThreadVideoInfo() != null) {
                this.m.setText(StringHelper.stringForVideoTime(bVar.getThreadData().getThreadVideoInfo().video_duration.intValue() * 1000));
                str = bVar.getThreadData().getThreadVideoInfo().thumbnail_url;
            }
        } else {
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            if (bVar.getThreadData().getMedias() != null && bVar.getThreadData().getMedias().size() >= 1) {
                str = bVar.getThreadData().getMedias().get(0).origin_pic;
            }
        }
        this.k.J(str, 10, false);
        this.n.setText(bVar.getThreadData().getTitle());
        c.a.p0.a4.q0.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.d(bVar.getThreadData().getId())) {
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0108);
        } else {
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0105);
        }
        this.o.setData(bVar.getThreadData(), false);
        this.q.setText(StringHelper.getFormatTimeShort(bVar.getThreadData().getAuditTime()));
        if ("news".equals(bVar.getThreadData().getGameInformationSource())) {
            this.o.setVisibility(8);
            this.p.setText(this.f15304b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0e32, StringHelper.numberUniformFormat(bVar.getThreadData().getView_num())));
            return;
        }
        this.o.setVisibility(0);
        x(bVar.getThreadData());
    }

    public String t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? StringHelper.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE) : (String) invokeL.objValue;
    }

    public void u(int i) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (view = this.r) == null) {
            return;
        }
        view.setVisibility(i);
    }

    public void v(int i, int i2, int i3, int i4) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) || (linearLayout = this.i) == null) {
            return;
        }
        linearLayout.setPadding(i, i2, i3, i4);
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.o.setVisibility(i);
        }
    }

    public final void x(ThreadData threadData) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, threadData) == null) || (textView = this.p) == null || threadData == null) {
            return;
        }
        textView.setVisibility(0);
        if (StringUtils.isNull(threadData.getAuthor().getName_show())) {
            return;
        }
        this.p.setText(t(threadData.getAuthor().getName_show()));
    }
}

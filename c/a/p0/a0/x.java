package c.a.p0.a0;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.o0.s.q.c2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class x extends b<c2> implements c.a.p0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View m;
    public TbPageContext<?> n;
    public HeadImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public c2 s;
    public u t;
    public FrsBaseVideoView u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View j2 = j();
        j2.setOnClickListener(this);
        this.n = tbPageContext;
        HeadImageView headImageView = (HeadImageView) j2.findViewById(R.id.topic_icon);
        this.o = headImageView;
        headImageView.setIsRound(true);
        this.o.setDefaultResource(R.drawable.pic_head_topic);
        this.p = (TextView) j2.findViewById(R.id.card_topic_name);
        this.r = (TextView) j2.findViewById(R.id.card_thread_title);
        this.q = (TextView) j2.findViewById(R.id.card_reply_time);
        this.m = j2.findViewById(R.id.card_divider_line);
        FrsBaseVideoView frsBaseVideoView = (FrsBaseVideoView) j2.findViewById(R.id.base_video_view);
        this.u = frsBaseVideoView;
        frsBaseVideoView.setClickListener(this);
    }

    @Override // c.a.p0.a0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.frs_hottopic_video_card : invokeV.intValue;
    }

    @Override // c.a.p0.a0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.o.invalidate();
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
            SkinManager.setBackgroundResource(j(), R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            FrsBaseVideoView frsBaseVideoView = this.u;
            if (frsBaseVideoView != null) {
                frsBaseVideoView.onChangeSkinType(i2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.s == null) {
            return;
        }
        if (g() != null) {
            g().b(view, this.s, this.t);
        }
        m.a(this.s.q1());
        m.l(this.r, this.s.q1(), R.color.CAM_X0105, R.color.CAM_X0109);
        p();
    }

    public final void p() {
        c2 c2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (c2Var = this.s) == null || c2Var.J() == null || this.s.J().getName_show() == null) {
            return;
        }
        if (c.a.o0.r0.b.h(true) && !c.a.o0.r0.b.g()) {
            String name_show = this.s.J().getName_show();
            HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(d());
            HotTopicActivityConfig createNormalConfig = hotTopicActivityConfig.createNormalConfig("", name_show + "", "3");
            createNormalConfig.setExtra(this.s.T(), this.s.U(), this.s.W0(), c.a.e.e.m.b.f(this.s.q1(), 0L));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
            return;
        }
        UrlManager.getInstance().dealOneLink(this.n, new String[]{this.s.w1()});
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a0.b
    /* renamed from: q */
    public void k(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, c2Var) == null) {
            if (c2Var == null) {
                if (j() != null) {
                    j().setVisibility(8);
                    return;
                }
                return;
            }
            this.s = c2Var;
            if (j() != null) {
                j().setVisibility(0);
                j().setOnClickListener(this);
            }
            FrsBaseVideoView frsBaseVideoView = this.u;
            if (frsBaseVideoView != null) {
                frsBaseVideoView.onBindDataToView(this.s, c2Var.e0());
            }
            if (c2Var.J() != null) {
                this.p.setText(c2Var.J().getName_show());
            }
            this.q.setText(StringHelper.getFormatTime(c2Var.t0() * 1000));
            String str = c2Var.x1() + "：";
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.append((CharSequence) c2Var.P2(false, true));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
            this.r.setText(spannableStringBuilder);
            m.l(this.r, this.s.q1(), R.color.CAM_X0105, R.color.CAM_X0109);
            l(this.n, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.p0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }
}

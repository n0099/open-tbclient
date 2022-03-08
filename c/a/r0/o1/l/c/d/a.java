package c.a.r0.o1.l.c.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.q0.r.v.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends c.a.r0.f0.b<c.a.r0.o1.l.c.c.a> {
    public static /* synthetic */ Interceptable $ic;
    public static final int D;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView A;
    public c.a.r0.o1.l.c.c.a B;
    public final int C;
    public final View m;
    public int n;
    public CellTopicLinearLayout o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public RelativeLayout t;
    public TbImageView u;
    public View v;
    public TopicPkView w;
    public ThreadGodReplyLayout x;
    public View y;
    public RelativeLayout z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1332726486, "Lc/a/r0/o1/l/c/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1332726486, "Lc/a/r0/o1/l/c/d/a;");
                return;
            }
        }
        D = n.k(TbadkCoreApplication.getInst()) - ((n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 3;
        this.C = n.f(getContext(), R.dimen.M_W_X005);
        View j2 = j();
        this.o = (CellTopicLinearLayout) j2.findViewById(R.id.cell_topic_root);
        this.z = (RelativeLayout) j2.findViewById(R.id.cell_topic_top_layout);
        this.p = (TextView) j2.findViewById(R.id.cell_topic_index);
        this.q = (TextView) j2.findViewById(R.id.cell_topic_title);
        this.r = (TextView) j2.findViewById(R.id.cell_topic_partake);
        this.s = (TextView) j2.findViewById(R.id.cell_topic_des);
        this.t = (RelativeLayout) j2.findViewById(R.id.cell_topic_img_layout);
        this.u = (TbImageView) j2.findViewById(R.id.cell_topic_img);
        this.v = j2.findViewById(R.id.cell_topic_img_placeholder);
        this.w = (TopicPkView) j2.findViewById(R.id.cell_topic_pk);
        this.x = (ThreadGodReplyLayout) j2.findViewById(R.id.cell_topic_god_reply);
        this.y = j2.findViewById(R.id.cell_topic_img_mask);
        this.m = j2.findViewById(R.id.cell_topic_bottom_placeholder);
        HeadImageView headImageView = (HeadImageView) j2.findViewById(R.id.user_avatar);
        this.A = headImageView;
        headImageView.setIsRound(true);
        this.A.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.A.setDefaultResource(17170445);
        this.A.setPlaceHolder(1);
        s(this.z);
        s(this.s);
        s(this.x);
        s(this.m);
        s(this.u);
        s(this.y);
        int f2 = n.f(getContext(), R.dimen.tbds11);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.w.getLayoutParams();
        layoutParams.leftMargin = f2;
        layoutParams.rightMargin = f2;
        this.w.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.u.getLayoutParams();
        layoutParams2.height = ((n.k(getContext()) - n.f(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.u.setLayoutParams(layoutParams2);
        this.u.setRadiusById(R.string.J_X05);
        this.u.setConrers(15);
        this.u.setDrawCorner(true);
        this.u.setPlaceHolder(3);
    }

    @Override // c.a.r0.f0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.cell_topic_card_layout : invokeV.intValue;
    }

    @Override // c.a.r0.f0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.w.onChangeSkinType();
            this.x.onChangeSkinType();
            if (i2 == this.n) {
                return;
            }
            this.n = i2;
            SkinManager.setViewTextColor(this.p, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0105);
            this.u.setSkinType(this.n);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.r0.o1.l.c.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || (aVar = this.B) == null) {
            return;
        }
        if (aVar.d0 != 1) {
            TiebaStatic.log(new StatisticItem("c13351").param("topic_id", this.B.W).param("obj_locate", this.B.V));
        }
        if (this.B.d0 == 1) {
            TiebaStatic.log(new StatisticItem("c13449").param("topic_id", this.B.W));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(getContext(), this.B.W)));
    }

    public CellTopicLinearLayout p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.o : (CellTopicLinearLayout) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.f0.b
    /* renamed from: q */
    public void k(c.a.r0.o1.l.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        this.B = aVar;
        if (aVar.d0 == 0) {
            this.A.setVisibility(8);
            this.p.setVisibility(0);
            this.r.setVisibility(0);
            this.p.setText(String.valueOf(aVar.V));
            int i2 = aVar.V;
            if (i2 == 1) {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_one_bg);
            } else if (i2 == 2) {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_two_bg);
            } else if (i2 == 3) {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_three_bg);
            } else {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_other_bg);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            int f2 = n.f(getContext(), R.dimen.tbds16);
            layoutParams.addRule(1, R.id.cell_topic_index);
            layoutParams.setMargins(f2, 0, f2, 0);
            ThreadCardUtils.cutAndSetTextByMaxLine(this.s, aVar.Y, R.string.check_detail, R.dimen.tbds17, 2, D, true);
            if (aVar.Z == 0) {
                this.r.setText("NEW");
            } else {
                this.r.setText(String.format(this.f17261f.getString(R.string.topic_partake_default), StringHelper.numberUniformFormat(aVar.Z)));
            }
            if (aVar.c0 == null) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
                this.x.setData(aVar.c0);
            }
        } else {
            this.A.setVisibility(0);
            this.p.setVisibility(8);
            this.r.setVisibility(8);
            this.x.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            int f3 = n.f(getContext(), R.dimen.tbds30);
            int f4 = n.f(getContext(), R.dimen.tbds16);
            layoutParams2.addRule(1, R.id.user_avatar);
            layoutParams2.setMargins(f3, 0, f4, 0);
            this.q.setTextSize(0, n.f(this.f17262g, R.dimen.tbds40));
            c d2 = c.d(this.q);
            d2.v(R.color.CAM_X0105);
            d2.A(R.string.F_X01);
            if (StringUtils.isNull(aVar.Y)) {
                this.s.setVisibility(8);
            } else {
                this.s.setVisibility(0);
                ThreadCardUtils.setAbstractStyleAb(this.s);
                ThreadCardUtils.cutAndSetTextByMaxLine(this.s, aVar.Y, R.string.check_detail, R.dimen.tbds17, 2, D, true, false);
            }
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
        }
        String str = aVar.X;
        if (str.length() > 14) {
            str = str.substring(0, 13) + "...";
        }
        this.q.setText(String.format(this.f17261f.getString(R.string.daily_topic_name), str));
        if (StringUtils.isNull(aVar.a0)) {
            this.t.setVisibility(8);
            this.w.setUserColor(R.color.CAM_X0109);
        } else {
            this.t.setVisibility(0);
            this.u.setPlaceHolder(3);
            this.u.startLoad(aVar.a0, 10, false);
            this.w.setUserColor(R.color.CAM_X0101);
        }
        if (!StringUtils.isNull(aVar.e0)) {
            this.A.setVisibility(0);
            this.A.startLoad(aVar.e0, 10, false);
        }
        if (aVar.b0 == null) {
            this.v.setVisibility(8);
            this.w.setVisibility(8);
            this.y.setVisibility(8);
            return;
        }
        this.v.setVisibility(0);
        this.w.setVisibility(0);
        this.w.setData(aVar.b0);
        this.y.setVisibility(0);
    }

    public final void s(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i2 = this.C;
            marginLayoutParams.leftMargin = i2;
            marginLayoutParams.rightMargin = i2;
            view.setLayoutParams(marginLayoutParams);
        }
    }
}

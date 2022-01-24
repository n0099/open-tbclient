package c.a.t0.u1.b.p;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.t0.g0.d0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.imMessageCenter.mention.base.MessageCardBottomView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c extends c.a.t0.g0.b<c.a.t0.u1.b.p.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.t0.u1.b.p.a A;
    public String B;
    public int C;
    public int D;
    public OriginalThreadCardView.b E;
    public HeadImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public View q;
    public TextView r;
    public TextView s;
    public View t;
    public TextView u;
    public OriginalThreadCardView v;
    public MessageCardBottomView w;
    public View x;
    public TbPageContext y;
    public int z;

    /* loaded from: classes8.dex */
    public class a implements OriginalThreadCardView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tieba.card.OriginalThreadCardView.b
        public void a(OriginalThreadInfo originalThreadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, originalThreadInfo) == null) {
                if (this.a.A != null && this.a.A.x() != null) {
                    StatisticItem param = new StatisticItem(this.a.A.x()).param("obj_locate", 2);
                    if (this.a.A.getType() != c.a.t0.u1.b.p.a.B && this.a.A.getType() != c.a.t0.u1.b.p.a.x) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (this.a.g() != null) {
                    d0<c.a.t0.u1.b.p.a> g2 = this.a.g();
                    c cVar = this.a;
                    g2.a(cVar.v, cVar.A);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.z = 3;
        this.E = new a(this);
        this.y = tbPageContext;
        this.C = n.f(tbPageContext.getContext(), R.dimen.tbds42);
        this.D = n.f(this.y.getContext(), R.dimen.tbds48);
        s();
    }

    @Override // c.a.t0.g0.b
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_message_layout : invokeV.intValue;
    }

    @Override // c.a.t0.g0.b
    public void l(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.z == i2) {
            return;
        }
        this.z = i2;
        j().setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.o, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0110);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0107);
        OriginalThreadCardView originalThreadCardView = this.v;
        if (originalThreadCardView != null) {
            originalThreadCardView.onChangeSkinType();
        }
        MessageCardBottomView messageCardBottomView = this.w;
        if (messageCardBottomView != null) {
            messageCardBottomView.onChangeSkinType();
        }
        SkinManager.setBackgroundResource(this.x, R.drawable.icon_news_red_dot);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (this.A == null && this.y == null) {
                return;
            }
            if (view == this.m || view == this.n) {
                if (this.A.w() == null) {
                    return;
                }
                String userId = this.A.w().getUserId();
                String userName = this.A.w().getUserName();
                if (userId != null && userId.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.y.getContext(), userId, userName)));
                }
            }
            if (g() != null) {
                g().a(view, this.A);
            }
        }
    }

    public final CharSequence q(TextView textView, SpannableString spannableString) {
        InterceptResult invokeLL;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, textView, spannableString)) == null) {
            if (textView == null || spannableString == null || (tbPageContext = this.y) == null) {
                return null;
            }
            return TextUtils.ellipsize(spannableString, textView.getPaint(), ((n.k(tbPageContext.getPageActivity()) - (this.y.getResources().getDimensionPixelSize(R.dimen.ds30) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View j2 = j();
            this.m = (HeadImageView) j2.findViewById(R.id.photo);
            this.n = (TextView) j2.findViewById(R.id.user_name);
            this.o = (TextView) j2.findViewById(R.id.fans_reply);
            this.p = (TextView) j2.findViewById(R.id.post_from);
            this.q = j2.findViewById(R.id.divider_between_time_and_post_from);
            this.r = (TextView) j2.findViewById(R.id.time);
            this.s = (TextView) j2.findViewById(R.id.card_message_title);
            this.t = j2.findViewById(R.id.card_message_divider_line);
            this.u = (TextView) j2.findViewById(R.id.card_message_post_title);
            this.v = (OriginalThreadCardView) j2.findViewById(R.id.original_thread_view);
            this.w = (MessageCardBottomView) j2.findViewById(R.id.card_message_bottom_layout);
            this.x = j2.findViewById(R.id.new_message);
            this.v.setUsePlaceHolder(false);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.w.getReplyContainer().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.g0.b
    /* renamed from: t */
    public void k(c.a.t0.u1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || aVar.w() == null) {
            return;
        }
        this.A = aVar;
        MetaData w = aVar.w();
        this.m.setVisibility(0);
        boolean z = true;
        this.m.setPlaceHolder(1);
        this.m.setIsRound(true);
        UtilHelper.showHeadImageViewBigV(this.m, w, 0);
        this.m.setTag(null);
        this.m.setPageId(this.y.getUniqueId());
        this.m.startLoad(aVar.w().getAvater(), 12, false);
        this.n.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(w), 14, "..."));
        if (aVar.w().getIsMyFans() == 1) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
        if (!m.isEmpty(aVar.p())) {
            this.q.setVisibility(0);
            this.p.setVisibility(0);
            this.p.setText(aVar.p());
        } else {
            this.q.setVisibility(8);
            this.p.setVisibility(8);
        }
        this.r.setText(StringHelper.getFormatTime(aVar.C()));
        TextView textView = this.s;
        TbFaceManager e2 = TbFaceManager.e();
        Context applicationContext = this.y.getPageActivity().getApplicationContext();
        String title = aVar.getTitle();
        int i2 = this.D;
        textView.setText(q(textView, e2.k(applicationContext, title, i2, i2)));
        if (m.isEmpty(aVar.y())) {
            this.t.setVisibility(8);
            this.u.setVisibility(8);
        } else {
            TextView textView2 = this.u;
            TbFaceManager e3 = TbFaceManager.e();
            Context applicationContext2 = this.y.getPageActivity().getApplicationContext();
            String y = aVar.y();
            int i3 = this.C;
            textView2.setText(q(textView2, e3.k(applicationContext2, y, i3, i3)));
            this.u.setVisibility(0);
            this.t.setVisibility(0);
        }
        this.v.setCardFrom(this.B);
        this.v.fillData(aVar.o());
        this.v.setSubClickListener(this.E);
        this.w.setData(aVar.i(), (aVar.getType() == c.a.t0.u1.b.p.a.x || aVar.getType() == c.a.t0.u1.b.p.a.y) ? false : false);
        if (aVar.E()) {
            this.x.setVisibility(0);
        } else {
            this.x.setVisibility(8);
        }
        l(this.y, TbadkCoreApplication.getInst().getSkinType());
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.B = str;
        }
    }
}

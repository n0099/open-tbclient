package c.a.p0.v1.b.p;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.p0.h0.b0;
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
/* loaded from: classes2.dex */
public class c extends c.a.p0.h0.b<c.a.p0.v1.b.p.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OriginalThreadCardView.b A;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public TextView n;
    public TextView o;
    public View p;
    public TextView q;
    public OriginalThreadCardView r;
    public MessageCardBottomView s;
    public View t;
    public TbPageContext u;
    public int v;
    public c.a.p0.v1.b.p.a w;
    public String x;
    public int y;
    public int z;

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (this.a.w != null && this.a.w.s() != null) {
                    StatisticItem param = new StatisticItem(this.a.w.s()).param("obj_locate", 2);
                    if (this.a.w.getType() != c.a.p0.v1.b.p.a.x && this.a.w.getType() != c.a.p0.v1.b.p.a.t) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (this.a.h() != null) {
                    b0<c.a.p0.v1.b.p.a> h2 = this.a.h();
                    c cVar = this.a;
                    h2.a(cVar.r, cVar.w);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = 3;
        this.A = new a(this);
        this.u = tbPageContext;
        this.y = n.f(tbPageContext.getContext(), R.dimen.tbds42);
        this.z = n.f(this.u.getContext(), R.dimen.tbds48);
        t();
    }

    @Override // c.a.p0.h0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01ab : invokeV.intValue;
    }

    @Override // c.a.p0.h0.b
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) || this.v == i) {
            return;
        }
        this.v = i;
        k().setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.k, R.drawable.btn_rounded_corner_gray_frame_transparent_thin);
        SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0110);
        SkinManager.setViewTextColor(this.o, (int) R.color.CAM_X0105);
        SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.q, (int) R.color.CAM_X0107);
        OriginalThreadCardView originalThreadCardView = this.r;
        if (originalThreadCardView != null) {
            originalThreadCardView.p();
        }
        MessageCardBottomView messageCardBottomView = this.s;
        if (messageCardBottomView != null) {
            messageCardBottomView.b();
        }
        SkinManager.setBackgroundResource(this.t, R.drawable.icon_news_red_dot);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (this.w == null && this.u == null) {
                return;
            }
            if (view == this.i || view == this.j) {
                if (this.w.r() == null) {
                    return;
                }
                String userId = this.w.r().getUserId();
                String userName = this.w.r().getUserName();
                if (userId != null && userId.length() > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.u.getContext(), userId, userName)));
                }
            }
            if (h() != null) {
                h().a(view, this.w);
            }
        }
    }

    public final CharSequence s(TextView textView, SpannableString spannableString) {
        InterceptResult invokeLL;
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, textView, spannableString)) == null) {
            if (textView == null || spannableString == null || (tbPageContext = this.u) == null) {
                return null;
            }
            return TextUtils.ellipsize(spannableString, textView.getPaint(), ((n.k(tbPageContext.getPageActivity()) - (this.u.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201) * 2)) - textView.getCompoundPaddingLeft()) * 2.0f, TextUtils.TruncateAt.END);
        }
        return (CharSequence) invokeLL.objValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View k = k();
            this.i = (HeadImageView) k.findViewById(R.id.obfuscated_res_0x7f091827);
            this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0922bb);
            this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090974);
            this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0918b0);
            this.m = k.findViewById(R.id.obfuscated_res_0x7f0907e9);
            this.n = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091ffb);
            this.o = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090558);
            this.p = k.findViewById(R.id.obfuscated_res_0x7f090555);
            this.q = (TextView) k.findViewById(R.id.obfuscated_res_0x7f090557);
            this.r = (OriginalThreadCardView) k.findViewById(R.id.obfuscated_res_0x7f091622);
            this.s = (MessageCardBottomView) k.findViewById(R.id.obfuscated_res_0x7f090554);
            this.t = k.findViewById(R.id.obfuscated_res_0x7f09154d);
            this.r.setUsePlaceHolder(false);
            this.i.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.s.getReplyContainer().setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.h0.b
    /* renamed from: u */
    public void l(c.a.p0.v1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || aVar.r() == null) {
            return;
        }
        this.w = aVar;
        MetaData r = aVar.r();
        this.i.setVisibility(0);
        boolean z = true;
        this.i.setPlaceHolder(1);
        this.i.setIsRound(true);
        UtilHelper.showHeadImageViewBigV(this.i, r, 0);
        this.i.setTag(null);
        this.i.setPageId(this.u.getUniqueId());
        this.i.J(aVar.r().getAvater(), 12, false);
        this.j.setText(StringHelper.cutChineseAndEnglishWithSuffix(UtilHelper.getUserName(r), 14, StringHelper.STRING_MORE));
        if (aVar.r().getIsMyFans() == 1) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(8);
        }
        if (!m.isEmpty(aVar.k())) {
            this.m.setVisibility(0);
            this.l.setVisibility(0);
            this.l.setText(aVar.k());
        } else {
            this.m.setVisibility(8);
            this.l.setVisibility(8);
        }
        this.n.setText(StringHelper.getFormatTime(aVar.getTime()));
        TextView textView = this.o;
        TbFaceManager e2 = TbFaceManager.e();
        Context applicationContext = this.u.getPageActivity().getApplicationContext();
        String title = aVar.getTitle();
        int i = this.z;
        textView.setText(s(textView, e2.k(applicationContext, title, i, i)));
        if (m.isEmpty(aVar.v())) {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        } else {
            TextView textView2 = this.q;
            TbFaceManager e3 = TbFaceManager.e();
            Context applicationContext2 = this.u.getPageActivity().getApplicationContext();
            String v = aVar.v();
            int i2 = this.y;
            textView2.setText(s(textView2, e3.k(applicationContext2, v, i2, i2)));
            this.q.setVisibility(0);
            this.p.setVisibility(0);
        }
        this.r.setCardFrom(this.x);
        this.r.g(aVar.i());
        this.r.setSubClickListener(this.A);
        this.s.setData(aVar.e(), (aVar.getType() == c.a.p0.v1.b.p.a.t || aVar.getType() == c.a.p0.v1.b.p.a.u) ? false : false);
        if (aVar.A()) {
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
        m(this.u, TbadkCoreApplication.getInst().getSkinType());
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.x = str;
        }
    }
}

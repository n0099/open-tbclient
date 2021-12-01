package c.a.r0.q2.u.f.b1;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f21799b;

    /* renamed from: c  reason: collision with root package name */
    public EMTextView f21800c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f21801d;

    /* renamed from: e  reason: collision with root package name */
    public String f21802e;

    /* renamed from: f  reason: collision with root package name */
    public int f21803f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f21804e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f21805f;

        public a(g gVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21805f = gVar;
            this.f21804e = tbPageContext;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> tbPageContext = this.f21804e;
                urlManager.dealOneLink(tbPageContext, new String[]{"http://tieba.baidu.com/mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1&postId=" + this.f21805f.f21802e});
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_UEG_POST_CLICKED).param("obj_locate", this.f21805f.f21803f));
            }
        }
    }

    public g(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c(pbFragment.getPageContext());
    }

    public void b(BdTypeListView bdTypeListView, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bdTypeListView, i2) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.a, i2);
    }

    public final void c(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) && this.a == null) {
            this.a = (FrameLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(c.a.r0.q2.j.pb_head_ueg_layout, (ViewGroup) null);
            h(tbPageContext);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f21799b);
            d2.n(c.a.r0.q2.l.J_X05);
            d2.f(c.a.r0.q2.f.CAM_X0206);
            SkinManager.setViewTextColor(this.f21800c, c.a.r0.q2.f.CAM_X0109);
            SkinManager.setViewTextColor(this.f21801d, c.a.r0.q2.f.CAM_X0109);
        }
    }

    public void e(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.a);
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f21802e = str;
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.a.setVisibility(i2);
        }
    }

    public final void h(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tbPageContext) == null) {
            this.f21799b = (LinearLayout) this.a.findViewById(c.a.r0.q2.i.container);
            this.f21800c = (EMTextView) this.a.findViewById(c.a.r0.q2.i.tv_title);
            this.f21801d = (EMTextView) this.a.findViewById(c.a.r0.q2.i.tv_content);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f21800c);
            d2.v(c.a.r0.q2.f.CAM_X0109);
            d2.A(c.a.r0.q2.l.F_X01);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.f21801d);
            d3.w(c.a.r0.q2.g.M_H_X003);
            d3.v(c.a.r0.q2.f.CAM_X0109);
            d3.A(c.a.r0.q2.l.F_X01);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tbPageContext.getResources().getString(c.a.r0.q2.l.pb_head_block_title));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(c.a.r0.q2.h.icon_pure_barrules_careful12, c.a.r0.q2.f.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan.f(c.a.d.f.p.l.f(tbPageContext.getContext(), c.a.r0.q2.g.tbds31));
            eMRichTextAnyIconSpan.d(c.a.d.f.p.l.f(tbPageContext.getContext(), c.a.r0.q2.g.M_W_X002));
            eMRichTextAnyIconSpan.b(0);
            spannableStringBuilder.setSpan(eMRichTextAnyIconSpan, 0, 1, 33);
            this.f21800c.setText(spannableStringBuilder);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(tbPageContext.getResources().getString(c.a.r0.q2.l.pb_head_block_content));
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan2 = new EMRichTextAnyIconSpan(c.a.r0.q2.h.icon_pure_arrow12_right_n, c.a.r0.q2.f.CAM_X0109, EMRichTextAnyIconSpan.IconType.WEBP);
            eMRichTextAnyIconSpan2.b(c.a.d.f.p.l.f(tbPageContext.getContext(), c.a.r0.q2.g.tbds3));
            spannableStringBuilder2.setSpan(eMRichTextAnyIconSpan2, spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 33);
            this.f21801d.setText(spannableStringBuilder2);
            this.f21799b.setOnClickListener(new a(this, tbPageContext));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(AbsVideoPbFragment absVideoPbFragment, FrameLayout frameLayout) {
        this(absVideoPbFragment.getPageContext(), frameLayout);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoPbFragment, frameLayout};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (FrameLayout) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public g(TbPageContext<?> tbPageContext, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, frameLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = frameLayout;
        h(tbPageContext);
    }
}

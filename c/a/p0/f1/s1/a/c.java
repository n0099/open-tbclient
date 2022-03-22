package c.a.p0.f1.s1.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.d.o.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailItemVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends c.a.d.o.e.a<c.a.p0.f1.s1.c.c, ForumRuleDetailItemVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context i;
    public TbRichText j;
    public List<n> k;

    /* loaded from: classes2.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f14513b;

        public a(c cVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14513b = cVar;
            this.a = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f14513b.k != null) {
                    n nVar = (n) this.f14513b.k.get(this.a);
                    if (nVar instanceof c.a.p0.f1.s1.c.c) {
                        c.a.d.f.p.c.a(TbRichTextView.X(((c.a.p0.f1.s1.c.c) nVar).b(), false).toString());
                        c.a.d.f.p.n.M(this.f14513b.i, R.string.obfuscated_res_0x7f0f0695);
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, c.a.p0.f1.s1.c.c cVar, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        c0(i, view, viewGroup, cVar, forumRuleDetailItemVH);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public ForumRuleDetailItemVH M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ForumRuleDetailItemVH forumRuleDetailItemVH = new ForumRuleDetailItemVH(this.i, LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d02c6, viewGroup, false));
            this.f2573g = forumRuleDetailItemVH;
            return forumRuleDetailItemVH;
        }
        return (ForumRuleDetailItemVH) invokeL.objValue;
    }

    public View c0(int i, View view, ViewGroup viewGroup, c.a.p0.f1.s1.c.c cVar, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, cVar, forumRuleDetailItemVH})) == null) {
            if (cVar != null && this.i != null) {
                forumRuleDetailItemVH.e(cVar.a());
                if (!StringUtils.isNull(cVar.e())) {
                    z = true;
                    forumRuleDetailItemVH.f32500c.setVisibility(0);
                    forumRuleDetailItemVH.f32500c.setText(cVar.e());
                } else {
                    forumRuleDetailItemVH.f32500c.setVisibility(8);
                    z = false;
                }
                if (cVar.b() != null && !StringUtils.isNull(cVar.b().toString())) {
                    forumRuleDetailItemVH.f32501d.setVisibility(0);
                    if (!z) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) forumRuleDetailItemVH.f32501d.getLayoutParams();
                        layoutParams.topMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                        forumRuleDetailItemVH.f32501d.setLayoutParams(layoutParams);
                    }
                    TbRichText X = TbRichTextView.X(cVar.b(), false);
                    this.j = X;
                    forumRuleDetailItemVH.f32501d.setText(X);
                } else {
                    forumRuleDetailItemVH.f32501d.setVisibility(8);
                }
                forumRuleDetailItemVH.f32501d.setOnLongClickListener(new a(this, i));
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.k = list;
        }
    }
}

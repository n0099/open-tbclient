package c.a.t0.e1.c2.a;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.d.n.e.n;
import c.a.t0.e1.d1;
import c.a.t0.e1.g1;
import c.a.t0.e1.i1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailItemVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class c extends c.a.d.n.e.a<c.a.t0.e1.c2.c.c, ForumRuleDetailItemVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context m;
    public TbRichText n;
    public List<n> o;

    /* loaded from: classes7.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f16181e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f16182f;

        public a(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16182f = cVar;
            this.f16181e = i2;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f16182f.o != null) {
                    n nVar = (n) this.f16182f.o.get(this.f16181e);
                    if (nVar instanceof c.a.t0.e1.c2.c.c) {
                        TbRichText parser = TbRichTextView.parser(((c.a.t0.e1.c2.c.c) nVar).d(), false);
                        ClipboardManager clipboardManager = (ClipboardManager) this.f16182f.m.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                        clipboardManager.setText(parser.toString());
                        if (clipboardManager.getText() != null) {
                            c.a.d.f.p.n.M(this.f16182f.m, i1.forum_rules_copy_clip);
                        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, c.a.t0.e1.c2.c.c cVar, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        c0(i2, view, viewGroup, cVar, forumRuleDetailItemVH);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public ForumRuleDetailItemVH M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ForumRuleDetailItemVH forumRuleDetailItemVH = new ForumRuleDetailItemVH(this.m, LayoutInflater.from(this.m).inflate(g1.forum_rules_item, viewGroup, false));
            this.k = forumRuleDetailItemVH;
            return forumRuleDetailItemVH;
        }
        return (ForumRuleDetailItemVH) invokeL.objValue;
    }

    public View c0(int i2, View view, ViewGroup viewGroup, c.a.t0.e1.c2.c.c cVar, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, forumRuleDetailItemVH})) == null) {
            if (cVar != null && this.m != null) {
                forumRuleDetailItemVH.setCurrentStatus(cVar.a());
                if (!StringUtils.isNull(cVar.e())) {
                    z = true;
                    forumRuleDetailItemVH.mTitle.setVisibility(0);
                    forumRuleDetailItemVH.mTitle.setText(cVar.e());
                } else {
                    forumRuleDetailItemVH.mTitle.setVisibility(8);
                    z = false;
                }
                if (cVar.d() != null && !StringUtils.isNull(cVar.d().toString())) {
                    forumRuleDetailItemVH.mContent.setVisibility(0);
                    if (!z) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) forumRuleDetailItemVH.mContent.getLayoutParams();
                        layoutParams.topMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), d1.tbds0);
                        forumRuleDetailItemVH.mContent.setLayoutParams(layoutParams);
                    }
                    TbRichText parser = TbRichTextView.parser(cVar.d(), false);
                    this.n = parser;
                    forumRuleDetailItemVH.mContent.setText(parser);
                } else {
                    forumRuleDetailItemVH.mContent.setVisibility(8);
                }
                forumRuleDetailItemVH.mContent.setOnLongClickListener(new a(this, i2));
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.o = list;
        }
    }
}

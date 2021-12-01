package c.a.r0.d1.b2.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.d1.e1;
import c.a.r0.d1.g1;
import c.a.r0.d1.i1;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailBottomVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends c.a.d.m.e.a<c.a.r0.d1.b2.c.a, ForumRuleDetailBottomVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context m;
    public String n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, BdUniqueId bdUniqueId) {
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
    @Override // c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, c.a.r0.d1.b2.c.a aVar, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        j0(i2, view, viewGroup, aVar, forumRuleDetailBottomVH);
        return view;
    }

    public final void g0(ForumRuleDetailBottomVH forumRuleDetailBottomVH, c.a.r0.d1.b2.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumRuleDetailBottomVH, aVar) == null) || forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.mBarManagementHeadView.setDefaultBgResource(e1.img_default_100);
        forumRuleDetailBottomVH.mBarManagementHeadView.startLoad(aVar.a(), 10, false);
        String string = TbadkApplication.getInst().getResources().getString(i1.forum_rules_bar_management_group);
        EMTextView eMTextView = forumRuleDetailBottomVH.mBarManagementTitle;
        eMTextView.setText(aVar.d() + string);
        forumRuleDetailBottomVH.mChargerOfBarHeadView.setDefaultBgResource(e1.img_default_100);
        forumRuleDetailBottomVH.mChargerOfBarHeadView.startLoad(aVar.g(), 12, false);
        forumRuleDetailBottomVH.mChargerOfBarTitle.setText(aVar.e());
        if (ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.n)) {
            forumRuleDetailBottomVH.onChangeReviseTimeSkinType(String.valueOf(System.currentTimeMillis() / 1000));
        } else {
            forumRuleDetailBottomVH.mTimeRevise.setText(String.format(TbadkApplication.getInst().getString(i1.forum_rules_revise_time), aVar.h()));
            forumRuleDetailBottomVH.mBarManagementRevise.setText(String.format(TbadkApplication.getInst().getString(i1.forum_rules_revise_time), aVar.h()));
        }
        forumRuleDetailBottomVH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void h0(ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, forumRuleDetailBottomVH) == null) || forumRuleDetailBottomVH == null) {
            return;
        }
        forumRuleDetailBottomVH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: i0 */
    public ForumRuleDetailBottomVH S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ForumRuleDetailBottomVH forumRuleDetailBottomVH = new ForumRuleDetailBottomVH(LayoutInflater.from(this.m).inflate(g1.forum_rules_bottom, viewGroup, false));
            h0(forumRuleDetailBottomVH);
            this.f2913k = forumRuleDetailBottomVH;
            return forumRuleDetailBottomVH;
        }
        return (ForumRuleDetailBottomVH) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, c.a.r0.d1.b2.c.a aVar, ForumRuleDetailBottomVH forumRuleDetailBottomVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, forumRuleDetailBottomVH})) == null) {
            if (aVar != null) {
                g0(forumRuleDetailBottomVH, aVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.n = str;
        }
    }
}

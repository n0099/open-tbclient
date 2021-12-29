package c.a.t0.q1.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.holder.HotTopicPkItemHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class g extends c.a.d.n.e.a<c.a.t0.q1.l.i, HotTopicPkItemHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public HotTopicActivity n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotTopicActivity, bdUniqueId};
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
        this.n = hotTopicActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.n.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, c.a.t0.q1.l.i iVar, HotTopicPkItemHolder hotTopicPkItemHolder) {
        c0(i2, view, viewGroup, iVar, hotTopicPkItemHolder);
        return view;
    }

    public final void Z(HotTopicPkItemHolder hotTopicPkItemHolder, c.a.t0.q1.l.i iVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hotTopicPkItemHolder, iVar) == null) || hotTopicPkItemHolder == null || iVar == null) {
            return;
        }
        hotTopicPkItemHolder.moduleName.setText(StringUtils.isNull(iVar.f22155e) ? this.n.getResources().getString(c.a.t0.q1.h.pk_topic_default) : iVar.f22155e.trim());
        hotTopicPkItemHolder.pkQuesDesc.setText(StringHelper.cutStringWithSuffix(iVar.f22156f.trim(), 32, "..."));
        hotTopicPkItemHolder.pkQuesDesc.setText(iVar.f22156f.trim());
        hotTopicPkItemHolder.pkView.setData(iVar, this.n);
        hotTopicPkItemHolder.pkPositive.setText(iVar.f22157g.trim());
        hotTopicPkItemHolder.pkOpposing.setText(iVar.f22159i.trim());
    }

    public final void a0(HotTopicPkItemHolder hotTopicPkItemHolder, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, hotTopicPkItemHolder, view) == null) || hotTopicPkItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (this.n == null || hotTopicPkItemHolder.skinType == skinType) {
            return;
        }
        hotTopicPkItemHolder.skinType = skinType;
        SkinManager.setBackgroundColor(hotTopicPkItemHolder.getView(), c.a.t0.q1.b.CAM_X0201);
        this.n.getLayoutMode().k(this.m == 1);
        this.n.getLayoutMode().j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public HotTopicPkItemHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new HotTopicPkItemHolder(LayoutInflater.from(this.f3299e).inflate(c.a.t0.q1.f.hot_topic_pk_item, viewGroup, false)) : (HotTopicPkItemHolder) invokeL.objValue;
    }

    public View c0(int i2, View view, ViewGroup viewGroup, c.a.t0.q1.l.i iVar, HotTopicPkItemHolder hotTopicPkItemHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, iVar, hotTopicPkItemHolder})) == null) {
            if (iVar != null && hotTopicPkItemHolder != null) {
                a0(hotTopicPkItemHolder, view);
                Z(hotTopicPkItemHolder, iVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}

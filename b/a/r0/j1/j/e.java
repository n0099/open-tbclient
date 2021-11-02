package b.a.r0.j1.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.holder.HotTopicIntervalItemHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e extends b.a.e.l.e.a<b.a.r0.j1.l.g, HotTopicIntervalItemHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
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
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // b.a.e.l.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.j1.l.g gVar, HotTopicIntervalItemHolder hotTopicIntervalItemHolder) {
        j0(i2, view, viewGroup, gVar, hotTopicIntervalItemHolder);
        return view;
    }

    public final void g0(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, b.a.r0.j1.l.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hotTopicIntervalItemHolder, gVar) == null) {
            if (hotTopicIntervalItemHolder != null && gVar != null && !StringUtils.isNull(gVar.f18453e)) {
                hotTopicIntervalItemHolder.moduleTheme.setVisibility(0);
                hotTopicIntervalItemHolder.moduleTheme.setText(gVar.f18453e);
            } else if (hotTopicIntervalItemHolder != null) {
                hotTopicIntervalItemHolder.moduleTheme.setVisibility(8);
            }
        }
    }

    public final void h0(HotTopicIntervalItemHolder hotTopicIntervalItemHolder, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, hotTopicIntervalItemHolder, view) == null) || hotTopicIntervalItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotTopicIntervalItemHolder.skinType != skinType) {
            hotTopicIntervalItemHolder.skinType = skinType;
            SkinManager.setBackgroundColor(hotTopicIntervalItemHolder.getView(), b.a.r0.j1.b.CAM_X0201);
            SkinManager.setBackgroundColor(hotTopicIntervalItemHolder.topDivilerLine, b.a.r0.j1.b.CAM_X0204);
            SkinManager.setViewTextColor(hotTopicIntervalItemHolder.moduleTheme, b.a.r0.j1.b.CAM_X0108, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: i0 */
    public HotTopicIntervalItemHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new HotTopicIntervalItemHolder(LayoutInflater.from(this.f2419e).inflate(b.a.r0.j1.f.hot_topic_interval, viewGroup, false)) : (HotTopicIntervalItemHolder) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, b.a.r0.j1.l.g gVar, HotTopicIntervalItemHolder hotTopicIntervalItemHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, hotTopicIntervalItemHolder})) == null) {
            if (gVar != null && hotTopicIntervalItemHolder != null) {
                h0(hotTopicIntervalItemHolder, view);
                g0(hotTopicIntervalItemHolder, gVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}

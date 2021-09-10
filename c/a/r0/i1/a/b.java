package c.a.r0.i1.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import com.baidu.tieba.hottopic.holder.HotRankListManualItemHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes3.dex */
public class b extends c.a.e.l.e.a<c.a.r0.i1.c.b, HotRankListManualItemHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.i1.c.b f19161e;

        public a(b bVar, c.a.r0.i1.c.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19161e = bVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(view.getContext()).createNormalConfig(String.valueOf(this.f19161e.b()), this.f19161e.d(), "5")));
                StatisticItem statisticItem = new StatisticItem("c10811");
                TiebaStatic.log(statisticItem.param("obj_name", "" + this.f19161e.d()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(HotRanklistActivity hotRanklistActivity, BdUniqueId bdUniqueId) {
        super(hotRanklistActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hotRanklistActivity, bdUniqueId};
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
    @Override // c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.i1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        k0(i2, view, viewGroup, bVar, hotRankListManualItemHolder);
        return view;
    }

    public final void h0(HotRankListManualItemHolder hotRankListManualItemHolder, c.a.r0.i1.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, hotRankListManualItemHolder, bVar) == null) || hotRankListManualItemHolder == null || bVar == null) {
            return;
        }
        String string = StringUtils.isNull(bVar.c()) ? this.f2957e.getResources().getString(R.string.hot_topic_hot_trend) : bVar.c();
        hotRankListManualItemHolder.topicDesc.setText(bVar.g());
        hotRankListManualItemHolder.topicModule.setText(string);
        hotRankListManualItemHolder.topicPic.startLoad(bVar.h(), 10, false);
        if (StringUtils.isNull(bVar.d())) {
            hotRankListManualItemHolder.topicNeme.setVisibility(8);
            hotRankListManualItemHolder.topicDesc.setPadding(0, 0, 0, 0);
        } else {
            hotRankListManualItemHolder.topicNeme.setVisibility(0);
            hotRankListManualItemHolder.topicNeme.setText(bVar.d());
        }
        hotRankListManualItemHolder.topicManualItem.setOnClickListener(new a(this, bVar));
    }

    public final void i0(HotRankListManualItemHolder hotRankListManualItemHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hotRankListManualItemHolder) == null) || hotRankListManualItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (hotRankListManualItemHolder.skinType != skinType) {
            hotRankListManualItemHolder.skinType = skinType;
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.getView(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.topicModule, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.topicNeme, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(hotRankListManualItemHolder.topicDesc, R.color.CAM_X0108, 1);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.dividerLineTop, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(hotRankListManualItemHolder.dividerLineBottom, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(hotRankListManualItemHolder.topicManualItem, R.drawable.hot_topic_ranklist_bg);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public HotRankListManualItemHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new HotRankListManualItemHolder(LayoutInflater.from(this.f2957e).inflate(R.layout.hot_topic_ranklist_head, viewGroup, false)) : (HotRankListManualItemHolder) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, c.a.r0.i1.c.b bVar, HotRankListManualItemHolder hotRankListManualItemHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, hotRankListManualItemHolder})) == null) {
            if (bVar != null) {
                i0(hotRankListManualItemHolder);
                h0(hotRankListManualItemHolder, bVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}

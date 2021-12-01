package c.a.r0.p1.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.m.e.n;
import c.a.d.m.e.w;
import c.a.r0.p1.l.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.holder.QualityThreadItemHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i extends c.a.d.m.e.a<m, QualityThreadItemHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public HotTopicActivity n;
    public b o;
    public w p;

    /* loaded from: classes6.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f21058e;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21058e = iVar;
        }

        @Override // c.a.d.m.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && nVar != null && (nVar instanceof m)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                this.f21058e.i0((m) nVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f21059e;

        /* renamed from: f  reason: collision with root package name */
        public String f21060f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ i f21061g;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21061g = iVar;
        }

        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                this.f21059e = str;
                this.f21060f = str2;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) && c.a.d.f.p.k.isForumName(this.f21059e)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f21061g.f2907e).createNormalCfg(this.f21059e, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new StatisticItem("c10523").param("fid", this.f21060f));
            }
        }

        public /* synthetic */ b(i iVar, a aVar) {
            this(iVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
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
        this.o = new b(this, null);
        this.p = new a(this);
        this.n = hotTopicActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, m mVar, QualityThreadItemHolder qualityThreadItemHolder) {
        m0(i2, view, viewGroup, mVar, qualityThreadItemHolder);
        return view;
    }

    public final void i0(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mVar) == null) || mVar == null || mVar.a()) {
            return;
        }
        String valueOf = String.valueOf(mVar.f21177g);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.n.getActivity()).createNormalCfg(valueOf, String.valueOf(mVar.n), "hot_topic")));
        TiebaStatic.log(new StatisticItem("c10522").param("tid", valueOf).param("obj_id", this.n.getHotTopicId()));
    }

    public final void j0(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, qualityThreadItemHolder, mVar) == null) || qualityThreadItemHolder == null || mVar == null) {
            return;
        }
        if (mVar.a()) {
            qualityThreadItemHolder.topDivilerLine.setVisibility(0);
            qualityThreadItemHolder.moduleTheme.setVisibility(0);
            qualityThreadItemHolder.contentDividerLine.setVisibility(8);
            qualityThreadItemHolder.threadView.setVisibility(8);
            qualityThreadItemHolder.moduleTheme.setText(mVar.f21176f.trim());
            SkinManager.setBackgroundColor(qualityThreadItemHolder.getView(), c.a.r0.p1.b.CAM_X0201);
            return;
        }
        qualityThreadItemHolder.topDivilerLine.setVisibility(8);
        qualityThreadItemHolder.moduleTheme.setVisibility(8);
        qualityThreadItemHolder.contentDividerLine.setVisibility(0);
        qualityThreadItemHolder.threadView.setVisibility(0);
        qualityThreadItemHolder.threadImg.startLoad(mVar.o, 10, false);
        qualityThreadItemHolder.titleView.setText(mVar.f21178h.trim());
        qualityThreadItemHolder.descView.setText(mVar.f21180j.trim());
        qualityThreadItemHolder.frsNameView.setText(TbadkCoreApplication.getInst().getString(c.a.r0.p1.h.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.l, 7, false)}));
        qualityThreadItemHolder.zanTextView.setText(StringHelper.numberUniformFormat(mVar.f21181k));
        qualityThreadItemHolder.replyTextView.setText(StringHelper.numFormatOver10000(mVar.f21179i));
        n0(qualityThreadItemHolder, mVar);
    }

    public final void k0(QualityThreadItemHolder qualityThreadItemHolder, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, qualityThreadItemHolder, view) == null) || qualityThreadItemHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.m = skinType;
        if (this.n == null || qualityThreadItemHolder.skinType == skinType) {
            return;
        }
        qualityThreadItemHolder.skinType = skinType;
        SkinManager.setBackgroundResource(qualityThreadItemHolder.getView(), c.a.r0.p1.d.list_item_selector);
        SkinManager.setViewTextColor(qualityThreadItemHolder.moduleTheme, c.a.r0.p1.b.CAM_X0108, 1);
        SkinManager.setViewTextColor(qualityThreadItemHolder.titleView, c.a.r0.p1.b.CAM_X0105, 1);
        SkinManager.setViewTextColor(qualityThreadItemHolder.descView, c.a.r0.p1.b.CAM_X0109, 1);
        SkinManager.setBackgroundColor(qualityThreadItemHolder.contentDividerLine, c.a.r0.p1.b.CAM_X0204);
        SkinManager.setBackgroundColor(qualityThreadItemHolder.topDivilerLine, c.a.r0.p1.b.CAM_X0204);
        qualityThreadItemHolder.threadImg.setImageDrawable(null);
        this.n.getLayoutMode().k(this.m == 1);
        this.n.getLayoutMode().j(view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: l0 */
    public QualityThreadItemHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) ? new QualityThreadItemHolder(LayoutInflater.from(this.f2907e).inflate(c.a.r0.p1.f.hot_topic_quality_item, viewGroup, false)) : (QualityThreadItemHolder) invokeL.objValue;
    }

    public View m0(int i2, View view, ViewGroup viewGroup, m mVar, QualityThreadItemHolder qualityThreadItemHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, mVar, qualityThreadItemHolder})) == null) {
            if (mVar != null && qualityThreadItemHolder != null) {
                k0(qualityThreadItemHolder, view);
                j0(qualityThreadItemHolder, mVar);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void n0(QualityThreadItemHolder qualityThreadItemHolder, m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, qualityThreadItemHolder, mVar) == null) || qualityThreadItemHolder == null || mVar == null || this.n == null) {
            return;
        }
        c0(this.p);
        this.o.a(TbadkCoreApplication.getInst().getString(c.a.r0.p1.h.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(mVar.l, 7, false)}), String.valueOf(mVar.m));
        qualityThreadItemHolder.frsNameView.setOnClickListener(this.o);
    }
}

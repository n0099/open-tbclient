package c.a.r0.v1.h.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.e.l.e.n;
import c.a.e.l.e.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestForumViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b extends c.a.e.l.e.a<c.a.r0.v1.h.e.b, SearchSuggestForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    /* loaded from: classes3.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f25533e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f25534f;

        public a(b bVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25534f = bVar;
            this.f25533e = context;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.r0.v1.h.e.b)) {
                c.a.r0.v1.h.e.b bVar = (c.a.r0.v1.h.e.b) nVar;
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f25533e).createNormalCfg(bVar.d(), FrsActivityConfig.FRS_FROM_SEARCH_SUG);
                createNormalCfg.setCallFrom(16);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                this.f25534f.j0(bVar);
            }
        }
    }

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
        this.f2961h = bdUniqueId;
        d0(new a(this, context));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.e.l.e.a
    public /* bridge */ /* synthetic */ View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.v1.h.e.b bVar, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        l0(i2, view, viewGroup, bVar, searchSuggestForumViewHolder);
        return view;
    }

    public final void i0(StatisticItem statisticItem, c.a.r0.v1.h.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, bVar) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", bVar.c().longValue());
            statisticItem.param("fname", bVar.d());
        }
    }

    public final void j0(c.a.r0.v1.h.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_CLICK);
            i0(statisticItem, bVar);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: k0 */
    public SearchSuggestForumViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new SearchSuggestForumViewHolder(LayoutInflater.from(this.m).inflate(R.layout.search_suggest_forum_item, viewGroup, false)) : (SearchSuggestForumViewHolder) invokeL.objValue;
    }

    public View l0(int i2, View view, ViewGroup viewGroup, c.a.r0.v1.h.e.b bVar, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, searchSuggestForumViewHolder})) == null) {
            if (bVar == null) {
                return view;
            }
            m0(searchSuggestForumViewHolder);
            searchSuggestForumViewHolder.mSearchForumBarIcon.setConrers(15);
            searchSuggestForumViewHolder.mSearchForumBarIcon.setRadiusById(R.string.J_X06);
            searchSuggestForumViewHolder.mSearchForumBarIcon.startLoad(bVar.b(), 10, false);
            searchSuggestForumViewHolder.mSearchForumTitle.setText(bVar.d() + this.m.getString(R.string.forum));
            if (!StringUtils.isNull(bVar.h())) {
                searchSuggestForumViewHolder.mSearchForumIntroduce.setText(this.m.getString(R.string.search_forum_introduce, bVar.h()));
            } else {
                Context context = this.m;
                searchSuggestForumViewHolder.mSearchForumIntroduce.setText(context.getString(R.string.search_forum_introduce, context.getString(R.string.search_forum_no_introduce)));
            }
            searchSuggestForumViewHolder.mSearchForumAttentionContent.setText(String.format(this.m.getString(R.string.concern), StringHelper.numberUniformFormatExtraWithRoundInt(bVar.g().intValue())));
            searchSuggestForumViewHolder.mSearchForumPbContent.setText(String.format(this.m.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(bVar.i().intValue())));
            n0(bVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void m0(SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestForumViewHolder) == null) {
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(searchSuggestForumViewHolder.mSearchForumTitle);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X06);
            d2.v(R.color.CAM_X0105);
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(searchSuggestForumViewHolder.mSearchForumIntroduce);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0108);
            c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(searchSuggestForumViewHolder.mSearchForumAttentionContent);
            d4.z(R.dimen.T_X09);
            d4.v(R.color.CAM_X0108);
            c.a.q0.s.u.c d5 = c.a.q0.s.u.c.d(searchSuggestForumViewHolder.mSearchForumPbContent);
            d5.z(R.dimen.T_X09);
            d5.v(R.color.CAM_X0108);
            SkinManager.setBackgroundResource(searchSuggestForumViewHolder.mRootView, R.drawable.addresslist_item_bg);
            c.a.q0.s.u.c.d(searchSuggestForumViewHolder.mSearchSuggetLine).f(R.color.CAM_X0203);
        }
    }

    public final void n0(c.a.r0.v1.h.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_SHOW);
            i0(statisticItem, bVar);
            TiebaStatic.log(statisticItem);
        }
    }
}

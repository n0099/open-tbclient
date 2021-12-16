package c.a.s0.c2.h.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.f.p.m;
import c.a.d.m.e.n;
import c.a.d.m.e.w;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class c extends c.a.d.m.e.a<c.a.s0.c2.h.e.c, SearchSuggestItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    /* loaded from: classes7.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f15462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f15463f;

        public a(c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15463f = cVar;
            this.f15462e = context;
        }

        @Override // c.a.d.m.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.s0.c2.h.e.c)) {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                c.a.s0.c2.h.e.c cVar = (c.a.s0.c2.h.e.c) nVar;
                sb.append(cVar.d());
                sb.append("");
                hashMap.put("itemID", sb.toString());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new c.a.s0.v3.j0.n(this.f15462e, "GameItemDetailsPage", hashMap)));
                this.f15463f.i0(cVar);
            }
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
        this.f2874h = bdUniqueId;
        c0(new a(this, context));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, c.a.s0.c2.h.e.c cVar, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        k0(i2, view, viewGroup, cVar, searchSuggestItemViewHolder);
        return view;
    }

    public final void h0(StatisticItem statisticItem, c.a.s0.c2.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, cVar) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("item_id", cVar.d().longValue());
        }
    }

    public final void i0(c.a.s0.c2.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_CLICK);
            h0(statisticItem, cVar);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: j0 */
    public SearchSuggestItemViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new SearchSuggestItemViewHolder(LayoutInflater.from(this.m).inflate(R.layout.search_suggest_itemcard_item, viewGroup, false)) : (SearchSuggestItemViewHolder) invokeL.objValue;
    }

    public View k0(int i2, View view, ViewGroup viewGroup, c.a.s0.c2.h.e.c cVar, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, searchSuggestItemViewHolder})) == null) {
            if (cVar == null) {
                return view;
            }
            l0(searchSuggestItemViewHolder);
            searchSuggestItemViewHolder.mSearchItemcardBarIcon.setConrers(15);
            searchSuggestItemViewHolder.mSearchItemcardBarIcon.setRadiusById(R.string.J_X06);
            searchSuggestItemViewHolder.mSearchItemcardBarIcon.startLoad(cVar.a(), 10, false);
            searchSuggestItemViewHolder.mSearchItemcardTitle.setText(cVar.e());
            searchSuggestItemViewHolder.mStarView.setStarSpacing(m.f(this.m, R.dimen.M_W_X002));
            searchSuggestItemViewHolder.mStarView.setStarCount(cVar.h().intValue());
            TextView textView = searchSuggestItemViewHolder.mSearchItemcardScore;
            StringBuilder sb = new StringBuilder();
            sb.append(cVar.g());
            String str = "";
            sb.append("");
            textView.setText(sb.toString());
            if (cVar.i() != null) {
                for (String str2 : cVar.i()) {
                    if (!StringUtils.isNull(str2)) {
                        if (!StringUtils.isNull(str)) {
                            str2 = str + " " + str2;
                        }
                        str = str2;
                    }
                }
            }
            searchSuggestItemViewHolder.mSearchItemcardTags.setText(str);
            m0(cVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void l0(SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestItemViewHolder) == null) {
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(searchSuggestItemViewHolder.mSearchItemcardTitle);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X06);
            c.a.r0.s.v.c d3 = c.a.r0.s.v.c.d(searchSuggestItemViewHolder.mSearchItemcardScore);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X09);
            c.a.r0.s.v.c d4 = c.a.r0.s.v.c.d(searchSuggestItemViewHolder.mSearchItemcardTags);
            d4.v(R.color.CAM_X0108);
            d4.z(R.dimen.T_X09);
            SkinManager.setBackgroundResource(searchSuggestItemViewHolder.mRootView, R.drawable.addresslist_item_bg);
            c.a.r0.s.v.c.d(searchSuggestItemViewHolder.mSearchSuggetLine).f(R.color.CAM_X0203);
        }
    }

    public final void m0(c.a.s0.c2.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_SHOW);
            h0(statisticItem, cVar);
            TiebaStatic.log(statisticItem);
        }
    }
}

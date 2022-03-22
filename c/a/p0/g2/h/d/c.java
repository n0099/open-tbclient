package c.a.p0.g2.h.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
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
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c extends c.a.d.o.e.a<c.a.p0.g2.h.e.c, SearchSuggestItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context i;

    /* loaded from: classes2.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f15172b;

        public a(c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15172b = cVar;
            this.a = context;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.p0.g2.h.e.c)) {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                c.a.p0.g2.h.e.c cVar = (c.a.p0.g2.h.e.c) nVar;
                sb.append(cVar.b());
                sb.append("");
                hashMap.put("itemID", sb.toString());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a, "GameItemDetailsPage", hashMap)));
                this.f15172b.b0(cVar);
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
        this.f2570d = bdUniqueId;
        V(new a(this, context));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, c.a.p0.g2.h.e.c cVar, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        d0(i, view, viewGroup, cVar, searchSuggestItemViewHolder);
        return view;
    }

    public final void a0(StatisticItem statisticItem, c.a.p0.g2.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, cVar) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("item_id", cVar.b().longValue());
        }
    }

    public final void b0(c.a.p0.g2.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_CLICK);
            a0(statisticItem, cVar);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: c0 */
    public SearchSuggestItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new SearchSuggestItemViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d0757, viewGroup, false)) : (SearchSuggestItemViewHolder) invokeL.objValue;
    }

    public View d0(int i, View view, ViewGroup viewGroup, c.a.p0.g2.h.e.c cVar, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view, viewGroup, cVar, searchSuggestItemViewHolder})) == null) {
            if (cVar == null) {
                return view;
            }
            e0(searchSuggestItemViewHolder);
            searchSuggestItemViewHolder.f34362b.setConrers(15);
            searchSuggestItemViewHolder.f34362b.setRadiusById(R.string.J_X06);
            searchSuggestItemViewHolder.f34362b.J(cVar.a(), 10, false);
            searchSuggestItemViewHolder.f34363c.setText(cVar.e());
            searchSuggestItemViewHolder.f34366f.setStarSpacing(c.a.d.f.p.n.f(this.i, R.dimen.M_W_X002));
            searchSuggestItemViewHolder.f34366f.setStarCount(cVar.g().intValue());
            TextView textView = searchSuggestItemViewHolder.f34364d;
            StringBuilder sb = new StringBuilder();
            sb.append(cVar.f());
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
            searchSuggestItemViewHolder.f34365e.setText(str);
            f0(cVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void e0(SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestItemViewHolder) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(searchSuggestItemViewHolder.f34363c);
            d2.A(R.string.F_X02);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X06);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(searchSuggestItemViewHolder.f34364d);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X09);
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(searchSuggestItemViewHolder.f34365e);
            d4.v(R.color.CAM_X0108);
            d4.z(R.dimen.T_X09);
            SkinManager.setBackgroundResource(searchSuggestItemViewHolder.a, R.drawable.addresslist_item_bg);
            c.a.o0.r.v.c.d(searchSuggestItemViewHolder.f34367g).f(R.color.CAM_X0203);
        }
    }

    public final void f0(c.a.p0.g2.h.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_SHOW);
            a0(statisticItem, cVar);
            TiebaStatic.log(statisticItem);
        }
    }
}

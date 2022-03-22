package c.a.p0.g2.h.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
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
/* loaded from: classes2.dex */
public class b extends c.a.d.o.e.a<c.a.p0.g2.h.e.b, SearchSuggestForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context i;

    /* loaded from: classes2.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f15171b;

        public a(b bVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15171b = bVar;
            this.a = context;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.p0.g2.h.e.b)) {
                c.a.p0.g2.h.e.b bVar = (c.a.p0.g2.h.e.b) nVar;
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a).createNormalCfg(bVar.e(), FrsActivityConfig.FRS_FROM_SEARCH_SUG);
                createNormalCfg.setCallFrom(16);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                this.f15171b.b0(bVar);
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
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, c.a.p0.g2.h.e.b bVar, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        d0(i, view, viewGroup, bVar, searchSuggestForumViewHolder);
        return view;
    }

    public final void a0(StatisticItem statisticItem, c.a.p0.g2.h.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, bVar) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", bVar.b().longValue());
            statisticItem.param("fname", bVar.e());
        }
    }

    public final void b0(c.a.p0.g2.h.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_CLICK);
            a0(statisticItem, bVar);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: c0 */
    public SearchSuggestForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new SearchSuggestForumViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d0755, viewGroup, false)) : (SearchSuggestForumViewHolder) invokeL.objValue;
    }

    public View d0(int i, View view, ViewGroup viewGroup, c.a.p0.g2.h.e.b bVar, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view, viewGroup, bVar, searchSuggestForumViewHolder})) == null) {
            if (bVar == null) {
                return view;
            }
            e0(searchSuggestForumViewHolder);
            searchSuggestForumViewHolder.f34356b.setConrers(15);
            searchSuggestForumViewHolder.f34356b.setRadiusById(R.string.J_X06);
            searchSuggestForumViewHolder.f34356b.J(bVar.a(), 10, false);
            searchSuggestForumViewHolder.f34357c.setText(bVar.e() + this.i.getString(R.string.obfuscated_res_0x7f0f063c));
            if (!StringUtils.isNull(bVar.g())) {
                searchSuggestForumViewHolder.f34358d.setText(this.i.getString(R.string.obfuscated_res_0x7f0f1093, bVar.g()));
            } else {
                Context context = this.i;
                searchSuggestForumViewHolder.f34358d.setText(context.getString(R.string.obfuscated_res_0x7f0f1093, context.getString(R.string.obfuscated_res_0x7f0f1094)));
            }
            searchSuggestForumViewHolder.f34359e.setText(String.format(this.i.getString(R.string.obfuscated_res_0x7f0f040e), StringHelper.numberUniformFormatExtraWithRoundInt(bVar.f().intValue())));
            searchSuggestForumViewHolder.f34360f.setText(String.format(this.i.getString(R.string.obfuscated_res_0x7f0f06a6), StringHelper.numberUniformFormatExtraWithRoundInt(bVar.i().intValue())));
            f0(bVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void e0(SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestForumViewHolder) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(searchSuggestForumViewHolder.f34357c);
            d2.A(R.string.F_X02);
            d2.z(R.dimen.T_X06);
            d2.v(R.color.CAM_X0105);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(searchSuggestForumViewHolder.f34358d);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0108);
            c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(searchSuggestForumViewHolder.f34359e);
            d4.z(R.dimen.T_X09);
            d4.v(R.color.CAM_X0108);
            c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(searchSuggestForumViewHolder.f34360f);
            d5.z(R.dimen.T_X09);
            d5.v(R.color.CAM_X0108);
            SkinManager.setBackgroundResource(searchSuggestForumViewHolder.a, R.drawable.addresslist_item_bg);
            c.a.o0.r.v.c.d(searchSuggestForumViewHolder.f34361g).f(R.color.CAM_X0203);
        }
    }

    public final void f0(c.a.p0.g2.h.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_SHOW);
            a0(statisticItem, bVar);
            TiebaStatic.log(statisticItem);
        }
    }
}

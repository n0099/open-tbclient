package c.a.r0.e2.h.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.d.o.e.n;
import c.a.d.o.e.v;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestLiveViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends c.a.d.o.e.a<c.a.r0.e2.h.e.d, SearchSuggestLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    /* loaded from: classes2.dex */
    public class a implements v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f17113e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f17114f;

        public a(d dVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17114f = dVar;
            this.f17113e = context;
        }

        @Override // c.a.d.o.e.v
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.r0.e2.h.e.d)) {
                c.a.r0.e2.h.e.d dVar = (c.a.r0.e2.h.e.d) nVar;
                this.f17114f.b0(dVar);
                TbPageContext tbPageContext = (TbPageContext) j.a(this.f17113e);
                String e2 = dVar.e();
                String g2 = dVar.g();
                String i3 = dVar.i();
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, e2, g2, i3, "" + dVar.d(), "search_sug_live");
                c.a.d.f.p.n.w(this.f17113e, view);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TBLottieAnimationView f17115e;

        public b(d dVar, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17115e = tBLottieAnimationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17115e.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, BdUniqueId bdUniqueId) {
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
        this.f3079h = bdUniqueId;
        V(new a(this, context));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, c.a.r0.e2.h.e.d dVar, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        e0(i2, view, viewGroup, dVar, searchSuggestLiveViewHolder);
        return view;
    }

    public final void a0(StatisticItem statisticItem, c.a.r0.e2.h.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, dVar) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, dVar.k());
            statisticItem.param(TiebaStatic.Params.ZHIBO_TYPE, dVar.n());
            statisticItem.param(TiebaStatic.YYParams.YYSID, dVar.e());
            statisticItem.param(TiebaStatic.YYParams.YYSSID, dVar.g());
            statisticItem.param(TiebaStatic.YYParams.YYUID, dVar.l());
            statisticItem.param("template_id", dVar.i());
        }
    }

    public final void b0(c.a.r0.e2.h.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_CLICK);
            a0(statisticItem, dVar);
            statisticItem.param("source", "search_sug_live");
            TiebaStatic.log(statisticItem);
        }
    }

    public final void c0(TextView textView) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, textView) == null) || (context = this.m) == null || textView == null) {
            return;
        }
        textView.setMaxWidth(c.a.d.f.p.n.k(context) - c.a.d.f.p.n.f(this.m, R.dimen.tbds297));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: d0 */
    public SearchSuggestLiveViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) ? new SearchSuggestLiveViewHolder(LayoutInflater.from(this.m).inflate(R.layout.search_suggest_live_item, viewGroup, false)) : (SearchSuggestLiveViewHolder) invokeL.objValue;
    }

    public View e0(int i2, View view, ViewGroup viewGroup, c.a.r0.e2.h.e.d dVar, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, searchSuggestLiveViewHolder})) == null) {
            if (dVar == null) {
                return view;
            }
            f0(searchSuggestLiveViewHolder);
            WebPManager.setPureDrawable(searchSuggestLiveViewHolder.searchBarIcon, R.drawable.icon_search_scan, R.color.CAM_X0109, null);
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(searchSuggestLiveViewHolder.searchLiveLayout);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0308);
            c.a.r0.e2.h.c.a(searchSuggestLiveViewHolder.mSuggest, dVar.h(), dVar.a());
            c0(searchSuggestLiveViewHolder.mSuggest);
            h0(searchSuggestLiveViewHolder.searchLiveLottieView);
            g0(dVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void f0(SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, searchSuggestLiveViewHolder) == null) {
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(searchSuggestLiveViewHolder.mSuggest);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X06);
            c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(searchSuggestLiveViewHolder.mLivingText);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X10);
            SkinManager.setBackgroundResource(searchSuggestLiveViewHolder.mRootView, R.drawable.addresslist_item_bg);
            c.a.q0.r.v.c.d(searchSuggestLiveViewHolder.mSearchSuggetLine).f(R.color.CAM_X0203);
        }
    }

    public final void g0(c.a.r0.e2.h.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_SHOW);
            a0(statisticItem, dVar);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void h0(TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tBLottieAnimationView) == null) {
            tBLottieAnimationView.cancelAnimation();
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_sug_live);
            tBLottieAnimationView.setRepeatCount(-1);
            tBLottieAnimationView.post(new b(this, tBLottieAnimationView));
        }
    }
}

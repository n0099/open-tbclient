package b.a.r0.v1.h.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.j;
import b.a.e.f.p.l;
import b.a.e.m.e.n;
import b.a.e.m.e.w;
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
/* loaded from: classes5.dex */
public class d extends b.a.e.m.e.a<b.a.r0.v1.h.e.d, SearchSuggestLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    /* loaded from: classes5.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f25832e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f25833f;

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
            this.f25833f = dVar;
            this.f25832e = context;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b.a.r0.v1.h.e.d)) {
                b.a.r0.v1.h.e.d dVar = (b.a.r0.v1.h.e.d) nVar;
                this.f25833f.i0(dVar);
                TbPageContext tbPageContext = (TbPageContext) j.a(this.f25832e);
                String e2 = dVar.e();
                String g2 = dVar.g();
                String i3 = dVar.i();
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, e2, g2, i3, "" + dVar.d(), "search_sug_live");
                l.x(this.f25832e, view);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TBLottieAnimationView f25834e;

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
            this.f25834e = tBLottieAnimationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f25834e.playAnimation();
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
        this.f2424h = bdUniqueId;
        c0(new a(this, context));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // b.a.e.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.v1.h.e.d dVar, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        l0(i2, view, viewGroup, dVar, searchSuggestLiveViewHolder);
        return view;
    }

    public final void h0(StatisticItem statisticItem, b.a.r0.v1.h.e.d dVar) {
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

    public final void i0(b.a.r0.v1.h.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_CLICK);
            h0(statisticItem, dVar);
            statisticItem.param("source", "search_sug_live");
            TiebaStatic.log(statisticItem);
        }
    }

    public final void j0(TextView textView) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, textView) == null) || (context = this.m) == null || textView == null) {
            return;
        }
        textView.setMaxWidth(l.k(context) - l.g(this.m, R.dimen.tbds297));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: k0 */
    public SearchSuggestLiveViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) ? new SearchSuggestLiveViewHolder(LayoutInflater.from(this.m).inflate(R.layout.search_suggest_live_item, viewGroup, false)) : (SearchSuggestLiveViewHolder) invokeL.objValue;
    }

    public View l0(int i2, View view, ViewGroup viewGroup, b.a.r0.v1.h.e.d dVar, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, searchSuggestLiveViewHolder})) == null) {
            if (dVar == null) {
                return view;
            }
            m0(searchSuggestLiveViewHolder);
            WebPManager.setPureDrawable(searchSuggestLiveViewHolder.searchBarIcon, R.drawable.icon_search_scan, R.color.CAM_X0109, null);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(searchSuggestLiveViewHolder.searchLiveLayout);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0308);
            b.a.r0.v1.h.c.a(searchSuggestLiveViewHolder.mSuggest, dVar.h(), dVar.a());
            j0(searchSuggestLiveViewHolder.mSuggest);
            o0(searchSuggestLiveViewHolder.searchLiveLottieView);
            n0(dVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void m0(SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, searchSuggestLiveViewHolder) == null) {
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(searchSuggestLiveViewHolder.mSuggest);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X06);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(searchSuggestLiveViewHolder.mLivingText);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X10);
            SkinManager.setBackgroundResource(searchSuggestLiveViewHolder.mRootView, R.drawable.addresslist_item_bg);
            b.a.q0.s.u.c.d(searchSuggestLiveViewHolder.mSearchSuggetLine).f(R.color.CAM_X0203);
        }
    }

    public final void n0(b.a.r0.v1.h.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_SHOW);
            h0(statisticItem, dVar);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void o0(TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, tBLottieAnimationView) == null) {
            tBLottieAnimationView.cancelAnimation();
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_sug_live);
            tBLottieAnimationView.setRepeatCount(-1);
            tBLottieAnimationView.post(new b(this, tBLottieAnimationView));
        }
    }
}

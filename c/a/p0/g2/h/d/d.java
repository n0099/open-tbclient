package c.a.p0.g2.h.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.j;
import c.a.d.o.e.n;
import c.a.d.o.e.w;
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
public class d extends c.a.d.o.e.a<c.a.p0.g2.h.e.d, SearchSuggestLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context i;

    /* loaded from: classes2.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f15173b;

        public a(d dVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15173b = dVar;
            this.a = context;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.p0.g2.h.e.d)) {
                c.a.p0.g2.h.e.d dVar = (c.a.p0.g2.h.e.d) nVar;
                this.f15173b.b0(dVar);
                TbPageContext tbPageContext = (TbPageContext) j.a(this.a);
                String e2 = dVar.e();
                String f2 = dVar.f();
                String i2 = dVar.i();
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, e2, f2, i2, "" + dVar.b(), "search_sug_live");
                c.a.d.f.p.n.w(this.a, view);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;

        public b(d dVar, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBLottieAnimationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.playAnimation();
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
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, c.a.p0.g2.h.e.d dVar, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        e0(i, view, viewGroup, dVar, searchSuggestLiveViewHolder);
        return view;
    }

    public final void a0(StatisticItem statisticItem, c.a.p0.g2.h.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, dVar) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, dVar.j());
            statisticItem.param(TiebaStatic.Params.ZHIBO_TYPE, dVar.m());
            statisticItem.param(TiebaStatic.YYParams.YYSID, dVar.e());
            statisticItem.param(TiebaStatic.YYParams.YYSSID, dVar.f());
            statisticItem.param(TiebaStatic.YYParams.YYUID, dVar.k());
            statisticItem.param("template_id", dVar.i());
        }
    }

    public final void b0(c.a.p0.g2.h.e.d dVar) {
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
        if (!(interceptable == null || interceptable.invokeL(1048580, this, textView) == null) || (context = this.i) == null || textView == null) {
            return;
        }
        textView.setMaxWidth(c.a.d.f.p.n.k(context) - c.a.d.f.p.n.f(this.i, R.dimen.tbds297));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: d0 */
    public SearchSuggestLiveViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) ? new SearchSuggestLiveViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d0758, viewGroup, false)) : (SearchSuggestLiveViewHolder) invokeL.objValue;
    }

    public View e0(int i, View view, ViewGroup viewGroup, c.a.p0.g2.h.e.d dVar, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view, viewGroup, dVar, searchSuggestLiveViewHolder})) == null) {
            if (dVar == null) {
                return view;
            }
            f0(searchSuggestLiveViewHolder);
            WebPManager.setPureDrawable(searchSuggestLiveViewHolder.f34369c, R.drawable.obfuscated_res_0x7f080a06, R.color.CAM_X0109, null);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(searchSuggestLiveViewHolder.f34371e);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0308);
            c.a.p0.g2.h.c.a(searchSuggestLiveViewHolder.f34368b, dVar.g(), dVar.a());
            c0(searchSuggestLiveViewHolder.f34368b);
            h0(searchSuggestLiveViewHolder.f34370d);
            g0(dVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void f0(SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, searchSuggestLiveViewHolder) == null) {
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(searchSuggestLiveViewHolder.f34368b);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X06);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(searchSuggestLiveViewHolder.f34372f);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X10);
            SkinManager.setBackgroundResource(searchSuggestLiveViewHolder.a, R.drawable.addresslist_item_bg);
            c.a.o0.r.v.c.d(searchSuggestLiveViewHolder.f34373g).f(R.color.CAM_X0203);
        }
    }

    public final void g0(c.a.p0.g2.h.e.d dVar) {
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
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f110035);
            tBLottieAnimationView.setRepeatCount(-1);
            tBLottieAnimationView.post(new b(this, tBLottieAnimationView));
        }
    }
}

package c.a.s0.d1.s1;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.g0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends c.a.d.m.e.a<g, CardViewHolder<c.a.s0.d1.s1.b>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public c.a.s0.d1.s1.b n;
    public boolean o;
    public List<c.a.s0.d1.s1.b> p;
    public Handler q;
    public c.a.s0.d1.s1.a r;
    public boolean s;
    public d0<g> t;

    /* loaded from: classes7.dex */
    public class a extends d0<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f16359b;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16359b = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.g0.d0
        /* renamed from: d */
        public void a(View view, g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, gVar) == null) || view == null || gVar == null) {
                return;
            }
            if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof c.a.s0.d1.s1.b)) {
                c.a.s0.d1.s1.b bVar = (c.a.s0.d1.s1.b) view.getTag();
                if (this.f16359b.n != null && this.f16359b.n != bVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                    this.f16359b.n.S();
                }
                if (this.f16359b.n != bVar) {
                    this.f16359b.n = bVar;
                }
            }
            if (view.getId() == R.id.title) {
                StatisticItem statisticItem = new StatisticItem("c12411");
                statisticItem.param("fid", gVar.f16368e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
            } else if (view.getId() == R.id.agree_view_container) {
                StatisticItem statisticItem2 = new StatisticItem("c12414");
                statisticItem2.param("fid", gVar.f16368e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem2);
            } else if (view.getId() != R.id.thread_info_commont_container && view.getId() != R.id.card_root_view) {
                if (view.getId() != R.id.user_icon && view.getId() != R.id.user_name) {
                    if (view.getId() == R.id.attention) {
                        StatisticItem statisticItem3 = new StatisticItem("c12413");
                        statisticItem3.param("fid", gVar.f16368e);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem3);
                        return;
                    } else if (view.getId() == R.id.mobile_network_play) {
                        StatisticItem statisticItem4 = new StatisticItem("c12416");
                        statisticItem4.param("fid", gVar.f16368e);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem4);
                        return;
                    } else {
                        return;
                    }
                }
                StatisticItem statisticItem5 = new StatisticItem("c12412");
                statisticItem5.param("fid", gVar.f16368e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem5);
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c12415");
                statisticItem6.param("fid", gVar.f16368e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem6);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16360e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16360e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16360e.o) {
                this.f16360e.o = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext, c.a.s0.d1.s1.a aVar, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), g.K);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar, Boolean.valueOf(z)};
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
        this.p = new ArrayList();
        this.q = new Handler();
        this.t = new a(this);
        this.m = tbPageContext;
        this.r = aVar;
        this.s = z;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.s0.d1.s1.b bVar = this.n;
            if (bVar != null) {
                return bVar.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l0(Configuration configuration) {
        c.a.s0.d1.s1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, configuration) == null) || (bVar = this.n) == null) {
            return;
        }
        this.o = true;
        bVar.D(configuration);
        if (configuration.orientation == 1) {
            this.q.postDelayed(new b(this), 500L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: m0 */
    public CardViewHolder<c.a.s0.d1.s1.b> S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            c.a.s0.d1.s1.b bVar = new c.a.s0.d1.s1.b(this.m, this.s);
            bVar.m(this.t);
            this.p.add(bVar);
            return new CardViewHolder<>(bVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: n0 */
    public View Z(int i2, View view, ViewGroup viewGroup, g gVar, CardViewHolder<c.a.s0.d1.s1.b> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, cardViewHolder})) == null) {
            if (gVar == null || cardViewHolder == null) {
                return null;
            }
            if (!this.o) {
                cardViewHolder.getCardView().C(gVar, i2, this.r);
                cardViewHolder.getCardView().J = i2;
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public boolean o0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            c.a.s0.d1.s1.b bVar = this.n;
            if (bVar == null) {
                return false;
            }
            return bVar.E(i2);
        }
        return invokeI.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (c.a.s0.d1.s1.b bVar : this.p) {
                if (bVar != null) {
                    bVar.onDestroy();
                }
            }
        }
    }

    public void p0() {
        c.a.s0.d1.s1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bVar = this.n) == null) {
            return;
        }
        bVar.F();
    }

    public void q0() {
        c.a.s0.d1.s1.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.n) == null) {
            return;
        }
        bVar.S();
    }
}

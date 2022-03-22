package c.a.p0.l3.d0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.l3.a0;
import c.a.p0.l3.g0.j;
import c.a.p0.l3.p;
import c.a.p0.l3.s;
import c.a.p0.l3.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.CardAppLegoViewHolder;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class b extends c.a.d.o.e.a<c.a.p0.h0.e0.d, CardAppLegoViewHolder> implements p, u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public int j;
    public boolean k;
    public AdvertAppInfo.ILegoAdvert l;
    public Runnable m;
    public CustomMessageListener n;

    /* loaded from: classes2.dex */
    public class a implements c.a.p0.b2.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16103b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f16104c;

        public a(b bVar, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, advertAppInfo, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advertAppInfo;
            this.f16103b = i;
            this.f16104c = str;
        }

        @Override // c.a.p0.b2.o.a
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) || i == 0) {
                return;
            }
            if (a0.q(i)) {
                c.a.p0.l3.m0.d.h(this.a, this.f16103b, hashMap, i);
            } else {
                c.a.p0.l3.m0.d.p(this.a, this.f16103b, this.f16104c, null, hashMap);
            }
            c.a.p0.b2.o.h.c.h(c.a.p0.b2.o.h.c.e(this.a));
        }
    }

    /* renamed from: c.a.p0.l3.d0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1207b implements c.a.p0.b2.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f16105b;

        public C1207b(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16105b = bVar;
            this.a = str;
        }

        @Override // c.a.p0.b2.o.c
        public void a(AdvertAppInfo advertAppInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i) == null) {
                j.b(this.f16105b.i.getPageActivity(), advertAppInfo, i, this.f16105b.i0(advertAppInfo, this.a));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((CardAppLegoViewHolder) this.a.f2573g).c((int) TimeUnit.SECONDS.toSeconds(1L));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f2573g == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof Boolean)) {
                ((CardAppLegoViewHolder) this.a.f2573g).stopPlay();
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                ((CardAppLegoViewHolder) this.a.f2573g).stopPlay();
            } else {
                int e2 = ((CardAppLegoViewHolder) this.a.f2573g).e();
                if (!((CardAppLegoViewHolder) this.a.f2573g).d()) {
                    if (e2 != -1) {
                        ((CardAppLegoViewHolder) this.a.f2573g).stopPlay();
                    }
                } else if (e2 == -1) {
                    c.a.d.f.m.e.a().removeCallbacks(this.a.m);
                    c.a.d.f.m.e.a().postDelayed(this.a.m, 500L);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, str};
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
        this.j = 3;
        this.k = false;
        this.l = null;
        this.m = new c(this);
        this.n = new d(this, 2921517);
        this.i = tbPageContext;
        if ((tbPageContext.getPageActivity() instanceof BaseFragmentActivity) && TextUtils.equals(str, "CONCERN")) {
            if (bdUniqueId == AdvertAppInfo.C || bdUniqueId == AdvertAppInfo.E) {
                MessageManager.getInstance().registerListener(this.n);
            }
        }
    }

    public final DownloadStaticsData i0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(advertAppInfo.k);
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.s);
            downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
            downloadStaticsData.setExtensionInfo(advertAppInfo.f29821h);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: j0 */
    public View E(int i, View view, ViewGroup viewGroup, c.a.p0.h0.e0.d dVar) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view, viewGroup, dVar})) == null) {
            if (dVar == null || (advertAppInfo = dVar.a) == null || (iLegoAdvert = advertAppInfo.i) == null) {
                return null;
            }
            this.l = iLegoAdvert;
            if (k0(view)) {
                CardAppLegoViewHolder M = M(viewGroup);
                this.f2573g = M;
                if (M != null) {
                    view = M.b();
                }
            }
            View view2 = view;
            if (view2 != null) {
                view2 = S(i, view2, viewGroup, dVar, (CardAppLegoViewHolder) view2.getTag());
                if (s.class.isAssignableFrom(view2.getClass())) {
                    ((CardAppLegoViewHolder) this.f2573g).f(((s) view2).getVideoOrVrView());
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.p0.l3.u
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.k = z;
        }
    }

    public final boolean k0(View view) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            if (view == null || view.getTag() == null || (v = this.f2573g) == 0 || this.l == null || !((CardAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.f2573g).getClass()) || !(view.getTag(R.id.obfuscated_res_0x7f091e73) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.l.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.obfuscated_res_0x7f091e73));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: l0 */
    public CardAppLegoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            if (this.l == null || (view = (View) c.a.p0.b2.o.b.h().a(this.i, this.l, 2)) == null) {
                return null;
            }
            view.setTag(R.id.obfuscated_res_0x7f091e73, this.l);
            return new CardAppLegoViewHolder((c.a.p0.b2.o.l.e) view);
        }
        return (CardAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: m0 */
    public CardAppLegoViewHolder N(ViewGroup viewGroup, c.a.p0.h0.e0.d dVar) {
        InterceptResult invokeLL;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, viewGroup, dVar)) == null) {
            if (dVar == null || (advertAppInfo = dVar.a) == null || (iLegoAdvert = advertAppInfo.i) == null) {
                return null;
            }
            this.l = iLegoAdvert;
            return M(viewGroup);
        }
        return (CardAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: n0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.h0.e0.d dVar, CardAppLegoViewHolder cardAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view, viewGroup, dVar, cardAppLegoViewHolder})) == null) {
            TbPageContext<?> tbPageContext = this.i;
            if (tbPageContext != null && dVar != null && dVar.a != null) {
                if (tbPageContext.getPageActivity() instanceof c.a.a0.f.b) {
                    AdvertAppInfo advertAppInfo = dVar.a;
                    advertAppInfo.u = c.a.a0.f.d.b(advertAppInfo.u, (c.a.a0.f.b) this.i.getPageActivity(), cardAppLegoViewHolder.itemView);
                }
                AdvertAppInfo.ILegoAdvert iLegoAdvert = dVar.a.i;
                this.l = iLegoAdvert;
                if (iLegoAdvert != null && view != null) {
                    if (this.f2573g == 0) {
                        this.f2573g = cardAppLegoViewHolder;
                    }
                    c.a.o0.r.r.e.d(dVar);
                    this.i.getLayoutMode().k(this.j == 1);
                    this.i.getLayoutMode().j(view);
                    AdvertAppInfo e2 = dVar.e();
                    c.a.p0.b2.o.l.e eVar = (c.a.p0.b2.o.l.e) view;
                    this.l.setAdvertAppInfo(e2);
                    eVar.setFromCDN(this.k);
                    eVar.update(this.l);
                    int i2 = dVar.f15324c;
                    String str = dVar.f15323b;
                    eVar.setAfterClickSchemeListener(new a(this, e2, i2, str));
                    eVar.setDownloadAppCallback(new C1207b(this, str));
                    if (s.class.isAssignableFrom(view.getClass())) {
                        cardAppLegoViewHolder.f(((s) view).getVideoOrVrView());
                    }
                    return view;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.p0.l3.p
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    @Override // c.a.p0.l3.p
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // c.a.p0.l3.p
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }
}

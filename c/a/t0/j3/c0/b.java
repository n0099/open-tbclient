package c.a.t0.j3.c0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.j3.f0.j;
import c.a.t0.j3.p;
import c.a.t0.j3.r;
import c.a.t0.j3.t;
import c.a.t0.j3.z;
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
/* loaded from: classes7.dex */
public class b extends c.a.d.n.e.a<c.a.t0.g0.f0.d, CardAppLegoViewHolder> implements p, t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public int n;
    public boolean o;
    public AdvertAppInfo.ILegoAdvert p;
    public Runnable q;
    public CustomMessageListener r;

    /* loaded from: classes7.dex */
    public class a implements c.a.t0.x1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18726b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18727c;

        public a(b bVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, advertAppInfo, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advertAppInfo;
            this.f18726b = i2;
            this.f18727c = str;
        }

        @Override // c.a.t0.x1.o.a
        public void a(int i2, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) || i2 == 0) {
                return;
            }
            if (z.q(i2)) {
                c.a.t0.j3.l0.d.h(this.a, this.f18726b, hashMap, i2);
            } else {
                c.a.t0.j3.l0.d.p(this.a, this.f18726b, this.f18727c, null, hashMap);
            }
            c.a.t0.x1.o.h.c.h(c.a.t0.x1.o.h.c.e(this.a));
        }
    }

    /* renamed from: c.a.t0.j3.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1130b implements c.a.t0.x1.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f18728b;

        public C1130b(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18728b = bVar;
            this.a = str;
        }

        @Override // c.a.t0.x1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i2) == null) {
                j.b(this.f18728b.m.getPageActivity(), advertAppInfo, i2, this.f18728b.i0(advertAppInfo, this.a));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18729e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18729e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((CardAppLegoViewHolder) this.f18729e.f3305k).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.f3305k == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof Boolean)) {
                ((CardAppLegoViewHolder) this.a.f3305k).stopPlay();
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                ((CardAppLegoViewHolder) this.a.f3305k).stopPlay();
            } else {
                int playStatus = ((CardAppLegoViewHolder) this.a.f3305k).getPlayStatus();
                if (!((CardAppLegoViewHolder) this.a.f3305k).canPlay()) {
                    if (playStatus != -1) {
                        ((CardAppLegoViewHolder) this.a.f3305k).stopPlay();
                    }
                } else if (playStatus == -1) {
                    c.a.d.f.m.e.a().removeCallbacks(this.a.q);
                    c.a.d.f.m.e.a().postDelayed(this.a.q, 500L);
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
        this.n = 3;
        this.o = false;
        this.p = null;
        this.q = new c(this);
        this.r = new d(this, 2921517);
        this.m = tbPageContext;
        if ((tbPageContext.getPageActivity() instanceof BaseFragmentActivity) && TextUtils.equals(str, "CONCERN")) {
            if (bdUniqueId == AdvertAppInfo.G4 || bdUniqueId == AdvertAppInfo.I4) {
                MessageManager.getInstance().registerListener(this.r);
            }
        }
    }

    public final DownloadStaticsData i0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(advertAppInfo.p4);
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.x4);
            downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
            downloadStaticsData.setExtensionInfo(advertAppInfo.m4);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: j0 */
    public View E(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.d dVar) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar})) == null) {
            if (dVar == null || (advertAppInfo = dVar.f18229e) == null || (iLegoAdvert = advertAppInfo.n4) == null) {
                return null;
            }
            this.p = iLegoAdvert;
            if (k0(view)) {
                CardAppLegoViewHolder M = M(viewGroup);
                this.f3305k = M;
                if (M != null) {
                    view = M.getView();
                }
            }
            View view2 = view;
            if (view2 != null) {
                view2 = S(i2, view2, viewGroup, dVar, (CardAppLegoViewHolder) view2.getTag());
                if (r.class.isAssignableFrom(view2.getClass())) {
                    ((CardAppLegoViewHolder) this.f3305k).setAdVideoView(((r) view2).getVideoOrVrView());
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.t0.j3.t
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.o = z;
        }
    }

    public final boolean k0(View view) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            if (view == null || view.getTag() == null || (v = this.f3305k) == 0 || this.p == null || !((CardAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.f3305k).getClass()) || !(view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.p.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: l0 */
    public CardAppLegoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            if (this.p == null || (view = (View) c.a.t0.x1.o.b.h().a(this.m, this.p, 2)) == null) {
                return null;
            }
            view.setTag(R.id.tag_first, this.p);
            return new CardAppLegoViewHolder((c.a.t0.x1.o.l.e) view);
        }
        return (CardAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: m0 */
    public CardAppLegoViewHolder N(ViewGroup viewGroup, c.a.t0.g0.f0.d dVar) {
        InterceptResult invokeLL;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, viewGroup, dVar)) == null) {
            if (dVar == null || (advertAppInfo = dVar.f18229e) == null || (iLegoAdvert = advertAppInfo.n4) == null) {
                return null;
            }
            this.p = iLegoAdvert;
            return M(viewGroup);
        }
        return (CardAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: n0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.d dVar, CardAppLegoViewHolder cardAppLegoViewHolder) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, cardAppLegoViewHolder})) == null) {
            if (this.m != null && dVar != null && (advertAppInfo = dVar.f18229e) != null) {
                AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.n4;
                this.p = iLegoAdvert;
                if (iLegoAdvert != null && view != null) {
                    if (this.f3305k == 0) {
                        this.f3305k = cardAppLegoViewHolder;
                    }
                    c.a.s0.s.q.e.d(dVar);
                    this.m.getLayoutMode().k(this.n == 1);
                    this.m.getLayoutMode().j(view);
                    AdvertAppInfo g2 = dVar.g();
                    c.a.t0.x1.o.l.e eVar = (c.a.t0.x1.o.l.e) view;
                    this.p.setAdvertAppInfo(g2);
                    eVar.setFromCDN(this.o);
                    eVar.update(this.p);
                    int i3 = dVar.f18231g;
                    String str = dVar.f18230f;
                    eVar.setAfterClickSchemeListener(new a(this, g2, i3, str));
                    eVar.setDownloadAppCallback(new C1130b(this, str));
                    if (r.class.isAssignableFrom(view.getClass())) {
                        cardAppLegoViewHolder.setAdVideoView(((r) view).getVideoOrVrView());
                    }
                    return view;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.t0.j3.p
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
        }
    }

    @Override // c.a.t0.j3.p
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // c.a.t0.j3.p
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }
}

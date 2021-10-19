package c.a.r0.z2.c0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.z2.f0.j;
import c.a.r0.z2.p;
import c.a.r0.z2.r;
import c.a.r0.z2.t;
import c.a.r0.z2.z;
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
/* loaded from: classes4.dex */
public class b extends c.a.e.l.e.a<c.a.r0.b0.e0.d, CardAppLegoViewHolder> implements p, t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public int n;
    public boolean o;
    public AdvertAppInfo.ILegoAdvert p;
    public Runnable q;
    public CustomMessageListener r;

    /* loaded from: classes4.dex */
    public class a implements c.a.r0.q1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f29494a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f29495b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29496c;

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
            this.f29494a = advertAppInfo;
            this.f29495b = i2;
            this.f29496c = str;
        }

        @Override // c.a.r0.q1.o.a
        public void a(int i2, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) || i2 == 0) {
                return;
            }
            if (z.p(i2)) {
                c.a.r0.z2.l0.d.g(this.f29494a, this.f29495b, hashMap, i2);
            } else {
                c.a.r0.z2.l0.d.o(this.f29494a, this.f29495b, this.f29496c, null, hashMap);
            }
            c.a.r0.q1.o.h.c.h(c.a.r0.q1.o.h.c.e(this.f29494a));
        }
    }

    /* renamed from: c.a.r0.z2.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1379b implements c.a.r0.q1.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f29497a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f29498b;

        public C1379b(b bVar, String str) {
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
            this.f29498b = bVar;
            this.f29497a = str;
        }

        @Override // c.a.r0.q1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i2) == null) {
                j.b(this.f29498b.m.getPageActivity(), advertAppInfo, i2, this.f29498b.q0(advertAppInfo, this.f29497a));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29499e;

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
            this.f29499e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((CardAppLegoViewHolder) this.f29499e.k).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f29500a;

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
            this.f29500a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f29500a.k == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof Boolean)) {
                ((CardAppLegoViewHolder) this.f29500a.k).stopPlay();
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                ((CardAppLegoViewHolder) this.f29500a.k).stopPlay();
            } else {
                int playStatus = ((CardAppLegoViewHolder) this.f29500a.k).getPlayStatus();
                if (!((CardAppLegoViewHolder) this.f29500a.k).canPlay()) {
                    if (playStatus != -1) {
                        ((CardAppLegoViewHolder) this.f29500a.k).stopPlay();
                    }
                } else if (playStatus == -1) {
                    c.a.e.e.m.e.a().removeCallbacks(this.f29500a.q);
                    c.a.e.e.m.e.a().postDelayed(this.f29500a.q, 500L);
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
            if (bdUniqueId == AdvertAppInfo.x4 || bdUniqueId == AdvertAppInfo.z4) {
                MessageManager.getInstance().registerListener(this.r);
            }
        }
    }

    @Override // c.a.r0.z2.t
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.o = z;
        }
    }

    @Override // c.a.r0.z2.p
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
        }
    }

    @Override // c.a.r0.z2.p
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // c.a.r0.z2.p
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public final DownloadStaticsData q0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(advertAppInfo.h4);
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.p4);
            downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
            downloadStaticsData.setExtensionInfo(advertAppInfo.e4);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: r0 */
    public View L(int i2, View view, ViewGroup viewGroup, c.a.r0.b0.e0.d dVar) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar})) == null) {
            if (dVar == null || (advertAppInfo = dVar.f15727e) == null || (iLegoAdvert = advertAppInfo.f4) == null) {
                return null;
            }
            this.p = iLegoAdvert;
            if (s0(view)) {
                CardAppLegoViewHolder U = U(viewGroup);
                this.k = U;
                if (U != null) {
                    view = U.getView();
                }
            }
            View view2 = view;
            if (view2 != null) {
                view2 = a0(i2, view2, viewGroup, dVar, (CardAppLegoViewHolder) view2.getTag());
                if (r.class.isAssignableFrom(view2.getClass())) {
                    ((CardAppLegoViewHolder) this.k).setAdVideoView(((r) view2).getVideoOrVrView());
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean s0(View view) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view)) == null) {
            if (view == null || view.getTag() == null || (v = this.k) == 0 || this.p == null || !((CardAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.k).getClass()) || !(view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.p.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: t0 */
    public CardAppLegoViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            if (this.p == null || (view = (View) c.a.r0.q1.o.b.h().a(this.m, this.p, 2)) == null) {
                return null;
            }
            view.setTag(R.id.tag_first, this.p);
            return new CardAppLegoViewHolder((c.a.r0.q1.o.l.e) view);
        }
        return (CardAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: u0 */
    public CardAppLegoViewHolder V(ViewGroup viewGroup, c.a.r0.b0.e0.d dVar) {
        InterceptResult invokeLL;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, viewGroup, dVar)) == null) {
            if (dVar == null || (advertAppInfo = dVar.f15727e) == null || (iLegoAdvert = advertAppInfo.f4) == null) {
                return null;
            }
            this.p = iLegoAdvert;
            return U(viewGroup);
        }
        return (CardAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: v0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.b0.e0.d dVar, CardAppLegoViewHolder cardAppLegoViewHolder) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, cardAppLegoViewHolder})) == null) {
            if (this.m != null && dVar != null && (advertAppInfo = dVar.f15727e) != null) {
                AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.f4;
                this.p = iLegoAdvert;
                if (iLegoAdvert != null && view != null) {
                    if (this.k == 0) {
                        this.k = cardAppLegoViewHolder;
                    }
                    c.a.q0.s.q.e.d(dVar);
                    this.m.getLayoutMode().k(this.n == 1);
                    this.m.getLayoutMode().j(view);
                    AdvertAppInfo g2 = dVar.g();
                    c.a.r0.q1.o.l.e eVar = (c.a.r0.q1.o.l.e) view;
                    this.p.setAdvertAppInfo(g2);
                    eVar.setFromCDN(this.o);
                    eVar.update(this.p);
                    int i3 = dVar.f15729g;
                    String str = dVar.f15728f;
                    eVar.setAfterClickSchemeListener(new a(this, g2, i3, str));
                    eVar.setDownloadAppCallback(new C1379b(this, str));
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
}

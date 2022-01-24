package c.a.t0.k3.c0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.k3.f0.j;
import c.a.t0.k3.r;
import c.a.t0.k3.t;
import c.a.t0.k3.z;
import c.a.t0.x3.j0.p;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.PbAppLegoViewHolder;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class f extends c.a.d.n.e.a<p, PbAppLegoViewHolder> implements t, c.a.t0.k3.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity m;
    public boolean n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public WeakReference<PbAppLegoViewHolder> s;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.k != null && this.a.o) {
                int playStatus = ((PbAppLegoViewHolder) this.a.k).getPlayStatus();
                if (((PbAppLegoViewHolder) this.a.k).canPlay()) {
                    if (playStatus == -1) {
                        ((PbAppLegoViewHolder) this.a.k).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                    }
                } else if (playStatus != -1) {
                    ((PbAppLegoViewHolder) this.a.k).stopPlay();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.p0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.k != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                ((PbAppLegoViewHolder) this.a.k).stopPlay();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements c.a.t0.y1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18742b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f18743c;

        public d(f fVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, advertAppInfo, Integer.valueOf(i2), str};
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
            this.f18742b = i2;
            this.f18743c = str;
        }

        @Override // c.a.t0.y1.o.a
        public void a(int i2, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) || i2 == 0) {
                return;
            }
            if (z.q(i2)) {
                c.a.t0.k3.l0.d.h(this.a, this.f18742b, hashMap, i2);
            } else {
                c.a.t0.k3.l0.d.p(this.a, this.f18742b, this.f18743c, null, hashMap);
            }
            AdvertAppInfo advertAppInfo = this.a;
            if (advertAppInfo.l4) {
                return;
            }
            c.a.t0.y1.o.h.c.h(c.a.t0.y1.o.h.c.e(advertAppInfo));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements c.a.t0.y1.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f18744b;

        public e(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18744b = fVar;
            this.a = str;
        }

        @Override // c.a.t0.y1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i2) == null) {
                j.b(this.f18744b.m.getPageContext().getPageActivity(), advertAppInfo, i2, this.f18744b.i0(advertAppInfo, this.a));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId};
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
        this.o = true;
        this.p = new a(this, 2004013);
        this.q = new b(this, 2004018);
        this.r = new c(this, 2004020);
        this.s = null;
        this.m = baseFragmentActivity;
        baseFragmentActivity.registerListener(this.p);
        this.m.registerListener(this.r);
        this.m.registerListener(this.q);
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder' to match base method */
    @Override // c.a.d.n.e.a
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder M(ViewGroup viewGroup) {
        m0(viewGroup);
        throw null;
    }

    public final DownloadStaticsData i0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(j0(advertAppInfo));
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.y4);
            downloadStaticsData.setAdPosition(advertAppInfo.m4);
            downloadStaticsData.setExtensionInfo(advertAppInfo.n4);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    public final String j0(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, advertAppInfo)) == null) ? TextUtils.isEmpty(advertAppInfo.q4) ? "PB" : advertAppInfo.q4 : (String) invokeL.objValue;
    }

    @Override // c.a.t0.k3.t
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: k0 */
    public View E(int i2, View view, ViewGroup viewGroup, p pVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar})) == null) {
            if (pVar == null || pVar.M0() == null) {
                return null;
            }
            if (l0(view, pVar)) {
                PbAppLegoViewHolder N = N(viewGroup, pVar);
                this.k = N;
                if (N != null) {
                    view = N.getView();
                }
            }
            View view2 = view;
            if (view2 != null) {
                view2 = S(i2, view2, viewGroup, pVar, (PbAppLegoViewHolder) view2.getTag());
                if (r.class.isAssignableFrom(view2.getClass())) {
                    ((PbAppLegoViewHolder) this.k).setAdVideoView(((r) view2).getVideoOrVrView());
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean l0(View view, p pVar) {
        InterceptResult invokeLL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, pVar)) == null) {
            if (view == null || view.getTag() == null || (v = this.k) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.k).getClass())) {
                return true;
            }
            AdvertAppInfo.ILegoAdvert M0 = pVar.M0();
            Object tag = view.getTag(R.id.tag_first);
            if (tag instanceof AdvertAppInfo.ILegoAdvert) {
                return !M0.isReusable((AdvertAppInfo.ILegoAdvert) tag);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public PbAppLegoViewHolder m0(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
        }
        return (PbAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: n0 */
    public PbAppLegoViewHolder N(ViewGroup viewGroup, p pVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, viewGroup, pVar)) == null) {
            View view = (View) c.a.t0.y1.o.b.h().a(this.m.getPageContext(), pVar.M0(), 4);
            if (view != null) {
                PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((c.a.t0.y1.o.l.e) view);
                pbAppLegoViewHolder.setIsRecyclable(false);
                return pbAppLegoViewHolder;
            }
            return null;
        }
        return (PbAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: o0 */
    public View S(int i2, View view, ViewGroup viewGroup, p pVar, PbAppLegoViewHolder pbAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar, pbAppLegoViewHolder})) == null) {
            if (this.m == null) {
                return null;
            }
            if (pVar.M0() instanceof AdCard) {
                ((AdCard) pVar.M0()).isPBBanner = pVar.J0;
            }
            pbAppLegoViewHolder.setIsRecyclable(false);
            AdvertAppInfo.ILegoAdvert M0 = pVar.M0();
            view.setTag(R.id.tag_first, M0);
            this.m.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.m.getLayoutMode().j(view);
            c.a.s0.s.q.e.f(pVar);
            if (pVar.R0) {
                c.a.t0.v.h.a.i().k(c.a.t0.v.h.a.g(pVar.getAdvertAppInfo()));
            }
            AdvertAppInfo advertAppInfo = pVar.getAdvertAppInfo();
            if (advertAppInfo.p4 == null) {
                advertAppInfo.p4 = new c.a.s0.s.q.e();
            }
            c.a.s0.s.q.e eVar = advertAppInfo.p4;
            eVar.f13536b = pVar.O0;
            eVar.a = pVar.L0();
            advertAppInfo.position = pVar.Q0;
            advertAppInfo.l4 = pVar.R0;
            c.a.t0.y1.o.l.e eVar2 = (c.a.t0.y1.o.l.e) view;
            M0.setAdvertAppInfo(advertAppInfo);
            eVar2.setFromCDN(this.n);
            eVar2.update(M0);
            int i3 = pVar.O0;
            String str = pVar.K0;
            eVar2.setAfterClickSchemeListener(new d(this, advertAppInfo, i3, str));
            eVar2.setDownloadAppCallback(new e(this, str));
            WeakReference<PbAppLegoViewHolder> weakReference = this.s;
            if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
                this.s = new WeakReference<>(pbAppLegoViewHolder);
            }
            p0();
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.t0.k3.p
    public void onDestroy() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbAppLegoViewHolder) v).release();
    }

    @Override // c.a.t0.k3.p
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            V v = this.k;
            if (v != 0) {
                ((PbAppLegoViewHolder) v).stopPlay();
            }
            this.o = false;
        }
    }

    @Override // c.a.t0.k3.p
    public void onResume() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (v = this.k) != 0 && ((PbAppLegoViewHolder) v).canPlay()) {
            if (((PbAppLegoViewHolder) this.k).getPlayStatus() == -1) {
                ((PbAppLegoViewHolder) this.k).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.o = true;
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            WeakReference<PbAppLegoViewHolder> weakReference = this.s;
            PbAppLegoViewHolder pbAppLegoViewHolder = weakReference != null ? weakReference.get() : null;
            if (pbAppLegoViewHolder != null) {
                pbAppLegoViewHolder.updateFontSize();
            }
        }
    }
}

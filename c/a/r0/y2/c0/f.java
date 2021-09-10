package c.a.r0.y2.c0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.j3.i0.p;
import c.a.r0.y2.f0.j;
import c.a.r0.y2.r;
import c.a.r0.y2.t;
import c.a.r0.y2.z;
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
/* loaded from: classes4.dex */
public class f extends c.a.e.l.e.a<p, PbAppLegoViewHolder> implements t, c.a.r0.y2.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity m;
    public boolean n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public WeakReference<PbAppLegoViewHolder> s;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f29310a;

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
            this.f29310a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f29310a.k != null && this.f29310a.o) {
                int playStatus = ((PbAppLegoViewHolder) this.f29310a.k).getPlayStatus();
                if (((PbAppLegoViewHolder) this.f29310a.k).canPlay()) {
                    if (playStatus == -1) {
                        ((PbAppLegoViewHolder) this.f29310a.k).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                    }
                } else if (playStatus != -1) {
                    ((PbAppLegoViewHolder) this.f29310a.k).stopPlay();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f29311a;

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
            this.f29311a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f29311a.x0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f29312a;

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
            this.f29312a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f29312a.k != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                ((PbAppLegoViewHolder) this.f29312a.k).stopPlay();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.a.r0.p1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f29313a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f29314b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29315c;

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
            this.f29313a = advertAppInfo;
            this.f29314b = i2;
            this.f29315c = str;
        }

        @Override // c.a.r0.p1.o.a
        public void a(int i2, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) || i2 == 0) {
                return;
            }
            if (z.p(i2)) {
                c.a.r0.y2.l0.d.g(this.f29313a, this.f29314b, hashMap, i2);
            } else {
                c.a.r0.y2.l0.d.o(this.f29313a, this.f29314b, this.f29315c, null, hashMap);
            }
            AdvertAppInfo advertAppInfo = this.f29313a;
            if (advertAppInfo.b4) {
                return;
            }
            c.a.r0.p1.o.h.c.h(c.a.r0.p1.o.h.c.e(advertAppInfo));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements c.a.r0.p1.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f29316a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f29317b;

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
            this.f29317b = fVar;
            this.f29316a = str;
        }

        @Override // c.a.r0.p1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i2) == null) {
                j.b(this.f29317b.m.getPageContext().getPageActivity(), advertAppInfo, i2, this.f29317b.q0(advertAppInfo, this.f29316a));
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
    @Override // c.a.e.l.e.a
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder U(ViewGroup viewGroup) {
        u0(viewGroup);
        throw null;
    }

    @Override // c.a.r0.y2.t
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.n = z;
        }
    }

    @Override // c.a.r0.y2.p
    public void onDestroy() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbAppLegoViewHolder) v).release();
    }

    @Override // c.a.r0.y2.p
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            V v = this.k;
            if (v != 0) {
                ((PbAppLegoViewHolder) v).stopPlay();
            }
            this.o = false;
        }
    }

    @Override // c.a.r0.y2.p
    public void onResume() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (v = this.k) != 0 && ((PbAppLegoViewHolder) v).canPlay()) {
            if (((PbAppLegoViewHolder) this.k).getPlayStatus() == -1) {
                ((PbAppLegoViewHolder) this.k).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.o = true;
        }
    }

    public final DownloadStaticsData q0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(r0(advertAppInfo));
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.o4);
            downloadStaticsData.setAdPosition(advertAppInfo.c4);
            downloadStaticsData.setExtensionInfo(advertAppInfo.d4);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    public final String r0(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, advertAppInfo)) == null) ? TextUtils.isEmpty(advertAppInfo.g4) ? "PB" : advertAppInfo.g4 : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: s0 */
    public View L(int i2, View view, ViewGroup viewGroup, p pVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar})) == null) {
            if (pVar == null || pVar.F0() == null) {
                return null;
            }
            if (t0(view, pVar)) {
                PbAppLegoViewHolder V = V(viewGroup, pVar);
                this.k = V;
                if (V != null) {
                    view = V.getView();
                }
            }
            View view2 = view;
            if (view2 != null) {
                view2 = a0(i2, view2, viewGroup, pVar, (PbAppLegoViewHolder) view2.getTag());
                if (r.class.isAssignableFrom(view2.getClass())) {
                    ((PbAppLegoViewHolder) this.k).setAdVideoView(((r) view2).getVideoOrVrView());
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean t0(View view, p pVar) {
        InterceptResult invokeLL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view, pVar)) == null) {
            if (view == null || view.getTag() == null || (v = this.k) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.k).getClass())) {
                return true;
            }
            AdvertAppInfo.ILegoAdvert F0 = pVar.F0();
            Object tag = view.getTag(R.id.tag_first);
            if (tag instanceof AdvertAppInfo.ILegoAdvert) {
                return !F0.isReusable((AdvertAppInfo.ILegoAdvert) tag);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public PbAppLegoViewHolder u0(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewGroup)) == null) {
            throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
        }
        return (PbAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: v0 */
    public PbAppLegoViewHolder V(ViewGroup viewGroup, p pVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, pVar)) == null) {
            View view = (View) c.a.r0.p1.o.b.h().a(this.m.getPageContext(), pVar.F0(), 4);
            if (view != null) {
                PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((c.a.r0.p1.o.l.e) view);
                pbAppLegoViewHolder.setIsRecyclable(false);
                return pbAppLegoViewHolder;
            }
            return null;
        }
        return (PbAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: w0 */
    public View a0(int i2, View view, ViewGroup viewGroup, p pVar, PbAppLegoViewHolder pbAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar, pbAppLegoViewHolder})) == null) {
            if (this.m == null) {
                return null;
            }
            if (pVar.F0() instanceof AdCard) {
                ((AdCard) pVar.F0()).isPBBanner = pVar.E0;
            }
            pbAppLegoViewHolder.setIsRecyclable(false);
            AdvertAppInfo.ILegoAdvert F0 = pVar.F0();
            view.setTag(R.id.tag_first, F0);
            this.m.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.m.getLayoutMode().j(view);
            c.a.q0.s.q.e.f(pVar);
            if (pVar.M0) {
                c.a.r0.q.f.a.i().k(c.a.r0.q.f.a.g(pVar.getAdvertAppInfo()));
            }
            AdvertAppInfo advertAppInfo = pVar.getAdvertAppInfo();
            if (advertAppInfo.f4 == null) {
                advertAppInfo.f4 = new c.a.q0.s.q.e();
            }
            c.a.q0.s.q.e eVar = advertAppInfo.f4;
            eVar.f14144b = pVar.J0;
            eVar.f14143a = pVar.E0();
            advertAppInfo.position = pVar.L0;
            advertAppInfo.b4 = pVar.M0;
            c.a.r0.p1.o.l.e eVar2 = (c.a.r0.p1.o.l.e) view;
            F0.setAdvertAppInfo(advertAppInfo);
            eVar2.setFromCDN(this.n);
            eVar2.update(F0);
            int i3 = pVar.J0;
            String str = pVar.F0;
            eVar2.setAfterClickSchemeListener(new d(this, advertAppInfo, i3, str));
            eVar2.setDownloadAppCallback(new e(this, str));
            WeakReference<PbAppLegoViewHolder> weakReference = this.s;
            if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
                this.s = new WeakReference<>(pbAppLegoViewHolder);
            }
            x0();
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void x0() {
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

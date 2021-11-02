package b.a.r0.z2.c0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.l3.j0.p;
import b.a.r0.z2.f0.j;
import b.a.r0.z2.r;
import b.a.r0.z2.t;
import b.a.r0.z2.z;
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
/* loaded from: classes6.dex */
public class f extends b.a.e.l.e.a<p, PbAppLegoViewHolder> implements t, b.a.r0.z2.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity m;
    public boolean n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public WeakReference<PbAppLegoViewHolder> s;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f27922a;

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
            this.f27922a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f27922a.k != null && this.f27922a.o) {
                int playStatus = ((PbAppLegoViewHolder) this.f27922a.k).getPlayStatus();
                if (((PbAppLegoViewHolder) this.f27922a.k).canPlay()) {
                    if (playStatus == -1) {
                        ((PbAppLegoViewHolder) this.f27922a.k).autoPlay((int) TimeUnit.SECONDS.toSeconds(1L));
                    }
                } else if (playStatus != -1) {
                    ((PbAppLegoViewHolder) this.f27922a.k).stopPlay();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f27923a;

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
            this.f27923a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f27923a.w0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f27924a;

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
            this.f27924a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f27924a.k != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                ((PbAppLegoViewHolder) this.f27924a.k).stopPlay();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements b.a.r0.q1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f27925a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f27926b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f27927c;

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
            this.f27925a = advertAppInfo;
            this.f27926b = i2;
            this.f27927c = str;
        }

        @Override // b.a.r0.q1.o.a
        public void a(int i2, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) || i2 == 0) {
                return;
            }
            if (z.p(i2)) {
                b.a.r0.z2.l0.d.h(this.f27925a, this.f27926b, hashMap, i2);
            } else {
                b.a.r0.z2.l0.d.p(this.f27925a, this.f27926b, this.f27927c, null, hashMap);
            }
            AdvertAppInfo advertAppInfo = this.f27925a;
            if (advertAppInfo.c4) {
                return;
            }
            b.a.r0.q1.o.h.c.h(b.a.r0.q1.o.h.c.e(advertAppInfo));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements b.a.r0.q1.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f27928a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f27929b;

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
            this.f27929b = fVar;
            this.f27928a = str;
        }

        @Override // b.a.r0.q1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i2) == null) {
                j.b(this.f27929b.m.getPageContext().getPageActivity(), advertAppInfo, i2, this.f27929b.p0(advertAppInfo, this.f27928a));
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
    @Override // b.a.e.l.e.a
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder T(ViewGroup viewGroup) {
        t0(viewGroup);
        throw null;
    }

    @Override // b.a.r0.z2.t
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.n = z;
        }
    }

    @Override // b.a.r0.z2.p
    public void onDestroy() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbAppLegoViewHolder) v).release();
    }

    @Override // b.a.r0.z2.p
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

    @Override // b.a.r0.z2.p
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

    public final DownloadStaticsData p0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(q0(advertAppInfo));
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.p4);
            downloadStaticsData.setAdPosition(advertAppInfo.d4);
            downloadStaticsData.setExtensionInfo(advertAppInfo.e4);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    public final String q0(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, advertAppInfo)) == null) ? TextUtils.isEmpty(advertAppInfo.h4) ? "PB" : advertAppInfo.h4 : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: r0 */
    public View J(int i2, View view, ViewGroup viewGroup, p pVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar})) == null) {
            if (pVar == null || pVar.L0() == null) {
                return null;
            }
            if (s0(view, pVar)) {
                PbAppLegoViewHolder U = U(viewGroup, pVar);
                this.k = U;
                if (U != null) {
                    view = U.getView();
                }
            }
            View view2 = view;
            if (view2 != null) {
                view2 = Z(i2, view2, viewGroup, pVar, (PbAppLegoViewHolder) view2.getTag());
                if (r.class.isAssignableFrom(view2.getClass())) {
                    ((PbAppLegoViewHolder) this.k).setAdVideoView(((r) view2).getVideoOrVrView());
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean s0(View view, p pVar) {
        InterceptResult invokeLL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view, pVar)) == null) {
            if (view == null || view.getTag() == null || (v = this.k) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.k).getClass())) {
                return true;
            }
            AdvertAppInfo.ILegoAdvert L0 = pVar.L0();
            Object tag = view.getTag(R.id.tag_first);
            if (tag instanceof AdvertAppInfo.ILegoAdvert) {
                return !L0.isReusable((AdvertAppInfo.ILegoAdvert) tag);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public PbAppLegoViewHolder t0(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewGroup)) == null) {
            throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
        }
        return (PbAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: u0 */
    public PbAppLegoViewHolder U(ViewGroup viewGroup, p pVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, pVar)) == null) {
            View view = (View) b.a.r0.q1.o.b.h().a(this.m.getPageContext(), pVar.L0(), 4);
            if (view != null) {
                PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((b.a.r0.q1.o.l.e) view);
                pbAppLegoViewHolder.setIsRecyclable(false);
                return pbAppLegoViewHolder;
            }
            return null;
        }
        return (PbAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: v0 */
    public View Z(int i2, View view, ViewGroup viewGroup, p pVar, PbAppLegoViewHolder pbAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), view, viewGroup, pVar, pbAppLegoViewHolder})) == null) {
            if (this.m == null) {
                return null;
            }
            if (pVar.L0() instanceof AdCard) {
                ((AdCard) pVar.L0()).isPBBanner = pVar.H0;
            }
            pbAppLegoViewHolder.setIsRecyclable(false);
            AdvertAppInfo.ILegoAdvert L0 = pVar.L0();
            view.setTag(R.id.tag_first, L0);
            this.m.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.m.getLayoutMode().j(view);
            b.a.q0.s.q.e.f(pVar);
            if (pVar.P0) {
                b.a.r0.r.f.a.i().k(b.a.r0.r.f.a.g(pVar.getAdvertAppInfo()));
            }
            AdvertAppInfo advertAppInfo = pVar.getAdvertAppInfo();
            if (advertAppInfo.g4 == null) {
                advertAppInfo.g4 = new b.a.q0.s.q.e();
            }
            b.a.q0.s.q.e eVar = advertAppInfo.g4;
            eVar.f13277b = pVar.M0;
            eVar.f13276a = pVar.K0();
            advertAppInfo.position = pVar.O0;
            advertAppInfo.c4 = pVar.P0;
            b.a.r0.q1.o.l.e eVar2 = (b.a.r0.q1.o.l.e) view;
            L0.setAdvertAppInfo(advertAppInfo);
            eVar2.setFromCDN(this.n);
            eVar2.update(L0);
            int i3 = pVar.M0;
            String str = pVar.I0;
            eVar2.setAfterClickSchemeListener(new d(this, advertAppInfo, i3, str));
            eVar2.setDownloadAppCallback(new e(this, str));
            WeakReference<PbAppLegoViewHolder> weakReference = this.s;
            if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
                this.s = new WeakReference<>(pbAppLegoViewHolder);
            }
            w0();
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void w0() {
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

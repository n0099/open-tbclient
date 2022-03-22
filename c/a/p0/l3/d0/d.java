package c.a.p0.l3.d0;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.f1.k;
import c.a.p0.l3.a0;
import c.a.p0.l3.g0.j;
import c.a.p0.l3.s;
import c.a.p0.l3.v;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.FrsAppLegoViewHolder;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class d extends k<AdvertAppInfo, FrsAppLegoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo.ILegoAdvert t;
    public v u;

    /* loaded from: classes2.dex */
    public class a implements c.a.p0.b2.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16106b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f16107c;

        public a(d dVar, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, advertAppInfo, Integer.valueOf(i), str};
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
            this.f16106b = i;
            this.f16107c = str;
        }

        @Override // c.a.p0.b2.o.a
        public void a(int i, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) {
                if (a0.q(i)) {
                    c.a.p0.l3.m0.d.h(this.a, this.f16106b, hashMap, i);
                } else {
                    c.a.p0.l3.m0.d.p(this.a, this.f16106b, this.f16107c, null, hashMap);
                }
                c.a.p0.b2.o.h.c.h(c.a.p0.b2.o.h.c.e(this.a));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.p0.b2.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f16108b;

        public b(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16108b = dVar;
            this.a = str;
        }

        @Override // c.a.p0.b2.o.c
        public void a(AdvertAppInfo advertAppInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i) == null) {
                j.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo, i, this.f16108b.m0(advertAppInfo, this.a));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(v vVar, BdUniqueId bdUniqueId) {
        super(vVar.j(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = null;
        this.u = vVar;
    }

    @Override // c.a.p0.f1.k
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            V v = this.f2573g;
            if (v != 0) {
                ((FrsAppLegoViewHolder) v).c();
            }
            super.c0();
        }
    }

    public final DownloadStaticsData m0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, advertAppInfo, str)) == null) {
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
    /* renamed from: n0 */
    public View E(int i, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeCommon;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view, viewGroup, advertAppInfo})) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.i) == null) {
                return null;
            }
            this.t = iLegoAdvert;
            if (o0(view)) {
                FrsAppLegoViewHolder M = M(viewGroup);
                this.f2573g = M;
                if (M == null) {
                    return null;
                }
                view = M.b();
            }
            View view2 = view;
            return S(i, view2, viewGroup, advertAppInfo, (FrsAppLegoViewHolder) view2.getTag());
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean o0(View view) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            if (view == null || view.getTag() == null || (v = this.f2573g) == 0 || this.t == null || !((FrsAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.f2573g).getClass()) || !(view.getTag(R.id.obfuscated_res_0x7f091e73) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.t.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.obfuscated_res_0x7f091e73));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: p0 */
    public FrsAppLegoViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            if (this.t == null || (view = (View) c.a.p0.b2.o.b.h().a(this.k, this.t, 1)) == null) {
                return null;
            }
            view.setTag(R.id.obfuscated_res_0x7f091e73, this.t);
            return new FrsAppLegoViewHolder((c.a.p0.b2.o.l.e) view);
        }
        return (FrsAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: q0 */
    public FrsAppLegoViewHolder N(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeLL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, viewGroup, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.i) == null) {
                return null;
            }
            this.t = iLegoAdvert;
            return M(viewGroup);
        }
        return (FrsAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.f1.k, c.a.d.o.e.a
    /* renamed from: r0 */
    public View S(int i, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view, viewGroup, advertAppInfo, frsAppLegoViewHolder})) == null) {
            super.S(i, view, viewGroup, advertAppInfo, frsAppLegoViewHolder);
            if (this.u == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.i;
            this.t = iLegoAdvert;
            if (iLegoAdvert == null || view == null) {
                return null;
            }
            if (this.k.getPageActivity() instanceof c.a.a0.f.b) {
                advertAppInfo.u = c.a.a0.f.d.b(advertAppInfo.u, (c.a.a0.f.b) this.k.getPageActivity(), frsAppLegoViewHolder.itemView);
            }
            this.k.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.k.getLayoutMode().j(view);
            c.a.o0.r.r.e.b(advertAppInfo);
            c.a.p0.b2.o.l.e eVar = (c.a.p0.b2.o.l.e) view;
            eVar.setFromCDN(this.i);
            eVar.update(this.t);
            String z = this.u.z();
            int r0 = this.u.r0();
            this.u.L();
            eVar.setAfterClickSchemeListener(new a(this, advertAppInfo, r0, z));
            eVar.setDownloadAppCallback(new b(this, z));
            if (s.class.isAssignableFrom(view.getClass())) {
                frsAppLegoViewHolder.d(((s) view).getVideoOrVrView());
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}

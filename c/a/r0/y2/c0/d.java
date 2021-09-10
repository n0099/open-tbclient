package c.a.r0.y2.c0;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.w0.k;
import c.a.r0.y2.f0.j;
import c.a.r0.y2.r;
import c.a.r0.y2.u;
import c.a.r0.y2.z;
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
/* loaded from: classes4.dex */
public class d extends k<AdvertAppInfo, FrsAppLegoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo.ILegoAdvert x;
    public u y;

    /* loaded from: classes4.dex */
    public class a implements c.a.r0.p1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f29305a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f29306b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f29307c;

        public a(d dVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, advertAppInfo, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29305a = advertAppInfo;
            this.f29306b = i2;
            this.f29307c = str;
        }

        @Override // c.a.r0.p1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) {
                if (z.p(i2)) {
                    c.a.r0.y2.l0.d.g(this.f29305a, this.f29306b, hashMap, i2);
                } else {
                    c.a.r0.y2.l0.d.o(this.f29305a, this.f29306b, this.f29307c, null, hashMap);
                }
                c.a.r0.p1.o.h.c.h(c.a.r0.p1.o.h.c.e(this.f29305a));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.r0.p1.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f29308a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f29309b;

        public b(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29309b = dVar;
            this.f29308a = str;
        }

        @Override // c.a.r0.p1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i2) == null) {
                j.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo, i2, this.f29309b.v0(advertAppInfo, this.f29308a));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(u uVar, BdUniqueId bdUniqueId) {
        super(uVar.getTbPageContext(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = null;
        this.y = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.w0.k, c.a.e.l.e.a
    /* renamed from: A0 */
    public View a0(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), view, viewGroup, advertAppInfo, frsAppLegoViewHolder})) == null) {
            super.a0(i2, view, viewGroup, advertAppInfo, frsAppLegoViewHolder);
            if (this.y == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.e4;
            this.x = iLegoAdvert;
            if (iLegoAdvert == null || view == null) {
                return null;
            }
            this.o.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.o.getLayoutMode().j(view);
            c.a.q0.s.q.e.b(advertAppInfo);
            c.a.r0.p1.o.l.e eVar = (c.a.r0.p1.o.l.e) view;
            eVar.setFromCDN(this.m);
            eVar.update(this.x);
            String fid = this.y.getFid();
            int pageNum = this.y.getPageNum();
            this.y.updateLastIds();
            eVar.setAfterClickSchemeListener(new a(this, advertAppInfo, pageNum, fid));
            eVar.setDownloadAppCallback(new b(this, fid));
            if (r.class.isAssignableFrom(view.getClass())) {
                frsAppLegoViewHolder.setAdVideoView(((r) view).getVideoOrVrView());
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.r0.w0.k
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            V v = this.k;
            if (v != 0) {
                ((FrsAppLegoViewHolder) v).release();
            }
            super.k0();
        }
    }

    public final DownloadStaticsData v0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(advertAppInfo.g4);
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.o4);
            downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
            downloadStaticsData.setExtensionInfo(advertAppInfo.d4);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: w0 */
    public View L(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeCommon;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, advertAppInfo})) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.e4) == null) {
                return null;
            }
            this.x = iLegoAdvert;
            if (x0(view)) {
                FrsAppLegoViewHolder U = U(viewGroup);
                this.k = U;
                if (U == null) {
                    return null;
                }
                view = U.getView();
            }
            View view2 = view;
            return a0(i2, view2, viewGroup, advertAppInfo, (FrsAppLegoViewHolder) view2.getTag());
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean x0(View view) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view)) == null) {
            if (view == null || view.getTag() == null || (v = this.k) == 0 || this.x == null || !((FrsAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.k).getClass()) || !(view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.x.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: y0 */
    public FrsAppLegoViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            if (this.x == null || (view = (View) c.a.r0.p1.o.b.h().a(this.o, this.x, 1)) == null) {
                return null;
            }
            view.setTag(R.id.tag_first, this.x);
            return new FrsAppLegoViewHolder((c.a.r0.p1.o.l.e) view);
        }
        return (FrsAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: z0 */
    public FrsAppLegoViewHolder V(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeLL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, viewGroup, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.e4) == null) {
                return null;
            }
            this.x = iLegoAdvert;
            return U(viewGroup);
        }
        return (FrsAppLegoViewHolder) invokeLL.objValue;
    }
}

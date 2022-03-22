package c.a.p0.l3.j0.d.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.c1.g;
import c.a.p0.l3.a0;
import c.a.p0.l3.o;
import c.a.p0.x.g.e;
import c.a.p0.x.g.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.view.XfremodeRoundLayout;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f16260b;

    /* renamed from: c  reason: collision with root package name */
    public View f16261c;

    /* renamed from: d  reason: collision with root package name */
    public XfremodeRoundLayout f16262d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f16263e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16264f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16265g;

    /* renamed from: h  reason: collision with root package name */
    public AdAppInfoView f16266h;
    public ApkDownloadView i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public AdCard m;
    public DownloadCacheKey n;
    public c.a.p0.x.g.h.d o;
    public List<AdvertAppInfo> p;
    public List<AdvertAppInfo> q;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.a.m;
                this.a.q.add(adCard.getAdvertAppInfo());
                c.a.p0.l3.m0.d.m(adCard.getAdvertAppInfo());
                this.a.f16261c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.a.m;
                String str = adCard.scheme;
                if (m.isEmpty(str)) {
                    return;
                }
                String str2 = adCard.ext;
                String downloadId = adCard.getDownloadId();
                int i = 3;
                if (!a0.C(adCard.getAdvertAppInfo(), str)) {
                    int i2 = adCard.goodsStyle;
                    if ((i2 == 7 || i2 == 14) && adCard.videoInfo != null && adCard.getAdvertAppInfo() != null) {
                        i = a0.g(TbadkCoreApplication.getInst(), str, adCard.getAdvertAppInfo(), adCard.playCmdScheme);
                    } else {
                        i = a0.d(TbadkCoreApplication.getInst(), str, downloadId, str2, adCard.cmdScheme);
                    }
                }
                this.a.f(i, adCard);
            }
        }
    }

    /* renamed from: c.a.p0.l3.j0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1214c implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C1214c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.p0.x.g.g.b.a
        public boolean b(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                AdCard adCard = this.a.m;
                c.a.p0.x.a.a(this.a.m.getButtonCmdScheme());
                this.a.f(1, adCard);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public c(ViewStub viewStub, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = null;
        this.f16260b = viewStub;
        this.a = tbPageContext;
    }

    @Override // c.a.p0.l3.o
    public void a(AdvertAppInfo advertAppInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, gVar) == null) {
            if (advertAppInfo == null) {
                View view = this.f16261c;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f16261c == null) {
                l(this.f16260b);
                this.p = new ArrayList();
                this.q = new ArrayList();
            }
            q(advertAppInfo, gVar);
        }
    }

    public final void f(int i, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, adCard) == null) || i == 0) {
            return;
        }
        if (a0.q(i)) {
            c.a.p0.l3.m0.d.f(adCard.getAdvertAppInfo(), i);
        } else {
            c.a.p0.l3.m0.d.n(adCard.getAdvertAppInfo());
        }
        c.a.p0.b2.o.h.c.h(c.a.p0.b2.o.h.c.e(adCard.getAdvertAppInfo()));
    }

    public void g(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.n = downloadCacheKey;
        p();
        this.o = null;
        AdDownloadData b2 = e.d().b(downloadCacheKey);
        if (a0.r(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.m;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.m.getAdvertAppInfo().k;
            b2.setExtInfo(this.m.getAdvertAppInfo().f29821h);
            b2.setDownloadKey(this.m.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.m.scheme);
            b2.setCmdScheme(this.m.cmdScheme);
        }
        e d2 = e.d();
        ApkDownloadView apkDownloadView = this.i;
        c.a.p0.x.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.o = new c.a.p0.x.g.h.b(c2);
        if (b2.extra().getPercent() > 0) {
            c2.e(b2);
        }
        n();
        this.i.d(b2.getCurrentState());
    }

    public float h(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            try {
                return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i).split(",")[0]);
            } catch (NumberFormatException unused) {
                return 0.0f;
            }
        }
        return invokeI.floatValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.j.setVisibility(8);
            this.i.setVisibility(0);
            AdCard adCard = this.m;
            c.a.p0.l3.j0.b.b bVar = adCard.downloadInfo;
            if (bVar == null) {
                return;
            }
            String str = bVar.a;
            DownloadData o = o(this.m, adCard.getPosition());
            if (a0.r(str)) {
                o.setStatus(8);
            } else {
                o.setStatus(this.i.getDownloadStatus());
            }
            this.i.setData(o);
            this.i.setOnClickInterceptListener(new C1214c(this));
        }
    }

    public final void j() {
        DownloadCacheKey i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AdCard adCard = this.m;
            String str = adCard.scheme;
            String downloadId = adCard.getDownloadId();
            if (!TextUtils.isEmpty(downloadId)) {
                i = e.d().h(downloadId);
            } else {
                i = e.d().i(str);
            }
            if (i == null) {
                c.a.p0.l3.j0.b.b bVar = this.m.downloadInfo;
                i = DownloadCacheKey.create(downloadId, bVar.f16226b, bVar.a);
                e.d().j(i, null);
            }
            g(i);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i.setVisibility(8);
            c.a.p0.l3.j0.b.a aVar = this.m.operate;
            String str = aVar != null ? aVar.f16223b : null;
            if (TextUtils.isEmpty(str)) {
                str = "立即查看";
            }
            this.j.setVisibility(0);
            this.j.setText(str);
        }
    }

    public final void l(ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewStub) == null) {
            viewStub.setLayoutResource(R.layout.obfuscated_res_0x7f0d006f);
            View inflate = viewStub.inflate();
            this.f16261c = inflate;
            this.f16262d = (XfremodeRoundLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0900ad);
            this.f16263e = (TbImageView) this.f16261c.findViewById(R.id.obfuscated_res_0x7f0900a9);
            this.f16264f = (TextView) this.f16261c.findViewById(R.id.obfuscated_res_0x7f090091);
            this.f16265g = (TextView) this.f16261c.findViewById(R.id.obfuscated_res_0x7f0900f3);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.f16261c.findViewById(R.id.obfuscated_res_0x7f090084);
            this.f16266h = adAppInfoView;
            adAppInfoView.setTextColor(R.color.CAM_X0101);
            this.i = (ApkDownloadView) this.f16261c.findViewById(R.id.obfuscated_res_0x7f09009e);
            this.j = (TextView) this.f16261c.findViewById(R.id.obfuscated_res_0x7f0900f5);
            this.k = (ImageView) this.f16261c.findViewById(R.id.obfuscated_res_0x7f090092);
            this.l = (TextView) this.f16261c.findViewById(R.id.obfuscated_res_0x7f0900eb);
            this.f16262d.setRoundLayoutRadius(h(R.string.J_X05));
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.j);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0201);
            TbPageContext tbPageContext = this.a;
            if (tbPageContext != null) {
                this.i.k(tbPageContext.getUniqueId());
            }
            this.i.setTextSize(R.dimen.T_X08);
            this.i.setTextColorInitSkin(R.color.CAM_X0105);
            this.i.setTextColorSkin(R.color.CAM_X0105);
            this.i.setStrokeWidth(R.dimen.obfuscated_res_0x7f070228);
            this.i.setBackgroundSkin(R.drawable.obfuscated_res_0x7f080ed5);
            this.i.j();
            int[] p = n.p(TbadkCoreApplication.getInst());
            int i = p[0];
            int i2 = p[1];
            this.k.setOnClickListener(new a(this));
            this.f16261c.setOnClickListener(new b(this));
        }
    }

    public final void m(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo) == null) || this.p.contains(advertAppInfo)) {
            return;
        }
        this.p.add(advertAppInfo);
        c.a.p0.l3.m0.d.q(advertAppInfo);
        c.a.p0.b2.o.h.c.g(c.a.p0.b2.o.h.c.e(advertAppInfo));
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.n == null || this.o == null) {
            return;
        }
        e.d().j(this.n, this.o);
    }

    public DownloadData o(AdCard adCard, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, adCard, i)) == null) {
            DownloadData downloadData = new DownloadData(adCard.getDownloadId());
            downloadData.setUrl(adCard.downloadInfo.f16226b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i);
            downloadData.setNotifyId(c.a.d.f.m.b.e(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    @Override // c.a.p0.l3.o
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p();
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.n == null || this.o == null) {
            return;
        }
        e.d().r(this.n, this.o);
    }

    public final void q(AdvertAppInfo advertAppInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, advertAppInfo, gVar) == null) {
            AdCard adCard = (AdCard) advertAppInfo.i;
            this.m = adCard;
            if (adCard != null && !gVar.j && !gVar.k) {
                if (this.q.contains(advertAppInfo)) {
                    this.f16261c.setVisibility(8);
                    return;
                }
                this.f16261c.setVisibility(0);
                m(advertAppInfo);
                ((RelativeLayout.LayoutParams) this.f16261c.getLayoutParams()).bottomMargin = gVar.f9947h + n.f(TbadkCoreApplication.getInst(), R.dimen.tbds52);
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f16261c);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0214);
                this.f16263e.J(this.m.userImage, 17, false);
                this.f16264f.setText(this.m.userName);
                this.f16265g.setText(this.m.threadTitle);
                if (this.m.appInfoModel == null) {
                    this.f16266h.setVisibility(8);
                    this.l.setVisibility(0);
                    this.f16264f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X05));
                    this.f16265g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X07));
                    this.f16265g.setMaxLines(2);
                } else {
                    this.f16266h.setVisibility(0);
                    this.l.setVisibility(8);
                    this.f16266h.setAd(advertAppInfo);
                    this.f16266h.setAppInfo(this.m.appInfoModel);
                    this.f16264f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06));
                    this.f16265g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X08));
                    this.f16265g.setMaxLines(1);
                }
                if (advertAppInfo.i()) {
                    i();
                    j();
                    return;
                } else if (advertAppInfo.m()) {
                    k();
                    return;
                } else {
                    return;
                }
            }
            this.f16261c.setVisibility(8);
        }
    }
}

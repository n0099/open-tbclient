package c.a.t0.j3.i0.d.a;

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
import c.a.s0.e1.g;
import c.a.t0.j3.o;
import c.a.t0.j3.z;
import c.a.t0.v.g.e;
import c.a.t0.v.g.g.b;
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
/* loaded from: classes7.dex */
public class c implements o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f18903b;

    /* renamed from: c  reason: collision with root package name */
    public View f18904c;

    /* renamed from: d  reason: collision with root package name */
    public XfremodeRoundLayout f18905d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f18906e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f18907f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f18908g;

    /* renamed from: h  reason: collision with root package name */
    public AdAppInfoView f18909h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f18910i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f18911j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f18912k;
    public TextView l;
    public AdCard m;
    public DownloadCacheKey n;
    public c.a.t0.v.g.h.d o;
    public List<AdvertAppInfo> p;
    public List<AdvertAppInfo> q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18913e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18913e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.f18913e.m;
                this.f18913e.q.add(adCard.getAdvertAppInfo());
                c.a.t0.j3.l0.d.m(adCard.getAdvertAppInfo());
                this.f18913e.f18904c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18914e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18914e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.f18914e.m;
                String str = adCard.scheme;
                if (m.isEmpty(str)) {
                    return;
                }
                String str2 = adCard.ext;
                String downloadId = adCard.getDownloadId();
                int i2 = 3;
                if (!z.C(adCard.getAdvertAppInfo(), str)) {
                    int i3 = adCard.goodsStyle;
                    if ((i3 == 7 || i3 == 14) && adCard.videoInfo != null && adCard.getAdvertAppInfo() != null) {
                        i2 = z.g(TbadkCoreApplication.getInst(), str, adCard.getAdvertAppInfo(), adCard.playCmdScheme);
                    } else {
                        i2 = z.d(TbadkCoreApplication.getInst(), str, downloadId, str2, adCard.cmdScheme);
                    }
                }
                this.f18914e.f(i2, adCard);
            }
        }
    }

    /* renamed from: c.a.t0.j3.i0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1137c implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C1137c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.t0.v.g.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                AdCard adCard = this.a.m;
                c.a.t0.v.a.a(this.a.m.getButtonCmdScheme());
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = null;
        this.f18903b = viewStub;
        this.a = tbPageContext;
    }

    @Override // c.a.t0.j3.o
    public void a(AdvertAppInfo advertAppInfo, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, gVar) == null) {
            if (advertAppInfo == null) {
                View view = this.f18904c;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f18904c == null) {
                l(this.f18903b);
                this.p = new ArrayList();
                this.q = new ArrayList();
            }
            q(advertAppInfo, gVar);
        }
    }

    public final void f(int i2, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, adCard) == null) || i2 == 0) {
            return;
        }
        if (z.q(i2)) {
            c.a.t0.j3.l0.d.f(adCard.getAdvertAppInfo(), i2);
        } else {
            c.a.t0.j3.l0.d.n(adCard.getAdvertAppInfo());
        }
        c.a.t0.x1.o.h.c.h(c.a.t0.x1.o.h.c.e(adCard.getAdvertAppInfo()));
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
        if (z.r(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.m;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.m.getAdvertAppInfo().p4;
            b2.setExtInfo(this.m.getAdvertAppInfo().m4);
            b2.setDownloadKey(this.m.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.m.scheme);
            b2.setCmdScheme(this.m.cmdScheme);
        }
        e d2 = e.d();
        ApkDownloadView apkDownloadView = this.f18910i;
        c.a.t0.v.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.o = new c.a.t0.v.g.h.b(c2);
        if (b2.extra().getPercent() > 0) {
            c2.d(b2);
        }
        n();
        this.f18910i.onStatusChanged(b2.getCurrentState());
    }

    public float h(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            try {
                return Float.parseFloat(TbadkCoreApplication.getInst().getContext().getResources().getString(i2).split(",")[0]);
            } catch (NumberFormatException unused) {
                return 0.0f;
            }
        }
        return invokeI.floatValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f18911j.setVisibility(8);
            this.f18910i.setVisibility(0);
            AdCard adCard = this.m;
            c.a.t0.j3.i0.b.b bVar = adCard.downloadInfo;
            if (bVar == null) {
                return;
            }
            String str = bVar.a;
            DownloadData o = o(this.m, adCard.getPosition());
            if (z.r(str)) {
                o.setStatus(8);
            } else {
                o.setStatus(this.f18910i.getDownloadStatus());
            }
            this.f18910i.setData(o);
            this.f18910i.setOnClickInterceptListener(new C1137c(this));
        }
    }

    public final void j() {
        DownloadCacheKey i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AdCard adCard = this.m;
            String str = adCard.scheme;
            String downloadId = adCard.getDownloadId();
            if (!TextUtils.isEmpty(downloadId)) {
                i2 = e.d().h(downloadId);
            } else {
                i2 = e.d().i(str);
            }
            if (i2 == null) {
                c.a.t0.j3.i0.b.b bVar = this.m.downloadInfo;
                i2 = DownloadCacheKey.create(downloadId, bVar.f18863b, bVar.a);
                e.d().j(i2, null);
            }
            g(i2);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f18910i.setVisibility(8);
            c.a.t0.j3.i0.b.a aVar = this.m.operate;
            String str = aVar != null ? aVar.f18860b : null;
            if (TextUtils.isEmpty(str)) {
                str = "立即查看";
            }
            this.f18911j.setVisibility(0);
            this.f18911j.setText(str);
        }
    }

    public final void l(ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewStub) == null) {
            viewStub.setLayoutResource(R.layout.ad_pic_banner_layout);
            View inflate = viewStub.inflate();
            this.f18904c = inflate;
            this.f18905d = (XfremodeRoundLayout) inflate.findViewById(R.id.ad_img_container);
            this.f18906e = (TbImageView) this.f18904c.findViewById(R.id.ad_img);
            this.f18907f = (TextView) this.f18904c.findViewById(R.id.ad_brand_name);
            this.f18908g = (TextView) this.f18904c.findViewById(R.id.ad_title);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.f18904c.findViewById(R.id.ad_app_info_view);
            this.f18909h = adAppInfoView;
            adAppInfoView.setTextColor(R.color.CAM_X0101);
            this.f18910i = (ApkDownloadView) this.f18904c.findViewById(R.id.ad_download_btn);
            this.f18911j = (TextView) this.f18904c.findViewById(R.id.ad_transform_btn);
            this.f18912k = (ImageView) this.f18904c.findViewById(R.id.ad_close_view);
            this.l = (TextView) this.f18904c.findViewById(R.id.ad_tag);
            this.f18905d.setRoundLayoutRadius(h(R.string.J_X05));
            SkinManager.setViewTextColor(this.f18911j, R.color.CAM_X0105, 1);
            c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f18911j);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0201);
            TbPageContext tbPageContext = this.a;
            if (tbPageContext != null) {
                this.f18910i.enableDownloadListener(tbPageContext.getUniqueId());
            }
            this.f18910i.setTextSize(R.dimen.T_X08);
            this.f18910i.setTextColorInitSkin(R.color.CAM_X0105);
            this.f18910i.setTextColorSkin(R.color.CAM_X0105);
            this.f18910i.setStrokeWidth(R.dimen.ds0);
            this.f18910i.setBackgroundSkin(R.drawable.pic_banner_down_btn_bg);
            this.f18910i.changeSkin();
            int[] p = n.p(TbadkCoreApplication.getInst());
            int i2 = p[0];
            int i3 = p[1];
            this.f18912k.setOnClickListener(new a(this));
            this.f18904c.setOnClickListener(new b(this));
        }
    }

    public final void m(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo) == null) || this.p.contains(advertAppInfo)) {
            return;
        }
        this.p.add(advertAppInfo);
        c.a.t0.j3.l0.d.q(advertAppInfo);
        c.a.t0.x1.o.h.c.g(c.a.t0.x1.o.h.c.e(advertAppInfo));
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.n == null || this.o == null) {
            return;
        }
        e.d().j(this.n, this.o);
    }

    public DownloadData o(AdCard adCard, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, adCard, i2)) == null) {
            DownloadData downloadData = new DownloadData(adCard.getDownloadId());
            downloadData.setUrl(adCard.downloadInfo.f18863b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.d.f.m.b.e(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    @Override // c.a.t0.j3.o
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
            AdCard adCard = (AdCard) advertAppInfo.n4;
            this.m = adCard;
            if (adCard != null && !gVar.f12671j && !gVar.f12672k) {
                if (this.q.contains(advertAppInfo)) {
                    this.f18904c.setVisibility(8);
                    return;
                }
                this.f18904c.setVisibility(0);
                m(advertAppInfo);
                ((RelativeLayout.LayoutParams) this.f18904c.getLayoutParams()).bottomMargin = gVar.f12669h + n.f(TbadkCoreApplication.getInst(), R.dimen.tbds52);
                c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(this.f18904c);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0214);
                this.f18906e.startLoad(this.m.userImage, 17, false);
                this.f18907f.setText(this.m.userName);
                this.f18908g.setText(this.m.threadTitle);
                if (this.m.appInfoModel == null) {
                    this.f18909h.setVisibility(8);
                    this.l.setVisibility(0);
                    this.f18907f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X05));
                    this.f18908g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X07));
                    this.f18908g.setMaxLines(2);
                } else {
                    this.f18909h.setVisibility(0);
                    this.l.setVisibility(8);
                    this.f18909h.setAd(advertAppInfo);
                    this.f18909h.setAppInfo(this.m.appInfoModel);
                    this.f18907f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06));
                    this.f18908g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X08));
                    this.f18908g.setMaxLines(1);
                }
                if (advertAppInfo.V4()) {
                    i();
                    j();
                    return;
                } else if (advertAppInfo.X4()) {
                    k();
                    return;
                } else {
                    return;
                }
            }
            this.f18904c.setVisibility(8);
        }
    }
}

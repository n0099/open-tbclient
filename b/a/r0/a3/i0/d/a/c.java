package b.a.r0.a3.i0.d.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import b.a.e.f.p.l;
import b.a.q0.c1.e;
import b.a.r0.a3.o;
import b.a.r0.a3.z;
import b.a.r0.r.e.g.b;
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
/* loaded from: classes4.dex */
public class c implements o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f15777a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f15778b;

    /* renamed from: c  reason: collision with root package name */
    public View f15779c;

    /* renamed from: d  reason: collision with root package name */
    public XfremodeRoundLayout f15780d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f15781e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15782f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15783g;

    /* renamed from: h  reason: collision with root package name */
    public AdAppInfoView f15784h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f15785i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public AdCard m;
    public DownloadCacheKey n;
    public b.a.r0.r.e.h.d o;
    public List<AdvertAppInfo> p;
    public List<AdvertAppInfo> q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15786e;

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
            this.f15786e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.f15786e.m;
                this.f15786e.q.add(adCard.getAdvertAppInfo());
                b.a.r0.a3.l0.d.m(adCard.getAdvertAppInfo());
                this.f15786e.f15779c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15787e;

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
            this.f15787e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.f15787e.m;
                String str = adCard.scheme;
                if (k.isEmpty(str)) {
                    return;
                }
                String str2 = adCard.ext;
                String downloadId = adCard.getDownloadId();
                int i2 = 3;
                if (!z.B(adCard.getAdvertAppInfo(), str)) {
                    int i3 = adCard.goodsStyle;
                    if ((i3 == 7 || i3 == 14) && adCard.videoInfo != null && adCard.getAdvertAppInfo() != null) {
                        i2 = z.g(TbadkCoreApplication.getInst(), str, adCard.getAdvertAppInfo());
                    } else {
                        i2 = z.d(TbadkCoreApplication.getInst(), str, downloadId, str2);
                    }
                }
                this.f15787e.f(i2, adCard);
            }
        }
    }

    /* renamed from: b.a.r0.a3.i0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0795c implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f15788a;

        public C0795c(c cVar) {
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
            this.f15788a = cVar;
        }

        @Override // b.a.r0.r.e.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f15788a.f(1, this.f15788a.m);
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
        this.f15778b = viewStub;
        this.f15777a = tbPageContext;
    }

    @Override // b.a.r0.a3.o
    public void a(AdvertAppInfo advertAppInfo, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, eVar) == null) {
            if (advertAppInfo == null) {
                View view = this.f15779c;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f15779c == null) {
                l(this.f15778b);
                this.p = new ArrayList();
                this.q = new ArrayList();
            }
            q(advertAppInfo, eVar);
        }
    }

    public final void f(int i2, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, adCard) == null) || i2 == 0) {
            return;
        }
        if (z.p(i2)) {
            b.a.r0.a3.l0.d.f(adCard.getAdvertAppInfo(), i2);
        } else {
            b.a.r0.a3.l0.d.n(adCard.getAdvertAppInfo());
        }
        b.a.r0.q1.o.h.c.h(b.a.r0.q1.o.h.c.e(adCard.getAdvertAppInfo()));
    }

    public void g(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.n = downloadCacheKey;
        p();
        this.o = null;
        AdDownloadData b2 = b.a.r0.r.e.e.c().b(downloadCacheKey);
        if (z.q(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.m;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.m.getAdvertAppInfo().i4;
            b2.setExtInfo(this.m.getAdvertAppInfo().f4);
            b2.setDownloadKey(this.m.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.m.scheme);
        }
        b.a.r0.r.d.b.d.a aVar = new b.a.r0.r.d.b.d.a(this.f15785i, b2);
        this.o = new b.a.r0.r.e.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        n();
        this.f15785i.onStatusChanged(b2.getCurrentState());
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
            this.j.setVisibility(8);
            this.f15785i.setVisibility(0);
            AdCard adCard = this.m;
            b.a.r0.a3.i0.b.b bVar = adCard.downloadInfo;
            if (bVar == null) {
                return;
            }
            String str = bVar.f15731a;
            DownloadData o = o(this.m, adCard.getPosition());
            if (z.q(str)) {
                o.setStatus(8);
            } else {
                o.setStatus(this.f15785i.getDownloadStatus());
            }
            this.f15785i.setData(o);
            this.f15785i.setOnClickInterceptListener(new C0795c(this));
        }
    }

    public final void j() {
        DownloadCacheKey h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            AdCard adCard = this.m;
            String str = adCard.scheme;
            String downloadId = adCard.getDownloadId();
            if (!TextUtils.isEmpty(downloadId)) {
                h2 = b.a.r0.r.e.e.c().g(downloadId);
            } else {
                h2 = b.a.r0.r.e.e.c().h(str);
            }
            if (h2 == null) {
                b.a.r0.a3.i0.b.b bVar = this.m.downloadInfo;
                h2 = DownloadCacheKey.create(downloadId, bVar.f15732b, bVar.f15731a);
                b.a.r0.r.e.e.c().i(h2, null);
            }
            g(h2);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f15785i.setVisibility(8);
            b.a.r0.a3.i0.b.a aVar = this.m.operate;
            String str = aVar != null ? aVar.f15729b : null;
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
            viewStub.setLayoutResource(R.layout.ad_pic_banner_layout);
            View inflate = viewStub.inflate();
            this.f15779c = inflate;
            this.f15780d = (XfremodeRoundLayout) inflate.findViewById(R.id.ad_img_container);
            this.f15781e = (TbImageView) this.f15779c.findViewById(R.id.ad_img);
            this.f15782f = (TextView) this.f15779c.findViewById(R.id.ad_brand_name);
            this.f15783g = (TextView) this.f15779c.findViewById(R.id.ad_title);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.f15779c.findViewById(R.id.ad_app_info_view);
            this.f15784h = adAppInfoView;
            adAppInfoView.setTextColor(R.color.CAM_X0101);
            this.f15785i = (ApkDownloadView) this.f15779c.findViewById(R.id.ad_download_btn);
            this.j = (TextView) this.f15779c.findViewById(R.id.ad_transform_btn);
            this.k = (ImageView) this.f15779c.findViewById(R.id.ad_close_view);
            this.l = (TextView) this.f15779c.findViewById(R.id.ad_tag);
            this.f15780d.setRoundLayoutRadius(h(R.string.J_X05));
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.j);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0201);
            TbPageContext tbPageContext = this.f15777a;
            if (tbPageContext != null) {
                this.f15785i.enableDownloadListener(tbPageContext.getUniqueId());
            }
            this.f15785i.setTextSize(R.dimen.T_X08);
            this.f15785i.setTextColorInitSkin(R.color.CAM_X0105);
            this.f15785i.setTextColorSkin(R.color.CAM_X0105);
            this.f15785i.setStrokeWidth(R.dimen.ds0);
            this.f15785i.setBackgroundSkin(R.drawable.pic_banner_down_btn_bg);
            this.f15785i.changeSkin();
            int[] p = l.p(TbadkCoreApplication.getInst());
            int i2 = p[0];
            int i3 = p[1];
            this.k.setOnClickListener(new a(this));
            this.f15779c.setOnClickListener(new b(this));
        }
    }

    public final void m(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo) == null) || this.p.contains(advertAppInfo)) {
            return;
        }
        this.p.add(advertAppInfo);
        b.a.r0.a3.l0.d.q(advertAppInfo);
        b.a.r0.q1.o.h.c.g(b.a.r0.q1.o.h.c.e(advertAppInfo));
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.n == null || this.o == null) {
            return;
        }
        b.a.r0.r.e.e.c().i(this.n, this.o);
    }

    public DownloadData o(AdCard adCard, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, adCard, i2)) == null) {
            DownloadData downloadData = new DownloadData(adCard.getDownloadId());
            downloadData.setUrl(adCard.downloadInfo.f15732b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(b.a.e.f.m.b.e(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    @Override // b.a.r0.a3.o
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
        b.a.r0.r.e.e.c().q(this.n, this.o);
    }

    public final void q(AdvertAppInfo advertAppInfo, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, advertAppInfo, eVar) == null) {
            AdCard adCard = (AdCard) advertAppInfo.g4;
            this.m = adCard;
            if (adCard != null && !eVar.j && !eVar.k) {
                if (this.q.contains(advertAppInfo)) {
                    this.f15779c.setVisibility(8);
                    return;
                }
                this.f15779c.setVisibility(0);
                m(advertAppInfo);
                ((RelativeLayout.LayoutParams) this.f15779c.getLayoutParams()).bottomMargin = eVar.f12770h + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
                b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f15779c);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0214);
                this.f15781e.startLoad(this.m.userImage, 17, false);
                this.f15782f.setText(this.m.userName);
                this.f15783g.setText(this.m.threadTitle);
                if (this.m.appInfoModel == null) {
                    this.f15784h.setVisibility(8);
                    this.l.setVisibility(0);
                    this.f15782f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X05));
                    this.f15783g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X07));
                    this.f15783g.setMaxLines(2);
                } else {
                    this.f15784h.setVisibility(0);
                    this.l.setVisibility(8);
                    this.f15784h.setAd(advertAppInfo);
                    this.f15784h.setAppInfo(this.m.appInfoModel);
                    this.f15782f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06));
                    this.f15783g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X08));
                    this.f15783g.setMaxLines(1);
                }
                if (advertAppInfo.T4()) {
                    i();
                    j();
                    return;
                } else if (advertAppInfo.V4()) {
                    k();
                    return;
                } else {
                    return;
                }
            }
            this.f15779c.setVisibility(8);
        }
    }
}

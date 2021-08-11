package c.a.p0.x2.i0.d.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.q.d.e;
import c.a.p0.q.d.g.b;
import c.a.p0.x2.o;
import c.a.p0.x2.z;
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
    public TbPageContext f28577a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f28578b;

    /* renamed from: c  reason: collision with root package name */
    public View f28579c;

    /* renamed from: d  reason: collision with root package name */
    public XfremodeRoundLayout f28580d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f28581e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28582f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f28583g;

    /* renamed from: h  reason: collision with root package name */
    public AdAppInfoView f28584h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f28585i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f28586j;
    public ImageView k;
    public TextView l;
    public AdCard m;
    public DownloadCacheKey n;
    public c.a.p0.q.d.h.d o;
    public List<AdvertAppInfo> p;
    public List<AdvertAppInfo> q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f28587e;

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
            this.f28587e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.f28587e.m;
                this.f28587e.q.add(adCard.getAdvertAppInfo());
                c.a.p0.x2.l0.d.l(adCard.getAdvertAppInfo());
                this.f28587e.f28579c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f28588e;

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
            this.f28588e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.f28588e.m;
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
                this.f28588e.f(i2, adCard);
            }
        }
    }

    /* renamed from: c.a.p0.x2.i0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1335c implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f28589a;

        public C1335c(c cVar) {
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
            this.f28589a = cVar;
        }

        @Override // c.a.p0.q.d.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f28589a.f(1, this.f28589a.m);
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
        this.f28578b = viewStub;
        this.f28577a = tbPageContext;
    }

    @Override // c.a.p0.x2.o
    public void a(AdvertAppInfo advertAppInfo, c.a.o0.b1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, cVar) == null) {
            if (advertAppInfo == null) {
                View view = this.f28579c;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f28579c == null) {
                l(this.f28578b);
                this.p = new ArrayList();
                this.q = new ArrayList();
            }
            q(advertAppInfo, cVar);
        }
    }

    public final void f(int i2, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, adCard) == null) || i2 == 0) {
            return;
        }
        if (z.p(i2)) {
            c.a.p0.x2.l0.d.e(adCard.getAdvertAppInfo(), i2);
        } else {
            c.a.p0.x2.l0.d.m(adCard.getAdvertAppInfo());
        }
        c.a.p0.o1.o.h.c.h(c.a.p0.o1.o.h.c.e(adCard.getAdvertAppInfo()));
    }

    public void g(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.n = downloadCacheKey;
        p();
        this.o = null;
        AdDownloadData b2 = e.c().b(downloadCacheKey);
        if (z.q(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.m;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.m.getAdvertAppInfo().d4;
            b2.setExtInfo(this.m.getAdvertAppInfo().a4);
            b2.setDownloadKey(this.m.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.m.scheme);
        }
        c.a.p0.q.c.b.d.a aVar = new c.a.p0.q.c.b.d.a(this.f28585i, b2);
        this.o = new c.a.p0.q.d.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        n();
        this.f28585i.onStatusChanged(b2.getCurrentState());
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
            this.f28586j.setVisibility(8);
            this.f28585i.setVisibility(0);
            AdCard adCard = this.m;
            c.a.p0.x2.i0.b.b bVar = adCard.downloadInfo;
            if (bVar == null) {
                return;
            }
            String str = bVar.f28531a;
            DownloadData o = o(this.m, adCard.getPosition());
            if (z.q(str)) {
                o.setStatus(8);
            } else {
                o.setStatus(this.f28585i.getDownloadStatus());
            }
            this.f28585i.setData(o);
            this.f28585i.setOnClickInterceptListener(new C1335c(this));
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
                h2 = e.c().g(downloadId);
            } else {
                h2 = e.c().h(str);
            }
            if (h2 == null) {
                c.a.p0.x2.i0.b.b bVar = this.m.downloadInfo;
                h2 = DownloadCacheKey.create(downloadId, bVar.f28532b, bVar.f28531a);
                e.c().i(h2, null);
            }
            g(h2);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f28585i.setVisibility(8);
            c.a.p0.x2.i0.b.a aVar = this.m.operate;
            String str = aVar != null ? aVar.f28529b : null;
            if (TextUtils.isEmpty(str)) {
                str = "立即查看";
            }
            this.f28586j.setVisibility(0);
            this.f28586j.setText(str);
        }
    }

    public final void l(ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewStub) == null) {
            viewStub.setLayoutResource(R.layout.ad_pic_banner_layout);
            View inflate = viewStub.inflate();
            this.f28579c = inflate;
            this.f28580d = (XfremodeRoundLayout) inflate.findViewById(R.id.ad_img_container);
            this.f28581e = (TbImageView) this.f28579c.findViewById(R.id.ad_img);
            this.f28582f = (TextView) this.f28579c.findViewById(R.id.ad_brand_name);
            this.f28583g = (TextView) this.f28579c.findViewById(R.id.ad_title);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.f28579c.findViewById(R.id.ad_app_info_view);
            this.f28584h = adAppInfoView;
            adAppInfoView.setTextColor(R.color.CAM_X0101);
            this.f28585i = (ApkDownloadView) this.f28579c.findViewById(R.id.ad_download_btn);
            this.f28586j = (TextView) this.f28579c.findViewById(R.id.ad_transform_btn);
            this.k = (ImageView) this.f28579c.findViewById(R.id.ad_close_view);
            this.l = (TextView) this.f28579c.findViewById(R.id.ad_tag);
            this.f28580d.setRoundLayoutRadius(h(R.string.J_X05));
            SkinManager.setViewTextColor(this.f28586j, R.color.CAM_X0105, 1);
            c.a.o0.s.u.c d2 = c.a.o0.s.u.c.d(this.f28586j);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0201);
            TbPageContext tbPageContext = this.f28577a;
            if (tbPageContext != null) {
                this.f28585i.enableDownloadListener(tbPageContext.getUniqueId());
            }
            this.f28585i.setTextSize(R.dimen.T_X08);
            this.f28585i.setTextColorInitSkin(R.color.CAM_X0105);
            this.f28585i.setTextColorSkin(R.color.CAM_X0105);
            this.f28585i.setStrokeWidth(R.dimen.ds0);
            this.f28585i.setBackgroundSkin(R.drawable.pic_banner_down_btn_bg);
            this.f28585i.changeSkin();
            int[] p = l.p(TbadkCoreApplication.getInst());
            int i2 = p[0];
            int i3 = p[1];
            this.k.setOnClickListener(new a(this));
            this.f28579c.setOnClickListener(new b(this));
        }
    }

    public final void m(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo) == null) || this.p.contains(advertAppInfo)) {
            return;
        }
        this.p.add(advertAppInfo);
        c.a.p0.x2.l0.d.p(advertAppInfo);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.n == null || this.o == null) {
            return;
        }
        e.c().i(this.n, this.o);
    }

    public DownloadData o(AdCard adCard, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, adCard, i2)) == null) {
            DownloadData downloadData = new DownloadData(adCard.getDownloadId());
            downloadData.setUrl(adCard.downloadInfo.f28532b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.e.e.m.b.d(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    @Override // c.a.p0.x2.o
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
        e.c().q(this.n, this.o);
    }

    public final void q(AdvertAppInfo advertAppInfo, c.a.o0.b1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, advertAppInfo, cVar) == null) {
            AdCard adCard = (AdCard) advertAppInfo.b4;
            this.m = adCard;
            if (adCard != null && !cVar.f12560j && !cVar.k) {
                if (this.q.contains(advertAppInfo)) {
                    this.f28579c.setVisibility(8);
                    return;
                }
                this.f28579c.setVisibility(0);
                m(advertAppInfo);
                ((RelativeLayout.LayoutParams) this.f28579c.getLayoutParams()).bottomMargin = cVar.f12558h + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
                c.a.o0.s.u.c d2 = c.a.o0.s.u.c.d(this.f28579c);
                d2.n(R.string.J_X06);
                d2.f(R.color.CAM_X0214);
                this.f28581e.startLoad(this.m.userImage, 17, false);
                this.f28582f.setText(this.m.userName);
                this.f28583g.setText(this.m.threadTitle);
                if (this.m.appInfoModel == null) {
                    this.f28584h.setVisibility(8);
                    this.l.setVisibility(0);
                    this.f28582f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X05));
                    this.f28583g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X07));
                    this.f28583g.setMaxLines(2);
                } else {
                    this.f28584h.setVisibility(0);
                    this.l.setVisibility(8);
                    this.f28584h.setAd(advertAppInfo);
                    this.f28584h.setAppInfo(this.m.appInfoModel);
                    this.f28582f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06));
                    this.f28583g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X08));
                    this.f28583g.setMaxLines(1);
                }
                if (advertAppInfo.F4()) {
                    i();
                    j();
                    return;
                } else if (advertAppInfo.H4()) {
                    k();
                    return;
                } else {
                    return;
                }
            }
            this.f28579c.setVisibility(8);
        }
    }
}

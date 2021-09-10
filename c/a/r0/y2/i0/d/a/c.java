package c.a.r0.y2.i0.d.a;

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
import c.a.r0.q.e.e;
import c.a.r0.q.e.g.b;
import c.a.r0.y2.o;
import c.a.r0.y2.z;
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
    public TbPageContext f29535a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStub f29536b;

    /* renamed from: c  reason: collision with root package name */
    public View f29537c;

    /* renamed from: d  reason: collision with root package name */
    public XfremodeRoundLayout f29538d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f29539e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f29540f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f29541g;

    /* renamed from: h  reason: collision with root package name */
    public AdAppInfoView f29542h;

    /* renamed from: i  reason: collision with root package name */
    public ApkDownloadView f29543i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f29544j;
    public ImageView k;
    public TextView l;
    public AdCard m;
    public DownloadCacheKey n;
    public c.a.r0.q.e.h.d o;
    public List<AdvertAppInfo> p;
    public List<AdvertAppInfo> q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f29545e;

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
            this.f29545e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.f29545e.m;
                this.f29545e.q.add(adCard.getAdvertAppInfo());
                c.a.r0.y2.l0.d.l(adCard.getAdvertAppInfo());
                this.f29545e.f29537c.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f29546e;

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
            this.f29546e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                AdCard adCard = this.f29546e.m;
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
                this.f29546e.f(i2, adCard);
            }
        }
    }

    /* renamed from: c.a.r0.y2.i0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1379c implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f29547a;

        public C1379c(c cVar) {
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
            this.f29547a = cVar;
        }

        @Override // c.a.r0.q.e.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f29547a.f(1, this.f29547a.m);
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
        this.f29536b = viewStub;
        this.f29535a = tbPageContext;
    }

    @Override // c.a.r0.y2.o
    public void a(AdvertAppInfo advertAppInfo, c.a.q0.d1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, advertAppInfo, cVar) == null) {
            if (advertAppInfo == null) {
                View view = this.f29537c;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f29537c == null) {
                l(this.f29536b);
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
            c.a.r0.y2.l0.d.e(adCard.getAdvertAppInfo(), i2);
        } else {
            c.a.r0.y2.l0.d.m(adCard.getAdvertAppInfo());
        }
        c.a.r0.p1.o.h.c.h(c.a.r0.p1.o.h.c.e(adCard.getAdvertAppInfo()));
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
            String str = this.m.getAdvertAppInfo().g4;
            b2.setExtInfo(this.m.getAdvertAppInfo().d4);
            b2.setDownloadKey(this.m.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.m.scheme);
        }
        c.a.r0.q.d.b.d.a aVar = new c.a.r0.q.d.b.d.a(this.f29543i, b2);
        this.o = new c.a.r0.q.e.h.b(aVar);
        if (b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        n();
        this.f29543i.onStatusChanged(b2.getCurrentState());
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
            this.f29544j.setVisibility(8);
            this.f29543i.setVisibility(0);
            AdCard adCard = this.m;
            c.a.r0.y2.i0.b.b bVar = adCard.downloadInfo;
            if (bVar == null) {
                return;
            }
            String str = bVar.f29487a;
            DownloadData o = o(this.m, adCard.getPosition());
            if (z.q(str)) {
                o.setStatus(8);
            } else {
                o.setStatus(this.f29543i.getDownloadStatus());
            }
            this.f29543i.setData(o);
            this.f29543i.setOnClickInterceptListener(new C1379c(this));
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
                c.a.r0.y2.i0.b.b bVar = this.m.downloadInfo;
                h2 = DownloadCacheKey.create(downloadId, bVar.f29488b, bVar.f29487a);
                e.c().i(h2, null);
            }
            g(h2);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f29543i.setVisibility(8);
            c.a.r0.y2.i0.b.a aVar = this.m.operate;
            String str = aVar != null ? aVar.f29485b : null;
            if (TextUtils.isEmpty(str)) {
                str = "立即查看";
            }
            this.f29544j.setVisibility(0);
            this.f29544j.setText(str);
        }
    }

    public final void l(ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewStub) == null) {
            viewStub.setLayoutResource(R.layout.ad_pic_banner_layout);
            View inflate = viewStub.inflate();
            this.f29537c = inflate;
            this.f29538d = (XfremodeRoundLayout) inflate.findViewById(R.id.ad_img_container);
            this.f29539e = (TbImageView) this.f29537c.findViewById(R.id.ad_img);
            this.f29540f = (TextView) this.f29537c.findViewById(R.id.ad_brand_name);
            this.f29541g = (TextView) this.f29537c.findViewById(R.id.ad_title);
            AdAppInfoView adAppInfoView = (AdAppInfoView) this.f29537c.findViewById(R.id.ad_app_info_view);
            this.f29542h = adAppInfoView;
            adAppInfoView.setTextColor(R.color.CAM_X0101);
            this.f29543i = (ApkDownloadView) this.f29537c.findViewById(R.id.ad_download_btn);
            this.f29544j = (TextView) this.f29537c.findViewById(R.id.ad_transform_btn);
            this.k = (ImageView) this.f29537c.findViewById(R.id.ad_close_view);
            this.l = (TextView) this.f29537c.findViewById(R.id.ad_tag);
            this.f29538d.setRoundLayoutRadius(h(R.string.J_X05));
            SkinManager.setViewTextColor(this.f29544j, R.color.CAM_X0105, 1);
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f29544j);
            d2.o(R.string.J_X01);
            d2.f(R.color.CAM_X0201);
            TbPageContext tbPageContext = this.f29535a;
            if (tbPageContext != null) {
                this.f29543i.enableDownloadListener(tbPageContext.getUniqueId());
            }
            this.f29543i.setTextSize(R.dimen.T_X08);
            this.f29543i.setTextColorInitSkin(R.color.CAM_X0105);
            this.f29543i.setTextColorSkin(R.color.CAM_X0105);
            this.f29543i.setStrokeWidth(R.dimen.ds0);
            this.f29543i.setBackgroundSkin(R.drawable.pic_banner_down_btn_bg);
            this.f29543i.changeSkin();
            int[] p = l.p(TbadkCoreApplication.getInst());
            int i2 = p[0];
            int i3 = p[1];
            this.k.setOnClickListener(new a(this));
            this.f29537c.setOnClickListener(new b(this));
        }
    }

    public final void m(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, advertAppInfo) == null) || this.p.contains(advertAppInfo)) {
            return;
        }
        this.p.add(advertAppInfo);
        c.a.r0.y2.l0.d.p(advertAppInfo);
        c.a.r0.p1.o.h.c.g(c.a.r0.p1.o.h.c.e(advertAppInfo));
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
            downloadData.setUrl(adCard.downloadInfo.f29488b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.e.e.m.b.e(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    @Override // c.a.r0.y2.o
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

    public final void q(AdvertAppInfo advertAppInfo, c.a.q0.d1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, advertAppInfo, cVar) == null) {
            AdCard adCard = (AdCard) advertAppInfo.e4;
            this.m = adCard;
            if (adCard != null && !cVar.f12903j && !cVar.k) {
                if (this.q.contains(advertAppInfo)) {
                    this.f29537c.setVisibility(8);
                    return;
                }
                this.f29537c.setVisibility(0);
                m(advertAppInfo);
                ((RelativeLayout.LayoutParams) this.f29537c.getLayoutParams()).bottomMargin = cVar.f12901h + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
                c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.f29537c);
                d2.o(R.string.J_X06);
                d2.f(R.color.CAM_X0214);
                this.f29539e.startLoad(this.m.userImage, 17, false);
                this.f29540f.setText(this.m.userName);
                this.f29541g.setText(this.m.threadTitle);
                if (this.m.appInfoModel == null) {
                    this.f29542h.setVisibility(8);
                    this.l.setVisibility(0);
                    this.f29540f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X05));
                    this.f29541g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X07));
                    this.f29541g.setMaxLines(2);
                } else {
                    this.f29542h.setVisibility(0);
                    this.l.setVisibility(8);
                    this.f29542h.setAd(advertAppInfo);
                    this.f29542h.setAppInfo(this.m.appInfoModel);
                    this.f29540f.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X06));
                    this.f29541g.setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.T_X08));
                    this.f29541g.setMaxLines(1);
                }
                if (advertAppInfo.Q4()) {
                    i();
                    j();
                    return;
                } else if (advertAppInfo.S4()) {
                    k();
                    return;
                } else {
                    return;
                }
            }
            this.f29537c.setVisibility(8);
        }
    }
}

package c.a.p0.l3.n0;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.l3.a0;
import c.a.p0.l3.j0.b.h;
import c.a.p0.x.g.g.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout i;
    public RoundTbImageView j;
    public TextView k;
    public TextView l;
    public ApkDownloadView m;
    public TextView n;
    public CountDownTextView o;
    public AdAppInfoView p;
    public DownloadCacheKey q;
    public c.a.p0.x.g.h.d r;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
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
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.a.f16322h) == null) {
                return;
            }
            onClickListener.onClick(view);
            this.a.o.c();
        }
    }

    /* renamed from: c.a.p0.l3.n0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1216c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f16311b;

        public View$OnClickListenerC1216c(c cVar, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16311b = cVar;
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.a.f16244d;
                if (a0.C(this.f16311b.f16318d, str)) {
                    i = 3;
                } else {
                    AdvertAppInfo advertAppInfo = this.f16311b.f16318d;
                    i = a0.e(this.f16311b.f16320f, str, advertAppInfo.i() ? this.f16311b.f16318d.getDownloadId() : this.f16311b.f16318d.a, advertAppInfo.f29821h, this.a.j);
                }
                if (i == 0) {
                    return;
                }
                AdvertAppInfo advertAppInfo2 = this.f16311b.f16318d;
                c.a.p0.l3.m0.c b2 = c.a.p0.l3.m0.g.b(advertAppInfo2, 2, advertAppInfo2.position);
                b2.h("VIDEO_FLOW_TAIL");
                c.a.p0.l3.m0.e.b().d(b2);
                c.a.p0.b2.o.h.c.h(c.a.p0.b2.o.h.c.e(this.f16311b.f16318d));
                this.f16311b.o.c();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public d(c cVar) {
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
                c.a.p0.x.a.a(this.a.f16321g.getButtonCmdScheme());
                c.a.p0.b2.o.h.c.h(c.a.p0.b2.o.h.c.e(this.a.f16318d));
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View view, String str) {
        super(view, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p();
    }

    @Override // c.a.p0.l3.n0.g
    public void d(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            super.d(hVar);
            if (hVar == null) {
                return;
            }
            this.j.J(hVar.f16243c, 30, false);
            this.k.setText(hVar.f16242b);
            this.l.setText(hVar.i);
            this.n.setOnClickListener(new b(this));
            this.o.setFormatString(this.f16320f.getResources().getString(R.string.obfuscated_res_0x7f0f00b4));
            this.i.setOnClickListener(new View$OnClickListenerC1216c(this, hVar));
            AdvertAppInfo advertAppInfo = this.f16318d;
            if (advertAppInfo == null || this.f16321g == null || !advertAppInfo.i()) {
                return;
            }
            this.p.setAd(this.f16318d);
            this.p.setAppInfo(this.f16318d.i.getAppInfoModel());
            q();
            r();
        }
    }

    @Override // c.a.p0.l3.n0.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e();
            this.o.update(5);
            this.o.e();
            s();
            AdvertAppInfo advertAppInfo = this.f16318d;
            c.a.p0.l3.m0.e.b().d(c.a.p0.l3.m0.g.b(advertAppInfo, 103, advertAppInfo.position));
        }
    }

    @Override // c.a.p0.l3.n0.g
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.f();
            u();
        }
    }

    @Override // c.a.p0.l3.n0.g
    public void m(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            super.m(cVar);
            this.o.setTimeoutListener(cVar);
        }
    }

    public void o(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.q = downloadCacheKey;
        u();
        this.r = null;
        AdDownloadData b2 = c.a.p0.x.g.e.d().b(downloadCacheKey);
        if (a0.r(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.f16321g;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.f16321g.getAdvertAppInfo().k;
            b2.setExtInfo(this.f16321g.getAdvertAppInfo().f29821h);
            b2.setDownloadKey(this.f16321g.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.f16321g.scheme);
            b2.setCmdScheme(this.f16321g.cmdScheme);
        }
        c.a.p0.x.g.e d2 = c.a.p0.x.g.e.d();
        ApkDownloadView apkDownloadView = this.m;
        c.a.p0.x.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.r = new c.a.p0.x.g.h.b(c2);
        if (b2.extra().getPercent() > 0) {
            c2.e(b2);
        }
        s();
        this.m.d(b2.getCurrentState());
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f16316b.setOnClickListener(new a(this));
            this.i = (RelativeLayout) b(R.id.obfuscated_res_0x7f090094);
            this.j = (RoundTbImageView) b(R.id.obfuscated_res_0x7f0922a1);
            this.k = (TextView) b(R.id.obfuscated_res_0x7f0922bb);
            this.l = (TextView) b(R.id.obfuscated_res_0x7f09229d);
            this.m = (ApkDownloadView) b(R.id.obfuscated_res_0x7f090817);
            this.n = (TextView) b(R.id.obfuscated_res_0x7f091a47);
            this.o = (CountDownTextView) b(R.id.obfuscated_res_0x7f0906fa);
            this.p = (AdAppInfoView) b(R.id.obfuscated_res_0x7f0900b0);
            this.m.setTextColorInitSkin(R.color.CAM_X0101);
            this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.m.setTextSize(R.dimen.T_X06);
            this.m.setForegroundSkin(R.color.black_alpha15);
            this.m.setBackgroundSkin(R.drawable.obfuscated_res_0x7f08122e);
            this.m.setRatio(0);
            this.m.j();
        }
    }

    public final void q() {
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (adCard = this.f16321g) == null || adCard.downloadInfo == null) {
            return;
        }
        this.m.setInitText(adCard.operate.f16223b);
        AdCard adCard2 = this.f16321g;
        String str = adCard2.downloadInfo.a;
        DownloadData t = t(this.f16321g, adCard2.getPosition());
        if (a0.r(str)) {
            t.setStatus(8);
        } else {
            t.setStatus(this.m.getDownloadStatus());
        }
        this.m.setData(t);
        this.m.setOnClickInterceptListener(new d(this));
    }

    public final void r() {
        DownloadCacheKey i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            AdCard adCard = this.f16321g;
            String str = adCard.scheme;
            String downloadId = adCard.getDownloadId();
            if (!TextUtils.isEmpty(downloadId)) {
                i = c.a.p0.x.g.e.d().h(downloadId);
            } else {
                i = c.a.p0.x.g.e.d().i(str);
            }
            if (i == null) {
                c.a.p0.l3.j0.b.b bVar = this.f16321g.downloadInfo;
                i = DownloadCacheKey.create(downloadId, bVar.f16226b, bVar.a);
                c.a.p0.x.g.e.d().j(i, null);
            }
            o(i);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.q == null || this.r == null) {
            return;
        }
        c.a.p0.x.g.e.d().j(this.q, this.r);
    }

    public DownloadData t(AdCard adCard, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, adCard, i)) == null) {
            DownloadData downloadData = new DownloadData(adCard.getDownloadId());
            downloadData.setUrl(adCard.downloadInfo.f16226b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i);
            downloadData.setNotifyId(c.a.d.f.m.b.e(adCard.adId, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.q == null || this.r == null) {
            return;
        }
        c.a.p0.x.g.e.d().r(this.q, this.r);
    }
}

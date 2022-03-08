package c.a.r0.j3.n0;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.j3.a0;
import c.a.r0.j3.j0.b.h;
import c.a.r0.v.g.g.b;
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

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f18556i;

    /* renamed from: j  reason: collision with root package name */
    public RoundTbImageView f18557j;
    public TextView k;
    public TextView l;
    public ApkDownloadView m;
    public TextView n;
    public CountDownTextView o;
    public AdAppInfoView p;
    public DownloadCacheKey q;
    public c.a.r0.v.g.h.d r;

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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18558e;

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
            this.f18558e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (onClickListener = this.f18558e.f18578h) == null) {
                return;
            }
            onClickListener.onClick(view);
            this.f18558e.o.countStop();
        }
    }

    /* renamed from: c.a.r0.j3.n0.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1157c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f18559e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f18560f;

        public View$OnClickListenerC1157c(c cVar, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18560f = cVar;
            this.f18559e = hVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                String str = this.f18559e.f18469d;
                if (a0.C(this.f18560f.f18574d, str)) {
                    i2 = 3;
                } else {
                    AdvertAppInfo advertAppInfo = this.f18560f.f18574d;
                    i2 = a0.e(this.f18560f.f18576f, str, advertAppInfo.W4() ? this.f18560f.f18574d.getDownloadId() : this.f18560f.f18574d.g4, advertAppInfo.n4, this.f18559e.f18475j);
                }
                if (i2 == 0) {
                    return;
                }
                AdvertAppInfo advertAppInfo2 = this.f18560f.f18574d;
                c.a.r0.j3.m0.c b2 = c.a.r0.j3.m0.g.b(advertAppInfo2, 2, advertAppInfo2.position);
                b2.h("VIDEO_FLOW_TAIL");
                c.a.r0.j3.m0.e.b().d(b2);
                c.a.r0.z1.o.h.c.h(c.a.r0.z1.o.h.c.e(this.f18560f.f18574d));
                this.f18560f.o.countStop();
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

        @Override // c.a.r0.v.g.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.r0.v.a.a(this.a.f18577g.getButtonCmdScheme());
                c.a.r0.z1.o.h.c.h(c.a.r0.z1.o.h.c.e(this.a.f18574d));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        p();
    }

    @Override // c.a.r0.j3.n0.g
    public void d(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            super.d(hVar);
            if (hVar == null) {
                return;
            }
            this.f18557j.startLoad(hVar.f18468c, 30, false);
            this.k.setText(hVar.f18467b);
            this.l.setText(hVar.f18474i);
            this.n.setOnClickListener(new b(this));
            this.o.setFormatString(this.f18576f.getResources().getString(R.string.ad_video_flow_count_down));
            this.f18556i.setOnClickListener(new View$OnClickListenerC1157c(this, hVar));
            AdvertAppInfo advertAppInfo = this.f18574d;
            if (advertAppInfo == null || this.f18577g == null || !advertAppInfo.W4()) {
                return;
            }
            this.p.setAd(this.f18574d);
            this.p.setAppInfo(this.f18574d.o4.getAppInfoModel());
            q();
            r();
        }
    }

    @Override // c.a.r0.j3.n0.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.e();
            this.o.update(5);
            this.o.startCountDown();
            s();
            AdvertAppInfo advertAppInfo = this.f18574d;
            c.a.r0.j3.m0.e.b().d(c.a.r0.j3.m0.g.b(advertAppInfo, 103, advertAppInfo.position));
        }
    }

    @Override // c.a.r0.j3.n0.g
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.f();
            u();
        }
    }

    @Override // c.a.r0.j3.n0.g
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
        AdDownloadData b2 = c.a.r0.v.g.e.d().b(downloadCacheKey);
        if (a0.r(b2.getPkgName())) {
            b2.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
        }
        AdCard adCard = this.f18577g;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.f18577g.getAdvertAppInfo().q4;
            b2.setExtInfo(this.f18577g.getAdvertAppInfo().n4);
            b2.setDownloadKey(this.f18577g.getDownloadKey());
            b2.setPage(str);
            b2.setDeeplinkUrl(this.f18577g.scheme);
            b2.setCmdScheme(this.f18577g.cmdScheme);
        }
        c.a.r0.v.g.e d2 = c.a.r0.v.g.e.d();
        ApkDownloadView apkDownloadView = this.m;
        c.a.r0.v.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.r = new c.a.r0.v.g.h.b(c2);
        if (b2.extra().getPercent() > 0) {
            c2.d(b2);
        }
        s();
        this.m.onStatusChanged(b2.getCurrentState());
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f18572b.setOnClickListener(new a(this));
            this.f18556i = (RelativeLayout) b(R.id.ad_container);
            this.f18557j = (RoundTbImageView) b(R.id.user_head);
            this.k = (TextView) b(R.id.user_name);
            this.l = (TextView) b(R.id.user_content);
            this.m = (ApkDownloadView) b(R.id.download_btn);
            this.n = (TextView) b(R.id.replay_btn);
            this.o = (CountDownTextView) b(R.id.count_down_view);
            this.p = (AdAppInfoView) b(R.id.ad_info_view);
            this.m.setTextColorInitSkin(R.color.CAM_X0101);
            this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.m.setTextSize(R.dimen.T_X06);
            this.m.setForegroundSkin(R.color.black_alpha15);
            this.m.setBackgroundSkin(R.drawable.video_flow_btn_bg_colored);
            this.m.setRatio(0);
            this.m.changeSkin();
        }
    }

    public final void q() {
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (adCard = this.f18577g) == null || adCard.downloadInfo == null) {
            return;
        }
        this.m.setInitText(adCard.operate.f18447b);
        AdCard adCard2 = this.f18577g;
        String str = adCard2.downloadInfo.a;
        DownloadData t = t(this.f18577g, adCard2.getPosition());
        if (a0.r(str)) {
            t.setStatus(8);
        } else {
            t.setStatus(this.m.getDownloadStatus());
        }
        this.m.setData(t);
        this.m.setOnClickInterceptListener(new d(this));
    }

    public final void r() {
        DownloadCacheKey i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            AdCard adCard = this.f18577g;
            String str = adCard.scheme;
            String downloadId = adCard.getDownloadId();
            if (!TextUtils.isEmpty(downloadId)) {
                i2 = c.a.r0.v.g.e.d().h(downloadId);
            } else {
                i2 = c.a.r0.v.g.e.d().i(str);
            }
            if (i2 == null) {
                c.a.r0.j3.j0.b.b bVar = this.f18577g.downloadInfo;
                i2 = DownloadCacheKey.create(downloadId, bVar.f18450b, bVar.a);
                c.a.r0.v.g.e.d().j(i2, null);
            }
            o(i2);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.q == null || this.r == null) {
            return;
        }
        c.a.r0.v.g.e.d().j(this.q, this.r);
    }

    public DownloadData t(AdCard adCard, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, adCard, i2)) == null) {
            DownloadData downloadData = new DownloadData(adCard.getDownloadId());
            downloadData.setUrl(adCard.downloadInfo.f18450b);
            downloadData.setName(adCard.userName);
            downloadData.setPosition(i2);
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
        c.a.r0.v.g.e.d().r(this.q, this.r);
    }
}

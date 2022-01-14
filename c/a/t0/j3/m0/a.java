package c.a.t0.j3.m0;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.s.s.a;
import c.a.t0.j3.f0.j;
import c.a.t0.j3.z;
import c.a.t0.v.g.g.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f18485i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f18486j;
    public ApkDownloadView k;
    public c.a.t0.x1.o.c l;
    public String m;
    public DownloadCacheKey n;
    public c.a.t0.v.g.h.d o;
    public boolean p;
    public boolean q;
    public CustomMessageListener r;

    /* renamed from: c.a.t0.j3.m0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1152a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1152a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.t0.v.g.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.t0.v.a.a(this.a.f18517g.getButtonCmdScheme());
                c.a.t0.x1.o.h.c.h(this.a.f18515e);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f18487e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f18488f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f18489g;

        public b(a aVar, AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, advertAppInfo, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18489g = aVar;
            this.f18487e = advertAppInfo;
            this.f18488f = i2;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f18489g.s(this.f18487e, this.f18488f);
                if (this.f18489g.k != null) {
                    this.f18489g.k.updata(this.f18489g.B(this.f18487e, this.f18488f));
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
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
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            DownloadData downloadData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || (downloadData = (DownloadData) customResponsedMessage.getData()) == null || TextUtils.isEmpty(this.a.m) || !this.a.m.equals(downloadData.getId())) {
                return;
            }
            this.a.k.reset(downloadData);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public AdvertAppInfo f18490e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f18491f;

        public e(a aVar, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, advertAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18491f = aVar;
            this.f18490e = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.A()) {
                    boolean z = view == this.f18491f.k;
                    c.a.t0.x1.o.h.c.h(this.f18491f.f18515e);
                    if (this.f18491f.w()) {
                        this.f18491f.k.performClick();
                        return;
                    }
                    AdvertAppInfo advertAppInfo = this.f18490e;
                    if (advertAppInfo != null) {
                        int e2 = c.a.d.f.m.b.e(advertAppInfo.l4, -1);
                        int status = ApkDownloadView.getStatus(this.f18491f.B(this.f18490e, e2));
                        if ((6 == status || 7 == status) && l.z() && !l.H()) {
                            this.f18491f.A(this.f18490e, e2, true, null);
                            return;
                        }
                        a aVar = this.f18491f;
                        aVar.t(this.f18490e, e2, aVar.k, z);
                        return;
                    }
                    return;
                }
                this.f18491f.f18516f.showToast(R.string.neterror);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(View view, String str) {
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
        this.o = null;
        this.p = false;
        this.r = new d(this, 2016483);
        u();
    }

    public void A(AdvertAppInfo advertAppInfo, int i2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z), str}) == null) || advertAppInfo == null) {
            return;
        }
        if (!l.A()) {
            n.M(this.f18516f.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.V4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.f18516f.getString(R.string.frs_network_tips);
            }
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f18516f.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new b(this, advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new c(this));
            aVar.create(this.f18516f).show();
        }
    }

    public final DownloadData B(AdvertAppInfo advertAppInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, i2)) == null) {
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.w4);
            downloadData.setName(advertAppInfo.s4);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.d.f.m.b.e(advertAppInfo.f4, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.n == null || this.o == null) {
            return;
        }
        c.a.t0.v.g.e.d().r(this.n, this.o);
    }

    @Override // c.a.t0.j3.m0.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            SkinManager.setViewTextColor(this.f18486j, R.color.CAM_X0101, 1);
            this.k.setTextColorInitSkin(R.color.CAM_X0101);
            this.k.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
            this.k.changeSkin();
        }
    }

    @Override // c.a.t0.j3.m0.g
    public void d(c.a.t0.j3.i0.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            super.d(gVar);
            int i2 = 0;
            this.f18485i.startLoad(gVar.f18409c, 10, false);
            this.f18486j.setText(gVar.f18408b);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
            this.k.setInitText(gVar.f18411e);
            c.a.t0.x1.o.h.b bVar = this.f18515e;
            if (bVar instanceof AdCard) {
                this.p = ((AdCard) bVar).isDirectDownload();
            }
            AdvertAppInfo advertAppInfo = this.f18514d;
            if (advertAppInfo != null) {
                e eVar = new e(this, advertAppInfo);
                this.f18512b.setOnClickListener(eVar);
                if (w()) {
                    this.k.setOnClickInterceptListener(new C1152a(this));
                } else {
                    this.k.setOnClickListener(eVar);
                }
                try {
                    if (!TextUtils.isEmpty(this.f18514d.l4)) {
                        i2 = Integer.valueOf(this.f18514d.l4).intValue();
                    }
                } catch (NumberFormatException unused) {
                }
                AdvertAppInfo advertAppInfo2 = this.f18514d;
                this.m = advertAppInfo2.x4;
                DownloadData B = B(advertAppInfo2, i2);
                y(B);
                this.k.setData(B);
            }
            if (!w()) {
                this.k.enableDownloadListener(this.f18516f.getUniqueId());
            }
            this.r.setTag(this.f18516f.getUniqueId());
            v();
            c();
        }
    }

    @Override // c.a.t0.j3.m0.g
    public void h(c.a.t0.x1.o.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.l = cVar;
        }
    }

    public final void r(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.n = downloadCacheKey;
        C();
        AdDownloadData b2 = c.a.t0.v.g.e.d().b(downloadCacheKey);
        if (b2 != null) {
            this.k.onStatusChanged(b2.getCurrentState());
        } else {
            this.k.onStatusChanged(DownloadStatus.STATUS_NONE);
        }
        AdvertAppInfo advertAppInfo = this.f18514d;
        String str = advertAppInfo != null ? advertAppInfo.p4 : "";
        AdvertAppInfo advertAppInfo2 = this.f18514d;
        b2.setExtInfo(advertAppInfo2 != null ? advertAppInfo2.m4 : "");
        b2.setPage(str);
        AdvertAppInfo advertAppInfo3 = this.f18514d;
        b2.setDeeplinkUrl(advertAppInfo3 != null ? advertAppInfo3.v4 : "");
        AdvertAppInfo advertAppInfo4 = this.f18514d;
        b2.setCmdScheme(advertAppInfo4 != null ? advertAppInfo4.y4 : "");
        c.a.t0.v.g.e d2 = c.a.t0.v.g.e.d();
        ApkDownloadView apkDownloadView = this.k;
        c.a.t0.v.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.o = new c.a.t0.v.g.h.b(c2);
        if (b2.extra().getPercent() > 0) {
            c2.d(b2);
        }
        x();
    }

    public void s(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, advertAppInfo, i2) == null) || advertAppInfo == null) {
            return;
        }
        if (!z.c(this.f18516f.getPageActivity())) {
            n.M(this.f18516f.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            return;
        }
        c.a.t0.x1.o.c cVar = this.l;
        if (cVar != null) {
            cVar.a(advertAppInfo, i2);
        }
    }

    public void t(AdvertAppInfo advertAppInfo, int i2, ApkDownloadView apkDownloadView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{advertAppInfo, Integer.valueOf(i2), apkDownloadView, Boolean.valueOf(z)}) == null) || advertAppInfo == null) {
            return;
        }
        DownloadData B = B(advertAppInfo, i2);
        int status = ApkDownloadView.getStatus(B);
        String str = "status: " + status + " id: " + B.getId();
        if (status != 1) {
            if (status == 3) {
                j.d(this.f18516f.getPageActivity(), advertAppInfo.x4);
                return;
            } else if (status != 5) {
                if (status == 6 || status == 7) {
                    s(advertAppInfo, i2);
                    apkDownloadView.startDownload(B);
                    return;
                }
                return;
            }
        }
        j.a(advertAppInfo);
        apkDownloadView.pause(B);
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.user_portrait);
            this.f18485i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f18485i.setDefaultBgResource(R.color.CAM_X0205);
            this.f18485i.setIsRound(true);
            this.f18486j = (TextView) b(R.id.user_name);
            this.k = (ApkDownloadView) b(R.id.download_view);
            MessageManager.getInstance().registerListener(this.r);
        }
    }

    public final void v() {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && w() && (advertAppInfo = this.f18514d) != null) {
            String downloadId = advertAppInfo.getDownloadId();
            DownloadCacheKey h2 = !TextUtils.isEmpty(downloadId) ? c.a.t0.v.g.e.d().h(downloadId) : null;
            if (h2 == null) {
                AdvertAppInfo advertAppInfo2 = this.f18514d;
                h2 = DownloadCacheKey.create(downloadId, advertAppInfo2.w4, advertAppInfo2.x4);
                c.a.t0.v.g.e.d().j(h2, null);
            }
            r(h2);
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? !this.p || this.q : invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.n == null || this.o == null) {
            return;
        }
        c.a.t0.v.g.e.d().j(this.n, this.o);
    }

    public final void y(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, downloadData) == null) {
            if (w()) {
                ApkDownloadView apkDownloadView = this.k;
                if (apkDownloadView == null) {
                    return;
                }
                downloadData.setStatus(apkDownloadView.getDownloadStatus());
                return;
            }
            downloadData.setStatus(ApkDownloadView.getStatus(downloadData));
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.q = z;
        }
    }
}

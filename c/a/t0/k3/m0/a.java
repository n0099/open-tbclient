package c.a.t0.k3.m0;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.s0.s.s.a;
import c.a.t0.k3.f0.j;
import c.a.t0.k3.z;
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
    public HeadImageView f18962i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f18963j;
    public ApkDownloadView k;
    public c.a.t0.y1.o.c l;
    public String m;
    public DownloadCacheKey n;
    public c.a.t0.v.g.h.d o;
    public boolean p;
    public boolean q;
    public CustomMessageListener r;

    /* renamed from: c.a.t0.k3.m0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1174a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.t0.k3.i0.b.g a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f18964b;

        public C1174a(a aVar, c.a.t0.k3.i0.b.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18964b = aVar;
            this.a = gVar;
        }

        @Override // c.a.t0.v.g.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                a aVar = this.f18964b;
                if (aVar.q) {
                    c.a.t0.v.a.a(this.a.f18893j);
                } else {
                    c.a.t0.v.a.a(aVar.f18995g.getButtonCmdScheme());
                }
                c.a.t0.y1.o.h.c.h(this.f18964b.f18993e);
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
        public final /* synthetic */ AdvertAppInfo f18965e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f18966f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f18967g;

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
            this.f18967g = aVar;
            this.f18965e = advertAppInfo;
            this.f18966f = i2;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f18967g.s(this.f18965e, this.f18966f);
                if (this.f18967g.k != null) {
                    this.f18967g.k.updata(this.f18967g.B(this.f18965e, this.f18966f));
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
        public AdvertAppInfo f18968e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f18969f;

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
            this.f18969f = aVar;
            this.f18968e = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.A()) {
                    boolean z = view == this.f18969f.k;
                    c.a.t0.y1.o.h.c.h(this.f18969f.f18993e);
                    if (this.f18969f.w()) {
                        this.f18969f.k.performClick();
                        return;
                    }
                    AdvertAppInfo advertAppInfo = this.f18968e;
                    if (advertAppInfo != null) {
                        int e2 = c.a.d.f.m.b.e(advertAppInfo.m4, -1);
                        int status = ApkDownloadView.getStatus(this.f18969f.B(this.f18968e, e2));
                        if ((6 == status || 7 == status) && l.z() && !l.H()) {
                            this.f18969f.A(this.f18968e, e2, true, null);
                            return;
                        }
                        a aVar = this.f18969f;
                        aVar.t(this.f18968e, e2, aVar.k, z);
                        return;
                    }
                    return;
                }
                this.f18969f.f18994f.showToast(R.string.neterror);
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
            n.M(this.f18994f.getPageActivity(), R.string.neterror);
        } else if (advertAppInfo.W4()) {
            if (TextUtils.isEmpty(str)) {
                str = this.f18994f.getString(R.string.frs_network_tips);
            }
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(this.f18994f.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.alert_yes_button, new b(this, advertAppInfo, i2));
            aVar.setNegativeButton(R.string.cancel, new c(this));
            aVar.create(this.f18994f).show();
        }
    }

    public final DownloadData B(AdvertAppInfo advertAppInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, i2)) == null) {
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.x4);
            downloadData.setName(advertAppInfo.t4);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.d.f.m.b.e(advertAppInfo.g4, 0));
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

    @Override // c.a.t0.k3.m0.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            SkinManager.setViewTextColor(this.f18963j, R.color.CAM_X0101, 1);
            this.k.setTextColorInitSkin(R.color.CAM_X0101);
            this.k.setBackgroundSkin(R.drawable.tail_frame_action_btn_bg);
            this.k.changeSkin();
        }
    }

    @Override // c.a.t0.k3.m0.g
    public void d(c.a.t0.k3.i0.b.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            super.d(gVar);
            int i2 = 0;
            this.f18962i.startLoad(gVar.f18886c, 10, false);
            this.f18963j.setText(gVar.f18885b);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
            this.k.setInitText(gVar.f18888e);
            c.a.t0.y1.o.h.b bVar = this.f18993e;
            if (bVar instanceof AdCard) {
                this.p = ((AdCard) bVar).isDirectDownload();
            }
            AdvertAppInfo advertAppInfo = this.f18992d;
            if (advertAppInfo != null) {
                e eVar = new e(this, advertAppInfo);
                this.f18990b.setOnClickListener(eVar);
                if (w()) {
                    this.k.setOnClickInterceptListener(new C1174a(this, gVar));
                } else {
                    this.k.setOnClickListener(eVar);
                }
                try {
                    if (!TextUtils.isEmpty(this.f18992d.m4)) {
                        i2 = Integer.valueOf(this.f18992d.m4).intValue();
                    }
                } catch (NumberFormatException unused) {
                }
                AdvertAppInfo advertAppInfo2 = this.f18992d;
                this.m = advertAppInfo2.y4;
                DownloadData B = B(advertAppInfo2, i2);
                y(B);
                this.k.setData(B);
            }
            if (!w()) {
                this.k.enableDownloadListener(this.f18994f.getUniqueId());
            }
            this.r.setTag(this.f18994f.getUniqueId());
            v();
            c();
        }
    }

    @Override // c.a.t0.k3.m0.g
    public void h(c.a.t0.y1.o.c cVar) {
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
        AdvertAppInfo advertAppInfo = this.f18992d;
        String str = advertAppInfo != null ? advertAppInfo.q4 : "";
        AdvertAppInfo advertAppInfo2 = this.f18992d;
        b2.setExtInfo(advertAppInfo2 != null ? advertAppInfo2.n4 : "");
        b2.setPage(str);
        AdvertAppInfo advertAppInfo3 = this.f18992d;
        b2.setDeeplinkUrl(advertAppInfo3 != null ? advertAppInfo3.w4 : "");
        AdvertAppInfo advertAppInfo4 = this.f18992d;
        b2.setCmdScheme(advertAppInfo4 != null ? advertAppInfo4.z4 : "");
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
        if (!z.c(this.f18994f.getPageActivity())) {
            n.M(this.f18994f.getPageActivity(), R.string.write_external_storage_permission_denied_fun_disable);
            return;
        }
        c.a.t0.y1.o.c cVar = this.l;
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
                j.d(this.f18994f.getPageActivity(), advertAppInfo.y4);
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
            this.f18962i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.f18962i.setDefaultBgResource(R.color.CAM_X0205);
            this.f18962i.setIsRound(true);
            this.f18963j = (TextView) b(R.id.user_name);
            this.k = (ApkDownloadView) b(R.id.download_view);
            MessageManager.getInstance().registerListener(this.r);
        }
    }

    public final void v() {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && w() && (advertAppInfo = this.f18992d) != null) {
            String downloadId = advertAppInfo.getDownloadId();
            DownloadCacheKey h2 = !TextUtils.isEmpty(downloadId) ? c.a.t0.v.g.e.d().h(downloadId) : null;
            if (h2 == null) {
                AdvertAppInfo advertAppInfo2 = this.f18992d;
                h2 = DownloadCacheKey.create(downloadId, advertAppInfo2.x4, advertAppInfo2.y4);
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

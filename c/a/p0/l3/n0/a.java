package c.a.p0.l3.n0;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
import c.a.p0.l3.a0;
import c.a.p0.l3.g0.j;
import c.a.p0.l3.j0.b.h;
import c.a.p0.x.g.g.b;
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
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView i;
    public TextView j;
    public ApkDownloadView k;
    public c.a.p0.b2.o.c l;
    public String m;
    public DownloadCacheKey n;
    public c.a.p0.x.g.h.d o;
    public boolean p;
    public CustomMessageListener q;

    /* renamed from: c.a.p0.l3.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1215a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f16306b;

        public C1215a(a aVar, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16306b = aVar;
            this.a = hVar;
        }

        @Override // c.a.p0.x.g.g.b.a
        public boolean b(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                a aVar = this.f16306b;
                if (aVar.p) {
                    c.a.p0.x.a.a(this.a.j);
                } else {
                    c.a.p0.x.a.a(aVar.f16321g.getButtonCmdScheme());
                }
                c.a.p0.b2.o.h.c.h(this.f16306b.f16319e);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f16307b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f16308c;

        public b(a aVar, AdvertAppInfo advertAppInfo, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, advertAppInfo, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16308c = aVar;
            this.a = advertAppInfo;
            this.f16307b = i;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16308c.s(this.a, this.f16307b);
                if (this.f16308c.k != null) {
                    this.f16308c.k.w(this.f16308c.B(this.a, this.f16307b));
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            this.a.k.s(downloadData);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AdvertAppInfo a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f16309b;

        public e(a aVar, AdvertAppInfo advertAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, advertAppInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16309b = aVar;
            this.a = advertAppInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (l.A()) {
                    boolean z = view == this.f16309b.k;
                    c.a.p0.b2.o.h.c.h(this.f16309b.f16319e);
                    if (this.f16309b.w()) {
                        this.f16309b.k.performClick();
                        return;
                    }
                    AdvertAppInfo advertAppInfo = this.a;
                    if (advertAppInfo != null) {
                        int e2 = c.a.d.f.m.b.e(advertAppInfo.f29820g, -1);
                        int n = ApkDownloadView.n(this.f16309b.B(this.a, e2));
                        if ((6 == n || 7 == n) && l.z() && !l.H()) {
                            this.f16309b.A(this.a, e2, true, null);
                            return;
                        }
                        a aVar = this.f16309b;
                        aVar.t(this.a, e2, aVar.k, z);
                        return;
                    }
                    return;
                }
                this.f16309b.f16320f.showToast(R.string.obfuscated_res_0x7f0f0c15);
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
        this.o = null;
        this.q = new d(this, 2016483);
        u();
    }

    public void A(AdvertAppInfo advertAppInfo, int i, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{advertAppInfo, Integer.valueOf(i), Boolean.valueOf(z), str}) == null) || advertAppInfo == null) {
            return;
        }
        if (!l.A()) {
            n.M(this.f16320f.getPageActivity(), R.string.obfuscated_res_0x7f0f0c15);
        } else if (advertAppInfo.i()) {
            if (TextUtils.isEmpty(str)) {
                str = this.f16320f.getString(R.string.obfuscated_res_0x7f0f070f);
            }
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.f16320f.getPageActivity());
            aVar.setMessage(str);
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f025c, new b(this, advertAppInfo, i));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new c(this));
            aVar.create(this.f16320f).show();
        }
    }

    public final DownloadData B(AdvertAppInfo advertAppInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, i)) == null) {
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.r);
            downloadData.setName(advertAppInfo.n);
            downloadData.setPosition(i);
            downloadData.setNotifyId(c.a.d.f.m.b.e(advertAppInfo.a, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.n == null || this.o == null) {
            return;
        }
        c.a.p0.x.g.e.d().r(this.n, this.o);
    }

    @Override // c.a.p0.l3.n0.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            this.k.setTextColorInitSkin(R.color.CAM_X0101);
            this.k.setBackgroundSkin(R.drawable.obfuscated_res_0x7f0811c4);
            this.k.j();
        }
    }

    @Override // c.a.p0.l3.n0.g
    public void d(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
            super.d(hVar);
            int i = 0;
            this.i.J(hVar.f16243c, 10, false);
            this.j.setText(hVar.f16242b);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
            this.k.setInitText(hVar.f16245e);
            AdvertAppInfo advertAppInfo = this.f16318d;
            if (advertAppInfo != null) {
                e eVar = new e(this, advertAppInfo);
                this.f16316b.setOnClickListener(eVar);
                if (w()) {
                    this.k.setOnClickInterceptListener(new C1215a(this, hVar));
                } else {
                    this.k.setOnClickListener(eVar);
                }
                try {
                    if (!TextUtils.isEmpty(this.f16318d.f29820g)) {
                        i = Integer.valueOf(this.f16318d.f29820g).intValue();
                    }
                } catch (NumberFormatException unused) {
                }
                AdvertAppInfo advertAppInfo2 = this.f16318d;
                this.m = advertAppInfo2.s;
                DownloadData B = B(advertAppInfo2, i);
                y(B);
                this.k.setData(B);
            }
            if (!w()) {
                this.k.k(this.f16320f.getUniqueId());
            }
            this.q.setTag(this.f16320f.getUniqueId());
            v();
            c();
        }
    }

    @Override // c.a.p0.l3.n0.g
    public void h(c.a.p0.b2.o.c cVar) {
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
        AdDownloadData b2 = c.a.p0.x.g.e.d().b(downloadCacheKey);
        if (b2 != null) {
            this.k.d(b2.getCurrentState());
        } else {
            this.k.d(DownloadStatus.STATUS_NONE);
        }
        AdvertAppInfo advertAppInfo = this.f16318d;
        String str = advertAppInfo != null ? advertAppInfo.k : "";
        AdvertAppInfo advertAppInfo2 = this.f16318d;
        b2.setExtInfo(advertAppInfo2 != null ? advertAppInfo2.f29821h : "");
        b2.setPage(str);
        AdvertAppInfo advertAppInfo3 = this.f16318d;
        b2.setDeeplinkUrl(advertAppInfo3 != null ? advertAppInfo3.q : "");
        AdvertAppInfo advertAppInfo4 = this.f16318d;
        b2.setCmdScheme(advertAppInfo4 != null ? advertAppInfo4.t : "");
        c.a.p0.x.g.e d2 = c.a.p0.x.g.e.d();
        ApkDownloadView apkDownloadView = this.k;
        c.a.p0.x.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.o = new c.a.p0.x.g.h.b(c2);
        if (b2.extra().getPercent() > 0) {
            c2.e(b2);
        }
        x();
    }

    public void s(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, advertAppInfo, i) == null) || advertAppInfo == null) {
            return;
        }
        if (!a0.c(this.f16320f.getPageActivity())) {
            n.M(this.f16320f.getPageActivity(), R.string.obfuscated_res_0x7f0f157e);
            return;
        }
        c.a.p0.b2.o.c cVar = this.l;
        if (cVar != null) {
            cVar.a(advertAppInfo, i);
        }
    }

    public void t(AdvertAppInfo advertAppInfo, int i, ApkDownloadView apkDownloadView, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{advertAppInfo, Integer.valueOf(i), apkDownloadView, Boolean.valueOf(z)}) == null) || advertAppInfo == null) {
            return;
        }
        DownloadData B = B(advertAppInfo, i);
        int n = ApkDownloadView.n(B);
        Log.e("guoqiangxiang", "status: " + n + " id: " + B.getId());
        if (n != 1) {
            if (n == 3) {
                j.d(this.f16320f.getPageActivity(), advertAppInfo.s);
                return;
            } else if (n != 5) {
                if (n == 6 || n == 7) {
                    s(advertAppInfo, i);
                    apkDownloadView.t(B);
                    return;
                }
                return;
            }
        }
        j.a(advertAppInfo);
        apkDownloadView.q(B);
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            HeadImageView headImageView = (HeadImageView) b(R.id.obfuscated_res_0x7f0922c8);
            this.i = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.i.setDefaultBgResource(R.color.CAM_X0205);
            this.i.setIsRound(true);
            this.j = (TextView) b(R.id.obfuscated_res_0x7f0922bb);
            this.k = (ApkDownloadView) b(R.id.obfuscated_res_0x7f09082b);
            MessageManager.getInstance().registerListener(this.q);
        }
    }

    public final void v() {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && w() && (advertAppInfo = this.f16318d) != null) {
            String downloadId = advertAppInfo.getDownloadId();
            DownloadCacheKey h2 = !TextUtils.isEmpty(downloadId) ? c.a.p0.x.g.e.d().h(downloadId) : null;
            if (h2 == null) {
                AdvertAppInfo advertAppInfo2 = this.f16318d;
                h2 = DownloadCacheKey.create(downloadId, advertAppInfo2.r, advertAppInfo2.s);
                c.a.p0.x.g.e.d().j(h2, null);
            }
            r(h2);
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.n == null || this.o == null) {
            return;
        }
        c.a.p0.x.g.e.d().j(this.n, this.o);
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
            downloadData.setStatus(ApkDownloadView.n(downloadData));
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.p = z;
        }
    }
}

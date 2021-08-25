package c.a.q0.x2.i0.d.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.q.d.g.b;
import c.a.q0.x2.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class b extends c.a.q0.x2.i0.d.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View.OnClickListener A;
    public RelativeLayout k;
    public TbImageView l;
    public TBSpecificationBtn m;
    public TextView n;
    public TextView o;
    public TextView p;
    public boolean q;
    public UrlDragImageView r;
    public DragImageView.h s;
    public RelativeLayout t;
    public RelativeLayout u;
    public ImageView v;
    public ApkDownloadView w;
    public VideoInfo x;
    public DownloadCacheKey y;
    public c.a.q0.q.d.h.d z;

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28907a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28907a = bVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f28907a.D();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* renamed from: c.a.q0.x2.i0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1344b implements DragImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28908a;

        public C1344b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28908a = bVar;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f28908a.s != null) {
                    this.f28908a.s.a();
                }
                this.f28908a.n.setVisibility(8);
                this.f28908a.o.setVisibility(8);
                this.f28908a.p.setVisibility(8);
                this.f28908a.t.setVisibility(8);
                this.f28908a.v.setVisibility(8);
                this.f28908a.m.setVisibility(8);
                this.f28908a.w.setVisibility(8);
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28908a.s == null) {
                return;
            }
            this.f28908a.s.b();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f28908a.s != null) {
                    this.f28908a.s.c();
                }
                this.f28908a.n.setVisibility(0);
                this.f28908a.o.setVisibility(0);
                this.f28908a.p.setVisibility(0);
                this.f28908a.t.setVisibility(0);
                b bVar = this.f28908a;
                AdvertAppInfo advertAppInfo = bVar.f28902f;
                if (advertAppInfo != null) {
                    bVar.v.setVisibility(advertAppInfo.J4() ? 0 : 8);
                    if (this.f28908a.f28902f.H4()) {
                        this.f28908a.m.setVisibility(0);
                    } else {
                        this.f28908a.w.setVisibility(0);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f28909e;

        /* renamed from: f  reason: collision with root package name */
        public float f28910f;

        /* renamed from: g  reason: collision with root package name */
        public float f28911g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f28912h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f28913i;

        public c(b bVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28913i = bVar;
            this.f28912h = onClickListener;
            this.f28909e = 0.0f;
            this.f28910f = 0.0f;
            this.f28911g = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        this.f28913i.q = 10.0f < this.f28911g;
                        b bVar = this.f28913i;
                        if (!bVar.q) {
                            this.f28912h.onClick(bVar.l);
                        }
                    } else if (action == 2) {
                        float x = motionEvent.getX() - this.f28909e;
                        float y = motionEvent.getY() - this.f28910f;
                        this.f28911g = (float) (this.f28911g + Math.sqrt((x * x) + (y * y)));
                        this.f28909e = motionEvent.getX();
                        this.f28910f = motionEvent.getY();
                    }
                } else {
                    this.f28913i.q = false;
                    this.f28909e = motionEvent.getX();
                    this.f28910f = motionEvent.getY();
                    this.f28911g = 0.0f;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28914e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28914e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int q;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f28914e;
                if (bVar.f28902f == null || bVar.f28901e == null) {
                    return;
                }
                if (bVar.q && view.getId() == R.id.big_image_ad_image) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                if (view.getId() == R.id.image_ad_button) {
                    q = this.f28914e.p(view);
                    str = "button";
                } else if (view.getId() == R.id.bottom_container) {
                    q = this.f28914e.o();
                    str = "title";
                } else {
                    q = this.f28914e.q();
                    str = this.f28914e.f28902f.G4() ? "image" : "video";
                }
                hashMap.put("da_area", str);
                this.f28914e.f28906j.a(q, hashMap);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28915a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28915a = bVar;
        }

        @Override // c.a.q0.q.d.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.q0.o1.o.h.c.h(c.a.q0.o1.o.h.c.e(this.f28915a.f28902f));
                b bVar = this.f28915a;
                if (bVar.f28904h != null && z.o(bVar.f28901e.getScheme()) && z.q(this.f28915a.f28902f.l4)) {
                    b bVar2 = this.f28915a;
                    z.d(bVar2.f28904h, bVar2.f28901e.getScheme(), this.f28915a.f28902f.getDownloadId(), this.f28915a.f28902f.a4);
                    return true;
                } else if (this.f28915a.f28904h == null || c.a.q0.a.h().u() || c.a.q0.i3.z.a((Activity) this.f28915a.f28904h)) {
                    return false;
                } else {
                    l.L((Activity) this.f28915a.f28904h, R.string.write_external_storage_permission_denied_fun_disable);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = false;
        this.z = null;
        this.A = new d(this);
    }

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.m;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(onClickListener);
            }
            TbImageView tbImageView = this.l;
            if (tbImageView != null) {
                tbImageView.setOnClickListener(onClickListener);
            }
            RelativeLayout relativeLayout = this.u;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(onClickListener);
            }
            ImageView imageView = this.v;
            if (imageView != null) {
                imageView.setOnClickListener(onClickListener);
            }
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                urlDragImageView.setOuterOnTouchListener(new c(this, onClickListener));
            }
        }
    }

    public DownloadData B(AdvertAppInfo advertAppInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo, i2)) == null) {
            if (advertAppInfo == null) {
                return new DownloadData();
            }
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.k4);
            downloadData.setName(advertAppInfo.g4);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.e.e.m.b.d(advertAppInfo.T3, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.y == null || this.z == null) {
            return;
        }
        c.a.q0.q.d.e.c().q(this.y, this.z);
    }

    public void D() {
        WindowManager windowManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (windowManager = (WindowManager) this.f28904h.getSystemService("window")) == null) {
            return;
        }
        int width = windowManager.getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
        double loadedHeight = this.l.getLoadedHeight() / this.l.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (width * loadedHeight);
            layoutParams.width = width;
        }
        this.l.setLayoutParams(layoutParams);
    }

    @Override // c.a.q0.x2.i0.d.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f28905i == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f28904h).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
        this.k = relativeLayout;
        this.l = (TbImageView) relativeLayout.findViewById(R.id.big_image_ad_image);
        this.m = (TBSpecificationBtn) this.k.findViewById(R.id.image_ad_button);
        c.a.p0.s.f0.n.b bVar = new c.a.p0.s.f0.n.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        this.m.setConfig(bVar);
        this.m.setTextHorizontalCenter(true);
        this.n = (TextView) this.k.findViewById(R.id.ad_title);
        this.o = (TextView) this.k.findViewById(R.id.ad_brand);
        this.p = (TextView) this.k.findViewById(R.id.ad_tag);
        this.t = (RelativeLayout) this.k.findViewById(R.id.ad_info_container);
        this.u = (RelativeLayout) this.k.findViewById(R.id.bottom_container);
        ImageView imageView = (ImageView) this.k.findViewById(R.id.video_ad_play_icon);
        this.v = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), null));
        ApkDownloadView apkDownloadView = (ApkDownloadView) this.k.findViewById(R.id.image_download_button);
        this.w = apkDownloadView;
        TbPageContext tbPageContext = this.f28905i;
        if (tbPageContext != null) {
            apkDownloadView.enableDownloadListener(tbPageContext.getUniqueId());
        }
        this.w.setTextSize(R.dimen.tbds39);
        this.w.setTextColorInitSkin(R.color.CAM_X0101);
        this.w.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.w.changeSkin();
        A(this.A);
    }

    @Override // c.a.q0.x2.i0.d.a.a
    public void c(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adCard) == null) {
            super.c(adCard);
            if (adCard == null) {
                return;
            }
            l();
            this.x = this.f28901e.videoInfo;
            v();
            s(this.f28902f, this.f28901e);
            if (!TextUtils.isEmpty(this.f28902f.g4)) {
                this.o.setText(this.f28902f.g4);
                this.p.setText(this.f28904h.getString(R.string.advert_label));
            }
            if (!TextUtils.isEmpty(adCard.threadTitle)) {
                this.n.setText(adCard.threadTitle);
            }
            this.v.setVisibility(this.f28902f.J4() ? 0 : 8);
            A(this.A);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l.setVisibility(4);
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                this.k.removeView(urlDragImageView);
            }
            UrlDragImageView urlDragImageView2 = new UrlDragImageView(this.f28904h);
            this.r = urlDragImageView2;
            urlDragImageView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.r.setIsCanDrag(true);
            this.r.setCanScale(false);
            this.r.setDragToExitListener(new C1344b(this));
            this.k.addView(this.r, 0);
        }
    }

    public void m(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.y = downloadCacheKey;
        C();
        this.z = null;
        AdDownloadData b2 = c.a.q0.q.d.e.c().b(downloadCacheKey);
        AdCard adCard = this.f28901e;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.f28901e.getAdvertAppInfo().d4;
            b2.setExtInfo(this.f28901e.getAdvertAppInfo().a4);
            b2.setDownloadKey(this.f28901e.getDownloadKey());
            JSONObject json = App.toJson(this.f28901e.getAdvertAppInfo().f4);
            if (json != null) {
                b2.setAppJson(json.toString());
            }
            b2.setPage(str);
            b2.setDeeplinkUrl(this.f28901e.scheme);
        }
        c.a.q0.q.c.b.d.a aVar = new c.a.q0.q.c.b.d.a(this.w, b2);
        this.z = new c.a.q0.q.d.h.b(aVar);
        if (b2 != null && b2.extra() != null && b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        this.w.onStatusChanged(b2.getCurrentState());
        x();
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public final int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? u() : invokeV.intValue;
    }

    public final int p(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view)) == null) ? u() : invokeL.intValue;
    }

    public final int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.f28902f.G4()) {
                return u();
            }
            return r();
        }
        return invokeV.intValue;
    }

    public final int r() {
        InterceptResult invokeV;
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f28902f == null || (adCard = this.f28901e) == null || this.x == null) {
                return 0;
            }
            return z.g(this.f28904h, adCard.getScheme(), this.f28902f);
        }
        return invokeV.intValue;
    }

    public void s(AdvertAppInfo advertAppInfo, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, advertAppInfo, adCard) == null) || advertAppInfo == null || adCard == null) {
            return;
        }
        this.f28902f = advertAppInfo;
        this.f28901e = adCard;
        if (advertAppInfo.H4()) {
            this.m.setText(adCard.getButtonText());
            this.w.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        this.w.setClickable(true);
        this.w.setInitText(adCard.getButtonText());
        this.w.setOnClickInterceptListener(new e(this));
        DownloadData B = B(this.f28902f, c.a.e.e.m.b.d(this.f28902f.Z3, -1));
        y(B);
        this.w.setData(B);
        this.w.setVisibility(0);
        this.m.setVisibility(8);
        t(adCard, advertAppInfo);
    }

    public final void t(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, adCard, advertAppInfo) == null) || advertAppInfo == null || !advertAppInfo.F4() || adCard == null) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            h2 = c.a.q0.q.d.e.c().g(downloadId);
        } else {
            h2 = c.a.q0.q.d.e.c().h(scheme);
        }
        if (h2 == null) {
            h2 = DownloadCacheKey.create(downloadId, advertAppInfo.k4, advertAppInfo.l4);
            c.a.q0.q.d.e.c().i(h2, null);
        }
        m(h2);
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? z.d(this.f28904h, this.f28901e.getScheme(), this.f28901e.getDownloadId(), this.f28902f.a4) : invokeV.intValue;
    }

    public final void v() {
        String picUrl;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f28902f.J4() && (videoInfo = this.x) != null) {
                picUrl = videoInfo.thumbnail_url;
            } else {
                picUrl = this.f28901e.getPicUrl();
            }
            this.l.setEvent(new a(this));
            this.l.startLoad(picUrl, this.f28903g ? 30 : 31, 720, 720, false);
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                urlDragImageView.setIsCdn(this.f28903g);
                this.r.setUrl(picUrl, true);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            C();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.y == null || this.z == null) {
            return;
        }
        c.a.q0.q.d.e.c().i(this.y, this.z);
    }

    public final void y(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, downloadData) == null) || downloadData == null) {
            return;
        }
        downloadData.setStatus(this.w.getDownloadStatus());
    }

    public void z(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hVar) == null) {
            this.s = hVar;
        }
    }
}

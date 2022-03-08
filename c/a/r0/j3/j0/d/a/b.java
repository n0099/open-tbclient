package c.a.r0.j3.j0.d.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.r0.j3.a0;
import c.a.r0.v.g.g.b;
import c.a.r0.y3.c0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.JsonTransHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
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
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class b extends c.a.r0.j3.j0.d.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ApkDownloadView A;
    public VideoInfo B;
    public DownloadCacheKey C;
    public c.a.r0.v.g.h.d D;
    public final View.OnClickListener E;
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
    public FrameLayout w;
    public View x;
    public TBLottieAnimationView y;
    public Runnable z;

    /* loaded from: classes2.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18482e;

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
            this.f18482e = bVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18482e.y.resumeAnimation();
                this.f18482e.y.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f18482e.y.cancelAnimation();
            }
        }
    }

    /* renamed from: c.a.r0.j3.j0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1154b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18483e;

        public RunnableC1154b(b bVar) {
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
            this.f18483e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = (bVar = this.f18483e).w) == null || bVar.y == null || frameLayout.getVisibility() != 0) {
                return;
            }
            this.f18483e.y.cancelAnimation();
            this.f18483e.w.setVisibility(8);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
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
            this.a = bVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.a.G();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements DragImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.s != null) {
                    this.a.s.a();
                }
                this.a.n.setVisibility(8);
                this.a.o.setVisibility(8);
                this.a.p.setVisibility(8);
                this.a.t.setVisibility(8);
                this.a.v.setVisibility(8);
                this.a.m.setVisibility(8);
                this.a.A.setVisibility(8);
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.s == null) {
                return;
            }
            this.a.s.b();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.s != null) {
                    this.a.s.c();
                }
                this.a.n.setVisibility(0);
                this.a.o.setVisibility(0);
                this.a.p.setVisibility(0);
                this.a.t.setVisibility(0);
                b bVar = this.a;
                AdvertAppInfo advertAppInfo = bVar.f18477f;
                if (advertAppInfo != null) {
                    bVar.v.setVisibility(advertAppInfo.a5() ? 0 : 8);
                    if (this.a.f18477f.Y4()) {
                        this.a.m.setVisibility(0);
                    } else {
                        this.a.A.setVisibility(0);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f18484e;

        /* renamed from: f  reason: collision with root package name */
        public float f18485f;

        /* renamed from: g  reason: collision with root package name */
        public float f18486g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f18487h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f18488i;

        public e(b bVar, View.OnClickListener onClickListener) {
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
            this.f18488i = bVar;
            this.f18487h = onClickListener;
            this.f18484e = 0.0f;
            this.f18485f = 0.0f;
            this.f18486g = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        this.f18488i.q = 10.0f < this.f18486g;
                        b bVar = this.f18488i;
                        if (!bVar.q) {
                            this.f18487h.onClick(bVar.l);
                        }
                    } else if (action == 2) {
                        float x = motionEvent.getX() - this.f18484e;
                        float y = motionEvent.getY() - this.f18485f;
                        this.f18486g = (float) (this.f18486g + Math.sqrt((x * x) + (y * y)));
                        this.f18484e = motionEvent.getX();
                        this.f18485f = motionEvent.getY();
                    }
                } else {
                    this.f18488i.q = false;
                    this.f18484e = motionEvent.getX();
                    this.f18485f = motionEvent.getY();
                    this.f18486g = 0.0f;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18489e;

        public f(b bVar) {
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
            this.f18489e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int r;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f18489e;
                if (bVar.f18477f == null || bVar.f18476e == null) {
                    return;
                }
                if (bVar.q && view.getId() == R.id.big_image_ad_image) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                if (view.getId() == R.id.image_ad_button) {
                    r = this.f18489e.q(view);
                    str = "button";
                } else if (view.getId() == R.id.bottom_container) {
                    r = this.f18489e.p();
                    str = "title";
                } else {
                    r = this.f18489e.r();
                    str = this.f18489e.f18477f.X4() ? "image" : "video";
                }
                hashMap.put("da_area", str);
                this.f18489e.f18481j.a(r, hashMap);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public g(b bVar) {
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
            this.a = bVar;
        }

        @Override // c.a.r0.v.g.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.r0.v.a.a(this.a.f18476e.getButtonCmdScheme());
                c.a.r0.z1.o.h.c.h(c.a.r0.z1.o.h.c.e(this.a.f18477f));
                b bVar = this.a;
                if (bVar.f18479h != null && a0.p(bVar.f18476e.getScheme()) && a0.r(this.a.f18477f.y4)) {
                    b bVar2 = this.a;
                    Context context = bVar2.f18479h;
                    String scheme = bVar2.f18476e.getScheme();
                    String downloadId = this.a.f18477f.getDownloadId();
                    b bVar3 = this.a;
                    a0.d(context, scheme, downloadId, bVar3.f18477f.n4, bVar3.f18476e.cmdScheme);
                    return true;
                } else if (this.a.f18479h == null || c.a.r0.a.h().u() || c0.a((Activity) this.a.f18479h)) {
                    return false;
                } else {
                    n.M((Activity) this.a.f18479h, R.string.write_external_storage_permission_denied_fun_disable);
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
        this.D = null;
        this.E = new f(this);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.C == null || this.D == null) {
            return;
        }
        c.a.r0.v.g.e.d().j(this.C, this.D);
    }

    public final void B(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) || downloadData == null) {
            return;
        }
        downloadData.setStatus(this.A.getDownloadStatus());
    }

    public void C(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
            this.s = hVar;
        }
    }

    public void D(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
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
                urlDragImageView.setOuterOnTouchListener(new e(this, onClickListener));
            }
        }
    }

    public DownloadData E(AdvertAppInfo advertAppInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, advertAppInfo, i2)) == null) {
            if (advertAppInfo == null) {
                return new DownloadData();
            }
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.x4);
            downloadData.setName(advertAppInfo.t4);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.d.f.m.b.e(advertAppInfo.g4, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.C == null || this.D == null) {
            return;
        }
        c.a.r0.v.g.e.d().r(this.C, this.D);
    }

    public void G() {
        WindowManager windowManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (windowManager = (WindowManager) this.f18479h.getSystemService("window")) == null) {
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

    @Override // c.a.r0.j3.j0.d.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f18480i == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f18479h).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
        this.k = relativeLayout;
        this.l = (TbImageView) relativeLayout.findViewById(R.id.big_image_ad_image);
        this.m = (TBSpecificationBtn) this.k.findViewById(R.id.image_ad_button);
        c.a.q0.r.l0.n.b bVar = new c.a.q0.r.l0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
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
        this.w = (FrameLayout) this.k.findViewById(R.id.ad_left_slide_guide);
        View findViewById = this.k.findViewById(R.id.ad_slide_guide_mask_layer);
        this.x = findViewById;
        c.a.q0.r.v.c.d(findViewById).p(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.k.findViewById(R.id.ad_left_slide_guide_icon);
        this.y = tBLottieAnimationView;
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.ad_left_slide_guide_lottie);
        this.y.setRepeatCount(3);
        this.y.addOnAttachStateChangeListener(new a(this));
        ApkDownloadView apkDownloadView = (ApkDownloadView) this.k.findViewById(R.id.image_download_button);
        this.A = apkDownloadView;
        TbPageContext tbPageContext = this.f18480i;
        if (tbPageContext != null) {
            apkDownloadView.enableDownloadListener(tbPageContext.getUniqueId());
        }
        this.A.setTextSize(R.dimen.tbds39);
        this.A.setTextColorInitSkin(R.color.CAM_X0101);
        this.A.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.A.changeSkin();
        D(this.E);
    }

    @Override // c.a.r0.j3.j0.d.a.a
    public void c(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, adCard) == null) {
            super.c(adCard);
            if (adCard == null) {
                return;
            }
            l();
            this.B = this.f18476e.videoInfo;
            x();
            u(this.f18477f, this.f18476e);
            if (!TextUtils.isEmpty(this.f18477f.t4)) {
                this.o.setText(this.f18477f.t4);
                this.p.setText(this.f18479h.getString(R.string.advert_label));
            }
            if (!TextUtils.isEmpty(adCard.threadTitle)) {
                this.n.setText(adCard.threadTitle);
            }
            this.v.setVisibility(this.f18477f.a5() ? 0 : 8);
            D(this.E);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l.setVisibility(4);
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                this.k.removeView(urlDragImageView);
            }
            UrlDragImageView urlDragImageView2 = new UrlDragImageView(this.f18479h);
            this.r = urlDragImageView2;
            urlDragImageView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.r.setIsCanDrag(true);
            this.r.setCanScale(false);
            this.r.setDragToExitListener(new d(this));
            this.k.addView(this.r, 0);
        }
    }

    public void m(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.C = downloadCacheKey;
        F();
        this.D = null;
        AdDownloadData b2 = c.a.r0.v.g.e.d().b(downloadCacheKey);
        AdCard adCard = this.f18476e;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.f18476e.getAdvertAppInfo().q4;
            b2.setExtInfo(this.f18476e.getAdvertAppInfo().n4);
            b2.setDownloadKey(this.f18476e.getDownloadKey());
            JSONObject appJson = JsonTransHelper.toAppJson(this.f18476e.getAdvertAppInfo().s4);
            if (appJson != null) {
                b2.setAppJson(appJson.toString());
            }
            b2.setPage(str);
            b2.setDeeplinkUrl(this.f18476e.scheme);
            b2.setCmdScheme(this.f18476e.cmdScheme);
        }
        c.a.r0.v.g.e d2 = c.a.r0.v.g.e.d();
        ApkDownloadView apkDownloadView = this.A;
        c.a.r0.v.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.D = new c.a.r0.v.g.h.b(c2);
        if (b2 != null && b2.extra() != null && b2.extra().getPercent() > 0) {
            c2.d(b2);
        }
        this.A.onStatusChanged(b2.getCurrentState());
        A();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.z = new RunnableC1154b(this);
            c.a.d.f.m.e.a().postDelayed(this.z, 10000L);
        }
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : (View) invokeV.objValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? w() : invokeV.intValue;
    }

    public final int q(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, view)) == null) ? w() : invokeL.intValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f18477f.X4()) {
                return w();
            }
            return s();
        }
        return invokeV.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f18477f == null || (adCard = this.f18476e) == null || this.B == null) {
                return 0;
            }
            return a0.g(this.f18479h, adCard.getScheme(), this.f18477f, this.f18476e.playCmdScheme);
        }
        return invokeV.intValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.y;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            FrameLayout frameLayout = this.w;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
    }

    public void u(AdvertAppInfo advertAppInfo, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, advertAppInfo, adCard) == null) || advertAppInfo == null || adCard == null) {
            return;
        }
        this.f18477f = advertAppInfo;
        this.f18476e = adCard;
        if (advertAppInfo.Y4()) {
            this.m.setText(adCard.getButtonText());
            this.A.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        this.A.setClickable(true);
        this.A.setInitText(adCard.getButtonText());
        this.A.setOnClickInterceptListener(new g(this));
        DownloadData E = E(this.f18477f, c.a.d.f.m.b.e(this.f18477f.m4, -1));
        B(E);
        this.A.setData(E);
        this.A.setVisibility(0);
        this.m.setVisibility(8);
        v(adCard, advertAppInfo);
    }

    public final void v(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, adCard, advertAppInfo) == null) || advertAppInfo == null || !advertAppInfo.W4() || adCard == null) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            i2 = c.a.r0.v.g.e.d().h(downloadId);
        } else {
            i2 = c.a.r0.v.g.e.d().i(scheme);
        }
        if (i2 == null) {
            i2 = DownloadCacheKey.create(downloadId, advertAppInfo.x4, advertAppInfo.y4);
            c.a.r0.v.g.e.d().j(i2, null);
        }
        m(i2);
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? a0.d(this.f18479h, this.f18476e.getScheme(), this.f18476e.getDownloadId(), this.f18477f.n4, this.f18476e.cmdScheme) : invokeV.intValue;
    }

    public final void x() {
        String picUrl;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.f18477f.a5() && (videoInfo = this.B) != null) {
                picUrl = videoInfo.thumbnail_url;
            } else {
                picUrl = this.f18476e.getPicUrl();
            }
            this.l.setEvent(new c(this));
            this.l.startLoad(picUrl, this.f18478g ? 30 : 31, 720, 720, false);
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                urlDragImageView.setIsCdn(this.f18478g);
                this.r.setUrl(picUrl, true);
            }
        }
    }

    public void y() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (frameLayout = this.w) == null || this.y == null) {
            return;
        }
        frameLayout.setVisibility(0);
        this.y.playAnimation();
        n();
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            F();
            if (this.z != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.z);
            }
        }
    }
}

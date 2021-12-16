package c.a.s0.j3.i0.d.a;

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
import c.a.d.f.p.m;
import c.a.s0.j3.z;
import c.a.s0.v.g.g.b;
import c.a.s0.v3.b0;
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
/* loaded from: classes7.dex */
public class b extends c.a.s0.j3.i0.d.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public ApkDownloadView B;
    public VideoInfo C;
    public DownloadCacheKey D;
    public c.a.s0.v.g.h.d E;
    public final View.OnClickListener F;

    /* renamed from: k  reason: collision with root package name */
    public RelativeLayout f18420k;
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
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18421e;

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
            this.f18421e = bVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18421e.y.resumeAnimation();
                this.f18421e.y.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f18421e.y.cancelAnimation();
            }
        }
    }

    /* renamed from: c.a.s0.j3.i0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1110b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18422e;

        public RunnableC1110b(b bVar) {
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
            this.f18422e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = (bVar = this.f18422e).w) == null || bVar.y == null || frameLayout.getVisibility() != 0) {
                return;
            }
            this.f18422e.y.cancelAnimation();
            this.f18422e.w.setVisibility(8);
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.I();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.B.setVisibility(8);
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
                AdvertAppInfo advertAppInfo = bVar.f18415f;
                if (advertAppInfo != null) {
                    bVar.v.setVisibility(advertAppInfo.Z4() ? 0 : 8);
                    if (this.a.f18415f.X4()) {
                        this.a.m.setVisibility(0);
                    } else {
                        this.a.B.setVisibility(0);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f18423e;

        /* renamed from: f  reason: collision with root package name */
        public float f18424f;

        /* renamed from: g  reason: collision with root package name */
        public float f18425g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f18426h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f18427i;

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
            this.f18427i = bVar;
            this.f18426h = onClickListener;
            this.f18423e = 0.0f;
            this.f18424f = 0.0f;
            this.f18425g = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        this.f18427i.q = 10.0f < this.f18425g;
                        b bVar = this.f18427i;
                        if (!bVar.q) {
                            this.f18426h.onClick(bVar.l);
                        }
                    } else if (action == 2) {
                        float x = motionEvent.getX() - this.f18423e;
                        float y = motionEvent.getY() - this.f18424f;
                        this.f18425g = (float) (this.f18425g + Math.sqrt((x * x) + (y * y)));
                        this.f18423e = motionEvent.getX();
                        this.f18424f = motionEvent.getY();
                    }
                } else {
                    this.f18427i.q = false;
                    this.f18423e = motionEvent.getX();
                    this.f18424f = motionEvent.getY();
                    this.f18425g = 0.0f;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f18428e;

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
            this.f18428e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int s;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f18428e;
                if (bVar.f18415f == null || bVar.f18414e == null) {
                    return;
                }
                if (bVar.q && view.getId() == R.id.big_image_ad_image) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                if (view.getId() == R.id.image_ad_button) {
                    s = this.f18428e.r(view);
                    str = "button";
                } else if (view.getId() == R.id.bottom_container) {
                    s = this.f18428e.q();
                    str = "title";
                } else {
                    s = this.f18428e.s();
                    str = this.f18428e.f18415f.W4() ? "image" : "video";
                }
                hashMap.put("da_area", str);
                this.f18428e.f18419j.a(s, hashMap);
            }
        }
    }

    /* loaded from: classes7.dex */
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

        @Override // c.a.s0.v.g.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.s0.v.a.a(this.a.f18414e.getButtonCmdScheme());
                c.a.s0.x1.o.h.c.h(c.a.s0.x1.o.h.c.e(this.a.f18415f));
                b bVar = this.a;
                if (bVar.f18417h != null && z.p(bVar.f18414e.getScheme()) && z.r(this.a.f18415f.v4)) {
                    b bVar2 = this.a;
                    Context context = bVar2.f18417h;
                    String scheme = bVar2.f18414e.getScheme();
                    String downloadId = this.a.f18415f.getDownloadId();
                    b bVar3 = this.a;
                    z.d(context, scheme, downloadId, bVar3.f18415f.k4, bVar3.f18414e.cmdScheme);
                    return true;
                } else if (this.a.f18417h == null || c.a.s0.a.h().u() || b0.a((Activity) this.a.f18417h)) {
                    return false;
                } else {
                    m.L((Activity) this.a.f18417h, R.string.write_external_storage_permission_denied_fun_disable);
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
        this.z = true;
        this.A = null;
        this.E = null;
        this.F = new f(this);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            H();
            if (this.A != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.A);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.D == null || this.E == null) {
            return;
        }
        c.a.s0.v.g.e.d().j(this.D, this.E);
    }

    public final void C(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) || downloadData == null) {
            return;
        }
        downloadData.setStatus(this.B.getDownloadStatus());
    }

    public void D(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            this.s = hVar;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.z = z;
        }
    }

    public void F(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
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

    public DownloadData G(AdvertAppInfo advertAppInfo, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, advertAppInfo, i2)) == null) {
            if (advertAppInfo == null) {
                return new DownloadData();
            }
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.u4);
            downloadData.setName(advertAppInfo.q4);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(c.a.d.f.m.b.e(advertAppInfo.d4, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.D == null || this.E == null) {
            return;
        }
        c.a.s0.v.g.e.d().r(this.D, this.E);
    }

    public void I() {
        WindowManager windowManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (windowManager = (WindowManager) this.f18417h.getSystemService("window")) == null) {
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

    @Override // c.a.s0.j3.i0.d.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f18418i == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f18417h).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
        this.f18420k = relativeLayout;
        this.l = (TbImageView) relativeLayout.findViewById(R.id.big_image_ad_image);
        this.m = (TBSpecificationBtn) this.f18420k.findViewById(R.id.image_ad_button);
        c.a.r0.s.i0.n.b bVar = new c.a.r0.s.i0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.m.setConfig(bVar);
        this.m.setTextHorizontalCenter(true);
        this.n = (TextView) this.f18420k.findViewById(R.id.ad_title);
        this.o = (TextView) this.f18420k.findViewById(R.id.ad_brand);
        this.p = (TextView) this.f18420k.findViewById(R.id.ad_tag);
        this.t = (RelativeLayout) this.f18420k.findViewById(R.id.ad_info_container);
        this.u = (RelativeLayout) this.f18420k.findViewById(R.id.bottom_container);
        ImageView imageView = (ImageView) this.f18420k.findViewById(R.id.video_ad_play_icon);
        this.v = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), null));
        this.w = (FrameLayout) this.f18420k.findViewById(R.id.ad_left_slide_guide);
        View findViewById = this.f18420k.findViewById(R.id.ad_slide_guide_mask_layer);
        this.x = findViewById;
        c.a.r0.s.v.c.d(findViewById).p(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f18420k.findViewById(R.id.ad_left_slide_guide_icon);
        this.y = tBLottieAnimationView;
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.ad_left_slide_guide_lottie);
        this.y.setRepeatCount(3);
        this.y.addOnAttachStateChangeListener(new a(this));
        ApkDownloadView apkDownloadView = (ApkDownloadView) this.f18420k.findViewById(R.id.image_download_button);
        this.B = apkDownloadView;
        TbPageContext tbPageContext = this.f18418i;
        if (tbPageContext != null) {
            apkDownloadView.enableDownloadListener(tbPageContext.getUniqueId());
        }
        this.B.setTextSize(R.dimen.tbds39);
        this.B.setTextColorInitSkin(R.color.CAM_X0101);
        this.B.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.B.changeSkin();
        F(this.F);
    }

    @Override // c.a.s0.j3.i0.d.a.a
    public void c(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adCard) == null) {
            super.c(adCard);
            if (adCard == null) {
                return;
            }
            l();
            this.C = this.f18414e.videoInfo;
            y();
            v(this.f18415f, this.f18414e);
            if (!TextUtils.isEmpty(this.f18415f.q4)) {
                this.o.setText(this.f18415f.q4);
                this.p.setText(this.f18417h.getString(R.string.advert_label));
            }
            if (!TextUtils.isEmpty(adCard.threadTitle)) {
                this.n.setText(adCard.threadTitle);
            }
            this.v.setVisibility(this.f18415f.Z4() ? 0 : 8);
            F(this.F);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.setVisibility(4);
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                this.f18420k.removeView(urlDragImageView);
            }
            UrlDragImageView urlDragImageView2 = new UrlDragImageView(this.f18417h);
            this.r = urlDragImageView2;
            urlDragImageView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.r.setIsCanDrag(true);
            this.r.setCanScale(false);
            this.r.setDragToExitListener(new d(this));
            this.f18420k.addView(this.r, 0);
        }
    }

    public void m(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.D = downloadCacheKey;
        H();
        this.E = null;
        AdDownloadData b2 = c.a.s0.v.g.e.d().b(downloadCacheKey);
        AdCard adCard = this.f18414e;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.f18414e.getAdvertAppInfo().n4;
            b2.setExtInfo(this.f18414e.getAdvertAppInfo().k4);
            b2.setDownloadKey(this.f18414e.getDownloadKey());
            JSONObject appJson = JsonTransHelper.toAppJson(this.f18414e.getAdvertAppInfo().p4);
            if (appJson != null) {
                b2.setAppJson(appJson.toString());
            }
            b2.setPage(str);
            b2.setDeeplinkUrl(this.f18414e.scheme);
            b2.setCmdScheme(this.f18414e.cmdScheme);
        }
        c.a.s0.v.g.e d2 = c.a.s0.v.g.e.d();
        ApkDownloadView apkDownloadView = this.B;
        c.a.s0.v.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.E = new c.a.s0.v.g.h.b(c2);
        if (b2 != null && b2.extra() != null && b2.extra().getPercent() > 0) {
            c2.d(b2);
        }
        this.B.onStatusChanged(b2.getCurrentState());
        B();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.A = new RunnableC1110b(this);
            c.a.d.f.m.e.a().postDelayed(this.A, 10000L);
        }
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f18420k : (View) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public final int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? x() : invokeV.intValue;
    }

    public final int r(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, view)) == null) ? x() : invokeL.intValue;
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f18415f.W4()) {
                return x();
            }
            return t();
        }
        return invokeV.intValue;
    }

    public final int t() {
        InterceptResult invokeV;
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f18415f == null || (adCard = this.f18414e) == null || this.C == null) {
                return 0;
            }
            return z.g(this.f18417h, adCard.getScheme(), this.f18415f, this.f18414e.cmdScheme);
        }
        return invokeV.intValue;
    }

    public void u() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (frameLayout = this.w) == null) {
            return;
        }
        frameLayout.setVisibility(8);
    }

    public void v(AdvertAppInfo advertAppInfo, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, advertAppInfo, adCard) == null) || advertAppInfo == null || adCard == null) {
            return;
        }
        this.f18415f = advertAppInfo;
        this.f18414e = adCard;
        if (advertAppInfo.X4()) {
            this.m.setText(adCard.getButtonText());
            this.B.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        this.B.setClickable(true);
        this.B.setInitText(adCard.getButtonText());
        this.B.setOnClickInterceptListener(new g(this));
        DownloadData G = G(this.f18415f, c.a.d.f.m.b.e(this.f18415f.j4, -1));
        C(G);
        this.B.setData(G);
        this.B.setVisibility(0);
        this.m.setVisibility(8);
        w(adCard, advertAppInfo);
    }

    public final void w(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, adCard, advertAppInfo) == null) || advertAppInfo == null || !advertAppInfo.V4() || adCard == null) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            i2 = c.a.s0.v.g.e.d().h(downloadId);
        } else {
            i2 = c.a.s0.v.g.e.d().i(scheme);
        }
        if (i2 == null) {
            i2 = DownloadCacheKey.create(downloadId, advertAppInfo.u4, advertAppInfo.v4);
            c.a.s0.v.g.e.d().j(i2, null);
        }
        m(i2);
    }

    public final int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? z.d(this.f18417h, this.f18414e.getScheme(), this.f18414e.getDownloadId(), this.f18415f.k4, this.f18414e.cmdScheme) : invokeV.intValue;
    }

    public final void y() {
        String picUrl;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.f18415f.Z4() && (videoInfo = this.C) != null) {
                picUrl = videoInfo.thumbnail_url;
            } else {
                picUrl = this.f18414e.getPicUrl();
            }
            this.l.setEvent(new c(this));
            this.l.startLoad(picUrl, this.f18416g ? 30 : 31, 720, 720, false);
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                urlDragImageView.setIsCdn(this.f18416g);
                this.r.setUrl(picUrl, true);
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.w == null || this.y == null || !p()) {
            return;
        }
        this.w.setVisibility(0);
        n();
        E(false);
    }
}

package b.a.r0.z2.i0.d.a;

import android.app.Activity;
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
import b.a.e.e.p.l;
import b.a.r0.l3.b0;
import b.a.r0.r.e.g.b;
import b.a.r0.z2.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.Direction;
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
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class b extends b.a.r0.z2.i0.d.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public ApkDownloadView B;
    public VideoInfo C;
    public DownloadCacheKey D;
    public b.a.r0.r.e.h.d E;
    public final View.OnClickListener F;
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
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28131e;

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
            this.f28131e = bVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f28131e.y.resumeAnimation();
                this.f28131e.y.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f28131e.y.cancelAnimation();
            }
        }
    }

    /* renamed from: b.a.r0.z2.i0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC1371b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28132e;

        public RunnableC1371b(b bVar) {
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
            this.f28132e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = (bVar = this.f28132e).w) == null || bVar.y == null || frameLayout.getVisibility() != 0) {
                return;
            }
            this.f28132e.y.cancelAnimation();
            this.f28132e.w.setVisibility(8);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28133a;

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
            this.f28133a = bVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f28133a.I();
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DragImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28134a;

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
            this.f28134a = bVar;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f28134a.s != null) {
                    this.f28134a.s.a();
                }
                this.f28134a.n.setVisibility(8);
                this.f28134a.o.setVisibility(8);
                this.f28134a.p.setVisibility(8);
                this.f28134a.t.setVisibility(8);
                this.f28134a.v.setVisibility(8);
                this.f28134a.m.setVisibility(8);
                this.f28134a.B.setVisibility(8);
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28134a.s == null) {
                return;
            }
            this.f28134a.s.b();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.f28134a.s != null) {
                    this.f28134a.s.c();
                }
                this.f28134a.n.setVisibility(0);
                this.f28134a.o.setVisibility(0);
                this.f28134a.p.setVisibility(0);
                this.f28134a.t.setVisibility(0);
                b bVar = this.f28134a;
                AdvertAppInfo advertAppInfo = bVar.f28127f;
                if (advertAppInfo != null) {
                    bVar.v.setVisibility(advertAppInfo.V4() ? 0 : 8);
                    if (this.f28134a.f28127f.T4()) {
                        this.f28134a.m.setVisibility(0);
                    } else {
                        this.f28134a.B.setVisibility(0);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public float f28135e;

        /* renamed from: f  reason: collision with root package name */
        public float f28136f;

        /* renamed from: g  reason: collision with root package name */
        public float f28137g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f28138h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f28139i;

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
            this.f28139i = bVar;
            this.f28138h = onClickListener;
            this.f28135e = 0.0f;
            this.f28136f = 0.0f;
            this.f28137g = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        this.f28139i.q = 10.0f < this.f28137g;
                        b bVar = this.f28139i;
                        if (!bVar.q) {
                            this.f28138h.onClick(bVar.l);
                        }
                    } else if (action == 2) {
                        float x = motionEvent.getX() - this.f28135e;
                        float y = motionEvent.getY() - this.f28136f;
                        this.f28137g = (float) (this.f28137g + Math.sqrt((x * x) + (y * y)));
                        this.f28135e = motionEvent.getX();
                        this.f28136f = motionEvent.getY();
                    }
                } else {
                    this.f28139i.q = false;
                    this.f28135e = motionEvent.getX();
                    this.f28136f = motionEvent.getY();
                    this.f28137g = 0.0f;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f28140e;

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
            this.f28140e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int s;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.f28140e;
                if (bVar.f28127f == null || bVar.f28126e == null) {
                    return;
                }
                if (bVar.q && view.getId() == R.id.big_image_ad_image) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                if (view.getId() == R.id.image_ad_button) {
                    s = this.f28140e.r(view);
                    str = "button";
                } else if (view.getId() == R.id.bottom_container) {
                    s = this.f28140e.q();
                    str = "title";
                } else {
                    s = this.f28140e.s();
                    str = this.f28140e.f28127f.S4() ? "image" : "video";
                }
                hashMap.put("da_area", str);
                this.f28140e.j.a(s, hashMap);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f28141a;

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
            this.f28141a = bVar;
        }

        @Override // b.a.r0.r.e.g.b.a
        public boolean onClickIntercept(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                b.a.r0.q1.o.h.c.h(b.a.r0.q1.o.h.c.e(this.f28141a.f28127f));
                b bVar = this.f28141a;
                if (bVar.f28129h != null && z.o(bVar.f28126e.getScheme()) && z.q(this.f28141a.f28127f.p4)) {
                    b bVar2 = this.f28141a;
                    z.d(bVar2.f28129h, bVar2.f28126e.getScheme(), this.f28141a.f28127f.getDownloadId(), this.f28141a.f28127f.e4);
                    return true;
                } else if (this.f28141a.f28129h == null || b.a.r0.a.h().u() || b0.a((Activity) this.f28141a.f28129h)) {
                    return false;
                } else {
                    l.L((Activity) this.f28141a.f28129h, R.string.write_external_storage_permission_denied_fun_disable);
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
                b.a.e.e.m.e.a().removeCallbacks(this.A);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.D == null || this.E == null) {
            return;
        }
        b.a.r0.r.e.e.c().i(this.D, this.E);
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
            downloadData.setUrl(advertAppInfo.o4);
            downloadData.setName(advertAppInfo.k4);
            downloadData.setPosition(i2);
            downloadData.setNotifyId(b.a.e.e.m.b.e(advertAppInfo.X3, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.D == null || this.E == null) {
            return;
        }
        b.a.r0.r.e.e.c().q(this.D, this.E);
    }

    public void I() {
        WindowManager windowManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (windowManager = (WindowManager) this.f28129h.getSystemService("window")) == null) {
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

    @Override // b.a.r0.z2.i0.d.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f28130i == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f28129h).inflate(R.layout.ad_pic_page_layout, (ViewGroup) null);
        this.k = relativeLayout;
        this.l = (TbImageView) relativeLayout.findViewById(R.id.big_image_ad_image);
        this.m = (TBSpecificationBtn) this.k.findViewById(R.id.image_ad_button);
        b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
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
        b.a.q0.s.u.c.d(findViewById).p(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.k.findViewById(R.id.ad_left_slide_guide_icon);
        this.y = tBLottieAnimationView;
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.ad_left_slide_guide_lottie);
        this.y.setRepeatCount(3);
        this.y.addOnAttachStateChangeListener(new a(this));
        ApkDownloadView apkDownloadView = (ApkDownloadView) this.k.findViewById(R.id.image_download_button);
        this.B = apkDownloadView;
        TbPageContext tbPageContext = this.f28130i;
        if (tbPageContext != null) {
            apkDownloadView.enableDownloadListener(tbPageContext.getUniqueId());
        }
        this.B.setTextSize(R.dimen.tbds39);
        this.B.setTextColorInitSkin(R.color.CAM_X0101);
        this.B.setBackgroundSkin(R.drawable.pic_page_down_btn_bg);
        this.B.changeSkin();
        F(this.F);
    }

    @Override // b.a.r0.z2.i0.d.a.a
    public void c(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adCard) == null) {
            super.c(adCard);
            if (adCard == null) {
                return;
            }
            l();
            this.C = this.f28126e.videoInfo;
            y();
            v(this.f28127f, this.f28126e);
            if (!TextUtils.isEmpty(this.f28127f.k4)) {
                this.o.setText(this.f28127f.k4);
                this.p.setText(this.f28129h.getString(R.string.advert_label));
            }
            if (!TextUtils.isEmpty(adCard.threadTitle)) {
                this.n.setText(adCard.threadTitle);
            }
            this.v.setVisibility(this.f28127f.V4() ? 0 : 8);
            F(this.F);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.setVisibility(4);
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                this.k.removeView(urlDragImageView);
            }
            UrlDragImageView urlDragImageView2 = new UrlDragImageView(this.f28129h);
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
        if (!(interceptable == null || interceptable.invokeL(1048588, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.D = downloadCacheKey;
        H();
        this.E = null;
        AdDownloadData b2 = b.a.r0.r.e.e.c().b(downloadCacheKey);
        AdCard adCard = this.f28126e;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.f28126e.getAdvertAppInfo().h4;
            b2.setExtInfo(this.f28126e.getAdvertAppInfo().e4);
            b2.setDownloadKey(this.f28126e.getDownloadKey());
            JSONObject json = App.toJson(this.f28126e.getAdvertAppInfo().j4);
            if (json != null) {
                b2.setAppJson(json.toString());
            }
            b2.setPage(str);
            b2.setDeeplinkUrl(this.f28126e.scheme);
        }
        b.a.r0.r.d.b.d.a aVar = new b.a.r0.r.d.b.d.a(this.B, b2);
        this.E = new b.a.r0.r.e.h.b(aVar);
        if (b2 != null && b2.extra() != null && b2.extra().getPercent() > 0) {
            aVar.e(b2);
        }
        this.B.onStatusChanged(b2.getCurrentState());
        B();
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.A = new RunnableC1371b(this);
            b.a.e.e.m.e.a().postDelayed(this.A, 10000L);
        }
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : (View) invokeV.objValue;
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
            if (this.f28127f.S4()) {
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
            if (this.f28127f == null || (adCard = this.f28126e) == null || this.C == null) {
                return 0;
            }
            return z.g(this.f28129h, adCard.getScheme(), this.f28127f);
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
        this.f28127f = advertAppInfo;
        this.f28126e = adCard;
        if (advertAppInfo.T4()) {
            this.m.setText(adCard.getButtonText());
            this.B.setVisibility(8);
            this.m.setVisibility(0);
            return;
        }
        this.B.setClickable(true);
        this.B.setInitText(adCard.getButtonText());
        this.B.setOnClickInterceptListener(new g(this));
        DownloadData G = G(this.f28127f, b.a.e.e.m.b.e(this.f28127f.d4, -1));
        C(G);
        this.B.setData(G);
        this.B.setVisibility(0);
        this.m.setVisibility(8);
        w(adCard, advertAppInfo);
    }

    public final void w(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, adCard, advertAppInfo) == null) || advertAppInfo == null || !advertAppInfo.R4() || adCard == null) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            h2 = b.a.r0.r.e.e.c().g(downloadId);
        } else {
            h2 = b.a.r0.r.e.e.c().h(scheme);
        }
        if (h2 == null) {
            h2 = DownloadCacheKey.create(downloadId, advertAppInfo.o4, advertAppInfo.p4);
            b.a.r0.r.e.e.c().i(h2, null);
        }
        m(h2);
    }

    public final int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? z.d(this.f28129h, this.f28126e.getScheme(), this.f28126e.getDownloadId(), this.f28127f.e4) : invokeV.intValue;
    }

    public final void y() {
        String picUrl;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.f28127f.V4() && (videoInfo = this.C) != null) {
                picUrl = videoInfo.thumbnail_url;
            } else {
                picUrl = this.f28126e.getPicUrl();
            }
            this.l.setEvent(new c(this));
            this.l.startLoad(picUrl, this.f28128g ? 30 : 31, 720, 720, false);
            UrlDragImageView urlDragImageView = this.r;
            if (urlDragImageView != null) {
                urlDragImageView.setIsCdn(this.f28128g);
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

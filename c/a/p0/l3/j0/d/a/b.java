package c.a.p0.l3.j0.d.a;

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
import c.a.p0.a4.c0;
import c.a.p0.l3.a0;
import c.a.p0.x.g.g.b;
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
public class b extends c.a.p0.l3.j0.d.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View.OnClickListener A;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f16254g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f16255h;
    public TBSpecificationBtn i;
    public TextView j;
    public TextView k;
    public TextView l;
    public boolean m;
    public UrlDragImageView n;
    public DragImageView.h o;
    public RelativeLayout p;
    public RelativeLayout q;
    public ImageView r;
    public FrameLayout s;
    public View t;
    public TBLottieAnimationView u;
    public Runnable v;
    public ApkDownloadView w;
    public VideoInfo x;
    public DownloadCacheKey y;
    public c.a.p0.x.g.h.d z;

    /* loaded from: classes2.dex */
    public class a implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.u.resumeAnimation();
                this.a.u.playAnimation();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.a.u.cancelAnimation();
            }
        }
    }

    /* renamed from: c.a.p0.l3.j0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1213b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public RunnableC1213b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (frameLayout = (bVar = this.a).s) == null || bVar.u == null || frameLayout.getVisibility() != 0) {
                return;
            }
            this.a.u.cancelAnimation();
            this.a.s.setVisibility(8);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.L();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (this.a.o != null) {
                    this.a.o.a();
                }
                this.a.j.setVisibility(8);
                this.a.k.setVisibility(8);
                this.a.l.setVisibility(8);
                this.a.p.setVisibility(8);
                this.a.r.setVisibility(8);
                this.a.i.setVisibility(8);
                this.a.w.setVisibility(8);
            }
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.o == null) {
                return;
            }
            this.a.o.b();
        }

        @Override // com.baidu.tbadk.widget.DragImageView.h
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.o != null) {
                    this.a.o.c();
                }
                this.a.j.setVisibility(0);
                this.a.k.setVisibility(0);
                this.a.l.setVisibility(0);
                this.a.p.setVisibility(0);
                b bVar = this.a;
                AdvertAppInfo advertAppInfo = bVar.f16249b;
                if (advertAppInfo != null) {
                    bVar.r.setVisibility(advertAppInfo.r() ? 0 : 8);
                    if (this.a.f16249b.m()) {
                        this.a.i.setVisibility(0);
                    } else {
                        this.a.w.setVisibility(0);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f16256b;

        /* renamed from: c  reason: collision with root package name */
        public float f16257c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f16258d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16259e;

        public e(b bVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16259e = bVar;
            this.f16258d = onClickListener;
            this.a = 0.0f;
            this.f16256b = 0.0f;
            this.f16257c = 0.0f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        this.f16259e.m = 10.0f < this.f16257c;
                        b bVar = this.f16259e;
                        if (!bVar.m) {
                            this.f16258d.onClick(bVar.f16255h);
                        }
                    } else if (action == 2) {
                        float x = motionEvent.getX() - this.a;
                        float y = motionEvent.getY() - this.f16256b;
                        this.f16257c = (float) (this.f16257c + Math.sqrt((x * x) + (y * y)));
                        this.a = motionEvent.getX();
                        this.f16256b = motionEvent.getY();
                    }
                } else {
                    this.f16259e.m = false;
                    this.a = motionEvent.getX();
                    this.f16256b = motionEvent.getY();
                    this.f16257c = 0.0f;
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
        public final /* synthetic */ b a;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int w;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b bVar = this.a;
                if (bVar.f16249b == null || bVar.a == null) {
                    return;
                }
                if (bVar.m && view.getId() == R.id.obfuscated_res_0x7f090368) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<>();
                if (view.getId() == R.id.obfuscated_res_0x7f090e6b) {
                    w = this.a.v(view);
                    str = "button";
                } else if (view.getId() == R.id.obfuscated_res_0x7f0903bb) {
                    w = this.a.u();
                    str = "title";
                } else {
                    w = this.a.w();
                    str = this.a.f16249b.k() ? "image" : "video";
                }
                hashMap.put("da_area", str);
                this.a.f16253f.a(w, hashMap);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.p0.x.g.g.b.a
        public boolean b(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.p0.x.a.a(this.a.a.getButtonCmdScheme());
                c.a.p0.b2.o.h.c.h(c.a.p0.b2.o.h.c.e(this.a.f16249b));
                b bVar = this.a;
                if (bVar.f16251d != null && a0.p(bVar.a.getScheme()) && a0.r(this.a.f16249b.s)) {
                    b bVar2 = this.a;
                    Context context = bVar2.f16251d;
                    String scheme = bVar2.a.getScheme();
                    String downloadId = this.a.f16249b.getDownloadId();
                    b bVar3 = this.a;
                    a0.d(context, scheme, downloadId, bVar3.f16249b.f29821h, bVar3.a.cmdScheme);
                    return true;
                } else if (this.a.f16251d == null || c.a.p0.a.h().u() || c0.a((Activity) this.a.f16251d)) {
                    return false;
                } else {
                    n.M((Activity) this.a.f16251d, R.string.obfuscated_res_0x7f0f157e);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.v = null;
        this.z = null;
        this.A = new f(this);
    }

    public final void A(AdCard adCard, AdvertAppInfo advertAppInfo) {
        DownloadCacheKey i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, adCard, advertAppInfo) == null) || advertAppInfo == null || !advertAppInfo.i() || adCard == null) {
            return;
        }
        String scheme = adCard.getScheme();
        String downloadId = adCard.getDownloadId();
        if (!TextUtils.isEmpty(downloadId)) {
            i = c.a.p0.x.g.e.d().h(downloadId);
        } else {
            i = c.a.p0.x.g.e.d().i(scheme);
        }
        if (i == null) {
            i = DownloadCacheKey.create(downloadId, advertAppInfo.r, advertAppInfo.s);
            c.a.p0.x.g.e.d().j(i, null);
        }
        r(i);
    }

    public final int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a0.d(this.f16251d, this.a.getScheme(), this.a.getDownloadId(), this.f16249b.f29821h, this.a.cmdScheme) : invokeV.intValue;
    }

    public final void C() {
        String picUrl;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f16249b.r() && (videoInfo = this.x) != null) {
                picUrl = videoInfo.thumbnail_url;
            } else {
                picUrl = this.a.getPicUrl();
            }
            this.f16255h.setEvent(new c(this));
            this.f16255h.G(picUrl, this.f16250c ? 30 : 31, 720, 720, false);
            UrlDragImageView urlDragImageView = this.n;
            if (urlDragImageView != null) {
                urlDragImageView.setIsCdn(this.f16250c);
                this.n.setUrl(picUrl, true);
            }
        }
    }

    public void D() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (frameLayout = this.s) == null || this.u == null) {
            return;
        }
        frameLayout.setVisibility(0);
        this.u.playAnimation();
        s();
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            K();
            if (this.v != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.v);
            }
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.y == null || this.z == null) {
            return;
        }
        c.a.p0.x.g.e.d().j(this.y, this.z);
    }

    public final void G(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, downloadData) == null) || downloadData == null) {
            return;
        }
        downloadData.setStatus(this.w.getDownloadStatus());
    }

    public void H(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
            this.o = hVar;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.i;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(onClickListener);
            }
            TbImageView tbImageView = this.f16255h;
            if (tbImageView != null) {
                tbImageView.setOnClickListener(onClickListener);
            }
            RelativeLayout relativeLayout = this.q;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(onClickListener);
            }
            ImageView imageView = this.r;
            if (imageView != null) {
                imageView.setOnClickListener(onClickListener);
            }
            UrlDragImageView urlDragImageView = this.n;
            if (urlDragImageView != null) {
                urlDragImageView.setOuterOnTouchListener(new e(this, onClickListener));
            }
        }
    }

    public DownloadData J(AdvertAppInfo advertAppInfo, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, advertAppInfo, i)) == null) {
            if (advertAppInfo == null) {
                return new DownloadData();
            }
            DownloadData downloadData = new DownloadData(advertAppInfo.getDownloadId());
            downloadData.setUrl(advertAppInfo.r);
            downloadData.setName(advertAppInfo.n);
            downloadData.setPosition(i);
            downloadData.setNotifyId(c.a.d.f.m.b.e(advertAppInfo.a, 0));
            return downloadData;
        }
        return (DownloadData) invokeLI.objValue;
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.y == null || this.z == null) {
            return;
        }
        c.a.p0.x.g.e.d().r(this.y, this.z);
    }

    public void L() {
        WindowManager windowManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (windowManager = (WindowManager) this.f16251d.getSystemService("window")) == null) {
            return;
        }
        int width = windowManager.getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.f16255h.getLayoutParams();
        double loadedHeight = this.f16255h.getLoadedHeight() / this.f16255h.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (width * loadedHeight);
            layoutParams.width = width;
        }
        this.f16255h.setLayoutParams(layoutParams);
    }

    @Override // c.a.p0.l3.j0.d.a.a
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f16252e == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f16251d).inflate(R.layout.obfuscated_res_0x7f0d0070, (ViewGroup) null);
        this.f16254g = relativeLayout;
        this.f16255h = (TbImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090368);
        this.i = (TBSpecificationBtn) this.f16254g.findViewById(R.id.obfuscated_res_0x7f090e6b);
        c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
        bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
        this.i.setConfig(bVar);
        this.i.setTextHorizontalCenter(true);
        this.j = (TextView) this.f16254g.findViewById(R.id.obfuscated_res_0x7f0900f3);
        this.k = (TextView) this.f16254g.findViewById(R.id.obfuscated_res_0x7f090090);
        this.l = (TextView) this.f16254g.findViewById(R.id.obfuscated_res_0x7f0900eb);
        this.p = (RelativeLayout) this.f16254g.findViewById(R.id.obfuscated_res_0x7f0900af);
        this.q = (RelativeLayout) this.f16254g.findViewById(R.id.obfuscated_res_0x7f0903bb);
        ImageView imageView = (ImageView) this.f16254g.findViewById(R.id.obfuscated_res_0x7f092307);
        this.r = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), null));
        this.s = (FrameLayout) this.f16254g.findViewById(R.id.obfuscated_res_0x7f0900ce);
        View findViewById = this.f16254g.findViewById(R.id.obfuscated_res_0x7f0900e3);
        this.t = findViewById;
        c.a.o0.r.v.c.d(findViewById).p(new int[]{R.color.black_alpha40, R.color.black_alpha0}, Direction.RIGHT);
        TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) this.f16254g.findViewById(R.id.obfuscated_res_0x7f0900cf);
        this.u = tBLottieAnimationView;
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f110000);
        this.u.setRepeatCount(3);
        this.u.addOnAttachStateChangeListener(new a(this));
        ApkDownloadView apkDownloadView = (ApkDownloadView) this.f16254g.findViewById(R.id.obfuscated_res_0x7f090e70);
        this.w = apkDownloadView;
        TbPageContext tbPageContext = this.f16252e;
        if (tbPageContext != null) {
            apkDownloadView.k(tbPageContext.getUniqueId());
        }
        this.w.setTextSize(R.dimen.tbds39);
        this.w.setTextColorInitSkin(R.color.CAM_X0101);
        this.w.setBackgroundSkin(R.drawable.obfuscated_res_0x7f080f39);
        this.w.j();
        I(this.A);
    }

    @Override // c.a.p0.l3.j0.d.a.a
    public void d(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, adCard) == null) {
            super.d(adCard);
            if (adCard == null) {
                return;
            }
            q();
            this.x = this.a.videoInfo;
            C();
            z(this.f16249b, this.a);
            if (!TextUtils.isEmpty(this.f16249b.n)) {
                this.k.setText(this.f16249b.n);
                this.l.setText(this.f16251d.getString(R.string.obfuscated_res_0x7f0f00d9));
            }
            if (!TextUtils.isEmpty(adCard.threadTitle)) {
                this.j.setText(adCard.threadTitle);
            }
            this.r.setVisibility(this.f16249b.r() ? 0 : 8);
            I(this.A);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f16255h.setVisibility(4);
            UrlDragImageView urlDragImageView = this.n;
            if (urlDragImageView != null) {
                this.f16254g.removeView(urlDragImageView);
            }
            UrlDragImageView urlDragImageView2 = new UrlDragImageView(this.f16251d);
            this.n = urlDragImageView2;
            urlDragImageView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.n.setIsCanDrag(true);
            this.n.setCanScale(false);
            this.n.setDragToExitListener(new d(this));
            this.f16254g.addView(this.n, 0);
        }
    }

    public void r(DownloadCacheKey downloadCacheKey) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, downloadCacheKey) == null) || downloadCacheKey == null) {
            return;
        }
        this.y = downloadCacheKey;
        K();
        this.z = null;
        AdDownloadData b2 = c.a.p0.x.g.e.d().b(downloadCacheKey);
        AdCard adCard = this.a;
        if (adCard != null && adCard.getAdvertAppInfo() != null) {
            String str = this.a.getAdvertAppInfo().k;
            b2.setExtInfo(this.a.getAdvertAppInfo().f29821h);
            b2.setDownloadKey(this.a.getDownloadKey());
            JSONObject appJson = JsonTransHelper.toAppJson(this.a.getAdvertAppInfo().m);
            if (appJson != null) {
                b2.setAppJson(appJson.toString());
            }
            b2.setPage(str);
            b2.setDeeplinkUrl(this.a.scheme);
            b2.setCmdScheme(this.a.cmdScheme);
        }
        c.a.p0.x.g.e d2 = c.a.p0.x.g.e.d();
        ApkDownloadView apkDownloadView = this.w;
        c.a.p0.x.g.g.c c2 = d2.c(apkDownloadView, apkDownloadView, b2);
        this.z = new c.a.p0.x.g.h.b(c2);
        if (b2 != null && b2.extra() != null && b2.extra().getPercent() > 0) {
            c2.e(b2);
        }
        this.w.d(b2.getCurrentState());
        F();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.v = new RunnableC1213b(this);
            c.a.d.f.m.e.a().postDelayed(this.v, 10000L);
        }
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f16254g : (View) invokeV.objValue;
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? B() : invokeV.intValue;
    }

    public final int v(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, view)) == null) ? B() : invokeL.intValue;
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.f16249b.k()) {
                return B();
            }
            return x();
        }
        return invokeV.intValue;
    }

    public final int x() {
        InterceptResult invokeV;
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f16249b == null || (adCard = this.a) == null || this.x == null) {
                return 0;
            }
            return a0.g(this.f16251d, adCard.getScheme(), this.f16249b, this.a.playCmdScheme);
        }
        return invokeV.intValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            TBLottieAnimationView tBLottieAnimationView = this.u;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            FrameLayout frameLayout = this.s;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
    }

    public void z(AdvertAppInfo advertAppInfo, AdCard adCard) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, advertAppInfo, adCard) == null) || advertAppInfo == null || adCard == null) {
            return;
        }
        this.f16249b = advertAppInfo;
        this.a = adCard;
        if (advertAppInfo.m()) {
            this.i.setText(adCard.getButtonText());
            this.w.setVisibility(8);
            this.i.setVisibility(0);
            return;
        }
        this.w.setClickable(true);
        this.w.setInitText(adCard.getButtonText());
        this.w.setOnClickInterceptListener(new g(this));
        DownloadData J = J(this.f16249b, c.a.d.f.m.b.e(this.f16249b.f29820g, -1));
        G(J);
        this.w.setData(J);
        this.w.setVisibility(0);
        this.i.setVisibility(8);
        A(adCard, advertAppInfo);
    }
}

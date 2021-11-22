package b.a.r0.w.f.g.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.c1.r0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class f extends b.a.r0.w.f.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f26398f;

    /* renamed from: g  reason: collision with root package name */
    public TbCyberVideoView f26399g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f26400h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f26401i;
    public TextView j;
    public VideoInfo k;
    public String l;
    public String m;
    public long n;
    public String o;
    public CyberPlayerManager.OnPreparedListener p;
    public CyberPlayerManager.OnErrorListener q;
    public TbCyberVideoView.h r;

    /* loaded from: classes5.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26402e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26402e = fVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26402e.s();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26403e;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26403e = fVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26403e.s();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26404e;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26404e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f26404e.f26381d.f26333b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            f fVar = this.f26404e;
            urlManager.dealOneLink(fVar.f26380c, new String[]{fVar.f26381d.f26333b}, true);
            b.a.r0.w.f.e.a c2 = b.a.r0.w.f.e.a.c();
            f fVar2 = this.f26404e;
            c2.f("c12909", fVar2.f26381d.f26336e, 2, fVar2.m, this.f26404e.n, this.f26404e.o, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext) {
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
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this);
    }

    @Override // b.a.r0.w.f.g.f.a
    public void b(b.a.r0.w.f.g.c.a aVar) {
        String title;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            if (!ListUtils.isEmpty(this.f26381d.f26334c) && this.f26381d.f26334c.get(0) != null) {
                this.k = this.f26381d.f26334c.get(0).r1();
                this.m = this.f26381d.f26334c.get(0).f0();
                this.n = this.f26381d.f26334c.get(0).T();
                this.o = this.f26381d.f26334c.get(0).Z();
            }
            VideoInfo videoInfo = this.k;
            if (videoInfo != null) {
                this.f26401i.startLoad(videoInfo.thumbnail_url, 10, false);
                if (!TextUtils.isEmpty(this.f26381d.f26334c.get(0).h1())) {
                    title = this.f26381d.f26334c.get(0).h1().toString();
                } else {
                    title = this.f26381d.f26334c.get(0).getTitle();
                }
                if (!TextUtils.isEmpty(title)) {
                    this.j.setText(title);
                }
                this.l = this.k.video_url;
                b.a.r0.w.f.e.a.c().f("c12908", this.f26381d.f26336e, 2, this.m, this.n, this.o, null);
            }
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f26398f : (View) invokeV.objValue;
    }

    @Override // b.a.r0.w.f.g.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26398f = LayoutInflater.from(this.f26380c.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
            this.f26398f.setLayoutParams(new FrameLayout.LayoutParams(this.f26378a, this.f26379b));
            TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) this.f26398f.findViewById(R.id.video_view);
            this.f26399g = tbCyberVideoView;
            tbCyberVideoView.setOnPreparedListener(this.p);
            this.f26399g.setOnErrorListener(this.q);
            this.f26399g.setOnSurfaceDestroyedListener(this.r);
            this.f26399g.setOnCompletionListener(new d(this));
            this.f26399g.setStageType(null);
            this.f26400h = (ImageView) this.f26398f.findViewById(R.id.video_play_btn);
            TbImageView tbImageView = (TbImageView) this.f26398f.findViewById(R.id.video_cover_img);
            this.f26401i = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f26401i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.j = (TextView) this.f26398f.findViewById(R.id.video_title);
            this.f26398f.setOnClickListener(new e(this));
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public boolean f(b.a.r0.w.f.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 2 != aVar.f26335d || TextUtils.isEmpty(aVar.f26332a)) ? false : true : invokeL.booleanValue;
    }

    @Override // b.a.r0.w.f.g.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f26398f.getLayoutParams();
            layoutParams.width = this.f26378a;
            layoutParams.height = this.f26379b;
            this.f26398f.setLayoutParams(layoutParams);
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void j() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tbCyberVideoView = this.f26399g) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
        this.f26399g.clearCallbackAndRemoveFromWindow();
        this.f26399g = null;
    }

    @Override // b.a.r0.w.f.g.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.f26399g;
            if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
                this.f26400h.setVisibility(0);
                this.f26399g.pause();
            }
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.f26399g;
            if (tbCyberVideoView == null || !tbCyberVideoView.isPlaying()) {
                this.f26400h.setVisibility(8);
                this.f26399g.start();
            }
        }
    }

    @Override // b.a.r0.w.f.g.f.a
    public void m() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbCyberVideoView = this.f26399g) == null || tbCyberVideoView.isPlaying()) {
            return;
        }
        this.f26401i.setVisibility(0);
        if (TextUtils.isEmpty(this.l) || !r0.b(1, this.l)) {
            return;
        }
        this.f26399g.setVideoPath(this.l);
        this.f26399g.setLooping(true);
    }

    @Override // b.a.r0.w.f.g.f.a
    public void n() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tbCyberVideoView = this.f26399g) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b.a.r0.w.f.e.a.c().f("c12910", this.f26381d.f26336e, 2, this.m, this.n, this.o, null);
            this.f26401i.setVisibility(8);
            this.f26400h.setVisibility(8);
            TbCyberVideoView tbCyberVideoView = this.f26399g;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.setVolume(0.0f, 0.0f);
                try {
                    this.f26399g.start();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}

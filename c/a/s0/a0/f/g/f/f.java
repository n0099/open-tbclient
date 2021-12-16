package c.a.s0.a0.f.g.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.d1.u0;
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
/* loaded from: classes6.dex */
public class f extends c.a.s0.a0.f.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f14518f;

    /* renamed from: g  reason: collision with root package name */
    public TbCyberVideoView f14519g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f14520h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f14521i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f14522j;

    /* renamed from: k  reason: collision with root package name */
    public VideoInfo f14523k;
    public String l;
    public String m;
    public long n;
    public String o;
    public CyberPlayerManager.OnPreparedListener p;
    public CyberPlayerManager.OnErrorListener q;
    public TbCyberVideoView.h r;

    /* loaded from: classes6.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f14524e;

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
            this.f14524e = fVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14524e.s();
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class d implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f14525e;

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
            this.f14525e = fVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14525e.s();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f14526e;

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
            this.f14526e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f14526e.f14502d.f14462b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            f fVar = this.f14526e;
            urlManager.dealOneLink(fVar.f14501c, new String[]{fVar.f14502d.f14462b}, true);
            c.a.s0.a0.f.e.a c2 = c.a.s0.a0.f.e.a.c();
            f fVar2 = this.f14526e;
            c2.f("c12909", fVar2.f14502d.f14465e, 2, fVar2.m, this.f14526e.n, this.f14526e.o, null);
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

    @Override // c.a.s0.a0.f.g.f.a
    public void b(c.a.s0.a0.f.g.c.a aVar) {
        String title;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            if (!ListUtils.isEmpty(this.f14502d.f14463c) && this.f14502d.f14463c.get(0) != null) {
                this.f14523k = this.f14502d.f14463c.get(0).t1();
                this.m = this.f14502d.f14463c.get(0).g0();
                this.n = this.f14502d.f14463c.get(0).U();
                this.o = this.f14502d.f14463c.get(0).a0();
            }
            VideoInfo videoInfo = this.f14523k;
            if (videoInfo != null) {
                this.f14521i.startLoad(videoInfo.thumbnail_url, 10, false);
                if (!TextUtils.isEmpty(this.f14502d.f14463c.get(0).i1())) {
                    title = this.f14502d.f14463c.get(0).i1().toString();
                } else {
                    title = this.f14502d.f14463c.get(0).getTitle();
                }
                if (!TextUtils.isEmpty(title)) {
                    this.f14522j.setText(title);
                }
                this.l = this.f14523k.video_url;
                c.a.s0.a0.f.e.a.c().f("c12908", this.f14502d.f14465e, 2, this.m, this.n, this.o, null);
            }
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14518f : (View) invokeV.objValue;
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14518f = LayoutInflater.from(this.f14501c.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
            this.f14518f.setLayoutParams(new FrameLayout.LayoutParams(this.a, this.f14500b));
            TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) this.f14518f.findViewById(R.id.video_view);
            this.f14519g = tbCyberVideoView;
            tbCyberVideoView.setOnPreparedListener(this.p);
            this.f14519g.setOnErrorListener(this.q);
            this.f14519g.setOnSurfaceDestroyedListener(this.r);
            this.f14519g.setOnCompletionListener(new d(this));
            this.f14519g.setStageType(null);
            this.f14520h = (ImageView) this.f14518f.findViewById(R.id.video_play_btn);
            TbImageView tbImageView = (TbImageView) this.f14518f.findViewById(R.id.video_cover_img);
            this.f14521i = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14521i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14522j = (TextView) this.f14518f.findViewById(R.id.video_title);
            this.f14518f.setOnClickListener(new e(this));
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public boolean f(c.a.s0.a0.f.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 2 != aVar.f14464d || TextUtils.isEmpty(aVar.a)) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14518f.getLayoutParams();
            layoutParams.width = this.a;
            layoutParams.height = this.f14500b;
            this.f14518f.setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            SkinManager.setViewTextColor(this.f14522j, R.color.CAM_X0111);
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void j() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tbCyberVideoView = this.f14519g) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
        this.f14519g.clearCallbackAndRemoveFromWindow();
        this.f14519g = null;
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.f14519g;
            if (tbCyberVideoView == null || tbCyberVideoView.isPlaying()) {
                this.f14520h.setVisibility(0);
                this.f14519g.pause();
            }
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.f14519g;
            if (tbCyberVideoView == null || !tbCyberVideoView.isPlaying()) {
                this.f14520h.setVisibility(8);
                this.f14519g.start();
            }
        }
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void m() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbCyberVideoView = this.f14519g) == null || tbCyberVideoView.isPlaying()) {
            return;
        }
        this.f14521i.setVisibility(0);
        if (TextUtils.isEmpty(this.l) || !u0.b(1, this.l)) {
            return;
        }
        this.f14519g.setVideoPath(this.l);
        this.f14519g.setLooping(true);
    }

    @Override // c.a.s0.a0.f.g.f.a
    public void n() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tbCyberVideoView = this.f14519g) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.s0.a0.f.e.a.c().f("c12910", this.f14502d.f14465e, 2, this.m, this.n, this.o, null);
            this.f14521i.setVisibility(8);
            this.f14520h.setVisibility(8);
            TbCyberVideoView tbCyberVideoView = this.f14519g;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.setVolume(0.0f, 0.0f);
                try {
                    this.f14519g.start();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}

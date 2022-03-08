package c.a.r0.a0.f.g.f;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c1.t0;
import c.a.q0.r.r.e2;
import c.a.r0.a3.t;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class f extends c.a.r0.a0.f.g.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public View f14484f;

    /* renamed from: g  reason: collision with root package name */
    public TbVideoViewContainer f14485g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f14486h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f14487i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f14488j;
    public VideoInfo k;
    public String l;
    public String m;
    public long n;
    public String o;
    public c.a.r0.a3.v.a p;

    /* loaded from: classes2.dex */
    public class a implements c.a.r0.a3.v.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f14489e;

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
            this.f14489e = fVar;
        }

        @Override // c.a.r0.a3.v.a
        public void changeRenderViewMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.r0.a3.v.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f14489e.s();
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, obj)) == null) {
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.f14489e.s();
            }
        }

        @Override // c.a.r0.a3.v.a
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setData(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, e2Var) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setStatistic(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, tVar) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f14490e;

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
                    return;
                }
            }
            this.f14490e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f14490e.f14469d.f14430b)) {
                return;
            }
            UrlManager urlManager = UrlManager.getInstance();
            f fVar = this.f14490e;
            urlManager.dealOneLink(fVar.f14468c, new String[]{fVar.f14469d.f14430b}, true);
            c.a.r0.a0.f.e.a c2 = c.a.r0.a0.f.e.a.c();
            f fVar2 = this.f14490e;
            c2.f("c12909", fVar2.f14469d.f14433e, 2, fVar2.m, this.f14490e.n, this.f14490e.o, null);
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
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void b(c.a.r0.a0.f.g.c.a aVar) {
        String title;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.b(aVar);
            if (!ListUtils.isEmpty(this.f14469d.f14431c) && this.f14469d.f14431c.get(0) != null) {
                this.k = this.f14469d.f14431c.get(0).u1();
                this.m = this.f14469d.f14431c.get(0).h0();
                this.n = this.f14469d.f14431c.get(0).U();
                this.o = this.f14469d.f14431c.get(0).b0();
            }
            VideoInfo videoInfo = this.k;
            if (videoInfo != null) {
                this.f14487i.startLoad(videoInfo.thumbnail_url, 10, false);
                if (!TextUtils.isEmpty(this.f14469d.f14431c.get(0).j1())) {
                    title = this.f14469d.f14431c.get(0).j1().toString();
                } else {
                    title = this.f14469d.f14431c.get(0).getTitle();
                }
                if (!TextUtils.isEmpty(title)) {
                    this.f14488j.setText(title);
                }
                this.l = this.k.video_url;
                c.a.r0.a0.f.e.a.c().f("c12908", this.f14469d.f14433e, 2, this.m, this.n, this.o, null);
            }
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14484f : (View) invokeV.objValue;
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14484f = LayoutInflater.from(this.f14468c.getPageActivity()).inflate(R.layout.special_video_view, (ViewGroup) null);
            this.f14484f.setLayoutParams(new FrameLayout.LayoutParams(this.a, this.f14467b));
            TbVideoViewContainer tbVideoViewContainer = (TbVideoViewContainer) this.f14484f.findViewById(R.id.video_view);
            this.f14485g = tbVideoViewContainer;
            tbVideoViewContainer.getControl().setOperableVideoContainer(this.p);
            this.f14485g.getControl().setStageType(null);
            this.f14486h = (ImageView) this.f14484f.findViewById(R.id.video_play_btn);
            TbImageView tbImageView = (TbImageView) this.f14484f.findViewById(R.id.video_cover_img);
            this.f14487i = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f14487i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f14488j = (TextView) this.f14484f.findViewById(R.id.video_title);
            this.f14484f.setOnClickListener(new b(this));
            i(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public boolean f(c.a.r0.a0.f.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) ? (aVar == null || 2 != aVar.f14432d || TextUtils.isEmpty(aVar.a)) ? false : true : invokeL.booleanValue;
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.h();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f14484f.getLayoutParams();
            layoutParams.width = this.a;
            layoutParams.height = this.f14467b;
            this.f14484f.setLayoutParams(layoutParams);
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            SkinManager.setViewTextColor(this.f14488j, (int) R.color.CAM_X0111);
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void j() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (tbVideoViewContainer = this.f14485g) == null) {
            return;
        }
        tbVideoViewContainer.getControl().stopPlayback();
        this.f14485g.clearCallbackAndRemoveFromWindow();
        this.f14485g = null;
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.f14485g;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl().isPlaying()) {
                this.f14486h.setVisibility(0);
                this.f14485g.getControl().pause();
            }
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.f14485g;
            if (tbVideoViewContainer == null || !tbVideoViewContainer.getControl().isPlaying()) {
                this.f14486h.setVisibility(8);
                this.f14485g.getControl().start();
            }
        }
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void m() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tbVideoViewContainer = this.f14485g) == null || tbVideoViewContainer.getControl().isPlaying()) {
            return;
        }
        this.f14487i.setVisibility(0);
        if (TextUtils.isEmpty(this.l) || !t0.b(1, this.l)) {
            return;
        }
        this.f14485g.getControl().setVideoPath(this.l);
        this.f14485g.getControl().setLooping(true);
    }

    @Override // c.a.r0.a0.f.g.f.a
    public void n() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tbVideoViewContainer = this.f14485g) == null) {
            return;
        }
        tbVideoViewContainer.getControl().stopPlayback();
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            c.a.r0.a0.f.e.a.c().f("c12910", this.f14469d.f14433e, 2, this.m, this.n, this.o, null);
            this.f14487i.setVisibility(8);
            this.f14486h.setVisibility(8);
            TbVideoViewContainer tbVideoViewContainer = this.f14485g;
            if (tbVideoViewContainer != null) {
                tbVideoViewContainer.getControl().setVolume(0.0f, 0.0f);
                try {
                    this.f14485g.getControl().start();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}

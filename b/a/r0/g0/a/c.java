package b.a.r0.g0.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.r0.g0.a.a;
import b.a.r0.z.c.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.R;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.mediaedit.MultiMediaEditLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener;
import com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol;
import com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaTimelineUpdateListener;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.google.gson.Gson;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements b.a.r0.g0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f18154a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f18155b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f18156c;

    /* renamed from: d  reason: collision with root package name */
    public TbGLMediaPreviewView f18157d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f18158e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f18159f;

    /* renamed from: g  reason: collision with root package name */
    public MultiMediaEditLayout f18160g;

    /* renamed from: h  reason: collision with root package name */
    public int f18161h;

    /* renamed from: i  reason: collision with root package name */
    public float f18162i;
    public long j;
    public long k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public List<MultiMediaData> p;
    public List<b.a.r0.d4.l.c.c.a> q;
    public b.a.r0.z.c.b r;
    public b.a.r0.z.b.b s;
    public boolean t;
    public b.a.r0.z.c.a u;
    public b.a v;
    public b.a.r0.z.b.a w;

    /* loaded from: classes4.dex */
    public class a implements b.a.r0.z.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18163a;

        /* renamed from: b.a.r0.g0.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0923a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f18164e;

            public RunnableC0923a(a aVar) {
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
                        return;
                    }
                }
                this.f18164e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f18164e.f18163a.S();
                }
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18163a = cVar;
        }

        @Override // b.a.r0.z.c.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                for (int i2 = 0; i2 < this.f18163a.p.size(); i2++) {
                    MultiMediaData multiMediaData = (MultiMediaData) this.f18163a.p.get(i2);
                    if (multiMediaData != null && multiMediaData.mSpeed != f2) {
                        multiMediaData.mSpeed = f2;
                        this.f18163a.o = true;
                    }
                }
                b.a.e.f.m.e.a().postDelayed(new RunnableC0923a(this), 100L);
                this.f18163a.f18160g.setLocalAlbumInfoData(this.f18163a.f18155b, this.f18163a.p, false);
                if (this.f18163a.r != null) {
                    this.f18163a.f18160g.updateSpeedButtonStyle(this.f18163a.r.d(), this.f18163a.r.b() == 0);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) ? str.endsWith(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) : invokeLL.booleanValue;
        }
    }

    /* renamed from: b.a.r0.g0.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0924c extends IVLogPlayControlProtocol.OnPlayStateListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0921a f18165a;

        public C0924c(c cVar, a.InterfaceC0921a interfaceC0921a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, interfaceC0921a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18165a = interfaceC0921a;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onPause();
                this.f18165a.a();
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onStart();
                this.f18165a.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18166a;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18166a = cVar;
        }

        @Override // b.a.r0.z.c.b.a
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 == 3) {
                    if (ListUtils.getCount(this.f18166a.p) < 1 || ((float) (this.f18166a.k - this.f18166a.j)) * ((MultiMediaData) this.f18166a.p.get(0)).getCurrentSpeed() < 6000.0f) {
                        BdToast.f(this.f18166a.f18154a.getPageActivity(), String.format(this.f18166a.f18154a.getString(R.string.file_edit_less_sec), 6), BdToast.DefaultIcon.FAILURE).q();
                        return false;
                    }
                } else if (i2 == 4 && (ListUtils.getCount(this.f18166a.p) < 1 || ((float) (this.f18166a.k - this.f18166a.j)) * ((MultiMediaData) this.f18166a.p.get(0)).getCurrentSpeed() < 9000.0f)) {
                    BdToast.f(this.f18166a.f18154a.getPageActivity(), String.format(this.f18166a.f18154a.getString(R.string.file_edit_less_sec), 9), BdToast.DefaultIcon.FAILURE).q();
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements b.a.r0.z.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18167a;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18167a = cVar;
        }

        @Override // b.a.r0.z.b.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f18167a.f18162i == f2) {
                    return true;
                }
                this.f18167a.f18162i = f2;
                this.f18167a.M();
                this.f18167a.o = true;
                if (this.f18167a.s != null) {
                    this.f18167a.f18160g.updateRatioButtonStyle(this.f18167a.s.b() == 0);
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f18168e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18168e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18168e.f18157d == null) {
                return;
            }
            this.f18168e.f18155b.setVideoRatio(this.f18168e.f18162i);
            if (this.f18168e.f18155b == null || this.f18168e.f18155b.isPlaying()) {
                return;
            }
            this.f18168e.f18157d.requestRender();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements b.a.r0.d4.l.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18169a;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f18170e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f18171f;

            public a(g gVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18171f = gVar;
                this.f18170e = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f18171f.f18169a.f18155b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f18171f.f18169a.f18155b.setAngle(this.f18170e, floatValue);
                ((MultiMediaData) this.f18171f.f18169a.p.get(this.f18170e)).angle = floatValue;
                if (this.f18171f.f18169a.f18157d == null || this.f18171f.f18169a.f18155b.isPlaying()) {
                    return;
                }
                this.f18171f.f18169a.f18157d.requestRender();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f18172e;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18172e = gVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f18172e.f18169a.f18155b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (int i2 = 0; i2 < this.f18172e.f18169a.p.size(); i2++) {
                    this.f18172e.f18169a.f18155b.setAngle(i2, floatValue);
                    ((MultiMediaData) this.f18172e.f18169a.p.get(i2)).angle = floatValue;
                    if (this.f18172e.f18169a.f18157d != null && !this.f18172e.f18169a.f18155b.isPlaying()) {
                        this.f18172e.f18169a.f18157d.requestRender();
                    }
                }
            }
        }

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18169a = cVar;
        }

        @Override // b.a.r0.d4.l.c.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void c(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void e(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2)}) == null) || this.f18169a.f18155b == null) {
                return;
            }
            this.f18169a.f18155b.seek((long) d2);
        }

        @Override // b.a.r0.d4.l.c.a
        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void g(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || this.f18169a.f18155b == null || ListUtils.isEmpty(this.f18169a.p)) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i2, i3);
            ofFloat.addUpdateListener(new b(this));
            ofFloat.setDuration(300L);
            ofFloat.start();
            this.f18169a.M();
            this.f18169a.o = true;
        }

        @Override // b.a.r0.d4.l.c.a
        public void h(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void i(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) || this.f18169a.f18155b == null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i3, i4);
            ofFloat.addUpdateListener(new a(this, i2));
            ofFloat.setDuration(300L);
            ofFloat.start();
        }

        @Override // b.a.r0.d4.l.c.a
        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.f18169a.o = true;
                if ((this.f18169a.k - this.f18169a.j) - 100 >= 3000 || b.a.q0.s.e0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f18169a.T(R.string.file_video_clip_less_3_tips);
                b.a.q0.s.e0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void l(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void m(int i2, b.a.r0.d4.l.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048588, this, i2, aVar) == null) {
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void n(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void o() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f18169a.s == null) {
                return;
            }
            int b2 = this.f18169a.s.b();
            this.f18169a.N();
            if (b2 != 0) {
                this.f18169a.s.c(0);
            }
            if (this.f18169a.f18160g != null) {
                this.f18169a.f18160g.updateRatioButtonStyle(this.f18169a.s.b() == 0);
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void p(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Double.valueOf(d2)}) == null) || this.f18169a.f18155b == null) {
                return;
            }
            this.f18169a.f18155b.seek((long) d2);
        }

        @Override // b.a.r0.d4.l.c.a
        public void q() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.f18169a.r == null) {
                return;
            }
            int b2 = this.f18169a.r.b();
            this.f18169a.N();
            if (b2 != 0) {
                this.f18169a.r.c(0);
            }
            if (this.f18169a.f18160g != null) {
                this.f18169a.f18160g.updateSpeedButtonStyle(this.f18169a.r.d(), this.f18169a.r.b() == 0);
            }
        }

        @Override // b.a.r0.d4.l.c.a
        public void r(long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f18169a.f18155b == null) {
                return;
            }
            this.f18169a.f18155b.seek(j);
        }

        @Override // b.a.r0.d4.l.c.a
        public void s(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if (this.f18169a.f18155b != null) {
                    this.f18169a.f18155b.seek(j);
                }
                this.f18169a.j = j;
                this.f18169a.k = j2;
                if (!this.f18169a.o || (this.f18169a.k - this.f18169a.j) - 100 >= 3000 || b.a.q0.s.e0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f18169a.T(R.string.file_video_clip_less_3_tips);
                b.a.q0.s.e0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18173a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f18174e;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18174e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f18174e.f18173a.q)) {
                    return;
                }
                this.f18174e.f18173a.f18160g.updateCurrentPlayIndex(-1, this.f18174e.f18173a.f18155b.getCurrentIndex());
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f18175e;

            /* loaded from: classes4.dex */
            public class a extends AnimatorListenerAdapter {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f18176e;

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
                    this.f18176e = bVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                        this.f18176e.f18175e.f18173a.f18160g.setVisibility(0);
                    }
                }
            }

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18175e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18175e.f18173a.f18160g, "translationY", this.f18175e.f18173a.f18160g.getHeight(), 0.0f);
                    ofFloat.setDuration(250L);
                    ofFloat.addListener(new a(this));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f18175e.f18173a.f18157d.getLayoutParams();
                    layoutParams.removeRule(3);
                    layoutParams.removeRule(2);
                    this.f18175e.f18173a.l = (l.i(this.f18175e.f18173a.f18154a.getPageActivity()) - this.f18175e.f18173a.f18159f.getHeight()) - this.f18175e.f18173a.f18158e.getHeight();
                    c cVar = this.f18175e.f18173a;
                    cVar.m = l.k(cVar.f18154a.getPageActivity());
                    if (this.f18175e.f18173a.f18162i > 1.0f) {
                        layoutParams.width = Math.min((int) (this.f18175e.f18173a.l / this.f18175e.f18173a.f18162i), this.f18175e.f18173a.m);
                    } else if (this.f18175e.f18173a.f18162i > 0.0f) {
                        layoutParams.width = this.f18175e.f18173a.m;
                    }
                    layoutParams.height = (int) (layoutParams.width * this.f18175e.f18173a.f18162i);
                    this.f18175e.f18173a.f18157d.requestLayout();
                    b.a.r0.z3.g.h(this.f18175e.f18173a.f18154a.getPageActivity().getIntent(), this.f18175e.f18173a.f18157d);
                    ofFloat.start();
                }
            }
        }

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18173a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f18173a.f18155b == null) {
                return;
            }
            this.f18173a.f18155b.pause();
            this.f18173a.f18160g.post(new a(this));
            if (this.f18173a.f18161h != 2 || this.f18173a.n) {
                return;
            }
            this.f18173a.n = true;
            this.f18173a.f18157d.post(new b(this));
        }
    }

    /* loaded from: classes4.dex */
    public class i implements MultiMediaTimelineUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18177a;

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18177a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaTimelineUpdateListener
        public void onTimelineUpdate(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if (this.f18177a.f18160g.isInSingleMedia()) {
                    j -= this.f18177a.f18160g.getSingleMediaStartDuration();
                    if (this.f18177a.f18160g.getSingleClipTo() - j <= 150) {
                        this.f18177a.f18155b.seek(this.f18177a.f18160g.getSingleClipFrom() + this.f18177a.f18160g.getSingleMediaStartDuration());
                    }
                } else if (this.f18177a.f18160g.getAllClipTo() - j <= 100) {
                    this.f18177a.f18155b.seek(this.f18177a.f18160g.getAllClipFrom());
                }
                this.f18177a.f18160g.updateTimeline(j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements MultiMediaStateEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18178a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f18179e;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f18179e = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f18179e.f18178a.q)) {
                    return;
                }
                this.f18179e.f18178a.f18160g.updateCurrentPlayIndex(-1, this.f18179e.f18178a.f18155b.getCurrentIndex());
            }
        }

        public j(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18178a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onIndexChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onLoop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f18178a.f18160g.post(new a(this));
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onPlayEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onRepeatIndexEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onRepeatIndexLoop(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements b.a.x0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18180a;

        public k(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18180a = cVar;
        }

        @Override // b.a.x0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b.a.r0.d4.l.b(this.f18180a.f18154a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // b.a.x0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18180a.t ? b.a.r0.a4.c.f15918c : b.a.r0.a4.c.f15919d : (String) invokeV.objValue;
        }

        @Override // b.a.x0.c
        public b.a.x0.j.a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (b.a.x0.j.a) invokeV.objValue;
        }

        @Override // b.a.x0.c
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }
    }

    public c(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, MultiMediaEditLayout multiMediaEditLayout, TbMultiMediaData tbMultiMediaData, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tbGLMediaPreviewView, multiMediaEditLayout, tbMultiMediaData, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.t = false;
        this.u = new a(this);
        this.v = new d(this);
        this.w = new e(this);
        this.f18154a = tbPageContext;
        this.r = new b.a.r0.z.c.c(tbPageContext, this.u, this.v);
        this.f18157d = tbGLMediaPreviewView;
        this.f18160g = multiMediaEditLayout;
        this.f18161h = i2;
        this.t = z;
        ArrayList arrayList = new ArrayList();
        this.p = arrayList;
        arrayList.add(tbMultiMediaData);
        if (!ListUtils.isEmpty(this.p) && this.p.get(0).height > 0 && this.p.get(0).width > 0) {
            this.f18162i = (this.p.get(0).height * 1.0f) / this.p.get(0).width;
            b.a.r0.z.b.c cVar = new b.a.r0.z.b.c(this.f18154a, this.p.get(0).height, this.p.get(0).width, this.w);
            this.s = cVar;
            cVar.d(0);
        }
        if (tbMultiMediaData != null) {
            this.j = tbMultiMediaData.start;
            tbMultiMediaData.start = 0L;
            this.k = tbMultiMediaData.end;
            tbMultiMediaData.end = tbMultiMediaData.originalDuration;
        }
        O();
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f18159f.post(new f(this));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.r0.z.c.b bVar = this.r;
            if (bVar != null) {
                bVar.c(8);
                MultiMediaEditLayout multiMediaEditLayout = this.f18160g;
                if (multiMediaEditLayout != null) {
                    multiMediaEditLayout.updateSpeedButtonStyle(this.r.d(), false);
                }
            }
            b.a.r0.z.b.b bVar2 = this.s;
            if (bVar2 != null) {
                bVar2.c(8);
                MultiMediaEditLayout multiMediaEditLayout2 = this.f18160g;
                if (multiMediaEditLayout2 != null) {
                    multiMediaEditLayout2.updateRatioButtonStyle(false);
                }
            }
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!b.a.r0.z3.a.a()) {
                this.f18154a.getPageActivity().finish();
                return false;
            }
            P();
            R();
            Q();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.x0.b.c().h(TbadkCoreApplication.getInst());
            b.a.x0.b.c().j(FileHelper.getCacheDir());
            b.a.x0.b.c().k(new k(this));
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f18157d.setZOrderMediaOverlay(true);
            this.f18157d.setMultiMediaDataSourceViewAdapter(this.f18156c, true);
            this.f18158e = (NavigationBar) this.f18154a.getPageActivity().findViewById(R.id.navigation_bar);
            this.f18159f = (FrameLayout) this.f18154a.getPageActivity().findViewById(R.id.tool_root_layout);
            this.f18160g.setPageContext(this.f18154a);
            this.f18160g.setOnlyOneVideo();
            this.f18160g.setLocalAlbumInfoData(this.f18155b, this.p);
            this.f18160g.setMultiVideoClipLayoutRange((int) this.j, (int) this.k);
            this.f18160g.setIMultiMediaEditView(new g(this));
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f18156c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.f18155b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.p);
            this.f18155b.setLooping(true);
            this.f18155b.setPreparedListener(new h(this));
            this.f18155b.setMultiMediaTimelineUpdateListener(new i(this), true);
            this.f18155b.setMultiMediaStateEventListener(new j(this));
        }
    }

    public final void S() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (vlogEditManager = this.f18155b) == null || this.f18160g == null) {
            return;
        }
        boolean isPlaying = vlogEditManager.isPlaying();
        this.f18155b.reset();
        this.f18155b.setMultiMediaData(this.p);
        if (this.f18160g.isInSingleMedia()) {
            int i2 = 0;
            MediaTrack mediaTrack = (MediaTrack) ListUtils.getItem(this.f18155b.getUpdateMediaTracks(), 0);
            int currentMediaPosition = this.f18160g.getCurrentMediaPosition();
            if (mediaTrack != null) {
                List<MediaSegment> list = mediaTrack.mediaSegments;
                if (!ListUtils.isEmpty(list)) {
                    int i3 = 0;
                    while (i2 < currentMediaPosition) {
                        i3 = (int) (i3 + (list.get(i2).end - list.get(i2).start));
                        i2++;
                    }
                    i2 = i3;
                }
            }
            int i4 = i2 + 100;
            this.f18160g.setSingleMediaStartDuration(i4);
            this.f18155b.seek(i4 + this.f18160g.getSingleClipFrom());
        } else {
            this.f18155b.seek(this.f18160g.getAllClipFrom());
        }
        if (isPlaying) {
            this.f18155b.start();
        } else {
            this.f18155b.pause();
        }
    }

    public final void T(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || i2 <= 0) {
            return;
        }
        b.a.r0.f0.g gVar = new b.a.r0.f0.g(this.f18154a, this.f18160g);
        gVar.g0(R.drawable.bg_tip_blue_up_right);
        gVar.L(4);
        gVar.h0(true);
        gVar.j0(-UtilHelper.getDimenPixelSize(R.dimen.tbds78));
        gVar.k0(UtilHelper.getDimenPixelSize(R.dimen.tbds19));
        gVar.X(R.color.CAM_X0101);
        gVar.e0(R.dimen.T_X08);
        gVar.P(R.dimen.T_X08);
        gVar.a0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
        gVar.d0(UtilHelper.getDimenPixelSize(R.dimen.tbds44));
        gVar.l0(this.f18154a.getPageActivity().getResources().getString(i2));
    }

    @Override // b.a.r0.g0.a.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmFilterItem)) == null) {
            String str = IVlogEditManager.FILTER_ORIGINAL;
            if (qmFilterItem == null || StringUtils.isNull(qmFilterItem.localPath) || FilterValue.DEFAULT_FILTER_VALUE.equals(qmFilterItem.localPath)) {
                f2 = 0.0f;
            } else {
                f2 = b.a.e.f.m.b.d(qmFilterItem.effect, 100.0f) / 100.0f;
                File file = new File(qmFilterItem.localPath);
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles(new b(this));
                    if (listFiles.length > 0) {
                        str = listFiles[0].getAbsolutePath();
                    }
                }
            }
            VlogEditManager vlogEditManager = this.f18155b;
            if (vlogEditManager != null) {
                try {
                    vlogEditManager.setFilter(f2, str);
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r0.g0.a.a
    public void b(a.InterfaceC0921a interfaceC0921a) {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, interfaceC0921a) == null) || (vlogEditManager = this.f18155b) == null) {
            return;
        }
        vlogEditManager.setOnPlayStateListener(null);
        this.f18155b.setOnPlayStateListener(new C0924c(this, interfaceC0921a));
    }

    @Override // b.a.r0.g0.a.a
    public void c(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, tbMultiMediaData) == null) || tbMultiMediaData == null) {
            return;
        }
        this.p.clear();
        this.p.add(tbMultiMediaData);
        S();
        MultiMediaEditLayout multiMediaEditLayout = this.f18160g;
        if (multiMediaEditLayout != null) {
            multiMediaEditLayout.resetRangeSlider();
        }
        b.a.r0.z.b.b bVar = this.s;
        if (bVar != null) {
            bVar.reset();
        }
        b.a.r0.z.c.b bVar2 = this.r;
        if (bVar2 != null) {
            bVar2.reset();
        }
    }

    @Override // b.a.r0.g0.a.a
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : invokeV.longValue;
    }

    @Override // b.a.r0.g0.a.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b.a.x0.b.c().k(null);
        }
    }

    @Override // b.a.r0.g0.a.a
    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048589, this, f2) == null) || this.f18162i == f2) {
            return;
        }
        this.f18162i = f2;
        M();
        VlogEditManager vlogEditManager = this.f18155b;
        if (vlogEditManager == null || vlogEditManager.isPlaying()) {
            return;
        }
        VlogEditManager vlogEditManager2 = this.f18155b;
        vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
    }

    @Override // b.a.r0.g0.a.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o : invokeV.booleanValue;
    }

    @Override // b.a.r0.g0.a.a
    public long getCurrentPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            VlogEditManager vlogEditManager = this.f18155b;
            if (vlogEditManager != null) {
                return vlogEditManager.getCurrentPlayTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // b.a.r0.g0.a.a
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.j : invokeV.longValue;
    }

    @Override // b.a.r0.g0.a.a
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f18155b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.f18155b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // b.a.r0.g0.a.a
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f18162i : invokeV.floatValue;
    }

    @Override // b.a.r0.g0.a.a
    public void h(boolean z) {
        MultiMediaEditLayout multiMediaEditLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (multiMediaEditLayout = this.f18160g) == null) {
            return;
        }
        multiMediaEditLayout.setOnlyClip(z);
    }

    @Override // b.a.r0.g0.a.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            VlogEditManager vlogEditManager = this.f18155b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.r0.g0.a.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            VlogEditManager vlogEditManager = this.f18155b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f18157d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            MultiMediaEditLayout multiMediaEditLayout = this.f18160g;
            if (multiMediaEditLayout != null) {
                multiMediaEditLayout.release();
            }
        }
    }

    @Override // b.a.r0.g0.a.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            VlogEditManager vlogEditManager = this.f18155b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f18157d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // b.a.r0.g0.a.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f18157d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.f18155b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    @Override // b.a.r0.g0.a.a
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (vlogEditManager = this.f18155b) == null) {
            return;
        }
        vlogEditManager.pause();
    }

    @Override // b.a.r0.g0.a.a
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (vlogEditManager = this.f18155b) == null) {
            return;
        }
        vlogEditManager.start();
        this.o = true;
    }
}

package c.a.q0.f0.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.f0.a.a;
import c.a.q0.y.c.b;
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
/* loaded from: classes3.dex */
public class c implements c.a.q0.f0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17168a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f17169b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f17170c;

    /* renamed from: d  reason: collision with root package name */
    public TbGLMediaPreviewView f17171d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f17172e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f17173f;

    /* renamed from: g  reason: collision with root package name */
    public MultiMediaEditLayout f17174g;

    /* renamed from: h  reason: collision with root package name */
    public int f17175h;

    /* renamed from: i  reason: collision with root package name */
    public float f17176i;

    /* renamed from: j  reason: collision with root package name */
    public long f17177j;
    public long k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public List<MultiMediaData> p;
    public List<c.a.q0.a4.l.c.c.a> q;
    public c.a.q0.y.c.b r;
    public c.a.q0.y.b.b s;
    public boolean t;
    public c.a.q0.y.c.a u;
    public b.a v;
    public c.a.q0.y.b.a w;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.y.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17178a;

        /* renamed from: c.a.q0.f0.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0830a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f17179e;

            public RunnableC0830a(a aVar) {
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
                this.f17179e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17179e.f17178a.R();
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
            this.f17178a = cVar;
        }

        @Override // c.a.q0.y.c.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                for (int i2 = 0; i2 < this.f17178a.p.size(); i2++) {
                    MultiMediaData multiMediaData = (MultiMediaData) this.f17178a.p.get(i2);
                    if (multiMediaData != null && multiMediaData.mSpeed != f2) {
                        multiMediaData.mSpeed = f2;
                        this.f17178a.o = true;
                    }
                }
                c.a.e.e.m.e.a().postDelayed(new RunnableC0830a(this), 100L);
                this.f17178a.f17174g.setLocalAlbumInfoData(this.f17178a.f17169b, this.f17178a.p, false);
                if (this.f17178a.r != null) {
                    this.f17178a.f17174g.updateSpeedButtonStyle(this.f17178a.r.d(), this.f17178a.r.b() == 0);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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

    /* renamed from: c.a.q0.f0.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0831c extends IVLogPlayControlProtocol.OnPlayStateListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0828a f17180a;

        public C0831c(c cVar, a.InterfaceC0828a interfaceC0828a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, interfaceC0828a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17180a = interfaceC0828a;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onPause();
                this.f17180a.a();
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onStart();
                this.f17180a.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17181a;

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
            this.f17181a = cVar;
        }

        @Override // c.a.q0.y.c.b.a
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 == 3) {
                    if (ListUtils.getCount(this.f17181a.p) < 1 || ((float) (this.f17181a.k - this.f17181a.f17177j)) * ((MultiMediaData) this.f17181a.p.get(0)).getCurrentSpeed() < 6000.0f) {
                        BdToast.f(this.f17181a.f17168a.getPageActivity(), String.format(this.f17181a.f17168a.getString(R.string.file_edit_less_sec), 6), BdToast.DefaultIcon.FAILURE).q();
                        return false;
                    }
                } else if (i2 == 4 && (ListUtils.getCount(this.f17181a.p) < 1 || ((float) (this.f17181a.k - this.f17181a.f17177j)) * ((MultiMediaData) this.f17181a.p.get(0)).getCurrentSpeed() < 9000.0f)) {
                    BdToast.f(this.f17181a.f17168a.getPageActivity(), String.format(this.f17181a.f17168a.getString(R.string.file_edit_less_sec), 9), BdToast.DefaultIcon.FAILURE).q();
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements c.a.q0.y.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17182a;

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
            this.f17182a = cVar;
        }

        @Override // c.a.q0.y.b.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f17182a.f17176i == f2) {
                    return true;
                }
                this.f17182a.f17176i = f2;
                this.f17182a.L();
                this.f17182a.o = true;
                if (this.f17182a.s != null) {
                    this.f17182a.f17174g.updateRatioButtonStyle(this.f17182a.s.b() == 0);
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f17183e;

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
            this.f17183e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17183e.f17171d == null) {
                return;
            }
            this.f17183e.f17169b.setVideoRatio(this.f17183e.f17176i);
            if (this.f17183e.f17169b == null || this.f17183e.f17169b.isPlaying()) {
                return;
            }
            this.f17183e.f17171d.requestRender();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements c.a.q0.a4.l.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17184a;

        /* loaded from: classes3.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f17185e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f17186f;

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
                this.f17186f = gVar;
                this.f17185e = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f17186f.f17184a.f17169b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f17186f.f17184a.f17169b.setAngle(this.f17185e, floatValue);
                ((MultiMediaData) this.f17186f.f17184a.p.get(this.f17185e)).angle = floatValue;
                if (this.f17186f.f17184a.f17171d == null || this.f17186f.f17184a.f17169b.isPlaying()) {
                    return;
                }
                this.f17186f.f17184a.f17171d.requestRender();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f17187e;

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
                this.f17187e = gVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f17187e.f17184a.f17169b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (int i2 = 0; i2 < this.f17187e.f17184a.p.size(); i2++) {
                    this.f17187e.f17184a.f17169b.setAngle(i2, floatValue);
                    ((MultiMediaData) this.f17187e.f17184a.p.get(i2)).angle = floatValue;
                    if (this.f17187e.f17184a.f17171d != null && !this.f17187e.f17184a.f17169b.isPlaying()) {
                        this.f17187e.f17184a.f17171d.requestRender();
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
            this.f17184a = cVar;
        }

        @Override // c.a.q0.a4.l.c.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void c(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void e(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2)}) == null) || this.f17184a.f17169b == null) {
                return;
            }
            this.f17184a.f17169b.seek((long) d2);
        }

        @Override // c.a.q0.a4.l.c.a
        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void g(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || this.f17184a.f17169b == null || ListUtils.isEmpty(this.f17184a.p)) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i2, i3);
            ofFloat.addUpdateListener(new b(this));
            ofFloat.setDuration(300L);
            ofFloat.start();
            this.f17184a.L();
            this.f17184a.o = true;
        }

        @Override // c.a.q0.a4.l.c.a
        public void h(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void i(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) || this.f17184a.f17169b == null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i3, i4);
            ofFloat.addUpdateListener(new a(this, i2));
            ofFloat.setDuration(300L);
            ofFloat.start();
        }

        @Override // c.a.q0.a4.l.c.a
        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.f17184a.o = true;
                if ((this.f17184a.k - this.f17184a.f17177j) - 100 >= 3000 || c.a.p0.s.d0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f17184a.S(R.string.file_video_clip_less_3_tips);
                c.a.p0.s.d0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void l(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void m(int i2, c.a.q0.a4.l.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048588, this, i2, aVar) == null) {
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void n(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void o() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f17184a.s == null) {
                return;
            }
            int b2 = this.f17184a.s.b();
            this.f17184a.M();
            if (b2 != 0) {
                this.f17184a.s.c(0);
            }
            if (this.f17184a.f17174g != null) {
                this.f17184a.f17174g.updateRatioButtonStyle(this.f17184a.s.b() == 0);
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void p(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Double.valueOf(d2)}) == null) || this.f17184a.f17169b == null) {
                return;
            }
            this.f17184a.f17169b.seek((long) d2);
        }

        @Override // c.a.q0.a4.l.c.a
        public void q() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.f17184a.r == null) {
                return;
            }
            int b2 = this.f17184a.r.b();
            this.f17184a.M();
            if (b2 != 0) {
                this.f17184a.r.c(0);
            }
            if (this.f17184a.f17174g != null) {
                this.f17184a.f17174g.updateSpeedButtonStyle(this.f17184a.r.d(), this.f17184a.r.b() == 0);
            }
        }

        @Override // c.a.q0.a4.l.c.a
        public void r(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f17184a.f17169b == null) {
                return;
            }
            this.f17184a.f17169b.seek(j2);
        }

        @Override // c.a.q0.a4.l.c.a
        public void s(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                if (this.f17184a.f17169b != null) {
                    this.f17184a.f17169b.seek(j2);
                }
                this.f17184a.f17177j = j2;
                this.f17184a.k = j3;
                if (!this.f17184a.o || (this.f17184a.k - this.f17184a.f17177j) - 100 >= 3000 || c.a.p0.s.d0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f17184a.S(R.string.file_video_clip_less_3_tips);
                c.a.p0.s.d0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17188a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f17189e;

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
                this.f17189e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f17189e.f17188a.q)) {
                    return;
                }
                this.f17189e.f17188a.f17174g.updateCurrentPlayIndex(-1, this.f17189e.f17188a.f17169b.getCurrentIndex());
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f17190e;

            /* loaded from: classes3.dex */
            public class a extends AnimatorListenerAdapter {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f17191e;

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
                    this.f17191e = bVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                        this.f17191e.f17190e.f17188a.f17174g.setVisibility(0);
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
                this.f17190e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f17190e.f17188a.f17174g, "translationY", this.f17190e.f17188a.f17174g.getHeight(), 0.0f);
                    ofFloat.setDuration(250L);
                    ofFloat.addListener(new a(this));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17190e.f17188a.f17171d.getLayoutParams();
                    layoutParams.removeRule(3);
                    layoutParams.removeRule(2);
                    this.f17190e.f17188a.l = (l.i(this.f17190e.f17188a.f17168a.getPageActivity()) - this.f17190e.f17188a.f17173f.getHeight()) - this.f17190e.f17188a.f17172e.getHeight();
                    c cVar = this.f17190e.f17188a;
                    cVar.m = l.k(cVar.f17168a.getPageActivity());
                    if (this.f17190e.f17188a.f17176i > 1.0f) {
                        layoutParams.width = Math.min((int) (this.f17190e.f17188a.l / this.f17190e.f17188a.f17176i), this.f17190e.f17188a.m);
                    } else if (this.f17190e.f17188a.f17176i > 0.0f) {
                        layoutParams.width = this.f17190e.f17188a.m;
                    }
                    layoutParams.height = (int) (layoutParams.width * this.f17190e.f17188a.f17176i);
                    this.f17190e.f17188a.f17171d.requestLayout();
                    c.a.q0.v3.g.h(this.f17190e.f17188a.f17168a.getPageActivity().getIntent(), this.f17190e.f17188a.f17171d);
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
            this.f17188a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17188a.f17169b == null) {
                return;
            }
            this.f17188a.f17169b.pause();
            this.f17188a.f17174g.post(new a(this));
            if (this.f17188a.f17175h != 2 || this.f17188a.n) {
                return;
            }
            this.f17188a.n = true;
            this.f17188a.f17171d.post(new b(this));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements MultiMediaTimelineUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17192a;

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
            this.f17192a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaTimelineUpdateListener
        public void onTimelineUpdate(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                if (this.f17192a.f17174g.isInSingleMedia()) {
                    j2 -= this.f17192a.f17174g.getSingleMediaStartDuration();
                    if (this.f17192a.f17174g.getSingleClipTo() - j2 <= 150) {
                        this.f17192a.f17169b.seek(this.f17192a.f17174g.getSingleClipFrom() + this.f17192a.f17174g.getSingleMediaStartDuration());
                    }
                } else if (this.f17192a.f17174g.getAllClipTo() - j2 <= 100) {
                    this.f17192a.f17169b.seek(this.f17192a.f17174g.getAllClipFrom());
                }
                this.f17192a.f17174g.updateTimeline(j2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements MultiMediaStateEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17193a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f17194e;

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
                this.f17194e = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f17194e.f17193a.q)) {
                    return;
                }
                this.f17194e.f17193a.f17174g.updateCurrentPlayIndex(-1, this.f17194e.f17193a.f17169b.getCurrentIndex());
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
            this.f17193a = cVar;
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
                this.f17193a.f17174g.post(new a(this));
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

    /* loaded from: classes3.dex */
    public class k implements c.a.w0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17195a;

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
            this.f17195a = cVar;
        }

        @Override // c.a.w0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c.a.q0.a4.l.b(this.f17195a.f17168a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // c.a.w0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17195a.t ? c.a.q0.w3.c.f28195c : c.a.q0.w3.c.f28196d : (String) invokeV.objValue;
        }

        @Override // c.a.w0.c
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        @Override // c.a.w0.c
        public c.a.w0.j.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (c.a.w0.j.a) invokeV.objValue;
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
        this.f17168a = tbPageContext;
        this.r = new c.a.q0.y.c.c(tbPageContext, this.u, this.v);
        this.f17171d = tbGLMediaPreviewView;
        this.f17174g = multiMediaEditLayout;
        this.f17175h = i2;
        this.t = z;
        ArrayList arrayList = new ArrayList();
        this.p = arrayList;
        arrayList.add(tbMultiMediaData);
        if (!ListUtils.isEmpty(this.p) && this.p.get(0).height > 0 && this.p.get(0).width > 0) {
            this.f17176i = (this.p.get(0).height * 1.0f) / this.p.get(0).width;
            c.a.q0.y.b.c cVar = new c.a.q0.y.b.c(this.f17168a, this.p.get(0).height, this.p.get(0).width, this.w);
            this.s = cVar;
            cVar.d(0);
        }
        if (tbMultiMediaData != null) {
            this.f17177j = tbMultiMediaData.start;
            tbMultiMediaData.start = 0L;
            this.k = tbMultiMediaData.end;
            tbMultiMediaData.end = tbMultiMediaData.originalDuration;
        }
        N();
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17173f.post(new f(this));
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.q0.y.c.b bVar = this.r;
            if (bVar != null) {
                bVar.c(8);
                MultiMediaEditLayout multiMediaEditLayout = this.f17174g;
                if (multiMediaEditLayout != null) {
                    multiMediaEditLayout.updateSpeedButtonStyle(this.r.d(), false);
                }
            }
            c.a.q0.y.b.b bVar2 = this.s;
            if (bVar2 != null) {
                bVar2.c(8);
                MultiMediaEditLayout multiMediaEditLayout2 = this.f17174g;
                if (multiMediaEditLayout2 != null) {
                    multiMediaEditLayout2.updateRatioButtonStyle(false);
                }
            }
        }
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!c.a.q0.v3.a.a()) {
                this.f17168a.getPageActivity().finish();
                return false;
            }
            O();
            Q();
            P();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.w0.b.d().i(TbadkCoreApplication.getInst());
            c.a.w0.b.d().k(FileHelper.getCacheDir());
            c.a.w0.b.d().l(new k(this));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f17171d.setZOrderMediaOverlay(true);
            this.f17171d.setMultiMediaDataSourceViewAdapter(this.f17170c, true);
            this.f17172e = (NavigationBar) this.f17168a.getPageActivity().findViewById(R.id.navigation_bar);
            this.f17173f = (FrameLayout) this.f17168a.getPageActivity().findViewById(R.id.tool_root_layout);
            this.f17174g.setPageContext(this.f17168a);
            this.f17174g.setOnlyOneVideo();
            this.f17174g.setLocalAlbumInfoData(this.f17169b, this.p);
            this.f17174g.setMultiVideoClipLayoutRange((int) this.f17177j, (int) this.k);
            this.f17174g.setIMultiMediaEditView(new g(this));
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f17170c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.f17169b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.p);
            this.f17169b.setLooping(true);
            this.f17169b.setPreparedListener(new h(this));
            this.f17169b.setMultiMediaTimelineUpdateListener(new i(this), true);
            this.f17169b.setMultiMediaStateEventListener(new j(this));
        }
    }

    public final void R() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (vlogEditManager = this.f17169b) == null || this.f17174g == null) {
            return;
        }
        boolean isPlaying = vlogEditManager.isPlaying();
        this.f17169b.reset();
        this.f17169b.setMultiMediaData(this.p);
        if (this.f17174g.isInSingleMedia()) {
            int i2 = 0;
            MediaTrack mediaTrack = (MediaTrack) ListUtils.getItem(this.f17169b.getUpdateMediaTracks(), 0);
            int currentMediaPosition = this.f17174g.getCurrentMediaPosition();
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
            this.f17174g.setSingleMediaStartDuration(i4);
            this.f17169b.seek(i4 + this.f17174g.getSingleClipFrom());
        } else {
            this.f17169b.seek(this.f17174g.getAllClipFrom());
        }
        if (isPlaying) {
            this.f17169b.start();
        } else {
            this.f17169b.pause();
        }
    }

    public final void S(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || i2 <= 0) {
            return;
        }
        c.a.q0.e0.e eVar = new c.a.q0.e0.e(this.f17168a, this.f17174g);
        eVar.g0(R.drawable.bg_tip_blue_up_right);
        eVar.L(4);
        eVar.h0(true);
        eVar.j0(-UtilHelper.getDimenPixelSize(R.dimen.tbds78));
        eVar.k0(UtilHelper.getDimenPixelSize(R.dimen.tbds19));
        eVar.X(R.color.CAM_X0101);
        eVar.e0(R.dimen.T_X08);
        eVar.P(R.dimen.T_X08);
        eVar.a0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
        eVar.d0(UtilHelper.getDimenPixelSize(R.dimen.tbds44));
        eVar.l0(this.f17168a.getPageActivity().getResources().getString(i2));
    }

    @Override // c.a.q0.f0.a.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmFilterItem)) == null) {
            String str = IVlogEditManager.FILTER_ORIGINAL;
            if (qmFilterItem == null || StringUtils.isNull(qmFilterItem.localPath) || FilterValue.DEFAULT_FILTER_VALUE.equals(qmFilterItem.localPath)) {
                f2 = 0.0f;
            } else {
                f2 = c.a.e.e.m.b.c(qmFilterItem.effect, 100.0f) / 100.0f;
                File file = new File(qmFilterItem.localPath);
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles(new b(this));
                    if (listFiles.length > 0) {
                        str = listFiles[0].getAbsolutePath();
                    }
                }
            }
            VlogEditManager vlogEditManager = this.f17169b;
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

    @Override // c.a.q0.f0.a.a
    public void b(a.InterfaceC0828a interfaceC0828a) {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, interfaceC0828a) == null) || (vlogEditManager = this.f17169b) == null) {
            return;
        }
        vlogEditManager.setOnPlayStateListener(null);
        this.f17169b.setOnPlayStateListener(new C0831c(this, interfaceC0828a));
    }

    @Override // c.a.q0.f0.a.a
    public void c(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, tbMultiMediaData) == null) || tbMultiMediaData == null) {
            return;
        }
        this.p.clear();
        this.p.add(tbMultiMediaData);
        R();
        MultiMediaEditLayout multiMediaEditLayout = this.f17174g;
        if (multiMediaEditLayout != null) {
            multiMediaEditLayout.resetRangeSlider();
        }
        c.a.q0.y.b.b bVar = this.s;
        if (bVar != null) {
            bVar.reset();
        }
        c.a.q0.y.c.b bVar2 = this.r;
        if (bVar2 != null) {
            bVar2.reset();
        }
    }

    @Override // c.a.q0.f0.a.a
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : invokeV.longValue;
    }

    @Override // c.a.q0.f0.a.a
    public void e(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048588, this, f2) == null) || this.f17176i == f2) {
            return;
        }
        this.f17176i = f2;
        L();
        VlogEditManager vlogEditManager = this.f17169b;
        if (vlogEditManager == null || vlogEditManager.isPlaying()) {
            return;
        }
        VlogEditManager vlogEditManager2 = this.f17169b;
        vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
    }

    @Override // c.a.q0.f0.a.a
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.o : invokeV.booleanValue;
    }

    @Override // c.a.q0.f0.a.a
    public void g(boolean z) {
        MultiMediaEditLayout multiMediaEditLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (multiMediaEditLayout = this.f17174g) == null) {
            return;
        }
        multiMediaEditLayout.setOnlyClip(z);
    }

    @Override // c.a.q0.f0.a.a
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f17177j : invokeV.longValue;
    }

    @Override // c.a.q0.f0.a.a
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.f17169b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.f17169b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // c.a.q0.f0.a.a
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f17176i : invokeV.floatValue;
    }

    @Override // c.a.q0.f0.a.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            VlogEditManager vlogEditManager = this.f17169b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.f0.a.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            VlogEditManager vlogEditManager = this.f17169b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17171d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            MultiMediaEditLayout multiMediaEditLayout = this.f17174g;
            if (multiMediaEditLayout != null) {
                multiMediaEditLayout.release();
            }
        }
    }

    @Override // c.a.q0.f0.a.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            VlogEditManager vlogEditManager = this.f17169b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17171d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // c.a.q0.f0.a.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17171d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.f17169b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    @Override // c.a.q0.f0.a.a
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (vlogEditManager = this.f17169b) == null) {
            return;
        }
        vlogEditManager.pause();
    }

    @Override // c.a.q0.f0.a.a
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (vlogEditManager = this.f17169b) == null) {
            return;
        }
        vlogEditManager.start();
        this.o = true;
    }
}

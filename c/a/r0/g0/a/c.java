package c.a.r0.g0.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.r0.g0.a.a;
import c.a.r0.z.c.b;
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
public class c implements c.a.r0.g0.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f17675a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f17676b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f17677c;

    /* renamed from: d  reason: collision with root package name */
    public TbGLMediaPreviewView f17678d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f17679e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f17680f;

    /* renamed from: g  reason: collision with root package name */
    public MultiMediaEditLayout f17681g;

    /* renamed from: h  reason: collision with root package name */
    public int f17682h;

    /* renamed from: i  reason: collision with root package name */
    public float f17683i;

    /* renamed from: j  reason: collision with root package name */
    public long f17684j;
    public long k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public List<MultiMediaData> p;
    public List<c.a.r0.c4.l.c.c.a> q;
    public c.a.r0.z.c.b r;
    public c.a.r0.z.b.b s;
    public boolean t;
    public c.a.r0.z.c.a u;
    public b.a v;
    public c.a.r0.z.b.a w;

    /* loaded from: classes3.dex */
    public class a implements c.a.r0.z.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17685a;

        /* renamed from: c.a.r0.g0.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0861a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f17686e;

            public RunnableC0861a(a aVar) {
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
                this.f17686e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17686e.f17685a.R();
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
            this.f17685a = cVar;
        }

        @Override // c.a.r0.z.c.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                for (int i2 = 0; i2 < this.f17685a.p.size(); i2++) {
                    MultiMediaData multiMediaData = (MultiMediaData) this.f17685a.p.get(i2);
                    if (multiMediaData != null && multiMediaData.mSpeed != f2) {
                        multiMediaData.mSpeed = f2;
                        this.f17685a.o = true;
                    }
                }
                c.a.e.e.m.e.a().postDelayed(new RunnableC0861a(this), 100L);
                this.f17685a.f17681g.setLocalAlbumInfoData(this.f17685a.f17676b, this.f17685a.p, false);
                if (this.f17685a.r != null) {
                    this.f17685a.f17681g.updateSpeedButtonStyle(this.f17685a.r.d(), this.f17685a.r.b() == 0);
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

    /* renamed from: c.a.r0.g0.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0862c extends IVLogPlayControlProtocol.OnPlayStateListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0859a f17687a;

        public C0862c(c cVar, a.InterfaceC0859a interfaceC0859a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, interfaceC0859a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17687a = interfaceC0859a;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onPause();
                this.f17687a.a();
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onStart();
                this.f17687a.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17688a;

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
            this.f17688a = cVar;
        }

        @Override // c.a.r0.z.c.b.a
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 == 3) {
                    if (ListUtils.getCount(this.f17688a.p) < 1 || ((float) (this.f17688a.k - this.f17688a.f17684j)) * ((MultiMediaData) this.f17688a.p.get(0)).getCurrentSpeed() < 6000.0f) {
                        BdToast.f(this.f17688a.f17675a.getPageActivity(), String.format(this.f17688a.f17675a.getString(R.string.file_edit_less_sec), 6), BdToast.DefaultIcon.FAILURE).q();
                        return false;
                    }
                } else if (i2 == 4 && (ListUtils.getCount(this.f17688a.p) < 1 || ((float) (this.f17688a.k - this.f17688a.f17684j)) * ((MultiMediaData) this.f17688a.p.get(0)).getCurrentSpeed() < 9000.0f)) {
                    BdToast.f(this.f17688a.f17675a.getPageActivity(), String.format(this.f17688a.f17675a.getString(R.string.file_edit_less_sec), 9), BdToast.DefaultIcon.FAILURE).q();
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements c.a.r0.z.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17689a;

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
            this.f17689a = cVar;
        }

        @Override // c.a.r0.z.b.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f17689a.f17683i == f2) {
                    return true;
                }
                this.f17689a.f17683i = f2;
                this.f17689a.L();
                this.f17689a.o = true;
                if (this.f17689a.s != null) {
                    this.f17689a.f17681g.updateRatioButtonStyle(this.f17689a.s.b() == 0);
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
        public final /* synthetic */ c f17690e;

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
            this.f17690e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17690e.f17678d == null) {
                return;
            }
            this.f17690e.f17676b.setVideoRatio(this.f17690e.f17683i);
            if (this.f17690e.f17676b == null || this.f17690e.f17676b.isPlaying()) {
                return;
            }
            this.f17690e.f17678d.requestRender();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements c.a.r0.c4.l.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17691a;

        /* loaded from: classes3.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f17692e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f17693f;

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
                this.f17693f = gVar;
                this.f17692e = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f17693f.f17691a.f17676b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f17693f.f17691a.f17676b.setAngle(this.f17692e, floatValue);
                ((MultiMediaData) this.f17693f.f17691a.p.get(this.f17692e)).angle = floatValue;
                if (this.f17693f.f17691a.f17678d == null || this.f17693f.f17691a.f17676b.isPlaying()) {
                    return;
                }
                this.f17693f.f17691a.f17678d.requestRender();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f17694e;

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
                this.f17694e = gVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f17694e.f17691a.f17676b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (int i2 = 0; i2 < this.f17694e.f17691a.p.size(); i2++) {
                    this.f17694e.f17691a.f17676b.setAngle(i2, floatValue);
                    ((MultiMediaData) this.f17694e.f17691a.p.get(i2)).angle = floatValue;
                    if (this.f17694e.f17691a.f17678d != null && !this.f17694e.f17691a.f17676b.isPlaying()) {
                        this.f17694e.f17691a.f17678d.requestRender();
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
            this.f17691a = cVar;
        }

        @Override // c.a.r0.c4.l.c.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void c(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void e(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2)}) == null) || this.f17691a.f17676b == null) {
                return;
            }
            this.f17691a.f17676b.seek((long) d2);
        }

        @Override // c.a.r0.c4.l.c.a
        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void g(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || this.f17691a.f17676b == null || ListUtils.isEmpty(this.f17691a.p)) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i2, i3);
            ofFloat.addUpdateListener(new b(this));
            ofFloat.setDuration(300L);
            ofFloat.start();
            this.f17691a.L();
            this.f17691a.o = true;
        }

        @Override // c.a.r0.c4.l.c.a
        public void h(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void i(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) || this.f17691a.f17676b == null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i3, i4);
            ofFloat.addUpdateListener(new a(this, i2));
            ofFloat.setDuration(300L);
            ofFloat.start();
        }

        @Override // c.a.r0.c4.l.c.a
        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.f17691a.o = true;
                if ((this.f17691a.k - this.f17691a.f17684j) - 100 >= 3000 || c.a.q0.s.d0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f17691a.S(R.string.file_video_clip_less_3_tips);
                c.a.q0.s.d0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void l(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void m(int i2, c.a.r0.c4.l.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048588, this, i2, aVar) == null) {
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void n(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void o() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f17691a.s == null) {
                return;
            }
            int b2 = this.f17691a.s.b();
            this.f17691a.M();
            if (b2 != 0) {
                this.f17691a.s.c(0);
            }
            if (this.f17691a.f17681g != null) {
                this.f17691a.f17681g.updateRatioButtonStyle(this.f17691a.s.b() == 0);
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void p(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Double.valueOf(d2)}) == null) || this.f17691a.f17676b == null) {
                return;
            }
            this.f17691a.f17676b.seek((long) d2);
        }

        @Override // c.a.r0.c4.l.c.a
        public void q() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.f17691a.r == null) {
                return;
            }
            int b2 = this.f17691a.r.b();
            this.f17691a.M();
            if (b2 != 0) {
                this.f17691a.r.c(0);
            }
            if (this.f17691a.f17681g != null) {
                this.f17691a.f17681g.updateSpeedButtonStyle(this.f17691a.r.d(), this.f17691a.r.b() == 0);
            }
        }

        @Override // c.a.r0.c4.l.c.a
        public void r(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f17691a.f17676b == null) {
                return;
            }
            this.f17691a.f17676b.seek(j2);
        }

        @Override // c.a.r0.c4.l.c.a
        public void s(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                if (this.f17691a.f17676b != null) {
                    this.f17691a.f17676b.seek(j2);
                }
                this.f17691a.f17684j = j2;
                this.f17691a.k = j3;
                if (!this.f17691a.o || (this.f17691a.k - this.f17691a.f17684j) - 100 >= 3000 || c.a.q0.s.d0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f17691a.S(R.string.file_video_clip_less_3_tips);
                c.a.q0.s.d0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17695a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f17696e;

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
                this.f17696e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f17696e.f17695a.q)) {
                    return;
                }
                this.f17696e.f17695a.f17681g.updateCurrentPlayIndex(-1, this.f17696e.f17695a.f17676b.getCurrentIndex());
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f17697e;

            /* loaded from: classes3.dex */
            public class a extends AnimatorListenerAdapter {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f17698e;

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
                    this.f17698e = bVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                        this.f17698e.f17697e.f17695a.f17681g.setVisibility(0);
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
                this.f17697e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f17697e.f17695a.f17681g, "translationY", this.f17697e.f17695a.f17681g.getHeight(), 0.0f);
                    ofFloat.setDuration(250L);
                    ofFloat.addListener(new a(this));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17697e.f17695a.f17678d.getLayoutParams();
                    layoutParams.removeRule(3);
                    layoutParams.removeRule(2);
                    this.f17697e.f17695a.l = (l.i(this.f17697e.f17695a.f17675a.getPageActivity()) - this.f17697e.f17695a.f17680f.getHeight()) - this.f17697e.f17695a.f17679e.getHeight();
                    c cVar = this.f17697e.f17695a;
                    cVar.m = l.k(cVar.f17675a.getPageActivity());
                    if (this.f17697e.f17695a.f17683i > 1.0f) {
                        layoutParams.width = Math.min((int) (this.f17697e.f17695a.l / this.f17697e.f17695a.f17683i), this.f17697e.f17695a.m);
                    } else if (this.f17697e.f17695a.f17683i > 0.0f) {
                        layoutParams.width = this.f17697e.f17695a.m;
                    }
                    layoutParams.height = (int) (layoutParams.width * this.f17697e.f17695a.f17683i);
                    this.f17697e.f17695a.f17678d.requestLayout();
                    c.a.r0.x3.g.h(this.f17697e.f17695a.f17675a.getPageActivity().getIntent(), this.f17697e.f17695a.f17678d);
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
            this.f17695a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17695a.f17676b == null) {
                return;
            }
            this.f17695a.f17676b.pause();
            this.f17695a.f17681g.post(new a(this));
            if (this.f17695a.f17682h != 2 || this.f17695a.n) {
                return;
            }
            this.f17695a.n = true;
            this.f17695a.f17678d.post(new b(this));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements MultiMediaTimelineUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17699a;

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
            this.f17699a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaTimelineUpdateListener
        public void onTimelineUpdate(long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                if (this.f17699a.f17681g.isInSingleMedia()) {
                    j2 -= this.f17699a.f17681g.getSingleMediaStartDuration();
                    if (this.f17699a.f17681g.getSingleClipTo() - j2 <= 150) {
                        this.f17699a.f17676b.seek(this.f17699a.f17681g.getSingleClipFrom() + this.f17699a.f17681g.getSingleMediaStartDuration());
                    }
                } else if (this.f17699a.f17681g.getAllClipTo() - j2 <= 100) {
                    this.f17699a.f17676b.seek(this.f17699a.f17681g.getAllClipFrom());
                }
                this.f17699a.f17681g.updateTimeline(j2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements MultiMediaStateEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17700a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f17701e;

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
                this.f17701e = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f17701e.f17700a.q)) {
                    return;
                }
                this.f17701e.f17700a.f17681g.updateCurrentPlayIndex(-1, this.f17701e.f17700a.f17676b.getCurrentIndex());
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
            this.f17700a = cVar;
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
                this.f17700a.f17681g.post(new a(this));
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
    public class k implements c.a.x0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f17702a;

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
            this.f17702a = cVar;
        }

        @Override // c.a.x0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c.a.r0.c4.l.b(this.f17702a.f17675a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // c.a.x0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17702a.t ? c.a.r0.y3.c.f29078c : c.a.r0.y3.c.f29079d : (String) invokeV.objValue;
        }

        @Override // c.a.x0.c
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        @Override // c.a.x0.c
        public c.a.x0.j.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (c.a.x0.j.a) invokeV.objValue;
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
        this.f17675a = tbPageContext;
        this.r = new c.a.r0.z.c.c(tbPageContext, this.u, this.v);
        this.f17678d = tbGLMediaPreviewView;
        this.f17681g = multiMediaEditLayout;
        this.f17682h = i2;
        this.t = z;
        ArrayList arrayList = new ArrayList();
        this.p = arrayList;
        arrayList.add(tbMultiMediaData);
        if (!ListUtils.isEmpty(this.p) && this.p.get(0).height > 0 && this.p.get(0).width > 0) {
            this.f17683i = (this.p.get(0).height * 1.0f) / this.p.get(0).width;
            c.a.r0.z.b.c cVar = new c.a.r0.z.b.c(this.f17675a, this.p.get(0).height, this.p.get(0).width, this.w);
            this.s = cVar;
            cVar.d(0);
        }
        if (tbMultiMediaData != null) {
            this.f17684j = tbMultiMediaData.start;
            tbMultiMediaData.start = 0L;
            this.k = tbMultiMediaData.end;
            tbMultiMediaData.end = tbMultiMediaData.originalDuration;
        }
        N();
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17680f.post(new f(this));
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.r0.z.c.b bVar = this.r;
            if (bVar != null) {
                bVar.c(8);
                MultiMediaEditLayout multiMediaEditLayout = this.f17681g;
                if (multiMediaEditLayout != null) {
                    multiMediaEditLayout.updateSpeedButtonStyle(this.r.d(), false);
                }
            }
            c.a.r0.z.b.b bVar2 = this.s;
            if (bVar2 != null) {
                bVar2.c(8);
                MultiMediaEditLayout multiMediaEditLayout2 = this.f17681g;
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
            if (!c.a.r0.x3.a.a()) {
                this.f17675a.getPageActivity().finish();
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
            c.a.x0.b.d().i(TbadkCoreApplication.getInst());
            c.a.x0.b.d().k(FileHelper.getCacheDir());
            c.a.x0.b.d().l(new k(this));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f17678d.setZOrderMediaOverlay(true);
            this.f17678d.setMultiMediaDataSourceViewAdapter(this.f17677c, true);
            this.f17679e = (NavigationBar) this.f17675a.getPageActivity().findViewById(R.id.navigation_bar);
            this.f17680f = (FrameLayout) this.f17675a.getPageActivity().findViewById(R.id.tool_root_layout);
            this.f17681g.setPageContext(this.f17675a);
            this.f17681g.setOnlyOneVideo();
            this.f17681g.setLocalAlbumInfoData(this.f17676b, this.p);
            this.f17681g.setMultiVideoClipLayoutRange((int) this.f17684j, (int) this.k);
            this.f17681g.setIMultiMediaEditView(new g(this));
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f17677c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.f17676b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.p);
            this.f17676b.setLooping(true);
            this.f17676b.setPreparedListener(new h(this));
            this.f17676b.setMultiMediaTimelineUpdateListener(new i(this), true);
            this.f17676b.setMultiMediaStateEventListener(new j(this));
        }
    }

    public final void R() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (vlogEditManager = this.f17676b) == null || this.f17681g == null) {
            return;
        }
        boolean isPlaying = vlogEditManager.isPlaying();
        this.f17676b.reset();
        this.f17676b.setMultiMediaData(this.p);
        if (this.f17681g.isInSingleMedia()) {
            int i2 = 0;
            MediaTrack mediaTrack = (MediaTrack) ListUtils.getItem(this.f17676b.getUpdateMediaTracks(), 0);
            int currentMediaPosition = this.f17681g.getCurrentMediaPosition();
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
            this.f17681g.setSingleMediaStartDuration(i4);
            this.f17676b.seek(i4 + this.f17681g.getSingleClipFrom());
        } else {
            this.f17676b.seek(this.f17681g.getAllClipFrom());
        }
        if (isPlaying) {
            this.f17676b.start();
        } else {
            this.f17676b.pause();
        }
    }

    public final void S(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || i2 <= 0) {
            return;
        }
        c.a.r0.f0.e eVar = new c.a.r0.f0.e(this.f17675a, this.f17681g);
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
        eVar.l0(this.f17675a.getPageActivity().getResources().getString(i2));
    }

    @Override // c.a.r0.g0.a.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmFilterItem)) == null) {
            String str = IVlogEditManager.FILTER_ORIGINAL;
            if (qmFilterItem == null || StringUtils.isNull(qmFilterItem.localPath) || FilterValue.DEFAULT_FILTER_VALUE.equals(qmFilterItem.localPath)) {
                f2 = 0.0f;
            } else {
                f2 = c.a.e.e.m.b.d(qmFilterItem.effect, 100.0f) / 100.0f;
                File file = new File(qmFilterItem.localPath);
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles(new b(this));
                    if (listFiles.length > 0) {
                        str = listFiles[0].getAbsolutePath();
                    }
                }
            }
            VlogEditManager vlogEditManager = this.f17676b;
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

    @Override // c.a.r0.g0.a.a
    public void b(a.InterfaceC0859a interfaceC0859a) {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, interfaceC0859a) == null) || (vlogEditManager = this.f17676b) == null) {
            return;
        }
        vlogEditManager.setOnPlayStateListener(null);
        this.f17676b.setOnPlayStateListener(new C0862c(this, interfaceC0859a));
    }

    @Override // c.a.r0.g0.a.a
    public void c(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, tbMultiMediaData) == null) || tbMultiMediaData == null) {
            return;
        }
        this.p.clear();
        this.p.add(tbMultiMediaData);
        R();
        MultiMediaEditLayout multiMediaEditLayout = this.f17681g;
        if (multiMediaEditLayout != null) {
            multiMediaEditLayout.resetRangeSlider();
        }
        c.a.r0.z.b.b bVar = this.s;
        if (bVar != null) {
            bVar.reset();
        }
        c.a.r0.z.c.b bVar2 = this.r;
        if (bVar2 != null) {
            bVar2.reset();
        }
    }

    @Override // c.a.r0.g0.a.a
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : invokeV.longValue;
    }

    @Override // c.a.r0.g0.a.a
    public void e(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048588, this, f2) == null) || this.f17683i == f2) {
            return;
        }
        this.f17683i = f2;
        L();
        VlogEditManager vlogEditManager = this.f17676b;
        if (vlogEditManager == null || vlogEditManager.isPlaying()) {
            return;
        }
        VlogEditManager vlogEditManager2 = this.f17676b;
        vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
    }

    @Override // c.a.r0.g0.a.a
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.o : invokeV.booleanValue;
    }

    @Override // c.a.r0.g0.a.a
    public void g(boolean z) {
        MultiMediaEditLayout multiMediaEditLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (multiMediaEditLayout = this.f17681g) == null) {
            return;
        }
        multiMediaEditLayout.setOnlyClip(z);
    }

    @Override // c.a.r0.g0.a.a
    public long getCurrentPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            VlogEditManager vlogEditManager = this.f17676b;
            if (vlogEditManager != null) {
                return vlogEditManager.getCurrentPlayTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.r0.g0.a.a
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f17684j : invokeV.longValue;
    }

    @Override // c.a.r0.g0.a.a
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.f17676b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.f17676b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // c.a.r0.g0.a.a
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f17683i : invokeV.floatValue;
    }

    @Override // c.a.r0.g0.a.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            VlogEditManager vlogEditManager = this.f17676b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.g0.a.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            VlogEditManager vlogEditManager = this.f17676b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17678d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            MultiMediaEditLayout multiMediaEditLayout = this.f17681g;
            if (multiMediaEditLayout != null) {
                multiMediaEditLayout.release();
            }
        }
    }

    @Override // c.a.r0.g0.a.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            VlogEditManager vlogEditManager = this.f17676b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17678d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // c.a.r0.g0.a.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f17678d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.f17676b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    @Override // c.a.r0.g0.a.a
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (vlogEditManager = this.f17676b) == null) {
            return;
        }
        vlogEditManager.pause();
    }

    @Override // c.a.r0.g0.a.a
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (vlogEditManager = this.f17676b) == null) {
            return;
        }
        vlogEditManager.start();
        this.o = true;
    }
}

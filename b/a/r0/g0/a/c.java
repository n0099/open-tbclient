package b.a.r0.g0.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.r0.g0.a.a;
import b.a.r0.z.c.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
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
    public TbPageContext f16640a;

    /* renamed from: b  reason: collision with root package name */
    public VlogEditManager f16641b;

    /* renamed from: c  reason: collision with root package name */
    public MultiMediaDataSourceViewAdapter f16642c;

    /* renamed from: d  reason: collision with root package name */
    public TbGLMediaPreviewView f16643d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f16644e;

    /* renamed from: f  reason: collision with root package name */
    public FrameLayout f16645f;

    /* renamed from: g  reason: collision with root package name */
    public MultiMediaEditLayout f16646g;

    /* renamed from: h  reason: collision with root package name */
    public int f16647h;

    /* renamed from: i  reason: collision with root package name */
    public float f16648i;
    public long j;
    public long k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public List<MultiMediaData> p;
    public List<b.a.r0.c4.l.c.c.a> q;
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
        public final /* synthetic */ c f16649a;

        /* renamed from: b.a.r0.g0.a.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0856a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f16650e;

            public RunnableC0856a(a aVar) {
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
                this.f16650e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16650e.f16649a.S();
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
            this.f16649a = cVar;
        }

        @Override // b.a.r0.z.c.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                for (int i2 = 0; i2 < this.f16649a.p.size(); i2++) {
                    MultiMediaData multiMediaData = (MultiMediaData) this.f16649a.p.get(i2);
                    if (multiMediaData != null && multiMediaData.mSpeed != f2) {
                        multiMediaData.mSpeed = f2;
                        this.f16649a.o = true;
                    }
                }
                b.a.e.e.m.e.a().postDelayed(new RunnableC0856a(this), 100L);
                this.f16649a.f16646g.setLocalAlbumInfoData(this.f16649a.f16641b, this.f16649a.p, false);
                if (this.f16649a.r != null) {
                    this.f16649a.f16646g.updateSpeedButtonStyle(this.f16649a.r.d(), this.f16649a.r.b() == 0);
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) ? str.endsWith(".png") : invokeLL.booleanValue;
        }
    }

    /* renamed from: b.a.r0.g0.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0857c extends IVLogPlayControlProtocol.OnPlayStateListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0854a f16651a;

        public C0857c(c cVar, a.InterfaceC0854a interfaceC0854a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, interfaceC0854a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16651a = interfaceC0854a;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onPause();
                this.f16651a.a();
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onStart();
                this.f16651a.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f16652a;

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
            this.f16652a = cVar;
        }

        @Override // b.a.r0.z.c.b.a
        public boolean a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 == 3) {
                    if (ListUtils.getCount(this.f16652a.p) < 1 || ((float) (this.f16652a.k - this.f16652a.j)) * ((MultiMediaData) this.f16652a.p.get(0)).getCurrentSpeed() < 6000.0f) {
                        BdToast.f(this.f16652a.f16640a.getPageActivity(), String.format(this.f16652a.f16640a.getString(R.string.file_edit_less_sec), 6), BdToast.DefaultIcon.FAILURE).q();
                        return false;
                    }
                } else if (i2 == 4 && (ListUtils.getCount(this.f16652a.p) < 1 || ((float) (this.f16652a.k - this.f16652a.j)) * ((MultiMediaData) this.f16652a.p.get(0)).getCurrentSpeed() < 9000.0f)) {
                    BdToast.f(this.f16652a.f16640a.getPageActivity(), String.format(this.f16652a.f16640a.getString(R.string.file_edit_less_sec), 9), BdToast.DefaultIcon.FAILURE).q();
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
        public final /* synthetic */ c f16653a;

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
            this.f16653a = cVar;
        }

        @Override // b.a.r0.z.b.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f16653a.f16648i == f2) {
                    return true;
                }
                this.f16653a.f16648i = f2;
                this.f16653a.M();
                this.f16653a.o = true;
                if (this.f16653a.s != null) {
                    this.f16653a.f16646g.updateRatioButtonStyle(this.f16653a.s.b() == 0);
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
        public final /* synthetic */ c f16654e;

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
            this.f16654e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16654e.f16643d == null) {
                return;
            }
            this.f16654e.f16641b.setVideoRatio(this.f16654e.f16648i);
            if (this.f16654e.f16641b == null || this.f16654e.f16641b.isPlaying()) {
                return;
            }
            this.f16654e.f16643d.requestRender();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements b.a.r0.c4.l.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f16655a;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f16656e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f16657f;

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
                this.f16657f = gVar;
                this.f16656e = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f16657f.f16655a.f16641b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f16657f.f16655a.f16641b.setAngle(this.f16656e, floatValue);
                ((MultiMediaData) this.f16657f.f16655a.p.get(this.f16656e)).angle = floatValue;
                if (this.f16657f.f16655a.f16643d == null || this.f16657f.f16655a.f16641b.isPlaying()) {
                    return;
                }
                this.f16657f.f16655a.f16643d.requestRender();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f16658e;

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
                this.f16658e = gVar;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || this.f16658e.f16655a.f16641b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (int i2 = 0; i2 < this.f16658e.f16655a.p.size(); i2++) {
                    this.f16658e.f16655a.f16641b.setAngle(i2, floatValue);
                    ((MultiMediaData) this.f16658e.f16655a.p.get(i2)).angle = floatValue;
                    if (this.f16658e.f16655a.f16643d != null && !this.f16658e.f16655a.f16641b.isPlaying()) {
                        this.f16658e.f16655a.f16643d.requestRender();
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
            this.f16655a = cVar;
        }

        @Override // b.a.r0.c4.l.c.a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void c(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void e(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d2)}) == null) || this.f16655a.f16641b == null) {
                return;
            }
            this.f16655a.f16641b.seek((long) d2);
        }

        @Override // b.a.r0.c4.l.c.a
        public void f(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void g(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) || this.f16655a.f16641b == null || ListUtils.isEmpty(this.f16655a.p)) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i2, i3);
            ofFloat.addUpdateListener(new b(this));
            ofFloat.setDuration(300L);
            ofFloat.start();
            this.f16655a.M();
            this.f16655a.o = true;
        }

        @Override // b.a.r0.c4.l.c.a
        public void h(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void i(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4) == null) || this.f16655a.f16641b == null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i3, i4);
            ofFloat.addUpdateListener(new a(this, i2));
            ofFloat.setDuration(300L);
            ofFloat.start();
        }

        @Override // b.a.r0.c4.l.c.a
        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.f16655a.o = true;
                if ((this.f16655a.k - this.f16655a.j) - 100 >= 3000 || b.a.q0.s.e0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f16655a.T(R.string.file_video_clip_less_3_tips);
                b.a.q0.s.e0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void l(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void m(int i2, b.a.r0.c4.l.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048588, this, i2, aVar) == null) {
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void n(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void o() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f16655a.s == null) {
                return;
            }
            int b2 = this.f16655a.s.b();
            this.f16655a.N();
            if (b2 != 0) {
                this.f16655a.s.c(0);
            }
            if (this.f16655a.f16646g != null) {
                this.f16655a.f16646g.updateRatioButtonStyle(this.f16655a.s.b() == 0);
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void p(double d2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Double.valueOf(d2)}) == null) || this.f16655a.f16641b == null) {
                return;
            }
            this.f16655a.f16641b.seek((long) d2);
        }

        @Override // b.a.r0.c4.l.c.a
        public void q() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.f16655a.r == null) {
                return;
            }
            int b2 = this.f16655a.r.b();
            this.f16655a.N();
            if (b2 != 0) {
                this.f16655a.r.c(0);
            }
            if (this.f16655a.f16646g != null) {
                this.f16655a.f16646g.updateSpeedButtonStyle(this.f16655a.r.d(), this.f16655a.r.b() == 0);
            }
        }

        @Override // b.a.r0.c4.l.c.a
        public void r(long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f16655a.f16641b == null) {
                return;
            }
            this.f16655a.f16641b.seek(j);
        }

        @Override // b.a.r0.c4.l.c.a
        public void s(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if (this.f16655a.f16641b != null) {
                    this.f16655a.f16641b.seek(j);
                }
                this.f16655a.j = j;
                this.f16655a.k = j2;
                if (!this.f16655a.o || (this.f16655a.k - this.f16655a.j) - 100 >= 3000 || b.a.q0.s.e0.b.j().g("key_file_video_clip_less_3_tip_show", false)) {
                    return;
                }
                this.f16655a.T(R.string.file_video_clip_less_3_tips);
                b.a.q0.s.e0.b.j().t("key_file_video_clip_less_3_tip_show", true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f16659a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f16660e;

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
                this.f16660e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f16660e.f16659a.q)) {
                    return;
                }
                this.f16660e.f16659a.f16646g.updateCurrentPlayIndex(-1, this.f16660e.f16659a.f16641b.getCurrentIndex());
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f16661e;

            /* loaded from: classes4.dex */
            public class a extends AnimatorListenerAdapter {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ b f16662e;

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
                    this.f16662e = bVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                        this.f16662e.f16661e.f16659a.f16646g.setVisibility(0);
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
                this.f16661e = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f16661e.f16659a.f16646g, Key.TRANSLATION_Y, this.f16661e.f16659a.f16646g.getHeight(), 0.0f);
                    ofFloat.setDuration(250L);
                    ofFloat.addListener(new a(this));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f16661e.f16659a.f16643d.getLayoutParams();
                    layoutParams.removeRule(3);
                    layoutParams.removeRule(2);
                    this.f16661e.f16659a.l = (l.i(this.f16661e.f16659a.f16640a.getPageActivity()) - this.f16661e.f16659a.f16645f.getHeight()) - this.f16661e.f16659a.f16644e.getHeight();
                    c cVar = this.f16661e.f16659a;
                    cVar.m = l.k(cVar.f16640a.getPageActivity());
                    if (this.f16661e.f16659a.f16648i > 1.0f) {
                        layoutParams.width = Math.min((int) (this.f16661e.f16659a.l / this.f16661e.f16659a.f16648i), this.f16661e.f16659a.m);
                    } else if (this.f16661e.f16659a.f16648i > 0.0f) {
                        layoutParams.width = this.f16661e.f16659a.m;
                    }
                    layoutParams.height = (int) (layoutParams.width * this.f16661e.f16659a.f16648i);
                    this.f16661e.f16659a.f16643d.requestLayout();
                    b.a.r0.y3.g.h(this.f16661e.f16659a.f16640a.getPageActivity().getIntent(), this.f16661e.f16659a.f16643d);
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
            this.f16659a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f16659a.f16641b == null) {
                return;
            }
            this.f16659a.f16641b.pause();
            this.f16659a.f16646g.post(new a(this));
            if (this.f16659a.f16647h != 2 || this.f16659a.n) {
                return;
            }
            this.f16659a.n = true;
            this.f16659a.f16643d.post(new b(this));
        }
    }

    /* loaded from: classes4.dex */
    public class i implements MultiMediaTimelineUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f16663a;

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
            this.f16663a = cVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaTimelineUpdateListener
        public void onTimelineUpdate(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if (this.f16663a.f16646g.isInSingleMedia()) {
                    j -= this.f16663a.f16646g.getSingleMediaStartDuration();
                    if (this.f16663a.f16646g.getSingleClipTo() - j <= 150) {
                        this.f16663a.f16641b.seek(this.f16663a.f16646g.getSingleClipFrom() + this.f16663a.f16646g.getSingleMediaStartDuration());
                    }
                } else if (this.f16663a.f16646g.getAllClipTo() - j <= 100) {
                    this.f16663a.f16641b.seek(this.f16663a.f16646g.getAllClipFrom());
                }
                this.f16663a.f16646g.updateTimeline(j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements MultiMediaStateEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f16664a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f16665e;

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
                this.f16665e = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || ListUtils.isEmpty(this.f16665e.f16664a.q)) {
                    return;
                }
                this.f16665e.f16664a.f16646g.updateCurrentPlayIndex(-1, this.f16665e.f16664a.f16641b.getCurrentIndex());
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
            this.f16664a = cVar;
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
                this.f16664a.f16646g.post(new a(this));
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
        public final /* synthetic */ c f16666a;

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
            this.f16666a = cVar;
        }

        @Override // b.a.x0.c
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b.a.r0.c4.l.b(this.f16666a.f16640a.getPageActivity()) : (IMediaPlayer) invokeV.objValue;
        }

        @Override // b.a.x0.c
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16666a.t ? b.a.r0.z3.c.f28283c : b.a.r0.z3.c.f28284d : (String) invokeV.objValue;
        }

        @Override // b.a.x0.c
        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        @Override // b.a.x0.c
        public b.a.x0.j.a d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (b.a.x0.j.a) invokeV.objValue;
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
        this.f16640a = tbPageContext;
        this.r = new b.a.r0.z.c.c(tbPageContext, this.u, this.v);
        this.f16643d = tbGLMediaPreviewView;
        this.f16646g = multiMediaEditLayout;
        this.f16647h = i2;
        this.t = z;
        ArrayList arrayList = new ArrayList();
        this.p = arrayList;
        arrayList.add(tbMultiMediaData);
        if (!ListUtils.isEmpty(this.p) && this.p.get(0).height > 0 && this.p.get(0).width > 0) {
            this.f16648i = (this.p.get(0).height * 1.0f) / this.p.get(0).width;
            b.a.r0.z.b.c cVar = new b.a.r0.z.b.c(this.f16640a, this.p.get(0).height, this.p.get(0).width, this.w);
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
            this.f16645f.post(new f(this));
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.r0.z.c.b bVar = this.r;
            if (bVar != null) {
                bVar.c(8);
                MultiMediaEditLayout multiMediaEditLayout = this.f16646g;
                if (multiMediaEditLayout != null) {
                    multiMediaEditLayout.updateSpeedButtonStyle(this.r.d(), false);
                }
            }
            b.a.r0.z.b.b bVar2 = this.s;
            if (bVar2 != null) {
                bVar2.c(8);
                MultiMediaEditLayout multiMediaEditLayout2 = this.f16646g;
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
            if (!b.a.r0.y3.a.a()) {
                this.f16640a.getPageActivity().finish();
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
            this.f16643d.setZOrderMediaOverlay(true);
            this.f16643d.setMultiMediaDataSourceViewAdapter(this.f16642c, true);
            this.f16644e = (NavigationBar) this.f16640a.getPageActivity().findViewById(R.id.navigation_bar);
            this.f16645f = (FrameLayout) this.f16640a.getPageActivity().findViewById(R.id.tool_root_layout);
            this.f16646g.setPageContext(this.f16640a);
            this.f16646g.setOnlyOneVideo();
            this.f16646g.setLocalAlbumInfoData(this.f16641b, this.p);
            this.f16646g.setMultiVideoClipLayoutRange((int) this.j, (int) this.k);
            this.f16646g.setIMultiMediaEditView(new g(this));
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.f16642c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.f16641b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.p);
            this.f16641b.setLooping(true);
            this.f16641b.setPreparedListener(new h(this));
            this.f16641b.setMultiMediaTimelineUpdateListener(new i(this), true);
            this.f16641b.setMultiMediaStateEventListener(new j(this));
        }
    }

    public final void S() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (vlogEditManager = this.f16641b) == null || this.f16646g == null) {
            return;
        }
        boolean isPlaying = vlogEditManager.isPlaying();
        this.f16641b.reset();
        this.f16641b.setMultiMediaData(this.p);
        if (this.f16646g.isInSingleMedia()) {
            int i2 = 0;
            MediaTrack mediaTrack = (MediaTrack) ListUtils.getItem(this.f16641b.getUpdateMediaTracks(), 0);
            int currentMediaPosition = this.f16646g.getCurrentMediaPosition();
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
            this.f16646g.setSingleMediaStartDuration(i4);
            this.f16641b.seek(i4 + this.f16646g.getSingleClipFrom());
        } else {
            this.f16641b.seek(this.f16646g.getAllClipFrom());
        }
        if (isPlaying) {
            this.f16641b.start();
        } else {
            this.f16641b.pause();
        }
    }

    public final void T(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || i2 <= 0) {
            return;
        }
        b.a.r0.f0.g gVar = new b.a.r0.f0.g(this.f16640a, this.f16646g);
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
        gVar.l0(this.f16640a.getPageActivity().getResources().getString(i2));
    }

    @Override // b.a.r0.g0.a.a
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmFilterItem)) == null) {
            String str = IVlogEditManager.FILTER_ORIGINAL;
            if (qmFilterItem == null || StringUtils.isNull(qmFilterItem.localPath) || "origin".equals(qmFilterItem.localPath)) {
                f2 = 0.0f;
            } else {
                f2 = b.a.e.e.m.b.d(qmFilterItem.effect, 100.0f) / 100.0f;
                File file = new File(qmFilterItem.localPath);
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles(new b(this));
                    if (listFiles.length > 0) {
                        str = listFiles[0].getAbsolutePath();
                    }
                }
            }
            VlogEditManager vlogEditManager = this.f16641b;
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
    public void b(a.InterfaceC0854a interfaceC0854a) {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, interfaceC0854a) == null) || (vlogEditManager = this.f16641b) == null) {
            return;
        }
        vlogEditManager.setOnPlayStateListener(null);
        this.f16641b.setOnPlayStateListener(new C0857c(this, interfaceC0854a));
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
        MultiMediaEditLayout multiMediaEditLayout = this.f16646g;
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
        if (!(interceptable == null || interceptable.invokeF(1048589, this, f2) == null) || this.f16648i == f2) {
            return;
        }
        this.f16648i = f2;
        M();
        VlogEditManager vlogEditManager = this.f16641b;
        if (vlogEditManager == null || vlogEditManager.isPlaying()) {
            return;
        }
        VlogEditManager vlogEditManager2 = this.f16641b;
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
            VlogEditManager vlogEditManager = this.f16641b;
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
            if (this.f16641b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.f16641b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // b.a.r0.g0.a.a
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f16648i : invokeV.floatValue;
    }

    @Override // b.a.r0.g0.a.a
    public void h(boolean z) {
        MultiMediaEditLayout multiMediaEditLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (multiMediaEditLayout = this.f16646g) == null) {
            return;
        }
        multiMediaEditLayout.setOnlyClip(z);
    }

    @Override // b.a.r0.g0.a.a
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            VlogEditManager vlogEditManager = this.f16641b;
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
            VlogEditManager vlogEditManager = this.f16641b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f16643d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            MultiMediaEditLayout multiMediaEditLayout = this.f16646g;
            if (multiMediaEditLayout != null) {
                multiMediaEditLayout.release();
            }
        }
    }

    @Override // b.a.r0.g0.a.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            VlogEditManager vlogEditManager = this.f16641b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f16643d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // b.a.r0.g0.a.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.f16643d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.f16641b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    @Override // b.a.r0.g0.a.a
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (vlogEditManager = this.f16641b) == null) {
            return;
        }
        vlogEditManager.pause();
    }

    @Override // b.a.r0.g0.a.a
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (vlogEditManager = this.f16641b) == null) {
            return;
        }
        vlogEditManager.start();
        this.o = true;
    }
}

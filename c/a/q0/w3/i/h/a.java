package c.a.q0.w3.i.h;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.p0.s.s.i;
import c.a.q0.y1.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.EditVideoActivity;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.tieba.video.editvideo.view.MaskVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends c.a.e.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f28316a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f28317b;

    /* renamed from: c  reason: collision with root package name */
    public MaskVideoView f28318c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.w3.i.a f28319d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f28320e;

    /* renamed from: f  reason: collision with root package name */
    public PopupDialog f28321f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.w3.i.h.c f28322g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.w3.i.h.e f28323h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.w3.i.h.d f28324i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f28325j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public g o;
    public i.e p;

    /* renamed from: c.a.q0.w3.i.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1318a implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28326e;

        public C1318a(a aVar) {
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
            this.f28326e = aVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                a aVar = this.f28326e;
                if (i2 == aVar.l) {
                    return;
                }
                if (i2 == 0) {
                    aVar.f28322g.i().setVisibility(0);
                    this.f28326e.f28323h.t().setVisibility(8);
                    this.f28326e.f28324i.g().setVisibility(8);
                    this.f28326e.f28322g.q(true);
                    this.f28326e.f28323h.A(false);
                    this.f28326e.f28324i.l(false);
                } else if (i2 == 1) {
                    aVar.f28324i.g().setVisibility(0);
                    this.f28326e.f28323h.t().setVisibility(8);
                    this.f28326e.f28322g.i().setVisibility(8);
                    this.f28326e.f28322g.q(false);
                    if (TextUtils.isEmpty(this.f28326e.f28323h.s())) {
                        this.f28326e.f28323h.A(false);
                    } else {
                        this.f28326e.f28323h.A(true);
                    }
                    this.f28326e.f28324i.l(true);
                } else if (i2 == 2) {
                    aVar.f28323h.t().setVisibility(0);
                    this.f28326e.f28322g.i().setVisibility(8);
                    this.f28326e.f28324i.g().setVisibility(8);
                    this.f28326e.f28322g.q(false);
                    this.f28326e.f28323h.A(true);
                    this.f28326e.f28324i.l(false);
                }
                a aVar2 = this.f28326e;
                aVar2.l = i2;
                aVar2.k.setCurrentTab(this.f28326e.l, true, true);
                this.f28326e.e0();
                this.f28326e.D();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28327e;

        /* renamed from: c.a.q0.w3.i.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1319a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f28328e;

            public RunnableC1319a(b bVar) {
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
                this.f28328e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f28328e.f28327e.f28322g.s();
                }
            }
        }

        /* renamed from: c.a.q0.w3.i.h.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1320b implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f28329e;

            public C1320b(b bVar) {
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
                this.f28329e = bVar;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (i2 == 3) {
                        a aVar = this.f28329e.f28327e;
                        if (aVar.l == 0) {
                            aVar.f28318c.pause();
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return invokeLII.booleanValue;
            }
        }

        public b(a aVar) {
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
            this.f28327e = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
        @Override // android.media.MediaPlayer.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, mediaPlayer) != null) {
                return;
            }
            this.f28327e.m = mediaPlayer;
            if (!this.f28327e.n) {
                a aVar = this.f28327e;
                if (aVar.l != 0) {
                    aVar.m.setVolume(1.0f, 1.0f);
                    c.a.e.e.m.e.a().postDelayed(new RunnableC1319a(this), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        this.f28327e.f28318c.start();
                        mediaPlayer.setOnInfoListener(new C1320b(this));
                        return;
                    }
                    this.f28327e.f28318c.seekTo(this.f28327e.f28322g.getCurrentPosition());
                    return;
                }
            }
            this.f28327e.m.setVolume(0.0f, 0.0f);
            c.a.e.e.m.e.a().postDelayed(new RunnableC1319a(this), 200L);
            if (Build.VERSION.SDK_INT < 17) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28330e;

        public c(a aVar) {
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
            this.f28330e = aVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                a aVar = this.f28330e;
                if (aVar.l != 0) {
                    aVar.R();
                    this.f28330e.f28323h.L();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28331e;

        public d(a aVar) {
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
            this.f28331e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f28331e.d0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28332e;

        public e(a aVar) {
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
            this.f28332e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f28332e.f28322g.k();
                if (this.f28332e.f28319d != null) {
                    this.f28332e.f28319d.onNext();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28333e;

        public f(a aVar) {
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
            this.f28333e = aVar;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 != 0) {
                    if (i2 == 1 && this.f28333e.f28319d != null) {
                        this.f28333e.f28319d.finishPage();
                    }
                } else if (this.f28333e.f28319d != null) {
                    this.f28333e.f28319d.onSave();
                }
                if (this.f28333e.f28321f == null || !this.f28333e.f28321f.isShowing() || this.f28333e.getPageContext() == null) {
                    return;
                }
                this.f28333e.f28321f.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.e.a.f fVar, c.a.q0.w3.i.a aVar, View view, g gVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, view, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.p = new f(this);
        this.f28319d = aVar;
        this.f28316a = view;
        this.o = gVar;
        this.f28320e = view.getResources();
        this.f28322g = new c.a.q0.w3.i.h.c(this.mContext, this);
        this.f28323h = new c.a.q0.w3.i.h.e(this.mContext, this, this.o);
        this.f28324i = new c.a.q0.w3.i.h.d(this.mContext, this);
        this.f28322g.l(this.f28316a);
        this.f28323h.u(this.f28316a);
        this.f28324i.h(this.f28316a);
        y();
        e0();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void B() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (maskVideoView = this.f28318c) == null) {
            return;
        }
        maskVideoView.doLoopSeek(this.f28322g.getCurrentPosition());
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.l == 0) {
                O();
                S();
                return;
            }
            R();
        }
    }

    public void J(c.a.e.a.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, fVar, i2) == null) {
            this.f28317b.onChangeSkinType(fVar, i2);
            this.k.onChangeSkinType(i2);
            this.k.setDiverColor(SkinManager.getColor(i2, R.color.CAM_X0105));
            SkinManager.setBackgroundColor(this.f28316a, R.color.CAM_X0201);
            c.a.q0.w3.i.h.c cVar = this.f28322g;
            if (cVar != null) {
                cVar.n(fVar, i2);
            }
            c.a.q0.w3.i.h.e eVar = this.f28323h;
            if (eVar != null) {
                eVar.w(fVar, i2);
            }
        }
    }

    public void K(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f28323h.x(str, str2);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            O();
            this.f28322g.o();
            this.f28323h.y();
            this.f28324i.j();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f28318c.onResume();
            if (this.l != 0) {
                this.f28318c.resumeMedia();
            }
            this.f28322g.p();
            this.f28323h.z();
            this.f28324i.k();
        }
    }

    public void O() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (maskVideoView = this.f28318c) == null) {
            return;
        }
        maskVideoView.pauseMediaPlayer();
    }

    public void P() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (maskVideoView = this.f28318c) == null) {
            return;
        }
        maskVideoView.onPause();
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.q0.w3.i.h.c cVar = this.f28322g;
            if (cVar != null) {
                cVar.r();
            }
            MaskVideoView maskVideoView = this.f28318c;
            if (maskVideoView != null) {
                maskVideoView.stopPlayback();
            }
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            O();
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                if (this.n) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
            }
            this.f28318c.start();
            this.f28318c.seekTo(0);
        }
    }

    public void S() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (maskVideoView = this.f28318c) == null) {
            return;
        }
        maskVideoView.seekTo(this.f28322g.getCurrentPosition());
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f28322g.t(str);
            this.f28318c.setVideoPath(str);
            this.f28318c.setOnPreparedListener(new b(this));
            this.f28318c.setOnCompletionListener(new c(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void U(c.a.q0.w3.i.d.a aVar) {
        c.a.q0.w3.i.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || (dVar = this.f28324i) == null) {
            return;
        }
        dVar.n(aVar);
    }

    public void V(MaskVideoView.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) || fVar == null || v() == null) {
            return;
        }
        v().setGenMaskCoverListener(fVar);
    }

    public void W(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f28323h.O(list);
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.n = z;
            if (this.m == null) {
                return;
            }
            R();
        }
    }

    public void Y(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.f28322g.u(list);
        }
    }

    public void Z(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            this.f28323h.Q(intent);
        }
    }

    public void a0(String str, String str2) {
        c.a.q0.w3.i.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) || (eVar = this.f28323h) == null) {
            return;
        }
        eVar.R(str, str2);
    }

    public void b0(c.a.q0.w3.i.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            MaskVideoView maskVideoView = this.f28318c;
            if (maskVideoView != null) {
                maskVideoView.setFilter(aVar);
            }
            c.a.q0.w3.i.h.d dVar = this.f28324i;
            if (dVar != null) {
                dVar.m(aVar);
            }
        }
    }

    public void c0(boolean z) {
        c.a.q0.w3.i.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (eVar = this.f28323h) == null) {
            return;
        }
        eVar.P(z);
        X(!z);
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).getFromType(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
                this.f28319d.finishPage();
                return;
            }
            if (this.f28321f == null) {
                String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
                PopupDialog popupDialog = new PopupDialog(getPageContext());
                this.f28321f = popupDialog;
                popupDialog.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
                this.f28321f.setDefaultContentView(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.p);
            }
            this.f28321f.showDialog();
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c12424");
            statisticItem.param("obj_locate", this.l == 0 ? 1 : 3);
            TiebaStatic.log(statisticItem);
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            MaskVideoView maskVideoView = this.f28318c;
            if (maskVideoView == null) {
                return 0;
            }
            return maskVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public Bitmap o(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, bitmap)) == null) ? this.f28322g.g(bitmap) : (Bitmap) invokeL.objValue;
    }

    public void p() {
        c.a.q0.w3.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (aVar = this.f28319d) == null) {
            return;
        }
        aVar.clearFinalVideoPath();
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f28323h.r() : (String) invokeV.objValue;
    }

    public c.a.q0.w3.i.e.a r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            if (this.f28324i == null || k.isEmpty(str)) {
                return null;
            }
            return this.f28324i.f(str);
        }
        return (c.a.q0.w3.i.e.a) invokeL.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f28323h.s() : (String) invokeV.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f28316a : (View) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f28322g.j() : (String) invokeV.objValue;
    }

    public MaskVideoView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f28318c : (MaskVideoView) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f28317b.setCenterTextTitle(this.f28320e.getString(R.string.select_cover));
            this.f28317b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            SkinManager.setViewTextColor(this.f28317b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f28320e.getString(R.string.select_cover_next), new e(this)), R.color.CAM_X0106);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            String[] stringArray = this.f28320e.getStringArray(R.array.edit_video_tab);
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
                fragmentTabIndicator.setText(stringArray[i2]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
                fragmentTabIndicator.setTextSize(0, this.f28320e.getDimension(R.dimen.fontsize34));
                this.k.addView(fragmentTabIndicator, i2);
            }
            if (!z() && this.k.getChildAt(1) != null) {
                this.k.getChildAt(1).setVisibility(8);
            }
            this.k.setDiverColor(this.f28320e.getColor(R.color.CAM_X0105));
            this.k.setCurrentTab(this.l, true, false);
            this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
            this.k.setDviderRectWidth(l.g(this.mContext.getPageActivity(), R.dimen.ds64));
            this.k.setTabSelectionListener(new C1318a(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f28317b = (NavigationBar) this.f28316a.findViewById(R.id.navigation_bar);
            MaskVideoView maskVideoView = (MaskVideoView) this.f28316a.findViewById(R.id.video_view);
            this.f28318c = maskVideoView;
            maskVideoView.setPreserveEGLContextOnPause(true);
            this.f28318c.setZOrderMediaOverlay(true);
            this.f28318c.setPostMonitorManager(this.o);
            FrameLayout frameLayout = (FrameLayout) this.f28316a.findViewById(R.id.edit_container);
            this.f28325j = frameLayout;
            frameLayout.addView(this.f28322g.i());
            this.k = (FragmentTabWidget) this.f28316a.findViewById(R.id.tab_widget);
            w();
            x();
            this.f28325j.addView(this.f28323h.t());
            this.f28325j.addView(this.f28324i.g());
            this.f28323h.t().setVisibility(8);
            this.f28324i.g().setVisibility(8);
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? Build.VERSION.SDK_INT >= 18 : invokeV.booleanValue;
    }
}

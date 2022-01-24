package c.a.t0.k4.i.h;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.s.s.j;
import c.a.t0.i2.g;
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
/* loaded from: classes7.dex */
public class a extends c.a.d.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f19127b;

    /* renamed from: c  reason: collision with root package name */
    public MaskVideoView f19128c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.k4.i.a f19129d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f19130e;

    /* renamed from: f  reason: collision with root package name */
    public PopupDialog f19131f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.k4.i.h.c f19132g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.k4.i.h.e f19133h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.t0.k4.i.h.d f19134i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f19135j;
    public FragmentTabWidget k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public g o;
    public j.e p;

    /* renamed from: c.a.t0.k4.i.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1181a implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19136e;

        public C1181a(a aVar) {
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
            this.f19136e = aVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                a aVar = this.f19136e;
                if (i2 == aVar.l) {
                    return;
                }
                if (i2 == 0) {
                    aVar.f19132g.i().setVisibility(0);
                    this.f19136e.f19133h.t().setVisibility(8);
                    this.f19136e.f19134i.g().setVisibility(8);
                    this.f19136e.f19132g.q(true);
                    this.f19136e.f19133h.A(false);
                    this.f19136e.f19134i.l(false);
                } else if (i2 == 1) {
                    aVar.f19134i.g().setVisibility(0);
                    this.f19136e.f19133h.t().setVisibility(8);
                    this.f19136e.f19132g.i().setVisibility(8);
                    this.f19136e.f19132g.q(false);
                    if (TextUtils.isEmpty(this.f19136e.f19133h.s())) {
                        this.f19136e.f19133h.A(false);
                    } else {
                        this.f19136e.f19133h.A(true);
                    }
                    this.f19136e.f19134i.l(true);
                } else if (i2 == 2) {
                    aVar.f19133h.t().setVisibility(0);
                    this.f19136e.f19132g.i().setVisibility(8);
                    this.f19136e.f19134i.g().setVisibility(8);
                    this.f19136e.f19132g.q(false);
                    this.f19136e.f19133h.A(true);
                    this.f19136e.f19134i.l(false);
                }
                a aVar2 = this.f19136e;
                aVar2.l = i2;
                aVar2.k.setCurrentTab(this.f19136e.l, true, true);
                this.f19136e.X();
                this.f19136e.C();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19137e;

        /* renamed from: c.a.t0.k4.i.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1182a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19138e;

            public RunnableC1182a(b bVar) {
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
                this.f19138e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f19138e.f19137e.f19132g.s();
                }
            }
        }

        /* renamed from: c.a.t0.k4.i.h.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1183b implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f19139e;

            public C1183b(b bVar) {
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
                this.f19139e = bVar;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (i2 == 3) {
                        a aVar = this.f19139e.f19137e;
                        if (aVar.l == 0) {
                            aVar.f19128c.pause();
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
            this.f19137e = aVar;
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
            this.f19137e.m = mediaPlayer;
            if (!this.f19137e.n) {
                a aVar = this.f19137e;
                if (aVar.l != 0) {
                    aVar.m.setVolume(1.0f, 1.0f);
                    c.a.d.f.m.e.a().postDelayed(new RunnableC1182a(this), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        this.f19137e.f19128c.start();
                        mediaPlayer.setOnInfoListener(new C1183b(this));
                        return;
                    }
                    this.f19137e.f19128c.seekTo(this.f19137e.f19132g.getCurrentPosition());
                    return;
                }
            }
            this.f19137e.m.setVolume(0.0f, 0.0f);
            c.a.d.f.m.e.a().postDelayed(new RunnableC1182a(this), 200L);
            if (Build.VERSION.SDK_INT < 17) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19140e;

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
            this.f19140e = aVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                a aVar = this.f19140e;
                if (aVar.l != 0) {
                    aVar.K();
                    this.f19140e.f19133h.F();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19141e;

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
            this.f19141e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19141e.W();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19142e;

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
            this.f19142e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19142e.f19132g.k();
                if (this.f19142e.f19129d != null) {
                    this.f19142e.f19129d.onNext();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19143e;

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
            this.f19143e = aVar;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) {
                if (i2 != 0) {
                    if (i2 == 1 && this.f19143e.f19129d != null) {
                        this.f19143e.f19129d.finishPage();
                    }
                } else if (this.f19143e.f19129d != null) {
                    this.f19143e.f19129d.onSave();
                }
                if (this.f19143e.f19131f == null || !this.f19143e.f19131f.isShowing() || this.f19143e.getPageContext() == null) {
                    return;
                }
                this.f19143e.f19131f.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.d.a.f fVar, c.a.t0.k4.i.a aVar, View view, g gVar) {
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
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.p = new f(this);
        this.f19129d = aVar;
        this.a = view;
        this.o = gVar;
        this.f19130e = view.getResources();
        this.f19132g = new c.a.t0.k4.i.h.c(this.mContext, this);
        this.f19133h = new c.a.t0.k4.i.h.e(this.mContext, this, this.o);
        this.f19134i = new c.a.t0.k4.i.h.d(this.mContext, this);
        this.f19132g.l(this.a);
        this.f19133h.u(this.a);
        this.f19134i.h(this.a);
        y();
        X();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public void B() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (maskVideoView = this.f19128c) == null) {
            return;
        }
        maskVideoView.doLoopSeek(this.f19132g.getCurrentPosition());
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.l == 0) {
                H();
                L();
                return;
            }
            K();
        }
    }

    public void D(c.a.d.a.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, fVar, i2) == null) {
            this.f19127b.onChangeSkinType(fVar, i2);
            this.k.onChangeSkinType(i2);
            this.k.setDiverColor(SkinManager.getColor(i2, R.color.CAM_X0105));
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            c.a.t0.k4.i.h.c cVar = this.f19132g;
            if (cVar != null) {
                cVar.n(fVar, i2);
            }
            c.a.t0.k4.i.h.e eVar = this.f19133h;
            if (eVar != null) {
                eVar.w(fVar, i2);
            }
        }
    }

    public void E(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f19133h.x(str, str2);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            H();
            this.f19132g.o();
            this.f19133h.y();
            this.f19134i.j();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f19128c.onResume();
            if (this.l != 0) {
                this.f19128c.resumeMedia();
            }
            this.f19132g.p();
            this.f19133h.z();
            this.f19134i.k();
        }
    }

    public void H() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (maskVideoView = this.f19128c) == null) {
            return;
        }
        maskVideoView.pauseMediaPlayer();
    }

    public void I() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (maskVideoView = this.f19128c) == null) {
            return;
        }
        maskVideoView.onPause();
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.t0.k4.i.h.c cVar = this.f19132g;
            if (cVar != null) {
                cVar.r();
            }
            MaskVideoView maskVideoView = this.f19128c;
            if (maskVideoView != null) {
                maskVideoView.stopPlayback();
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            H();
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                if (this.n) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
            }
            this.f19128c.start();
            this.f19128c.seekTo(0);
        }
    }

    public void L() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (maskVideoView = this.f19128c) == null) {
            return;
        }
        maskVideoView.seekTo(this.f19132g.getCurrentPosition());
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f19132g.t(str);
            this.f19128c.setVideoPath(str);
            this.f19128c.setOnPreparedListener(new b(this));
            this.f19128c.setOnCompletionListener(new c(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void N(c.a.t0.k4.i.d.a aVar) {
        c.a.t0.k4.i.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || (dVar = this.f19134i) == null) {
            return;
        }
        dVar.n(aVar);
    }

    public void O(MaskVideoView.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, fVar) == null) || fVar == null || v() == null) {
            return;
        }
        v().setGenMaskCoverListener(fVar);
    }

    public void P(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f19133h.H(list);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.n = z;
            if (this.m == null) {
                return;
            }
            K();
        }
    }

    public void R(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.f19132g.u(list);
        }
    }

    public void S(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            this.f19133h.J(intent);
        }
    }

    public void T(String str, String str2) {
        c.a.t0.k4.i.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) || (eVar = this.f19133h) == null) {
            return;
        }
        eVar.K(str, str2);
    }

    public void U(c.a.t0.k4.i.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            MaskVideoView maskVideoView = this.f19128c;
            if (maskVideoView != null) {
                maskVideoView.setFilter(aVar);
            }
            c.a.t0.k4.i.h.d dVar = this.f19134i;
            if (dVar != null) {
                dVar.m(aVar);
            }
        }
    }

    public void V(boolean z) {
        c.a.t0.k4.i.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (eVar = this.f19133h) == null) {
            return;
        }
        eVar.I(z);
        Q(!z);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).getFromType(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
                this.f19129d.finishPage();
                return;
            }
            if (this.f19131f == null) {
                String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
                PopupDialog popupDialog = new PopupDialog(getPageContext());
                this.f19131f = popupDialog;
                popupDialog.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
                this.f19131f.setDefaultContentView(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.p);
            }
            this.f19131f.showDialog();
        }
    }

    public final void X() {
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
            MaskVideoView maskVideoView = this.f19128c;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, bitmap)) == null) ? this.f19132g.g(bitmap) : (Bitmap) invokeL.objValue;
    }

    public void p() {
        c.a.t0.k4.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (aVar = this.f19129d) == null) {
            return;
        }
        aVar.clearFinalVideoPath();
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f19133h.r() : (String) invokeV.objValue;
    }

    public c.a.t0.k4.i.e.a r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            if (this.f19134i == null || m.isEmpty(str)) {
                return null;
            }
            return this.f19134i.f(str);
        }
        return (c.a.t0.k4.i.e.a) invokeL.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f19133h.s() : (String) invokeV.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f19132g.j() : (String) invokeV.objValue;
    }

    public MaskVideoView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f19128c : (MaskVideoView) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f19127b.setCenterTextTitle(this.f19130e.getString(R.string.select_cover));
            this.f19127b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            SkinManager.setViewTextColor(this.f19127b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f19130e.getString(R.string.select_cover_next), new e(this)), R.color.CAM_X0106);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            String[] stringArray = this.f19130e.getStringArray(R.array.edit_video_tab);
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
                fragmentTabIndicator.setText(stringArray[i2]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
                fragmentTabIndicator.setTextSize(0, this.f19130e.getDimension(R.dimen.fontsize34));
                this.k.addView(fragmentTabIndicator, i2);
            }
            if (!z() && this.k.getChildAt(1) != null) {
                this.k.getChildAt(1).setVisibility(8);
            }
            this.k.setDiverColor(this.f19130e.getColor(R.color.CAM_X0105));
            this.k.setCurrentTab(this.l, true, false);
            this.k.setBackGroundDrawableResId(R.color.CAM_X0201);
            this.k.setDviderRectWidth(n.f(this.mContext.getPageActivity(), R.dimen.ds64));
            this.k.setTabSelectionListener(new C1181a(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f19127b = (NavigationBar) this.a.findViewById(R.id.navigation_bar);
            MaskVideoView maskVideoView = (MaskVideoView) this.a.findViewById(R.id.video_view);
            this.f19128c = maskVideoView;
            maskVideoView.setPreserveEGLContextOnPause(true);
            this.f19128c.setZOrderMediaOverlay(true);
            this.f19128c.setPostMonitorManager(this.o);
            FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.edit_container);
            this.f19135j = frameLayout;
            frameLayout.addView(this.f19132g.i());
            this.k = (FragmentTabWidget) this.a.findViewById(R.id.tab_widget);
            w();
            x();
            this.f19135j.addView(this.f19133h.t());
            this.f19135j.addView(this.f19134i.g());
            this.f19133h.t().setVisibility(8);
            this.f19134i.g().setVisibility(8);
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? Build.VERSION.SDK_INT >= 18 : invokeV.booleanValue;
    }
}

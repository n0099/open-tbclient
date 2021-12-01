package c.a.r0.h4.i.h;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.s.s.i;
import c.a.r0.g2.g;
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
/* loaded from: classes6.dex */
public class a extends c.a.d.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f18009b;

    /* renamed from: c  reason: collision with root package name */
    public MaskVideoView f18010c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.h4.i.a f18011d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f18012e;

    /* renamed from: f  reason: collision with root package name */
    public PopupDialog f18013f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.h4.i.h.c f18014g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.h4.i.h.e f18015h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.h4.i.h.d f18016i;

    /* renamed from: j  reason: collision with root package name */
    public FrameLayout f18017j;

    /* renamed from: k  reason: collision with root package name */
    public FragmentTabWidget f18018k;
    public int l;
    public MediaPlayer m;
    public boolean n;
    public g o;
    public i.e p;

    /* renamed from: c.a.r0.h4.i.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1062a implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18019e;

        public C1062a(a aVar) {
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
            this.f18019e = aVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                a aVar = this.f18019e;
                if (i2 == aVar.l) {
                    return;
                }
                if (i2 == 0) {
                    aVar.f18014g.i().setVisibility(0);
                    this.f18019e.f18015h.t().setVisibility(8);
                    this.f18019e.f18016i.g().setVisibility(8);
                    this.f18019e.f18014g.q(true);
                    this.f18019e.f18015h.A(false);
                    this.f18019e.f18016i.l(false);
                } else if (i2 == 1) {
                    aVar.f18016i.g().setVisibility(0);
                    this.f18019e.f18015h.t().setVisibility(8);
                    this.f18019e.f18014g.i().setVisibility(8);
                    this.f18019e.f18014g.q(false);
                    if (TextUtils.isEmpty(this.f18019e.f18015h.s())) {
                        this.f18019e.f18015h.A(false);
                    } else {
                        this.f18019e.f18015h.A(true);
                    }
                    this.f18019e.f18016i.l(true);
                } else if (i2 == 2) {
                    aVar.f18015h.t().setVisibility(0);
                    this.f18019e.f18014g.i().setVisibility(8);
                    this.f18019e.f18016i.g().setVisibility(8);
                    this.f18019e.f18014g.q(false);
                    this.f18019e.f18015h.A(true);
                    this.f18019e.f18016i.l(false);
                }
                a aVar2 = this.f18019e;
                aVar2.l = i2;
                aVar2.f18018k.setCurrentTab(this.f18019e.l, true, true);
                this.f18019e.e0();
                this.f18019e.C();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18020e;

        /* renamed from: c.a.r0.h4.i.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC1063a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f18021e;

            public RunnableC1063a(b bVar) {
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
                this.f18021e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f18021e.f18020e.f18014g.s();
                }
            }
        }

        /* renamed from: c.a.r0.h4.i.h.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1064b implements MediaPlayer.OnInfoListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f18022e;

            public C1064b(b bVar) {
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
                this.f18022e = bVar;
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                    if (i2 == 3) {
                        a aVar = this.f18022e.f18020e;
                        if (aVar.l == 0) {
                            aVar.f18010c.pause();
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
            this.f18020e = aVar;
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
            this.f18020e.m = mediaPlayer;
            if (!this.f18020e.n) {
                a aVar = this.f18020e;
                if (aVar.l != 0) {
                    aVar.m.setVolume(1.0f, 1.0f);
                    c.a.d.f.m.e.a().postDelayed(new RunnableC1063a(this), 200L);
                    if (Build.VERSION.SDK_INT < 17) {
                        this.f18020e.f18010c.start();
                        mediaPlayer.setOnInfoListener(new C1064b(this));
                        return;
                    }
                    this.f18020e.f18010c.seekTo(this.f18020e.f18014g.getCurrentPosition());
                    return;
                }
            }
            this.f18020e.m.setVolume(0.0f, 0.0f);
            c.a.d.f.m.e.a().postDelayed(new RunnableC1063a(this), 200L);
            if (Build.VERSION.SDK_INT < 17) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements MediaPlayer.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18023e;

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
            this.f18023e = aVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                a aVar = this.f18023e;
                if (aVar.l != 0) {
                    aVar.O();
                    this.f18023e.f18015h.F();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18024e;

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
            this.f18024e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18024e.d0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18025e;

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
            this.f18025e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18025e.f18014g.k();
                if (this.f18025e.f18011d != null) {
                    this.f18025e.f18011d.onNext();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f18026e;

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
            this.f18026e = aVar;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 != 0) {
                    if (i2 == 1 && this.f18026e.f18011d != null) {
                        this.f18026e.f18011d.finishPage();
                    }
                } else if (this.f18026e.f18011d != null) {
                    this.f18026e.f18011d.onSave();
                }
                if (this.f18026e.f18013f == null || !this.f18026e.f18013f.isShowing() || this.f18026e.getPageContext() == null) {
                    return;
                }
                this.f18026e.f18013f.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.d.a.f fVar, c.a.r0.h4.i.a aVar, View view, g gVar) {
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
        this.f18011d = aVar;
        this.a = view;
        this.o = gVar;
        this.f18012e = view.getResources();
        this.f18014g = new c.a.r0.h4.i.h.c(this.mContext, this);
        this.f18015h = new c.a.r0.h4.i.h.e(this.mContext, this, this.o);
        this.f18016i = new c.a.r0.h4.i.h.d(this.mContext, this);
        this.f18014g.l(this.a);
        this.f18015h.u(this.a);
        this.f18016i.h(this.a);
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (maskVideoView = this.f18010c) == null) {
            return;
        }
        maskVideoView.doLoopSeek(this.f18014g.getCurrentPosition());
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.l == 0) {
                K();
                Q();
                return;
            }
            O();
        }
    }

    public void D(c.a.d.a.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, fVar, i2) == null) {
            this.f18009b.onChangeSkinType(fVar, i2);
            this.f18018k.onChangeSkinType(i2);
            this.f18018k.setDiverColor(SkinManager.getColor(i2, R.color.CAM_X0105));
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            c.a.r0.h4.i.h.c cVar = this.f18014g;
            if (cVar != null) {
                cVar.n(fVar, i2);
            }
            c.a.r0.h4.i.h.e eVar = this.f18015h;
            if (eVar != null) {
                eVar.w(fVar, i2);
            }
        }
    }

    public void E(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f18015h.x(str, str2);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            K();
            this.f18014g.o();
            this.f18015h.y();
            this.f18016i.j();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f18010c.onResume();
            if (this.l != 0) {
                this.f18010c.resumeMedia();
            }
            this.f18014g.p();
            this.f18015h.z();
            this.f18016i.k();
        }
    }

    public void K() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (maskVideoView = this.f18010c) == null) {
            return;
        }
        maskVideoView.pauseMediaPlayer();
    }

    public void L() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (maskVideoView = this.f18010c) == null) {
            return;
        }
        maskVideoView.onPause();
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c.a.r0.h4.i.h.c cVar = this.f18014g;
            if (cVar != null) {
                cVar.r();
            }
            MaskVideoView maskVideoView = this.f18010c;
            if (maskVideoView != null) {
                maskVideoView.stopPlayback();
            }
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            K();
            MediaPlayer mediaPlayer = this.m;
            if (mediaPlayer != null) {
                if (this.n) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
            }
            this.f18010c.start();
            this.f18010c.seekTo(0);
        }
    }

    public void Q() {
        MaskVideoView maskVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (maskVideoView = this.f18010c) == null) {
            return;
        }
        maskVideoView.seekTo(this.f18014g.getCurrentPosition());
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f18014g.t(str);
            this.f18010c.setVideoPath(str);
            this.f18010c.setOnPreparedListener(new b(this));
            this.f18010c.setOnCompletionListener(new c(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void T(c.a.r0.h4.i.d.a aVar) {
        c.a.r0.h4.i.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || (dVar = this.f18016i) == null) {
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
            this.f18015h.K(list);
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.n = z;
            if (this.m == null) {
                return;
            }
            O();
        }
    }

    public void Y(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.f18014g.u(list);
        }
    }

    public void Z(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, intent) == null) {
            this.f18015h.M(intent);
        }
    }

    public void a0(String str, String str2) {
        c.a.r0.h4.i.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) || (eVar = this.f18015h) == null) {
            return;
        }
        eVar.O(str, str2);
    }

    public void b0(c.a.r0.h4.i.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            MaskVideoView maskVideoView = this.f18010c;
            if (maskVideoView != null) {
                maskVideoView.setFilter(aVar);
            }
            c.a.r0.h4.i.h.d dVar = this.f18016i;
            if (dVar != null) {
                dVar.m(aVar);
            }
        }
    }

    public void c0(boolean z) {
        c.a.r0.h4.i.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (eVar = this.f18015h) == null) {
            return;
        }
        eVar.L(z);
        X(!z);
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if ((this.mContext.getPageActivity() instanceof EditVideoActivity) && StringHelper.equals(((EditVideoActivity) this.mContext.getPageActivity()).getFromType(), EditVideoActivityConfig.FROM_TYPE_WRITE_ACTIVITY_EDIT)) {
                this.f18011d.finishPage();
                return;
            }
            if (this.f18013f == null) {
                String[] strArr = {getPageContext().getString(R.string.save), getPageContext().getString(R.string.not_save)};
                PopupDialog popupDialog = new PopupDialog(getPageContext());
                this.f18013f = popupDialog;
                popupDialog.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title));
                this.f18013f.setDefaultContentView(TbadkCoreApplication.getInst().getResources().getString(R.string.save_video_title), strArr, this.p);
            }
            this.f18013f.showDialog();
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
            MaskVideoView maskVideoView = this.f18010c;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, bitmap)) == null) ? this.f18014g.g(bitmap) : (Bitmap) invokeL.objValue;
    }

    public void p() {
        c.a.r0.h4.i.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (aVar = this.f18011d) == null) {
            return;
        }
        aVar.clearFinalVideoPath();
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f18015h.r() : (String) invokeV.objValue;
    }

    public c.a.r0.h4.i.e.a r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            if (this.f18016i == null || k.isEmpty(str)) {
                return null;
            }
            return this.f18016i.f(str);
        }
        return (c.a.r0.h4.i.e.a) invokeL.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f18015h.s() : (String) invokeV.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f18014g.j() : (String) invokeV.objValue;
    }

    public MaskVideoView v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f18010c : (MaskVideoView) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f18009b.setCenterTextTitle(this.f18012e.getString(R.string.select_cover));
            this.f18009b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
            SkinManager.setViewTextColor(this.f18009b.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f18012e.getString(R.string.select_cover_next), new e(this)), R.color.CAM_X0106);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            String[] stringArray = this.f18012e.getStringArray(R.array.edit_video_tab);
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.mContext.getPageActivity());
                fragmentTabIndicator.setText(stringArray[i2]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_video_tab_title_color);
                fragmentTabIndicator.setTextSize(0, this.f18012e.getDimension(R.dimen.fontsize34));
                this.f18018k.addView(fragmentTabIndicator, i2);
            }
            if (!z() && this.f18018k.getChildAt(1) != null) {
                this.f18018k.getChildAt(1).setVisibility(8);
            }
            this.f18018k.setDiverColor(this.f18012e.getColor(R.color.CAM_X0105));
            this.f18018k.setCurrentTab(this.l, true, false);
            this.f18018k.setBackGroundDrawableResId(R.color.CAM_X0201);
            this.f18018k.setDviderRectWidth(l.f(this.mContext.getPageActivity(), R.dimen.ds64));
            this.f18018k.setTabSelectionListener(new C1062a(this));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f18009b = (NavigationBar) this.a.findViewById(R.id.navigation_bar);
            MaskVideoView maskVideoView = (MaskVideoView) this.a.findViewById(R.id.video_view);
            this.f18010c = maskVideoView;
            maskVideoView.setPreserveEGLContextOnPause(true);
            this.f18010c.setZOrderMediaOverlay(true);
            this.f18010c.setPostMonitorManager(this.o);
            FrameLayout frameLayout = (FrameLayout) this.a.findViewById(R.id.edit_container);
            this.f18017j = frameLayout;
            frameLayout.addView(this.f18014g.i());
            this.f18018k = (FragmentTabWidget) this.a.findViewById(R.id.tab_widget);
            w();
            x();
            this.f18017j.addView(this.f18015h.t());
            this.f18017j.addView(this.f18016i.g());
            this.f18015h.t().setVisibility(8);
            this.f18016i.g().setVisibility(8);
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? Build.VERSION.SDK_INT >= 18 : invokeV.booleanValue;
    }
}

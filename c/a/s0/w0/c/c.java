package c.a.s0.w0.c;

import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.s0.h2.g;
import c.a.s0.h2.k;
import c.a.s0.m4.m.e.b.a;
import c.a.s0.w0.c.d.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.music.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class c implements c.a.s0.w0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SelectMusicModel a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f25202b;

    /* renamed from: c  reason: collision with root package name */
    public int f25203c;

    /* renamed from: d  reason: collision with root package name */
    public TbMusicData f25204d;

    /* renamed from: e  reason: collision with root package name */
    public String f25205e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25206f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f25207g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f25208h;

    /* renamed from: i  reason: collision with root package name */
    public g f25209i;

    /* loaded from: classes8.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.C1197a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f25210b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f25211c;

        public a(c cVar, a.C1197a c1197a, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c1197a, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25211c = cVar;
            this.a = c1197a;
            this.f25210b = musicData;
        }

        @Override // c.a.s0.w0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a.f19842d == this.f25211c.f25203c) {
                this.f25211c.f25208h = false;
                this.a.f19840b.setVisibility(4);
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
                m.M(TbadkCoreApplication.getInst(), str);
                if (this.f25211c.f25209i != null) {
                    this.f25211c.f25209i.b(3, str);
                }
            }
        }

        @Override // c.a.s0.w0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.f19842d == this.f25211c.f25203c) {
                this.f25211c.f25208h = false;
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
                this.a.f19840b.setVisibility(4);
            }
        }

        @Override // c.a.s0.w0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.a.f19842d == this.f25211c.f25203c) {
                this.f25211c.f25208h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f25211c.n(str, this.f25210b);
                this.a.f19840b.setVisibility(4);
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MusicData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f25212b;

        public b(c cVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25212b = cVar;
            this.a = musicData;
        }

        @Override // c.a.s0.w0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                m.M(TbadkCoreApplication.getInst(), str);
                if (this.f25212b.f25209i != null) {
                    this.f25212b.f25209i.b(3, str);
                }
            }
        }

        @Override // c.a.s0.w0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.s0.w0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f25212b.n(str, this.a);
            }
        }
    }

    /* renamed from: c.a.s0.w0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1461c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25213e;

        public C1461c(c cVar) {
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
            this.f25213e = cVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f25213e.f25202b.setLooping(true);
                this.f25213e.f25202b.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f25214e;

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
            this.f25214e = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f25214e.f25209i != null) {
                    g gVar = this.f25214e.f25209i;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public c(TbPageContext tbPageContext, c.a.s0.w0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, k.class);
        k kVar = runTask != null ? (k) runTask.getData() : null;
        if (kVar != null) {
            this.f25209i = kVar.get();
        }
        this.f25207g = tbPageContext;
        this.a = new SelectMusicModel(tbPageContext, bVar);
        m();
    }

    @Override // c.a.s0.w0.c.a
    public void a(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (mediaPlayer = this.f25202b) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.f25202b.getDuration()) {
            f2 %= this.f25202b.getDuration();
        }
        this.f25202b.seekTo((int) (f2 * 1000.0f));
        this.f25202b.start();
    }

    @Override // c.a.s0.w0.c.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f25205e : (String) invokeV.objValue;
    }

    @Override // c.a.s0.w0.c.a
    public void c(MusicData musicData, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, musicData, obj) == null) || musicData == null) {
            return;
        }
        int i2 = musicData.editMusicType;
        if (i2 == 0) {
            o(obj, musicData);
        } else if (i2 == 1) {
            releasePlayer();
        } else if (i2 != 2) {
        } else {
            CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.f25207g.getPageActivity(), 25032);
            cloudMusicActivityConfig.setCurrentMusicData(this.f25204d);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
        }
    }

    @Override // c.a.s0.w0.c.a
    public void d() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (selectMusicModel = this.a) == null) {
            return;
        }
        selectMusicModel.cancelLoadData();
    }

    @Override // c.a.s0.w0.c.a
    public void e(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbMusicData) == null) {
            this.f25204d = tbMusicData;
        }
    }

    @Override // c.a.s0.w0.c.a
    public void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.f25206f = false;
            this.f25205e = str;
            n(str, null);
        }
    }

    @Override // c.a.s0.w0.c.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f25208h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.a.x();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, musicData) == null) || this.f25206f) {
            return;
        }
        if (this.f25202b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f25202b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f25205e = str;
            this.f25202b.reset();
            this.f25202b.setDataSource(str);
            this.f25202b.prepare();
            this.f25202b.setOnPreparedListener(new C1461c(this));
            this.f25202b.setOnErrorListener(new d(this));
        } catch (Exception e2) {
            e2.printStackTrace();
            p(str, musicData);
        }
    }

    public final void o(Object obj, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, obj, musicData) == null) || musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        MediaPlayer mediaPlayer = this.f25202b;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f25202b.stop();
        }
        this.f25208h = false;
        String str = musicData.id;
        String g2 = c.a.s0.w0.c.d.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof a.C1197a)) {
            this.f25203c = ((a.C1197a) obj).f19842d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof a.C1197a) {
                a.C1197a c1197a = (a.C1197a) obj;
                c1197a.f19840b.setVisibility(0);
                c1197a.a.setDrawBorder(false);
                c1197a.a.invalidate();
                this.f25208h = true;
                c.a.s0.w0.c.d.a.h().f(musicData.id, musicData.resource, new a(this, c1197a, musicData));
                return;
            }
            c.a.s0.w0.c.d.a.h().f(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        n(g2, musicData);
    }

    @Override // c.a.s0.w0.c.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f25206f = true;
            MediaPlayer mediaPlayer = this.f25202b;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f25202b.pause();
        }
    }

    @Override // c.a.s0.w0.c.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f25206f = false;
            MediaPlayer mediaPlayer = this.f25202b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f25202b.seekTo(0);
            }
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, musicData) == null) {
            this.f25205e = null;
            releasePlayer();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                c.a.s0.w0.c.d.a.h().e();
            }
            o(null, musicData);
        }
    }

    @Override // c.a.s0.w0.c.a
    public void pause() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (mediaPlayer = this.f25202b) != null && mediaPlayer.isPlaying()) {
            this.f25202b.pause();
        }
    }

    @Override // c.a.s0.w0.c.a
    public void releasePlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.f25202b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f25202b.stop();
                }
                this.f25202b.release();
                this.f25202b = null;
            }
            this.f25205e = null;
        }
    }

    @Override // c.a.s0.w0.c.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            releasePlayer();
        }
    }
}

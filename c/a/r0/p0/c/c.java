package c.a.r0.p0.c;

import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.r0.b4.l.e.b.a;
import c.a.r0.p0.c.d.a;
import c.a.r0.z1.g;
import c.a.r0.z1.k;
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
/* loaded from: classes3.dex */
public class c implements c.a.r0.p0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SelectMusicModel f23454a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f23455b;

    /* renamed from: c  reason: collision with root package name */
    public int f23456c;

    /* renamed from: d  reason: collision with root package name */
    public TbMusicData f23457d;

    /* renamed from: e  reason: collision with root package name */
    public String f23458e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23459f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f23460g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23461h;

    /* renamed from: i  reason: collision with root package name */
    public g f23462i;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0785a f23463a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f23464b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f23465c;

        public a(c cVar, a.C0785a c0785a, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c0785a, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23465c = cVar;
            this.f23463a = c0785a;
            this.f23464b = musicData;
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f23463a.f16393d == this.f23465c.f23456c) {
                this.f23465c.f23461h = false;
                this.f23463a.f16391b.setVisibility(4);
                this.f23463a.f16390a.setDrawBorder(true);
                this.f23463a.f16390a.invalidate();
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f23465c.f23462i != null) {
                    this.f23465c.f23462i.b(3, str);
                }
            }
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f23463a.f16393d == this.f23465c.f23456c) {
                this.f23465c.f23461h = false;
                this.f23463a.f16390a.setDrawBorder(true);
                this.f23463a.f16390a.invalidate();
                this.f23463a.f16391b.setVisibility(4);
            }
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f23463a.f16393d == this.f23465c.f23456c) {
                this.f23465c.f23461h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f23465c.n(str, this.f23464b);
                this.f23463a.f16391b.setVisibility(4);
                this.f23463a.f16390a.setDrawBorder(true);
                this.f23463a.f16390a.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f23466a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f23467b;

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
            this.f23467b = cVar;
            this.f23466a = musicData;
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f23467b.f23462i != null) {
                    this.f23467b.f23462i.b(3, str);
                }
            }
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f23467b.n(str, this.f23466a);
            }
        }
    }

    /* renamed from: c.a.r0.p0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1095c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23468e;

        public C1095c(c cVar) {
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
            this.f23468e = cVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f23468e.f23455b.setLooping(true);
                this.f23468e.f23455b.start();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23469e;

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
            this.f23469e = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f23469e.f23462i != null) {
                    g gVar = this.f23469e.f23462i;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public c(TbPageContext tbPageContext, c.a.r0.p0.c.b bVar) {
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
            this.f23462i = kVar.get();
        }
        this.f23460g = tbPageContext;
        this.f23454a = new SelectMusicModel(tbPageContext, bVar);
        m();
    }

    @Override // c.a.r0.p0.c.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23458e : (String) invokeV.objValue;
    }

    @Override // c.a.r0.p0.c.a
    public void b(MusicData musicData, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, musicData, obj) == null) || musicData == null) {
            return;
        }
        int i2 = musicData.editMusicType;
        if (i2 == 0) {
            o(obj, musicData);
        } else if (i2 == 1) {
            releasePlayer();
        } else if (i2 != 2) {
        } else {
            CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.f23460g.getPageActivity(), 25032);
            cloudMusicActivityConfig.setCurrentMusicData(this.f23457d);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
        }
    }

    @Override // c.a.r0.p0.c.a
    public void c() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (selectMusicModel = this.f23454a) == null) {
            return;
        }
        selectMusicModel.cancelLoadData();
    }

    @Override // c.a.r0.p0.c.a
    public void d(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbMusicData) == null) {
            this.f23457d = tbMusicData;
        }
    }

    @Override // c.a.r0.p0.c.a
    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f23459f = false;
            this.f23458e = str;
            n(str, null);
        }
    }

    @Override // c.a.r0.p0.c.a
    public void f(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f2) == null) || (mediaPlayer = this.f23455b) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.f23455b.getDuration()) {
            f2 %= this.f23455b.getDuration();
        }
        this.f23455b.seekTo((int) (f2 * 1000.0f));
        this.f23455b.start();
    }

    @Override // c.a.r0.p0.c.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23461h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f23454a.x();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, musicData) == null) || this.f23459f) {
            return;
        }
        if (this.f23455b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f23455b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f23458e = str;
            this.f23455b.reset();
            this.f23455b.setDataSource(str);
            this.f23455b.prepare();
            this.f23455b.setOnPreparedListener(new C1095c(this));
            this.f23455b.setOnErrorListener(new d(this));
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
        MediaPlayer mediaPlayer = this.f23455b;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f23455b.stop();
        }
        this.f23461h = false;
        String str = musicData.id;
        String g2 = c.a.r0.p0.c.d.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof a.C0785a)) {
            this.f23456c = ((a.C0785a) obj).f16393d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof a.C0785a) {
                a.C0785a c0785a = (a.C0785a) obj;
                c0785a.f16391b.setVisibility(0);
                c0785a.f16390a.setDrawBorder(false);
                c0785a.f16390a.invalidate();
                this.f23461h = true;
                c.a.r0.p0.c.d.a.h().f(musicData.id, musicData.resource, new a(this, c0785a, musicData));
                return;
            }
            c.a.r0.p0.c.d.a.h().f(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        n(g2, musicData);
    }

    @Override // c.a.r0.p0.c.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f23459f = true;
            MediaPlayer mediaPlayer = this.f23455b;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f23455b.pause();
        }
    }

    @Override // c.a.r0.p0.c.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f23459f = false;
            MediaPlayer mediaPlayer = this.f23455b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f23455b.seekTo(0);
            }
        }
    }

    @Override // c.a.r0.p0.c.a
    public void onStopRecord() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (mediaPlayer = this.f23455b) != null && mediaPlayer.isPlaying()) {
            this.f23455b.pause();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f23458e = null;
            releasePlayer();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                c.a.r0.p0.c.d.a.h().e();
            }
            o(null, musicData);
        }
    }

    @Override // c.a.r0.p0.c.a
    public void releasePlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.f23455b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f23455b.stop();
                }
                this.f23455b.release();
                this.f23455b = null;
            }
            this.f23458e = null;
        }
    }

    @Override // c.a.r0.p0.c.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            releasePlayer();
        }
    }
}

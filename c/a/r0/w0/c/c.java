package c.a.r0.w0.c;

import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.r0.j2.g;
import c.a.r0.j2.k;
import c.a.r0.o4.m.e.b.a;
import c.a.r0.w0.c.d.a;
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
public class c implements c.a.r0.w0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SelectMusicModel a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f24361b;

    /* renamed from: c  reason: collision with root package name */
    public int f24362c;

    /* renamed from: d  reason: collision with root package name */
    public TbMusicData f24363d;

    /* renamed from: e  reason: collision with root package name */
    public String f24364e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24365f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f24366g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24367h;

    /* renamed from: i  reason: collision with root package name */
    public g f24368i;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.C1293a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f24369b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f24370c;

        public a(c cVar, a.C1293a c1293a, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c1293a, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24370c = cVar;
            this.a = c1293a;
            this.f24369b = musicData;
        }

        @Override // c.a.r0.w0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a.f20651d == this.f24370c.f24362c) {
                this.f24370c.f24367h = false;
                this.a.f20649b.setVisibility(4);
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
                n.N(TbadkCoreApplication.getInst(), str);
                if (this.f24370c.f24368i != null) {
                    this.f24370c.f24368i.b(3, str);
                }
            }
        }

        @Override // c.a.r0.w0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.f20651d == this.f24370c.f24362c) {
                this.f24370c.f24367h = false;
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
                this.a.f20649b.setVisibility(4);
            }
        }

        @Override // c.a.r0.w0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.a.f20651d == this.f24370c.f24362c) {
                this.f24370c.f24367h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f24370c.n(str, this.f24369b);
                this.a.f20649b.setVisibility(4);
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MusicData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f24371b;

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
            this.f24371b = cVar;
            this.a = musicData;
        }

        @Override // c.a.r0.w0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                n.N(TbadkCoreApplication.getInst(), str);
                if (this.f24371b.f24368i != null) {
                    this.f24371b.f24368i.b(3, str);
                }
            }
        }

        @Override // c.a.r0.w0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.w0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f24371b.n(str, this.a);
            }
        }
    }

    /* renamed from: c.a.r0.w0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1498c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24372e;

        public C1498c(c cVar) {
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
            this.f24372e = cVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f24372e.f24361b.setLooping(true);
                this.f24372e.f24361b.start();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24373e;

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
            this.f24373e = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f24373e.f24368i != null) {
                    g gVar = this.f24373e.f24368i;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public c(TbPageContext tbPageContext, c.a.r0.w0.c.b bVar) {
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
            this.f24368i = kVar.get();
        }
        this.f24366g = tbPageContext;
        this.a = new SelectMusicModel(tbPageContext, bVar);
        m();
    }

    @Override // c.a.r0.w0.c.a
    public void a(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (mediaPlayer = this.f24361b) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.f24361b.getDuration()) {
            f2 %= this.f24361b.getDuration();
        }
        this.f24361b.seekTo((int) (f2 * 1000.0f));
        this.f24361b.start();
    }

    @Override // c.a.r0.w0.c.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24364e : (String) invokeV.objValue;
    }

    @Override // c.a.r0.w0.c.a
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
            CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.f24366g.getPageActivity(), 25032);
            cloudMusicActivityConfig.setCurrentMusicData(this.f24363d);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
        }
    }

    @Override // c.a.r0.w0.c.a
    public void d() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (selectMusicModel = this.a) == null) {
            return;
        }
        selectMusicModel.cancelLoadData();
    }

    @Override // c.a.r0.w0.c.a
    public void e(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbMusicData) == null) {
            this.f24363d = tbMusicData;
        }
    }

    @Override // c.a.r0.w0.c.a
    public void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.f24365f = false;
            this.f24364e = str;
            n(str, null);
        }
    }

    @Override // c.a.r0.w0.c.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f24367h : invokeV.booleanValue;
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
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, musicData) == null) || this.f24365f) {
            return;
        }
        if (this.f24361b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f24361b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f24364e = str;
            this.f24361b.reset();
            this.f24361b.setDataSource(str);
            this.f24361b.prepare();
            this.f24361b.setOnPreparedListener(new C1498c(this));
            this.f24361b.setOnErrorListener(new d(this));
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
        MediaPlayer mediaPlayer = this.f24361b;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f24361b.stop();
        }
        this.f24367h = false;
        String str = musicData.id;
        String g2 = c.a.r0.w0.c.d.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof a.C1293a)) {
            this.f24362c = ((a.C1293a) obj).f20651d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof a.C1293a) {
                a.C1293a c1293a = (a.C1293a) obj;
                c1293a.f20649b.setVisibility(0);
                c1293a.a.setDrawBorder(false);
                c1293a.a.invalidate();
                this.f24367h = true;
                c.a.r0.w0.c.d.a.h().f(musicData.id, musicData.resource, new a(this, c1293a, musicData));
                return;
            }
            c.a.r0.w0.c.d.a.h().f(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        n(g2, musicData);
    }

    @Override // c.a.r0.w0.c.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f24365f = true;
            MediaPlayer mediaPlayer = this.f24361b;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f24361b.pause();
        }
    }

    @Override // c.a.r0.w0.c.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f24365f = false;
            MediaPlayer mediaPlayer = this.f24361b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f24361b.seekTo(0);
            }
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, musicData) == null) {
            this.f24364e = null;
            releasePlayer();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                c.a.r0.w0.c.d.a.h().e();
            }
            o(null, musicData);
        }
    }

    @Override // c.a.r0.w0.c.a
    public void pause() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (mediaPlayer = this.f24361b) != null && mediaPlayer.isPlaying()) {
            this.f24361b.pause();
        }
    }

    @Override // c.a.r0.w0.c.a
    public void releasePlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.f24361b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f24361b.stop();
                }
                this.f24361b.release();
                this.f24361b = null;
            }
            this.f24364e = null;
        }
    }

    @Override // c.a.r0.w0.c.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            releasePlayer();
        }
    }
}

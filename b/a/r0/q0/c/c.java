package b.a.r0.q0.c;

import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.l;
import b.a.r0.a2.g;
import b.a.r0.a2.k;
import b.a.r0.d4.l.e.b.a;
import b.a.r0.q0.c.d.a;
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
/* loaded from: classes5.dex */
public class c implements b.a.r0.q0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SelectMusicModel f24059a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f24060b;

    /* renamed from: c  reason: collision with root package name */
    public int f24061c;

    /* renamed from: d  reason: collision with root package name */
    public TbMusicData f24062d;

    /* renamed from: e  reason: collision with root package name */
    public String f24063e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f24064f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f24065g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24066h;

    /* renamed from: i  reason: collision with root package name */
    public g f24067i;

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0863a f24068a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f24069b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f24070c;

        public a(c cVar, a.C0863a c0863a, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c0863a, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24070c = cVar;
            this.f24068a = c0863a;
            this.f24069b = musicData;
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f24068a.f17207d == this.f24070c.f24061c) {
                this.f24070c.f24066h = false;
                this.f24068a.f17205b.setVisibility(4);
                this.f24068a.f17204a.setDrawBorder(true);
                this.f24068a.f17204a.invalidate();
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f24070c.f24067i != null) {
                    this.f24070c.f24067i.b(3, str);
                }
            }
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f24068a.f17207d == this.f24070c.f24061c) {
                this.f24070c.f24066h = false;
                this.f24068a.f17204a.setDrawBorder(true);
                this.f24068a.f17204a.invalidate();
                this.f24068a.f17205b.setVisibility(4);
            }
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f24068a.f17207d == this.f24070c.f24061c) {
                this.f24070c.f24066h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f24070c.n(str, this.f24069b);
                this.f24068a.f17205b.setVisibility(4);
                this.f24068a.f17204a.setDrawBorder(true);
                this.f24068a.f17204a.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f24071a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f24072b;

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
            this.f24072b = cVar;
            this.f24071a = musicData;
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f24072b.f24067i != null) {
                    this.f24072b.f24067i.b(3, str);
                }
            }
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f24072b.n(str, this.f24071a);
            }
        }
    }

    /* renamed from: b.a.r0.q0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1169c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24073e;

        public C1169c(c cVar) {
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
            this.f24073e = cVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f24073e.f24060b.setLooping(true);
                this.f24073e.f24060b.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f24074e;

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
            this.f24074e = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f24074e.f24067i != null) {
                    g gVar = this.f24074e.f24067i;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public c(TbPageContext tbPageContext, b.a.r0.q0.c.b bVar) {
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
            this.f24067i = kVar.get();
        }
        this.f24065g = tbPageContext;
        this.f24059a = new SelectMusicModel(tbPageContext, bVar);
        m();
    }

    @Override // b.a.r0.q0.c.a
    public void a(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (mediaPlayer = this.f24060b) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.f24060b.getDuration()) {
            f2 %= this.f24060b.getDuration();
        }
        this.f24060b.seekTo((int) (f2 * 1000.0f));
        this.f24060b.start();
    }

    @Override // b.a.r0.q0.c.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f24063e : (String) invokeV.objValue;
    }

    @Override // b.a.r0.q0.c.a
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
            CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.f24065g.getPageActivity(), 25032);
            cloudMusicActivityConfig.setCurrentMusicData(this.f24062d);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
        }
    }

    @Override // b.a.r0.q0.c.a
    public void d() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (selectMusicModel = this.f24059a) == null) {
            return;
        }
        selectMusicModel.cancelLoadData();
    }

    @Override // b.a.r0.q0.c.a
    public void e(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbMusicData) == null) {
            this.f24062d = tbMusicData;
        }
    }

    @Override // b.a.r0.q0.c.a
    public void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.f24064f = false;
            this.f24063e = str;
            n(str, null);
        }
    }

    @Override // b.a.r0.q0.c.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f24066h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f24059a.x();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, musicData) == null) || this.f24064f) {
            return;
        }
        if (this.f24060b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f24060b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f24063e = str;
            this.f24060b.reset();
            this.f24060b.setDataSource(str);
            this.f24060b.prepare();
            this.f24060b.setOnPreparedListener(new C1169c(this));
            this.f24060b.setOnErrorListener(new d(this));
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
        MediaPlayer mediaPlayer = this.f24060b;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f24060b.stop();
        }
        this.f24066h = false;
        String str = musicData.id;
        String g2 = b.a.r0.q0.c.d.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof a.C0863a)) {
            this.f24061c = ((a.C0863a) obj).f17207d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof a.C0863a) {
                a.C0863a c0863a = (a.C0863a) obj;
                c0863a.f17205b.setVisibility(0);
                c0863a.f17204a.setDrawBorder(false);
                c0863a.f17204a.invalidate();
                this.f24066h = true;
                b.a.r0.q0.c.d.a.h().f(musicData.id, musicData.resource, new a(this, c0863a, musicData));
                return;
            }
            b.a.r0.q0.c.d.a.h().f(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        n(g2, musicData);
    }

    @Override // b.a.r0.q0.c.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f24064f = true;
            MediaPlayer mediaPlayer = this.f24060b;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f24060b.pause();
        }
    }

    @Override // b.a.r0.q0.c.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f24064f = false;
            MediaPlayer mediaPlayer = this.f24060b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f24060b.seekTo(0);
            }
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, musicData) == null) {
            this.f24063e = null;
            releasePlayer();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                b.a.r0.q0.c.d.a.h().e();
            }
            o(null, musicData);
        }
    }

    @Override // b.a.r0.q0.c.a
    public void pause() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (mediaPlayer = this.f24060b) != null && mediaPlayer.isPlaying()) {
            this.f24060b.pause();
        }
    }

    @Override // b.a.r0.q0.c.a
    public void releasePlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.f24060b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f24060b.stop();
                }
                this.f24060b.release();
                this.f24060b = null;
            }
            this.f24063e = null;
        }
    }

    @Override // b.a.r0.q0.c.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            releasePlayer();
        }
    }
}

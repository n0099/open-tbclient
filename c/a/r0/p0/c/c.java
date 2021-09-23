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
    public SelectMusicModel f23470a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f23471b;

    /* renamed from: c  reason: collision with root package name */
    public int f23472c;

    /* renamed from: d  reason: collision with root package name */
    public TbMusicData f23473d;

    /* renamed from: e  reason: collision with root package name */
    public String f23474e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23475f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f23476g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23477h;

    /* renamed from: i  reason: collision with root package name */
    public g f23478i;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0783a f23479a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f23480b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f23481c;

        public a(c cVar, a.C0783a c0783a, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c0783a, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23481c = cVar;
            this.f23479a = c0783a;
            this.f23480b = musicData;
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f23479a.f16403d == this.f23481c.f23472c) {
                this.f23481c.f23477h = false;
                this.f23479a.f16401b.setVisibility(4);
                this.f23479a.f16400a.setDrawBorder(true);
                this.f23479a.f16400a.invalidate();
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f23481c.f23478i != null) {
                    this.f23481c.f23478i.b(3, str);
                }
            }
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f23479a.f16403d == this.f23481c.f23472c) {
                this.f23481c.f23477h = false;
                this.f23479a.f16400a.setDrawBorder(true);
                this.f23479a.f16400a.invalidate();
                this.f23479a.f16401b.setVisibility(4);
            }
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f23479a.f16403d == this.f23481c.f23472c) {
                this.f23481c.f23477h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f23481c.n(str, this.f23480b);
                this.f23479a.f16401b.setVisibility(4);
                this.f23479a.f16400a.setDrawBorder(true);
                this.f23479a.f16400a.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f23482a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f23483b;

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
            this.f23483b = cVar;
            this.f23482a = musicData;
        }

        @Override // c.a.r0.p0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f23483b.f23478i != null) {
                    this.f23483b.f23478i.b(3, str);
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
                this.f23483b.n(str, this.f23482a);
            }
        }
    }

    /* renamed from: c.a.r0.p0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1093c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23484e;

        public C1093c(c cVar) {
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
            this.f23484e = cVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f23484e.f23471b.setLooping(true);
                this.f23484e.f23471b.start();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f23485e;

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
            this.f23485e = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f23485e.f23478i != null) {
                    g gVar = this.f23485e.f23478i;
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
            this.f23478i = kVar.get();
        }
        this.f23476g = tbPageContext;
        this.f23470a = new SelectMusicModel(tbPageContext, bVar);
        m();
    }

    @Override // c.a.r0.p0.c.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f23474e : (String) invokeV.objValue;
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
            CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.f23476g.getPageActivity(), 25032);
            cloudMusicActivityConfig.setCurrentMusicData(this.f23473d);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
        }
    }

    @Override // c.a.r0.p0.c.a
    public void c() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (selectMusicModel = this.f23470a) == null) {
            return;
        }
        selectMusicModel.cancelLoadData();
    }

    @Override // c.a.r0.p0.c.a
    public void d(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbMusicData) == null) {
            this.f23473d = tbMusicData;
        }
    }

    @Override // c.a.r0.p0.c.a
    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f23475f = false;
            this.f23474e = str;
            n(str, null);
        }
    }

    @Override // c.a.r0.p0.c.a
    public void f(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f2) == null) || (mediaPlayer = this.f23471b) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.f23471b.getDuration()) {
            f2 %= this.f23471b.getDuration();
        }
        this.f23471b.seekTo((int) (f2 * 1000.0f));
        this.f23471b.start();
    }

    @Override // c.a.r0.p0.c.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23477h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f23470a.x();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, musicData) == null) || this.f23475f) {
            return;
        }
        if (this.f23471b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f23471b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f23474e = str;
            this.f23471b.reset();
            this.f23471b.setDataSource(str);
            this.f23471b.prepare();
            this.f23471b.setOnPreparedListener(new C1093c(this));
            this.f23471b.setOnErrorListener(new d(this));
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
        MediaPlayer mediaPlayer = this.f23471b;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f23471b.stop();
        }
        this.f23477h = false;
        String str = musicData.id;
        String g2 = c.a.r0.p0.c.d.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof a.C0783a)) {
            this.f23472c = ((a.C0783a) obj).f16403d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof a.C0783a) {
                a.C0783a c0783a = (a.C0783a) obj;
                c0783a.f16401b.setVisibility(0);
                c0783a.f16400a.setDrawBorder(false);
                c0783a.f16400a.invalidate();
                this.f23477h = true;
                c.a.r0.p0.c.d.a.h().f(musicData.id, musicData.resource, new a(this, c0783a, musicData));
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
            this.f23475f = true;
            MediaPlayer mediaPlayer = this.f23471b;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f23471b.pause();
        }
    }

    @Override // c.a.r0.p0.c.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f23475f = false;
            MediaPlayer mediaPlayer = this.f23471b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f23471b.seekTo(0);
            }
        }
    }

    @Override // c.a.r0.p0.c.a
    public void onStopRecord() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (mediaPlayer = this.f23471b) != null && mediaPlayer.isPlaying()) {
            this.f23471b.pause();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f23474e = null;
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
            MediaPlayer mediaPlayer = this.f23471b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f23471b.stop();
                }
                this.f23471b.release();
                this.f23471b = null;
            }
            this.f23474e = null;
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

package b.a.r0.q0.c;

import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.r0.a2.g;
import b.a.r0.a2.k;
import b.a.r0.c4.l.e.b.a;
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
    public SelectMusicModel f22538a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f22539b;

    /* renamed from: c  reason: collision with root package name */
    public int f22540c;

    /* renamed from: d  reason: collision with root package name */
    public TbMusicData f22541d;

    /* renamed from: e  reason: collision with root package name */
    public String f22542e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22543f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f22544g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22545h;

    /* renamed from: i  reason: collision with root package name */
    public g f22546i;

    /* loaded from: classes5.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0786a f22547a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f22548b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f22549c;

        public a(c cVar, a.C0786a c0786a, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c0786a, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22549c = cVar;
            this.f22547a = c0786a;
            this.f22548b = musicData;
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f22547a.f15575d == this.f22549c.f22540c) {
                this.f22549c.f22545h = false;
                this.f22547a.f15573b.setVisibility(4);
                this.f22547a.f15572a.setDrawBorder(true);
                this.f22547a.f15572a.invalidate();
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f22549c.f22546i != null) {
                    this.f22549c.f22546i.b(3, str);
                }
            }
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f22547a.f15575d == this.f22549c.f22540c) {
                this.f22549c.f22545h = false;
                this.f22547a.f15572a.setDrawBorder(true);
                this.f22547a.f15572a.invalidate();
                this.f22547a.f15573b.setVisibility(4);
            }
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f22547a.f15575d == this.f22549c.f22540c) {
                this.f22549c.f22545h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f22549c.n(str, this.f22548b);
                this.f22547a.f15573b.setVisibility(4);
                this.f22547a.f15572a.setDrawBorder(true);
                this.f22547a.f15572a.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f22550a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f22551b;

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
            this.f22551b = cVar;
            this.f22550a = musicData;
        }

        @Override // b.a.r0.q0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f22551b.f22546i != null) {
                    this.f22551b.f22546i.b(3, str);
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
                this.f22551b.n(str, this.f22550a);
            }
        }
    }

    /* renamed from: b.a.r0.q0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1102c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22552e;

        public C1102c(c cVar) {
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
            this.f22552e = cVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f22552e.f22539b.setLooping(true);
                this.f22552e.f22539b.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22553e;

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
            this.f22553e = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f22553e.f22546i != null) {
                    g gVar = this.f22553e.f22546i;
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
            this.f22546i = kVar.get();
        }
        this.f22544g = tbPageContext;
        this.f22538a = new SelectMusicModel(tbPageContext, bVar);
        m();
    }

    @Override // b.a.r0.q0.c.a
    public void a(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (mediaPlayer = this.f22539b) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.f22539b.getDuration()) {
            f2 %= this.f22539b.getDuration();
        }
        this.f22539b.seekTo((int) (f2 * 1000.0f));
        this.f22539b.start();
    }

    @Override // b.a.r0.q0.c.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22542e : (String) invokeV.objValue;
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
            CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.f22544g.getPageActivity(), 25032);
            cloudMusicActivityConfig.setCurrentMusicData(this.f22541d);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
        }
    }

    @Override // b.a.r0.q0.c.a
    public void d() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (selectMusicModel = this.f22538a) == null) {
            return;
        }
        selectMusicModel.cancelLoadData();
    }

    @Override // b.a.r0.q0.c.a
    public void e(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbMusicData) == null) {
            this.f22541d = tbMusicData;
        }
    }

    @Override // b.a.r0.q0.c.a
    public void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            this.f22543f = false;
            this.f22542e = str;
            n(str, null);
        }
    }

    @Override // b.a.r0.q0.c.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22545h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f22538a.x();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, musicData) == null) || this.f22543f) {
            return;
        }
        if (this.f22539b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f22539b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f22542e = str;
            this.f22539b.reset();
            this.f22539b.setDataSource(str);
            this.f22539b.prepare();
            this.f22539b.setOnPreparedListener(new C1102c(this));
            this.f22539b.setOnErrorListener(new d(this));
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
        MediaPlayer mediaPlayer = this.f22539b;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f22539b.stop();
        }
        this.f22545h = false;
        String str = musicData.id;
        String g2 = b.a.r0.q0.c.d.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof a.C0786a)) {
            this.f22540c = ((a.C0786a) obj).f15575d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof a.C0786a) {
                a.C0786a c0786a = (a.C0786a) obj;
                c0786a.f15573b.setVisibility(0);
                c0786a.f15572a.setDrawBorder(false);
                c0786a.f15572a.invalidate();
                this.f22545h = true;
                b.a.r0.q0.c.d.a.h().f(musicData.id, musicData.resource, new a(this, c0786a, musicData));
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
            this.f22543f = true;
            MediaPlayer mediaPlayer = this.f22539b;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f22539b.pause();
        }
    }

    @Override // b.a.r0.q0.c.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f22543f = false;
            MediaPlayer mediaPlayer = this.f22539b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f22539b.seekTo(0);
            }
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, musicData) == null) {
            this.f22542e = null;
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
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (mediaPlayer = this.f22539b) != null && mediaPlayer.isPlaying()) {
            this.f22539b.pause();
        }
    }

    @Override // b.a.r0.q0.c.a
    public void releasePlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.f22539b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f22539b.stop();
                }
                this.f22539b.release();
                this.f22539b = null;
            }
            this.f22542e = null;
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

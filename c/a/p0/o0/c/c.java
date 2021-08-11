package c.a.p0.o0.c;

import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.a4.l.e.b.a;
import c.a.p0.o0.c.d.a;
import c.a.p0.y1.g;
import c.a.p0.y1.k;
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
public class c implements c.a.p0.o0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SelectMusicModel f22532a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f22533b;

    /* renamed from: c  reason: collision with root package name */
    public int f22534c;

    /* renamed from: d  reason: collision with root package name */
    public TbMusicData f22535d;

    /* renamed from: e  reason: collision with root package name */
    public String f22536e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22537f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f22538g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22539h;

    /* renamed from: i  reason: collision with root package name */
    public g f22540i;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0739a f22541a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f22542b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f22543c;

        public a(c cVar, a.C0739a c0739a, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c0739a, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22543c = cVar;
            this.f22541a = c0739a;
            this.f22542b = musicData;
        }

        @Override // c.a.p0.o0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f22541a.f15574d == this.f22543c.f22534c) {
                this.f22543c.f22539h = false;
                this.f22541a.f15572b.setVisibility(4);
                this.f22541a.f15571a.setDrawBorder(true);
                this.f22541a.f15571a.invalidate();
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f22543c.f22540i != null) {
                    this.f22543c.f22540i.b(3, str);
                }
            }
        }

        @Override // c.a.p0.o0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f22541a.f15574d == this.f22543c.f22534c) {
                this.f22543c.f22539h = false;
                this.f22541a.f15571a.setDrawBorder(true);
                this.f22541a.f15571a.invalidate();
                this.f22541a.f15572b.setVisibility(4);
            }
        }

        @Override // c.a.p0.o0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f22541a.f15574d == this.f22543c.f22534c) {
                this.f22543c.f22539h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f22543c.n(str, this.f22542b);
                this.f22541a.f15572b.setVisibility(4);
                this.f22541a.f15571a.setDrawBorder(true);
                this.f22541a.f15571a.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f22544a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f22545b;

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
            this.f22545b = cVar;
            this.f22544a = musicData;
        }

        @Override // c.a.p0.o0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f22545b.f22540i != null) {
                    this.f22545b.f22540i.b(3, str);
                }
            }
        }

        @Override // c.a.p0.o0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.p0.o0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f22545b.n(str, this.f22544a);
            }
        }
    }

    /* renamed from: c.a.p0.o0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1049c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22546e;

        public C1049c(c cVar) {
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
            this.f22546e = cVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f22546e.f22533b.setLooping(true);
                this.f22546e.f22533b.start();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22547e;

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
            this.f22547e = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f22547e.f22540i != null) {
                    g gVar = this.f22547e.f22540i;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public c(TbPageContext tbPageContext, c.a.p0.o0.c.b bVar) {
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
            this.f22540i = kVar.get();
        }
        this.f22538g = tbPageContext;
        this.f22532a = new SelectMusicModel(tbPageContext, bVar);
        m();
    }

    @Override // c.a.p0.o0.c.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22536e : (String) invokeV.objValue;
    }

    @Override // c.a.p0.o0.c.a
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
            CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.f22538g.getPageActivity(), 25032);
            cloudMusicActivityConfig.setCurrentMusicData(this.f22535d);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
        }
    }

    @Override // c.a.p0.o0.c.a
    public void c() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (selectMusicModel = this.f22532a) == null) {
            return;
        }
        selectMusicModel.cancelLoadData();
    }

    @Override // c.a.p0.o0.c.a
    public void d(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbMusicData) == null) {
            this.f22535d = tbMusicData;
        }
    }

    @Override // c.a.p0.o0.c.a
    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f22537f = false;
            this.f22536e = str;
            n(str, null);
        }
    }

    @Override // c.a.p0.o0.c.a
    public void f(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f2) == null) || (mediaPlayer = this.f22533b) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.f22533b.getDuration()) {
            f2 %= this.f22533b.getDuration();
        }
        this.f22533b.seekTo((int) (f2 * 1000.0f));
        this.f22533b.start();
    }

    @Override // c.a.p0.o0.c.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22539h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f22532a.x();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, musicData) == null) || this.f22537f) {
            return;
        }
        if (this.f22533b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f22533b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f22536e = str;
            this.f22533b.reset();
            this.f22533b.setDataSource(str);
            this.f22533b.prepare();
            this.f22533b.setOnPreparedListener(new C1049c(this));
            this.f22533b.setOnErrorListener(new d(this));
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
        MediaPlayer mediaPlayer = this.f22533b;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f22533b.stop();
        }
        this.f22539h = false;
        String str = musicData.id;
        String g2 = c.a.p0.o0.c.d.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof a.C0739a)) {
            this.f22534c = ((a.C0739a) obj).f15574d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof a.C0739a) {
                a.C0739a c0739a = (a.C0739a) obj;
                c0739a.f15572b.setVisibility(0);
                c0739a.f15571a.setDrawBorder(false);
                c0739a.f15571a.invalidate();
                this.f22539h = true;
                c.a.p0.o0.c.d.a.h().f(musicData.id, musicData.resource, new a(this, c0739a, musicData));
                return;
            }
            c.a.p0.o0.c.d.a.h().f(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        n(g2, musicData);
    }

    @Override // c.a.p0.o0.c.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f22537f = true;
            MediaPlayer mediaPlayer = this.f22533b;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f22533b.pause();
        }
    }

    @Override // c.a.p0.o0.c.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f22537f = false;
            MediaPlayer mediaPlayer = this.f22533b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f22533b.seekTo(0);
            }
        }
    }

    @Override // c.a.p0.o0.c.a
    public void onStopRecord() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (mediaPlayer = this.f22533b) != null && mediaPlayer.isPlaying()) {
            this.f22533b.pause();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f22536e = null;
            releasePlayer();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                c.a.p0.o0.c.d.a.h().e();
            }
            o(null, musicData);
        }
    }

    @Override // c.a.p0.o0.c.a
    public void releasePlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.f22533b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f22533b.stop();
                }
                this.f22533b.release();
                this.f22533b = null;
            }
            this.f22536e = null;
        }
    }

    @Override // c.a.p0.o0.c.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            releasePlayer();
        }
    }
}

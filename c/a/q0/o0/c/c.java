package c.a.q0.o0.c;

import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.q0.a4.l.e.b.a;
import c.a.q0.o0.c.d.a;
import c.a.q0.y1.g;
import c.a.q0.y1.k;
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
public class c implements c.a.q0.o0.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SelectMusicModel f22864a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f22865b;

    /* renamed from: c  reason: collision with root package name */
    public int f22866c;

    /* renamed from: d  reason: collision with root package name */
    public TbMusicData f22867d;

    /* renamed from: e  reason: collision with root package name */
    public String f22868e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22869f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f22870g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f22871h;

    /* renamed from: i  reason: collision with root package name */
    public g f22872i;

    /* loaded from: classes3.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.C0749a f22873a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f22874b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f22875c;

        public a(c cVar, a.C0749a c0749a, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, c0749a, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22875c = cVar;
            this.f22873a = c0749a;
            this.f22874b = musicData;
        }

        @Override // c.a.q0.o0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f22873a.f15860d == this.f22875c.f22866c) {
                this.f22875c.f22871h = false;
                this.f22873a.f15858b.setVisibility(4);
                this.f22873a.f15857a.setDrawBorder(true);
                this.f22873a.f15857a.invalidate();
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f22875c.f22872i != null) {
                    this.f22875c.f22872i.b(3, str);
                }
            }
        }

        @Override // c.a.q0.o0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f22873a.f15860d == this.f22875c.f22866c) {
                this.f22875c.f22871h = false;
                this.f22873a.f15857a.setDrawBorder(true);
                this.f22873a.f15857a.invalidate();
                this.f22873a.f15858b.setVisibility(4);
            }
        }

        @Override // c.a.q0.o0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f22873a.f15860d == this.f22875c.f22866c) {
                this.f22875c.f22871h = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f22875c.n(str, this.f22874b);
                this.f22873a.f15858b.setVisibility(4);
                this.f22873a.f15857a.setDrawBorder(true);
                this.f22873a.f15857a.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f22876a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f22877b;

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
            this.f22877b = cVar;
            this.f22876a = musicData;
        }

        @Override // c.a.q0.o0.c.d.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.M(TbadkCoreApplication.getInst(), str);
                if (this.f22877b.f22872i != null) {
                    this.f22877b.f22872i.b(3, str);
                }
            }
        }

        @Override // c.a.q0.o0.c.d.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.q0.o0.c.d.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f22877b.n(str, this.f22876a);
            }
        }
    }

    /* renamed from: c.a.q0.o0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1060c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22878e;

        public C1060c(c cVar) {
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
            this.f22878e = cVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f22878e.f22865b.setLooping(true);
                this.f22878e.f22865b.start();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f22879e;

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
            this.f22879e = cVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f22879e.f22872i != null) {
                    g gVar = this.f22879e.f22872i;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public c(TbPageContext tbPageContext, c.a.q0.o0.c.b bVar) {
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
            this.f22872i = kVar.get();
        }
        this.f22870g = tbPageContext;
        this.f22864a = new SelectMusicModel(tbPageContext, bVar);
        m();
    }

    @Override // c.a.q0.o0.c.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22868e : (String) invokeV.objValue;
    }

    @Override // c.a.q0.o0.c.a
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
            CloudMusicActivityConfig cloudMusicActivityConfig = new CloudMusicActivityConfig(this.f22870g.getPageActivity(), 25032);
            cloudMusicActivityConfig.setCurrentMusicData(this.f22867d);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, cloudMusicActivityConfig));
        }
    }

    @Override // c.a.q0.o0.c.a
    public void c() {
        SelectMusicModel selectMusicModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (selectMusicModel = this.f22864a) == null) {
            return;
        }
        selectMusicModel.cancelLoadData();
    }

    @Override // c.a.q0.o0.c.a
    public void d(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbMusicData) == null) {
            this.f22867d = tbMusicData;
        }
    }

    @Override // c.a.q0.o0.c.a
    public void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f22869f = false;
            this.f22868e = str;
            n(str, null);
        }
    }

    @Override // c.a.q0.o0.c.a
    public void f(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048581, this, f2) == null) || (mediaPlayer = this.f22865b) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > this.f22865b.getDuration()) {
            f2 %= this.f22865b.getDuration();
        }
        this.f22865b.seekTo((int) (f2 * 1000.0f));
        this.f22865b.start();
    }

    @Override // c.a.q0.o0.c.a
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f22871h : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f22864a.x();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void n(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, musicData) == null) || this.f22869f) {
            return;
        }
        if (this.f22865b == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f22865b = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f22868e = str;
            this.f22865b.reset();
            this.f22865b.setDataSource(str);
            this.f22865b.prepare();
            this.f22865b.setOnPreparedListener(new C1060c(this));
            this.f22865b.setOnErrorListener(new d(this));
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
        MediaPlayer mediaPlayer = this.f22865b;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f22865b.stop();
        }
        this.f22871h = false;
        String str = musicData.id;
        String g2 = c.a.q0.o0.c.d.a.h().g(musicData.resource);
        if (obj != null && (obj instanceof a.C0749a)) {
            this.f22866c = ((a.C0749a) obj).f15860d;
        }
        if (TextUtils.isEmpty(g2)) {
            if (obj instanceof a.C0749a) {
                a.C0749a c0749a = (a.C0749a) obj;
                c0749a.f15858b.setVisibility(0);
                c0749a.f15857a.setDrawBorder(false);
                c0749a.f15857a.invalidate();
                this.f22871h = true;
                c.a.q0.o0.c.d.a.h().f(musicData.id, musicData.resource, new a(this, c0749a, musicData));
                return;
            }
            c.a.q0.o0.c.d.a.h().f(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        n(g2, musicData);
    }

    @Override // c.a.q0.o0.c.a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f22869f = true;
            MediaPlayer mediaPlayer = this.f22865b;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f22865b.pause();
        }
    }

    @Override // c.a.q0.o0.c.a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f22869f = false;
            MediaPlayer mediaPlayer = this.f22865b;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f22865b.seekTo(0);
            }
        }
    }

    @Override // c.a.q0.o0.c.a
    public void onStopRecord() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (mediaPlayer = this.f22865b) != null && mediaPlayer.isPlaying()) {
            this.f22865b.pause();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f22868e = null;
            releasePlayer();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                c.a.q0.o0.c.d.a.h().e();
            }
            o(null, musicData);
        }
    }

    @Override // c.a.q0.o0.c.a
    public void releasePlayer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaPlayer mediaPlayer = this.f22865b;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f22865b.stop();
                }
                this.f22865b.release();
                this.f22865b = null;
            }
            this.f22868e = null;
        }
    }

    @Override // c.a.q0.o0.c.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            releasePlayer();
        }
    }
}

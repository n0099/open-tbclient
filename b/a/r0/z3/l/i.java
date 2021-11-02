package b.a.r0.z3.l;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.z3.i.f.a;
import b.a.r0.z3.l.c;
import b.a.r0.z3.l.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class i implements h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f28555e;

    /* renamed from: f  reason: collision with root package name */
    public int f28556f;

    /* renamed from: g  reason: collision with root package name */
    public String f28557g;

    /* renamed from: h  reason: collision with root package name */
    public String f28558h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28559i;
    public Context j;
    public boolean k;
    public b.a.r0.a2.g l;

    /* loaded from: classes6.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a f28560a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f28561b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f28562c;

        public a(i iVar, c.a aVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, aVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28562c = iVar;
            this.f28560a = aVar;
            this.f28561b = musicData;
        }

        @Override // b.a.r0.z3.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f28560a.f28515d == this.f28562c.f28556f) {
                this.f28562c.k = false;
                this.f28560a.f28513b.setVisibility(4);
                this.f28560a.f28512a.setDrawBorder(true);
                this.f28560a.f28512a.invalidate();
                b.a.e.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f28562c.l != null) {
                    this.f28562c.l.b(3, str);
                }
            }
        }

        @Override // b.a.r0.z3.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f28560a.f28515d == this.f28562c.f28556f) {
                this.f28562c.k = false;
                this.f28560a.f28512a.setDrawBorder(true);
                this.f28560a.f28512a.invalidate();
                this.f28560a.f28513b.setVisibility(4);
            }
        }

        @Override // b.a.r0.z3.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f28560a.f28515d == this.f28562c.f28556f) {
                this.f28562c.k = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f28562c.o(str, this.f28561b);
                this.f28560a.f28513b.setVisibility(4);
                this.f28560a.f28512a.setDrawBorder(true);
                this.f28560a.f28512a.invalidate();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f28563a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f28564b;

        public b(i iVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28564b = iVar;
            this.f28563a = musicData;
        }

        @Override // b.a.r0.z3.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.e.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f28564b.l != null) {
                    this.f28564b.l.b(3, str);
                }
            }
        }

        @Override // b.a.r0.z3.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // b.a.r0.z3.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f28564b.o(str, this.f28563a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f28565e;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28565e = iVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f28565e.f28555e.setLooping(true);
                this.f28565e.f28555e.start();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f28566e;

        public d(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28566e = iVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f28566e.l != null) {
                    b.a.r0.a2.g gVar = this.f28566e.l;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public i(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, b.a.r0.a2.k.class);
        b.a.r0.a2.k kVar = runTask != null ? (b.a.r0.a2.k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.j = activity;
    }

    public void f(EditVideoActivityConfig editVideoActivityConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, editVideoActivityConfig) == null) || TextUtils.isEmpty(this.f28558h) || TextUtils.isEmpty(this.f28557g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f28558h, this.f28557g, this.f28556f);
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28558h : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.f28559i = false;
            this.f28558h = str;
            this.f28557g = str2;
            o(str, null);
        }
    }

    public void j(MusicData musicData, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, musicData, obj) == null) || musicData == null) {
            return;
        }
        int i2 = musicData.editMusicType;
        if (i2 == 0) {
            p(obj, musicData);
        } else if (i2 == 1) {
            q();
        } else if (i2 != 2) {
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.j, 25032)));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28559i = true;
            MediaPlayer mediaPlayer = this.f28555e;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f28555e.pause();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f28559i = false;
            MediaPlayer mediaPlayer = this.f28555e;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f28555e.seekTo(0);
            }
        }
    }

    public void m(int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (mediaPlayer = this.f28555e) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f28555e.getDuration()) {
            i2 %= this.f28555e.getDuration();
        }
        this.f28555e.seekTo(i2);
        this.f28555e.start();
    }

    public void n() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (mediaPlayer = this.f28555e) != null && mediaPlayer.isPlaying()) {
            this.f28555e.pause();
        }
    }

    public final void o(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, musicData) == null) || this.f28559i) {
            return;
        }
        if (this.f28555e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f28555e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f28558h = str;
            this.f28555e.reset();
            this.f28555e.setDataSource(str);
            this.f28555e.prepare();
            this.f28555e.setOnPreparedListener(new c(this));
            this.f28555e.setOnErrorListener(new d(this));
        } catch (Exception e2) {
            e2.printStackTrace();
            r(str, musicData);
        }
    }

    @Override // b.a.r0.z3.l.h.b
    public void onStatusChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
        }
    }

    public final void p(Object obj, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, obj, musicData) == null) || musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        MediaPlayer mediaPlayer = this.f28555e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f28555e.stop();
        }
        this.k = false;
        this.f28557g = musicData.id;
        String f2 = b.a.r0.z3.i.f.a.g().f(musicData.resource);
        if (obj != null && (obj instanceof c.a)) {
            this.f28556f = ((c.a) obj).f28515d;
        }
        if (TextUtils.isEmpty(f2)) {
            if (obj instanceof c.a) {
                c.a aVar = (c.a) obj;
                aVar.f28513b.setVisibility(0);
                aVar.f28512a.setDrawBorder(false);
                aVar.f28512a.invalidate();
                this.k = true;
                b.a.r0.z3.i.f.a.g().e(musicData.id, musicData.resource, new a(this, aVar, musicData));
                return;
            }
            b.a.r0.z3.i.f.a.g().e(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        o(f2, musicData);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MediaPlayer mediaPlayer = this.f28555e;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f28555e.stop();
                }
                this.f28555e.release();
                this.f28555e = null;
            }
            this.f28558h = null;
            this.f28557g = null;
        }
    }

    public final void r(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f28558h = null;
            q();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                b.a.r0.z3.i.f.a.g().d();
            }
            p(null, musicData);
        }
    }

    public void s(SelectMusicModel selectMusicModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, selectMusicModel) == null) {
        }
    }
}

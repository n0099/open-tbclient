package c.a.r0.y3.l;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.y3.i.f.a;
import c.a.r0.y3.l.c;
import c.a.r0.y3.l.h;
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
/* loaded from: classes4.dex */
public class i implements h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f29358e;

    /* renamed from: f  reason: collision with root package name */
    public int f29359f;

    /* renamed from: g  reason: collision with root package name */
    public String f29360g;

    /* renamed from: h  reason: collision with root package name */
    public String f29361h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29362i;

    /* renamed from: j  reason: collision with root package name */
    public Context f29363j;
    public boolean k;
    public c.a.r0.a2.g l;

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a f29364a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f29365b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f29366c;

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
            this.f29366c = iVar;
            this.f29364a = aVar;
            this.f29365b = musicData;
        }

        @Override // c.a.r0.y3.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f29364a.f29317d == this.f29366c.f29359f) {
                this.f29366c.k = false;
                this.f29364a.f29315b.setVisibility(4);
                this.f29364a.f29314a.setDrawBorder(true);
                this.f29364a.f29314a.invalidate();
                c.a.e.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f29366c.l != null) {
                    this.f29366c.l.b(3, str);
                }
            }
        }

        @Override // c.a.r0.y3.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f29364a.f29317d == this.f29366c.f29359f) {
                this.f29366c.k = false;
                this.f29364a.f29314a.setDrawBorder(true);
                this.f29364a.f29314a.invalidate();
                this.f29364a.f29315b.setVisibility(4);
            }
        }

        @Override // c.a.r0.y3.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f29364a.f29317d == this.f29366c.f29359f) {
                this.f29366c.k = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f29366c.o(str, this.f29365b);
                this.f29364a.f29315b.setVisibility(4);
                this.f29364a.f29314a.setDrawBorder(true);
                this.f29364a.f29314a.invalidate();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f29367a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f29368b;

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
            this.f29368b = iVar;
            this.f29367a = musicData;
        }

        @Override // c.a.r0.y3.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.e.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f29368b.l != null) {
                    this.f29368b.l.b(3, str);
                }
            }
        }

        @Override // c.a.r0.y3.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.y3.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f29368b.o(str, this.f29367a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f29369e;

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
            this.f29369e = iVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f29369e.f29358e.setLooping(true);
                this.f29369e.f29358e.start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f29370e;

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
            this.f29370e = iVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f29370e.l != null) {
                    c.a.r0.a2.g gVar = this.f29370e.l;
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, c.a.r0.a2.k.class);
        c.a.r0.a2.k kVar = runTask != null ? (c.a.r0.a2.k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.f29363j = activity;
    }

    public void f(EditVideoActivityConfig editVideoActivityConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, editVideoActivityConfig) == null) || TextUtils.isEmpty(this.f29361h) || TextUtils.isEmpty(this.f29360g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f29361h, this.f29360g, this.f29359f);
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29361h : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.f29362i = false;
            this.f29361h = str;
            this.f29360g = str2;
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.f29363j, 25032)));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f29362i = true;
            MediaPlayer mediaPlayer = this.f29358e;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f29358e.pause();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f29362i = false;
            MediaPlayer mediaPlayer = this.f29358e;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f29358e.seekTo(0);
            }
        }
    }

    public void m(int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (mediaPlayer = this.f29358e) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f29358e.getDuration()) {
            i2 %= this.f29358e.getDuration();
        }
        this.f29358e.seekTo(i2);
        this.f29358e.start();
    }

    public void n() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (mediaPlayer = this.f29358e) != null && mediaPlayer.isPlaying()) {
            this.f29358e.pause();
        }
    }

    public final void o(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, musicData) == null) || this.f29362i) {
            return;
        }
        if (this.f29358e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f29358e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f29361h = str;
            this.f29358e.reset();
            this.f29358e.setDataSource(str);
            this.f29358e.prepare();
            this.f29358e.setOnPreparedListener(new c(this));
            this.f29358e.setOnErrorListener(new d(this));
        } catch (Exception e2) {
            e2.printStackTrace();
            r(str, musicData);
        }
    }

    @Override // c.a.r0.y3.l.h.b
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
        MediaPlayer mediaPlayer = this.f29358e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f29358e.stop();
        }
        this.k = false;
        this.f29360g = musicData.id;
        String f2 = c.a.r0.y3.i.f.a.g().f(musicData.resource);
        if (obj != null && (obj instanceof c.a)) {
            this.f29359f = ((c.a) obj).f29317d;
        }
        if (TextUtils.isEmpty(f2)) {
            if (obj instanceof c.a) {
                c.a aVar = (c.a) obj;
                aVar.f29315b.setVisibility(0);
                aVar.f29314a.setDrawBorder(false);
                aVar.f29314a.invalidate();
                this.k = true;
                c.a.r0.y3.i.f.a.g().e(musicData.id, musicData.resource, new a(this, aVar, musicData));
                return;
            }
            c.a.r0.y3.i.f.a.g().e(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        o(f2, musicData);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MediaPlayer mediaPlayer = this.f29358e;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f29358e.stop();
                }
                this.f29358e.release();
                this.f29358e = null;
            }
            this.f29361h = null;
            this.f29360g = null;
        }
    }

    public final void r(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f29361h = null;
            q();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                c.a.r0.y3.i.f.a.g().d();
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

package b.a.r0.a4.l;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.a4.i.f.a;
import b.a.r0.a4.l.c;
import b.a.r0.a4.l.h;
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
    public MediaPlayer f16190e;

    /* renamed from: f  reason: collision with root package name */
    public int f16191f;

    /* renamed from: g  reason: collision with root package name */
    public String f16192g;

    /* renamed from: h  reason: collision with root package name */
    public String f16193h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16194i;
    public Context j;
    public boolean k;
    public b.a.r0.a2.g l;

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a f16195a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f16196b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f16197c;

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
            this.f16197c = iVar;
            this.f16195a = aVar;
            this.f16196b = musicData;
        }

        @Override // b.a.r0.a4.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f16195a.f16150d == this.f16197c.f16191f) {
                this.f16197c.k = false;
                this.f16195a.f16148b.setVisibility(4);
                this.f16195a.f16147a.setDrawBorder(true);
                this.f16195a.f16147a.invalidate();
                b.a.e.f.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f16197c.l != null) {
                    this.f16197c.l.b(3, str);
                }
            }
        }

        @Override // b.a.r0.a4.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f16195a.f16150d == this.f16197c.f16191f) {
                this.f16197c.k = false;
                this.f16195a.f16147a.setDrawBorder(true);
                this.f16195a.f16147a.invalidate();
                this.f16195a.f16148b.setVisibility(4);
            }
        }

        @Override // b.a.r0.a4.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f16195a.f16150d == this.f16197c.f16191f) {
                this.f16197c.k = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f16197c.o(str, this.f16196b);
                this.f16195a.f16148b.setVisibility(4);
                this.f16195a.f16147a.setDrawBorder(true);
                this.f16195a.f16147a.invalidate();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f16198a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f16199b;

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
            this.f16199b = iVar;
            this.f16198a = musicData;
        }

        @Override // b.a.r0.a4.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.e.f.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f16199b.l != null) {
                    this.f16199b.l.b(3, str);
                }
            }
        }

        @Override // b.a.r0.a4.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // b.a.r0.a4.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f16199b.o(str, this.f16198a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f16200e;

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
            this.f16200e = iVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f16200e.f16190e.setLooping(true);
                this.f16200e.f16190e.start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f16201e;

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
            this.f16201e = iVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f16201e.l != null) {
                    b.a.r0.a2.g gVar = this.f16201e.l;
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
        if (!(interceptable == null || interceptable.invokeL(1048576, this, editVideoActivityConfig) == null) || TextUtils.isEmpty(this.f16193h) || TextUtils.isEmpty(this.f16192g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f16193h, this.f16192g, this.f16191f);
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16193h : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.f16194i = false;
            this.f16193h = str;
            this.f16192g = str2;
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
            this.f16194i = true;
            MediaPlayer mediaPlayer = this.f16190e;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f16190e.pause();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16194i = false;
            MediaPlayer mediaPlayer = this.f16190e;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f16190e.seekTo(0);
            }
        }
    }

    public void m(int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (mediaPlayer = this.f16190e) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f16190e.getDuration()) {
            i2 %= this.f16190e.getDuration();
        }
        this.f16190e.seekTo(i2);
        this.f16190e.start();
    }

    public void n() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (mediaPlayer = this.f16190e) != null && mediaPlayer.isPlaying()) {
            this.f16190e.pause();
        }
    }

    public final void o(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, musicData) == null) || this.f16194i) {
            return;
        }
        if (this.f16190e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f16190e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f16193h = str;
            this.f16190e.reset();
            this.f16190e.setDataSource(str);
            this.f16190e.prepare();
            this.f16190e.setOnPreparedListener(new c(this));
            this.f16190e.setOnErrorListener(new d(this));
        } catch (Exception e2) {
            e2.printStackTrace();
            r(str, musicData);
        }
    }

    @Override // b.a.r0.a4.l.h.b
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
        MediaPlayer mediaPlayer = this.f16190e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f16190e.stop();
        }
        this.k = false;
        this.f16192g = musicData.id;
        String f2 = b.a.r0.a4.i.f.a.g().f(musicData.resource);
        if (obj != null && (obj instanceof c.a)) {
            this.f16191f = ((c.a) obj).f16150d;
        }
        if (TextUtils.isEmpty(f2)) {
            if (obj instanceof c.a) {
                c.a aVar = (c.a) obj;
                aVar.f16148b.setVisibility(0);
                aVar.f16147a.setDrawBorder(false);
                aVar.f16147a.invalidate();
                this.k = true;
                b.a.r0.a4.i.f.a.g().e(musicData.id, musicData.resource, new a(this, aVar, musicData));
                return;
            }
            b.a.r0.a4.i.f.a.g().e(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        o(f2, musicData);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MediaPlayer mediaPlayer = this.f16190e;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f16190e.stop();
                }
                this.f16190e.release();
                this.f16190e = null;
            }
            this.f16193h = null;
            this.f16192g = null;
        }
    }

    public final void r(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f16193h = null;
            q();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                b.a.r0.a4.i.f.a.g().d();
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

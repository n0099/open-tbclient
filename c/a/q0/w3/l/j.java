package c.a.q0.w3.l;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.w3.i.f.a;
import c.a.q0.w3.l.d;
import c.a.q0.w3.l.i;
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
public class j implements i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f28475e;

    /* renamed from: f  reason: collision with root package name */
    public int f28476f;

    /* renamed from: g  reason: collision with root package name */
    public String f28477g;

    /* renamed from: h  reason: collision with root package name */
    public String f28478h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28479i;

    /* renamed from: j  reason: collision with root package name */
    public Context f28480j;
    public boolean k;
    public c.a.q0.y1.g l;

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a f28481a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f28482b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f28483c;

        public a(j jVar, d.a aVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, aVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28483c = jVar;
            this.f28481a = aVar;
            this.f28482b = musicData;
        }

        @Override // c.a.q0.w3.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.f28481a.f28434d == this.f28483c.f28476f) {
                this.f28483c.k = false;
                this.f28481a.f28432b.setVisibility(4);
                this.f28481a.f28431a.setDrawBorder(true);
                this.f28481a.f28431a.invalidate();
                c.a.e.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f28483c.l != null) {
                    this.f28483c.l.b(3, str);
                }
            }
        }

        @Override // c.a.q0.w3.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f28481a.f28434d == this.f28483c.f28476f) {
                this.f28483c.k = false;
                this.f28481a.f28431a.setDrawBorder(true);
                this.f28481a.f28431a.invalidate();
                this.f28481a.f28432b.setVisibility(4);
            }
        }

        @Override // c.a.q0.w3.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.f28481a.f28434d == this.f28483c.f28476f) {
                this.f28483c.k = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f28483c.o(str, this.f28482b);
                this.f28481a.f28432b.setVisibility(4);
                this.f28481a.f28431a.setDrawBorder(true);
                this.f28481a.f28431a.invalidate();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MusicData f28484a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f28485b;

        public b(j jVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28485b = jVar;
            this.f28484a = musicData;
        }

        @Override // c.a.q0.w3.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.e.e.p.l.M(TbadkCoreApplication.getInst(), str);
                if (this.f28485b.l != null) {
                    this.f28485b.l.b(3, str);
                }
            }
        }

        @Override // c.a.q0.w3.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.q0.w3.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f28485b.o(str, this.f28484a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f28486e;

        public c(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28486e = jVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f28486e.f28475e.setLooping(true);
                this.f28486e.f28475e.start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f28487e;

        public d(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28487e = jVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f28487e.l != null) {
                    c.a.q0.y1.g gVar = this.f28487e.l;
                    gVar.b(4, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    public j(Activity activity) {
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, c.a.q0.y1.k.class);
        c.a.q0.y1.k kVar = runTask != null ? (c.a.q0.y1.k) runTask.getData() : null;
        if (kVar != null) {
            this.l = kVar.get();
        }
        this.f28480j = activity;
    }

    public void f(EditVideoActivityConfig editVideoActivityConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, editVideoActivityConfig) == null) || TextUtils.isEmpty(this.f28478h) || TextUtils.isEmpty(this.f28477g)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f28478h, this.f28477g, this.f28476f);
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28478h : (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            this.f28479i = false;
            this.f28478h = str;
            this.f28477g = str2;
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.f28480j, 25032)));
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28479i = true;
            MediaPlayer mediaPlayer = this.f28475e;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f28475e.pause();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f28479i = false;
            MediaPlayer mediaPlayer = this.f28475e;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.f28475e.seekTo(0);
            }
        }
    }

    public void m(int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (mediaPlayer = this.f28475e) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.f28475e.getDuration()) {
            i2 %= this.f28475e.getDuration();
        }
        this.f28475e.seekTo(i2);
        this.f28475e.start();
    }

    public void n() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (mediaPlayer = this.f28475e) != null && mediaPlayer.isPlaying()) {
            this.f28475e.pause();
        }
    }

    public final void o(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, str, musicData) == null) || this.f28479i) {
            return;
        }
        if (this.f28475e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f28475e = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f28478h = str;
            this.f28475e.reset();
            this.f28475e.setDataSource(str);
            this.f28475e.prepare();
            this.f28475e.setOnPreparedListener(new c(this));
            this.f28475e.setOnErrorListener(new d(this));
        } catch (Exception e2) {
            e2.printStackTrace();
            r(str, musicData);
        }
    }

    @Override // c.a.q0.w3.l.i.b
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
        MediaPlayer mediaPlayer = this.f28475e;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f28475e.stop();
        }
        this.k = false;
        this.f28477g = musicData.id;
        String f2 = c.a.q0.w3.i.f.a.g().f(musicData.resource);
        if (obj != null && (obj instanceof d.a)) {
            this.f28476f = ((d.a) obj).f28434d;
        }
        if (TextUtils.isEmpty(f2)) {
            if (obj instanceof d.a) {
                d.a aVar = (d.a) obj;
                aVar.f28432b.setVisibility(0);
                aVar.f28431a.setDrawBorder(false);
                aVar.f28431a.invalidate();
                this.k = true;
                c.a.q0.w3.i.f.a.g().e(musicData.id, musicData.resource, new a(this, aVar, musicData));
                return;
            }
            c.a.q0.w3.i.f.a.g().e(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        o(f2, musicData);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MediaPlayer mediaPlayer = this.f28475e;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f28475e.stop();
                }
                this.f28475e.release();
                this.f28475e = null;
            }
            this.f28478h = null;
            this.f28477g = null;
        }
    }

    public final void r(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f28478h = null;
            q();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                c.a.q0.w3.i.f.a.g().d();
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

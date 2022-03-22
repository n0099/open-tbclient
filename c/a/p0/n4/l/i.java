package c.a.p0.n4.l;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.n4.i.f.a;
import c.a.p0.n4.l.c;
import c.a.p0.n4.l.h;
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
/* loaded from: classes2.dex */
public class i implements h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer a;

    /* renamed from: b  reason: collision with root package name */
    public int f16770b;

    /* renamed from: c  reason: collision with root package name */
    public String f16771c;

    /* renamed from: d  reason: collision with root package name */
    public String f16772d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16773e;

    /* renamed from: f  reason: collision with root package name */
    public Context f16774f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16775g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.l2.g f16776h;

    /* loaded from: classes2.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MusicData f16777b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f16778c;

        public a(i iVar, c.a aVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, aVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16778c = iVar;
            this.a = aVar;
            this.f16777b = musicData;
        }

        @Override // c.a.p0.n4.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a.f16747d == this.f16778c.f16770b) {
                this.f16778c.f16775g = false;
                this.a.f16745b.setVisibility(4);
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
                n.N(TbadkCoreApplication.getInst(), str);
                if (this.f16778c.f16776h != null) {
                    this.f16778c.f16776h.b(3, str);
                }
            }
        }

        @Override // c.a.p0.n4.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.f16747d == this.f16778c.f16770b) {
                this.f16778c.f16775g = false;
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
                this.a.f16745b.setVisibility(4);
            }
        }

        @Override // c.a.p0.n4.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) && this.a.f16747d == this.f16778c.f16770b) {
                this.f16778c.f16775g = false;
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f16778c.p(str, this.f16777b);
                this.a.f16745b.setVisibility(4);
                this.a.a.setDrawBorder(true);
                this.a.a.invalidate();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MusicData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i f16779b;

        public b(i iVar, MusicData musicData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, musicData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16779b = iVar;
            this.a = musicData;
        }

        @Override // c.a.p0.n4.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                n.N(TbadkCoreApplication.getInst(), str);
                if (this.f16779b.f16776h != null) {
                    this.f16779b.f16776h.b(3, str);
                }
            }
        }

        @Override // c.a.p0.n4.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.p0.n4.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f16779b.p(str, this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.a.a.setLooping(true);
                this.a.a.start();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public d(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i, i2)) == null) {
                if (this.a.f16776h != null) {
                    c.a.p0.l2.g gVar = this.a.f16776h;
                    gVar.b(4, "what-->" + i + "  extra-->" + i2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, c.a.p0.l2.k.class);
        c.a.p0.l2.k kVar = runTask != null ? (c.a.p0.l2.k) runTask.getData() : null;
        if (kVar != null) {
            this.f16776h = kVar.get();
        }
        this.f16774f = activity;
    }

    @Override // c.a.p0.n4.l.h.b
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    public void g(EditVideoActivityConfig editVideoActivityConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editVideoActivityConfig) == null) || TextUtils.isEmpty(this.f16772d) || TextUtils.isEmpty(this.f16771c)) {
            return;
        }
        editVideoActivityConfig.addMusicInfo(this.f16772d, this.f16771c, this.f16770b);
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16772d : (String) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16775g : invokeV.booleanValue;
    }

    public void j(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.f16773e = false;
            this.f16772d = str;
            this.f16771c = str2;
            p(str, null);
        }
    }

    public void k(MusicData musicData, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, musicData, obj) == null) || musicData == null) {
            return;
        }
        int i = musicData.editMusicType;
        if (i == 0) {
            q(obj, musicData);
        } else if (i == 1) {
            r();
        } else if (i != 2) {
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.f16774f, 25032)));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16773e = true;
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.a.pause();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f16773e = false;
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                mediaPlayer.start();
                this.a.seekTo(0);
            }
        }
    }

    public void n(int i) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (mediaPlayer = this.a) == null || mediaPlayer.getDuration() <= 0) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i > this.a.getDuration()) {
            i %= this.a.getDuration();
        }
        this.a.seekTo(i);
        this.a.start();
    }

    public void o() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (mediaPlayer = this.a) != null && mediaPlayer.isPlaying()) {
            this.a.pause();
        }
    }

    public final void p(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, str, musicData) == null) || this.f16773e) {
            return;
        }
        if (this.a == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.a = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            this.f16772d = str;
            this.a.reset();
            this.a.setDataSource(str);
            this.a.prepare();
            this.a.setOnPreparedListener(new c(this));
            this.a.setOnErrorListener(new d(this));
        } catch (Exception e2) {
            e2.printStackTrace();
            s(str, musicData);
        }
    }

    public final void q(Object obj, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, obj, musicData) == null) || musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.a.stop();
        }
        this.f16775g = false;
        this.f16771c = musicData.id;
        String f2 = c.a.p0.n4.i.f.a.g().f(musicData.resource);
        if (obj != null && (obj instanceof c.a)) {
            this.f16770b = ((c.a) obj).f16747d;
        }
        if (TextUtils.isEmpty(f2)) {
            if (obj instanceof c.a) {
                c.a aVar = (c.a) obj;
                aVar.f16745b.setVisibility(0);
                aVar.a.setDrawBorder(false);
                aVar.a.invalidate();
                this.f16775g = true;
                c.a.p0.n4.i.f.a.g().e(musicData.id, musicData.resource, new a(this, aVar, musicData));
                return;
            }
            c.a.p0.n4.i.f.a.g().e(musicData.id, musicData.resource, new b(this, musicData));
            return;
        }
        p(f2, musicData);
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.a.stop();
                }
                this.a.release();
                this.a = null;
            }
            this.f16772d = null;
            this.f16771c = null;
        }
    }

    public final void s(String str, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, musicData) == null) {
            this.f16772d = null;
            r();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                c.a.p0.n4.i.f.a.g().d();
            }
            q(null, musicData);
        }
    }

    public void t(SelectMusicModel selectMusicModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, selectMusicModel) == null) {
        }
    }
}

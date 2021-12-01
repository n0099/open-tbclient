package c.a.r0.h4.i.h;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.r0.h4.i.c.c;
import c.a.r0.h4.i.f.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HorizontalListView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends c.a.d.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f18045b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f18046c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.h4.i.h.a f18047d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.h4.i.c.c f18048e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18049f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f18050g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18051h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18052i;

    /* renamed from: j  reason: collision with root package name */
    public MediaPlayer f18053j;

    /* renamed from: k  reason: collision with root package name */
    public String f18054k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public boolean q;
    public c.a.r0.g2.g r;
    public String s;
    public String t;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18055e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18055e = eVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f18055e.f18048e.b() != i2 || i2 == this.f18055e.l) {
                    this.f18055e.m = i2;
                    this.f18055e.q(i2, view);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f18056b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f18057c;

        public b(e eVar, c.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18057c = eVar;
            this.a = aVar;
            this.f18056b = i2;
        }

        @Override // c.a.r0.h4.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.f17951b.setVisibility(4);
                l.M(this.f18057c.mContext.getPageActivity(), str);
                if (this.f18057c.r != null) {
                    this.f18057c.r.a(206, str);
                }
            }
        }

        @Override // c.a.r0.h4.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f17951b.setVisibility(4);
            }
        }

        @Override // c.a.r0.h4.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.a.f17951b.setVisibility(4);
                this.f18057c.B(str, this.f18056b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f18058b;

        public c(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18058b = eVar;
            this.a = i2;
        }

        @Override // c.a.r0.h4.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.M(this.f18058b.mContext.getPageActivity(), str);
                if (this.f18058b.r != null) {
                    this.f18058b.r.a(206, str);
                }
            }
        }

        @Override // c.a.r0.h4.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.h4.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f18058b.B(str, this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f18059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18060f;

        public d(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18060f = eVar;
            this.f18059e = i2;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f18060f.f18048e.d(this.f18059e);
                this.f18060f.f18053j.setLooping(true);
            }
        }
    }

    /* renamed from: c.a.r0.h4.i.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1066e implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18061e;

        public C1066e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18061e = eVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f18061e.r != null) {
                    c.a.r0.g2.g gVar = this.f18061e.r;
                    gVar.a(207, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f18062e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f18063f;

        public f(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18063f = eVar;
            this.f18062e = i2;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f18063f.f18048e.d(this.f18062e);
                this.f18063f.f18053j.setLooping(true);
                this.f18063f.f18053j.start();
                this.f18063f.f18047d.O();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18064e;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18064e = eVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f18064e.r != null) {
                    c.a.r0.g2.g gVar = this.f18064e.r;
                    gVar.a(207, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18065e;

        public h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18065e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e eVar = this.f18065e;
                eVar.L(!eVar.f18052i);
                this.f18065e.f18047d.X(!this.f18065e.f18052i);
                this.f18065e.F();
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_type", !this.f18065e.f18052i ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18066e;

        public i(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18066e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f18066e.f18045b.setSelection(this.f18066e.n);
                this.f18066e.f18045b.scrollTo(this.f18066e.m * l.f(this.f18066e.getPageContext().getContext(), R.dimen.ds122));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.d.a.f fVar, c.a.r0.h4.i.h.a aVar, c.a.r0.g2.g gVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, aVar, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18052i = true;
        this.l = 1;
        this.f18047d = aVar;
        this.r = gVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.a = inflate;
        this.f18046c = inflate.getResources();
        v();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                this.f18049f.setVisibility(0);
                if (this.q && this.f18053j == null && !TextUtils.isEmpty(this.f18054k)) {
                    B(this.f18054k, this.n);
                    this.q = false;
                    if (this.n > 4) {
                        new Handler().postDelayed(new i(this), 300L);
                        return;
                    }
                    return;
                }
                F();
                return;
            }
            this.f18049f.setVisibility(8);
            y();
        }
    }

    public final void B(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            this.n = i2;
            if (this.m == i2 && !this.o) {
                if (this.f18053j == null) {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    this.f18053j = mediaPlayer;
                    mediaPlayer.setAudioStreamType(3);
                }
                try {
                    this.f18054k = str;
                    this.f18053j.reset();
                    this.f18053j.setDataSource(str);
                    this.f18053j.prepare();
                    this.f18053j.setOnPreparedListener(new f(this, i2));
                    this.f18053j.setOnErrorListener(new g(this));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    G(str, i2);
                    c.a.r0.g2.g gVar = this.r;
                    if (gVar != null) {
                        gVar.a(208, c.a.r0.g2.a.a(e2));
                    }
                }
            }
        }
    }

    public final void C(int i2, View view, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, view, musicData) == null) || musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        this.p = musicData.id;
        this.f18047d.p();
        String f2 = c.a.r0.h4.i.f.a.g().f(musicData.resource);
        if (!TextUtils.isEmpty(f2)) {
            B(f2, i2);
        } else if (view != null) {
            c.a aVar = (c.a) view.getTag();
            aVar.f17951b.setVisibility(0);
            c.a.r0.h4.i.f.a.g().e(musicData.id, musicData.resource, new b(this, aVar, i2));
        } else {
            c.a.r0.h4.i.f.a.g().e(musicData.id, musicData.resource, new c(this, i2));
        }
    }

    public final void D(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || k.isEmpty(this.s)) {
            return;
        }
        this.n = i2;
        if (this.f18053j == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f18053j = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            try {
                this.p = this.t;
                this.f18054k = this.s;
                this.f18053j.reset();
                this.f18053j.setDataSource(this.s);
                this.f18053j.prepare();
                this.f18053j.setOnPreparedListener(new d(this, i2));
                this.f18053j.setOnErrorListener(new C1066e(this));
            } catch (Exception e2) {
                e2.printStackTrace();
                G(this.f18054k, i2);
                if (this.r != null) {
                    this.r.a(208, c.a.r0.g2.a.a(e2));
                }
            }
        } finally {
            this.t = null;
            this.s = null;
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MediaPlayer mediaPlayer = this.f18053j;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f18053j.stop();
                }
                this.f18053j.release();
                this.f18053j = null;
            }
            this.f18054k = null;
            this.p = null;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.o = false;
            MediaPlayer mediaPlayer = this.f18053j;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.f18053j.pause();
            }
            MediaPlayer mediaPlayer2 = this.f18053j;
            if (mediaPlayer2 != null) {
                mediaPlayer2.start();
                this.f18053j.seekTo(0);
            }
        }
    }

    public final void G(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            this.f18054k = null;
            E();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                c.a.r0.h4.i.f.a.g().d();
            }
            C(i2, this.f18045b.getChildCount() > i2 ? this.f18045b.getChildAt(i2) : null, (MusicData) this.f18048e.getItem(i2));
        }
    }

    public void K(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f18048e.f(list);
            c.a.r0.h4.i.c.c cVar = this.f18048e;
            if (cVar != null) {
                int b2 = cVar.b();
                this.n = b2;
                this.m = b2;
            }
            Q();
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f18052i = z;
            if (z) {
                this.f18050g.setSelected(false);
                this.f18051h.setText(this.f18046c.getString(R.string.video_voice_open));
                return;
            }
            this.f18050g.setSelected(true);
            this.f18051h.setText(this.f18046c.getString(R.string.video_voice_close));
        }
    }

    public void M(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, intent) == null) || intent == null || intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) == null || intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) == null) {
            return;
        }
        this.q = true;
        this.p = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
        this.f18054k = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
        c.a.r0.h4.i.c.c cVar = this.f18048e;
        if (cVar != null) {
            cVar.e(this.p);
            int b2 = this.f18048e.b();
            this.n = b2;
            this.l = b2;
            this.m = b2;
        }
    }

    public void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            this.s = str;
            this.t = str2;
            Q();
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || k.isEmpty(this.t) || k.isEmpty(this.s)) {
            return;
        }
        List<MusicData> c2 = this.f18048e.c();
        if (ListUtils.isEmpty(c2)) {
            return;
        }
        for (int i2 = 0; i2 < c2.size(); i2++) {
            if (c2.get(i2) != null && StringHelper.equals(c2.get(i2).id, this.t)) {
                D(i2);
                return;
            }
        }
        D(1);
    }

    public final void q(int i2, View view) {
        MusicData musicData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048588, this, i2, view) == null) || (musicData = (MusicData) this.f18048e.getItem(i2)) == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12423");
        statisticItem.param("obj_id", musicData.id);
        statisticItem.param("obj_locate", i2 + 1);
        statisticItem.param("obj_source", 2);
        TiebaStatic.log(statisticItem);
        int i3 = musicData.editMusicType;
        if (i3 == 0) {
            C(i2, view, musicData);
        } else if (i3 == 1) {
            this.f18048e.d(i2);
            E();
            this.f18047d.O();
        } else if (i3 != 2) {
        } else {
            this.l = i2;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CloudMusicActivityConfig(this.mContext.getPageActivity(), 25032)));
        }
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f18054k : (String) invokeV.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    public void u(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            this.f18049f = (LinearLayout) view.findViewById(R.id.video_voice_layout);
            this.f18050g = (ImageView) view.findViewById(R.id.video_voice_img);
            this.f18051h = (TextView) view.findViewById(R.id.video_voice_text);
            this.f18049f.setVisibility(8);
            this.f18049f.setOnClickListener(new h(this));
            L(this.f18052i);
            this.f18047d.X(!this.f18052i);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f18045b = (HorizontalListView) this.a.findViewById(R.id.horizontal_list);
            c.a.r0.h4.i.c.c cVar = new c.a.r0.h4.i.c.c(this.mContext);
            this.f18048e = cVar;
            this.f18045b.setAdapter((ListAdapter) cVar);
            this.f18045b.setOnItemClickListener(new a(this));
        }
    }

    public void w(c.a.d.a.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, fVar, i2) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
        }
    }

    public void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            this.o = false;
            int i2 = this.l;
            this.m = i2;
            this.p = str2;
            B(str, i2);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.o = true;
            MediaPlayer mediaPlayer = this.f18053j;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f18053j.pause();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.o = false;
            MediaPlayer mediaPlayer = this.f18053j;
            if (mediaPlayer == null || this.f18047d.l != 2) {
                return;
            }
            mediaPlayer.start();
            this.f18053j.seekTo(0);
        }
    }
}

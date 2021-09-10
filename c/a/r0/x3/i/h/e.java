package c.a.r0.x3.i.h;

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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.r0.x3.i.c.c;
import c.a.r0.x3.i.f.a;
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
/* loaded from: classes4.dex */
public class e extends c.a.e.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f29043a;

    /* renamed from: b  reason: collision with root package name */
    public HorizontalListView f29044b;

    /* renamed from: c  reason: collision with root package name */
    public Resources f29045c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.x3.i.h.a f29046d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.x3.i.c.c f29047e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f29048f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f29049g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f29050h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29051i;

    /* renamed from: j  reason: collision with root package name */
    public MediaPlayer f29052j;
    public String k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public String p;
    public boolean q;
    public c.a.r0.z1.g r;
    public String s;
    public String t;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f29053e;

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
            this.f29053e = eVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f29053e.f29047e.b() != i2 || i2 == this.f29053e.l) {
                    this.f29053e.m = i2;
                    this.f29053e.q(i2, view);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a f29054a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f29055b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f29056c;

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
            this.f29056c = eVar;
            this.f29054a = aVar;
            this.f29055b = i2;
        }

        @Override // c.a.r0.x3.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f29054a.f28934b.setVisibility(4);
                l.M(this.f29056c.mContext.getPageActivity(), str);
                if (this.f29056c.r != null) {
                    this.f29056c.r.a(206, str);
                }
            }
        }

        @Override // c.a.r0.x3.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f29054a.f28934b.setVisibility(4);
            }
        }

        @Override // c.a.r0.x3.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f29054a.f28934b.setVisibility(4);
                this.f29056c.B(str, this.f29055b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f29057a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f29058b;

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
            this.f29058b = eVar;
            this.f29057a = i2;
        }

        @Override // c.a.r0.x3.i.f.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                l.M(this.f29058b.mContext.getPageActivity(), str);
                if (this.f29058b.r != null) {
                    this.f29058b.r.a(206, str);
                }
            }
        }

        @Override // c.a.r0.x3.i.f.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // c.a.r0.x3.i.f.a.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str2;
                }
                this.f29058b.B(str, this.f29057a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f29059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f29060f;

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
            this.f29060f = eVar;
            this.f29059e = i2;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f29060f.f29047e.d(this.f29059e);
                this.f29060f.f29052j.setLooping(true);
            }
        }
    }

    /* renamed from: c.a.r0.x3.i.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1359e implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f29061e;

        public C1359e(e eVar) {
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
            this.f29061e = eVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f29061e.r != null) {
                    c.a.r0.z1.g gVar = this.f29061e.r;
                    gVar.a(207, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f29062e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f29063f;

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
            this.f29063f = eVar;
            this.f29062e = i2;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                this.f29063f.f29047e.d(this.f29062e);
                this.f29063f.f29052j.setLooping(true);
                this.f29063f.f29052j.start();
                this.f29063f.f29046d.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements MediaPlayer.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f29064e;

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
            this.f29064e = eVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3)) == null) {
                if (this.f29064e.r != null) {
                    c.a.r0.z1.g gVar = this.f29064e.r;
                    gVar.a(207, "what-->" + i2 + "  extra-->" + i3);
                    return false;
                }
                return false;
            }
            return invokeLII.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f29065e;

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
            this.f29065e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                e eVar = this.f29065e;
                eVar.P(!eVar.f29051i);
                this.f29065e.f29046d.X(!this.f29065e.f29051i);
                this.f29065e.L();
                StatisticItem statisticItem = new StatisticItem("c12423");
                statisticItem.param("obj_type", !this.f29065e.f29051i ? 1 : 0);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f29066e;

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
            this.f29066e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29066e.f29044b.setSelection(this.f29066e.n);
                this.f29066e.f29044b.scrollTo(this.f29066e.m * l.g(this.f29066e.getPageContext().getContext(), R.dimen.ds122));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c.a.e.a.f fVar, c.a.r0.x3.i.h.a aVar, c.a.r0.z1.g gVar) {
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
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29051i = true;
        this.l = 1;
        this.f29046d = aVar;
        this.r = gVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.edit_music_layout, (ViewGroup) null);
        this.f29043a = inflate;
        this.f29045c = inflate.getResources();
        v();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                this.f29048f.setVisibility(0);
                if (this.q && this.f29052j == null && !TextUtils.isEmpty(this.k)) {
                    B(this.k, this.n);
                    this.q = false;
                    if (this.n > 4) {
                        new Handler().postDelayed(new i(this), 300L);
                        return;
                    }
                    return;
                }
                L();
                return;
            }
            this.f29048f.setVisibility(8);
            y();
        }
    }

    public final void B(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            this.n = i2;
            if (this.m == i2 && !this.o) {
                if (this.f29052j == null) {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    this.f29052j = mediaPlayer;
                    mediaPlayer.setAudioStreamType(3);
                }
                try {
                    this.k = str;
                    this.f29052j.reset();
                    this.f29052j.setDataSource(str);
                    this.f29052j.prepare();
                    this.f29052j.setOnPreparedListener(new f(this, i2));
                    this.f29052j.setOnErrorListener(new g(this));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    N(str, i2);
                    c.a.r0.z1.g gVar = this.r;
                    if (gVar != null) {
                        gVar.a(208, c.a.r0.z1.a.a(e2));
                    }
                }
            }
        }
    }

    public final void D(int i2, View view, MusicData musicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, view, musicData) == null) || musicData == null || TextUtils.isEmpty(musicData.resource)) {
            return;
        }
        this.p = musicData.id;
        this.f29046d.p();
        String f2 = c.a.r0.x3.i.f.a.g().f(musicData.resource);
        if (!TextUtils.isEmpty(f2)) {
            B(f2, i2);
        } else if (view != null) {
            c.a aVar = (c.a) view.getTag();
            aVar.f28934b.setVisibility(0);
            c.a.r0.x3.i.f.a.g().e(musicData.id, musicData.resource, new b(this, aVar, i2));
        } else {
            c.a.r0.x3.i.f.a.g().e(musicData.id, musicData.resource, new c(this, i2));
        }
    }

    public final void J(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || k.isEmpty(this.s)) {
            return;
        }
        this.n = i2;
        if (this.f29052j == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f29052j = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
        }
        try {
            try {
                this.p = this.t;
                this.k = this.s;
                this.f29052j.reset();
                this.f29052j.setDataSource(this.s);
                this.f29052j.prepare();
                this.f29052j.setOnPreparedListener(new d(this, i2));
                this.f29052j.setOnErrorListener(new C1359e(this));
            } catch (Exception e2) {
                e2.printStackTrace();
                N(this.k, i2);
                if (this.r != null) {
                    this.r.a(208, c.a.r0.z1.a.a(e2));
                }
            }
        } finally {
            this.t = null;
            this.s = null;
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MediaPlayer mediaPlayer = this.f29052j;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.f29052j.stop();
                }
                this.f29052j.release();
                this.f29052j = null;
            }
            this.k = null;
            this.p = null;
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.o = false;
            MediaPlayer mediaPlayer = this.f29052j;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                this.f29052j.pause();
            }
            MediaPlayer mediaPlayer2 = this.f29052j;
            if (mediaPlayer2 != null) {
                mediaPlayer2.start();
                this.f29052j.seekTo(0);
            }
        }
    }

    public final void N(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            this.k = null;
            K();
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                c.a.r0.x3.i.f.a.g().d();
            }
            D(i2, this.f29044b.getChildCount() > i2 ? this.f29044b.getChildAt(i2) : null, (MusicData) this.f29047e.getItem(i2));
        }
    }

    public void O(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f29047e.f(list);
            c.a.r0.x3.i.c.c cVar = this.f29047e;
            if (cVar != null) {
                int b2 = cVar.b();
                this.n = b2;
                this.m = b2;
            }
            S();
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f29051i = z;
            if (z) {
                this.f29049g.setSelected(false);
                this.f29050h.setText(this.f29045c.getString(R.string.video_voice_open));
                return;
            }
            this.f29049g.setSelected(true);
            this.f29050h.setText(this.f29045c.getString(R.string.video_voice_close));
        }
    }

    public void Q(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, intent) == null) || intent == null || intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY) == null || intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY) == null) {
            return;
        }
        this.q = true;
        this.p = intent.getStringExtra(EditVideoActivityConfig.MUSIC_ID_KEY);
        this.k = intent.getStringExtra(EditVideoActivityConfig.LOCAL_PATH_KEY);
        c.a.r0.x3.i.c.c cVar = this.f29047e;
        if (cVar != null) {
            cVar.e(this.p);
            int b2 = this.f29047e.b();
            this.n = b2;
            this.l = b2;
            this.m = b2;
        }
    }

    public void R(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            this.s = str;
            this.t = str2;
            S();
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || k.isEmpty(this.t) || k.isEmpty(this.s)) {
            return;
        }
        List<MusicData> c2 = this.f29047e.c();
        if (ListUtils.isEmpty(c2)) {
            return;
        }
        for (int i2 = 0; i2 < c2.size(); i2++) {
            if (c2.get(i2) != null && StringHelper.equals(c2.get(i2).id, this.t)) {
                J(i2);
                return;
            }
        }
        J(1);
    }

    public final void q(int i2, View view) {
        MusicData musicData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048588, this, i2, view) == null) || (musicData = (MusicData) this.f29047e.getItem(i2)) == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12423");
        statisticItem.param("obj_id", musicData.id);
        statisticItem.param("obj_locate", i2 + 1);
        statisticItem.param("obj_source", 2);
        TiebaStatic.log(statisticItem);
        int i3 = musicData.editMusicType;
        if (i3 == 0) {
            D(i2, view, musicData);
        } else if (i3 == 1) {
            this.f29047e.d(i2);
            K();
            this.f29046d.R();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f29043a : (View) invokeV.objValue;
    }

    public void u(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            this.f29048f = (LinearLayout) view.findViewById(R.id.video_voice_layout);
            this.f29049g = (ImageView) view.findViewById(R.id.video_voice_img);
            this.f29050h = (TextView) view.findViewById(R.id.video_voice_text);
            this.f29048f.setVisibility(8);
            this.f29048f.setOnClickListener(new h(this));
            P(this.f29051i);
            this.f29046d.X(!this.f29051i);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f29044b = (HorizontalListView) this.f29043a.findViewById(R.id.horizontal_list);
            c.a.r0.x3.i.c.c cVar = new c.a.r0.x3.i.c.c(this.mContext);
            this.f29047e = cVar;
            this.f29044b.setAdapter((ListAdapter) cVar);
            this.f29044b.setOnItemClickListener(new a(this));
        }
    }

    public void w(c.a.e.a.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, fVar, i2) == null) {
            SkinManager.setBackgroundColor(this.f29043a, R.color.CAM_X0201);
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
            MediaPlayer mediaPlayer = this.f29052j;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.f29052j.pause();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.o = false;
            MediaPlayer mediaPlayer = this.f29052j;
            if (mediaPlayer == null || this.f29046d.l != 2) {
                return;
            }
            mediaPlayer.start();
            this.f29052j.seekTo(0);
        }
    }
}

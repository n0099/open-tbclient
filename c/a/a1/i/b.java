package c.a.a1.i;

import c.a.a1.t.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AudioPlayData> a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f1172b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.a1.i.g.a f1173c;

    /* renamed from: d  reason: collision with root package name */
    public int f1174d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0013b f1175e;

    /* loaded from: classes.dex */
    public class a extends c.a.a1.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1176e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f1177f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f1178g;

        public a(b bVar, String str, AudioPlayData audioPlayData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, audioPlayData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1178g = bVar;
            this.f1176e = str;
            this.f1177f = audioPlayData;
        }

        @Override // c.a.a1.l.d.j.c.a, c.a.a1.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f1178g.f1175e == null) {
                return;
            }
            this.f1178g.f1175e.onFailed(str);
        }

        @Override // c.a.a1.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.f1176e, 0, (int) x.b(this.f1176e), this.f1177f.volume);
                if (this.f1178g.f1172b == null) {
                    this.f1178g.f1172b = new ArrayList();
                }
                this.f1178g.f1172b.add(audioPlayData);
                b.c(this.f1178g);
                this.f1178g.f();
            }
        }

        @Override // c.a.a1.l.d.j.c.a, c.a.a1.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j2)}) == null) {
            }
        }

        @Override // c.a.a1.l.d.j.c.a, c.a.a1.l.d.j.b
        public void onTrackEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }
    }

    /* renamed from: c.a.a1.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0013b {
        void onFailed(String str);

        void onSuccess(List<AudioPlayData> list);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static /* synthetic */ int c(b bVar) {
        int i2 = bVar.f1174d;
        bVar.f1174d = i2 + 1;
        return i2;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (c.a.a1.t.h.c(this.a, this.f1174d) == null) {
                InterfaceC0013b interfaceC0013b = this.f1175e;
                if (interfaceC0013b != null) {
                    interfaceC0013b.onSuccess(this.f1172b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.a.get(this.f1174d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i2 = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i2, audioPlayData2.end - i2, audioPlayData2.volume);
                if (this.f1172b == null) {
                    arrayList = new ArrayList();
                    this.f1172b = arrayList;
                }
                this.f1172b.add(audioPlayData);
                this.f1174d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f1172b == null) {
                    arrayList = new ArrayList();
                    this.f1172b = arrayList;
                }
                this.f1172b.add(audioPlayData);
                this.f1174d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    c.a.a1.i.g.a aVar = new c.a.a1.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f1173c = aVar;
                    aVar.S(new a(this, str2, audioPlayData2));
                    this.f1173c.D(null);
                    this.f1173c.G(audioPlayData2.mSpeed);
                    this.f1173c.B(audioPlayData2.start);
                    this.f1173c.R(audioPlayData2.end);
                    this.f1173c.I();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC0013b interfaceC0013b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC0013b) == null) {
            this.f1175e = interfaceC0013b;
        }
    }

    public void h(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.a = list;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
        }
    }
}

package c.a.y0.i;

import c.a.y0.t.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AudioPlayData> a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f27278b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.y0.i.g.a f27279c;

    /* renamed from: d  reason: collision with root package name */
    public int f27280d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1571b f27281e;

    /* loaded from: classes9.dex */
    public class a extends c.a.y0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f27282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f27283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f27284g;

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
            this.f27284g = bVar;
            this.f27282e = str;
            this.f27283f = audioPlayData;
        }

        @Override // c.a.y0.l.d.j.c.a, c.a.y0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f27284g.f27281e == null) {
                return;
            }
            this.f27284g.f27281e.onFailed(str);
        }

        @Override // c.a.y0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.f27282e, 0, (int) x.b(this.f27282e), this.f27283f.volume);
                if (this.f27284g.f27278b == null) {
                    this.f27284g.f27278b = new ArrayList();
                }
                this.f27284g.f27278b.add(audioPlayData);
                b.c(this.f27284g);
                this.f27284g.f();
            }
        }

        @Override // c.a.y0.l.d.j.c.a, c.a.y0.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j2)}) == null) {
            }
        }

        @Override // c.a.y0.l.d.j.c.a, c.a.y0.l.d.j.b
        public void onTrackEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }
    }

    /* renamed from: c.a.y0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1571b {
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
        int i2 = bVar.f27280d;
        bVar.f27280d = i2 + 1;
        return i2;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (c.a.y0.t.h.c(this.a, this.f27280d) == null) {
                InterfaceC1571b interfaceC1571b = this.f27281e;
                if (interfaceC1571b != null) {
                    interfaceC1571b.onSuccess(this.f27278b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.a.get(this.f27280d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i2 = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i2, audioPlayData2.end - i2, audioPlayData2.volume);
                if (this.f27278b == null) {
                    arrayList = new ArrayList();
                    this.f27278b = arrayList;
                }
                this.f27278b.add(audioPlayData);
                this.f27280d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f27278b == null) {
                    arrayList = new ArrayList();
                    this.f27278b = arrayList;
                }
                this.f27278b.add(audioPlayData);
                this.f27280d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    c.a.y0.i.g.a aVar = new c.a.y0.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f27279c = aVar;
                    aVar.S(new a(this, str2, audioPlayData2));
                    this.f27279c.D(null);
                    this.f27279c.G(audioPlayData2.mSpeed);
                    this.f27279c.B(audioPlayData2.start);
                    this.f27279c.R(audioPlayData2.end);
                    this.f27279c.I();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC1571b interfaceC1571b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1571b) == null) {
            this.f27281e = interfaceC1571b;
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

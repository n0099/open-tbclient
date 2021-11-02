package b.a.x0.i;

import b.a.x0.t.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<AudioPlayData> f29564a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f29565b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.x0.i.g.a f29566c;

    /* renamed from: d  reason: collision with root package name */
    public int f29567d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1423b f29568e;

    /* loaded from: classes6.dex */
    public class a extends b.a.x0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f29569e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f29570f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f29571g;

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
            this.f29571g = bVar;
            this.f29569e = str;
            this.f29570f = audioPlayData;
        }

        @Override // b.a.x0.l.d.j.c.a, b.a.x0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f29571g.f29568e == null) {
                return;
            }
            this.f29571g.f29568e.onFailed(str);
        }

        @Override // b.a.x0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.f29569e, 0, (int) x.b(this.f29569e), this.f29570f.volume);
                if (this.f29571g.f29565b == null) {
                    this.f29571g.f29565b = new ArrayList();
                }
                this.f29571g.f29565b.add(audioPlayData);
                b.c(this.f29571g);
                this.f29571g.f();
            }
        }

        @Override // b.a.x0.l.d.j.c.a, b.a.x0.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // b.a.x0.l.d.j.c.a, b.a.x0.l.d.j.b
        public void onTrackEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }
    }

    /* renamed from: b.a.x0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1423b {
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
        int i2 = bVar.f29567d;
        bVar.f29567d = i2 + 1;
        return i2;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (b.a.x0.t.h.c(this.f29564a, this.f29567d) == null) {
                InterfaceC1423b interfaceC1423b = this.f29568e;
                if (interfaceC1423b != null) {
                    interfaceC1423b.onSuccess(this.f29565b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.f29564a.get(this.f29567d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i2 = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i2, audioPlayData2.end - i2, audioPlayData2.volume);
                if (this.f29565b == null) {
                    arrayList = new ArrayList();
                    this.f29565b = arrayList;
                }
                this.f29565b.add(audioPlayData);
                this.f29567d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f29565b == null) {
                    arrayList = new ArrayList();
                    this.f29565b = arrayList;
                }
                this.f29565b.add(audioPlayData);
                this.f29567d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    b.a.x0.i.g.a aVar = new b.a.x0.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f29566c = aVar;
                    aVar.S(new a(this, str2, audioPlayData2));
                    this.f29566c.D(null);
                    this.f29566c.G(audioPlayData2.mSpeed);
                    this.f29566c.B(audioPlayData2.start);
                    this.f29566c.R(audioPlayData2.end);
                    this.f29566c.I();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC1423b interfaceC1423b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1423b) == null) {
            this.f29568e = interfaceC1423b;
        }
    }

    public void h(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f29564a = list;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
        }
    }
}

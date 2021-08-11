package c.a.v0.i;

import c.a.v0.t.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<AudioPlayData> f30217a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f30218b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.v0.i.g.a f30219c;

    /* renamed from: d  reason: collision with root package name */
    public int f30220d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1408b f30221e;

    /* loaded from: classes4.dex */
    public class a extends c.a.v0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f30222e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f30223f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f30224g;

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
            this.f30224g = bVar;
            this.f30222e = str;
            this.f30223f = audioPlayData;
        }

        @Override // c.a.v0.l.d.j.c.a, c.a.v0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f30224g.f30221e == null) {
                return;
            }
            this.f30224g.f30221e.onFailed(str);
        }

        @Override // c.a.v0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.f30222e, 0, (int) x.b(this.f30222e), this.f30223f.volume);
                if (this.f30224g.f30218b == null) {
                    this.f30224g.f30218b = new ArrayList();
                }
                this.f30224g.f30218b.add(audioPlayData);
                b.c(this.f30224g);
                this.f30224g.f();
            }
        }

        @Override // c.a.v0.l.d.j.c.a, c.a.v0.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j2)}) == null) {
            }
        }

        @Override // c.a.v0.l.d.j.c.a, c.a.v0.l.d.j.b
        public void onTrackEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }
    }

    /* renamed from: c.a.v0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1408b {
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
        int i2 = bVar.f30220d;
        bVar.f30220d = i2 + 1;
        return i2;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (c.a.v0.t.h.c(this.f30217a, this.f30220d) == null) {
                InterfaceC1408b interfaceC1408b = this.f30221e;
                if (interfaceC1408b != null) {
                    interfaceC1408b.onSuccess(this.f30218b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.f30217a.get(this.f30220d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i2 = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i2, audioPlayData2.end - i2, audioPlayData2.volume);
                if (this.f30218b == null) {
                    arrayList = new ArrayList();
                    this.f30218b = arrayList;
                }
                this.f30218b.add(audioPlayData);
                this.f30220d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f30218b == null) {
                    arrayList = new ArrayList();
                    this.f30218b = arrayList;
                }
                this.f30218b.add(audioPlayData);
                this.f30220d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    c.a.v0.i.g.a aVar = new c.a.v0.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f30219c = aVar;
                    aVar.S(new a(this, str2, audioPlayData2));
                    this.f30219c.D(null);
                    this.f30219c.G(audioPlayData2.mSpeed);
                    this.f30219c.B(audioPlayData2.start);
                    this.f30219c.R(audioPlayData2.end);
                    this.f30219c.I();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC1408b interfaceC1408b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1408b) == null) {
            this.f30221e = interfaceC1408b;
        }
    }

    public void h(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f30217a = list;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
        }
    }
}

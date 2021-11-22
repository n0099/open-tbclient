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
    public List<AudioPlayData> f30433a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f30434b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.x0.i.g.a f30435c;

    /* renamed from: d  reason: collision with root package name */
    public int f30436d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1465b f30437e;

    /* loaded from: classes6.dex */
    public class a extends b.a.x0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f30438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f30439f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f30440g;

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
            this.f30440g = bVar;
            this.f30438e = str;
            this.f30439f = audioPlayData;
        }

        @Override // b.a.x0.l.d.j.c.a, b.a.x0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f30440g.f30437e == null) {
                return;
            }
            this.f30440g.f30437e.onFailed(str);
        }

        @Override // b.a.x0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.f30438e, 0, (int) x.b(this.f30438e), this.f30439f.volume);
                if (this.f30440g.f30434b == null) {
                    this.f30440g.f30434b = new ArrayList();
                }
                this.f30440g.f30434b.add(audioPlayData);
                b.c(this.f30440g);
                this.f30440g.f();
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
    public interface InterfaceC1465b {
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
        int i2 = bVar.f30436d;
        bVar.f30436d = i2 + 1;
        return i2;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (b.a.x0.t.h.c(this.f30433a, this.f30436d) == null) {
                InterfaceC1465b interfaceC1465b = this.f30437e;
                if (interfaceC1465b != null) {
                    interfaceC1465b.onSuccess(this.f30434b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.f30433a.get(this.f30436d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i2 = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i2, audioPlayData2.end - i2, audioPlayData2.volume);
                if (this.f30434b == null) {
                    arrayList = new ArrayList();
                    this.f30434b = arrayList;
                }
                this.f30434b.add(audioPlayData);
                this.f30436d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f30434b == null) {
                    arrayList = new ArrayList();
                    this.f30434b = arrayList;
                }
                this.f30434b.add(audioPlayData);
                this.f30436d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    b.a.x0.i.g.a aVar = new b.a.x0.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f30435c = aVar;
                    aVar.S(new a(this, str2, audioPlayData2));
                    this.f30435c.D(null);
                    this.f30435c.G(audioPlayData2.mSpeed);
                    this.f30435c.B(audioPlayData2.start);
                    this.f30435c.R(audioPlayData2.end);
                    this.f30435c.I();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC1465b interfaceC1465b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1465b) == null) {
            this.f30437e = interfaceC1465b;
        }
    }

    public void h(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f30433a = list;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
        }
    }
}

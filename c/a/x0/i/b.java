package c.a.x0.i;

import c.a.x0.t.x;
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
    public List<AudioPlayData> f30858a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f30859b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.x0.i.g.a f30860c;

    /* renamed from: d  reason: collision with root package name */
    public int f30861d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1423b f30862e;

    /* loaded from: classes4.dex */
    public class a extends c.a.x0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f30863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f30864f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f30865g;

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
            this.f30865g = bVar;
            this.f30863e = str;
            this.f30864f = audioPlayData;
        }

        @Override // c.a.x0.l.d.j.c.a, c.a.x0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f30865g.f30862e == null) {
                return;
            }
            this.f30865g.f30862e.onFailed(str);
        }

        @Override // c.a.x0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.f30863e, 0, (int) x.b(this.f30863e), this.f30864f.volume);
                if (this.f30865g.f30859b == null) {
                    this.f30865g.f30859b = new ArrayList();
                }
                this.f30865g.f30859b.add(audioPlayData);
                b.c(this.f30865g);
                this.f30865g.f();
            }
        }

        @Override // c.a.x0.l.d.j.c.a, c.a.x0.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j2)}) == null) {
            }
        }

        @Override // c.a.x0.l.d.j.c.a, c.a.x0.l.d.j.b
        public void onTrackEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }
    }

    /* renamed from: c.a.x0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
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
        int i2 = bVar.f30861d;
        bVar.f30861d = i2 + 1;
        return i2;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (c.a.x0.t.h.c(this.f30858a, this.f30861d) == null) {
                InterfaceC1423b interfaceC1423b = this.f30862e;
                if (interfaceC1423b != null) {
                    interfaceC1423b.onSuccess(this.f30859b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.f30858a.get(this.f30861d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i2 = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i2, audioPlayData2.end - i2, audioPlayData2.volume);
                if (this.f30859b == null) {
                    arrayList = new ArrayList();
                    this.f30859b = arrayList;
                }
                this.f30859b.add(audioPlayData);
                this.f30861d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f30859b == null) {
                    arrayList = new ArrayList();
                    this.f30859b = arrayList;
                }
                this.f30859b.add(audioPlayData);
                this.f30861d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    c.a.x0.i.g.a aVar = new c.a.x0.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f30860c = aVar;
                    aVar.S(new a(this, str2, audioPlayData2));
                    this.f30860c.D(null);
                    this.f30860c.G(audioPlayData2.mSpeed);
                    this.f30860c.B(audioPlayData2.start);
                    this.f30860c.R(audioPlayData2.end);
                    this.f30860c.I();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC1423b interfaceC1423b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1423b) == null) {
            this.f30862e = interfaceC1423b;
        }
    }

    public void h(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f30858a = list;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
        }
    }
}

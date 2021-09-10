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
    public List<AudioPlayData> f30790a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f30791b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.x0.i.g.a f30792c;

    /* renamed from: d  reason: collision with root package name */
    public int f30793d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1422b f30794e;

    /* loaded from: classes4.dex */
    public class a extends c.a.x0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f30795e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f30796f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f30797g;

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
            this.f30797g = bVar;
            this.f30795e = str;
            this.f30796f = audioPlayData;
        }

        @Override // c.a.x0.l.d.j.c.a, c.a.x0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f30797g.f30794e == null) {
                return;
            }
            this.f30797g.f30794e.onFailed(str);
        }

        @Override // c.a.x0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.f30795e, 0, (int) x.b(this.f30795e), this.f30796f.volume);
                if (this.f30797g.f30791b == null) {
                    this.f30797g.f30791b = new ArrayList();
                }
                this.f30797g.f30791b.add(audioPlayData);
                b.c(this.f30797g);
                this.f30797g.f();
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
    public interface InterfaceC1422b {
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
        int i2 = bVar.f30793d;
        bVar.f30793d = i2 + 1;
        return i2;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (c.a.x0.t.h.c(this.f30790a, this.f30793d) == null) {
                InterfaceC1422b interfaceC1422b = this.f30794e;
                if (interfaceC1422b != null) {
                    interfaceC1422b.onSuccess(this.f30791b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.f30790a.get(this.f30793d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i2 = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i2, audioPlayData2.end - i2, audioPlayData2.volume);
                if (this.f30791b == null) {
                    arrayList = new ArrayList();
                    this.f30791b = arrayList;
                }
                this.f30791b.add(audioPlayData);
                this.f30793d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f30791b == null) {
                    arrayList = new ArrayList();
                    this.f30791b = arrayList;
                }
                this.f30791b.add(audioPlayData);
                this.f30793d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    c.a.x0.i.g.a aVar = new c.a.x0.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f30792c = aVar;
                    aVar.S(new a(this, str2, audioPlayData2));
                    this.f30792c.D(null);
                    this.f30792c.G(audioPlayData2.mSpeed);
                    this.f30792c.B(audioPlayData2.start);
                    this.f30792c.R(audioPlayData2.end);
                    this.f30792c.I();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC1422b interfaceC1422b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1422b) == null) {
            this.f30794e = interfaceC1422b;
        }
    }

    public void h(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f30790a = list;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
        }
    }
}

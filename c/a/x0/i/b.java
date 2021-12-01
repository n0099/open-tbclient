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
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AudioPlayData> a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f26885b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.x0.i.g.a f26886c;

    /* renamed from: d  reason: collision with root package name */
    public int f26887d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1529b f26888e;

    /* loaded from: classes7.dex */
    public class a extends c.a.x0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f26889e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f26890f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f26891g;

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
            this.f26891g = bVar;
            this.f26889e = str;
            this.f26890f = audioPlayData;
        }

        @Override // c.a.x0.l.d.j.c.a, c.a.x0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f26891g.f26888e == null) {
                return;
            }
            this.f26891g.f26888e.onFailed(str);
        }

        @Override // c.a.x0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.f26889e, 0, (int) x.b(this.f26889e), this.f26890f.volume);
                if (this.f26891g.f26885b == null) {
                    this.f26891g.f26885b = new ArrayList();
                }
                this.f26891g.f26885b.add(audioPlayData);
                b.c(this.f26891g);
                this.f26891g.f();
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
    /* loaded from: classes7.dex */
    public interface InterfaceC1529b {
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
        int i2 = bVar.f26887d;
        bVar.f26887d = i2 + 1;
        return i2;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (c.a.x0.t.h.c(this.a, this.f26887d) == null) {
                InterfaceC1529b interfaceC1529b = this.f26888e;
                if (interfaceC1529b != null) {
                    interfaceC1529b.onSuccess(this.f26885b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.a.get(this.f26887d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i2 = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i2, audioPlayData2.end - i2, audioPlayData2.volume);
                if (this.f26885b == null) {
                    arrayList = new ArrayList();
                    this.f26885b = arrayList;
                }
                this.f26885b.add(audioPlayData);
                this.f26887d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f26885b == null) {
                    arrayList = new ArrayList();
                    this.f26885b = arrayList;
                }
                this.f26885b.add(audioPlayData);
                this.f26887d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    c.a.x0.i.g.a aVar = new c.a.x0.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f26886c = aVar;
                    aVar.S(new a(this, str2, audioPlayData2));
                    this.f26886c.D(null);
                    this.f26886c.G(audioPlayData2.mSpeed);
                    this.f26886c.B(audioPlayData2.start);
                    this.f26886c.R(audioPlayData2.end);
                    this.f26886c.I();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC1529b interfaceC1529b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1529b) == null) {
            this.f26888e = interfaceC1529b;
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

package c.a.v0.i;

import c.a.v0.r.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AudioPlayData> a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f21583b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.v0.i.g.a f21584c;

    /* renamed from: d  reason: collision with root package name */
    public int f21585d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1601b f21586e;

    /* loaded from: classes3.dex */
    public class a extends c.a.v0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f21587b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f21588c;

        public a(b bVar, String str, AudioPlayData audioPlayData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, audioPlayData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21588c = bVar;
            this.a = str;
            this.f21587b = audioPlayData;
        }

        @Override // c.a.v0.l.d.j.c.a, c.a.v0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f21588c.f21586e == null) {
                return;
            }
            this.f21588c.f21586e.onFailed(str);
        }

        @Override // c.a.v0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.a, 0, (int) x.b(this.a), this.f21587b.volume);
                if (this.f21588c.f21583b == null) {
                    this.f21588c.f21583b = new ArrayList();
                }
                this.f21588c.f21583b.add(audioPlayData);
                b.c(this.f21588c);
                this.f21588c.f();
            }
        }

        @Override // c.a.v0.l.d.j.c.a, c.a.v0.l.d.j.b
        public void onProgressChanged(int i, double d2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // c.a.v0.l.d.j.c.a, c.a.v0.l.d.j.b
        public void onTrackEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }
    }

    /* renamed from: c.a.v0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1601b {
        void onFailed(String str);

        void onSuccess(List<AudioPlayData> list);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static /* synthetic */ int c(b bVar) {
        int i = bVar.f21585d;
        bVar.f21585d = i + 1;
        return i;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (c.a.v0.r.h.c(this.a, this.f21585d) == null) {
                InterfaceC1601b interfaceC1601b = this.f21586e;
                if (interfaceC1601b != null) {
                    interfaceC1601b.onSuccess(this.f21583b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.a.get(this.f21585d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i, audioPlayData2.end - i, audioPlayData2.volume);
                if (this.f21583b == null) {
                    arrayList = new ArrayList();
                    this.f21583b = arrayList;
                }
                this.f21583b.add(audioPlayData);
                this.f21585d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f21583b == null) {
                    arrayList = new ArrayList();
                    this.f21583b = arrayList;
                }
                this.f21583b.add(audioPlayData);
                this.f21585d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    c.a.v0.i.g.a aVar = new c.a.v0.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f21584c = aVar;
                    aVar.S(new a(this, str2, audioPlayData2));
                    this.f21584c.D(null);
                    this.f21584c.G(audioPlayData2.mSpeed);
                    this.f21584c.B(audioPlayData2.start);
                    this.f21584c.R(audioPlayData2.end);
                    this.f21584c.I();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC1601b interfaceC1601b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1601b) == null) {
            this.f21586e = interfaceC1601b;
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

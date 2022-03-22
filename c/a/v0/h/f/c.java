package c.a.v0.h.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.h.e;
import c.a.v0.r.h;
import c.a.v0.r.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends c.a.v0.h.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.v0.i.g.a f21578h;
    public int i;
    public int j;

    /* loaded from: classes3.dex */
    public class a extends c.a.v0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f21579b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f21580c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.v0.h.a f21581d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21582e;

        public a(c cVar, String str, int i, AudioPlayData audioPlayData, c.a.v0.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, Integer.valueOf(i), audioPlayData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21582e = cVar;
            this.a = str;
            this.f21579b = i;
            this.f21580c = audioPlayData;
            this.f21581d = aVar;
        }

        @Override // c.a.v0.l.d.j.c.a, c.a.v0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f21582e.f21578h.cancel();
                AudioPlayData audioPlayData = this.f21580c;
                if (audioPlayData.mSpeed != 1.0f || c.a.v0.i.c.o(audioPlayData.mSoundTypes)) {
                    this.f21582e.g(str);
                    this.f21582e.f21578h.cancel();
                } else {
                    this.f21582e.f21578h.cancel();
                    this.f21582e.q(this.f21581d, this.f21579b);
                }
                synchronized (this.f21582e) {
                    this.f21582e.notifyAll();
                }
            }
        }

        @Override // c.a.v0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.f21582e.q(new c.a.v0.h.a(new AudioPlayData(this.a, 0, -1, 1.0f)), this.f21579b);
                }
                synchronized (this.f21582e) {
                    this.f21582e.notifyAll();
                }
            }
        }

        @Override // c.a.v0.l.d.j.c.a, c.a.v0.l.d.j.b
        public void onProgressChanged(int i, double d2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d2), Long.valueOf(j)}) == null) {
                c cVar = this.f21582e;
                cVar.i((int) (((((cVar.j - 1) + d2) * 1.0d) / this.f21582e.i) * 100.0d));
            }
        }
    }

    public c() {
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

    @Override // c.a.v0.h.f.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f21569f = true;
            c.a.v0.i.g.a aVar = this.f21578h;
            if (aVar != null) {
                aVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // c.a.v0.h.f.a
    public void d(c.a.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar == null || h.e(cVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(cVar)) {
                l(cVar);
            } else {
                String a2 = cVar.a();
                this.f21570g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.f21570g)) {
                    new File(this.f21570g).mkdir();
                }
                this.f21568e = false;
                this.f21569f = false;
                y(cVar);
                x(cVar);
                List<e> c2 = cVar.c();
                int size = c2.size();
                for (int i = 0; i < size; i++) {
                    r(c2.get(i), i);
                }
                if (this.f21568e || this.f21569f) {
                    return;
                }
                l(this.f21567d);
            }
        }
    }

    @Override // c.a.v0.h.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.v0.i.g.a aVar = this.f21578h;
            if (aVar != null) {
                aVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(c.a.v0.h.a aVar, int i) {
        c.a.v0.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, aVar, i) == null) || (cVar = this.f21567d) == null || cVar.c() == null || this.f21567d.c().get(i) == null) {
            return;
        }
        this.f21567d.c().get(i).a().add(aVar);
    }

    public final void r(e eVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, eVar, i) == null) || eVar == null || h.e(eVar.a()) || this.f21569f || this.f21568e) {
            return;
        }
        for (c.a.v0.h.a aVar : eVar.a()) {
            if (this.f21568e || this.f21569f) {
                return;
            }
            this.j++;
            if (t(aVar)) {
                v(aVar, i);
            } else {
                q(aVar, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(c.a.v0.h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar == null || aVar.b() == null || !aVar.c()) {
                return false;
            }
            if (!c.a.v0.i.c.o(aVar.b().mSoundTypes) && aVar.b().mSpeed == 1.0f && aVar.b().start == 0 && aVar.b().end == -1 && aVar.b().volume == 1.0f) {
                return (aVar.a() == null || "audio/mp4a-latm".equals(aVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(c.a.v0.h.a aVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, aVar, i) == null) || this.f21569f || this.f21568e) {
            return;
        }
        AudioPlayData b2 = aVar.b();
        if (b2 == null || !FileUtils.isExists(b2.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b2.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            c.a.v0.i.g.a aVar2 = new c.a.v0.i.g.a(b2.audioPath, a2, b2.mSoundTypes);
            this.f21578h = aVar2;
            aVar2.S(new a(this, a2, i, b2, aVar));
            this.f21578h.D(b2.mSoundTypes);
            this.f21578h.G(b2.mSpeed);
            this.f21578h.H(b2.volume);
            this.f21578h.B(b2.start);
            this.f21578h.R(b2.end);
            this.f21578h.I();
            synchronized (this) {
                wait();
            }
        } catch (Exception e2) {
            g("dealAudioPlayData exception:" + m.g(e2));
            e2.printStackTrace();
        }
    }

    public final void x(c.a.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || cVar == null || h.e(cVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < cVar.c().size(); i++) {
            arrayList.add(new e(new ArrayList()));
        }
        c.a.v0.h.c cVar2 = new c.a.v0.h.c(arrayList);
        this.f21567d = cVar2;
        cVar2.e(cVar.b());
        this.f21567d.d(cVar.a());
    }

    public final void y(c.a.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.i = 0;
            this.j = 0;
            List<e> c2 = cVar.c();
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                if (c2.get(i) != null && c2.get(i).a() != null) {
                    this.i += c2.get(i).a().size();
                }
            }
        }
    }
}

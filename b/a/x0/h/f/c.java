package b.a.x0.h.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.x0.h.e;
import b.a.x0.t.h;
import b.a.x0.t.m;
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
/* loaded from: classes6.dex */
public class c extends b.a.x0.h.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public b.a.x0.i.g.a f29557h;

    /* renamed from: i  reason: collision with root package name */
    public int f29558i;
    public int j;

    /* loaded from: classes6.dex */
    public class a extends b.a.x0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f29559e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f29560f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f29561g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.x0.h.a f29562h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f29563i;

        public a(c cVar, String str, int i2, AudioPlayData audioPlayData, b.a.x0.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, Integer.valueOf(i2), audioPlayData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29563i = cVar;
            this.f29559e = str;
            this.f29560f = i2;
            this.f29561g = audioPlayData;
            this.f29562h = aVar;
        }

        @Override // b.a.x0.l.d.j.c.a, b.a.x0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f29563i.f29557h.cancel();
                AudioPlayData audioPlayData = this.f29561g;
                if (audioPlayData.mSpeed != 1.0f || b.a.x0.i.c.o(audioPlayData.mSoundTypes)) {
                    this.f29563i.g(str);
                    this.f29563i.f29557h.cancel();
                } else {
                    this.f29563i.f29557h.cancel();
                    this.f29563i.q(this.f29562h, this.f29560f);
                }
                synchronized (this.f29563i) {
                    this.f29563i.notifyAll();
                }
            }
        }

        @Override // b.a.x0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.f29563i.q(new b.a.x0.h.a(new AudioPlayData(this.f29559e, 0, -1, 1.0f)), this.f29560f);
                }
                synchronized (this.f29563i) {
                    this.f29563i.notifyAll();
                }
            }
        }

        @Override // b.a.x0.l.d.j.c.a, b.a.x0.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j)}) == null) {
                c cVar = this.f29563i;
                cVar.i((int) (((((cVar.j - 1) + d2) * 1.0d) / this.f29563i.f29558i) * 100.0d));
            }
        }
    }

    public c() {
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

    @Override // b.a.x0.h.f.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f29542f = true;
            b.a.x0.i.g.a aVar = this.f29557h;
            if (aVar != null) {
                aVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // b.a.x0.h.f.a
    public void d(b.a.x0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar == null || h.e(cVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(cVar)) {
                l(cVar);
            } else {
                String a2 = cVar.a();
                this.f29543g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.f29543g)) {
                    new File(this.f29543g).mkdir();
                }
                this.f29541e = false;
                this.f29542f = false;
                y(cVar);
                x(cVar);
                List<e> c2 = cVar.c();
                int size = c2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    r(c2.get(i2), i2);
                }
                if (this.f29541e || this.f29542f) {
                    return;
                }
                l(this.f29540d);
            }
        }
    }

    @Override // b.a.x0.h.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b.a.x0.i.g.a aVar = this.f29557h;
            if (aVar != null) {
                aVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(b.a.x0.h.a aVar, int i2) {
        b.a.x0.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, aVar, i2) == null) || (cVar = this.f29540d) == null || cVar.c() == null || this.f29540d.c().get(i2) == null) {
            return;
        }
        this.f29540d.c().get(i2).a().add(aVar);
    }

    public final void r(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, eVar, i2) == null) || eVar == null || h.e(eVar.a()) || this.f29542f || this.f29541e) {
            return;
        }
        for (b.a.x0.h.a aVar : eVar.a()) {
            if (this.f29541e || this.f29542f) {
                return;
            }
            this.j++;
            if (t(aVar)) {
                v(aVar, i2);
            } else {
                q(aVar, i2);
                i((int) (((this.j * 1.0f) / this.f29558i) * 100.0f));
            }
        }
    }

    public final boolean t(b.a.x0.h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar == null || aVar.b() == null || !aVar.c()) {
                return false;
            }
            if (!b.a.x0.i.c.o(aVar.b().mSoundTypes) && aVar.b().mSpeed == 1.0f && aVar.b().start == 0 && aVar.b().end == -1 && aVar.b().volume == 1.0f) {
                return (aVar.a() == null || "audio/mp4a-latm".equals(aVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(b.a.x0.h.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, aVar, i2) == null) || this.f29542f || this.f29541e) {
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
            b.a.x0.i.g.a aVar2 = new b.a.x0.i.g.a(b2.audioPath, a2, b2.mSoundTypes);
            this.f29557h = aVar2;
            aVar2.S(new a(this, a2, i2, b2, aVar));
            this.f29557h.D(b2.mSoundTypes);
            this.f29557h.G(b2.mSpeed);
            this.f29557h.H(b2.volume);
            this.f29557h.B(b2.start);
            this.f29557h.R(b2.end);
            this.f29557h.I();
            synchronized (this) {
                wait();
            }
        } catch (Exception e2) {
            g("dealAudioPlayData exception:" + m.g(e2));
            e2.printStackTrace();
        }
    }

    public final void x(b.a.x0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || cVar == null || h.e(cVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cVar.c().size(); i2++) {
            arrayList.add(new e(new ArrayList()));
        }
        b.a.x0.h.c cVar2 = new b.a.x0.h.c(arrayList);
        this.f29540d = cVar2;
        cVar2.e(cVar.b());
        this.f29540d.d(cVar.a());
    }

    public final void y(b.a.x0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f29558i = 0;
            this.j = 0;
            List<e> c2 = cVar.c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (c2.get(i2) != null && c2.get(i2).a() != null) {
                    this.f29558i += c2.get(i2).a().size();
                }
            }
        }
    }
}

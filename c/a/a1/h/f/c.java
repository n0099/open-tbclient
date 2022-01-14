package c.a.a1.h.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.h.e;
import c.a.a1.t.h;
import c.a.a1.t.m;
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
/* loaded from: classes.dex */
public class c extends c.a.a1.h.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.a1.i.g.a f1164h;

    /* renamed from: i  reason: collision with root package name */
    public int f1165i;

    /* renamed from: j  reason: collision with root package name */
    public int f1166j;

    /* loaded from: classes.dex */
    public class a extends c.a.a1.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1167e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f1168f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f1169g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.a1.h.a f1170h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f1171i;

        public a(c cVar, String str, int i2, AudioPlayData audioPlayData, c.a.a1.h.a aVar) {
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
            this.f1171i = cVar;
            this.f1167e = str;
            this.f1168f = i2;
            this.f1169g = audioPlayData;
            this.f1170h = aVar;
        }

        @Override // c.a.a1.l.d.j.c.a, c.a.a1.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f1171i.f1164h.cancel();
                AudioPlayData audioPlayData = this.f1169g;
                if (audioPlayData.mSpeed != 1.0f || c.a.a1.i.c.o(audioPlayData.mSoundTypes)) {
                    this.f1171i.g(str);
                    this.f1171i.f1164h.cancel();
                } else {
                    this.f1171i.f1164h.cancel();
                    this.f1171i.q(this.f1170h, this.f1168f);
                }
                synchronized (this.f1171i) {
                    this.f1171i.notifyAll();
                }
            }
        }

        @Override // c.a.a1.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.f1171i.q(new c.a.a1.h.a(new AudioPlayData(this.f1167e, 0, -1, 1.0f)), this.f1168f);
                }
                synchronized (this.f1171i) {
                    this.f1171i.notifyAll();
                }
            }
        }

        @Override // c.a.a1.l.d.j.c.a, c.a.a1.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j2)}) == null) {
                c cVar = this.f1171i;
                cVar.i((int) (((((cVar.f1166j - 1) + d2) * 1.0d) / this.f1171i.f1165i) * 100.0d));
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

    @Override // c.a.a1.h.f.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1153f = true;
            c.a.a1.i.g.a aVar = this.f1164h;
            if (aVar != null) {
                aVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // c.a.a1.h.f.a
    public void d(c.a.a1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar == null || h.e(cVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(cVar)) {
                l(cVar);
            } else {
                String a2 = cVar.a();
                this.f1154g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.f1154g)) {
                    new File(this.f1154g).mkdir();
                }
                this.f1152e = false;
                this.f1153f = false;
                y(cVar);
                x(cVar);
                List<e> c2 = cVar.c();
                int size = c2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    r(c2.get(i2), i2);
                }
                if (this.f1152e || this.f1153f) {
                    return;
                }
                l(this.f1151d);
            }
        }
    }

    @Override // c.a.a1.h.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.a1.i.g.a aVar = this.f1164h;
            if (aVar != null) {
                aVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(c.a.a1.h.a aVar, int i2) {
        c.a.a1.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, aVar, i2) == null) || (cVar = this.f1151d) == null || cVar.c() == null || this.f1151d.c().get(i2) == null) {
            return;
        }
        this.f1151d.c().get(i2).a().add(aVar);
    }

    public final void r(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, eVar, i2) == null) || eVar == null || h.e(eVar.a()) || this.f1153f || this.f1152e) {
            return;
        }
        for (c.a.a1.h.a aVar : eVar.a()) {
            if (this.f1152e || this.f1153f) {
                return;
            }
            this.f1166j++;
            if (t(aVar)) {
                v(aVar, i2);
            } else {
                q(aVar, i2);
                i((int) (((this.f1166j * 1.0f) / this.f1165i) * 100.0f));
            }
        }
    }

    public final boolean t(c.a.a1.h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar == null || aVar.b() == null || !aVar.c()) {
                return false;
            }
            if (!c.a.a1.i.c.o(aVar.b().mSoundTypes) && aVar.b().mSpeed == 1.0f && aVar.b().start == 0 && aVar.b().end == -1 && aVar.b().volume == 1.0f) {
                return (aVar.a() == null || "audio/mp4a-latm".equals(aVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(c.a.a1.h.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, aVar, i2) == null) || this.f1153f || this.f1152e) {
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
            c.a.a1.i.g.a aVar2 = new c.a.a1.i.g.a(b2.audioPath, a2, b2.mSoundTypes);
            this.f1164h = aVar2;
            aVar2.S(new a(this, a2, i2, b2, aVar));
            this.f1164h.D(b2.mSoundTypes);
            this.f1164h.G(b2.mSpeed);
            this.f1164h.H(b2.volume);
            this.f1164h.B(b2.start);
            this.f1164h.R(b2.end);
            this.f1164h.I();
            synchronized (this) {
                wait();
            }
        } catch (Exception e2) {
            g("dealAudioPlayData exception:" + m.g(e2));
            e2.printStackTrace();
        }
    }

    public final void x(c.a.a1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || cVar == null || h.e(cVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cVar.c().size(); i2++) {
            arrayList.add(new e(new ArrayList()));
        }
        c.a.a1.h.c cVar2 = new c.a.a1.h.c(arrayList);
        this.f1151d = cVar2;
        cVar2.e(cVar.b());
        this.f1151d.d(cVar.a());
    }

    public final void y(c.a.a1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f1165i = 0;
            this.f1166j = 0;
            List<e> c2 = cVar.c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (c2.get(i2) != null && c2.get(i2).a() != null) {
                    this.f1165i += c2.get(i2).a().size();
                }
            }
        }
    }
}

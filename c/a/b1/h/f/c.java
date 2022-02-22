package c.a.b1.h.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.b1.h.e;
import c.a.b1.t.h;
import c.a.b1.t.m;
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
public class c extends c.a.b1.h.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.b1.i.g.a f1198h;

    /* renamed from: i  reason: collision with root package name */
    public int f1199i;

    /* renamed from: j  reason: collision with root package name */
    public int f1200j;

    /* loaded from: classes.dex */
    public class a extends c.a.b1.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1201e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f1202f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f1203g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.b1.h.a f1204h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f1205i;

        public a(c cVar, String str, int i2, AudioPlayData audioPlayData, c.a.b1.h.a aVar) {
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
            this.f1205i = cVar;
            this.f1201e = str;
            this.f1202f = i2;
            this.f1203g = audioPlayData;
            this.f1204h = aVar;
        }

        @Override // c.a.b1.l.d.j.c.a, c.a.b1.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f1205i.f1198h.cancel();
                AudioPlayData audioPlayData = this.f1203g;
                if (audioPlayData.mSpeed != 1.0f || c.a.b1.i.c.o(audioPlayData.mSoundTypes)) {
                    this.f1205i.g(str);
                    this.f1205i.f1198h.cancel();
                } else {
                    this.f1205i.f1198h.cancel();
                    this.f1205i.q(this.f1204h, this.f1202f);
                }
                synchronized (this.f1205i) {
                    this.f1205i.notifyAll();
                }
            }
        }

        @Override // c.a.b1.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.f1205i.q(new c.a.b1.h.a(new AudioPlayData(this.f1201e, 0, -1, 1.0f)), this.f1202f);
                }
                synchronized (this.f1205i) {
                    this.f1205i.notifyAll();
                }
            }
        }

        @Override // c.a.b1.l.d.j.c.a, c.a.b1.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j2)}) == null) {
                c cVar = this.f1205i;
                cVar.i((int) (((((cVar.f1200j - 1) + d2) * 1.0d) / this.f1205i.f1199i) * 100.0d));
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

    @Override // c.a.b1.h.f.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1187f = true;
            c.a.b1.i.g.a aVar = this.f1198h;
            if (aVar != null) {
                aVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // c.a.b1.h.f.a
    public void d(c.a.b1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar == null || h.e(cVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(cVar)) {
                l(cVar);
            } else {
                String a2 = cVar.a();
                this.f1188g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.f1188g)) {
                    new File(this.f1188g).mkdir();
                }
                this.f1186e = false;
                this.f1187f = false;
                y(cVar);
                x(cVar);
                List<e> c2 = cVar.c();
                int size = c2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    r(c2.get(i2), i2);
                }
                if (this.f1186e || this.f1187f) {
                    return;
                }
                l(this.f1185d);
            }
        }
    }

    @Override // c.a.b1.h.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.b1.i.g.a aVar = this.f1198h;
            if (aVar != null) {
                aVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(c.a.b1.h.a aVar, int i2) {
        c.a.b1.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, aVar, i2) == null) || (cVar = this.f1185d) == null || cVar.c() == null || this.f1185d.c().get(i2) == null) {
            return;
        }
        this.f1185d.c().get(i2).a().add(aVar);
    }

    public final void r(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, eVar, i2) == null) || eVar == null || h.e(eVar.a()) || this.f1187f || this.f1186e) {
            return;
        }
        for (c.a.b1.h.a aVar : eVar.a()) {
            if (this.f1186e || this.f1187f) {
                return;
            }
            this.f1200j++;
            if (t(aVar)) {
                v(aVar, i2);
            } else {
                q(aVar, i2);
                i((int) (((this.f1200j * 1.0f) / this.f1199i) * 100.0f));
            }
        }
    }

    public final boolean t(c.a.b1.h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar == null || aVar.b() == null || !aVar.c()) {
                return false;
            }
            if (!c.a.b1.i.c.o(aVar.b().mSoundTypes) && aVar.b().mSpeed == 1.0f && aVar.b().start == 0 && aVar.b().end == -1 && aVar.b().volume == 1.0f) {
                return (aVar.a() == null || "audio/mp4a-latm".equals(aVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(c.a.b1.h.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, aVar, i2) == null) || this.f1187f || this.f1186e) {
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
            c.a.b1.i.g.a aVar2 = new c.a.b1.i.g.a(b2.audioPath, a2, b2.mSoundTypes);
            this.f1198h = aVar2;
            aVar2.S(new a(this, a2, i2, b2, aVar));
            this.f1198h.D(b2.mSoundTypes);
            this.f1198h.G(b2.mSpeed);
            this.f1198h.H(b2.volume);
            this.f1198h.B(b2.start);
            this.f1198h.R(b2.end);
            this.f1198h.I();
            synchronized (this) {
                wait();
            }
        } catch (Exception e2) {
            g("dealAudioPlayData exception:" + m.g(e2));
            e2.printStackTrace();
        }
    }

    public final void x(c.a.b1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || cVar == null || h.e(cVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cVar.c().size(); i2++) {
            arrayList.add(new e(new ArrayList()));
        }
        c.a.b1.h.c cVar2 = new c.a.b1.h.c(arrayList);
        this.f1185d = cVar2;
        cVar2.e(cVar.b());
        this.f1185d.d(cVar.a());
    }

    public final void y(c.a.b1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f1199i = 0;
            this.f1200j = 0;
            List<e> c2 = cVar.c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (c2.get(i2) != null && c2.get(i2).a() != null) {
                    this.f1199i += c2.get(i2).a().size();
                }
            }
        }
    }
}

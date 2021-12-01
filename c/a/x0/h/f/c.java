package c.a.x0.h.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.h.e;
import c.a.x0.t.h;
import c.a.x0.t.m;
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
/* loaded from: classes7.dex */
public class c extends c.a.x0.h.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public c.a.x0.i.g.a f26877h;

    /* renamed from: i  reason: collision with root package name */
    public int f26878i;

    /* renamed from: j  reason: collision with root package name */
    public int f26879j;

    /* loaded from: classes7.dex */
    public class a extends c.a.x0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f26880e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f26881f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f26882g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.x0.h.a f26883h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f26884i;

        public a(c cVar, String str, int i2, AudioPlayData audioPlayData, c.a.x0.h.a aVar) {
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
            this.f26884i = cVar;
            this.f26880e = str;
            this.f26881f = i2;
            this.f26882g = audioPlayData;
            this.f26883h = aVar;
        }

        @Override // c.a.x0.l.d.j.c.a, c.a.x0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f26884i.f26877h.cancel();
                AudioPlayData audioPlayData = this.f26882g;
                if (audioPlayData.mSpeed != 1.0f || c.a.x0.i.c.o(audioPlayData.mSoundTypes)) {
                    this.f26884i.g(str);
                    this.f26884i.f26877h.cancel();
                } else {
                    this.f26884i.f26877h.cancel();
                    this.f26884i.q(this.f26883h, this.f26881f);
                }
                synchronized (this.f26884i) {
                    this.f26884i.notifyAll();
                }
            }
        }

        @Override // c.a.x0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.f26884i.q(new c.a.x0.h.a(new AudioPlayData(this.f26880e, 0, -1, 1.0f)), this.f26881f);
                }
                synchronized (this.f26884i) {
                    this.f26884i.notifyAll();
                }
            }
        }

        @Override // c.a.x0.l.d.j.c.a, c.a.x0.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j2)}) == null) {
                c cVar = this.f26884i;
                cVar.i((int) (((((cVar.f26879j - 1) + d2) * 1.0d) / this.f26884i.f26878i) * 100.0d));
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

    @Override // c.a.x0.h.f.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26865f = true;
            c.a.x0.i.g.a aVar = this.f26877h;
            if (aVar != null) {
                aVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // c.a.x0.h.f.a
    public void d(c.a.x0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar == null || h.e(cVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(cVar)) {
                l(cVar);
            } else {
                String a2 = cVar.a();
                this.f26866g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.f26866g)) {
                    new File(this.f26866g).mkdir();
                }
                this.f26864e = false;
                this.f26865f = false;
                y(cVar);
                x(cVar);
                List<e> c2 = cVar.c();
                int size = c2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    r(c2.get(i2), i2);
                }
                if (this.f26864e || this.f26865f) {
                    return;
                }
                l(this.f26863d);
            }
        }
    }

    @Override // c.a.x0.h.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.x0.i.g.a aVar = this.f26877h;
            if (aVar != null) {
                aVar.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(c.a.x0.h.a aVar, int i2) {
        c.a.x0.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, aVar, i2) == null) || (cVar = this.f26863d) == null || cVar.c() == null || this.f26863d.c().get(i2) == null) {
            return;
        }
        this.f26863d.c().get(i2).a().add(aVar);
    }

    public final void r(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, eVar, i2) == null) || eVar == null || h.e(eVar.a()) || this.f26865f || this.f26864e) {
            return;
        }
        for (c.a.x0.h.a aVar : eVar.a()) {
            if (this.f26864e || this.f26865f) {
                return;
            }
            this.f26879j++;
            if (t(aVar)) {
                v(aVar, i2);
            } else {
                q(aVar, i2);
                i((int) (((this.f26879j * 1.0f) / this.f26878i) * 100.0f));
            }
        }
    }

    public final boolean t(c.a.x0.h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar == null || aVar.b() == null || !aVar.c()) {
                return false;
            }
            if (!c.a.x0.i.c.o(aVar.b().mSoundTypes) && aVar.b().mSpeed == 1.0f && aVar.b().start == 0 && aVar.b().end == -1 && aVar.b().volume == 1.0f) {
                return (aVar.a() == null || "audio/mp4a-latm".equals(aVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(c.a.x0.h.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, aVar, i2) == null) || this.f26865f || this.f26864e) {
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
            c.a.x0.i.g.a aVar2 = new c.a.x0.i.g.a(b2.audioPath, a2, b2.mSoundTypes);
            this.f26877h = aVar2;
            aVar2.S(new a(this, a2, i2, b2, aVar));
            this.f26877h.D(b2.mSoundTypes);
            this.f26877h.G(b2.mSpeed);
            this.f26877h.H(b2.volume);
            this.f26877h.B(b2.start);
            this.f26877h.R(b2.end);
            this.f26877h.I();
            synchronized (this) {
                wait();
            }
        } catch (Exception e2) {
            g("dealAudioPlayData exception:" + m.g(e2));
            e2.printStackTrace();
        }
    }

    public final void x(c.a.x0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || cVar == null || h.e(cVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cVar.c().size(); i2++) {
            arrayList.add(new e(new ArrayList()));
        }
        c.a.x0.h.c cVar2 = new c.a.x0.h.c(arrayList);
        this.f26863d = cVar2;
        cVar2.e(cVar.b());
        this.f26863d.d(cVar.a());
    }

    public final void y(c.a.x0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f26878i = 0;
            this.f26879j = 0;
            List<e> c2 = cVar.c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (c2.get(i2) != null && c2.get(i2).a() != null) {
                    this.f26878i += c2.get(i2).a().size();
                }
            }
        }
    }
}

package c.a.v0.h;

import androidx.core.view.InputDeviceCompat;
import c.a.v0.h.f.a;
import c.a.v0.r.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements a.InterfaceC1599a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public b f21559b;

    /* renamed from: c  reason: collision with root package name */
    public Thread f21560c;

    /* renamed from: d  reason: collision with root package name */
    public List<c.a.v0.h.f.a> f21561d;

    /* renamed from: e  reason: collision with root package name */
    public int f21562e;

    /* renamed from: f  reason: collision with root package name */
    public int f21563f;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.a;
                if (dVar.j(dVar.a)) {
                    if (h.e(this.a.f21561d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((c.a.v0.h.f.a) this.a.f21561d.get(0)).d(this.a.a);
                        return;
                    }
                }
                d dVar2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                dVar2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(c.a.v0.h.b bVar);
    }

    public d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.f21561d = new ArrayList();
    }

    @Override // c.a.v0.h.f.a.InterfaceC1599a
    public void a(c.a.v0.h.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            l();
        }
    }

    @Override // c.a.v0.h.f.a.InterfaceC1599a
    public void b(c.a.v0.h.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            int k = this.f21562e + aVar.k();
            this.f21562e = k;
            n(k);
            if (aVar == null || !aVar.m()) {
                return;
            }
            c.a.v0.h.b k2 = k(aVar.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // c.a.v0.h.f.a.InterfaceC1599a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.f21562e + (((i * 1.0f) / 100.0f) * i2))) <= this.f21563f) {
            return;
        }
        n(i3);
        this.f21563f = i3;
    }

    @Override // c.a.v0.h.f.a.InterfaceC1599a
    public void d(String str, c.a.v0.h.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!h.e(this.f21561d)) {
                for (c.a.v0.h.f.a aVar : this.f21561d) {
                    aVar.b();
                }
            }
            Thread thread = this.f21560c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null || h.e(cVar.c())) {
                return false;
            }
            List<e> c2 = cVar.c();
            c.a.v0.h.b bVar = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c2.size(); i2++) {
                if (c.a.v0.i.c.o(c2.get(i2).b())) {
                    z = true;
                }
                if (!h.e(c2.get(i2).a())) {
                    for (c.a.v0.h.a aVar : c2.get(i2).a()) {
                        if (aVar != null) {
                            if (aVar.c()) {
                                if (bVar == null) {
                                    bVar = aVar.a();
                                }
                                if (bVar != null) {
                                    int k = bVar.k(aVar.a());
                                    z2 = ((c.a.v0.h.b.f21549g & k) == 0 && (c.a.v0.h.b.i & k) == 0 && (k & c.a.v0.h.b.f21550h) == 0) ? false : true;
                                }
                                if (aVar.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(aVar.a().f())) {
                                    z = true;
                                }
                                z3 = true;
                            }
                            i++;
                            if (i > 1) {
                                z2 = true;
                            }
                            if (z2 && z && z3) {
                                break;
                            }
                        }
                    }
                }
                if (z2 && z && z3) {
                    break;
                }
            }
            if (z) {
                c.a.v0.h.f.c cVar2 = new c.a.v0.h.f.c();
                cVar2.c(z2 ? 50 : 90);
                cVar2.e(this);
                this.f21561d.add(cVar2);
                c.a.v0.h.f.b bVar2 = new c.a.v0.h.f.b();
                bVar2.c(z2 ? 50 : 10);
                bVar2.e(this);
                this.f21561d.add(bVar2);
                cVar2.f(bVar2);
            } else {
                c.a.v0.h.f.b bVar3 = new c.a.v0.h.f.b();
                bVar3.c(100);
                bVar3.e(this);
                this.f21561d.add(bVar3);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final c.a.v0.h.b k(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) {
            if (cVar != null && h.b(cVar.c()) == 1 && h.b(cVar.c().get(0).a()) == 1) {
                c.a.v0.h.a aVar = cVar.c().get(0).a().get(0);
                if (aVar.b() == null || aVar.b().isNeedEdit() || !aVar.c()) {
                    return null;
                }
                return aVar.a();
            }
            return null;
        }
        return (c.a.v0.h.b) invokeL.objValue;
    }

    public final void l() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bVar = this.f21559b) == null) {
            return;
        }
        bVar.onAudioMixtureCancel();
    }

    public final void m(String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (bVar = this.f21559b) == null) {
            return;
        }
        bVar.onAudioMixtureFail(str);
    }

    public final void n(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (bVar = this.f21559b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(i);
    }

    public final void o(c.a.v0.h.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) || (bVar2 = this.f21559b) == null) {
            return;
        }
        bVar2.onAudioMixtureProgress(100);
        this.f21559b.onAudioMixtureSuccess(bVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || h.e(this.f21561d)) {
            return;
        }
        for (c.a.v0.h.f.a aVar : this.f21561d) {
            aVar.h();
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f21559b = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f21561d.clear();
            this.f21562e = 0;
            this.f21563f = 0;
            c.a.v0.h.b k = k(this.a);
            if (k != null && k.i()) {
                o(k);
                return;
            }
            Thread thread = this.f21560c;
            if (thread != null) {
                thread.interrupt();
                this.f21560c = null;
            }
            Thread thread2 = new Thread(new a(this));
            this.f21560c = thread2;
            thread2.start();
        }
    }
}

package b.h.b.a.e0.l;

import androidx.core.view.InputDeviceCompat;
import b.h.b.a.e0.h;
import b.h.b.a.e0.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.LinkedList;
import java.util.PriorityQueue;
/* loaded from: classes6.dex */
public abstract class d implements b.h.b.a.e0.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<h> f33178a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<i> f33179b;

    /* renamed from: c  reason: collision with root package name */
    public final PriorityQueue<h> f33180c;

    /* renamed from: d  reason: collision with root package name */
    public h f33181d;

    /* renamed from: e  reason: collision with root package name */
    public long f33182e;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33178a = new LinkedList<>();
        for (int i4 = 0; i4 < 10; i4++) {
            this.f33178a.add(new h());
        }
        this.f33179b = new LinkedList<>();
        for (int i5 = 0; i5 < 2; i5++) {
            this.f33179b.add(new e(this));
        }
        this.f33180c = new PriorityQueue<>();
    }

    @Override // b.h.b.a.e0.f
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f33182e = j;
        }
    }

    public abstract b.h.b.a.e0.e e();

    public abstract void f(h hVar);

    @Override // b.h.b.a.y.c
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f33182e = 0L;
            while (!this.f33180c.isEmpty()) {
                k(this.f33180c.poll());
            }
            h hVar = this.f33181d;
            if (hVar != null) {
                k(hVar);
                this.f33181d = null;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.h.b.a.y.c
    /* renamed from: g */
    public h a() throws SubtitleDecoderException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            b.h.b.a.i0.a.f(this.f33181d == null);
            if (this.f33178a.isEmpty()) {
                return null;
            }
            h pollFirst = this.f33178a.pollFirst();
            this.f33181d = pollFirst;
            return pollFirst;
        }
        return (h) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.h.b.a.y.c
    /* renamed from: h */
    public i c() throws SubtitleDecoderException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f33179b.isEmpty()) {
                return null;
            }
            while (!this.f33180c.isEmpty() && this.f33180c.peek().f33760h <= this.f33182e) {
                h poll = this.f33180c.poll();
                if (poll.j()) {
                    i pollFirst = this.f33179b.pollFirst();
                    pollFirst.e(4);
                    k(poll);
                    return pollFirst;
                }
                f(poll);
                if (i()) {
                    b.h.b.a.e0.e e2 = e();
                    if (!poll.i()) {
                        i pollFirst2 = this.f33179b.pollFirst();
                        pollFirst2.n(poll.f33760h, e2, Long.MAX_VALUE);
                        k(poll);
                        return pollFirst2;
                    }
                }
                k(poll);
            }
            return null;
        }
        return (i) invokeV.objValue;
    }

    public abstract boolean i();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.h.b.a.y.c
    /* renamed from: j */
    public void d(h hVar) throws SubtitleDecoderException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
            b.h.b.a.i0.a.a(hVar == this.f33181d);
            if (hVar.i()) {
                k(hVar);
            } else {
                this.f33180c.add(hVar);
            }
            this.f33181d = null;
        }
    }

    public final void k(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
            hVar.f();
            this.f33178a.add(hVar);
        }
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
            iVar.f();
            this.f33179b.add(iVar);
        }
    }

    @Override // b.h.b.a.y.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }
}

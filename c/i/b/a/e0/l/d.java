package c.i.b.a.e0.l;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.e0.h;
import c.i.b.a.e0.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.LinkedList;
import java.util.PriorityQueue;
/* loaded from: classes4.dex */
public abstract class d implements c.i.b.a.e0.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedList<h> f33504a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<i> f33505b;

    /* renamed from: c  reason: collision with root package name */
    public final PriorityQueue<h> f33506c;

    /* renamed from: d  reason: collision with root package name */
    public h f33507d;

    /* renamed from: e  reason: collision with root package name */
    public long f33508e;

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
        this.f33504a = new LinkedList<>();
        for (int i4 = 0; i4 < 10; i4++) {
            this.f33504a.add(new h());
        }
        this.f33505b = new LinkedList<>();
        for (int i5 = 0; i5 < 2; i5++) {
            this.f33505b.add(new e(this));
        }
        this.f33506c = new PriorityQueue<>();
    }

    @Override // c.i.b.a.e0.f
    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f33508e = j2;
        }
    }

    public abstract c.i.b.a.e0.e e();

    public abstract void f(h hVar);

    @Override // c.i.b.a.y.c
    public void flush() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f33508e = 0L;
            while (!this.f33506c.isEmpty()) {
                k(this.f33506c.poll());
            }
            h hVar = this.f33507d;
            if (hVar != null) {
                k(hVar);
                this.f33507d = null;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.y.c
    /* renamed from: g */
    public h a() throws SubtitleDecoderException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            c.i.b.a.i0.a.f(this.f33507d == null);
            if (this.f33504a.isEmpty()) {
                return null;
            }
            h pollFirst = this.f33504a.pollFirst();
            this.f33507d = pollFirst;
            return pollFirst;
        }
        return (h) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.y.c
    /* renamed from: h */
    public i c() throws SubtitleDecoderException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f33505b.isEmpty()) {
                return null;
            }
            while (!this.f33506c.isEmpty() && this.f33506c.peek().f34113h <= this.f33508e) {
                h poll = this.f33506c.poll();
                if (poll.j()) {
                    i pollFirst = this.f33505b.pollFirst();
                    pollFirst.e(4);
                    k(poll);
                    return pollFirst;
                }
                f(poll);
                if (i()) {
                    c.i.b.a.e0.e e2 = e();
                    if (!poll.i()) {
                        i pollFirst2 = this.f33505b.pollFirst();
                        pollFirst2.n(poll.f34113h, e2, Long.MAX_VALUE);
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
    @Override // c.i.b.a.y.c
    /* renamed from: j */
    public void d(h hVar) throws SubtitleDecoderException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hVar) == null) {
            c.i.b.a.i0.a.a(hVar == this.f33507d);
            if (hVar.i()) {
                k(hVar);
            } else {
                this.f33506c.add(hVar);
            }
            this.f33507d = null;
        }
    }

    public final void k(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hVar) == null) {
            hVar.f();
            this.f33504a.add(hVar);
        }
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
            iVar.f();
            this.f33505b.add(iVar);
        }
    }

    @Override // c.i.b.a.y.c
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }
}

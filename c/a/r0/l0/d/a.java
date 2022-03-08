package c.a.r0.l0.d;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Comparable;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
/* loaded from: classes2.dex */
public class a<E extends Comparable<E>> extends AbstractList<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b<E> f18800e;

    /* renamed from: f  reason: collision with root package name */
    public int f18801f;

    /* renamed from: c.a.r0.l0.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C1177a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class b<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b<E> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f18802b;

        /* renamed from: c  reason: collision with root package name */
        public b<E> f18803c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f18804d;

        /* renamed from: e  reason: collision with root package name */
        public int f18805e;

        /* renamed from: f  reason: collision with root package name */
        public int f18806f;

        /* renamed from: g  reason: collision with root package name */
        public E f18807g;

        public /* synthetic */ b(int i2, Object obj, b bVar, b bVar2, C1177a c1177a) {
            this(i2, obj, bVar, bVar2);
        }

        public final void A(b<E> bVar, b<E> bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bVar, bVar2) == null) {
                boolean z = bVar == null;
                this.f18802b = z;
                if (z) {
                    bVar = bVar2;
                }
                this.a = bVar;
                t();
            }
        }

        public final int B(b<E> bVar, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2)) == null) {
                if (bVar == null) {
                    return 0;
                }
                int i3 = i(bVar);
                bVar.f18806f = i2;
                return i3;
            }
            return invokeLI.intValue;
        }

        public final void C(b<E> bVar, b<E> bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bVar, bVar2) == null) {
                boolean z = bVar == null;
                this.f18804d = z;
                if (z) {
                    bVar = bVar2;
                }
                this.f18803c = bVar;
                t();
            }
        }

        public void D(E e2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, e2) == null) {
                this.f18807g = e2;
            }
        }

        public void E(Object[] objArr, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, objArr, i2) == null) {
                objArr[i2] = this.f18807g;
                if (h() != null) {
                    b<E> bVar = this.a;
                    bVar.E(objArr, bVar.f18806f + i2);
                }
                if (j() != null) {
                    b<E> bVar2 = this.f18803c;
                    bVar2.E(objArr, i2 + bVar2.f18806f);
                }
            }
        }

        public final b<E> d(b<E> bVar, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, bVar, i2)) == null) {
                b<E> p = p();
                b<E> q = bVar.q();
                if (bVar.f18805e > this.f18805e) {
                    b<E> v = v();
                    ArrayDeque arrayDeque = new ArrayDeque();
                    b<E> bVar2 = bVar;
                    int i3 = bVar.f18806f + i2;
                    int i4 = 0;
                    while (bVar2 != null && bVar2.f18805e > g(v)) {
                        arrayDeque.push(bVar2);
                        bVar2 = bVar2.a;
                        if (bVar2 != null) {
                            i4 = i3;
                            i3 = bVar2.f18806f + i3;
                        } else {
                            i4 = i3;
                        }
                    }
                    p.A(v, null);
                    p.C(bVar2, q);
                    if (v != null) {
                        v.p().C(null, p);
                        v.f18806f -= i2 - 1;
                    }
                    if (bVar2 != null) {
                        bVar2.q().A(null, p);
                        bVar2.f18806f = (i3 - i2) + 1;
                    }
                    p.f18806f = (i2 - 1) - i4;
                    bVar.f18806f += i2;
                    while (!arrayDeque.isEmpty()) {
                        b bVar3 = (b) arrayDeque.pop();
                        bVar3.A(p, null);
                        p = bVar3.e();
                    }
                    return p;
                }
                b<E> w = bVar.w();
                ArrayDeque arrayDeque2 = new ArrayDeque();
                b<E> bVar4 = this;
                int i5 = this.f18806f;
                int i6 = 0;
                while (bVar4 != null && bVar4.f18805e > g(w)) {
                    arrayDeque2.push(bVar4);
                    bVar4 = bVar4.f18803c;
                    if (bVar4 != null) {
                        int i7 = i5;
                        i5 = bVar4.f18806f + i5;
                        i6 = i7;
                    } else {
                        i6 = i5;
                    }
                }
                q.C(w, null);
                q.A(bVar4, p);
                if (w != null) {
                    w.q().A(null, q);
                    w.f18806f++;
                }
                if (bVar4 != null) {
                    bVar4.p().C(null, q);
                    bVar4.f18806f = i5 - i2;
                }
                q.f18806f = i2 - i6;
                while (!arrayDeque2.isEmpty()) {
                    b bVar5 = (b) arrayDeque2.pop();
                    bVar5.C(q, null);
                    q = bVar5.e();
                }
                return q;
            }
            return (b) invokeLI.objValue;
        }

        public final b<E> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                int l = l();
                if (l == -2) {
                    if (this.a.l() > 0) {
                        A(this.a.y(), null);
                    }
                    return z();
                } else if (l == -1 || l == 0 || l == 1) {
                    return this;
                } else {
                    if (l == 2) {
                        if (this.f18803c.l() < 0) {
                            C(this.f18803c.z(), null);
                        }
                        return y();
                    }
                    throw new RuntimeException("tree inconsistent!");
                }
            }
            return (b) invokeV.objValue;
        }

        public b<E> f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                int i3 = i2 - this.f18806f;
                if (i3 == 0) {
                    return this;
                }
                b<E> h2 = i3 < 0 ? h() : j();
                if (h2 == null) {
                    return null;
                }
                return h2.f(i3);
            }
            return (b) invokeI.objValue;
        }

        public final int g(b<E> bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
                if (bVar == null) {
                    return -1;
                }
                return bVar.f18805e;
            }
            return invokeL.intValue;
        }

        public final b<E> h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                if (this.f18802b) {
                    return null;
                }
                return this.a;
            }
            return (b) invokeV.objValue;
        }

        public final int i(b<E> bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bVar)) == null) {
                if (bVar == null) {
                    return 0;
                }
                return bVar.f18806f;
            }
            return invokeL.intValue;
        }

        public b<E> insert(int i2, E e2) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, e2)) == null) {
                int i3 = i2 - this.f18806f;
                if (i3 <= 0) {
                    return n(i3, e2);
                }
                return o(i3, e2);
            }
            return (b) invokeIL.objValue;
        }

        public final b<E> j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                if (this.f18804d) {
                    return null;
                }
                return this.f18803c;
            }
            return (b) invokeV.objValue;
        }

        public E k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f18807g : (E) invokeV.objValue;
        }

        public final int l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? g(j()) - g(h()) : invokeV.intValue;
        }

        public int m(Object obj, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, obj, i2)) == null) {
                if (h() != null) {
                    b<E> bVar = this.a;
                    int m = bVar.m(obj, bVar.f18806f + i2);
                    if (m != -1) {
                        return m;
                    }
                }
                if (Objects.equals(this.f18807g, obj)) {
                    return i2;
                }
                if (j() != null) {
                    b<E> bVar2 = this.f18803c;
                    return bVar2.m(obj, i2 + bVar2.f18806f);
                }
                return -1;
            }
            return invokeLI.intValue;
        }

        public final b<E> n(int i2, E e2) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048592, this, i2, e2)) == null) {
                if (h() == null) {
                    A(new b<>(-1, e2, this, this.a), null);
                } else {
                    A(this.a.insert(i2, e2), null);
                }
                int i3 = this.f18806f;
                if (i3 >= 0) {
                    this.f18806f = i3 + 1;
                }
                b<E> e3 = e();
                t();
                return e3;
            }
            return (b) invokeIL.objValue;
        }

        public final b<E> o(int i2, E e2) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i2, e2)) == null) {
                if (j() == null) {
                    C(new b<>(1, e2, this.f18803c, this), null);
                } else {
                    C(this.f18803c.insert(i2, e2), null);
                }
                int i3 = this.f18806f;
                if (i3 < 0) {
                    this.f18806f = i3 - 1;
                }
                b<E> e3 = e();
                t();
                return e3;
            }
            return (b) invokeIL.objValue;
        }

        public final b<E> p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? j() == null ? this : this.f18803c.p() : (b) invokeV.objValue;
        }

        public final b<E> q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? h() == null ? this : this.a.q() : (b) invokeV.objValue;
        }

        public b<E> r() {
            InterceptResult invokeV;
            b<E> bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                if (!this.f18804d && (bVar = this.f18803c) != null) {
                    return bVar.q();
                }
                return this.f18803c;
            }
            return (b) invokeV.objValue;
        }

        public b<E> s() {
            InterceptResult invokeV;
            b<E> bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                if (!this.f18802b && (bVar = this.a) != null) {
                    return bVar.p();
                }
                return this.a;
            }
            return (b) invokeV.objValue;
        }

        public final void t() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                this.f18805e = Math.max(h() == null ? -1 : h().f18805e, j() != null ? j().f18805e : -1) + 1;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("AVLNode(");
                sb.append(this.f18806f);
                sb.append(",");
                sb.append(this.a != null);
                sb.append(",");
                sb.append(this.f18807g);
                sb.append(",");
                sb.append(j() != null);
                sb.append(", faedelung ");
                sb.append(this.f18804d);
                sb.append(" )");
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public b<E> u(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
                int i3 = i2 - this.f18806f;
                if (i3 == 0) {
                    return x();
                }
                if (i3 > 0) {
                    C(this.f18803c.u(i3), this.f18803c.f18803c);
                    int i4 = this.f18806f;
                    if (i4 < 0) {
                        this.f18806f = i4 + 1;
                    }
                } else {
                    A(this.a.u(i3), this.a.a);
                    int i5 = this.f18806f;
                    if (i5 > 0) {
                        this.f18806f = i5 - 1;
                    }
                }
                t();
                return e();
            }
            return (b) invokeI.objValue;
        }

        public final b<E> v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
                if (j() == null) {
                    return x();
                }
                C(this.f18803c.v(), this.f18803c.f18803c);
                int i2 = this.f18806f;
                if (i2 < 0) {
                    this.f18806f = i2 + 1;
                }
                t();
                return e();
            }
            return (b) invokeV.objValue;
        }

        public final b<E> w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                if (h() == null) {
                    return x();
                }
                A(this.a.w(), this.a.a);
                int i2 = this.f18806f;
                if (i2 > 0) {
                    this.f18806f = i2 - 1;
                }
                t();
                return e();
            }
            return (b) invokeV.objValue;
        }

        public final b<E> x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                if (j() == null && h() == null) {
                    return null;
                }
                if (j() == null) {
                    int i2 = this.f18806f;
                    if (i2 > 0) {
                        this.a.f18806f += i2;
                    }
                    this.a.p().C(null, this.f18803c);
                    return this.a;
                }
                if (h() == null) {
                    b<E> bVar = this.f18803c;
                    int i3 = bVar.f18806f;
                    int i4 = this.f18806f;
                    bVar.f18806f = i3 + (i4 - (i4 < 0 ? 0 : 1));
                    this.f18803c.q().A(null, this.a);
                    return this.f18803c;
                }
                if (l() > 0) {
                    b<E> q = this.f18803c.q();
                    this.f18807g = q.f18807g;
                    if (this.f18802b) {
                        this.a = q.a;
                    }
                    this.f18803c = this.f18803c.w();
                    int i5 = this.f18806f;
                    if (i5 < 0) {
                        this.f18806f = i5 + 1;
                    }
                } else {
                    b<E> p = this.a.p();
                    this.f18807g = p.f18807g;
                    if (this.f18804d) {
                        this.f18803c = p.f18803c;
                    }
                    b<E> bVar2 = this.a;
                    b<E> bVar3 = bVar2.a;
                    b<E> v = bVar2.v();
                    this.a = v;
                    if (v == null) {
                        this.a = bVar3;
                        this.f18802b = true;
                    }
                    int i6 = this.f18806f;
                    if (i6 > 0) {
                        this.f18806f = i6 - 1;
                    }
                }
                t();
                return this;
            }
            return (b) invokeV.objValue;
        }

        public final b<E> y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                b<E> bVar = this.f18803c;
                b<E> h2 = j().h();
                int i2 = this.f18806f + i(bVar);
                C(h2, bVar);
                bVar.A(this, null);
                B(bVar, i2);
                B(this, -bVar.f18806f);
                B(h2, i(bVar) + i(h2));
                return bVar;
            }
            return (b) invokeV.objValue;
        }

        public final b<E> z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                b<E> bVar = this.a;
                b<E> j2 = h().j();
                int i2 = this.f18806f + i(bVar);
                A(j2, bVar);
                bVar.C(this, null);
                B(bVar, i2);
                B(this, -bVar.f18806f);
                B(j2, i(bVar) + i(j2));
                return bVar;
            }
            return (b) invokeV.objValue;
        }

        public /* synthetic */ b(Collection collection, C1177a c1177a) {
            this(collection);
        }

        public b(int i2, E e2, b<E> bVar, b<E> bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), e2, bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18806f = i2;
            this.f18807g = e2;
            this.f18804d = true;
            this.f18802b = true;
            this.f18803c = bVar;
            this.a = bVar2;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(Collection<? extends E> collection) {
            this(collection.iterator(), 0, collection.size() - 1, 0, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {collection};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Iterator) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (b) objArr2[4], (b) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        public b(Iterator<? extends E> it, int i2, int i3, int i4, b<E> bVar, b<E> bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bVar, bVar2};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            int i7 = i2 + ((i3 - i2) / 2);
            if (i2 < i7) {
                this.a = new b<>(it, i2, i7 - 1, i7, bVar, this);
            } else {
                this.f18802b = true;
                this.a = bVar;
            }
            this.f18807g = it.next();
            this.f18806f = i7 - i4;
            if (i7 < i3) {
                this.f18803c = new b<>(it, i7 + 1, i3, i7, this, bVar2);
            } else {
                this.f18804d = true;
                this.f18803c = bVar2;
            }
            t();
        }
    }

    /* loaded from: classes2.dex */
    public static class c<E extends Comparable<E>> implements ListIterator<E>, Object<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final a<E> f18808e;

        /* renamed from: f  reason: collision with root package name */
        public b<E> f18809f;

        /* renamed from: g  reason: collision with root package name */
        public int f18810g;

        /* renamed from: h  reason: collision with root package name */
        public b<E> f18811h;

        /* renamed from: i  reason: collision with root package name */
        public int f18812i;

        /* renamed from: j  reason: collision with root package name */
        public int f18813j;

        public c(a<E> aVar, int i2) throws IndexOutOfBoundsException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18808e = aVar;
            this.f18813j = ((AbstractList) aVar).modCount;
            this.f18809f = aVar.f18800e == null ? null : aVar.f18800e.f(i2);
            this.f18810g = i2;
            this.f18812i = -1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator
        /* renamed from: a */
        public void add(E e2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, e2) == null) {
                b();
                this.f18808e.add(this.f18810g, e2);
                this.f18811h = null;
                this.f18812i = -1;
                this.f18810g++;
                this.f18813j++;
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && ((AbstractList) this.f18808e).modCount != this.f18813j) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c */
        public E next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                b();
                if (hasNext()) {
                    if (this.f18809f == null) {
                        this.f18809f = this.f18808e.f18800e.f(this.f18810g);
                    }
                    E k = this.f18809f.k();
                    b<E> bVar = this.f18809f;
                    this.f18811h = bVar;
                    int i2 = this.f18810g;
                    this.f18810g = i2 + 1;
                    this.f18812i = i2;
                    this.f18809f = bVar.r();
                    return k;
                }
                throw new NoSuchElementException("No element at index " + this.f18810g + ".");
            }
            return (E) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator
        /* renamed from: d */
        public E previous() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                b();
                if (hasPrevious()) {
                    b<E> bVar = this.f18809f;
                    if (bVar == null) {
                        this.f18809f = this.f18808e.f18800e.f(this.f18810g - 1);
                    } else {
                        this.f18809f = bVar.s();
                    }
                    E k = this.f18809f.k();
                    this.f18811h = this.f18809f;
                    int i2 = this.f18810g - 1;
                    this.f18810g = i2;
                    this.f18812i = i2;
                    return k;
                }
                throw new NoSuchElementException("Already at start of list.");
            }
            return (E) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator
        /* renamed from: e */
        public void set(E e2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, e2) == null) {
                b();
                b<E> bVar = this.f18811h;
                if (bVar != null) {
                    bVar.D(e2);
                    return;
                }
                throw new IllegalStateException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f18810g < this.f18808e.size() : invokeV.booleanValue;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f18810g > 0 : invokeV.booleanValue;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f18810g : invokeV.intValue;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? nextIndex() - 1 : invokeV.intValue;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                b();
                int i2 = this.f18812i;
                if (i2 != -1) {
                    this.f18808e.remove(i2);
                    int i3 = this.f18810g;
                    if (i3 != this.f18812i) {
                        this.f18810g = i3 - 1;
                    }
                    this.f18809f = null;
                    this.f18811h = null;
                    this.f18812i = -1;
                    this.f18813j++;
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    public a() {
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
            if (collection.isEmpty()) {
                return false;
            }
            ((AbstractList) this).modCount += collection.size();
            b<E> bVar = new b<>(collection, null);
            b<E> bVar2 = this.f18800e;
            if (bVar2 != null) {
                bVar = bVar2.d(bVar, this.f18801f);
            }
            this.f18800e = bVar;
            this.f18801f += collection.size();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ((AbstractList) this).modCount++;
            this.f18800e = null;
            this.f18801f = 0;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? indexOf(obj) >= 0 : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    /* renamed from: d */
    public void add(int i2, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, e2) == null) {
            ((AbstractList) this).modCount++;
            e(i2, 0, size());
            b<E> bVar = this.f18800e;
            if (bVar == null) {
                this.f18800e = new b<>(i2, e2, null, null, null);
            } else {
                this.f18800e = bVar.insert(i2, e2);
            }
            this.f18801f++;
        }
    }

    public final void e(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i2, i3, i4) == null) {
            if (i2 < i3 || i2 > i4) {
                throw new IndexOutOfBoundsException("Invalid index:" + i2 + ", size=" + size());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f */
    public E get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            e(i2, 0, size() - 1);
            return this.f18800e.f(i2).k();
        }
        return (E) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g */
    public E remove(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ((AbstractList) this).modCount++;
            e(i2, 0, size() - 1);
            E e2 = get(i2);
            this.f18800e = this.f18800e.u(i2);
            this.f18801f--;
            return e2;
        }
        return (E) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h */
    public E set(int i2, E e2) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, e2)) == null) {
            e(i2, 0, size() - 1);
            b<E> f2 = this.f18800e.f(i2);
            E e3 = (E) f2.f18807g;
            f2.D(e2);
            return e3;
        }
        return (E) invokeIL.objValue;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            b<E> bVar = this.f18800e;
            if (bVar == null) {
                return -1;
            }
            return bVar.m(obj, bVar.f18806f);
        }
        return invokeL.intValue;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NonNull
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? listIterator(0) : (Iterator) invokeV.objValue;
    }

    @Override // java.util.AbstractList, java.util.List
    @NonNull
    public ListIterator<E> listIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? listIterator(0) : (ListIterator) invokeV.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f18801f : invokeV.intValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NonNull
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Object[] objArr = new Object[size()];
            b<E> bVar = this.f18800e;
            if (bVar != null) {
                bVar.E(objArr, bVar.f18806f);
            }
            return objArr;
        }
        return (Object[]) invokeV.objValue;
    }

    public a(Collection<? extends E> collection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (collection.isEmpty()) {
            return;
        }
        this.f18800e = new b<>(collection, null);
        this.f18801f = collection.size();
    }

    @Override // java.util.AbstractList, java.util.List
    @NonNull
    public ListIterator<E> listIterator(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            e(i2, 0, size());
            return new c(this, i2);
        }
        return (ListIterator) invokeI.objValue;
    }
}

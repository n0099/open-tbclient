package c.b.b.n;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes3.dex */
public final class j implements Iterable<i>, Comparable<j> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final i[] a;

    /* renamed from: b  reason: collision with root package name */
    public final int f22486b;

    /* renamed from: c  reason: collision with root package name */
    public long f22487c;

    /* renamed from: d  reason: collision with root package name */
    public a<i> f22488d;

    /* loaded from: classes3.dex */
    public static class a<T> implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T[] a;

        /* renamed from: b  reason: collision with root package name */
        public b f22489b;

        /* renamed from: c  reason: collision with root package name */
        public b f22490c;

        public a(T[] tArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (c.b.b.q.f.a) {
                    return new b(this.a);
                }
                if (this.f22489b == null) {
                    this.f22489b = new b(this.a);
                    this.f22490c = new b(this.a);
                }
                b bVar = this.f22489b;
                if (!bVar.f22492c) {
                    bVar.f22491b = 0;
                    bVar.f22492c = true;
                    this.f22490c.f22492c = false;
                    return bVar;
                }
                b bVar2 = this.f22490c;
                bVar2.f22491b = 0;
                bVar2.f22492c = true;
                bVar.f22492c = false;
                return bVar2;
            }
            return (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b<T> implements Iterator<T>, Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f22491b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f22492c;

        public b(T[] tArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22492c = true;
            this.a = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f22492c) {
                    return this.f22491b < this.a.length;
                }
                throw new GdxRuntimeException("#iterator() cannot be used nested.");
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.f22491b;
                T[] tArr = this.a;
                if (i < tArr.length) {
                    if (this.f22492c) {
                        this.f22491b = i + 1;
                        return tArr[i];
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.f22491b));
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                throw new GdxRuntimeException("Remove not allowed.");
            }
        }
    }

    public j(i... iVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22487c = -1L;
        if (iVarArr.length != 0) {
            i[] iVarArr2 = new i[iVarArr.length];
            for (int i3 = 0; i3 < iVarArr.length; i3++) {
                iVarArr2[i3] = iVarArr[i3];
            }
            this.a = iVarArr2;
            this.f22486b = b();
            return;
        }
        throw new IllegalArgumentException("attributes must be >= 1");
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
            return invokeV.intValue;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            i[] iVarArr = this.a;
            if (i >= iVarArr.length) {
                return i2;
            }
            i iVar = iVarArr[i];
            iVar.f22482e = i2;
            i2 += iVar.k();
            i++;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar)) == null) {
            i[] iVarArr = this.a;
            int length = iVarArr.length;
            i[] iVarArr2 = jVar.a;
            if (length != iVarArr2.length) {
                return iVarArr.length - iVarArr2.length;
            }
            int i = (e() > jVar.e() ? 1 : (e() == jVar.e() ? 0 : -1));
            if (i != 0) {
                return i < 0 ? -1 : 1;
            }
            for (int length2 = this.a.length - 1; length2 >= 0; length2--) {
                i iVar = this.a[length2];
                i iVar2 = jVar.a[length2];
                int i2 = iVar.a;
                int i3 = iVar2.a;
                if (i2 != i3) {
                    return i2 - i3;
                }
                int i4 = iVar.f22484g;
                int i5 = iVar2.f22484g;
                if (i4 != i5) {
                    return i4 - i5;
                }
                int i6 = iVar.f22479b;
                int i7 = iVar2.f22479b;
                if (i6 != i7) {
                    return i6 - i7;
                }
                boolean z = iVar.f22480c;
                if (z != iVar2.f22480c) {
                    return z ? 1 : -1;
                }
                int i8 = iVar.f22481d;
                int i9 = iVar2.f22481d;
                if (i8 != i9) {
                    return i8 - i9;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public i d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.a[i] : (i) invokeI.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f22487c == -1) {
                long j = 0;
                int i = 0;
                while (true) {
                    i[] iVarArr = this.a;
                    if (i >= iVarArr.length) {
                        break;
                    }
                    j |= iVarArr[i].a;
                    i++;
                }
                this.f22487c = j;
            }
            return this.f22487c;
        }
        return invokeV.longValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, obj)) != null) {
            return invokeL.booleanValue;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.a.length != jVar.a.length) {
            return false;
        }
        int i = 0;
        while (true) {
            i[] iVarArr = this.a;
            if (i >= iVarArr.length) {
                return true;
            }
            if (!iVarArr[i].i(jVar.a[i])) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        i[] iVarArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return invokeV.intValue;
        }
        long length = this.a.length * 61;
        int i = 0;
        while (true) {
            if (i >= this.a.length) {
                return (int) (length ^ (length >> 32));
            }
            length = (length * 61) + iVarArr[i].hashCode();
            i++;
        }
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f22488d == null) {
                this.f22488d = new a<>(this.a);
            }
            return this.f22488d.iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.length : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            for (int i = 0; i < this.a.length; i++) {
                sb.append("(");
                sb.append(this.a[i].f22483f);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.a[i].a);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.a[i].f22479b);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.a[i].f22482e);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sb.append("\n");
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}

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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public final class j implements Iterable<i>, Comparable<j> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i[] f27489e;

    /* renamed from: f  reason: collision with root package name */
    public final int f27490f;

    /* renamed from: g  reason: collision with root package name */
    public long f27491g;

    /* renamed from: h  reason: collision with root package name */
    public a<i> f27492h;

    /* loaded from: classes7.dex */
    public static class a<T> implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final T[] f27493e;

        /* renamed from: f  reason: collision with root package name */
        public b f27494f;

        /* renamed from: g  reason: collision with root package name */
        public b f27495g;

        public a(T[] tArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27493e = tArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (c.b.b.q.f.a) {
                    return new b(this.f27493e);
                }
                if (this.f27494f == null) {
                    this.f27494f = new b(this.f27493e);
                    this.f27495g = new b(this.f27493e);
                }
                b bVar = this.f27494f;
                if (!bVar.f27498g) {
                    bVar.f27497f = 0;
                    bVar.f27498g = true;
                    this.f27495g.f27498g = false;
                    return bVar;
                }
                b bVar2 = this.f27495g;
                bVar2.f27497f = 0;
                bVar2.f27498g = true;
                bVar.f27498g = false;
                return bVar2;
            }
            return (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b<T> implements Iterator<T>, Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final T[] f27496e;

        /* renamed from: f  reason: collision with root package name */
        public int f27497f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f27498g;

        public b(T[] tArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27498g = true;
            this.f27496e = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f27498g) {
                    return this.f27497f < this.f27496e.length;
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
                int i2 = this.f27497f;
                T[] tArr = this.f27496e;
                if (i2 < tArr.length) {
                    if (this.f27498g) {
                        this.f27497f = i2 + 1;
                        return tArr[i2];
                    }
                    throw new GdxRuntimeException("#iterator() cannot be used nested.");
                }
                throw new NoSuchElementException(String.valueOf(this.f27497f));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27491g = -1L;
        if (iVarArr.length != 0) {
            i[] iVarArr2 = new i[iVarArr.length];
            for (int i4 = 0; i4 < iVarArr.length; i4++) {
                iVarArr2[i4] = iVarArr[i4];
            }
            this.f27489e = iVarArr2;
            this.f27490f = b();
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
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i[] iVarArr = this.f27489e;
            if (i2 >= iVarArr.length) {
                return i3;
            }
            i iVar = iVarArr[i2];
            iVar.f27485e = i3;
            i3 += iVar.k();
            i2++;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(j jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar)) == null) {
            i[] iVarArr = this.f27489e;
            int length = iVarArr.length;
            i[] iVarArr2 = jVar.f27489e;
            if (length != iVarArr2.length) {
                return iVarArr.length - iVarArr2.length;
            }
            int i2 = (e() > jVar.e() ? 1 : (e() == jVar.e() ? 0 : -1));
            if (i2 != 0) {
                return i2 < 0 ? -1 : 1;
            }
            for (int length2 = this.f27489e.length - 1; length2 >= 0; length2--) {
                i iVar = this.f27489e[length2];
                i iVar2 = jVar.f27489e[length2];
                int i3 = iVar.a;
                int i4 = iVar2.a;
                if (i3 != i4) {
                    return i3 - i4;
                }
                int i5 = iVar.f27487g;
                int i6 = iVar2.f27487g;
                if (i5 != i6) {
                    return i5 - i6;
                }
                int i7 = iVar.f27482b;
                int i8 = iVar2.f27482b;
                if (i7 != i8) {
                    return i7 - i8;
                }
                boolean z = iVar.f27483c;
                if (z != iVar2.f27483c) {
                    return z ? 1 : -1;
                }
                int i9 = iVar.f27484d;
                int i10 = iVar2.f27484d;
                if (i9 != i10) {
                    return i9 - i10;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public i d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f27489e[i2] : (i) invokeI.objValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f27491g == -1) {
                long j2 = 0;
                int i2 = 0;
                while (true) {
                    i[] iVarArr = this.f27489e;
                    if (i2 >= iVarArr.length) {
                        break;
                    }
                    j2 |= iVarArr[i2].a;
                    i2++;
                }
                this.f27491g = j2;
            }
            return this.f27491g;
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
        if (this.f27489e.length != jVar.f27489e.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            i[] iVarArr = this.f27489e;
            if (i2 >= iVarArr.length) {
                return true;
            }
            if (!iVarArr[i2].i(jVar.f27489e[i2])) {
                return false;
            }
            i2++;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        i[] iVarArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048582, this)) != null) {
            return invokeV.intValue;
        }
        long length = this.f27489e.length * 61;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f27489e.length) {
                return (int) (length ^ (length >> 32));
            }
            length = (length * 61) + iVarArr[i2].hashCode();
            i2++;
        }
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f27492h == null) {
                this.f27492h = new a<>(this.f27489e);
            }
            return this.f27492h.iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f27489e.length : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            for (int i2 = 0; i2 < this.f27489e.length; i2++) {
                sb.append("(");
                sb.append(this.f27489e[i2].f27486f);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.f27489e[i2].a);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.f27489e[i2].f27482b);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.f27489e[i2].f27485e);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                sb.append(StringUtils.LF);
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}

package c.d.b.e0.k;

import android.net.http.Headers;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final c.d.b.e0.k.a[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<ByteString, Integer> f28586b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<c.d.b.e0.k.a> a;

        /* renamed from: b  reason: collision with root package name */
        public final BufferedSource f28587b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28588c;

        /* renamed from: d  reason: collision with root package name */
        public int f28589d;

        /* renamed from: e  reason: collision with root package name */
        public c.d.b.e0.k.a[] f28590e;

        /* renamed from: f  reason: collision with root package name */
        public int f28591f;

        /* renamed from: g  reason: collision with root package name */
        public int f28592g;

        /* renamed from: h  reason: collision with root package name */
        public int f28593h;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(int i2, Source source) {
            this(i2, i2, source);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), source};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (Source) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public final void a() {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f28589d) >= (i3 = this.f28593h)) {
                return;
            }
            if (i2 == 0) {
                b();
            } else {
                d(i3 - i2);
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Arrays.fill(this.f28590e, (Object) null);
                this.f28591f = this.f28590e.length - 1;
                this.f28592g = 0;
                this.f28593h = 0;
            }
        }

        public final int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f28591f + 1 + i2 : invokeI.intValue;
        }

        public final int d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = 0;
                if (i2 > 0) {
                    int length = this.f28590e.length;
                    while (true) {
                        length--;
                        if (length < this.f28591f || i2 <= 0) {
                            break;
                        }
                        c.d.b.e0.k.a[] aVarArr = this.f28590e;
                        i2 -= aVarArr[length].f28585c;
                        this.f28593h -= aVarArr[length].f28585c;
                        this.f28592g--;
                        i3++;
                    }
                    c.d.b.e0.k.a[] aVarArr2 = this.f28590e;
                    int i4 = this.f28591f;
                    System.arraycopy(aVarArr2, i4 + 1, aVarArr2, i4 + 1 + i3, this.f28592g);
                    this.f28591f += i3;
                }
                return i3;
            }
            return invokeI.intValue;
        }

        public List<c.d.b.e0.k.a> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ArrayList arrayList = new ArrayList(this.a);
                this.a.clear();
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public final ByteString f(int i2) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                if (h(i2)) {
                    return b.a[i2].a;
                }
                int c2 = c(i2 - b.a.length);
                if (c2 >= 0) {
                    c.d.b.e0.k.a[] aVarArr = this.f28590e;
                    if (c2 < aVarArr.length) {
                        return aVarArr[c2].a;
                    }
                }
                throw new IOException("Header index too large " + (i2 + 1));
            }
            return (ByteString) invokeI.objValue;
        }

        public final void g(int i2, c.d.b.e0.k.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i2, aVar) == null) {
                this.a.add(aVar);
                int i3 = aVar.f28585c;
                if (i2 != -1) {
                    i3 -= this.f28590e[c(i2)].f28585c;
                }
                int i4 = this.f28589d;
                if (i3 > i4) {
                    b();
                    return;
                }
                int d2 = d((this.f28593h + i3) - i4);
                if (i2 == -1) {
                    int i5 = this.f28592g + 1;
                    c.d.b.e0.k.a[] aVarArr = this.f28590e;
                    if (i5 > aVarArr.length) {
                        c.d.b.e0.k.a[] aVarArr2 = new c.d.b.e0.k.a[aVarArr.length * 2];
                        System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                        this.f28591f = this.f28590e.length - 1;
                        this.f28590e = aVarArr2;
                    }
                    int i6 = this.f28591f;
                    this.f28591f = i6 - 1;
                    this.f28590e[i6] = aVar;
                    this.f28592g++;
                } else {
                    this.f28590e[i2 + c(i2) + d2] = aVar;
                }
                this.f28593h += i3;
            }
        }

        public final boolean h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 >= 0 && i2 <= b.a.length - 1 : invokeI.booleanValue;
        }

        public final int i() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f28587b.readByte() & 255 : invokeV.intValue;
        }

        public ByteString j() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int i2 = i();
                boolean z = (i2 & 128) == 128;
                int m = m(i2, 127);
                if (z) {
                    return ByteString.of(i.f().c(this.f28587b.readByteArray(m)));
                }
                return this.f28587b.readByteString(m);
            }
            return (ByteString) invokeV.objValue;
        }

        public void k() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                while (!this.f28587b.exhausted()) {
                    int readByte = this.f28587b.readByte() & 255;
                    if (readByte == 128) {
                        throw new IOException("index == 0");
                    }
                    if ((readByte & 128) == 128) {
                        l(m(readByte, 127) - 1);
                    } else if (readByte == 64) {
                        o();
                    } else if ((readByte & 64) == 64) {
                        n(m(readByte, 63) - 1);
                    } else if ((readByte & 32) == 32) {
                        int m = m(readByte, 31);
                        this.f28589d = m;
                        if (m >= 0 && m <= this.f28588c) {
                            a();
                        } else {
                            throw new IOException("Invalid dynamic table size update " + this.f28589d);
                        }
                    } else if (readByte != 16 && readByte != 0) {
                        p(m(readByte, 15) - 1);
                    } else {
                        q();
                    }
                }
            }
        }

        public final void l(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
                if (h(i2)) {
                    this.a.add(b.a[i2]);
                    return;
                }
                int c2 = c(i2 - b.a.length);
                if (c2 >= 0) {
                    c.d.b.e0.k.a[] aVarArr = this.f28590e;
                    if (c2 < aVarArr.length) {
                        this.a.add(aVarArr[c2]);
                        return;
                    }
                }
                throw new IOException("Header index too large " + (i2 + 1));
            }
        }

        public int m(int i2, int i3) throws IOException {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeII = interceptable.invokeII(1048588, this, i2, i3)) != null) {
                return invokeII.intValue;
            }
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int i6 = i();
                if ((i6 & 128) == 0) {
                    return i3 + (i6 << i5);
                }
                i3 += (i6 & 127) << i5;
                i5 += 7;
            }
        }

        public final void n(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
                g(-1, new c.d.b.e0.k.a(f(i2), j()));
            }
        }

        public final void o() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                ByteString j2 = j();
                b.a(j2);
                g(-1, new c.d.b.e0.k.a(j2, j()));
            }
        }

        public final void p(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
                this.a.add(new c.d.b.e0.k.a(f(i2), j()));
            }
        }

        public final void q() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                ByteString j2 = j();
                b.a(j2);
                this.a.add(new c.d.b.e0.k.a(j2, j()));
            }
        }

        public a(int i2, int i3, Source source) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), source};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new ArrayList();
            c.d.b.e0.k.a[] aVarArr = new c.d.b.e0.k.a[8];
            this.f28590e = aVarArr;
            this.f28591f = aVarArr.length - 1;
            this.f28592g = 0;
            this.f28593h = 0;
            this.f28588c = i2;
            this.f28589d = i3;
            this.f28587b = Okio.buffer(source);
        }
    }

    /* renamed from: c.d.b.e0.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1606b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Buffer a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f28594b;

        /* renamed from: c  reason: collision with root package name */
        public int f28595c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f28596d;

        /* renamed from: e  reason: collision with root package name */
        public int f28597e;

        /* renamed from: f  reason: collision with root package name */
        public c.d.b.e0.k.a[] f28598f;

        /* renamed from: g  reason: collision with root package name */
        public int f28599g;

        /* renamed from: h  reason: collision with root package name */
        public int f28600h;

        /* renamed from: i  reason: collision with root package name */
        public int f28601i;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C1606b(Buffer buffer) {
            this(4096, true, buffer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buffer};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (Buffer) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public final void a() {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f28597e) >= (i3 = this.f28601i)) {
                return;
            }
            if (i2 == 0) {
                b();
            } else {
                c(i3 - i2);
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                Arrays.fill(this.f28598f, (Object) null);
                this.f28599g = this.f28598f.length - 1;
                this.f28600h = 0;
                this.f28601i = 0;
            }
        }

        public final int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int i3 = 0;
                if (i2 > 0) {
                    int length = this.f28598f.length;
                    while (true) {
                        length--;
                        if (length < this.f28599g || i2 <= 0) {
                            break;
                        }
                        c.d.b.e0.k.a[] aVarArr = this.f28598f;
                        i2 -= aVarArr[length].f28585c;
                        this.f28601i -= aVarArr[length].f28585c;
                        this.f28600h--;
                        i3++;
                    }
                    c.d.b.e0.k.a[] aVarArr2 = this.f28598f;
                    int i4 = this.f28599g;
                    System.arraycopy(aVarArr2, i4 + 1, aVarArr2, i4 + 1 + i3, this.f28600h);
                    c.d.b.e0.k.a[] aVarArr3 = this.f28598f;
                    int i5 = this.f28599g;
                    Arrays.fill(aVarArr3, i5 + 1, i5 + 1 + i3, (Object) null);
                    this.f28599g += i3;
                }
                return i3;
            }
            return invokeI.intValue;
        }

        public final void d(c.d.b.e0.k.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                int i2 = aVar.f28585c;
                int i3 = this.f28597e;
                if (i2 > i3) {
                    b();
                    return;
                }
                c((this.f28601i + i2) - i3);
                int i4 = this.f28600h + 1;
                c.d.b.e0.k.a[] aVarArr = this.f28598f;
                if (i4 > aVarArr.length) {
                    c.d.b.e0.k.a[] aVarArr2 = new c.d.b.e0.k.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f28599g = this.f28598f.length - 1;
                    this.f28598f = aVarArr2;
                }
                int i5 = this.f28599g;
                this.f28599g = i5 - 1;
                this.f28598f[i5] = aVar;
                this.f28600h++;
                this.f28601i += i2;
            }
        }

        public void e(int i2) {
            int min;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (i3 = this.f28597e) == (min = Math.min(i2, 16384))) {
                return;
            }
            if (min < i3) {
                this.f28595c = Math.min(this.f28595c, min);
            }
            this.f28596d = true;
            this.f28597e = min;
            a();
        }

        public void f(ByteString byteString) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, byteString) == null) {
                if (this.f28594b && i.f().e(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    i.f().d(byteString, buffer);
                    ByteString readByteString = buffer.readByteString();
                    h(readByteString.size(), 127, 128);
                    this.a.write(readByteString);
                    return;
                }
                h(byteString.size(), 127, 0);
                this.a.write(byteString);
            }
        }

        public void g(List<c.d.b.e0.k.a> list) throws IOException {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
                if (this.f28596d) {
                    int i4 = this.f28595c;
                    if (i4 < this.f28597e) {
                        h(i4, 31, 32);
                    }
                    this.f28596d = false;
                    this.f28595c = Integer.MAX_VALUE;
                    h(this.f28597e, 31, 32);
                }
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    c.d.b.e0.k.a aVar = list.get(i5);
                    ByteString asciiLowercase = aVar.a.toAsciiLowercase();
                    ByteString byteString = aVar.f28584b;
                    Integer num = b.f28586b.get(asciiLowercase);
                    if (num != null) {
                        i2 = num.intValue() + 1;
                        if (i2 > 1 && i2 < 8) {
                            if (c.d.b.e0.e.p(b.a[i2 - 1].f28584b, byteString)) {
                                i3 = i2;
                            } else if (c.d.b.e0.e.p(b.a[i2].f28584b, byteString)) {
                                i3 = i2;
                                i2++;
                            }
                        }
                        i3 = i2;
                        i2 = -1;
                    } else {
                        i2 = -1;
                        i3 = -1;
                    }
                    if (i2 == -1) {
                        int i6 = this.f28599g + 1;
                        int length = this.f28598f.length;
                        while (true) {
                            if (i6 >= length) {
                                break;
                            }
                            if (c.d.b.e0.e.p(this.f28598f[i6].a, asciiLowercase)) {
                                if (c.d.b.e0.e.p(this.f28598f[i6].f28584b, byteString)) {
                                    i2 = b.a.length + (i6 - this.f28599g);
                                    break;
                                } else if (i3 == -1) {
                                    i3 = (i6 - this.f28599g) + b.a.length;
                                }
                            }
                            i6++;
                        }
                    }
                    if (i2 != -1) {
                        h(i2, 127, 128);
                    } else if (i3 == -1) {
                        this.a.writeByte(64);
                        f(asciiLowercase);
                        f(byteString);
                        d(aVar);
                    } else if (asciiLowercase.startsWith(c.d.b.e0.k.a.f28578d) && !c.d.b.e0.k.a.f28583i.equals(asciiLowercase)) {
                        h(i3, 15, 0);
                        f(byteString);
                    } else {
                        h(i3, 63, 64);
                        f(byteString);
                        d(aVar);
                    }
                }
            }
        }

        public void h(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048583, this, i2, i3, i4) == null) {
                if (i2 < i3) {
                    this.a.writeByte(i2 | i4);
                    return;
                }
                this.a.writeByte(i4 | i3);
                int i5 = i2 - i3;
                while (i5 >= 128) {
                    this.a.writeByte(128 | (i5 & 127));
                    i5 >>>= 7;
                }
                this.a.writeByte(i5);
            }
        }

        public C1606b(int i2, boolean z, Buffer buffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), buffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28595c = Integer.MAX_VALUE;
            c.d.b.e0.k.a[] aVarArr = new c.d.b.e0.k.a[8];
            this.f28598f = aVarArr;
            this.f28599g = aVarArr.length - 1;
            this.f28600h = 0;
            this.f28601i = 0;
            this.f28597e = i2;
            this.f28594b = z;
            this.a = buffer;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1090404783, "Lc/d/b/e0/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1090404783, "Lc/d/b/e0/k/b;");
                return;
            }
        }
        a = new c.d.b.e0.k.a[]{new c.d.b.e0.k.a(c.d.b.e0.k.a.f28583i, ""), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28580f, "GET"), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28580f, "POST"), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28581g, "/"), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28581g, "/index.html"), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28582h, "http"), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28582h, "https"), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28579e, BasicPushStatus.SUCCESS_CODE), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28579e, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE204), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28579e, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE206), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28579e, "304"), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28579e, FontParser.sFontWeightDefault), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28579e, "404"), new c.d.b.e0.k.a(c.d.b.e0.k.a.f28579e, "500"), new c.d.b.e0.k.a("accept-charset", ""), new c.d.b.e0.k.a("accept-encoding", "gzip, deflate"), new c.d.b.e0.k.a("accept-language", ""), new c.d.b.e0.k.a(Headers.ACCEPT_RANGES, ""), new c.d.b.e0.k.a(BOSTokenRequest.ACCEPT, ""), new c.d.b.e0.k.a("access-control-allow-origin", ""), new c.d.b.e0.k.a("age", ""), new c.d.b.e0.k.a("allow", ""), new c.d.b.e0.k.a("authorization", ""), new c.d.b.e0.k.a(Headers.CACHE_CONTROL, ""), new c.d.b.e0.k.a(Headers.CONTENT_DISPOSITION, ""), new c.d.b.e0.k.a(Headers.CONTENT_ENCODING, ""), new c.d.b.e0.k.a("content-language", ""), new c.d.b.e0.k.a(Headers.CONTENT_LEN, ""), new c.d.b.e0.k.a("content-location", ""), new c.d.b.e0.k.a("content-range", ""), new c.d.b.e0.k.a("content-type", ""), new c.d.b.e0.k.a("cookie", ""), new c.d.b.e0.k.a("date", ""), new c.d.b.e0.k.a("etag", ""), new c.d.b.e0.k.a("expect", ""), new c.d.b.e0.k.a("expires", ""), new c.d.b.e0.k.a("from", ""), new c.d.b.e0.k.a("host", ""), new c.d.b.e0.k.a("if-match", ""), new c.d.b.e0.k.a("if-modified-since", ""), new c.d.b.e0.k.a("if-none-match", ""), new c.d.b.e0.k.a("if-range", ""), new c.d.b.e0.k.a("if-unmodified-since", ""), new c.d.b.e0.k.a(Headers.LAST_MODIFIED, ""), new c.d.b.e0.k.a("link", ""), new c.d.b.e0.k.a("location", ""), new c.d.b.e0.k.a("max-forwards", ""), new c.d.b.e0.k.a(Headers.PROXY_AUTHENTICATE, ""), new c.d.b.e0.k.a("proxy-authorization", ""), new c.d.b.e0.k.a("range", ""), new c.d.b.e0.k.a("referer", ""), new c.d.b.e0.k.a("refresh", ""), new c.d.b.e0.k.a("retry-after", ""), new c.d.b.e0.k.a("server", ""), new c.d.b.e0.k.a(Headers.SET_COOKIE, ""), new c.d.b.e0.k.a("strict-transport-security", ""), new c.d.b.e0.k.a(Headers.TRANSFER_ENCODING, ""), new c.d.b.e0.k.a("user-agent", ""), new c.d.b.e0.k.a("vary", ""), new c.d.b.e0.k.a("via", ""), new c.d.b.e0.k.a(Headers.WWW_AUTHENTICATE, "")};
        f28586b = b();
    }

    public static ByteString a(ByteString byteString) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, byteString)) == null) {
            int size = byteString.size();
            for (int i2 = 0; i2 < size; i2++) {
                byte b2 = byteString.getByte(i2);
                if (b2 >= 65 && b2 <= 90) {
                    throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
                }
            }
            return byteString;
        }
        return (ByteString) invokeL.objValue;
    }

    public static Map<ByteString, Integer> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (Map) invokeV.objValue;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        int i2 = 0;
        while (true) {
            c.d.b.e0.k.a[] aVarArr = a;
            if (i2 < aVarArr.length) {
                if (!linkedHashMap.containsKey(aVarArr[i2].a)) {
                    linkedHashMap.put(a[i2].a, Integer.valueOf(i2));
                }
                i2++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }
}

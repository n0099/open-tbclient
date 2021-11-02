package b.d.b.e0.k;

import android.net.http.Headers;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.countly.XAdRemoteSDKCountly;
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
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final b.d.b.e0.k.a[] f30317a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<ByteString, Integer> f30318b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<b.d.b.e0.k.a> f30319a;

        /* renamed from: b  reason: collision with root package name */
        public final BufferedSource f30320b;

        /* renamed from: c  reason: collision with root package name */
        public final int f30321c;

        /* renamed from: d  reason: collision with root package name */
        public int f30322d;

        /* renamed from: e  reason: collision with root package name */
        public b.d.b.e0.k.a[] f30323e;

        /* renamed from: f  reason: collision with root package name */
        public int f30324f;

        /* renamed from: g  reason: collision with root package name */
        public int f30325g;

        /* renamed from: h  reason: collision with root package name */
        public int f30326h;

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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f30322d) >= (i3 = this.f30326h)) {
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
                Arrays.fill(this.f30323e, (Object) null);
                this.f30324f = this.f30323e.length - 1;
                this.f30325g = 0;
                this.f30326h = 0;
            }
        }

        public final int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f30324f + 1 + i2 : invokeI.intValue;
        }

        public final int d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = 0;
                if (i2 > 0) {
                    int length = this.f30323e.length;
                    while (true) {
                        length--;
                        if (length < this.f30324f || i2 <= 0) {
                            break;
                        }
                        b.d.b.e0.k.a[] aVarArr = this.f30323e;
                        i2 -= aVarArr[length].f30316c;
                        this.f30326h -= aVarArr[length].f30316c;
                        this.f30325g--;
                        i3++;
                    }
                    b.d.b.e0.k.a[] aVarArr2 = this.f30323e;
                    int i4 = this.f30324f;
                    System.arraycopy(aVarArr2, i4 + 1, aVarArr2, i4 + 1 + i3, this.f30325g);
                    this.f30324f += i3;
                }
                return i3;
            }
            return invokeI.intValue;
        }

        public List<b.d.b.e0.k.a> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ArrayList arrayList = new ArrayList(this.f30319a);
                this.f30319a.clear();
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public final ByteString f(int i2) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                if (h(i2)) {
                    return b.f30317a[i2].f30314a;
                }
                int c2 = c(i2 - b.f30317a.length);
                if (c2 >= 0) {
                    b.d.b.e0.k.a[] aVarArr = this.f30323e;
                    if (c2 < aVarArr.length) {
                        return aVarArr[c2].f30314a;
                    }
                }
                throw new IOException("Header index too large " + (i2 + 1));
            }
            return (ByteString) invokeI.objValue;
        }

        public final void g(int i2, b.d.b.e0.k.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i2, aVar) == null) {
                this.f30319a.add(aVar);
                int i3 = aVar.f30316c;
                if (i2 != -1) {
                    i3 -= this.f30323e[c(i2)].f30316c;
                }
                int i4 = this.f30322d;
                if (i3 > i4) {
                    b();
                    return;
                }
                int d2 = d((this.f30326h + i3) - i4);
                if (i2 == -1) {
                    int i5 = this.f30325g + 1;
                    b.d.b.e0.k.a[] aVarArr = this.f30323e;
                    if (i5 > aVarArr.length) {
                        b.d.b.e0.k.a[] aVarArr2 = new b.d.b.e0.k.a[aVarArr.length * 2];
                        System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                        this.f30324f = this.f30323e.length - 1;
                        this.f30323e = aVarArr2;
                    }
                    int i6 = this.f30324f;
                    this.f30324f = i6 - 1;
                    this.f30323e[i6] = aVar;
                    this.f30325g++;
                } else {
                    this.f30323e[i2 + c(i2) + d2] = aVar;
                }
                this.f30326h += i3;
            }
        }

        public final boolean h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 >= 0 && i2 <= b.f30317a.length - 1 : invokeI.booleanValue;
        }

        public final int i() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f30320b.readByte() & 255 : invokeV.intValue;
        }

        public ByteString j() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int i2 = i();
                boolean z = (i2 & 128) == 128;
                int m = m(i2, 127);
                if (z) {
                    return ByteString.of(i.f().c(this.f30320b.readByteArray(m)));
                }
                return this.f30320b.readByteString(m);
            }
            return (ByteString) invokeV.objValue;
        }

        public void k() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                while (!this.f30320b.exhausted()) {
                    int readByte = this.f30320b.readByte() & 255;
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
                        this.f30322d = m;
                        if (m >= 0 && m <= this.f30321c) {
                            a();
                        } else {
                            throw new IOException("Invalid dynamic table size update " + this.f30322d);
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
                    this.f30319a.add(b.f30317a[i2]);
                    return;
                }
                int c2 = c(i2 - b.f30317a.length);
                if (c2 >= 0) {
                    b.d.b.e0.k.a[] aVarArr = this.f30323e;
                    if (c2 < aVarArr.length) {
                        this.f30319a.add(aVarArr[c2]);
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
                g(-1, new b.d.b.e0.k.a(f(i2), j()));
            }
        }

        public final void o() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                ByteString j = j();
                b.a(j);
                g(-1, new b.d.b.e0.k.a(j, j()));
            }
        }

        public final void p(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
                this.f30319a.add(new b.d.b.e0.k.a(f(i2), j()));
            }
        }

        public final void q() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                ByteString j = j();
                b.a(j);
                this.f30319a.add(new b.d.b.e0.k.a(j, j()));
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
            this.f30319a = new ArrayList();
            b.d.b.e0.k.a[] aVarArr = new b.d.b.e0.k.a[8];
            this.f30323e = aVarArr;
            this.f30324f = aVarArr.length - 1;
            this.f30325g = 0;
            this.f30326h = 0;
            this.f30321c = i2;
            this.f30322d = i3;
            this.f30320b = Okio.buffer(source);
        }
    }

    /* renamed from: b.d.b.e0.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1449b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Buffer f30327a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f30328b;

        /* renamed from: c  reason: collision with root package name */
        public int f30329c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f30330d;

        /* renamed from: e  reason: collision with root package name */
        public int f30331e;

        /* renamed from: f  reason: collision with root package name */
        public b.d.b.e0.k.a[] f30332f;

        /* renamed from: g  reason: collision with root package name */
        public int f30333g;

        /* renamed from: h  reason: collision with root package name */
        public int f30334h;

        /* renamed from: i  reason: collision with root package name */
        public int f30335i;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C1449b(Buffer buffer) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f30331e) >= (i3 = this.f30335i)) {
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
                Arrays.fill(this.f30332f, (Object) null);
                this.f30333g = this.f30332f.length - 1;
                this.f30334h = 0;
                this.f30335i = 0;
            }
        }

        public final int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int i3 = 0;
                if (i2 > 0) {
                    int length = this.f30332f.length;
                    while (true) {
                        length--;
                        if (length < this.f30333g || i2 <= 0) {
                            break;
                        }
                        b.d.b.e0.k.a[] aVarArr = this.f30332f;
                        i2 -= aVarArr[length].f30316c;
                        this.f30335i -= aVarArr[length].f30316c;
                        this.f30334h--;
                        i3++;
                    }
                    b.d.b.e0.k.a[] aVarArr2 = this.f30332f;
                    int i4 = this.f30333g;
                    System.arraycopy(aVarArr2, i4 + 1, aVarArr2, i4 + 1 + i3, this.f30334h);
                    b.d.b.e0.k.a[] aVarArr3 = this.f30332f;
                    int i5 = this.f30333g;
                    Arrays.fill(aVarArr3, i5 + 1, i5 + 1 + i3, (Object) null);
                    this.f30333g += i3;
                }
                return i3;
            }
            return invokeI.intValue;
        }

        public final void d(b.d.b.e0.k.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                int i2 = aVar.f30316c;
                int i3 = this.f30331e;
                if (i2 > i3) {
                    b();
                    return;
                }
                c((this.f30335i + i2) - i3);
                int i4 = this.f30334h + 1;
                b.d.b.e0.k.a[] aVarArr = this.f30332f;
                if (i4 > aVarArr.length) {
                    b.d.b.e0.k.a[] aVarArr2 = new b.d.b.e0.k.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f30333g = this.f30332f.length - 1;
                    this.f30332f = aVarArr2;
                }
                int i5 = this.f30333g;
                this.f30333g = i5 - 1;
                this.f30332f[i5] = aVar;
                this.f30334h++;
                this.f30335i += i2;
            }
        }

        public void e(int i2) {
            int min;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (i3 = this.f30331e) == (min = Math.min(i2, 16384))) {
                return;
            }
            if (min < i3) {
                this.f30329c = Math.min(this.f30329c, min);
            }
            this.f30330d = true;
            this.f30331e = min;
            a();
        }

        public void f(ByteString byteString) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, byteString) == null) {
                if (this.f30328b && i.f().e(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    i.f().d(byteString, buffer);
                    ByteString readByteString = buffer.readByteString();
                    h(readByteString.size(), 127, 128);
                    this.f30327a.write(readByteString);
                    return;
                }
                h(byteString.size(), 127, 0);
                this.f30327a.write(byteString);
            }
        }

        public void g(List<b.d.b.e0.k.a> list) throws IOException {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
                if (this.f30330d) {
                    int i4 = this.f30329c;
                    if (i4 < this.f30331e) {
                        h(i4, 31, 32);
                    }
                    this.f30330d = false;
                    this.f30329c = Integer.MAX_VALUE;
                    h(this.f30331e, 31, 32);
                }
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    b.d.b.e0.k.a aVar = list.get(i5);
                    ByteString asciiLowercase = aVar.f30314a.toAsciiLowercase();
                    ByteString byteString = aVar.f30315b;
                    Integer num = b.f30318b.get(asciiLowercase);
                    if (num != null) {
                        i2 = num.intValue() + 1;
                        if (i2 > 1 && i2 < 8) {
                            if (b.d.b.e0.e.p(b.f30317a[i2 - 1].f30315b, byteString)) {
                                i3 = i2;
                            } else if (b.d.b.e0.e.p(b.f30317a[i2].f30315b, byteString)) {
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
                        int i6 = this.f30333g + 1;
                        int length = this.f30332f.length;
                        while (true) {
                            if (i6 >= length) {
                                break;
                            }
                            if (b.d.b.e0.e.p(this.f30332f[i6].f30314a, asciiLowercase)) {
                                if (b.d.b.e0.e.p(this.f30332f[i6].f30315b, byteString)) {
                                    i2 = b.f30317a.length + (i6 - this.f30333g);
                                    break;
                                } else if (i3 == -1) {
                                    i3 = (i6 - this.f30333g) + b.f30317a.length;
                                }
                            }
                            i6++;
                        }
                    }
                    if (i2 != -1) {
                        h(i2, 127, 128);
                    } else if (i3 == -1) {
                        this.f30327a.writeByte(64);
                        f(asciiLowercase);
                        f(byteString);
                        d(aVar);
                    } else if (asciiLowercase.startsWith(b.d.b.e0.k.a.f30308d) && !b.d.b.e0.k.a.f30313i.equals(asciiLowercase)) {
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
                    this.f30327a.writeByte(i2 | i4);
                    return;
                }
                this.f30327a.writeByte(i4 | i3);
                int i5 = i2 - i3;
                while (i5 >= 128) {
                    this.f30327a.writeByte(128 | (i5 & 127));
                    i5 >>>= 7;
                }
                this.f30327a.writeByte(i5);
            }
        }

        public C1449b(int i2, boolean z, Buffer buffer) {
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
            this.f30329c = Integer.MAX_VALUE;
            b.d.b.e0.k.a[] aVarArr = new b.d.b.e0.k.a[8];
            this.f30332f = aVarArr;
            this.f30333g = aVarArr.length - 1;
            this.f30334h = 0;
            this.f30335i = 0;
            this.f30331e = i2;
            this.f30328b = z;
            this.f30327a = buffer;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-797001776, "Lb/d/b/e0/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-797001776, "Lb/d/b/e0/k/b;");
                return;
            }
        }
        f30317a = new b.d.b.e0.k.a[]{new b.d.b.e0.k.a(b.d.b.e0.k.a.f30313i, ""), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30310f, "GET"), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30310f, "POST"), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30311g, "/"), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30311g, "/index.html"), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30312h, "http"), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30312h, "https"), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30309e, BasicPushStatus.SUCCESS_CODE), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30309e, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE204), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30309e, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE206), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30309e, "304"), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30309e, FontParser.sFontWeightDefault), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30309e, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH), new b.d.b.e0.k.a(b.d.b.e0.k.a.f30309e, "500"), new b.d.b.e0.k.a("accept-charset", ""), new b.d.b.e0.k.a("accept-encoding", "gzip, deflate"), new b.d.b.e0.k.a("accept-language", ""), new b.d.b.e0.k.a(Headers.ACCEPT_RANGES, ""), new b.d.b.e0.k.a(BOSTokenRequest.ACCEPT, ""), new b.d.b.e0.k.a("access-control-allow-origin", ""), new b.d.b.e0.k.a("age", ""), new b.d.b.e0.k.a(UniversalToast.ToastCallbackWithAction.PARAMS_RESULT_KEY, ""), new b.d.b.e0.k.a("authorization", ""), new b.d.b.e0.k.a(Headers.CACHE_CONTROL, ""), new b.d.b.e0.k.a(Headers.CONTENT_DISPOSITION, ""), new b.d.b.e0.k.a(Headers.CONTENT_ENCODING, ""), new b.d.b.e0.k.a("content-language", ""), new b.d.b.e0.k.a(Headers.CONTENT_LEN, ""), new b.d.b.e0.k.a("content-location", ""), new b.d.b.e0.k.a("content-range", ""), new b.d.b.e0.k.a("content-type", ""), new b.d.b.e0.k.a("cookie", ""), new b.d.b.e0.k.a("date", ""), new b.d.b.e0.k.a("etag", ""), new b.d.b.e0.k.a("expect", ""), new b.d.b.e0.k.a("expires", ""), new b.d.b.e0.k.a("from", ""), new b.d.b.e0.k.a("host", ""), new b.d.b.e0.k.a("if-match", ""), new b.d.b.e0.k.a("if-modified-since", ""), new b.d.b.e0.k.a("if-none-match", ""), new b.d.b.e0.k.a("if-range", ""), new b.d.b.e0.k.a("if-unmodified-since", ""), new b.d.b.e0.k.a(Headers.LAST_MODIFIED, ""), new b.d.b.e0.k.a("link", ""), new b.d.b.e0.k.a("location", ""), new b.d.b.e0.k.a("max-forwards", ""), new b.d.b.e0.k.a(Headers.PROXY_AUTHENTICATE, ""), new b.d.b.e0.k.a("proxy-authorization", ""), new b.d.b.e0.k.a("range", ""), new b.d.b.e0.k.a("referer", ""), new b.d.b.e0.k.a("refresh", ""), new b.d.b.e0.k.a("retry-after", ""), new b.d.b.e0.k.a("server", ""), new b.d.b.e0.k.a(Headers.SET_COOKIE, ""), new b.d.b.e0.k.a("strict-transport-security", ""), new b.d.b.e0.k.a(Headers.TRANSFER_ENCODING, ""), new b.d.b.e0.k.a("user-agent", ""), new b.d.b.e0.k.a("vary", ""), new b.d.b.e0.k.a("via", ""), new b.d.b.e0.k.a(Headers.WWW_AUTHENTICATE, "")};
        f30318b = b();
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
        LinkedHashMap linkedHashMap = new LinkedHashMap(f30317a.length);
        int i2 = 0;
        while (true) {
            b.d.b.e0.k.a[] aVarArr = f30317a;
            if (i2 < aVarArr.length) {
                if (!linkedHashMap.containsKey(aVarArr[i2].f30314a)) {
                    linkedHashMap.put(f30317a[i2].f30314a, Integer.valueOf(i2));
                }
                i2++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }
}

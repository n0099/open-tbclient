package b.c.b.e0.k;

import android.net.http.Headers;
import androidx.core.view.InputDeviceCompat;
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
    public static final b.c.b.e0.k.a[] f31175a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<ByteString, Integer> f31176b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<b.c.b.e0.k.a> f31177a;

        /* renamed from: b  reason: collision with root package name */
        public final BufferedSource f31178b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31179c;

        /* renamed from: d  reason: collision with root package name */
        public int f31180d;

        /* renamed from: e  reason: collision with root package name */
        public b.c.b.e0.k.a[] f31181e;

        /* renamed from: f  reason: collision with root package name */
        public int f31182f;

        /* renamed from: g  reason: collision with root package name */
        public int f31183g;

        /* renamed from: h  reason: collision with root package name */
        public int f31184h;

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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f31180d) >= (i3 = this.f31184h)) {
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
                Arrays.fill(this.f31181e, (Object) null);
                this.f31182f = this.f31181e.length - 1;
                this.f31183g = 0;
                this.f31184h = 0;
            }
        }

        public final int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f31182f + 1 + i2 : invokeI.intValue;
        }

        public final int d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = 0;
                if (i2 > 0) {
                    int length = this.f31181e.length;
                    while (true) {
                        length--;
                        if (length < this.f31182f || i2 <= 0) {
                            break;
                        }
                        b.c.b.e0.k.a[] aVarArr = this.f31181e;
                        i2 -= aVarArr[length].f31174c;
                        this.f31184h -= aVarArr[length].f31174c;
                        this.f31183g--;
                        i3++;
                    }
                    b.c.b.e0.k.a[] aVarArr2 = this.f31181e;
                    int i4 = this.f31182f;
                    System.arraycopy(aVarArr2, i4 + 1, aVarArr2, i4 + 1 + i3, this.f31183g);
                    this.f31182f += i3;
                }
                return i3;
            }
            return invokeI.intValue;
        }

        public List<b.c.b.e0.k.a> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ArrayList arrayList = new ArrayList(this.f31177a);
                this.f31177a.clear();
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public final ByteString f(int i2) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                if (h(i2)) {
                    return b.f31175a[i2].f31172a;
                }
                int c2 = c(i2 - b.f31175a.length);
                if (c2 >= 0) {
                    b.c.b.e0.k.a[] aVarArr = this.f31181e;
                    if (c2 < aVarArr.length) {
                        return aVarArr[c2].f31172a;
                    }
                }
                throw new IOException("Header index too large " + (i2 + 1));
            }
            return (ByteString) invokeI.objValue;
        }

        public final void g(int i2, b.c.b.e0.k.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048582, this, i2, aVar) == null) {
                this.f31177a.add(aVar);
                int i3 = aVar.f31174c;
                if (i2 != -1) {
                    i3 -= this.f31181e[c(i2)].f31174c;
                }
                int i4 = this.f31180d;
                if (i3 > i4) {
                    b();
                    return;
                }
                int d2 = d((this.f31184h + i3) - i4);
                if (i2 == -1) {
                    int i5 = this.f31183g + 1;
                    b.c.b.e0.k.a[] aVarArr = this.f31181e;
                    if (i5 > aVarArr.length) {
                        b.c.b.e0.k.a[] aVarArr2 = new b.c.b.e0.k.a[aVarArr.length * 2];
                        System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                        this.f31182f = this.f31181e.length - 1;
                        this.f31181e = aVarArr2;
                    }
                    int i6 = this.f31182f;
                    this.f31182f = i6 - 1;
                    this.f31181e[i6] = aVar;
                    this.f31183g++;
                } else {
                    this.f31181e[i2 + c(i2) + d2] = aVar;
                }
                this.f31184h += i3;
            }
        }

        public final boolean h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 >= 0 && i2 <= b.f31175a.length - 1 : invokeI.booleanValue;
        }

        public final int i() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31178b.readByte() & 255 : invokeV.intValue;
        }

        public ByteString j() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                int i2 = i();
                boolean z = (i2 & 128) == 128;
                int m = m(i2, 127);
                if (z) {
                    return ByteString.of(i.f().c(this.f31178b.readByteArray(m)));
                }
                return this.f31178b.readByteString(m);
            }
            return (ByteString) invokeV.objValue;
        }

        public void k() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                while (!this.f31178b.exhausted()) {
                    int readByte = this.f31178b.readByte() & 255;
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
                        this.f31180d = m;
                        if (m >= 0 && m <= this.f31179c) {
                            a();
                        } else {
                            throw new IOException("Invalid dynamic table size update " + this.f31180d);
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
                    this.f31177a.add(b.f31175a[i2]);
                    return;
                }
                int c2 = c(i2 - b.f31175a.length);
                if (c2 >= 0) {
                    b.c.b.e0.k.a[] aVarArr = this.f31181e;
                    if (c2 < aVarArr.length) {
                        this.f31177a.add(aVarArr[c2]);
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
                g(-1, new b.c.b.e0.k.a(f(i2), j()));
            }
        }

        public final void o() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
                ByteString j = j();
                b.a(j);
                g(-1, new b.c.b.e0.k.a(j, j()));
            }
        }

        public final void p(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
                this.f31177a.add(new b.c.b.e0.k.a(f(i2), j()));
            }
        }

        public final void q() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
                ByteString j = j();
                b.a(j);
                this.f31177a.add(new b.c.b.e0.k.a(j, j()));
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
            this.f31177a = new ArrayList();
            b.c.b.e0.k.a[] aVarArr = new b.c.b.e0.k.a[8];
            this.f31181e = aVarArr;
            this.f31182f = aVarArr.length - 1;
            this.f31183g = 0;
            this.f31184h = 0;
            this.f31179c = i2;
            this.f31180d = i3;
            this.f31178b = Okio.buffer(source);
        }
    }

    /* renamed from: b.c.b.e0.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1491b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Buffer f31185a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f31186b;

        /* renamed from: c  reason: collision with root package name */
        public int f31187c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f31188d;

        /* renamed from: e  reason: collision with root package name */
        public int f31189e;

        /* renamed from: f  reason: collision with root package name */
        public b.c.b.e0.k.a[] f31190f;

        /* renamed from: g  reason: collision with root package name */
        public int f31191g;

        /* renamed from: h  reason: collision with root package name */
        public int f31192h;

        /* renamed from: i  reason: collision with root package name */
        public int f31193i;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public C1491b(Buffer buffer) {
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f31189e) >= (i3 = this.f31193i)) {
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
                Arrays.fill(this.f31190f, (Object) null);
                this.f31191g = this.f31190f.length - 1;
                this.f31192h = 0;
                this.f31193i = 0;
            }
        }

        public final int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int i3 = 0;
                if (i2 > 0) {
                    int length = this.f31190f.length;
                    while (true) {
                        length--;
                        if (length < this.f31191g || i2 <= 0) {
                            break;
                        }
                        b.c.b.e0.k.a[] aVarArr = this.f31190f;
                        i2 -= aVarArr[length].f31174c;
                        this.f31193i -= aVarArr[length].f31174c;
                        this.f31192h--;
                        i3++;
                    }
                    b.c.b.e0.k.a[] aVarArr2 = this.f31190f;
                    int i4 = this.f31191g;
                    System.arraycopy(aVarArr2, i4 + 1, aVarArr2, i4 + 1 + i3, this.f31192h);
                    b.c.b.e0.k.a[] aVarArr3 = this.f31190f;
                    int i5 = this.f31191g;
                    Arrays.fill(aVarArr3, i5 + 1, i5 + 1 + i3, (Object) null);
                    this.f31191g += i3;
                }
                return i3;
            }
            return invokeI.intValue;
        }

        public final void d(b.c.b.e0.k.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                int i2 = aVar.f31174c;
                int i3 = this.f31189e;
                if (i2 > i3) {
                    b();
                    return;
                }
                c((this.f31193i + i2) - i3);
                int i4 = this.f31192h + 1;
                b.c.b.e0.k.a[] aVarArr = this.f31190f;
                if (i4 > aVarArr.length) {
                    b.c.b.e0.k.a[] aVarArr2 = new b.c.b.e0.k.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.f31191g = this.f31190f.length - 1;
                    this.f31190f = aVarArr2;
                }
                int i5 = this.f31191g;
                this.f31191g = i5 - 1;
                this.f31190f[i5] = aVar;
                this.f31192h++;
                this.f31193i += i2;
            }
        }

        public void e(int i2) {
            int min;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (i3 = this.f31189e) == (min = Math.min(i2, 16384))) {
                return;
            }
            if (min < i3) {
                this.f31187c = Math.min(this.f31187c, min);
            }
            this.f31188d = true;
            this.f31189e = min;
            a();
        }

        public void f(ByteString byteString) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, byteString) == null) {
                if (this.f31186b && i.f().e(byteString) < byteString.size()) {
                    Buffer buffer = new Buffer();
                    i.f().d(byteString, buffer);
                    ByteString readByteString = buffer.readByteString();
                    h(readByteString.size(), 127, 128);
                    this.f31185a.write(readByteString);
                    return;
                }
                h(byteString.size(), 127, 0);
                this.f31185a.write(byteString);
            }
        }

        public void g(List<b.c.b.e0.k.a> list) throws IOException {
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
                if (this.f31188d) {
                    int i4 = this.f31187c;
                    if (i4 < this.f31189e) {
                        h(i4, 31, 32);
                    }
                    this.f31188d = false;
                    this.f31187c = Integer.MAX_VALUE;
                    h(this.f31189e, 31, 32);
                }
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    b.c.b.e0.k.a aVar = list.get(i5);
                    ByteString asciiLowercase = aVar.f31172a.toAsciiLowercase();
                    ByteString byteString = aVar.f31173b;
                    Integer num = b.f31176b.get(asciiLowercase);
                    if (num != null) {
                        i2 = num.intValue() + 1;
                        if (i2 > 1 && i2 < 8) {
                            if (b.c.b.e0.e.p(b.f31175a[i2 - 1].f31173b, byteString)) {
                                i3 = i2;
                            } else if (b.c.b.e0.e.p(b.f31175a[i2].f31173b, byteString)) {
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
                        int i6 = this.f31191g + 1;
                        int length = this.f31190f.length;
                        while (true) {
                            if (i6 >= length) {
                                break;
                            }
                            if (b.c.b.e0.e.p(this.f31190f[i6].f31172a, asciiLowercase)) {
                                if (b.c.b.e0.e.p(this.f31190f[i6].f31173b, byteString)) {
                                    i2 = b.f31175a.length + (i6 - this.f31191g);
                                    break;
                                } else if (i3 == -1) {
                                    i3 = (i6 - this.f31191g) + b.f31175a.length;
                                }
                            }
                            i6++;
                        }
                    }
                    if (i2 != -1) {
                        h(i2, 127, 128);
                    } else if (i3 == -1) {
                        this.f31185a.writeByte(64);
                        f(asciiLowercase);
                        f(byteString);
                        d(aVar);
                    } else if (asciiLowercase.startsWith(b.c.b.e0.k.a.f31166d) && !b.c.b.e0.k.a.f31171i.equals(asciiLowercase)) {
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
                    this.f31185a.writeByte(i2 | i4);
                    return;
                }
                this.f31185a.writeByte(i4 | i3);
                int i5 = i2 - i3;
                while (i5 >= 128) {
                    this.f31185a.writeByte(128 | (i5 & 127));
                    i5 >>>= 7;
                }
                this.f31185a.writeByte(i5);
            }
        }

        public C1491b(int i2, boolean z, Buffer buffer) {
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
            this.f31187c = Integer.MAX_VALUE;
            b.c.b.e0.k.a[] aVarArr = new b.c.b.e0.k.a[8];
            this.f31190f = aVarArr;
            this.f31191g = aVarArr.length - 1;
            this.f31192h = 0;
            this.f31193i = 0;
            this.f31189e = i2;
            this.f31186b = z;
            this.f31185a = buffer;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(999949583, "Lb/c/b/e0/k/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(999949583, "Lb/c/b/e0/k/b;");
                return;
            }
        }
        f31175a = new b.c.b.e0.k.a[]{new b.c.b.e0.k.a(b.c.b.e0.k.a.f31171i, ""), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31168f, "GET"), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31168f, "POST"), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31169g, "/"), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31169g, "/index.html"), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31170h, "http"), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31170h, "https"), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31167e, BasicPushStatus.SUCCESS_CODE), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31167e, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE204), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31167e, HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE206), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31167e, "304"), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31167e, FontParser.sFontWeightDefault), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31167e, XAdRemoteSDKCountly.COUNTLY_TYPE_4_CRASH), new b.c.b.e0.k.a(b.c.b.e0.k.a.f31167e, "500"), new b.c.b.e0.k.a("accept-charset", ""), new b.c.b.e0.k.a("accept-encoding", "gzip, deflate"), new b.c.b.e0.k.a("accept-language", ""), new b.c.b.e0.k.a(Headers.ACCEPT_RANGES, ""), new b.c.b.e0.k.a(BOSTokenRequest.ACCEPT, ""), new b.c.b.e0.k.a("access-control-allow-origin", ""), new b.c.b.e0.k.a("age", ""), new b.c.b.e0.k.a("allow", ""), new b.c.b.e0.k.a("authorization", ""), new b.c.b.e0.k.a(Headers.CACHE_CONTROL, ""), new b.c.b.e0.k.a(Headers.CONTENT_DISPOSITION, ""), new b.c.b.e0.k.a(Headers.CONTENT_ENCODING, ""), new b.c.b.e0.k.a("content-language", ""), new b.c.b.e0.k.a(Headers.CONTENT_LEN, ""), new b.c.b.e0.k.a("content-location", ""), new b.c.b.e0.k.a("content-range", ""), new b.c.b.e0.k.a("content-type", ""), new b.c.b.e0.k.a("cookie", ""), new b.c.b.e0.k.a("date", ""), new b.c.b.e0.k.a("etag", ""), new b.c.b.e0.k.a("expect", ""), new b.c.b.e0.k.a("expires", ""), new b.c.b.e0.k.a("from", ""), new b.c.b.e0.k.a("host", ""), new b.c.b.e0.k.a("if-match", ""), new b.c.b.e0.k.a("if-modified-since", ""), new b.c.b.e0.k.a("if-none-match", ""), new b.c.b.e0.k.a("if-range", ""), new b.c.b.e0.k.a("if-unmodified-since", ""), new b.c.b.e0.k.a(Headers.LAST_MODIFIED, ""), new b.c.b.e0.k.a("link", ""), new b.c.b.e0.k.a("location", ""), new b.c.b.e0.k.a("max-forwards", ""), new b.c.b.e0.k.a(Headers.PROXY_AUTHENTICATE, ""), new b.c.b.e0.k.a("proxy-authorization", ""), new b.c.b.e0.k.a("range", ""), new b.c.b.e0.k.a("referer", ""), new b.c.b.e0.k.a("refresh", ""), new b.c.b.e0.k.a("retry-after", ""), new b.c.b.e0.k.a("server", ""), new b.c.b.e0.k.a(Headers.SET_COOKIE, ""), new b.c.b.e0.k.a("strict-transport-security", ""), new b.c.b.e0.k.a(Headers.TRANSFER_ENCODING, ""), new b.c.b.e0.k.a("user-agent", ""), new b.c.b.e0.k.a("vary", ""), new b.c.b.e0.k.a("via", ""), new b.c.b.e0.k.a(Headers.WWW_AUTHENTICATE, "")};
        f31176b = b();
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
        LinkedHashMap linkedHashMap = new LinkedHashMap(f31175a.length);
        int i2 = 0;
        while (true) {
            b.c.b.e0.k.a[] aVarArr = f31175a;
            if (i2 < aVarArr.length) {
                if (!linkedHashMap.containsKey(aVarArr[i2].f31172a)) {
                    linkedHashMap.put(f31175a[i2].f31172a, Integer.valueOf(i2));
                }
                i2++;
            } else {
                return Collections.unmodifiableMap(linkedHashMap);
            }
        }
    }
}

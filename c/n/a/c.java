package c.n.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.FieldEncoding;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.BufferedSource;
import okio.ByteString;
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BufferedSource a;

    /* renamed from: b  reason: collision with root package name */
    public long f31160b;

    /* renamed from: c  reason: collision with root package name */
    public long f31161c;

    /* renamed from: d  reason: collision with root package name */
    public int f31162d;

    /* renamed from: e  reason: collision with root package name */
    public int f31163e;

    /* renamed from: f  reason: collision with root package name */
    public int f31164f;

    /* renamed from: g  reason: collision with root package name */
    public long f31165g;

    /* renamed from: h  reason: collision with root package name */
    public FieldEncoding f31166h;

    public c(BufferedSource bufferedSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31160b = 0L;
        this.f31161c = Long.MAX_VALUE;
        this.f31163e = 2;
        this.f31164f = -1;
        this.f31165g = -1L;
        this.a = bufferedSource;
    }

    public final void a(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (this.f31163e == i2) {
                this.f31163e = 6;
                return;
            }
            long j2 = this.f31160b;
            long j3 = this.f31161c;
            if (j2 > j3) {
                throw new IOException("Expected to end at " + this.f31161c + " but was " + this.f31160b);
            } else if (j2 == j3) {
                this.f31161c = this.f31165g;
                this.f31165g = -1L;
                this.f31163e = 6;
            } else {
                this.f31163e = 7;
            }
        }
    }

    public final long b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f31163e == 2) {
                long j2 = this.f31161c - this.f31160b;
                this.a.require(j2);
                this.f31163e = 6;
                this.f31160b = this.f31161c;
                this.f31161c = this.f31165g;
                this.f31165g = -1L;
                return j2;
            }
            throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f31163e);
        }
        return invokeV.longValue;
    }

    public long c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f31163e == 2) {
                int i2 = this.f31162d + 1;
                this.f31162d = i2;
                if (i2 <= 65) {
                    long j2 = this.f31165g;
                    this.f31165g = -1L;
                    this.f31163e = 6;
                    return j2;
                }
                throw new IOException("Wire recursion limit exceeded");
            }
            throw new IllegalStateException("Unexpected call to beginMessage()");
        }
        return invokeV.longValue;
    }

    public void d(long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            if (this.f31163e == 6) {
                int i2 = this.f31162d - 1;
                this.f31162d = i2;
                if (i2 >= 0 && this.f31165g == -1) {
                    if (this.f31160b != this.f31161c && i2 != 0) {
                        throw new IOException("Expected to end at " + this.f31161c + " but was " + this.f31160b);
                    }
                    this.f31161c = j2;
                    return;
                }
                throw new IllegalStateException("No corresponding call to beginMessage()");
            }
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
    }

    public final int e() throws IOException {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f31160b++;
            byte readByte = this.a.readByte();
            if (readByte >= 0) {
                return readByte;
            }
            int i3 = readByte & ByteCompanionObject.MAX_VALUE;
            this.f31160b++;
            byte readByte2 = this.a.readByte();
            if (readByte2 >= 0) {
                i2 = readByte2 << 7;
            } else {
                i3 |= (readByte2 & ByteCompanionObject.MAX_VALUE) << 7;
                this.f31160b++;
                byte readByte3 = this.a.readByte();
                if (readByte3 >= 0) {
                    i2 = readByte3 << 14;
                } else {
                    i3 |= (readByte3 & ByteCompanionObject.MAX_VALUE) << 14;
                    this.f31160b++;
                    byte readByte4 = this.a.readByte();
                    if (readByte4 < 0) {
                        int i4 = i3 | ((readByte4 & ByteCompanionObject.MAX_VALUE) << 21);
                        this.f31160b++;
                        byte readByte5 = this.a.readByte();
                        int i5 = i4 | (readByte5 << 28);
                        if (readByte5 < 0) {
                            for (int i6 = 0; i6 < 5; i6++) {
                                this.f31160b++;
                                if (this.a.readByte() >= 0) {
                                    return i5;
                                }
                            }
                            throw new ProtocolException("Malformed VARINT");
                        }
                        return i5;
                    }
                    i2 = readByte4 << 21;
                }
            }
            return i3 | i2;
        }
        return invokeV.intValue;
    }

    public int f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.f31163e;
            if (i2 == 7) {
                this.f31163e = 2;
                return this.f31164f;
            } else if (i2 == 6) {
                while (this.f31160b < this.f31161c && !this.a.exhausted()) {
                    int e2 = e();
                    if (e2 != 0) {
                        int i3 = e2 >> 3;
                        this.f31164f = i3;
                        int i4 = e2 & 7;
                        if (i4 == 0) {
                            this.f31166h = FieldEncoding.VARINT;
                            this.f31163e = 0;
                            return i3;
                        } else if (i4 == 1) {
                            this.f31166h = FieldEncoding.FIXED64;
                            this.f31163e = 1;
                            return i3;
                        } else if (i4 == 2) {
                            this.f31166h = FieldEncoding.LENGTH_DELIMITED;
                            this.f31163e = 2;
                            int e3 = e();
                            if (e3 >= 0) {
                                if (this.f31165g == -1) {
                                    long j2 = this.f31161c;
                                    this.f31165g = j2;
                                    long j3 = this.f31160b + e3;
                                    this.f31161c = j3;
                                    if (j3 <= j2) {
                                        return this.f31164f;
                                    }
                                    throw new EOFException();
                                }
                                throw new IllegalStateException();
                            }
                            throw new ProtocolException("Negative length: " + e3);
                        } else if (i4 != 3) {
                            if (i4 != 4) {
                                if (i4 == 5) {
                                    this.f31166h = FieldEncoding.FIXED32;
                                    this.f31163e = 5;
                                    return i3;
                                }
                                throw new ProtocolException("Unexpected field encoding: " + i4);
                            }
                            throw new ProtocolException("Unexpected end group");
                        } else {
                            n(i3);
                        }
                    } else {
                        throw new ProtocolException("Unexpected tag 0");
                    }
                }
                return -1;
            } else {
                throw new IllegalStateException("Unexpected call to nextTag()");
            }
        }
        return invokeV.intValue;
    }

    public FieldEncoding g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31166h : (FieldEncoding) invokeV.objValue;
    }

    public ByteString h() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.readByteString(b()) : (ByteString) invokeV.objValue;
    }

    public int i() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.f31163e;
            if (i2 != 5 && i2 != 2) {
                throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f31163e);
            }
            this.a.require(4L);
            this.f31160b += 4;
            int readIntLe = this.a.readIntLe();
            a(5);
            return readIntLe;
        }
        return invokeV.intValue;
    }

    public long j() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f31163e;
            if (i2 != 1 && i2 != 2) {
                throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f31163e);
            }
            this.a.require(8L);
            this.f31160b += 8;
            long readLongLe = this.a.readLongLe();
            a(1);
            return readLongLe;
        }
        return invokeV.longValue;
    }

    public String k() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.readUtf8(b()) : (String) invokeV.objValue;
    }

    public int l() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = this.f31163e;
            if (i2 != 0 && i2 != 2) {
                throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f31163e);
            }
            int e2 = e();
            a(0);
            return e2;
        }
        return invokeV.intValue;
    }

    public long m() throws IOException {
        InterceptResult invokeV;
        byte readByte;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.f31163e;
            if (i2 != 0 && i2 != 2) {
                throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f31163e);
            }
            long j2 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                this.f31160b++;
                j2 |= (readByte & ByteCompanionObject.MAX_VALUE) << i3;
                if ((this.a.readByte() & ByteCompanionObject.MIN_VALUE) == 0) {
                    a(0);
                    return j2;
                }
            }
            throw new ProtocolException("WireInput encountered a malformed varint");
        }
        return invokeV.longValue;
    }

    public final void n(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            while (this.f31160b < this.f31161c && !this.a.exhausted()) {
                int e2 = e();
                if (e2 == 0) {
                    throw new ProtocolException("Unexpected tag 0");
                }
                int i3 = e2 >> 3;
                int i4 = e2 & 7;
                if (i4 == 0) {
                    this.f31163e = 0;
                    m();
                } else if (i4 == 1) {
                    this.f31163e = 1;
                    j();
                } else if (i4 == 2) {
                    long e3 = e();
                    this.f31160b += e3;
                    this.a.skip(e3);
                } else if (i4 == 3) {
                    n(i3);
                } else if (i4 == 4) {
                    if (i3 != i2) {
                        throw new ProtocolException("Unexpected end group");
                    }
                    return;
                } else if (i4 == 5) {
                    this.f31163e = 5;
                    i();
                } else {
                    throw new ProtocolException("Unexpected field encoding: " + i4);
                }
            }
            throw new EOFException();
        }
    }
}

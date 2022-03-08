package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UShort;
/* loaded from: classes3.dex */
public class n0 implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    public n0() {
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
        this.a = true;
    }

    @Override // c.b.b.q.c
    public JsonValue a(c.b.b.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            try {
                return d(aVar.l(8192));
            } catch (Exception e2) {
                throw new SerializationException("Error parsing file: " + aVar, e2);
            }
        }
        return (JsonValue) invokeL.objValue;
    }

    public JsonValue b(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataInputStream)) == null) {
            try {
                return c(dataInputStream, dataInputStream.readByte());
            } finally {
                i0.a(dataInputStream);
            }
        }
        return (JsonValue) invokeL.objValue;
    }

    public JsonValue c(DataInputStream dataInputStream, byte b2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{dataInputStream, Byte.valueOf(b2)})) == null) {
            if (b2 == 91) {
                return e(dataInputStream);
            }
            if (b2 == 123) {
                return g(dataInputStream);
            }
            if (b2 == 90) {
                return new JsonValue(JsonValue.ValueType.nullValue);
            }
            if (b2 == 84) {
                return new JsonValue(true);
            }
            if (b2 == 70) {
                return new JsonValue(false);
            }
            if (b2 == 66) {
                return new JsonValue(m(dataInputStream));
            }
            if (b2 == 85) {
                return new JsonValue(m(dataInputStream));
            }
            if (b2 == 105) {
                return new JsonValue(this.a ? dataInputStream.readShort() : dataInputStream.readByte());
            } else if (b2 == 73) {
                return new JsonValue(this.a ? dataInputStream.readInt() : dataInputStream.readShort());
            } else if (b2 == 108) {
                return new JsonValue(dataInputStream.readInt());
            } else {
                if (b2 == 76) {
                    return new JsonValue(dataInputStream.readLong());
                }
                if (b2 == 100) {
                    return new JsonValue(dataInputStream.readFloat());
                }
                if (b2 == 68) {
                    return new JsonValue(dataInputStream.readDouble());
                }
                if (b2 == 115 || b2 == 83) {
                    return new JsonValue(j(dataInputStream, b2));
                }
                if (b2 == 97 || b2 == 65) {
                    return f(dataInputStream, b2);
                }
                if (b2 == 67) {
                    return new JsonValue(dataInputStream.readChar());
                }
                throw new GdxRuntimeException("Unrecognized data type");
            }
        }
        return (JsonValue) invokeCommon.objValue;
    }

    public JsonValue d(InputStream inputStream) {
        InterceptResult invokeL;
        DataInputStream dataInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, inputStream)) == null) {
            DataInputStream dataInputStream2 = null;
            try {
                try {
                    dataInputStream = new DataInputStream(inputStream);
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                JsonValue b2 = b(dataInputStream);
                i0.a(dataInputStream);
                return b2;
            } catch (IOException e3) {
                e = e3;
                dataInputStream2 = dataInputStream;
                throw new SerializationException(e);
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                i0.a(dataInputStream2);
                throw th;
            }
        }
        return (JsonValue) invokeL.objValue;
    }

    public JsonValue e(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dataInputStream)) == null) {
            JsonValue jsonValue = new JsonValue(JsonValue.ValueType.array);
            byte readByte = dataInputStream.readByte();
            if (readByte == 36) {
                b2 = dataInputStream.readByte();
                readByte = dataInputStream.readByte();
            } else {
                b2 = 0;
            }
            long j2 = -1;
            if (readByte == 35) {
                j2 = i(dataInputStream, false, -1L);
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 < 0) {
                    throw new GdxRuntimeException("Unrecognized data type");
                }
                if (i2 == 0) {
                    return jsonValue;
                }
                readByte = b2 == 0 ? dataInputStream.readByte() : b2;
            }
            JsonValue jsonValue2 = null;
            long j3 = 0;
            while (dataInputStream.available() > 0 && readByte != 93) {
                JsonValue c2 = c(dataInputStream, readByte);
                c2.k = jsonValue;
                if (jsonValue2 != null) {
                    c2.m = jsonValue2;
                    jsonValue2.l = c2;
                    jsonValue.n++;
                } else {
                    jsonValue.f29775j = c2;
                    jsonValue.n = 1;
                }
                if (j2 > 0) {
                    j3++;
                    if (j3 >= j2) {
                        break;
                    }
                }
                jsonValue2 = c2;
                readByte = b2 == 0 ? dataInputStream.readByte() : b2;
            }
            return jsonValue;
        }
        return (JsonValue) invokeL.objValue;
    }

    public JsonValue f(DataInputStream dataInputStream, byte b2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{dataInputStream, Byte.valueOf(b2)})) == null) {
            byte readByte = dataInputStream.readByte();
            long n = b2 == 65 ? n(dataInputStream) : m(dataInputStream);
            JsonValue jsonValue = new JsonValue(JsonValue.ValueType.array);
            JsonValue jsonValue2 = null;
            long j2 = 0;
            while (j2 < n) {
                JsonValue c2 = c(dataInputStream, readByte);
                c2.k = jsonValue;
                if (jsonValue2 != null) {
                    jsonValue2.l = c2;
                    jsonValue.n++;
                } else {
                    jsonValue.f29775j = c2;
                    jsonValue.n = 1;
                }
                j2++;
                jsonValue2 = c2;
            }
            return jsonValue;
        }
        return (JsonValue) invokeCommon.objValue;
    }

    public JsonValue g(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        byte b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dataInputStream)) == null) {
            JsonValue jsonValue = new JsonValue(JsonValue.ValueType.object);
            byte readByte = dataInputStream.readByte();
            if (readByte == 36) {
                b2 = dataInputStream.readByte();
                readByte = dataInputStream.readByte();
            } else {
                b2 = 0;
            }
            long j2 = -1;
            if (readByte == 35) {
                j2 = i(dataInputStream, false, -1L);
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 < 0) {
                    throw new GdxRuntimeException("Unrecognized data type");
                }
                if (i2 == 0) {
                    return jsonValue;
                }
                readByte = dataInputStream.readByte();
            }
            JsonValue jsonValue2 = null;
            long j3 = 0;
            while (dataInputStream.available() > 0 && readByte != 125) {
                String k = k(dataInputStream, true, readByte);
                JsonValue c2 = c(dataInputStream, b2 == 0 ? dataInputStream.readByte() : b2);
                c2.Q(k);
                c2.k = jsonValue;
                if (jsonValue2 != null) {
                    c2.m = jsonValue2;
                    jsonValue2.l = c2;
                    jsonValue.n++;
                } else {
                    jsonValue.f29775j = c2;
                    jsonValue.n = 1;
                }
                if (j2 > 0) {
                    j3++;
                    if (j3 >= j2) {
                        break;
                    }
                }
                readByte = dataInputStream.readByte();
                jsonValue2 = c2;
            }
            return jsonValue;
        }
        return (JsonValue) invokeL.objValue;
    }

    public long h(DataInputStream dataInputStream, byte b2, boolean z, long j2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{dataInputStream, Byte.valueOf(b2), Boolean.valueOf(z), Long.valueOf(j2)})) == null) {
            if (b2 == 105) {
                return m(dataInputStream);
            }
            if (b2 == 73) {
                return o(dataInputStream);
            }
            if (b2 == 108) {
                return n(dataInputStream);
            }
            if (b2 == 76) {
                return dataInputStream.readLong();
            }
            return z ? ((b2 & 255) << 24) | ((dataInputStream.readByte() & 255) << 16) | ((dataInputStream.readByte() & 255) << 8) | (dataInputStream.readByte() & 255) : j2;
        }
        return invokeCommon.longValue;
    }

    public long i(DataInputStream dataInputStream, boolean z, long j2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{dataInputStream, Boolean.valueOf(z), Long.valueOf(j2)})) == null) ? h(dataInputStream, dataInputStream.readByte(), z, j2) : invokeCommon.longValue;
    }

    public String j(DataInputStream dataInputStream, byte b2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{dataInputStream, Byte.valueOf(b2)})) == null) ? k(dataInputStream, false, b2) : (String) invokeCommon.objValue;
    }

    public String k(DataInputStream dataInputStream, boolean z, byte b2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{dataInputStream, Boolean.valueOf(z), Byte.valueOf(b2)})) == null) {
            long j2 = -1;
            if (b2 == 83) {
                j2 = i(dataInputStream, true, -1L);
            } else if (b2 == 115) {
                j2 = m(dataInputStream);
            } else if (z) {
                j2 = h(dataInputStream, b2, false, -1L);
            }
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 >= 0) {
                return i2 > 0 ? l(dataInputStream, j2) : "";
            }
            throw new GdxRuntimeException("Unrecognized data type, string expected");
        }
        return (String) invokeCommon.objValue;
    }

    public String l(DataInputStream dataInputStream, long j2) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048587, this, dataInputStream, j2)) == null) {
            byte[] bArr = new byte[(int) j2];
            dataInputStream.readFully(bArr);
            return new String(bArr, "UTF-8");
        }
        return (String) invokeLJ.objValue;
    }

    public short m(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, dataInputStream)) == null) ? (short) (dataInputStream.readByte() & 255) : invokeL.shortValue;
    }

    public long n(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, dataInputStream)) == null) ? dataInputStream.readInt() & (-1) : invokeL.longValue;
    }

    public int o(DataInputStream dataInputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, dataInputStream)) == null) ? dataInputStream.readShort() & UShort.MAX_VALUE : invokeL.intValue;
    }
}

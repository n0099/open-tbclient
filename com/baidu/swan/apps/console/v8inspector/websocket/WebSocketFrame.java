package com.baidu.swan.apps.console.v8inspector.websocket;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.Text;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes6.dex */
public class WebSocketFrame {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45878g;

    /* renamed from: h  reason: collision with root package name */
    public static final Charset f45879h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public OpCode f45880a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45881b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f45882c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f45883d;

    /* renamed from: e  reason: collision with root package name */
    public int f45884e;

    /* renamed from: f  reason: collision with root package name */
    public String f45885f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class CloseCode {
        public static final /* synthetic */ CloseCode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CloseCode MessageTooLong;
        public static final CloseCode NormalClosure;
        public static final CloseCode ProtocolError;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-592427795, "Lcom/baidu/swan/apps/console/v8inspector/websocket/WebSocketFrame$CloseCode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-592427795, "Lcom/baidu/swan/apps/console/v8inspector/websocket/WebSocketFrame$CloseCode;");
                    return;
                }
            }
            NormalClosure = new CloseCode("NormalClosure", 0, 1000);
            ProtocolError = new CloseCode("ProtocolError", 1, 1002);
            CloseCode closeCode = new CloseCode("MessageTooLong", 2, 1009);
            MessageTooLong = closeCode;
            $VALUES = new CloseCode[]{NormalClosure, ProtocolError, closeCode};
        }

        public CloseCode(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mCode = i3;
        }

        public static CloseCode find(int i2) {
            InterceptResult invokeI;
            CloseCode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (CloseCode closeCode : values()) {
                    if (closeCode.getValue() == i2) {
                        return closeCode;
                    }
                }
                return null;
            }
            return (CloseCode) invokeI.objValue;
        }

        public static CloseCode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (CloseCode) Enum.valueOf(CloseCode.class, str) : (CloseCode) invokeL.objValue;
        }

        public static CloseCode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (CloseCode[]) $VALUES.clone() : (CloseCode[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCode : invokeV.intValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class OpCode {
        public static final /* synthetic */ OpCode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OpCode Binary;
        public static final OpCode Close;
        public static final OpCode Continuation;
        public static final OpCode Ping;
        public static final OpCode Pong;
        public static final OpCode Text;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte mCode;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1716494890, "Lcom/baidu/swan/apps/console/v8inspector/websocket/WebSocketFrame$OpCode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1716494890, "Lcom/baidu/swan/apps/console/v8inspector/websocket/WebSocketFrame$OpCode;");
                    return;
                }
            }
            Continuation = new OpCode("Continuation", 0, 0);
            Text = new OpCode(Text.k, 1, 1);
            Binary = new OpCode("Binary", 2, 2);
            Close = new OpCode("Close", 3, 8);
            Ping = new OpCode("Ping", 4, 9);
            OpCode opCode = new OpCode("Pong", 5, 10);
            Pong = opCode;
            $VALUES = new OpCode[]{Continuation, Text, Binary, Close, Ping, opCode};
        }

        public OpCode(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mCode = (byte) i3;
        }

        public static OpCode find(byte b2) {
            InterceptResult invokeB;
            OpCode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) {
                for (OpCode opCode : values()) {
                    if (opCode.getValue() == b2) {
                        return opCode;
                    }
                }
                return null;
            }
            return (OpCode) invokeB.objValue;
        }

        public static OpCode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (OpCode) Enum.valueOf(OpCode.class, str) : (OpCode) invokeL.objValue;
        }

        public static OpCode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (OpCode[]) $VALUES.clone() : (OpCode[]) invokeV.objValue;
        }

        public byte getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCode : invokeV.byteValue;
        }

        public boolean isControlFrame() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this == Close || this == Ping || this == Pong : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b extends WebSocketFrame {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public CloseCode f45886i;

        /* renamed from: j  reason: collision with root package name */
        public String f45887j;

        public /* synthetic */ b(WebSocketFrame webSocketFrame, a aVar) {
            this(webSocketFrame);
        }

        public static byte[] u(CloseCode closeCode, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, closeCode, str)) == null) {
                if (closeCode != null) {
                    byte[] s = WebSocketFrame.s(str);
                    byte[] bArr = new byte[s.length + 2];
                    bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                    bArr[1] = (byte) (closeCode.getValue() & 255);
                    System.arraycopy(s, 0, bArr, 2, s.length);
                    return bArr;
                }
                return new byte[0];
            }
            return (byte[]) invokeLL.objValue;
        }

        public CloseCode v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45886i : (CloseCode) invokeV.objValue;
        }

        public String w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45887j : (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CloseCode closeCode, String str) {
            super(OpCode.Close, true, u(closeCode, str));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {closeCode, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((OpCode) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (byte[]) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WebSocketFrame webSocketFrame) {
            super(webSocketFrame);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webSocketFrame};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((WebSocketFrame) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (webSocketFrame.d().length >= 2) {
                this.f45886i = CloseCode.find((webSocketFrame.d()[1] & 255) | ((webSocketFrame.d()[0] & 255) << 8));
                this.f45887j = WebSocketFrame.a(d(), 2, d().length - 2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-985832242, "Lcom/baidu/swan/apps/console/v8inspector/websocket/WebSocketFrame;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-985832242, "Lcom/baidu/swan/apps/console/v8inspector/websocket/WebSocketFrame;");
                return;
            }
        }
        f45878g = k.f7085a;
        f45879h = Charset.forName("UTF-8");
    }

    public WebSocketFrame(WebSocketFrame webSocketFrame) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webSocketFrame};
            interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                return;
            }
        }
        q(webSocketFrame.f());
        o(webSocketFrame.h());
        n(webSocketFrame.d());
        p(webSocketFrame.e());
    }

    public static String a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, bArr, i2, i3)) == null) ? new String(bArr, i2, i3, f45879h) : (String) invokeLII.objValue;
    }

    public static String b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) ? a(bArr, 0, bArr.length) : (String) invokeL.objValue;
    }

    public static int c(int i2) throws EOFException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            if (i2 >= 0) {
                return i2;
            }
            throw new EOFException();
        }
        return invokeI.intValue;
    }

    public static WebSocketFrame k(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, inputStream)) == null) {
            int read = inputStream.read();
            c(read);
            byte b2 = (byte) read;
            boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
            OpCode find = OpCode.find((byte) (b2 & 15));
            int i2 = b2 & 112;
            if (i2 != 0) {
                CloseCode closeCode = CloseCode.ProtocolError;
                throw new WebSocketException(closeCode, "The reserved bits (" + Integer.toBinaryString(i2) + ") must be 0.");
            } else if (find != null) {
                if (find.isControlFrame() && !z) {
                    throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
                }
                WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
                webSocketFrame.m(inputStream);
                webSocketFrame.l(inputStream);
                return webSocketFrame.f() == OpCode.Close ? new b(webSocketFrame, (a) null) : webSocketFrame;
            } else {
                CloseCode closeCode2 = CloseCode.ProtocolError;
                throw new WebSocketException(closeCode2, "Received frame with reserved/unknown opcode " + i2 + ".");
            }
        }
        return (WebSocketFrame) invokeL.objValue;
    }

    public static byte[] s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? str.getBytes(f45879h) : (byte[]) invokeL.objValue;
    }

    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45883d : (byte[]) invokeV.objValue;
    }

    public final byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45882c : (byte[]) invokeV.objValue;
    }

    public OpCode f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f45880a : (OpCode) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f45885f == null) {
                this.f45885f = b(d());
            }
            return this.f45885f;
        }
        return (String) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45881b : invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            byte[] bArr = this.f45882c;
            return bArr != null && bArr.length == 4;
        }
        return invokeV.booleanValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f45883d == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(this.f45883d.length);
            sb.append("b] ");
            if (f() == OpCode.Text) {
                String g2 = g();
                if (g2.length() > 100) {
                    sb.append(g2.substring(0, 100));
                    sb.append("...");
                } else {
                    sb.append(g2);
                }
            } else {
                sb.append("0x");
                for (int i2 = 0; i2 < Math.min(this.f45883d.length, 50); i2++) {
                    sb.append(Integer.toHexString(this.f45883d[i2] & 255));
                }
                if (this.f45883d.length > 50) {
                    sb.append("...");
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void l(InputStream inputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, inputStream) == null) {
            this.f45883d = new byte[this.f45884e];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f45884e;
                if (i3 >= i4) {
                    break;
                }
                int read = inputStream.read(this.f45883d, i3, i4 - i3);
                c(read);
                i3 += read;
            }
            if (i()) {
                while (true) {
                    byte[] bArr = this.f45883d;
                    if (i2 >= bArr.length) {
                        break;
                    }
                    bArr[i2] = (byte) (bArr[i2] ^ this.f45882c[i2 % 4]);
                    i2++;
                }
            }
            if (f() == OpCode.Text) {
                this.f45885f = b(d());
            }
        }
    }

    public final void m(InputStream inputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, inputStream) != null) {
            return;
        }
        int read = inputStream.read();
        c(read);
        byte b2 = (byte) read;
        int i2 = 0;
        boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
        byte b3 = (byte) (b2 & ByteCompanionObject.MAX_VALUE);
        this.f45884e = b3;
        if (b3 == 126) {
            int read2 = inputStream.read();
            c(read2);
            int read3 = inputStream.read();
            c(read3);
            int i3 = ((read2 << 8) | read3) & 65535;
            this.f45884e = i3;
            if (i3 < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (b3 == Byte.MAX_VALUE) {
            int read4 = inputStream.read();
            c(read4);
            int read5 = inputStream.read();
            c(read5);
            int read6 = inputStream.read();
            c(read6);
            int read7 = inputStream.read();
            c(read7);
            int read8 = inputStream.read();
            c(read8);
            int read9 = inputStream.read();
            c(read9);
            int read10 = inputStream.read();
            c(read10);
            int read11 = inputStream.read();
            c(read11);
            long j2 = (read4 << 56) | (read5 << 48) | (read6 << 40) | (read7 << 32) | (read8 << 24) | (read9 << 16) | (read10 << 8) | read11;
            if (j2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (j2 <= 2147483647L) {
                this.f45884e = (int) j2;
            } else {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
        }
        if (this.f45880a.isControlFrame()) {
            int i4 = this.f45884e;
            if (i4 <= 125) {
                if (this.f45880a == OpCode.Close && i4 == 1) {
                    throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
                }
            } else {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
        }
        if (!z) {
            return;
        }
        this.f45882c = new byte[4];
        while (true) {
            byte[] bArr = this.f45882c;
            if (i2 >= bArr.length) {
                return;
            }
            int read12 = inputStream.read(bArr, i2, bArr.length - i2);
            c(read12);
            i2 += read12;
        }
    }

    public final void n(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bArr) == null) {
            this.f45883d = bArr;
            this.f45884e = bArr.length;
            this.f45885f = null;
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f45881b = z;
        }
    }

    public final void p(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bArr) == null) {
            if (bArr != null && bArr.length != 4 && f45878g) {
                String str = "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4";
            }
            this.f45882c = bArr;
        }
    }

    public final void q(OpCode opCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, opCode) == null) {
            this.f45880a = opCode;
        }
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f45883d = s(str);
            this.f45884e = str.length();
            this.f45885f = str;
        }
    }

    public void t(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, outputStream) == null) {
            outputStream.write((byte) ((this.f45881b ? (byte) 128 : (byte) 0) | (this.f45880a.getValue() & 15)));
            int length = d().length;
            this.f45884e = length;
            if (length <= 125) {
                outputStream.write(i() ? ((byte) this.f45884e) | ByteCompanionObject.MIN_VALUE : (byte) this.f45884e);
            } else if (length < 65536) {
                outputStream.write(i() ? 254 : 126);
                outputStream.write(this.f45884e >>> 8);
                outputStream.write(this.f45884e);
            } else {
                outputStream.write(i() ? 255 : 127);
                outputStream.write(new byte[4]);
                outputStream.write(this.f45884e >>> 24);
                outputStream.write(this.f45884e >>> 16);
                outputStream.write(this.f45884e >>> 8);
                outputStream.write(this.f45884e);
            }
            if (i()) {
                outputStream.write(this.f45882c);
                for (int i2 = 0; i2 < this.f45884e; i2++) {
                    outputStream.write(d()[i2] ^ this.f45882c[i2 % 4]);
                }
            } else {
                outputStream.write(d());
            }
            outputStream.flush();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Object[] objArr = new Object[4];
            objArr[0] = f();
            objArr[1] = h() ? "fin" : "inter";
            objArr[2] = i() ? "masked" : "unmasked";
            objArr[3] = j();
            return String.format("WS[%s, %s, %s, %s]", objArr);
        }
        return (String) invokeV.objValue;
    }

    public WebSocketFrame(OpCode opCode, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {opCode, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        q(opCode);
        o(z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {opCode, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((OpCode) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        long j2 = 0;
        while (list.iterator().hasNext()) {
            j2 += it.next().d().length;
        }
        if (j2 >= 0 && j2 <= 2147483647L) {
            int i4 = (int) j2;
            this.f45884e = i4;
            byte[] bArr = new byte[i4];
            int i5 = 0;
            for (WebSocketFrame webSocketFrame : list) {
                System.arraycopy(webSocketFrame.d(), 0, bArr, i5, webSocketFrame.d().length);
                i5 += webSocketFrame.d().length;
            }
            n(bArr);
        } else if (f45878g) {
            throw new RuntimeException("Max frame length has been exceeded.");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
        this(opCode, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {opCode, Boolean.valueOf(z), bArr};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((OpCode) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        n(bArr);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WebSocketFrame(OpCode opCode, boolean z, String str) {
        this(opCode, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {opCode, Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((OpCode) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        r(str);
    }
}

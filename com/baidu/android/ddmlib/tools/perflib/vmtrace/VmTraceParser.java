package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ddmlib.ByteBufferUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class VmTraceParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HEADER_END = "*end";
    public static final String HEADER_SECTION_METHODS = "*methods";
    public static final String HEADER_SECTION_THREADS = "*threads";
    public static final String HEADER_SECTION_VERSION = "*version";
    public static final String KEY_CLOCK = "clock";
    public static final int PARSE_METHODS = 1;
    public static final int PARSE_OPTIONS = 4;
    public static final int PARSE_SUMMARY = 3;
    public static final int PARSE_THREADS = 2;
    public static final int PARSE_VERSION = 0;
    public static final int TRACE_MAGIC = 1464814675;
    public transient /* synthetic */ FieldHolder $fh;
    public final VmTraceHandler mTraceDataHandler;
    public final File mTraceFile;
    public int mVersion;
    public VmClockType mVmClockType;

    /* renamed from: com.baidu.android.ddmlib.tools.perflib.vmtrace.VmTraceParser$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$VmClockType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1679471438, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/VmTraceParser$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1679471438, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/VmTraceParser$1;");
                    return;
                }
            }
            int[] iArr = new int[VmClockType.values().length];
            $SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$VmClockType = iArr;
            try {
                iArr[VmClockType.WALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$VmClockType[VmClockType.DUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$VmClockType[VmClockType.THREAD_CPU.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class StreamingTraceParser {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public static /* synthetic */ Interceptable $ic = null;
        public static final int STREAMING_TRACE_VERSION_MASK = 240;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteArrayOutputStream mByteOutputStream;
        public DataInputStream mInputStream;
        public File mTraceFile;
        public final /* synthetic */ VmTraceParser this$0;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(698416337, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/VmTraceParser$StreamingTraceParser;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(698416337, "Lcom/baidu/android/ddmlib/tools/perflib/vmtrace/VmTraceParser$StreamingTraceParser;");
            }
        }

        public StreamingTraceParser(VmTraceParser vmTraceParser, File file) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vmTraceParser, file};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = vmTraceParser;
            this.mTraceFile = file;
            this.mInputStream = new DataInputStream(new FileInputStream(this.mTraceFile));
            this.mByteOutputStream = new ByteArrayOutputStream();
        }

        public /* synthetic */ StreamingTraceParser(VmTraceParser vmTraceParser, File file, AnonymousClass1 anonymousClass1) throws IOException {
            this(vmTraceParser, file);
        }

        private void processSummary(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
                String[] split = str.split("\n");
                String str2 = split[2];
                for (int i = 2; i < split.length && !str2.equals("*threads\n"); i++) {
                    this.this$0.parseOption(split[i]);
                }
            }
        }

        private int readNumberLE(int i) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i)) == null) {
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    i2 += this.mInputStream.readUnsignedByte() << (i3 * 8);
                }
                return i2;
            }
            return invokeI.intValue;
        }

        private String readString(int i) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
                byte[] bArr = new byte[i];
                for (int i2 = 0; i2 < i; i2++) {
                    bArr[i2] = (byte) this.mInputStream.readUnsignedByte();
                }
                return new String(bArr, Charset.forName("UTF-8"));
            }
            return (String) invokeI.objValue;
        }

        private void copyBytes(int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
                byte[] bArr = new byte[i];
                int read = this.mInputStream.read(bArr);
                if (read == i) {
                    this.mByteOutputStream.write(bArr);
                    return;
                }
                throw new RuntimeException(String.format("Invalid trace format: expected %d bytes, but found %d\n", Integer.valueOf(i), Integer.valueOf(read)));
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE] complete} */
        /* JADX INFO: Access modifiers changed from: private */
        public ByteBuffer parse() throws IOException {
            InterceptResult invokeV;
            int i;
            int readUnsignedByte;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
                try {
                    int readNumberLE = readNumberLE(4);
                    VmTraceParser.validateMagic(readNumberLE);
                    writeNumberLE(readNumberLE, 4);
                    int readNumberLE2 = readNumberLE(2) ^ 240;
                    VmTraceParser.validateTraceVersion(readNumberLE2);
                    writeNumberLE(readNumberLE2, 2);
                    this.this$0.mVersion = readNumberLE2;
                    this.this$0.mTraceDataHandler.setVersion(readNumberLE2);
                    int readNumberLE3 = readNumberLE(2) - 16;
                    writeNumberLE(readNumberLE3 + 16, 2);
                    copyBytes(8);
                    if (readNumberLE2 != 1) {
                        if (readNumberLE2 != 2) {
                            i = readNumberLE(2);
                            writeNumberLE(i, 2);
                            readNumberLE3 -= 2;
                        } else {
                            i = 10;
                        }
                    } else {
                        i = 9;
                    }
                    copyBytes(readNumberLE3);
                    while (true) {
                        try {
                            int readNumberLE4 = readNumberLE(2);
                            if (readNumberLE4 == 0) {
                                readUnsignedByte = this.mInputStream.readUnsignedByte();
                                if (readUnsignedByte == 1) {
                                    this.this$0.parseMethod(readString(readNumberLE(2)));
                                } else if (readUnsignedByte != 2) {
                                    break;
                                } else {
                                    this.this$0.mTraceDataHandler.addThread(readNumberLE(2), readString(readNumberLE(2)));
                                }
                            } else {
                                writeNumberLE(readNumberLE4, 2);
                                copyBytes(i - 2);
                            }
                        } catch (EOFException unused) {
                        }
                    }
                    if (readUnsignedByte == 3) {
                        processSummary(readString(readNumberLE(4)));
                        return ByteBuffer.wrap(this.mByteOutputStream.toByteArray()).order(ByteOrder.LITTLE_ENDIAN);
                    }
                    throw new RuntimeException("Invalid trace format: got an invalid code.");
                } finally {
                    try {
                        this.mInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            }
            return (ByteBuffer) invokeV.objValue;
        }

        private void writeNumberLE(int i, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(65545, this, i, i2) == null) {
                byte[] bArr = new byte[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    bArr[i3] = (byte) ((i >> (i3 * 8)) & 255);
                }
                this.mByteOutputStream.write(bArr);
            }
        }
    }

    public VmTraceParser(File file, VmTraceHandler vmTraceHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, vmTraceHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (file.exists()) {
            this.mTraceFile = file;
            this.mTraceDataHandler = vmTraceHandler;
            return;
        }
        throw new IllegalArgumentException("Trace file " + file.getAbsolutePath() + " does not exist.");
    }

    private void parseData(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, byteBuffer) == null) {
            parseMethodTraceData(byteBuffer, readDataFileHeader(byteBuffer));
        }
    }

    public static void validateTraceVersion(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i) == null) {
            if (i >= 1 && i <= 3) {
                return;
            }
            throw new RuntimeException(String.format("Error: unsupported trace version number %d.  Please use a newer version of TraceView to read this file.", Integer.valueOf(i)));
        }
    }

    private String constructPathname(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, str, str2)) == null) {
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf > 0 && lastIndexOf < str.length() - 1 && str2.endsWith(".java")) {
                return str.substring(0, lastIndexOf + 1) + str2;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isStreamingTrace(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("US-ASCII")));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.startsWith(HEADER_SECTION_VERSION)) {
                        return false;
                    }
                }
                bufferedReader.close();
                return true;
            } finally {
                bufferedReader.close();
            }
        }
        return invokeL.booleanValue;
    }

    private void parseThread(String str) {
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, this, str) != null) || (indexOf = str.indexOf(9)) < 0) {
            return;
        }
        try {
            this.mTraceDataHandler.addThread(Integer.decode(str.substring(0, indexOf)).intValue(), str.substring(indexOf).trim());
        } catch (NumberFormatException unused) {
        }
    }

    public static void validateMagic(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65549, null, i) != null) || i == 1464814675) {
            return;
        }
        throw new RuntimeException(String.format("Error: magic number mismatch; got 0x%x, expected 0x%x\n", Integer.valueOf(i), Integer.valueOf((int) TRACE_MAGIC)));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseMethodTraceData(ByteBuffer byteBuffer, int i) {
        short s;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        TraceAction traceAction;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, this, byteBuffer, i) == null) {
            int i7 = this.mVersion;
            while (byteBuffer.hasRemaining()) {
                int position = byteBuffer.position();
                if (i7 == 1) {
                    s = byteBuffer.get();
                } else {
                    s = byteBuffer.getShort();
                }
                short s2 = s;
                int i8 = byteBuffer.getInt();
                int i9 = AnonymousClass1.$SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$VmClockType[this.mVmClockType.ordinal()];
                if (i9 != 1) {
                    if (i9 != 2) {
                        i2 = byteBuffer.getInt();
                    } else {
                        i4 = byteBuffer.getInt();
                        i3 = byteBuffer.getInt();
                        int position2 = byteBuffer.position();
                        i5 = position2 - position;
                        if (i5 < i) {
                            byteBuffer.position(position2 + (i - i5));
                        }
                        i6 = i8 & 3;
                        if (i6 == 0) {
                            if (i6 != 1) {
                                if (i6 == 2) {
                                    traceAction = TraceAction.METHOD_EXIT_UNROLL;
                                } else {
                                    throw new RuntimeException("Invalid trace action, expected one of method entry, exit or unroll.");
                                }
                            } else {
                                traceAction = TraceAction.METHOD_EXIT;
                            }
                        } else {
                            traceAction = TraceAction.METHOD_ENTER;
                        }
                        this.mTraceDataHandler.addMethodAction(s2, 4294967295L & i8 & (-4), traceAction, i4, i3);
                    }
                } else {
                    i2 = byteBuffer.getInt();
                }
                i4 = i2;
                i3 = i4;
                int position22 = byteBuffer.position();
                i5 = position22 - position;
                if (i5 < i) {
                }
                i6 = i8 & 3;
                if (i6 == 0) {
                }
                this.mTraceDataHandler.addMethodAction(s2, 4294967295L & i8 & (-4), traceAction, i4, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseOption(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, str) == null) {
            String[] split = str.split("=");
            if (split.length == 2) {
                String str2 = split[0];
                String str3 = split[1];
                this.mTraceDataHandler.setProperty(str2, str3);
                if (str2.equals("clock")) {
                    if (str3.equals("thread-cpu")) {
                        this.mVmClockType = VmClockType.THREAD_CPU;
                    } else if (str3.equals("wall")) {
                        this.mVmClockType = VmClockType.WALL;
                    } else if (str3.equals("dual")) {
                        this.mVmClockType = VmClockType.DUAL;
                    }
                }
            }
        }
    }

    private int readDataFileHeader(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        short s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, byteBuffer)) == null) {
            validateMagic(byteBuffer.getInt());
            short s2 = byteBuffer.getShort();
            if (s2 == this.mVersion) {
                validateTraceVersion(s2);
                int i = byteBuffer.getShort() - 16;
                this.mTraceDataHandler.setStartTimeUs(byteBuffer.getLong());
                if (s2 != 1) {
                    if (s2 != 2) {
                        s = byteBuffer.getShort();
                        i -= 2;
                    } else {
                        s = 10;
                    }
                } else {
                    s = 9;
                }
                while (true) {
                    int i2 = i - 1;
                    if (i > 0) {
                        byteBuffer.get();
                        i = i2;
                    } else {
                        return s;
                    }
                }
            } else {
                throw new RuntimeException(String.format("Error: version number mismatch; got %d in data header but %d in options\n", Integer.valueOf(s2), Integer.valueOf(this.mVersion)));
            }
        } else {
            return invokeL.intValue;
        }
    }

    public void parseMethod(String str) {
        String str2;
        String str3;
        String str4;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            String[] split = str.split("\t");
            try {
                long longValue = Long.decode(split[0]).longValue();
                String str5 = split[1];
                if (split.length == 6) {
                    String str6 = split[2];
                    String str7 = split[3];
                    String str8 = split[4];
                    i = Integer.decode(split[5]).intValue();
                    str2 = str6;
                    str3 = str7;
                    str4 = constructPathname(str5, str8);
                } else {
                    if (split.length > 2) {
                        if (split[3].startsWith("(")) {
                            String str9 = split[2];
                            str3 = split[3];
                            str2 = str9;
                            str4 = null;
                        } else {
                            String str10 = split[2];
                            i = Integer.decode(split[3]).intValue();
                            str4 = str10;
                            str2 = null;
                            str3 = null;
                        }
                    } else {
                        str2 = null;
                        str3 = null;
                        str4 = null;
                    }
                    i = -1;
                }
                this.mTraceDataHandler.addMethod(longValue, new MethodInfo(longValue, str5, str2, str3, str4, i));
            } catch (NumberFormatException unused) {
            }
        }
    }

    public void parse() throws IOException {
        ByteBuffer mapFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (isStreamingTrace(this.mTraceFile)) {
                mapFile = new StreamingTraceParser(this, this.mTraceFile, null).parse();
            } else {
                mapFile = ByteBufferUtil.mapFile(this.mTraceFile, parseHeader(this.mTraceFile), ByteOrder.LITTLE_ENDIAN);
            }
            parseData(mapFile);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0091, code lost:
        throw new java.io.IOException("Key section does not have an *end marker");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long parseHeader(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
                long j = 0;
                loop0: while (true) {
                    char c = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break loop0;
                            }
                            j += readLine.getBytes(Charset.forName("UTF-8")).length + 1;
                            if (readLine.startsWith("*")) {
                                if (readLine.equals(HEADER_SECTION_VERSION)) {
                                    break;
                                } else if (readLine.equals(HEADER_SECTION_THREADS)) {
                                    c = 2;
                                } else if (readLine.equals(HEADER_SECTION_METHODS)) {
                                    c = 1;
                                } else if (readLine.equals(HEADER_END)) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException unused) {
                                    }
                                    return j;
                                }
                            }
                            if (c != 0) {
                                if (c != 1) {
                                    if (c != 2) {
                                        if (c == 4) {
                                            parseOption(readLine);
                                        }
                                    } else {
                                        parseThread(readLine);
                                    }
                                } else {
                                    parseMethod(readLine);
                                }
                            } else {
                                int intValue = Integer.decode(readLine).intValue();
                                this.mVersion = intValue;
                                this.mTraceDataHandler.setVersion(intValue);
                                c = 4;
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return invokeL.longValue;
        }
    }
}

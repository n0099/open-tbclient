package com.baidu.android.ddmlib.tools.perflib.vmtrace;

import androidx.annotation.NonNull;
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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes9.dex */
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
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
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

    /* loaded from: classes9.dex */
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

        public /* synthetic */ StreamingTraceParser(VmTraceParser vmTraceParser, File file, AnonymousClass1 anonymousClass1) throws IOException {
            this(vmTraceParser, file);
        }

        private void copyBytes(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
                byte[] bArr = new byte[i2];
                int read = this.mInputStream.read(bArr);
                if (read == i2) {
                    this.mByteOutputStream.write(bArr);
                    return;
                }
                throw new RuntimeException(String.format("Invalid trace format: expected %d bytes, but found %d\n", Integer.valueOf(i2), Integer.valueOf(read)));
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IGET, INVOKE] complete} */
        /* JADX INFO: Access modifiers changed from: private */
        public ByteBuffer parse() throws IOException {
            InterceptResult invokeV;
            int i2;
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
                    if (readNumberLE2 == 1) {
                        i2 = 9;
                    } else if (readNumberLE2 != 2) {
                        i2 = readNumberLE(2);
                        writeNumberLE(i2, 2);
                        readNumberLE3 -= 2;
                    } else {
                        i2 = 10;
                    }
                    copyBytes(readNumberLE3);
                    while (true) {
                        try {
                            int readNumberLE4 = readNumberLE(2);
                            if (readNumberLE4 == 0) {
                                readUnsignedByte = this.mInputStream.readUnsignedByte();
                                if (readUnsignedByte != 1) {
                                    if (readUnsignedByte != 2) {
                                        break;
                                    }
                                    this.this$0.mTraceDataHandler.addThread(readNumberLE(2), readString(readNumberLE(2)));
                                } else {
                                    this.this$0.parseMethod(readString(readNumberLE(2)));
                                }
                            } else {
                                writeNumberLE(readNumberLE4, 2);
                                copyBytes(i2 - 2);
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

        private void processSummary(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
                String[] split = str.split(StringUtils.LF);
                String str2 = split[2];
                for (int i2 = 2; i2 < split.length && !str2.equals("*threads\n"); i2++) {
                    this.this$0.parseOption(split[i2]);
                }
            }
        }

        private int readNumberLE(int i2) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65543, this, i2)) == null) {
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    i3 += this.mInputStream.readUnsignedByte() << (i4 * 8);
                }
                return i3;
            }
            return invokeI.intValue;
        }

        @NonNull
        private String readString(int i2) throws IOException {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
                byte[] bArr = new byte[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    bArr[i3] = (byte) this.mInputStream.readUnsignedByte();
                }
                return new String(bArr, Charset.forName("UTF-8"));
            }
            return (String) invokeI.objValue;
        }

        private void writeNumberLE(int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(65545, this, i2, i3) == null) {
                byte[] bArr = new byte[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr[i4] = (byte) ((i2 >> (i4 * 8)) & 255);
                }
                this.mByteOutputStream.write(bArr);
            }
        }

        public StreamingTraceParser(VmTraceParser vmTraceParser, File file) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vmTraceParser, file};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    }

    public VmTraceParser(File file, VmTraceHandler vmTraceHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, vmTraceHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    private String constructPathname(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, str, str2)) == null) {
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf <= 0 || lastIndexOf >= str.length() - 1 || !str2.endsWith(".java")) {
                return str2;
            }
            return str.substring(0, lastIndexOf + 1) + str2;
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

    private void parseData(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, byteBuffer) == null) {
            parseMethodTraceData(byteBuffer, readDataFileHeader(byteBuffer));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseMethodTraceData(ByteBuffer byteBuffer, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        TraceAction traceAction;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, this, byteBuffer, i2) == null) {
            int i8 = this.mVersion;
            while (byteBuffer.hasRemaining()) {
                int position = byteBuffer.position();
                short s = i8 == 1 ? byteBuffer.get() : byteBuffer.getShort();
                int i9 = byteBuffer.getInt();
                int i10 = AnonymousClass1.$SwitchMap$com$baidu$android$ddmlib$tools$perflib$vmtrace$VmClockType[this.mVmClockType.ordinal()];
                if (i10 == 1) {
                    i3 = byteBuffer.getInt();
                } else if (i10 != 2) {
                    i3 = byteBuffer.getInt();
                } else {
                    i5 = byteBuffer.getInt();
                    i4 = byteBuffer.getInt();
                    int position2 = byteBuffer.position();
                    i6 = position2 - position;
                    if (i6 < i2) {
                        byteBuffer.position(position2 + (i2 - i6));
                    }
                    i7 = i9 & 3;
                    if (i7 != 0) {
                        traceAction = TraceAction.METHOD_ENTER;
                    } else if (i7 == 1) {
                        traceAction = TraceAction.METHOD_EXIT;
                    } else if (i7 == 2) {
                        traceAction = TraceAction.METHOD_EXIT_UNROLL;
                    } else {
                        throw new RuntimeException("Invalid trace action, expected one of method entry, exit or unroll.");
                    }
                    this.mTraceDataHandler.addMethodAction(s, 4294967295L & i9 & (-4), traceAction, i5, i4);
                }
                i5 = i3;
                i4 = i5;
                int position22 = byteBuffer.position();
                i6 = position22 - position;
                if (i6 < i2) {
                }
                i7 = i9 & 3;
                if (i7 != 0) {
                }
                this.mTraceDataHandler.addMethodAction(s, 4294967295L & i9 & (-4), traceAction, i5, i4);
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

    private void parseThread(String str) {
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, str) == null) || (indexOf = str.indexOf(9)) < 0) {
            return;
        }
        try {
            this.mTraceDataHandler.addThread(Integer.decode(str.substring(0, indexOf)).intValue(), str.substring(indexOf).trim());
        } catch (NumberFormatException unused) {
        }
    }

    private int readDataFileHeader(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        short s;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65548, this, byteBuffer)) != null) {
            return invokeL.intValue;
        }
        validateMagic(byteBuffer.getInt());
        short s2 = byteBuffer.getShort();
        if (s2 == this.mVersion) {
            validateTraceVersion(s2);
            int i2 = byteBuffer.getShort() - 16;
            this.mTraceDataHandler.setStartTimeUs(byteBuffer.getLong());
            if (s2 == 1) {
                s = 9;
            } else if (s2 != 2) {
                s = byteBuffer.getShort();
                i2 -= 2;
            } else {
                s = 10;
            }
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0) {
                    return s;
                }
                byteBuffer.get();
                i2 = i3;
            }
        } else {
            throw new RuntimeException(String.format("Error: version number mismatch; got %d in data header but %d in options\n", Integer.valueOf(s2), Integer.valueOf(this.mVersion)));
        }
    }

    public static void validateMagic(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65549, null, i2) == null) && i2 != 1464814675) {
            throw new RuntimeException(String.format("Error: magic number mismatch; got 0x%x, expected 0x%x\n", Integer.valueOf(i2), Integer.valueOf((int) TRACE_MAGIC)));
        }
    }

    public static void validateTraceVersion(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i2) == null) {
            if (i2 < 1 || i2 > 3) {
                throw new RuntimeException(String.format("Error: unsupported trace version number %d.  Please use a newer version of TraceView to read this file.", Integer.valueOf(i2)));
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
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) != null) {
            return invokeL.longValue;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
            long j2 = 0;
            loop0: while (true) {
                char c2 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break loop0;
                        }
                        j2 += readLine.getBytes(Charset.forName("UTF-8")).length + 1;
                        if (readLine.startsWith("*")) {
                            if (readLine.equals(HEADER_SECTION_VERSION)) {
                                break;
                            } else if (readLine.equals(HEADER_SECTION_THREADS)) {
                                c2 = 2;
                            } else if (readLine.equals(HEADER_SECTION_METHODS)) {
                                c2 = 1;
                            } else if (readLine.equals(HEADER_END)) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException unused) {
                                }
                                return j2;
                            }
                        }
                        if (c2 == 0) {
                            int intValue = Integer.decode(readLine).intValue();
                            this.mVersion = intValue;
                            this.mTraceDataHandler.setVersion(intValue);
                            c2 = 4;
                        } else if (c2 == 1) {
                            parseMethod(readLine);
                        } else if (c2 == 2) {
                            parseThread(readLine);
                        } else if (c2 == 4) {
                            parseOption(readLine);
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
    }

    public void parseMethod(String str) {
        String str2;
        String str3;
        String str4;
        int i2;
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
                    i2 = Integer.decode(split[5]).intValue();
                    str2 = str6;
                    str3 = str7;
                    str4 = constructPathname(str5, str8);
                } else {
                    if (split.length <= 2) {
                        str2 = null;
                        str3 = null;
                        str4 = null;
                    } else if (split[3].startsWith("(")) {
                        String str9 = split[2];
                        str3 = split[3];
                        str2 = str9;
                        str4 = null;
                    } else {
                        String str10 = split[2];
                        i2 = Integer.decode(split[3]).intValue();
                        str4 = str10;
                        str2 = null;
                        str3 = null;
                    }
                    i2 = -1;
                }
                this.mTraceDataHandler.addMethod(longValue, new MethodInfo(longValue, str5, str2, str3, str4, i2));
            } catch (NumberFormatException unused) {
            }
        }
    }
}

package androidx.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a7\u0010\u0010\u001a\u00020\u000e*\u00020\u00002!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001b\u0010\u0013\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a%\u0010\u0016\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroid/util/AtomicFile;", "", "readBytes", "(Landroid/util/AtomicFile;)[B", "Ljava/nio/charset/Charset;", "charset", "", "readText", "(Landroid/util/AtomicFile;Ljava/nio/charset/Charset;)Ljava/lang/String;", "Lkotlin/Function1;", "Ljava/io/FileOutputStream;", "Lkotlin/ParameterName;", "name", "out", "", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "tryWrite", "(Landroid/util/AtomicFile;Lkotlin/Function1;)V", "array", "writeBytes", "(Landroid/util/AtomicFile;[B)V", "text", "writeText", "(Landroid/util/AtomicFile;Ljava/lang/String;Ljava/nio/charset/Charset;)V", "core-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class AtomicFileKt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final byte[] readBytes(android.util.AtomicFile atomicFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, atomicFile)) == null) {
            byte[] readFully = atomicFile.readFully();
            Intrinsics.checkExpressionValueIsNotNull(readFully, "readFully()");
            return readFully;
        }
        return (byte[]) invokeL.objValue;
    }

    public static final String readText(android.util.AtomicFile atomicFile, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, atomicFile, charset)) == null) {
            byte[] readFully = atomicFile.readFully();
            Intrinsics.checkExpressionValueIsNotNull(readFully, "readFully()");
            return new String(readFully, charset);
        }
        return (String) invokeLL.objValue;
    }

    public static final void writeBytes(android.util.AtomicFile atomicFile, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, atomicFile, bArr) == null) {
            FileOutputStream stream = atomicFile.startWrite();
            try {
                Intrinsics.checkExpressionValueIsNotNull(stream, "stream");
                stream.write(bArr);
                atomicFile.finishWrite(stream);
            } catch (Throwable th) {
                atomicFile.failWrite(stream);
                throw th;
            }
        }
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readText(atomicFile, charset);
    }

    public static final void tryWrite(android.util.AtomicFile atomicFile, Function1<? super FileOutputStream, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, atomicFile, function1) == null) {
            FileOutputStream stream = atomicFile.startWrite();
            try {
                Intrinsics.checkExpressionValueIsNotNull(stream, "stream");
                function1.invoke(stream);
                InlineMarker.finallyStart(1);
                atomicFile.finishWrite(stream);
                InlineMarker.finallyEnd(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                atomicFile.failWrite(stream);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }

    public static final void writeText(android.util.AtomicFile atomicFile, String str, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, atomicFile, str, charset) == null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            writeBytes(atomicFile, bytes);
        }
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(atomicFile, str, charset);
    }
}

package c.b.b.n;

import c.b.b.q.i0;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.nio.ByteBuffer;
import java.util.zip.InflaterInputStream;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final byte[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(339068619, "Lc/b/b/n/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(339068619, "Lc/b/b/n/f$a;");
                    return;
                }
            }
            a = new byte[32000];
        }

        /* JADX WARN: Not initialized variable reg: 1, insn: 0x0084: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0084 */
        public static Pixmap a(c.b.b.m.a aVar) {
            InterceptResult invokeL;
            Exception e2;
            Closeable closeable;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, aVar)) != null) {
                return (Pixmap) invokeL.objValue;
            }
            Closeable closeable2 = null;
            try {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new InflaterInputStream(new BufferedInputStream(aVar.m())));
                    try {
                        Pixmap pixmap = new Pixmap(dataInputStream.readInt(), dataInputStream.readInt(), Pixmap.Format.fromGdx2DPixmapFormat(dataInputStream.readInt()));
                        ByteBuffer m = pixmap.m();
                        m.position(0);
                        m.limit(m.capacity());
                        synchronized (a) {
                            while (true) {
                                int read = dataInputStream.read(a);
                                if (read > 0) {
                                    m.put(a, 0, read);
                                }
                            }
                        }
                        m.position(0);
                        m.limit(m.capacity());
                        i0.a(dataInputStream);
                        return pixmap;
                    } catch (Exception e3) {
                        e2 = e3;
                        throw new GdxRuntimeException("Couldn't read Pixmap from file '" + aVar + "'", e2);
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    i0.a(closeable2);
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
            } catch (Throwable th2) {
                th = th2;
                i0.a(closeable2);
                throw th;
            }
        }
    }

    public static Pixmap a(c.b.b.m.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) ? a.a(aVar) : (Pixmap) invokeL.objValue;
    }
}

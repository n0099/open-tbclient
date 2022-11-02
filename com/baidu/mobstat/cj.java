package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.ce;
import com.baidu.mobstat.cw;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class cj {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1000;
    public static int b = 64;
    public static final byte[] c;
    public transient /* synthetic */ FieldHolder $fh;
    public ce.b d;
    public cw.a e;

    public abstract b a(cy cyVar, df dfVar) throws cp;

    public abstract cz a(cz czVar) throws cp;

    public abstract ByteBuffer a(cw cwVar);

    public abstract List<cw> a(ByteBuffer byteBuffer, boolean z);

    public abstract void a();

    public abstract a b();

    public abstract cj c();

    public abstract List<cw> c(ByteBuffer byteBuffer) throws cn;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final /* synthetic */ a[] d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628580494, "Lcom/baidu/mobstat/cj$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(628580494, "Lcom/baidu/mobstat/cj$a;");
                    return;
                }
            }
            a = new a(HlsPlaylistParser.METHOD_NONE, 0);
            b = new a("ONEWAY", 1);
            a aVar = new a("TWOWAY", 2);
            c = aVar;
            d = new a[]{a, b, aVar};
        }

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (a) Enum.valueOf(a.class, str);
            }
            return (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (a[]) d.clone();
            }
            return (a[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final b b;
        public static final /* synthetic */ b[] c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628580525, "Lcom/baidu/mobstat/cj$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(628580525, "Lcom/baidu/mobstat/cj$b;");
                    return;
                }
            }
            a = new b("MATCHED", 0);
            b bVar = new b("NOT_MATCHED", 1);
            b = bVar;
            c = new b[]{a, bVar};
        }

        public b(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static b valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (b) Enum.valueOf(b.class, str);
            }
            return (b) invokeL.objValue;
        }

        public static b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (b[]) c.clone();
            }
            return (b[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581659051, "Lcom/baidu/mobstat/cj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581659051, "Lcom/baidu/mobstat/cj;");
                return;
            }
        }
        c = di.a("<policy-file-request/>\u0000");
    }

    public cj() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.baidu.mobstat.dc, com.baidu.mobstat.dg] */
    public static da a(ByteBuffer byteBuffer, ce.b bVar) throws cp, cm {
        InterceptResult invokeLL;
        db dbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, byteBuffer, bVar)) == null) {
            String b2 = b(byteBuffer);
            if (b2 != null) {
                String[] split = b2.split(" ", 3);
                if (split.length == 3) {
                    if (bVar == ce.b.a) {
                        ?? dcVar = new dc();
                        dcVar.a(Short.parseShort(split[1]));
                        dcVar.a(split[2]);
                        dbVar = dcVar;
                    } else {
                        db dbVar2 = new db();
                        dbVar2.a(split[1]);
                        dbVar = dbVar2;
                    }
                    String b3 = b(byteBuffer);
                    while (b3 != null && b3.length() > 0) {
                        String[] split2 = b3.split(":", 2);
                        if (split2.length == 2) {
                            dbVar.a(split2[0], split2[1].replaceFirst("^ +", ""));
                            b3 = b(byteBuffer);
                        } else {
                            throw new cp("not an http header");
                        }
                    }
                    if (b3 != null) {
                        return dbVar;
                    }
                    throw new cm();
                }
                throw new cp();
            }
            throw new cm(byteBuffer.capacity() + 128);
        }
        return (da) invokeLL.objValue;
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, byteBuffer)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
            byte b2 = 48;
            while (byteBuffer.hasRemaining()) {
                byte b3 = byteBuffer.get();
                allocate.put(b3);
                if (b2 == 13 && b3 == 10) {
                    allocate.limit(allocate.position() - 2);
                    allocate.position(0);
                    return allocate;
                }
                b2 = b3;
            }
            byteBuffer.position(byteBuffer.position() - allocate.position());
            return null;
        }
        return (ByteBuffer) invokeL.objValue;
    }

    public static String b(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, byteBuffer)) == null) {
            ByteBuffer a2 = a(byteBuffer);
            if (a2 == null) {
                return null;
            }
            return di.a(a2.array(), 0, a2.limit());
        }
        return (String) invokeL.objValue;
    }

    public int a(int i) throws cq, cn {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= 0) {
                return i;
            }
            throw new cn(1002, "Negative count");
        }
        return invokeI.intValue;
    }

    public dd d(ByteBuffer byteBuffer) throws cp {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, byteBuffer)) == null) {
            return a(byteBuffer, this.d);
        }
        return (dd) invokeL.objValue;
    }

    public List<ByteBuffer> a(dd ddVar, ce.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, ddVar, bVar)) == null) {
            return a(ddVar, bVar, true);
        }
        return (List) invokeLL.objValue;
    }

    public List<ByteBuffer> a(dd ddVar, ce.b bVar, boolean z) {
        InterceptResult invokeLLZ;
        byte[] bArr;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, ddVar, bVar, z)) == null) {
            StringBuilder sb = new StringBuilder(100);
            if (ddVar instanceof cy) {
                sb.append("GET ");
                sb.append(((cy) ddVar).a());
                sb.append(" HTTP/1.1");
            } else if (ddVar instanceof df) {
                sb.append("HTTP/1.1 101 ");
                sb.append(((df) ddVar).a());
            } else {
                throw new RuntimeException("unknown role");
            }
            sb.append("\r\n");
            Iterator<String> b2 = ddVar.b();
            while (b2.hasNext()) {
                String next = b2.next();
                String b3 = ddVar.b(next);
                sb.append(next);
                sb.append(": ");
                sb.append(b3);
                sb.append("\r\n");
            }
            sb.append("\r\n");
            byte[] b4 = di.b(sb.toString());
            if (z) {
                bArr = ddVar.c();
            } else {
                bArr = null;
            }
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            ByteBuffer allocate = ByteBuffer.allocate(length + b4.length);
            allocate.put(b4);
            if (bArr != null) {
                allocate.put(bArr);
            }
            allocate.flip();
            return Collections.singletonList(allocate);
        }
        return (List) invokeLLZ.objValue;
    }

    public void a(ce.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.d = bVar;
        }
    }
}

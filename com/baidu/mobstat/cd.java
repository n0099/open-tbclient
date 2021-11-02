package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.mobstat.by;
import com.baidu.mobstat.cq;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class cd {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f41231a = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static int f41232b = 64;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f41233c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public by.b f41234d;

    /* renamed from: e  reason: collision with root package name */
    public cq.a f41235e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f41236a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f41237b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f41238c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ a[] f41239d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628401748, "Lcom/baidu/mobstat/cd$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(628401748, "Lcom/baidu/mobstat/cd$a;");
                    return;
                }
            }
            f41236a = new a("NONE", 0);
            f41237b = new a("ONEWAY", 1);
            a aVar = new a("TWOWAY", 2);
            f41238c = aVar;
            f41239d = new a[]{f41236a, f41237b, aVar};
        }

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f41239d.clone() : (a[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f41240a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f41241b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ b[] f41242c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628401779, "Lcom/baidu/mobstat/cd$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(628401779, "Lcom/baidu/mobstat/cd$b;");
                    return;
                }
            }
            f41240a = new b("MATCHED", 0);
            b bVar = new b("NOT_MATCHED", 1);
            f41241b = bVar;
            f41242c = new b[]{f41240a, bVar};
        }

        public b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (b) Enum.valueOf(b.class, str) : (b) invokeL.objValue;
        }

        public static b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (b[]) f41242c.clone() : (b[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581658865, "Lcom/baidu/mobstat/cd;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581658865, "Lcom/baidu/mobstat/cd;");
                return;
            }
        }
        f41233c = dc.a("<policy-file-request/>\u0000");
    }

    public cd() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41234d = null;
        this.f41235e = null;
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
            return dc.a(a2.array(), 0, a2.limit());
        }
        return (String) invokeL.objValue;
    }

    public abstract b a(cs csVar, cz czVar) throws cj;

    public abstract ct a(ct ctVar) throws cj;

    public abstract ByteBuffer a(cq cqVar);

    public abstract List<cq> a(ByteBuffer byteBuffer, boolean z);

    public abstract void a();

    public abstract a b();

    public abstract cd c();

    public abstract List<cq> c(ByteBuffer byteBuffer) throws ch;

    public cx d(ByteBuffer byteBuffer) throws cj {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, byteBuffer)) == null) ? a(byteBuffer, this.f41234d) : (cx) invokeL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.baidu.mobstat.da, com.baidu.mobstat.cw] */
    public static cu a(ByteBuffer byteBuffer, by.b bVar) throws cj, cg {
        InterceptResult invokeLL;
        cv cvVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, byteBuffer, bVar)) == null) {
            String b2 = b(byteBuffer);
            if (b2 != null) {
                String[] split = b2.split(" ", 3);
                if (split.length == 3) {
                    if (bVar == by.b.f41210a) {
                        ?? cwVar = new cw();
                        cwVar.a(Short.parseShort(split[1]));
                        cwVar.a(split[2]);
                        cvVar = cwVar;
                    } else {
                        cv cvVar2 = new cv();
                        cvVar2.a(split[1]);
                        cvVar = cvVar2;
                    }
                    String b3 = b(byteBuffer);
                    while (b3 != null && b3.length() > 0) {
                        String[] split2 = b3.split(":", 2);
                        if (split2.length == 2) {
                            cvVar.a(split2[0], split2[1].replaceFirst("^ +", ""));
                            b3 = b(byteBuffer);
                        } else {
                            throw new cj("not an http header");
                        }
                    }
                    if (b3 != null) {
                        return cvVar;
                    }
                    throw new cg();
                }
                throw new cj();
            }
            throw new cg(byteBuffer.capacity() + 128);
        }
        return (cu) invokeLL.objValue;
    }

    public List<ByteBuffer> a(cx cxVar, by.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, cxVar, bVar)) == null) ? a(cxVar, bVar, true) : (List) invokeLL.objValue;
    }

    public List<ByteBuffer> a(cx cxVar, by.b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, cxVar, bVar, z)) == null) {
            StringBuilder sb = new StringBuilder(100);
            if (cxVar instanceof cs) {
                sb.append("GET ");
                sb.append(((cs) cxVar).a());
                sb.append(" HTTP/1.1");
            } else if (cxVar instanceof cz) {
                sb.append("HTTP/1.1 101 ");
                sb.append(((cz) cxVar).a());
            } else {
                throw new RuntimeException("unknown role");
            }
            sb.append(Part.CRLF);
            Iterator<String> b2 = cxVar.b();
            while (b2.hasNext()) {
                String next = b2.next();
                String b3 = cxVar.b(next);
                sb.append(next);
                sb.append(": ");
                sb.append(b3);
                sb.append(Part.CRLF);
            }
            sb.append(Part.CRLF);
            byte[] b4 = dc.b(sb.toString());
            byte[] c2 = z ? cxVar.c() : null;
            ByteBuffer allocate = ByteBuffer.allocate((c2 == null ? 0 : c2.length) + b4.length);
            allocate.put(b4);
            if (c2 != null) {
                allocate.put(c2);
            }
            allocate.flip();
            return Collections.singletonList(allocate);
        }
        return (List) invokeLLZ.objValue;
    }

    public int a(int i2) throws ck, ch {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 >= 0) {
                return i2;
            }
            throw new ch(1002, "Negative count");
        }
        return invokeI.intValue;
    }

    public void a(by.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f41234d = bVar;
        }
    }
}

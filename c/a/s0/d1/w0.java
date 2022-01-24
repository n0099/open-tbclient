package c.a.s0.d1;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class w0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Wire wire, Class<? extends Message> cls) {
        File[] listFiles;
        String name;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, wire, cls) == null) || wire == null || cls == null) {
            return;
        }
        String str = "wire_" + cls.getName();
        File file = new File(TbadkCoreApplication.getInst().getCacheDir(), str + "_" + TbConfig.getVersion());
        byte[] bArr = null;
        try {
            if (file.exists() && (bArr = b(file)) != null) {
                wire.parseFrom(bArr, cls);
            }
            if (bArr == null) {
                byte[] bArr2 = (byte[]) c.a.d.f.b.a.a.c(cls, "toByteArray", new Object[0]).invoke(c(cls, new HashSet()), new Object[0]);
                wire.parseFrom(bArr2, cls);
                d(file, bArr2);
            }
        } catch (Throwable th) {
            BdLog.detailException(th);
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
        File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
        if (cacheDir == null || (listFiles = cacheDir.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null && (name = file2.getName()) != null && name.startsWith(str) && !file.getName().equals(name)) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public static byte[] b(File file) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            byte[] bArr = null;
            if (file == null) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr2, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                        bArr = byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            BdLog.e(th.getMessage());
                            return bArr;
                        } finally {
                            c.a.d.f.p.o.e(fileInputStream);
                            c.a.d.f.p.o.f(byteArrayOutputStream);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                fileInputStream = null;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static final Object c(Class<?> cls, HashSet<Class<?>> hashSet) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Type[] actualTypeArguments;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, hashSet)) == null) {
            if (hashSet != null && !hashSet.contains(cls)) {
                hashSet.add(cls);
                try {
                    Class<?> cls2 = Class.forName(cls.getName() + "$Builder");
                    Method declaredMethod = cls2.getDeclaredMethod("build", Boolean.TYPE);
                    Object newInstance = cls2.newInstance();
                    for (Field field : cls2.getDeclaredFields()) {
                        Class<?> type = field.getType();
                        if (type != null) {
                            if (c.a.d.f.b.a.a.e(type, Message.class)) {
                                Object c2 = c(type, hashSet);
                                if (c2 != null) {
                                    if (c.a.d.f.b.a.a.e(c2.getClass(), Message.class)) {
                                        field.setAccessible(true);
                                        field.set(newInstance, c2);
                                    } else {
                                        BdLog.e("");
                                    }
                                }
                            } else if (c.a.d.f.b.a.a.e(type, List.class)) {
                                Type genericType = field.getGenericType();
                                if ((genericType instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) != null && actualTypeArguments.length > 0) {
                                    try {
                                        Class cls3 = (Class) actualTypeArguments[0];
                                        if (c.a.d.f.b.a.a.e(cls3, Message.class)) {
                                            ArrayList arrayList = new ArrayList();
                                            Object c3 = c(cls3, hashSet);
                                            if (c3 != null) {
                                                if (c.a.d.f.b.a.a.e(c3.getClass(), Message.class)) {
                                                    arrayList.add(c3);
                                                } else {
                                                    BdLog.e("");
                                                }
                                                field.setAccessible(true);
                                                field.set(newInstance, arrayList);
                                            }
                                        }
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    }
                    return declaredMethod.invoke(newInstance, Boolean.TRUE);
                } catch (Throwable th) {
                    BdLog.detailException(th);
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static final boolean d(File file, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65539, null, file, bArr)) != null) {
            return invokeLL.booleanValue;
        }
        if (file == null || bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists() || file.delete()) {
                if (file.createNewFile()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr, 0, bArr.length);
                        fileOutputStream2.flush();
                        c.a.d.f.p.o.f(fileOutputStream2);
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        try {
                            BdLog.e(th.getMessage());
                            return false;
                        } finally {
                            c.a.d.f.p.o.f(fileOutputStream);
                        }
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

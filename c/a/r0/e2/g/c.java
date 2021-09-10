package c.a.r0.e2.g;

import com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f17289a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f17290b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-284087273, "Lc/a/r0/e2/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-284087273, "Lc/a/r0/e2/g/c;");
                return;
            }
        }
        f17289a = c.a.r0.e2.c.f17248c + "draft/";
        f17290b = f17289a + "upload_draft";
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            File file = new File(f17290b);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0010 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.baidu.tieba.newfaceshop.facemake.FaceGroupDraft] */
    public static FaceGroupDraft b() {
        InterceptResult invokeV;
        FaceGroupDraft faceGroupDraft;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (FaceGroupDraft) invokeV.objValue;
        }
        File file = new File(f17290b);
        ?? r2 = 0;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        FaceGroupDraft faceGroupDraft2 = null;
        r2 = null;
        r2 = null;
        ObjectInputStream objectInputStream = null;
        try {
            if (!file.exists()) {
                return null;
            }
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(file));
                try {
                    Object readObject = objectInputStream2.readObject();
                    if (readObject != null && (readObject instanceof FaceGroupDraft)) {
                        faceGroupDraft2 = (FaceGroupDraft) readObject;
                    }
                    objectInputStream2.close();
                    c.a.e.e.m.a.c(objectInputStream2);
                    return faceGroupDraft2;
                } catch (IOException e2) {
                    e = e2;
                    FaceGroupDraft faceGroupDraft3 = faceGroupDraft2;
                    objectInputStream = objectInputStream2;
                    faceGroupDraft = faceGroupDraft3;
                    e.printStackTrace();
                    c.a.e.e.m.a.c(objectInputStream);
                    r2 = faceGroupDraft;
                    return r2;
                } catch (ClassNotFoundException e3) {
                    e = e3;
                    FaceGroupDraft faceGroupDraft4 = faceGroupDraft2;
                    objectInputStream = objectInputStream2;
                    faceGroupDraft = faceGroupDraft4;
                    e.printStackTrace();
                    c.a.e.e.m.a.c(objectInputStream);
                    r2 = faceGroupDraft;
                    return r2;
                } catch (Throwable th) {
                    th = th;
                    FaceGroupDraft faceGroupDraft5 = faceGroupDraft2;
                    objectInputStream = objectInputStream2;
                    faceGroupDraft = faceGroupDraft5;
                    th.printStackTrace();
                    c.a.e.e.m.a.c(objectInputStream);
                    r2 = faceGroupDraft;
                    return r2;
                }
            } catch (IOException e4) {
                e = e4;
                faceGroupDraft = null;
            } catch (ClassNotFoundException e5) {
                e = e5;
                faceGroupDraft = null;
            } catch (Throwable th2) {
                th = th2;
                faceGroupDraft = null;
            }
        } catch (Throwable th3) {
            c.a.e.e.m.a.c(r2);
            throw th3;
        }
    }

    public static void c(FaceGroupDraft faceGroupDraft) {
        ObjectOutputStream objectOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, faceGroupDraft) == null) {
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    File file = new File(f17289a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    a();
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(f17290b));
                } finally {
                    c.a.e.e.m.a.d(objectOutputStream2);
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeObject(faceGroupDraft);
                c.a.e.e.m.a.d(objectOutputStream);
            } catch (FileNotFoundException e4) {
                e = e4;
                objectOutputStream2 = objectOutputStream;
                e.printStackTrace();
            } catch (IOException e5) {
                e = e5;
                objectOutputStream2 = objectOutputStream;
                e.printStackTrace();
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                th.printStackTrace();
            }
        }
    }
}

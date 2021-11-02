package b.a.e.e.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.e.e.a.b f1594a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f1595b;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f1596c;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1597a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(576053026, "Lb/a/e/e/a/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(576053026, "Lb/a/e/e/a/e$a;");
                    return;
                }
            }
            int[] iArr = new int[DiskFileOperate.Action.values().length];
            f1597a = iArr;
            try {
                iArr[DiskFileOperate.Action.WRITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1597a[DiskFileOperate.Action.WRITE_FORCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1597a[DiskFileOperate.Action.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1597a[DiskFileOperate.Action.DELETE_FILES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1597a[DiskFileOperate.Action.APPEND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1597a[DiskFileOperate.Action.APPEND_MORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1597a[DiskFileOperate.Action.INFO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1597a[DiskFileOperate.Action.RENAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1597a[DiskFileOperate.Action.READ.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1597a[DiskFileOperate.Action.CUSTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b.a.e.e.a.b bVar);
    }

    public e(b.a.e.e.a.b bVar, DiskFileOperate diskFileOperate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, diskFileOperate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1594a = null;
        this.f1595b = null;
        this.f1596c = null;
        if (bVar != null && diskFileOperate != null && diskFileOperate.getAction() != null) {
            this.f1595b = new AtomicBoolean(false);
            this.f1594a = bVar;
            this.f1596c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskWorker Parameter is null");
    }

    private boolean delete() {
        InterceptResult invokeV;
        File c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                try {
                    c2 = this.f1594a.c(this.f1596c.buildPath(), this.f1596c.getName(), false, this.f1596c.isSdCard(), this.f1596c.isSavedCache());
                } catch (Exception e2) {
                    e2.getMessage();
                }
                if (c2 != null && !this.f1595b.get()) {
                    r0 = c2.exists() ? c2.delete() : false;
                    if (r0) {
                        this.f1596c.setFileInfo(c2);
                        this.f1596c.setSuccess(true);
                    }
                    return r0;
                }
                return false;
            } finally {
                this.f1596c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            OutputStream outputStream = this.f1596c.getOutputStream();
            File fileInfo = this.f1596c.getFileInfo();
            try {
                if (outputStream == null) {
                    try {
                        fileInfo = this.f1594a.c(this.f1596c.buildPath(), this.f1596c.getName(), true, this.f1596c.isSdCard(), this.f1596c.isSavedCache());
                        if (fileInfo != null && !this.f1595b.get()) {
                            outputStream = new FileOutputStream(fileInfo, true);
                        }
                        this.f1596c.unLock();
                        return false;
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                        if (!z) {
                            b.a.e.e.m.a.d(outputStream);
                        }
                        this.f1596c.unLock();
                        return false;
                    }
                }
                byte[] buildFormatData = this.f1596c.buildFormatData();
                byte[] data = this.f1596c.getData();
                if ((buildFormatData == null && data == null) || this.f1595b.get()) {
                    if (!z) {
                        b.a.e.e.m.a.d(outputStream);
                    }
                    this.f1596c.unLock();
                    return false;
                }
                if (buildFormatData != null) {
                    outputStream.write(buildFormatData);
                }
                if (data != null) {
                    outputStream.write(data);
                }
                outputStream.flush();
                this.f1596c.setFileInfo(fileInfo);
                this.f1596c.setSuccess(true);
                if (!z) {
                    b.a.e.e.m.a.d(outputStream);
                } else {
                    this.f1596c.setOutputStream(outputStream);
                }
                this.f1596c.unLock();
                return true;
            } catch (Throwable th) {
                if (!z) {
                    b.a.e.e.m.a.d(outputStream);
                }
                this.f1596c.unLock();
                throw th;
            }
        }
        return invokeZ.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f1595b.set(true);
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                try {
                    r0 = this.f1596c.getCustomOperate() != null ? this.f1596c.getCustomOperate().a(this, this.f1596c, this.f1594a) : false;
                    if (r0) {
                        this.f1596c.setSuccess(true);
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                return r0;
            } finally {
                this.f1596c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            switch (a.f1597a[this.f1596c.getAction().ordinal()]) {
                case 1:
                    return i(false);
                case 2:
                    return i(true);
                case 3:
                    return delete();
                case 4:
                    return e();
                case 5:
                    return a(false);
                case 6:
                    return a(true);
                case 7:
                    return f();
                case 8:
                    return h();
                case 9:
                    return g();
                case 10:
                    return c();
                default:
                    return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, file)) == null) {
            if (file != null) {
                DiskFileOperate diskFileOperate = this.f1596c;
                if (diskFileOperate instanceof b.a.e.e.a.a) {
                    b.a.e.e.a.a aVar = (b.a.e.e.a.a) diskFileOperate;
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null) {
                            for (int i2 = 0; i2 < listFiles.length && !this.f1595b.get(); i2++) {
                                if (listFiles[i2].isDirectory()) {
                                    d(listFiles[i2]);
                                } else if (aVar.compare(listFiles[i2])) {
                                    listFiles[i2].delete();
                                }
                            }
                        }
                        file.delete();
                    } else if (aVar.compare(file)) {
                        file.delete();
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            boolean z = false;
            try {
                try {
                    File d2 = this.f1594a.d(this.f1596c.getPath(), false, this.f1596c.isSdCard(), this.f1596c.isSavedCache());
                    z = d(d2);
                    if (z) {
                        this.f1596c.setFileInfo(d2);
                        this.f1596c.setSuccess(true);
                    }
                } catch (Exception e2) {
                    e2.getMessage();
                }
                return z;
            } finally {
                this.f1596c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        File d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f1596c.getName() != null) {
                d2 = this.f1594a.c(this.f1596c.buildPath(), this.f1596c.getName(), false, this.f1596c.isSdCard(), this.f1596c.isSavedCache());
            } else {
                d2 = this.f1594a.d(this.f1596c.buildPath(), false, this.f1596c.isSdCard(), this.f1596c.isSavedCache());
            }
            if (d2 != null && d2.exists()) {
                this.f1596c.setFileInfo(d2);
                this.f1596c.setSuccess(true);
                this.f1596c.unLock();
                return true;
            }
            this.f1596c.unLock();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        Exception e2;
        Throwable th;
        File c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            this.f1596c.startLog();
            boolean z = false;
            try {
                c2 = this.f1594a.c(this.f1596c.buildPath(), this.f1596c.getName(), false, this.f1596c.isSdCard(), this.f1596c.isSavedCache());
            } catch (Exception e3) {
                fileInputStream = null;
                e2 = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                fileInputStream = null;
            }
            if (c2 != null && c2.exists() && !this.f1595b.get()) {
                fileInputStream = new FileInputStream(c2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr, 0, 1024);
                                if (read == -1 || this.f1595b.get()) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            if (!this.f1595b.get()) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                if (!this.f1596c.isFormatData() || this.f1596c.formatData(byteArray)) {
                                    this.f1596c.setData(byteArray);
                                    z = true;
                                }
                            }
                            b.a.e.e.m.a.c(fileInputStream);
                            b.a.e.e.m.a.d(byteArrayOutputStream);
                            if (z) {
                                this.f1596c.setSuccess(true);
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            BdLog.e(e2.getMessage());
                            b.a.e.e.m.a.c(fileInputStream);
                            b.a.e.e.m.a.d(byteArrayOutputStream);
                            this.f1596c.unLock();
                            this.f1596c.endLog();
                            return z;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        b.a.e.e.m.a.c(fileInputStream);
                        b.a.e.e.m.a.d(byteArrayOutputStream);
                        this.f1596c.unLock();
                        throw th;
                    }
                } catch (Exception e5) {
                    byteArrayOutputStream = null;
                    e2 = e5;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    th = th;
                    b.a.e.e.m.a.c(fileInputStream);
                    b.a.e.e.m.a.d(byteArrayOutputStream);
                    this.f1596c.unLock();
                    throw th;
                }
                this.f1596c.unLock();
                this.f1596c.endLog();
                return z;
            }
            b.a.e.e.m.a.c(null);
            b.a.e.e.m.a.d(null);
            this.f1596c.unLock();
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            boolean z = false;
            try {
                try {
                    File c2 = this.f1594a.c(this.f1596c.buildPath(), this.f1596c.getName(), false, this.f1596c.isSdCard(), this.f1596c.isSavedCache());
                    File c3 = this.f1594a.c(this.f1596c.buildDesPath(), this.f1596c.getDesName(), true, this.f1596c.isSdCard(), this.f1596c.isSavedCache());
                    if (c2 != null) {
                        if (c3 != null) {
                            c3.delete();
                        }
                        z = c2.renameTo(c3);
                    }
                    if (z) {
                        this.f1596c.setSuccess(true);
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                return z;
            } finally {
                this.f1596c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeZ = interceptable.invokeZ(1048585, this, z)) != null) {
            return invokeZ.booleanValue;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File c2 = this.f1594a.c(this.f1596c.buildPath(), this.f1596c.getName(), true, this.f1596c.isSdCard(), this.f1596c.isSavedCache());
                if (c2 != null && !this.f1595b.get()) {
                    if (c2.exists()) {
                        if (z) {
                            c2.delete();
                        } else {
                            b.a.e.e.m.a.d(null);
                            this.f1596c.unLock();
                            return true;
                        }
                    }
                    byte[] buildFormatData = this.f1596c.buildFormatData();
                    byte[] data = this.f1596c.getData();
                    if ((buildFormatData != null || data != null) && !this.f1595b.get()) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(c2);
                        if (buildFormatData != null) {
                            try {
                                fileOutputStream2.write(buildFormatData);
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                BdLog.e(e.getMessage());
                                b.a.e.e.m.a.d(fileOutputStream);
                                this.f1596c.unLock();
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                b.a.e.e.m.a.d(fileOutputStream);
                                this.f1596c.unLock();
                                throw th;
                            }
                        }
                        if (data != null) {
                            fileOutputStream2.write(data);
                        }
                        fileOutputStream2.flush();
                        b.a.e.e.m.a.d(fileOutputStream2);
                        this.f1596c.setFileInfo(c2);
                        this.f1596c.setSuccess(true);
                        this.f1596c.unLock();
                        return true;
                    }
                }
                b.a.e.e.m.a.d(null);
                this.f1596c.unLock();
                return false;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}

package c.a.e.e.a;

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
    public c.a.e.e.a.b f2054a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f2055b;

    /* renamed from: c  reason: collision with root package name */
    public DiskFileOperate f2056c;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2057a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(70494401, "Lc/a/e/e/a/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(70494401, "Lc/a/e/e/a/e$a;");
                    return;
                }
            }
            int[] iArr = new int[DiskFileOperate.Action.values().length];
            f2057a = iArr;
            try {
                iArr[DiskFileOperate.Action.WRITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2057a[DiskFileOperate.Action.WRITE_FORCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2057a[DiskFileOperate.Action.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2057a[DiskFileOperate.Action.DELETE_FILES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2057a[DiskFileOperate.Action.APPEND.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2057a[DiskFileOperate.Action.APPEND_MORE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2057a[DiskFileOperate.Action.INFO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2057a[DiskFileOperate.Action.RENAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2057a[DiskFileOperate.Action.READ.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2057a[DiskFileOperate.Action.CUSTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(e eVar, DiskFileOperate diskFileOperate, c.a.e.e.a.b bVar);
    }

    public e(c.a.e.e.a.b bVar, DiskFileOperate diskFileOperate) {
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
        this.f2054a = null;
        this.f2055b = null;
        this.f2056c = null;
        if (bVar != null && diskFileOperate != null && diskFileOperate.getAction() != null) {
            this.f2055b = new AtomicBoolean(false);
            this.f2054a = bVar;
            this.f2056c = diskFileOperate;
            return;
        }
        throw new InvalidParameterException("DiskWorker Parameter is null");
    }

    public boolean a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            OutputStream outputStream = this.f2056c.getOutputStream();
            File fileInfo = this.f2056c.getFileInfo();
            try {
                if (outputStream == null) {
                    try {
                        fileInfo = this.f2054a.c(this.f2056c.buildPath(), this.f2056c.getName(), true, this.f2056c.isSdCard(), this.f2056c.isSavedCache());
                        if (fileInfo != null && !this.f2055b.get()) {
                            outputStream = new FileOutputStream(fileInfo, true);
                        }
                        this.f2056c.unLock();
                        return false;
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                        if (!z) {
                            c.a.e.e.m.a.d(outputStream);
                        }
                        this.f2056c.unLock();
                        return false;
                    }
                }
                byte[] buildFormatData = this.f2056c.buildFormatData();
                byte[] data = this.f2056c.getData();
                if ((buildFormatData == null && data == null) || this.f2055b.get()) {
                    if (!z) {
                        c.a.e.e.m.a.d(outputStream);
                    }
                    this.f2056c.unLock();
                    return false;
                }
                if (buildFormatData != null) {
                    outputStream.write(buildFormatData);
                }
                if (data != null) {
                    outputStream.write(data);
                }
                outputStream.flush();
                this.f2056c.setFileInfo(fileInfo);
                this.f2056c.setSuccess(true);
                if (!z) {
                    c.a.e.e.m.a.d(outputStream);
                } else {
                    this.f2056c.setOutputStream(outputStream);
                }
                this.f2056c.unLock();
                return true;
            } catch (Throwable th) {
                if (!z) {
                    c.a.e.e.m.a.d(outputStream);
                }
                this.f2056c.unLock();
                throw th;
            }
        }
        return invokeZ.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            switch (a.f2057a[this.f2056c.getAction().ordinal()]) {
                case 1:
                    return k(false);
                case 2:
                    return k(true);
                case 3:
                    return e();
                case 4:
                    return g();
                case 5:
                    return a(false);
                case 6:
                    return a(true);
                case 7:
                    return h();
                case 8:
                    return j();
                case 9:
                    return i();
                case 10:
                    return d();
                default:
                    return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f2055b.set(true);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                try {
                    r0 = this.f2056c.getCustomOperate() != null ? this.f2056c.getCustomOperate().a(this, this.f2056c, this.f2054a) : false;
                    if (r0) {
                        this.f2056c.setSuccess(true);
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                return r0;
            } finally {
                this.f2056c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        File c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                try {
                    c2 = this.f2054a.c(this.f2056c.buildPath(), this.f2056c.getName(), false, this.f2056c.isSdCard(), this.f2056c.isSavedCache());
                } catch (Exception e2) {
                    e2.getMessage();
                }
                if (c2 != null && !this.f2055b.get()) {
                    r0 = c2.exists() ? c2.delete() : false;
                    if (r0) {
                        this.f2056c.setFileInfo(c2);
                        this.f2056c.setSuccess(true);
                    }
                    return r0;
                }
                return false;
            } finally {
                this.f2056c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean f(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, file)) == null) {
            if (file != null) {
                DiskFileOperate diskFileOperate = this.f2056c;
                if (diskFileOperate instanceof c.a.e.e.a.a) {
                    c.a.e.e.a.a aVar = (c.a.e.e.a.a) diskFileOperate;
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null) {
                            for (int i2 = 0; i2 < listFiles.length && !this.f2055b.get(); i2++) {
                                if (listFiles[i2].isDirectory()) {
                                    f(listFiles[i2]);
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

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            boolean z = false;
            try {
                try {
                    File d2 = this.f2054a.d(this.f2056c.getPath(), false, this.f2056c.isSdCard(), this.f2056c.isSavedCache());
                    z = f(d2);
                    if (z) {
                        this.f2056c.setFileInfo(d2);
                        this.f2056c.setSuccess(true);
                    }
                } catch (Exception e2) {
                    e2.getMessage();
                }
                return z;
            } finally {
                this.f2056c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        File d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f2056c.getName() != null) {
                d2 = this.f2054a.c(this.f2056c.buildPath(), this.f2056c.getName(), false, this.f2056c.isSdCard(), this.f2056c.isSavedCache());
            } else {
                d2 = this.f2054a.d(this.f2056c.buildPath(), false, this.f2056c.isSdCard(), this.f2056c.isSavedCache());
            }
            if (d2 != null && d2.exists()) {
                this.f2056c.setFileInfo(d2);
                this.f2056c.setSuccess(true);
                this.f2056c.unLock();
                return true;
            }
            this.f2056c.unLock();
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        Exception e2;
        Throwable th;
        File c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            this.f2056c.startLog();
            boolean z = false;
            try {
                c2 = this.f2054a.c(this.f2056c.buildPath(), this.f2056c.getName(), false, this.f2056c.isSdCard(), this.f2056c.isSavedCache());
            } catch (Exception e3) {
                fileInputStream = null;
                e2 = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                fileInputStream = null;
            }
            if (c2 != null && c2.exists() && !this.f2055b.get()) {
                fileInputStream = new FileInputStream(c2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr, 0, 1024);
                                if (read == -1 || this.f2055b.get()) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            if (!this.f2055b.get()) {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                if (!this.f2056c.isFormatData() || this.f2056c.formatData(byteArray)) {
                                    this.f2056c.setData(byteArray);
                                    z = true;
                                }
                            }
                            c.a.e.e.m.a.c(fileInputStream);
                            c.a.e.e.m.a.d(byteArrayOutputStream);
                            if (z) {
                                this.f2056c.setSuccess(true);
                            }
                        } catch (Exception e4) {
                            e2 = e4;
                            BdLog.e(e2.getMessage());
                            c.a.e.e.m.a.c(fileInputStream);
                            c.a.e.e.m.a.d(byteArrayOutputStream);
                            this.f2056c.unLock();
                            this.f2056c.endLog();
                            return z;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        c.a.e.e.m.a.c(fileInputStream);
                        c.a.e.e.m.a.d(byteArrayOutputStream);
                        this.f2056c.unLock();
                        throw th;
                    }
                } catch (Exception e5) {
                    byteArrayOutputStream = null;
                    e2 = e5;
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream = null;
                    th = th;
                    c.a.e.e.m.a.c(fileInputStream);
                    c.a.e.e.m.a.d(byteArrayOutputStream);
                    this.f2056c.unLock();
                    throw th;
                }
                this.f2056c.unLock();
                this.f2056c.endLog();
                return z;
            }
            c.a.e.e.m.a.c(null);
            c.a.e.e.m.a.d(null);
            this.f2056c.unLock();
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            boolean z = false;
            try {
                try {
                    File c2 = this.f2054a.c(this.f2056c.buildPath(), this.f2056c.getName(), false, this.f2056c.isSdCard(), this.f2056c.isSavedCache());
                    File c3 = this.f2054a.c(this.f2056c.buildDesPath(), this.f2056c.getDesName(), true, this.f2056c.isSdCard(), this.f2056c.isSavedCache());
                    if (c2 != null) {
                        if (c3 != null) {
                            c3.delete();
                        }
                        z = c2.renameTo(c3);
                    }
                    if (z) {
                        this.f2056c.setSuccess(true);
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                return z;
            } finally {
                this.f2056c.unLock();
            }
        }
        return invokeV.booleanValue;
    }

    public boolean k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeZ = interceptable.invokeZ(1048586, this, z)) != null) {
            return invokeZ.booleanValue;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File c2 = this.f2054a.c(this.f2056c.buildPath(), this.f2056c.getName(), true, this.f2056c.isSdCard(), this.f2056c.isSavedCache());
                if (c2 != null && !this.f2055b.get()) {
                    if (c2.exists()) {
                        if (z) {
                            c2.delete();
                        } else {
                            c.a.e.e.m.a.d(null);
                            this.f2056c.unLock();
                            return true;
                        }
                    }
                    byte[] buildFormatData = this.f2056c.buildFormatData();
                    byte[] data = this.f2056c.getData();
                    if ((buildFormatData != null || data != null) && !this.f2055b.get()) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(c2);
                        if (buildFormatData != null) {
                            try {
                                fileOutputStream2.write(buildFormatData);
                            } catch (Exception e2) {
                                e = e2;
                                fileOutputStream = fileOutputStream2;
                                BdLog.e(e.getMessage());
                                c.a.e.e.m.a.d(fileOutputStream);
                                this.f2056c.unLock();
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                c.a.e.e.m.a.d(fileOutputStream);
                                this.f2056c.unLock();
                                throw th;
                            }
                        }
                        if (data != null) {
                            fileOutputStream2.write(data);
                        }
                        fileOutputStream2.flush();
                        c.a.e.e.m.a.d(fileOutputStream2);
                        this.f2056c.setFileInfo(c2);
                        this.f2056c.setSuccess(true);
                        this.f2056c.unLock();
                        return true;
                    }
                }
                c.a.e.e.m.a.d(null);
                this.f2056c.unLock();
                return false;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }
}

package c.a.o0.a.k2.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public abstract class a implements e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final ReadWriteLock f7086c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public File f7087a;

    /* renamed from: b  reason: collision with root package name */
    public final long f7088b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-617441803, "Lc/a/o0/a/k2/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-617441803, "Lc/a/o0/a/k2/f/a;");
                return;
            }
        }
        f7086c = new ReentrantReadWriteLock();
    }

    public a() {
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
        this.f7087a = d();
        this.f7088b = getMaxSize();
    }

    @Override // c.a.o0.a.k2.f.e
    public boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            f7086c.readLock().lock();
            try {
                return e() + j2 > this.f7088b;
            } finally {
                f7086c.readLock().unlock();
            }
        }
        return invokeJ.booleanValue;
    }

    @Override // c.a.o0.a.k2.f.e
    public void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            f7086c.writeLock().lock();
            try {
                try {
                    if (this.f7087a == null) {
                        this.f7087a = d();
                    }
                    File file = this.f7087a;
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    c.a.o0.t.d.N(String.valueOf(e() + j2).getBytes(), file);
                } catch (Exception e2) {
                    if (k.f7049a) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                f7086c.writeLock().unlock();
            }
        }
    }

    @NonNull
    public abstract String c();

    public final File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new File(c() + File.separator + "record.pro");
        }
        return (File) invokeV.objValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f7087a == null) {
                this.f7087a = d();
            }
            File file = this.f7087a;
            if (file.exists() && file.isFile()) {
                String D = c.a.o0.t.d.D(file);
                try {
                    if (!TextUtils.isEmpty(D) && TextUtils.isDigitsOnly(D.trim())) {
                        return Long.valueOf(D.trim()).longValue();
                    }
                } catch (Exception e2) {
                    if (k.f7049a) {
                        e2.printStackTrace();
                    }
                }
            }
            return 0L;
        }
        return invokeV.longValue;
    }
}

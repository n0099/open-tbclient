package c.b.b.m;

import androidx.core.view.InputDeviceCompat;
import c.b.b.f;
import c.b.b.q.i0;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.utility.FileUtil;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;

    /* renamed from: b  reason: collision with root package name */
    public Files.FileType f27314b;

    /* renamed from: c.b.b.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1624a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(310290513, "Lc/b/b/m/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(310290513, "Lc/b/b/m/a$a;");
                    return;
                }
            }
            int[] iArr = new int[Files.FileType.values().length];
            a = iArr;
            try {
                iArr[Files.FileType.Internal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Files.FileType.Classpath.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Files.FileType.Absolute.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Files.FileType.External.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.getPath().length() == 0 ? new a(new File(str), this.f27314b) : new a(new File(this.a, str), this.f27314b) : (a) invokeL.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int f2 = (int) f();
            if (f2 != 0) {
                return f2;
            }
            return 512;
        }
        return invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = C1624a.a[this.f27314b.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return e().exists();
                }
            } else if (e().exists()) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(this.a.getPath().replace(FileUtil.WINDOWS_SEPARATOR, '/'));
            return a.class.getResource(sb.toString()) != null;
        }
        return invokeV.booleanValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String name = this.a.getName();
            int lastIndexOf = name.lastIndexOf(46);
            return lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1);
        }
        return (String) invokeV.objValue;
    }

    public boolean delete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Files.FileType fileType = this.f27314b;
            if (fileType != Files.FileType.Classpath) {
                if (fileType != Files.FileType.Internal) {
                    return e().delete();
                }
                throw new GdxRuntimeException("Cannot delete an internal file: " + this.a);
            }
            throw new GdxRuntimeException("Cannot delete a classpath file: " + this.a);
        }
        return invokeV.booleanValue;
    }

    public File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f27314b == Files.FileType.External ? new File(f.f27172d.e(), this.a.getPath()) : this.a : (File) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f27314b == aVar.f27314b && j().equals(aVar.j());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Files.FileType fileType = this.f27314b;
            if (fileType != Files.FileType.Classpath && (fileType != Files.FileType.Internal || this.a.exists())) {
                return e().length();
            }
            InputStream m = m();
            try {
                long available = m.available();
                i0.a(m);
                return available;
            } catch (Exception unused) {
                i0.a(m);
                return 0L;
            } catch (Throwable th) {
                i0.a(m);
                throw th;
            }
        }
        return invokeV.longValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.getName() : (String) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String name = this.a.getName();
            int lastIndexOf = name.lastIndexOf(46);
            return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? ((37 + this.f27314b.hashCode()) * 67) + j().hashCode() : invokeV.intValue;
    }

    public a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            File parentFile = this.a.getParentFile();
            if (parentFile == null) {
                if (this.f27314b == Files.FileType.Absolute) {
                    parentFile = new File("/");
                } else {
                    parentFile = new File("");
                }
            }
            return new a(parentFile, this.f27314b);
        }
        return (a) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.a.getPath().replace(FileUtil.WINDOWS_SEPARATOR, '/') : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String replace = this.a.getPath().replace(FileUtil.WINDOWS_SEPARATOR, '/');
            int lastIndexOf = replace.lastIndexOf(46);
            return lastIndexOf == -1 ? replace : replace.substring(0, lastIndexOf);
        }
        return (String) invokeV.objValue;
    }

    public BufferedInputStream l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) ? new BufferedInputStream(m(), i2) : (BufferedInputStream) invokeI.objValue;
    }

    public InputStream m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Files.FileType fileType = this.f27314b;
            if (fileType != Files.FileType.Classpath && ((fileType != Files.FileType.Internal || e().exists()) && (this.f27314b != Files.FileType.Local || e().exists()))) {
                try {
                    return new FileInputStream(e());
                } catch (Exception e2) {
                    if (e().isDirectory()) {
                        throw new GdxRuntimeException("Cannot open a stream to a directory: " + this.a + " (" + this.f27314b + SmallTailInfo.EMOTION_SUFFIX, e2);
                    }
                    throw new GdxRuntimeException("Error reading file: " + this.a + " (" + this.f27314b + SmallTailInfo.EMOTION_SUFFIX, e2);
                }
            }
            InputStream resourceAsStream = a.class.getResourceAsStream("/" + this.a.getPath().replace(FileUtil.WINDOWS_SEPARATOR, '/'));
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
            throw new GdxRuntimeException("File not found: " + this.a + " (" + this.f27314b + SmallTailInfo.EMOTION_SUFFIX);
        }
        return (InputStream) invokeV.objValue;
    }

    public byte[] n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            InputStream m = m();
            try {
                try {
                    return i0.d(m, b());
                } catch (IOException e2) {
                    throw new GdxRuntimeException("Error reading file: " + this, e2);
                }
            } finally {
                i0.a(m);
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? p(null) : (String) invokeV.objValue;
    }

    public String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048594, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        StringBuilder sb = new StringBuilder(b());
        InputStreamReader inputStreamReader = null;
        try {
            try {
                if (str == null) {
                    inputStreamReader = new InputStreamReader(m());
                } else {
                    inputStreamReader = new InputStreamReader(m(), str);
                }
                char[] cArr = new char[256];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        i0.a(inputStreamReader);
                        return sb.toString();
                    }
                    sb.append(cArr, 0, read);
                }
            } catch (IOException e2) {
                throw new GdxRuntimeException("Error reading layout file: " + this, e2);
            }
        } catch (Throwable th) {
            i0.a(inputStreamReader);
            throw th;
        }
    }

    public BufferedReader q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? new BufferedReader(new InputStreamReader(m()), i2) : (BufferedReader) invokeI.objValue;
    }

    public Reader r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            InputStream m = m();
            try {
                return new InputStreamReader(m, str);
            } catch (UnsupportedEncodingException e2) {
                i0.a(m);
                throw new GdxRuntimeException("Error reading file: " + this, e2);
            }
        }
        return (Reader) invokeL.objValue;
    }

    public a s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            if (this.a.getPath().length() != 0) {
                return new a(new File(this.a.getParent(), str), this.f27314b);
            }
            throw new GdxRuntimeException("Cannot get the sibling of the root.");
        }
        return (a) invokeL.objValue;
    }

    public Files.FileType t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f27314b : (Files.FileType) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a.getPath().replace(FileUtil.WINDOWS_SEPARATOR, '/') : (String) invokeV.objValue;
    }

    public a(String str, Files.FileType fileType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, fileType};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f27314b = fileType;
        this.a = new File(str);
    }

    public a(File file, Files.FileType fileType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, fileType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = file;
        this.f27314b = fileType;
    }
}

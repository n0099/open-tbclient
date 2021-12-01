package c.a.t0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f26268b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1350905126, "Lc/a/t0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1350905126, "Lc/a/t0/b;");
                return;
            }
        }
        f26268b = b0.m();
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public final boolean a(l0 l0Var) {
        InterceptResult invokeL;
        File[] listFiles;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, l0Var)) == null) {
            File file = new File(this.a.getFilesDir() + File.separator + "ubcdir", "proc");
            if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
                return false;
            }
            for (File file2 : listFiles) {
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                        long j2 = Long.MAX_VALUE;
                        int i2 = 0;
                        long j3 = 0;
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                                if (jSONObject.has("abtest")) {
                                    l0Var.K("1");
                                }
                                long j4 = jSONObject.getLong("timestamp");
                                if (j4 > 0) {
                                    if (j4 < j2) {
                                        j2 = j4;
                                    }
                                    if (j4 > j3) {
                                        j3 = j4;
                                    }
                                }
                                if (f26268b) {
                                    jSONObject.toString();
                                }
                                l0Var.b(jSONObject);
                                i2++;
                                if (i2 >= 10) {
                                    break;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                        l0Var.J(j2, j3);
                        if (f26268b) {
                            String str = "line num " + i2 + " delete file ";
                        }
                        try {
                            bufferedReader2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final File b(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            File file = new File(this.a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!TextUtils.isEmpty(str)) {
                File file2 = new File(file, "proc");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                return new File(file2, str);
            }
            return new File(file, z ? "filereal" : "filedata");
        }
        return (File) invokeLZ.objValue;
    }

    public void c(boolean z) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            File file = new File(this.a.getFilesDir(), "ubcdir");
            if (file.exists()) {
                File file2 = new File(file, z ? "filereal" : "filedata");
                if (file2.exists()) {
                    file2.delete();
                }
                File file3 = new File(file, "proc");
                if (!file3.exists() || !file3.isDirectory() || (listFiles = file3.listFiles()) == null || listFiles.length == 0) {
                    return;
                }
                for (File file4 : listFiles) {
                    if (file4.isFile()) {
                        file4.delete();
                    }
                }
            }
        }
    }

    public void d(n nVar, File file) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, nVar, file) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", nVar.l());
                jSONObject.put("timestamp", nVar.p());
                jSONObject.put("type", "0");
                if (!TextUtils.isEmpty(nVar.f())) {
                    jSONObject.put("content", nVar.f());
                } else if (nVar.m() != null) {
                    jSONObject.put("content", nVar.m().toString());
                }
                if (!TextUtils.isEmpty(nVar.h())) {
                    jSONObject.put("abtest", nVar.h());
                }
                if (!TextUtils.isEmpty(nVar.e())) {
                    jSONObject.put("c", nVar.e());
                }
                if (nVar.q()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put(Constant.ID_TYPE, g.o().z(nVar.l()));
                JSONObject d2 = nVar.d();
                if (d2 != null) {
                    jSONObject.put("bizInfo", d2);
                }
            } catch (JSONException e2) {
                if (f26268b) {
                    e2.getMessage();
                }
            }
            if (f26268b) {
                String str = "saveEvent:" + jSONObject.toString();
            }
            byte[] encode = Base64.encode(jSONObject.toString().getBytes(), 2);
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, true);
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(encode);
                fileOutputStream.write(StringUtils.LF.getBytes());
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    x.f().a(nVar.l(), false);
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e6) {
                        e = e6;
                        e.printStackTrace();
                        x.f().a(nVar.l(), false);
                    }
                }
                x.f().a(nVar.l(), false);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                x.f().a(nVar.l(), false);
                throw th;
            }
            x.f().a(nVar.l(), false);
        }
    }

    /* JADX DEBUG: Null dom frontier in handler: Exception -> 0x0097 */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008a, code lost:
        if (r1.exists() != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008c, code lost:
        r1.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a7, code lost:
        if (r1.exists() != false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, l0Var)) == null) {
            File file = new File(this.a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "filequality");
            boolean z = false;
            if (file2.exists()) {
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                        long j2 = Long.MAX_VALUE;
                        long j3 = 0;
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                                if (jSONObject.has("abtest")) {
                                    l0Var.K("1");
                                }
                                long j4 = jSONObject.getLong("timestamp");
                                if (j4 > 0) {
                                    if (j4 < j2) {
                                        j2 = j4;
                                    }
                                    if (j4 > j3) {
                                        j3 = j4;
                                    }
                                }
                                l0Var.b(jSONObject);
                                z = true;
                            } catch (Exception unused) {
                                bufferedReader = bufferedReader2;
                                boolean z2 = f26268b;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception unused2) {
                                        boolean z3 = f26268b;
                                    }
                                }
                                if (z) {
                                }
                                return z;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception unused3) {
                                        boolean z4 = f26268b;
                                    }
                                }
                                if (z && file2.exists()) {
                                    file2.delete();
                                }
                                throw th;
                            }
                        }
                        l0Var.J(j2, j3);
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused4) {
                            boolean z5 = f26268b;
                        }
                        if (z) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception unused5) {
                }
                return z;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f(l0 l0Var, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, l0Var, z)) == null) {
            boolean a = !z ? a(l0Var) : false;
            File b2 = b("", z);
            if (b2.exists()) {
                BufferedReader bufferedReader = null;
                try {
                    try {
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(b2));
                            long j2 = Long.MAX_VALUE;
                            long j3 = 0;
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    JSONObject jSONObject = new JSONObject(new String(Base64.decode(readLine.getBytes(), 2)));
                                    if (jSONObject.has("abtest")) {
                                        l0Var.K("1");
                                    }
                                    long j4 = jSONObject.getLong("timestamp");
                                    if (j4 > 0) {
                                        if (j4 < j2) {
                                            j2 = j4;
                                        }
                                        if (j4 > j3) {
                                            j3 = j4;
                                        }
                                    }
                                    l0Var.b(jSONObject);
                                    a = true;
                                } catch (Exception unused) {
                                    bufferedReader = bufferedReader2;
                                    boolean z2 = f26268b;
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    return a;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader2;
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception unused2) {
                                            boolean z3 = f26268b;
                                        }
                                    }
                                    throw th;
                                }
                            }
                            l0Var.J(j2, j3);
                            bufferedReader2.close();
                        } catch (Exception unused3) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception unused4) {
                    boolean z4 = f26268b;
                }
            }
            return a;
        }
        return invokeLZ.booleanValue;
    }

    public void g(n nVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, nVar, z) == null) {
            d(nVar, b(nVar.i(), z));
        }
    }

    public void h(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, exc) == null) {
            if (f26268b) {
                exc.printStackTrace();
            }
            d0.a().h(Log.getStackTraceString(exc));
        }
    }

    public void i(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) {
            File file = new File(this.a.getFilesDir(), "ubcdir");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "filequality");
            if (file2.length() > g.o().p()) {
                if (!file2.delete()) {
                    return;
                }
                file2 = new File(file, "filequality");
            }
            d(nVar, file2);
        }
    }
}

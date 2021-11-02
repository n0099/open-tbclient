package b.a.p0.a.i2.c;

import android.text.TextUtils;
import b.a.p0.a.a2.e;
import b.a.p0.a.k;
import b.a.p0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f6222b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f6223a;

    /* renamed from: b.a.p0.a.i2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0266a implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0266a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                long lastModified = file.lastModified();
                long lastModified2 = file2.lastModified();
                if (lastModified == lastModified2) {
                    return 0;
                }
                return lastModified - lastModified2 > 0 ? 1 : -1;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1752921642, "Lb/a/p0/a/i2/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1752921642, "Lb/a/p0/a/i2/c/a;");
                return;
            }
        }
        f6222b = k.f6397a;
    }

    public a() {
        String str;
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
        try {
            str = AppRuntime.getAppContext().getFilesDir().getPath();
        } catch (Exception e2) {
            if (f6222b) {
                throw e2;
            }
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.f6223a = str + File.separator + "aiapps_folder/stability";
            return;
        }
        this.f6223a = "";
    }

    public final void a(int i2) {
        File[] c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (c2 = c()) == null || c2.length == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Arrays.sort(c2, new C0266a(this));
        ArrayList<File> arrayList = new ArrayList(c2.length);
        int i3 = 0;
        for (File file : c2) {
            if (i3 < i2) {
                if (file.lastModified() - currentTimeMillis > 172800000) {
                    arrayList.add(file);
                }
            } else {
                arrayList.add(file);
            }
            i3++;
        }
        for (File file2 : arrayList) {
            d.i(file2);
        }
    }

    public final File b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            if (TextUtils.isEmpty(this.f6223a)) {
                return null;
            }
            String U = e.U() == null ? "" : e.U();
            return new File(this.f6223a + File.separator + U + "_" + j + "_swan_stability_traces.log");
        }
        return (File) invokeJ.objValue;
    }

    public File[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (TextUtils.isEmpty(this.f6223a)) {
                return null;
            }
            try {
                return new File(this.f6223a).listFiles();
            } catch (Exception unused) {
                boolean z = f6222b;
                return null;
            }
        }
        return (File[]) invokeV.objValue;
    }

    public File d(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                a(9);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("_app_id", e.U() == null ? "" : e.U());
                jSONObject.put("_date", b.a.p0.a.v2.k.b(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
                jSONArray.put(jSONObject);
                File b2 = b(currentTimeMillis);
                if (b2 != null) {
                    if (b.a.p0.a.b1.a.b(b2.getPath(), jSONArray.toString(), false)) {
                        return b2;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                boolean z = f6222b;
                return null;
            }
        }
        return (File) invokeL.objValue;
    }
}

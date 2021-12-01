package c.a.r0.k4.i;

import c.a.d.f.j.a.e;
import c.a.d.f.j.a.h;
import c.a.d.f.p.k;
import c.a.d.f.p.q;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class c extends BdAsyncTask<Void, Void, String> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f18891d;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f18892b;

    /* renamed from: c  reason: collision with root package name */
    public b f18893c;

    /* loaded from: classes6.dex */
    public class a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // c.a.d.f.j.a.h
        public void onProgress(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.a.f18893c == null) {
                return;
            }
            this.a.f18893c.b(i2, i3);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z, String str, String str2);

        void b(int i2, int i3);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(803285401, "Lc/a/r0/k4/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(803285401, "Lc/a/r0/k4/i/c;");
                return;
            }
        }
        f18891d = File.separator;
    }

    public c(String str, String str2, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f18892b = str2;
        this.f18893c = bVar;
    }

    public final void c(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, file) == null) || k.isEmpty(this.a)) {
            return;
        }
        File file2 = new File(this.a);
        if (!file2.exists() || (listFiles = file2.listFiles()) == null) {
            return;
        }
        for (File file3 : listFiles) {
            if (file3 != null && !file3.equals(file)) {
                FileHelper.deleteFileOrDir(file3);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
            if (!k.isEmpty(this.a) && !k.isEmpty(this.f18892b)) {
                new File(this.a).mkdirs();
                String str = this.a + f18891d + "annivervideo.temp";
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                e eVar = new e();
                eVar.b().s(this.f18892b);
                if (new c.a.d.f.j.a.c(eVar).c(str, new a(this), 3, 3000, -1, -1, true, true)) {
                    return e();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            File file = new File(this.a + f18891d + "annivervideo.temp");
            StringBuilder sb = new StringBuilder();
            sb.append(q.c(this.f18892b));
            sb.append(".mp4");
            String sb2 = sb.toString();
            File file2 = new File(this.a + f18891d + sb2);
            if (file2.exists()) {
                file2.delete();
            }
            if (file.renameTo(file2)) {
                c(file2);
                return file2.getAbsolutePath();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f18893c == null) {
            return;
        }
        if (!k.isEmpty(str)) {
            this.f18893c.a(true, str, this.f18892b);
        } else {
            this.f18893c.a(false, null, null);
        }
    }
}

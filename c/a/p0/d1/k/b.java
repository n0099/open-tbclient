package c.a.p0.d1.k;

import c.a.e.e.p.k;
import c.a.e.e.p.q;
import c.a.p0.s.y.r;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class b extends BdAsyncTask<Void, Void, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f13186a;

    /* renamed from: b  reason: collision with root package name */
    public String f13187b;

    /* renamed from: c  reason: collision with root package name */
    public NetWork f13188c;

    /* renamed from: d  reason: collision with root package name */
    public a f13189d;

    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z, String str);
    }

    public b(String str, String str2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13186a = str;
        this.f13187b = str2;
        this.f13189d = aVar;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            try {
                return file.mkdirs();
            } catch (Exception e2) {
                TiebaStatic.file(e2, k.join("FileHelper", ".", "CheckTempDir", " ", str));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
            if (k.isEmpty(this.f13186a) || k.isEmpty(this.f13187b) || !b(this.f13186a)) {
                return null;
            }
            String c2 = q.c(this.f13187b);
            String str = this.f13186a + c2 + "/";
            if (e(str)) {
                return c2;
            }
            NetWork netWork = new NetWork();
            this.f13188c = netWork;
            netWork.setUrl(this.f13187b);
            String str2 = this.f13186a + c2 + ".zip";
            if (this.f13188c.downloadFile(str2, null, 0, 3, 0, true) && f(str2, str)) {
                c(str2);
                return c2;
            }
            c(str2);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? !k.isEmpty(str) && new File(str).exists() : invokeL.booleanValue;
    }

    public final boolean f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            if (k.isEmpty(str) || k.isEmpty(str2)) {
                return false;
            }
            return r.b(str, str2);
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.f13189d == null) {
            return;
        }
        if (!k.isEmpty(str)) {
            this.f13189d.a(true, str);
        } else {
            this.f13189d.a(false, null);
        }
    }
}

package c.a.d.f.n.o;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public final void b() {
            ArrayList<c.a.d.f.n.j.d> c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = c.a.d.f.n.j.b.c(true)) == null || c2.size() == 0) {
                return;
            }
            int i2 = 0;
            Iterator<c.a.d.f.n.j.d> it = c2.iterator();
            while (it.hasNext()) {
                i2 = (int) (i2 + it.next().a);
            }
            int i3 = i2 - IMConstants.MAX_IMAGE_CACHE_DISC_SIZE;
            ArrayList arrayList = new ArrayList();
            if (i3 > 0) {
                Collections.sort(c2, new c.a.d.f.n.j.e());
                Iterator<c.a.d.f.n.j.d> it2 = c2.iterator();
                while (it2.hasNext()) {
                    c.a.d.f.n.j.d next = it2.next();
                    arrayList.add(next.f2530b);
                    i3 = (int) (i3 - next.a);
                    if (i3 <= 0) {
                        break;
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<c.a.d.f.n.j.d> it3 = c2.iterator();
            while (it3.hasNext()) {
                c.a.d.f.n.j.d next2 = it3.next();
                if (next2 != null) {
                    long j2 = next2.f2531c;
                    if (j2 != 0 && j2 + 604800000 < currentTimeMillis && !arrayList.contains(next2.f2530b)) {
                        arrayList.add(next2.f2530b);
                    }
                }
            }
            if (arrayList.size() > 0) {
                c.a.d.f.n.j.b.a(arrayList, true);
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                b();
                return null;
            }
            return (String) invokeL.objValue;
        }
    }

    public i() {
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new b(null).execute(new String[0]);
        }
    }
}

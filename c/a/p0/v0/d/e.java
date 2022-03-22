package c.a.p0.v0.d;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.w.p.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static e f19031c;

    /* renamed from: d  reason: collision with root package name */
    public static BdAsyncTaskParallel f19032d;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c.a.o0.w.p.d> a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.o0.w.p.b> f19033b;

    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ArrayList<c.a.o0.w.p.d> a;

        /* renamed from: b  reason: collision with root package name */
        public final b.a f19034b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f19035c;

        /* renamed from: c.a.p0.v0.d.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1441a implements b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1441a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // c.a.o0.w.p.b.a
            public void a(c.a.o0.w.p.d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                    this.a.a.add(dVar);
                }
            }
        }

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19035c = eVar;
            this.a = new ArrayList<>();
            this.f19034b = new C1441a(this);
            setPriority(4);
            setParallel(e.f19032d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                super.onPostExecute(r5);
                this.f19035c.a = this.a;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                for (int i = 0; i < this.f19035c.f19033b.size(); i++) {
                    ((c.a.o0.w.p.b) this.f19035c.f19033b.get(i)).b(this.f19034b);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2040714483, "Lc/a/p0/v0/d/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2040714483, "Lc/a/p0/v0/d/e;");
                return;
            }
        }
        f19031c = new e();
        f19032d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.f19033b = new ArrayList();
    }

    public static e j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f19031c : (e) invokeV.objValue;
    }

    public void d(String str, c.a.d.o.d.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, str, aVar, z) == null) || aVar == null) {
            return;
        }
        if (z) {
            c.a.o0.b0.c.k().e(f(str, z), aVar, true);
            return;
        }
        c.a.o0.b0.c.k().e(str, aVar, false);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f19033b.isEmpty()) {
            try {
                Class.forName("com.baidu.tieba.faceshop.FaceshopStatic");
            } catch (Throwable th) {
                BdLog.e(th);
            }
            try {
                Class.forName("com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic");
            } catch (Throwable th2) {
                BdLog.e(th2);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004602, new ArrayList()));
        }
    }

    public String f(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (d.f().g()) {
                return str;
            }
            e();
            List<c.a.o0.w.p.d> e2 = d.f().e();
            if (z) {
                for (c.a.o0.w.p.d dVar : e2) {
                    if (dVar.m(str)) {
                        return str;
                    }
                }
                return "#@" + str;
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public String g(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            if (str == null) {
                return null;
            }
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                if (str.equals(c.a.o0.b0.d.f9862d)) {
                    return null;
                }
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("collect_")) {
                    String str2 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + c.a.o0.b0.d.b() + "/" + substring.replace("collect_", "");
                    if (z) {
                        return str2 + "_b.gif";
                    }
                    return str2 + "_s.jpg";
                }
                long hashCode = str.hashCode();
                if (hashCode < 0) {
                    hashCode *= -1;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(z ? "d_" : "s_");
                sb.append(hashCode);
                String sb2 = sb.toString();
                if (z) {
                    return sb2 + ".gif";
                }
                return sb2 + ".jpg";
            }
            long hashCode2 = str.hashCode();
            if (hashCode2 < 0) {
                hashCode2 *= -1;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(z ? "d_" : "s_");
            sb3.append(hashCode2);
            return sb3.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("_")) {
                    return substring.substring(0, substring.indexOf("_"));
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public ArrayList<c.a.o0.w.p.d> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            e();
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            e();
            Iterator<c.a.o0.w.p.d> it = this.a.iterator();
            while (it.hasNext()) {
                if (it.next().m(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (str == null || !k(str)) {
                return false;
            }
            e();
            Iterator<c.a.o0.w.p.d> it = this.a.iterator();
            while (it.hasNext()) {
                c.a.o0.w.p.d next = it.next();
                if (next.m(str)) {
                    return next.h() == EmotionGroupType.LOCAL;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (!c.a.o0.b0.d.f9862d.equals(str) && str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("_") && !substring.contains("collect_")) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? c.a.o0.b0.d.f9862d.equals(str) || str.startsWith(c.a.o0.b0.d.f9863e) : invokeL.booleanValue;
    }

    public c.a.d.o.d.a o(String str, String str2) {
        InterceptResult invokeLL;
        Bitmap p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            c.a.d.o.d.a m = c.a.o0.b0.c.k().m(str2);
            if (m != null) {
                return m;
            }
            e();
            Iterator<c.a.o0.w.p.d> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c.a.o0.w.p.d next = it.next();
                if (next.m(str2)) {
                    m = next.o(str2);
                    break;
                }
            }
            if (m == null && str != null && (p = p(str, g(str2, false))) != null) {
                m = new c.a.d.o.d.a(p, false, str2);
            }
            d(str2, m, false);
            return m;
        }
        return (c.a.d.o.d.a) invokeLL.objValue;
    }

    public Bitmap p(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            return FileHelper.getImage(".emotions/" + str, str2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public void q(c.a.o0.w.p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            synchronized (this.f19033b) {
                if (!this.f19033b.contains(bVar)) {
                    this.f19033b.add(bVar);
                    Collections.sort(this.f19033b);
                }
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            new a(this).execute(new Void[0]);
        }
    }
}

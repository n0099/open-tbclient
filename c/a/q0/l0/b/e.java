package c.a.q0.l0.b;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.x.p.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
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
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static e f21588c;

    /* renamed from: d  reason: collision with root package name */
    public static BdAsyncTaskParallel f21589d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c.a.p0.x.p.c> f21590a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.p0.x.p.a> f21591b;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<c.a.p0.x.p.c> f21592a;

        /* renamed from: b  reason: collision with root package name */
        public final a.InterfaceC0719a f21593b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f21594c;

        /* renamed from: c.a.q0.l0.b.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1005a implements a.InterfaceC0719a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f21595a;

            public C1005a(a aVar) {
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
                        return;
                    }
                }
                this.f21595a = aVar;
            }

            @Override // c.a.p0.x.p.a.InterfaceC0719a
            public void a(c.a.p0.x.p.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                    this.f21595a.f21592a.add(cVar);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21594c = eVar;
            this.f21592a = new ArrayList<>();
            this.f21593b = new C1005a(this);
            setPriority(4);
            setParallel(e.f21589d);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, r5) == null) {
                super.onPostExecute(r5);
                this.f21594c.f21590a = this.f21592a;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001117));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr)) == null) {
                for (int i2 = 0; i2 < this.f21594c.f21591b.size(); i2++) {
                    ((c.a.p0.x.p.a) this.f21594c.f21591b.get(i2)).b(this.f21593b);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1772577508, "Lc/a/q0/l0/b/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1772577508, "Lc/a/q0/l0/b/e;");
                return;
            }
        }
        f21588c = new e();
        f21589d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    }

    public e() {
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
        this.f21590a = new ArrayList<>();
        this.f21591b = new ArrayList();
    }

    public static e i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f21588c : (e) invokeV.objValue;
    }

    public void d(String str, c.a.e.l.d.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, str, aVar, z) == null) || aVar == null) {
            return;
        }
        if (z) {
            c.a.p0.b0.c.k().e(e(str, z), aVar, true);
            return;
        }
        c.a.p0.b0.c.k().e(str, aVar, false);
    }

    public String e(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            if (d.f().g()) {
                return str;
            }
            List<c.a.p0.x.p.c> e2 = d.f().e();
            if (z) {
                for (c.a.p0.x.p.c cVar : e2) {
                    if (cVar.m(str)) {
                        return str;
                    }
                }
                return "#@" + str;
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public String f(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (str == null) {
                return null;
            }
            if (str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                if (str.equals(c.a.p0.b0.d.f12807d)) {
                    return null;
                }
                String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
                String substring = replace.substring(0, replace.indexOf(","));
                if (substring.contains("collect_")) {
                    String str2 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/.collect/" + c.a.p0.b0.d.b() + "/" + substring.replace("collect_", "");
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
                return sb2 + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
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

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
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

    public ArrayList<c.a.p0.x.p.c> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21590a : (ArrayList) invokeV.objValue;
    }

    public boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Iterator<c.a.p0.x.p.c> it = this.f21590a.iterator();
            while (it.hasNext()) {
                if (it.next().m(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str == null || !j(str)) {
                return false;
            }
            Iterator<c.a.p0.x.p.c> it = this.f21590a.iterator();
            while (it.hasNext()) {
                c.a.p0.x.p.c next = it.next();
                if (next.m(str)) {
                    return next.h() == EmotionGroupType.LOCAL;
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
            if (!c.a.p0.b0.d.f12807d.equals(str) && str.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
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

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? c.a.p0.b0.d.f12807d.equals(str) || str.startsWith(c.a.p0.b0.d.f12808e) : invokeL.booleanValue;
    }

    public c.a.e.l.d.a n(String str, String str2) {
        InterceptResult invokeLL;
        Bitmap o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
            c.a.e.l.d.a m = c.a.p0.b0.c.k().m(str2);
            if (m != null) {
                return m;
            }
            Iterator<c.a.p0.x.p.c> it = this.f21590a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                c.a.p0.x.p.c next = it.next();
                if (next.m(str2)) {
                    m = next.o(str2);
                    break;
                }
            }
            if (m == null && str != null && (o = o(str, f(str2, false))) != null) {
                m = new c.a.e.l.d.a(o, false, str2);
            }
            d(str2, m, false);
            return m;
        }
        return (c.a.e.l.d.a) invokeLL.objValue;
    }

    public Bitmap o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            return FileHelper.getImage(".emotions/" + str, str2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public void p(c.a.p0.x.p.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            synchronized (this.f21591b) {
                if (!this.f21591b.contains(aVar)) {
                    this.f21591b.add(aVar);
                    Collections.sort(this.f21591b);
                }
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            new a(this).execute(new Void[0]);
        }
    }
}

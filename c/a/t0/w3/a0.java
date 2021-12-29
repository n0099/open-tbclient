package c.a.t0.w3;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f25486b;

        public a(WriteData writeData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeData;
            this.f25486b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.s0.s.r.a.f();
                c.a.d.f.d.l<String> g2 = c.a.s0.s.r.a.g("tb.pb_editor");
                WriteData writeData = this.a;
                if (writeData != null && writeData.hasContentToSave()) {
                    g2.e(a0.f(this.f25486b), this.a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(a0.f(this.f25486b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f25487b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25488c;

        public b(WriteData writeData, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeData;
            this.f25487b = z;
            this.f25488c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            WriteData writeData;
            WriteData writeData2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.s0.s.r.a.f();
                c.a.d.f.d.l<String> g2 = c.a.s0.s.r.a.g("tb.pb_editor");
                WriteData writeData3 = this.a;
                if (writeData3 != null && writeData3.hasContentToSave() && !this.f25487b) {
                    String draftString = this.a.toDraftString();
                    g2.e(a0.c(this.f25488c), draftString, 604800000L);
                    if ("0".equals(this.f25488c) || (writeData2 = this.a) == null || writeData2.getStatisticFrom() != 1) {
                        return null;
                    }
                    g2.e(a0.c("0"), draftString, 604800000L);
                    return null;
                }
                g2.remove(a0.c(this.f25488c));
                if ("0".equals(this.f25488c) || (writeData = this.a) == null || writeData.getStatisticFrom() != 1) {
                    return null;
                }
                g2.remove(a0.c("0"));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f25489b;

        public c(WriteData writeData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = writeData;
            this.f25489b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.s0.s.r.a.f();
                c.a.d.f.d.l<String> g2 = c.a.s0.s.r.a.g("tb.pb_editor");
                WriteData writeData = this.a;
                if (writeData != null && writeData.hasContentToSave()) {
                    g2.e(a0.g(this.f25489b), this.a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(a0.g(this.f25489b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.s0.s.r.a.f();
                c.a.d.f.d.l<String> g2 = c.a.s0.s.r.a.g("tb.pb_editor");
                if (!TextUtils.isEmpty(this.a)) {
                    g2.e(a0.e(), this.a, 604800000L);
                    return null;
                }
                g2.remove(a0.e());
                FileHelper.deleteFileOrDir(new File(c.a.t0.k4.c.f19294e));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void onDraftLoaded(WriteData writeData);
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(String str);
    }

    /* loaded from: classes8.dex */
    public static class g extends BdAsyncTask<String, String, WriteData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;

        /* renamed from: b  reason: collision with root package name */
        public final String f25490b;

        public g(String str, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setPriority(3);
            this.a = eVar;
            this.f25490b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public WriteData doInBackground(String... strArr) {
            String str;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                try {
                    c.a.s0.s.r.a.f();
                    str = c.a.s0.s.r.a.g("tb.pb_editor").get(this.f25490b);
                } catch (Exception unused) {
                    str = null;
                }
                return WriteData.fromDraftString(str);
            }
            return (WriteData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) {
                super.onPostExecute(writeData);
                e eVar = this.a;
                if (eVar != null) {
                    eVar.onDraftLoaded(writeData);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class h extends BdAsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final f a;

        /* renamed from: b  reason: collision with root package name */
        public final String f25491b;

        public h(String str, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setPriority(3);
            this.a = fVar;
            this.f25491b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                try {
                    c.a.s0.s.r.a.f();
                    return c.a.s0.s.r.a.g("tb.pb_editor").get(this.f25491b);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((h) str);
                if (this.a == null || TextUtils.isEmpty(str)) {
                    return;
                }
                this.a.a(str);
            }
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@evaluate" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@frs" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@localchannel";
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@newvideo";
        }
        return (String) invokeV.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
        }
        return (String) invokeL.objValue;
    }

    public static void i(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, eVar) == null) {
            if (str != null) {
                new g(b(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void j(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, eVar) == null) {
            if (!c.a.d.f.p.m.isEmpty(str)) {
                new g(c(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void k(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, eVar) == null) {
            new g(d(), eVar).execute(new String[0]);
        }
    }

    public static void l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, fVar) == null) {
            new h(e(), fVar).execute(new String[0]);
        }
    }

    public static void m(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, eVar) == null) {
            if (!c.a.d.f.p.m.isEmpty(str)) {
                new g(f(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void n(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, eVar) == null) {
            if (!c.a.d.f.p.m.isEmpty(str)) {
                new g(g(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void o(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, eVar) == null) {
            if (!c.a.d.f.p.m.isEmpty(str)) {
                new g(h(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void p(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, eVar) == null) {
            if (!c.a.d.f.p.m.isEmpty(str)) {
                new g(a(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void q(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, str, writeData) == null) || str == null) {
            return;
        }
        c.a.s0.s.r.a.f();
        c.a.d.f.d.l<String> g2 = c.a.s0.s.r.a.g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.e(b(str), writeData.toDraftString(), 604800000L);
            g2.e(b(""), writeData.toDraftString(), 604800000L);
            return;
        }
        g2.remove(b(str));
        g2.remove(b(""));
    }

    public static void r(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, writeData) == null) {
            s(str, writeData, false);
        }
    }

    public static void s(String str, WriteData writeData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65554, null, str, writeData, z) == null) || c.a.d.f.p.m.isEmpty(str)) {
            return;
        }
        new b(writeData, z, str).execute(new Void[0]);
    }

    public static void t(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, writeData) == null) {
            c.a.s0.s.r.a.f();
            c.a.d.f.d.l<String> g2 = c.a.s0.s.r.a.g("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                g2.e(d(), writeData.toDraftString(), 604800000L);
            } else {
                g2.remove(d());
            }
        }
    }

    public static void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            new d(str).execute(new Void[0]);
        }
    }

    public static void v(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65557, null, str, writeData) == null) || c.a.d.f.p.m.isEmpty(str)) {
            return;
        }
        new a(writeData, str).execute(new Void[0]);
    }

    public static void w(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65558, null, str, writeData) == null) || c.a.d.f.p.m.isEmpty(str)) {
            return;
        }
        new c(writeData, str).execute(new Void[0]);
    }

    public static void x(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65559, null, str, writeData) == null) || c.a.d.f.p.m.isEmpty(str)) {
            return;
        }
        c.a.s0.s.r.a.f();
        c.a.d.f.d.l<String> g2 = c.a.s0.s.r.a.g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.i(h(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(h(str));
        }
    }

    public static void y(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65560, null, str, writeData) == null) || c.a.d.f.p.m.isEmpty(str)) {
            return;
        }
        c.a.s0.s.r.a.f();
        c.a.d.f.d.l<String> g2 = c.a.s0.s.r.a.g("tb.pb_editor");
        if (writeData != null) {
            g2.i(a(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(a(str));
        }
    }

    public static String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            String e2 = e();
            c.a.s0.s.r.a.f();
            return c.a.s0.s.r.a.g("tb.pb_editor").get(e2);
        }
        return (String) invokeV.objValue;
    }
}

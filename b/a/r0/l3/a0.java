package b.a.r0.l3;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f20515a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20516b;

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
            this.f20515a = writeData;
            this.f20516b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                b.a.q0.s.r.a.f();
                b.a.e.e.d.l<String> g2 = b.a.q0.s.r.a.g("tb.pb_editor");
                WriteData writeData = this.f20515a;
                if (writeData != null && writeData.hasContentToSave()) {
                    g2.e(a0.e(this.f20516b), this.f20515a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(a0.e(this.f20516b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f20517a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f20518b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f20519c;

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
            this.f20517a = writeData;
            this.f20518b = z;
            this.f20519c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            WriteData writeData;
            WriteData writeData2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                b.a.q0.s.r.a.f();
                b.a.e.e.d.l<String> g2 = b.a.q0.s.r.a.g("tb.pb_editor");
                WriteData writeData3 = this.f20517a;
                if (writeData3 != null && writeData3.hasContentToSave() && !this.f20518b) {
                    String draftString = this.f20517a.toDraftString();
                    g2.e(a0.c(this.f20519c), draftString, 604800000L);
                    if ("0".equals(this.f20519c) || (writeData2 = this.f20517a) == null || writeData2.getStatisticFrom() != 1) {
                        return null;
                    }
                    g2.e(a0.c("0"), draftString, 604800000L);
                    return null;
                }
                g2.remove(a0.c(this.f20519c));
                if ("0".equals(this.f20519c) || (writeData = this.f20517a) == null || writeData.getStatisticFrom() != 1) {
                    return null;
                }
                g2.remove(a0.c("0"));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f20520a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20521b;

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
            this.f20520a = writeData;
            this.f20521b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                b.a.q0.s.r.a.f();
                b.a.e.e.d.l<String> g2 = b.a.q0.s.r.a.g("tb.pb_editor");
                WriteData writeData = this.f20520a;
                if (writeData != null && writeData.hasContentToSave()) {
                    g2.e(a0.f(this.f20521b), this.f20520a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(a0.f(this.f20521b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f20522a;

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
            this.f20522a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                b.a.q0.s.r.a.f();
                b.a.e.e.d.l<String> g2 = b.a.q0.s.r.a.g("tb.pb_editor");
                if (!TextUtils.isEmpty(this.f20522a)) {
                    g2.e(a0.d(), this.f20522a, 604800000L);
                    return null;
                }
                g2.remove(a0.d());
                FileHelper.deleteFileOrDir(new File(b.a.r0.z3.c.f28285e));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void onDraftLoaded(WriteData writeData);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(String str);
    }

    /* loaded from: classes5.dex */
    public static class g extends BdAsyncTask<String, String, WriteData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e f20523a;

        /* renamed from: b  reason: collision with root package name */
        public final String f20524b;

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
            this.f20523a = eVar;
            this.f20524b = str;
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
                    b.a.q0.s.r.a.f();
                    str = b.a.q0.s.r.a.g("tb.pb_editor").get(this.f20524b);
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
                e eVar = this.f20523a;
                if (eVar != null) {
                    eVar.onDraftLoaded(writeData);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h extends BdAsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final f f20525a;

        /* renamed from: b  reason: collision with root package name */
        public final String f20526b;

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
            this.f20525a = fVar;
            this.f20526b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                try {
                    b.a.q0.s.r.a.f();
                    return b.a.q0.s.r.a.g("tb.pb_editor").get(this.f20526b);
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
                if (this.f20525a == null || TextUtils.isEmpty(str)) {
                    return;
                }
                this.f20525a.a(str);
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
            return TbadkCoreApplication.getCurrentAccount() + "@newvideo";
        }
        return (String) invokeV.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
        }
        return (String) invokeL.objValue;
    }

    public static void h(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, eVar) == null) {
            if (str != null) {
                new g(b(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void i(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, eVar) == null) {
            if (!b.a.e.e.p.k.isEmpty(str)) {
                new g(c(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, fVar) == null) {
            new h(d(), fVar).execute(new String[0]);
        }
    }

    public static void k(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, eVar) == null) {
            if (!b.a.e.e.p.k.isEmpty(str)) {
                new g(e(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void l(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, eVar) == null) {
            if (!b.a.e.e.p.k.isEmpty(str)) {
                new g(f(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void m(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, eVar) == null) {
            if (!b.a.e.e.p.k.isEmpty(str)) {
                new g(g(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void n(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, eVar) == null) {
            if (!b.a.e.e.p.k.isEmpty(str)) {
                new g(a(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void o(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, str, writeData) == null) || str == null) {
            return;
        }
        b.a.q0.s.r.a.f();
        b.a.e.e.d.l<String> g2 = b.a.q0.s.r.a.g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.e(b(str), writeData.toDraftString(), 604800000L);
            g2.e(b(""), writeData.toDraftString(), 604800000L);
            return;
        }
        g2.remove(b(str));
        g2.remove(b(""));
    }

    public static void p(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, writeData) == null) {
            q(str, writeData, false);
        }
    }

    public static void q(String str, WriteData writeData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65552, null, str, writeData, z) == null) || b.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        new b(writeData, z, str).execute(new Void[0]);
    }

    public static void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            new d(str).execute(new Void[0]);
        }
    }

    public static void s(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, str, writeData) == null) || b.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        new a(writeData, str).execute(new Void[0]);
    }

    public static void t(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, null, str, writeData) == null) || b.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        new c(writeData, str).execute(new Void[0]);
    }

    public static void u(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, null, str, writeData) == null) || b.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        b.a.q0.s.r.a.f();
        b.a.e.e.d.l<String> g2 = b.a.q0.s.r.a.g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.i(g(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(g(str));
        }
    }

    public static void v(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65557, null, str, writeData) == null) || b.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        b.a.q0.s.r.a.f();
        b.a.e.e.d.l<String> g2 = b.a.q0.s.r.a.g("tb.pb_editor");
        if (writeData != null) {
            g2.i(a(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(a(str));
        }
    }

    public static String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            String d2 = d();
            b.a.q0.s.r.a.f();
            return b.a.q0.s.r.a.g("tb.pb_editor").get(d2);
        }
        return (String) invokeV.objValue;
    }
}

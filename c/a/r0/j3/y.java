package c.a.r0.j3;

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
/* loaded from: classes3.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f21140a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21141b;

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
            this.f21140a = writeData;
            this.f21141b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.q0.s.r.a.f();
                c.a.e.e.d.l<String> g2 = c.a.q0.s.r.a.g("tb.pb_editor");
                WriteData writeData = this.f21140a;
                if (writeData != null && writeData.hasContentToSave()) {
                    g2.e(y.e(this.f21141b), this.f21140a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(y.e(this.f21141b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f21142a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f21143b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f21144c;

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
            this.f21142a = writeData;
            this.f21143b = z;
            this.f21144c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            WriteData writeData;
            WriteData writeData2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.q0.s.r.a.f();
                c.a.e.e.d.l<String> g2 = c.a.q0.s.r.a.g("tb.pb_editor");
                WriteData writeData3 = this.f21142a;
                if (writeData3 != null && writeData3.hasContentToSave() && !this.f21143b) {
                    String draftString = this.f21142a.toDraftString();
                    g2.e(y.c(this.f21144c), draftString, 604800000L);
                    if ("0".equals(this.f21144c) || (writeData2 = this.f21142a) == null || writeData2.getStatisticFrom() != 1) {
                        return null;
                    }
                    g2.e(y.c("0"), draftString, 604800000L);
                    return null;
                }
                g2.remove(y.c(this.f21144c));
                if ("0".equals(this.f21144c) || (writeData = this.f21142a) == null || writeData.getStatisticFrom() != 1) {
                    return null;
                }
                g2.remove(y.c("0"));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WriteData f21145a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f21146b;

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
            this.f21145a = writeData;
            this.f21146b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.q0.s.r.a.f();
                c.a.e.e.d.l<String> g2 = c.a.q0.s.r.a.g("tb.pb_editor");
                WriteData writeData = this.f21145a;
                if (writeData != null && writeData.hasContentToSave()) {
                    g2.e(y.f(this.f21146b), this.f21145a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(y.f(this.f21146b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f21147a;

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
            this.f21147a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.q0.s.r.a.f();
                c.a.e.e.d.l<String> g2 = c.a.q0.s.r.a.g("tb.pb_editor");
                if (!TextUtils.isEmpty(this.f21147a)) {
                    g2.e(y.d(), this.f21147a, 604800000L);
                    return null;
                }
                g2.remove(y.d());
                FileHelper.deleteFileOrDir(new File(c.a.r0.x3.c.f28884e));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void onDraftLoaded(WriteData writeData);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(String str);
    }

    /* loaded from: classes3.dex */
    public static class g extends BdAsyncTask<String, String, WriteData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final e f21148a;

        /* renamed from: b  reason: collision with root package name */
        public final String f21149b;

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
            this.f21148a = eVar;
            this.f21149b = str;
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
                    c.a.q0.s.r.a.f();
                    str = c.a.q0.s.r.a.g("tb.pb_editor").get(this.f21149b);
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
                e eVar = this.f21148a;
                if (eVar != null) {
                    eVar.onDraftLoaded(writeData);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends BdAsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final f f21150a;

        /* renamed from: b  reason: collision with root package name */
        public final String f21151b;

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
            this.f21150a = fVar;
            this.f21151b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                try {
                    c.a.q0.s.r.a.f();
                    return c.a.q0.s.r.a.g("tb.pb_editor").get(this.f21151b);
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
                if (this.f21150a == null || TextUtils.isEmpty(str)) {
                    return;
                }
                this.f21150a.a(str);
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
            if (!c.a.e.e.p.k.isEmpty(str)) {
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
            if (!c.a.e.e.p.k.isEmpty(str)) {
                new g(e(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void l(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, eVar) == null) {
            if (!c.a.e.e.p.k.isEmpty(str)) {
                new g(f(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void m(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, eVar) == null) {
            if (!c.a.e.e.p.k.isEmpty(str)) {
                new g(g(str), eVar).execute(new String[0]);
            } else if (eVar != null) {
                eVar.onDraftLoaded(null);
            }
        }
    }

    public static void n(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, eVar) == null) {
            if (!c.a.e.e.p.k.isEmpty(str)) {
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
        c.a.q0.s.r.a.f();
        c.a.e.e.d.l<String> g2 = c.a.q0.s.r.a.g("tb.pb_editor");
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
        if (!(interceptable == null || interceptable.invokeLLZ(65552, null, str, writeData, z) == null) || c.a.e.e.p.k.isEmpty(str)) {
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
        if (!(interceptable == null || interceptable.invokeLL(65554, null, str, writeData) == null) || c.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        new a(writeData, str).execute(new Void[0]);
    }

    public static void t(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, null, str, writeData) == null) || c.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        new c(writeData, str).execute(new Void[0]);
    }

    public static void u(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, null, str, writeData) == null) || c.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        c.a.q0.s.r.a.f();
        c.a.e.e.d.l<String> g2 = c.a.q0.s.r.a.g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.i(g(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(g(str));
        }
    }

    public static void v(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65557, null, str, writeData) == null) || c.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        c.a.q0.s.r.a.f();
        c.a.e.e.d.l<String> g2 = c.a.q0.s.r.a.g("tb.pb_editor");
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
            c.a.q0.s.r.a.f();
            return c.a.q0.s.r.a.g("tb.pb_editor").get(d2);
        }
        return (String) invokeV.objValue;
    }
}

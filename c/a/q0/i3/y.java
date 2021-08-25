package c.a.q0.i3;

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
        public final /* synthetic */ WriteData f20572a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20573b;

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
            this.f20572a = writeData;
            this.f20573b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.p0.s.r.a.f();
                c.a.e.e.d.l<String> g2 = c.a.p0.s.r.a.g("tb.pb_editor");
                WriteData writeData = this.f20572a;
                if (writeData != null && writeData.hasContentToSave()) {
                    g2.e(y.e(this.f20573b), this.f20572a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(y.e(this.f20573b));
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
        public final /* synthetic */ WriteData f20574a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f20575b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f20576c;

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
            this.f20574a = writeData;
            this.f20575b = z;
            this.f20576c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            WriteData writeData;
            WriteData writeData2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.p0.s.r.a.f();
                c.a.e.e.d.l<String> g2 = c.a.p0.s.r.a.g("tb.pb_editor");
                WriteData writeData3 = this.f20574a;
                if (writeData3 != null && writeData3.hasContentToSave() && !this.f20575b) {
                    String draftString = this.f20574a.toDraftString();
                    g2.e(y.c(this.f20576c), draftString, 604800000L);
                    if ("0".equals(this.f20576c) || (writeData2 = this.f20574a) == null || writeData2.getStatisticFrom() != 1) {
                        return null;
                    }
                    g2.e(y.c("0"), draftString, 604800000L);
                    return null;
                }
                g2.remove(y.c(this.f20576c));
                if ("0".equals(this.f20576c) || (writeData = this.f20574a) == null || writeData.getStatisticFrom() != 1) {
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
        public final /* synthetic */ WriteData f20577a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20578b;

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
            this.f20577a = writeData;
            this.f20578b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.p0.s.r.a.f();
                c.a.e.e.d.l<String> g2 = c.a.p0.s.r.a.g("tb.pb_editor");
                WriteData writeData = this.f20577a;
                if (writeData != null && writeData.hasContentToSave()) {
                    g2.e(y.f(this.f20578b), this.f20577a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(y.f(this.f20578b));
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
        public final /* synthetic */ String f20579a;

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
            this.f20579a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                c.a.p0.s.r.a.f();
                c.a.e.e.d.l<String> g2 = c.a.p0.s.r.a.g("tb.pb_editor");
                if (!TextUtils.isEmpty(this.f20579a)) {
                    g2.e(y.d(), this.f20579a, 604800000L);
                    return null;
                }
                g2.remove(y.d());
                FileHelper.deleteFileOrDir(new File(c.a.q0.w3.c.f28197e));
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
        public final e f20580a;

        /* renamed from: b  reason: collision with root package name */
        public final String f20581b;

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
            this.f20580a = eVar;
            this.f20581b = str;
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
                    c.a.p0.s.r.a.f();
                    str = c.a.p0.s.r.a.g("tb.pb_editor").get(this.f20581b);
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
                e eVar = this.f20580a;
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
        public final f f20582a;

        /* renamed from: b  reason: collision with root package name */
        public final String f20583b;

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
            this.f20582a = fVar;
            this.f20583b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                try {
                    c.a.p0.s.r.a.f();
                    return c.a.p0.s.r.a.g("tb.pb_editor").get(this.f20583b);
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
                if (this.f20582a == null || TextUtils.isEmpty(str)) {
                    return;
                }
                this.f20582a.a(str);
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
        c.a.p0.s.r.a.f();
        c.a.e.e.d.l<String> g2 = c.a.p0.s.r.a.g("tb.pb_editor");
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
        c.a.p0.s.r.a.f();
        c.a.e.e.d.l<String> g2 = c.a.p0.s.r.a.g("tb.pb_editor");
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
        c.a.p0.s.r.a.f();
        c.a.e.e.d.l<String> g2 = c.a.p0.s.r.a.g("tb.pb_editor");
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
            c.a.p0.s.r.a.f();
            return c.a.p0.s.r.a.g("tb.pb_editor").get(d2);
        }
        return (String) invokeV.objValue;
    }
}

package c.a.t0.x3;

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
        public final /* synthetic */ String f25030b;

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
            this.f25030b = str;
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
                    g2.e(a0.g(this.f25030b), this.a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(a0.g(this.f25030b));
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
        public final /* synthetic */ boolean f25031b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f25032c;

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
            this.f25031b = z;
            this.f25032c = str;
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
                if (writeData3 != null && writeData3.hasContentToSave() && !this.f25031b) {
                    String draftString = this.a.toDraftString();
                    g2.e(a0.c(this.f25032c), draftString, 604800000L);
                    if ("0".equals(this.f25032c) || (writeData2 = this.a) == null || writeData2.getStatisticFrom() != 1) {
                        return null;
                    }
                    g2.e(a0.c("0"), draftString, 604800000L);
                    return null;
                }
                g2.remove(a0.c(this.f25032c));
                if ("0".equals(this.f25032c) || (writeData = this.a) == null || writeData.getStatisticFrom() != 1) {
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
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f25033b;

        public c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
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
            this.f25033b = str2;
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
                    g2.e(a0.e(this.f25033b), this.a, 604800000L);
                    return null;
                }
                g2.remove(a0.e(this.f25033b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class d extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f25034b;

        public d(WriteData writeData, String str) {
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
            this.f25034b = str;
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
                    g2.e(a0.h(this.f25034b), this.a.toDraftString(), 604800000L);
                    return null;
                }
                g2.remove(a0.h(this.f25034b));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class e extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public e(String str) {
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
                    g2.e(a0.f(), this.a, 604800000L);
                    return null;
                }
                g2.remove(a0.f());
                FileHelper.deleteFileOrDir(new File(c.a.t0.k4.c.f19031e));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void onDraftLoaded(WriteData writeData);
    }

    /* loaded from: classes8.dex */
    public interface g {
        void a(String str);
    }

    /* loaded from: classes8.dex */
    public static class h extends BdAsyncTask<String, String, WriteData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final f a;

        /* renamed from: b  reason: collision with root package name */
        public final String f25035b;

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
            this.f25035b = str;
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
                    str = c.a.s0.s.r.a.g("tb.pb_editor").get(this.f25035b);
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
                f fVar = this.a;
                if (fVar != null) {
                    fVar.onDraftLoaded(writeData);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class i extends BdAsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final g a;

        /* renamed from: b  reason: collision with root package name */
        public final String f25036b;

        public i(String str, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, gVar};
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
            this.a = gVar;
            this.f25036b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                try {
                    c.a.s0.s.r.a.f();
                    return c.a.s0.s.r.a.g("tb.pb_editor").get(this.f25036b);
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
                super.onPostExecute((i) str);
                if (this.a == null || TextUtils.isEmpty(str)) {
                    return;
                }
                this.a.a(str);
            }
        }
    }

    public static void A(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, writeData) == null) || c.a.d.f.p.m.isEmpty(str)) {
            return;
        }
        c.a.s0.s.r.a.f();
        c.a.d.f.d.l<String> g2 = c.a.s0.s.r.a.g("tb.pb_editor");
        if (writeData != null && writeData.hasContentToSave()) {
            g2.i(i(str), writeData.toDraftString(), 604800000L);
        } else {
            g2.d(i(str));
        }
    }

    public static void B(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, str, writeData) == null) || c.a.d.f.p.m.isEmpty(str)) {
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

    public static String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String f2 = f();
            c.a.s0.s.r.a.f();
            return c.a.s0.s.r.a.g("tb.pb_editor").get(f2);
        }
        return (String) invokeV.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@evapost" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@evaluate" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@frs" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@localchannel";
        }
        return (String) invokeV.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@localchannelhi" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@newvideo";
        }
        return (String) invokeV.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@pb" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@subpb" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            return TbadkCoreApplication.getCurrentAccount() + "@topic" + str;
        }
        return (String) invokeL.objValue;
    }

    public static void j(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, fVar) == null) {
            if (str != null) {
                new h(b(str), fVar).execute(new String[0]);
            } else if (fVar != null) {
                fVar.onDraftLoaded(null);
            }
        }
    }

    public static void k(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, fVar) == null) {
            if (!c.a.d.f.p.m.isEmpty(str)) {
                new h(c(str), fVar).execute(new String[0]);
            } else if (fVar != null) {
                fVar.onDraftLoaded(null);
            }
        }
    }

    public static void l(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, fVar) == null) {
            new h(d(), fVar).execute(new String[0]);
        }
    }

    public static void m(String str, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, gVar) == null) {
            if (!c.a.d.f.p.m.isEmpty(str)) {
                new i(e(str), gVar).execute(new String[0]);
            } else if (gVar != null) {
                gVar.a(null);
            }
        }
    }

    public static void n(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, gVar) == null) {
            new i(f(), gVar).execute(new String[0]);
        }
    }

    public static void o(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, fVar) == null) {
            if (!c.a.d.f.p.m.isEmpty(str)) {
                new h(g(str), fVar).execute(new String[0]);
            } else if (fVar != null) {
                fVar.onDraftLoaded(null);
            }
        }
    }

    public static void p(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, fVar) == null) {
            if (!c.a.d.f.p.m.isEmpty(str)) {
                new h(h(str), fVar).execute(new String[0]);
            } else if (fVar != null) {
                fVar.onDraftLoaded(null);
            }
        }
    }

    public static void q(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, str, fVar) == null) {
            if (!c.a.d.f.p.m.isEmpty(str)) {
                new h(i(str), fVar).execute(new String[0]);
            } else if (fVar != null) {
                fVar.onDraftLoaded(null);
            }
        }
    }

    public static void r(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, fVar) == null) {
            if (!c.a.d.f.p.m.isEmpty(str)) {
                new h(a(str), fVar).execute(new String[0]);
            } else if (fVar != null) {
                fVar.onDraftLoaded(null);
            }
        }
    }

    public static void s(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65557, null, str, writeData) == null) || str == null) {
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

    public static void t(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, str, writeData) == null) {
            u(str, writeData, false);
        }
    }

    public static void u(String str, WriteData writeData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65559, null, str, writeData, z) == null) || c.a.d.f.p.m.isEmpty(str)) {
            return;
        }
        new b(writeData, z, str).execute(new Void[0]);
    }

    public static void v(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, writeData) == null) {
            c.a.s0.s.r.a.f();
            c.a.d.f.d.l<String> g2 = c.a.s0.s.r.a.g("tb.pb_editor");
            if (writeData != null && writeData.hasContentToSave()) {
                g2.e(d(), writeData.toDraftString(), 604800000L);
            } else {
                g2.remove(d());
            }
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65561, null, str, str2) == null) || c.a.d.f.p.m.isEmpty(str)) {
            return;
        }
        new c(str2, str).execute(new Void[0]);
    }

    public static void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, str) == null) {
            new e(str).execute(new Void[0]);
        }
    }

    public static void y(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65563, null, str, writeData) == null) || c.a.d.f.p.m.isEmpty(str)) {
            return;
        }
        new a(writeData, str).execute(new Void[0]);
    }

    public static void z(String str, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65564, null, str, writeData) == null) || c.a.d.f.p.m.isEmpty(str)) {
            return;
        }
        new d(writeData, str).execute(new Void[0]);
    }
}

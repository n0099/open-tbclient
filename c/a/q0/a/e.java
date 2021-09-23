package c.a.q0.a;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntime;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.BdToken.DecryptCodeHttpRespMsg;
import com.baidu.tbadk.BdToken.DecryptCodeReqMsg;
import com.baidu.tbadk.BdToken.DecryptCodeSocketRespMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckHttpResMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckReqMsg;
import com.baidu.tbadk.BdToken.TiebaUidCheckSocketResMsg;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f12582h;

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f12583i;

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f12584j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f12585a;

    /* renamed from: b  reason: collision with root package name */
    public long f12586b;

    /* renamed from: c  reason: collision with root package name */
    public u f12587c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.a.f f12588d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f12589e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f12590f;

    /* renamed from: g  reason: collision with root package name */
    public f.b f12591g;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12592a;

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
            this.f12592a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public l doInBackground(String... strArr) {
            InterceptResult invokeL;
            Matcher matcher;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (strArr == null || strArr.length < 1) {
                    return null;
                }
                String str = strArr[0];
                if (!c.a.e.e.p.k.isEmpty(str) && (matcher = e.f12583i.matcher(str)) != null && matcher.find() && matcher.groupCount() >= 2) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    if (TextUtils.isEmpty(group2)) {
                        return null;
                    }
                    UserData b2 = c.a.q0.a0.b.a().b();
                    String tiebaUid = b2 != null ? b2.getTiebaUid() : "";
                    if ((TextUtils.isEmpty(group) || !group.equals(TbadkCoreApplication.getCurrentAccountNameShow())) && !group2.equals(tiebaUid)) {
                        l lVar = new l();
                        lVar.c(group);
                        lVar.d(group2);
                        return lVar;
                    }
                    return null;
                }
                return null;
            }
            return (l) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                super.onPostExecute(lVar);
                if (lVar == null || this.f12592a.f12590f.get()) {
                    return;
                }
                this.f12592a.f12590f.compareAndSet(false, true);
                TiebaUidCheckReqMsg tiebaUidCheckReqMsg = new TiebaUidCheckReqMsg();
                tiebaUidCheckReqMsg.setTiebaUid(lVar);
                MessageManager.getInstance().sendMessage(tiebaUidCheckReqMsg);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12593a;

        public b(e eVar) {
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
            this.f12593a = eVar;
        }

        @Override // c.a.q0.a.f.b
        public void a(boolean z, a0 a0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, a0Var) == null) && z && a0Var != null) {
                this.f12593a.p();
                this.f12593a.q(a0Var.a(), a0Var.c());
                this.f12593a.s(a0Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f12594e;

        public c(e eVar) {
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
            this.f12594e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.y().m(this.f12594e.w());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f12595e;

        public d(e eVar) {
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
            this.f12595e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.y().m(this.f12595e.w());
            }
        }
    }

    /* renamed from: c.a.q0.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0643e extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12596a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0643e(e eVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12596a = eVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage responsedMessage) {
            c.a.q0.a.h decryptData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f12596a.f12589e.compareAndSet(true, false);
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (!(responsedMessage instanceof DecryptCodeSocketRespMsg)) {
                    return;
                } else {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                }
                if (decryptData == null) {
                    return;
                }
                GrowthStatsUtil.statisticClipBoard(decryptData.f());
                UtilHelper.clearClipBoard();
                int g2 = decryptData.g();
                if (g2 == 1 || g2 == 0) {
                    if (MessageManager.getInstance().findTask(2921361) == null || decryptData.f12626g.equals(TbadkCoreApplication.getInst().getCurAiAppid())) {
                        return;
                    }
                    TbadkCoreApplication.getInst().setCurAiAppid(null);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                } else if (g2 == 2) {
                    this.f12596a.q(decryptData.e(), decryptData.f());
                } else if (g2 == 4 || g2 != 3 || StringUtils.isNull(decryptData.f())) {
                } else {
                    Uri parse = Uri.parse(decryptData.f());
                    String queryParameter = parse != null ? parse.getQueryParameter("obj_source") : "";
                    String queryParameter2 = parse != null ? parse.getQueryParameter("obj_type") : "";
                    String queryParameter3 = parse != null ? parse.getQueryParameter("tid") : "";
                    String queryParameter4 = parse != null ? parse.getQueryParameter("fname") : "";
                    String queryParameter5 = parse != null ? parse.getQueryParameter("eqid") : "";
                    if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2) || !queryParameter2.startsWith("tbcm")) {
                        this.f12596a.r(decryptData.f());
                        TiebaStatic.log(new StatisticItem("c13390").param("obj_type", queryParameter2).param("obj_source", queryParameter).param("tid", queryParameter3).param("fname", queryParameter4).param("query", queryParameter5));
                        return;
                    }
                    this.f12596a.r(decryptData.f());
                    TiebaStatic.log(new StatisticItem("c13390").param("obj_type", queryParameter2).param("obj_source", queryParameter).param("tid", queryParameter3).param("fname", queryParameter4));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12597a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(e eVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12597a = eVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tbadk.core.data.UserData userData;
            TiebaUidCheckReqMsg tiebaUidCheckReqMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f12597a.f12590f.compareAndSet(true, false);
                if (responsedMessage instanceof TiebaUidCheckSocketResMsg) {
                    userData = ((TiebaUidCheckSocketResMsg) responsedMessage).getUserData();
                } else if (!(responsedMessage instanceof TiebaUidCheckHttpResMsg)) {
                    return;
                } else {
                    userData = ((TiebaUidCheckHttpResMsg) responsedMessage).getUserData();
                }
                l lVar = (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof TiebaUidCheckReqMsg) || (tiebaUidCheckReqMsg = (TiebaUidCheckReqMsg) responsedMessage.getOrginalMessage().getExtra()) == null) ? null : tiebaUidCheckReqMsg.mTiebaUidData;
                if (userData == null || lVar == null) {
                    return;
                }
                UtilHelper.clearClipBoard();
                y d2 = y.d();
                d2.b();
                d2.e(userData, lVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12598a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12598a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage instanceof BackgroundSwitchMessage) || ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                return;
            }
            this.f12598a.m(this.f12598a.w());
        }
    }

    /* loaded from: classes3.dex */
    public class h extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12599a;

        public h(e eVar) {
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
            this.f12599a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Matcher matcher;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr != null && strArr.length >= 1) {
                    String str = strArr[0];
                    if (c.a.e.e.p.k.isEmpty(str)) {
                        return null;
                    }
                    String z = this.f12599a.z();
                    if (!c.a.e.e.p.k.isEmpty(z) && (matcher = Pattern.compile(z).matcher(str)) != null && matcher.find()) {
                        return str;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((h) str);
                if (str == null) {
                    if (this.f12599a.f12587c == null || !this.f12599a.C()) {
                        return;
                    }
                    this.f12599a.f12587c.b();
                    return;
                }
                this.f12599a.n(str);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12600a;

        public i(e eVar) {
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
            this.f12600a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Matcher matcher;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr != null && strArr.length >= 1) {
                    String str = strArr[0];
                    if (!c.a.e.e.p.k.isEmpty(str) && (matcher = e.f12584j.matcher(str)) != null && matcher.find()) {
                        return str;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((i) str);
                if (str != null) {
                    this.f12600a.r(str.substring(1, str.length() - 1));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f12601a;

        public j(e eVar) {
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
            this.f12601a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Matcher matcher;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                if (strArr != null && strArr.length >= 1) {
                    String str = strArr[0];
                    if (!c.a.e.e.p.k.isEmpty(str) && (matcher = e.f12582h.matcher(str)) != null && matcher.find()) {
                        return str;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((j) str);
                if (str == null || this.f12601a.f12589e.get()) {
                    return;
                }
                this.f12601a.f12589e.compareAndSet(false, true);
                DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
                decryptCodeReqMsg.setCode(str);
                MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final e f12602a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1128360007, "Lc/a/q0/a/e$k;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1128360007, "Lc/a/q0/a/e$k;");
                    return;
                }
            }
            f12602a = new e();
        }
    }

    /* loaded from: classes3.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f12603a;

        /* renamed from: b  reason: collision with root package name */
        public String f12604b;

        public l() {
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

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f12603a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f12604b : (String) invokeV.objValue;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f12603a = str;
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f12604b = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1522846482, "Lc/a/q0/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1522846482, "Lc/a/q0/a/e;");
                return;
            }
        }
        f12582h = Pattern.compile("\\$[0-9A-Za-z@_]{5,200}[#$]", 2);
        f12583i = Pattern.compile("^@(.*)@给你分享了贴吧号#(\\d+)#\\s?整段复制后打开贴吧即可找到Ta$", 2);
        f12584j = Pattern.compile("\\$(com.baidu.tieba://unidispatch/)[0-9a-zA-Z]{1,10}\\?[0-9a-zA-Z_=&%\\-.]{1,300}[$]", 2);
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
        this.f12589e = new AtomicBoolean(false);
        this.f12590f = new AtomicBoolean(false);
        this.f12591g = new b(this);
    }

    public static final e y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? k.f12602a : (e) invokeV.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (c.a.e.e.p.k.isEmpty(clipBoardContent)) {
                return false;
            }
            return D(z(), clipBoardContent) || clipBoardContent.contains("^sZqulxTVsT$") || E(f12582h, clipBoardContent) || E(f12584j, clipBoardContent) || E(f12583i, clipBoardContent);
        }
        return invokeV.booleanValue;
    }

    public void B(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || this.f12585a) {
            return;
        }
        F();
        H();
        G();
        c.a.q0.a.f fVar = new c.a.q0.a.f();
        this.f12588d = fVar;
        fVar.g(this.f12591g);
        this.f12587c = new u();
        String w = w();
        if (!c.a.e.e.p.k.isEmpty(w)) {
            y().m(w);
        } else if (UtilHelper.isActivityStartFromScheme(activity)) {
            c.a.e.e.m.e.a().postDelayed(new c(this), PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
        } else if (RomTypeUtil.isEmui() || RomTypeUtil.isOnePlus() || RomTypeUtil.check("MIUI")) {
            c.a.e.e.m.e.a().postDelayed(new d(this), 2000L);
        }
        this.f12585a = true;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String topActivityClassName = UtilHelper.getTopActivityClassName();
            return !c.a.e.e.p.k.isEmpty(topActivityClassName) && topActivityClassName.equals(SpeedRuntime.MAIN_ACTIVITY_NAME) && TbSingleton.getInstance().isRecommendPage();
        }
        return invokeV.booleanValue;
    }

    public boolean D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            return E(Pattern.compile(str), str2);
        }
        return invokeLL.booleanValue;
    }

    public boolean E(Pattern pattern, String str) {
        InterceptResult invokeLL;
        Matcher matcher;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, pattern, str)) == null) ? (pattern == null || TextUtils.isEmpty(str) || (matcher = pattern.matcher(str)) == null || !matcher.find()) ? false : true : invokeLL.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.r0.j3.e0.a.h(309626, DecryptCodeSocketRespMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, c.a.r0.j3.e0.a.a(TbConfig.DECRYPT_CODE_URL, 309626));
            tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().registerListener(new C0643e(this, CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626));
            MessageManager.getInstance().registerListener(new f(this, CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, 309702));
            MessageManager.getInstance().registerListener(new g(this, 2001011));
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.r0.j3.e0.a.h(309702, TiebaUidCheckSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, c.a.r0.j3.e0.a.a(TbConfig.URL_GET_USER_BY_TIEBA_UID, 309702));
            tbHttpMessageTask.setResponsedClass(TiebaUidCheckHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || c.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        new h(this).execute(str);
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            l(str);
            o(str);
            t(str);
            u(str);
            v(str);
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f12588d.c(str);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && !c.a.e.e.p.k.isEmpty(str) && str.contains("^sZqulxTVsT$")) {
            n(str);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            UtilHelper.clearClipBoard();
        }
    }

    public final void q(String str, String str2) {
        TbPageContext<?> x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || c.a.e.e.p.k.isEmpty(str2) || (x = x(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(x, str, new String[]{str2});
    }

    public final void r(String str) {
        Activity currentActivity;
        Uri parse;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || c.a.e.e.p.k.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (parse = Uri.parse(str)) == null) {
            return;
        }
        if (str.startsWith(c.a.q0.a.g.f12609a)) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter(c.a.q0.a.g.x, c.a.q0.a.g.W);
            parse = buildUpon.build();
        }
        UtilHelper.dealOneScheme(currentActivity, parse.toString());
    }

    public final void s(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, a0Var) == null) || a0Var == null || a0Var.b() == null || c.a.e.e.p.k.isEmpty(a0Var.b().f12505a) || !C()) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, a0Var.b().f12505a));
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || c.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        new j(this).execute(str);
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || c.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        new i(this).execute(str);
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || c.a.e.e.p.k.isEmpty(str)) {
            return;
        }
        new a(this).execute(str);
    }

    public final String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (System.currentTimeMillis() - this.f12586b < 2000) {
                return null;
            }
            this.f12586b = System.currentTimeMillis();
            return UtilHelper.getClipBoardContent();
        }
        return (String) invokeV.objValue;
    }

    public final TbPageContext x(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    public final String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? new String(Base64.decode(c.a.q0.s.d0.b.j().p("key_baidu_password_re", "LipcXlsjJGEtekEtWjAtOV9dezUsfVxeezAsMX1bXF4kXXsxfS4q"), 0)) : (String) invokeV.objValue;
    }
}

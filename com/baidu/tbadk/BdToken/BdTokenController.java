package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.GrowthStatsUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.UserData;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.bha;
import com.baidu.tieba.by5;
import com.baidu.tieba.cx5;
import com.baidu.tieba.ei;
import com.baidu.tieba.fu4;
import com.baidu.tieba.gu4;
import com.baidu.tieba.m55;
import com.baidu.tieba.o55;
import com.baidu.tieba.ot4;
import com.baidu.tieba.qu4;
import com.baidu.tieba.rt4;
import com.baidu.tieba.ru4;
import com.baidu.tieba.sl5;
import com.baidu.tieba.tu4;
import com.baidu.tieba.xx5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BdTokenController {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern k;
    public static final Pattern l;
    public static final Pattern m;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public long b;
    public ot4 c;
    public AtomicBoolean d;
    public AtomicBoolean e;
    public ru4 f;
    @Nullable
    public SyncToken g;
    @Nullable
    public String h;
    public int i;
    public ot4.b j;

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTokenController a;

        /* loaded from: classes4.dex */
        public class a extends xx5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.xx5
            public String doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.a.a.C();
                }
                return (String) invokeV.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements cx5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.cx5
            /* renamed from: a */
            public void onReturnDataInUI(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null) {
                    this.a.a.q(str);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(BdTokenController bdTokenController, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTokenController, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTokenController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                if (TbadkCoreApplication.getInst().isMIUIRom()) {
                    by5.b(new a(this), new b(this));
                    return;
                }
                this.a.q(this.a.C());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class SyncToken implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String token;
        public int type;
        public String url;

        public SyncToken() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<String, Integer, l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTokenController a;

        public a(BdTokenController bdTokenController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTokenController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTokenController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public l doInBackground(String... strArr) {
            InterceptResult invokeL;
            Matcher matcher;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (strArr == null || strArr.length < 1) {
                    return null;
                }
                String str2 = strArr[0];
                if (ei.isEmpty(str2) || (matcher = BdTokenController.l.matcher(str2)) == null || !matcher.find() || matcher.groupCount() < 2) {
                    return null;
                }
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                if (TextUtils.isEmpty(group2)) {
                    return null;
                }
                UserData e = sl5.d().e();
                if (e != null) {
                    str = e.getTiebaUid();
                } else {
                    str = "";
                }
                if ((!TextUtils.isEmpty(group) && group.equals(TbadkCoreApplication.getCurrentAccountNameShow())) || group2.equals(str)) {
                    return null;
                }
                l lVar = new l();
                lVar.c(group);
                lVar.d(group2);
                return lVar;
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
                if (lVar == null || this.a.e.get()) {
                    this.a.v();
                    return;
                }
                this.a.e.compareAndSet(false, true);
                TiebaUidCheckReqMsg tiebaUidCheckReqMsg = new TiebaUidCheckReqMsg();
                tiebaUidCheckReqMsg.setTiebaUid(lVar);
                MessageManager.getInstance().sendMessage(tiebaUidCheckReqMsg);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ot4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTokenController a;

        public b(BdTokenController bdTokenController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTokenController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTokenController;
        }

        @Override // com.baidu.tieba.ot4.b
        public void a(boolean z, gu4 gu4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZL(1048576, this, z, gu4Var) != null) || !z || gu4Var == null || gu4Var.d()) {
                return;
            }
            this.a.t();
            this.a.w(gu4Var.a(), gu4Var.c());
            this.a.y(gu4Var);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends xx5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(BdTokenController bdTokenController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTokenController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return UtilHelper.getClipBoardContent();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements cx5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ BdTokenController b;

        public d(BdTokenController bdTokenController, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTokenController, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bdTokenController;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cx5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.b.N(str, this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTokenController a;

        public e(BdTokenController bdTokenController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTokenController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTokenController;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.R(0L);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTokenController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(BdTokenController bdTokenController, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTokenController, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTokenController;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage responsedMessage) {
            rt4 decryptData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.d.compareAndSet(true, false);
                if (responsedMessage instanceof DecryptCodeHttpRespMsg) {
                    decryptData = ((DecryptCodeHttpRespMsg) responsedMessage).getDecryptData();
                } else if (responsedMessage instanceof DecryptCodeSocketRespMsg) {
                    decryptData = ((DecryptCodeSocketRespMsg) responsedMessage).getDecryptData();
                } else {
                    return;
                }
                if (decryptData == null) {
                    return;
                }
                tu4.c(responsedMessage.getError(), decryptData.g());
                GrowthStatsUtil.statisticClipBoard(decryptData.f());
                this.a.t();
                int g = decryptData.g();
                if (g != 1 && g != 0) {
                    if (g == 2) {
                        tu4.e();
                        this.a.w(decryptData.e(), decryptData.f());
                    } else if (g == 4 || g != 3 || StringUtils.isNull(decryptData.f())) {
                    } else {
                        tu4.e();
                        this.a.x(decryptData.f());
                        this.a.J(decryptData.f());
                    }
                } else if (MessageManager.getInstance().findTask(2921361) != null && !decryptData.g.equals(TbadkCoreApplication.getInst().getCurAiAppid())) {
                    tu4.e();
                    TbadkCoreApplication.getInst().setCurAiAppid(null);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921377, decryptData));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTokenController a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(BdTokenController bdTokenController, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTokenController, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTokenController;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tbadk.core.data.UserData userData;
            l lVar;
            TiebaUidCheckReqMsg tiebaUidCheckReqMsg;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.e.compareAndSet(true, false);
                if (responsedMessage instanceof TiebaUidCheckSocketResMsg) {
                    userData = ((TiebaUidCheckSocketResMsg) responsedMessage).getUserData();
                } else if (responsedMessage instanceof TiebaUidCheckHttpResMsg) {
                    userData = ((TiebaUidCheckHttpResMsg) responsedMessage).getUserData();
                } else {
                    return;
                }
                if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof TiebaUidCheckReqMsg) && (tiebaUidCheckReqMsg = (TiebaUidCheckReqMsg) responsedMessage.getOrginalMessage().getExtra()) != null) {
                    lVar = tiebaUidCheckReqMsg.mTiebaUidData;
                } else {
                    lVar = null;
                }
                if (userData == null || lVar == null) {
                    return;
                }
                this.a.t();
                fu4.f().e();
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                TbPageContext D = this.a.D(currentActivity);
                if (currentActivity != null && D != null) {
                    o55.g(Collections.singletonList(new m55(D, currentActivity, userData, lVar)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTokenController a;

        public i(BdTokenController bdTokenController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTokenController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTokenController;
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
                    if (!ei.isEmpty(str) && (matcher = BdTokenController.m.matcher(str)) != null && matcher.find()) {
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
                if (str == null) {
                    this.a.v();
                    return;
                }
                this.a.x(str.substring(1, str.length() - 1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends BdAsyncTask<String, Integer, qu4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdTokenController a;

        public j(BdTokenController bdTokenController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdTokenController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdTokenController;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public qu4 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                if (strArr == null || strArr.length < 1) {
                    return null;
                }
                String str = strArr[0];
                if (ei.isEmpty(str)) {
                    return null;
                }
                if (this.a.f == null) {
                    this.a.f = new ru4();
                }
                return this.a.f.a(str);
            }
            return (qu4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(qu4 qu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qu4Var) == null) {
                super.onPostExecute(qu4Var);
                if (qu4Var == null) {
                    this.a.v();
                } else if (qu4Var.d) {
                    this.a.t();
                    if (!this.a.x(qu4Var.e)) {
                        if (!StringUtils.isNull(qu4Var.a)) {
                            this.a.v();
                            this.a.T(qu4Var.a, qu4Var.c);
                            return;
                        }
                        this.a.v();
                        return;
                    }
                    this.a.J(qu4Var.e);
                    tu4.b(qu4Var.c, qu4Var.e);
                } else if (StringUtils.isNull(qu4Var.a)) {
                    this.a.v();
                } else {
                    this.a.S(qu4Var.a);
                    this.a.T(qu4Var.a, qu4Var.c);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public static final BdTokenController a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1147132956, "Lcom/baidu/tbadk/BdToken/BdTokenController$k;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1147132956, "Lcom/baidu/tbadk/BdToken/BdTokenController$k;");
                    return;
                }
            }
            a = new BdTokenController();
        }
    }

    /* loaded from: classes4.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.b = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(832477699, "Lcom/baidu/tbadk/BdToken/BdTokenController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(832477699, "Lcom/baidu/tbadk/BdToken/BdTokenController;");
                return;
            }
        }
        k = Pattern.compile("\\$[0-9A-Za-z@_]{5,300}[#$]", 2);
        l = Pattern.compile("^@(.*)@给你分享了贴吧号#(\\d+)#\\s?整段复制后打开贴吧即可找到Ta$", 2);
        m = Pattern.compile("\\$(com.baidu.tieba://unidispatch/)[0-9a-zA-Z]{1,10}\\?[0-9a-zA-Z_=&%\\-.]{1,300}[$]", 2);
    }

    public BdTokenController() {
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
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.j = new b(this);
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            bha.h(309626, DecryptCodeSocketRespMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, bha.a(TbConfig.DECRYPT_CODE_URL, 309626));
            tbHttpMessageTask.setResponsedClass(DecryptCodeHttpRespMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MessageManager.getInstance().registerListener(new f(this, CmdConfigHttp.CMD_HTTP_DECRYPT_CODE, 309626));
            MessageManager.getInstance().registerListener(new g(this, CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, 309702));
            MessageManager.getInstance().registerListener(new h(this, 2001011));
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            bha.h(309702, TiebaUidCheckSocketResMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_TIEBA_UID_CHECK, bha.a(TbConfig.URL_GET_USER_BY_TIEBA_UID, 309702));
            tbHttpMessageTask.setResponsedClass(TiebaUidCheckHttpResMsg.class);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void U() {
        SyncToken syncToken;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (syncToken = this.g) != null && !TextUtils.isEmpty(syncToken.url)) {
            x(this.g.url);
            if (!TextUtils.isEmpty(this.g.token)) {
                p(this.g.token, true);
            }
            u();
        }
    }

    public static final BdTokenController E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return k.a;
        }
        return (BdTokenController) invokeV.objValue;
    }

    public final String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (System.currentTimeMillis() - this.b < 2000) {
                return null;
            }
            this.b = System.currentTimeMillis();
            return UtilHelper.getClipBoardContent().trim();
        }
        return (String) invokeV.objValue;
    }

    public final String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new String(Base64.decode(SharedPrefHelper.getInstance().getString("key_baidu_password_re", "LipcXlsjJGEtekEtWjAtOV9dezUsfVxeezAsMX1bXF4kXXsxfS4q"), 0));
        }
        return (String) invokeV.objValue;
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            String topActivityClassName = UtilHelper.getTopActivityClassName();
            if (!ei.isEmpty(topActivityClassName) && topActivityClassName.equals(SpeedRuntimeProvider.MAIN_ACTIVITY_NAME) && TbSingleton.getInstance().isRecommendPage()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            UtilHelper.clearClipBoard();
            String str = this.h;
            if (str != null && !TextUtils.isEmpty(str)) {
                p(this.h, false);
            }
            u();
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.g = null;
            this.h = null;
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int i2 = this.i - 1;
            this.i = i2;
            if (i2 == 0) {
                U();
            }
        }
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || ei.isEmpty(str)) {
            return;
        }
        new i(this).execute(str);
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || ei.isEmpty(str)) {
            return;
        }
        new a(this).execute(str);
    }

    public final TbPageContext D(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
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

    public void M(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jSONObject) == null) && jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("token_info");
                if (optJSONObject != null) {
                    this.g = (SyncToken) DataExt.toEntity(optJSONObject.toString(), SyncToken.class);
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final void R(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) {
            if (TbadkCoreApplication.getInst().isMIUIRom()) {
                by5.b(new c(this), new d(this, j2));
            } else {
                N(C(), j2);
            }
        }
    }

    public void S(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.h = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.i = 5;
            s(str);
            z(str);
            A(str);
            B(str);
        }
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, str) == null) && this.c != null) {
            S(str);
            this.c.c(str);
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            if (!ei.isEmpty(str) && str.contains("^sZqulxTVsT$")) {
                r(str);
            } else {
                v();
            }
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, str) != null) || ei.isEmpty(str)) {
            return;
        }
        new j(this).execute(str);
    }

    public boolean K(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return L(Pattern.compile(str), str2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean L(Pattern pattern, String str) {
        InterceptResult invokeLL;
        Matcher matcher;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, pattern, str)) == null) {
            if (pattern == null || TextUtils.isEmpty(str) || (matcher = pattern.matcher(str)) == null || !matcher.find()) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void w(String str, String str2) {
        TbPageContext<?> D;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, str, str2) == null) && !ei.isEmpty(str2) && (D = D(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            UrlManager.getInstance().dealOneLink(D, str, new String[]{str2});
        }
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (ei.isEmpty(clipBoardContent)) {
                return false;
            }
            if (!K(F(), clipBoardContent) && !clipBoardContent.contains("^sZqulxTVsT$") && !L(k, clipBoardContent) && !L(m, clipBoardContent) && !L(l, clipBoardContent)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void H(boolean z) {
        long j2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048582, this, z) == null) && !this.a) {
            O();
            Q();
            P();
            ot4 ot4Var = new ot4();
            this.c = ot4Var;
            ot4Var.g(this.j);
            if (z) {
                j2 = 4000;
            } else {
                j2 = 2000;
            }
            R(j2);
            this.a = true;
        }
    }

    public final void y(gu4 gu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, gu4Var) == null) && gu4Var != null && gu4Var.b() != null && !ei.isEmpty(gu4Var.b().a) && I()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921380, gu4Var.b().a));
        }
    }

    public final void J(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            Uri parse = Uri.parse(str);
            String str6 = "";
            if (parse == null) {
                str2 = "";
            } else {
                str2 = parse.getQueryParameter("obj_source");
            }
            if (parse == null) {
                str3 = "";
            } else {
                str3 = parse.getQueryParameter("obj_type");
            }
            if (parse == null) {
                str4 = "";
            } else {
                str4 = parse.getQueryParameter("tid");
            }
            if (parse == null) {
                str5 = "";
            } else {
                str5 = parse.getQueryParameter("fname");
            }
            if (parse != null) {
                str6 = parse.getQueryParameter(TiebaStatic.Params.EQID);
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && str3.startsWith("tbcm")) {
                TiebaStatic.log(new StatisticItem("c13390").param("obj_type", str3).param("obj_source", str2).param("tid", str4).param("fname", str5));
            } else {
                TiebaStatic.log(new StatisticItem("c13390").param("obj_type", str3).param("obj_source", str2).param("tid", str4).param("fname", str5).param("query", str6));
            }
        }
    }

    public final void N(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048588, this, str, j2) == null) {
            if (!ei.isEmpty(str)) {
                E().q(str);
            } else if (j2 > 0) {
                SafeHandler.getInst().postDelayed(new e(this), j2);
            } else {
                U();
            }
        }
    }

    public final void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) && !this.d.get()) {
            tu4.b = str;
            tu4.d(str2);
            this.d.compareAndSet(false, true);
            DecryptCodeReqMsg decryptCodeReqMsg = new DecryptCodeReqMsg();
            decryptCodeReqMsg.setCode(str);
            MessageManager.getInstance().sendMessage(decryptCodeReqMsg);
        }
    }

    public final void p(@NonNull String str, boolean z) {
        TbPageContext D;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048596, this, str, z) != null) || (D = D(TbadkCoreApplication.getInst().getCurrentActivity())) == null) {
            return;
        }
        FastRequest fastRequest = new FastRequest(D, CmdConfigHttp.CMD_HTTP_DEL_TOKEN_INFO, TbConfig.DEL_TOKEN_INFO);
        fastRequest.N("token", str);
        fastRequest.N("is_server", Integer.valueOf(z ? 1 : 0));
        fastRequest.O();
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Activity currentActivity;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            if (ei.isEmpty(str) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null || (parse = Uri.parse(str)) == null) {
                return false;
            }
            if (str.startsWith(BdUniDispatchSchemeController.SCHEME)) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                buildUpon.appendQueryParameter(BdUniDispatchSchemeController.PARAM_SCHEME_FROM, BdUniDispatchSchemeController.SCHEME_FROM_TB_TOKEN);
                parse = buildUpon.build();
            }
            return UtilHelper.dealOneScheme(currentActivity, parse.toString());
        }
        return invokeL.booleanValue;
    }
}

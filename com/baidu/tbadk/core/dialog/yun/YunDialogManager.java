package com.baidu.tbadk.core.dialog.yun;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.browser.TBWebViewActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogDataManager;
import com.baidu.tbadk.core.dialog.yun.strategy.ExcludeDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.FrequenceDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.PageDialogStrategy;
import com.baidu.tbadk.core.dialog.yun.strategy.UniqueDialogStrategy;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.a05;
import com.baidu.tieba.c15;
import com.baidu.tieba.e15;
import com.baidu.tieba.f15;
import com.baidu.tieba.g15;
import com.baidu.tieba.i15;
import com.baidu.tieba.j15;
import com.baidu.tieba.k15;
import com.baidu.tieba.l15;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.m15;
import com.baidu.tieba.n15;
import com.baidu.tieba.o15;
import com.baidu.tieba.p15;
import com.baidu.tieba.q15;
import com.baidu.tieba.s15;
import com.baidu.tieba.t15;
import com.baidu.tieba.ye1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YunDialogManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_ID = "5001";
    public static final String LOG_KEY = "YunDialogManager";
    public static final String PAGE_PARAMS_KEY = "pageParams";
    public static final String TIME_KEY = "time";
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Set<String> alreadyShownDialogs;
    @NonNull
    public String currentPageName;
    @NonNull
    public final Set<String> currentShowingDialogList;
    public final CustomMessageListener dialogDismissListener;
    public boolean isBackFromYunDialog;
    @NonNull
    public final Set<String> showingH5DialogList;
    @NonNull
    public final Map<String, e15> strategyMap;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YunDialogManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(YunDialogManager yunDialogManager, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yunDialogManager, Integer.valueOf(i)};
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
            this.a = yunDialogManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.a.currentShowingDialogList.remove(str);
                this.a.showingH5DialogList.remove(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ a05 b;

        public b(Context context, a05 a05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, a05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = a05Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                YunDialogManager.onShow(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements YunDialogDataManager.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ a05 b;

        public c(Context context, a05 a05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, a05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = a05Var;
        }

        @Override // com.baidu.tbadk.core.dialog.yun.YunDialogDataManager.e
        public void a(List<DialogStrategiesData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                for (DialogStrategiesData dialogStrategiesData : list) {
                    YunDialogManager.access$400().show(this.a, this.b.b(), dialogStrategiesData, new JSONObject());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONObject c;

        public d(Context context, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = str;
            this.c = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                YunDialogManager.onShow(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements YunDialogDataManager.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ JSONObject b;

        public e(Context context, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = jSONObject;
        }

        @Override // com.baidu.tbadk.core.dialog.yun.YunDialogDataManager.e
        public void a(List<DialogStrategiesData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                for (DialogStrategiesData dialogStrategiesData : list) {
                    YunDialogManager.access$400().show(this.a, "", dialogStrategiesData, this.b);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public static final YunDialogManager a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(876514735, "Lcom/baidu/tbadk/core/dialog/yun/YunDialogManager$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(876514735, "Lcom/baidu/tbadk/core/dialog/yun/YunDialogManager$f;");
                    return;
                }
            }
            a = new YunDialogManager(null);
        }
    }

    public YunDialogManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.strategyMap = new HashMap();
        this.currentShowingDialogList = new HashSet();
        this.showingH5DialogList = new HashSet();
        this.alreadyShownDialogs = new HashSet();
        this.currentPageName = "";
        this.isBackFromYunDialog = false;
        this.dialogDismissListener = new a(this, 2921753);
        f15 f15Var = new f15();
        ye1<g15> ye1Var = f15Var.a;
        if (ye1Var != null && !ListUtils.isEmpty(ye1Var.getList())) {
            for (g15 g15Var : f15Var.a.getList()) {
                this.strategyMap.put(g15Var.name(), g15Var.a());
            }
        }
        this.strategyMap.put("NEW_FREQUENCE_STRATEGY", new q15());
        this.strategyMap.put("FREQUENCE_STRATEGY", new FrequenceDialogStrategy());
        this.strategyMap.put("PAGE_STRATEGY", new PageDialogStrategy());
        this.strategyMap.put("EXCLUDE_STRATEGY", new ExcludeDialogStrategy());
        this.strategyMap.put("UNIQUE_STRATEGY", new UniqueDialogStrategy());
        this.strategyMap.put("HYBRID_CHECK_STRATEGY", new i15());
        this.strategyMap.put("NA_USER_ICON_STRATEGY", new p15());
        this.strategyMap.put("NA_USER_GROWTH_STRATEGY", new o15());
        this.strategyMap.put("NA_NEW_GOD_STRATEGY", new j15());
        this.strategyMap.put("NA_OPERATION_STRATEGY", new l15());
        this.strategyMap.put("NA_LIVE_REMIND_STRATEGY", new k15());
        this.strategyMap.put("NA_COMMON_NOTIFY_STRATEGY", new m15());
        this.strategyMap.put("NA_UPDATE_STRATEGY", new n15());
        TbLog yunDialogLog = YunDialogLog.getInstance();
        yunDialogLog.i(LOG_KEY, "strategyMap:" + this.strategyMap);
        MessageManager.getInstance().registerListener(this.dialogDismissListener);
    }

    public /* synthetic */ YunDialogManager(a aVar) {
        this();
    }

    public static boolean isYunDialogActivity(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, activity)) == null) {
            if ((activity instanceof TBWebViewActivity) && activity.getIntent() != null && !TextUtils.isEmpty(activity.getIntent().getStringExtra(WebViewActivityConfig.TAG_WEB_DIALOG_NAME))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void markIsBackFromYunDialog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            getInstance().isBackFromYunDialog = z;
        }
    }

    public static void markShowingDialogName(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, str) == null) {
            getInstance().currentShowingDialogList.add(str);
            getInstance().alreadyShownDialogs.add(str);
        }
    }

    public static /* synthetic */ YunDialogManager access$400() {
        return getInstance();
    }

    public static YunDialogManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return f.a;
        }
        return (YunDialogManager) invokeV.objValue;
    }

    public static Set<String> getShowingDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return getInstance().showingH5DialogList;
        }
        return (Set) invokeV.objValue;
    }

    public static boolean isShowingDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return !getInstance().showingH5DialogList.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public static boolean canShowDialog(@Nullable a05 a05Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, a05Var)) == null) {
            String str = null;
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                TbLog yunDialogLog = YunDialogLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("云弹窗 ");
                if (a05Var != null) {
                    str = a05Var.b();
                }
                sb.append(str);
                sb.append(" 不可显示：当前冷启动开屏展示中");
                yunDialogLog.i(LOG_KEY, sb.toString());
                return false;
            } else if (LogoActivityConfig.IS_HOT_SPLASH_SHOW) {
                TbLog yunDialogLog2 = YunDialogLog.getInstance();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("云弹窗 ");
                if (a05Var != null) {
                    str = a05Var.b();
                }
                sb2.append(str);
                sb2.append(" 不可显示：当前热启动开屏展示中");
                yunDialogLog2.i(LOG_KEY, sb2.toString());
                return false;
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                TbLog yunDialogLog3 = YunDialogLog.getInstance();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("云弹窗 ");
                if (a05Var != null) {
                    str = a05Var.b();
                }
                sb3.append(str);
                sb3.append(" 不可显示：当前网络异常");
                yunDialogLog3.i(LOG_KEY, sb3.toString());
                return false;
            } else if (a05Var != null && a05Var.c() && getInstance().isBackFromYunDialog) {
                TbLog yunDialogLog4 = YunDialogLog.getInstance();
                yunDialogLog4.i(LOG_KEY, "云弹窗 " + a05Var.b() + " 不可显示：从云弹窗返回");
                return false;
            } else {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    private void doShowDialog(@NonNull Context context, @NonNull String str, @Nullable List<DialogStrategiesData.StrategiesConfigData> list, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, this, context, str, list, str2) == null) {
            this.currentShowingDialogList.add(str);
            this.showingH5DialogList.add(str);
            c15.a(context, str, str2);
            TbLog yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.i(LOG_KEY, "云弹窗 " + str + " 弹出显示，展示链接：" + str2);
            t15.a.c(str);
            if (hasNewFrequenceStrategy(list)) {
                s15.a.g(str, readFrequencyVersion(list));
            }
            this.alreadyShownDialogs.add(str);
        }
    }

    private boolean findUnUniqueStrategyExist(List<DialogStrategiesData.StrategiesConfigData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            for (DialogStrategiesData.StrategiesConfigData strategiesConfigData : list) {
                if ("UN_UNIQUE_STRATEGY".equals(strategiesConfigData.getType())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean hasNewFrequenceStrategy(@Nullable List<DialogStrategiesData.StrategiesConfigData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, list)) == null) {
            if (list == null || list.size() == 0) {
                return false;
            }
            for (DialogStrategiesData.StrategiesConfigData strategiesConfigData : list) {
                if ("NEW_FREQUENCE_STRATEGY".equals(strategiesConfigData.getType())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void onHidden(@NonNull a05 a05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, a05Var) == null) {
            TbLog yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.i(LOG_KEY, "云弹窗时机消失:" + a05Var.b());
            if (a05Var.c()) {
                getInstance().currentPageName = "";
            }
        }
    }

    public static void unMarkShowingDialogName(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            TbLog yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.i(LOG_KEY, "unMarkShowingDialogName:" + str);
            getInstance().currentShowingDialogList.remove(str);
            getInstance().showingH5DialogList.remove(str);
        }
    }

    public static void onShow(@NonNull Context context, @NonNull a05 a05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, a05Var) == null) {
            if (!BdUtilHelper.isMainThread()) {
                SafeHandler.getInst().postAtFrontOfQueue(new b(context, a05Var));
                return;
            }
            TbLog yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.i(LOG_KEY, "云弹窗时机触发:" + a05Var.b());
            if (a05Var.c()) {
                getInstance().currentPageName = a05Var.b();
            }
            if (!canShowDialog(a05Var)) {
                return;
            }
            YunDialogDataManager.j().g(a05Var.b(), new c(context, a05Var));
        }
    }

    public static void onShow(@NonNull Context context, @NonNull String str, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, context, str, jSONObject) == null) {
            if (!BdUtilHelper.isMainThread()) {
                SafeHandler.getInst().postAtFrontOfQueue(new d(context, str, jSONObject));
            } else if (!canShowDialog(null)) {
            } else {
                YunDialogDataManager.j().f(str, new e(context, jSONObject));
            }
        }
    }

    private String parseUrl(String str, @NonNull String str2, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, this, str, str2, jSONObject)) == null) {
            if (!TextUtils.isEmpty(str)) {
                Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("time", str2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    appendQueryParameter.appendQueryParameter(next, jSONObject.optString(next));
                }
                return appendQueryParameter.build().toString();
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    private int readFrequencyVersion(@Nullable List<DialogStrategiesData.StrategiesConfigData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, list)) == null) {
            if (list == null) {
                return 0;
            }
            for (DialogStrategiesData.StrategiesConfigData strategiesConfigData : list) {
                if ("NEW_FREQUENCE_STRATEGY".equals(strategiesConfigData.getType())) {
                    try {
                        return ((FrequenceDialogStrategy.Data) DataExt.toEntity(strategiesConfigData.O(), FrequenceDialogStrategy.Data.class)).frequenceClearVersion;
                    } catch (Exception e2) {
                        TbLog yunDialogLog = YunDialogLog.getInstance();
                        yunDialogLog.e(LOG_KEY, "新版频次版本读取失败 " + strategiesConfigData.O());
                        e2.printStackTrace();
                        if (!TbadkCoreApplication.getInst().isDebugMode()) {
                            return 0;
                        }
                        throw e2;
                    }
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show(@NonNull Context context, @NonNull String str, @NonNull DialogStrategiesData dialogStrategiesData, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65557, this, context, str, dialogStrategiesData, jSONObject) == null) {
            TbLog yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.i(LOG_KEY, "准备显示云弹窗：" + dialogStrategiesData.getDialogName() + " ，参数：" + jSONObject);
            List<DialogStrategiesData.StrategiesConfigData> dialogStrategy = dialogStrategiesData.getDialogStrategy();
            HashMap hashMap = new HashMap();
            hashMap.put("currentShowingDialogList", this.currentShowingDialogList);
            hashMap.put("alreadyShownDialogs", this.alreadyShownDialogs);
            hashMap.put("currentPageName", this.currentPageName);
            if (!TextUtils.isEmpty(dialogStrategiesData.getDialogName()) && this.currentShowingDialogList.contains(dialogStrategiesData.getDialogName())) {
                TbLog yunDialogLog2 = YunDialogLog.getInstance();
                yunDialogLog2.i(LOG_KEY, "云弹窗 " + dialogStrategiesData.getDialogName() + " 正在显示中，过滤");
                return;
            }
            if (!findUnUniqueStrategyExist(dialogStrategy)) {
                if (dialogStrategy == null) {
                    dialogStrategy = new ArrayList<>();
                }
                dialogStrategy.add(DialogStrategiesData.StrategiesConfigData.N());
            }
            if (dialogStrategy != null) {
                for (DialogStrategiesData.StrategiesConfigData strategiesConfigData : dialogStrategy) {
                    e15 e15Var = this.strategyMap.get(strategiesConfigData.getType());
                    if (e15Var != null && !e15Var.b(e15Var.a(dialogStrategiesData, strategiesConfigData.O(), hashMap))) {
                        return;
                    }
                }
            }
            doShowDialog(context, dialogStrategiesData.getDialogName(), dialogStrategy, parseUrl(dialogStrategiesData.getDialogUrl(), str, jSONObject));
        }
    }
}

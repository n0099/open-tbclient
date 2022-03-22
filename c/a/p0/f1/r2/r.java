package c.a.p0.f1.r2;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.w;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(TbPageContext tbPageContext, Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, tbPageContext, intent, str) == null) || tbPageContext == null) {
            return;
        }
        if (intent != null && !intent.getBooleanExtra("back_special", false)) {
            tbPageContext.getPageActivity().finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
                tbPageContext.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(1)));
            } else {
                c.a.o0.r.f0.b.e(tbPageContext.getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
            tbPageContext.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2)));
        } else {
            c.a.o0.r.f0.b.e(tbPageContext.getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
            tbPageContext.getPageActivity().finish();
        }
    }

    public static j b(Intent intent) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            if (intent == null || intent.getParcelableExtra(IntentConfig.KEY_URI) == null) {
                return null;
            }
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            j jVar = new j();
            if (!StringUtils.isNull(uri2) && uri2.startsWith("tbfrs://")) {
                String decode = Uri.decode(uri.getEncodedPath());
                if (StringUtils.isNull(decode)) {
                    return null;
                }
                Matcher matcher = Pattern.compile(".*fr=(.*)&kw=(.*)").matcher(decode);
                if (matcher.find()) {
                    if (!"mpush".equals(matcher.group(1)) && "bpush".equals(matcher.group(1))) {
                        k(decode);
                    }
                    jVar.a = matcher.group(2);
                } else {
                    k(decode);
                    int indexOf = decode.indexOf("kw=");
                    if (indexOf < 0 || (i = indexOf + 3) > decode.length()) {
                        return null;
                    }
                    jVar.a = decode.substring(i);
                    try {
                        jVar.f14486b = uri.getQueryParameter("from");
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                }
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", uri2);
                MessageManager.getInstance().sendMessage(httpMessage);
            }
            return jVar;
        }
        return (j) invokeL.objValue;
    }

    public static Intent c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            if (TextUtils.isEmpty(str) || context == null) {
                return null;
            }
            Intent intent = new Intent(context, DealIntentService.class);
            intent.putExtra(DealIntentService.KEY_CLASS, 2);
            intent.putExtra("fname", str);
            intent.putExtra("from", "nas");
            return intent;
        }
        return (Intent) invokeLL.objValue;
    }

    public static void d(TbPageContext tbPageContext, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, tbPageContext, frsViewData) == null) || tbPageContext == null || frsViewData == null) {
            return;
        }
        c.a.o0.l.a.q(tbPageContext.getPageActivity(), "福袋", TbConfig.SERVER_ADDRESS + TbConfig.FORTUNE_ADDRESS + "?fid=" + frsViewData.getForum().getId(), true, true, true);
    }

    public static void e(FrsFragment frsFragment, ThreadData threadData, int i, boolean z) {
        PbActivityConfig createFromThreadCfg;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{frsFragment, threadData, Integer.valueOf(i), Boolean.valueOf(z)}) == null) || frsFragment == null || threadData == null) {
            return;
        }
        String str = null;
        String valueOf = String.valueOf(threadData.getFid());
        OriginalForumInfo originalForumInfo = threadData.mOriginalForumInfo;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            str = valueOf;
        }
        if (threadData.getLastReadPid() > 0 && c.a.p0.a4.q0.e.c()) {
            createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createHistoryCfg(threadData.getTid(), String.valueOf(threadData.getLastReadPid()), false, true, "frs_page");
        } else {
            createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(threadData, frsFragment.a(), "frs_page", 18003, true, false, z);
        }
        if (i == 4) {
            createFromThreadCfg.setVideo_source("floor5");
        } else {
            createFromThreadCfg.setVideo_source("frs");
        }
        createFromThreadCfg.setFromSmartFrs(threadData.isSmartFrsThread());
        createFromThreadCfg.setSmartFrsPosition(i);
        createFromThreadCfg.setForumId(valueOf);
        createFromThreadCfg.setFromForumId(str);
        createFromThreadCfg.setStartFrom(3);
        createFromThreadCfg.setFrom("from_frs");
        if (threadData.isInterviewLiveStyle() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && j(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            c.a.p0.f1.l.update(threadData);
        }
        frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void f(FrsFragment frsFragment, String str, ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{frsFragment, str, threadData, Boolean.valueOf(z)}) == null) || frsFragment == null || threadData == null || str == null) {
            return;
        }
        if (!(threadData == null || threadData.isAnonymityUser())) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(threadData, frsFragment.a(), "frs_page", 18003, true, true, z);
            createFromThreadCfg.setVideo_source("frs");
            createFromThreadCfg.setStartFrom(3);
            frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            return;
        }
        PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(threadData, frsFragment.a(), "frs_page", 18003, true, false, z);
        createFromThreadCfg2.setVideo_source("frs");
        createFromThreadCfg2.setStartFrom(3);
        frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg2));
    }

    public static void g(FrsFragment frsFragment, String str, ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{frsFragment, str, threadData, Boolean.valueOf(z)}) == null) || frsFragment == null || threadData == null || str == null) {
            return;
        }
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(threadData, frsFragment.a(), "frs_page", 18003, false, false, z);
        createFromThreadCfg.setVideo_source("frs");
        createFromThreadCfg.setStartFrom(3);
        frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void h(FrsFragment frsFragment, int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65543, null, frsFragment, i, strArr, iArr) == null) || frsFragment == null || strArr == null || iArr == null || i != 1) {
            return;
        }
        if (PermissionUtil.checkCamera(TbadkCoreApplication.getInst().getApplicationContext())) {
            SelectImageHelper.takePhoto(frsFragment.getPageContext());
        } else {
            frsFragment.showToast(R.string.obfuscated_res_0x7f0f1312);
        }
        ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
        if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
            return;
        }
        frsFragment.showToast(R.string.obfuscated_res_0x7f0f1076);
    }

    public static boolean i(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            Iterator<ActivityManager.RunningTaskInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningTaskInfo next = it.next();
                if (next.topActivity.getClassName().equals(str)) {
                    if (next.numActivities <= 1) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean j(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, threadData)) == null) {
            if (threadData == null || threadData.isShareThread) {
                return false;
            }
            int i = threadData.threadType;
            return i == 0 || i == 11 || i == 40 || threadData.isUgcThreadType();
        }
        return invokeL.booleanValue;
    }

    public static void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            if (str.startsWith("//")) {
                str = str.substring(2);
            }
            Map<String, String> paramPair = UrlManager.getParamPair(str);
            if (paramPair != null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SCHEME_JUMP_CALL_NATIVE);
                w.b(statisticItem, paramPair);
                statisticItem.param("obj_locate", paramPair.get("obj_locate"));
                statisticItem.param("obj_type", 1);
                statisticItem.param("fname", paramPair.get(TiebaStatic.Params.H5_FORUM_NAME));
                statisticItem.param("obj_source", paramPair.get("obj_source"));
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, paramPair.get(TiebaStatic.Params.OBJ_PARAM2));
                statisticItem.param(TiebaStatic.Params.OBJ_TO, 2);
                statisticItem.param("obj_id", paramPair.get(TiebaStatic.Params.BDID));
                statisticItem.param("obj_name", TbadkCoreApplication.getInst().getStartType());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, 1);
                if (!c.a.d.f.p.m.isEmpty(paramPair.get("ext_log"))) {
                    try {
                        JSONObject jSONObject = new JSONObject(paramPair.get("ext_log"));
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            statisticItem.param(next, jSONObject.getString(next));
                        }
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }
}

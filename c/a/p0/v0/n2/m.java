package c.a.p0.v0.n2;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.w;
import c.a.o0.s.q.c2;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalForumInfo;
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
/* loaded from: classes4.dex */
public class m {
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
                c.a.o0.s.a0.b.e(tbPageContext.getPageActivity(), 1);
            }
        } else if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
            tbPageContext.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(2)));
        } else {
            c.a.o0.s.a0.b.e(tbPageContext.getPageActivity(), 2);
        }
        if (FrsActivityConfig.FRS_FROM_WRITESHARE.equals(str)) {
            tbPageContext.getPageActivity().finish();
        }
    }

    public static g b(Intent intent) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            if (intent == null || intent.getParcelableExtra(IntentConfig.KEY_URI) == null) {
                return null;
            }
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            String uri2 = uri.toString();
            g gVar = new g();
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
                    gVar.f26335a = matcher.group(2);
                } else {
                    k(decode);
                    int indexOf = decode.indexOf(FrsFragment.FORUM_KW);
                    if (indexOf < 0 || (i2 = indexOf + 3) > decode.length()) {
                        return null;
                    }
                    gVar.f26335a = decode.substring(i2);
                    try {
                        gVar.f26336b = uri.getQueryParameter("from");
                    } catch (Exception e2) {
                        BdLog.e(e2);
                    }
                }
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                httpMessage.addParam("call_url", uri2);
                MessageManager.getInstance().sendMessage(httpMessage);
            }
            return gVar;
        }
        return (g) invokeL.objValue;
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
        c.a.o0.m.a.o(tbPageContext.getPageActivity(), "福袋", TbConfig.SERVER_ADDRESS + TbConfig.FORTUNE_ADDRESS + "?fid=" + frsViewData.getForum().getId(), true, true, true);
    }

    public static void e(FrsFragment frsFragment, c2 c2Var, int i2, boolean z) {
        PbActivityConfig createFromThreadCfg;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{frsFragment, c2Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || frsFragment == null || c2Var == null) {
            return;
        }
        String str = null;
        String valueOf = String.valueOf(c2Var.T());
        OriginalForumInfo originalForumInfo = c2Var.G1;
        if (originalForumInfo != null) {
            valueOf = originalForumInfo.id;
            str = valueOf;
        }
        if (c2Var.s0() > 0 && c.a.p0.i3.n0.e.c()) {
            createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createHistoryCfg(c2Var.q1(), String.valueOf(c2Var.s0()), false, true, FrsFragment.STAR_FRS);
        } else {
            createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(c2Var, frsFragment.getForumName(), FrsFragment.STAR_FRS, 18003, true, false, z);
        }
        if (i2 == 4) {
            createFromThreadCfg.setVideo_source("floor5");
        } else {
            createFromThreadCfg.setVideo_source("frs");
        }
        createFromThreadCfg.setFromSmartFrs(c2Var.t2());
        createFromThreadCfg.setSmartFrsPosition(i2);
        createFromThreadCfg.setForumId(valueOf);
        createFromThreadCfg.setFromForumId(str);
        createFromThreadCfg.setStartFrom(3);
        createFromThreadCfg.setFrom("from_frs");
        if (c2Var.a2() && createFromThreadCfg.getIntent() != null) {
            createFromThreadCfg.getIntent().putExtra("KEY_IS_INTERVIEW_LIVE", true);
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && j(c2Var)) {
            createFromThreadCfg.setNeedPreLoad(true);
            c.a.p0.v0.l.c(c2Var);
        }
        frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void f(FrsFragment frsFragment, String str, c2 c2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{frsFragment, str, c2Var, Boolean.valueOf(z)}) == null) || frsFragment == null || c2Var == null || str == null) {
            return;
        }
        if (!(c2Var == null || c2Var.I1())) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(c2Var, frsFragment.getForumName(), FrsFragment.STAR_FRS, 18003, true, true, z);
            createFromThreadCfg.setVideo_source("frs");
            createFromThreadCfg.setStartFrom(3);
            frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            return;
        }
        PbActivityConfig createFromThreadCfg2 = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(c2Var, frsFragment.getForumName(), FrsFragment.STAR_FRS, 18003, true, false, z);
        createFromThreadCfg2.setVideo_source("frs");
        createFromThreadCfg2.setStartFrom(3);
        frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg2));
    }

    public static void g(FrsFragment frsFragment, String str, c2 c2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{frsFragment, str, c2Var, Boolean.valueOf(z)}) == null) || frsFragment == null || c2Var == null || str == null) {
            return;
        }
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(frsFragment.getPageContext().getPageActivity()).createFromThreadCfg(c2Var, frsFragment.getForumName(), FrsFragment.STAR_FRS, 18003, false, false, z);
        createFromThreadCfg.setVideo_source("frs");
        createFromThreadCfg.setStartFrom(3);
        frsFragment.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void h(FrsFragment frsFragment, int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65543, null, frsFragment, i2, strArr, iArr) == null) || frsFragment == null || strArr == null || iArr == null || i2 != 1) {
            return;
        }
        if (PermissionUtil.checkCamera(TbadkCoreApplication.getInst().getApplicationContext())) {
            SelectImageHelper.takePhoto(frsFragment.getPageContext());
        } else {
            frsFragment.showToast(R.string.system_permission_prompt_camera);
        }
        ArrayMap<String, Boolean> transformPermissionResult = PermissionUtil.transformPermissionResult(strArr, iArr);
        if (!transformPermissionResult.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") || transformPermissionResult.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
            return;
        }
        frsFragment.showToast(R.string.sdcard_permission_denied_advert_for_camera);
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

    public static boolean j(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, c2Var)) == null) {
            if (c2Var == null || c2Var.w1) {
                return false;
            }
            int i2 = c2Var.a0;
            return i2 == 0 || i2 == 11 || i2 == 40 || c2Var.z2();
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
                if (!c.a.e.e.p.k.isEmpty(paramPair.get("ext_log"))) {
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

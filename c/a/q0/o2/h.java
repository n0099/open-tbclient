package c.a.q0.o2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.play.PlayStatisticsResponseMessage;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(49367541, "Lc/a/q0/o2/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(49367541, "Lc/a/q0/o2/h;");
                return;
            }
        }
        c();
        b();
    }

    public static void a(HttpMessage httpMessage, o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, httpMessage, oVar) == null) || httpMessage == null || oVar == null) {
            return;
        }
        httpMessage.addParam("tid", oVar.f23218c);
        httpMessage.addParam("fid", oVar.f23219d);
        httpMessage.addParam(TiebaStatic.Params.OBJ_TO, oVar.f23222g);
        httpMessage.addParam("obj_id", oVar.k);
        httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM3, oVar.f23223h);
        httpMessage.addParam("obj_source", oVar.f23221f);
        httpMessage.addParam("obj_locate", oVar.f23216a);
        httpMessage.addParam("obj_param1", oVar.f23224i);
        if (!StringUtils.isNull(oVar.n)) {
            httpMessage.addParam("topic_type", oVar.n);
        }
        if (StringUtils.isNull(oVar.p)) {
            return;
        }
        httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, oVar.p);
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_DURATION_STATISTICS);
            tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PLAY_STATISTICS_CMD, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_STATISTICS);
            tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public static void d(long j2, String str, o oVar, String str2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), str, oVar, str2, Long.valueOf(j3)}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS);
            httpMessage.addParam(TiebaStatic.Params.OBJ_DURATION, j2);
            httpMessage.addParam("obj_type", str);
            httpMessage.addParam("playduration", j3);
            if (oVar != null) {
                httpMessage.addParam(VideoFinishResult.KEY_VIDEO_MD5, oVar.m);
            }
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
            a(httpMessage, oVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void e(String str, String str2, String str3, o oVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, str2, str3, oVar, Integer.valueOf(i2)}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_PLAY_STATISTICS_CMD);
            httpMessage.addParam(VideoFinishResult.KEY_VIDEO_MD5, str);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
            httpMessage.addParam("obj_type", str3);
            if (TbSingleton.getInstance().getPcdnConfigData() != null && TbSingleton.getInstance().getPcdnConfigData().c()) {
                httpMessage.addParam("pcdn_state", i2);
            }
            a(httpMessage, oVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}

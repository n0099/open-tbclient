package com.baidu.tbadk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.xh;
import com.baidu.tieba.zoa;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public class TiebaIMConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GET_DOUBLE_FOLLOW_LIST = "c/u/user/get_double_follows";
    public static final BdUniqueId IM_ASYCTASK_UNIQUEID;
    public static String IM_GROUP_SHARE_URL = null;
    public static final int MAX_IMAGES_IN_GROUP_GALLARY = 1000;
    public static String NEW_UPLOAD_PIC_SERVER = null;
    public static int POST_IMAGE_DEFAULT_HEIGHT = 0;
    public static int POST_IMAGE_DEFAULT_WIDTH = 0;
    public static String POST_IMAGE_PATH = null;
    public static final String PROTOBUF_VERSION = "1.0.3";
    public static final String PUBLIC_KEY_BASE64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwQpwBZxXJV/JVRF/uNfyMSdu7YWwRNLM8+2xbniGp2iIQHOikPpTYQjlQgMi1uvq1kZpJ32rHo3hkwjy2l0lFwr3u4Hk2Wk7vnsqYQjAlYlK0TCzjpmiI+OiPOUNVtbWHQiLiVqFtzvpvi4AU7C1iKGvc/4IS45WjHxeScHhnZZ7njS4S1UgNP/GflRIbzgbBhyZ9kEW5/OO5YfG1fy6r4KSlDJw4o/mw5XhftyIpL+5ZBVBC6E1EIiP/dd9AbK62VV1PByfPMHMixpxI3GM2qwcmFsXcCcgvUXJBa9k6zP8dDQ3csCM2QNT+CQAOxthjtp/TFWaD7MzOdsIYb3THwIDAQAB";
    public static final String SEARCH_DOUBLE_FOLLOW_LIST = "c/u/user/search_double_follows";
    public static final String defaultUrl;
    public static int[] reconStrategy = null;
    public static final BdAsyncTaskParallel sBdAsyncTaskParallel;
    public static String url = null;
    public static final String wsExtensions = "im_version=2.3";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2142249705, "Lcom/baidu/tbadk/TiebaIMConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2142249705, "Lcom/baidu/tbadk/TiebaIMConfig;");
                return;
            }
        }
        IM_ASYCTASK_UNIQUEID = BdUniqueId.gen();
        sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, IM_ASYCTASK_UNIQUEID);
        String c = zoa.c(AppRuntime.getAppContext(), "LCS_SERVER_ADDR");
        defaultUrl = c;
        url = c;
        reconStrategy = new int[]{30, 60, 300, 600, 1800, 3600, 7200, 14400};
        POST_IMAGE_PATH = "post_image";
        POST_IMAGE_DEFAULT_WIDTH = 30;
        POST_IMAGE_DEFAULT_HEIGHT = 30;
        NEW_UPLOAD_PIC_SERVER = "c/i/msgcenter/uploadPic";
        IM_GROUP_SHARE_URL = TbConfig.TIEBA_ADDRESS + "group/index?id=";
    }

    public TiebaIMConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BdAsyncTaskParallel getParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return sBdAsyncTaskParallel;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    public static byte[] getRSAPublicKey() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return xh.d(PUBLIC_KEY_BASE64);
        }
        return (byte[]) invokeV.objValue;
    }

    public static int getMaxChatImageWidthInPx(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return BdUtilHelper.dip2px(context, 300.0f);
        }
        return invokeL.intValue;
    }
}

package com.baidu.live.tbadk;

import android.content.Context;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.lib.asynctask.BdAsyncTaskParallel;
import com.baidu.live.adp.lib.util.Base64;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.io.IOException;
/* loaded from: classes10.dex */
public class TiebaIMConfig {
    public static final String GET_DOUBLE_FOLLOW_LIST = "c/u/user/get_double_follows";
    public static final int MAX_IMAGES_IN_GROUP_GALLARY = 1000;
    public static final String PROTOBUF_VERSION = "1.0.3";
    private static final String PUBLIC_KEY_BASE64 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwQpwBZxXJV/JVRF/uNfyMSdu7YWwRNLM8+2xbniGp2iIQHOikPpTYQjlQgMi1uvq1kZpJ32rHo3hkwjy2l0lFwr3u4Hk2Wk7vnsqYQjAlYlK0TCzjpmiI+OiPOUNVtbWHQiLiVqFtzvpvi4AU7C1iKGvc/4IS45WjHxeScHhnZZ7njS4S1UgNP/GflRIbzgbBhyZ9kEW5/OO5YfG1fy6r4KSlDJw4o/mw5XhftyIpL+5ZBVBC6E1EIiP/dd9AbK62VV1PByfPMHMixpxI3GM2qwcmFsXcCcgvUXJBa9k6zP8dDQ3csCM2QNT+CQAOxthjtp/TFWaD7MzOdsIYb3THwIDAQAB";
    public static final String SEARCH_DOUBLE_FOLLOW_LIST = "c/u/user/search_double_follows";
    public static final String defaultUrl = "ws://im.tieba.baidu.com:8000";
    public static final String wsExtensions = "im_version=2.3";
    public static final BdUniqueId IM_ASYCTASK_UNIQUEID = BdUniqueId.gen();
    private static final BdAsyncTaskParallel sBdAsyncTaskParallel = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, IM_ASYCTASK_UNIQUEID);
    public static String url = "ws://im.tieba.baidu.com:8000";
    public static int[] reconStrategy = {30, 60, 300, 600, 1800, SdkConfigData.DEFAULT_REQUEST_INTERVAL, 7200, 14400};
    public static String POST_IMAGE_PATH = "post_image";
    public static int POST_IMAGE_DEFAULT_WIDTH = 30;
    public static int POST_IMAGE_DEFAULT_HEIGHT = 30;
    public static String NEW_UPLOAD_PIC_SERVER = "c/i/msgcenter/uploadPic";
    public static String IM_GROUP_SHARE_URL = "http://tieba.baidu.com/group/index?id=";

    public static byte[] getRSAPublicKey() throws IOException {
        return Base64.decode(PUBLIC_KEY_BASE64);
    }

    public static int getMaxChatImageWidthInPx(Context context) {
        return BdUtilHelper.dip2px(context, 300.0f);
    }

    public static BdAsyncTaskParallel getParallel() {
        return sBdAsyncTaskParallel;
    }
}

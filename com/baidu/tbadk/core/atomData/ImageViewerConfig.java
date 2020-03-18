package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.a.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class ImageViewerConfig extends IntentConfig {
    public static final String ABTEST = "abtest";
    public static final String ACCOUNT_BDUSS = "account_bduss";
    public static final String ACCOUNT_STOKEN = "account_stoken";
    public static final String ACCOUNT_TBS = "account_tbs";
    public static final String ASSIST_URLS = "assist_urls";
    public static final String DATA_NOT_VALID = "data_not_valid";
    public static final String DATA_VALID = "data_valid";
    public static final String FORUM_ID = "fid";
    public static final String FORUM_NAME = "fname";
    public static final String FROM_CONCERN = "concern";
    public static final String FROM_DISCOVER_BEAUTY = "discover_beauty";
    public static final String FROM_FRS = "frs";
    public static final String FROM_GAME_VIDEO = "game_video";
    public static final String FROM_HOME = "index";
    public static final String FROM_OTHER = "other";
    public static final String FROM_PB = "pb";
    public static final String FROM_PORTRAIT = "portrait";
    public static final String FROM_VIDEO_TAB = "video_tab";
    public static final String INDEX = "index";
    public static final String IS_BJH = "is_bjh";
    public static final String IS_CAN_DRAG = "is_can_drag";
    public static final String IS_DATA_VALID = "is_data_valid";
    public static final String IS_DYNAMIC_CARD = "is_dynamic_card";
    public static final String IS_FROM_AI_APP = "is_from_ai_app";
    public static final String IS_GODREPLY_IMAGE = "is_godreply_image";
    public static final String IS_IDENTIFY_IMAGE = "is_identify_image";
    public static final String IS_LOGIN = "is_login";
    public static final String IS_PV = "is_pv";
    public static final String IS_SHOW_AD = "is_show_ad";
    public static final String IS_SHOW_BOTTOM_CONTAINER = "is_show_bottom_container";
    public static final String IS_SHOW_HOST = "is_show_host";
    public static final String LAST_ID = "last_id";
    public static final String NEED_BROADCAST = "need_broadcast";
    public static final String PARAM_IS_CDN = "isCdn";
    public static final String PV_TYPE = "pv_type";
    public static final String REVERSE_MODE = "reverse_mode";
    public static final String SEE_HOST = "see_host";
    public static final String START_ACTIVITY_NORMAL = "start_activity_normal";
    public static final String START_ACTIVITY_TYPE = "start_activity_type";
    public static final String THREAD_ID = "tid";
    public static final String THREAD_TYPE = "thread_type";
    public static final String URL = "url";
    public static final String USER_ID = "user_id";

    public ImageViewerConfig(Context context) {
        super(context);
    }

    public ImageViewerConfig createConfig(ArrayList<String> arrayList, int i, String str, String str2, String str3, boolean z, String str4, boolean z2, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap, boolean z3, boolean z4, boolean z5) {
        ImageUrlData imageUrlData;
        Intent intent = getIntent();
        intent.putExtra("abtest", b.rG("picpage_content_clear"));
        intent.putExtra(START_ACTIVITY_TYPE, START_ACTIVITY_NORMAL);
        if (arrayList != null && arrayList.size() > 0) {
            intent.putExtra(IS_DATA_VALID, DATA_VALID);
            intent.putStringArrayListExtra("url", arrayList);
            intent.putExtra("index", i);
            intent.putExtra("is_pv", true);
            intent.putExtra(PV_TYPE, "pb");
            intent.putExtra(PARAM_IS_CDN, z);
            intent.putExtra("fname", str);
            intent.putExtra("fid", str2);
            intent.putExtra("tid", str3);
            intent.putExtra(LAST_ID, str4);
            intent.putExtra(REVERSE_MODE, z2);
            intent.putExtra(ASSIST_URLS, concurrentHashMap);
            intent.putExtra(IS_SHOW_AD, z3);
            intent.putExtra(NEED_BROADCAST, z4);
            intent.putExtra(SEE_HOST, z5);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str5 = arrayList.get(i2);
                if (!StringUtils.isNull(str5)) {
                    ImageUrlData imageUrlData2 = null;
                    if (concurrentHashMap != null) {
                        imageUrlData2 = concurrentHashMap.get(str5);
                    }
                    if (imageUrlData2 == null) {
                        ImageUrlData imageUrlData3 = new ImageUrlData();
                        imageUrlData3.imageUrl = str5;
                        imageUrlData = imageUrlData3;
                    } else {
                        imageUrlData = imageUrlData2;
                    }
                    imageUrlData.overAllIndex = i2 + 1;
                }
            }
            TbadkCoreApplication.getInst();
            intent.putExtra(IS_LOGIN, TbadkCoreApplication.isLogin());
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                intent.putExtra("user_id", currentAccountObj.getID());
                intent.putExtra(ACCOUNT_BDUSS, currentAccountObj.getBDUSS());
                intent.putExtra(ACCOUNT_STOKEN, currentAccountObj.getStoken());
                intent.putExtra(ACCOUNT_TBS, currentAccountObj.getTbs());
            }
        } else {
            intent.putExtra(IS_DATA_VALID, DATA_NOT_VALID);
        }
        return this;
    }

    public ImageViewerConfig createConfig(ArrayList<String> arrayList, int i, String str, String str2, String str3, boolean z, String str4, boolean z2, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap, boolean z3) {
        return createConfig(arrayList, i, str, str2, str3, z, str4, z2, concurrentHashMap, z3, false, true);
    }

    public ImageViewerConfig createConfig(ArrayList<String> arrayList, int i, String str, String str2, String str3, boolean z, String str4, boolean z2) {
        return createConfig(arrayList, i, str, str2, str3, z, str4, z2, null, false, false, true);
    }

    public ImageViewerConfig setIsCanDrag(boolean z) {
        getIntent().putExtra(IS_CAN_DRAG, z);
        return this;
    }

    public ImageViewerConfig setIsShowHost(boolean z) {
        getIntent().putExtra(IS_SHOW_HOST, z);
        return this;
    }

    public ImageViewerConfig makeDynamicCard() {
        getIntent().putExtra(IS_DYNAMIC_CARD, true);
        getIntent().putExtra(IS_SHOW_BOTTOM_CONTAINER, false);
        getIntent().putExtra(IS_SHOW_HOST, false);
        return this;
    }

    public ImageViewerConfig setSrcRectInScreen(Rect rect, RectF rectF) {
        if (rect == null || rectF == null) {
            return null;
        }
        int i = 0;
        if (!UtilHelper.canUseStyleImmersiveSticky()) {
            i = UtilHelper.getStatusBarHeight();
        }
        JSONArray jSONArray = new JSONArray();
        try {
            jSONArray.put((int) rectF.left);
            jSONArray.put((int) (rectF.top - i));
            jSONArray.put((int) rectF.right);
            jSONArray.put((int) (rectF.bottom - i));
            jSONArray.put(rect.left);
            jSONArray.put(rect.top - i);
            jSONArray.put(rect.right);
            jSONArray.put(rect.bottom - i);
            getIntent().putExtra("source_rect_in_screen", jSONArray.toString());
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ImageViewerConfig setIsIdentifyImage(boolean z) {
        getIntent().putExtra(IS_IDENTIFY_IMAGE, z);
        return this;
    }

    public ImageViewerConfig setIsFromAiApp(boolean z) {
        getIntent().putExtra(IS_FROM_AI_APP, z);
        return this;
    }

    public ImageViewerConfig setThreadType(int i) {
        if (i >= 0) {
            getIntent().putExtra("thread_type", i);
        }
        return this;
    }

    public ImageViewerConfig setThreadData(bj bjVar) {
        Intent intent = getIntent();
        if (bjVar != null && intent != null) {
            intent.putExtra(IS_BJH, bjVar.aEm());
            if (bjVar.aEm()) {
                intent.putExtra(PARAM_IS_CDN, true);
            }
        }
        return this;
    }

    public ImageViewerConfig setPostId(String str) {
        if (!TextUtils.isEmpty(str)) {
            getIntent().putExtra("post_id", str);
        }
        return this;
    }
}

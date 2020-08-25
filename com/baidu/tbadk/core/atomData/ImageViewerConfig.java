package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.switchs.IdentifyImageSwitch;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes2.dex */
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

    private ImageViewerConfig(Context context, a aVar) {
        super(context);
        Intent intent;
        ImageUrlData imageUrlData;
        if (aVar != null && (intent = getIntent()) != null) {
            intent.putExtra(START_ACTIVITY_TYPE, START_ACTIVITY_NORMAL);
            if (aVar.data != null && aVar.data.size() > 0) {
                intent.putExtra(IS_DATA_VALID, DATA_VALID);
                intent.putStringArrayListExtra("url", aVar.data);
                intent.putExtra("index", aVar.index);
                intent.putExtra("is_pv", true);
                intent.putExtra(PV_TYPE, "pb");
                intent.putExtra(PARAM_IS_CDN, aVar.dUM);
                intent.putExtra("fname", aVar.forumName);
                intent.putExtra("fid", aVar.forumId);
                intent.putExtra("tid", aVar.threadId);
                intent.putExtra(LAST_ID, aVar.lastId);
                intent.putExtra(REVERSE_MODE, aVar.dUN);
                intent.putExtra(ASSIST_URLS, aVar.dUO);
                intent.putExtra(IS_SHOW_AD, aVar.dUP);
                intent.putExtra(NEED_BROADCAST, aVar.dUQ);
                intent.putExtra(SEE_HOST, aVar.dUR);
                int size = aVar.data.size();
                for (int i = 0; i < size; i++) {
                    String str = (String) aVar.data.get(i);
                    if (!StringUtils.isNull(str)) {
                        ImageUrlData imageUrlData2 = aVar.dUO != null ? (ImageUrlData) aVar.dUO.get(str) : null;
                        if (imageUrlData2 == null) {
                            ImageUrlData imageUrlData3 = new ImageUrlData();
                            imageUrlData3.imageUrl = str;
                            imageUrlData = imageUrlData3;
                        } else {
                            imageUrlData = imageUrlData2;
                        }
                        imageUrlData.overAllIndex = i + 1;
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
            if (aVar.dUS != null) {
                intent.putExtra(IS_BJH, aVar.dUS.bdo());
                if (aVar.dUS.bdo()) {
                    intent.putExtra(PARAM_IS_CDN, true);
                }
                intent.putExtra("nid", aVar.dUS.getNid());
                intent.putExtra(IntentConfig.CARD_TYPE, aVar.dUS.bgD());
                intent.putExtra(IntentConfig.RECOM_SOURCE, aVar.dUS.mRecomSource);
                intent.putExtra("ab_tag", aVar.dUS.mRecomAbTag);
                intent.putExtra("weight", aVar.dUS.mRecomWeight);
                intent.putExtra("extra", aVar.dUS.mRecomExtra);
            }
            if (!TextUtils.isEmpty(aVar.postId)) {
                intent.putExtra("post_id", aVar.postId);
            }
            intent.putExtra(IS_CAN_DRAG, aVar.dUU);
            if (aVar.dUV != null && aVar.dUW != null) {
                int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((int) aVar.dUW.left);
                jSONArray.put((int) (aVar.dUW.top - statusBarHeight));
                jSONArray.put((int) aVar.dUW.right);
                jSONArray.put((int) (aVar.dUW.bottom - statusBarHeight));
                jSONArray.put(aVar.dUV.left);
                jSONArray.put(aVar.dUV.top - statusBarHeight);
                jSONArray.put(aVar.dUV.right);
                jSONArray.put(aVar.dUV.bottom - statusBarHeight);
                intent.putExtra("source_rect_in_screen", jSONArray.toString());
            }
            intent.putExtra(IS_SHOW_HOST, aVar.dUX);
            if (aVar.dUY) {
                intent.putExtra(IS_DYNAMIC_CARD, true);
                intent.putExtra(IS_SHOW_BOTTOM_CONTAINER, false);
                intent.putExtra(IS_SHOW_HOST, false);
            }
            intent.putExtra(IS_IDENTIFY_IMAGE, IdentifyImageSwitch.isOn());
            intent.putExtra(IS_FROM_AI_APP, aVar.dUZ);
            intent.putExtra("from_forum_id", aVar.dUT);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private boolean dUM;
        private boolean dUN;
        private ConcurrentHashMap<String, ImageUrlData> dUO;
        private boolean dUP;
        private boolean dUQ;
        private bw dUS;
        private String dUT;
        private Rect dUV;
        private RectF dUW;
        private boolean dUY;
        private boolean dUZ;
        private ArrayList<String> data;
        private String forumName;
        private String lastId;
        private String postId;
        private int index = 0;
        private String forumId = "";
        private String threadId = "";
        private boolean dUR = false;
        private boolean dUU = true;
        private boolean dUX = true;

        public a x(ArrayList<String> arrayList) {
            this.data = arrayList;
            return this;
        }

        public a mM(int i) {
            this.index = i;
            return this;
        }

        public a yP(String str) {
            this.forumName = str;
            return this;
        }

        public a yQ(String str) {
            this.forumId = str;
            return this;
        }

        public a yR(String str) {
            this.threadId = str;
            return this;
        }

        public a hH(boolean z) {
            this.dUM = z;
            return this;
        }

        public a yS(String str) {
            this.lastId = str;
            return this;
        }

        public a hI(boolean z) {
            this.dUN = z;
            return this;
        }

        public a a(ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
            this.dUO = concurrentHashMap;
            return this;
        }

        public a hJ(boolean z) {
            this.dUP = z;
            return this;
        }

        public a hK(boolean z) {
            this.dUQ = z;
            return this;
        }

        public a hL(boolean z) {
            this.dUR = z;
            return this;
        }

        public a r(bw bwVar) {
            this.dUS = bwVar;
            return this;
        }

        public a yT(String str) {
            this.postId = str;
            return this;
        }

        public a hM(boolean z) {
            this.dUU = z;
            return this;
        }

        public a a(Rect rect, RectF rectF) {
            this.dUV = rect;
            this.dUW = rectF;
            return this;
        }

        public a hN(boolean z) {
            this.dUX = z;
            return this;
        }

        public a hO(boolean z) {
            this.dUY = z;
            return this;
        }

        public a hP(boolean z) {
            this.dUZ = z;
            return this;
        }

        public a yU(String str) {
            this.dUT = str;
            return this;
        }

        public ImageViewerConfig dP(Context context) {
            return new ImageViewerConfig(context, this);
        }
    }
}

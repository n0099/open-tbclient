package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.switchs.IdentifyImageSwitch;
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
    public static final String FROM_HOT_TOPIC = "hot_topic";
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
    public static final String SKIN_TYPE = "skin_type";
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
                intent.putExtra(PARAM_IS_CDN, aVar.eLl);
                intent.putExtra("fname", aVar.forumName);
                intent.putExtra("fid", aVar.forumId);
                intent.putExtra("tid", aVar.threadId);
                intent.putExtra(LAST_ID, aVar.lastId);
                intent.putExtra(REVERSE_MODE, aVar.eLm);
                intent.putExtra(ASSIST_URLS, aVar.eLn);
                intent.putExtra(IS_SHOW_AD, aVar.eLo);
                intent.putExtra(NEED_BROADCAST, aVar.eLp);
                intent.putExtra(SEE_HOST, aVar.eLq);
                int size = aVar.data.size();
                for (int i = 0; i < size; i++) {
                    String str = (String) aVar.data.get(i);
                    if (!StringUtils.isNull(str)) {
                        ImageUrlData imageUrlData2 = aVar.eLn != null ? (ImageUrlData) aVar.eLn.get(str) : null;
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
            if (aVar.eLr != null) {
                intent.putExtra(IS_BJH, aVar.eLr.bmB());
                if (aVar.eLr.bmB()) {
                    intent.putExtra(PARAM_IS_CDN, true);
                }
                intent.putExtra(IntentConfig.NID, aVar.eLr.bmq());
                intent.putExtra(IntentConfig.CARD_TYPE, aVar.eLr.bpT());
                intent.putExtra(IntentConfig.RECOM_SOURCE, aVar.eLr.mRecomSource);
                intent.putExtra("ab_tag", aVar.eLr.mRecomAbTag);
                intent.putExtra("weight", aVar.eLr.mRecomWeight);
                intent.putExtra("extra", aVar.eLr.mRecomExtra);
            }
            if (!TextUtils.isEmpty(aVar.postId)) {
                intent.putExtra("post_id", aVar.postId);
            }
            intent.putExtra(IS_CAN_DRAG, aVar.eLt);
            if (aVar.eLu != null && aVar.eLv != null) {
                int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((int) aVar.eLv.left);
                jSONArray.put((int) (aVar.eLv.top - statusBarHeight));
                jSONArray.put((int) aVar.eLv.right);
                jSONArray.put((int) (aVar.eLv.bottom - statusBarHeight));
                jSONArray.put(aVar.eLu.left);
                jSONArray.put(aVar.eLu.top - statusBarHeight);
                jSONArray.put(aVar.eLu.right);
                jSONArray.put(aVar.eLu.bottom - statusBarHeight);
                intent.putExtra("source_rect_in_screen", jSONArray.toString());
            }
            intent.putExtra(IS_SHOW_HOST, aVar.eLw);
            if (aVar.eLx) {
                intent.putExtra(IS_DYNAMIC_CARD, true);
                intent.putExtra(IS_SHOW_BOTTOM_CONTAINER, false);
                intent.putExtra(IS_SHOW_HOST, false);
            }
            intent.putExtra(IS_IDENTIFY_IMAGE, IdentifyImageSwitch.isOn());
            intent.putExtra(IS_FROM_AI_APP, aVar.eLy);
            intent.putExtra("from_forum_id", aVar.eLs);
            intent.putExtra("skin_type", TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* loaded from: classes.dex */
    public static final class a {
        private ArrayList<String> data;
        private boolean eLl;
        private boolean eLm;
        private ConcurrentHashMap<String, ImageUrlData> eLn;
        private boolean eLo;
        private boolean eLp;
        private cb eLr;
        private String eLs;
        private Rect eLu;
        private RectF eLv;
        private boolean eLx;
        private boolean eLy;
        private String forumName;
        private String lastId;
        private String postId;
        private int index = 0;
        private String forumId = "";
        private String threadId = "";
        private boolean eLq = false;
        private boolean eLt = true;
        private boolean eLw = true;

        public a s(ArrayList<String> arrayList) {
            this.data = arrayList;
            return this;
        }

        public a mR(int i) {
            this.index = i;
            return this;
        }

        public a zQ(String str) {
            this.forumName = str;
            return this;
        }

        public a zR(String str) {
            this.forumId = str;
            return this;
        }

        public a zS(String str) {
            this.threadId = str;
            return this;
        }

        public a jg(boolean z) {
            this.eLl = z;
            return this;
        }

        public a zT(String str) {
            this.lastId = str;
            return this;
        }

        public a jh(boolean z) {
            this.eLm = z;
            return this;
        }

        public a d(ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
            this.eLn = concurrentHashMap;
            return this;
        }

        public a ji(boolean z) {
            this.eLo = z;
            return this;
        }

        public a jj(boolean z) {
            this.eLp = z;
            return this;
        }

        public a jk(boolean z) {
            this.eLq = z;
            return this;
        }

        public a s(cb cbVar) {
            this.eLr = cbVar;
            return this;
        }

        public a zU(String str) {
            this.postId = str;
            return this;
        }

        public a jl(boolean z) {
            this.eLt = z;
            return this;
        }

        public a a(Rect rect, RectF rectF) {
            this.eLu = rect;
            this.eLv = rectF;
            return this;
        }

        public a jm(boolean z) {
            this.eLw = z;
            return this;
        }

        public a jn(boolean z) {
            this.eLx = z;
            return this;
        }

        public a jo(boolean z) {
            this.eLy = z;
            return this;
        }

        public a zV(String str) {
            this.eLs = str;
            return this;
        }

        public ImageViewerConfig eO(Context context) {
            return new ImageViewerConfig(context, this);
        }
    }
}

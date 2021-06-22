package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.switchs.IdentifyImageSwitch;
import d.a.n0.c1.b.e;
import d.a.n0.r.q.a2;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes3.dex */
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
    public static final String IS_VIDEO_WORKS_INFO = "is_video_works_info";
    public static final String IS_YOUNGSTER_MODE = "is_youngster_mode";
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

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f12166a;

        /* renamed from: c  reason: collision with root package name */
        public String f12168c;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12171f;

        /* renamed from: g  reason: collision with root package name */
        public String f12172g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f12173h;

        /* renamed from: i  reason: collision with root package name */
        public ConcurrentHashMap<String, ImageUrlData> f12174i;
        public boolean j;
        public boolean k;
        public a2 m;
        public String n;
        public String o;
        public Rect q;
        public RectF r;
        public boolean t;
        public boolean u;

        /* renamed from: b  reason: collision with root package name */
        public int f12167b = 0;

        /* renamed from: d  reason: collision with root package name */
        public String f12169d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f12170e = "";
        public boolean l = false;
        public boolean p = true;
        public boolean s = true;

        public b A(String str) {
            this.n = str;
            return this;
        }

        public b B(int i2) {
            this.f12167b = i2;
            return this;
        }

        public b C(boolean z) {
            this.f12171f = z;
            return this;
        }

        public b D(boolean z) {
            this.p = z;
            return this;
        }

        public b E(boolean z) {
            this.t = z;
            return this;
        }

        public b F(boolean z) {
            this.f12173h = z;
            return this;
        }

        public b G(boolean z) {
            this.l = z;
            return this;
        }

        public b H(boolean z) {
            this.j = z;
            return this;
        }

        public b I(boolean z) {
            this.s = z;
            return this;
        }

        public b J(String str) {
            this.f12172g = str;
            return this;
        }

        public b K(boolean z) {
            this.k = z;
            return this;
        }

        public b L(String str) {
            this.o = str;
            return this;
        }

        public b M(Rect rect, RectF rectF) {
            this.q = rect;
            this.r = rectF;
            return this;
        }

        public b N(a2 a2Var) {
            this.m = a2Var;
            return this;
        }

        public b O(String str) {
            this.f12170e = str;
            return this;
        }

        public ImageViewerConfig v(Context context) {
            return new ImageViewerConfig(context, this);
        }

        public b w(ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
            this.f12174i = concurrentHashMap;
            return this;
        }

        public b x(ArrayList<String> arrayList) {
            this.f12166a = arrayList;
            return this;
        }

        public b y(String str) {
            this.f12169d = str;
            return this;
        }

        public b z(String str) {
            this.f12168c = str;
            return this;
        }
    }

    public ImageViewerConfig(Context context, b bVar) {
        super(context);
        Intent intent;
        if (bVar == null || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(START_ACTIVITY_TYPE, START_ACTIVITY_NORMAL);
        if (bVar.f12166a != null && bVar.f12166a.size() > 0) {
            intent.putExtra(IS_DATA_VALID, DATA_VALID);
            intent.putStringArrayListExtra("url", bVar.f12166a);
            intent.putExtra("index", bVar.f12167b);
            intent.putExtra("is_pv", true);
            intent.putExtra(PV_TYPE, "pb");
            intent.putExtra(PARAM_IS_CDN, bVar.f12171f);
            intent.putExtra("fname", bVar.f12168c);
            intent.putExtra("fid", bVar.f12169d);
            intent.putExtra("tid", bVar.f12170e);
            intent.putExtra(LAST_ID, bVar.f12172g);
            intent.putExtra(REVERSE_MODE, bVar.f12173h);
            intent.putExtra(ASSIST_URLS, bVar.f12174i);
            intent.putExtra(IS_SHOW_AD, bVar.j);
            intent.putExtra(NEED_BROADCAST, bVar.k);
            intent.putExtra(SEE_HOST, bVar.l);
            int size = bVar.f12166a.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = (String) bVar.f12166a.get(i2);
                if (!StringUtils.isNull(str)) {
                    ImageUrlData imageUrlData = bVar.f12174i != null ? (ImageUrlData) bVar.f12174i.get(str) : null;
                    if (imageUrlData == null) {
                        imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = str;
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
        if (bVar.m != null) {
            intent.putExtra(IS_BJH, bVar.m.C2());
            if (bVar.m.C2()) {
                intent.putExtra(PARAM_IS_CDN, true);
            }
            intent.putExtra("nid", bVar.m.M0());
            intent.putExtra("card_type", bVar.m.W0());
            intent.putExtra("recom_source", bVar.m.T0);
            intent.putExtra("ab_tag", bVar.m.V0);
            intent.putExtra("weight", bVar.m.U0);
            intent.putExtra("extra", bVar.m.W0);
            if (bVar.m.E2()) {
                intent.putExtra(IS_VIDEO_WORKS_INFO, true);
            }
        }
        if (!TextUtils.isEmpty(bVar.o)) {
            intent.putExtra("post_id", bVar.o);
        }
        intent.putExtra(IS_CAN_DRAG, bVar.p);
        if (bVar.q != null && bVar.r != null) {
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? UtilHelper.getStatusBarHeight() : 0;
            JSONArray jSONArray = new JSONArray();
            jSONArray.put((int) bVar.r.left);
            float f2 = statusBarHeight;
            jSONArray.put((int) (bVar.r.top - f2));
            jSONArray.put((int) bVar.r.right);
            jSONArray.put((int) (bVar.r.bottom - f2));
            jSONArray.put(bVar.q.left);
            jSONArray.put(bVar.q.top - statusBarHeight);
            jSONArray.put(bVar.q.right);
            jSONArray.put(bVar.q.bottom - statusBarHeight);
            intent.putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, jSONArray.toString());
        }
        intent.putExtra(IS_SHOW_HOST, bVar.s);
        if (bVar.t) {
            intent.putExtra(IS_DYNAMIC_CARD, true);
            intent.putExtra(IS_SHOW_BOTTOM_CONTAINER, false);
            intent.putExtra(IS_SHOW_HOST, false);
        }
        intent.putExtra(IS_IDENTIFY_IMAGE, IdentifyImageSwitch.isOn());
        intent.putExtra(IS_FROM_AI_APP, bVar.u);
        intent.putExtra("from_forum_id", bVar.n);
        intent.putExtra("skin_type", TbadkCoreApplication.getInst().getSkinType());
        intent.putExtra(IS_YOUNGSTER_MODE, e.d());
    }
}

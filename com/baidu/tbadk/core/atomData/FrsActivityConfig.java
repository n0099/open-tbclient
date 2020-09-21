package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.ac;
import com.baidu.tieba.frs.f.i;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class FrsActivityConfig extends IntentConfig {
    public static final String ALA_IS_ONLIVING = "ala_is_living";
    public static final String BACK_SPECIAL = "back_special";
    public static final String FLAG = "flag";
    public static final String FOLLOWED_HAS_NEW = "followed_has_new";
    public static final String FROM = "from";
    public static final String FROM_PB_OR_PERSON = "from_pb_or_person";
    public static final String FROM_SHORT_CUT = "from_short_cut";
    public static final String FRS_CALL_FROM = "frs_call_from";
    public static final int FRS_CALL_FROM_ENTERFORUM_FREQUENTLY = 4;
    public static final int FRS_CALL_FROM_ENTERFORUM_LIKE = 3;
    public static final int FRS_CALL_FROM_ENTER_FORUM_BUTTON = 14;
    public static final int FRS_CALL_FROM_HOME_LIVE_TAB = 15;
    public static final int FRS_CALL_FROM_ONE_KEY_SIGN = 6;
    public static final int FRS_CALL_FROM_PERSON_GUEST_LIKE = 9;
    public static final int FRS_CALL_FROM_PERSON_GUEST_SAME_FORUM = 8;
    public static final int FRS_CALL_FROM_PERSON_HOST = 7;
    public static final int FRS_CALL_FROM_PUSH = 13;
    public static final int FRS_CALL_FROM_SQUARE = 5;
    public static final int FRS_CALL_FROM_TAB_RECOMMEND = 11;
    public static final int FRS_CALL_FROM_URL_JUMP = 12;
    public static final String FRS_CALL_SEARCH = "frs_call_search";
    public static final String FRS_CREATE_WITH_GAME = "create_with_game";
    public static final String FRS_FAKE_THREAD_ID = "frs_fake_thread_id";
    public static final String FRS_FROM_ENTERFORUM_RECOMMEND = "recom_flist";
    public static final String FRS_FROM_FLUTTER_BCASTEDIT = "bar_broadcast_edit";
    public static final String FRS_FROM_FOLLOWED_RECOMMEND = "followed_recommend_forumlist";
    public static final String FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD = "frequently_forum_new_thread";
    public static final String FRS_FROM_FREQUENTLY_FORUM_POST_THREAD = "frequently_forum_post_thread";
    public static final String FRS_FROM_MANGA_COVER = "form_manga_cover";
    public static final String FRS_FROM_PB = "tb_pb";
    public static final String FRS_FROM_RECENTLY_VISITED = "from_recently_visited";
    public static final String FRS_FROM_RECOMMEND = "dimension_door";
    public static final String FRS_FROM_RECOMMEND_BAR_CAR = "recommend_bar_card_forum";
    public static final String FRS_FROM_SEARCH = "tb_searchlist";
    public static final String FRS_FROM_SQUARE = "from_square";
    public static final String FRS_FROM_SQUARE_HOT = "from_square_hot";
    public static final String FRS_FROM_SQUARE_RECOMMEND = "from_square_recommend";
    public static final String FRS_FROM_SQUARE_TOP = "from_square_top";
    public static final String FRS_FROM_TAB_RECOMMEND_FORUM = "tab_recommend_forum";
    public static final String FRS_FROM_WRITESHARE = "tb_write_share";
    public static final String FRS_GAME_DEFAULT_TAB_ID = "frs_game_default_tab_id";
    public static final String FRS_HOT_THREAD_ID = "frs_hot_thread_id";
    public static final String FRS_PAGE_ID = "frs_page_id";
    public static final String FRS_PB_CARD_GIFT = "tb_pb_card_gift";
    public static final String GOOD = "good";
    public static final String KEY_ACHIEVEMENT_URL = "key_achievement_url";
    public static final String KEY_REFRESH = "refresh_all";
    public static final String NAME = "name";
    public static final int READ_CHAT = 1;
    public static final int READ_REPLYORAT = 0;
    public static final String YUELAOU_LOCATE = "yuelaou_locate";
    private BdUniqueId mPageId;

    public FrsActivityConfig(Context context) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        this.mPageId = BdUniqueId.gen();
        intent.putExtra(FRS_PAGE_ID, this.mPageId);
    }

    public FrsActivityConfig createNormalCfg(String str, String str2) {
        return createBackSpecialCfg(str, str2, false, false);
    }

    public FrsActivityConfig createJumpLiveTabCfg(String str, String str2, boolean z) {
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra("back_special", false);
        intent.putExtra(GOOD, false);
        intent.putExtra(FOLLOWED_HAS_NEW, false);
        intent.putExtra(ALA_IS_ONLIVING, z);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return this;
    }

    public FrsActivityConfig createNormalCfg(String str, String str2, boolean z) {
        return createBackSpecialCfg(str, str2, false, false, z);
    }

    public FrsActivityConfig createCfgForpersonalized(String str, String str2, String str3) {
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra("back_special", false);
        intent.putExtra(GOOD, false);
        intent.putExtra("yuelaou_locate", str3);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return this;
    }

    public FrsActivityConfig createBackSpecialCfg(String str, String str2, boolean z, boolean z2) {
        return createBackSpecialCfg(str, str2, z, z2, false);
    }

    public FrsActivityConfig createBackSpecialCfg(String str, String str2, boolean z, boolean z2, boolean z3) {
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra("back_special", z);
        intent.putExtra(GOOD, z2);
        intent.putExtra(FOLLOWED_HAS_NEW, z3);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        return this;
    }

    public FrsActivityConfig setDefaultGameTabId(int i) {
        getIntent().putExtra(FRS_GAME_DEFAULT_TAB_ID, i);
        return this;
    }

    public FrsActivityConfig setCallFrom(int i) {
        getIntent().putExtra(FRS_CALL_FROM, i);
        return this;
    }

    public FrsActivityConfig setFakeThreadId(long j) {
        getIntent().putExtra(FRS_FAKE_THREAD_ID, j);
        return this;
    }

    public void setUri(Uri uri) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }

    public void setAchievementUrl(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_ACHIEVEMENT_URL, str);
        }
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public void preJump() {
        AccountData currentAccountObj;
        int Jv;
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("name");
        String stringExtra2 = intent.getStringExtra("from");
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        if (uri != null) {
            stringExtra = uri.getQueryParameter("name");
            stringExtra2 = uri.getQueryParameter("from");
            if (StringUtils.isNull(stringExtra)) {
                stringExtra = uri.getQueryParameter("kw");
            }
        }
        int intExtra = intent.getIntExtra(FRS_CALL_FROM, 0);
        long longExtra = intent.getLongExtra(FRS_HOT_THREAD_ID, 0L);
        String stringExtra3 = intent.getStringExtra("yuelaou_locate");
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = "";
        }
        FrsRequestData frsRequestData = new FrsRequestData();
        if (FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(stringExtra2)) {
            Jv = 3;
        } else if (FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(stringExtra2)) {
            Jv = 6;
        } else {
            String str = "";
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                str = currentAccountObj.getID() + Constants.WAVE_SEPARATOR;
            }
            Jv = i.Jv("1~" + str + stringExtra);
        }
        frsRequestData.setSortType(i.zf(Jv));
        if (Jv == 5) {
            frsRequestData.setIsGood(1);
        } else {
            frsRequestData.setIsGood(0);
        }
        frsRequestData.gc("forum_name", k.getUrlEncode(stringExtra));
        frsRequestData.gc("client_type", "2");
        frsRequestData.setPn(1);
        frsRequestData.setCallFrom(intExtra);
        i.a(Jv, frsRequestData);
        frsRequestData.Rd("2");
        frsRequestData.setObjSource("-2");
        frsRequestData.setKw(stringExtra);
        frsRequestData.setWithGroup(1);
        frsRequestData.setCid(0);
        frsRequestData.setScrW(l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        frsRequestData.setScrH(l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        frsRequestData.setScrDip(l.getEquipmentDensity(TbadkCoreApplication.getInst()));
        frsRequestData.setqType(au.bkm().bkn() ? 2 : 1);
        if (uri != null) {
            frsRequestData.setSchemeUrl(uri.toString());
        }
        frsRequestData.setLastId(null);
        frsRequestData.setYuelaouLocate(stringExtra3);
        frsRequestData.setLastClickTid(b.toLong(ac.bwS(), 0L));
        frsRequestData.setStType(stringExtra2);
        frsRequestData.In(1);
        frsRequestData.setNeedCache(true);
        frsRequestData.setUpdateType(3);
        frsRequestData.gj(longExtra);
        i.a(Jv, frsRequestData);
        frsRequestData.setLoadType(1);
        if (bw.edR.get() && r.dqU().dqO() != null) {
            int aT = r.dqU().dqO().aT(stringExtra, false);
            int aU = r.dqU().dqO().aU(stringExtra, false);
            if (frsRequestData.getLoadType() == 1) {
                aT++;
            } else if (frsRequestData.getLoadType() == 2) {
                aU++;
            }
            frsRequestData.setRefreshCount(aT);
            frsRequestData.setLoadCount(aU);
        }
        FrsNetModel frsNetModel = new FrsNetModel(null, frsRequestData);
        frsNetModel.setUniqueId(this.mPageId);
        frsNetModel.a((NetModel.b) frsNetModel);
        TbadkCoreApplication.getInst().getFrsModeArray().put(this.mPageId.getId(), frsNetModel);
        frsNetModel.loadData();
    }
}

package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import d.a.c.e.m.b;
import d.a.c.e.p.l;
import d.a.m0.b.d;
import d.a.m0.b.g.a;
import d.a.m0.r.q.a2;
import d.a.m0.z0.c0;
import d.a.n0.r0.n2.k;
import d.a.n0.t2.x;
/* loaded from: classes3.dex */
public class FrsActivityConfig extends IntentConfig {
    public static final String ALA_IS_ONLIVING = "ala_is_living";
    public static final String BACK_SPECIAL = "back_special";
    public static final String FLAG = "flag";
    public static final String FLAG_SHOW_AD = "fun_ad";
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
    public static final String FRS_FROM_FORUM_RULE_EDIT = "frs_from_forum_rule_edit";
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
    public BdUniqueId mPageId;

    public FrsActivityConfig(Context context) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        BdUniqueId gen = BdUniqueId.gen();
        this.mPageId = gen;
        intent.putExtra(FRS_PAGE_ID, gen);
    }

    public FrsActivityConfig createBackSpecialCfg(String str, String str2, boolean z, boolean z2) {
        return createBackSpecialCfg(str, str2, z, z2, false);
    }

    public FrsActivityConfig createCfgForpersonalized(String str, String str2, String str3) {
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra("back_special", false);
        intent.putExtra(GOOD, false);
        intent.putExtra("yuelaou_locate", str3);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        return this;
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
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        return this;
    }

    public FrsActivityConfig createNormalCfg(String str, String str2) {
        return createBackSpecialCfg(str, str2, false, false);
    }

    @Override // com.baidu.tbadk.core.frameworkData.IntentConfig
    public void preJump() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("name");
        String stringExtra2 = intent.getStringExtra("from");
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        if (uri != null) {
            stringExtra = uri.getQueryParameter("name");
            stringExtra2 = uri.getQueryParameter("from");
            if (StringUtils.isNull(stringExtra)) {
                stringExtra = uri.getQueryParameter(TiebaStatic.Params.H5_FORUM_NAME);
            }
        }
        int intExtra = intent.getIntExtra(FRS_CALL_FROM, 0);
        long longExtra = intent.getLongExtra(FRS_HOT_THREAD_ID, 0L);
        String stringExtra3 = intent.getStringExtra("yuelaou_locate");
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = "";
        }
        int i2 = -1;
        FrsRequestData frsRequestData = new FrsRequestData();
        if (FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD.equals(stringExtra2)) {
            i2 = 3;
        } else if (FRS_FROM_FREQUENTLY_FORUM_POST_THREAD.equals(stringExtra2)) {
            i2 = 6;
        }
        if (d.n() && a.f52562c != a.d()) {
            frsRequestData.H(k.d(a.d()));
        }
        frsRequestData.setSortType(k.d(i2));
        if (i2 == 5) {
            frsRequestData.K(1);
        } else {
            frsRequestData.K(0);
        }
        frsRequestData.w("forum_name", d.a.c.e.p.k.getUrlEncode(stringExtra));
        frsRequestData.w("client_type", "2");
        frsRequestData.setPn(1);
        frsRequestData.setCallFrom(intExtra);
        k.e(i2, frsRequestData);
        frsRequestData.S("2");
        frsRequestData.T("-2");
        frsRequestData.M(stringExtra);
        frsRequestData.Z(1);
        frsRequestData.E(0);
        frsRequestData.Y(l.k(TbadkCoreApplication.getInst()));
        frsRequestData.X(l.i(TbadkCoreApplication.getInst()));
        frsRequestData.W(l.h(TbadkCoreApplication.getInst()));
        frsRequestData.b0(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
        if (uri != null) {
            frsRequestData.V(uri.toString());
        }
        frsRequestData.O(null);
        frsRequestData.a0(stringExtra3);
        frsRequestData.N(b.f(c0.a(), 0L));
        frsRequestData.setStType(stringExtra2);
        frsRequestData.J(1);
        frsRequestData.setNeedCache(true);
        frsRequestData.setUpdateType(3);
        frsRequestData.I(longExtra);
        k.e(i2, frsRequestData);
        frsRequestData.Q(1);
        if (a2.z3.get() && x.p().b() != null) {
            int d2 = x.p().b().d(stringExtra, false);
            int e2 = x.p().b().e(stringExtra, false);
            if (frsRequestData.A() == 1) {
                d2++;
            } else if (frsRequestData.A() == 2) {
                e2++;
            }
            frsRequestData.U(d2);
            frsRequestData.P(e2);
        }
        FrsNetModel frsNetModel = new FrsNetModel(null, frsRequestData);
        frsNetModel.setUniqueId(this.mPageId);
        frsNetModel.Z(frsNetModel);
        TbadkCoreApplication.getInst().getFrsModeArray().put(this.mPageId.getId(), frsNetModel);
        frsNetModel.R();
    }

    public void setAchievementUrl(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_ACHIEVEMENT_URL, str);
        }
    }

    public FrsActivityConfig setCallFrom(int i2) {
        getIntent().putExtra(FRS_CALL_FROM, i2);
        return this;
    }

    public FrsActivityConfig setDefaultGameTabId(int i2) {
        getIntent().putExtra(FRS_GAME_DEFAULT_TAB_ID, i2);
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

    public FrsActivityConfig createBackSpecialCfg(String str, String str2, boolean z, boolean z2, boolean z3) {
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra("back_special", z);
        intent.putExtra(GOOD, z2);
        intent.putExtra(FOLLOWED_HAS_NEW, z3);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        }
        return this;
    }

    public FrsActivityConfig createNormalCfg(String str, String str2, boolean z) {
        return createBackSpecialCfg(str, str2, false, false, z);
    }
}

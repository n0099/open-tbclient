package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class FrsActivityConfig extends IntentConfig {
    public static final String ADD_SEARCH = "add_search";
    public static final String ALA_IS_ONLIVING = "ala_is_living";
    public static final String BACK_SPECIAL = "back_special";
    public static final String CONTENT_SHOW = "content_show";
    public static final String FLAG = "flag";
    public static final String FOLLOWED_HAS_NEW = "followed_has_new";
    public static final String FROM = "from";
    public static final String FROM_SHORT_CUT = "from_short_cut";
    public static final String FRS_CALL_FROM = "frs_call_from";
    public static final int FRS_CALL_FROM_ENTERFORUM_FREQUENTLY = 4;
    public static final int FRS_CALL_FROM_ENTERFORUM_LIKE = 3;
    public static final int FRS_CALL_FROM_ENTER_FORUM_BUTTON = 14;
    public static final int FRS_CALL_FROM_HOME_LIVE_TAB = 15;
    public static final int FRS_CALL_FROM_ONE_KEY_SIGN = 6;
    public static final int FRS_CALL_FROM_PB = 2;
    public static final int FRS_CALL_FROM_PERSON_GUEST_LIKE = 9;
    public static final int FRS_CALL_FROM_PERSON_GUEST_SAME_FORUM = 8;
    public static final int FRS_CALL_FROM_PERSON_HOST = 7;
    public static final int FRS_CALL_FROM_PUSH = 13;
    public static final int FRS_CALL_FROM_SEARCH = 10;
    public static final int FRS_CALL_FROM_SQUARE = 5;
    public static final int FRS_CALL_FROM_TAB_RECOMMEND = 11;
    public static final int FRS_CALL_FROM_URL_JUMP = 12;
    public static final String FRS_CALL_SEARCH = "frs_call_search";
    public static final String FRS_CREATE_WITH_GAME = "create_with_game";
    public static final String FRS_FROM_ENTERFORUM_RECOMMEND = "recom_flist";
    public static final String FRS_FROM_FOLLOWED_RECOMMEND = "followed_recommend_forumlist";
    public static final String FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD = "frequently_forum_new_thread";
    public static final String FRS_FROM_FREQUENTLY_FORUM_POST_THREAD = "frequently_forum_post_thread";
    public static final String FRS_FROM_KUANG = "from_tieba_kuang";
    public static final String FRS_FROM_LIKE = "tb_forumlist";
    public static final String FRS_FROM_MANGA_COVER = "form_manga_cover";
    public static final String FRS_FROM_PB = "tb_pb";
    public static final String FRS_FROM_RECENTLY_VISITED = "from_recently_visited";
    public static final String FRS_FROM_RECOMMEND = "dimension_door";
    public static final String FRS_FROM_SEARCH = "tb_searchlist";
    public static final String FRS_FROM_SQUARE = "from_square";
    public static final String FRS_FROM_SQUARE_HOT = "from_square_hot";
    public static final String FRS_FROM_SQUARE_RECOMMEND = "from_square_recommend";
    public static final String FRS_FROM_SQUARE_TOP = "from_square_top";
    public static final String FRS_FROM_TAB_RECOMMEND_FORUM = "tab_recommend_forum";
    public static final String FRS_FROM_WRITESHARE = "tb_write_share";
    public static final String FRS_GAME_DEFAULT_TAB_ID = "frs_game_default_tab_id";
    public static final String FRS_HOT_THREAD_ID = "frs_hot_thread_id";
    public static final String FRS_TO_PB = "tb_frslist";
    public static final String GOOD = "good";
    public static final String IS_SELECTION = "is_selection";
    public static final String KEY_REFRESH = "refresh_all";
    public static final String NAME = "name";
    public static final int READ_CHAT = 1;
    public static final int READ_REPLYORAT = 0;
    public static final String YUELAOU_LOCATE = "yuelaou_locate";

    public FrsActivityConfig(Context context) {
        super(context);
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
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
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
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
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
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
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
}

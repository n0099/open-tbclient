package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.acrossForum.AcrossForumViewData;
/* loaded from: classes.dex */
public class FrsActivityConfig extends IntentConfig {
    public static final String ACROSS_FROUM_DATA = "across_forum_data";
    public static final String ADD_SEARCH = "add_search";
    public static final String BACK_SPECIAL = "back_special";
    public static final String CONTENT_SHOW = "content_show";
    public static final String FLAG = "flag";
    public static final String FOLLOWED_HAS_NEW = "followed_has_new";
    public static final String FROM = "from";
    public static final String FROM_SHORT_CUT = "from_short_cut";
    public static final int FRS_FLAG_ADD_SEARCH_HIS = 1;
    public static final int FRS_FLAG_NORMAL = 0;
    public static final String FRS_FORUM_FREQUENTLY_FORUM = "frequently_forum";
    public static final String FRS_FROM_BAIDU_SEARCHBOX = "from_baidu_searchbox";
    public static final String FRS_FROM_ENTERFORUM_RECOMMEND = "recom_flist";
    public static final String FRS_FROM_FOLLOWED_RECOMMEND = "followed_recommend_forumlist";
    public static final String FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD = "frequently_forum_new_thread";
    public static final String FRS_FROM_FREQUENTLY_FORUM_POST_THREAD = "frequently_forum_post_thread";
    public static final String FRS_FROM_LIKE = "tb_forumlist";
    public static final String FRS_FROM_MANGA_COVER = "form_manga_cover";
    public static final String FRS_FROM_PB = "tb_pb";
    public static final String FRS_FROM_RECOMMEND = "dimension_door";
    public static final String FRS_FROM_SEARCH = "tb_searchlist";
    public static final String FRS_FROM_SEARCHBOX = "tb_searchbox";
    public static final String FRS_FROM_SQUARE = "from_square";
    public static final String FRS_FROM_SQUARE_HOT = "from_square_hot";
    public static final String FRS_FROM_SQUARE_RECOMMEND = "from_square_recommend";
    public static final String FRS_FROM_SQUARE_TOP = "from_square_top";
    public static final String FRS_FROM_WRITESHARE = "tb_write_share";
    public static final String FRS_TO_PB = "tb_frslist";
    public static final String GOOD = "good";
    public static String HAS_SHOWN_FRS_GUIDE = "has_shown_frs_guide";
    public static final String KEY_REFRESH = "refresh_all";
    public static final String NAME = "name";
    public static final int READ_CHAT = 1;
    public static final int READ_REPLYORAT = 0;
    public static final String REFRESH_TO_FRS = "tb_frslist";
    public static final String YUELAOU_LOCATE = "yuelaou_locate";

    public FrsActivityConfig(Context context) {
        super(context);
    }

    public FrsActivityConfig createNormalCfg(String str, String str2) {
        return createBackSpecialCfg(str, str2, false, false);
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
        intent.putExtra(YUELAOU_LOCATE, str3);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }

    public FrsActivityConfig createGoodCfg(String str, String str2) {
        return createBackSpecialCfg(str, str2, false, true);
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

    public FrsActivityConfig createFlagCfg(String str, String str2, int i) {
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra(FLAG, i);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }

    public FrsActivityConfig createRefreshCfg() {
        Intent intent = getIntent();
        intent.setFlags(603979776);
        intent.putExtra(KEY_REFRESH, true);
        return this;
    }

    public FrsActivityConfig createRefreshCfgShowContent(String str, String str2) {
        Intent intent = getIntent();
        intent.setFlags(603979776);
        intent.putExtra(KEY_REFRESH, true);
        intent.putExtra(CONTENT_SHOW, true);
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }

    public FrsActivityConfig createImageActivityNormalCfg(String str, String str2, int i) {
        Intent intent = getIntent();
        intent.addFlags(268435456);
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra(ADD_SEARCH, i);
        intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
        return this;
    }

    public void setIsFromAcrossForum(AcrossForumViewData acrossForumViewData) {
        if (getIntent() != null && acrossForumViewData != null) {
            getIntent().putExtra(ACROSS_FROUM_DATA, acrossForumViewData);
        }
    }
}

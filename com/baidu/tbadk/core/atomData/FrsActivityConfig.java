package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class FrsActivityConfig extends a {
    public static final String ADD_SEARCH = "add_search";
    public static final String BACK_SPECIAL = "back_special";
    public static final String CONTENT_SHOW = "content_show";
    public static final String FLAG = "flag";
    public static final String FROM = "from";
    public static final String FROM_SHORT_CUT = "from_short_cut";
    public static final int FRS_FLAG_ADD_SEARCH_HIS = 1;
    public static final int FRS_FLAG_NORMAL = 0;
    public static final String FRS_FROM_ENTERFORUM_RECOMMEND = "recom_flist";
    public static final String FRS_FROM_LIKE = "tb_forumlist";
    public static final String FRS_FROM_PB = "tb_pb";
    public static final String FRS_FROM_RECOMMEND = "dimension_door";
    public static final String FRS_FROM_SEARCH = "tb_searchlist";
    public static final String FRS_FROM_SQUARE = "from_square";
    public static final String FRS_FROM_WRITESHARE = "tb_write_share";
    public static final String FRS_TO_PB = "tb_frslist";
    public static final String GOOD = "good";
    public static String HAS_SHOWN_FRS_GUIDE = "has_shown_frs_guide";
    public static final String KEY_REFRESH = "refresh_all";
    public static final String NAME = "name";
    public static final int READ_CHAT = 1;
    public static final int READ_REPLYORAT = 0;
    public static final String REFRESH_TO_FRS = "tb_frslist";

    public FrsActivityConfig(Context context) {
        super(context);
    }

    public FrsActivityConfig createNormalCfg(String str, String str2) {
        return createBackSpecialCfg(str, str2, false, false);
    }

    public FrsActivityConfig createGoodCfg(String str, String str2) {
        return createBackSpecialCfg(str, str2, false, true);
    }

    public FrsActivityConfig createBackSpecialCfg(String str, String str2, boolean z, boolean z2) {
        Intent intent = getIntent();
        intent.putExtra("name", str);
        intent.putExtra("from", str2);
        intent.putExtra("back_special", z);
        intent.putExtra(GOOD, z2);
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
}

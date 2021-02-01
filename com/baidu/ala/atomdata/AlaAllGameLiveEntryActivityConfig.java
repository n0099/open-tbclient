package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class AlaAllGameLiveEntryActivityConfig extends IntentConfig {
    public static final String ALA_ALL_GAME_ENTRY_DATA = "ala_all_game_entry_data";
    public static final String ALA_ALL_GAME_ENTRY_HAS_SEARCH = "ala_all_game_entry_has_search";
    @Deprecated
    public static final String ALA_ALL_GAME_ENTRY_TITLE = "ala_all_game_entry_title";

    public AlaAllGameLiveEntryActivityConfig(Context context, int i, ArrayList<AlaSquareTabInfo> arrayList) {
        super(context);
        getIntent().putExtra(ALA_ALL_GAME_ENTRY_HAS_SEARCH, i);
        getIntent().putParcelableArrayListExtra(ALA_ALL_GAME_ENTRY_DATA, arrayList);
    }
}

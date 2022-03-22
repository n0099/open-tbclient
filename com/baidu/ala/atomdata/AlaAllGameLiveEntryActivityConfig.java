package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.ala.data.AlaSquareTabInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaAllGameLiveEntryActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALA_ALL_GAME_ENTRY_DATA = "ala_all_game_entry_data";
    public static final String ALA_ALL_GAME_ENTRY_HAS_SEARCH = "ala_all_game_entry_has_search";
    @Deprecated
    public static final String ALA_ALL_GAME_ENTRY_TITLE = "ala_all_game_entry_title";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaAllGameLiveEntryActivityConfig(Context context, int i, ArrayList<AlaSquareTabInfo> arrayList) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(ALA_ALL_GAME_ENTRY_HAS_SEARCH, i);
        getIntent().putParcelableArrayListExtra(ALA_ALL_GAME_ENTRY_DATA, arrayList);
    }
}

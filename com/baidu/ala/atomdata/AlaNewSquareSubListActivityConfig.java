package com.baidu.ala.atomdata;

import android.content.Context;
import android.os.Parcelable;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class AlaNewSquareSubListActivityConfig extends IntentConfig {
    public static final String ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO = "ala_square_sub_liste_activity_bitmap_ratio";
    public static final String ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA = "ala_square_sub_liste_activity_entry_data";
    public static final String ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME = "ala_square_sub_liste_activity_entry_name";
    public static final String ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME = "ala_square_sub_liste_activity_label_name";
    public static final String ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST = "ala_square_sub_list_activity_sub_type_list";

    public AlaNewSquareSubListActivityConfig(Context context, Parcelable parcelable) {
        super(context);
        getIntent().putExtra(ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA, parcelable);
    }

    public AlaNewSquareSubListActivityConfig(Context context, String str, String str2, String str3, ArrayList<String> arrayList) {
        super(context);
        getIntent().putExtra(ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO, str);
        getIntent().putExtra(ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME, str2);
        getIntent().putExtra(ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME, str3);
        getIntent().putStringArrayListExtra(ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST, arrayList);
    }
}

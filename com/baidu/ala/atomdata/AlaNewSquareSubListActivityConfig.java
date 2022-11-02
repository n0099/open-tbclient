package com.baidu.ala.atomdata;

import android.content.Context;
import android.os.Parcelable;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AlaNewSquareSubListActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO = "ala_square_sub_liste_activity_bitmap_ratio";
    public static final String ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA = "ala_square_sub_liste_activity_entry_data";
    public static final String ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME = "ala_square_sub_liste_activity_entry_name";
    public static final String ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME = "ala_square_sub_liste_activity_label_name";
    public static final String ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST = "ala_square_sub_list_activity_sub_type_list";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaNewSquareSubListActivityConfig(Context context, Parcelable parcelable) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, parcelable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_DATA, parcelable);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaNewSquareSubListActivityConfig(Context context, String str, String str2, String str3, ArrayList<String> arrayList) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, arrayList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra(ALA_SQUARE_SUB_LIST_ACTIVITY_BITMAP_RATIO, str);
        getIntent().putExtra(ALA_SQUARE_SUB_LIST_ACTIVITY_ENTRY_NAME, str2);
        getIntent().putExtra(ALA_SQUARE_SUB_LIST_ACTIVITY_LABEL_NAME, str3);
        getIntent().putStringArrayListExtra(ALA_SQUARE_SUB_LIST_ACTIVITY_SUB_TYPE_LIST, arrayList);
    }
}

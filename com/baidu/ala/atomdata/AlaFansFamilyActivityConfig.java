package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class AlaFansFamilyActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTHOR_LIVE_USER_ID = "author_live_user_id";
    public static final String FROM_LIVE_ROOM = "from_live_room";
    public static final String FROM_PERSON_CENTER = "from_person_center";
    public static final String FROM_TYPE = "from_type";
    public static final String IS_SHOW_FULL_SCREEN = "is_show_full_screen";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaFansFamilyActivityConfig(Context context, String str, boolean z, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), str2};
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
        getIntent().putExtra("author_live_user_id", str);
        getIntent().putExtra(IS_SHOW_FULL_SCREEN, z);
        getIntent().putExtra("from_type", str2);
    }
}

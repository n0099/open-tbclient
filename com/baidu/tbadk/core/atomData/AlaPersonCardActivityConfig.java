package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class AlaPersonCardActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PERSON_APP_ID = "PERSON_APP_ID";
    public static final String PERSON_DESCRIPTION = "PERSON_DESCRIPTION";
    public static final String PERSON_FANS_COUNT = "PERSON_FANS_COUNT";
    public static final String PERSON_FOLLOWS_COUNT = "PERSON_FOLLOWS_COUNT";
    public static final String PERSON_FOLLOW_STATUS = "PERSON_FOLLOW_STATUS";
    public static final String PERSON_GROUP_ID = "PERSON_GROUP_ID";
    public static final String PERSON_LEVEL = "PERSON_LEVEL";
    public static final String PERSON_LIVE_ID = "PERSON_LIVE_ID";
    public static final String PERSON_LIVE_OWNER_FLAG = "PERSON_LIVE_OWNER_FLAG";
    public static final String PERSON_LIVE_OWNER_UID = "PERSON_LIVE_OWNER_UID";
    public static final String PERSON_LOCATION = "PERSON_LOCATION";
    public static final String PERSON_PORTRAIT_URL = "PERSON_PORTRAIT_URL";
    public static final String PERSON_SEND_COUNT = "PERSON_SEND_COUNT";
    public static final String PERSON_SEX = "PERSON_SEX";
    public static final String PERSON_USER_ID = "PERSON_USER_ID";
    public static final String PERSON_USER_NAME = "PERSON_USER_NAME";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaPersonCardActivityConfig(Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
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
        getIntent().putExtra(PERSON_USER_ID, str);
        setIntentAction(IntentAction.Activity);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaPersonCardActivityConfig(Context context, String str, String str2, String str3, int i2, int i3, String str4, String str5, long j2, long j3, long j4, int i4, String str6, String str7, boolean z, String str8, String str9) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4, str5, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i4), str6, str7, Boolean.valueOf(z), str8, str9};
            interceptable.invokeUnInit(65538, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra(PERSON_USER_ID, str);
        getIntent().putExtra(PERSON_USER_NAME, str2);
        getIntent().putExtra(PERSON_PORTRAIT_URL, str3);
        getIntent().putExtra(PERSON_SEX, i2);
        getIntent().putExtra(PERSON_LEVEL, i3);
        getIntent().putExtra(PERSON_LOCATION, str4);
        getIntent().putExtra(PERSON_DESCRIPTION, str5);
        getIntent().putExtra(PERSON_SEND_COUNT, j2);
        getIntent().putExtra(PERSON_FANS_COUNT, j3);
        getIntent().putExtra(PERSON_FOLLOWS_COUNT, j4);
        getIntent().putExtra(PERSON_FOLLOW_STATUS, i4);
        getIntent().putExtra(PERSON_GROUP_ID, str6);
        getIntent().putExtra(PERSON_LIVE_ID, str7);
        getIntent().putExtra(PERSON_LIVE_OWNER_FLAG, z);
        getIntent().putExtra(PERSON_LIVE_OWNER_UID, str8);
        getIntent().putExtra(PERSON_APP_ID, str9);
        setRequestCode(25014);
        setIntentAction(IntentAction.ActivityForResult);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaPersonCardActivityConfig(Context context, String str, String str2, String str3, int i2, int i3, String str4, String str5, long j2, long j3, long j4, int i4, String str6) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4, str5, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i4), str6};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra(PERSON_USER_ID, str);
        getIntent().putExtra(PERSON_USER_NAME, str2);
        getIntent().putExtra(PERSON_PORTRAIT_URL, str3);
        getIntent().putExtra(PERSON_SEX, i2);
        getIntent().putExtra(PERSON_LEVEL, i3);
        getIntent().putExtra(PERSON_LOCATION, str4);
        getIntent().putExtra(PERSON_DESCRIPTION, str5);
        getIntent().putExtra(PERSON_SEND_COUNT, j2);
        getIntent().putExtra(PERSON_FANS_COUNT, j3);
        getIntent().putExtra(PERSON_FOLLOWS_COUNT, j4);
        getIntent().putExtra(PERSON_FOLLOW_STATUS, i4);
        getIntent().putExtra(PERSON_APP_ID, str6);
        setRequestCode(25014);
        setIntentAction(IntentAction.ActivityForResult);
    }
}

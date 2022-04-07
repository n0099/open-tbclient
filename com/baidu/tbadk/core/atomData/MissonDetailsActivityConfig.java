package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MissonDetailsActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ANTI_DATA = "anti_data";
    public static final String CURRENT_LEVEL = "current_level";
    public static final String FANS_NAME = "fans_name";
    public static final String FLOOR_NUM = "floor_num";
    public static final String FROM_PERSON = "from_person";
    public static final String FROM_PHOTO_LIVE = "from_photo_live";
    public static final String IS_MEMBER = "is_member";
    public static final String IS_UPGRADE_SUCCESS = "is_upgrade_success";
    public static final String THREAD_TITLE = "thread_title";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissonDetailsActivityConfig(Context context, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j, int i3, int i4, AntiData antiData, String str7) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, str4, str5, str6, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4), antiData, str7};
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
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra("current_level", i2);
        getIntent().putExtra("portrait", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("from", str3);
        getIntent().putExtra("thread_id", str4);
        getIntent().putExtra(THREAD_TITLE, str5);
        getIntent().putExtra("forum_name", str6);
        getIntent().putExtra("forum_id", j);
        getIntent().putExtra("floor_num", i3);
        getIntent().putExtra(IS_MEMBER, i4);
        getIntent().putExtra("anti_data", antiData);
        getIntent().putExtra(FANS_NAME, str7);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MissonDetailsActivityConfig(Context context, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6) {
        this(context, i, i2, str, str2, str3, str4, str5, str6, 0L, 0, 0, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, str4, str5, str6};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (String) objArr2[3], (String) objArr2[4], (String) objArr2[5], (String) objArr2[6], (String) objArr2[7], (String) objArr2[8], ((Long) objArr2[9]).longValue(), ((Integer) objArr2[10]).intValue(), ((Integer) objArr2[11]).intValue(), (AntiData) objArr2[12], (String) objArr2[13]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MissonDetailsActivityConfig(Context context, int i, int i2, String str, String str2, String str3) {
        this(context, i, i2, str, str2, str3, null, null, null, 0L, 0, 0, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (String) objArr2[3], (String) objArr2[4], (String) objArr2[5], (String) objArr2[6], (String) objArr2[7], (String) objArr2[8], ((Long) objArr2[9]).longValue(), ((Integer) objArr2[10]).intValue(), ((Integer) objArr2[11]).intValue(), (AntiData) objArr2[12], (String) objArr2[13]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}

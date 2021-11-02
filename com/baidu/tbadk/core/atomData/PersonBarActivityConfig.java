package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PersonBarActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BAR_ID = "bar_id";
    public static final String BAR_NAME = "bar_name";
    public static final String IS_CHOOSE_BAR_MODE = "is_choose_bar_mode";
    public static final String KEY_CURRENT_TAB = "key_current_tab";
    public static final String KEY_SEX = "key_sex";
    public static final String KEY_UID = "key_uid";
    public static final String LIKE_BARS_COUNT = "like_bars_count";
    public static final String REQUEST_CODE = "tb_request_code";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonBarActivityConfig(Context context, String str, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonBarActivityConfig(Context context, int i2, String str, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i3);
        intent.putExtra(LIKE_BARS_COUNT, i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonBarActivityConfig(Context context, String str, int i2, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i2);
        intent.putExtra("key_current_tab", i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonBarActivityConfig(Context context, String str, int i2, boolean z, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i2);
        intent.putExtra(IS_CHOOSE_BAR_MODE, z);
        intent.putExtra("tb_request_code", i3);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonBarActivityConfig(Context context, String str, int i2, boolean z, int i3, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i2);
        intent.putExtra(IS_CHOOSE_BAR_MODE, z);
        intent.putExtra("tb_request_code", i3);
        intent.putExtra("bar_id", str2);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i3);
    }
}

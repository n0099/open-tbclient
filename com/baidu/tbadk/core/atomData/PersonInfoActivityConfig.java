package com.baidu.tbadk.core.atomData;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PersonInfoActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FANS_NUM = "fans_num";
    public static final String IS_SHOW_PROGRESS = "is_show_progress";
    public static final int REQUSET_CHANGE = 101;
    public static final String TAG_DATA = "data";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoActivityConfig(Context context, String str, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2};
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
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
    }

    public void setIsVideoThread(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            getIntent().putExtra(IntentConfig.IS_VIDEO_THREAD, z);
        }
    }

    public void setShowProgress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            getIntent().putExtra(IS_SHOW_PROGRESS, z);
        }
    }

    public void setSourceTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            getIntent().putExtra("thread_id", str);
        }
    }

    public void setVideoPersonFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            getIntent().putExtra(IntentConfig.VIDEO_PERSON_FROM, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("from", str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("from", str3);
        getIntent().putExtra("st_type", str4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoActivityConfig(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, str4, str5, str6};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("from", str3);
        getIntent().putExtra("st_type", str4);
        getIntent().putExtra("thread_id", str5);
        getIntent().putExtra("nid", str6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonInfoActivityConfig(Context context, String str, String str2, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra("user_id", str);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra(FANS_NUM, i);
    }
}

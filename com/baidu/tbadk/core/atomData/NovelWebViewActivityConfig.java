package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class NovelWebViewActivityConfig extends TbWebViewActivityConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_IS_SHOW_TOAST_TIP = "key_is_show_toast_tip";
    public static final String KEY_NOVEL_FID = "key_novel_fid";
    public static final String KEY_NOVEL_ID = "key_novel_id";
    public static final String KEY_NOVEL_TID = "key_novel_tid";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NovelWebViewActivityConfig(Context context, String str, String str2, boolean z) {
        super(context, str, str2, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setFixTitle(true);
        setNoMenu(true);
        setNoShare(true);
    }

    public void setBookId(String str) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_NOVEL_ID, str);
        }
    }

    public void setIsShowTopToast(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_IS_SHOW_TOAST_TIP, z);
        }
    }

    public void setExtraData(String str, String str2) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_NOVEL_TID, str);
            intent.putExtra(KEY_NOVEL_FID, str2);
        }
    }
}

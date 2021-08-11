package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SkinDetailActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String THEME_ALBUM_PICTURE = "theme_album_picture";
    public static final String THEME_CURRENT_TYPE = "current_type";
    public static final String THEME_ID = "theme_id";
    public static final String THEME_PERMISSION_ICON_URL = "theme_permission_icon_url";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinDetailActivityConfig(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        getIntent().putExtra(THEME_ID, i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinDetailActivityConfig(Context context, int i2, String str, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        getIntent().putExtra(THEME_ID, i2);
        getIntent().putExtra(THEME_ALBUM_PICTURE, str);
        getIntent().putExtra(THEME_PERMISSION_ICON_URL, str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkinDetailActivityConfig(Context context, int i2, int i3, String str, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        getIntent().putExtra(THEME_ID, i2);
        getIntent().putExtra("current_type", i3);
        getIntent().putExtra(THEME_ALBUM_PICTURE, str);
        getIntent().putExtra(THEME_PERMISSION_ICON_URL, str2);
    }
}

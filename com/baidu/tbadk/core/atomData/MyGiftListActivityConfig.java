package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.net.Uri;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mg;
/* loaded from: classes3.dex */
public class MyGiftListActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AccountTypeForum = 1;
    public static final int AccountTypeUser = 0;
    public static final String NAME_SHOW = "name_show";
    public static final String ST_TYPE = "st_type";
    public static final String USER_ID = "id";
    public static final String USER_NAME = "user_name";
    public static final String USER_SEX = "sex";
    public static final String USER_TPYE = "user_type";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGiftListActivityConfig(Context context, String str, String str2, String str3, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, Integer.valueOf(i)};
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
        getIntent().putExtra("id", str);
        getIntent().putExtra("sex", i);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("name_show", str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGiftListActivityConfig(Context context, String str, String str2, String str3, int i, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)};
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
        getIntent().putExtra("id", str);
        getIntent().putExtra("sex", i);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("name_show", str3);
        getIntent().putExtra("user_type", i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGiftListActivityConfig(Context context, String str, String str2, String str3, int i, String str4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, Integer.valueOf(i), str4};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        getIntent().putExtra("id", str);
        getIntent().putExtra("sex", i);
        getIntent().putExtra("st_type", str4);
        getIntent().putExtra("user_name", str2);
        getIntent().putExtra("name_show", str3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGiftListActivityConfig(Context context, Uri uri) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, uri};
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
        if (uri != null) {
            getIntent().putExtra("id", uri.getQueryParameter("id"));
            getIntent().putExtra("sex", mg.e(uri.getQueryParameter("sex"), 0));
            getIntent().putExtra("user_name", uri.getQueryParameter("user_name"));
            getIntent().putExtra("name_show", uri.getQueryParameter("name_show"));
        }
    }
}

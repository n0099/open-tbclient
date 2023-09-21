package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PersonPostActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALL_FROM_CREATIVE_WORK = "creativeWork";
    public static final String KEY_CALL_FROM = "key_call_from";
    public static final String KEY_NAV_TITLE = "key_nav_title";
    public static final String KEY_PORTRAIT_URL = "key_portrait_url";
    public static final String KEY_SEX = "key_sex";
    public static final String KEY_UID = "key_uid";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPostActivityConfig(Context context, Uri uri) {
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
            getIntent().putExtra("key_uid", uri.getQueryParameter("user_id"));
            getIntent().putExtra("key_sex", JavaTypesHelper.toInt(uri.getQueryParameter("sex"), 0));
            getIntent().putExtra("key_portrait_url", uri.getQueryParameter("portrait"));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPostActivityConfig(Context context, String str, int i, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i), str2};
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
        getIntent().putExtra("key_uid", str);
        getIntent().putExtra("key_sex", i);
        getIntent().putExtra("key_portrait_url", str2);
    }
}

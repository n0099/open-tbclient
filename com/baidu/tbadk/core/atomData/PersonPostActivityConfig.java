package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.net.Uri;
import b.a.e.f.m.b;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PersonPostActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_PORTRAIT_URL = "key_portrait_url";
    public static final String KEY_SEX = "key_sex";
    public static final String KEY_UID = "key_uid";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPostActivityConfig(Context context, String str, int i2, String str2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2), str2};
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
        getIntent().putExtra("key_uid", str);
        getIntent().putExtra("key_sex", i2);
        getIntent().putExtra(KEY_PORTRAIT_URL, str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPostActivityConfig(Context context, Uri uri) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, uri};
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
        if (uri != null) {
            getIntent().putExtra("key_uid", uri.getQueryParameter("user_id"));
            getIntent().putExtra("key_sex", b.e(uri.getQueryParameter("sex"), 0));
            getIntent().putExtra(KEY_PORTRAIT_URL, uri.getQueryParameter("portrait"));
        }
    }
}

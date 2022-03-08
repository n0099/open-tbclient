package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class WriteShareActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FORUM_NAME = "forum_name";
    public static final String PREFIX_DATA = "prefix_data";
    public static final String SHARE_API_KEY = "share_api_key";
    public static final String SHARE_APP_NAME = "share_app_name";
    public static final String SHARE_REFER_URL = "share_refer_url";
    public static final String SHARE_SIGN_KEY = "share_sign_key";
    public static final String SHARE_SUMMARY_CONTENT = "share_summary_content";
    public static final String SHARE_SUMMARY_IMG = "share_summary_img";
    public static final String SHARE_SUMMARY_IMG_HEIGHT = "summary_img_height";
    public static final String SHARE_SUMMARY_IMG_TYPE = "summary_img_type";
    public static final String SHARE_SUMMARY_IMG_WIDTH = "summary_img_width";
    public static final String SHARE_SUMMARY_TITLE = "share_summary_title";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteShareActivityConfig(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, str, str2, str3, str4, str5, str6, str7, str8};
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
        getIntent().putExtra("forum_name", str);
        getIntent().putExtra(SHARE_SUMMARY_TITLE, str2);
        getIntent().putExtra(SHARE_SUMMARY_CONTENT, str3);
        getIntent().putExtra(SHARE_SUMMARY_IMG, str4);
        getIntent().putExtra(SHARE_REFER_URL, str5);
        getIntent().putExtra(SHARE_API_KEY, str6);
        getIntent().putExtra(SHARE_APP_NAME, str7);
        getIntent().putExtra(SHARE_SIGN_KEY, str8);
    }
}

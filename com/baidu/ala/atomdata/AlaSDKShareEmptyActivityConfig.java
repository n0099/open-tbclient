package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AlaSDKShareEmptyActivityConfig extends IntentConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PACKAGE_NAME_QQ = "com.tencent.mobileqq";
    public static final String PACKAGE_NAME_SINA_WEIBO = "com.sina.weibo";
    public static final String PACKAGE_NAME_WEIXIN = "com.tencent.mm";
    public static final int SHARE_ACTION_PANEL = 1;
    public static final int SHARE_ACTION_SINGLE_CHANNEL = 2;
    public static final String SHARE_ALA_SDK_ACTION_KEY = "action";
    public static final String SHARE_ALA_SDK_CHANNEL_KEY = "channel";
    public static final String SHARE_ALA_SDK_CONTENT_KEY = "content";
    public static final String SHARE_ALA_SDK_IMAGEURI_KEY = "imageuri";
    public static final String SHARE_ALA_SDK_LINKURL_KEY = "linkurl";
    public static final String SHARE_ALA_SDK_LIVE_EXT_INFO = "liveextInfo";
    public static final String SHARE_ALA_SDK_LIVE_ID = "liveid";
    public static final String SHARE_ALA_SDK_TITLE_KEY = "title";
    public static final String SHARE_ALA_SDK_YY_ANCHOR_BDUID = "yy_anchor_bduid";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaSDKShareEmptyActivityConfig(Context context, ShareItem shareItem, int i2, int i3) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, shareItem, Integer.valueOf(i2), Integer.valueOf(i3)};
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
        getIntent().putExtra("title", shareItem.r);
        getIntent().putExtra("content", shareItem.s);
        getIntent().putExtra(SHARE_ALA_SDK_IMAGEURI_KEY, shareItem.w);
        getIntent().putExtra(SHARE_ALA_SDK_LINKURL_KEY, shareItem.t);
        getIntent().putExtra("channel", i2);
        getIntent().putExtra("action", i3);
        getIntent().putExtra("liveid", shareItem.q);
        getIntent().putExtra(SHARE_ALA_SDK_LIVE_EXT_INFO, shareItem.o0);
        getIntent().putExtra(SHARE_ALA_SDK_YY_ANCHOR_BDUID, shareItem.z);
    }
}

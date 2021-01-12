package com.baidu.ala.atomdata;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
/* loaded from: classes9.dex */
public class AlaSDKShareEmptyActivityConfig extends IntentConfig {
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

    public AlaSDKShareEmptyActivityConfig(Context context, ShareItem shareItem, int i, int i2) {
        super(context);
        getIntent().putExtra("title", shareItem.title);
        getIntent().putExtra("content", shareItem.content);
        getIntent().putExtra(SHARE_ALA_SDK_IMAGEURI_KEY, shareItem.imageUrl);
        getIntent().putExtra(SHARE_ALA_SDK_LINKURL_KEY, shareItem.linkUrl);
        getIntent().putExtra("channel", i);
        getIntent().putExtra("action", i2);
        getIntent().putExtra(SHARE_ALA_SDK_LIVE_ID, shareItem.extData);
        getIntent().putExtra(SHARE_ALA_SDK_LIVE_EXT_INFO, shareItem.extLiveInfo);
    }
}

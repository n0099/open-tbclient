package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class YoungsterVerifyActivityConfig extends TbWebViewActivityConfig {
    public static final String PARAMA_AUTH_ID = "authid";
    public static final String PARAMA_SCENE = "scene";
    public static final String PARAMA_TIEBA_AUTH = "tieba_auth";
    public static final String VERIFY_URL_PREFIX = "https://wappass.baidu.com/v6/authwidget?adapter=3&clientfrom=wap&tpl=tieba&u=";

    public YoungsterVerifyActivityConfig(Context context, String str, String str2, boolean z) {
        super(context, str, str2, z);
    }

    public static String getYoungsterVerifyUrl() {
        try {
            return VERIFY_URL_PREFIX + URLEncoder.encode(TbConfig.SERVER_ADDRESS + TbConfig.URL_YOUNGSTER_VERIFY_AUTHID, "utf-8") + ETAG.ITEM_SEPARATOR + "scene" + ETAG.EQUAL + PARAMA_TIEBA_AUTH;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void setKeyYoungsterPasswordFrom(int i) {
        getIntent().putExtra(YoungsterPasswordActivityConfig.KEY_YOUNGSTER_PASSWORD_FROM, i);
    }
}

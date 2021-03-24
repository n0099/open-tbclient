package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SelectForumActivityConfig extends IntentConfig {
    public static final String EXTRA_KEY_BAIJIAHAO_DATA = "extra_key_baijiahao_data";
    public static final String EXTRA_KEY_FROM = "extra_key_from";
    public static final String EXTRA_KEY_LIVE_ID = "extra_key_live_id";
    public static final String EXTRA_KEY_ORIGINAL_THREAD = "extra_key_original_thread";
    public static final String EXTRA_KEY_PRIVATE_THREAD = "extra_key_private_thread";
    public static final String EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT = "extra_key_transmit_origin_thread_content";
    public static final String EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW = "extra_key_transmit_thread_author_name_show";
    public static final int FROM_ALA_SHARE = 1;
    public static final int FROM_FORUM_SHARE = 4;
    public static final int FROM_SHARE_SDK = 3;
    public static final int FROM_TRANSMIT_SHARE = 2;
    public static final String KEY_APPKEY = "appkey";
    public static final String KEY_APPLETSKEY = "appletsKey";
    public static final String KEY_INPUT_FORUM_LIST = "KEY_INTPUT_FORUM_LIST";
    public static final String KEY_OUTPUT_FORUM_LIST = "KEY_OUTPUT_FORUM_LIST";
    public static final String KEY_SHARE_APPLETS_LINK = "linkAppletsUrl";
    public static final String KEY_SHARE_DESC = "desc";
    public static final String KEY_SHARE_IMGURL = "image";
    public static final String KEY_SHARE_LINK = "link";
    public static final String KEY_SHARE_TITLE = "title";
    public static final String KEY_TBOPEN_APP_KEY = "81d0b67309e0c2387a031408597139f358f32b4d";
    public static final String MORE_FORUM_IMG = "more_forum_img";
    public static final String MORE_FORUM_TITLE = "more_forum_title";
    public static final String MORE_FORUM_URL = "more_forum_url";
    public static final String SELECT_FORUM_ID = "select_forum_id";
    public static final String SELECT_FORUM_NAME = "select_forum_name";
    public static final String URL_AIAPPS_SHARE_FORUM = "tieba://baidu.tieba.share:8080/selectForum";

    public SelectForumActivityConfig(Context context, int i) {
        super(context);
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setAiAppsParams(String str, String str2, String str3, String str4, String str5, String str6) {
        Intent intent = getIntent();
        intent.setData(Uri.parse(URL_AIAPPS_SHARE_FORUM));
        intent.putExtra("appkey", KEY_TBOPEN_APP_KEY);
        intent.putExtra(KEY_APPLETSKEY, str);
        intent.putExtra("title", str2);
        intent.putExtra("image", str3);
        intent.putExtra("desc", str4);
        intent.putExtra("link", str5);
        intent.putExtra(KEY_SHARE_APPLETS_LINK, str6);
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        if (getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_BAIJIAHAO_DATA, baijiahaoData);
        }
    }

    public void setForumList(ArrayList<TransmitForumData> arrayList) {
        if (getIntent() != null) {
            getIntent().putParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST", arrayList);
        }
    }

    public void setFrom(int i) {
        if (getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_FROM, i);
        }
    }

    public void setLiveId(long j) {
        if (getIntent() != null) {
            getIntent().putExtra("extra_key_live_id", j);
        }
    }

    public void setMoreForumImg(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("more_forum_img", str);
        }
    }

    public void setMoreForumTitle(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("more_forum_title", str);
        }
    }

    public void setMoreForumUrl(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("more_forum_url", str);
        }
    }

    public void setOriginalThread(OriginalThreadInfo.ShareInfo shareInfo) {
        if (getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_ORIGINAL_THREAD, shareInfo);
        }
    }

    public void setPrivateThread(int i) {
        if (getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_PRIVATE_THREAD, i);
        }
    }

    public void setTransmitOriginThreadComment(String str) {
        if (getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT, str);
        }
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        if (getIntent() != null) {
            getIntent().putExtra(EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW, str);
        }
    }
}

package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class ForumSearchActivityConfig extends IntentConfig {
    public ForumSearchActivityConfig(Context context) {
        super(context);
    }

    public void setBaijiahaoData(BaijiahaoData baijiahaoData) {
        if (getIntent() != null) {
            getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA, baijiahaoData);
        }
    }

    public void setFrom(int i2) {
        if (getIntent() != null) {
            getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, i2);
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
            getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD, shareInfo);
        }
    }

    public void setTransmitOriginThreadComment(String str) {
        if (getIntent() != null) {
            getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT, str);
        }
    }

    public void setTransmitThreadAuthorNameShow(String str) {
        if (getIntent() != null) {
            getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW, str);
        }
    }

    public void setYyAnchorBdUid(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("extra_key_yy_anchor_bduid", str);
        }
    }
}

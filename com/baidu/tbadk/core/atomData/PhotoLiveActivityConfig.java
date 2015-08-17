package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.PhotoLiveCoverData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PhotoLiveActivityConfig extends IntentConfig {
    public static final String KEY_COVER_DATA = "cover_data";
    public static final String KEY_FROM_FRS = "from_frs";
    public static final String KEY_FROM_MARK = "from_mark";
    public static final String KEY_FROM_WRITE = "from_write";
    public static final String KEY_POST_ID = "post_id";
    public static final String KEY_ST_TYPE = "st_type";
    public static final String KEY_THREAD_ID = "thread_id";
    private PhotoLiveCoverData coverData;
    private String from;
    private final Context mContext;
    private String postID;
    private int requestCode;
    private String stType;
    private String threadID;

    public PhotoLiveActivityConfig(Context context) {
        super(context);
        this.mContext = context;
    }

    /* synthetic */ PhotoLiveActivityConfig(a aVar, PhotoLiveActivityConfig photoLiveActivityConfig) {
        this(aVar);
    }

    private PhotoLiveActivityConfig(a aVar) {
        super(aVar.context);
        this.mContext = aVar.context;
        this.threadID = aVar.threadID;
        this.postID = aVar.postID;
        this.stType = aVar.stType;
        this.from = aVar.from;
        this.requestCode = aVar.requestCode;
        this.coverData = aVar.coverData;
        createNormalCfg(this.threadID, this.postID, this.stType, this.from, this.requestCode, this.coverData);
    }

    public PhotoLiveActivityConfig createNormalCfg(String str, String str2, String str3, String str4, int i) {
        return createNormalCfg(str, str2, str3, str4, i, null);
    }

    public PhotoLiveActivityConfig createNormalCfg(String str, String str2, String str3, String str4, int i, PhotoLiveCoverData photoLiveCoverData) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra(KEY_COVER_DATA, photoLiveCoverData);
            intent.putExtra("request_code", i);
            setRequestCode(i);
            setIntentAction(IntentAction.ActivityForResult);
            if ("from_frs".equals(str4)) {
                intent.putExtra("from_frs", true);
            } else if ("from_mark".equals(str4)) {
                intent.putExtra("from_mark", true);
            } else if (KEY_FROM_WRITE.equals(str4)) {
                intent.putExtra(KEY_FROM_WRITE, true);
            }
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
        }
        return this;
    }

    /* loaded from: classes.dex */
    public static final class a {
        private final Context context;
        private PhotoLiveCoverData coverData;
        private String from;
        private String postID;
        private int requestCode;
        private String stType;
        private String threadID;
    }
}

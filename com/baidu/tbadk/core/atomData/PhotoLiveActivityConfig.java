package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PhotoLiveActivityConfig extends IntentConfig {
    public static final String KEY_FROM_FRS = "from_frs";
    public static final String KEY_FROM_MARK = "from_mark";
    public static final String KEY_FROM_MESSAGE = "from_message";
    public static final String KEY_FROM_MY_OR_HIS_THREAD = "from_my_or_his_thread";
    public static final String KEY_FROM_WRITE = "from_write";
    public static final String KEY_FROM_WRITE_TARGET = "from_write_target";
    public static final String KEY_LOCATE = "locate";
    public static final String KEY_POST_ID = "post_id";
    public static final String KEY_ST_TYPE = "st_type";
    public static final String KEY_THREAD_ID = "thread_id";
    private String from;
    private String locate;
    private final Context mContext;
    private String postID;
    private int requestCode;
    private String stType;
    private String threadID;

    public PhotoLiveActivityConfig(Context context) {
        super(context);
        this.mContext = context;
    }

    private PhotoLiveActivityConfig(a aVar) {
        super(aVar.context);
        this.mContext = aVar.context;
        this.threadID = aVar.threadID;
        this.postID = aVar.postID;
        this.stType = aVar.stType;
        this.from = aVar.from;
        this.locate = aVar.locate;
        this.requestCode = aVar.requestCode;
        createNormalCfg(this.threadID, this.postID, this.stType, this.from, this.requestCode);
    }

    public PhotoLiveActivityConfig createNormalCfg(String str, String str2, String str3, String str4, int i) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            intent.putExtra(IntentConfig.REQUEST_CODE, i);
            setRequestCode(i);
            setIntentAction(IntentAction.ActivityForResult);
            if ("from_frs".equals(str4)) {
                intent.putExtra("from_frs", true);
            } else if ("from_mark".equals(str4)) {
                intent.putExtra("from_mark", true);
            } else if (KEY_FROM_WRITE.equals(str4)) {
                intent.putExtra(KEY_FROM_WRITE, true);
            } else if (KEY_FROM_MY_OR_HIS_THREAD.equals(str4)) {
                intent.putExtra(KEY_FROM_MY_OR_HIS_THREAD, true);
            } else if (KEY_FROM_MESSAGE.equals(str4)) {
                intent.putExtra(KEY_FROM_MESSAGE, true);
            } else if (KEY_FROM_WRITE_TARGET.equals(str4)) {
                intent.putExtra(KEY_FROM_WRITE_TARGET, true);
            }
            if (!(this.mContext instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (this.locate != null) {
                intent.putExtra("locate", this.locate);
            }
        }
        return this;
    }

    /* loaded from: classes.dex */
    public static final class a {
        private final Context context;
        private String from;
        private String locate;
        private String postID;
        private int requestCode;
        private String stType;
        private String threadID;

        public a(Context context, String str) {
            this.threadID = str;
            this.context = context;
        }

        public a cx(String str) {
            this.postID = str;
            return this;
        }

        public a cy(String str) {
            this.stType = str;
            return this;
        }

        public a cz(String str) {
            this.from = str;
            return this;
        }

        public a cA(String str) {
            this.locate = str;
            return this;
        }

        public a bC(int i) {
            this.requestCode = i;
            return this;
        }

        public PhotoLiveActivityConfig pi() {
            return new PhotoLiveActivityConfig(this);
        }
    }
}

package com.baidu.tbadk.core.frameworkData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.pluginSettings.h;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class a extends i {
    public static final String CMD = "cmd";
    public static final String DATAS = "datas";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String FROM = "from";
    public static final String FRS_MANAGER = "frs_manager";
    public static final String GROUP_ID = "group_id";
    public static final String GROUP_NAME = "group_name";
    public static final int IMAGE_DETAIL_FROM_FORUM = 1;
    public static final int IMAGE_DETAIL_FROM_GCHAT = 3;
    public static final int IMAGE_DETAIL_FROM_PCHAT = 2;
    public static final String INTENT_KEY_START_TIME = "TibaStatic.StartTime";
    public static final String IS_ACCEPT_NOTIFY = "is_accept_notify";
    public static final String IS_DOWNLOADING = "is_downloading";
    public static final String IS_FROM_PB = "is_from_pb";
    public static final String IS_MASK = "isMask";
    public static final String IS_NEED_MULTIPLE = "is_need_multiple";
    public static final String LIST = "list";
    public static final String MASK_TYPE = "maskType";
    public static final String NAME_SHOW = "name_show";
    public static final String PKG_ID = "pkg_id";
    public static final String PORTRAIT = "portrait";
    public static final String POST_DESC = "post_desc";
    public static final String POST_ID = "post_id";
    public static final String PUBLISHER_ID = "publisher_id";
    public static final String PUBLISHER_NAME = "publisher_name";
    public static final String REPLAY_URL = "replay_url";
    public static final String REQUEST_CODE = "request_code";
    public static final String SHOW_KEYBOARD = "keyboard";
    public static final String SHOW_RECOMMEND = "show_recommend";
    public static final String START = "start";
    public static final String START_ONCE = "start_once";
    public static final String STOP = "stop";
    public static final String ST_TYPE = "st_type";
    public static final String THREAD_ID = "thread_id";
    public static final String TOTAL = "total";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_SEX = "user_sex";
    private Context mContext;
    private Intent mIntent;
    private IntentAction mIntentAction;
    private int mRequestCode;

    public a() {
        this.mContext = null;
        this.mIntent = null;
        this.mIntentAction = IntentAction.Activity;
    }

    public a(Context context) {
        this.mContext = null;
        this.mIntent = null;
        this.mIntentAction = IntentAction.Activity;
        if (context == null) {
            throw new InvalidParameterException("ActivitySwitch context null");
        }
        this.mContext = context;
        this.mIntent = new Intent();
    }

    public Context getContext() {
        return this.mContext;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public boolean isValid() {
        return true;
    }

    public void setIntentAction(IntentAction intentAction) {
        this.mIntentAction = intentAction;
    }

    public void setRequestCode(int i) {
        this.mRequestCode = i;
    }

    public void run() {
        if (isValid()) {
            if (this.mIntentAction == IntentAction.Activity) {
                startActivity();
            } else if (this.mIntentAction == IntentAction.ActivityForResult) {
                startActivityForResult(this.mRequestCode);
            } else if (this.mIntentAction == IntentAction.StartService) {
                startService();
            } else if (this.mIntentAction == IntentAction.StopService) {
                stopService();
            }
        }
    }

    public void startActivity() {
        if (!(this.mContext instanceof Activity)) {
            this.mIntent.addFlags(268435456);
        }
        this.mContext.startActivity(this.mIntent);
    }

    public void startActivityForResult(int i) {
        if (this.mContext instanceof Activity) {
            ((Activity) this.mContext).startActivityForResult(this.mIntent, i);
        }
    }

    public void startActivityForResult(int i, Message<?> message) {
        if (message != null) {
            if (TextUtils.isEmpty(h.ir().aw(message.getCmd()))) {
                if (this.mIntent != null) {
                    try {
                        if (com.baidu.adp.plugin.pluginBase.c.class.isAssignableFrom(BdBaseApplication.getInst().getClassLoader().loadClass(this.mIntent.getComponent().getClassName()))) {
                            PluginCenter.getInstance().launchIntent(this.mContext, message.getCmd(), this.mIntent);
                            return;
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                }
                try {
                    startActivityForResult(i);
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            PluginCenter.getInstance().launchIntent(this.mContext, message.getCmd(), this.mIntent);
        }
    }

    public void startService() {
        this.mContext.startService(this.mIntent);
    }

    public void stopService() {
        this.mContext.stopService(this.mIntent);
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public void startActivity(Message<?> message) {
        if (message != null) {
            if (TextUtils.isEmpty(h.ir().aw(message.getCmd()))) {
                if (this.mIntent != null) {
                    try {
                        if (com.baidu.adp.plugin.pluginBase.c.class.isAssignableFrom(BdBaseApplication.getInst().getClassLoader().loadClass(this.mIntent.getComponent().getClassName()))) {
                            PluginCenter.getInstance().launchIntent(this.mContext, message.getCmd(), this.mIntent);
                            return;
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                }
                try {
                    this.mContext.startActivity(this.mIntent);
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            PluginCenter.getInstance().launchIntent(this.mContext, message.getCmd(), this.mIntent);
        }
    }
}

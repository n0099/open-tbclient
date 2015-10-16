package com.baidu.tbadk.core.frameworkData;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.g;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class IntentConfig extends i {
    public static final String CLOSE = "close";
    public static final String CMD = "cmd";
    public static final String DATAS = "datas";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String FROM = "from";
    public static final int FROM_VALUE_LOGIN = 1;
    public static final int FROM_VALUE_NOTLOGIN_GUIDE = 4;
    public static final int FROM_VALUE_REGISTER = 2;
    public static final int FROM_VALUE_VISITOR = 3;
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
    public static final String TOPIC_ID = "topic_id";
    public static final String TOPIC_NAME = "topic_name";
    public static final String TOTAL = "total";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_SEX = "user_sex";
    private boolean isForResult;
    private ServiceConnection mClientConnection;
    private Messenger mClientMessenger;
    private Class<?> mComponentClass;
    private Context mContext;
    private Intent mIntent;
    private IntentAction mIntentAction;
    private Messenger mReplyMessenger;
    private int mRequestCode;
    private ServiceConnection mServiceConnection;
    private int mServiceConnectionFlags;

    public IntentConfig() {
        this.mContext = null;
        this.mIntent = null;
        this.mServiceConnection = null;
        this.mServiceConnectionFlags = 0;
        this.mComponentClass = null;
        this.mClientMessenger = new Messenger(new a(this, null));
        this.isForResult = false;
        this.mClientConnection = new b(this);
        this.mIntentAction = IntentAction.Activity;
    }

    public IntentConfig(Context context) {
        this.mContext = null;
        this.mIntent = null;
        this.mServiceConnection = null;
        this.mServiceConnectionFlags = 0;
        this.mComponentClass = null;
        this.mClientMessenger = new Messenger(new a(this, null));
        this.isForResult = false;
        this.mClientConnection = new b(this);
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

    public ServiceConnection getServiceConnection() {
        return this.mServiceConnection;
    }

    public void setServiceConnection(ServiceConnection serviceConnection) {
        this.mServiceConnection = serviceConnection;
    }

    public int getServiceConnectionFlags() {
        return this.mServiceConnectionFlags;
    }

    public void setServiceConnectionFlags(int i) {
        this.mServiceConnectionFlags = i;
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

    public void setComponentClass(Class<?> cls) {
        if (cls == null) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("IntentConfig setClass args exception!");
            }
            return;
        }
        this.mComponentClass = cls;
        if (this.mContext != null) {
            this.mIntent.setClass(this.mContext, this.mComponentClass);
        }
    }

    public void run() {
        if (isValid()) {
            if (this.mIntentAction == IntentAction.Activity) {
                startActivity(this.mComponentClass);
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

    public void startActivityForResult(int i, Class<?> cls) {
        Class<?> loadClass;
        setComponentClass(cls);
        if (this.mComponentClass != null && this.mContext != null) {
            String pluginNameByClassloader = PluginCenter.getInstance().getPluginNameByClassloader(this.mComponentClass.getClassLoader());
            if (TextUtils.isEmpty(pluginNameByClassloader) || pluginNameByClassloader.equals(BdBaseApplication.getInst().getPackageName())) {
                if (this.mIntent != null) {
                    try {
                        if (com.baidu.adp.plugin.pluginBase.c.class.isAssignableFrom(BdBaseApplication.getInst().getClassLoader().loadClass(this.mIntent.getComponent().getClassName()))) {
                            PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                            return;
                        }
                    } catch (Exception e) {
                        com.baidu.adp.plugin.b.a.lF().I("plugin_run_fail", pluginNameByClassloader);
                        BdLog.detailException(e);
                    }
                }
                try {
                    if (this.mComponentClass.getClassLoader() == null) {
                        loadClass = Class.forName(this.mComponentClass.getName());
                    } else {
                        loadClass = this.mComponentClass.getClassLoader().loadClass(this.mComponentClass.getName());
                    }
                    if (loadClass != null) {
                        startActivityForResult(i);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.plugin.b.a.lF().I("plugin_run_fail", pluginNameByClassloader);
                    BdLog.detailException(th);
                }
            } else if (!com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().bE(pluginNameByClassloader)) {
                PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
            }
        }
    }

    public void startService() {
        this.mContext.startService(this.mIntent);
    }

    public void startService(Class<?> cls) {
        setComponentClass(cls);
        if (this.mComponentClass != null && this.mContext != null) {
            String pluginNameByClassloader = PluginCenter.getInstance().getPluginNameByClassloader(this.mComponentClass.getClassLoader());
            if (TextUtils.isEmpty(pluginNameByClassloader) || pluginNameByClassloader.equals(BdBaseApplication.getInst().getPackageName())) {
                if (this.mIntent != null) {
                    try {
                        if (g.class.isAssignableFrom(BdBaseApplication.getInst().getClassLoader().loadClass(this.mIntent.getComponent().getClassName()))) {
                            PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                            return;
                        }
                    } catch (Exception e) {
                        com.baidu.adp.plugin.b.a.lF().I("plugin_run_fail", pluginNameByClassloader);
                        BdLog.detailException(e);
                    }
                }
                try {
                    this.mContext.startService(this.mIntent);
                } catch (Throwable th) {
                    com.baidu.adp.plugin.b.a.lF().I("plugin_run_fail", pluginNameByClassloader);
                    BdLog.detailException(th);
                }
            } else if (!com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().bE(pluginNameByClassloader)) {
                PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
            }
        }
    }

    public void stopService() {
        this.mContext.stopService(this.mIntent);
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public boolean startActivity(Class<?> cls) {
        Class<?> loadClass;
        boolean z = false;
        setComponentClass(cls);
        if (this.mComponentClass == null || this.mContext == null) {
            return false;
        }
        String pluginNameByClassloader = PluginCenter.getInstance().getPluginNameByClassloader(this.mComponentClass.getClassLoader());
        if (TextUtils.isEmpty(pluginNameByClassloader) || pluginNameByClassloader.equals(BdBaseApplication.getInst().getPackageName())) {
            if (this.mIntent != null) {
                try {
                    Class<?> loadClass2 = BdBaseApplication.getInst().getClassLoader().loadClass(this.mIntent.getComponent().getClassName());
                    if (loadClass2 != null && com.baidu.adp.plugin.pluginBase.c.class.isAssignableFrom(loadClass2)) {
                        PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                        return PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                    }
                } catch (Exception e) {
                    com.baidu.adp.plugin.b.a.lF().I("plugin_run_fail", pluginNameByClassloader);
                    BdLog.detailException(e);
                    return false;
                }
            }
            try {
                if (this.mComponentClass.getClassLoader() == null) {
                    loadClass = Class.forName(this.mComponentClass.getName());
                } else {
                    loadClass = this.mComponentClass.getClassLoader().loadClass(this.mComponentClass.getName());
                }
                if (loadClass != null) {
                    if (!(this.mContext instanceof Activity)) {
                        this.mIntent.addFlags(268435456);
                    }
                    this.mContext.startActivity(this.mIntent);
                    z = true;
                    return true;
                }
                return false;
            } catch (Throwable th) {
                com.baidu.adp.plugin.b.a.lF().I("plugin_run_fail", pluginNameByClassloader);
                BdLog.detailException(th);
                return z;
            }
        } else if (com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().bE(pluginNameByClassloader)) {
            return false;
        } else {
            return PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
        }
    }

    public void bindService(Class<?> cls) {
        setComponentClass(cls);
        if (this.mComponentClass != null && this.mContext != null) {
            String pluginNameByClassloader = PluginCenter.getInstance().getPluginNameByClassloader(this.mComponentClass.getClassLoader());
            if (TextUtils.isEmpty(pluginNameByClassloader) || pluginNameByClassloader.equals(BdBaseApplication.getInst().getPackageName())) {
                if (this.mIntent != null) {
                    try {
                        if (g.class.isAssignableFrom(BdBaseApplication.getInst().getClassLoader().loadClass(this.mIntent.getComponent().getClassName()))) {
                            PluginCenter.getInstance().bindService(this.mContext, pluginNameByClassloader, this.mIntent, this.mServiceConnection, this.mServiceConnectionFlags);
                            return;
                        }
                    } catch (Exception e) {
                        com.baidu.adp.plugin.b.a.lF().I("plugin_run_fail", pluginNameByClassloader);
                        BdLog.detailException(e);
                    }
                }
                try {
                    this.mContext.bindService(this.mIntent, this.mServiceConnection, this.mServiceConnectionFlags);
                } catch (Throwable th) {
                    com.baidu.adp.plugin.b.a.lF().I("plugin_run_fail", pluginNameByClassloader);
                    BdLog.detailException(th);
                }
            } else if (!com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().bE(pluginNameByClassloader)) {
                PluginCenter.getInstance().bindService(this.mContext, pluginNameByClassloader, this.mIntent, this.mServiceConnection, this.mServiceConnectionFlags);
            }
        }
    }

    public void startActivityForRemote(Class<?> cls) {
        setComponentClass(cls);
        Intent intent = new Intent();
        intent.setClass(this.mContext, RemoteActivityProxyService.class);
        com.baidu.adp.lib.g.i.a(this.mContext, intent, this.mClientConnection, 1);
    }

    public void startActivityForResultForRemote(int i, Class<?> cls) {
        setRequestCode(i);
        this.isForResult = true;
        setComponentClass(cls);
        Intent intent = new Intent();
        intent.setClass(this.mContext, RemoteActivityProxyService.class);
        com.baidu.adp.lib.g.i.a(this.mContext, intent, this.mClientConnection, 1);
    }

    public void startActivityForXiaoying(Class<?> cls) {
        this.isForResult = true;
        setComponentClass(cls);
        Intent intent = new Intent();
        intent.setClass(this.mContext, XiaoyingActivityProxyService.class);
        com.baidu.adp.lib.g.i.a(this.mContext, intent, this.mClientConnection, 1);
    }

    /* loaded from: classes.dex */
    private class a extends Handler {
        private a() {
        }

        /* synthetic */ a(IntentConfig intentConfig, a aVar) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (IntentConfig.this.mContext != null) {
                if (isMsgValid(message)) {
                    if (IntentConfig.this.isForResult) {
                        IntentConfig.this.startActivityForResult(IntentConfig.this.mRequestCode, IntentConfig.this.mComponentClass);
                    } else {
                        IntentConfig.this.startActivity(IntentConfig.this.mComponentClass);
                    }
                }
                com.baidu.adp.lib.g.i.a(IntentConfig.this.mContext, IntentConfig.this.mClientConnection);
                IntentConfig.this.mContext = null;
            }
        }

        private boolean isMsgValid(Message message) {
            return message != null && message.what == 0 && message.arg1 == 1;
        }
    }
}

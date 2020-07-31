package com.baidu.tbadk.core.frameworkData;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.base.f;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class IntentConfig extends OrmObject {
    public static final String AB_TAG = "ab_tag";
    public static final String CALL_FROM = "call_from";
    public static final String CARD_TYPE = "card_type";
    public static final String CLOSE = "close";
    public static final String CMD = "cmd";
    public static final String DATAS = "datas";
    public static final String EXTRA = "extra";
    public static final String FORUM_AVATAR = "forum_avatar";
    public static final String FORUM_FIRST_DIR = "forum_first_dir";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String FORUM_SECOND_DIR = "forum_second_dir";
    public static final String FROM = "from";
    public static final int FROM_VALUE_LOGIN = 1;
    public static final int FROM_VALUE_NOTLOGIN_GUIDE = 4;
    public static final int FROM_VALUE_REGISTER = 2;
    public static final int FROM_VALUE_VISITOR = 3;
    public static final String FRS_MANAGER = "frs_manager";
    public static final String GROUP_ID = "group_id";
    public static final String GROUP_NAME = "group_name";
    public static final String HOT_TOPIC_CHANGE_FOURM = "hot_topic_change_fourm";
    public static final int IMAGE_DETAIL_FROM_FORUM = 1;
    public static final int IMAGE_DETAIL_FROM_GCHAT = 3;
    public static final int IMAGE_DETAIL_FROM_PCHAT = 2;
    public static final String INTENT_KEY_START_TIME = "TibaStatic.StartTime";
    public static final String IS_ACCEPT_NOTIFY = "is_accept_notify";
    public static final String IS_BJH_USER = "is_bjh_user";
    public static final String IS_DOWNLOADING = "is_downloading";
    public static final String IS_FROM_PB = "is_from_pb";
    public static final String IS_MASK = "isMask";
    public static final String IS_NEED_MULTIPLE = "is_need_multiple";
    public static final String KEY_AI_APP_SCHEMA = "KEY_AI_APP_SCHEMA";
    public static final String KEY_ALBUM_THREAD = "album_thread";
    public static final String KEY_CAN_EDIT_IMAGE = "can_edit_image";
    public static final String KEY_CAN_SELECT_VIDEO = "can_select_video";
    public static final String KEY_FROM_TYPE = "from_type";
    public static final String KEY_FROM_WRITEACTIVITY = "from_write";
    public static final String KEY_TAB_LIST = "tab_list";
    public static final String KEY_URI = "key_uri";
    private static final long LAUNCH_ACTIVITY_INTERVAL_TIME = 500;
    public static final String LIST = "list";
    public static final String LIST_TYPE = "list_type";
    public static final String MASK_TYPE = "maskType";
    public static final String MEMBER_BUY_SHOW = "member_buy_show";
    public static final String NAME_SHOW = "name_show";
    public static final String NID = "nid";
    public static final String PKG_ID = "pkg_id";
    public static final String PORTRAIT = "portrait";
    public static final String POST_DESC = "post_desc";
    public static final String POST_ID = "post_id";
    public static final String PRE_PAGE_ID = "pre_page_id";
    public static final String PUBLISHER_ID = "publisher_id";
    public static final String PUBLISHER_NAME = "publisher_name";
    public static final String RECOM_SOURCE = "recom_source";
    public static final String REPLAY_URL = "replay_url";
    public static final String REQUEST_CODE = "request_code";
    public static final String SEARCH_MAJOR_NAME = "major_name";
    public static final String SHARE_THREAD_ID = "share_thread_id";
    public static final String SHARE_TOAST_STATUS = "status";
    public static final String SHOW_KEYBOARD = "keyboard";
    public static final String SHOW_RECOMMEND = "show_recommend";
    public static final String SOURCE_RECT_IN_SCREEN = "source_rect_in_screen";
    public static final String START = "start";
    public static final String START_ONCE = "start_once";
    public static final String STOP = "stop";
    public static final String ST_TYPE = "st_type";
    public static final String THREAD_ID = "thread_id";
    public static final String TOPIC_FID = "topic_fid";
    public static final String TOPIC_FIRST_DIR = "topic_first_dir";
    public static final String TOPIC_ID = "topic_id";
    public static final String TOPIC_NAME = "topic_name";
    public static final String TOPIC_SECOND_DIR = "topic_second_dir";
    public static final String TOPIC_TID = "topic_tid";
    public static final String TOTAL = "total";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_SEX = "user_sex";
    public static final String VIDEO_EASTER_EGG_DATA = "video_easter_egg_data";
    public static final String WEIGHT = "weight";
    public static final String WRITE_VOTE_DATA = "write_vote_data";
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
    private static long lastStartActivityTime = 0;
    private static Class<?> lastStartActivityClass = null;

    public IntentConfig() {
        this.mContext = null;
        this.mIntent = null;
        this.mServiceConnection = null;
        this.mServiceConnectionFlags = 0;
        this.mComponentClass = null;
        this.mClientMessenger = new Messenger(new a());
        this.isForResult = false;
        this.mClientConnection = new ServiceConnection() { // from class: com.baidu.tbadk.core.frameworkData.IntentConfig.1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (iBinder != null) {
                    IntentConfig.this.mReplyMessenger = new Messenger(iBinder);
                    if (IntentConfig.this.mReplyMessenger != null) {
                        Message obtain = Message.obtain();
                        Bundle bundle = new Bundle();
                        if (IntentConfig.this.mComponentClass != null) {
                            bundle.putString(DealIntentService.KEY_CLASS, IntentConfig.this.mComponentClass.getName());
                        }
                        obtain.setData(bundle);
                        obtain.replyTo = IntentConfig.this.mClientMessenger;
                        try {
                            IntentConfig.this.mReplyMessenger.send(obtain);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        this.mIntentAction = IntentAction.Activity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: android.content.Intent */
    /* JADX WARN: Multi-variable type inference failed */
    public void addSourceTraceForPageStayDurationStat() {
        ArrayList arrayList;
        if (this.mIntent != null) {
            f<?> F = i.F(this.mContext);
            if (!(F instanceof com.baidu.tbadk.m.a)) {
                arrayList = null;
            } else {
                arrayList = (ArrayList) ((com.baidu.tbadk.m.a) F).getNextPageSourceKeyList();
            }
            if (!x.isEmpty(arrayList)) {
                this.mIntent.putStringArrayListExtra("obj_source", arrayList);
            }
        }
    }

    private void addPageSourceTrace() {
        com.baidu.tbadk.pageInfo.b bVar;
        if (this.mIntent != null && this.mContext != null) {
            f<?> F = i.F(this.mContext);
            if (!(F instanceof com.baidu.tbadk.pageInfo.a)) {
                bVar = null;
            } else {
                bVar = ((com.baidu.tbadk.pageInfo.a) F).getTbPageInfo();
            }
            if (bVar != null) {
                this.mIntent.putExtra("tb_page_tag_source_trace", bVar.blj());
            }
        }
    }

    public void addPreSourceTrace() {
        if (this.mIntent != null && this.mContext != null) {
            com.baidu.tbadk.l.b dZ = com.baidu.tbadk.l.c.dZ(this.mContext);
            ArrayList<String> blf = dZ == null ? null : dZ.blf();
            if (!x.isEmpty(blf)) {
                this.mIntent.putStringArrayListExtra("tb_page_extar_source_list", blf);
            }
        }
    }

    public void addPreSourceTrace(String str) {
        if (this.mIntent != null && this.mContext != null) {
            com.baidu.tbadk.l.b dZ = com.baidu.tbadk.l.c.dZ(this.mContext);
            ArrayList<String> d = com.baidu.tbadk.l.c.d(dZ == null ? null : dZ.ble(), str);
            if (!x.isEmpty(d)) {
                this.mIntent.putStringArrayListExtra("tb_page_extar_source_list", d);
            }
        }
    }

    public IntentConfig(Context context) {
        this.mContext = null;
        this.mIntent = null;
        this.mServiceConnection = null;
        this.mServiceConnectionFlags = 0;
        this.mComponentClass = null;
        this.mClientMessenger = new Messenger(new a());
        this.isForResult = false;
        this.mClientConnection = new ServiceConnection() { // from class: com.baidu.tbadk.core.frameworkData.IntentConfig.1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (iBinder != null) {
                    IntentConfig.this.mReplyMessenger = new Messenger(iBinder);
                    if (IntentConfig.this.mReplyMessenger != null) {
                        Message obtain = Message.obtain();
                        Bundle bundle = new Bundle();
                        if (IntentConfig.this.mComponentClass != null) {
                            bundle.putString(DealIntentService.KEY_CLASS, IntentConfig.this.mComponentClass.getName());
                        }
                        obtain.setData(bundle);
                        obtain.replyTo = IntentConfig.this.mClientMessenger;
                        try {
                            IntentConfig.this.mReplyMessenger.send(obtain);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        this.mIntentAction = IntentAction.Activity;
        if (context == null) {
            throw new InvalidParameterException("ActivitySwitch context null");
        }
        this.mContext = context;
        this.mIntent = new Intent();
        addSourceTraceForPageStayDurationStat();
        addPageSourceTrace();
        addPreSourceTrace();
    }

    public Context getContext() {
        return this.mContext;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
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
                startActivityForResult(this.mRequestCode, this.mComponentClass);
            } else if (this.mIntentAction == IntentAction.StartService) {
                startService();
            } else if (this.mIntentAction == IntentAction.StopService) {
                stopService();
            }
        }
    }

    public void startActivityForResult(int i) {
        if (checkStartActivityInterval(this.mComponentClass) && (this.mContext instanceof Activity)) {
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
                        if (PluginBaseActivity.class.isAssignableFrom(BdBaseApplication.getInst().getClassLoader().loadClass(this.mIntent.getComponent().getClassName()))) {
                            PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                            return;
                        }
                    } catch (Exception e) {
                        com.baidu.adp.plugin.b.a.nY().C("plugin_run_fail", pluginNameByClassloader);
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
                    com.baidu.adp.plugin.b.a.nY().C("plugin_run_fail", pluginNameByClassloader);
                    BdLog.detailException(th);
                }
            } else if (!com.baidu.adp.plugin.packageManager.pluginSettings.c.oR().cF(pluginNameByClassloader)) {
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
                        if (PluginBaseService.class.isAssignableFrom(BdBaseApplication.getInst().getClassLoader().loadClass(this.mIntent.getComponent().getClassName()))) {
                            PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                            return;
                        }
                    } catch (Exception e) {
                        com.baidu.adp.plugin.b.a.nY().C("plugin_run_fail", pluginNameByClassloader);
                        BdLog.detailException(e);
                    }
                }
                try {
                    this.mContext.startService(this.mIntent);
                } catch (Throwable th) {
                    com.baidu.adp.plugin.b.a.nY().C("plugin_run_fail", pluginNameByClassloader);
                    BdLog.detailException(th);
                }
            } else if (!com.baidu.adp.plugin.packageManager.pluginSettings.c.oR().cF(pluginNameByClassloader)) {
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

    public void preJump() {
    }

    public boolean startActivity(Class<?> cls) {
        Class<?> loadClass;
        boolean z = false;
        preJump();
        setComponentClass(cls);
        if (this.mComponentClass == null || this.mContext == null || !checkStartActivityInterval(this.mComponentClass)) {
            return false;
        }
        String pluginNameByClassloader = PluginCenter.getInstance().getPluginNameByClassloader(this.mComponentClass.getClassLoader());
        if (TextUtils.isEmpty(pluginNameByClassloader) || pluginNameByClassloader.equals(BdBaseApplication.getInst().getPackageName())) {
            if (this.mIntent != null) {
                try {
                    Class<?> loadClass2 = BdBaseApplication.getInst().getClassLoader().loadClass(this.mIntent.getComponent().getClassName());
                    if (loadClass2 != null && PluginBaseActivity.class.isAssignableFrom(loadClass2)) {
                        PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                        return PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                    }
                } catch (Exception e) {
                    com.baidu.adp.plugin.b.a.nY().C("plugin_run_fail", pluginNameByClassloader);
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
                com.baidu.adp.plugin.b.a.nY().C("plugin_run_fail", pluginNameByClassloader);
                BdLog.detailException(th);
                return z;
            }
        } else if (com.baidu.adp.plugin.packageManager.pluginSettings.c.oR().cF(pluginNameByClassloader)) {
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
                        if (PluginBaseService.class.isAssignableFrom(BdBaseApplication.getInst().getClassLoader().loadClass(this.mIntent.getComponent().getClassName()))) {
                            PluginCenter.getInstance().bindService(this.mContext, pluginNameByClassloader, this.mIntent, this.mServiceConnection, this.mServiceConnectionFlags);
                            return;
                        }
                    } catch (Exception e) {
                        com.baidu.adp.plugin.b.a.nY().C("plugin_run_fail", pluginNameByClassloader);
                        BdLog.detailException(e);
                    }
                }
                try {
                    this.mContext.bindService(this.mIntent, this.mServiceConnection, this.mServiceConnectionFlags);
                } catch (Throwable th) {
                    com.baidu.adp.plugin.b.a.nY().C("plugin_run_fail", pluginNameByClassloader);
                    BdLog.detailException(th);
                }
            } else if (!com.baidu.adp.plugin.packageManager.pluginSettings.c.oR().cF(pluginNameByClassloader)) {
                PluginCenter.getInstance().bindService(this.mContext, pluginNameByClassloader, this.mIntent, this.mServiceConnection, this.mServiceConnectionFlags);
            }
        }
    }

    public void startActivityForRemote(Class<?> cls) {
        setComponentClass(cls);
        Intent intent = new Intent();
        intent.setClass(this.mContext, RemoteActivityProxyService.class);
        com.baidu.adp.lib.f.f.bindService(this.mContext, intent, this.mClientConnection, 1);
    }

    public void startActivityForResultForRemote(int i, Class<?> cls) {
        setRequestCode(i);
        this.isForResult = true;
        setComponentClass(cls);
        Intent intent = new Intent();
        intent.setClass(this.mContext, RemoteActivityProxyService.class);
        com.baidu.adp.lib.f.f.bindService(this.mContext, intent, this.mClientConnection, 1);
    }

    private static boolean checkStartActivityInterval(Class<?> cls) {
        long currentTimeMillis = System.currentTimeMillis();
        if (cls == lastStartActivityClass && Math.abs(currentTimeMillis - lastStartActivityTime) < LAUNCH_ACTIVITY_INTERVAL_TIME) {
            return false;
        }
        lastStartActivityTime = currentTimeMillis;
        lastStartActivityClass = cls;
        return true;
    }

    /* loaded from: classes.dex */
    private class a extends Handler {
        private a() {
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
                com.baidu.adp.lib.f.f.unbindService(IntentConfig.this.mContext, IntentConfig.this.mClientConnection);
            }
        }

        private boolean isMsgValid(Message message) {
            return message != null && message.what == 0 && message.arg1 == 1;
        }
    }

    public boolean asynStart() {
        return false;
    }

    public void start() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, this));
    }
}

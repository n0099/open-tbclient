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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import d.b.b.a.g;
import d.b.b.a.j;
import d.b.b.e.m.f;
import d.b.b.h.j.g.d;
import d.b.h0.i0.c;
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
    public static final String IS_EVALUATE = "is_evaluate";
    public static final String IS_FROM_PB = "is_from_pb";
    public static final String IS_ITEM_DETAIL = "is_item_detail";
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
    public static final long LAUNCH_ACTIVITY_INTERVAL_TIME = 500;
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
    public static final String URL = "url";
    public static final String USER_ID = "user_id";
    public static final String USER_LEVEL = "user_level";
    public static final String USER_NAME = "user_name";
    public static final String USER_SEX = "user_sex";
    public static final String VIDEO_EASTER_EGG_DATA = "video_easter_egg_data";
    public static final String WEIGHT = "weight";
    public static final String WRITE_VOTE_DATA = "write_vote_data";
    public static Class<?> lastStartActivityClass;
    public static long lastStartActivityTime;
    public boolean isForResult;
    public ServiceConnection mClientConnection;
    public Messenger mClientMessenger;
    public Class<?> mComponentClass;
    public Context mContext;
    public Intent mIntent;
    public IntentAction mIntentAction;
    public Messenger mReplyMessenger;
    public int mRequestCode;
    public ServiceConnection mServiceConnection;
    public int mServiceConnectionFlags;

    /* loaded from: classes3.dex */
    public class a implements ServiceConnection {
        public a() {
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
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Handler {
        public b() {
        }

        public final boolean a(Message message) {
            return message != null && message.what == 0 && message.arg1 == 1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (IntentConfig.this.mContext == null) {
                return;
            }
            if (a(message)) {
                if (IntentConfig.this.isForResult) {
                    IntentConfig intentConfig = IntentConfig.this;
                    intentConfig.startActivityForResult(intentConfig.mRequestCode, IntentConfig.this.mComponentClass);
                } else {
                    IntentConfig intentConfig2 = IntentConfig.this;
                    intentConfig2.startActivity(intentConfig2.mComponentClass);
                }
            }
            f.e(IntentConfig.this.mContext, IntentConfig.this.mClientConnection);
        }

        public /* synthetic */ b(IntentConfig intentConfig, a aVar) {
            this();
        }
    }

    public IntentConfig() {
        this.mContext = null;
        this.mIntent = null;
        this.mServiceConnection = null;
        this.mServiceConnectionFlags = 0;
        this.mComponentClass = null;
        this.mClientMessenger = new Messenger(new b(this, null));
        this.isForResult = false;
        this.mClientConnection = new a();
        this.mIntentAction = IntentAction.Activity;
    }

    private void addPageSourceTrace() {
        Context context;
        if (this.mIntent == null || (context = this.mContext) == null) {
            return;
        }
        g<?> b2 = j.b(context);
        d.b.h0.j0.b tbPageInfo = b2 instanceof d.b.h0.j0.a ? ((d.b.h0.j0.a) b2).getTbPageInfo() : null;
        if (tbPageInfo != null) {
            this.mIntent.putExtra("tb_page_tag_source_trace", tbPageInfo.a());
        }
    }

    public static boolean checkStartActivityInterval(Class<?> cls) {
        long currentTimeMillis = System.currentTimeMillis();
        if (cls != lastStartActivityClass || Math.abs(currentTimeMillis - lastStartActivityTime) >= 500) {
            lastStartActivityTime = currentTimeMillis;
            lastStartActivityClass = cls;
            return true;
        }
        return false;
    }

    public void addPreSourceTrace() {
        Context context;
        if (this.mIntent == null || (context = this.mContext) == null) {
            return;
        }
        c k = TbPageExtraHelper.k(context);
        ArrayList<String> b2 = k == null ? null : k.b();
        if (ListUtils.isEmpty(b2)) {
            return;
        }
        if (k != null) {
            TbPageExtraHelper.u(k.a());
            d.b.h0.f0.g.g(new PrePageKeyEvent(TbPageExtraHelper.m()));
        }
        this.mIntent.putStringArrayListExtra("tb_page_extar_source_list", b2);
    }

    public void addSourceTraceForPageStayDurationStat() {
        if (this.mIntent != null) {
            g<?> b2 = j.b(this.mContext);
            ArrayList<String> arrayList = b2 instanceof d.b.h0.k0.a ? (ArrayList) ((d.b.h0.k0.a) b2).getNextPageSourceKeyList() : null;
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            this.mIntent.putStringArrayListExtra("obj_source", arrayList);
        }
    }

    public boolean asynStart() {
        return false;
    }

    public void bindService(Class<?> cls) {
        setComponentClass(cls);
        if (this.mComponentClass == null || this.mContext == null) {
            return;
        }
        String pluginNameByClassloader = PluginCenter.getInstance().getPluginNameByClassloader(this.mComponentClass.getClassLoader());
        if (!TextUtils.isEmpty(pluginNameByClassloader) && !pluginNameByClassloader.equals(BdBaseApplication.getInst().getPackageName())) {
            if (d.k().n(pluginNameByClassloader)) {
                return;
            }
            PluginCenter.getInstance().bindService(this.mContext, pluginNameByClassloader, this.mIntent, this.mServiceConnection, this.mServiceConnectionFlags);
            return;
        }
        Intent intent = this.mIntent;
        if (intent != null) {
            try {
                if (PluginBaseService.class.isAssignableFrom(BdBaseApplication.getInst().getClassLoader().loadClass(intent.getComponent().getClassName()))) {
                    PluginCenter.getInstance().bindService(this.mContext, pluginNameByClassloader, this.mIntent, this.mServiceConnection, this.mServiceConnectionFlags);
                    return;
                }
            } catch (Exception e2) {
                d.b.b.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
                BdLog.detailException(e2);
            }
        }
        try {
            this.mContext.bindService(this.mIntent, this.mServiceConnection, this.mServiceConnectionFlags);
        } catch (Throwable th) {
            d.b.b.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
            BdLog.detailException(th);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public ServiceConnection getServiceConnection() {
        return this.mServiceConnection;
    }

    public int getServiceConnectionFlags() {
        return this.mServiceConnectionFlags;
    }

    public boolean isValid() {
        return true;
    }

    public void preJump() {
    }

    public void run() {
        if (isValid()) {
            IntentAction intentAction = this.mIntentAction;
            if (intentAction == IntentAction.Activity) {
                startActivity(this.mComponentClass);
            } else if (intentAction == IntentAction.ActivityForResult) {
                startActivityForResult(this.mRequestCode, this.mComponentClass);
            } else if (intentAction == IntentAction.StartService) {
                startService();
            } else if (intentAction == IntentAction.StopService) {
                stopService();
            }
        }
    }

    public void setComponentClass(Class<?> cls) {
        if (cls == null) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                throw new IllegalArgumentException("IntentConfig setClass args exception!");
            }
            return;
        }
        this.mComponentClass = cls;
        Context context = this.mContext;
        if (context != null) {
            this.mIntent.setClass(context, cls);
        }
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setIntentAction(IntentAction intentAction) {
        this.mIntentAction = intentAction;
    }

    public void setRequestCode(int i) {
        this.mRequestCode = i;
    }

    public void setServiceConnection(ServiceConnection serviceConnection) {
        this.mServiceConnection = serviceConnection;
    }

    public void setServiceConnectionFlags(int i) {
        this.mServiceConnectionFlags = i;
    }

    public void start() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this));
    }

    public boolean startActivity(Class<?> cls) {
        Class<?> loadClass;
        preJump();
        setComponentClass(cls);
        Class<?> cls2 = this.mComponentClass;
        if (cls2 == null || this.mContext == null || !checkStartActivityInterval(cls2)) {
            return false;
        }
        String pluginNameByClassloader = PluginCenter.getInstance().getPluginNameByClassloader(this.mComponentClass.getClassLoader());
        if (!TextUtils.isEmpty(pluginNameByClassloader) && !pluginNameByClassloader.equals(BdBaseApplication.getInst().getPackageName())) {
            if (d.k().n(pluginNameByClassloader)) {
                return false;
            }
            return PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
        }
        Intent intent = this.mIntent;
        if (intent != null) {
            try {
                Class<?> loadClass2 = BdBaseApplication.getInst().getClassLoader().loadClass(intent.getComponent().getClassName());
                if (loadClass2 != null && PluginBaseActivity.class.isAssignableFrom(loadClass2)) {
                    PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                    return PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                }
            } catch (Exception e2) {
                d.b.b.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
                BdLog.detailException(e2);
                return false;
            }
        }
        try {
            if (this.mComponentClass.getClassLoader() == null) {
                loadClass = Class.forName(this.mComponentClass.getName());
            } else {
                loadClass = this.mComponentClass.getClassLoader().loadClass(this.mComponentClass.getName());
            }
            if (loadClass == null) {
                return false;
            }
            if (!(this.mContext instanceof Activity)) {
                this.mIntent.addFlags(268435456);
            }
            this.mContext.startActivity(this.mIntent);
            return true;
        } catch (Throwable th) {
            d.b.b.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
            BdLog.detailException(th);
            return false;
        }
    }

    public void startActivityForRemote(Class<?> cls) {
        setComponentClass(cls);
        Intent intent = new Intent();
        intent.setClass(this.mContext, RemoteActivityProxyService.class);
        f.a(this.mContext, intent, this.mClientConnection, 1);
    }

    public void startActivityForResult(int i) {
        if (checkStartActivityInterval(this.mComponentClass)) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(this.mIntent, i);
            }
        }
    }

    public void startActivityForResultForRemote(int i, Class<?> cls) {
        setRequestCode(i);
        this.isForResult = true;
        setComponentClass(cls);
        Intent intent = new Intent();
        intent.setClass(this.mContext, RemoteActivityProxyService.class);
        f.a(this.mContext, intent, this.mClientConnection, 1);
    }

    public void startService() {
        this.mContext.startService(this.mIntent);
    }

    public void stopService() {
        this.mContext.stopService(this.mIntent);
    }

    public void startService(Class<?> cls) {
        setComponentClass(cls);
        if (this.mComponentClass == null || this.mContext == null) {
            return;
        }
        String pluginNameByClassloader = PluginCenter.getInstance().getPluginNameByClassloader(this.mComponentClass.getClassLoader());
        if (!TextUtils.isEmpty(pluginNameByClassloader) && !pluginNameByClassloader.equals(BdBaseApplication.getInst().getPackageName())) {
            if (d.k().n(pluginNameByClassloader)) {
                return;
            }
            PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
            return;
        }
        Intent intent = this.mIntent;
        if (intent != null) {
            try {
                if (PluginBaseService.class.isAssignableFrom(BdBaseApplication.getInst().getClassLoader().loadClass(intent.getComponent().getClassName()))) {
                    PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                    return;
                }
            } catch (Exception e2) {
                d.b.b.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
                BdLog.detailException(e2);
            }
        }
        try {
            this.mContext.startService(this.mIntent);
        } catch (Throwable th) {
            d.b.b.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
            BdLog.detailException(th);
        }
    }

    public void startActivityForResult(int i, Class<?> cls) {
        Class<?> loadClass;
        setComponentClass(cls);
        if (this.mComponentClass == null || this.mContext == null) {
            return;
        }
        String pluginNameByClassloader = PluginCenter.getInstance().getPluginNameByClassloader(this.mComponentClass.getClassLoader());
        if (!TextUtils.isEmpty(pluginNameByClassloader) && !pluginNameByClassloader.equals(BdBaseApplication.getInst().getPackageName())) {
            if (d.k().n(pluginNameByClassloader)) {
                return;
            }
            PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
            return;
        }
        Intent intent = this.mIntent;
        if (intent != null) {
            try {
                if (PluginBaseActivity.class.isAssignableFrom(BdBaseApplication.getInst().getClassLoader().loadClass(intent.getComponent().getClassName()))) {
                    PluginCenter.getInstance().launchIntent(this.mContext, pluginNameByClassloader, this.mIntent);
                    return;
                }
            } catch (Exception e2) {
                d.b.b.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
                BdLog.detailException(e2);
            }
        }
        try {
            if (this.mComponentClass.getClassLoader() == null) {
                loadClass = Class.forName(this.mComponentClass.getName());
            } else {
                loadClass = this.mComponentClass.getClassLoader().loadClass(this.mComponentClass.getName());
            }
            if (loadClass == null) {
                return;
            }
            startActivityForResult(i);
        } catch (Throwable th) {
            d.b.b.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
            BdLog.detailException(th);
        }
    }

    public void addPreSourceTrace(String str) {
        Context context;
        if (this.mIntent == null || (context = this.mContext) == null) {
            return;
        }
        c k = TbPageExtraHelper.k(context);
        ArrayList<String> c2 = TbPageExtraHelper.c(k == null ? null : k.c(), str);
        if (ListUtils.isEmpty(c2)) {
            return;
        }
        this.mIntent.putStringArrayListExtra("tb_page_extar_source_list", c2);
    }

    public IntentConfig(Context context) {
        this.mContext = null;
        this.mIntent = null;
        this.mServiceConnection = null;
        this.mServiceConnectionFlags = 0;
        this.mComponentClass = null;
        this.mClientMessenger = new Messenger(new b(this, null));
        this.isForResult = false;
        this.mClientConnection = new a();
        this.mIntentAction = IntentAction.Activity;
        if (context != null) {
            this.mContext = context;
            this.mIntent = new Intent();
            addSourceTraceForPageStayDurationStat();
            addPageSourceTrace();
            addPreSourceTrace();
            return;
        }
        throw new InvalidParameterException("ActivitySwitch context null");
    }
}

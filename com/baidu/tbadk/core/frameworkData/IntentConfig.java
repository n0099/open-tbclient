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
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.g;
import c.a.e.a.j;
import c.a.e.e.m.f;
import c.a.e.h.j.g.d;
import c.a.q0.j0.h;
import c.a.q0.m0.c;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.pluginBase.PluginBaseActivity;
import com.baidu.adp.plugin.pluginBase.PluginBaseService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class IntentConfig extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AB_TAG = "ab_tag";
    public static final String AT_SELECT_LIST_DATA = "at_select_list_data";
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
    public static final String IS_VIDEO_THREAD = "is_video_thread";
    public static final String IS_VIDEO_TOPIC = "is_video_topic";
    public static final String KEY_AI_APP_SCHEMA = "KEY_AI_APP_SCHEMA";
    public static final String KEY_ALBUM_THREAD = "album_thread";
    public static final String KEY_CAN_EDIT_IMAGE = "can_edit_image";
    public static final String KEY_CAN_SELECT_GIF = "can_select_gif";
    public static final String KEY_CAN_SELECT_ONLY_VIDEO = "can_select_only_video";
    public static final String KEY_CAN_SELECT_VIDEO = "can_select_video";
    public static final String KEY_FORCE_INTERCEPT_STIME_STAT = "key_force_intercept_stime_stat";
    public static final String KEY_FROM_TYPE = "from_type";
    public static final String KEY_FROM_WRITE_TYPE = "from_write_type";
    public static final String KEY_IMAGE_CLIP_TYPE = "image_clip_type";
    public static final String KEY_NEED_CLIP_IMAGE = "need_clip_image";
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
    public static final String START_ACTION = "start";
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
    public static final String VIDEO_PERSON_FROM = "video_person_from";
    public static final String WEIGHT = "weight";
    public static final String WRITE_VOTE_DATA = "write_vote_data";
    public static Class<?> lastStartActivityClass;
    public static long lastStartActivityTime;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* loaded from: classes6.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IntentConfig f47566e;

        public a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intentConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47566e = intentConfig;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) || iBinder == null) {
                return;
            }
            this.f47566e.mReplyMessenger = new Messenger(iBinder);
            if (this.f47566e.mReplyMessenger != null) {
                Message obtain = Message.obtain();
                Bundle bundle = new Bundle();
                if (this.f47566e.mComponentClass != null) {
                    bundle.putString(DealIntentService.KEY_CLASS, this.f47566e.mComponentClass.getName());
                }
                obtain.setData(bundle);
                obtain.replyTo = this.f47566e.mClientMessenger;
                try {
                    this.f47566e.mReplyMessenger.send(obtain);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IntentConfig f47567a;

        public b(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intentConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47567a = intentConfig;
        }

        public final boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) ? message != null && message.what == 0 && message.arg1 == 1 : invokeL.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) || this.f47567a.mContext == null) {
                return;
            }
            if (a(message)) {
                if (this.f47567a.isForResult) {
                    IntentConfig intentConfig = this.f47567a;
                    intentConfig.startActivityForResult(intentConfig.mRequestCode, this.f47567a.mComponentClass);
                } else {
                    IntentConfig intentConfig2 = this.f47567a;
                    intentConfig2.startActivity(intentConfig2.mComponentClass);
                }
            }
            f.e(this.f47567a.mContext, this.f47567a.mClientConnection);
        }

        public /* synthetic */ b(IntentConfig intentConfig, a aVar) {
            this(intentConfig);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(846997993, "Lcom/baidu/tbadk/core/frameworkData/IntentConfig;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(846997993, "Lcom/baidu/tbadk/core/frameworkData/IntentConfig;");
        }
    }

    public IntentConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mIntent = null;
        this.mServiceConnection = null;
        this.mServiceConnectionFlags = 0;
        this.mComponentClass = null;
        this.mClientMessenger = new Messenger(new b(this, null));
        this.isForResult = false;
        this.mClientConnection = new a(this);
        this.mIntentAction = IntentAction.Activity;
    }

    private void addPageSourceTrace() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.mIntent == null || (context = this.mContext) == null) {
            return;
        }
        g<?> b2 = j.b(context);
        c.a.q0.n0.b tbPageInfo = b2 instanceof c.a.q0.n0.a ? ((c.a.q0.n0.a) b2).getTbPageInfo() : null;
        if (tbPageInfo != null) {
            this.mIntent.putExtra("tb_page_tag_source_trace", tbPageInfo.a());
        }
    }

    public static boolean checkStartActivityInterval(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, cls)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (cls != lastStartActivityClass || Math.abs(currentTimeMillis - lastStartActivityTime) >= 500) {
                lastStartActivityTime = currentTimeMillis;
                lastStartActivityClass = cls;
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void addPreSourceTrace() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.mIntent == null || (context = this.mContext) == null) {
            return;
        }
        c k = TbPageExtraHelper.k(context);
        ArrayList<String> b2 = k == null ? null : k.b();
        if (ListUtils.isEmpty(b2)) {
            return;
        }
        if (k != null) {
            TbPageExtraHelper.v(k.a());
            h.i(new PrePageKeyEvent(TbPageExtraHelper.m()));
        }
        this.mIntent.putStringArrayListExtra("tb_page_extar_source_list", b2);
    }

    public void addSourceTraceForPageStayDurationStat() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.mIntent == null) {
            return;
        }
        g<?> b2 = j.b(this.mContext);
        ArrayList<String> arrayList = b2 instanceof c.a.q0.o0.a ? (ArrayList) ((c.a.q0.o0.a) b2).getNextPageSourceKeyList() : null;
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        this.mIntent.putStringArrayListExtra("obj_source", arrayList);
    }

    public boolean asynStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void bindService(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cls) == null) {
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
                    c.a.e.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
                    BdLog.detailException(e2);
                }
            }
            try {
                this.mContext.bindService(this.mIntent, this.mServiceConnection, this.mServiceConnectionFlags);
            } catch (Throwable th) {
                c.a.e.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
                BdLog.detailException(th);
            }
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mIntent : (Intent) invokeV.objValue;
    }

    public int getRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mRequestCode : invokeV.intValue;
    }

    public ServiceConnection getServiceConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mServiceConnection : (ServiceConnection) invokeV.objValue;
    }

    public int getServiceConnectionFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mServiceConnectionFlags : invokeV.intValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void preJump() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void run() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && isValid()) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cls) == null) {
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
    }

    public void setForceInterceptStimeStat(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (intent = getIntent()) == null) {
            return;
        }
        intent.putExtra(KEY_FORCE_INTERCEPT_STIME_STAT, z);
    }

    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, intent) == null) {
            this.mIntent = intent;
        }
    }

    public void setIntentAction(IntentAction intentAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, intentAction) == null) {
            this.mIntentAction = intentAction;
        }
    }

    public void setRequestCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.mRequestCode = i2;
        }
    }

    public void setServiceConnection(ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, serviceConnection) == null) {
            this.mServiceConnection = serviceConnection;
        }
    }

    public void setServiceConnectionFlags(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.mServiceConnectionFlags = i2;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this));
        }
    }

    public boolean startActivity(Class<?> cls) {
        InterceptResult invokeL;
        Class<?> loadClass;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, cls)) == null) {
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
                    c.a.e.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
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
                if (this.mIntent != null && !(this.mContext instanceof Activity)) {
                    this.mIntent.addFlags(268435456);
                }
                this.mContext.startActivity(this.mIntent);
                return true;
            } catch (Throwable th) {
                c.a.e.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
                BdLog.detailException(th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void startActivityForRemote(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, cls) == null) {
            setComponentClass(cls);
            Intent intent = new Intent();
            intent.setClass(this.mContext, RemoteActivityProxyService.class);
            f.a(this.mContext, intent, this.mClientConnection, 1);
        }
    }

    public void startActivityForResult(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && checkStartActivityInterval(this.mComponentClass)) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(this.mIntent, i2);
            }
        }
    }

    public void startActivityForResultForRemote(int i2, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048601, this, i2, cls) == null) {
            setRequestCode(i2);
            this.isForResult = true;
            setComponentClass(cls);
            Intent intent = new Intent();
            intent.setClass(this.mContext, RemoteActivityProxyService.class);
            f.a(this.mContext, intent, this.mClientConnection, 1);
        }
    }

    public void startService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.mContext.startService(this.mIntent);
        }
    }

    public void stopService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.mContext.stopService(this.mIntent);
        }
    }

    public void startService(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cls) == null) {
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
                    c.a.e.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
                    BdLog.detailException(e2);
                }
            }
            try {
                this.mContext.startService(this.mIntent);
            } catch (Throwable th) {
                c.a.e.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
                BdLog.detailException(th);
            }
        }
    }

    public void startActivityForResult(int i2, Class<?> cls) {
        Class<?> loadClass;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i2, cls) == null) {
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
                    c.a.e.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
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
                startActivityForResult(i2);
            } catch (Throwable th) {
                c.a.e.h.h.a.b().i("plugin_run_fail", pluginNameByClassloader);
                BdLog.detailException(th);
            }
        }
    }

    public void addPreSourceTrace(String str) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.mIntent == null || (context = this.mContext) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mContext = null;
        this.mIntent = null;
        this.mServiceConnection = null;
        this.mServiceConnectionFlags = 0;
        this.mComponentClass = null;
        this.mClientMessenger = new Messenger(new b(this, null));
        this.isForResult = false;
        this.mClientConnection = new a(this);
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

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.log.ActivityLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.mutiprocess.prePageKey.PrePageKeyEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.gp5;
import com.baidu.tieba.kr5;
import com.baidu.tieba.l9;
import com.baidu.tieba.nr5;
import com.baidu.tieba.or5;
import com.baidu.tieba.q9;
import com.baidu.tieba.qr5;
import com.baidu.tieba.wg;
import com.baidu.tieba.wq8;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class IntentConfig extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AB_TAG = "ab_tag";
    public static final String AT_SELECT_LIST_DATA = "at_select_list_data";
    public static final String BACK_SCHEME = "backScheme";
    public static final String BJH_POST_ID = "bjh_post_id";
    public static final String CALL_FROM = "call_from";
    public static final String CARD_TYPE = "card_type";
    public static final String CLOSE = "close";
    public static final String DATAS = "datas";
    public static final String EXTRA = "extra";
    public static final String FORUM_FIRST_DIR = "forum_first_dir";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String FORUM_SECOND_DIR = "forum_second_dir";
    public static final String FROM = "from";
    public static final String GROUP_ID = "group_id";
    public static final String GROUP_NAME = "group_name";
    public static final int IMAGE_DETAIL_FROM_FORUM = 1;
    public static final int IMAGE_DETAIL_FROM_GCHAT = 3;
    public static final int IMAGE_DETAIL_FROM_PCHAT = 2;
    public static final String INTENT_KEY_START_TIME = "TibaStatic.StartTime";
    public static final String IS_ACCEPT_NOTIFY = "is_accept_notify";
    public static final String IS_AT_SELECT_BOT_DATA = "is_at_select_bot_data";
    public static final String IS_BJH_USER = "is_bjh_user";
    public static final String IS_DOWNLOADING = "is_downloading";
    public static final String IS_EVALUATE = "is_evaluate";
    public static final String IS_FROM_PB = "is_from_pb";
    public static final String IS_ITEM_DETAIL = "is_item_detail";
    public static final String IS_NEED_MULTIPLE = "is_need_multiple";
    public static final String IS_VIDEO_THREAD = "is_video_thread";
    public static final String IS_VIDEO_TOPIC = "is_video_topic";
    public static final String KEY_AI_APP_SCHEMA = "KEY_AI_APP_SCHEMA";
    public static final String KEY_ALBUM_THREAD = "album_thread";
    public static final String KEY_CAN_EDIT_IMAGE = "can_edit_image";
    public static final String KEY_CAN_SELECT_GIF = "can_select_gif";
    public static final String KEY_CAN_SELECT_ONLY_VIDEO = "can_select_only_video";
    public static final String KEY_CAN_SELECT_VIDEO = "can_select_video";
    public static final String KEY_COVER_PATH = "key_cover_path";
    public static final String KEY_FORCE_INTERCEPT_STIME_STAT = "key_force_intercept_stime_stat";
    public static final String KEY_FROM_TYPE = "from_type";
    public static final String KEY_FROM_WRITE_TYPE = "from_write_type";
    public static final String KEY_IMAGE_CLIP_TYPE = "image_clip_type";
    public static final String KEY_NEED_CLIP_IMAGE = "need_clip_image";
    public static final String KEY_ONLY_SELECT_PNG_AND_JPEG = "only_select_png_and_jpeg";
    public static final String KEY_TAB_LIST = "tab_list";
    public static final String KEY_URI = "key_uri";
    public static final String KEY_VIDEO_INFO = "key_video_info";
    public static final long LAUNCH_ACTIVITY_INTERVAL_TIME = 500;
    public static final String LIST = "list";
    public static final String LIST_TYPE = "list_type";
    public static final String MEMBER_BUY_SHOW = "member_buy_show";
    public static final String NAME_SHOW = "name_show";
    public static final String NID = "nid";
    public static final String PKG_ID = "pkg_id";
    public static final String PORTRAIT = "portrait";
    public static final String POST_DESC = "post_desc";
    public static final String POST_ID = "post_id";
    public static final String PRE_PAGE_ID = "pre_page_id";
    public static final String RECOM_SOURCE = "recom_source";
    public static final String REQUEST_CODE = "request_code";
    public static final String ROOM_ID = "roomId";
    public static final String SEARCH_PAGE_QUERY_CONTENT_KEY = "searchPageQueryContent";
    public static final String SHOW_KEYBOARD = "keyboard";
    public static final String SOURCE_RECT_IN_SCREEN = "source_rect_in_screen";
    public static final String START_ACTION = "start";
    public static final String STOP = "stop";
    public static final String ST_TYPE = "st_type";
    public static final String THREAD_ID = "thread_id";
    public static final String TOPIC_FID = "topic_fid";
    public static final String TOPIC_FIRST_DIR = "topic_first_dir";
    public static final String TOPIC_ID = "topic_id";
    public static final String TOPIC_NAME = "topic_name";
    public static final String TOPIC_SECOND_DIR = "topic_second_dir";
    public static final String TOPIC_TID = "topic_tid";
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

    public boolean asynStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void preJump() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IntentConfig a;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }

        public a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intentConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intentConfig;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) && iBinder != null) {
                this.a.mReplyMessenger = new Messenger(iBinder);
                if (this.a.mReplyMessenger != null) {
                    Message obtain = Message.obtain();
                    Bundle bundle = new Bundle();
                    if (this.a.mComponentClass != null) {
                        bundle.putString("class", this.a.mComponentClass.getName());
                    }
                    obtain.setData(bundle);
                    obtain.replyTo = this.a.mClientMessenger;
                    try {
                        this.a.mReplyMessenger.send(obtain);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ IntentConfig b;

        public b(IntentConfig intentConfig, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intentConfig, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = intentConfig;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                this.b.logIntentImpl(this.a);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IntentConfig a;

        public c(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intentConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intentConfig;
        }

        public final boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message != null && message.what == 0 && message.arg1 == 1) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ c(IntentConfig intentConfig, a aVar) {
            this(intentConfig);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) != null) || this.a.mContext == null) {
                return;
            }
            if (a(message)) {
                if (this.a.isForResult) {
                    IntentConfig intentConfig = this.a;
                    intentConfig.startActivityForResult(intentConfig.mRequestCode, this.a.mComponentClass);
                } else {
                    IntentConfig intentConfig2 = this.a;
                    intentConfig2.startActivity(intentConfig2.mComponentClass);
                }
            }
            xg.unbindService(this.a.mContext, this.a.mClientConnection);
        }
    }

    public IntentConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.mClientMessenger = new Messenger(new c(this, null));
        this.isForResult = false;
        this.mClientConnection = new a(this);
        this.mIntentAction = IntentAction.Activity;
    }

    public void addPreSourceTrace() {
        Context context;
        ArrayList<String> c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mIntent != null && (context = this.mContext) != null) {
            kr5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(context);
            if (currentVisiblePageExtra == null) {
                c2 = null;
            } else {
                c2 = currentVisiblePageExtra.c();
            }
            if (ListUtils.isEmpty(c2)) {
                return;
            }
            if (currentVisiblePageExtra != null) {
                TbPageExtraHelper.setPrePageKey(currentVisiblePageExtra.a());
                gp5.i(new PrePageKeyEvent(TbPageExtraHelper.getPrePageKey()));
            }
            this.mIntent.putStringArrayListExtra("tb_page_extar_source_list", c2);
        }
    }

    public IntentConfig(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.mClientMessenger = new Messenger(new c(this, null));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void logIntentImpl(String str) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65551, this, str) != null) || this.mIntent == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Bundle extras = this.mIntent.getExtras();
        if (extras != null && !extras.isEmpty()) {
            for (String str2 : extras.keySet()) {
                Object obj = extras.get(str2);
                String str3 = null;
                if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short)) {
                    str3 = obj.toString();
                }
                jSONObject2.put(str2, str3);
            }
        }
        jSONObject.put("component", this.mComponentClass);
        jSONObject.put("extra", jSONObject2);
        ActivityLog.getInstance().c(str, jSONObject.toString());
    }

    public static boolean checkStartActivityInterval(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, cls)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (cls == lastStartActivityClass && Math.abs(currentTimeMillis - lastStartActivityTime) < 500) {
                return false;
            }
            lastStartActivityTime = currentTimeMillis;
            lastStartActivityClass = cls;
            return true;
        }
        return invokeL.booleanValue;
    }

    private void logIntent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
            wg.a().post(new b(this, str));
        }
    }

    public void setComponentClass(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cls) == null) {
            if (cls == null) {
                if (!BdBaseApplication.getInst().isDebugMode()) {
                    return;
                }
                throw new IllegalArgumentException("IntentConfig setClass args exception!");
            }
            this.mComponentClass = cls;
            Context context = this.mContext;
            if (context != null) {
                this.mIntent.setClass(context, cls);
            }
        }
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            this.mContext = context;
        }
    }

    public void setForceInterceptStimeStat(boolean z) {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (intent = getIntent()) != null) {
            intent.putExtra(KEY_FORCE_INTERCEPT_STIME_STAT, z);
        }
    }

    public void setIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, intent) == null) {
            this.mIntent = intent;
        }
    }

    public void setIntentAction(IntentAction intentAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, intentAction) == null) {
            this.mIntentAction = intentAction;
        }
    }

    public void setRequestCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mRequestCode = i;
        }
    }

    public void startActivityForRemote(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, cls) == null) {
            setComponentClass(cls);
            logIntent("startActivityForRemote");
            Intent intent = new Intent();
            intent.setClass(this.mContext, RemoteActivityProxyService.class);
            xg.bindService(this.mContext, intent, this.mClientConnection, 1);
        }
    }

    public void startService(Class<?> cls) {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, cls) == null) {
            setComponentClass(cls);
            logIntent("startService");
            if (this.mComponentClass != null && (context = this.mContext) != null) {
                try {
                    context.startService(this.mIntent);
                } catch (Throwable th) {
                    BdLog.detailException(th);
                }
            }
        }
    }

    public void startActivityForResultForRemote(int i, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i, cls) == null) {
            setRequestCode(i);
            this.isForResult = true;
            setComponentClass(cls);
            logIntent("startActivityForResultForRemote");
            Intent intent = new Intent();
            intent.setClass(this.mContext, RemoteActivityProxyService.class);
            xg.bindService(this.mContext, intent, this.mClientConnection, 1);
        }
    }

    private void addPageSourceTrace() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65548, this) == null) && this.mIntent != null && (context = this.mContext) != null) {
            l9<?> b2 = q9.b(context);
            or5 or5Var = null;
            if (b2 instanceof nr5) {
                or5Var = ((nr5) b2).getTbPageInfo();
            }
            if (or5Var != null) {
                this.mIntent.putExtra("tb_page_tag_source_trace", or5Var.a());
            }
        }
    }

    public void addSourceTraceForPageStayDurationStat() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.mIntent != null) {
            l9<?> b2 = q9.b(this.mContext);
            ArrayList<String> arrayList = null;
            if (b2 instanceof qr5) {
                arrayList = (ArrayList) ((qr5) b2).getNextPageSourceKeyList();
            }
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            this.mIntent.putStringArrayListExtra("obj_source", arrayList);
        }
    }

    public void run() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || !isValid()) {
            return;
        }
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

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mContext;
        }
        return (Context) invokeV.objValue;
    }

    public Intent getIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mIntent;
        }
        return (Intent) invokeV.objValue;
    }

    public int getRequestCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mRequestCode;
        }
        return invokeV.intValue;
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this));
        }
    }

    public void startService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            logIntent("startService");
            this.mContext.startService(this.mIntent);
        }
    }

    public void stopService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            logIntent("stopService");
            this.mContext.stopService(this.mIntent);
        }
    }

    public boolean startActivity(Class<?> cls) {
        InterceptResult invokeL;
        Class<?> loadClass;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, cls)) == null) {
            preJump();
            setComponentClass(cls);
            logIntent(WBConstants.SHARE_START_ACTIVITY);
            Class<?> cls2 = this.mComponentClass;
            if (cls2 != null && this.mContext != null) {
                if (!checkStartActivityInterval(cls2)) {
                    ActivityLog.getInstance().b(WBConstants.SHARE_START_ACTIVITY, "fail checkStartActivityInterval");
                    return false;
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
                        this.mIntent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    }
                    if (this.mIntent != null && SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(this.mComponentClass.getName())) {
                        this.mIntent.addFlags(603979776);
                    }
                    this.mContext.startActivity(this.mIntent);
                    return true;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return false;
                }
            }
            wq8 activityLog = ActivityLog.getInstance();
            activityLog.b(WBConstants.SHARE_START_ACTIVITY, "fail mComponentClass:" + this.mComponentClass + " mContext：" + this.mContext);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void startActivityForResult(int i) {
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            logIntent("startActivityForResult");
            if (!checkStartActivityInterval(this.mComponentClass)) {
                ActivityLog.getInstance().b("startActivityForResult", "fail checkStartActivityInterval");
                return;
            }
            if (this.mIntent != null && (cls = this.mComponentClass) != null && SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(cls.getName())) {
                this.mIntent.addFlags(603979776);
            }
            Context context = this.mContext;
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(this.mIntent, i);
            }
        }
    }

    public void startActivityForResult(int i, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, cls) == null) {
            setComponentClass(cls);
            if (this.mComponentClass != null && this.mContext != null) {
                try {
                    startActivityForResult(i);
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            wq8 activityLog = ActivityLog.getInstance();
            activityLog.b("startActivityForResult", "fail mComponentClass:" + this.mComponentClass + " mContext：" + this.mContext);
        }
    }
}

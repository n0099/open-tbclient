package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class NotificationManagerCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    public static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    public static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    public static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    public static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    public static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    public static final String TAG = "NotifManCompat";
    @GuardedBy("sEnabledNotificationListenersLock")
    public static Set<String> sEnabledNotificationListenerPackages;
    @GuardedBy("sEnabledNotificationListenersLock")
    public static String sEnabledNotificationListeners;
    public static final Object sEnabledNotificationListenersLock;
    public static final Object sLock;
    @GuardedBy("sLock")
    public static SideChannelManager sSideChannelManager;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context mContext;
    public final NotificationManager mNotificationManager;

    /* loaded from: classes.dex */
    public static class NotifyTask implements Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int id;
        public final Notification notif;
        public final String packageName;
        public final String tag;

        public NotifyTask(String str, int i2, String str2, Notification notification) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2, notification};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.packageName = str;
            this.id = i2;
            this.tag = str2;
            this.notif = notification;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iNotificationSideChannel) == null) {
                iNotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "NotifyTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class ServiceConnectedEvent {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ComponentName componentName;
        public final IBinder iBinder;

        public ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {componentName, iBinder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.componentName = componentName;
            this.iBinder = iBinder;
        }
    }

    /* loaded from: classes.dex */
    public static class SideChannelManager implements Handler.Callback, ServiceConnection {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MSG_QUEUE_TASK = 0;
        public static final int MSG_RETRY_LISTENER_QUEUE = 3;
        public static final int MSG_SERVICE_CONNECTED = 1;
        public static final int MSG_SERVICE_DISCONNECTED = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public Set<String> mCachedEnabledPackages;
        public final Context mContext;
        public final Handler mHandler;
        public final HandlerThread mHandlerThread;
        public final Map<ComponentName, ListenerRecord> mRecordMap;

        /* loaded from: classes.dex */
        public static class ListenerRecord {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean bound;
            public final ComponentName componentName;
            public int retryCount;
            public INotificationSideChannel service;
            public ArrayDeque<Task> taskQueue;

            public ListenerRecord(ComponentName componentName) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {componentName};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.bound = false;
                this.taskQueue = new ArrayDeque<>();
                this.retryCount = 0;
                this.componentName = componentName;
            }
        }

        public SideChannelManager(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mRecordMap = new HashMap();
            this.mCachedEnabledPackages = new HashSet();
            this.mContext = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
        }

        private boolean ensureServiceBound(ListenerRecord listenerRecord) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, listenerRecord)) == null) {
                if (listenerRecord.bound) {
                    return true;
                }
                boolean bindService = this.mContext.bindService(new Intent(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL).setComponent(listenerRecord.componentName), this, 33);
                listenerRecord.bound = bindService;
                if (bindService) {
                    listenerRecord.retryCount = 0;
                } else {
                    String str = "Unable to bind to listener " + listenerRecord.componentName;
                    this.mContext.unbindService(this);
                }
                return listenerRecord.bound;
            }
            return invokeL.booleanValue;
        }

        private void ensureServiceUnbound(ListenerRecord listenerRecord) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, listenerRecord) == null) {
                if (listenerRecord.bound) {
                    this.mContext.unbindService(this);
                    listenerRecord.bound = false;
                }
                listenerRecord.service = null;
            }
        }

        private void handleQueueTask(Task task) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, task) == null) {
                updateListenerMap();
                for (ListenerRecord listenerRecord : this.mRecordMap.values()) {
                    listenerRecord.taskQueue.add(task);
                    processListenerQueue(listenerRecord);
                }
            }
        }

        private void handleRetryListenerQueue(ComponentName componentName) {
            ListenerRecord listenerRecord;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, componentName) == null) || (listenerRecord = this.mRecordMap.get(componentName)) == null) {
                return;
            }
            processListenerQueue(listenerRecord);
        }

        private void handleServiceConnected(ComponentName componentName, IBinder iBinder) {
            ListenerRecord listenerRecord;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, componentName, iBinder) == null) || (listenerRecord = this.mRecordMap.get(componentName)) == null) {
                return;
            }
            listenerRecord.service = INotificationSideChannel.Stub.asInterface(iBinder);
            listenerRecord.retryCount = 0;
            processListenerQueue(listenerRecord);
        }

        private void handleServiceDisconnected(ComponentName componentName) {
            ListenerRecord listenerRecord;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, componentName) == null) || (listenerRecord = this.mRecordMap.get(componentName)) == null) {
                return;
            }
            ensureServiceUnbound(listenerRecord);
        }

        private void processListenerQueue(ListenerRecord listenerRecord) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65543, this, listenerRecord) == null) {
                if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                    String str = "Processing component " + listenerRecord.componentName + StringUtil.ARRAY_ELEMENT_SEPARATOR + listenerRecord.taskQueue.size() + " queued tasks";
                }
                if (listenerRecord.taskQueue.isEmpty()) {
                    return;
                }
                if (ensureServiceBound(listenerRecord) && listenerRecord.service != null) {
                    while (true) {
                        Task peek = listenerRecord.taskQueue.peek();
                        if (peek == null) {
                            break;
                        }
                        try {
                            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                                String str2 = "Sending task " + peek;
                            }
                            peek.send(listenerRecord.service);
                            listenerRecord.taskQueue.remove();
                        } catch (DeadObjectException unused) {
                            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                                String str3 = "Remote service has died: " + listenerRecord.componentName;
                            }
                        } catch (RemoteException unused2) {
                            String str4 = "RemoteException communicating with " + listenerRecord.componentName;
                        }
                    }
                    if (listenerRecord.taskQueue.isEmpty()) {
                        return;
                    }
                    scheduleListenerRetry(listenerRecord);
                    return;
                }
                scheduleListenerRetry(listenerRecord);
            }
        }

        private void scheduleListenerRetry(ListenerRecord listenerRecord) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65544, this, listenerRecord) == null) || this.mHandler.hasMessages(3, listenerRecord.componentName)) {
                return;
            }
            int i2 = listenerRecord.retryCount + 1;
            listenerRecord.retryCount = i2;
            if (i2 > 6) {
                String str = "Giving up on delivering " + listenerRecord.taskQueue.size() + " tasks to " + listenerRecord.componentName + " after " + listenerRecord.retryCount + " retries";
                listenerRecord.taskQueue.clear();
                return;
            }
            int i3 = (1 << (i2 - 1)) * 1000;
            if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                String str2 = "Scheduling retry for " + i3 + " ms";
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, listenerRecord.componentName), i3);
        }

        private void updateListenerMap() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65545, this) == null) {
                Set<String> enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
                if (enabledListenerPackages.equals(this.mCachedEnabledPackages)) {
                    return;
                }
                this.mCachedEnabledPackages = enabledListenerPackages;
                List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction(NotificationManagerCompat.ACTION_BIND_SIDE_CHANNEL), 0);
                HashSet<ComponentName> hashSet = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (enabledListenerPackages.contains(resolveInfo.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            String str = "Permission present on component " + componentName + ", not adding listener record.";
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.mRecordMap.containsKey(componentName2)) {
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            String str2 = "Adding listener record for " + componentName2;
                        }
                        this.mRecordMap.put(componentName2, new ListenerRecord(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, ListenerRecord>> it = this.mRecordMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<ComponentName, ListenerRecord> next = it.next();
                    if (!hashSet.contains(next.getKey())) {
                        if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                            String str3 = "Removing listener record for " + next.getKey();
                        }
                        ensureServiceUnbound(next.getValue());
                        it.remove();
                    }
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 == 0) {
                    handleQueueTask((Task) message.obj);
                    return true;
                } else if (i2 == 1) {
                    ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                    handleServiceConnected(serviceConnectedEvent.componentName, serviceConnectedEvent.iBinder);
                    return true;
                } else if (i2 == 2) {
                    handleServiceDisconnected((ComponentName) message.obj);
                    return true;
                } else if (i2 != 3) {
                    return false;
                } else {
                    handleRetryListenerQueue((ComponentName) message.obj);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName, iBinder) == null) {
                if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                    String str = "Connected to service " + componentName;
                }
                this.mHandler.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
                if (Log.isLoggable(NotificationManagerCompat.TAG, 3)) {
                    String str = "Disconnected from service " + componentName;
                }
                this.mHandler.obtainMessage(2, componentName).sendToTarget();
            }
        }

        public void queueTask(Task task) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, task) == null) {
                this.mHandler.obtainMessage(0, task).sendToTarget();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface Task {
        void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1324314949, "Landroidx/core/app/NotificationManagerCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1324314949, "Landroidx/core/app/NotificationManagerCompat;");
                return;
            }
        }
        sEnabledNotificationListenersLock = new Object();
        sEnabledNotificationListenerPackages = new HashSet();
        sLock = new Object();
    }

    public NotificationManagerCompat(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mNotificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }

    @NonNull
    public static NotificationManagerCompat from(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new NotificationManagerCompat(context) : (NotificationManagerCompat) invokeL.objValue;
    }

    @NonNull
    public static Set<String> getEnabledListenerPackages(@NonNull Context context) {
        InterceptResult invokeL;
        Set<String> set;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
            synchronized (sEnabledNotificationListenersLock) {
                if (string != null) {
                    if (!string.equals(sEnabledNotificationListeners)) {
                        String[] split = string.split(":", -1);
                        HashSet hashSet = new HashSet(split.length);
                        for (String str : split) {
                            ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                            if (unflattenFromString != null) {
                                hashSet.add(unflattenFromString.getPackageName());
                            }
                        }
                        sEnabledNotificationListenerPackages = hashSet;
                        sEnabledNotificationListeners = string;
                    }
                }
                set = sEnabledNotificationListenerPackages;
            }
            return set;
        }
        return (Set) invokeL.objValue;
    }

    private void pushSideChannelQueue(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, task) == null) {
            synchronized (sLock) {
                if (sSideChannelManager == null) {
                    sSideChannelManager = new SideChannelManager(this.mContext.getApplicationContext());
                }
                sSideChannelManager.queueTask(task);
            }
        }
    }

    public static boolean useSideChannelForNotification(Notification notification) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, notification)) == null) {
            Bundle extras = NotificationCompat.getExtras(notification);
            return extras != null && extras.getBoolean(EXTRA_USE_SIDE_CHANNEL);
        }
        return invokeL.booleanValue;
    }

    public boolean areNotificationsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                return this.mNotificationManager.areNotificationsEnabled();
            }
            if (i2 >= 19) {
                AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService("appops");
                ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
                String packageName = this.mContext.getApplicationContext().getPackageName();
                int i3 = applicationInfo.uid;
                try {
                    Class<?> cls = Class.forName(AppOpsManager.class.getName());
                    return ((Integer) cls.getMethod(CHECK_OP_NO_THROW, Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0;
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
                    return true;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void cancel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            cancel(null, i2);
        }
    }

    public void cancelAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mNotificationManager.cancelAll();
            if (Build.VERSION.SDK_INT <= 19) {
                pushSideChannelQueue(new CancelTask(this.mContext.getPackageName()));
            }
        }
    }

    public void createNotificationChannel(@NonNull NotificationChannel notificationChannel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, notificationChannel) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        this.mNotificationManager.createNotificationChannel(notificationChannel);
    }

    public void createNotificationChannelGroup(@NonNull NotificationChannelGroup notificationChannelGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, notificationChannelGroup) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        this.mNotificationManager.createNotificationChannelGroup(notificationChannelGroup);
    }

    public void createNotificationChannelGroups(@NonNull List<NotificationChannelGroup> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, list) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        this.mNotificationManager.createNotificationChannelGroups(list);
    }

    public void createNotificationChannels(@NonNull List<NotificationChannel> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        this.mNotificationManager.createNotificationChannels(list);
    }

    public void deleteNotificationChannel(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        this.mNotificationManager.deleteNotificationChannel(str);
    }

    public void deleteNotificationChannelGroup(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        this.mNotificationManager.deleteNotificationChannelGroup(str);
    }

    public int getImportance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return this.mNotificationManager.getImportance();
            }
            return -1000;
        }
        return invokeV.intValue;
    }

    @Nullable
    public NotificationChannel getNotificationChannel(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return this.mNotificationManager.getNotificationChannel(str);
            }
            return null;
        }
        return (NotificationChannel) invokeL.objValue;
    }

    @Nullable
    public NotificationChannelGroup getNotificationChannelGroup(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                return this.mNotificationManager.getNotificationChannelGroup(str);
            }
            if (i2 >= 26) {
                for (NotificationChannelGroup notificationChannelGroup : getNotificationChannelGroups()) {
                    if (notificationChannelGroup.getId().equals(str)) {
                        return notificationChannelGroup;
                    }
                }
            }
            return null;
        }
        return (NotificationChannelGroup) invokeL.objValue;
    }

    @NonNull
    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return this.mNotificationManager.getNotificationChannelGroups();
            }
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public List<NotificationChannel> getNotificationChannels() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                return this.mNotificationManager.getNotificationChannels();
            }
            return Collections.emptyList();
        }
        return (List) invokeV.objValue;
    }

    public void notify(int i2, @NonNull Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, notification) == null) {
            notify(null, i2, notification);
        }
    }

    public void cancel(@Nullable String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            this.mNotificationManager.cancel(str, i2);
            if (Build.VERSION.SDK_INT <= 19) {
                pushSideChannelQueue(new CancelTask(this.mContext.getPackageName(), i2, str));
            }
        }
    }

    public void notify(@Nullable String str, int i2, @NonNull Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048592, this, str, i2, notification) == null) {
            if (useSideChannelForNotification(notification)) {
                pushSideChannelQueue(new NotifyTask(this.mContext.getPackageName(), i2, str, notification));
                this.mNotificationManager.cancel(str, i2);
                return;
            }
            this.mNotificationManager.notify(str, i2, notification);
        }
    }

    /* loaded from: classes.dex */
    public static class CancelTask implements Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean all;
        public final int id;
        public final String packageName;
        public final String tag;

        public CancelTask(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.packageName = str;
            this.id = 0;
            this.tag = null;
            this.all = true;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iNotificationSideChannel) == null) {
                if (this.all) {
                    iNotificationSideChannel.cancelAll(this.packageName);
                } else {
                    iNotificationSideChannel.cancel(this.packageName, this.id, this.tag);
                }
            }
        }

        @NonNull
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "CancelTask[packageName:" + this.packageName + ", id:" + this.id + ", tag:" + this.tag + ", all:" + this.all + PreferencesUtil.RIGHT_MOUNT;
            }
            return (String) invokeV.objValue;
        }

        public CancelTask(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.packageName = str;
            this.id = i2;
            this.tag = str2;
            this.all = false;
        }
    }
}

package com.baidu.cyberplayer.sdk.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
@Keep
/* loaded from: classes5.dex */
public class DuplayerHandlerThreadPool {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_CHECK_IDLE_LONG_TIME_OUT = 100;
    public static final int MSG_CHECK_IDLE_SHORT_TIME_OUT = 101;
    public static final String TAG = "DuplayerHandlerThreadPool";

    /* renamed from: b  reason: collision with root package name */
    public static final Object f39304b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f39305a;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<DuplayerHandlerThread> f39306c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<DuplayerHandlerThread> f39307d;

    /* renamed from: e  reason: collision with root package name */
    public c f39308e;

    /* renamed from: com.baidu.cyberplayer.sdk.utils.DuplayerHandlerThreadPool$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f39309a;

        /* renamed from: b  reason: collision with root package name */
        public final String f39310b;

        /* renamed from: c  reason: collision with root package name */
        public int f39311c;

        public a(String str) {
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
            this.f39309a = new AtomicInteger(1);
            this.f39311c = 5;
            this.f39310b = str + "-";
            this.f39311c = 5;
        }

        public DuplayerHandlerThread a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DuplayerHandlerThread duplayerHandlerThread = new DuplayerHandlerThread(this.f39310b + this.f39309a.getAndIncrement());
                duplayerHandlerThread.setPriority(this.f39311c);
                return duplayerHandlerThread;
            }
            return (DuplayerHandlerThread) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static DuplayerHandlerThreadPool f39312a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1548253099, "Lcom/baidu/cyberplayer/sdk/utils/DuplayerHandlerThreadPool$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1548253099, "Lcom/baidu/cyberplayer/sdk/utils/DuplayerHandlerThreadPool$b;");
                    return;
                }
            }
            f39312a = new DuplayerHandlerThreadPool(null);
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ c(Looper looper, AnonymousClass1 anonymousClass1) {
            this(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 == 100) {
                    DuplayerHandlerThreadPool.getInstance().checkIdlePoolLongTimeNoUse();
                } else if (i2 != 101) {
                } else {
                    DuplayerHandlerThreadPool.getInstance().b();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-962503853, "Lcom/baidu/cyberplayer/sdk/utils/DuplayerHandlerThreadPool;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-962503853, "Lcom/baidu/cyberplayer/sdk/utils/DuplayerHandlerThreadPool;");
                return;
            }
        }
        f39304b = new Object();
    }

    public DuplayerHandlerThreadPool() {
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
        this.f39306c = new ArrayList<>();
        this.f39307d = new ArrayList<>();
        this.f39305a = new a("duplayer-t");
        this.f39308e = new c(Looper.getMainLooper(), null);
    }

    public /* synthetic */ DuplayerHandlerThreadPool(AnonymousClass1 anonymousClass1) {
        this();
    }

    private DuplayerHandlerThread a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            DuplayerHandlerThread a2 = this.f39305a.a();
            a2.start();
            return a2;
        }
        return (DuplayerHandlerThread) invokeV.objValue;
    }

    private void a(DuplayerHandlerThread duplayerHandlerThread) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, duplayerHandlerThread) == null) {
            CyberLog.d(TAG, " quitHandlerThread handlerThread:" + duplayerHandlerThread);
            if (duplayerHandlerThread != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    if (duplayerHandlerThread == null) {
                        return;
                    }
                    try {
                        duplayerHandlerThread.getLooper().quitSafely();
                        return;
                    } catch (NoSuchMethodError unused) {
                    }
                }
                duplayerHandlerThread.getLooper().quit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            synchronized (f39304b) {
                int size = this.f39306c.size();
                CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse size:" + size);
                if (size > 3) {
                    int i2 = size - 3;
                    Iterator<DuplayerHandlerThread> it = this.f39306c.iterator();
                    while (it.hasNext() && i2 > 0) {
                        DuplayerHandlerThread next = it.next();
                        if (next != null) {
                            long idleBeginTime = next.getIdleBeginTime();
                            if (idleBeginTime > 0 && SystemClock.uptimeMillis() - idleBeginTime >= AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                                CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse short time no use next:" + next);
                                it.remove();
                                a(next);
                                i2 += -1;
                            }
                        }
                    }
                    print();
                }
                CyberLog.d(TAG, "checkIdlePoolShortTimeNoUse end");
            }
        }
    }

    public static DuplayerHandlerThreadPool getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? b.f39312a : (DuplayerHandlerThreadPool) invokeV.objValue;
    }

    public void checkIdlePoolLongTimeNoUse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (f39304b) {
                if (this.f39306c.size() <= 0) {
                    return;
                }
                CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse called size:" + this.f39306c.size());
                Iterator<DuplayerHandlerThread> it = this.f39306c.iterator();
                while (it.hasNext()) {
                    DuplayerHandlerThread next = it.next();
                    if (next != null) {
                        long idleBeginTime = next.getIdleBeginTime();
                        CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse long time no use delta:" + (SystemClock.uptimeMillis() - idleBeginTime));
                        if (idleBeginTime > 0 && SystemClock.uptimeMillis() - idleBeginTime >= 900000) {
                            CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse long time no use");
                            it.remove();
                            a(next);
                        }
                    }
                }
                print();
                CyberLog.d(TAG, "checkIdlePoolLongTimeNoUse  called end");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0042 A[Catch: all -> 0x0074, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x0010, B:13:0x002d, B:15:0x0042, B:16:0x0049, B:18:0x0052, B:19:0x0059, B:20:0x0072, B:9:0x0015), top: B:29:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052 A[Catch: all -> 0x0074, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x0010, B:13:0x002d, B:15:0x0042, B:16:0x0049, B:18:0x0052, B:19:0x0059, B:20:0x0072, B:9:0x0015), top: B:29:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DuplayerHandlerThread obtain() {
        InterceptResult invokeV;
        DuplayerHandlerThread duplayerHandlerThread;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (f39304b) {
                if (this.f39306c.size() != 0) {
                    int size = this.f39306c.size() - 1;
                    DuplayerHandlerThread duplayerHandlerThread2 = this.f39306c.get(size);
                    this.f39306c.remove(size);
                    if (duplayerHandlerThread2 != null) {
                        duplayerHandlerThread = duplayerHandlerThread2;
                        duplayerHandlerThread.setRunState(1);
                        duplayerHandlerThread.setIdleBeginTime(-1L);
                        this.f39307d.add(duplayerHandlerThread);
                        if (this.f39306c.size() <= 0) {
                            this.f39308e.removeMessages(100);
                        }
                        if (this.f39306c.size() <= 3) {
                            this.f39308e.removeMessages(101);
                        }
                        CyberLog.d(TAG, " obtain handlerThread:" + duplayerHandlerThread);
                        print();
                    }
                }
                duplayerHandlerThread = a();
                duplayerHandlerThread.setRunState(1);
                duplayerHandlerThread.setIdleBeginTime(-1L);
                this.f39307d.add(duplayerHandlerThread);
                if (this.f39306c.size() <= 0) {
                }
                if (this.f39306c.size() <= 3) {
                }
                CyberLog.d(TAG, " obtain handlerThread:" + duplayerHandlerThread);
                print();
            }
            return duplayerHandlerThread;
        }
        return (DuplayerHandlerThread) invokeV.objValue;
    }

    public void print() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (f39304b) {
                int size = this.f39306c.size();
                CyberLog.d(TAG, "-- mIdlePool size:" + size + "--");
                for (int i2 = 0; i2 < size; i2++) {
                    CyberLog.d(TAG, "-- mIdlePool i:" + i2 + " " + this.f39306c.get(i2) + " --");
                }
                int size2 = this.f39307d.size();
                CyberLog.d(TAG, "-- mBusyPool size:" + size2 + " --");
                for (int i3 = 0; i3 < size2; i3++) {
                    CyberLog.d(TAG, "-- mBusyPool i:" + i3 + " " + this.f39307d.get(i3) + " --");
                }
            }
        }
    }

    public void recycle(DuplayerHandlerThread duplayerHandlerThread) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, duplayerHandlerThread) == null) || duplayerHandlerThread == null) {
            return;
        }
        CyberLog.d(TAG, " recycle handlerThread:" + duplayerHandlerThread);
        synchronized (f39304b) {
            duplayerHandlerThread.setIdleBeginTime(SystemClock.uptimeMillis());
            duplayerHandlerThread.setRunState(0);
            this.f39307d.remove(duplayerHandlerThread);
            this.f39306c.add(duplayerHandlerThread);
            if (this.f39306c.size() > 0) {
                this.f39308e.sendEmptyMessageDelayed(100, 900000L);
            }
            if (this.f39306c.size() > 3) {
                this.f39308e.sendEmptyMessageDelayed(101, AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            }
            print();
        }
        CyberLog.d(TAG, " recycle  end ");
    }
}

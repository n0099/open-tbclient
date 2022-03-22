package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SelfDestructiveThread {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_DESTRUCTION = 0;
    public static final int MSG_INVOKE_RUNNABLE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler.Callback mCallback;
    public final int mDestructAfterMillisec;
    @GuardedBy("mLock")
    public int mGeneration;
    @GuardedBy("mLock")
    public Handler mHandler;
    public final Object mLock;
    public final int mPriority;
    @GuardedBy("mLock")
    public HandlerThread mThread;
    public final String mThreadName;

    /* loaded from: classes.dex */
    public interface ReplyCallback<T> {
        void onReply(T t);
    }

    public SelfDestructiveThread(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLock = new Object();
        this.mCallback = new Handler.Callback(this) { // from class: androidx.core.provider.SelfDestructiveThread.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SelfDestructiveThread this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, message)) == null) {
                    int i5 = message.what;
                    if (i5 == 0) {
                        this.this$0.onDestruction();
                        return true;
                    } else if (i5 != 1) {
                        return true;
                    } else {
                        this.this$0.onInvokeRunnable((Runnable) message.obj);
                        return true;
                    }
                }
                return invokeL.booleanValue;
            }
        };
        this.mThreadName = str;
        this.mPriority = i;
        this.mDestructAfterMillisec = i2;
        this.mGeneration = 0;
    }

    private void post(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, runnable) == null) {
            synchronized (this.mLock) {
                if (this.mThread == null) {
                    HandlerThread handlerThread = new HandlerThread(this.mThreadName, this.mPriority);
                    this.mThread = handlerThread;
                    handlerThread.start();
                    this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);
                    this.mGeneration++;
                }
                this.mHandler.removeMessages(0);
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1, runnable));
            }
        }
    }

    @VisibleForTesting
    public int getGeneration() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.mLock) {
                i = this.mGeneration;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @VisibleForTesting
    public boolean isRunning() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.mLock) {
                z = this.mThread != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void onDestruction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.mLock) {
                if (this.mHandler.hasMessages(1)) {
                    return;
                }
                this.mThread.quit();
                this.mThread = null;
                this.mHandler = null;
            }
        }
    }

    public void onInvokeRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
            runnable.run();
            synchronized (this.mLock) {
                this.mHandler.removeMessages(0);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), this.mDestructAfterMillisec);
            }
        }
    }

    public <T> void postAndReply(Callable<T> callable, ReplyCallback<T> replyCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, callable, replyCallback) == null) {
            post(new Runnable(this, callable, new Handler(), replyCallback) { // from class: androidx.core.provider.SelfDestructiveThread.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SelfDestructiveThread this$0;
                public final /* synthetic */ Callable val$callable;
                public final /* synthetic */ Handler val$callingHandler;
                public final /* synthetic */ ReplyCallback val$reply;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, callable, r8, replyCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callable = callable;
                    this.val$callingHandler = r8;
                    this.val$reply = replyCallback;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Object obj;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            obj = this.val$callable.call();
                        } catch (Exception unused) {
                            obj = null;
                        }
                        this.val$callingHandler.post(new Runnable(this, obj) { // from class: androidx.core.provider.SelfDestructiveThread.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ Object val$result;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, obj};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$result = obj;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.this$1.val$reply.onReply(this.val$result);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public <T> T postAndWait(Callable<T> callable, int i) throws InterruptedException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, callable, i)) == null) {
            ReentrantLock reentrantLock = new ReentrantLock();
            Condition newCondition = reentrantLock.newCondition();
            AtomicReference atomicReference = new AtomicReference();
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            post(new Runnable(this, atomicReference, callable, reentrantLock, atomicBoolean, newCondition) { // from class: androidx.core.provider.SelfDestructiveThread.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SelfDestructiveThread this$0;
                public final /* synthetic */ Callable val$callable;
                public final /* synthetic */ Condition val$cond;
                public final /* synthetic */ AtomicReference val$holder;
                public final /* synthetic */ ReentrantLock val$lock;
                public final /* synthetic */ AtomicBoolean val$running;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, atomicReference, callable, reentrantLock, atomicBoolean, newCondition};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$holder = atomicReference;
                    this.val$callable = callable;
                    this.val$lock = reentrantLock;
                    this.val$running = atomicBoolean;
                    this.val$cond = newCondition;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.val$holder.set(this.val$callable.call());
                        } catch (Exception unused) {
                        }
                        this.val$lock.lock();
                        try {
                            this.val$running.set(false);
                            this.val$cond.signal();
                        } finally {
                            this.val$lock.unlock();
                        }
                    }
                }
            });
            reentrantLock.lock();
            try {
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
                long nanos = TimeUnit.MILLISECONDS.toNanos(i);
                do {
                    try {
                        nanos = newCondition.awaitNanos(nanos);
                    } catch (InterruptedException unused) {
                    }
                    if (!atomicBoolean.get()) {
                        return (T) atomicReference.get();
                    }
                } while (nanos > 0);
                throw new InterruptedException("timeout");
            } finally {
                reentrantLock.unlock();
            }
        }
        return (T) invokeLI.objValue;
    }
}

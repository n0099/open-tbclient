package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class MessageThreadUtil<T> implements ThreadUtil<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ADD_TILE = 2;
        public static final int REMOVE_TILE = 3;
        public static final int UPDATE_ITEM_COUNT = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler mMainThreadHandler;
        public Runnable mMainThreadRunnable;
        public final MessageQueue mQueue;
        public final /* synthetic */ MessageThreadUtil this$0;
        public final /* synthetic */ ThreadUtil.MainThreadCallback val$callback;

        public AnonymousClass1(MessageThreadUtil messageThreadUtil, ThreadUtil.MainThreadCallback mainThreadCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageThreadUtil, mainThreadCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = messageThreadUtil;
            this.val$callback = mainThreadCallback;
            this.mQueue = new MessageQueue();
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
            this.mMainThreadRunnable = new Runnable(this) { // from class: androidx.recyclerview.widget.MessageThreadUtil.1.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AnonymousClass1 this$1;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SyncQueueItem next = this.this$1.mQueue.next();
                        while (next != null) {
                            int i4 = next.what;
                            if (i4 == 1) {
                                this.this$1.val$callback.updateItemCount(next.arg1, next.arg2);
                            } else if (i4 == 2) {
                                this.this$1.val$callback.addTile(next.arg1, (TileList.Tile) next.data);
                            } else if (i4 != 3) {
                                Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                            } else {
                                this.this$1.val$callback.removeTile(next.arg1, next.arg2);
                            }
                            next = this.this$1.mQueue.next();
                        }
                    }
                }
            };
        }

        private void sendMessage(SyncQueueItem syncQueueItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, this, syncQueueItem) == null) {
                this.mQueue.sendMessage(syncQueueItem);
                this.mMainThreadHandler.post(this.mMainThreadRunnable);
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int i2, TileList.Tile<T> tile) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, tile) == null) {
                sendMessage(SyncQueueItem.obtainMessage(2, i2, tile));
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                sendMessage(SyncQueueItem.obtainMessage(3, i2, i3));
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
                sendMessage(SyncQueueItem.obtainMessage(1, i2, i3));
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int LOAD_TILE = 3;
        public static final int RECYCLE_TILE = 4;
        public static final int REFRESH = 1;
        public static final int UPDATE_RANGE = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public Runnable mBackgroundRunnable;
        public AtomicBoolean mBackgroundRunning;
        public final Executor mExecutor;
        public final MessageQueue mQueue;
        public final /* synthetic */ MessageThreadUtil this$0;
        public final /* synthetic */ ThreadUtil.BackgroundCallback val$callback;

        public AnonymousClass2(MessageThreadUtil messageThreadUtil, ThreadUtil.BackgroundCallback backgroundCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageThreadUtil, backgroundCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = messageThreadUtil;
            this.val$callback = backgroundCallback;
            this.mQueue = new MessageQueue();
            this.mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
            this.mBackgroundRunning = new AtomicBoolean(false);
            this.mBackgroundRunnable = new Runnable(this) { // from class: androidx.recyclerview.widget.MessageThreadUtil.2.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AnonymousClass2 this$1;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    while (true) {
                        SyncQueueItem next = this.this$1.mQueue.next();
                        if (next == null) {
                            this.this$1.mBackgroundRunning.set(false);
                            return;
                        }
                        int i4 = next.what;
                        if (i4 == 1) {
                            this.this$1.mQueue.removeMessages(1);
                            this.this$1.val$callback.refresh(next.arg1);
                        } else if (i4 == 2) {
                            this.this$1.mQueue.removeMessages(2);
                            this.this$1.mQueue.removeMessages(3);
                            this.this$1.val$callback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
                        } else if (i4 == 3) {
                            this.this$1.val$callback.loadTile(next.arg1, next.arg2);
                        } else if (i4 != 4) {
                            Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                        } else {
                            this.this$1.val$callback.recycleTile((TileList.Tile) next.data);
                        }
                    }
                }
            };
        }

        private void maybeExecuteBackgroundRunnable() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.mBackgroundRunning.compareAndSet(false, true)) {
                this.mExecutor.execute(this.mBackgroundRunnable);
            }
        }

        private void sendMessage(SyncQueueItem syncQueueItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, this, syncQueueItem) == null) {
                this.mQueue.sendMessage(syncQueueItem);
                maybeExecuteBackgroundRunnable();
            }
        }

        private void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, syncQueueItem) == null) {
                this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
                maybeExecuteBackgroundRunnable();
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                sendMessage(SyncQueueItem.obtainMessage(3, i2, i3));
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> tile) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tile) == null) {
                sendMessage(SyncQueueItem.obtainMessage(4, 0, tile));
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, i2, (Object) null));
            }
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, i2, i3, i4, i5, i6, null));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MessageQueue {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SyncQueueItem mRoot;

        public MessageQueue() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public synchronized SyncQueueItem next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    if (this.mRoot == null) {
                        return null;
                    }
                    SyncQueueItem syncQueueItem = this.mRoot;
                    this.mRoot = this.mRoot.next;
                    return syncQueueItem;
                }
            }
            return (SyncQueueItem) invokeV.objValue;
        }

        public synchronized void removeMessages(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                synchronized (this) {
                    while (this.mRoot != null && this.mRoot.what == i2) {
                        SyncQueueItem syncQueueItem = this.mRoot;
                        this.mRoot = this.mRoot.next;
                        syncQueueItem.recycle();
                    }
                    if (this.mRoot != null) {
                        SyncQueueItem syncQueueItem2 = this.mRoot;
                        SyncQueueItem syncQueueItem3 = syncQueueItem2.next;
                        while (syncQueueItem3 != null) {
                            SyncQueueItem syncQueueItem4 = syncQueueItem3.next;
                            if (syncQueueItem3.what == i2) {
                                syncQueueItem2.next = syncQueueItem4;
                                syncQueueItem3.recycle();
                            } else {
                                syncQueueItem2 = syncQueueItem3;
                            }
                            syncQueueItem3 = syncQueueItem4;
                        }
                    }
                }
            }
        }

        public synchronized void sendMessage(SyncQueueItem syncQueueItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, syncQueueItem) == null) {
                synchronized (this) {
                    if (this.mRoot == null) {
                        this.mRoot = syncQueueItem;
                        return;
                    }
                    SyncQueueItem syncQueueItem2 = this.mRoot;
                    while (syncQueueItem2.next != null) {
                        syncQueueItem2 = syncQueueItem2.next;
                    }
                    syncQueueItem2.next = syncQueueItem;
                }
            }
        }

        public synchronized void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, syncQueueItem) == null) {
                synchronized (this) {
                    syncQueueItem.next = this.mRoot;
                    this.mRoot = syncQueueItem;
                }
            }
        }
    }

    public MessageThreadUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, backgroundCallback)) == null) ? new AnonymousClass2(this, backgroundCallback) : (ThreadUtil.BackgroundCallback) invokeL.objValue;
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mainThreadCallback)) == null) ? new AnonymousClass1(this, mainThreadCallback) : (ThreadUtil.MainThreadCallback) invokeL.objValue;
    }

    /* loaded from: classes.dex */
    public static class SyncQueueItem {
        public static /* synthetic */ Interceptable $ic;
        public static SyncQueueItem sPool;
        public static final Object sPoolLock;
        public transient /* synthetic */ FieldHolder $fh;
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        public SyncQueueItem next;
        public int what;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1878215357, "Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1878215357, "Landroidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;");
                    return;
                }
            }
            sPoolLock = new Object();
        }

        public SyncQueueItem() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SyncQueueItem obtainMessage(int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
            InterceptResult invokeCommon;
            SyncQueueItem syncQueueItem;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), obj})) == null) {
                synchronized (sPoolLock) {
                    if (sPool == null) {
                        syncQueueItem = new SyncQueueItem();
                    } else {
                        syncQueueItem = sPool;
                        sPool = sPool.next;
                        syncQueueItem.next = null;
                    }
                    syncQueueItem.what = i2;
                    syncQueueItem.arg1 = i3;
                    syncQueueItem.arg2 = i4;
                    syncQueueItem.arg3 = i5;
                    syncQueueItem.arg4 = i6;
                    syncQueueItem.arg5 = i7;
                    syncQueueItem.data = obj;
                }
                return syncQueueItem;
            }
            return (SyncQueueItem) invokeCommon.objValue;
        }

        public void recycle() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.next = null;
                this.arg5 = 0;
                this.arg4 = 0;
                this.arg3 = 0;
                this.arg2 = 0;
                this.arg1 = 0;
                this.what = 0;
                this.data = null;
                synchronized (sPoolLock) {
                    if (sPool != null) {
                        this.next = sPool;
                    }
                    sPool = this;
                }
            }
        }

        public static SyncQueueItem obtainMessage(int i2, int i3, int i4) {
            InterceptResult invokeIII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i2, i3, i4)) == null) ? obtainMessage(i2, i3, i4, 0, 0, 0, null) : (SyncQueueItem) invokeIII.objValue;
        }

        public static SyncQueueItem obtainMessage(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3, obj)) == null) ? obtainMessage(i2, i3, 0, 0, 0, 0, obj) : (SyncQueueItem) invokeIIL.objValue;
        }
    }
}

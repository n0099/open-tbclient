package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.TimeUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncTaskLoader";
    public transient /* synthetic */ FieldHolder $fh;
    public volatile AsyncTaskLoader<D>.LoadTask mCancellingTask;
    public final Executor mExecutor;
    public Handler mHandler;
    public long mLastLoadCompleteTime;
    public volatile AsyncTaskLoader<D>.LoadTask mTask;
    public long mUpdateThrottle;

    public void cancelLoadInBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Nullable
    public abstract D loadInBackground();

    public void onCanceled(@Nullable D d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d) == null) {
        }
    }

    /* loaded from: classes.dex */
    public final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CountDownLatch mDone;
        public final /* synthetic */ AsyncTaskLoader this$0;
        public boolean waiting;

        public LoadTask(AsyncTaskLoader asyncTaskLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {asyncTaskLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = asyncTaskLoader;
            this.mDone = new CountDownLatch(1);
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void onCancelled(D d) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d) == null) {
                try {
                    this.this$0.dispatchOnCancelled(this, d);
                } finally {
                    this.mDone.countDown();
                }
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void onPostExecute(D d) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, d) == null) {
                try {
                    this.this$0.dispatchOnLoadComplete(this, d);
                } finally {
                    this.mDone.countDown();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.loader.content.ModernAsyncTask
        public D doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                try {
                    return (D) this.this$0.onLoadInBackground();
                } catch (OperationCanceledException e) {
                    if (isCancelled()) {
                        return null;
                    }
                    throw e;
                }
            }
            return (D) invokeL.objValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.waiting = false;
                this.this$0.executePendingTask();
            }
        }

        public void waitForLoader() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                try {
                    this.mDone.await();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AsyncTaskLoader(@NonNull Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (Executor) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncTaskLoader(@NonNull Context context, @NonNull Executor executor) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, executor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLastLoadCompleteTime = -10000L;
        this.mExecutor = executor;
    }

    public void dispatchOnCancelled(AsyncTaskLoader<D>.LoadTask loadTask, D d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadTask, d) == null) {
            onCanceled(d);
            if (this.mCancellingTask == loadTask) {
                rollbackContentChanged();
                this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
                this.mCancellingTask = null;
                deliverCancellation();
                executePendingTask();
            }
        }
    }

    public void dispatchOnLoadComplete(AsyncTaskLoader<D>.LoadTask loadTask, D d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, loadTask, d) == null) {
            if (this.mTask != loadTask) {
                dispatchOnCancelled(loadTask, d);
            } else if (isAbandoned()) {
                onCanceled(d);
            } else {
                commitContentChanged();
                this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
                this.mTask = null;
                deliverResult(d);
            }
        }
    }

    @Override // androidx.loader.content.Loader
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, fileDescriptor, printWriter, strArr) == null) {
            super.dump(str, fileDescriptor, printWriter, strArr);
            if (this.mTask != null) {
                printWriter.print(str);
                printWriter.print("mTask=");
                printWriter.print(this.mTask);
                printWriter.print(" waiting=");
                printWriter.println(this.mTask.waiting);
            }
            if (this.mCancellingTask != null) {
                printWriter.print(str);
                printWriter.print("mCancellingTask=");
                printWriter.print(this.mCancellingTask);
                printWriter.print(" waiting=");
                printWriter.println(this.mCancellingTask.waiting);
            }
            if (this.mUpdateThrottle != 0) {
                printWriter.print(str);
                printWriter.print("mUpdateThrottle=");
                TimeUtils.formatDuration(this.mUpdateThrottle, printWriter);
                printWriter.print(" mLastLoadCompleteTime=");
                TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
                printWriter.println();
            }
        }
    }

    public void executePendingTask() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mCancellingTask == null && this.mTask != null) {
            if (this.mTask.waiting) {
                this.mTask.waiting = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            if (this.mUpdateThrottle > 0 && SystemClock.uptimeMillis() < this.mLastLoadCompleteTime + this.mUpdateThrottle) {
                this.mTask.waiting = true;
                this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
                return;
            }
            this.mTask.executeOnExecutor(this.mExecutor, null);
        }
    }

    @Override // androidx.loader.content.Loader
    public boolean onCancelLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mTask == null) {
                return false;
            }
            if (!this.mStarted) {
                this.mContentChanged = true;
            }
            if (this.mCancellingTask != null) {
                if (this.mTask.waiting) {
                    this.mTask.waiting = false;
                    this.mHandler.removeCallbacks(this.mTask);
                }
                this.mTask = null;
                return false;
            } else if (this.mTask.waiting) {
                this.mTask.waiting = false;
                this.mHandler.removeCallbacks(this.mTask);
                this.mTask = null;
                return false;
            } else {
                boolean cancel = this.mTask.cancel(false);
                if (cancel) {
                    this.mCancellingTask = this.mTask;
                    cancelLoadInBackground();
                }
                this.mTask = null;
                return cancel;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean isLoadInBackgroundCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mCancellingTask != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.loader.content.Loader
    public void onForceLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onForceLoad();
            cancelLoad();
            this.mTask = new LoadTask(this);
            executePendingTask();
        }
    }

    @Nullable
    public D onLoadInBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return loadInBackground();
        }
        return (D) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask loadTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (loadTask = this.mTask) != null) {
            loadTask.waitForLoader();
        }
    }

    public void setUpdateThrottle(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.mUpdateThrottle = j;
            if (j != 0) {
                this.mHandler = new Handler();
            }
        }
    }
}

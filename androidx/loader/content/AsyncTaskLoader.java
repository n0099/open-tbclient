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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = asyncTaskLoader;
            this.mDone = new CountDownLatch(1);
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void onCancelled(D d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2) == null) {
                try {
                    this.this$0.dispatchOnCancelled(this, d2);
                } finally {
                    this.mDone.countDown();
                }
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void onPostExecute(D d2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, d2) == null) {
                try {
                    this.this$0.dispatchOnLoadComplete(this, d2);
                } finally {
                    this.mDone.countDown();
                }
            }
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.loader.content.ModernAsyncTask
        public D doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                try {
                    return (D) this.this$0.onLoadInBackground();
                } catch (OperationCanceledException e2) {
                    if (isCancelled()) {
                        return null;
                    }
                    throw e2;
                }
            }
            return (D) invokeL.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (Executor) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void cancelLoadInBackground() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void dispatchOnCancelled(AsyncTaskLoader<D>.LoadTask loadTask, D d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, loadTask, d2) == null) {
            onCanceled(d2);
            if (this.mCancellingTask == loadTask) {
                rollbackContentChanged();
                this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
                this.mCancellingTask = null;
                deliverCancellation();
                executePendingTask();
            }
        }
    }

    public void dispatchOnLoadComplete(AsyncTaskLoader<D>.LoadTask loadTask, D d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, loadTask, d2) == null) {
            if (this.mTask != loadTask) {
                dispatchOnCancelled(loadTask, d2);
            } else if (isAbandoned()) {
                onCanceled(d2);
            } else {
                commitContentChanged();
                this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
                this.mTask = null;
                deliverResult(d2);
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

    public boolean isLoadInBackgroundCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mCancellingTask != null : invokeV.booleanValue;
    }

    @Nullable
    public abstract D loadInBackground();

    @Override // androidx.loader.content.Loader
    public boolean onCancelLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mTask != null) {
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
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onCanceled(@Nullable D d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d2) == null) {
        }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? loadInBackground() : (D) invokeV.objValue;
    }

    public void setUpdateThrottle(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j2) == null) {
            this.mUpdateThrottle = j2;
            if (j2 != 0) {
                this.mHandler = new Handler();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask loadTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (loadTask = this.mTask) == null) {
            return;
        }
        loadTask.waitForLoader();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLastLoadCompleteTime = -10000L;
        this.mExecutor = executor;
    }
}

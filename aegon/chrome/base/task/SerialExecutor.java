package aegon.chrome.base.task;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class SerialExecutor implements Executor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable mActive;
    public final ArrayDeque<Runnable> mTasks;

    public SerialExecutor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTasks = new ArrayDeque<>();
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            synchronized (this) {
                this.mTasks.offer(new Runnable(this, runnable) { // from class: aegon.chrome.base.task.SerialExecutor.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SerialExecutor this$0;
                    public final /* synthetic */ Runnable val$r;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, runnable};
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
                        this.val$r = runnable;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.val$r.run();
                            } finally {
                                this.this$0.scheduleNext();
                            }
                        }
                    }
                });
                if (this.mActive == null) {
                    scheduleNext();
                }
            }
        }
    }

    public synchronized void scheduleNext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                Runnable poll = this.mTasks.poll();
                this.mActive = poll;
                if (poll != null) {
                    AsyncTask.THREAD_POOL_EXECUTOR.execute(poll);
                }
            }
        }
    }
}

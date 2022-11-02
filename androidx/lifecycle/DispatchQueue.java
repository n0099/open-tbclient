package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000B\u0007¢\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "canRun", "()Z", "", "drainQueue", "()V", "Ljava/lang/Runnable;", "runnable", "enqueue", "(Ljava/lang/Runnable;)V", "finish", "pause", "resume", "runOrEnqueue", "finished", "Z", "isDraining", "paused", "Ljava/util/Queue;", "queue", "Ljava/util/Queue;", "<init>", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class DispatchQueue {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean finished;
    public boolean isDraining;
    public boolean paused;
    public final Queue<Runnable> queue;

    public DispatchQueue() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.paused = true;
        this.queue = new ArrayDeque();
    }

    @MainThread
    private final boolean canRun() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (!this.finished && this.paused) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @MainThread
    public final void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.finished = true;
            drainQueue();
        }
    }

    @MainThread
    public final void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.paused = true;
        }
    }

    @MainThread
    public final void resume() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !this.paused) {
            return;
        }
        if (!this.finished) {
            this.paused = false;
            drainQueue();
            return;
        }
        throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void enqueue(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, runnable) == null) {
            if (this.queue.offer(runnable)) {
                drainQueue();
                return;
            }
            throw new IllegalStateException("cannot enqueue any more runnables".toString());
        }
    }

    @AnyThread
    @SuppressLint({"WrongThread"})
    @ExperimentalCoroutinesApi
    public final void runOrEnqueue(final Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) {
            MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            if (immediate.isDispatchNeeded(EmptyCoroutineContext.INSTANCE)) {
                immediate.dispatch(EmptyCoroutineContext.INSTANCE, new Runnable(this, runnable) { // from class: androidx.lifecycle.DispatchQueue$runOrEnqueue$$inlined$with$lambda$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Runnable $runnable$inlined;
                    public final /* synthetic */ DispatchQueue this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, runnable};
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
                        this.$runnable$inlined = runnable;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.this$0.enqueue(this.$runnable$inlined);
                    }
                });
            } else {
                enqueue(runnable);
            }
        }
    }

    @MainThread
    public final void drainQueue() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.isDraining) {
            return;
        }
        try {
            this.isDraining = true;
            while ((!this.queue.isEmpty()) && canRun()) {
                Runnable poll = this.queue.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        } finally {
            this.isDraining = false;
        }
    }
}

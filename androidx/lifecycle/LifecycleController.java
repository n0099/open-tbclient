package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000B'\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/LifecycleController;", "", ConstantHelper.LOG_FINISH, "()V", "Lkotlinx/coroutines/Job;", "parentJob", "handleDestroy", "(Lkotlinx/coroutines/Job;)V", "Landroidx/lifecycle/DispatchQueue;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "Landroidx/lifecycle/LifecycleEventObserver;", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@MainThread
/* loaded from: classes.dex */
public final class LifecycleController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DispatchQueue dispatchQueue;
    public final Lifecycle lifecycle;
    public final Lifecycle.State minState;
    public final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State state, DispatchQueue dispatchQueue, final Job job) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lifecycle, state, dispatchQueue, job};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lifecycle = lifecycle;
        this.minState = state;
        this.dispatchQueue = dispatchQueue;
        this.observer = new LifecycleEventObserver(this, job) { // from class: androidx.lifecycle.LifecycleController$observer$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Job $parentJob;
            public final /* synthetic */ LifecycleController this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, job};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.$parentJob = job;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Lifecycle.State state2;
                DispatchQueue dispatchQueue2;
                DispatchQueue dispatchQueue3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, lifecycleOwner, event) == null) {
                    Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
                    Intrinsics.checkExpressionValueIsNotNull(lifecycle2, "source.lifecycle");
                    if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
                        LifecycleController lifecycleController = this.this$0;
                        Job.DefaultImpls.cancel$default(this.$parentJob, (CancellationException) null, 1, (Object) null);
                        lifecycleController.finish();
                        return;
                    }
                    Lifecycle lifecycle3 = lifecycleOwner.getLifecycle();
                    Intrinsics.checkExpressionValueIsNotNull(lifecycle3, "source.lifecycle");
                    Lifecycle.State currentState = lifecycle3.getCurrentState();
                    state2 = this.this$0.minState;
                    if (currentState.compareTo(state2) < 0) {
                        dispatchQueue3 = this.this$0.dispatchQueue;
                        dispatchQueue3.pause();
                        return;
                    }
                    dispatchQueue2 = this.this$0.dispatchQueue;
                    dispatchQueue2.resume();
                }
            }
        };
        if (this.lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            finish();
            return;
        }
        this.lifecycle.addObserver(this.observer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDestroy(Job job) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, job) == null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            finish();
        }
    }

    @MainThread
    public final void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.lifecycle.removeObserver(this.observer);
            this.dispatchQueue.finish();
        }
    }
}

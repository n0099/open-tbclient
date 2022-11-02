package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@DebugMetadata(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0, 0, 0, 0}, l = {MatroskaExtractor.ID_SIMPLE_BLOCK}, m = "invokeSuspend", n = {"$this$withContext", "job", "dispatcher", "controller"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes.dex */
public final class PausingDispatcherKt$whenStateAtLeast$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ Function2 $block;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Lifecycle.State $minState;
    public final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public CoroutineScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        super(2, continuation);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lifecycle, state, function2, continuation};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (Continuation) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, continuation)) == null) {
            PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, continuation);
            pausingDispatcherKt$whenStateAtLeast$2.p$ = (CoroutineScope) obj;
            return pausingDispatcherKt$whenStateAtLeast$2;
        }
        return (Continuation) invokeLL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coroutineScope, obj)) == null) ? ((PausingDispatcherKt$whenStateAtLeast$2) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.INSTANCE) : invokeLL.objValue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        InterceptResult invokeL;
        LifecycleController lifecycleController;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    lifecycleController = (LifecycleController) this.L$3;
                    PausingDispatcher pausingDispatcher = (PausingDispatcher) this.L$2;
                    Job job = (Job) this.L$1;
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th) {
                        th = th;
                        lifecycleController.finish();
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = this.p$;
                Job job2 = (Job) coroutineScope2.getCoroutineContext().get(Job.Key);
                if (job2 != null) {
                    PausingDispatcher pausingDispatcher2 = new PausingDispatcher();
                    LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher2.dispatchQueue, job2);
                    try {
                        Function2 function2 = this.$block;
                        this.L$0 = coroutineScope2;
                        this.L$1 = job2;
                        this.L$2 = pausingDispatcher2;
                        this.L$3 = lifecycleController2;
                        this.label = 1;
                        obj = BuildersKt.withContext(pausingDispatcher2, function2, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        lifecycleController = lifecycleController2;
                    } catch (Throwable th2) {
                        th = th2;
                        lifecycleController = lifecycleController2;
                        lifecycleController.finish();
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("when[State] methods should have a parent job".toString());
                }
            }
            lifecycleController.finish();
            return obj;
        }
        return invokeL.objValue;
    }
}

package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001Be\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012-\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004R@\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\n8\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Landroidx/lifecycle/BlockRunner;", ExifInterface.GPS_DIRECTION_TRUE, "", QueryResponse.Options.CANCEL, "()V", "maybeRun", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Lkotlin/jvm/functions/Function2;", "Lkotlinx/coroutines/Job;", "cancellationJob", "Lkotlinx/coroutines/Job;", "Landroidx/lifecycle/CoroutineLiveData;", "liveData", "Landroidx/lifecycle/CoroutineLiveData;", "Lkotlin/Function0;", "onDone", "Lkotlin/Function0;", "runningJob", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "", "timeoutInMs", "J", "<init>", "(Landroidx/lifecycle/CoroutineLiveData;Lkotlin/jvm/functions/Function2;JLkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;)V", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class BlockRunner<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function2<LiveDataScope<T>, Continuation<? super Unit>, Object> block;
    public Job cancellationJob;
    public final CoroutineLiveData<T> liveData;
    public final Function0<Unit> onDone;
    public Job runningJob;
    public final CoroutineScope scope;
    public final long timeoutInMs;

    public BlockRunner(CoroutineLiveData<T> coroutineLiveData, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, long j, CoroutineScope coroutineScope, Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {coroutineLiveData, function2, Long.valueOf(j), coroutineScope, function0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.liveData = coroutineLiveData;
        this.block = function2;
        this.timeoutInMs = j;
        this.scope = coroutineScope;
        this.onDone = function0;
    }

    @MainThread
    public final void cancel() {
        Job launch$default;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.cancellationJob == null) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getMain().getImmediate(), null, new BlockRunner$cancel$1(this, null), 2, null);
                this.cancellationJob = launch$default;
                return;
            }
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
        }
    }

    @MainThread
    public final void maybeRun() {
        Job launch$default;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Job job = this.cancellationJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.cancellationJob = null;
            if (this.runningJob != null) {
                return;
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new BlockRunner$maybeRun$1(this, null), 3, null);
            this.runningJob = launch$default;
        }
    }
}

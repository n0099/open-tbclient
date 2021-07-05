package androidx.lifecycle;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0016\u0010\u0001\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0017\u0010\u0007\u001a\u00020\u0004*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"", "JOB_KEY", "Ljava/lang/String;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class ViewModelKt {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";
    public transient /* synthetic */ FieldHolder $fh;

    public static final CoroutineScope getViewModelScope(ViewModel viewModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, viewModel)) == null) {
            CoroutineScope coroutineScope = (CoroutineScope) viewModel.getTag(JOB_KEY);
            if (coroutineScope != null) {
                return coroutineScope;
            }
            Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate())));
            Intrinsics.checkExpressionValueIsNotNull(tagIfAbsent, "setTagIfAbsent(JOB_KEY,\n…patchers.Main.immediate))");
            return (CoroutineScope) tagIfAbsent;
        }
        return (CoroutineScope) invokeL.objValue;
    }
}

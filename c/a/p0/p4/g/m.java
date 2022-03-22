package c.a.p0.p4.g;

import android.view.View;
import com.baidu.tieba.videoplay.fragment.VideoAttentionListPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class m implements View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ m a = new m();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ m() {
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? VideoAttentionListPageFragment.E0(view) : invokeL.booleanValue;
    }
}

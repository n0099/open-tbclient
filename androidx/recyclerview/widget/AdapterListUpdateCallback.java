package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adapter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdapter = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, obj) == null) {
            this.mAdapter.notifyItemRangeChanged(i2, i3, obj);
        }
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            this.mAdapter.notifyItemRangeInserted(i2, i3);
        }
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.mAdapter.notifyItemMoved(i2, i3);
        }
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.mAdapter.notifyItemRangeRemoved(i2, i3);
        }
    }
}

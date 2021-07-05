package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TransitionValuesMaps {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<View> mIdValues;
    public final LongSparseArray<View> mItemIdValues;
    public final ArrayMap<String, View> mNameValues;
    public final ArrayMap<View, TransitionValues> mViewValues;

    public TransitionValuesMaps() {
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
        this.mViewValues = new ArrayMap<>();
        this.mIdValues = new SparseArray<>();
        this.mItemIdValues = new LongSparseArray<>();
        this.mNameValues = new ArrayMap<>();
    }
}

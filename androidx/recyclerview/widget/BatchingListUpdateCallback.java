package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_ADD = 1;
    public static final int TYPE_CHANGE = 3;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_REMOVE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int mLastEventCount;
    public Object mLastEventPayload;
    public int mLastEventPosition;
    public int mLastEventType;
    public final ListUpdateCallback mWrapped;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listUpdateCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLastEventType = 0;
        this.mLastEventPosition = -1;
        this.mLastEventCount = -1;
        this.mLastEventPayload = null;
        this.mWrapped = listUpdateCallback;
    }

    public void dispatchLastEvent() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.mLastEventType) == 0) {
            return;
        }
        if (i2 == 1) {
            this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
        } else if (i2 == 2) {
            this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
        } else if (i2 == 3) {
            this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
        }
        this.mLastEventPayload = null;
        this.mLastEventType = 0;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i2, int i3, Object obj) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj) == null) {
            if (this.mLastEventType == 3) {
                int i5 = this.mLastEventPosition;
                int i6 = this.mLastEventCount;
                if (i2 <= i5 + i6 && (i4 = i2 + i3) >= i5 && this.mLastEventPayload == obj) {
                    this.mLastEventPosition = Math.min(i2, i5);
                    this.mLastEventCount = Math.max(i6 + i5, i4) - this.mLastEventPosition;
                    return;
                }
            }
            dispatchLastEvent();
            this.mLastEventPosition = i2;
            this.mLastEventCount = i3;
            this.mLastEventPayload = obj;
            this.mLastEventType = 3;
        }
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            if (this.mLastEventType == 1 && i2 >= (i4 = this.mLastEventPosition)) {
                int i5 = this.mLastEventCount;
                if (i2 <= i4 + i5) {
                    this.mLastEventCount = i5 + i3;
                    this.mLastEventPosition = Math.min(i2, i4);
                    return;
                }
            }
            dispatchLastEvent();
            this.mLastEventPosition = i2;
            this.mLastEventCount = i3;
            this.mLastEventType = 1;
        }
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            dispatchLastEvent();
            this.mWrapped.onMoved(i2, i3);
        }
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            if (this.mLastEventType == 2 && (i4 = this.mLastEventPosition) >= i2 && i4 <= i2 + i3) {
                this.mLastEventCount += i3;
                this.mLastEventPosition = i2;
                return;
            }
            dispatchLastEvent();
            this.mLastEventPosition = i2;
            this.mLastEventCount = i3;
            this.mLastEventType = 2;
        }
    }
}

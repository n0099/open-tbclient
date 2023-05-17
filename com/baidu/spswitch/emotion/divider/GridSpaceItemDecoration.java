package com.baidu.spswitch.emotion.divider;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float COLUMN_DIVIDER_SIZE = 3.0f;
    public static final float COLUMN_SIZE = 4.0f;
    public static final float ROW_DIVIDER_HEIGHT = 11.0f;
    public transient /* synthetic */ FieldHolder $fh;

    public GridSpaceItemDecoration() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private float getItemLeftWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            return (i / 4.0f) - AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.emotion_dynamic_item_size);
        }
        return invokeI.floatValue;
    }

    private int getRealRecyclerWidth(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, context, i)) == null) {
            Resources resources = AppRuntime.getAppContext().getResources();
            if (i <= 0) {
                return EmotionUtils.getScreenWidth(context) - (resources.getDimensionPixelOffset(R.dimen.expression_left_right_margin) * 2);
            }
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
            float itemLeftWidth = getItemLeftWidth(getRealRecyclerWidth(view2.getContext(), recyclerView.getWidth()));
            float f = (itemLeftWidth * 4.0f) / 3.0f;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
            float f2 = childAdapterPosition % 4.0f;
            if (f2 == 0.0f) {
                if (childAdapterPosition == 0) {
                    rect.left = 0;
                } else {
                    rect.left = (int) ((f * 3.0f) - (itemLeftWidth * 3.0f));
                }
                rect.right = 0;
            } else if (f2 == 1.0f) {
                rect.left = 0;
                rect.right = (int) itemLeftWidth;
            } else if (f2 == 2.0f) {
                rect.left = (int) (f - itemLeftWidth);
                rect.right = (int) ((itemLeftWidth * 2.0f) - f);
            } else if (f2 == 3.0f) {
                float f3 = f * 2.0f;
                rect.left = (int) (f3 - (2.0f * itemLeftWidth));
                rect.right = (int) ((itemLeftWidth * 3.0f) - f3);
            }
            if (childAdapterPosition != 0) {
                rect.top = 0;
                rect.bottom = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 11.0f);
            }
        }
    }
}

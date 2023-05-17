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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class EmoTextGridItemDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float COLUMN_DIVIDER_SIZE = 2.0f;
    public static final float COLUMN_SIZE = 3.0f;
    public static final int LAST_ROW_DIVIDER_HEIGHT;
    public static final float ROW_DIVIDER_HEIGHT = 10.0f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1001608360, "Lcom/baidu/spswitch/emotion/divider/EmoTextGridItemDecoration;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1001608360, "Lcom/baidu/spswitch/emotion/divider/EmoTextGridItemDecoration;");
                return;
            }
        }
        LAST_ROW_DIVIDER_HEIGHT = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 70.0f);
    }

    public EmoTextGridItemDecoration() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private float getItemDividerWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            return (i / 3.0f) - AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.emotion_tab_emo_text_width);
        }
        return invokeI.floatValue;
    }

    private int getRealRecyclerWidth(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, context, i)) == null) {
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
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
            float itemDividerWidth = getItemDividerWidth(getRealRecyclerWidth(view2.getContext(), recyclerView.getWidth()));
            float f2 = (itemDividerWidth * 3.0f) / 2.0f;
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view2);
            float f3 = childAdapterPosition % 3.0f;
            boolean z = false;
            if (f3 == 0.0f) {
                if (childAdapterPosition == 0) {
                    rect.left = 0;
                } else {
                    rect.left = (int) itemDividerWidth;
                }
                rect.right = 0;
            } else if (f3 == 1.0f) {
                rect.left = 0;
                rect.right = (int) itemDividerWidth;
            } else if (f3 == 2.0f) {
                rect.left = (int) (f2 - itemDividerWidth);
                rect.right = (int) ((itemDividerWidth * 2.0f) - f2);
            }
            int itemCount = state.getItemCount();
            if (((int) Math.ceil(f / 3.0f)) == ((int) Math.ceil((itemCount - 1) / 3.0f))) {
                z = true;
            }
            if (itemCount > 0 && z) {
                rect.bottom = LAST_ROW_DIVIDER_HEIGHT;
            } else if (childAdapterPosition != 0) {
                rect.bottom = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 10.0f);
            }
        }
    }
}

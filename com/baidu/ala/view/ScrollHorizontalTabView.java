package com.baidu.ala.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ScrollHorizontalTabView extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mCurrentPositionOffset;
    public int mCurrentTabIndex;
    public final int mIndicatorHeight;
    public final int mIndicatorWidth;
    public Paint mRectPaint;
    public int mScrollOffset;
    public int mSelectorColor;
    public final List<View> mTabItemView;
    public LinearLayout mTabsContainer;

    /* loaded from: classes.dex */
    public class ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView icon;
        public final /* synthetic */ ScrollHorizontalTabView this$0;
        public TextView title;

        public ViewHolder(ScrollHorizontalTabView scrollHorizontalTabView, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollHorizontalTabView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = scrollHorizontalTabView;
            this.title = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092500);
            this.icon = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924fb);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollHorizontalTabView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702d2);
        this.mIndicatorWidth = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070258);
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702d2);
        this.mIndicatorWidth = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070258);
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollHorizontalTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mTabItemView = new ArrayList();
        this.mIndicatorHeight = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702d2);
        this.mIndicatorWidth = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070258);
        this.mCurrentTabIndex = 0;
        this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
        this.mCurrentPositionOffset = 0.0f;
        this.mScrollOffset = 52;
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            setHorizontalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.mTabsContainer = linearLayout;
            linearLayout.setGravity(16);
            this.mTabsContainer.setOrientation(0);
            this.mTabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mTabsContainer.setClipChildren(false);
            addView(this.mTabsContainer);
            Paint paint = new Paint();
            this.mRectPaint = paint;
            paint.setAntiAlias(true);
            this.mRectPaint.setStyle(Paint.Style.FILL);
            this.mScrollOffset = (int) TypedValue.applyDimension(1, this.mScrollOffset, getResources().getDisplayMetrics());
        }
    }

    private void setTabStatus(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, textView, z) != null) || textView == null) {
            return;
        }
        if (z) {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
        } else {
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0107);
        }
    }

    private void updateTabStyles() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            int size = this.mTabItemView.size();
            for (int i = 0; i < size; i++) {
                TextView textView = new ViewHolder(this, this.mTabItemView.get(i)).title;
                if (textView != null) {
                    if (i == this.mCurrentTabIndex) {
                        setTabStatus(textView, true);
                    } else {
                        setTabStatus(textView, false);
                    }
                }
            }
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.mSelectorColor = SkinManager.getColor(R.color.CAM_X0302);
            updateTabStyles();
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            if (!isInEditMode() && !this.mTabItemView.isEmpty()) {
                int height = getHeight();
                this.mRectPaint.setColor(this.mSelectorColor);
                View childAt = this.mTabsContainer.getChildAt(this.mCurrentTabIndex);
                int width = (childAt.getWidth() - childAt.getPaddingLeft()) - childAt.getPaddingRight();
                int left = this.mTabsContainer.getLeft() + childAt.getLeft() + childAt.getPaddingLeft();
                int i = this.mIndicatorWidth;
                float f = left + ((width - i) / 2);
                float f2 = i + f;
                if (this.mCurrentPositionOffset > 0.0f && this.mCurrentTabIndex < this.mTabsContainer.getChildCount() - 1) {
                    View childAt2 = this.mTabsContainer.getChildAt(this.mCurrentTabIndex + 1);
                    int width2 = (childAt2.getWidth() - childAt2.getPaddingRight()) - childAt2.getPaddingLeft();
                    int left2 = childAt2.getLeft() + childAt2.getPaddingLeft() + this.mTabsContainer.getLeft();
                    int i2 = this.mIndicatorWidth;
                    float f3 = left2 + ((width2 - i2) / 2);
                    float f4 = this.mCurrentPositionOffset;
                    f = (f3 * f4) + ((1.0f - f4) * f);
                    f2 = ((i2 + f3) * f4) + ((1.0f - f4) * f2);
                }
                canvas.drawRoundRect(new RectF(f, height - this.mIndicatorHeight, f2, height), 10.0f, 10.0f, this.mRectPaint);
            }
        }
    }
}

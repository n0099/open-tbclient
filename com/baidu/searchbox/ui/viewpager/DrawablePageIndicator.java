package com.baidu.searchbox.ui.viewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.viewpager.BdPagerTabBar;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DrawablePageIndicator extends View implements PageIndicator {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INVALID_POINTER = -1;
    public static float VALUE_NOT_SET = -1.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActivePointerId;
    public int mCurrentPage;
    public Drawable mDrawable;
    public float mIndicatorHeight;
    public float mIndicatorLenPercent;
    public boolean mIsDragging;
    public float mLastMotionX;
    public ViewPager.OnPageChangeListener mListener;
    public BdPagerTabBar mPagerTabBar;
    public float mPositionOffset;
    public int mScrollState;
    public float mShadowLeft;
    public float mShadowRight;
    public GradientDrawable mStandDrawable;
    public int mStandardDrawableHeight;
    public int mStandardDrawableWidth;
    public OnTabClickListener mTabClickListener;
    public SparseIntArray mTabTextWidthArray;
    public int mTouchSlop;
    public Type mType;
    public boolean mUseStandardStyle;
    public ViewPager mViewPager;

    /* renamed from: com.baidu.searchbox.ui.viewpager.DrawablePageIndicator$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface OnTabClickListener {
        void onClick(int i2);
    }

    /* loaded from: classes7.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentPage;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(666262141, "Lcom/baidu/searchbox/ui/viewpager/DrawablePageIndicator$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(666262141, "Lcom/baidu/searchbox/ui/viewpager/DrawablePageIndicator$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.baidu.searchbox.ui.viewpager.DrawablePageIndicator.SavedState.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }
            };
        }

        public /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.currentPage);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.currentPage = parcel.readInt();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type DRAW_BOTTOM_COLOR;
        public static final Type DRAW_BOTTOM_COLOR_TEXT_WIDTH;
        public static final Type DRAW_COLOR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1689859213, "Lcom/baidu/searchbox/ui/viewpager/DrawablePageIndicator$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1689859213, "Lcom/baidu/searchbox/ui/viewpager/DrawablePageIndicator$Type;");
                    return;
                }
            }
            DRAW_COLOR = new Type("DRAW_COLOR", 0);
            DRAW_BOTTOM_COLOR = new Type("DRAW_BOTTOM_COLOR", 1);
            Type type = new Type("DRAW_BOTTOM_COLOR_TEXT_WIDTH", 2);
            DRAW_BOTTOM_COLOR_TEXT_WIDTH = type;
            $VALUES = new Type[]{DRAW_COLOR, DRAW_BOTTOM_COLOR, type};
        }

        public Type(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1641291819, "Lcom/baidu/searchbox/ui/viewpager/DrawablePageIndicator;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1641291819, "Lcom/baidu/searchbox/ui/viewpager/DrawablePageIndicator;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DrawablePageIndicator(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private float getMotionEventX(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, motionEvent, i2)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
            if (findPointerIndex < 0) {
                return -1.0f;
            }
            return MotionEventCompat.getX(motionEvent, findPointerIndex);
        }
        return invokeLI.floatValue;
    }

    public float getTextWidth() {
        InterceptResult invokeV;
        AdapterLinearLayout adapterLinearLayout;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
            if (bdPagerTabBar == null || (adapterLinearLayout = (AdapterLinearLayout) bdPagerTabBar.getChildAt(0)) == null || (childAt = adapterLinearLayout.getChildAt(this.mCurrentPage)) == null || !(childAt instanceof TextView)) {
                return 0.0f;
            }
            TextView textView = (TextView) childAt;
            return textView.getPaint().measureText(textView.getText().toString());
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.searchbox.ui.viewpager.PageIndicator
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            ViewPager viewPager = this.mViewPager;
            if (viewPager == null || (count = viewPager.getAdapter().getCount()) == 0) {
                return;
            }
            if (this.mCurrentPage >= count) {
                setCurrentItem(count - 1);
                return;
            }
            int paddingLeft = getPaddingLeft();
            float width = ((getWidth() - paddingLeft) - getPaddingRight()) / (count * 1.0f);
            float paddingTop = getPaddingTop();
            float height = getHeight() - getPaddingBottom();
            if (this.mUseStandardStyle) {
                float f2 = paddingLeft + ((this.mCurrentPage + this.mPositionOffset) * width);
                float min = Math.min(width, this.mStandardDrawableWidth);
                float f3 = f2 + ((width - min) / 2.0f);
                this.mStandDrawable.setBounds((int) (f3 - this.mShadowLeft), (getPaddingTop() + getHeight()) - this.mStandardDrawableHeight, (int) (min + f3 + this.mShadowRight), (int) height);
                this.mStandDrawable.draw(canvas);
                return;
            }
            Type type = this.mType;
            if (type == Type.DRAW_BOTTOM_COLOR) {
                float f4 = paddingLeft + ((this.mCurrentPage + this.mPositionOffset) * width);
                float f5 = this.mIndicatorLenPercent;
                float min2 = f5 == VALUE_NOT_SET ? Math.min(width, this.mStandardDrawableWidth) : f5 * width;
                float f6 = f4 + ((width - min2) / 2.0f);
                this.mDrawable.setBounds((int) (f6 - this.mShadowLeft), (int) ((getPaddingTop() + getHeight()) - this.mIndicatorHeight), (int) (min2 + f6 + this.mShadowRight), (int) height);
            } else if (type == Type.DRAW_BOTTOM_COLOR_TEXT_WIDTH) {
                int i2 = this.mCurrentPage;
                if (this.mTabTextWidthArray == null) {
                    this.mTabTextWidthArray = new SparseIntArray(count);
                }
                int i3 = this.mTabTextWidthArray.get(i2);
                if (i3 <= 0) {
                    i3 = (int) getTextWidth(i2);
                    this.mTabTextWidthArray.put(i2, i3);
                }
                int i4 = i2 + 1;
                int i5 = this.mTabTextWidthArray.get(i4);
                if (i5 <= 0 && i4 < count) {
                    i5 = (int) getTextWidth(i4);
                    this.mTabTextWidthArray.put(i4, i5);
                }
                float f7 = this.mPositionOffset;
                float f8 = i3 + ((i5 - i3) * f7);
                float f9 = (((this.mCurrentPage + 0.5f) + f7) * width) - (f8 / 2.0f);
                this.mDrawable.setBounds((int) f9, (int) ((getPaddingTop() + getHeight()) - this.mIndicatorHeight), (int) (f9 + f8), (int) height);
            } else if (type == Type.DRAW_COLOR) {
                float f10 = paddingLeft + ((this.mCurrentPage + this.mPositionOffset) * width);
                float f11 = f10 + width;
                float textWidth = getTextWidth();
                float f12 = textWidth != 0.0f ? (width - textWidth) / 2.0f : 0.0f;
                this.mDrawable.setBounds((int) ((f10 - this.mShadowLeft) + f12), (int) paddingTop, (int) ((f11 + this.mShadowRight) - f12), (int) height);
            }
            this.mDrawable.draw(canvas);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mScrollState = i2;
            ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            this.mCurrentPage = i2;
            this.mPositionOffset = f2;
            invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            if (this.mScrollState == 0) {
                this.mCurrentPage = i2;
                this.mPositionOffset = 0.0f;
                invalidate();
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i2);
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.mCurrentPage = savedState.currentPage;
            requestLayout();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPage = this.mCurrentPage;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            if (super.onTouchEvent(motionEvent)) {
                return true;
            }
            ViewPager viewPager = this.mViewPager;
            if (viewPager == null || viewPager.getAdapter().getCount() == 0) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float motionEventX = getMotionEventX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId));
                        if (motionEventX == -1.0f) {
                            return false;
                        }
                        float f2 = motionEventX - this.mLastMotionX;
                        if (!this.mIsDragging && Math.abs(f2) > this.mTouchSlop) {
                            this.mIsDragging = true;
                        }
                        if (this.mIsDragging) {
                            this.mLastMotionX = motionEventX;
                            if (this.mViewPager.isFakeDragging()) {
                                this.mViewPager.beginFakeDrag();
                                try {
                                    this.mViewPager.fakeDragBy(f2);
                                } catch (NullPointerException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    } else if (action != 3) {
                        if (action == 5) {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            float motionEventX2 = getMotionEventX(motionEvent, actionIndex);
                            this.mLastMotionX = motionEventX2;
                            if (motionEventX2 == -1.0f) {
                                return false;
                            }
                            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        } else if (action == 6) {
                            int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                            if (MotionEventCompat.getPointerId(motionEvent, actionIndex2) == this.mActivePointerId) {
                                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex2 == 0 ? 1 : 0);
                            }
                            float motionEventX3 = getMotionEventX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId));
                            this.mLastMotionX = motionEventX3;
                            if (motionEventX3 == -1.0f) {
                                return false;
                            }
                        }
                    }
                }
                if (!this.mIsDragging && action != 3) {
                    int x = (int) (motionEvent.getX() / (getWidth() / this.mViewPager.getAdapter().getCount()));
                    if (x != this.mCurrentPage) {
                        this.mViewPager.setCurrentItem(x);
                        OnTabClickListener onTabClickListener = this.mTabClickListener;
                        if (onTabClickListener != null) {
                            onTabClickListener.onClick(x);
                        }
                        return true;
                    }
                }
                this.mIsDragging = false;
                this.mActivePointerId = -1;
                if (this.mViewPager.isFakeDragging()) {
                    this.mViewPager.endFakeDrag();
                }
            } else {
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                this.mLastMotionX = motionEvent.getX();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.ui.viewpager.PageIndicator
    public void setCurrentItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            ViewPager viewPager = this.mViewPager;
            if (viewPager != null) {
                viewPager.setCurrentItem(i2);
                this.mCurrentPage = i2;
                invalidate();
                return;
            }
            throw new IllegalStateException("ViewPager has not been bound.");
        }
    }

    public void setIndicatorColor(int i2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.mUseStandardStyle) {
            return;
        }
        GradientDrawable gradientDrawable = this.mStandDrawable;
        this.mDrawable = gradientDrawable;
        gradientDrawable.setColor(i2);
        this.mIndicatorLenPercent = (f2 < 0.0f || f2 > 1.0f) ? 1.0f : 1.0f;
        this.mIndicatorHeight = f3;
    }

    public void setIndicatorDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, drawable) == null) {
            this.mDrawable = drawable;
        }
    }

    public void setIndicatorHeight(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048591, this, f2) == null) || this.mUseStandardStyle) {
            return;
        }
        this.mIndicatorHeight = f2;
    }

    public void setIndicatorType(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, type) == null) {
            this.mType = type;
        }
    }

    public void setIndicatorWidth(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048593, this, f2) == null) || this.mUseStandardStyle) {
            return;
        }
        this.mIndicatorLenPercent = (f2 < 0.0f || f2 > 1.0f) ? 1.0f : 1.0f;
    }

    @Override // com.baidu.searchbox.ui.viewpager.PageIndicator
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onPageChangeListener) == null) {
            this.mListener = onPageChangeListener;
        }
    }

    public void setPagerTabBar(BdPagerTabBar bdPagerTabBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bdPagerTabBar) == null) {
            this.mPagerTabBar = bdPagerTabBar;
        }
    }

    public void setTabClickListener(OnTabClickListener onTabClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onTabClickListener) == null) {
            this.mTabClickListener = onTabClickListener;
        }
    }

    public void setTabTextWidthArrayNull() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.mTabTextWidthArray = null;
        }
    }

    public void setUseStandardStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mUseStandardStyle = z;
        }
    }

    @Override // com.baidu.searchbox.ui.viewpager.PageIndicator
    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, viewPager) == null) || (viewPager2 = this.mViewPager) == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.setOnPageChangeListener(null);
        }
        if (viewPager.getAdapter() != null) {
            this.mViewPager = viewPager;
            viewPager.setOnPageChangeListener(this);
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public void updateStandardDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.mStandDrawable.setColor(getResources().getColor(R.color.UC68));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DrawablePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.vpiDrawablePageIndicatorStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawablePageIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mLastMotionX = -1.0f;
        this.mActivePointerId = -1;
        this.mTabTextWidthArray = null;
        this.mUseStandardStyle = true;
        this.mStandardDrawableWidth = getResources().getDimensionPixelSize(R.dimen.bdpager_tab_indicator_width);
        this.mStandardDrawableHeight = getResources().getDimensionPixelSize(R.dimen.bdpager_tab_indicator_height);
        this.mStandDrawable = new GradientDrawable();
        this.mStandDrawable.setColor(getResources().getColor(R.color.UC68));
        this.mStandDrawable.setCornerRadius(this.mStandardDrawableHeight / 2);
        this.mType = Type.DRAW_BOTTOM_COLOR;
        this.mIndicatorLenPercent = VALUE_NOT_SET;
        this.mIndicatorHeight = this.mStandardDrawableHeight;
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DrawablePageIndicator, i2, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.DrawablePageIndicator_android_background);
        if (drawable != null) {
            setBackgroundDrawable(drawable);
        }
        this.mShadowLeft = obtainStyledAttributes.getDimension(R.styleable.DrawablePageIndicator_shadow_left, 0.0f);
        this.mShadowRight = obtainStyledAttributes.getDimension(R.styleable.DrawablePageIndicator_shadow_right, 0.0f);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.DrawablePageIndicator_android_src);
        this.mDrawable = drawable2;
        if (drawable2 == null) {
            this.mDrawable = this.mStandDrawable;
        }
        obtainStyledAttributes.recycle();
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
    }

    public float getTextWidth(int i2) {
        InterceptResult invokeI;
        AdapterLinearLayout adapterLinearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            BdPagerTabBar bdPagerTabBar = this.mPagerTabBar;
            if (bdPagerTabBar != null && (adapterLinearLayout = (AdapterLinearLayout) bdPagerTabBar.getChildAt(0)) != null) {
                View childAt = adapterLinearLayout.getChildAt(i2);
                if (childAt != null && (childAt instanceof TextView)) {
                    TextView textView = (TextView) childAt;
                    return textView.getPaint().measureText(textView.getText().toString());
                } else if (childAt instanceof BdPagerTabBar.PagerNewTipsTabBarItem) {
                    BdPagerTabBar.PagerTabBarItem pagerTabBarItem = ((BdPagerTabBar.PagerNewTipsTabBarItem) childAt).getPagerTabBarItem();
                    return pagerTabBarItem.getPaint().measureText(pagerTabBarItem.getText().toString());
                }
            }
            return 0.0f;
        }
        return invokeI.floatValue;
    }

    public void setIndicatorColor(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) || this.mUseStandardStyle) {
            return;
        }
        GradientDrawable gradientDrawable = this.mStandDrawable;
        this.mDrawable = gradientDrawable;
        gradientDrawable.setColor(i2);
        this.mIndicatorHeight = f2;
    }

    @Override // com.baidu.searchbox.ui.viewpager.PageIndicator
    public void setViewPager(ViewPager viewPager, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, viewPager, i2) == null) {
            setViewPager(viewPager);
            setCurrentItem(i2);
        }
    }

    public void setIndicatorColor(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || this.mUseStandardStyle) {
            return;
        }
        GradientDrawable gradientDrawable = this.mStandDrawable;
        this.mDrawable = gradientDrawable;
        gradientDrawable.setColor(i2);
    }
}

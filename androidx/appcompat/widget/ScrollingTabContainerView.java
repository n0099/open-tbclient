package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FADE_DURATION = 200;
    public static final String TAG = "ScrollingTabContainerView";
    public static final Interpolator sAlphaInterpolator;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAllowCollapse;
    public int mContentHeight;
    public int mMaxTabWidth;
    public int mSelectedTabIndex;
    public int mStackedTabMaxWidth;
    public TabClickListener mTabClickListener;
    public LinearLayoutCompat mTabLayout;
    public Runnable mTabSelector;
    public Spinner mTabSpinner;
    public final VisibilityAnimListener mVisAnimListener;
    public ViewPropertyAnimator mVisibilityAnim;

    /* loaded from: classes.dex */
    public class TabAdapter extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollingTabContainerView this$0;

        public TabAdapter(ScrollingTabContainerView scrollingTabContainerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollingTabContainerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = scrollingTabContainerView;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.this$0.mTabLayout.getChildCount() : invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? ((TabView) this.this$0.mTabLayout.getChildAt(i)).getTab() : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    return this.this$0.createTabView((ActionBar.Tab) getItem(i), true);
                }
                ((TabView) view2).bindTab((ActionBar.Tab) getItem(i));
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class TabClickListener implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ScrollingTabContainerView this$0;

        public TabClickListener(ScrollingTabContainerView scrollingTabContainerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollingTabContainerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = scrollingTabContainerView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ((TabView) view2).getTab().select();
                int childCount = this.this$0.mTabLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.this$0.mTabLayout.getChildAt(i);
                    childAt.setSelected(childAt == view2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class TabView extends LinearLayout {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] BG_ATTRS;
        public View mCustomView;
        public ImageView mIconView;
        public ActionBar.Tab mTab;
        public TextView mTextView;
        public final /* synthetic */ ScrollingTabContainerView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabView(ScrollingTabContainerView scrollingTabContainerView, Context context, ActionBar.Tab tab, boolean z) {
            super(context, null, R$attr.actionBarTabStyle);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollingTabContainerView, context, tab, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = scrollingTabContainerView;
            int[] iArr = {16842964};
            this.BG_ATTRS = iArr;
            this.mTab = tab;
            TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, null, iArr, R$attr.actionBarTabStyle, 0);
            if (obtainStyledAttributes.hasValue(0)) {
                setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            }
            obtainStyledAttributes.recycle();
            if (z) {
                setGravity(8388627);
            }
            update();
        }

        public void bindTab(ActionBar.Tab tab) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, tab) == null) {
                this.mTab = tab;
                update();
            }
        }

        public ActionBar.Tab getTab() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTab : (ActionBar.Tab) invokeV.objValue;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(accessibilityEvent);
                accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, accessibilityNodeInfo) == null) {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
                super.onMeasure(i, i2);
                if (this.this$0.mMaxTabWidth > 0) {
                    int measuredWidth = getMeasuredWidth();
                    int i3 = this.this$0.mMaxTabWidth;
                    if (measuredWidth > i3) {
                        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                boolean z2 = isSelected() != z;
                super.setSelected(z);
                if (z2 && z) {
                    sendAccessibilityEvent(4);
                }
            }
        }

        public void update() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                ActionBar.Tab tab = this.mTab;
                View customView = tab.getCustomView();
                if (customView != null) {
                    ViewParent parent = customView.getParent();
                    if (parent != this) {
                        if (parent != null) {
                            ((ViewGroup) parent).removeView(customView);
                        }
                        addView(customView);
                    }
                    this.mCustomView = customView;
                    TextView textView = this.mTextView;
                    if (textView != null) {
                        textView.setVisibility(8);
                    }
                    ImageView imageView = this.mIconView;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                        this.mIconView.setImageDrawable(null);
                        return;
                    }
                    return;
                }
                View view2 = this.mCustomView;
                if (view2 != null) {
                    removeView(view2);
                    this.mCustomView = null;
                }
                Drawable icon = tab.getIcon();
                CharSequence text = tab.getText();
                if (icon != null) {
                    if (this.mIconView == null) {
                        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 16;
                        appCompatImageView.setLayoutParams(layoutParams);
                        addView(appCompatImageView, 0);
                        this.mIconView = appCompatImageView;
                    }
                    this.mIconView.setImageDrawable(icon);
                    this.mIconView.setVisibility(0);
                } else {
                    ImageView imageView2 = this.mIconView;
                    if (imageView2 != null) {
                        imageView2.setVisibility(8);
                        this.mIconView.setImageDrawable(null);
                    }
                }
                boolean z = !TextUtils.isEmpty(text);
                if (z) {
                    if (this.mTextView == null) {
                        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R$attr.actionBarTabTextStyle);
                        appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams2.gravity = 16;
                        appCompatTextView.setLayoutParams(layoutParams2);
                        addView(appCompatTextView);
                        this.mTextView = appCompatTextView;
                    }
                    this.mTextView.setText(text);
                    this.mTextView.setVisibility(0);
                } else {
                    TextView textView2 = this.mTextView;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                        this.mTextView.setText((CharSequence) null);
                    }
                }
                ImageView imageView3 = this.mIconView;
                if (imageView3 != null) {
                    imageView3.setContentDescription(tab.getContentDescription());
                }
                TooltipCompat.setTooltipText(this, z ? null : tab.getContentDescription());
            }
        }
    }

    /* loaded from: classes.dex */
    public class VisibilityAnimListener extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mCanceled;
        public int mFinalVisibility;
        public final /* synthetic */ ScrollingTabContainerView this$0;

        public VisibilityAnimListener(ScrollingTabContainerView scrollingTabContainerView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scrollingTabContainerView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = scrollingTabContainerView;
            this.mCanceled = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.mCanceled = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.mCanceled) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = this.this$0;
            scrollingTabContainerView.mVisibilityAnim = null;
            scrollingTabContainerView.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                this.this$0.setVisibility(0);
                this.mCanceled = false;
            }
        }

        public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator viewPropertyAnimator, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewPropertyAnimator, i)) == null) {
                this.mFinalVisibility = i;
                this.this$0.mVisibilityAnim = viewPropertyAnimator;
                return this;
            }
            return (VisibilityAnimListener) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2014749318, "Landroidx/appcompat/widget/ScrollingTabContainerView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2014749318, "Landroidx/appcompat/widget/ScrollingTabContainerView;");
                return;
            }
        }
        sAlphaInterpolator = new DecelerateInterpolator();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingTabContainerView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mVisAnimListener = new VisibilityAnimListener(this);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(context);
        setContentHeight(actionBarPolicy.getTabContainerHeight());
        this.mStackedTabMaxWidth = actionBarPolicy.getStackedTabMaxWidth();
        LinearLayoutCompat createTabLayout = createTabLayout();
        this.mTabLayout = createTabLayout;
        addView(createTabLayout, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner createSpinner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R$attr.actionDropDownStyle);
            appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
            appCompatSpinner.setOnItemSelectedListener(this);
            return appCompatSpinner;
        }
        return (Spinner) invokeV.objValue;
    }

    private LinearLayoutCompat createTabLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R$attr.actionBarTabBarStyle);
            linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
            linearLayoutCompat.setGravity(17);
            linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
            return linearLayoutCompat;
        }
        return (LinearLayoutCompat) invokeV.objValue;
    }

    private boolean isCollapsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            Spinner spinner = this.mTabSpinner;
            return spinner != null && spinner.getParent() == this;
        }
        return invokeV.booleanValue;
    }

    private void performCollapse() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || isCollapsed()) {
            return;
        }
        if (this.mTabSpinner == null) {
            this.mTabSpinner = createSpinner();
        }
        removeView(this.mTabLayout);
        addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
        if (this.mTabSpinner.getAdapter() == null) {
            this.mTabSpinner.setAdapter((SpinnerAdapter) new TabAdapter(this));
        }
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.mTabSelector = null;
        }
        this.mTabSpinner.setSelection(this.mSelectedTabIndex);
    }

    private boolean performExpand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (isCollapsed()) {
                removeView(this.mTabSpinner);
                addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
                setTabSelected(this.mTabSpinner.getSelectedItemPosition());
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void addTab(ActionBar.Tab tab, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tab, z) == null) {
            TabView createTabView = createTabView(tab, false);
            this.mTabLayout.addView(createTabView, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
            Spinner spinner = this.mTabSpinner;
            if (spinner != null) {
                ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
            }
            if (z) {
                createTabView.setSelected(true);
            }
            if (this.mAllowCollapse) {
                requestLayout();
            }
        }
    }

    public void animateToTab(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            View childAt = this.mTabLayout.getChildAt(i);
            Runnable runnable = this.mTabSelector;
            if (runnable != null) {
                removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable(this, childAt) { // from class: androidx.appcompat.widget.ScrollingTabContainerView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ScrollingTabContainerView this$0;
                public final /* synthetic */ View val$tabView;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, childAt};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$tabView = childAt;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.smoothScrollTo(this.val$tabView.getLeft() - ((this.this$0.getWidth() - this.val$tabView.getWidth()) / 2), 0);
                        this.this$0.mTabSelector = null;
                    }
                }
            };
            this.mTabSelector = runnable2;
            post(runnable2);
        }
    }

    public void animateToVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            ViewPropertyAnimator viewPropertyAnimator = this.mVisibilityAnim;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
            }
            if (i == 0) {
                if (getVisibility() != 0) {
                    setAlpha(0.0f);
                }
                ViewPropertyAnimator alpha = animate().alpha(1.0f);
                alpha.setDuration(200L);
                alpha.setInterpolator(sAlphaInterpolator);
                alpha.setListener(this.mVisAnimListener.withFinalVisibility(alpha, i));
                alpha.start();
                return;
            }
            ViewPropertyAnimator alpha2 = animate().alpha(0.0f);
            alpha2.setDuration(200L);
            alpha2.setInterpolator(sAlphaInterpolator);
            alpha2.setListener(this.mVisAnimListener.withFinalVisibility(alpha2, i));
            alpha2.start();
        }
    }

    public TabView createTabView(ActionBar.Tab tab, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, tab, z)) == null) {
            TabView tabView = new TabView(this, getContext(), tab, z);
            if (z) {
                tabView.setBackgroundDrawable(null);
                tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
            } else {
                tabView.setFocusable(true);
                if (this.mTabClickListener == null) {
                    this.mTabClickListener = new TabClickListener(this);
                }
                tabView.setOnClickListener(this.mTabClickListener);
            }
            return tabView;
        }
        return (TabView) invokeLZ.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            Runnable runnable = this.mTabSelector;
            if (runnable != null) {
                post(runnable);
            }
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            ActionBarPolicy actionBarPolicy = ActionBarPolicy.get(getContext());
            setContentHeight(actionBarPolicy.getTabContainerHeight());
            this.mStackedTabMaxWidth = actionBarPolicy.getStackedTabMaxWidth();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            Runnable runnable = this.mTabSelector;
            if (runnable != null) {
                removeCallbacks(runnable);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ((TabView) view2).getTab().select();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            int mode = View.MeasureSpec.getMode(i);
            boolean z = true;
            boolean z2 = mode == 1073741824;
            setFillViewport(z2);
            int childCount = this.mTabLayout.getChildCount();
            if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
                if (childCount > 2) {
                    this.mMaxTabWidth = (int) (View.MeasureSpec.getSize(i) * 0.4f);
                } else {
                    this.mMaxTabWidth = View.MeasureSpec.getSize(i) / 2;
                }
                this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
            } else {
                this.mMaxTabWidth = -1;
            }
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
            if ((z2 || !this.mAllowCollapse) ? false : false) {
                this.mTabLayout.measure(0, makeMeasureSpec);
                if (this.mTabLayout.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                    performCollapse();
                } else {
                    performExpand();
                }
            } else {
                performExpand();
            }
            int measuredWidth = getMeasuredWidth();
            super.onMeasure(i, makeMeasureSpec);
            int measuredWidth2 = getMeasuredWidth();
            if (!z2 || measuredWidth == measuredWidth2) {
                return;
            }
            setTabSelected(this.mSelectedTabIndex);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, adapterView) == null) {
        }
    }

    public void removeAllTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mTabLayout.removeAllViews();
            Spinner spinner = this.mTabSpinner;
            if (spinner != null) {
                ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
            }
            if (this.mAllowCollapse) {
                requestLayout();
            }
        }
    }

    public void removeTabAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mTabLayout.removeViewAt(i);
            Spinner spinner = this.mTabSpinner;
            if (spinner != null) {
                ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
            }
            if (this.mAllowCollapse) {
                requestLayout();
            }
        }
    }

    public void setAllowCollapse(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mAllowCollapse = z;
        }
    }

    public void setContentHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mContentHeight = i;
            requestLayout();
        }
    }

    public void setTabSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mSelectedTabIndex = i;
            int childCount = this.mTabLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = this.mTabLayout.getChildAt(i2);
                boolean z = i2 == i;
                childAt.setSelected(z);
                if (z) {
                    animateToTab(i);
                }
                i2++;
            }
            Spinner spinner = this.mTabSpinner;
            if (spinner == null || i < 0) {
                return;
            }
            spinner.setSelection(i);
        }
    }

    public void updateTab(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            ((TabView) this.mTabLayout.getChildAt(i)).update();
            Spinner spinner = this.mTabSpinner;
            if (spinner != null) {
                ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
            }
            if (this.mAllowCollapse) {
                requestLayout();
            }
        }
    }

    public void addTab(ActionBar.Tab tab, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tab, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            TabView createTabView = createTabView(tab, false);
            this.mTabLayout.addView(createTabView, i, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
            Spinner spinner = this.mTabSpinner;
            if (spinner != null) {
                ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
            }
            if (z) {
                createTabView.setSelected(true);
            }
            if (this.mAllowCollapse) {
                requestLayout();
            }
        }
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Toolbar";
    public transient /* synthetic */ FieldHolder $fh;
    public MenuPresenter.Callback mActionMenuPresenterCallback;
    public int mButtonGravity;
    public ImageButton mCollapseButtonView;
    public CharSequence mCollapseDescription;
    public Drawable mCollapseIcon;
    public boolean mCollapsible;
    public int mContentInsetEndWithActions;
    public int mContentInsetStartWithNavigation;
    public RtlSpacingHelper mContentInsets;
    public boolean mEatingHover;
    public boolean mEatingTouch;
    public View mExpandedActionView;
    public ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    public int mGravity;
    public final ArrayList<View> mHiddenViews;
    public ImageView mLogoView;
    public int mMaxButtonHeight;
    public MenuBuilder.Callback mMenuBuilderCallback;
    public ActionMenuView mMenuView;
    public final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    public ImageButton mNavButtonView;
    public OnMenuItemClickListener mOnMenuItemClickListener;
    public ActionMenuPresenter mOuterActionMenuPresenter;
    public Context mPopupContext;
    public int mPopupTheme;
    public final Runnable mShowOverflowMenuRunnable;
    public CharSequence mSubtitleText;
    public int mSubtitleTextAppearance;
    public ColorStateList mSubtitleTextColor;
    public TextView mSubtitleTextView;
    public final int[] mTempMargins;
    public final ArrayList<View> mTempViews;
    public int mTitleMarginBottom;
    public int mTitleMarginEnd;
    public int mTitleMarginStart;
    public int mTitleMarginTop;
    public CharSequence mTitleText;
    public int mTitleTextAppearance;
    public ColorStateList mTitleTextColor;
    public TextView mTitleTextView;
    public ToolbarWidgetWrapper mWrapper;

    /* loaded from: classes.dex */
    public class ExpandedActionViewMenuPresenter implements MenuPresenter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MenuItemImpl mCurrentExpandedItem;
        public MenuBuilder mMenu;
        public final /* synthetic */ Toolbar this$0;

        public ExpandedActionViewMenuPresenter(Toolbar toolbar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toolbar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = toolbar;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, menuBuilder, menuItemImpl)) == null) {
                View view = this.this$0.mExpandedActionView;
                if (view instanceof CollapsibleActionView) {
                    ((CollapsibleActionView) view).onActionViewCollapsed();
                }
                Toolbar toolbar = this.this$0;
                toolbar.removeView(toolbar.mExpandedActionView);
                Toolbar toolbar2 = this.this$0;
                toolbar2.removeView(toolbar2.mCollapseButtonView);
                Toolbar toolbar3 = this.this$0;
                toolbar3.mExpandedActionView = null;
                toolbar3.addChildrenForExpandedActionView();
                this.mCurrentExpandedItem = null;
                this.this$0.requestLayout();
                menuItemImpl.setActionViewExpanded(false);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, menuBuilder, menuItemImpl)) == null) {
                this.this$0.ensureCollapseButtonView();
                ViewParent parent = this.this$0.mCollapseButtonView.getParent();
                Toolbar toolbar = this.this$0;
                if (parent != toolbar) {
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                    }
                    Toolbar toolbar2 = this.this$0;
                    toolbar2.addView(toolbar2.mCollapseButtonView);
                }
                this.this$0.mExpandedActionView = menuItemImpl.getActionView();
                this.mCurrentExpandedItem = menuItemImpl;
                ViewParent parent2 = this.this$0.mExpandedActionView.getParent();
                Toolbar toolbar3 = this.this$0;
                if (parent2 != toolbar3) {
                    if (parent2 instanceof ViewGroup) {
                        ((ViewGroup) parent2).removeView(toolbar3.mExpandedActionView);
                    }
                    LayoutParams generateDefaultLayoutParams = this.this$0.generateDefaultLayoutParams();
                    Toolbar toolbar4 = this.this$0;
                    generateDefaultLayoutParams.gravity = 8388611 | (toolbar4.mButtonGravity & 112);
                    generateDefaultLayoutParams.mViewType = 2;
                    toolbar4.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                    Toolbar toolbar5 = this.this$0;
                    toolbar5.addView(toolbar5.mExpandedActionView);
                }
                this.this$0.removeChildrenForExpandedActionView();
                this.this$0.requestLayout();
                menuItemImpl.setActionViewExpanded(true);
                View view = this.this$0.mExpandedActionView;
                if (view instanceof CollapsibleActionView) {
                    ((CollapsibleActionView) view).onActionViewExpanded();
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean flagActionItems() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public MenuView getMenuView(ViewGroup viewGroup) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
                return null;
            }
            return (MenuView) invokeL.objValue;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, context, menuBuilder) == null) {
                MenuBuilder menuBuilder2 = this.mMenu;
                if (menuBuilder2 != null && (menuItemImpl = this.mCurrentExpandedItem) != null) {
                    menuBuilder2.collapseItemActionView(menuItemImpl);
                }
                this.mMenu = menuBuilder;
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048582, this, menuBuilder, z) == null) {
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, parcelable) == null) {
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return null;
            }
            return (Parcelable) invokeV.objValue;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, subMenuBuilder)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, callback) == null) {
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.mCurrentExpandedItem == null) {
                return;
            }
            MenuBuilder menuBuilder = this.mMenu;
            boolean z2 = false;
            if (menuBuilder != null) {
                int size = menuBuilder.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (this.mMenu.getItem(i2) == this.mCurrentExpandedItem) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (z2) {
                return;
            }
            collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
        }
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int expandedMenuItemId;
        public boolean isOverflowOpen;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-399331005, "Landroidx/appcompat/widget/Toolbar$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-399331005, "Landroidx/appcompat/widget/Toolbar$SavedState;");
                    return;
                }
            }
            CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.Toolbar.SavedState.1
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
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }
            };
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            this(parcel, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.expandedMenuItemId);
                parcel.writeInt(this.isOverflowOpen ? 1 : 0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Toolbar(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addCustomViewsWithGravity(List<View> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, list, i2) == null) {
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            int childCount = getChildCount();
            int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, ViewCompat.getLayoutDirection(this));
            list.clear();
            if (!z) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == absoluteGravity) {
                        list.add(childAt);
                    }
                }
                return;
            }
            for (int i4 = childCount - 1; i4 >= 0; i4--) {
                View childAt2 = getChildAt(i4);
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams2.mViewType == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams2.gravity) == absoluteGravity) {
                    list.add(childAt2);
                }
            }
        }
    }

    private void addSystemView(View view, boolean z) {
        LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65540, this, view, z) == null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = generateDefaultLayoutParams();
            } else if (!checkLayoutParams(layoutParams2)) {
                layoutParams = generateLayoutParams(layoutParams2);
            } else {
                layoutParams = (LayoutParams) layoutParams2;
            }
            layoutParams.mViewType = 1;
            if (z && this.mExpandedActionView != null) {
                view.setLayoutParams(layoutParams);
                this.mHiddenViews.add(view);
                return;
            }
            addView(view, layoutParams);
        }
    }

    private void ensureContentInsets() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && this.mContentInsets == null) {
            this.mContentInsets = new RtlSpacingHelper();
        }
    }

    private void ensureLogoView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) && this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    private void ensureMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ensureMenuView();
            if (this.mMenuView.peekMenu() == null) {
                MenuBuilder menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
                }
                this.mMenuView.setExpandedActionViewsExclusive(true);
                menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
            }
        }
    }

    private void ensureMenuView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65544, this) == null) && this.mMenuView == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.mMenuView = actionMenuView;
            actionMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private void ensureNavButtonView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private int getChildHorizontalGravity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i2)) == null) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            int absoluteGravity = GravityCompat.getAbsoluteGravity(i2, layoutDirection) & 7;
            return (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) ? absoluteGravity : layoutDirection == 1 ? 5 : 3;
        }
        return invokeI.intValue;
    }

    private int getChildTop(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, this, view, i2)) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int measuredHeight = view.getMeasuredHeight();
            int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
            int childVerticalGravity = getChildVerticalGravity(layoutParams.gravity);
            if (childVerticalGravity != 48) {
                if (childVerticalGravity != 80) {
                    int paddingTop = getPaddingTop();
                    int paddingBottom = getPaddingBottom();
                    int height = getHeight();
                    int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    if (i4 < i5) {
                        i4 = i5;
                    } else {
                        int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
                        int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        if (i6 < i7) {
                            i4 = Math.max(0, i4 - (i7 - i6));
                        }
                    }
                    return paddingTop + i4;
                }
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i3;
            }
            return getPaddingTop() - i3;
        }
        return invokeLI.intValue;
    }

    private int getChildVerticalGravity(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i2)) == null) {
            int i3 = i2 & 112;
            return (i3 == 16 || i3 == 48 || i3 == 80) ? i3 : this.mGravity & 112;
        }
        return invokeI.intValue;
    }

    private int getHorizontalMargins(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, view)) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
        }
        return invokeL.intValue;
    }

    private MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? new SupportMenuInflater(getContext()) : (MenuInflater) invokeV.objValue;
    }

    private int getVerticalMargins(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, view)) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return invokeL.intValue;
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, list, iArr)) == null) {
            int i2 = iArr[0];
            int i3 = iArr[1];
            int size = list.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size) {
                View view = list.get(i4);
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i2;
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i3;
                int max = Math.max(0, i6);
                int max2 = Math.max(0, i7);
                int max3 = Math.max(0, -i6);
                int max4 = Math.max(0, -i7);
                i5 += max + view.getMeasuredWidth() + max2;
                i4++;
                i3 = max4;
                i2 = max3;
            }
            return i5;
        }
        return invokeLL.intValue;
    }

    private boolean isChildOrHidden(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, this, view)) == null) ? view.getParent() == this || this.mHiddenViews.contains(view) : invokeL.booleanValue;
    }

    private int layoutChildLeft(View view, int i2, int[] iArr, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, this, new Object[]{view, Integer.valueOf(i2), iArr, Integer.valueOf(i3)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
            int max = i2 + Math.max(0, i4);
            iArr[0] = Math.max(0, -i4);
            int childTop = getChildTop(view, i3);
            int measuredWidth = view.getMeasuredWidth();
            view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
            return max + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }
        return invokeCommon.intValue;
    }

    private int layoutChildRight(View view, int i2, int[] iArr, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, this, new Object[]{view, Integer.valueOf(i2), iArr, Integer.valueOf(i3)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
            int max = i2 - Math.max(0, i4);
            iArr[1] = Math.max(0, -i4);
            int childTop = getChildTop(view, i3);
            int measuredWidth = view.getMeasuredWidth();
            view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
            return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
        }
        return invokeCommon.intValue;
    }

    private int measureChildCollapseMargins(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i6 = marginLayoutParams.leftMargin - iArr[0];
            int i7 = marginLayoutParams.rightMargin - iArr[1];
            int max = Math.max(0, i6) + Math.max(0, i7);
            iArr[0] = Math.max(0, -i6);
            iArr[1] = Math.max(0, -i7);
            view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
            return view.getMeasuredWidth() + max;
        }
        return invokeCommon.intValue;
    }

    private void measureChildConstrained(View view, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
            int mode = View.MeasureSpec.getMode(childMeasureSpec2);
            if (mode != 1073741824 && i6 >= 0) {
                if (mode != 0) {
                    i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
                }
                childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            }
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    private void postShowOverflowMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            removeCallbacks(this.mShowOverflowMenuRunnable);
            post(this.mShowOverflowMenuRunnable);
        }
    }

    private boolean shouldCollapse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            if (this.mCollapsible) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean shouldLayout(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, this, view)) == null) ? (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true : invokeL.booleanValue;
    }

    public void addChildrenForExpandedActionView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
                addView(this.mHiddenViews.get(size));
            }
            this.mHiddenViews.clear();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean canShowOverflowMenu() {
        InterceptResult invokeV;
        ActionMenuView actionMenuView;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getVisibility() == 0 && (actionMenuView = this.mMenuView) != null && actionMenuView.isOverflowReserved() : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) ? super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams) : invokeL.booleanValue;
    }

    public void collapseActionView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
            MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter == null ? null : expandedActionViewMenuPresenter.mCurrentExpandedItem;
            if (menuItemImpl != null) {
                menuItemImpl.collapseActionView();
            }
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (actionMenuView = this.mMenuView) == null) {
            return;
        }
        actionMenuView.dismissPopupMenus();
    }

    public void ensureCollapseButtonView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.mCollapseButtonView == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.mButtonGravity & 112);
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener(this) { // from class: androidx.appcompat.widget.Toolbar.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Toolbar this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.this$0.collapseActionView();
                    }
                }
            });
        }
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ImageButton imageButton = this.mCollapseButtonView;
            if (imageButton != null) {
                return imageButton.getContentDescription();
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ImageButton imageButton = this.mCollapseButtonView;
            if (imageButton != null) {
                return imageButton.getDrawable();
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public int getContentInsetEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
            if (rtlSpacingHelper != null) {
                return rtlSpacingHelper.getEnd();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getContentInsetEndWithActions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.mContentInsetEndWithActions;
            return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
        }
        return invokeV.intValue;
    }

    public int getContentInsetLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
            if (rtlSpacingHelper != null) {
                return rtlSpacingHelper.getLeft();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getContentInsetRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
            if (rtlSpacingHelper != null) {
                return rtlSpacingHelper.getRight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getContentInsetStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
            if (rtlSpacingHelper != null) {
                return rtlSpacingHelper.getStart();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getContentInsetStartWithNavigation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i2 = this.mContentInsetStartWithNavigation;
            return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
        }
        return invokeV.intValue;
    }

    public int getCurrentContentInsetEnd() {
        InterceptResult invokeV;
        MenuBuilder peekMenu;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ActionMenuView actionMenuView = this.mMenuView;
            if ((actionMenuView == null || (peekMenu = actionMenuView.peekMenu()) == null || !peekMenu.hasVisibleItems()) ? false : true) {
                return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
            }
            return getContentInsetEnd();
        }
        return invokeV.intValue;
    }

    public int getCurrentContentInsetLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (ViewCompat.getLayoutDirection(this) == 1) {
                return getCurrentContentInsetEnd();
            }
            return getCurrentContentInsetStart();
        }
        return invokeV.intValue;
    }

    public int getCurrentContentInsetRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (ViewCompat.getLayoutDirection(this) == 1) {
                return getCurrentContentInsetStart();
            }
            return getCurrentContentInsetEnd();
        }
        return invokeV.intValue;
    }

    public int getCurrentContentInsetStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (getNavigationIcon() != null) {
                return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
            }
            return getContentInsetStart();
        }
        return invokeV.intValue;
    }

    public Drawable getLogo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ImageView imageView = this.mLogoView;
            if (imageView != null) {
                return imageView.getDrawable();
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public CharSequence getLogoDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ImageView imageView = this.mLogoView;
            if (imageView != null) {
                return imageView.getContentDescription();
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    public Menu getMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            ensureMenu();
            return this.mMenuView.getMenu();
        }
        return (Menu) invokeV.objValue;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null) {
                return imageButton.getContentDescription();
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null) {
                return imageButton.getDrawable();
            }
            return null;
        }
        return (Drawable) invokeV.objValue;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mOuterActionMenuPresenter : (ActionMenuPresenter) invokeV.objValue;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            ensureMenu();
            return this.mMenuView.getOverflowIcon();
        }
        return (Drawable) invokeV.objValue;
    }

    public Context getPopupContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mPopupContext : (Context) invokeV.objValue;
    }

    public int getPopupTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mPopupTheme : invokeV.intValue;
    }

    public CharSequence getSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mSubtitleText : (CharSequence) invokeV.objValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getSubtitleTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mSubtitleTextView : (TextView) invokeV.objValue;
    }

    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mTitleText : (CharSequence) invokeV.objValue;
    }

    public int getTitleMarginBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mTitleMarginBottom : invokeV.intValue;
    }

    public int getTitleMarginEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mTitleMarginEnd : invokeV.intValue;
    }

    public int getTitleMarginStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mTitleMarginStart : invokeV.intValue;
    }

    public int getTitleMarginTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mTitleMarginTop : invokeV.intValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getTitleTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mTitleTextView : (TextView) invokeV.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DecorToolbar getWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.mWrapper == null) {
                this.mWrapper = new ToolbarWidgetWrapper(this, true);
            }
            return this.mWrapper;
        }
        return (DecorToolbar) invokeV.objValue;
    }

    public boolean hasExpandedActionView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
            return (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean hideOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ActionMenuView actionMenuView = this.mMenuView;
            return actionMenuView != null && actionMenuView.hideOverflowMenu();
        }
        return invokeV.booleanValue;
    }

    public void inflateMenu(@MenuRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            getMenuInflater().inflate(i2, getMenu());
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            ActionMenuView actionMenuView = this.mMenuView;
            return actionMenuView != null && actionMenuView.isOverflowMenuShowPending();
        }
        return invokeV.booleanValue;
    }

    public boolean isOverflowMenuShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            ActionMenuView actionMenuView = this.mMenuView;
            return actionMenuView != null && actionMenuView.isOverflowMenuShowing();
        }
        return invokeV.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        InterceptResult invokeV;
        Layout layout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            TextView textView = this.mTitleTextView;
            if (textView == null || (layout = textView.getLayout()) == null) {
                return false;
            }
            int lineCount = layout.getLineCount();
            for (int i2 = 0; i2 < lineCount; i2++) {
                if (layout.getEllipsisCount(i2) > 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onDetachedFromWindow();
            removeCallbacks(this.mShowOverflowMenuRunnable);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 9) {
                this.mEatingHover = false;
            }
            if (!this.mEatingHover) {
                boolean onHoverEvent = super.onHoverEvent(motionEvent);
                if (actionMasked == 9 && !onHoverEvent) {
                    this.mEatingHover = true;
                }
            }
            if (actionMasked == 10 || actionMasked == 3) {
                this.mEatingHover = false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x02a7 A[LOOP:0: B:106:0x02a5->B:107:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02c9 A[LOOP:1: B:109:0x02c7->B:110:0x02c9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0302 A[LOOP:2: B:118:0x0300->B:119:0x0302, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x022d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        boolean shouldLayout;
        boolean shouldLayout2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int paddingTop;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int size;
        int i21;
        int size2;
        int i22;
        int i23;
        int size3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048626, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) != null) {
            return;
        }
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i24 = width - paddingRight;
        int[] iArr = this.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        int min = minimumHeight >= 0 ? Math.min(minimumHeight, i5 - i3) : 0;
        if (!shouldLayout(this.mNavButtonView)) {
            i6 = paddingLeft;
        } else if (z2) {
            i7 = layoutChildRight(this.mNavButtonView, i24, iArr, min);
            i6 = paddingLeft;
            if (shouldLayout(this.mCollapseButtonView)) {
                if (z2) {
                    i7 = layoutChildRight(this.mCollapseButtonView, i7, iArr, min);
                } else {
                    i6 = layoutChildLeft(this.mCollapseButtonView, i6, iArr, min);
                }
            }
            if (shouldLayout(this.mMenuView)) {
                if (z2) {
                    i6 = layoutChildLeft(this.mMenuView, i6, iArr, min);
                } else {
                    i7 = layoutChildRight(this.mMenuView, i7, iArr, min);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - i6);
            iArr[1] = Math.max(0, currentContentInsetRight - (i24 - i7));
            int max = Math.max(i6, currentContentInsetLeft);
            int min2 = Math.min(i7, i24 - currentContentInsetRight);
            if (shouldLayout(this.mExpandedActionView)) {
                if (z2) {
                    min2 = layoutChildRight(this.mExpandedActionView, min2, iArr, min);
                } else {
                    max = layoutChildLeft(this.mExpandedActionView, max, iArr, min);
                }
            }
            if (shouldLayout(this.mLogoView)) {
                if (z2) {
                    min2 = layoutChildRight(this.mLogoView, min2, iArr, min);
                } else {
                    max = layoutChildLeft(this.mLogoView, max, iArr, min);
                }
            }
            shouldLayout = shouldLayout(this.mTitleTextView);
            shouldLayout2 = shouldLayout(this.mSubtitleTextView);
            if (shouldLayout) {
                i8 = paddingRight;
                i9 = 0;
            } else {
                LayoutParams layoutParams = (LayoutParams) this.mTitleTextView.getLayoutParams();
                i8 = paddingRight;
                i9 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.mTitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + 0;
            }
            if (shouldLayout2) {
                i10 = width;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                i10 = width;
                i9 += ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + this.mSubtitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
            }
            if (!shouldLayout || shouldLayout2) {
                TextView textView = !shouldLayout ? this.mTitleTextView : this.mSubtitleTextView;
                TextView textView2 = !shouldLayout2 ? this.mSubtitleTextView : this.mTitleTextView;
                LayoutParams layoutParams3 = (LayoutParams) textView.getLayoutParams();
                LayoutParams layoutParams4 = (LayoutParams) textView2.getLayoutParams();
                boolean z3 = (!shouldLayout && this.mTitleTextView.getMeasuredWidth() > 0) || (shouldLayout2 && this.mSubtitleTextView.getMeasuredWidth() > 0);
                i11 = this.mGravity & 112;
                i12 = paddingLeft;
                if (i11 != 48) {
                    i13 = max;
                    i14 = min;
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + this.mTitleMarginTop;
                } else if (i11 != 80) {
                    int i25 = (((height - paddingTop2) - paddingBottom) - i9) / 2;
                    int i26 = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin;
                    i14 = min;
                    int i27 = this.mTitleMarginTop;
                    i13 = max;
                    if (i25 < i26 + i27) {
                        i25 = i26 + i27;
                    } else {
                        int i28 = (((height - paddingBottom) - i9) - i25) - paddingTop2;
                        int i29 = ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                        int i30 = this.mTitleMarginBottom;
                        if (i28 < i29 + i30) {
                            i25 = Math.max(0, i25 - ((((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin + i30) - i28));
                        }
                    }
                    paddingTop = paddingTop2 + i25;
                } else {
                    i13 = max;
                    i14 = min;
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) - this.mTitleMarginBottom) - i9;
                }
                if (!z2) {
                    int i31 = (z3 ? this.mTitleMarginStart : 0) - iArr[1];
                    min2 -= Math.max(0, i31);
                    iArr[1] = Math.max(0, -i31);
                    if (shouldLayout) {
                        int measuredWidth = min2 - this.mTitleTextView.getMeasuredWidth();
                        int measuredHeight = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                        this.mTitleTextView.layout(measuredWidth, paddingTop, min2, measuredHeight);
                        i19 = measuredWidth - this.mTitleMarginEnd;
                        paddingTop = measuredHeight + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mTitleTextView.getLayoutParams())).bottomMargin;
                    } else {
                        i19 = min2;
                    }
                    if (shouldLayout2) {
                        LayoutParams layoutParams5 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                        int i32 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin;
                        this.mSubtitleTextView.layout(min2 - this.mSubtitleTextView.getMeasuredWidth(), i32, min2, this.mSubtitleTextView.getMeasuredHeight() + i32);
                        i20 = min2 - this.mTitleMarginEnd;
                        int i33 = ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin;
                    } else {
                        i20 = min2;
                    }
                    if (z3) {
                        min2 = Math.min(i19, i20);
                    }
                    max = i13;
                } else {
                    if (z3) {
                        i16 = this.mTitleMarginStart;
                        i15 = 0;
                    } else {
                        i15 = 0;
                        i16 = 0;
                    }
                    int i34 = i16 - iArr[i15];
                    max = i13 + Math.max(i15, i34);
                    iArr[i15] = Math.max(i15, -i34);
                    if (shouldLayout) {
                        int measuredWidth2 = this.mTitleTextView.getMeasuredWidth() + max;
                        int measuredHeight2 = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                        this.mTitleTextView.layout(max, paddingTop, measuredWidth2, measuredHeight2);
                        i17 = measuredWidth2 + this.mTitleMarginEnd;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mTitleTextView.getLayoutParams())).bottomMargin;
                    } else {
                        i17 = max;
                    }
                    if (shouldLayout2) {
                        LayoutParams layoutParams6 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                        int i35 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin;
                        int measuredWidth3 = this.mSubtitleTextView.getMeasuredWidth() + max;
                        this.mSubtitleTextView.layout(max, i35, measuredWidth3, this.mSubtitleTextView.getMeasuredHeight() + i35);
                        i18 = measuredWidth3 + this.mTitleMarginEnd;
                        int i36 = ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin;
                    } else {
                        i18 = max;
                    }
                    if (z3) {
                        max = Math.max(i17, i18);
                    }
                    addCustomViewsWithGravity(this.mTempViews, 3);
                    size = this.mTempViews.size();
                    for (i21 = 0; i21 < size; i21++) {
                        max = layoutChildLeft(this.mTempViews.get(i21), max, iArr, i14);
                    }
                    int i37 = i14;
                    addCustomViewsWithGravity(this.mTempViews, 5);
                    size2 = this.mTempViews.size();
                    for (i22 = 0; i22 < size2; i22++) {
                        min2 = layoutChildRight(this.mTempViews.get(i22), min2, iArr, i37);
                    }
                    addCustomViewsWithGravity(this.mTempViews, 1);
                    int viewListMeasuredWidth = getViewListMeasuredWidth(this.mTempViews, iArr);
                    i23 = (i12 + (((i10 - i12) - i8) / 2)) - (viewListMeasuredWidth / 2);
                    int i38 = viewListMeasuredWidth + i23;
                    if (i23 >= max) {
                        max = i38 > min2 ? i23 - (i38 - min2) : i23;
                    }
                    size3 = this.mTempViews.size();
                    while (i15 < size3) {
                        max = layoutChildLeft(this.mTempViews.get(i15), max, iArr, i37);
                        i15++;
                    }
                    this.mTempViews.clear();
                    return;
                }
            } else {
                i12 = paddingLeft;
                i14 = min;
            }
            i15 = 0;
            addCustomViewsWithGravity(this.mTempViews, 3);
            size = this.mTempViews.size();
            while (i21 < size) {
            }
            int i372 = i14;
            addCustomViewsWithGravity(this.mTempViews, 5);
            size2 = this.mTempViews.size();
            while (i22 < size2) {
            }
            addCustomViewsWithGravity(this.mTempViews, 1);
            int viewListMeasuredWidth2 = getViewListMeasuredWidth(this.mTempViews, iArr);
            i23 = (i12 + (((i10 - i12) - i8) / 2)) - (viewListMeasuredWidth2 / 2);
            int i382 = viewListMeasuredWidth2 + i23;
            if (i23 >= max) {
            }
            size3 = this.mTempViews.size();
            while (i15 < size3) {
            }
            this.mTempViews.clear();
            return;
        } else {
            i6 = layoutChildLeft(this.mNavButtonView, paddingLeft, iArr, min);
        }
        i7 = i24;
        if (shouldLayout(this.mCollapseButtonView)) {
        }
        if (shouldLayout(this.mMenuView)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i6);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i24 - i7));
        int max2 = Math.max(i6, currentContentInsetLeft2);
        int min22 = Math.min(i7, i24 - currentContentInsetRight2);
        if (shouldLayout(this.mExpandedActionView)) {
        }
        if (shouldLayout(this.mLogoView)) {
        }
        shouldLayout = shouldLayout(this.mTitleTextView);
        shouldLayout2 = shouldLayout(this.mSubtitleTextView);
        if (shouldLayout) {
        }
        if (shouldLayout2) {
        }
        if (shouldLayout) {
        }
        if (!shouldLayout) {
        }
        if (!shouldLayout2) {
        }
        LayoutParams layoutParams32 = (LayoutParams) textView.getLayoutParams();
        LayoutParams layoutParams42 = (LayoutParams) textView2.getLayoutParams();
        if (shouldLayout) {
        }
        i11 = this.mGravity & 112;
        i12 = paddingLeft;
        if (i11 != 48) {
        }
        if (!z2) {
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048627, this, i2, i3) == null) {
            int[] iArr = this.mTempMargins;
            if (ViewUtils.isLayoutRtl(this)) {
                c2 = 1;
                c3 = 0;
            } else {
                c2 = 0;
                c3 = 1;
            }
            if (shouldLayout(this.mNavButtonView)) {
                measureChildConstrained(this.mNavButtonView, i2, 0, i3, 0, this.mMaxButtonHeight);
                i4 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
                i5 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
                i6 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
            } else {
                i4 = 0;
                i5 = 0;
                i6 = 0;
            }
            if (shouldLayout(this.mCollapseButtonView)) {
                measureChildConstrained(this.mCollapseButtonView, i2, 0, i3, 0, this.mMaxButtonHeight);
                i4 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
                i5 = Math.max(i5, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
                i6 = View.combineMeasuredStates(i6, this.mCollapseButtonView.getMeasuredState());
            }
            int currentContentInsetStart = getCurrentContentInsetStart();
            int max = 0 + Math.max(currentContentInsetStart, i4);
            iArr[c2] = Math.max(0, currentContentInsetStart - i4);
            if (shouldLayout(this.mMenuView)) {
                measureChildConstrained(this.mMenuView, i2, max, i3, 0, this.mMaxButtonHeight);
                i7 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
                i5 = Math.max(i5, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
                i6 = View.combineMeasuredStates(i6, this.mMenuView.getMeasuredState());
            } else {
                i7 = 0;
            }
            int currentContentInsetEnd = getCurrentContentInsetEnd();
            int max2 = max + Math.max(currentContentInsetEnd, i7);
            iArr[c3] = Math.max(0, currentContentInsetEnd - i7);
            if (shouldLayout(this.mExpandedActionView)) {
                max2 += measureChildCollapseMargins(this.mExpandedActionView, i2, max2, i3, 0, iArr);
                i5 = Math.max(i5, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
                i6 = View.combineMeasuredStates(i6, this.mExpandedActionView.getMeasuredState());
            }
            if (shouldLayout(this.mLogoView)) {
                max2 += measureChildCollapseMargins(this.mLogoView, i2, max2, i3, 0, iArr);
                i5 = Math.max(i5, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
                i6 = View.combineMeasuredStates(i6, this.mLogoView.getMeasuredState());
            }
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (((LayoutParams) childAt.getLayoutParams()).mViewType == 0 && shouldLayout(childAt)) {
                    max2 += measureChildCollapseMargins(childAt, i2, max2, i3, 0, iArr);
                    i5 = Math.max(i5, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                    i6 = View.combineMeasuredStates(i6, childAt.getMeasuredState());
                }
            }
            int i12 = this.mTitleMarginTop + this.mTitleMarginBottom;
            int i13 = this.mTitleMarginStart + this.mTitleMarginEnd;
            if (shouldLayout(this.mTitleTextView)) {
                measureChildCollapseMargins(this.mTitleTextView, i2, max2 + i13, i3, i12, iArr);
                int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
                i10 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
                i8 = View.combineMeasuredStates(i6, this.mTitleTextView.getMeasuredState());
                i9 = measuredWidth;
            } else {
                i8 = i6;
                i9 = 0;
                i10 = 0;
            }
            if (shouldLayout(this.mSubtitleTextView)) {
                i9 = Math.max(i9, measureChildCollapseMargins(this.mSubtitleTextView, i2, max2 + i13, i3, i10 + i12, iArr));
                i10 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
                i8 = View.combineMeasuredStates(i8, this.mSubtitleTextView.getMeasuredState());
            }
            int max3 = Math.max(i5, i10);
            setMeasuredDimension(View.resolveSizeAndState(Math.max(max2 + i9 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, (-16777216) & i8), shouldCollapse() ? 0 : View.resolveSizeAndState(Math.max(max3 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, i8 << 16));
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            ActionMenuView actionMenuView = this.mMenuView;
            MenuBuilder peekMenu = actionMenuView != null ? actionMenuView.peekMenu() : null;
            int i2 = savedState.expandedMenuItemId;
            if (i2 != 0 && this.mExpandedMenuPresenter != null && peekMenu != null && (findItem = peekMenu.findItem(i2)) != null) {
                findItem.expandActionView();
            }
            if (savedState.isOverflowOpen) {
                postShowOverflowMenu();
            }
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                super.onRtlPropertiesChanged(i2);
            }
            ensureContentInsets();
            this.mContentInsets.setDirection(i2 == 1);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        MenuItemImpl menuItemImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
            if (expandedActionViewMenuPresenter != null && (menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem) != null) {
                savedState.expandedMenuItemId = menuItemImpl.getItemId();
            }
            savedState.isOverflowOpen = isOverflowMenuShowing();
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.mEatingTouch = false;
            }
            if (!this.mEatingTouch) {
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                if (actionMasked == 0 && !onTouchEvent) {
                    this.mEatingTouch = true;
                }
            }
            if (actionMasked == 1 || actionMasked == 3) {
                this.mEatingTouch = false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void removeChildrenForExpandedActionView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (((LayoutParams) childAt.getLayoutParams()).mViewType != 2 && childAt != this.mMenuView) {
                    removeViewAt(childCount);
                    this.mHiddenViews.add(childAt);
                }
            }
        }
    }

    public void setCollapseContentDescription(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
        }
    }

    public void setCollapseIcon(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i2) == null) {
            setCollapseIcon(AppCompatResources.getDrawable(getContext(), i2));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.mCollapsible = z;
            requestLayout();
        }
    }

    public void setContentInsetEndWithActions(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            if (i2 < 0) {
                i2 = Integer.MIN_VALUE;
            }
            if (i2 != this.mContentInsetEndWithActions) {
                this.mContentInsetEndWithActions = i2;
                if (getNavigationIcon() != null) {
                    requestLayout();
                }
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i2) == null) {
            if (i2 < 0) {
                i2 = Integer.MIN_VALUE;
            }
            if (i2 != this.mContentInsetStartWithNavigation) {
                this.mContentInsetStartWithNavigation = i2;
                if (getNavigationIcon() != null) {
                    requestLayout();
                }
            }
        }
    }

    public void setContentInsetsAbsolute(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048640, this, i2, i3) == null) {
            ensureContentInsets();
            this.mContentInsets.setAbsolute(i2, i3);
        }
    }

    public void setContentInsetsRelative(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048641, this, i2, i3) == null) {
            ensureContentInsets();
            this.mContentInsets.setRelative(i2, i3);
        }
    }

    public void setLogo(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            setLogo(AppCompatResources.getDrawable(getContext(), i2));
        }
    }

    public void setLogoDescription(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            setLogoDescription(getContext().getText(i2));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenu(MenuBuilder menuBuilder, ActionMenuPresenter actionMenuPresenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048646, this, menuBuilder, actionMenuPresenter) == null) {
            if (menuBuilder == null && this.mMenuView == null) {
                return;
            }
            ensureMenuView();
            MenuBuilder peekMenu = this.mMenuView.peekMenu();
            if (peekMenu == menuBuilder) {
                return;
            }
            if (peekMenu != null) {
                peekMenu.removeMenuPresenter(this.mOuterActionMenuPresenter);
                peekMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
            }
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
            }
            actionMenuPresenter.setExpandedActionViewsExclusive(true);
            if (menuBuilder != null) {
                menuBuilder.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
                menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
            } else {
                actionMenuPresenter.initForMenu(this.mPopupContext, null);
                this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
                actionMenuPresenter.updateMenuView(true);
                this.mExpandedMenuPresenter.updateMenuView(true);
            }
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setPresenter(actionMenuPresenter);
            this.mOuterActionMenuPresenter = actionMenuPresenter;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048647, this, callback, callback2) == null) {
            this.mActionMenuPresenterCallback = callback;
            this.mMenuBuilderCallback = callback2;
            ActionMenuView actionMenuView = this.mMenuView;
            if (actionMenuView != null) {
                actionMenuView.setMenuCallbacks(callback, callback2);
            }
        }
    }

    public void setNavigationContentDescription(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i2) == null) {
            setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
        }
    }

    public void setNavigationIcon(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            setNavigationIcon(AppCompatResources.getDrawable(getContext(), i2));
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, onClickListener) == null) {
            ensureNavButtonView();
            this.mNavButtonView.setOnClickListener(onClickListener);
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, onMenuItemClickListener) == null) {
            this.mOnMenuItemClickListener = onMenuItemClickListener;
        }
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, drawable) == null) {
            ensureMenu();
            this.mMenuView.setOverflowIcon(drawable);
        }
    }

    public void setPopupTheme(@StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048655, this, i2) == null) || this.mPopupTheme == i2) {
            return;
        }
        this.mPopupTheme = i2;
        if (i2 == 0) {
            this.mPopupContext = getContext();
        } else {
            this.mPopupContext = new ContextThemeWrapper(getContext(), i2);
        }
    }

    public void setSubtitle(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i2) == null) {
            setSubtitle(getContext().getText(i2));
        }
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048658, this, context, i2) == null) {
            this.mSubtitleTextAppearance = i2;
            TextView textView = this.mSubtitleTextView;
            if (textView != null) {
                textView.setTextAppearance(context, i2);
            }
        }
    }

    public void setSubtitleTextColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i2) == null) {
            setSubtitleTextColor(ColorStateList.valueOf(i2));
        }
    }

    public void setTitle(@StringRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i2) == null) {
            setTitle(getContext().getText(i2));
        }
    }

    public void setTitleMargin(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048663, this, i2, i3, i4, i5) == null) {
            this.mTitleMarginStart = i2;
            this.mTitleMarginTop = i3;
            this.mTitleMarginEnd = i4;
            this.mTitleMarginBottom = i5;
            requestLayout();
        }
    }

    public void setTitleMarginBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i2) == null) {
            this.mTitleMarginBottom = i2;
            requestLayout();
        }
    }

    public void setTitleMarginEnd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i2) == null) {
            this.mTitleMarginEnd = i2;
            requestLayout();
        }
    }

    public void setTitleMarginStart(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i2) == null) {
            this.mTitleMarginStart = i2;
            requestLayout();
        }
    }

    public void setTitleMarginTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048667, this, i2) == null) {
            this.mTitleMarginTop = i2;
            requestLayout();
        }
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048668, this, context, i2) == null) {
            this.mTitleTextAppearance = i2;
            TextView textView = this.mTitleTextView;
            if (textView != null) {
                textView.setTextAppearance(context, i2);
            }
        }
    }

    public void setTitleTextColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i2) == null) {
            setTitleTextColor(ColorStateList.valueOf(i2));
        }
    }

    public boolean showOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            ActionMenuView actionMenuView = this.mMenuView;
            return actionMenuView != null && actionMenuView.showOverflowMenu();
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ActionBar.LayoutParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CUSTOM = 0;
        public static final int EXPANDED = 2;
        public static final int SYSTEM = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public int mViewType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
        }

        public void copyMarginsFromCompat(ViewGroup.MarginLayoutParams marginLayoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, marginLayoutParams) == null) {
                ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
                ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
                ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
                ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
            this.gravity = i4;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2) {
            this(-2, -1, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(LayoutParams layoutParams) {
            super((ActionBar.LayoutParams) layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65543, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ActionBar.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65543, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
            this.mViewType = layoutParams.mViewType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ActionBar.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.BAIDU_LOGO_ID, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(AdIconUtil.AD_TEXT_ID, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(AdIconUtil.AD_TEXT_ID, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
            copyMarginsFromCompat(marginLayoutParams);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65540, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65540, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new LayoutParams(-2, -2) : (LayoutParams) invokeV.objValue;
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, charSequence) == null) {
            if (!TextUtils.isEmpty(charSequence)) {
                ensureCollapseButtonView();
            }
            ImageButton imageButton = this.mCollapseButtonView;
            if (imageButton != null) {
                imageButton.setContentDescription(charSequence);
            }
        }
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, drawable) == null) {
            if (drawable != null) {
                ensureCollapseButtonView();
                this.mCollapseButtonView.setImageDrawable(drawable);
                return;
            }
            ImageButton imageButton = this.mCollapseButtonView;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.mCollapseIcon);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, drawable) == null) {
            if (drawable != null) {
                ensureLogoView();
                if (!isChildOrHidden(this.mLogoView)) {
                    addSystemView(this.mLogoView, true);
                }
            } else {
                ImageView imageView = this.mLogoView;
                if (imageView != null && isChildOrHidden(imageView)) {
                    removeView(this.mLogoView);
                    this.mHiddenViews.remove(this.mLogoView);
                }
            }
            ImageView imageView2 = this.mLogoView;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable);
            }
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, charSequence) == null) {
            if (!TextUtils.isEmpty(charSequence)) {
                ensureLogoView();
            }
            ImageView imageView = this.mLogoView;
            if (imageView != null) {
                imageView.setContentDescription(charSequence);
            }
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, charSequence) == null) {
            if (!TextUtils.isEmpty(charSequence)) {
                ensureNavButtonView();
            }
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null) {
                imageButton.setContentDescription(charSequence);
            }
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, drawable) == null) {
            if (drawable != null) {
                ensureNavButtonView();
                if (!isChildOrHidden(this.mNavButtonView)) {
                    addSystemView(this.mNavButtonView, true);
                }
            } else {
                ImageButton imageButton = this.mNavButtonView;
                if (imageButton != null && isChildOrHidden(imageButton)) {
                    removeView(this.mNavButtonView);
                    this.mHiddenViews.remove(this.mNavButtonView);
                }
            }
            ImageButton imageButton2 = this.mNavButtonView;
            if (imageButton2 != null) {
                imageButton2.setImageDrawable(drawable);
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, charSequence) == null) {
            if (!TextUtils.isEmpty(charSequence)) {
                if (this.mSubtitleTextView == null) {
                    Context context = getContext();
                    AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                    this.mSubtitleTextView = appCompatTextView;
                    appCompatTextView.setSingleLine();
                    this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                    int i2 = this.mSubtitleTextAppearance;
                    if (i2 != 0) {
                        this.mSubtitleTextView.setTextAppearance(context, i2);
                    }
                    ColorStateList colorStateList = this.mSubtitleTextColor;
                    if (colorStateList != null) {
                        this.mSubtitleTextView.setTextColor(colorStateList);
                    }
                }
                if (!isChildOrHidden(this.mSubtitleTextView)) {
                    addSystemView(this.mSubtitleTextView, true);
                }
            } else {
                TextView textView = this.mSubtitleTextView;
                if (textView != null && isChildOrHidden(textView)) {
                    removeView(this.mSubtitleTextView);
                    this.mHiddenViews.remove(this.mSubtitleTextView);
                }
            }
            TextView textView2 = this.mSubtitleTextView;
            if (textView2 != null) {
                textView2.setText(charSequence);
            }
            this.mSubtitleText = charSequence;
        }
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, colorStateList) == null) {
            this.mSubtitleTextColor = colorStateList;
            TextView textView = this.mSubtitleTextView;
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, charSequence) == null) {
            if (!TextUtils.isEmpty(charSequence)) {
                if (this.mTitleTextView == null) {
                    Context context = getContext();
                    AppCompatTextView appCompatTextView = new AppCompatTextView(context);
                    this.mTitleTextView = appCompatTextView;
                    appCompatTextView.setSingleLine();
                    this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                    int i2 = this.mTitleTextAppearance;
                    if (i2 != 0) {
                        this.mTitleTextView.setTextAppearance(context, i2);
                    }
                    ColorStateList colorStateList = this.mTitleTextColor;
                    if (colorStateList != null) {
                        this.mTitleTextView.setTextColor(colorStateList);
                    }
                }
                if (!isChildOrHidden(this.mTitleTextView)) {
                    addSystemView(this.mTitleTextView, true);
                }
            } else {
                TextView textView = this.mTitleTextView;
                if (textView != null && isChildOrHidden(textView)) {
                    removeView(this.mTitleTextView);
                    this.mHiddenViews.remove(this.mTitleTextView);
                }
            }
            TextView textView2 = this.mTitleTextView;
            if (textView2 != null) {
                textView2.setText(charSequence);
            }
            this.mTitleText = charSequence;
        }
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, colorStateList) == null) {
            this.mTitleTextColor = colorStateList;
            TextView textView = this.mTitleTextView;
            if (textView != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ActionMenuView.OnMenuItemClickListener(this) { // from class: androidx.appcompat.widget.Toolbar.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Toolbar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // androidx.appcompat.widget.ActionMenuView.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, menuItem)) == null) {
                    OnMenuItemClickListener onMenuItemClickListener = this.this$0.mOnMenuItemClickListener;
                    if (onMenuItemClickListener != null) {
                        return onMenuItemClickListener.onMenuItemClick(menuItem);
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable(this) { // from class: androidx.appcompat.widget.Toolbar.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Toolbar this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.showOverflowMenu();
                }
            }
        };
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, R.styleable.Toolbar, i2, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.Toolbar, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i2, 0);
        this.mTitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = obtainStyledAttributes.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = obtainStyledAttributes.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        dimensionPixelOffset = obtainStyledAttributes.hasValue(R.styleable.Toolbar_titleMargins) ? obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, dimensionPixelOffset) : dimensionPixelOffset;
        this.mTitleMarginBottom = dimensionPixelOffset;
        this.mTitleMarginTop = dimensionPixelOffset;
        this.mTitleMarginEnd = dimensionPixelOffset;
        this.mTitleMarginStart = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.mTitleMarginStart = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.mTitleMarginEnd = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.mTitleMarginTop = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.mTitleMarginBottom = dimensionPixelOffset5;
        }
        this.mMaxButtonHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(dimensionPixelSize, dimensionPixelSize2);
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            this.mContentInsets.setRelative(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.mContentInsetStartWithNavigation = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = obtainStyledAttributes.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = obtainStyledAttributes.getText(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = obtainStyledAttributes.getText(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = obtainStyledAttributes.getText(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(obtainStyledAttributes.getColorStateList(R.styleable.Toolbar_titleTextColor));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(obtainStyledAttributes.getColorStateList(R.styleable.Toolbar_subtitleTextColor));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.Toolbar_menu)) {
            inflateMenu(obtainStyledAttributes.getResourceId(R.styleable.Toolbar_menu, 0));
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, layoutParams)) == null) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ActionBar.LayoutParams) {
                return new LayoutParams((ActionBar.LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }
        return (LayoutParams) invokeL.objValue;
    }
}

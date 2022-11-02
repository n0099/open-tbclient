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
import com.baidu.tieba.R;
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
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public class ExpandedActionViewMenuPresenter implements MenuPresenter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MenuItemImpl mCurrentExpandedItem;
        public MenuBuilder mMenu;
        public final /* synthetic */ Toolbar this$0;

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

        public ExpandedActionViewMenuPresenter(Toolbar toolbar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {toolbar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                View view2 = this.this$0.mExpandedActionView;
                if (view2 instanceof CollapsibleActionView) {
                    ((CollapsibleActionView) view2).onActionViewCollapsed();
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
                View view2 = this.this$0.mExpandedActionView;
                if (view2 instanceof CollapsibleActionView) {
                    ((CollapsibleActionView) view2).onActionViewExpanded();
                }
                return true;
            }
            return invokeLL.booleanValue;
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
        public void updateMenuView(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && this.mCurrentExpandedItem != null) {
                MenuBuilder menuBuilder = this.mMenu;
                boolean z2 = false;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ActionBar.LayoutParams {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CUSTOM = 0;
        public static final int EXPANDED = 2;
        public static final int SYSTEM = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public int mViewType;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i) {
            this(-2, -1, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
            this.gravity = i3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
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
                interceptable.invokeUnInit(65541, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65541, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
            copyMarginsFromCompat(marginLayoutParams);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65542, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ActionBar.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65542, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ActionBar.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65543, newInitContext);
                    return;
                }
            }
            this.mViewType = 0;
            this.mViewType = layoutParams.mViewType;
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new SavedState(parcel, null);
                    }
                    return (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048580, this, i)) == null) {
                        return new SavedState[i];
                    }
                    return (SavedState[]) invokeI.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) {
                        return new SavedState(parcel, classLoader);
                    }
                    return (SavedState) invokeLL.objValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.expandedMenuItemId = parcel.readInt();
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.isOverflowOpen = z;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.expandedMenuItemId);
                parcel.writeInt(this.isOverflowOpen ? 1 : 0);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuBuilder menuBuilder;
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
            if (actionMenuView != null) {
                menuBuilder = actionMenuView.peekMenu();
            } else {
                menuBuilder = null;
            }
            int i = savedState.expandedMenuItemId;
            if (i != 0 && this.mExpandedMenuPresenter != null && menuBuilder != null && (findItem = menuBuilder.findItem(i)) != null) {
                findItem.expandActionView();
            }
            if (savedState.isOverflowOpen) {
                postShowOverflowMenu();
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040727);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, list, iArr)) == null) {
            int i = iArr[0];
            int i2 = iArr[1];
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                View view2 = list.get(i3);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i;
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i2;
                int max = Math.max(0, i5);
                int max2 = Math.max(0, i6);
                int max3 = Math.max(0, -i5);
                int max4 = Math.max(0, -i6);
                i4 += max + view2.getMeasuredWidth() + max2;
                i3++;
                i2 = max4;
                i = max3;
            }
            return i4;
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, androidx.appcompat.R.styleable.Toolbar, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, androidx.appcompat.R.styleable.Toolbar, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        this.mTitleTextAppearance = obtainStyledAttributes.getResourceId(28, 0);
        this.mSubtitleTextAppearance = obtainStyledAttributes.getResourceId(19, 0);
        this.mGravity = obtainStyledAttributes.getInteger(0, this.mGravity);
        this.mButtonGravity = obtainStyledAttributes.getInteger(2, 48);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = obtainStyledAttributes.hasValue(27) ? obtainStyledAttributes.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.mTitleMarginBottom = dimensionPixelOffset;
        this.mTitleMarginTop = dimensionPixelOffset;
        this.mTitleMarginEnd = dimensionPixelOffset;
        this.mTitleMarginStart = dimensionPixelOffset;
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.mTitleMarginStart = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.mTitleMarginEnd = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.mTitleMarginTop = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.mTitleMarginBottom = dimensionPixelOffset5;
        }
        this.mMaxButtonHeight = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = obtainStyledAttributes.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = obtainStyledAttributes.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(dimensionPixelSize, dimensionPixelSize2);
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            this.mContentInsets.setRelative(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.mContentInsetStartWithNavigation = obtainStyledAttributes.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = obtainStyledAttributes.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.mCollapseIcon = obtainStyledAttributes.getDrawable(4);
        this.mCollapseDescription = obtainStyledAttributes.getText(3);
        CharSequence text = obtainStyledAttributes.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = obtainStyledAttributes.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(obtainStyledAttributes.getResourceId(17, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(16);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = obtainStyledAttributes.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(11);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = obtainStyledAttributes.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (obtainStyledAttributes.hasValue(29)) {
            setTitleTextColor(obtainStyledAttributes.getColorStateList(29));
        }
        if (obtainStyledAttributes.hasValue(20)) {
            setSubtitleTextColor(obtainStyledAttributes.getColorStateList(20));
        }
        if (obtainStyledAttributes.hasValue(14)) {
            inflateMenu(obtainStyledAttributes.getResourceId(14, 0));
        }
        obtainStyledAttributes.recycle();
    }

    private void addCustomViewsWithGravity(List<View> list, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, list, i) == null) {
            if (ViewCompat.getLayoutDirection(this) == 1) {
                z = true;
            } else {
                z = false;
            }
            int childCount = getChildCount();
            int absoluteGravity = GravityCompat.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this));
            list.clear();
            if (z) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    View childAt = getChildAt(i2);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == absoluteGravity) {
                        list.add(childAt);
                    }
                }
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams2.mViewType == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams2.gravity) == absoluteGravity) {
                    list.add(childAt2);
                }
            }
        }
    }

    private int getChildTop(View view2, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, this, view2, i)) == null) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            int measuredHeight = view2.getMeasuredHeight();
            if (i > 0) {
                i2 = (measuredHeight - i) / 2;
            } else {
                i2 = 0;
            }
            int childVerticalGravity = getChildVerticalGravity(layoutParams.gravity);
            if (childVerticalGravity != 48) {
                if (childVerticalGravity != 80) {
                    int paddingTop = getPaddingTop();
                    int paddingBottom = getPaddingBottom();
                    int height = getHeight();
                    int i3 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                    int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    if (i3 < i4) {
                        i3 = i4;
                    } else {
                        int i5 = (((height - paddingBottom) - measuredHeight) - i3) - paddingTop;
                        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        if (i5 < i6) {
                            i3 = Math.max(0, i3 - (i6 - i5));
                        }
                    }
                    return paddingTop + i3;
                }
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i2;
            }
            return getPaddingTop() - i2;
        }
        return invokeLI.intValue;
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

    private void addSystemView(View view2, boolean z) {
        LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, view2, z) == null) {
            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = generateDefaultLayoutParams();
            } else if (!checkLayoutParams(layoutParams2)) {
                layoutParams = generateLayoutParams(layoutParams2);
            } else {
                layoutParams = (LayoutParams) layoutParams2;
            }
            layoutParams.mViewType = 1;
            if (z && this.mExpandedActionView != null) {
                view2.setLayoutParams(layoutParams);
                this.mHiddenViews.add(view2);
                return;
            }
            addView(view2, layoutParams);
        }
    }

    private void ensureContentInsets() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.mContentInsets == null) {
            this.mContentInsets = new RtlSpacingHelper();
        }
    }

    private void ensureLogoView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    private MenuInflater getMenuInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            return new SupportMenuInflater(getContext());
        }
        return (MenuInflater) invokeV.objValue;
    }

    private void postShowOverflowMenu() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            removeCallbacks(this.mShowOverflowMenuRunnable);
            post(this.mShowOverflowMenuRunnable);
        }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getVisibility() == 0 && (actionMenuView = this.mMenuView) != null && actionMenuView.isOverflowReserved()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void collapseActionView() {
        MenuItemImpl menuItemImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
            if (expandedActionViewMenuPresenter == null) {
                menuItemImpl = null;
            } else {
                menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem;
            }
            if (menuItemImpl != null) {
                menuItemImpl.collapseActionView();
            }
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (actionMenuView = this.mMenuView) != null) {
            actionMenuView.dismissPopupMenus();
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
            int i = this.mContentInsetEndWithActions;
            if (i == Integer.MIN_VALUE) {
                return getContentInsetEnd();
            }
            return i;
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
            int i = this.mContentInsetStartWithNavigation;
            if (i == Integer.MIN_VALUE) {
                return getContentInsetStart();
            }
            return i;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mOuterActionMenuPresenter;
        }
        return (ActionMenuPresenter) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mPopupContext;
        }
        return (Context) invokeV.objValue;
    }

    public int getPopupTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mPopupTheme;
        }
        return invokeV.intValue;
    }

    public CharSequence getSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.mSubtitleText;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getSubtitleTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mSubtitleTextView;
        }
        return (TextView) invokeV.objValue;
    }

    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mTitleText;
        }
        return (CharSequence) invokeV.objValue;
    }

    public int getTitleMarginBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mTitleMarginBottom;
        }
        return invokeV.intValue;
    }

    public int getTitleMarginEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mTitleMarginEnd;
        }
        return invokeV.intValue;
    }

    public int getTitleMarginStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.mTitleMarginStart;
        }
        return invokeV.intValue;
    }

    public int getTitleMarginTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.mTitleMarginTop;
        }
        return invokeV.intValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getTitleTextView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mTitleTextView;
        }
        return (TextView) invokeV.objValue;
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
            if (expandedActionViewMenuPresenter != null && expandedActionViewMenuPresenter.mCurrentExpandedItem != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean hideOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ActionMenuView actionMenuView = this.mMenuView;
            if (actionMenuView != null && actionMenuView.hideOverflowMenu()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            ActionMenuView actionMenuView = this.mMenuView;
            if (actionMenuView != null && actionMenuView.isOverflowMenuShowPending()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isOverflowMenuShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            ActionMenuView actionMenuView = this.mMenuView;
            if (actionMenuView != null && actionMenuView.isOverflowMenuShowing()) {
                return true;
            }
            return false;
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
            for (int i = 0; i < lineCount; i++) {
                if (layout.getEllipsisCount(i) > 0) {
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

    public boolean showOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            ActionMenuView actionMenuView = this.mMenuView;
            if (actionMenuView != null && actionMenuView.showOverflowMenu()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
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

    private void ensureNavButtonView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.obfuscated_res_0x7f040726);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    private boolean shouldCollapse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            if (!this.mCollapsible) {
                return false;
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int getCurrentContentInsetEnd() {
        InterceptResult invokeV;
        boolean z;
        MenuBuilder peekMenu;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ActionMenuView actionMenuView = this.mMenuView;
            if (actionMenuView != null && (peekMenu = actionMenuView.peekMenu()) != null && peekMenu.hasVisibleItems()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
            }
            return getContentInsetEnd();
        }
        return invokeV.intValue;
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

    public void ensureCollapseButtonView() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.mCollapseButtonView == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R.attr.obfuscated_res_0x7f040726);
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.collapseActionView();
                    }
                }
            });
        }
    }

    private int getChildHorizontalGravity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i)) == null) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            int absoluteGravity = GravityCompat.getAbsoluteGravity(i, layoutDirection) & 7;
            if (absoluteGravity != 1 && absoluteGravity != 3 && absoluteGravity != 5) {
                if (layoutDirection != 1) {
                    return 3;
                }
                return 5;
            }
            return absoluteGravity;
        }
        return invokeI.intValue;
    }

    private int getChildVerticalGravity(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, this, i)) == null) {
            int i2 = i & 112;
            if (i2 != 16 && i2 != 48 && i2 != 80) {
                return this.mGravity & 112;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    private int getHorizontalMargins(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, view2)) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            return MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams);
        }
        return invokeL.intValue;
    }

    private int getVerticalMargins(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, view2)) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        return invokeL.intValue;
    }

    private boolean isChildOrHidden(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, view2)) == null) {
            if (view2.getParent() != this && !this.mHiddenViews.contains(view2)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean shouldLayout(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, this, view2)) == null) {
            if (view2 != null && view2.getParent() == this && view2.getVisibility() != 8) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) {
            if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void inflateMenu(@MenuRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            getMenuInflater().inflate(i, getMenu());
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                super.onRtlPropertiesChanged(i);
            }
            ensureContentInsets();
            RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            rtlSpacingHelper.setDirection(z);
        }
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

    public void setCollapseContentDescription(@StringRes int i) {
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
            if (i != 0) {
                charSequence = getContext().getText(i);
            } else {
                charSequence = null;
            }
            setCollapseContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048635, this, i) == null) {
            setCollapseIcon(AppCompatResources.getDrawable(getContext(), i));
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

    public void setContentInsetEndWithActions(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            if (i < 0) {
                i = Integer.MIN_VALUE;
            }
            if (i != this.mContentInsetEndWithActions) {
                this.mContentInsetEndWithActions = i;
                if (getNavigationIcon() != null) {
                    requestLayout();
                }
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            if (i < 0) {
                i = Integer.MIN_VALUE;
            }
            if (i != this.mContentInsetStartWithNavigation) {
                this.mContentInsetStartWithNavigation = i;
                if (getNavigationIcon() != null) {
                    requestLayout();
                }
            }
        }
    }

    public void setLogo(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i) == null) {
            setLogo(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    public void setLogoDescription(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            setLogoDescription(getContext().getText(i));
        }
    }

    public void setNavigationContentDescription(@StringRes int i) {
        CharSequence charSequence;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i) == null) {
            if (i != 0) {
                charSequence = getContext().getText(i);
            } else {
                charSequence = null;
            }
            setNavigationContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(@DrawableRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i) == null) {
            setNavigationIcon(AppCompatResources.getDrawable(getContext(), i));
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

    public void setPopupTheme(@StyleRes int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048655, this, i) == null) && this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i) == null) {
            setSubtitle(getContext().getText(i));
        }
    }

    public void setSubtitleTextColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i) == null) {
            setSubtitleTextColor(ColorStateList.valueOf(i));
        }
    }

    public void setTitle(@StringRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i) == null) {
            setTitle(getContext().getText(i));
        }
    }

    public void setTitleMarginBottom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i) == null) {
            this.mTitleMarginBottom = i;
            requestLayout();
        }
    }

    public void setTitleMarginEnd(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048665, this, i) == null) {
            this.mTitleMarginEnd = i;
            requestLayout();
        }
    }

    public void setTitleMarginStart(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i) == null) {
            this.mTitleMarginStart = i;
            requestLayout();
        }
    }

    public void setTitleMarginTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048667, this, i) == null) {
            this.mTitleMarginTop = i;
            requestLayout();
        }
    }

    public void setTitleTextColor(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i) == null) {
            setTitleTextColor(ColorStateList.valueOf(i));
        }
    }

    private int layoutChildLeft(View view2, int i, int[] iArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, this, new Object[]{view2, Integer.valueOf(i), iArr, Integer.valueOf(i2)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
            int max = i + Math.max(0, i3);
            iArr[0] = Math.max(0, -i3);
            int childTop = getChildTop(view2, i2);
            int measuredWidth = view2.getMeasuredWidth();
            view2.layout(max, childTop, max + measuredWidth, view2.getMeasuredHeight() + childTop);
            return max + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }
        return invokeCommon.intValue;
    }

    private int layoutChildRight(View view2, int i, int[] iArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65555, this, new Object[]{view2, Integer.valueOf(i), iArr, Integer.valueOf(i2)})) == null) {
            LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
            int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
            int max = i - Math.max(0, i3);
            iArr[1] = Math.max(0, -i3);
            int childTop = getChildTop(view2, i2);
            int measuredWidth = view2.getMeasuredWidth();
            view2.layout(max - measuredWidth, childTop, max, view2.getMeasuredHeight() + childTop);
            return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
        }
        return invokeCommon.intValue;
    }

    private int measureChildCollapseMargins(View view2, int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65556, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i5 = marginLayoutParams.leftMargin - iArr[0];
            int i6 = marginLayoutParams.rightMargin - iArr[1];
            int max = Math.max(0, i5) + Math.max(0, i6);
            iArr[0] = Math.max(0, -i5);
            iArr[1] = Math.max(0, -i6);
            view2.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
            return view2.getMeasuredWidth() + max;
        }
        return invokeCommon.intValue;
    }

    private void measureChildConstrained(View view2, int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
            int mode = View.MeasureSpec.getMode(childMeasureSpec2);
            if (mode != 1073741824 && i5 >= 0) {
                if (mode != 0) {
                    i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
                }
                childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            }
            view2.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new LayoutParams(-2, -2);
        }
        return (LayoutParams) invokeV.objValue;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (LayoutParams) invokeL.objValue;
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
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        int i6;
        int i7;
        boolean shouldLayout;
        boolean shouldLayout2;
        int i8;
        int i9;
        int i10;
        TextView textView;
        TextView textView2;
        boolean z3;
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
        int i21;
        int size;
        int i22;
        int size2;
        int i23;
        int i24;
        int size3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (ViewCompat.getLayoutDirection(this) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            int width = getWidth();
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop2 = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int i25 = width - paddingRight;
            int[] iArr = this.mTempMargins;
            iArr[1] = 0;
            iArr[0] = 0;
            int minimumHeight = ViewCompat.getMinimumHeight(this);
            if (minimumHeight >= 0) {
                i5 = Math.min(minimumHeight, i4 - i2);
            } else {
                i5 = 0;
            }
            if (shouldLayout(this.mNavButtonView)) {
                if (z2) {
                    i7 = layoutChildRight(this.mNavButtonView, i25, iArr, i5);
                    i6 = paddingLeft;
                    if (shouldLayout(this.mCollapseButtonView)) {
                        if (z2) {
                            i7 = layoutChildRight(this.mCollapseButtonView, i7, iArr, i5);
                        } else {
                            i6 = layoutChildLeft(this.mCollapseButtonView, i6, iArr, i5);
                        }
                    }
                    if (shouldLayout(this.mMenuView)) {
                        if (z2) {
                            i6 = layoutChildLeft(this.mMenuView, i6, iArr, i5);
                        } else {
                            i7 = layoutChildRight(this.mMenuView, i7, iArr, i5);
                        }
                    }
                    int currentContentInsetLeft = getCurrentContentInsetLeft();
                    int currentContentInsetRight = getCurrentContentInsetRight();
                    iArr[0] = Math.max(0, currentContentInsetLeft - i6);
                    iArr[1] = Math.max(0, currentContentInsetRight - (i25 - i7));
                    int max = Math.max(i6, currentContentInsetLeft);
                    int min = Math.min(i7, i25 - currentContentInsetRight);
                    if (shouldLayout(this.mExpandedActionView)) {
                        if (z2) {
                            min = layoutChildRight(this.mExpandedActionView, min, iArr, i5);
                        } else {
                            max = layoutChildLeft(this.mExpandedActionView, max, iArr, i5);
                        }
                    }
                    if (shouldLayout(this.mLogoView)) {
                        if (z2) {
                            min = layoutChildRight(this.mLogoView, min, iArr, i5);
                        } else {
                            max = layoutChildLeft(this.mLogoView, max, iArr, i5);
                        }
                    }
                    shouldLayout = shouldLayout(this.mTitleTextView);
                    shouldLayout2 = shouldLayout(this.mSubtitleTextView);
                    if (!shouldLayout) {
                        LayoutParams layoutParams = (LayoutParams) this.mTitleTextView.getLayoutParams();
                        i8 = paddingRight;
                        i9 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + this.mTitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + 0;
                    } else {
                        i8 = paddingRight;
                        i9 = 0;
                    }
                    if (!shouldLayout2) {
                        LayoutParams layoutParams2 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                        i10 = width;
                        i9 += ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + this.mSubtitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                    } else {
                        i10 = width;
                    }
                    if (shouldLayout && !shouldLayout2) {
                        i12 = paddingLeft;
                        i14 = i5;
                    } else {
                        if (!shouldLayout) {
                            textView = this.mTitleTextView;
                        } else {
                            textView = this.mSubtitleTextView;
                        }
                        if (!shouldLayout2) {
                            textView2 = this.mSubtitleTextView;
                        } else {
                            textView2 = this.mTitleTextView;
                        }
                        LayoutParams layoutParams3 = (LayoutParams) textView.getLayoutParams();
                        LayoutParams layoutParams4 = (LayoutParams) textView2.getLayoutParams();
                        if ((!shouldLayout && this.mTitleTextView.getMeasuredWidth() > 0) || (shouldLayout2 && this.mSubtitleTextView.getMeasuredWidth() > 0)) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        i11 = this.mGravity & 112;
                        i12 = paddingLeft;
                        if (i11 == 48) {
                            if (i11 != 80) {
                                int i26 = (((height - paddingTop2) - paddingBottom) - i9) / 2;
                                int i27 = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin;
                                i14 = i5;
                                int i28 = this.mTitleMarginTop;
                                i13 = max;
                                if (i26 < i27 + i28) {
                                    i26 = i27 + i28;
                                } else {
                                    int i29 = (((height - paddingBottom) - i9) - i26) - paddingTop2;
                                    int i30 = ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                                    int i31 = this.mTitleMarginBottom;
                                    if (i29 < i30 + i31) {
                                        i26 = Math.max(0, i26 - ((((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin + i31) - i29));
                                    }
                                }
                                paddingTop = paddingTop2 + i26;
                            } else {
                                i13 = max;
                                i14 = i5;
                                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) - this.mTitleMarginBottom) - i9;
                            }
                        } else {
                            i13 = max;
                            i14 = i5;
                            paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + this.mTitleMarginTop;
                        }
                        if (!z2) {
                            if (z3) {
                                i19 = this.mTitleMarginStart;
                            } else {
                                i19 = 0;
                            }
                            int i32 = i19 - iArr[1];
                            min -= Math.max(0, i32);
                            iArr[1] = Math.max(0, -i32);
                            if (shouldLayout) {
                                int measuredWidth = min - this.mTitleTextView.getMeasuredWidth();
                                int measuredHeight = this.mTitleTextView.getMeasuredHeight() + paddingTop;
                                this.mTitleTextView.layout(measuredWidth, paddingTop, min, measuredHeight);
                                i20 = measuredWidth - this.mTitleMarginEnd;
                                paddingTop = measuredHeight + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mTitleTextView.getLayoutParams())).bottomMargin;
                            } else {
                                i20 = min;
                            }
                            if (shouldLayout2) {
                                LayoutParams layoutParams5 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                                int i33 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin;
                                this.mSubtitleTextView.layout(min - this.mSubtitleTextView.getMeasuredWidth(), i33, min, this.mSubtitleTextView.getMeasuredHeight() + i33);
                                i21 = min - this.mTitleMarginEnd;
                                int i34 = ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin;
                            } else {
                                i21 = min;
                            }
                            if (z3) {
                                min = Math.min(i20, i21);
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
                            int i35 = i16 - iArr[i15];
                            max = i13 + Math.max(i15, i35);
                            iArr[i15] = Math.max(i15, -i35);
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
                                int i36 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin;
                                int measuredWidth3 = this.mSubtitleTextView.getMeasuredWidth() + max;
                                this.mSubtitleTextView.layout(max, i36, measuredWidth3, this.mSubtitleTextView.getMeasuredHeight() + i36);
                                i18 = measuredWidth3 + this.mTitleMarginEnd;
                                int i37 = ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin;
                            } else {
                                i18 = max;
                            }
                            if (z3) {
                                max = Math.max(i17, i18);
                            }
                            addCustomViewsWithGravity(this.mTempViews, 3);
                            size = this.mTempViews.size();
                            for (i22 = 0; i22 < size; i22++) {
                                max = layoutChildLeft(this.mTempViews.get(i22), max, iArr, i14);
                            }
                            int i38 = i14;
                            addCustomViewsWithGravity(this.mTempViews, 5);
                            size2 = this.mTempViews.size();
                            for (i23 = 0; i23 < size2; i23++) {
                                min = layoutChildRight(this.mTempViews.get(i23), min, iArr, i38);
                            }
                            addCustomViewsWithGravity(this.mTempViews, 1);
                            int viewListMeasuredWidth = getViewListMeasuredWidth(this.mTempViews, iArr);
                            i24 = (i12 + (((i10 - i12) - i8) / 2)) - (viewListMeasuredWidth / 2);
                            int i39 = viewListMeasuredWidth + i24;
                            if (i24 >= max) {
                                if (i39 > min) {
                                    max = i24 - (i39 - min);
                                } else {
                                    max = i24;
                                }
                            }
                            size3 = this.mTempViews.size();
                            while (i15 < size3) {
                                max = layoutChildLeft(this.mTempViews.get(i15), max, iArr, i38);
                                i15++;
                            }
                            this.mTempViews.clear();
                            return;
                        }
                    }
                    i15 = 0;
                    addCustomViewsWithGravity(this.mTempViews, 3);
                    size = this.mTempViews.size();
                    while (i22 < size) {
                    }
                    int i382 = i14;
                    addCustomViewsWithGravity(this.mTempViews, 5);
                    size2 = this.mTempViews.size();
                    while (i23 < size2) {
                    }
                    addCustomViewsWithGravity(this.mTempViews, 1);
                    int viewListMeasuredWidth2 = getViewListMeasuredWidth(this.mTempViews, iArr);
                    i24 = (i12 + (((i10 - i12) - i8) / 2)) - (viewListMeasuredWidth2 / 2);
                    int i392 = viewListMeasuredWidth2 + i24;
                    if (i24 >= max) {
                    }
                    size3 = this.mTempViews.size();
                    while (i15 < size3) {
                    }
                    this.mTempViews.clear();
                    return;
                }
                i6 = layoutChildLeft(this.mNavButtonView, paddingLeft, iArr, i5);
            } else {
                i6 = paddingLeft;
            }
            i7 = i25;
            if (shouldLayout(this.mCollapseButtonView)) {
            }
            if (shouldLayout(this.mMenuView)) {
            }
            int currentContentInsetLeft2 = getCurrentContentInsetLeft();
            int currentContentInsetRight2 = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft2 - i6);
            iArr[1] = Math.max(0, currentContentInsetRight2 - (i25 - i7));
            int max2 = Math.max(i6, currentContentInsetLeft2);
            int min2 = Math.min(i7, i25 - currentContentInsetRight2);
            if (shouldLayout(this.mExpandedActionView)) {
            }
            if (shouldLayout(this.mLogoView)) {
            }
            shouldLayout = shouldLayout(this.mTitleTextView);
            shouldLayout2 = shouldLayout(this.mSubtitleTextView);
            if (!shouldLayout) {
            }
            if (!shouldLayout2) {
            }
            if (shouldLayout) {
            }
            if (!shouldLayout) {
            }
            if (!shouldLayout2) {
            }
            LayoutParams layoutParams32 = (LayoutParams) textView.getLayoutParams();
            LayoutParams layoutParams42 = (LayoutParams) textView2.getLayoutParams();
            if (!shouldLayout) {
            }
            z3 = false;
            i11 = this.mGravity & 112;
            i12 = paddingLeft;
            if (i11 == 48) {
            }
            if (!z2) {
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048627, this, i, i2) == null) {
            int[] iArr = this.mTempMargins;
            int i10 = 0;
            if (ViewUtils.isLayoutRtl(this)) {
                c = 1;
                c2 = 0;
            } else {
                c = 0;
                c2 = 1;
            }
            if (shouldLayout(this.mNavButtonView)) {
                measureChildConstrained(this.mNavButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
                i3 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
                i4 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
                i5 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
            } else {
                i3 = 0;
                i4 = 0;
                i5 = 0;
            }
            if (shouldLayout(this.mCollapseButtonView)) {
                measureChildConstrained(this.mCollapseButtonView, i, 0, i2, 0, this.mMaxButtonHeight);
                i3 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
                i4 = Math.max(i4, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
                i5 = View.combineMeasuredStates(i5, this.mCollapseButtonView.getMeasuredState());
            }
            int currentContentInsetStart = getCurrentContentInsetStart();
            int max = 0 + Math.max(currentContentInsetStart, i3);
            iArr[c] = Math.max(0, currentContentInsetStart - i3);
            if (shouldLayout(this.mMenuView)) {
                measureChildConstrained(this.mMenuView, i, max, i2, 0, this.mMaxButtonHeight);
                i6 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
                i4 = Math.max(i4, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
                i5 = View.combineMeasuredStates(i5, this.mMenuView.getMeasuredState());
            } else {
                i6 = 0;
            }
            int currentContentInsetEnd = getCurrentContentInsetEnd();
            int max2 = max + Math.max(currentContentInsetEnd, i6);
            iArr[c2] = Math.max(0, currentContentInsetEnd - i6);
            if (shouldLayout(this.mExpandedActionView)) {
                max2 += measureChildCollapseMargins(this.mExpandedActionView, i, max2, i2, 0, iArr);
                i4 = Math.max(i4, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
                i5 = View.combineMeasuredStates(i5, this.mExpandedActionView.getMeasuredState());
            }
            if (shouldLayout(this.mLogoView)) {
                max2 += measureChildCollapseMargins(this.mLogoView, i, max2, i2, 0, iArr);
                i4 = Math.max(i4, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
                i5 = View.combineMeasuredStates(i5, this.mLogoView.getMeasuredState());
            }
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (((LayoutParams) childAt.getLayoutParams()).mViewType == 0 && shouldLayout(childAt)) {
                    max2 += measureChildCollapseMargins(childAt, i, max2, i2, 0, iArr);
                    i4 = Math.max(i4, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                    i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
                }
            }
            int i12 = this.mTitleMarginTop + this.mTitleMarginBottom;
            int i13 = this.mTitleMarginStart + this.mTitleMarginEnd;
            if (shouldLayout(this.mTitleTextView)) {
                measureChildCollapseMargins(this.mTitleTextView, i, max2 + i13, i2, i12, iArr);
                int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
                i9 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
                i7 = View.combineMeasuredStates(i5, this.mTitleTextView.getMeasuredState());
                i8 = measuredWidth;
            } else {
                i7 = i5;
                i8 = 0;
                i9 = 0;
            }
            if (shouldLayout(this.mSubtitleTextView)) {
                i8 = Math.max(i8, measureChildCollapseMargins(this.mSubtitleTextView, i, max2 + i13, i2, i9 + i12, iArr));
                i9 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
                i7 = View.combineMeasuredStates(i7, this.mSubtitleTextView.getMeasuredState());
            }
            int max3 = Math.max(i4, i9);
            int paddingLeft = max2 + i8 + getPaddingLeft() + getPaddingRight();
            int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
            int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & i7);
            int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, i7 << 16);
            if (!shouldCollapse()) {
                i10 = resolveSizeAndState2;
            }
            setMeasuredDimension(resolveSizeAndState, i10);
        }
    }

    public void setContentInsetsAbsolute(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048640, this, i, i2) == null) {
            ensureContentInsets();
            this.mContentInsets.setAbsolute(i, i2);
        }
    }

    public void setContentInsetsRelative(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048641, this, i, i2) == null) {
            ensureContentInsets();
            this.mContentInsets.setRelative(i, i2);
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

    public void setSubtitleTextAppearance(Context context, @StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048658, this, context, i) == null) {
            this.mSubtitleTextAppearance = i;
            TextView textView = this.mSubtitleTextView;
            if (textView != null) {
                textView.setTextAppearance(context, i);
            }
        }
    }

    public void setTitleTextAppearance(Context context, @StyleRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048668, this, context, i) == null) {
            this.mTitleTextAppearance = i;
            TextView textView = this.mTitleTextView;
            if (textView != null) {
                textView.setTextAppearance(context, i);
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
                    int i = this.mSubtitleTextAppearance;
                    if (i != 0) {
                        this.mSubtitleTextView.setTextAppearance(context, i);
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
                    int i = this.mTitleTextAppearance;
                    if (i != 0) {
                        this.mTitleTextView.setTextAppearance(context, i);
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

    public void setTitleMargin(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048663, this, i, i2, i3, i4) == null) {
            this.mTitleMarginStart = i;
            this.mTitleMarginTop = i2;
            this.mTitleMarginEnd = i3;
            this.mTitleMarginBottom = i4;
            requestLayout();
        }
    }
}

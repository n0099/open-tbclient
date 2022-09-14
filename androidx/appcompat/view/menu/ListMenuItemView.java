package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ListMenuItemView";
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable mBackground;
    public CheckBox mCheckBox;
    public LinearLayout mContent;
    public boolean mForceShowIcon;
    public ImageView mGroupDivider;
    public boolean mHasListDivider;
    public ImageView mIconView;
    public LayoutInflater mInflater;
    public MenuItemImpl mItemData;
    public boolean mPreserveIconSpacing;
    public RadioButton mRadioButton;
    public TextView mShortcutView;
    public Drawable mSubMenuArrow;
    public ImageView mSubMenuArrowView;
    public int mTextAppearance;
    public Context mTextAppearanceContext;
    public TextView mTitleView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f04043c);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addContentView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, view2) == null) {
            addContentView(view2, -1);
        }
    }

    private LayoutInflater getInflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(getContext());
            }
            return this.mInflater;
        }
        return (LayoutInflater) invokeV.objValue;
    }

    private void insertCheckBox() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.obfuscated_res_0x7f0d000e, (ViewGroup) this, false);
            this.mCheckBox = checkBox;
            addContentView(checkBox);
        }
    }

    private void insertIconView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            ImageView imageView = (ImageView) getInflater().inflate(R.layout.obfuscated_res_0x7f0d000f, (ViewGroup) this, false);
            this.mIconView = imageView;
            addContentView(imageView, 0);
        }
    }

    private void insertRadioButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.obfuscated_res_0x7f0d0011, (ViewGroup) this, false);
            this.mRadioButton = radioButton;
            addContentView(radioButton);
        }
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65544, this, z) == null) || (imageView = this.mSubMenuArrowView) == null) {
            return;
        }
        imageView.setVisibility(z ? 0 : 8);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, rect) == null) && (imageView = this.mGroupDivider) != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mGroupDivider.getLayoutParams();
            rect.top += this.mGroupDivider.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mItemData : (MenuItemImpl) invokeV.objValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, menuItemImpl, i) == null) {
            this.mItemData = menuItemImpl;
            setVisibility(menuItemImpl.isVisible() ? 0 : 8);
            setTitle(menuItemImpl.getTitleForItemView(this));
            setCheckable(menuItemImpl.isCheckable());
            setShortcut(menuItemImpl.shouldShowShortcut(), menuItemImpl.getShortcut());
            setIcon(menuItemImpl.getIcon());
            setEnabled(menuItemImpl.isEnabled());
            setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
            setContentDescription(menuItemImpl.getContentDescription());
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishInflate();
            ViewCompat.setBackground(this, this.mBackground);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092216);
            this.mTitleView = textView;
            int i = this.mTextAppearance;
            if (i != -1) {
                textView.setTextAppearance(this.mTextAppearanceContext, i);
            }
            this.mShortcutView = (TextView) findViewById(R.id.obfuscated_res_0x7f091ebc);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091fa3);
            this.mSubMenuArrowView = imageView;
            if (imageView != null) {
                imageView.setImageDrawable(this.mSubMenuArrow);
            }
            this.mGroupDivider = (ImageView) findViewById(R.id.obfuscated_res_0x7f090cfb);
            this.mContent = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906e3);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            if (this.mIconView != null && this.mPreserveIconSpacing) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
                int i3 = layoutParams.height;
                if (i3 > 0 && layoutParams2.width <= 0) {
                    layoutParams2.width = i3;
                }
            }
            super.onMeasure(i, i2);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (!z && this.mRadioButton == null && this.mCheckBox == null) {
                return;
            }
            if (this.mItemData.isExclusiveCheckable()) {
                if (this.mRadioButton == null) {
                    insertRadioButton();
                }
                compoundButton = this.mRadioButton;
                compoundButton2 = this.mCheckBox;
            } else {
                if (this.mCheckBox == null) {
                    insertCheckBox();
                }
                compoundButton = this.mCheckBox;
                compoundButton2 = this.mRadioButton;
            }
            if (z) {
                compoundButton.setChecked(this.mItemData.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                    return;
                }
                compoundButton2.setVisibility(8);
                return;
            }
            CheckBox checkBox = this.mCheckBox;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.mRadioButton;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (this.mItemData.isExclusiveCheckable()) {
                if (this.mRadioButton == null) {
                    insertRadioButton();
                }
                compoundButton = this.mRadioButton;
            } else {
                if (this.mCheckBox == null) {
                    insertCheckBox();
                }
                compoundButton = this.mCheckBox;
            }
            compoundButton.setChecked(z);
        }
    }

    public void setForceShowIcon(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.mForceShowIcon = z;
            this.mPreserveIconSpacing = z;
        }
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (imageView = this.mGroupDivider) == null) {
            return;
        }
        imageView.setVisibility((this.mHasListDivider || !z) ? 8 : 0);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            boolean z = this.mItemData.shouldShowIcon() || this.mForceShowIcon;
            if (z || this.mPreserveIconSpacing) {
                if (this.mIconView == null && drawable == null && !this.mPreserveIconSpacing) {
                    return;
                }
                if (this.mIconView == null) {
                    insertIconView();
                }
                if (drawable == null && !this.mPreserveIconSpacing) {
                    this.mIconView.setVisibility(8);
                    return;
                }
                ImageView imageView = this.mIconView;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.mIconView.getVisibility() != 0) {
                    this.mIconView.setVisibility(0);
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Character.valueOf(c)}) == null) {
            int i = (z && this.mItemData.shouldShowShortcut()) ? 0 : 8;
            if (i == 0) {
                this.mShortcutView.setText(this.mItemData.getShortcutLabel());
            }
            if (this.mShortcutView.getVisibility() != i) {
                this.mShortcutView.setVisibility(i);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, charSequence) == null) {
            if (charSequence != null) {
                this.mTitleView.setText(charSequence);
                if (this.mTitleView.getVisibility() != 0) {
                    this.mTitleView.setVisibility(0);
                }
            } else if (this.mTitleView.getVisibility() != 8) {
                this.mTitleView.setVisibility(8);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mForceShowIcon : invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, androidx.appcompat.R.styleable.MenuView, i, 0);
        this.mBackground = obtainStyledAttributes.getDrawable(5);
        this.mTextAppearance = obtainStyledAttributes.getResourceId(1, -1);
        this.mPreserveIconSpacing = obtainStyledAttributes.getBoolean(7, false);
        this.mTextAppearanceContext = context;
        this.mSubMenuArrow = obtainStyledAttributes.getDrawable(8);
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R.attr.obfuscated_res_0x7f040264, 0);
        this.mHasListDivider = obtainStyledAttributes2.hasValue(0);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes2.recycle();
    }

    private void addContentView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, view2, i) == null) {
            LinearLayout linearLayout = this.mContent;
            if (linearLayout != null) {
                linearLayout.addView(view2, i);
            } else {
                addView(view2, i);
            }
        }
    }
}

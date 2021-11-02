package com.baidu.searchbox.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.ext.widget.dialog.BoxScrollView;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.android.ext.widget.menu.BdMenuItemCheck;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class CommonOverflowMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<BdMenuItem, ImageView> mBdMenuItemIconMap;
    public List<TextView> mBdMenuItemTexList;
    public SparseArray<View> mChildView;
    public View mContentView;
    public int mDividerHeight;
    public List<ImageView> mDividerList;
    public int mDividerRes;
    public int mItemBgRes;
    public ColorStateList mItemTextColor;
    public LinearLayout mLinearContent;
    public boolean mMenuLoaded;
    public Object mNightModeRegister;
    public BoxScrollView mScrollView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonOverflowMenuView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mItemBgRes = com.baidu.android.common.ui.R.drawable.discovery_home_menu_item_selector;
        this.mDividerRes = com.baidu.android.common.ui.R.color.home_menu_separator_color;
        this.mDividerHeight = 1;
        this.mDividerList = new ArrayList();
        this.mBdMenuItemTexList = new ArrayList();
        this.mBdMenuItemIconMap = new HashMap<>();
        this.mMenuLoaded = false;
        this.mChildView = new SparseArray<>();
        this.mNightModeRegister = new Object();
        init(context);
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(com.baidu.android.common.ui.R.layout.menu_scroll_view, (ViewGroup) this, true);
            this.mContentView = inflate;
            this.mLinearContent = (LinearLayout) inflate.findViewById(com.baidu.android.common.ui.R.id.menu_linear);
            this.mScrollView = (BoxScrollView) this.mContentView.findViewById(com.baidu.android.common.ui.R.id.menu_scrollview);
            setFocusable(true);
            setFocusableInTouchMode(true);
            updateUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemOnclick(BdMenuItem bdMenuItem) {
        BdMenuItem.OnItemClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bdMenuItem) == null) || (onClickListener = bdMenuItem.getOnClickListener()) == null) {
            return;
        }
        onClickListener.onClick(bdMenuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.mItemTextColor = getResources().getColorStateList(com.baidu.android.common.ui.R.color.discovery_home_menu_text_color);
            setBackground(getResources().getDrawable(com.baidu.android.common.ui.R.drawable.discovery_feedback_menu_bg));
            for (ImageView imageView : this.mDividerList) {
                imageView.setBackgroundColor(getResources().getColor(this.mDividerRes));
            }
            for (TextView textView : this.mBdMenuItemTexList) {
                textView.setTextColor(this.mItemTextColor);
            }
            for (Map.Entry<BdMenuItem, ImageView> entry : this.mBdMenuItemIconMap.entrySet()) {
                entry.getValue().setImageDrawable(entry.getKey().getIcon());
            }
        }
    }

    public int getItemBgRes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mItemBgRes : invokeV.intValue;
    }

    public LinearLayout getLinearContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLinearContent : (LinearLayout) invokeV.objValue;
    }

    public View getMenuItemView(Context context, BdMenuItem bdMenuItem) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, bdMenuItem)) == null) {
            if (bdMenuItem instanceof BdMenuItemCheck) {
                View inflate = LayoutInflater.from(context).inflate(com.baidu.android.common.ui.R.layout.pulldown_item_checkbox, (ViewGroup) this.mLinearContent, false);
                inflate.findViewById(com.baidu.android.common.ui.R.id.item).setBackgroundResource(this.mItemBgRes);
                TextView textView = (TextView) inflate.findViewById(com.baidu.android.common.ui.R.id.item_title);
                this.mBdMenuItemTexList.add(textView);
                textView.setText(bdMenuItem.getTitle());
                ((CheckBox) inflate.findViewById(com.baidu.android.common.ui.R.id.checkbox_id)).setChecked(bdMenuItem.isChecked());
                textView.setTextColor(this.mItemTextColor);
                inflate.setEnabled(bdMenuItem.isEnabled());
                textView.setEnabled(bdMenuItem.isEnabled());
                return inflate;
            }
            View inflate2 = LayoutInflater.from(context).inflate(com.baidu.android.common.ui.R.layout.pulldown_item, (ViewGroup) this.mLinearContent, false);
            inflate2.findViewById(com.baidu.android.common.ui.R.id.item).setBackgroundResource(this.mItemBgRes);
            ImageView imageView = (ImageView) inflate2.findViewById(com.baidu.android.common.ui.R.id.left_img);
            this.mBdMenuItemIconMap.put(bdMenuItem, imageView);
            imageView.setImageDrawable(bdMenuItem.getIcon());
            TextView textView2 = (TextView) inflate2.findViewById(com.baidu.android.common.ui.R.id.right_txt);
            this.mBdMenuItemTexList.add(textView2);
            textView2.setText(bdMenuItem.getTitle());
            textView2.setTextColor(this.mItemTextColor);
            inflate2.setEnabled(bdMenuItem.isEnabled());
            imageView.setEnabled(bdMenuItem.isEnabled());
            textView2.setEnabled(bdMenuItem.isEnabled());
            return inflate2;
        }
        return (View) invokeLL.objValue;
    }

    public ColorStateList getTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mItemTextColor : (ColorStateList) invokeV.objValue;
    }

    public void layoutMenu(List<BdMenuItem> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || this.mMenuLoaded) {
            return;
        }
        this.mLinearContent.removeAllViews();
        this.mChildView.clear();
        Context context = getContext();
        if (this.mDividerHeight < 0) {
            this.mDividerHeight = context.getResources().getDimensionPixelSize(com.baidu.android.common.ui.R.dimen.pulldown_divider_height);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.mDividerHeight);
        int i2 = 0;
        for (BdMenuItem bdMenuItem : list) {
            View menuItemView = getMenuItemView(context, bdMenuItem);
            if (bdMenuItem.isEnabled()) {
                menuItemView.setOnClickListener(new View.OnClickListener(this, bdMenuItem) { // from class: com.baidu.searchbox.ui.CommonOverflowMenuView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CommonOverflowMenuView this$0;
                    public final /* synthetic */ BdMenuItem val$item;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, bdMenuItem};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$item = bdMenuItem;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.this$0.itemOnclick(this.val$item);
                        }
                    }
                });
            }
            this.mLinearContent.addView(menuItemView);
            this.mChildView.append(bdMenuItem.getItemId(), menuItemView);
            if (i2 < list.size() - 1) {
                ImageView imageView = new ImageView(context);
                this.mDividerList.add(imageView);
                imageView.setBackgroundColor(getResources().getColor(this.mDividerRes));
                this.mLinearContent.addView(imageView, layoutParams);
            }
            i2++;
        }
        this.mMenuLoaded = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            NightModeHelper.subscribeNightModeChangeEvent(this.mNightModeRegister, new NightModeChangeListener(this) { // from class: com.baidu.searchbox.ui.CommonOverflowMenuView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CommonOverflowMenuView this$0;

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

                @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
                public void onNightModeChanged(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.this$0.updateUI();
                    }
                }
            });
            updateUI();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            NightModeHelper.unsubscribeNightModeChangedEvent(this.mNightModeRegister);
        }
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bdMenuItem) == null) || bdMenuItem == null || !(bdMenuItem instanceof BdMenuItemCheck) || (view = this.mChildView.get(bdMenuItem.getItemId())) == null) {
            return;
        }
        view.findViewById(com.baidu.android.common.ui.R.id.item).setBackgroundResource(this.mItemBgRes);
        TextView textView = (TextView) view.findViewById(com.baidu.android.common.ui.R.id.item_title);
        textView.setText(bdMenuItem.getTitle());
        ((CheckBox) view.findViewById(com.baidu.android.common.ui.R.id.checkbox_id)).setChecked(bdMenuItem.isChecked());
        textView.setTextColor(this.mItemTextColor);
        view.setEnabled(bdMenuItem.isEnabled());
        textView.setEnabled(bdMenuItem.isEnabled());
    }

    @Override // com.baidu.android.ext.widget.menu.BdMenu.OnMenuSetChangedListener
    public void onMenuSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mMenuLoaded = false;
        }
    }

    public void setItemBackground(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mItemBgRes = i2;
        }
    }

    public void setItemDivider(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            this.mDividerRes = i2;
            this.mDividerHeight = i3;
        }
    }

    public void setItemTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mItemTextColor = getResources().getColorStateList(i2);
        }
    }

    public void setMaxHeightPixel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mScrollView.setMaxHeight(i2);
        }
    }

    public void setMaxHeightRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.mScrollView.setMaxHeight(getContext().getResources().getDimensionPixelSize(i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonOverflowMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mItemBgRes = com.baidu.android.common.ui.R.drawable.discovery_home_menu_item_selector;
        this.mDividerRes = com.baidu.android.common.ui.R.color.home_menu_separator_color;
        this.mDividerHeight = 1;
        this.mDividerList = new ArrayList();
        this.mBdMenuItemTexList = new ArrayList();
        this.mBdMenuItemIconMap = new HashMap<>();
        this.mMenuLoaded = false;
        this.mChildView = new SparseArray<>();
        this.mNightModeRegister = new Object();
        init(context);
    }
}

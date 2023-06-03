package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.spswitch.emotion.bean.EmotionTypeModel;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class EmotionTabLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_TAB_ID = "emoji";
    public static String sSelectedTabId = "notSet";
    public transient /* synthetic */ FieldHolder $fh;
    public int currentItem;
    public LinearLayout linearLayout;
    public ViewPager.OnPageChangeListener listener;
    public int mItemHeight;
    public int mItemWidth;
    public BDEmotionPanelManager.EmotionPanelConfig mPanelConfig;
    public List<String> mTabIdList;
    public ViewPager viewPager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1860511215, "Lcom/baidu/spswitch/emotion/view/EmotionTabLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1860511215, "Lcom/baidu/spswitch/emotion/view/EmotionTabLayout;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmotionTabLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ubcClick(int i) {
        BDEmotionPanelManager.EmotionPanelConfig emotionPanelConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65551, this, i) == null) && i != 0 && i < this.mTabIdList.size() && (emotionPanelConfig = this.mPanelConfig) != null) {
            EmotionUbcHelper.doEmotionDynamicUBC(emotionPanelConfig.from, "tab_clk", emotionPanelConfig.page, emotionPanelConfig.source, this.mTabIdList.get(i), "");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmotionTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.currentItem = 0;
        this.mTabIdList = new ArrayList();
        initView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getItemViewByPos(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
            return this.linearLayout.getChildAt(i);
        }
        return (View) invokeI.objValue;
    }

    private void scrollToCenter(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i) == null) {
            UiThreadUtils.getMainHandler().post(new Runnable(this, i) { // from class: com.baidu.spswitch.emotion.view.EmotionTabLayout.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EmotionTabLayout this$0;
                public final /* synthetic */ int val$position;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
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
                    this.val$position = i;
                }

                @Override // java.lang.Runnable
                public void run() {
                    View itemViewByPos;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (itemViewByPos = this.this$0.getItemViewByPos(this.val$position)) != null) {
                        this.this$0.smoothScrollTo((itemViewByPos.getLeft() - (this.this$0.getMeasuredWidth() / 2)) + (itemViewByPos.getWidth() / 2), 0);
                    }
                }
            });
        }
    }

    public void changeTabByTabId(String str) {
        int indexOf;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (indexOf = this.mTabIdList.indexOf(str)) >= 0) {
            setCurrentItem(indexOf);
            this.viewPager.setCurrentItem(indexOf);
        }
    }

    public void setPanelConfig(@Nullable BDEmotionPanelManager.EmotionPanelConfig emotionPanelConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, emotionPanelConfig) == null) {
            this.mPanelConfig = emotionPanelConfig;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, viewPager) == null) {
            this.viewPager = viewPager;
        }
    }

    private SimpleDraweeView createItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_padding_left);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_padding_top);
            float dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_radius);
            GenericDraweeHierarchy build = GenericDraweeHierarchyBuilder.newInstance(getResources()).setRoundingParams(RoundingParams.fromCornersRadii(dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3, dimensionPixelSize3)).setPlaceholderImage(R.drawable.emotion_preview_placeholder).build();
            SimpleDraweeView simpleDraweeView = new SimpleDraweeView(getContext());
            simpleDraweeView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
            simpleDraweeView.setHierarchy(build);
            return simpleDraweeView;
        }
        return (SimpleDraweeView) invokeV.objValue;
    }

    private LinearLayout.LayoutParams getItemParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_margin_left);
            layoutParams.gravity = 16;
            return layoutParams;
        }
        return (LinearLayout.LayoutParams) invokeV.objValue;
    }

    public ViewPager.OnPageChangeListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.listener == null) {
                this.listener = new ViewPager.OnPageChangeListener(this) { // from class: com.baidu.spswitch.emotion.view.EmotionTabLayout.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EmotionTabLayout this$0;

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        }
                    }

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int i, float f, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
                        }
                    }

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

                    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                    public void onPageSelected(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) {
                            return;
                        }
                        this.this$0.setCurrentItem(i);
                        this.this$0.ubcClick(i);
                    }
                };
            }
            return this.listener;
        }
        return (ViewPager.OnPageChangeListener) invokeV.objValue;
    }

    @NonNull
    public String getSelectedTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return sSelectedTabId;
        }
        return (String) invokeV.objValue;
    }

    private void initView(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, context) == null) {
            this.linearLayout = new LinearLayout(context);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.emotion_tab_layout_height);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.expression_left_right_margin);
            this.mItemWidth = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_width);
            this.mItemHeight = getResources().getDimensionPixelSize(R.dimen.emotion_tab_type_height);
            this.linearLayout.setPadding(dimensionPixelSize2, 0, 0, 0);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, dimensionPixelSize);
            this.linearLayout.setGravity(16);
            addView(this.linearLayout, layoutParams);
            SimpleDraweeView createItem = createItem();
            createItem.setImageResource(R.drawable.face_bottom);
            createItem.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.emotion_tab_tyep_selected_bg));
            createItem.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.spswitch.emotion.view.EmotionTabLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EmotionTabLayout this$0;

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
                        this.this$0.viewPager.setCurrentItem(0);
                        String unused = EmotionTabLayout.sSelectedTabId = "emoji";
                    }
                }
            });
            this.mTabIdList.add("emoji");
            this.linearLayout.addView(createItem, getItemParams());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, this, i) == null) {
            this.linearLayout.getChildAt(this.currentItem).setBackground(null);
            this.currentItem = i;
            scrollToCenter(i);
            this.linearLayout.getChildAt(i).setBackground(ContextCompat.getDrawable(getContext(), R.drawable.emotion_tab_tyep_selected_bg));
            if (i < this.mTabIdList.size()) {
                sSelectedTabId = this.mTabIdList.get(i);
            }
        }
    }

    public void addData(@NonNull Map<String, EmotionTypeModel> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, map) != null) || map.isEmpty()) {
            return;
        }
        int childCount = this.linearLayout.getChildCount();
        for (EmotionTypeModel emotionTypeModel : map.values()) {
            SimpleDraweeView createItem = createItem();
            createItem.setImageURI(emotionTypeModel.getIcon());
            this.linearLayout.addView(createItem, getItemParams());
            createItem.setOnClickListener(new View.OnClickListener(this, childCount) { // from class: com.baidu.spswitch.emotion.view.EmotionTabLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EmotionTabLayout this$0;
                public final /* synthetic */ int val$pos;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(childCount)};
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
                    this.val$pos = childCount;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.this$0.viewPager.setCurrentItem(this.val$pos);
                        this.this$0.ubcClick(this.val$pos);
                    }
                }
            });
            this.mTabIdList.add(emotionTypeModel.getId());
            childCount++;
        }
    }
}

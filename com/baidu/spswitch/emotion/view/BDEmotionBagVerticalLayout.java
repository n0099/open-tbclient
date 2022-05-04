package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.emotion.view.PopupEmotionManager;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.UIUtils;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public class BDEmotionBagVerticalLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COLOR_EMOTION_BAG = -460552;
    public static final float DEL_BTN_ALPHA_DISABLED = 0.4f;
    public static final float DEL_BTN_ALPHA_ENABLED = 1.0f;
    public static final int DEL_BTN_ALPHA_INT_DISABLED = 102;
    public static final int DEL_BTN_ALPHA_INT_ENABLED = 255;
    public static final int DEL_BTN_ALPHA_INT_PRESSED = 51;
    public static final float DEL_BTN_ALPHA_PRESSED = 0.2f;
    public static final int EMOTION_COLUMNS = 7;
    public static final int EXPRESSION_ALL_META_BASE_IDX = 3;
    public static final int EXPRESSION_COMMON_META_IDX = 1;
    public static final int ITEM_TYPE_EMOTION = 1;
    public static final int ITEM_TYPE_PADDING = 2;
    public static final int ITEM_TYPE_TITLE = 0;
    public static final int NIGHT_COLOR_EMOTION_BAG = -15132391;
    public static final int SECTION_ALL = 1;
    public static final int SECTION_COMMON = 0;
    public static final String TAG = "BDEmotionBagVerticalLayout";
    public static int sExprCrossSectionFixedHeight;
    public static int sExprTotalExtraHeight;
    public static int sExpressionHeightWithPadding;
    public static int sExpressionWidthWithPadding;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> mAlphaChangingEmotionSet;
    public Map<ImageView, Object> mAlphaChangingIconSet;
    public Context mCtx;
    public int mCurrentScrollY;
    public Rect mDelBtLocRect;
    public ImageView mDelBtn;
    public EmotionListAdapter mEmotionListAdapter;
    public RecyclerView mEmotionRecyclerView;
    public CircleIndicator mIndicator;
    public OffsetLinearLayoutManager mLayoutManager;
    public Handler mMainHandler;
    public EmotionPagerAdapter mPagerAdapter;
    public PopupEmotionManager mPopupEmotionManager;
    public boolean mTempEnableIdleAlpha;
    public RectF mValidLongPressedRect;
    public ViewPager mViewPager;

    /* loaded from: classes2.dex */
    public static abstract class BaseViewHolder<DATA> extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mCtx;
        public int mItemType;
        public BDEmotionBagVerticalLayout mVerticalLayout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(View view2, Context context, int i, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, context, Integer.valueOf(i), bDEmotionBagVerticalLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCtx = context;
            this.mItemType = i;
            this.mVerticalLayout = bDEmotionBagVerticalLayout;
        }

        public static BaseViewHolder createViewHolder(ViewGroup viewGroup, int i, Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65537, null, viewGroup, i, context, bDEmotionBagVerticalLayout)) == null) {
                LayoutInflater from = LayoutInflater.from(context);
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return null;
                        }
                        View view2 = new View(context);
                        view2.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070324)));
                        return new PaddingViewHolder(view2, context, bDEmotionBagVerticalLayout);
                    }
                    return new EmotionViewHolder(from.inflate(R.layout.obfuscated_res_0x7f0d0275, viewGroup, false), context, bDEmotionBagVerticalLayout);
                }
                return new TitleViewHolder(from.inflate(R.layout.obfuscated_res_0x7f0d0278, viewGroup, false), context, bDEmotionBagVerticalLayout);
            }
            return (BaseViewHolder) invokeLILL.objValue;
        }

        public int getItemType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mItemType : invokeV.intValue;
        }

        public abstract void onBindViewHolder(int i, DATA data);
    }

    /* loaded from: classes2.dex */
    public static class EmotionGridViewAdapter extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public LayoutInflater mInflater;
        public List<String> mList;
        public LongClickCallback mLongClickCallback;
        public View.OnTouchListener mOnTouchListener;
        public int mRowCount;
        public int mRowIndex;
        public int mRowType;
        public StatisticData mStatisticData;
        public BDEmotionBagVerticalLayout mVerticalLayout;

        /* loaded from: classes2.dex */
        public interface LongClickCallback {
            void onLongClick(View view2);
        }

        /* loaded from: classes2.dex */
        public static class StatisticData {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int rowIndex;
            public int sectionType;
            public EmotionType type;

            public StatisticData(EmotionType emotionType, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {emotionType, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.type = emotionType;
                this.rowIndex = i;
                this.sectionType = i2;
            }
        }

        public EmotionGridViewAdapter(Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bDEmotionBagVerticalLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mInflater = LayoutInflater.from(context);
            this.mContext = context;
            this.mVerticalLayout = bDEmotionBagVerticalLayout;
        }

        private void processAlpha(ViewGroup viewGroup, ImageView imageView, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, viewGroup, imageView, str, i) == null) && i == 6 && this.mRowType == 1) {
                if (imageView.getTag() != null && (imageView.getTag() instanceof ViewTreeObserver.OnPreDrawListener)) {
                    imageView.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) imageView.getTag());
                }
                ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener(this, viewGroup, imageView, str) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionGridViewAdapter.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EmotionGridViewAdapter this$0;
                    public final /* synthetic */ String val$emotionName;
                    public final /* synthetic */ ImageView val$imageView;
                    public final /* synthetic */ ViewGroup val$itemRoot;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, viewGroup, imageView, str};
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
                        this.val$itemRoot = viewGroup;
                        this.val$imageView = imageView;
                        this.val$emotionName = str;
                    }

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            if (this.this$0.mVerticalLayout == null) {
                                return true;
                            }
                            float iconAlpha = this.this$0.mVerticalLayout.getIconAlpha(this.val$itemRoot, this.val$imageView, this.val$emotionName);
                            if (iconAlpha >= 0.0f) {
                                this.val$imageView.setAlpha(iconAlpha);
                            }
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                };
                imageView.setTag(onPreDrawListener);
                imageView.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<String> list = this.mList;
                if (list == null || list.isEmpty()) {
                    return 0;
                }
                return this.mList.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    frameLayout = (FrameLayout) this.mInflater.inflate(R.layout.obfuscated_res_0x7f0d0273, viewGroup, false);
                    ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                    layoutParams.height = BDEmotionBagVerticalLayout.sExpressionHeightWithPadding;
                    frameLayout.setLayoutParams(layoutParams);
                } else {
                    frameLayout = (FrameLayout) view2;
                }
                frameLayout.setOnClickListener(new View.OnClickListener(this, i) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionGridViewAdapter.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EmotionGridViewAdapter this$0;
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

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) && view3.isEnabled()) {
                            GlobalOnItemClickListenerManager.getInstance().verticalOnItemClick(this.this$0.getItem(this.val$position), this.this$0.mStatisticData, this.val$position);
                        }
                    }
                });
                View.OnTouchListener onTouchListener = this.mOnTouchListener;
                if (onTouchListener != null) {
                    frameLayout.setOnTouchListener(onTouchListener);
                }
                frameLayout.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionGridViewAdapter.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EmotionGridViewAdapter this$0;

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

                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view3) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view3)) == null) {
                            if (view3.isEnabled()) {
                                if (this.this$0.mLongClickCallback != null) {
                                    this.this$0.mLongClickCallback.onLongClick(view3);
                                }
                                if (this.this$0.mVerticalLayout == null || this.this$0.mVerticalLayout.getPopupEmotionManager() == null) {
                                    return true;
                                }
                                this.this$0.mVerticalLayout.getPopupEmotionManager().reset();
                                return true;
                            }
                            return false;
                        }
                        return invokeL.booleanValue;
                    }
                });
                ImageView imageView = (ImageView) frameLayout.findViewById(R.id.obfuscated_res_0x7f090eb6);
                processAlpha(frameLayout, imageView, this.mList.get(i), i);
                Bitmap emotionBitmapByName = EmotionUtils.getInstance().getEmotionBitmapByName(EmotionType.EMOTION_CLASSIC_TYPE, this.mList.get(i));
                if (emotionBitmapByName != null) {
                    imageView.setImageBitmap(emotionBitmapByName);
                }
                return frameLayout;
            }
            return (View) invokeILL.objValue;
        }

        public void setData(EmotionTemplateData emotionTemplateData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, emotionTemplateData) == null) || emotionTemplateData == null) {
                return;
            }
            this.mList = emotionTemplateData.iconList;
            this.mRowIndex = emotionTemplateData.rowIndex;
            this.mRowCount = emotionTemplateData.rowCount;
            this.mRowType = emotionTemplateData.sectionType;
            notifyDataSetChanged();
        }

        public void setLongClickCallback(LongClickCallback longClickCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, longClickCallback) == null) {
                this.mLongClickCallback = longClickCallback;
            }
        }

        public void setOnTouchListener(View.OnTouchListener onTouchListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, onTouchListener) == null) {
                this.mOnTouchListener = onTouchListener;
            }
        }

        public void setStatisticData(StatisticData statisticData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, statisticData) == null) {
                this.mStatisticData = statisticData;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                List<String> list = this.mList;
                return (list == null || list.isEmpty()) ? "" : this.mList.get(i);
            }
            return (String) invokeI.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class EmotionListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mCtx;
        public List<ListMetaData> mDataList;
        public BDEmotionBagVerticalLayout mVerticalLayout;

        public EmotionListAdapter(Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bDEmotionBagVerticalLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDataList = new ArrayList();
            this.mCtx = context;
            this.mVerticalLayout = bDEmotionBagVerticalLayout;
        }

        public List<ListMetaData> getDataList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDataList : (List) invokeV.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<ListMetaData> list = this.mDataList;
                if (list == null || list.isEmpty()) {
                    return 0;
                }
                return this.mDataList.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                List<ListMetaData> list = this.mDataList;
                if (list == null || list.isEmpty()) {
                    return -1;
                }
                return this.mDataList.get(i).itemType;
            }
            return invokeI.intValue;
        }

        public void setData(List<ListMetaData> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, list) == null) || list == null || list.isEmpty()) {
                return;
            }
            this.mDataList.clear();
            this.mDataList.addAll(list);
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
            List<ListMetaData> list;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048580, this, baseViewHolder, i) == null) || (list = this.mDataList) == null || list.isEmpty() || this.mDataList.get(i).itemType != baseViewHolder.getItemType()) {
                return;
            }
            baseViewHolder.onBindViewHolder(i, this.mDataList.get(i).data);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) ? BaseViewHolder.createViewHolder(viewGroup, i, this.mCtx, this.mVerticalLayout) : (BaseViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class EmotionPagerAdapter extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<View> mList;
        public final /* synthetic */ BDEmotionBagVerticalLayout this$0;

        public EmotionPagerAdapter(BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout, List<View> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDEmotionBagVerticalLayout, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bDEmotionBagVerticalLayout;
            this.mList = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
                viewGroup.removeView(this.mList.get(i));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mList.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                viewGroup.addView(this.mList.get(i));
                return this.mList.get(i);
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class EmotionTemplateData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<String> iconList;
        public int rowCount;
        public int rowIndex;
        public int sectionType;

        public EmotionTemplateData() {
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
    }

    /* loaded from: classes2.dex */
    public static class EmotionViewHolder extends BaseViewHolder<EmotionTemplateData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mActivePointerId;
        public int[] mAnchorLocationBase;
        public int[] mAnchorRowColBase;
        public EmotionGridViewAdapter mGridViewAdapter;
        public GridView mIconGridList;
        public boolean mIsAnchorInited;
        public boolean mIsLongPressed;
        public View mPressedView;
        public boolean mValidTouch;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmotionViewHolder(View view2, Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            super(view2, context, 1, bDEmotionBagVerticalLayout);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, context, bDEmotionBagVerticalLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (Context) objArr2[1], ((Integer) objArr2[2]).intValue(), (BDEmotionBagVerticalLayout) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCtx = context;
            GridView gridView = (GridView) view2.findViewById(R.id.obfuscated_res_0x7f090e1b);
            this.mIconGridList = gridView;
            gridView.setSelector(new ColorDrawable(0));
            this.mIconGridList.setNumColumns(7);
        }

        private void dismissLongPressedIfNecessary() {
            BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (bDEmotionBagVerticalLayout = this.mVerticalLayout) == null || bDEmotionBagVerticalLayout.getPopupEmotionManager() == null) {
                return;
            }
            this.mVerticalLayout.getPopupEmotionManager().dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean releaseLongPressedIfNecessary(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, view2, motionEvent)) == null) {
                if (this.mIsLongPressed) {
                    this.mIsLongPressed = false;
                    this.mIsAnchorInited = false;
                    this.mIconGridList.requestDisallowInterceptTouchEvent(false);
                    dismissLongPressedIfNecessary();
                    motionEvent.setAction(3);
                    view2.dispatchTouchEvent(motionEvent);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showLongPressedIfNecessary(float f, float f2, EmotionTemplateData emotionTemplateData) {
            BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout;
            int[] iconRowAndColIndex;
            int[] iArr;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), emotionTemplateData}) == null) || (bDEmotionBagVerticalLayout = this.mVerticalLayout) == null || bDEmotionBagVerticalLayout.getPopupEmotionManager() == null || !this.mIsLongPressed) {
                return;
            }
            RectF validLongPressedRect = this.mVerticalLayout.getValidLongPressedRect();
            if ((validLongPressedRect == null || validLongPressedRect.contains((int) f, (int) f2)) && !this.mVerticalLayout.getPopupEmotionManager().isPostRunning()) {
                if (this.mIsAnchorInited) {
                    iconRowAndColIndex = this.mVerticalLayout.getIconRowAndColIndex(f, f2);
                    int i = iconRowAndColIndex[0];
                    int[] iArr2 = this.mAnchorRowColBase;
                    iArr = new int[]{i - iArr2[0], iconRowAndColIndex[1] - iArr2[1]};
                } else {
                    this.mIsAnchorInited = true;
                    int[] iArr3 = new int[2];
                    this.mAnchorLocationBase = iArr3;
                    this.mPressedView.getLocationOnScreen(iArr3);
                    iconRowAndColIndex = this.mVerticalLayout.getIconRowAndColIndex(f, f2);
                    this.mAnchorRowColBase = iconRowAndColIndex;
                    iArr = new int[]{0, 0};
                }
                if (iconRowAndColIndex[0] < 0 || iconRowAndColIndex[1] < 0) {
                    return;
                }
                String expressionName = this.mVerticalLayout.getExpressionName(iconRowAndColIndex[0], iconRowAndColIndex[1]);
                if (TextUtils.isEmpty(expressionName)) {
                    return;
                }
                PopupEmotionManager.ShowParam showParam = new PopupEmotionManager.ShowParam();
                showParam.sectionType = emotionTemplateData != null ? emotionTemplateData.sectionType : -1;
                showParam.exprRow = iconRowAndColIndex[0];
                showParam.exprCol = iconRowAndColIndex[1];
                showParam.anchorWidth = this.mPressedView.getWidth();
                showParam.anchorXpos = this.mAnchorLocationBase[0] + (iArr[1] * BDEmotionBagVerticalLayout.sExpressionWidthWithPadding);
                int i2 = this.mAnchorLocationBase[1] + (iArr[0] * BDEmotionBagVerticalLayout.sExpressionHeightWithPadding);
                showParam.anchorYpos = i2;
                if (iconRowAndColIndex[0] == 0 && this.mAnchorRowColBase[0] > 0) {
                    showParam.anchorYpos = i2 - BDEmotionBagVerticalLayout.sExprCrossSectionFixedHeight;
                } else if (iconRowAndColIndex[0] > 0 && this.mAnchorRowColBase[0] == 0) {
                    showParam.anchorYpos += BDEmotionBagVerticalLayout.sExprCrossSectionFixedHeight;
                }
                showParam.exprName = expressionName;
                showParam.exprBitmap = EmotionUtils.getInstance().getEmotionBitmapByName(EmotionType.EMOTION_CLASSIC_TYPE, showParam.exprName);
                this.mVerticalLayout.getPopupEmotionManager().show(showParam);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.BaseViewHolder
        public void onBindViewHolder(int i, EmotionTemplateData emotionTemplateData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, emotionTemplateData) == null) {
                EmotionGridViewAdapter emotionGridViewAdapter = new EmotionGridViewAdapter(this.mCtx, this.mVerticalLayout);
                this.mGridViewAdapter = emotionGridViewAdapter;
                emotionGridViewAdapter.setData(emotionTemplateData);
                this.mIconGridList.setAdapter((ListAdapter) this.mGridViewAdapter);
                this.mGridViewAdapter.setStatisticData(new EmotionGridViewAdapter.StatisticData(EmotionType.EMOTION_CLASSIC_TYPE, emotionTemplateData.rowIndex, emotionTemplateData.sectionType));
                this.mGridViewAdapter.setOnTouchListener(new View.OnTouchListener(this, emotionTemplateData) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionViewHolder.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EmotionViewHolder this$0;
                    public final /* synthetic */ EmotionTemplateData val$data;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, emotionTemplateData};
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
                        this.val$data = emotionTemplateData;
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view2, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                this.this$0.mActivePointerId = pointerId;
                                this.this$0.mValidTouch = true;
                            } else if (action == 1) {
                                return this.this$0.releaseLongPressedIfNecessary(view2, motionEvent);
                            } else {
                                if (action != 2) {
                                    if (action == 5 || action == 6) {
                                        this.this$0.mValidTouch = false;
                                    }
                                } else if (this.this$0.mValidTouch && this.this$0.mActivePointerId == pointerId && this.this$0.mIsLongPressed) {
                                    this.this$0.showLongPressedIfNecessary(motionEvent.getRawX(), motionEvent.getRawY(), this.val$data);
                                    return true;
                                }
                            }
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                this.mGridViewAdapter.setLongClickCallback(new EmotionGridViewAdapter.LongClickCallback(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionViewHolder.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EmotionViewHolder this$0;

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

                    @Override // com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionGridViewAdapter.LongClickCallback
                    public void onLongClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.this$0.mIsLongPressed = true;
                            this.this$0.mPressedView = view2;
                            this.this$0.mIconGridList.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                });
                this.mIconGridList.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionViewHolder.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ EmotionViewHolder this$0;

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

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            this.this$0.mIconGridList.getViewTreeObserver().removeOnPreDrawListener(this);
                            int unused = BDEmotionBagVerticalLayout.sExpressionWidthWithPadding = this.this$0.mIconGridList.getColumnWidth() + this.this$0.mIconGridList.getHorizontalSpacing();
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                });
                if (emotionTemplateData != null) {
                    GlobalOnItemClickListenerManager.getInstance().updateEmotionShownMaxRow(emotionTemplateData.rowIndex);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ListMetaData<DATA> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DATA data;
        public int itemType;

        public ListMetaData(int i, DATA data) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), data};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.itemType = i;
            this.data = data;
        }
    }

    /* loaded from: classes2.dex */
    public static class OffsetLinearLayoutManager extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RecyclerView.Recycler mRecycler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OffsetLinearLayoutManager(Context context) {
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
        }

        public int getScrollY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int paddingTop = getPaddingTop();
                int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
                if (findFirstVisibleItemPosition < 0 || findFirstVisibleItemPosition >= getItemCount()) {
                    return paddingTop;
                }
                for (int i = 0; i < findFirstVisibleItemPosition; i++) {
                    View viewForPosition = this.mRecycler.getViewForPosition(i);
                    if (viewForPosition != null) {
                        if (viewForPosition.getMeasuredHeight() <= 0) {
                            measureChildWithMargins(viewForPosition, 0, 0);
                        }
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
                        paddingTop = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getDecoratedMeasuredHeight(viewForPosition) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        this.mRecycler.recycleView(viewForPosition);
                    }
                }
                View findViewByPosition = findViewByPosition(findFirstVisibleItemPosition);
                return (paddingTop + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) findViewByPosition.getLayoutParams())).topMargin) - getDecoratedTop(findViewByPosition);
            }
            return invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recycler, state, i, i2) == null) {
                super.onMeasure(recycler, state, i, i2);
                this.mRecycler = recycler;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class PaddingTemplateData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PaddingTemplateData() {
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
    }

    /* loaded from: classes2.dex */
    public static class PaddingViewHolder extends BaseViewHolder<PaddingTemplateData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PaddingViewHolder(View view2, Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            super(view2, context, 2, bDEmotionBagVerticalLayout);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, context, bDEmotionBagVerticalLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (Context) objArr2[1], ((Integer) objArr2[2]).intValue(), (BDEmotionBagVerticalLayout) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.BaseViewHolder
        public void onBindViewHolder(int i, PaddingTemplateData paddingTemplateData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, paddingTemplateData) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class TitleTemplateData {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String sectionTitle;
        public int sectionType;

        public TitleTemplateData() {
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
    }

    /* loaded from: classes2.dex */
    public static class TitleViewHolder extends BaseViewHolder<TitleTemplateData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mAllPaddingTop;
        public int mCommonPaddingTop;
        public TextView mTitle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleViewHolder(View view2, Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            super(view2, context, 0, bDEmotionBagVerticalLayout);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, context, bDEmotionBagVerticalLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (Context) objArr2[1], ((Integer) objArr2[2]).intValue(), (BDEmotionBagVerticalLayout) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTitle = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0908bb);
            this.mCommonPaddingTop = this.mCtx.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070325);
            this.mAllPaddingTop = this.mCtx.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070323);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.BaseViewHolder
        public void onBindViewHolder(int i, TitleTemplateData titleTemplateData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, titleTemplateData) == null) || titleTemplateData == null) {
                return;
            }
            this.mTitle.setText(titleTemplateData.sectionTitle);
            this.mTitle.setTextColor(this.mCtx.getResources().getColor(R.color.obfuscated_res_0x7f060211));
            int i2 = titleTemplateData.sectionType;
            if (i2 == 0) {
                this.mTitle.setPadding(0, this.mCommonPaddingTop, 0, 0);
            } else if (i2 == 1) {
                this.mTitle.setPadding(0, this.mAllPaddingTop, 0, 0);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDEmotionBagVerticalLayout(Context context) {
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

    private boolean acquireTokenForIconAlpha(ImageView imageView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, this, imageView)) == null) {
            if (this.mAlphaChangingIconSet.containsKey(imageView)) {
                return true;
            }
            if (this.mAlphaChangingIconSet.size() >= 2) {
                return false;
            }
            this.mAlphaChangingIconSet.put(imageView, null);
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableIdleAlphaTemporarily() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || this.mTempEnableIdleAlpha) {
            return;
        }
        this.mTempEnableIdleAlpha = true;
        this.mMainHandler.postDelayed(new Runnable(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BDEmotionBagVerticalLayout this$0;

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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mTempEnableIdleAlpha = false;
                }
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getExpressionName(int i, int i2) {
        InterceptResult invokeII;
        List<ListMetaData> dataList;
        ListMetaData listMetaData;
        int i3;
        DATA data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65557, this, i, i2)) == null) {
            EmotionListAdapter emotionListAdapter = this.mEmotionListAdapter;
            if (emotionListAdapter == null || i < 0 || i2 < 0 || (dataList = emotionListAdapter.getDataList()) == null || dataList.isEmpty()) {
                return null;
            }
            if (i == 0 && 1 < dataList.size()) {
                listMetaData = dataList.get(1);
            } else {
                listMetaData = (i <= 0 || (i3 = (i + 3) - 1) >= dataList.size() - 1) ? null : dataList.get(i3);
            }
            if (listMetaData == null || (data = listMetaData.data) == 0 || ((EmotionTemplateData) data).iconList == null || ((EmotionTemplateData) data).iconList.isEmpty()) {
                return null;
            }
            String str = i2 < ((EmotionTemplateData) listMetaData.data).iconList.size() ? ((EmotionTemplateData) listMetaData.data).iconList.get(i2) : null;
            if (this.mAlphaChangingEmotionSet.contains(str)) {
                return null;
            }
            return str;
        }
        return (String) invokeII.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getIconAlpha(ViewGroup viewGroup, ImageView imageView, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65558, this, viewGroup, imageView, str)) == null) {
            RecyclerView recyclerView = this.mEmotionRecyclerView;
            if (((recyclerView == null || recyclerView.getScrollState() == 0) && !this.mTempEnableIdleAlpha) || this.mDelBtLocRect == null || !acquireTokenForIconAlpha(imageView)) {
                return -1.0f;
            }
            int[] iArr = new int[2];
            imageView.getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + imageView.getWidth(), iArr[1] + imageView.getHeight());
            float dp2px = UIUtils.dp2px(this.mCtx, 10.0f);
            int centerY = rect.centerY() - this.mDelBtLocRect.top;
            if (centerY < (-dp2px)) {
                this.mAlphaChangingEmotionSet.remove(str);
                viewGroup.setEnabled(true);
                releaseTokenForIconAlpha(imageView);
                return 1.0f;
            } else if (centerY < 0) {
                float abs = Math.abs(centerY) / dp2px;
                if (abs > 0.2d) {
                    this.mAlphaChangingEmotionSet.remove(str);
                    viewGroup.setEnabled(true);
                } else {
                    this.mAlphaChangingEmotionSet.add(str);
                    viewGroup.setEnabled(false);
                }
                return abs;
            } else {
                this.mAlphaChangingEmotionSet.add(str);
                viewGroup.setEnabled(false);
                return 0.0f;
            }
        }
        return invokeLLL.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getIconRowAndColIndex(float f, float f2) {
        InterceptResult invokeCommon;
        RecyclerView recyclerView;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (sExpressionWidthWithPadding == 0 || (recyclerView = this.mEmotionRecyclerView) == null) {
                return null;
            }
            recyclerView.getLocationOnScreen(new int[2]);
            float f3 = f2 - iArr[1];
            int[] iArr2 = new int[2];
            if (r6 < 0) {
                r6 = -1;
            }
            iArr2[0] = r6;
            if (r5 >= 7) {
                r5 = -1;
            }
            iArr2[1] = r5;
            return iArr2;
        }
        return (int[]) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PopupEmotionManager getPopupEmotionManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) ? this.mPopupEmotionManager : (PopupEmotionManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getValidLongPressedRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            RectF rectF = this.mValidLongPressedRect;
            if (rectF != null) {
                return rectF;
            }
            RecyclerView recyclerView = this.mEmotionRecyclerView;
            if (recyclerView == null || !recyclerView.isLaidOut()) {
                return null;
            }
            int[] iArr = new int[2];
            this.mEmotionRecyclerView.getLocationOnScreen(iArr);
            RectF rectF2 = new RectF(iArr[0], iArr[1], iArr[0] + this.mEmotionRecyclerView.getWidth(), iArr[1] + this.mEmotionRecyclerView.getHeight());
            this.mValidLongPressedRect = rectF2;
            return rectF2;
        }
        return (RectF) invokeV.objValue;
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, context) == null) {
            this.mCtx = context;
            int i = context.getResources().getConfiguration().orientation;
            if (i == 1) {
                setPadding(0, 0, 0, 0);
            } else if (i == 2) {
                int dimensionPixelSize = this.mCtx.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070960);
                setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            sExprTotalExtraHeight = (this.mCtx.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070329) * 2) + this.mCtx.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070325) + this.mCtx.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070323);
            sExpressionHeightWithPadding = this.mCtx.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070328);
            sExprCrossSectionFixedHeight = this.mCtx.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070326);
            PopupEmotionManager popupEmotionManager = new PopupEmotionManager(this.mCtx);
            this.mPopupEmotionManager = popupEmotionManager;
            popupEmotionManager.setShowListener(GlobalOnItemClickListenerManager.getInstance().getPopupEmotionShowListener());
            if (BDEmotionPanelManager.getInstance().isNightMode()) {
                setBackgroundColor(NIGHT_COLOR_EMOTION_BAG);
            } else {
                setBackgroundColor(COLOR_EMOTION_BAG);
            }
            LayoutInflater.from(this.mCtx).inflate(R.layout.obfuscated_res_0x7f0d0277, this);
            this.mViewPager = (ViewPager) findViewById(R.id.obfuscated_res_0x7f0923b2);
            this.mIndicator = (CircleIndicator) findViewById(R.id.obfuscated_res_0x7f090eee);
            ArrayList arrayList = new ArrayList();
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mCtx).inflate(R.layout.obfuscated_res_0x7f0d0276, (ViewGroup) this, false);
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090777);
            this.mDelBtn = imageView;
            imageView.setImageDrawable(this.mCtx.getResources().getDrawable(R.drawable.emotion_delete));
            this.mDelBtn.setBackground(this.mCtx.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0804ba));
            this.mDelBtn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBagVerticalLayout this$0;

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

                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        this.this$0.mDelBtn.getViewTreeObserver().removeOnPreDrawListener(this);
                        int[] iArr = new int[2];
                        this.this$0.mDelBtn.getLocationOnScreen(iArr);
                        this.this$0.mDelBtLocRect = new Rect(iArr[0], iArr[1], iArr[0] + this.this$0.mDelBtn.getWidth(), iArr[1] + this.this$0.mDelBtn.getHeight());
                        this.this$0.mDelBtn.setEnabled(!GlobalOnItemClickListenerManager.getInstance().isEditContentEmpty());
                        this.this$0.mDelBtn.setImageAlpha(this.this$0.mDelBtn.isEnabled() ? 255 : 102);
                        return true;
                    }
                    return invokeV.booleanValue;
                }
            });
            this.mDelBtn.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBagVerticalLayout this$0;

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
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        GlobalOnItemClickListenerManager.getInstance().performVerticalDelClick();
                    }
                }
            });
            this.mDelBtn.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBagVerticalLayout this$0;

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

                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, view2)) == null) {
                        GlobalOnItemClickListenerManager.getInstance().performDelLongClick();
                        return false;
                    }
                    return invokeL.booleanValue;
                }
            });
            this.mDelBtn.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBagVerticalLayout this$0;

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

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            this.this$0.mDelBtn.setImageAlpha(51);
                            return false;
                        } else if (action == 1 || action == 3) {
                            this.this$0.mDelBtn.setImageAlpha(255);
                            GlobalOnItemClickListenerManager.getInstance().removeLongClickCallback();
                            this.this$0.mDelBtn.setEnabled(!GlobalOnItemClickListenerManager.getInstance().isEditContentEmpty());
                            this.this$0.mDelBtn.setImageAlpha(this.this$0.mDelBtn.isEnabled() ? 255 : 102);
                            return false;
                        } else {
                            return false;
                        }
                    }
                    return invokeLL.booleanValue;
                }
            });
            GlobalOnItemClickListenerManager.getInstance().setEditContentTextWatcher(new TextWatcher(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBagVerticalLayout this$0;

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

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) || GlobalOnItemClickListenerManager.getInstance().isDelLongClick()) {
                        return;
                    }
                    this.this$0.mDelBtn.setEnabled(editable.length() > 0);
                    this.this$0.mDelBtn.setImageAlpha(this.this$0.mDelBtn.isEnabled() ? 255 : 102);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            this.mEmotionRecyclerView = (RecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091a17);
            OffsetLinearLayoutManager offsetLinearLayoutManager = new OffsetLinearLayoutManager(this.mCtx);
            this.mLayoutManager = offsetLinearLayoutManager;
            this.mEmotionRecyclerView.setLayoutManager(offsetLinearLayoutManager);
            EmotionListAdapter emotionListAdapter = new EmotionListAdapter(this.mCtx, this);
            this.mEmotionListAdapter = emotionListAdapter;
            this.mEmotionRecyclerView.setAdapter(emotionListAdapter);
            this.mEmotionRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBagVerticalLayout this$0;

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

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i2) == null) {
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                        GlobalOnItemClickListenerManager.getInstance().removeLongClickCallback();
                        if (this.this$0.mPopupEmotionManager != null && this.this$0.mPopupEmotionManager.isShowing()) {
                            this.this$0.mPopupEmotionManager.dismiss();
                        }
                        this.this$0.mCurrentScrollY += i3;
                        if (Math.abs(this.this$0.mCurrentScrollY) >= BDEmotionBagVerticalLayout.sExpressionHeightWithPadding) {
                            this.this$0.mCurrentScrollY = 0;
                            GlobalOnItemClickListenerManager.getInstance().addEmotionShownSlideCount();
                        }
                        this.this$0.enableIdleAlphaTemporarily();
                    }
                }
            });
            arrayList.add(viewGroup);
            EmotionPagerAdapter emotionPagerAdapter = new EmotionPagerAdapter(this, arrayList);
            this.mPagerAdapter = emotionPagerAdapter;
            this.mViewPager.setAdapter(emotionPagerAdapter);
            this.mIndicator.setViewPager(this.mViewPager);
            if (arrayList.size() <= 1) {
                this.mIndicator.setVisibility(8);
            }
        }
    }

    private void releaseTokenForIconAlpha(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, imageView) == null) {
            this.mAlphaChangingIconSet.remove(imageView);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view2, int i) {
        List<ListMetaData> dataList;
        ListMetaData listMetaData;
        DATA data;
        PopupEmotionManager popupEmotionManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            if (view2.getClass() == SPSwitchPanelLinearLayout.class || view2.getClass() == BDEmotionBagVerticalLayout.class) {
                if (i == 0) {
                    enableIdleAlphaTemporarily();
                    GlobalOnItemClickListenerManager.getInstance().resetEmotionShownData();
                }
                EmotionListAdapter emotionListAdapter = this.mEmotionListAdapter;
                if (emotionListAdapter == null || (dataList = emotionListAdapter.getDataList()) == null || dataList.isEmpty() || 1 >= dataList.size() || (listMetaData = dataList.get(1)) == null || (data = listMetaData.data) == 0) {
                    return;
                }
                ((EmotionTemplateData) data).iconList = EmotionUtils.getInstance().getPanelOftenEmotionList();
                this.mEmotionListAdapter.notifyDataSetChanged();
            }
            if (i == 0 || (popupEmotionManager = this.mPopupEmotionManager) == null || !popupEmotionManager.isShowing()) {
                return;
            }
            this.mPopupEmotionManager.dismiss();
        }
    }

    public void setEmotionList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            TitleTemplateData titleTemplateData = new TitleTemplateData();
            titleTemplateData.sectionType = 0;
            titleTemplateData.sectionTitle = EmotionUtils.getInstance().getOftenZoneTitle();
            arrayList.add(new ListMetaData(0, titleTemplateData));
            EmotionTemplateData emotionTemplateData = new EmotionTemplateData();
            emotionTemplateData.iconList = EmotionUtils.getInstance().getPanelOftenEmotionList();
            emotionTemplateData.rowIndex = 0;
            emotionTemplateData.rowCount = 1;
            emotionTemplateData.sectionType = 0;
            arrayList.add(new ListMetaData(1, emotionTemplateData));
            TitleTemplateData titleTemplateData2 = new TitleTemplateData();
            titleTemplateData2.sectionType = 1;
            titleTemplateData2.sectionTitle = EmotionUtils.getInstance().getAllZoneTitle();
            arrayList.add(new ListMetaData(0, titleTemplateData2));
            if (list != null) {
                int size = (list.size() / 7) + 1;
                int i = 1;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (i2 % 7 == 0) {
                        emotionTemplateData = new EmotionTemplateData();
                        emotionTemplateData.sectionType = 1;
                        emotionTemplateData.rowIndex = i;
                        emotionTemplateData.rowCount = size;
                        emotionTemplateData.iconList = new ArrayList();
                        arrayList.add(new ListMetaData(1, emotionTemplateData));
                        i++;
                    }
                    emotionTemplateData.iconList.add(list.get(i2));
                }
            }
            arrayList.add(new ListMetaData(2, new PaddingTemplateData()));
            this.mEmotionListAdapter.setData(arrayList);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDEmotionBagVerticalLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDEmotionBagVerticalLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.mAlphaChangingIconSet = new WeakHashMap();
        this.mAlphaChangingEmotionSet = new HashSet();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        init(context);
    }
}

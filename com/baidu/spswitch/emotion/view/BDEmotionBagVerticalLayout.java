package com.baidu.spswitch.emotion.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
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
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.emotion.view.PopupEmotionManager;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.SPConfig;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class BDEmotionBagVerticalLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float DEL_BTN_ALPHA_DISABLED = 0.4f;
    public static final float DEL_BTN_ALPHA_ENABLED = 1.0f;
    public static final int DEL_BTN_ALPHA_INT_DISABLED = 102;
    public static final int DEL_BTN_ALPHA_INT_ENABLED = 255;
    public static final int DEL_BTN_ALPHA_INT_PRESSED = 51;
    public static final float DEL_BTN_ALPHA_PRESSED = 0.2f;
    public static final int EMOTION_COLUMNS = 7;
    public static final int EXPRESSION_ALL_META_BASE_IDX = 3;
    public static final int EXPRESSION_COMMON_META_IDX = 1;
    public static final int FIXED_EMOTION_COLUMNS = 4;
    public static final int ITEM_TYPE_EMOTION = 1;
    public static final int ITEM_TYPE_PADDING = 2;
    public static final int ITEM_TYPE_TITLE = 0;
    public static final int SECTION_ALL = 1;
    public static final int SECTION_COMMON = 0;
    public static final String TAG = "BDEmotionBagVertical";
    public static int sExprCrossSectionFixedHeight;
    public static int sExprTotalExtraHeight;
    public static int sExpressionHeightWithPadding;
    public static int sExpressionWidthWithPadding;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> mAlphaChangingEmotionSet;
    public Context mCtx;
    public int mCurrentScrollY;
    public ImageView mDelBtn;
    public ViewGroup mEditArea;
    public Rect mEditAreaLocRect;
    public boolean mEditAreaParamsHasInit;
    public EmotionListAdapter mEmotionListAdapter;
    public RecyclerView mEmotionRecyclerView;
    public OffsetLinearLayoutManager mLayoutManager;
    public Handler mMainHandler;
    public PopupEmotionManager mPopupEmotionManager;
    public TextView mSendBtn;
    public boolean mTempEnableIdleAlpha;
    public RectF mValidLongPressedRect;

    /* loaded from: classes4.dex */
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

        /* loaded from: classes4.dex */
        public interface LongClickCallback {
            void onLongClick(View view2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        /* loaded from: classes4.dex */
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

        public void setData(EmotionTemplateData emotionTemplateData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, emotionTemplateData) == null) && emotionTemplateData != null) {
                this.mList = emotionTemplateData.iconList;
                this.mRowIndex = emotionTemplateData.rowIndex;
                this.mRowCount = emotionTemplateData.rowCount;
                this.mRowType = emotionTemplateData.sectionType;
                notifyDataSetChanged();
            }
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

        private void processAlpha(ViewGroup viewGroup, ImageView imageView, String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TRACKBALL, this, viewGroup, imageView, str, i) != null) || i < 4 || this.mRowType != 1) {
                return;
            }
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

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                List<String> list = this.mList;
                if (list != null && !list.isEmpty()) {
                    return this.mList.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                List<String> list = this.mList;
                if (list != null && !list.isEmpty()) {
                    return this.mList.get(i);
                }
                return "";
            }
            return (String) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            FrameLayout frameLayout;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    frameLayout = (FrameLayout) this.mInflater.inflate(R.layout.emotion_vertical_grid_item, viewGroup, false);
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
                        if ((interceptable2 != null && interceptable2.invokeL(1048576, this, view3) != null) || !view3.isEnabled()) {
                            return;
                        }
                        GlobalOnItemClickListenerManager.getInstance().verticalOnItemClick(this.this$0.getItem(this.val$position), this.this$0.mStatisticData, this.val$position);
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
                            if (!view3.isEnabled()) {
                                return false;
                            }
                            if (this.this$0.mLongClickCallback != null) {
                                this.this$0.mLongClickCallback.onLongClick(view3);
                            }
                            if (this.this$0.mVerticalLayout != null && this.this$0.mVerticalLayout.getPopupEmotionManager() != null) {
                                this.this$0.mVerticalLayout.getPopupEmotionManager().reset();
                                return true;
                            }
                            return true;
                        }
                        return invokeL.booleanValue;
                    }
                });
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) frameLayout.findViewById(R.id.img_item);
                processAlpha(frameLayout, simpleDraweeView, this.mList.get(i), i);
                String emotionUriByName = EmotionUtils.getInstance().getEmotionUriByName(EmotionType.EMOTION_CLASSIC_TYPE, this.mList.get(i));
                if (!TextUtils.isEmpty(emotionUriByName)) {
                    simpleDraweeView.setImageURI(emotionUriByName);
                }
                return frameLayout;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class BaseViewHolder<DATA> extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mCtx;
        public int mItemType;
        public BDEmotionBagVerticalLayout mVerticalLayout;

        public abstract void onBindViewHolder(int i, DATA data);

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
                        view2.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.expression_bottom_padding_height)));
                        return new PaddingViewHolder(view2, context, bDEmotionBagVerticalLayout);
                    }
                    return new EmotionViewHolder(from.inflate(R.layout.emotion_vertical_panel_icon, viewGroup, false), context, bDEmotionBagVerticalLayout);
                }
                return new TitleViewHolder(from.inflate(R.layout.emotion_vertical_panel_title, viewGroup, false), context, bDEmotionBagVerticalLayout);
            }
            return (BaseViewHolder) invokeLILL.objValue;
        }

        public int getItemType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mItemType;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
            List<ListMetaData> list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048580, this, baseViewHolder, i) == null) && (list = this.mDataList) != null && !list.isEmpty() && this.mDataList.get(i).itemType == baseViewHolder.getItemType()) {
                baseViewHolder.onBindViewHolder(i, this.mDataList.get(i).data);
            }
        }

        public List<ListMetaData> getDataList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mDataList;
            }
            return (List) invokeV.objValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<ListMetaData> list = this.mDataList;
                if (list != null && !list.isEmpty()) {
                    return this.mDataList.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                List<ListMetaData> list = this.mDataList;
                if (list != null && !list.isEmpty()) {
                    return this.mDataList.get(i).itemType;
                }
                return -1;
            }
            return invokeI.intValue;
        }

        public void setData(List<ListMetaData> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && list != null && !list.isEmpty()) {
                this.mDataList.clear();
                this.mDataList.addAll(list);
                notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
                return BaseViewHolder.createViewHolder(viewGroup, i, this.mCtx, this.mVerticalLayout);
            }
            return (BaseViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            GridView gridView = (GridView) view2.findViewById(R.id.icon_list);
            this.mIconGridList = gridView;
            gridView.setSelector(new ColorDrawable(0));
            this.mIconGridList.setNumColumns(7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean releaseLongPressedIfNecessary(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, view2, motionEvent)) == null) {
                if (!this.mIsLongPressed) {
                    return false;
                }
                this.mIsLongPressed = false;
                this.mIsAnchorInited = false;
                this.mIconGridList.requestDisallowInterceptTouchEvent(false);
                dismissLongPressedIfNecessary();
                motionEvent.setAction(3);
                view2.dispatchTouchEvent(motionEvent);
                return true;
            }
            return invokeLL.booleanValue;
        }

        private void dismissLongPressedIfNecessary() {
            BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65547, this) == null) && (bDEmotionBagVerticalLayout = this.mVerticalLayout) != null && bDEmotionBagVerticalLayout.getPopupEmotionManager() != null) {
                this.mVerticalLayout.getPopupEmotionManager().dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showLongPressedIfNecessary(float f, float f2, EmotionTemplateData emotionTemplateData) {
            BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout;
            int[] iconRowAndColIndex;
            int[] iArr;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), emotionTemplateData}) == null) && (bDEmotionBagVerticalLayout = this.mVerticalLayout) != null && bDEmotionBagVerticalLayout.getPopupEmotionManager() != null && this.mIsLongPressed) {
                RectF validLongPressedRect = this.mVerticalLayout.getValidLongPressedRect();
                if ((validLongPressedRect != null && !validLongPressedRect.contains((int) f, (int) f2)) || this.mVerticalLayout.getPopupEmotionManager().isPostRunning()) {
                    return;
                }
                if (this.mIsAnchorInited) {
                    iconRowAndColIndex = this.mVerticalLayout.getIconRowAndColIndex(f, f2);
                    int i2 = iconRowAndColIndex[0];
                    int[] iArr2 = this.mAnchorRowColBase;
                    iArr = new int[]{i2 - iArr2[0], iconRowAndColIndex[1] - iArr2[1]};
                } else {
                    this.mIsAnchorInited = true;
                    int[] iArr3 = new int[2];
                    this.mAnchorLocationBase = iArr3;
                    this.mPressedView.getLocationOnScreen(iArr3);
                    iconRowAndColIndex = this.mVerticalLayout.getIconRowAndColIndex(f, f2);
                    this.mAnchorRowColBase = iconRowAndColIndex;
                    iArr = new int[]{0, 0};
                }
                if (iconRowAndColIndex[0] >= 0 && iconRowAndColIndex[1] >= 0) {
                    String expressionName = this.mVerticalLayout.getExpressionName(iconRowAndColIndex[0], iconRowAndColIndex[1]);
                    if (TextUtils.isEmpty(expressionName)) {
                        return;
                    }
                    if (DeviceUtils.ScreenInfo.isScreenLand()) {
                        Rect rect = new Rect();
                        this.mPressedView.getGlobalVisibleRect(rect);
                        this.mAnchorLocationBase[0] = rect.left;
                    }
                    PopupEmotionManager.ShowParam showParam = new PopupEmotionManager.ShowParam();
                    if (emotionTemplateData != null) {
                        i = emotionTemplateData.sectionType;
                    } else {
                        i = -1;
                    }
                    showParam.sectionType = i;
                    showParam.exprRow = iconRowAndColIndex[0];
                    showParam.exprCol = iconRowAndColIndex[1];
                    showParam.anchorWidth = this.mPressedView.getWidth();
                    showParam.anchorXpos = this.mAnchorLocationBase[0] + (iArr[1] * BDEmotionBagVerticalLayout.sExpressionWidthWithPadding);
                    int i3 = this.mAnchorLocationBase[1] + (iArr[0] * BDEmotionBagVerticalLayout.sExpressionHeightWithPadding);
                    showParam.anchorYpos = i3;
                    if (iconRowAndColIndex[0] == 0 && this.mAnchorRowColBase[0] > 0) {
                        showParam.anchorYpos = i3 - BDEmotionBagVerticalLayout.sExprCrossSectionFixedHeight;
                    } else if (iconRowAndColIndex[0] > 0 && this.mAnchorRowColBase[0] == 0) {
                        showParam.anchorYpos += BDEmotionBagVerticalLayout.sExprCrossSectionFixedHeight;
                    }
                    showParam.exprName = expressionName;
                    showParam.exprBitmap = EmotionUtils.getInstance().getEmotionBitmapByName(EmotionType.EMOTION_CLASSIC_TYPE, showParam.exprName);
                    this.mVerticalLayout.getPopupEmotionManager().show(showParam);
                }
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
                            if (action != 0) {
                                if (action != 1) {
                                    if (action != 2) {
                                        if (action == 5 || action == 6) {
                                            this.this$0.mValidTouch = false;
                                        }
                                    } else if (this.this$0.mValidTouch && this.this$0.mActivePointerId == pointerId && this.this$0.mIsLongPressed) {
                                        this.this$0.showLongPressedIfNecessary(motionEvent.getRawX(), motionEvent.getRawY(), this.val$data);
                                        return true;
                                    }
                                } else {
                                    return this.this$0.releaseLongPressedIfNecessary(view2, motionEvent);
                                }
                            } else {
                                this.this$0.mActivePointerId = pointerId;
                                this.this$0.mValidTouch = true;
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
                        if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                            return;
                        }
                        this.this$0.mIsLongPressed = true;
                        this.this$0.mPressedView = view2;
                        this.this$0.mIconGridList.requestDisallowInterceptTouchEvent(true);
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition < getItemCount()) {
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
                return paddingTop;
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static class PaddingViewHolder extends BaseViewHolder<PaddingTemplateData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.BaseViewHolder
        public void onBindViewHolder(int i, PaddingTemplateData paddingTemplateData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, paddingTemplateData) == null) {
            }
        }

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
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            this.mTitle = (TextView) view2.findViewById(R.id.emotion_title);
            this.mCommonPaddingTop = this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_common_title_padding_top);
            this.mAllPaddingTop = this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_all_title_padding_top);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.BaseViewHolder
        public void onBindViewHolder(int i, TitleTemplateData titleTemplateData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, titleTemplateData) == null) && titleTemplateData != null) {
                this.mTitle.setText(titleTemplateData.sectionTitle);
                this.mTitle.setTextColor(this.mCtx.getResources().getColor(R.color.emotion_vertical_section_title));
                int i2 = titleTemplateData.sectionType;
                if (i2 == 0) {
                    this.mTitle.setPadding(0, this.mCommonPaddingTop, 0, 0);
                } else if (i2 == 1) {
                    this.mTitle.setPadding(0, this.mAllPaddingTop, 0, 0);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDEmotionBagVerticalLayout(Context context) {
        this(context, (AttributeSet) null);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViewEnabled(View view2, boolean z) {
        int color;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65566, this, view2, z) != null) || view2 == null) {
            return;
        }
        view2.setEnabled(z);
        if (view2 instanceof ImageView) {
            ImageView imageView = (ImageView) view2;
            if (view2.isEnabled()) {
                i = 255;
            } else {
                i = 102;
            }
            imageView.setImageAlpha(i);
        } else if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            if (view2.isEnabled()) {
                color = ContextCompat.getColor(AppRuntime.getAppContext(), R.color.obfuscated_res_0x7f060223);
            } else {
                color = ContextCompat.getColor(AppRuntime.getAppContext(), R.color.obfuscated_res_0x7f060218);
            }
            textView.setTextColor(color);
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
        this.mEditAreaParamsHasInit = false;
        this.mAlphaChangingEmotionSet = new HashSet();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        init(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDEmotionBagVerticalLayout(Context context, BDEmotionPanelManager.EmotionPanelConfig emotionPanelConfig) {
        super(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, emotionPanelConfig};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mEditAreaParamsHasInit = false;
        this.mAlphaChangingEmotionSet = new HashSet();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        init(context, emotionPanelConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableIdleAlphaTemporarily() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65558, this) != null) || this.mTempEnableIdleAlpha) {
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
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                this.this$0.mTempEnableIdleAlpha = false;
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PopupEmotionManager getPopupEmotionManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            return this.mPopupEmotionManager;
        }
        return (PopupEmotionManager) invokeV.objValue;
    }

    public static /* synthetic */ int access$412(BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout, int i) {
        int i2 = bDEmotionBagVerticalLayout.mCurrentScrollY + i;
        bDEmotionBagVerticalLayout.mCurrentScrollY = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getExpressionName(int i, int i2) {
        InterceptResult invokeII;
        List<ListMetaData> dataList;
        ListMetaData listMetaData;
        int i3;
        DATA data;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65559, this, i, i2)) == null) {
            EmotionListAdapter emotionListAdapter = this.mEmotionListAdapter;
            if (emotionListAdapter == null || i < 0 || i2 < 0 || (dataList = emotionListAdapter.getDataList()) == null || dataList.isEmpty()) {
                return null;
            }
            if (i == 0 && 1 < dataList.size()) {
                listMetaData = dataList.get(1);
            } else if (i > 0 && (i3 = (i + 3) - 1) < dataList.size() - 1) {
                listMetaData = dataList.get(i3);
            } else {
                listMetaData = null;
            }
            if (listMetaData == null || (data = listMetaData.data) == 0 || ((EmotionTemplateData) data).iconList == null || ((EmotionTemplateData) data).iconList.isEmpty()) {
                return null;
            }
            if (i2 < ((EmotionTemplateData) listMetaData.data).iconList.size()) {
                str = ((EmotionTemplateData) listMetaData.data).iconList.get(i2);
            } else {
                str = null;
            }
            if (this.mAlphaChangingEmotionSet.contains(str)) {
                return null;
            }
            return str;
        }
        return (String) invokeII.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getIconRowAndColIndex(float f, float f2) {
        InterceptResult invokeCommon;
        RecyclerView recyclerView;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (sExpressionWidthWithPadding != 0 && (recyclerView = this.mEmotionRecyclerView) != null) {
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
            return null;
        }
        return (int[]) invokeCommon.objValue;
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
                if (emotionListAdapter != null && (dataList = emotionListAdapter.getDataList()) != null && !dataList.isEmpty() && 1 < dataList.size() && (listMetaData = dataList.get(1)) != null && (data = listMetaData.data) != 0) {
                    ((EmotionTemplateData) data).iconList = EmotionUtils.getInstance().getPanelOftenEmotionList();
                    this.mEmotionListAdapter.notifyDataSetChanged();
                } else {
                    return;
                }
            }
            if (i != 0 && (popupEmotionManager = this.mPopupEmotionManager) != null && popupEmotionManager.isShowing()) {
                this.mPopupEmotionManager.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getIconAlpha(ViewGroup viewGroup, ImageView imageView, String str) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65560, this, viewGroup, imageView, str)) == null) {
            RecyclerView recyclerView = this.mEmotionRecyclerView;
            if ((recyclerView == null || recyclerView.getScrollState() == 0) && !this.mTempEnableIdleAlpha) {
                return -1.0f;
            }
            initEditAreaParamsIfNeed();
            if (this.mEditAreaLocRect == null) {
                return -1.0f;
            }
            int[] iArr = new int[2];
            imageView.getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + imageView.getWidth(), iArr[1] + imageView.getHeight());
            if (rect.centerX() >= this.mEditAreaLocRect.left && rect.centerX() <= this.mEditAreaLocRect.right) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return -1.0f;
            }
            float height = (rect.height() / 2.0f) + (this.mEditAreaLocRect.height() / 2.0f);
            int abs = Math.abs(rect.centerY() - this.mEditAreaLocRect.centerY());
            if (SPConfig.isDebug()) {
                Log.d(TAG, "iconRect.centerY() = " + rect.centerY() + "; mEditAreaLocRect.centerY = " + this.mEditAreaLocRect.centerY() + "; distance = " + abs + "; threshold = " + height);
            }
            float f = abs;
            if (f >= height) {
                this.mAlphaChangingEmotionSet.remove(str);
                viewGroup.setEnabled(true);
                return 1.0f;
            } else if (f > this.mEditAreaLocRect.height() / 2.0f) {
                float height2 = (f - (this.mEditAreaLocRect.height() / 2.0f)) / (rect.height() / 2.0f);
                if (height2 > 0.2d) {
                    this.mAlphaChangingEmotionSet.remove(str);
                    viewGroup.setEnabled(true);
                } else {
                    this.mAlphaChangingEmotionSet.add(str);
                    viewGroup.setEnabled(false);
                }
                return height2;
            } else {
                this.mAlphaChangingEmotionSet.add(str);
                viewGroup.setEnabled(false);
                return 0.0f;
            }
        }
        return invokeLLL.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getValidLongPressedRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            RectF rectF = this.mValidLongPressedRect;
            if (rectF != null) {
                return rectF;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                RecyclerView recyclerView = this.mEmotionRecyclerView;
                if (recyclerView == null || !recyclerView.isLaidOut()) {
                    return null;
                }
            } else if (this.mEmotionRecyclerView == null) {
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

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(Context context, BDEmotionPanelManager.EmotionPanelConfig emotionPanelConfig) {
        Drawable drawable;
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, this, context, emotionPanelConfig) == null) {
            this.mCtx = context;
            int i = context.getResources().getConfiguration().orientation;
            if (i == 1) {
                setPadding(0, 0, 0, 0);
            } else if (i == 2) {
                int dimensionPixelSize = this.mCtx.getResources().getDimensionPixelSize(R.dimen.window_horizontal_padding);
                setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            sExprTotalExtraHeight = (this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_title_size) * 2) + this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_common_title_padding_top) + this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_all_title_padding_top);
            sExpressionHeightWithPadding = this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_row_height);
            sExprCrossSectionFixedHeight = this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_cross_section_fixed_height);
            PopupEmotionManager popupEmotionManager = new PopupEmotionManager(this.mCtx);
            this.mPopupEmotionManager = popupEmotionManager;
            popupEmotionManager.setShowListener(GlobalOnItemClickListenerManager.getInstance().getPopupEmotionShowListener());
            if (emotionPanelConfig != null && (drawable2 = emotionPanelConfig.backgroundDrawable) != null) {
                setBackground(drawable2);
            } else {
                setBackgroundColor(ContextCompat.getColor(this.mCtx, R.color.obfuscated_res_0x7f06026b));
            }
            LayoutInflater.from(this.mCtx).inflate(R.layout.emotion_vertical_panel_page1_root, this);
            this.mDelBtn = (ImageView) findViewById(R.id.delete_btn);
            ContextCompat.getColor(this.mCtx, R.color.obfuscated_res_0x7f060238);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(AppRuntime.getAppContext().getResources().getDimension(R.dimen.emotion_panel_del_btn_radius));
            gradientDrawable.setStroke(AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.emotion_panel_del_btn_stroke), ContextCompat.getColor(this.mCtx, R.color.obfuscated_res_0x7f060213));
            if (emotionPanelConfig != null) {
                gradientDrawable.setColor(emotionPanelConfig.delBtnColor);
            } else {
                gradientDrawable.setColor(ContextCompat.getColor(this.mCtx, R.color.obfuscated_res_0x7f06026b));
            }
            if (emotionPanelConfig != null && (drawable = emotionPanelConfig.delBtnDrawable) != null) {
                this.mDelBtn.setImageDrawable(drawable);
            } else {
                this.mDelBtn.setImageDrawable(ContextCompat.getDrawable(AppRuntime.getAppContext(), R.drawable.emotion_delete));
            }
            this.mDelBtn.setBackground(gradientDrawable);
            this.mDelBtn.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.1
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
            this.mDelBtn.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.2
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
            this.mDelBtn.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.3
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
                        if (action != 0) {
                            if (action == 1 || action == 3) {
                                this.this$0.mDelBtn.setImageAlpha(255);
                                GlobalOnItemClickListenerManager.getInstance().removeLongClickCallback();
                                boolean isEditContentEmpty = GlobalOnItemClickListenerManager.getInstance().isEditContentEmpty();
                                BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout = this.this$0;
                                bDEmotionBagVerticalLayout.updateViewEnabled(bDEmotionBagVerticalLayout.mDelBtn, !isEditContentEmpty);
                                return false;
                            }
                            return false;
                        }
                        this.this$0.mDelBtn.setImageAlpha(51);
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            GlobalOnItemClickListenerManager.getInstance().addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBagVerticalLayout this$0;

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

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
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) && !GlobalOnItemClickListenerManager.getInstance().isDelLongClick() && editable != null) {
                        BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout = this.this$0;
                        ImageView imageView = bDEmotionBagVerticalLayout.mDelBtn;
                        if (editable.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        bDEmotionBagVerticalLayout.updateViewEnabled(imageView, z);
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                        boolean isSendEnabled = GlobalOnItemClickListenerManager.getInstance().isSendEnabled();
                        BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout = this.this$0;
                        bDEmotionBagVerticalLayout.updateViewEnabled(bDEmotionBagVerticalLayout.mSendBtn, isSendEnabled);
                    }
                }
            });
            this.mEditArea = (ViewGroup) findViewById(R.id.edit_area);
            TextView textView = (TextView) findViewById(R.id.send_btn);
            this.mSendBtn = textView;
            textView.setBackground(ResourcesCompat.getDrawable(AppRuntime.getAppContext().getResources(), R.drawable.emotion_panel_send_bg, null));
            this.mSendBtn.setTextColor(ContextCompat.getColor(context, R.color.obfuscated_res_0x7f060223));
            this.mSendBtn.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.5
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
                        GlobalOnItemClickListenerManager.getInstance().performVerticalSendClick();
                    }
                }
            });
            if (emotionPanelConfig != null && emotionPanelConfig.showSendBtn) {
                this.mSendBtn.setVisibility(0);
            } else {
                this.mSendBtn.setVisibility(8);
            }
            this.mEmotionRecyclerView = (RecyclerView) findViewById(R.id.recycler_list);
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

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i2) == null) {
                    }
                }

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
                public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                        GlobalOnItemClickListenerManager.getInstance().removeLongClickCallback();
                        if (this.this$0.mPopupEmotionManager != null && this.this$0.mPopupEmotionManager.isShowing()) {
                            this.this$0.mPopupEmotionManager.dismiss();
                        }
                        BDEmotionBagVerticalLayout.access$412(this.this$0, i3);
                        if (Math.abs(this.this$0.mCurrentScrollY) >= BDEmotionBagVerticalLayout.sExpressionHeightWithPadding) {
                            this.this$0.mCurrentScrollY = 0;
                            GlobalOnItemClickListenerManager.getInstance().addEmotionShownSlideCount();
                        }
                        this.this$0.enableIdleAlphaTemporarily();
                    }
                }
            });
        }
    }

    private void initEditAreaParamsIfNeed() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65565, this) != null) || this.mDelBtn == null || this.mSendBtn == null || (viewGroup = this.mEditArea) == null || this.mEditAreaParamsHasInit) {
            return;
        }
        this.mEditAreaParamsHasInit = true;
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        this.mEditAreaLocRect = new Rect(iArr[0], iArr[1], iArr[0] + this.mEditArea.getWidth(), iArr[1] + this.mEditArea.getHeight());
        updateViewEnabled(this.mDelBtn, !GlobalOnItemClickListenerManager.getInstance().isEditContentEmpty());
        updateViewEnabled(this.mSendBtn, GlobalOnItemClickListenerManager.getInstance().isSendEnabled());
        if (SPConfig.isDebug()) {
            Log.d(TAG, "Emotion delBtn has been initialized, and it`s rect.top is " + this.mEditAreaLocRect.top);
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
}

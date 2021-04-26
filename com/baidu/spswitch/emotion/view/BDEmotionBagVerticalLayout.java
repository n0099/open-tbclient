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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.spswitch.R;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.emotion.view.PopupEmotionManager;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.UIUtils;
import com.baidu.spswitch.view.SPSwitchPanelLinearLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes2.dex */
public class BDEmotionBagVerticalLayout extends FrameLayout {
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
        public Context mCtx;
        public int mItemType;
        public BDEmotionBagVerticalLayout mVerticalLayout;

        public BaseViewHolder(View view, Context context, int i2, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            super(view);
            this.mCtx = context;
            this.mItemType = i2;
            this.mVerticalLayout = bDEmotionBagVerticalLayout;
        }

        public static BaseViewHolder createViewHolder(ViewGroup viewGroup, int i2, Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            LayoutInflater from = LayoutInflater.from(context);
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return null;
                    }
                    View view = new View(context);
                    view.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.expression_bottom_padding_height)));
                    return new PaddingViewHolder(view, context, bDEmotionBagVerticalLayout);
                }
                return new EmotionViewHolder(from.inflate(R.layout.emotion_vertical_panel_icon, viewGroup, false), context, bDEmotionBagVerticalLayout);
            }
            return new TitleViewHolder(from.inflate(R.layout.emotion_vertical_panel_title, viewGroup, false), context, bDEmotionBagVerticalLayout);
        }

        public int getItemType() {
            return this.mItemType;
        }

        public abstract void onBindViewHolder(int i2, DATA data);
    }

    /* loaded from: classes2.dex */
    public static class EmotionGridViewAdapter extends BaseAdapter {
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
            void onLongClick(View view);
        }

        /* loaded from: classes2.dex */
        public static class StatisticData {
            public int rowIndex;
            public int sectionType;
            public EmotionType type;

            public StatisticData(EmotionType emotionType, int i2, int i3) {
                this.type = emotionType;
                this.rowIndex = i2;
                this.sectionType = i3;
            }
        }

        public EmotionGridViewAdapter(Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            this.mInflater = LayoutInflater.from(context);
            this.mContext = context;
            this.mVerticalLayout = bDEmotionBagVerticalLayout;
        }

        private void processAlpha(final ViewGroup viewGroup, final ImageView imageView, final String str, int i2) {
            if (i2 == 6 && this.mRowType == 1) {
                if (imageView.getTag() != null && (imageView.getTag() instanceof ViewTreeObserver.OnPreDrawListener)) {
                    imageView.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) imageView.getTag());
                }
                ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionGridViewAdapter.3
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        if (EmotionGridViewAdapter.this.mVerticalLayout == null) {
                            return true;
                        }
                        float iconAlpha = EmotionGridViewAdapter.this.mVerticalLayout.getIconAlpha(viewGroup, imageView, str);
                        if (iconAlpha >= 0.0f) {
                            imageView.setAlpha(iconAlpha);
                        }
                        return true;
                    }
                };
                imageView.setTag(onPreDrawListener);
                imageView.getViewTreeObserver().addOnPreDrawListener(onPreDrawListener);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> list = this.mList;
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return this.mList.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(final int i2, View view, ViewGroup viewGroup) {
            FrameLayout frameLayout;
            if (view == null) {
                frameLayout = (FrameLayout) this.mInflater.inflate(R.layout.emotion_vertical_grid_item, viewGroup, false);
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                layoutParams.height = BDEmotionBagVerticalLayout.sExpressionHeightWithPadding;
                frameLayout.setLayoutParams(layoutParams);
            } else {
                frameLayout = (FrameLayout) view;
            }
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionGridViewAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2.isEnabled()) {
                        GlobalOnItemClickListenerManager.getInstance().verticalOnItemClick(EmotionGridViewAdapter.this.getItem(i2), EmotionGridViewAdapter.this.mStatisticData, i2);
                    }
                }
            });
            View.OnTouchListener onTouchListener = this.mOnTouchListener;
            if (onTouchListener != null) {
                frameLayout.setOnTouchListener(onTouchListener);
            }
            frameLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionGridViewAdapter.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    if (view2.isEnabled()) {
                        if (EmotionGridViewAdapter.this.mLongClickCallback != null) {
                            EmotionGridViewAdapter.this.mLongClickCallback.onLongClick(view2);
                        }
                        if (EmotionGridViewAdapter.this.mVerticalLayout == null || EmotionGridViewAdapter.this.mVerticalLayout.getPopupEmotionManager() == null) {
                            return true;
                        }
                        EmotionGridViewAdapter.this.mVerticalLayout.getPopupEmotionManager().reset();
                        return true;
                    }
                    return false;
                }
            });
            ImageView imageView = (ImageView) frameLayout.findViewById(R.id.img_item);
            processAlpha(frameLayout, imageView, this.mList.get(i2), i2);
            Bitmap emotionBitmapByName = EmotionUtils.getInstance().getEmotionBitmapByName(EmotionType.EMOTION_CLASSIC_TYPE, this.mList.get(i2));
            if (emotionBitmapByName != null) {
                imageView.setImageBitmap(emotionBitmapByName);
            }
            return frameLayout;
        }

        public void setData(EmotionTemplateData emotionTemplateData) {
            if (emotionTemplateData != null) {
                this.mList = emotionTemplateData.iconList;
                this.mRowIndex = emotionTemplateData.rowIndex;
                this.mRowCount = emotionTemplateData.rowCount;
                this.mRowType = emotionTemplateData.sectionType;
                notifyDataSetChanged();
            }
        }

        public void setLongClickCallback(LongClickCallback longClickCallback) {
            this.mLongClickCallback = longClickCallback;
        }

        public void setOnTouchListener(View.OnTouchListener onTouchListener) {
            this.mOnTouchListener = onTouchListener;
        }

        public void setStatisticData(StatisticData statisticData) {
            this.mStatisticData = statisticData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i2) {
            List<String> list = this.mList;
            return (list == null || list.isEmpty()) ? "" : this.mList.get(i2);
        }
    }

    /* loaded from: classes2.dex */
    public static class EmotionListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
        public Context mCtx;
        public List<ListMetaData> mDataList = new ArrayList();
        public BDEmotionBagVerticalLayout mVerticalLayout;

        public EmotionListAdapter(Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            this.mCtx = context;
            this.mVerticalLayout = bDEmotionBagVerticalLayout;
        }

        public List<ListMetaData> getDataList() {
            return this.mDataList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<ListMetaData> list = this.mDataList;
            if (list == null || list.isEmpty()) {
                return 0;
            }
            return this.mDataList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            List<ListMetaData> list = this.mDataList;
            if (list == null || list.isEmpty()) {
                return -1;
            }
            return this.mDataList.get(i2).itemType;
        }

        public void setData(List<ListMetaData> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            this.mDataList.clear();
            this.mDataList.addAll(list);
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
            List<ListMetaData> list = this.mDataList;
            if (list == null || list.isEmpty() || this.mDataList.get(i2).itemType != baseViewHolder.getItemType()) {
                return;
            }
            baseViewHolder.onBindViewHolder(i2, this.mDataList.get(i2).data);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return BaseViewHolder.createViewHolder(viewGroup, i2, this.mCtx, this.mVerticalLayout);
        }
    }

    /* loaded from: classes2.dex */
    public class EmotionPagerAdapter extends PagerAdapter {
        public List<View> mList;

        public EmotionPagerAdapter(List<View> list) {
            this.mList = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView(this.mList.get(i2));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.mList.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            viewGroup.addView(this.mList.get(i2));
            return this.mList.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: classes2.dex */
    public static class EmotionTemplateData {
        public List<String> iconList;
        public int rowCount;
        public int rowIndex;
        public int sectionType;

        public EmotionTemplateData() {
        }
    }

    /* loaded from: classes2.dex */
    public static class EmotionViewHolder extends BaseViewHolder<EmotionTemplateData> {
        public int mActivePointerId;
        public int[] mAnchorLocationBase;
        public int[] mAnchorRowColBase;
        public EmotionGridViewAdapter mGridViewAdapter;
        public GridView mIconGridList;
        public boolean mIsAnchorInited;
        public boolean mIsLongPressed;
        public View mPressedView;
        public boolean mValidTouch;

        public EmotionViewHolder(View view, Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            super(view, context, 1, bDEmotionBagVerticalLayout);
            this.mCtx = context;
            GridView gridView = (GridView) view.findViewById(R.id.icon_list);
            this.mIconGridList = gridView;
            gridView.setSelector(new ColorDrawable(0));
            this.mIconGridList.setNumColumns(7);
        }

        private void dismissLongPressedIfNecessary() {
            BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout = this.mVerticalLayout;
            if (bDEmotionBagVerticalLayout == null || bDEmotionBagVerticalLayout.getPopupEmotionManager() == null) {
                return;
            }
            this.mVerticalLayout.getPopupEmotionManager().dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean releaseLongPressedIfNecessary(View view, MotionEvent motionEvent) {
            if (this.mIsLongPressed) {
                this.mIsLongPressed = false;
                this.mIsAnchorInited = false;
                this.mIconGridList.requestDisallowInterceptTouchEvent(false);
                dismissLongPressedIfNecessary();
                motionEvent.setAction(3);
                view.dispatchTouchEvent(motionEvent);
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showLongPressedIfNecessary(float f2, float f3, EmotionTemplateData emotionTemplateData) {
            int[] iconRowAndColIndex;
            int[] iArr;
            BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout = this.mVerticalLayout;
            if (bDEmotionBagVerticalLayout == null || bDEmotionBagVerticalLayout.getPopupEmotionManager() == null || !this.mIsLongPressed) {
                return;
            }
            RectF validLongPressedRect = this.mVerticalLayout.getValidLongPressedRect();
            if ((validLongPressedRect == null || validLongPressedRect.contains((int) f2, (int) f3)) && !this.mVerticalLayout.getPopupEmotionManager().isPostRunning()) {
                if (this.mIsAnchorInited) {
                    iconRowAndColIndex = this.mVerticalLayout.getIconRowAndColIndex(f2, f3);
                    int i2 = iconRowAndColIndex[0];
                    int[] iArr2 = this.mAnchorRowColBase;
                    iArr = new int[]{i2 - iArr2[0], iconRowAndColIndex[1] - iArr2[1]};
                } else {
                    this.mIsAnchorInited = true;
                    int[] iArr3 = new int[2];
                    this.mAnchorLocationBase = iArr3;
                    this.mPressedView.getLocationOnScreen(iArr3);
                    iconRowAndColIndex = this.mVerticalLayout.getIconRowAndColIndex(f2, f3);
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.BaseViewHolder
        public void onBindViewHolder(int i2, final EmotionTemplateData emotionTemplateData) {
            EmotionGridViewAdapter emotionGridViewAdapter = new EmotionGridViewAdapter(this.mCtx, this.mVerticalLayout);
            this.mGridViewAdapter = emotionGridViewAdapter;
            emotionGridViewAdapter.setData(emotionTemplateData);
            this.mIconGridList.setAdapter((ListAdapter) this.mGridViewAdapter);
            this.mGridViewAdapter.setStatisticData(new EmotionGridViewAdapter.StatisticData(EmotionType.EMOTION_CLASSIC_TYPE, emotionTemplateData.rowIndex, emotionTemplateData.sectionType));
            this.mGridViewAdapter.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionViewHolder.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        EmotionViewHolder.this.mActivePointerId = pointerId;
                        EmotionViewHolder.this.mValidTouch = true;
                    } else if (action == 1) {
                        return EmotionViewHolder.this.releaseLongPressedIfNecessary(view, motionEvent);
                    } else {
                        if (action != 2) {
                            if (action == 5 || action == 6) {
                                EmotionViewHolder.this.mValidTouch = false;
                            }
                        } else if (EmotionViewHolder.this.mValidTouch && EmotionViewHolder.this.mActivePointerId == pointerId && EmotionViewHolder.this.mIsLongPressed) {
                            EmotionViewHolder.this.showLongPressedIfNecessary(motionEvent.getRawX(), motionEvent.getRawY(), emotionTemplateData);
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.mGridViewAdapter.setLongClickCallback(new EmotionGridViewAdapter.LongClickCallback() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionViewHolder.2
                @Override // com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionGridViewAdapter.LongClickCallback
                public void onLongClick(View view) {
                    EmotionViewHolder.this.mIsLongPressed = true;
                    EmotionViewHolder.this.mPressedView = view;
                    EmotionViewHolder.this.mIconGridList.requestDisallowInterceptTouchEvent(true);
                }
            });
            this.mIconGridList.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.EmotionViewHolder.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    EmotionViewHolder.this.mIconGridList.getViewTreeObserver().removeOnPreDrawListener(this);
                    int unused = BDEmotionBagVerticalLayout.sExpressionWidthWithPadding = EmotionViewHolder.this.mIconGridList.getColumnWidth() + EmotionViewHolder.this.mIconGridList.getHorizontalSpacing();
                    return true;
                }
            });
            if (emotionTemplateData != null) {
                GlobalOnItemClickListenerManager.getInstance().updateEmotionShownMaxRow(emotionTemplateData.rowIndex);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class ListMetaData<DATA> {
        public DATA data;
        public int itemType;

        public ListMetaData(int i2, DATA data) {
            this.itemType = i2;
            this.data = data;
        }
    }

    /* loaded from: classes2.dex */
    public static class OffsetLinearLayoutManager extends LinearLayoutManager {
        public RecyclerView.Recycler mRecycler;

        public OffsetLinearLayoutManager(Context context) {
            super(context);
        }

        public int getScrollY() {
            int paddingTop = getPaddingTop();
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition < 0 || findFirstVisibleItemPosition >= getItemCount()) {
                return paddingTop;
            }
            for (int i2 = 0; i2 < findFirstVisibleItemPosition; i2++) {
                View viewForPosition = this.mRecycler.getViewForPosition(i2);
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

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, int i3) {
            super.onMeasure(recycler, state, i2, i3);
            this.mRecycler = recycler;
        }
    }

    /* loaded from: classes2.dex */
    public static class PaddingTemplateData {
        public PaddingTemplateData() {
        }
    }

    /* loaded from: classes2.dex */
    public static class PaddingViewHolder extends BaseViewHolder<PaddingTemplateData> {
        public PaddingViewHolder(View view, Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            super(view, context, 2, bDEmotionBagVerticalLayout);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.BaseViewHolder
        public void onBindViewHolder(int i2, PaddingTemplateData paddingTemplateData) {
        }
    }

    /* loaded from: classes2.dex */
    public static class TitleTemplateData {
        public String sectionTitle;
        public int sectionType;

        public TitleTemplateData() {
        }
    }

    /* loaded from: classes2.dex */
    public static class TitleViewHolder extends BaseViewHolder<TitleTemplateData> {
        public int mAllPaddingTop;
        public int mCommonPaddingTop;
        public TextView mTitle;

        public TitleViewHolder(View view, Context context, BDEmotionBagVerticalLayout bDEmotionBagVerticalLayout) {
            super(view, context, 0, bDEmotionBagVerticalLayout);
            this.mTitle = (TextView) view.findViewById(R.id.emotion_title);
            this.mCommonPaddingTop = this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_common_title_padding_top);
            this.mAllPaddingTop = this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_all_title_padding_top);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.BaseViewHolder
        public void onBindViewHolder(int i2, TitleTemplateData titleTemplateData) {
            if (titleTemplateData != null) {
                this.mTitle.setText(titleTemplateData.sectionTitle);
                this.mTitle.setTextColor(this.mCtx.getResources().getColor(R.color.GC1));
                int i3 = titleTemplateData.sectionType;
                if (i3 == 0) {
                    this.mTitle.setPadding(0, this.mCommonPaddingTop, 0, 0);
                } else if (i3 == 1) {
                    this.mTitle.setPadding(0, this.mAllPaddingTop, 0, 0);
                }
            }
        }
    }

    public BDEmotionBagVerticalLayout(Context context) {
        this(context, null);
    }

    private boolean acquireTokenForIconAlpha(ImageView imageView) {
        if (this.mAlphaChangingIconSet.containsKey(imageView)) {
            return true;
        }
        if (this.mAlphaChangingIconSet.size() >= 2) {
            return false;
        }
        this.mAlphaChangingIconSet.put(imageView, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableIdleAlphaTemporarily() {
        if (this.mTempEnableIdleAlpha) {
            return;
        }
        this.mTempEnableIdleAlpha = true;
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.7
            @Override // java.lang.Runnable
            public void run() {
                BDEmotionBagVerticalLayout.this.mTempEnableIdleAlpha = false;
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getExpressionName(int i2, int i3) {
        List<ListMetaData> dataList;
        ListMetaData listMetaData;
        int i4;
        DATA data;
        EmotionListAdapter emotionListAdapter = this.mEmotionListAdapter;
        if (emotionListAdapter == null || i2 < 0 || i3 < 0 || (dataList = emotionListAdapter.getDataList()) == null || dataList.isEmpty()) {
            return null;
        }
        if (i2 == 0 && 1 < dataList.size()) {
            listMetaData = dataList.get(1);
        } else {
            listMetaData = (i2 <= 0 || (i4 = (i2 + 3) - 1) >= dataList.size() - 1) ? null : dataList.get(i4);
        }
        if (listMetaData == null || (data = listMetaData.data) == 0 || ((EmotionTemplateData) data).iconList == null || ((EmotionTemplateData) data).iconList.isEmpty()) {
            return null;
        }
        String str = i3 < ((EmotionTemplateData) listMetaData.data).iconList.size() ? ((EmotionTemplateData) listMetaData.data).iconList.get(i3) : null;
        if (this.mAlphaChangingEmotionSet.contains(str)) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getIconAlpha(ViewGroup viewGroup, ImageView imageView, String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getIconRowAndColIndex(float f2, float f3) {
        RecyclerView recyclerView;
        int[] iArr;
        if (sExpressionWidthWithPadding == 0 || (recyclerView = this.mEmotionRecyclerView) == null) {
            return null;
        }
        recyclerView.getLocationOnScreen(new int[2]);
        float f4 = f3 - iArr[1];
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

    /* JADX INFO: Access modifiers changed from: private */
    public PopupEmotionManager getPopupEmotionManager() {
        return this.mPopupEmotionManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getValidLongPressedRect() {
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

    private void init(Context context) {
        this.mCtx = context;
        int i2 = context.getResources().getConfiguration().orientation;
        if (i2 == 1) {
            setPadding(0, 0, 0, 0);
        } else if (i2 == 2) {
            int dimensionPixelSize = this.mCtx.getResources().getDimensionPixelSize(R.dimen.window_horizontal_padding);
            setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        sExprTotalExtraHeight = (this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_title_size) * 2) + this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_common_title_padding_top) + this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_all_title_padding_top);
        sExpressionHeightWithPadding = this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_row_height);
        sExprCrossSectionFixedHeight = this.mCtx.getResources().getDimensionPixelSize(R.dimen.expression_cross_section_fixed_height);
        PopupEmotionManager popupEmotionManager = new PopupEmotionManager(this.mCtx);
        this.mPopupEmotionManager = popupEmotionManager;
        popupEmotionManager.setShowListener(GlobalOnItemClickListenerManager.getInstance().getPopupEmotionShowListener());
        if (BDEmotionPanelManager.getInstance().isNightMode()) {
            setBackgroundColor(NIGHT_COLOR_EMOTION_BAG);
        } else {
            setBackgroundColor(COLOR_EMOTION_BAG);
        }
        LayoutInflater.from(this.mCtx).inflate(R.layout.emotion_vertical_panel_root, this);
        this.mViewPager = (ViewPager) findViewById(R.id.view_pager);
        this.mIndicator = (CircleIndicator) findViewById(R.id.indicator);
        ArrayList arrayList = new ArrayList();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mCtx).inflate(R.layout.emotion_vertical_panel_page1_root, (ViewGroup) this, false);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.delete_btn);
        this.mDelBtn = imageView;
        imageView.setImageDrawable(this.mCtx.getResources().getDrawable(R.drawable.emotion_delete));
        this.mDelBtn.setBackground(this.mCtx.getResources().getDrawable(R.drawable.emotion_del_btn_bg));
        this.mDelBtn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                BDEmotionBagVerticalLayout.this.mDelBtn.getViewTreeObserver().removeOnPreDrawListener(this);
                int[] iArr = new int[2];
                BDEmotionBagVerticalLayout.this.mDelBtn.getLocationOnScreen(iArr);
                BDEmotionBagVerticalLayout.this.mDelBtLocRect = new Rect(iArr[0], iArr[1], iArr[0] + BDEmotionBagVerticalLayout.this.mDelBtn.getWidth(), iArr[1] + BDEmotionBagVerticalLayout.this.mDelBtn.getHeight());
                BDEmotionBagVerticalLayout.this.mDelBtn.setEnabled(!GlobalOnItemClickListenerManager.getInstance().isEditContentEmpty());
                BDEmotionBagVerticalLayout.this.mDelBtn.setImageAlpha(BDEmotionBagVerticalLayout.this.mDelBtn.isEnabled() ? 255 : 102);
                return true;
            }
        });
        this.mDelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GlobalOnItemClickListenerManager.getInstance().performVerticalDelClick();
            }
        });
        this.mDelBtn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                GlobalOnItemClickListenerManager.getInstance().performDelLongClick();
                return false;
            }
        });
        this.mDelBtn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    BDEmotionBagVerticalLayout.this.mDelBtn.setImageAlpha(51);
                    return false;
                } else if (action == 1 || action == 3) {
                    BDEmotionBagVerticalLayout.this.mDelBtn.setImageAlpha(255);
                    GlobalOnItemClickListenerManager.getInstance().removeLongClickCallback();
                    BDEmotionBagVerticalLayout.this.mDelBtn.setEnabled(!GlobalOnItemClickListenerManager.getInstance().isEditContentEmpty());
                    BDEmotionBagVerticalLayout.this.mDelBtn.setImageAlpha(BDEmotionBagVerticalLayout.this.mDelBtn.isEnabled() ? 255 : 102);
                    return false;
                } else {
                    return false;
                }
            }
        });
        GlobalOnItemClickListenerManager.getInstance().setEditContentTextWatcher(new TextWatcher() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (GlobalOnItemClickListenerManager.getInstance().isDelLongClick()) {
                    return;
                }
                BDEmotionBagVerticalLayout.this.mDelBtn.setEnabled(editable.length() > 0);
                BDEmotionBagVerticalLayout.this.mDelBtn.setImageAlpha(BDEmotionBagVerticalLayout.this.mDelBtn.isEnabled() ? 255 : 102);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }
        });
        this.mEmotionRecyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_list);
        OffsetLinearLayoutManager offsetLinearLayoutManager = new OffsetLinearLayoutManager(this.mCtx);
        this.mLayoutManager = offsetLinearLayoutManager;
        this.mEmotionRecyclerView.setLayoutManager(offsetLinearLayoutManager);
        EmotionListAdapter emotionListAdapter = new EmotionListAdapter(this.mCtx, this);
        this.mEmotionListAdapter = emotionListAdapter;
        this.mEmotionRecyclerView.setAdapter(emotionListAdapter);
        this.mEmotionRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                GlobalOnItemClickListenerManager.getInstance().removeLongClickCallback();
                if (BDEmotionBagVerticalLayout.this.mPopupEmotionManager != null && BDEmotionBagVerticalLayout.this.mPopupEmotionManager.isShowing()) {
                    BDEmotionBagVerticalLayout.this.mPopupEmotionManager.dismiss();
                }
                BDEmotionBagVerticalLayout.this.mCurrentScrollY += i4;
                if (Math.abs(BDEmotionBagVerticalLayout.this.mCurrentScrollY) >= BDEmotionBagVerticalLayout.sExpressionHeightWithPadding) {
                    BDEmotionBagVerticalLayout.this.mCurrentScrollY = 0;
                    GlobalOnItemClickListenerManager.getInstance().addEmotionShownSlideCount();
                }
                BDEmotionBagVerticalLayout.this.enableIdleAlphaTemporarily();
            }
        });
        arrayList.add(viewGroup);
        EmotionPagerAdapter emotionPagerAdapter = new EmotionPagerAdapter(arrayList);
        this.mPagerAdapter = emotionPagerAdapter;
        this.mViewPager.setAdapter(emotionPagerAdapter);
        this.mIndicator.setViewPager(this.mViewPager);
        if (arrayList.size() <= 1) {
            this.mIndicator.setVisibility(8);
        }
    }

    private void releaseTokenForIconAlpha(ImageView imageView) {
        this.mAlphaChangingIconSet.remove(imageView);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        List<ListMetaData> dataList;
        ListMetaData listMetaData;
        DATA data;
        PopupEmotionManager popupEmotionManager;
        if (view.getClass() == SPSwitchPanelLinearLayout.class || view.getClass() == BDEmotionBagVerticalLayout.class) {
            if (i2 == 0) {
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
        if (i2 == 0 || (popupEmotionManager = this.mPopupEmotionManager) == null || !popupEmotionManager.isShowing()) {
            return;
        }
        this.mPopupEmotionManager.dismiss();
    }

    public void setEmotionList(List<String> list) {
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
            int i2 = 1;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (i3 % 7 == 0) {
                    emotionTemplateData = new EmotionTemplateData();
                    emotionTemplateData.sectionType = 1;
                    emotionTemplateData.rowIndex = i2;
                    emotionTemplateData.rowCount = size;
                    emotionTemplateData.iconList = new ArrayList();
                    arrayList.add(new ListMetaData(1, emotionTemplateData));
                    i2++;
                }
                emotionTemplateData.iconList.add(list.get(i3));
            }
        }
        arrayList.add(new ListMetaData(2, new PaddingTemplateData()));
        this.mEmotionListAdapter.setData(arrayList);
    }

    public BDEmotionBagVerticalLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BDEmotionBagVerticalLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mAlphaChangingIconSet = new WeakHashMap();
        this.mAlphaChangingEmotionSet = new HashSet();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        init(context);
    }
}

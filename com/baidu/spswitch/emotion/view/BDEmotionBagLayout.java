package com.baidu.spswitch.emotion.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.UIUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class BDEmotionBagLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BACKGROUND_COLOR = -1;
    public static final int COLOR_EMOTION_BAG = -1;
    public static final int EMOTION_COLUMNS = 7;
    public static final int EMOTION_ROWS = 3;
    public static final int EXPRESSION_ROW_HEIGHT = 48;
    public static final int GV_LEFT_RIGHT_PADDING = 10;
    public static final int HORIZONTAL_SPACING = 3;
    public static final int INDICATOR_HEIGHT = 16;
    public static final int NIGHT_COLOR_EMOTION_BAG = -14540254;
    public static final String TAG = "BDEmotionBagLayout";
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> mEmotionList;
    public int mGridViewVerticalSpace;
    public CircleIndicator mIndicator;
    public List<GridView> mPageList;
    public PagerAdapter mPagerAdapter;
    public ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public class EmotionGridViewAdapter extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context mContext;
        public LayoutInflater mInflater;
        public List<String> mList;
        public final /* synthetic */ BDEmotionBagLayout this$0;

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 21;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        public EmotionGridViewAdapter(BDEmotionBagLayout bDEmotionBagLayout, Context context, List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDEmotionBagLayout, context, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bDEmotionBagLayout;
            this.mList = list;
            this.mInflater = LayoutInflater.from(context);
            this.mContext = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        public String getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (i < this.mList.size()) {
                    return this.mList.get(i);
                }
                return null;
            }
            return (String) invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            LinearLayout linearLayout;
            Bitmap emotionBitmapByName;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    linearLayout = (LinearLayout) this.mInflater.inflate(R.layout.emotion_grid_item, viewGroup, false);
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    layoutParams.height = (int) UIUtils.dp2px(this.mContext, 48.0f);
                    linearLayout.setLayoutParams(layoutParams);
                } else {
                    linearLayout = (LinearLayout) view2;
                }
                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.img_item);
                if (i == getCount() - 1) {
                    imageView.setImageResource(R.drawable.face_delete);
                } else if (i < this.mList.size() && (emotionBitmapByName = EmotionUtils.getInstance().getEmotionBitmapByName(EmotionType.EMOTION_CLASSIC_TYPE, this.mList.get(i))) != null) {
                    imageView.setImageBitmap(emotionBitmapByName);
                }
                return linearLayout;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class EmotionPagerAdapter extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<GridView> mList;
        public final /* synthetic */ BDEmotionBagLayout this$0;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }

        public EmotionPagerAdapter(BDEmotionBagLayout bDEmotionBagLayout, List<GridView> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bDEmotionBagLayout, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bDEmotionBagLayout;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mList.size();
            }
            return invokeV.intValue;
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
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDEmotionBagLayout(Context context) {
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

    private List<String> getEmotionListForPage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i)) == null) {
            int i2 = i * 20;
            int min = Math.min(i2 + 20, this.mEmotionList.size());
            ArrayList arrayList = new ArrayList();
            while (i2 < min) {
                arrayList.add(this.mEmotionList.get(i2));
                i2++;
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDEmotionBagLayout(Context context, @Nullable AttributeSet attributeSet) {
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
    public BDEmotionBagLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.mPageList = new ArrayList();
        init(context);
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            if (BDEmotionPanelManager.getInstance().isNightMode()) {
                setBackgroundColor(-14540254);
            } else {
                setBackgroundColor(-1);
            }
            setOrientation(1);
            this.mViewPager = new ViewPager(context);
            this.mIndicator = new CircleIndicator(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.mViewPager.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) UIUtils.dp2px(context, 16.0f));
            layoutParams2.weight = 0.0f;
            this.mIndicator.setLayoutParams(layoutParams2);
            this.mViewPager.setOverScrollMode(2);
            addView(this.mViewPager);
            addView(this.mIndicator);
        }
    }

    public void setEmotionList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.mEmotionList = list;
            if (list != null && list.size() > 0) {
                int size = this.mEmotionList.size();
                int i = size % 20;
                int i2 = size / 20;
                if (i != 0) {
                    i2++;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    NoScrollGridView noScrollGridView = new NoScrollGridView(getContext());
                    noScrollGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    noScrollGridView.setNumColumns(7);
                    noScrollGridView.setStretchMode(2);
                    noScrollGridView.setVerticalScrollBarEnabled(false);
                    noScrollGridView.setOverScrollMode(2);
                    GlobalOnItemClickListenerManager globalOnItemClickListenerManager = GlobalOnItemClickListenerManager.getInstance();
                    noScrollGridView.setOnItemClickListener(globalOnItemClickListenerManager.getOnItemClickListener(EmotionType.EMOTION_CLASSIC_TYPE, i3));
                    noScrollGridView.setOnItemLongClickListener(globalOnItemClickListenerManager.getOnItemLongClickListener(EmotionType.EMOTION_CLASSIC_TYPE));
                    noScrollGridView.setOnTouchListener(globalOnItemClickListenerManager.getOnTouchListener(EmotionType.EMOTION_CLASSIC_TYPE));
                    noScrollGridView.setSelector(new ColorDrawable(0));
                    this.mPageList.add(noScrollGridView);
                }
                prepareContentForAllGridView();
                EmotionPagerAdapter emotionPagerAdapter = new EmotionPagerAdapter(this, this.mPageList);
                this.mPagerAdapter = emotionPagerAdapter;
                this.mViewPager.setAdapter(emotionPagerAdapter);
                this.mIndicator.setViewPager(this.mViewPager);
            }
        }
    }

    private void prepareContentForAllGridView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            int size = this.mPageList.size();
            for (int i = 0; i < size; i++) {
                this.mPageList.get(i).setAdapter((ListAdapter) new EmotionGridViewAdapter(this, getContext(), getEmotionListForPage(i)));
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            int measuredHeight = getChildAt(0).getMeasuredHeight() - (((int) UIUtils.dp2px(getContext(), 48.0f)) * 3);
            int dp2px = (int) ((measuredHeight / 4) + UIUtils.dp2px(getContext(), 8.0f));
            this.mGridViewVerticalSpace = (measuredHeight - (dp2px * 2)) / 2;
            int size = this.mPageList.size();
            for (int i5 = 0; i5 < size; i5++) {
                GridView gridView = this.mPageList.get(i5);
                int dp2px2 = (int) UIUtils.dp2px(getContext(), 10.0f);
                gridView.setPadding(dp2px2, dp2px, dp2px2, dp2px);
                gridView.setVerticalSpacing(this.mGridViewVerticalSpace);
                gridView.setHorizontalSpacing((int) UIUtils.dp2px(getContext(), (int) UIUtils.dp2px(getContext(), 3.0f)));
                EmotionGridViewAdapter emotionGridViewAdapter = (EmotionGridViewAdapter) gridView.getAdapter();
                if (emotionGridViewAdapter != null && (viewPager = this.mViewPager) != null) {
                    viewPager.post(new Runnable(this, emotionGridViewAdapter) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBagLayout.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BDEmotionBagLayout this$0;
                        public final /* synthetic */ EmotionGridViewAdapter val$adapter;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, emotionGridViewAdapter};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i6 = newInitContext.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$adapter = emotionGridViewAdapter;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$adapter.notifyDataSetChanged();
                            }
                        }
                    });
                }
            }
        }
    }
}

package com.baidu.spswitch.emotion.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.searchbox.ui.CommonEmptyView;
import com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager;
import com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter;
import com.baidu.spswitch.emotion.bean.BDEmotionDynamicModelKt;
import com.baidu.spswitch.emotion.bean.EmotionItemModel;
import com.baidu.spswitch.emotion.bean.EmotionTitleModel;
import com.baidu.spswitch.emotion.bean.EmotionTypeModel;
import com.baidu.spswitch.emotion.divider.GridSpaceItemDecoration;
import com.baidu.spswitch.emotion.net.EmotionRequest;
import com.baidu.spswitch.emotion.net.EmotionRequestCallback;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.spswitch.utils.EmoAlphaChangeHelper;
import com.baidu.spswitch.utils.EmotionPreviewHandler;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class BDEmotionBaseLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EMOTION_ASCII_TYPE = "2";
    public static final int EMOTION_DYNAMIC_COLUMNS = 4;
    public static final String EMOTION_DYNAMIC_TYPE = "1";
    public static final String TAG = "BDEmotionBaseLayout";
    public transient /* synthetic */ FieldHolder $fh;
    public EmoAlphaChangeHelper mAlphaChangeHelper;
    public BdShimmerView mBdShimmerView;
    public ImageView mDelBtn;
    public BDEmotionDynamicAdapter mDynamicAdapter;
    public EmotionPreviewHandler mEmotionPreviewHandler;
    public RecyclerView mEmotionRecyclerView;
    public CommonEmptyView mEmptyView;
    public BDEmotionPanelManager.EmotionPanelConfig mPanelConfig;
    public View mRootView;
    public EmotionTypeModel mTypeModel;

    public abstract BDEmotionDynamicAdapter.OnEmotionClickListener getEmotionClickListener();

    public int getSpanCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    public abstract boolean showDelBtn();

    public abstract boolean showPreview();

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDEmotionBaseLayout(@NonNull Context context) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchPanelData(boolean z) {
        EmotionTypeModel emotionTypeModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65546, this, z) == null) && (emotionTypeModel = this.mTypeModel) != null && !TextUtils.isEmpty(emotionTypeModel.getId())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mTypeModel.getId());
            EmotionRequest.getEmoList(arrayList, new EmotionRequestCallback(this, arrayList, z) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBaseLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBaseLayout this$0;
                public final /* synthetic */ List val$idList;
                public final /* synthetic */ boolean val$isReFetch;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, arrayList, Boolean.valueOf(z)};
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
                    this.val$idList = arrayList;
                    this.val$isReFetch = z;
                }

                @Override // com.baidu.spswitch.emotion.net.EmotionRequestCallback
                public void onFailure(@Nullable String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        UiThreadUtils.runOnUiThread(new Runnable(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBaseLayout.2.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.this$1.val$isReFetch) {
                                        UniversalToast.makeText(AppRuntime.getAppContext(), (int) R.string.bdemotion_panel_net_err).show();
                                    }
                                    this.this$1.this$0.showNetWorkErrorView();
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.spswitch.emotion.net.EmotionRequestCallback
                public void onSuccess(String str, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
                        UiThreadUtils.runOnUiThread(new Runnable(this, str) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBaseLayout.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 this$1;
                            public final /* synthetic */ String val$result;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$result = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    Map<String, List<EmotionItemModel>> parseEmotionItemList = BDEmotionDynamicModelKt.parseEmotionItemList(this.this$1.val$idList, this.val$result);
                                    if (parseEmotionItemList == null || parseEmotionItemList.isEmpty()) {
                                        if (this.this$1.val$isReFetch) {
                                            UniversalToast.makeText(AppRuntime.getAppContext(), (int) R.string.bdemotion_panel_net_err).show();
                                        }
                                        this.this$1.this$0.showNetWorkErrorView();
                                        return;
                                    }
                                    this.this$1.this$0.hideLoading();
                                    this.this$1.this$0.addEmotionPanel(parseEmotionItemList);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BDEmotionBaseLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public BDEmotionBaseLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        init(context);
    }

    private int getEmotionItemType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, str)) == null) {
            if (TextUtils.equals(str, "1")) {
                return 2;
            }
            if (TextUtils.equals(str, "2")) {
                return 1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void loadData(@NonNull EmotionTypeModel emotionTypeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, emotionTypeModel) == null) {
            this.mTypeModel = emotionTypeModel;
            showLoading();
            fetchPanelData(false);
            EmotionPreviewHandler emotionPreviewHandler = this.mEmotionPreviewHandler;
            if (emotionPreviewHandler != null) {
                emotionPreviewHandler.setTypeModel(emotionTypeModel);
            }
        }
    }

    public void setEmotionPanelConfig(@Nullable BDEmotionPanelManager.EmotionPanelConfig emotionPanelConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, emotionPanelConfig) == null) {
            this.mPanelConfig = emotionPanelConfig;
            EmotionPreviewHandler emotionPreviewHandler = this.mEmotionPreviewHandler;
            if (emotionPreviewHandler != null) {
                emotionPreviewHandler.setPanelConfig(emotionPanelConfig);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEmotionPanel(@NonNull Map<String, List<EmotionItemModel>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, map) == null) {
            for (String str : map.keySet()) {
                List<EmotionItemModel> list = map.get(str);
                if (this.mTypeModel != null && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new BDEmotionDynamicAdapter.EmotionDynamicData(0, new EmotionTitleModel(this.mTypeModel.getTitle(), this.mTypeModel.getPic())));
                    for (EmotionItemModel emotionItemModel : list) {
                        if (emotionItemModel != null) {
                            arrayList.add(new BDEmotionDynamicAdapter.EmotionDynamicData(getEmotionItemType(this.mTypeModel.getType()), emotionItemModel));
                        }
                    }
                    BDEmotionDynamicAdapter bDEmotionDynamicAdapter = this.mDynamicAdapter;
                    if (bDEmotionDynamicAdapter != null) {
                        bDEmotionDynamicAdapter.setData(arrayList);
                    }
                    if (TextUtils.equals(this.mTypeModel.getType(), "2")) {
                        GlobalOnItemClickListenerManager.getInstance().addEmotionTextModels(list);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.mBdShimmerView.setVisibility(8);
            this.mRootView.setVisibility(0);
            this.mBdShimmerView.stopShimmerAnimation();
        }
    }

    private void hideNetWorkErrorView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.mEmptyView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            hideNetWorkErrorView();
            this.mRootView.setVisibility(8);
            this.mBdShimmerView.setVisibility(0);
            this.mBdShimmerView.startShimmerAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetWorkErrorView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.mRootView.setVisibility(8);
            hideLoading();
            this.mEmptyView.setVisibility(0);
        }
    }

    private void updateUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            setBackgroundColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f060213));
            this.mEmptyView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f060213));
        }
    }

    @Nullable
    public BDEmotionDynamicAdapter getDynamicAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mDynamicAdapter;
        }
        return (BDEmotionDynamicAdapter) invokeV.objValue;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecoration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new GridSpaceItemDecoration();
        }
        return (RecyclerView.ItemDecoration) invokeV.objValue;
    }

    @Nullable
    public RecyclerView.LayoutManager getLayoutManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this, gridLayoutManager) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBaseLayout.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBaseLayout this$0;
                public final /* synthetic */ GridLayoutManager val$manager;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, gridLayoutManager};
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
                    this.val$manager = gridLayoutManager;
                }

                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(1048576, this, i)) == null) {
                        if (i == 0) {
                            return this.val$manager.getSpanCount();
                        }
                        return 1;
                    }
                    return invokeI.intValue;
                }
            });
            return gridLayoutManager;
        }
        return (RecyclerView.LayoutManager) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            BdShimmerView bdShimmerView = this.mBdShimmerView;
            if (bdShimmerView != null) {
                bdShimmerView.stopShimmerAnimation();
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, context) == null) {
            int i = context.getResources().getConfiguration().orientation;
            int i2 = 0;
            if (i == 1) {
                setPadding(0, 0, 0, 0);
            } else if (i == 2) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.window_horizontal_padding);
                setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            LayoutInflater.from(context).inflate(R.layout.emotion_vertical_panel_page1_root, this);
            this.mRootView = findViewById(R.id.emotion_content_root);
            ImageView imageView = (ImageView) findViewById(R.id.delete_btn);
            this.mDelBtn = imageView;
            imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.emotion_delete));
            this.mDelBtn.setBackground(ContextCompat.getDrawable(context, R.drawable.emotion_del_btn_bg));
            ImageView imageView2 = this.mDelBtn;
            if (!showDelBtn()) {
                i2 = 8;
            }
            imageView2.setVisibility(i2);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_list);
            this.mEmotionRecyclerView = recyclerView;
            recyclerView.setLayoutManager(getLayoutManager());
            this.mEmotionRecyclerView.addItemDecoration(getItemDecoration());
            this.mDynamicAdapter = new BDEmotionDynamicAdapter(getContext());
            EmoAlphaChangeHelper emoAlphaChangeHelper = new EmoAlphaChangeHelper(context);
            this.mAlphaChangeHelper = emoAlphaChangeHelper;
            emoAlphaChangeHelper.setSpanCount(getSpanCount());
            this.mDynamicAdapter.setAlphaChangeHelper(this.mAlphaChangeHelper);
            this.mAlphaChangeHelper.setDelBtn(this.mDelBtn);
            this.mEmotionRecyclerView.addOnScrollListener(this.mAlphaChangeHelper);
            this.mEmotionRecyclerView.setAdapter(this.mDynamicAdapter);
            this.mDynamicAdapter.setOnEmotionClickListener(getEmotionClickListener());
            if (showPreview()) {
                EmotionPreviewHandler emotionPreviewHandler = new EmotionPreviewHandler(context, this.mEmotionRecyclerView, getSpanCount());
                this.mEmotionPreviewHandler = emotionPreviewHandler;
                this.mDynamicAdapter.setEmotionPreviewHandler(emotionPreviewHandler);
            }
            initDelBtnClickActions();
            initLoadingView();
            initEmptyView();
            updateUI();
        }
    }

    private void initDelBtnClickActions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.mDelBtn.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBaseLayout.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBaseLayout this$0;

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
                        GlobalOnItemClickListenerManager.getInstance().performVerticalDelClick();
                    }
                }
            });
            this.mDelBtn.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBaseLayout.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBaseLayout this$0;

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
            this.mDelBtn.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBaseLayout.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBaseLayout this$0;

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

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                        int action = motionEvent.getAction();
                        if (action != 0) {
                            if (action == 1 || action == 3) {
                                int i = 255;
                                this.this$0.mDelBtn.setImageAlpha(255);
                                GlobalOnItemClickListenerManager.getInstance().removeLongClickCallback();
                                this.this$0.mDelBtn.setEnabled(!GlobalOnItemClickListenerManager.getInstance().isEditContentEmpty());
                                ImageView imageView = this.this$0.mDelBtn;
                                if (!this.this$0.mDelBtn.isEnabled()) {
                                    i = 102;
                                }
                                imageView.setImageAlpha(i);
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
            GlobalOnItemClickListenerManager.getInstance().addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBaseLayout.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBaseLayout this$0;

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
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

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    boolean z;
                    int i;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeL(1048576, this, editable) != null) || GlobalOnItemClickListenerManager.getInstance().isDelLongClick()) {
                        return;
                    }
                    ImageView imageView = this.this$0.mDelBtn;
                    if (editable.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    imageView.setEnabled(z);
                    ImageView imageView2 = this.this$0.mDelBtn;
                    if (this.this$0.mDelBtn.isEnabled()) {
                        i = 255;
                    } else {
                        i = 102;
                    }
                    imageView2.setImageAlpha(i);
                }
            });
        }
    }

    private void initLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            BdShimmerView bdShimmerView = new BdShimmerView(getContext());
            this.mBdShimmerView = bdShimmerView;
            bdShimmerView.setVisibility(8);
            this.mBdShimmerView.setType(1);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.mBdShimmerView, layoutParams);
        }
    }

    private void initEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            CommonEmptyView commonEmptyView = new CommonEmptyView(getContext());
            this.mEmptyView = commonEmptyView;
            commonEmptyView.setVisibility(8);
            this.mEmptyView.setTitle(getResources().getString(R.string.bdemotion_panel_net_error));
            this.mEmptyView.setButtonText(getResources().getString(R.string.bdemotion_panel_net_reload));
            this.mEmptyView.setButtonStyle(CommonEmptyView.ButtonStyle.WHITE);
            this.mEmptyView.setIcon(R.drawable.obfuscated_res_0x7f0805f9);
            this.mEmptyView.setTextButtonClickListener(new View.OnClickListener(this) { // from class: com.baidu.spswitch.emotion.view.BDEmotionBaseLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BDEmotionBaseLayout this$0;

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
                    if (interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) {
                        return;
                    }
                    this.this$0.showLoading();
                    this.this$0.fetchPanelData(true);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.mEmptyView, layoutParams);
        }
    }
}

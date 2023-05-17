package com.baidu.spswitch.utils;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.EmotionUtils;
import com.baidu.spswitch.emotion.adapter.BDEmotionDynamicAdapter;
import com.baidu.spswitch.emotion.bean.EmotionItemModel;
import com.baidu.spswitch.emotion.bean.EmotionTypeModel;
import com.baidu.spswitch.emotion.view.PopupEmotionManager;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class EmotionPreviewHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIVIDER_HEIGHT;
    public static final String TAG = "EmotionPreviewHandler";
    public static final int TRIANGLE_DIFF;
    public transient /* synthetic */ FieldHolder $fh;
    public int mActivePointerId;
    public final Context mContext;
    public int mCutOffItemHeight;
    public int mExtraHeight;
    public boolean mIsItemPosInited;
    public boolean mIsLongPressed;
    public int mItemHeightWithPadding;
    public int mItemHorizontalDiff;
    public int mItemWidthWithPadding;
    public BDEmotionPanelManager.EmotionPanelConfig mPanelConfig;
    public final PopupEmotionManager mPopupEmotionManager;
    public int mPos;
    public int[] mPressedItemPos;
    public int[] mPressedItemRowCol;
    public EmotionItemModel mPressedModel;
    public View mPressedView;
    public final RecyclerView mRecyclerView;
    public final int mSpanCount;
    public EmotionTypeModel mTypeModel;
    public RectF mValidLongPressedRect;
    public boolean mValidTouch;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(245244588, "Lcom/baidu/spswitch/utils/EmotionPreviewHandler;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(245244588, "Lcom/baidu/spswitch/utils/EmotionPreviewHandler;");
                return;
            }
        }
        DIVIDER_HEIGHT = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 10.0f);
        TRIANGLE_DIFF = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 7.0f);
    }

    public EmotionPreviewHandler(@NonNull Context context, @NonNull RecyclerView recyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, recyclerView, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mExtraHeight = 10;
        this.mContext = context;
        this.mPopupEmotionManager = new PopupEmotionManager(context);
        this.mSpanCount = i;
        this.mRecyclerView = recyclerView;
        initListeners();
    }

    public void onLongClick(@Nullable View view2, int i, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, obj) == null) && view2 != null && (obj instanceof EmotionItemModel) && this.mSpanCount > 1) {
            this.mItemWidthWithPadding = this.mRecyclerView.getWidth() / this.mSpanCount;
            int width = this.mRecyclerView.getWidth();
            int width2 = view2.getWidth();
            int i2 = this.mSpanCount;
            this.mItemHorizontalDiff = (width - (width2 * i2)) / (i2 - 1);
            this.mItemHeightWithPadding = view2.getHeight() + DIVIDER_HEIGHT;
            this.mIsLongPressed = true;
            this.mPressedView = view2;
            this.mPressedModel = (EmotionItemModel) obj;
            this.mRecyclerView.requestDisallowInterceptTouchEvent(true);
            this.mPopupEmotionManager.reset();
            this.mPos = i;
        }
    }

    public void setPanelConfig(@Nullable BDEmotionPanelManager.EmotionPanelConfig emotionPanelConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, emotionPanelConfig) == null) {
            this.mPanelConfig = emotionPanelConfig;
        }
    }

    public void setTypeModel(@Nullable EmotionTypeModel emotionTypeModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, emotionTypeModel) == null) {
            this.mTypeModel = emotionTypeModel;
        }
    }

    private void dismissLongPressedIfNecessary() {
        PopupEmotionManager popupEmotionManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) || (popupEmotionManager = this.mPopupEmotionManager) == null) {
            return;
        }
        popupEmotionManager.dismiss();
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.baidu.spswitch.utils.EmotionPreviewHandler.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EmotionPreviewHandler this$0;

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

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, recyclerView, i) == null) {
                        super.onScrollStateChanged(recyclerView, i);
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                        super.onScrolled(recyclerView, i, i2);
                        if (this.this$0.mPopupEmotionManager != null && this.this$0.mPopupEmotionManager.isShowing()) {
                            this.this$0.mPopupEmotionManager.dismiss();
                        }
                    }
                }
            });
            this.mPopupEmotionManager.setShowListener(new PopupEmotionManager.IShowListener(this) { // from class: com.baidu.spswitch.utils.EmotionPreviewHandler.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ EmotionPreviewHandler this$0;

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

                @Override // com.baidu.spswitch.emotion.view.PopupEmotionManager.IShowListener
                public void show(int i, String str, int i2, int i3) {
                    EmotionPreviewHandler emotionPreviewHandler;
                    BDEmotionPanelManager.EmotionPanelConfig emotionPanelConfig;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && this.this$0.mPressedModel != null && (emotionPanelConfig = (emotionPreviewHandler = this.this$0).mPanelConfig) != null && emotionPreviewHandler.mTypeModel != null) {
                        String str2 = emotionPanelConfig.from;
                        String str3 = emotionPanelConfig.page;
                        String str4 = emotionPanelConfig.source;
                        EmotionUbcHelper.doEmotionDynamicUBC(str2, EmotionUbcHelper.TYPE_MEME_PRESS, str3, str4, "", this.this$0.mTypeModel.getId() + "-" + this.this$0.mPressedModel.getId());
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ca  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] getIconRowAndColIndex(float f, float f2) {
        InterceptResult invokeCommon;
        int i;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (this.mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                i = ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                View findViewByPosition = this.mRecyclerView.getLayoutManager().findViewByPosition(i);
                if (findViewByPosition != null) {
                    Rect rect = new Rect();
                    findViewByPosition.getGlobalVisibleRect(rect);
                    i2 = rect.bottom - rect.top;
                    this.mCutOffItemHeight = this.mPressedView.getHeight() - i2;
                    this.mRecyclerView.getLocationOnScreen(new int[2]);
                    float f3 = f - iArr[0];
                    float f4 = f2 - iArr[1];
                    if (i != 0) {
                        float f5 = i2;
                        if (f4 <= f5) {
                            return new int[]{-1, -1};
                        }
                        this.mCutOffItemHeight = 0;
                        i3 = ((int) (f4 - f5)) / this.mItemHeightWithPadding;
                    } else {
                        float f6 = (int) (i2 + (DIVIDER_HEIGHT / 2.0f));
                        if (f4 > f6) {
                            i3 = (((int) (f4 - f6)) / this.mItemHeightWithPadding) + 1;
                        } else {
                            i3 = 0;
                        }
                    }
                    i4 = ((int) f3) / this.mItemWidthWithPadding;
                    if (AppConfig.isDebug()) {
                        Log.d(TAG, "getIconRowAndColIndex: x " + f3 + " y " + f4 + " colIndex " + i4 + " rowIndex " + i3 + " cutOffHeight " + i2);
                    }
                    int[] iArr2 = new int[2];
                    if (i3 < 0) {
                        i3 = -1;
                    }
                    iArr2[0] = i3;
                    if (i4 >= this.mSpanCount) {
                        i4 = -1;
                    }
                    iArr2[1] = i4;
                    return iArr2;
                }
            } else {
                i = 0;
            }
            i2 = 0;
            this.mRecyclerView.getLocationOnScreen(new int[2]);
            float f32 = f - iArr[0];
            float f42 = f2 - iArr[1];
            if (i != 0) {
            }
            i4 = ((int) f32) / this.mItemWidthWithPadding;
            if (AppConfig.isDebug()) {
            }
            int[] iArr22 = new int[2];
            if (i3 < 0) {
            }
            iArr22[0] = i3;
            if (i4 >= this.mSpanCount) {
            }
            iArr22[1] = i4;
            return iArr22;
        }
        return (int[]) invokeCommon.objValue;
    }

    private RectF getValidLongPressedRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            RectF rectF = this.mValidLongPressedRect;
            if (rectF != null) {
                return rectF;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 19 && !recyclerView.isLaidOut()) {
                return null;
            }
            int[] iArr = new int[2];
            this.mRecyclerView.getLocationOnScreen(iArr);
            RectF rectF2 = new RectF(iArr[0], iArr[1], iArr[0] + this.mRecyclerView.getWidth(), iArr[1] + this.mRecyclerView.getHeight());
            this.mValidLongPressedRect = rectF2;
            return rectF2;
        }
        return (RectF) invokeV.objValue;
    }

    private boolean releaseLongPressedIfNecessary(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, view2, motionEvent)) == null) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "releaseLongPressedIfNecessary: mIsLongPressed " + this.mIsLongPressed);
            }
            if (!this.mIsLongPressed) {
                return false;
            }
            this.mIsLongPressed = false;
            this.mIsItemPosInited = false;
            this.mRecyclerView.requestDisallowInterceptTouchEvent(false);
            dismissLongPressedIfNecessary();
            motionEvent.setAction(3);
            view2.dispatchTouchEvent(motionEvent);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
            int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action == 5 || action == 6) {
                            this.mValidTouch = false;
                        }
                    } else if (this.mValidTouch && this.mActivePointerId == pointerId && this.mIsLongPressed) {
                        showLongPressedIfNecessary(motionEvent.getRawX(), motionEvent.getRawY());
                        return true;
                    }
                } else {
                    return releaseLongPressedIfNecessary(view2, motionEvent);
                }
            } else {
                this.mActivePointerId = pointerId;
                this.mValidTouch = true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void show(@NonNull int[] iArr, @NonNull int[] iArr2, @NonNull String str) {
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, iArr, iArr2, str) == null) {
            PopupEmotionManager.ShowParam showParam = new PopupEmotionManager.ShowParam();
            showParam.sectionType = -1;
            showParam.exprRow = iArr[0];
            showParam.exprCol = iArr[1];
            showParam.anchorWidth = this.mPressedView.getWidth();
            if (iArr[1] == this.mSpanCount - 1) {
                z = true;
            } else {
                z = false;
            }
            showParam.isLastCol = z;
            showParam.anchorXpos = this.mPressedItemPos[0] + (iArr2[1] * (this.mPressedView.getWidth() + this.mItemHorizontalDiff));
            if (iArr[0] == 0) {
                showParam.anchorYpos = ((this.mPressedItemPos[1] + (iArr2[0] * this.mItemHeightWithPadding)) - TRIANGLE_DIFF) + this.mCutOffItemHeight;
            } else {
                showParam.anchorYpos = (this.mPressedItemPos[1] + (iArr2[0] * this.mItemHeightWithPadding)) - TRIANGLE_DIFF;
            }
            showParam.exprName = str;
            showParam.exprBitmap = EmotionUtils.getInstance().getEmotionBitmapByName(EmotionType.EMOTION_CLASSIC_TYPE, showParam.exprName);
            EmotionItemModel emotionItemModel = this.mPressedModel;
            if (emotionItemModel != null) {
                str2 = emotionItemModel.getDynamicUrl();
            } else {
                str2 = null;
            }
            showParam.exprBitmapUrl = str2;
            this.mPopupEmotionManager.show(showParam);
        }
    }

    private void showLongPressedIfNecessary(float f, float f2) {
        int[] iconRowAndColIndex;
        int[] iArr;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (this.mIsLongPressed && this.mPopupEmotionManager != null && this.mRecyclerView != null && this.mItemWidthWithPadding != 0) {
                RectF validLongPressedRect = getValidLongPressedRect();
                if (validLongPressedRect != null && !validLongPressedRect.contains((int) f, (int) f2)) {
                    return;
                }
                if (this.mPopupEmotionManager.isPostRunning()) {
                    if (AppConfig.isDebug()) {
                        Log.d(TAG, "showLongPressedIfNecessary: isRunning " + this.mPopupEmotionManager.isPostRunning() + " isShowing " + this.mPopupEmotionManager.isShowing());
                        return;
                    }
                    return;
                }
                if (!this.mIsItemPosInited) {
                    this.mIsItemPosInited = true;
                    int[] iArr2 = new int[2];
                    this.mPressedItemPos = iArr2;
                    this.mPressedView.getLocationOnScreen(iArr2);
                    if (DeviceUtils.ScreenInfo.isScreenLand()) {
                        Rect rect = new Rect();
                        this.mPressedView.getGlobalVisibleRect(rect);
                        this.mPressedItemPos[0] = rect.left;
                    }
                    iconRowAndColIndex = getIconRowAndColIndex(f, f2);
                    this.mPressedItemRowCol = iconRowAndColIndex;
                    iArr = new int[]{0, 0};
                } else {
                    iconRowAndColIndex = getIconRowAndColIndex(f, f2);
                    int i = iconRowAndColIndex[0];
                    int[] iArr3 = this.mPressedItemRowCol;
                    iArr = new int[]{i - iArr3[0], iconRowAndColIndex[1] - iArr3[1]};
                }
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "showLongPressedIfNecessary: " + this.mPressedItemPos[0] + " " + this.mPressedItemPos[1] + " rowColDiff " + iArr[0] + " " + iArr[1]);
                }
                if (iconRowAndColIndex[0] >= 0 && iconRowAndColIndex[1] >= 0) {
                    updatePressedModel(iconRowAndColIndex[0], iconRowAndColIndex[1]);
                    EmotionItemModel emotionItemModel = this.mPressedModel;
                    if (emotionItemModel != null) {
                        str = emotionItemModel.getText();
                    } else {
                        str = "";
                    }
                    if (TextUtils.isEmpty(str)) {
                        dismissLongPressedIfNecessary();
                        if (AppConfig.isDebug()) {
                            Log.d(TAG, "showLongPressedIfNecessary:  exprName is null");
                            return;
                        }
                        return;
                    }
                    show(iconRowAndColIndex, iArr, str);
                    return;
                }
                dismissLongPressedIfNecessary();
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "showLongPressedIfNecessary: row or col < 0 ");
                }
            } else if (AppConfig.isDebug()) {
                Log.d(TAG, "showLongPressedIfNecessary: mIsLongPressed " + this.mIsLongPressed);
            }
        }
    }

    private void updatePressedModel(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(65546, this, i, i2) == null) && (this.mRecyclerView.getAdapter() instanceof BDEmotionDynamicAdapter) && i >= 0 && i2 >= 0) {
            BDEmotionDynamicAdapter bDEmotionDynamicAdapter = (BDEmotionDynamicAdapter) this.mRecyclerView.getAdapter();
            int i3 = this.mPos;
            int[] iArr = this.mPressedItemRowCol;
            int i4 = i3 + ((i - iArr[0]) * this.mSpanCount) + (i2 - iArr[1]);
            if ((bDEmotionDynamicAdapter.getDataByPos(i4) instanceof EmotionItemModel) && i4 >= 0) {
                EmotionItemModel emotionItemModel = (EmotionItemModel) bDEmotionDynamicAdapter.getDataByPos(i4);
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "getExpressionName: text " + emotionItemModel.getText() + " id " + emotionItemModel.getId() + " pos " + i4);
                }
                this.mPressedModel = emotionItemModel;
            }
        }
    }
}

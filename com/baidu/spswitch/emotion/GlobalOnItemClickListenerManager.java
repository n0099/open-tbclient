package com.baidu.spswitch.emotion;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.emotion.view.BDEmotionBagLayout;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.spswitch.emotion.view.PopupEmotionManager;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class GlobalOnItemClickListenerManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DELETE_EMOTION = "[delete]";
    public static final int EDIT_CONTENT_DELETE_INTERVAL = 60;
    public static GlobalOnItemClickListenerManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable mEditContentDeleteRunnable;
    public EditText mEditText;
    public BDEmotionPanelManager.OnEmotionClickListener mEmotionClickListener;
    public int mEmotionShownMaxRow;
    public int mEmotionSlideCount;
    public boolean mIsDeleteItemLongClick;
    public Handler mMainHandler;
    public TextWatcher mTextWatcher;
    public BDEmotionPanelManager.OnVerticalEmotionListener mVerticalEmotionListener;

    public GlobalOnItemClickListenerManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mEditContentDeleteRunnable = new Runnable(this) { // from class: com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ GlobalOnItemClickListenerManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                if ((interceptable2 != null && interceptable2.invokeV(1048576, this) != null) || this.this$0.mEditText == null) {
                    return;
                }
                this.this$0.mEditText.dispatchKeyEvent(new KeyEvent(0, 67));
                if (this.this$0.mIsDeleteItemLongClick) {
                    this.this$0.mMainHandler.postDelayed(this, 60L);
                }
            }
        };
    }

    public static GlobalOnItemClickListenerManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            return getInstance();
        }
        return (GlobalOnItemClickListenerManager) invokeL.objValue;
    }

    public void attachToEditText(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editText) == null) {
            this.mEditText = editText;
        }
    }

    public AdapterView.OnItemLongClickListener getOnItemLongClickListener(EmotionType emotionType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, emotionType)) == null) {
            return new AdapterView.OnItemLongClickListener(this) { // from class: com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GlobalOnItemClickListenerManager this$0;

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

                @Override // android.widget.AdapterView.OnItemLongClickListener
                public boolean onItemLongClick(AdapterView adapterView, View view2, int i, long j) {
                    InterceptResult invokeCommon;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                        Adapter adapter = adapterView.getAdapter();
                        if ((adapter instanceof BDEmotionBagLayout.EmotionGridViewAdapter) && i == ((BDEmotionBagLayout.EmotionGridViewAdapter) adapter).getCount() - 1) {
                            this.this$0.performDelLongClick();
                            return false;
                        }
                        return false;
                    }
                    return invokeCommon.booleanValue;
                }
            };
        }
        return (AdapterView.OnItemLongClickListener) invokeL.objValue;
    }

    public View.OnTouchListener getOnTouchListener(EmotionType emotionType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, emotionType)) == null) {
            return new View.OnTouchListener(this) { // from class: com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GlobalOnItemClickListenerManager this$0;

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
                        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            this.this$0.removeLongClickCallback();
                            return false;
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            };
        }
        return (View.OnTouchListener) invokeL.objValue;
    }

    public void setEditContentTextWatcher(TextWatcher textWatcher) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, textWatcher) == null) && (editText = this.mEditText) != null && textWatcher != null) {
            editText.removeTextChangedListener(this.mTextWatcher);
            this.mEditText.addTextChangedListener(textWatcher);
            this.mTextWatcher = textWatcher;
        }
    }

    public void setOnEmotionClickListener(BDEmotionPanelManager.OnEmotionClickListener onEmotionClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onEmotionClickListener) == null) {
            this.mEmotionClickListener = onEmotionClickListener;
        }
    }

    public void setOnVerticalEmotionListener(BDEmotionPanelManager.OnVerticalEmotionListener onVerticalEmotionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onVerticalEmotionListener) == null) {
            this.mVerticalEmotionListener = onVerticalEmotionListener;
        }
    }

    public void updateEmotionShownMaxRow(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048594, this, i) == null) && i > this.mEmotionShownMaxRow) {
            this.mEmotionShownMaxRow = i;
        }
    }

    public static GlobalOnItemClickListenerManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (mInstance == null) {
                synchronized (GlobalOnItemClickListenerManager.class) {
                    if (mInstance == null) {
                        mInstance = new GlobalOnItemClickListenerManager();
                    }
                }
            }
            return mInstance;
        }
        return (GlobalOnItemClickListenerManager) invokeV.objValue;
    }

    public void addEmotionShownSlideCount() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mEmotionSlideCount++;
        }
    }

    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeLongClickCallback();
            EditText editText = this.mEditText;
            if (editText != null) {
                editText.removeTextChangedListener(this.mTextWatcher);
            }
            this.mTextWatcher = null;
            this.mEmotionClickListener = null;
            this.mVerticalEmotionListener = null;
            this.mEditText = null;
            mInstance = null;
        }
    }

    public int getEmotionShownMaxRow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mEmotionShownMaxRow;
        }
        return invokeV.intValue;
    }

    public int getEmotionShownSlideCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mEmotionSlideCount;
        }
        return invokeV.intValue;
    }

    public PopupEmotionManager.IShowListener getPopupEmotionShowListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new PopupEmotionManager.IShowListener(this) { // from class: com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GlobalOnItemClickListenerManager this$0;

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
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && this.this$0.mVerticalEmotionListener != null) {
                        this.this$0.mVerticalEmotionListener.onVerticalEmotionLongClick(EmotionType.EMOTION_CLASSIC_TYPE, i, EmotionUtils.getInstance().getEmotionIdByName(EmotionType.EMOTION_CLASSIC_TYPE, str), str, i2, i3);
                    }
                }
            };
        }
        return (PopupEmotionManager.IShowListener) invokeV.objValue;
    }

    public boolean isDelLongClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mIsDeleteItemLongClick;
        }
        return invokeV.booleanValue;
    }

    public boolean isEditContentEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            EditText editText = this.mEditText;
            if (editText == null || editText.getEditableText().length() <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void performDelLongClick() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && !this.mIsDeleteItemLongClick && this.mEditText != null) {
            this.mIsDeleteItemLongClick = true;
            this.mMainHandler.post(this.mEditContentDeleteRunnable);
        }
    }

    public void performVerticalDelClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (!this.mIsDeleteItemLongClick) {
                this.mEditText.dispatchKeyEvent(new KeyEvent(0, 67));
            }
            removeLongClickCallback();
        }
    }

    public void removeLongClickCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mMainHandler.removeCallbacks(this.mEditContentDeleteRunnable);
            this.mIsDeleteItemLongClick = false;
        }
    }

    public void resetEmotionShownData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.mEmotionShownMaxRow = 0;
            this.mEmotionSlideCount = 0;
        }
    }

    public AdapterView.OnItemClickListener getOnItemClickListener(EmotionType emotionType, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, emotionType, i)) == null) {
            return new AdapterView.OnItemClickListener(this, emotionType, i) { // from class: com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ GlobalOnItemClickListenerManager this$0;
                public final /* synthetic */ int val$page;
                public final /* synthetic */ EmotionType val$type;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, emotionType, Integer.valueOf(i)};
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
                    this.val$type = emotionType;
                    this.val$page = i;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView adapterView, View view2, int i2, long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                        Adapter adapter = adapterView.getAdapter();
                        if (adapter instanceof BDEmotionBagLayout.EmotionGridViewAdapter) {
                            BDEmotionBagLayout.EmotionGridViewAdapter emotionGridViewAdapter = (BDEmotionBagLayout.EmotionGridViewAdapter) adapter;
                            if (this.this$0.mEditText == null) {
                                return;
                            }
                            if (i2 < emotionGridViewAdapter.getCount() - 1) {
                                String item = emotionGridViewAdapter.getItem(i2);
                                if (TextUtils.isEmpty(item)) {
                                    return;
                                }
                                this.this$0.mEditText.getEditableText().insert(this.this$0.mEditText.getSelectionStart(), EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, AppRuntime.getAppContext(), item, this.this$0.mEditText));
                                if (this.this$0.mEmotionClickListener != null) {
                                    this.this$0.mEmotionClickListener.onEmotionClick(this.val$type, this.val$page, EmotionUtils.getInstance().getEmotionIdByName(this.val$type, item), item);
                                }
                            } else if (i2 == emotionGridViewAdapter.getCount() - 1) {
                                if (!this.this$0.mIsDeleteItemLongClick) {
                                    this.this$0.mEditText.dispatchKeyEvent(new KeyEvent(0, 67));
                                    if (this.this$0.mEmotionClickListener != null) {
                                        this.this$0.mEmotionClickListener.onEmotionClick(this.val$type, this.val$page, "", GlobalOnItemClickListenerManager.DELETE_EMOTION);
                                    }
                                }
                                this.this$0.removeLongClickCallback();
                            }
                        }
                    }
                }
            };
        }
        return (AdapterView.OnItemClickListener) invokeLI.objValue;
    }

    public void verticalOnItemClick(String str, BDEmotionBagVerticalLayout.EmotionGridViewAdapter.StatisticData statisticData, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048595, this, str, statisticData, i) != null) || this.mEditText == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mEditText.getEditableText().insert(this.mEditText.getSelectionStart(), EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, AppRuntime.getAppContext(), str, this.mEditText));
        EmotionUtils.getInstance().playEmotionClickSound();
        EmotionUsageUtil.recordEmotionUsage(str);
        if (this.mVerticalEmotionListener != null) {
            this.mVerticalEmotionListener.onVerticalEmotionClick(statisticData.type, statisticData.sectionType, EmotionUtils.getInstance().getEmotionIdByName(statisticData.type, str), str, statisticData.rowIndex, i);
        }
    }
}

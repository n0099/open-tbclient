package com.baidu.spswitch.emotion;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.spswitch.emotion.view.BDEmotionBagLayout;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.spswitch.emotion.view.PopupEmotionManager;
import com.baidu.spswitch.utils.BDEmotionPanelManager;
/* loaded from: classes2.dex */
public class GlobalOnItemClickListenerManager {
    public static final String DELETE_EMOTION = "[delete]";
    public static final int EDIT_CONTENT_DELETE_INTERVAL = 60;
    public static GlobalOnItemClickListenerManager mInstance;
    public EditText mEditText;
    public BDEmotionPanelManager.OnEmotionClickListener mEmotionClickListener;
    public int mEmotionShownMaxRow;
    public int mEmotionSlideCount;
    public boolean mIsDeleteItemLongClick;
    public TextWatcher mTextWatcher;
    public BDEmotionPanelManager.OnVerticalEmotionListener mVerticalEmotionListener;
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public Runnable mEditContentDeleteRunnable = new Runnable() { // from class: com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager.1
        @Override // java.lang.Runnable
        public void run() {
            if (GlobalOnItemClickListenerManager.this.mEditText == null) {
                return;
            }
            GlobalOnItemClickListenerManager.this.mEditText.dispatchKeyEvent(new KeyEvent(0, 67));
            if (GlobalOnItemClickListenerManager.this.mIsDeleteItemLongClick) {
                GlobalOnItemClickListenerManager.this.mMainHandler.postDelayed(this, 60L);
            }
        }
    };

    public static GlobalOnItemClickListenerManager getInstance() {
        if (mInstance == null) {
            synchronized (GlobalOnItemClickListenerManager.class) {
                if (mInstance == null) {
                    mInstance = new GlobalOnItemClickListenerManager();
                }
            }
        }
        return mInstance;
    }

    public void addEmotionShownSlideCount() {
        this.mEmotionSlideCount++;
    }

    public void attachToEditText(EditText editText) {
        this.mEditText = editText;
    }

    public void dismiss() {
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

    public int getEmotionShownMaxRow() {
        return this.mEmotionShownMaxRow;
    }

    public int getEmotionShownSlideCount() {
        return this.mEmotionSlideCount;
    }

    public AdapterView.OnItemClickListener getOnItemClickListener(final EmotionType emotionType, final int i2) {
        return new AdapterView.OnItemClickListener() { // from class: com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j) {
                Object adapter = adapterView.getAdapter();
                if (adapter instanceof BDEmotionBagLayout.EmotionGridViewAdapter) {
                    BDEmotionBagLayout.EmotionGridViewAdapter emotionGridViewAdapter = (BDEmotionBagLayout.EmotionGridViewAdapter) adapter;
                    if (GlobalOnItemClickListenerManager.this.mEditText == null) {
                        return;
                    }
                    if (i3 < emotionGridViewAdapter.getCount() - 1) {
                        String item = emotionGridViewAdapter.getItem(i3);
                        if (TextUtils.isEmpty(item)) {
                            return;
                        }
                        GlobalOnItemClickListenerManager.this.mEditText.getEditableText().insert(GlobalOnItemClickListenerManager.this.mEditText.getSelectionStart(), EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, AppRuntime.getAppContext(), item, GlobalOnItemClickListenerManager.this.mEditText));
                        if (GlobalOnItemClickListenerManager.this.mEmotionClickListener != null) {
                            GlobalOnItemClickListenerManager.this.mEmotionClickListener.onEmotionClick(emotionType, i2, EmotionUtils.getInstance().getEmotionIdByName(emotionType, item), item);
                        }
                    } else if (i3 == emotionGridViewAdapter.getCount() - 1) {
                        if (!GlobalOnItemClickListenerManager.this.mIsDeleteItemLongClick) {
                            GlobalOnItemClickListenerManager.this.mEditText.dispatchKeyEvent(new KeyEvent(0, 67));
                            if (GlobalOnItemClickListenerManager.this.mEmotionClickListener != null) {
                                GlobalOnItemClickListenerManager.this.mEmotionClickListener.onEmotionClick(emotionType, i2, "", GlobalOnItemClickListenerManager.DELETE_EMOTION);
                            }
                        }
                        GlobalOnItemClickListenerManager.this.removeLongClickCallback();
                    }
                }
            }
        };
    }

    public AdapterView.OnItemLongClickListener getOnItemLongClickListener(EmotionType emotionType) {
        return new AdapterView.OnItemLongClickListener() { // from class: com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                Object adapter = adapterView.getAdapter();
                if ((adapter instanceof BDEmotionBagLayout.EmotionGridViewAdapter) && i2 == ((BDEmotionBagLayout.EmotionGridViewAdapter) adapter).getCount() - 1) {
                    GlobalOnItemClickListenerManager.this.performDelLongClick();
                    return false;
                }
                return false;
            }
        };
    }

    public View.OnTouchListener getOnTouchListener(EmotionType emotionType) {
        return new View.OnTouchListener() { // from class: com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    GlobalOnItemClickListenerManager.this.removeLongClickCallback();
                    return false;
                }
                return false;
            }
        };
    }

    public PopupEmotionManager.IShowListener getPopupEmotionShowListener() {
        return new PopupEmotionManager.IShowListener() { // from class: com.baidu.spswitch.emotion.GlobalOnItemClickListenerManager.5
            @Override // com.baidu.spswitch.emotion.view.PopupEmotionManager.IShowListener
            public void show(int i2, String str, int i3, int i4) {
                if (GlobalOnItemClickListenerManager.this.mVerticalEmotionListener != null) {
                    GlobalOnItemClickListenerManager.this.mVerticalEmotionListener.onVerticalEmotionLongClick(EmotionType.EMOTION_CLASSIC_TYPE, i2, EmotionUtils.getInstance().getEmotionIdByName(EmotionType.EMOTION_CLASSIC_TYPE, str), str, i3, i4);
                }
            }
        };
    }

    public boolean isDelLongClick() {
        return this.mIsDeleteItemLongClick;
    }

    public boolean isEditContentEmpty() {
        EditText editText = this.mEditText;
        return editText == null || editText.getEditableText().length() <= 0;
    }

    public void performDelLongClick() {
        if (this.mIsDeleteItemLongClick || this.mEditText == null) {
            return;
        }
        this.mIsDeleteItemLongClick = true;
        this.mMainHandler.post(this.mEditContentDeleteRunnable);
    }

    public void performVerticalDelClick() {
        if (!this.mIsDeleteItemLongClick) {
            this.mEditText.dispatchKeyEvent(new KeyEvent(0, 67));
        }
        removeLongClickCallback();
    }

    public void removeLongClickCallback() {
        this.mMainHandler.removeCallbacks(this.mEditContentDeleteRunnable);
        this.mIsDeleteItemLongClick = false;
    }

    public void resetEmotionShownData() {
        this.mEmotionShownMaxRow = 0;
        this.mEmotionSlideCount = 0;
    }

    public void setEditContentTextWatcher(TextWatcher textWatcher) {
        EditText editText = this.mEditText;
        if (editText == null || textWatcher == null) {
            return;
        }
        editText.removeTextChangedListener(this.mTextWatcher);
        this.mEditText.addTextChangedListener(textWatcher);
        this.mTextWatcher = textWatcher;
    }

    public void setOnEmotionClickListener(BDEmotionPanelManager.OnEmotionClickListener onEmotionClickListener) {
        this.mEmotionClickListener = onEmotionClickListener;
    }

    public void setOnVerticalEmotionListener(BDEmotionPanelManager.OnVerticalEmotionListener onVerticalEmotionListener) {
        this.mVerticalEmotionListener = onVerticalEmotionListener;
    }

    public void updateEmotionShownMaxRow(int i2) {
        if (i2 > this.mEmotionShownMaxRow) {
            this.mEmotionShownMaxRow = i2;
        }
    }

    public void verticalOnItemClick(String str, BDEmotionBagVerticalLayout.EmotionGridViewAdapter.StatisticData statisticData, int i2) {
        if (this.mEditText == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mEditText.getEditableText().insert(this.mEditText.getSelectionStart(), EmotionLoader.getInstance().parseEmotion(EmotionType.EMOTION_CLASSIC_TYPE, AppRuntime.getAppContext(), str, this.mEditText));
        EmotionUtils.getInstance().playEmotionClickSound();
        EmotionUsageUtil.recordEmotionUsage(str);
        if (this.mVerticalEmotionListener != null) {
            this.mVerticalEmotionListener.onVerticalEmotionClick(statisticData.type, statisticData.sectionType, EmotionUtils.getInstance().getEmotionIdByName(statisticData.type, str), str, statisticData.rowIndex, i2);
        }
    }

    public static GlobalOnItemClickListenerManager getInstance(Context context) {
        return getInstance();
    }
}

package com.baidu.searchbox.ugc.emoji;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.util.android.WrappedClipboardManager;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.emoji.edittextrule.IEditTextPatternRule;
import com.baidu.spswitch.emotion.EmotionType;
import com.baidu.spswitch.emotion.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes13.dex */
public class EmojiconEditText extends AppCompatEditText {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "EmojiconEditText";
    private OnDelKeyEventListener delKeyEventListener;
    private TextNumbersChangedListener listener;
    private WrappedClipboardManager mClipboardManager;
    private int mEmojiconSize;
    private int mMaxSize;
    private OnPasteKeyEventListener mOnPasteKeyEventListener;
    private final Map<String, IEditTextPatternRule> mPatternRuleMap;
    private String mTextInClipboard;
    private TextSelectChangedListener selectedListener;

    /* loaded from: classes13.dex */
    public interface OnDelKeyEventListener {
        void onDeleteClick();
    }

    /* loaded from: classes13.dex */
    public interface OnPasteKeyEventListener {
        void onPasteClick();
    }

    /* loaded from: classes13.dex */
    public interface TextNumbersChangedListener {
        void addChanged(int i);

        void back();

        void reduceChanged(int i);
    }

    /* loaded from: classes13.dex */
    public interface TextSelectChangedListener {
        void selectChanged(int i, int i2);
    }

    public EmojiconEditText(Context context) {
        super(context);
        this.mMaxSize = 200;
        this.mPatternRuleMap = new HashMap();
        this.mClipboardManager = WrappedClipboardManager.newInstance(getContext());
    }

    public EmojiconEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxSize = 200;
        this.mPatternRuleMap = new HashMap();
        init(attributeSet, context);
        this.mClipboardManager = WrappedClipboardManager.newInstance(getContext());
    }

    public EmojiconEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxSize = 200;
        this.mPatternRuleMap = new HashMap();
        init(attributeSet, context);
        this.mClipboardManager = WrappedClipboardManager.newInstance(getContext());
    }

    private void init(AttributeSet attributeSet, Context context) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Emojicon);
        this.mEmojiconSize = (int) obtainStyledAttributes.getDimension(R.styleable.Emojicon_emojiconSize, getTextSize() + DeviceUtil.ScreenInfo.dp2px(context, 2.0f));
        obtainStyledAttributes.recycle();
        setText(getText());
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ugc.emoji.EmojiconEditText.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (EmojiconEditText.this.canVerticalScroll()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        addTextChangedListener(new EmojiconEditTextWatcher());
    }

    public void setMaxSize(int i) {
        this.mMaxSize = i;
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String charSequence2 = charSequence.toString();
        Matcher matcher = Pattern.compile("\\[([一-龥\\w])+]").matcher(charSequence2);
        int i4 = 0;
        while (matcher.find()) {
            i4++;
            charSequence2 = charSequence2.replace(matcher.group(), "");
        }
        int length = i4 + charSequence2.length();
        if (length <= this.mMaxSize) {
            if (this.listener != null) {
                this.listener.reduceChanged(length);
            }
        } else if (this.listener != null) {
            this.listener.addChanged(length);
        }
    }

    public void setEmojiconSize(int i) {
        this.mEmojiconSize = i;
    }

    public void setListener(TextNumbersChangedListener textNumbersChangedListener) {
        this.listener = textNumbersChangedListener;
    }

    public void removeListener() {
        this.listener = null;
    }

    public void setSelectListener(TextSelectChangedListener textSelectChangedListener) {
        this.selectedListener = textSelectChangedListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canVerticalScroll() {
        int scrollY = getScrollY();
        int height = getLayout().getHeight() - getHeight();
        if (height == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height + (-1);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && this.listener != null) {
            this.listener.back();
            return false;
        }
        return false;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (this.selectedListener != null) {
            this.selectedListener.selectChanged(i, i2);
        }
        if (this.mPatternRuleMap != null) {
            for (Map.Entry<String, IEditTextPatternRule> entry : this.mPatternRuleMap.entrySet()) {
                entry.getValue().onSelectionChanged(i, i2);
            }
        }
    }

    @Override // android.support.v7.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection == null) {
            return null;
        }
        return new ZanyInputConnection(onCreateInputConnection, true);
    }

    /* loaded from: classes13.dex */
    private class ZanyInputConnection extends InputConnectionWrapper {
        public ZanyInputConnection(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            boolean z;
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67) {
                boolean z2 = false;
                if (EmojiconEditText.this.mPatternRuleMap != null) {
                    Iterator it = EmojiconEditText.this.mPatternRuleMap.entrySet().iterator();
                    while (true) {
                        z = z2;
                        if (!it.hasNext()) {
                            break;
                        }
                        z2 = ((IEditTextPatternRule) ((Map.Entry) it.next()).getValue()).onDelete() ? true : z;
                    }
                } else {
                    z = false;
                }
                if (EmojiconEditText.this.delKeyEventListener != null) {
                    EmojiconEditText.this.delKeyEventListener.onDeleteClick();
                    return true;
                } else if (z) {
                    return true;
                } else {
                    return super.sendKeyEvent(keyEvent);
                }
            }
            return super.sendKeyEvent(keyEvent);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            if (i == 1 && i2 == 0) {
                return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
            }
            return super.deleteSurroundingText(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class EmojiconEditTextWatcher implements TextWatcher {
        private EmojiconEditTextWatcher() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (EmojiconEditText.this.mPatternRuleMap != null) {
                for (Map.Entry entry : EmojiconEditText.this.mPatternRuleMap.entrySet()) {
                    ((IEditTextPatternRule) entry.getValue()).beforeTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (EmojiconEditText.this.mPatternRuleMap != null) {
                for (Map.Entry entry : EmojiconEditText.this.mPatternRuleMap.entrySet()) {
                    ((IEditTextPatternRule) entry.getValue()).onTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (EmojiconEditText.this.mPatternRuleMap != null) {
                for (Map.Entry entry : EmojiconEditText.this.mPatternRuleMap.entrySet()) {
                    ((IEditTextPatternRule) entry.getValue()).afterTextChanged(editable);
                }
            }
        }
    }

    public void addRule(String str, IEditTextPatternRule iEditTextPatternRule) {
        this.mPatternRuleMap.put(str, iEditTextPatternRule);
    }

    public void removeRule(String str) {
        this.mPatternRuleMap.remove(str);
    }

    public void removeAllRules() {
        this.mPatternRuleMap.clear();
    }

    public boolean containsRule(IEditTextPatternRule iEditTextPatternRule) {
        return this.mPatternRuleMap.containsValue(iEditTextPatternRule);
    }

    public void setDelKeyEventListener(OnDelKeyEventListener onDelKeyEventListener) {
        this.delKeyEventListener = onDelKeyEventListener;
    }

    public void setPasteKeyEventListener(OnPasteKeyEventListener onPasteKeyEventListener) {
        this.mOnPasteKeyEventListener = onPasteKeyEventListener;
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        switch (i) {
            case 16908322:
            case 16908337:
                if (this.mOnPasteKeyEventListener != null) {
                    this.mOnPasteKeyEventListener.onPasteClick();
                }
                handlePasteEmojiDisplay();
                break;
        }
        return super.onTextContextMenuItem(i);
    }

    private void handlePasteEmojiDisplay() {
        CharSequence text = this.mClipboardManager.getText();
        if (text != null && Pattern.compile("\\[([一-龥\\w])+\\]").matcher(text).find()) {
            this.mTextInClipboard = text.toString();
            this.mClipboardManager.setText(HanziToPinyin.Token.SEPARATOR);
            SpannableString a = a.Go().a(EmotionType.EMOTION_CLASSIC_TYPE, getContext(), this.mTextInClipboard, this);
            int selectionStart = getSelectionStart();
            final Editable editableText = getEditableText();
            editableText.insert(selectionStart, a);
            post(new Runnable() { // from class: com.baidu.searchbox.ugc.emoji.EmojiconEditText.2
                @Override // java.lang.Runnable
                public void run() {
                    int selectionStart2 = EmojiconEditText.this.getSelectionStart();
                    if (selectionStart2 > 0) {
                        editableText.delete(selectionStart2 - 1, selectionStart2);
                    }
                    EmojiconEditText.this.restoreClipboard();
                }
            });
        }
    }

    public void handleDraftEmojiDisplay() {
        Editable editableText = getEditableText();
        if (!TextUtils.isEmpty(editableText) && Pattern.compile("\\[([一-龥\\w])+\\]").matcher(editableText).find()) {
            getEditableText().replace(0, editableText.length(), a.Go().a(EmotionType.EMOTION_CLASSIC_TYPE, getContext(), editableText, this));
        }
    }

    public void restoreClipboard() {
        this.mClipboardManager.setText(this.mTextInClipboard);
    }

    public void clearData() {
        removeListener();
        removeAllRules();
    }
}

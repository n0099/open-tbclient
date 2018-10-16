package com.baidu.searchbox.ng.ai.apps.textarea.parser;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsRectPosition;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.textarea.ShowConfirmBarLayout;
import com.baidu.searchbox.ng.ai.apps.textarea.SoftGlobalLayoutListener;
import com.baidu.searchbox.ng.ai.apps.textarea.info.TextAreaCallbackInfo;
import com.baidu.searchbox.ng.ai.apps.textarea.info.TextAreaStatusInfo;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewType;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewFinder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TextAreaSecondaryParser {
    private static final int CONFIRM_BAR_HEIGHT = 38;
    protected static final boolean DEBUG = false;
    private static final int DEF_HEIGHT = 0;
    private static final int DEF_LENGTH = 0;
    private static final int DEF_LINE_COUNT = 1;
    private static final int DELAY_TIME = 50;
    private static final String FONT_WEIGHT_BOLD = "bold";
    private static final String FONT_WEIGHT_NORMAL = "normal";
    private static final int SHOW_FLAGS = 0;
    protected static final String TAG = "TextAreaSecondaryParser";
    private static final String TEXT_ALIGN_CENTER = "center";
    private static final String TEXT_ALIGN_LEFT = "left";
    private static final String TEXT_ALIGN_RIGHT = "right";
    private SendAsyncCallback mCallback;
    private AiAppsFragment mFragment;
    private int mKeyboardHeight;
    private ShowConfirmBarLayout mShowConfirmBarLayout;
    private int mTextAreaHeight;
    private HashMap<String, EditText> mTextAreaMap = null;
    private HashMap<String, TextAreaStatusInfo> mTextAreaInfoMap = null;
    private AiAppsActivity mAiAppsActivity = AiAppsController.getInstance().getActivity();

    /* loaded from: classes2.dex */
    public interface SendAsyncCallback {
        void callback(String str, JSONObject jSONObject);
    }

    public TextAreaSecondaryParser() {
        AiAppsFragment topAiAppsFragment;
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager != null && (topAiAppsFragment = aiAppsFragmentManager.getTopAiAppsFragment()) != null) {
            this.mFragment = topAiAppsFragment;
        }
    }

    public boolean addTextAreaEditText(SendAsyncCallback sendAsyncCallback, Context context, JSONObject jSONObject) {
        this.mCallback = sendAsyncCallback;
        TextAreaStatusInfo createTextAreaStatusInfo = TextAreaStatusInfo.createTextAreaStatusInfo(jSONObject);
        if (this.mTextAreaMap == null) {
            this.mTextAreaMap = new HashMap<>();
        }
        if (this.mTextAreaMap.get(createTextAreaStatusInfo.id) != null) {
            AiAppsLog.w(TAG, "insert failed: text has added with same view id");
            return false;
        }
        if (this.mTextAreaInfoMap == null) {
            this.mTextAreaInfoMap = new HashMap<>();
        }
        if (this.mAiAppsActivity != null) {
            EditText editText = new EditText(this.mAiAppsActivity);
            this.mTextAreaInfoMap.put(createTextAreaStatusInfo.id, createTextAreaStatusInfo);
            setTextAreaAttr(true, editText, createTextAreaStatusInfo, this.mAiAppsActivity);
            this.mTextAreaMap.put(createTextAreaStatusInfo.id, editText);
            editText.setTag(createTextAreaStatusInfo.id);
            setTextAreaListener(editText, this.mAiAppsActivity, createTextAreaStatusInfo);
            if (createTextAreaStatusInfo.mFixed) {
                if (this.mFragment != null) {
                    FrameLayout webViewContainer = this.mFragment.getWebViewContainer();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(createTextAreaStatusInfo.mWidth, createTextAreaStatusInfo.mHeight);
                    layoutParams.topMargin = createTextAreaStatusInfo.mTop;
                    layoutParams.leftMargin = createTextAreaStatusInfo.mLeft;
                    webViewContainer.addView(editText, layoutParams);
                    return true;
                }
                return false;
            }
            AiAppsRectPosition aiAppsRectPosition = new AiAppsRectPosition(createTextAreaStatusInfo.mLeft, createTextAreaStatusInfo.mTop, createTextAreaStatusInfo.mWidth, createTextAreaStatusInfo.mHeight);
            if (createTextAreaStatusInfo.mAutoHeight) {
                aiAppsRectPosition.setHeightAuto(true);
            }
            createTextAreaStatusInfo.position = aiAppsRectPosition;
            return new AiAppsNAViewContainer(context).insertView(editText, createTextAreaStatusInfo);
        }
        return false;
    }

    public boolean updateTextAreaById(JSONObject jSONObject) {
        if (this.mAiAppsActivity == null) {
            return false;
        }
        TextAreaStatusInfo createTextAreaStatusInfo = TextAreaStatusInfo.createTextAreaStatusInfo(jSONObject);
        EditText editText = this.mTextAreaMap.get(createTextAreaStatusInfo.id);
        this.mTextAreaInfoMap.put(createTextAreaStatusInfo.id, createTextAreaStatusInfo);
        if (editText != null) {
            setTextAreaAttr(false, editText, createTextAreaStatusInfo, this.mAiAppsActivity);
            if (createTextAreaStatusInfo.mFixed) {
                if (this.mFragment != null) {
                    FrameLayout webViewContainer = this.mFragment.getWebViewContainer();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(createTextAreaStatusInfo.mWidth, createTextAreaStatusInfo.mHeight);
                    layoutParams.topMargin = createTextAreaStatusInfo.mTop;
                    layoutParams.leftMargin = createTextAreaStatusInfo.mLeft;
                    if (!editText.getParent().equals(webViewContainer)) {
                        AiAppsLog.d(TAG, "textarea change to fixed");
                        removeTextAreaById(true, createTextAreaStatusInfo.slaveId, createTextAreaStatusInfo.id, createTextAreaStatusInfo.parentId);
                        ((ViewGroup) editText.getParent()).removeView(editText);
                        webViewContainer.addView(editText, layoutParams);
                    } else {
                        webViewContainer.updateViewLayout(editText, layoutParams);
                    }
                    return true;
                }
                return false;
            }
            AiAppsRectPosition aiAppsRectPosition = new AiAppsRectPosition(createTextAreaStatusInfo.mLeft, createTextAreaStatusInfo.mTop, createTextAreaStatusInfo.mWidth, createTextAreaStatusInfo.mHeight);
            if (createTextAreaStatusInfo.mAutoHeight) {
                aiAppsRectPosition.setHeightAuto(true);
            }
            createTextAreaStatusInfo.position = aiAppsRectPosition;
            AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(createTextAreaStatusInfo, null);
            return findNAViewContainer != null && findNAViewContainer.updateView(createTextAreaStatusInfo);
        }
        return false;
    }

    public boolean removeTextAreaById(boolean z, String str, String str2, String str3) {
        EditText editText = this.mTextAreaMap.get(str2);
        if (editText == null) {
            return false;
        }
        AiAppsNaViewModel aiAppsNaViewModel = new AiAppsNaViewModel("", AiAppsNAViewType.TEXTAREA);
        aiAppsNaViewModel.slaveId = str;
        aiAppsNaViewModel.id = str2;
        aiAppsNaViewModel.parentId = str3;
        AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(aiAppsNaViewModel, null);
        if (findNAViewContainer == null) {
            removeFixedTextArea(editText);
        } else if (!findNAViewContainer.removeView()) {
            removeFixedTextArea(editText);
        }
        if (z) {
            return true;
        }
        this.mTextAreaMap.remove(str2);
        this.mTextAreaInfoMap.remove(str2);
        if (this.mTextAreaMap.size() == 0) {
            TextAreaBaseParser.getInstance().destroyTextAreaSecondaryParser(str);
            this.mTextAreaMap = null;
        }
        return true;
    }

    private boolean removeFixedTextArea(EditText editText) {
        if (this.mFragment == null) {
            return false;
        }
        this.mFragment.getWebViewContainer().removeView(editText);
        return true;
    }

    public void removeAllTextArea(String str) {
        TextAreaSecondaryParser textAreaSecondaryParser = TextAreaBaseParser.getInstance().getTextAreaSecondaryParser(str);
        if (textAreaSecondaryParser != null) {
            for (EditText editText : textAreaSecondaryParser.mTextAreaMap.values()) {
                if (editText != null) {
                    String obj = editText.getTag().toString();
                    AiAppsNaViewModel aiAppsNaViewModel = new AiAppsNaViewModel("", AiAppsNAViewType.TEXTAREA);
                    aiAppsNaViewModel.slaveId = str;
                    aiAppsNaViewModel.id = obj;
                    AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(aiAppsNaViewModel, null);
                    if (findNAViewContainer != null && !findNAViewContainer.removeView() && this.mFragment != null) {
                        this.mFragment.getWebViewContainer().removeView(editText);
                    }
                }
            }
            TextAreaBaseParser.getInstance().destroyTextAreaSecondaryParser(str);
            textAreaSecondaryParser.mTextAreaMap = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void setTextAreaAttr(boolean z, final EditText editText, final TextAreaStatusInfo textAreaStatusInfo, final Activity activity) {
        boolean z2;
        StyleSpan styleSpan;
        boolean z3;
        boolean z4;
        if (!TextUtils.equals(textAreaStatusInfo.mValue, editText.getText())) {
            editText.setText(textAreaStatusInfo.mValue);
        }
        editText.setBackgroundColor(0);
        SpannableString spannableString = new SpannableString(textAreaStatusInfo.mHint);
        String str = textAreaStatusInfo.mPlaceHolderFontWeight;
        switch (str.hashCode()) {
            case -1039745817:
                if (str.equals("normal")) {
                    z2 = false;
                    break;
                }
                z2 = true;
                break;
            case 3029637:
                if (str.equals(FONT_WEIGHT_BOLD)) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            default:
                z2 = true;
                break;
        }
        switch (z2) {
            case false:
                styleSpan = new StyleSpan(0);
                break;
            case true:
                styleSpan = new StyleSpan(1);
                break;
            default:
                styleSpan = new StyleSpan(0);
                break;
        }
        spannableString.setSpan(styleSpan, 0, textAreaStatusInfo.mHint.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(AiAppsConfigData.parseColor(textAreaStatusInfo.mPlaceHolderFontColor)), 0, textAreaStatusInfo.mHint.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(textAreaStatusInfo.mPlaceHolderFontSize, true), 0, textAreaStatusInfo.mHint.length(), 33);
        editText.setHint(spannableString);
        int length = editText.getText().length();
        if (textAreaStatusInfo.mFocus) {
            if (textAreaStatusInfo.mCursor <= length && textAreaStatusInfo.mCursor >= 0) {
                editText.setSelection(textAreaStatusInfo.mCursor);
            } else {
                editText.setSelection(length);
            }
        }
        if (textAreaStatusInfo.mSelectionEnd <= length && textAreaStatusInfo.mSelectionEnd > 0 && textAreaStatusInfo.mSelectionStart <= textAreaStatusInfo.mSelectionEnd && textAreaStatusInfo.mSelectionStart > 0 && textAreaStatusInfo.mFocus && !editText.hasFocus()) {
            editText.setSelection(textAreaStatusInfo.mSelectionStart, textAreaStatusInfo.mSelectionEnd);
        }
        if (textAreaStatusInfo.mMaxLength >= 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(textAreaStatusInfo.mMaxLength)});
        }
        String str2 = textAreaStatusInfo.mFontWeight;
        switch (str2.hashCode()) {
            case -1039745817:
                if (str2.equals("normal")) {
                    z3 = false;
                    break;
                }
                z3 = true;
                break;
            case 3029637:
                if (str2.equals(FONT_WEIGHT_BOLD)) {
                    z3 = true;
                    break;
                }
                z3 = true;
                break;
            default:
                z3 = true;
                break;
        }
        switch (z3) {
            case false:
                editText.setTypeface(Typeface.SANS_SERIF, 0);
                break;
            case true:
                editText.setTypeface(Typeface.SANS_SERIF, 1);
                break;
            default:
                editText.setTypeface(Typeface.SANS_SERIF, 0);
                break;
        }
        String str3 = textAreaStatusInfo.mTextAlign;
        switch (str3.hashCode()) {
            case -1364013995:
                if (str3.equals(TEXT_ALIGN_CENTER)) {
                    z4 = true;
                    break;
                }
                z4 = true;
                break;
            case 3317767:
                if (str3.equals("left")) {
                    z4 = false;
                    break;
                }
                z4 = true;
                break;
            case 108511772:
                if (str3.equals(TEXT_ALIGN_RIGHT)) {
                    z4 = true;
                    break;
                }
                z4 = true;
                break;
            default:
                z4 = true;
                break;
        }
        switch (z4) {
            case false:
                editText.setGravity(GravityCompat.START);
                break;
            case true:
                editText.setGravity(GravityCompat.END);
                break;
            case true:
                editText.setGravity(17);
                break;
            default:
                editText.setGravity(GravityCompat.START);
                break;
        }
        editText.setTextColor(AiAppsConfigData.parseColor(textAreaStatusInfo.mColor));
        editText.setTextSize(textAreaStatusInfo.mFontSize);
        if (textAreaStatusInfo.mPaddingArray != null) {
            editText.setPadding(AiAppsUIUtils.dp2px(textAreaStatusInfo.mPaddingArray.optInt(3)), AiAppsUIUtils.dp2px(textAreaStatusInfo.mPaddingArray.optInt(0)), AiAppsUIUtils.dp2px(textAreaStatusInfo.mPaddingArray.optInt(1)), AiAppsUIUtils.dp2px(textAreaStatusInfo.mPaddingArray.optInt(2)));
        }
        editText.setLineSpacing(textAreaStatusInfo.mLineSpace, 1.0f);
        if (textAreaStatusInfo.mAutoHeight) {
            if (z) {
                editText.setMinHeight(textAreaStatusInfo.mHeight);
            }
            textAreaStatusInfo.mHeight = -2;
        } else if (z) {
            editText.setMaxHeight(textAreaStatusInfo.mHeight);
        }
        new Handler().post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaSecondaryParser.1
            @Override // java.lang.Runnable
            public void run() {
                if (activity == null) {
                    AiAppsLog.w(TextAreaSecondaryParser.TAG, "activity is null, set textarea attr failed");
                    return;
                }
                InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
                if (inputMethodManager != null && textAreaStatusInfo.mFocus) {
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.requestFocus();
                    inputMethodManager.showSoftInput(editText, 0);
                }
            }
        });
        editText.setEnabled(!textAreaStatusInfo.mDisable);
    }

    private void setTextAreaListener(final EditText editText, final AiAppsActivity aiAppsActivity, final TextAreaStatusInfo textAreaStatusInfo) {
        editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaSecondaryParser.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (editText.getLineCount() > 0) {
                    textAreaStatusInfo.mLineCount = editText.getLineCount();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editText.hasFocus()) {
                    AiAppsLog.d(TextAreaSecondaryParser.TAG, "send input callback");
                    TextAreaSecondaryParser.this.changeTextAreaStatus(editText, "input");
                }
            }
        });
        SoftGlobalLayoutListener.setListener(textAreaStatusInfo.id, aiAppsActivity, new SoftGlobalLayoutListener.OnSoftGlobalLayoutChangeListener() { // from class: com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaSecondaryParser.3
            @Override // com.baidu.searchbox.ng.ai.apps.textarea.SoftGlobalLayoutListener.OnSoftGlobalLayoutChangeListener
            public void keyBoardShow(String str, int i) {
                NgWebView ngWebView = AiAppsController.getInstance().getNgWebView();
                if (TextAreaSecondaryParser.this.mTextAreaInfoMap.get(str) != null && TextAreaSecondaryParser.this.mKeyboardHeight != i && editText.hasFocus() && ngWebView != null) {
                    TextAreaSecondaryParser.this.mKeyboardHeight = i;
                    TextAreaSecondaryParser.this.mTextAreaHeight = editText.getHeight();
                    TextAreaSecondaryParser.this.changeTextAreaStatus(editText, "focus");
                    boolean z = ((TextAreaStatusInfo) TextAreaSecondaryParser.this.mTextAreaInfoMap.get(str)).mAdjustPosition;
                    int i2 = 0;
                    if (((TextAreaStatusInfo) TextAreaSecondaryParser.this.mTextAreaInfoMap.get(str)).mShowConfirmBar) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                        i2 = AiAppsUIUtils.dp2px(38.0f);
                        if (TextAreaSecondaryParser.this.mShowConfirmBarLayout == null) {
                            TextAreaSecondaryParser.this.mShowConfirmBarLayout = new ShowConfirmBarLayout(aiAppsActivity);
                            TextAreaSecondaryParser.this.mShowConfirmBarLayout.setOnConfirmButtonClickListener(new ShowConfirmBarLayout.OnConfirmButtonClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaSecondaryParser.3.1
                                @Override // com.baidu.searchbox.ng.ai.apps.textarea.ShowConfirmBarLayout.OnConfirmButtonClickListener
                                public void onClick(View view) {
                                    if (aiAppsActivity == null) {
                                        AiAppsLog.w(TextAreaSecondaryParser.TAG, "activity is null when click confirmBar");
                                        return;
                                    }
                                    InputMethodManager inputMethodManager = (InputMethodManager) aiAppsActivity.getSystemService("input_method");
                                    if (inputMethodManager != null) {
                                        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                    }
                                    AiAppsLog.d(TextAreaSecondaryParser.TAG, "send confirm change callback");
                                    TextAreaSecondaryParser.this.changeTextAreaStatus(editText, TextAreaCallbackInfo.EVENT_NAME_CONFIRM);
                                }
                            });
                            View decorView = aiAppsActivity.getWindow().getDecorView();
                            layoutParams.topMargin = ((decorView.getHeight() - i) - i2) - AiAppsUIUtils.getNavigationBarHeight();
                            ((FrameLayout) decorView.findViewById(16908290)).addView(TextAreaSecondaryParser.this.mShowConfirmBarLayout, layoutParams);
                        }
                    }
                    if (z) {
                        int webViewScrollY = ngWebView.getCurrentWebView().getWebViewScrollY() + ((TextAreaSecondaryParser.this.mFragment.getWebViewContainer().getHeight() - ((TextAreaStatusInfo) TextAreaSecondaryParser.this.mTextAreaInfoMap.get(str)).mTop) - editText.getHeight());
                        int i3 = ((TextAreaStatusInfo) TextAreaSecondaryParser.this.mTextAreaInfoMap.get(str)).mCursorSpacing;
                        if (webViewScrollY - i3 < i) {
                            if (i3 > webViewScrollY) {
                                TextAreaSecondaryParser.this.mFragment.getWebViewContainer().setScrollY(i2 + i);
                            } else {
                                TextAreaSecondaryParser.this.mFragment.getWebViewContainer().setScrollY(i3 + (i - webViewScrollY) + i2);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.searchbox.ng.ai.apps.textarea.SoftGlobalLayoutListener.OnSoftGlobalLayoutChangeListener
            public void keyBoardHide(String str, int i) {
                if (TextAreaSecondaryParser.this.mKeyboardHeight != 0 && TextAreaSecondaryParser.this.mTextAreaInfoMap.get(str) != null) {
                    TextAreaSecondaryParser.this.mKeyboardHeight = 0;
                    if (TextAreaSecondaryParser.this.mFragment.getWebViewContainer().getScrollY() > 0) {
                        TextAreaSecondaryParser.this.mFragment.getWebViewContainer().setScrollY(0);
                    }
                    if (TextAreaSecondaryParser.this.mShowConfirmBarLayout != null && TextAreaSecondaryParser.this.mShowConfirmBarLayout.getVisibility() == 0) {
                        ((FrameLayout) aiAppsActivity.getWindow().getDecorView().findViewById(16908290)).removeView(TextAreaSecondaryParser.this.mShowConfirmBarLayout);
                        TextAreaSecondaryParser.this.mShowConfirmBarLayout = null;
                    }
                    AiAppsLog.d(TextAreaSecondaryParser.TAG, "send blur change callback");
                    TextAreaSecondaryParser.this.changeTextAreaStatus(editText, TextAreaCallbackInfo.EVENT_NAME_BLUR);
                    if (editText.getParent() != null) {
                        ((ViewGroup) editText.getParent()).requestFocus();
                        editText.clearFocus();
                    }
                }
            }

            @Override // com.baidu.searchbox.ng.ai.apps.textarea.SoftGlobalLayoutListener.OnSoftGlobalLayoutChangeListener
            public void onGlobalLayout(String str) {
                if (TextAreaSecondaryParser.this.mTextAreaInfoMap.get(str) != null && ((TextAreaStatusInfo) TextAreaSecondaryParser.this.mTextAreaInfoMap.get(str)).mLineCount != editText.getLineCount()) {
                    AiAppsLog.d(TextAreaSecondaryParser.TAG, "send line change callback");
                    TextAreaSecondaryParser.this.changeTextAreaStatus(editText, TextAreaCallbackInfo.EVENT_NAME_LINE_CHANGE);
                    ((TextAreaStatusInfo) TextAreaSecondaryParser.this.mTextAreaInfoMap.get(str)).mLineCount = editText.getLineCount();
                    TextAreaSecondaryParser.this.changeContainerScrollY(editText, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeContainerScrollY(EditText editText, String str) {
        boolean z = this.mTextAreaInfoMap.get(str).mAdjustPosition;
        if (editText.hasFocus() && !this.mTextAreaInfoMap.get(str).mFixed) {
            if (this.mKeyboardHeight > 0 && z) {
                int height = (editText.getHeight() - this.mTextAreaHeight) + this.mFragment.getWebViewContainer().getScrollY();
                if (height > 0) {
                    this.mFragment.getWebViewContainer().setScrollY(height);
                } else {
                    this.mFragment.getWebViewContainer().setScrollY(0);
                }
            }
            this.mTextAreaHeight = editText.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeTextAreaStatus(final EditText editText, final String str) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.textarea.parser.TextAreaSecondaryParser.4
            @Override // java.lang.Runnable
            public void run() {
                if (editText != null) {
                    JSONObject jSONObject = new JSONObject();
                    String obj = editText.getTag().toString();
                    try {
                        jSONObject.put(TextAreaCallbackInfo.EVENT_NAME_KEY, str);
                        jSONObject.put("value", editText.getText().toString());
                        jSONObject.put(TextAreaCallbackInfo.CURSOR_KEY, editText.getSelectionStart());
                        jSONObject.put(TextAreaCallbackInfo.LINE_COUNT_KEY, editText.getLineCount());
                        jSONObject.put("height", AiAppsUIUtils.px2dp(editText.getHeight()));
                        jSONObject.put(TextAreaCallbackInfo.KEYBOARD_HEIGHT_KEY, TextAreaSecondaryParser.this.mKeyboardHeight);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    TextAreaSecondaryParser.this.mCallback.callback(obj, jSONObject);
                }
            }
        }, 50L);
    }
}

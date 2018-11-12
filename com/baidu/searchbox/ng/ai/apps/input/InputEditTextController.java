package com.baidu.searchbox.ng.ai.apps.input;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.config.AiAppsConfigData;
import com.baidu.searchbox.ng.ai.apps.textarea.SoftGlobalLayoutListener;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewFinder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class InputEditTextController {
    private static final String CONFIRM_TYPE_DONE = "done";
    private static final String CONFIRM_TYPE_GO = "go";
    private static final String CONFIRM_TYPE_NEXT = "next";
    private static final String CONFIRM_TYPE_SEARCH = "search";
    private static final String CONFIRM_TYPE_SEND = "send";
    private static final String CURSOR_OFFSET = "cursorOffset";
    protected static final boolean DEBUG = false;
    private static final int DEF_HEIGHT = 0;
    private static final int DEF_LENGTH = 0;
    private static final String DIGIT = "digit";
    private static final String EVENT_NAME_BLUR = "blur";
    private static final String EVENT_NAME_CHANGE = "change";
    private static final String EVENT_NAME_CONFIRM = "confirm";
    private static final String EVENT_NAME_KEY = "eventName";
    private static final String FONT_WEIGHT_BOLD = "bold";
    private static final String FONT_WEIGHT_BOLD_ITALIC = "boldItalic";
    private static final String FONT_WEIGHT_ITALIC = "italic";
    private static final String FONT_WEIGHT_NORMAL = "normal";
    private static final String NUMBER = "number";
    private static final int PADDING = 0;
    private static final int PADDING_TOP = -6;
    private static final int SHOW_FLAGS = 0;
    protected static final String TAG = "InputEditTextController";
    private static final String TEXT = "text";
    private static final String TEXT_ALIGN_CENTER = "center";
    private static final String TEXT_ALIGN_LEFT = "left";
    private static final String TEXT_ALIGN_RIGHT = "right";
    private static final String VALUE_KEY = "value";
    private SendAsyncCallback mCallback;
    private AiAppsFragment mFragment;
    private InputInfo mInputInfo = new InputInfo();
    private int mKeyboardHeight;

    /* loaded from: classes2.dex */
    public interface SendAsyncCallback {
        void callback(JSONObject jSONObject);
    }

    public InputEditTextController(AiAppsFragment aiAppsFragment, SendAsyncCallback sendAsyncCallback) {
        this.mFragment = aiAppsFragment;
        this.mCallback = sendAsyncCallback;
    }

    public boolean updateInputTextVisible(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        InputInfo inputInfo = new InputInfo();
        inputInfo.fastParseFromJson(jSONObject);
        AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(inputInfo, null);
        if (findNAViewContainer != null) {
            findNAViewContainer.setHidden(inputInfo.hidden);
            findNAViewContainer.updateView(inputInfo);
            return true;
        }
        return false;
    }

    private void closeOldEditText() {
        EditText inputEditText = InputEditTextProvider.getInstance().getInputEditText();
        if (inputEditText != null) {
            AiAppsLog.w(TAG, "old editText is destroyed");
            closeInputEditText(inputEditText);
        }
    }

    private InputInfo createInputInfo(JSONObject jSONObject) {
        InputInfo inputInfo = new InputInfo();
        try {
            inputInfo.parseFromJson(jSONObject);
        } catch (JSONException e) {
            AiAppsLog.e("Input", "parsing InputInfo occurs exception", e);
        }
        return inputInfo;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean addInputEditText(Context context, JSONObject jSONObject) {
        boolean z;
        char c;
        boolean z2;
        char c2 = 65535;
        closeOldEditText();
        InputInfo createInputInfo = createInputInfo(jSONObject);
        this.mInputInfo = createInputInfo;
        AiAppsActivity activity = AiAppsController.getInstance().getActivity();
        if (activity == null) {
            AiAppsLog.w(TAG, "activity is null when add input");
            return false;
        }
        EditText createInputEditText = InputEditTextProvider.getInstance().createInputEditText(context);
        createInputEditText.setText(createInputInfo.value);
        createInputEditText.setSingleLine(true);
        int length = createInputEditText.getText().length();
        String str = createInputInfo.type;
        switch (str.hashCode()) {
            case -1034364087:
                if (str.equals(NUMBER)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 3556653:
                if (str.equals("text")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 95582509:
                if (str.equals(DIGIT)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case true:
                createInputEditText.setInputType(2);
                break;
            case true:
                createInputEditText.setInputType(8194);
                break;
        }
        if (createInputInfo.isPassword) {
            createInputEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (createInputInfo.cursor <= length && createInputInfo.cursor >= 0) {
            createInputEditText.setSelection(createInputInfo.cursor);
        }
        if (createInputInfo.selectionEnd <= length && createInputInfo.selectionStart >= 0 && createInputInfo.selectionStart <= createInputInfo.selectionEnd) {
            createInputEditText.setSelection(createInputInfo.selectionStart, createInputInfo.selectionEnd);
        }
        if (createInputInfo.maxLength >= 0) {
            createInputEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(createInputInfo.maxLength)});
        }
        String str2 = createInputInfo.confirmType;
        switch (str2.hashCode()) {
            case -906336856:
                if (str2.equals("search")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3304:
                if (str2.equals(CONFIRM_TYPE_GO)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3089282:
                if (str2.equals(CONFIRM_TYPE_DONE)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3377907:
                if (str2.equals("next")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3526536:
                if (str2.equals(CONFIRM_TYPE_SEND)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                createInputEditText.setImeOptions(4);
                break;
            case 1:
                createInputEditText.setImeOptions(3);
                break;
            case 2:
                createInputEditText.setImeOptions(5);
                break;
            case 3:
                createInputEditText.setImeOptions(2);
                break;
            case 4:
                createInputEditText.setImeOptions(6);
                break;
        }
        String str3 = createInputInfo.fontWeight;
        switch (str3.hashCode()) {
            case -1178781136:
                if (str3.equals(FONT_WEIGHT_ITALIC)) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case -1039745817:
                if (str3.equals("normal")) {
                    z2 = false;
                    break;
                }
                z2 = true;
                break;
            case -841373419:
                if (str3.equals(FONT_WEIGHT_BOLD_ITALIC)) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 3029637:
                if (str3.equals(FONT_WEIGHT_BOLD)) {
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
                createInputEditText.setTypeface(Typeface.SANS_SERIF, 0);
                break;
            case true:
                createInputEditText.setTypeface(Typeface.SANS_SERIF, 1);
                break;
            case true:
                createInputEditText.setTypeface(Typeface.SANS_SERIF, 2);
                break;
            case true:
                createInputEditText.setTypeface(Typeface.SANS_SERIF, 3);
                break;
            default:
                createInputEditText.setTypeface(Typeface.SANS_SERIF, 0);
                break;
        }
        String str4 = createInputInfo.textAlign;
        switch (str4.hashCode()) {
            case -1364013995:
                if (str4.equals("center")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str4.equals("left")) {
                    c2 = 0;
                    break;
                }
                break;
            case 108511772:
                if (str4.equals("right")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                createInputEditText.setGravity(8388627);
                break;
            case 1:
                createInputEditText.setGravity(8388629);
                break;
            case 2:
                createInputEditText.setGravity(17);
                break;
            default:
                createInputEditText.setGravity(8388627);
                break;
        }
        createInputEditText.setTextColor(AiAppsConfigData.parseColor(createInputInfo.color));
        createInputEditText.setTextSize(1, createInputInfo.fontSize);
        createInputEditText.setPadding(0, -6, 0, 0);
        createInputEditText.setBackgroundColor(context.getResources().getColor(R.color.aiapps_transparent));
        setInputListener(createInputEditText, createInputInfo, activity);
        new AiAppsNAViewContainer(context).insertView(createInputEditText, createInputInfo);
        createInputEditText.setFocusable(true);
        createInputEditText.setFocusableInTouchMode(true);
        createInputEditText.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(createInputEditText, 0);
        }
        return true;
    }

    private void setInputListener(final EditText editText, final InputInfo inputInfo, AiAppsActivity aiAppsActivity) {
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.searchbox.ng.ai.apps.input.InputEditTextController.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (inputInfo.needConfirmHold) {
                    return true;
                }
                InputEditTextController.this.changeInputEditTextStatus(InputEditTextProvider.getInstance().getInputEditText(), "confirm");
                editText.clearFocus();
                return false;
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.searchbox.ng.ai.apps.input.InputEditTextController.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                InputEditTextController.this.changeInputEditTextStatus(InputEditTextProvider.getInstance().getInputEditText(), InputEditTextController.EVENT_NAME_CHANGE);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.searchbox.ng.ai.apps.input.InputEditTextController.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    AiAppsLog.d(InputEditTextController.TAG, "send blur callback");
                    InputEditTextController.this.changeInputEditTextStatus(InputEditTextProvider.getInstance().getInputEditText(), "blur");
                }
            }
        });
        SoftGlobalLayoutListener.setListener(this.mInputInfo.id, aiAppsActivity, new SoftGlobalLayoutListener.OnSoftGlobalLayoutChangeListener() { // from class: com.baidu.searchbox.ng.ai.apps.input.InputEditTextController.4
            @Override // com.baidu.searchbox.ng.ai.apps.textarea.SoftGlobalLayoutListener.OnSoftGlobalLayoutChangeListener
            public void keyBoardShow(String str, int i) {
                NgWebView ngWebView = AiAppsController.getInstance().getNgWebView();
                if (InputEditTextController.this.mKeyboardHeight != i && editText.hasFocus() && ngWebView != null) {
                    InputEditTextController.this.mKeyboardHeight = i;
                    if (inputInfo.needAdjustPosition) {
                        int webViewScrollY = ngWebView.getCurrentWebView().getWebViewScrollY() + ((InputEditTextController.this.mFragment.getWebViewContainer().getHeight() - inputInfo.position.getTop()) - editText.getHeight());
                        if (webViewScrollY - inputInfo.cursorSpacing < i) {
                            if (inputInfo.cursorSpacing > webViewScrollY) {
                                InputEditTextController.this.mFragment.getWebViewContainer().setScrollY(i);
                            } else {
                                InputEditTextController.this.mFragment.getWebViewContainer().setScrollY((i - webViewScrollY) + inputInfo.cursorSpacing);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.searchbox.ng.ai.apps.textarea.SoftGlobalLayoutListener.OnSoftGlobalLayoutChangeListener
            public void keyBoardHide(String str, int i) {
                if (InputEditTextController.this.mKeyboardHeight != 0) {
                    InputEditTextController.this.mKeyboardHeight = 0;
                    if (InputEditTextController.this.mFragment.getWebViewContainer().getScrollY() > 0) {
                        InputEditTextController.this.mFragment.getWebViewContainer().setScrollY(0);
                    }
                }
            }

            @Override // com.baidu.searchbox.ng.ai.apps.textarea.SoftGlobalLayoutListener.OnSoftGlobalLayoutChangeListener
            public void onGlobalLayout(String str) {
            }
        });
        InputEditTextProvider.getInstance().setTextWatcher(textWatcher);
        editText.addTextChangedListener(textWatcher);
    }

    public void changeInputEditTextStatus(EditText editText, String str) {
        if (editText != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("value", editText.getText());
                jSONObject.put("eventName", str);
                jSONObject.put(CURSOR_OFFSET, editText.getText().length());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mCallback.callback(jSONObject);
            if (!TextUtils.equals(str, EVENT_NAME_CHANGE) && !TextUtils.equals(str, "confirm")) {
                closeInputEditText(editText);
            }
        }
    }

    private boolean closeInputEditText(EditText editText) {
        AiAppsActivity activity = AiAppsController.getInstance().getActivity();
        if (activity == null) {
            AiAppsLog.w(TAG, "activity is null when close input");
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        AiAppsNAViewContainer findNAViewContainer = NAViewFinder.findNAViewContainer(this.mInputInfo, null);
        if (findNAViewContainer != null) {
            AiAppsLog.d(TAG, "remove input success");
            findNAViewContainer.removeView();
            InputEditTextProvider.getInstance().destroyInputEditText();
            return true;
        }
        AiAppsLog.d(TAG, "remove input failure, slaveId = " + this.mInputInfo.slaveId + " ; viewId = " + this.mInputInfo.id + " ; parentId = " + this.mInputInfo.parentId);
        return false;
    }
}

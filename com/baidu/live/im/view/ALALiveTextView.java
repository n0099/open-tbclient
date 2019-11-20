package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ao;
import com.baidu.live.im.k;
import com.baidu.live.im.view.ImBarrageOptionListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.view.GradientEnableTextView;
import com.baidu.live.view.Switch;
import com.baidu.live.view.input.QuickImInputHeaderView;
import com.baidu.live.view.input.QuickImInputPanelView;
import com.baidu.live.view.input.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes6.dex */
public class ALALiveTextView extends LinearLayout implements com.baidu.live.view.input.a {
    private ImBarrageItemView ahL;
    private QuickImInputHeaderView ahM;
    private ImBarrageOptionListView ahN;
    private Switch ahO;
    private EditText ahP;
    private GradientEnableTextView ahQ;
    private QuickImInputPanelView ahR;
    private a.InterfaceC0080a ahS;
    private long ahT;
    private int ahU;
    private int ahV;
    private boolean ahW;
    private String ahX;
    private View.OnClickListener ahY;
    private String mOtherParams;
    private TextWatcher mTextWatcher;

    public ALALiveTextView(Context context) {
        super(context);
        this.ahY = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.ahT >= 2000) {
                    ALALiveTextView.this.ahT = currentTimeMillis;
                    String obj = ALALiveTextView.this.ahP.getText().toString();
                    if (obj.length() > ALALiveTextView.this.ahV) {
                        obj = obj.subSequence(0, ALALiveTextView.this.ahV).toString();
                    }
                    ALALiveTextView.this.h(obj, false);
                    return;
                }
                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), "您按得太快，我都跟不上了~");
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.tJ();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ahY = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.ahT >= 2000) {
                    ALALiveTextView.this.ahT = currentTimeMillis;
                    String obj = ALALiveTextView.this.ahP.getText().toString();
                    if (obj.length() > ALALiveTextView.this.ahV) {
                        obj = obj.subSequence(0, ALALiveTextView.this.ahV).toString();
                    }
                    ALALiveTextView.this.h(obj, false);
                    return;
                }
                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), "您按得太快，我都跟不上了~");
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.tJ();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ahY = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.ahT >= 2000) {
                    ALALiveTextView.this.ahT = currentTimeMillis;
                    String obj = ALALiveTextView.this.ahP.getText().toString();
                    if (obj.length() > ALALiveTextView.this.ahV) {
                        obj = obj.subSequence(0, ALALiveTextView.this.ahV).toString();
                    }
                    ALALiveTextView.this.h(obj, false);
                    return;
                }
                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), "您按得太快，我都跟不上了~");
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.tJ();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        setBackgroundColor(0);
        setClickable(true);
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.h.ala_im_input_layout, (ViewGroup) this, true);
        tD();
        ql();
        tE();
        this.ahV = 50;
    }

    private void tD() {
        this.ahL = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.ahN = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.ahO = (Switch) findViewById(a.g.switch_barrage);
        this.ahN.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.4
            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public void bu(int i) {
                ALALiveTextView.this.tK();
                ALALiveTextView.this.aC(false);
            }
        });
        this.ahO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.aB(z);
            }
        });
    }

    private void ql() {
        this.ahP = (EditText) findViewById(a.g.edit_text);
        this.ahP.addTextChangedListener(this.mTextWatcher);
        this.ahP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.ahP.getText())) {
                        ALALiveTextView.this.h(ALALiveTextView.this.ahP.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.ahQ = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.ahQ.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.ahP, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.ahP, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.ahQ.setOnClickListener(this.ahY);
        this.ahQ.setClickable(false);
    }

    private void tE() {
        this.ahM = (QuickImInputHeaderView) findViewById(a.g.quick_input_header);
        this.ahR = (QuickImInputPanelView) findViewById(a.g.quick_input_panel);
        this.ahM.setCallback(new QuickImInputHeaderView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.7
            @Override // com.baidu.live.view.input.QuickImInputHeaderView.a
            public void n(String str, int i) {
                ALALiveTextView.this.h(str, true);
                LogManager.getCommonLogger().doClickQuickImToolLog(ALALiveTextView.this.ahX, String.valueOf(i), str, ALALiveTextView.this.mOtherParams);
            }

            @Override // com.baidu.live.view.input.QuickImInputHeaderView.a
            public void tL() {
                if (ALALiveTextView.this.ahS != null) {
                    ALALiveTextView.this.ahS.sI();
                }
                LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.ahX, ALALiveTextView.this.mOtherParams);
            }
        });
        this.ahR.setCallback(new QuickImInputPanelView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // com.baidu.live.view.input.QuickImInputPanelView.a
            public void n(String str, int i) {
                ALALiveTextView.this.h(str, true);
                LogManager.getCommonLogger().doClickQuickImPanelLog(ALALiveTextView.this.ahX, String.valueOf(i), str, ALALiveTextView.this.mOtherParams);
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.ahW = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean tF() {
        return this.ahO != null && this.ahO.isChecked();
    }

    public ao getBarrageInfo() {
        return this.ahN.getSelectInfo();
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.ahP.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0080a interfaceC0080a) {
        this.ahS = interfaceC0080a;
    }

    public void setLogData(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.ahX = str;
        if (str2 == null) {
            str2 = "";
        }
        this.mOtherParams = str2;
    }

    public void cM(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean tG() {
        return getView().getVisibility() == 0 && this.ahR.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.ahR.setVisibility(0);
            if (this.ahU < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                this.ahR.wL();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahR.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.ahR.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.ahX, this.mOtherParams);
            return;
        }
        this.ahR.setVisibility(8);
        if (this.ahP != null) {
            this.ahP.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void tH() {
        if (this.ahP != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.ahP);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.ahU - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void tI() {
        this.ahP.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.ahP.getSelectionStart();
            Editable editableText = this.ahP.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.ahP.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        i(map);
        this.ahP.requestFocus();
        if (this.ahP != null) {
            this.ahP.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.ahP);
                }
            });
        }
        if (list == null || list.isEmpty()) {
            this.ahM.setData(list);
            this.ahR.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() >= 3) {
            this.ahM.setData(arrayList.subList(0, 3));
        } else {
            this.ahM.setData(arrayList);
        }
        this.ahM.setVisibility(tF() ? 8 : 0);
        this.ahR.setVisibility(0);
        this.ahR.wK();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ahR.getLayoutParams();
        layoutParams.height = -2;
        this.ahR.setLayoutParams(layoutParams);
        this.ahR.setData(arrayList);
        this.ahR.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.10
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.ahU = ALALiveTextView.this.ahR.getHeight();
                ALALiveTextView.this.ahR.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public void show() {
        a((List<String>) null, (Map<String, Integer>) null);
    }

    @Override // com.baidu.live.view.input.a
    public void hide() {
        this.ahP.clearFocus();
        if (this.ahL != null) {
            this.ahL.release();
        }
        setVisibility(8);
    }

    public void h(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.ahN != null) {
            this.ahN.j(map);
        }
    }

    private void i(final Map<String, Integer> map) {
        if (this.ahW) {
            this.ahO.setVisibility(8);
            return;
        }
        final ao[] sO = k.sN().sO();
        if (sO == null || sO.length <= 0) {
            if (this.ahO.isChecked()) {
                this.ahO.setChecked(false, false);
            } else {
                aB(false);
            }
            this.ahO.setVisibility(8);
            return;
        }
        if (this.ahN.getWidth() <= 0) {
            this.ahN.setVisibility(0);
        }
        this.ahN.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.2
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.ahN.setData(sO, map, 0);
                if (k.sN().sP()) {
                    if (ALALiveTextView.this.ahO.isChecked()) {
                        if (ALALiveTextView.this.ahN.getSelect() != k.sN().getSelect()) {
                            ALALiveTextView.this.ahN.setSelect(k.sN().getSelect());
                            ALALiveTextView.this.tK();
                        }
                        ALALiveTextView.this.aC(true);
                    } else {
                        ALALiveTextView.this.ahO.setChecked(true, false);
                    }
                } else if (ALALiveTextView.this.ahO.isChecked()) {
                    ALALiveTextView.this.ahO.setChecked(false, false);
                }
                ALALiveTextView.this.ahN.setVisibility(ALALiveTextView.this.ahO.isChecked() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ() {
        if (this.ahQ != null) {
            if (TextUtils.isEmpty(this.ahP.getText())) {
                this.ahQ.setClickable(false);
            } else {
                this.ahQ.setClickable(true);
            }
        }
        if (this.ahP.getText().length() > this.ahV) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.ahV)));
            this.ahP.setText(this.ahP.getText().subSequence(0, this.ahV));
            this.ahP.setSelection(this.ahP.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tK() {
        ao selectInfo = this.ahN.getSelectInfo();
        if (this.ahP != null && selectInfo != null) {
            this.ahP.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(boolean z) {
        if (z && this.ahS != null && !this.ahS.sG()) {
            this.ahO.setChecked(false, false);
            return;
        }
        this.ahV = z ? 20 : 50;
        if (z && this.ahP != null && this.ahP.getText() != null && this.ahP.getText().length() > this.ahV) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.ahV)));
        }
        if (z) {
            k.sN().ax(true);
            this.ahN.setSelect(k.sN().getSelect());
            this.ahN.setVisibility(0);
            aC(true);
            this.ahM.setVisibility(8);
            tK();
            setQuickInputPanelVisible(false);
        } else {
            k.sN().ax(false);
            this.ahL.setVisibility(8);
            this.ahN.setVisibility(8);
            this.ahM.setVisibility(0);
            if (this.ahP != null) {
                this.ahP.setHint(a.i.sdk_im_sendmessage_to_host);
            }
        }
        if (this.ahS != null) {
            this.ahS.sJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(boolean z) {
        if (z) {
            this.ahL.setPreview();
        }
        this.ahL.setUIInfo(this.ahN.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.ahL.setVisibility(8);
        } else if (this.ahO != null && this.ahO.isChecked()) {
            this.ahL.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, boolean z) {
        if (this.ahS != null) {
            this.ahS.g(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.ahL.setVisibility(8);
            } else if (this.ahO != null && this.ahO.isChecked()) {
                this.ahL.setVisibility(0);
            }
        }
    }
}

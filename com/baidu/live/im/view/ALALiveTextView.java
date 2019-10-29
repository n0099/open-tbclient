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
    private ImBarrageItemView aie;
    private QuickImInputHeaderView aif;
    private ImBarrageOptionListView aig;
    private Switch aih;
    private EditText aii;
    private GradientEnableTextView aij;
    private QuickImInputPanelView aik;
    private a.InterfaceC0080a ail;
    private long aim;
    private int ain;
    private int aio;
    private boolean aip;
    private String aiq;
    private View.OnClickListener air;
    private String mOtherParams;
    private TextWatcher mTextWatcher;

    public ALALiveTextView(Context context) {
        super(context);
        this.air = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aim >= 2000) {
                    ALALiveTextView.this.aim = currentTimeMillis;
                    String obj = ALALiveTextView.this.aii.getText().toString();
                    if (obj.length() > ALALiveTextView.this.aio) {
                        obj = obj.subSequence(0, ALALiveTextView.this.aio).toString();
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
                ALALiveTextView.this.tI();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.air = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aim >= 2000) {
                    ALALiveTextView.this.aim = currentTimeMillis;
                    String obj = ALALiveTextView.this.aii.getText().toString();
                    if (obj.length() > ALALiveTextView.this.aio) {
                        obj = obj.subSequence(0, ALALiveTextView.this.aio).toString();
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
                ALALiveTextView.this.tI();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.air = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aim >= 2000) {
                    ALALiveTextView.this.aim = currentTimeMillis;
                    String obj = ALALiveTextView.this.aii.getText().toString();
                    if (obj.length() > ALALiveTextView.this.aio) {
                        obj = obj.subSequence(0, ALALiveTextView.this.aio).toString();
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
                ALALiveTextView.this.tI();
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
        tC();
        qk();
        tD();
        this.aio = 50;
    }

    private void tC() {
        this.aie = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aig = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aih = (Switch) findViewById(a.g.switch_barrage);
        this.aig.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.4
            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public void bu(int i) {
                ALALiveTextView.this.tJ();
                ALALiveTextView.this.aC(false);
            }
        });
        this.aih.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.aB(z);
            }
        });
    }

    private void qk() {
        this.aii = (EditText) findViewById(a.g.edit_text);
        this.aii.addTextChangedListener(this.mTextWatcher);
        this.aii.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aii.getText())) {
                        ALALiveTextView.this.h(ALALiveTextView.this.aii.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.aij = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.aij.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.aii, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.aii, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.aij.setOnClickListener(this.air);
        this.aij.setClickable(false);
    }

    private void tD() {
        this.aif = (QuickImInputHeaderView) findViewById(a.g.quick_input_header);
        this.aik = (QuickImInputPanelView) findViewById(a.g.quick_input_panel);
        this.aif.setCallback(new QuickImInputHeaderView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.7
            @Override // com.baidu.live.view.input.QuickImInputHeaderView.a
            public void n(String str, int i) {
                ALALiveTextView.this.h(str, true);
                LogManager.getCommonLogger().doClickQuickImToolLog(ALALiveTextView.this.aiq, String.valueOf(i), str, ALALiveTextView.this.mOtherParams);
            }

            @Override // com.baidu.live.view.input.QuickImInputHeaderView.a
            public void tK() {
                if (ALALiveTextView.this.ail != null) {
                    ALALiveTextView.this.ail.sH();
                }
                LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.aiq, ALALiveTextView.this.mOtherParams);
            }
        });
        this.aik.setCallback(new QuickImInputPanelView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // com.baidu.live.view.input.QuickImInputPanelView.a
            public void n(String str, int i) {
                ALALiveTextView.this.h(str, true);
                LogManager.getCommonLogger().doClickQuickImPanelLog(ALALiveTextView.this.aiq, String.valueOf(i), str, ALALiveTextView.this.mOtherParams);
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.aip = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean tE() {
        return this.aih != null && this.aih.isChecked();
    }

    public ao getBarrageInfo() {
        return this.aig.getSelectInfo();
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.aii.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0080a interfaceC0080a) {
        this.ail = interfaceC0080a;
    }

    public void setLogData(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.aiq = str;
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
    public boolean tF() {
        return getView().getVisibility() == 0 && this.aik.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.aik.setVisibility(0);
            if (this.ain < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                this.aik.wK();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aik.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.aik.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.aiq, this.mOtherParams);
            return;
        }
        this.aik.setVisibility(8);
        if (this.aii != null) {
            this.aii.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void tG() {
        if (this.aii != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.aii);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.ain - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void tH() {
        this.aii.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.aii.getSelectionStart();
            Editable editableText = this.aii.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.aii.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        i(map);
        this.aii.requestFocus();
        if (this.aii != null) {
            this.aii.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.aii);
                }
            });
        }
        if (list == null || list.isEmpty()) {
            this.aif.setData(list);
            this.aik.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() >= 3) {
            this.aif.setData(arrayList.subList(0, 3));
        } else {
            this.aif.setData(arrayList);
        }
        this.aif.setVisibility(tE() ? 8 : 0);
        this.aik.setVisibility(0);
        this.aik.wJ();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aik.getLayoutParams();
        layoutParams.height = -2;
        this.aik.setLayoutParams(layoutParams);
        this.aik.setData(arrayList);
        this.aik.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.10
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.ain = ALALiveTextView.this.aik.getHeight();
                ALALiveTextView.this.aik.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public void show() {
        a((List<String>) null, (Map<String, Integer>) null);
    }

    @Override // com.baidu.live.view.input.a
    public void hide() {
        this.aii.clearFocus();
        if (this.aie != null) {
            this.aie.release();
        }
        setVisibility(8);
    }

    public void h(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.aig != null) {
            this.aig.j(map);
        }
    }

    private void i(final Map<String, Integer> map) {
        if (this.aip) {
            this.aih.setVisibility(8);
            return;
        }
        final ao[] sN = k.sM().sN();
        if (sN == null || sN.length <= 0) {
            if (this.aih.isChecked()) {
                this.aih.setChecked(false, false);
            } else {
                aB(false);
            }
            this.aih.setVisibility(8);
            return;
        }
        if (this.aig.getWidth() <= 0) {
            this.aig.setVisibility(0);
        }
        this.aig.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.2
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.aig.setData(sN, map, 0);
                if (k.sM().sO()) {
                    if (ALALiveTextView.this.aih.isChecked()) {
                        if (ALALiveTextView.this.aig.getSelect() != k.sM().getSelect()) {
                            ALALiveTextView.this.aig.setSelect(k.sM().getSelect());
                            ALALiveTextView.this.tJ();
                        }
                        ALALiveTextView.this.aC(true);
                    } else {
                        ALALiveTextView.this.aih.setChecked(true, false);
                    }
                } else if (ALALiveTextView.this.aih.isChecked()) {
                    ALALiveTextView.this.aih.setChecked(false, false);
                }
                ALALiveTextView.this.aig.setVisibility(ALALiveTextView.this.aih.isChecked() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI() {
        if (this.aij != null) {
            if (TextUtils.isEmpty(this.aii.getText())) {
                this.aij.setClickable(false);
            } else {
                this.aij.setClickable(true);
            }
        }
        if (this.aii.getText().length() > this.aio) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aio)));
            this.aii.setText(this.aii.getText().subSequence(0, this.aio));
            this.aii.setSelection(this.aii.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ() {
        ao selectInfo = this.aig.getSelectInfo();
        if (this.aii != null && selectInfo != null) {
            this.aii.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(boolean z) {
        if (z && this.ail != null && !this.ail.sF()) {
            this.aih.setChecked(false, false);
            return;
        }
        this.aio = z ? 20 : 50;
        if (z && this.aii != null && this.aii.getText() != null && this.aii.getText().length() > this.aio) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aio)));
        }
        if (z) {
            k.sM().ax(true);
            this.aig.setSelect(k.sM().getSelect());
            this.aig.setVisibility(0);
            aC(true);
            this.aif.setVisibility(8);
            tJ();
            setQuickInputPanelVisible(false);
        } else {
            k.sM().ax(false);
            this.aie.setVisibility(8);
            this.aig.setVisibility(8);
            this.aif.setVisibility(0);
            if (this.aii != null) {
                this.aii.setHint(a.i.sdk_im_sendmessage_to_host);
            }
        }
        if (this.ail != null) {
            this.ail.sI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(boolean z) {
        if (z) {
            this.aie.setPreview();
        }
        this.aie.setUIInfo(this.aig.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aie.setVisibility(8);
        } else if (this.aih != null && this.aih.isChecked()) {
            this.aie.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, boolean z) {
        if (this.ail != null) {
            this.ail.g(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aie.setVisibility(8);
            } else if (this.aih != null && this.aih.isChecked()) {
                this.aie.setVisibility(0);
            }
        }
    }
}

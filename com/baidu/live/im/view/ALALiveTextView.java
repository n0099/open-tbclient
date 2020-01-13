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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.az;
import com.baidu.live.im.k;
import com.baidu.live.im.view.ImBarrageOptionListView;
import com.baidu.live.r.a;
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
/* loaded from: classes2.dex */
public class ALALiveTextView extends LinearLayout implements com.baidu.live.view.input.a {
    private Map<String, Integer> afx;
    private QuickImInputHeaderView aqA;
    private ImBarrageOptionListView aqB;
    private Switch aqC;
    private EditText aqD;
    private GradientEnableTextView aqE;
    private QuickImInputPanelView aqF;
    private a.InterfaceC0098a aqG;
    private long aqH;
    private int aqI;
    private int aqJ;
    private boolean aqK;
    private View.OnClickListener aqL;
    private ImBarrageItemView aqz;
    private String mOtherParams;
    private TextWatcher mTextWatcher;
    private String mVid;

    public ALALiveTextView(Context context) {
        super(context);
        this.aqL = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aqH >= 2000) {
                    ALALiveTextView.this.aqH = currentTimeMillis;
                    String obj = ALALiveTextView.this.aqD.getText().toString();
                    if (obj.length() > ALALiveTextView.this.aqJ) {
                        obj = obj.subSequence(0, ALALiveTextView.this.aqJ).toString();
                    }
                    ALALiveTextView.this.k(obj, false);
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
                ALALiveTextView.this.vV();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqL = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aqH >= 2000) {
                    ALALiveTextView.this.aqH = currentTimeMillis;
                    String obj = ALALiveTextView.this.aqD.getText().toString();
                    if (obj.length() > ALALiveTextView.this.aqJ) {
                        obj = obj.subSequence(0, ALALiveTextView.this.aqJ).toString();
                    }
                    ALALiveTextView.this.k(obj, false);
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
                ALALiveTextView.this.vV();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aqL = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aqH >= 2000) {
                    ALALiveTextView.this.aqH = currentTimeMillis;
                    String obj = ALALiveTextView.this.aqD.getText().toString();
                    if (obj.length() > ALALiveTextView.this.aqJ) {
                        obj = obj.subSequence(0, ALALiveTextView.this.aqJ).toString();
                    }
                    ALALiveTextView.this.k(obj, false);
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
                ALALiveTextView.this.vV();
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
        vO();
        si();
        vP();
        this.aqJ = 50;
    }

    private void vO() {
        this.aqz = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aqB = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aqC = (Switch) findViewById(a.g.switch_barrage);
        this.aqB.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.4
            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public boolean vX() {
                return ALALiveTextView.this.aqG != null && ALALiveTextView.this.aqG.uS();
            }

            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public void bI(int i) {
                ALALiveTextView.this.vW();
                ALALiveTextView.this.aV(false);
            }
        });
        this.aqC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.aU(z);
            }
        });
    }

    private void si() {
        this.aqD = (EditText) findViewById(a.g.edit_text);
        this.aqD.addTextChangedListener(this.mTextWatcher);
        this.aqD.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aqD.getText())) {
                        ALALiveTextView.this.k(ALALiveTextView.this.aqD.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.aqE = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.aqE.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.aqD, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.aqD, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.aqE.setOnClickListener(this.aqL);
        this.aqE.setClickable(false);
    }

    private void vP() {
        this.aqA = (QuickImInputHeaderView) findViewById(a.g.quick_input_header);
        this.aqF = (QuickImInputPanelView) findViewById(a.g.quick_input_panel);
        this.aqA.setCallback(new QuickImInputHeaderView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.7
            @Override // com.baidu.live.view.input.QuickImInputHeaderView.a
            public void r(String str, int i) {
                ALALiveTextView.this.k(str, true);
                LogManager.getCommonLogger().doClickQuickImToolLog(ALALiveTextView.this.mVid, String.valueOf(i), str, ALALiveTextView.this.mOtherParams);
            }

            @Override // com.baidu.live.view.input.QuickImInputHeaderView.a
            public void vY() {
                if (ALALiveTextView.this.aqG != null) {
                    ALALiveTextView.this.aqG.uQ();
                }
                LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
            }
        });
        this.aqF.setCallback(new QuickImInputPanelView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // com.baidu.live.view.input.QuickImInputPanelView.a
            public void r(String str, int i) {
                ALALiveTextView.this.k(str, true);
                LogManager.getCommonLogger().doClickQuickImPanelLog(ALALiveTextView.this.mVid, String.valueOf(i), str, ALALiveTextView.this.mOtherParams);
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.aqK = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean vQ() {
        return this.aqC != null && this.aqC.isChecked();
    }

    public az getBarrageInfo() {
        return this.aqB.getSelectInfo();
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.aqD.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0098a interfaceC0098a) {
        this.aqG = interfaceC0098a;
    }

    public void setLogData(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.mVid = str;
        if (str2 == null) {
            str2 = "";
        }
        this.mOtherParams = str2;
    }

    public void dF(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean vR() {
        return getView().getVisibility() == 0 && this.aqF.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.aqF.setVisibility(0);
            if (this.aqI < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                this.aqF.zg();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqF.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.aqF.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.aqF.setVisibility(8);
        if (this.aqD != null) {
            this.aqD.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void vS() {
        if (this.aqD != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.aqD);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.aqI - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void vT() {
        this.aqD.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.aqD.getSelectionStart();
            Editable editableText = this.aqD.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.aqD.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void b(List<String> list, Map<String, Integer> map) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913152, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.afx = map;
        vU();
        this.aqD.requestFocus();
        if (this.aqD != null) {
            this.aqD.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.aqD);
                }
            });
        }
        if (list == null || list.isEmpty()) {
            this.aqA.setData(list);
            this.aqF.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() >= 3) {
            this.aqA.setData(arrayList.subList(0, 3));
        } else {
            this.aqA.setData(arrayList);
        }
        this.aqA.setVisibility(vQ() ? 8 : 0);
        this.aqF.setVisibility(0);
        this.aqF.zf();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aqF.getLayoutParams();
        layoutParams.height = -2;
        this.aqF.setLayoutParams(layoutParams);
        this.aqF.setData(arrayList);
        this.aqF.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.10
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.aqI = ALALiveTextView.this.aqF.getHeight();
                ALALiveTextView.this.aqF.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public void show() {
        b((List<String>) null, (Map<String, Integer>) null);
    }

    @Override // com.baidu.live.view.input.a
    public void hide() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913152, false));
        this.aqD.clearFocus();
        if (this.aqz != null) {
            this.aqz.release();
        }
        setVisibility(8);
    }

    public void h(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.aqB != null) {
            this.aqB.i(map);
        }
    }

    private void vU() {
        if (this.aqK) {
            this.aqC.setVisibility(8);
            return;
        }
        final az[] aQ = k.uW().aQ(this.aqG != null && this.aqG.uS());
        if (aQ == null || aQ.length <= 0) {
            if (this.aqC.isChecked()) {
                this.aqC.setChecked(false, false);
            } else {
                aU(false);
            }
            this.aqC.setVisibility(8);
            return;
        }
        if (this.aqB.getWidth() <= 0) {
            this.aqB.setVisibility(0);
        }
        this.aqB.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.uW().uY()) {
                    ALALiveTextView.this.aqB.setData(aQ, ALALiveTextView.this.afx, 0);
                    if (ALALiveTextView.this.aqC.isChecked()) {
                        ALALiveTextView.this.aqB.setSelectId(k.uW().uZ());
                        ALALiveTextView.this.vW();
                        ALALiveTextView.this.aV(true);
                    } else {
                        ALALiveTextView.this.aqC.setChecked(true, false);
                    }
                } else if (ALALiveTextView.this.aqC.isChecked()) {
                    ALALiveTextView.this.aqC.setChecked(false, false);
                }
                ALALiveTextView.this.aqB.setVisibility(ALALiveTextView.this.aqC.isChecked() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV() {
        if (this.aqE != null) {
            if (TextUtils.isEmpty(this.aqD.getText())) {
                this.aqE.setClickable(false);
            } else {
                this.aqE.setClickable(true);
            }
        }
        if (this.aqD.getText().length() > this.aqJ) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aqJ)));
            this.aqD.setText(this.aqD.getText().subSequence(0, this.aqJ));
            this.aqD.setSelection(this.aqD.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vW() {
        az selectInfo = this.aqB.getSelectInfo();
        if (this.aqD != null && selectInfo != null) {
            switch (selectInfo.type) {
                case 1:
                    this.aqD.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                    return;
                case 16:
                    this.aqD.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(boolean z) {
        if (z && this.aqG != null && !this.aqG.uO()) {
            this.aqC.setChecked(false, false);
            return;
        }
        this.aqJ = z ? 20 : 50;
        if (z && this.aqD != null && this.aqD.getText() != null && this.aqD.getText().length() > this.aqJ) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aqJ)));
        }
        if (z) {
            this.aqB.setData(k.uW().aQ(this.aqG != null && this.aqG.uS()), this.afx, 0);
            this.aqB.setSwitchStatus(true);
            if (!TextUtils.isEmpty(k.uW().uZ())) {
                this.aqB.setSelectId(k.uW().uZ());
            } else {
                this.aqB.setSelectPos(0);
            }
            this.aqB.setVisibility(0);
            aV(true);
            this.aqA.setVisibility(8);
            vW();
            setQuickInputPanelVisible(false);
        } else {
            this.aqB.setSwitchStatus(false);
            this.aqz.setVisibility(8);
            this.aqB.setVisibility(8);
            this.aqA.setVisibility(0);
            if (this.aqD != null) {
                this.aqD.setHint(a.i.sdk_im_sendmessage_to_host);
            }
        }
        if (this.aqG != null) {
            this.aqG.uR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(boolean z) {
        if (z) {
            this.aqz.setPreview();
        }
        this.aqz.setUIInfo(this.aqB.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aqz.setVisibility(8);
        } else if (this.aqC != null && this.aqC.isChecked()) {
            this.aqz.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z) {
        if (this.aqG != null) {
            this.aqG.j(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aqz.setVisibility(8);
            } else if (this.aqC != null && this.aqC.isChecked()) {
                this.aqz.setVisibility(0);
            }
        }
    }
}

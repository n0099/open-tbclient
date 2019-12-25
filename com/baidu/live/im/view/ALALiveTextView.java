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
import com.baidu.live.data.av;
import com.baidu.live.im.k;
import com.baidu.live.im.view.ImBarrageOptionListView;
import com.baidu.live.q.a;
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
    private Map<String, Integer> aeO;
    private ImBarrageItemView apN;
    private QuickImInputHeaderView apO;
    private ImBarrageOptionListView apP;
    private Switch apQ;
    private EditText apR;
    private GradientEnableTextView apS;
    private QuickImInputPanelView apT;
    private a.InterfaceC0097a apU;
    private long apV;
    private int apW;
    private int apX;
    private boolean apY;
    private View.OnClickListener apZ;
    private String mOtherParams;
    private TextWatcher mTextWatcher;
    private String mVid;

    public ALALiveTextView(Context context) {
        super(context);
        this.apZ = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.apV >= 2000) {
                    ALALiveTextView.this.apV = currentTimeMillis;
                    String obj = ALALiveTextView.this.apR.getText().toString();
                    if (obj.length() > ALALiveTextView.this.apX) {
                        obj = obj.subSequence(0, ALALiveTextView.this.apX).toString();
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
                ALALiveTextView.this.vE();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apZ = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.apV >= 2000) {
                    ALALiveTextView.this.apV = currentTimeMillis;
                    String obj = ALALiveTextView.this.apR.getText().toString();
                    if (obj.length() > ALALiveTextView.this.apX) {
                        obj = obj.subSequence(0, ALALiveTextView.this.apX).toString();
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
                ALALiveTextView.this.vE();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apZ = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.apV >= 2000) {
                    ALALiveTextView.this.apV = currentTimeMillis;
                    String obj = ALALiveTextView.this.apR.getText().toString();
                    if (obj.length() > ALALiveTextView.this.apX) {
                        obj = obj.subSequence(0, ALALiveTextView.this.apX).toString();
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
                ALALiveTextView.this.vE();
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
        vx();
        rS();
        vy();
        this.apX = 50;
    }

    private void vx() {
        this.apN = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.apP = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.apQ = (Switch) findViewById(a.g.switch_barrage);
        this.apP.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.4
            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public boolean vG() {
                return ALALiveTextView.this.apU != null && ALALiveTextView.this.apU.uB();
            }

            @Override // com.baidu.live.im.view.ImBarrageOptionListView.a
            public void bI(int i) {
                ALALiveTextView.this.vF();
                ALALiveTextView.this.aT(false);
            }
        });
        this.apQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.aS(z);
            }
        });
    }

    private void rS() {
        this.apR = (EditText) findViewById(a.g.edit_text);
        this.apR.addTextChangedListener(this.mTextWatcher);
        this.apR.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.apR.getText())) {
                        ALALiveTextView.this.k(ALALiveTextView.this.apR.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.apS = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.apS.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.apR, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.apR, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.apS.setOnClickListener(this.apZ);
        this.apS.setClickable(false);
    }

    private void vy() {
        this.apO = (QuickImInputHeaderView) findViewById(a.g.quick_input_header);
        this.apT = (QuickImInputPanelView) findViewById(a.g.quick_input_panel);
        this.apO.setCallback(new QuickImInputHeaderView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.7
            @Override // com.baidu.live.view.input.QuickImInputHeaderView.a
            public void r(String str, int i) {
                ALALiveTextView.this.k(str, true);
                LogManager.getCommonLogger().doClickQuickImToolLog(ALALiveTextView.this.mVid, String.valueOf(i), str, ALALiveTextView.this.mOtherParams);
            }

            @Override // com.baidu.live.view.input.QuickImInputHeaderView.a
            public void vH() {
                if (ALALiveTextView.this.apU != null) {
                    ALALiveTextView.this.apU.uz();
                }
                LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
            }
        });
        this.apT.setCallback(new QuickImInputPanelView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.8
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
        this.apY = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean vz() {
        return this.apQ != null && this.apQ.isChecked();
    }

    public av getBarrageInfo() {
        return this.apP.getSelectInfo();
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.apR.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0097a interfaceC0097a) {
        this.apU = interfaceC0097a;
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

    public void dD(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean vA() {
        return getView().getVisibility() == 0 && this.apT.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.apT.setVisibility(0);
            if (this.apW < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                this.apT.yK();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apT.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.apT.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.apT.setVisibility(8);
        if (this.apR != null) {
            this.apR.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void vB() {
        if (this.apR != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.apR);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.apW - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void vC() {
        this.apR.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.apR.getSelectionStart();
            Editable editableText = this.apR.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.apR.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void b(List<String> list, Map<String, Integer> map) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aeO = map;
        vD();
        this.apR.requestFocus();
        if (this.apR != null) {
            this.apR.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.apR);
                }
            });
        }
        if (list == null || list.isEmpty()) {
            this.apO.setData(list);
            this.apT.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() >= 3) {
            this.apO.setData(arrayList.subList(0, 3));
        } else {
            this.apO.setData(arrayList);
        }
        this.apO.setVisibility(vz() ? 8 : 0);
        this.apT.setVisibility(0);
        this.apT.yJ();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.apT.getLayoutParams();
        layoutParams.height = -2;
        this.apT.setLayoutParams(layoutParams);
        this.apT.setData(arrayList);
        this.apT.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.10
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.apW = ALALiveTextView.this.apT.getHeight();
                ALALiveTextView.this.apT.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public void show() {
        b((List<String>) null, (Map<String, Integer>) null);
    }

    @Override // com.baidu.live.view.input.a
    public void hide() {
        this.apR.clearFocus();
        if (this.apN != null) {
            this.apN.release();
        }
        setVisibility(8);
    }

    public void h(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.apP != null) {
            this.apP.i(map);
        }
    }

    private void vD() {
        if (this.apY) {
            this.apQ.setVisibility(8);
            return;
        }
        final av[] aO = k.uF().aO(this.apU != null && this.apU.uB());
        if (aO == null || aO.length <= 0) {
            if (this.apQ.isChecked()) {
                this.apQ.setChecked(false, false);
            } else {
                aS(false);
            }
            this.apQ.setVisibility(8);
            return;
        }
        if (this.apP.getWidth() <= 0) {
            this.apP.setVisibility(0);
        }
        this.apP.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.uF().uH()) {
                    ALALiveTextView.this.apP.setData(aO, ALALiveTextView.this.aeO, 0);
                    if (ALALiveTextView.this.apQ.isChecked()) {
                        ALALiveTextView.this.apP.setSelectId(k.uF().uI());
                        ALALiveTextView.this.vF();
                        ALALiveTextView.this.aT(true);
                    } else {
                        ALALiveTextView.this.apQ.setChecked(true, false);
                    }
                } else if (ALALiveTextView.this.apQ.isChecked()) {
                    ALALiveTextView.this.apQ.setChecked(false, false);
                }
                ALALiveTextView.this.apP.setVisibility(ALALiveTextView.this.apQ.isChecked() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vE() {
        if (this.apS != null) {
            if (TextUtils.isEmpty(this.apR.getText())) {
                this.apS.setClickable(false);
            } else {
                this.apS.setClickable(true);
            }
        }
        if (this.apR.getText().length() > this.apX) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.apX)));
            this.apR.setText(this.apR.getText().subSequence(0, this.apX));
            this.apR.setSelection(this.apR.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF() {
        av selectInfo = this.apP.getSelectInfo();
        if (this.apR != null && selectInfo != null) {
            switch (selectInfo.type) {
                case 1:
                    this.apR.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                    return;
                case 16:
                    this.apR.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(boolean z) {
        if (z && this.apU != null && !this.apU.ux()) {
            this.apQ.setChecked(false, false);
            return;
        }
        this.apX = z ? 20 : 50;
        if (z && this.apR != null && this.apR.getText() != null && this.apR.getText().length() > this.apX) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.apX)));
        }
        if (z) {
            this.apP.setData(k.uF().aO(this.apU != null && this.apU.uB()), this.aeO, 0);
            this.apP.setSwitchStatus(true);
            if (!TextUtils.isEmpty(k.uF().uI())) {
                this.apP.setSelectId(k.uF().uI());
            } else {
                this.apP.setSelectPos(0);
            }
            this.apP.setVisibility(0);
            aT(true);
            this.apO.setVisibility(8);
            vF();
            setQuickInputPanelVisible(false);
        } else {
            this.apP.setSwitchStatus(false);
            this.apN.setVisibility(8);
            this.apP.setVisibility(8);
            this.apO.setVisibility(0);
            if (this.apR != null) {
                this.apR.setHint(a.i.sdk_im_sendmessage_to_host);
            }
        }
        if (this.apU != null) {
            this.apU.uA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(boolean z) {
        if (z) {
            this.apN.setPreview();
        }
        this.apN.setUIInfo(this.apP.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.apN.setVisibility(8);
        } else if (this.apQ != null && this.apQ.isChecked()) {
            this.apN.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z) {
        if (this.apU != null) {
            this.apU.j(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.apN.setVisibility(8);
            } else if (this.apQ != null && this.apQ.isChecked()) {
                this.apN.setVisibility(0);
            }
        }
    }
}

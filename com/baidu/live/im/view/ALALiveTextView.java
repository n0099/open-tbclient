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
import com.baidu.live.data.bb;
import com.baidu.live.im.k;
import com.baidu.live.im.view.barrage.ImBarrageItemView;
import com.baidu.live.im.view.barrage.ImBarrageOptionListView;
import com.baidu.live.im.view.quick.QuickImInputHeaderView;
import com.baidu.live.im.view.quick.QuickImInputPanelView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.view.GradientEnableTextView;
import com.baidu.live.u.a;
import com.baidu.live.view.Switch;
import com.baidu.live.view.input.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class ALALiveTextView extends LinearLayout implements com.baidu.live.view.input.a {
    private Map<String, Integer> ahO;
    private QuickImInputPanelView auA;
    private a.InterfaceC0104a auB;
    private long auC;
    private int auD;
    private int auE;
    private boolean auF;
    private View.OnClickListener auG;
    private ImBarrageItemView auu;
    private QuickImInputHeaderView auv;
    private ImBarrageOptionListView auw;
    private Switch aux;
    private EditText auy;
    private GradientEnableTextView auz;
    private String mOtherParams;
    private TextWatcher mTextWatcher;
    private String mVid;

    public ALALiveTextView(Context context) {
        super(context);
        this.auG = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.auC >= 2000) {
                    ALALiveTextView.this.auC = currentTimeMillis;
                    String obj = ALALiveTextView.this.auy.getText().toString();
                    if (obj.length() > ALALiveTextView.this.auE) {
                        obj = obj.subSequence(0, ALALiveTextView.this.auE).toString();
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
                ALALiveTextView.this.xZ();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auG = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.auC >= 2000) {
                    ALALiveTextView.this.auC = currentTimeMillis;
                    String obj = ALALiveTextView.this.auy.getText().toString();
                    if (obj.length() > ALALiveTextView.this.auE) {
                        obj = obj.subSequence(0, ALALiveTextView.this.auE).toString();
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
                ALALiveTextView.this.xZ();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auG = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.auC >= 2000) {
                    ALALiveTextView.this.auC = currentTimeMillis;
                    String obj = ALALiveTextView.this.auy.getText().toString();
                    if (obj.length() > ALALiveTextView.this.auE) {
                        obj = obj.subSequence(0, ALALiveTextView.this.auE).toString();
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
                ALALiveTextView.this.xZ();
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
        xS();
        tz();
        xT();
        this.auE = 50;
    }

    private void xS() {
        this.auu = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.auw = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aux = (Switch) findViewById(a.g.switch_barrage);
        this.auw.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.4
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean xs() {
                return ALALiveTextView.this.auB != null && ALALiveTextView.this.auB.wB();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bP(int i) {
                ALALiveTextView.this.ya();
                ALALiveTextView.this.aY(false);
            }
        });
        this.aux.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.aX(z);
            }
        });
    }

    private void tz() {
        this.auy = (EditText) findViewById(a.g.edit_text);
        this.auy.addTextChangedListener(this.mTextWatcher);
        this.auy.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.auy.getText())) {
                        ALALiveTextView.this.k(ALALiveTextView.this.auy.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.auz = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.auz.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.auy, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.auy, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.auz.setOnClickListener(this.auG);
        this.auz.setClickable(false);
    }

    private void xT() {
        this.auv = (QuickImInputHeaderView) findViewById(a.g.quick_input_header);
        this.auA = (QuickImInputPanelView) findViewById(a.g.quick_input_panel);
        this.auv.setCallback(new QuickImInputHeaderView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.7
            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void r(String str, int i) {
                ALALiveTextView.this.k(str, true);
                LogManager.getCommonLogger().doClickQuickImToolLog(ALALiveTextView.this.mVid, String.valueOf(i), str, ALALiveTextView.this.mOtherParams);
            }

            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void yb() {
                if (ALALiveTextView.this.auB != null) {
                    ALALiveTextView.this.auB.wz();
                }
                LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
            }
        });
        this.auA.setCallback(new QuickImInputPanelView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // com.baidu.live.im.view.quick.QuickImInputPanelView.a
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
        this.auF = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean xU() {
        return this.aux != null && this.aux.isChecked();
    }

    public bb getBarrageInfo() {
        return this.auw.getSelectInfo();
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.auy.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0104a interfaceC0104a) {
        this.auB = interfaceC0104a;
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

    public void dP(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean xV() {
        return getView().getVisibility() == 0 && this.auA.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.auA.setVisibility(0);
            if (this.auD < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                this.auA.yq();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auA.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.auA.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.auA.setVisibility(8);
        if (this.auy != null) {
            this.auy.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void xW() {
        if (this.auy != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.auy);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.auD - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void xX() {
        this.auy.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.auy.getSelectionStart();
            Editable editableText = this.auy.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.auy.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void b(List<String> list, Map<String, Integer> map) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.ahO = map;
        xY();
        this.auy.requestFocus();
        if (this.auy != null) {
            this.auy.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.auy);
                }
            });
        }
        if (list == null || list.isEmpty()) {
            this.auv.setData(list);
            this.auA.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() >= 3) {
            this.auv.setData(arrayList.subList(0, 3));
        } else {
            this.auv.setData(arrayList);
        }
        this.auv.setVisibility(xU() ? 8 : 0);
        this.auA.setVisibility(0);
        this.auA.yp();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auA.getLayoutParams();
        layoutParams.height = -2;
        this.auA.setLayoutParams(layoutParams);
        this.auA.setData(arrayList);
        this.auA.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.10
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.auD = ALALiveTextView.this.auA.getHeight();
                ALALiveTextView.this.auA.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public void show() {
        b((List<String>) null, (Map<String, Integer>) null);
    }

    @Override // com.baidu.live.view.input.a
    public void hide() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        this.auy.clearFocus();
        if (this.auu != null) {
            this.auu.release();
        }
        setVisibility(8);
    }

    public void h(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.auw != null) {
            this.auw.i(map);
        }
    }

    private void xY() {
        if (this.auF) {
            this.aux.setVisibility(8);
            return;
        }
        final bb[] aT = k.wF().aT(this.auB != null && this.auB.wB());
        if (aT == null || aT.length <= 0) {
            if (this.aux.isChecked()) {
                this.aux.setChecked(false, false);
            } else {
                aX(false);
            }
            this.aux.setVisibility(8);
            return;
        }
        if (this.auw.getWidth() <= 0) {
            this.auw.setVisibility(0);
        }
        this.auw.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.wF().wH()) {
                    ALALiveTextView.this.auw.setData(aT, ALALiveTextView.this.ahO, 0);
                    if (ALALiveTextView.this.aux.isChecked()) {
                        ALALiveTextView.this.auw.setSelectId(k.wF().wI());
                        ALALiveTextView.this.ya();
                        ALALiveTextView.this.aY(true);
                    } else {
                        ALALiveTextView.this.aux.setChecked(true, false);
                    }
                } else if (ALALiveTextView.this.aux.isChecked()) {
                    ALALiveTextView.this.aux.setChecked(false, false);
                }
                ALALiveTextView.this.auw.setVisibility(ALALiveTextView.this.aux.isChecked() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xZ() {
        if (this.auz != null) {
            if (TextUtils.isEmpty(this.auy.getText())) {
                this.auz.setClickable(false);
            } else {
                this.auz.setClickable(true);
            }
        }
        if (this.auy.getText().length() > this.auE) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.auE)));
            this.auy.setText(this.auy.getText().subSequence(0, this.auE));
            this.auy.setSelection(this.auy.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ya() {
        bb selectInfo = this.auw.getSelectInfo();
        if (this.auy != null && selectInfo != null) {
            switch (selectInfo.type) {
                case 1:
                    this.auy.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                    return;
                case 16:
                    this.auy.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(boolean z) {
        if (z && this.auB != null && !this.auB.wx()) {
            this.aux.setChecked(false, false);
            return;
        }
        this.auE = z ? 20 : 50;
        if (z && this.auy != null && this.auy.getText() != null && this.auy.getText().length() > this.auE) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.auE)));
        }
        if (z) {
            this.auw.setData(k.wF().aT(this.auB != null && this.auB.wB()), this.ahO, 0);
            this.auw.setSwitchStatus(true);
            if (!TextUtils.isEmpty(k.wF().wI())) {
                this.auw.setSelectId(k.wF().wI());
            } else {
                this.auw.setSelectPos(0);
            }
            this.auw.setVisibility(0);
            aY(true);
            this.auv.setVisibility(8);
            ya();
            setQuickInputPanelVisible(false);
        } else {
            this.auw.setSwitchStatus(false);
            this.auu.setVisibility(8);
            this.auw.setVisibility(8);
            this.auv.setVisibility(0);
            if (this.auy != null) {
                this.auy.setHint(a.i.sdk_im_sendmessage_to_host);
            }
        }
        if (this.auB != null) {
            this.auB.wA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (z) {
            this.auu.setPreview();
        }
        this.auu.setUIInfo(this.auw.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.auu.setVisibility(8);
        } else if (this.aux != null && this.aux.isChecked()) {
            this.auu.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z) {
        if (this.auB != null) {
            this.auB.j(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.auu.setVisibility(8);
            } else if (this.aux != null && this.aux.isChecked()) {
                this.auu.setVisibility(0);
            }
        }
    }
}

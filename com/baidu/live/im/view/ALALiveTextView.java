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
    private Map<String, Integer> ahE;
    private ImBarrageItemView auk;
    private QuickImInputHeaderView aul;
    private ImBarrageOptionListView aum;
    private Switch aun;
    private EditText auo;
    private GradientEnableTextView aup;
    private QuickImInputPanelView auq;
    private a.InterfaceC0104a aur;
    private long aus;
    private int aut;
    private int auu;
    private boolean auv;
    private View.OnClickListener auw;
    private String mOtherParams;
    private TextWatcher mTextWatcher;
    private String mVid;

    public ALALiveTextView(Context context) {
        super(context);
        this.auw = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aus >= 2000) {
                    ALALiveTextView.this.aus = currentTimeMillis;
                    String obj = ALALiveTextView.this.auo.getText().toString();
                    if (obj.length() > ALALiveTextView.this.auu) {
                        obj = obj.subSequence(0, ALALiveTextView.this.auu).toString();
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
                ALALiveTextView.this.xU();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auw = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aus >= 2000) {
                    ALALiveTextView.this.aus = currentTimeMillis;
                    String obj = ALALiveTextView.this.auo.getText().toString();
                    if (obj.length() > ALALiveTextView.this.auu) {
                        obj = obj.subSequence(0, ALALiveTextView.this.auu).toString();
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
                ALALiveTextView.this.xU();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auw = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aus >= 2000) {
                    ALALiveTextView.this.aus = currentTimeMillis;
                    String obj = ALALiveTextView.this.auo.getText().toString();
                    if (obj.length() > ALALiveTextView.this.auu) {
                        obj = obj.subSequence(0, ALALiveTextView.this.auu).toString();
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
                ALALiveTextView.this.xU();
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
        xN();
        tu();
        xO();
        this.auu = 50;
    }

    private void xN() {
        this.auk = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aum = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aun = (Switch) findViewById(a.g.switch_barrage);
        this.aum.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.4
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean xn() {
                return ALALiveTextView.this.aur != null && ALALiveTextView.this.aur.ww();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bP(int i) {
                ALALiveTextView.this.xV();
                ALALiveTextView.this.aY(false);
            }
        });
        this.aun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.aX(z);
            }
        });
    }

    private void tu() {
        this.auo = (EditText) findViewById(a.g.edit_text);
        this.auo.addTextChangedListener(this.mTextWatcher);
        this.auo.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.auo.getText())) {
                        ALALiveTextView.this.k(ALALiveTextView.this.auo.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.aup = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.aup.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.auo, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.auo, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.aup.setOnClickListener(this.auw);
        this.aup.setClickable(false);
    }

    private void xO() {
        this.aul = (QuickImInputHeaderView) findViewById(a.g.quick_input_header);
        this.auq = (QuickImInputPanelView) findViewById(a.g.quick_input_panel);
        this.aul.setCallback(new QuickImInputHeaderView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.7
            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void r(String str, int i) {
                ALALiveTextView.this.k(str, true);
                LogManager.getCommonLogger().doClickQuickImToolLog(ALALiveTextView.this.mVid, String.valueOf(i), str, ALALiveTextView.this.mOtherParams);
            }

            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void xW() {
                if (ALALiveTextView.this.aur != null) {
                    ALALiveTextView.this.aur.wu();
                }
                LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
            }
        });
        this.auq.setCallback(new QuickImInputPanelView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.8
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
        this.auv = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean xP() {
        return this.aun != null && this.aun.isChecked();
    }

    public bb getBarrageInfo() {
        return this.aum.getSelectInfo();
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.auo.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0104a interfaceC0104a) {
        this.aur = interfaceC0104a;
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

    public void dQ(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean xQ() {
        return getView().getVisibility() == 0 && this.auq.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.auq.setVisibility(0);
            if (this.aut < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                this.auq.yl();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auq.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.auq.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.auq.setVisibility(8);
        if (this.auo != null) {
            this.auo.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void xR() {
        if (this.auo != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.auo);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.aut - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void xS() {
        this.auo.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.auo.getSelectionStart();
            Editable editableText = this.auo.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.auo.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void b(List<String> list, Map<String, Integer> map) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.ahE = map;
        xT();
        this.auo.requestFocus();
        if (this.auo != null) {
            this.auo.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.auo);
                }
            });
        }
        if (list == null || list.isEmpty()) {
            this.aul.setData(list);
            this.auq.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() >= 3) {
            this.aul.setData(arrayList.subList(0, 3));
        } else {
            this.aul.setData(arrayList);
        }
        this.aul.setVisibility(xP() ? 8 : 0);
        this.auq.setVisibility(0);
        this.auq.yk();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.auq.getLayoutParams();
        layoutParams.height = -2;
        this.auq.setLayoutParams(layoutParams);
        this.auq.setData(arrayList);
        this.auq.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.10
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.aut = ALALiveTextView.this.auq.getHeight();
                ALALiveTextView.this.auq.setVisibility(8);
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
        this.auo.clearFocus();
        if (this.auk != null) {
            this.auk.release();
        }
        setVisibility(8);
    }

    public void h(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.aum != null) {
            this.aum.i(map);
        }
    }

    private void xT() {
        if (this.auv) {
            this.aun.setVisibility(8);
            return;
        }
        final bb[] aT = k.wA().aT(this.aur != null && this.aur.ww());
        if (aT == null || aT.length <= 0) {
            if (this.aun.isChecked()) {
                this.aun.setChecked(false, false);
            } else {
                aX(false);
            }
            this.aun.setVisibility(8);
            return;
        }
        if (this.aum.getWidth() <= 0) {
            this.aum.setVisibility(0);
        }
        this.aum.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.wA().wC()) {
                    ALALiveTextView.this.aum.setData(aT, ALALiveTextView.this.ahE, 0);
                    if (ALALiveTextView.this.aun.isChecked()) {
                        ALALiveTextView.this.aum.setSelectId(k.wA().wD());
                        ALALiveTextView.this.xV();
                        ALALiveTextView.this.aY(true);
                    } else {
                        ALALiveTextView.this.aun.setChecked(true, false);
                    }
                } else if (ALALiveTextView.this.aun.isChecked()) {
                    ALALiveTextView.this.aun.setChecked(false, false);
                }
                ALALiveTextView.this.aum.setVisibility(ALALiveTextView.this.aun.isChecked() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU() {
        if (this.aup != null) {
            if (TextUtils.isEmpty(this.auo.getText())) {
                this.aup.setClickable(false);
            } else {
                this.aup.setClickable(true);
            }
        }
        if (this.auo.getText().length() > this.auu) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.auu)));
            this.auo.setText(this.auo.getText().subSequence(0, this.auu));
            this.auo.setSelection(this.auo.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xV() {
        bb selectInfo = this.aum.getSelectInfo();
        if (this.auo != null && selectInfo != null) {
            switch (selectInfo.type) {
                case 1:
                    this.auo.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                    return;
                case 16:
                    this.auo.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(boolean z) {
        if (z && this.aur != null && !this.aur.ws()) {
            this.aun.setChecked(false, false);
            return;
        }
        this.auu = z ? 20 : 50;
        if (z && this.auo != null && this.auo.getText() != null && this.auo.getText().length() > this.auu) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.auu)));
        }
        if (z) {
            this.aum.setData(k.wA().aT(this.aur != null && this.aur.ww()), this.ahE, 0);
            this.aum.setSwitchStatus(true);
            if (!TextUtils.isEmpty(k.wA().wD())) {
                this.aum.setSelectId(k.wA().wD());
            } else {
                this.aum.setSelectPos(0);
            }
            this.aum.setVisibility(0);
            aY(true);
            this.aul.setVisibility(8);
            xV();
            setQuickInputPanelVisible(false);
        } else {
            this.aum.setSwitchStatus(false);
            this.auk.setVisibility(8);
            this.aum.setVisibility(8);
            this.aul.setVisibility(0);
            if (this.auo != null) {
                this.auo.setHint(a.i.sdk_im_sendmessage_to_host);
            }
        }
        if (this.aur != null) {
            this.aur.wv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (z) {
            this.auk.setPreview();
        }
        this.auk.setUIInfo(this.aum.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.auk.setVisibility(8);
        } else if (this.aun != null && this.aun.isChecked()) {
            this.auk.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z) {
        if (this.aur != null) {
            this.aur.j(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.auk.setVisibility(8);
            } else if (this.aun != null && this.aun.isChecked()) {
                this.auk.setVisibility(0);
            }
        }
    }
}

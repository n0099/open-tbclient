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
    private ImBarrageItemView auj;
    private QuickImInputHeaderView auk;
    private ImBarrageOptionListView aul;
    private Switch aum;
    private EditText aun;
    private GradientEnableTextView auo;
    private QuickImInputPanelView aup;
    private a.InterfaceC0104a auq;
    private long aur;
    private int aus;
    private int aut;
    private boolean auu;
    private View.OnClickListener auv;
    private String mOtherParams;
    private TextWatcher mTextWatcher;
    private String mVid;

    public ALALiveTextView(Context context) {
        super(context);
        this.auv = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aur >= 2000) {
                    ALALiveTextView.this.aur = currentTimeMillis;
                    String obj = ALALiveTextView.this.aun.getText().toString();
                    if (obj.length() > ALALiveTextView.this.aut) {
                        obj = obj.subSequence(0, ALALiveTextView.this.aut).toString();
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
        this.auv = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aur >= 2000) {
                    ALALiveTextView.this.aur = currentTimeMillis;
                    String obj = ALALiveTextView.this.aun.getText().toString();
                    if (obj.length() > ALALiveTextView.this.aut) {
                        obj = obj.subSequence(0, ALALiveTextView.this.aut).toString();
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
        this.auv = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ALALiveTextView.this.aur >= 2000) {
                    ALALiveTextView.this.aur = currentTimeMillis;
                    String obj = ALALiveTextView.this.aun.getText().toString();
                    if (obj.length() > ALALiveTextView.this.aut) {
                        obj = obj.subSequence(0, ALALiveTextView.this.aut).toString();
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
        this.aut = 50;
    }

    private void xN() {
        this.auj = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aul = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aum = (Switch) findViewById(a.g.switch_barrage);
        this.aul.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.4
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean xn() {
                return ALALiveTextView.this.auq != null && ALALiveTextView.this.auq.ww();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bP(int i) {
                ALALiveTextView.this.xV();
                ALALiveTextView.this.aY(false);
            }
        });
        this.aum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.aX(z);
            }
        });
    }

    private void tu() {
        this.aun = (EditText) findViewById(a.g.edit_text);
        this.aun.addTextChangedListener(this.mTextWatcher);
        this.aun.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.6
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aun.getText())) {
                        ALALiveTextView.this.k(ALALiveTextView.this.aun.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.auo = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.auo.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.aun, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.aun, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.auo.setOnClickListener(this.auv);
        this.auo.setClickable(false);
    }

    private void xO() {
        this.auk = (QuickImInputHeaderView) findViewById(a.g.quick_input_header);
        this.aup = (QuickImInputPanelView) findViewById(a.g.quick_input_panel);
        this.auk.setCallback(new QuickImInputHeaderView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.7
            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void r(String str, int i) {
                ALALiveTextView.this.k(str, true);
                LogManager.getCommonLogger().doClickQuickImToolLog(ALALiveTextView.this.mVid, String.valueOf(i), str, ALALiveTextView.this.mOtherParams);
            }

            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void xW() {
                if (ALALiveTextView.this.auq != null) {
                    ALALiveTextView.this.auq.wu();
                }
                LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
            }
        });
        this.aup.setCallback(new QuickImInputPanelView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.8
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
        this.auu = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean xP() {
        return this.aum != null && this.aum.isChecked();
    }

    public bb getBarrageInfo() {
        return this.aul.getSelectInfo();
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.aun.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0104a interfaceC0104a) {
        this.auq = interfaceC0104a;
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
        return getView().getVisibility() == 0 && this.aup.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.aup.setVisibility(0);
            if (this.aus < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                this.aup.yl();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aup.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.aup.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.aup.setVisibility(8);
        if (this.aun != null) {
            this.aun.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void xR() {
        if (this.aun != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.aun);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.aus - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void xS() {
        this.aun.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.aun.getSelectionStart();
            Editable editableText = this.aun.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.aun.setHint(i);
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
        this.aun.requestFocus();
        if (this.aun != null) {
            this.aun.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.aun);
                }
            });
        }
        if (list == null || list.isEmpty()) {
            this.auk.setData(list);
            this.aup.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() >= 3) {
            this.auk.setData(arrayList.subList(0, 3));
        } else {
            this.auk.setData(arrayList);
        }
        this.auk.setVisibility(xP() ? 8 : 0);
        this.aup.setVisibility(0);
        this.aup.yk();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aup.getLayoutParams();
        layoutParams.height = -2;
        this.aup.setLayoutParams(layoutParams);
        this.aup.setData(arrayList);
        this.aup.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.10
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.aus = ALALiveTextView.this.aup.getHeight();
                ALALiveTextView.this.aup.setVisibility(8);
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
        this.aun.clearFocus();
        if (this.auj != null) {
            this.auj.release();
        }
        setVisibility(8);
    }

    public void h(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.aul != null) {
            this.aul.i(map);
        }
    }

    private void xT() {
        if (this.auu) {
            this.aum.setVisibility(8);
            return;
        }
        final bb[] aT = k.wA().aT(this.auq != null && this.auq.ww());
        if (aT == null || aT.length <= 0) {
            if (this.aum.isChecked()) {
                this.aum.setChecked(false, false);
            } else {
                aX(false);
            }
            this.aum.setVisibility(8);
            return;
        }
        if (this.aul.getWidth() <= 0) {
            this.aul.setVisibility(0);
        }
        this.aul.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.2
            @Override // java.lang.Runnable
            public void run() {
                if (k.wA().wC()) {
                    ALALiveTextView.this.aul.setData(aT, ALALiveTextView.this.ahE, 0);
                    if (ALALiveTextView.this.aum.isChecked()) {
                        ALALiveTextView.this.aul.setSelectId(k.wA().wD());
                        ALALiveTextView.this.xV();
                        ALALiveTextView.this.aY(true);
                    } else {
                        ALALiveTextView.this.aum.setChecked(true, false);
                    }
                } else if (ALALiveTextView.this.aum.isChecked()) {
                    ALALiveTextView.this.aum.setChecked(false, false);
                }
                ALALiveTextView.this.aul.setVisibility(ALALiveTextView.this.aum.isChecked() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xU() {
        if (this.auo != null) {
            if (TextUtils.isEmpty(this.aun.getText())) {
                this.auo.setClickable(false);
            } else {
                this.auo.setClickable(true);
            }
        }
        if (this.aun.getText().length() > this.aut) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aut)));
            this.aun.setText(this.aun.getText().subSequence(0, this.aut));
            this.aun.setSelection(this.aun.getText().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xV() {
        bb selectInfo = this.aul.getSelectInfo();
        if (this.aun != null && selectInfo != null) {
            switch (selectInfo.type) {
                case 1:
                    this.aun.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                    return;
                case 16:
                    this.aun.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(boolean z) {
        if (z && this.auq != null && !this.auq.ws()) {
            this.aum.setChecked(false, false);
            return;
        }
        this.aut = z ? 20 : 50;
        if (z && this.aun != null && this.aun.getText() != null && this.aun.getText().length() > this.aut) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aut)));
        }
        if (z) {
            this.aul.setData(k.wA().aT(this.auq != null && this.auq.ww()), this.ahE, 0);
            this.aul.setSwitchStatus(true);
            if (!TextUtils.isEmpty(k.wA().wD())) {
                this.aul.setSelectId(k.wA().wD());
            } else {
                this.aul.setSelectPos(0);
            }
            this.aul.setVisibility(0);
            aY(true);
            this.auk.setVisibility(8);
            xV();
            setQuickInputPanelVisible(false);
        } else {
            this.aul.setSwitchStatus(false);
            this.auj.setVisibility(8);
            this.aul.setVisibility(8);
            this.auk.setVisibility(0);
            if (this.aun != null) {
                this.aun.setHint(a.i.sdk_im_sendmessage_to_host);
            }
        }
        if (this.auq != null) {
            this.auq.wv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (z) {
            this.auj.setPreview();
        }
        this.auj.setUIInfo(this.aul.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.auj.setVisibility(8);
        } else if (this.aum != null && this.aum.isChecked()) {
            this.auj.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, boolean z) {
        if (this.auq != null) {
            this.auq.j(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.auj.setVisibility(8);
            } else if (this.aum != null && this.aum.isChecked()) {
                this.auj.setVisibility(0);
            }
        }
    }
}

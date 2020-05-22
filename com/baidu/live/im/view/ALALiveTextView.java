package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.bj;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.m;
import com.baidu.live.im.view.barrage.ImBarrageItemView;
import com.baidu.live.im.view.barrage.ImBarrageOptionListView;
import com.baidu.live.im.view.quick.QuickImInputHeaderView;
import com.baidu.live.im.view.quick.QuickImInputPanelView;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
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
    private Map<String, Integer> aFH;
    private int aJP;
    public CustomMessageListener aMA;
    private boolean aTs;
    private int aTt;
    private int aTu;
    public CustomMessageListener aTv;
    private ImBarrageItemView aUg;
    private QuickImInputHeaderView aUh;
    private ImBarrageOptionListView aUi;
    private Switch aUj;
    private EditText aUk;
    private GradientEnableTextView aUl;
    private QuickImInputPanelView aUm;
    private a.InterfaceC0184a aUn;
    private long aUo;
    private int aUp;
    private int aUq;
    private boolean aUr;
    private BdPageContext aUs;
    private String aUt;
    private int aUu;
    private View.OnClickListener aUv;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TextWatcher mTextWatcher;
    private String mUserName;
    private String mVid;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        Log.i("i", "@@@ localText swfbwtst gb=" + imForbiddenStateData.globalBan + ",cb=" + imForbiddenStateData.anchorBan + ",bl=" + imForbiddenStateData.liveBan);
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aTF == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aTG);
            }
            this.mDialog = new BdAlertDialog(this.aUs.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                        BrowserHelper.startInternalWebActivity(ALALiveTextView.this.getContext(), "https%3A%2F%2Fufosdk.baidu.com%2F%3Fm%3DClient%26a%3DpostViewNew%26appid%3D238780%26needFbtype%3Dtrue%26hasRt%3Dfalse%26hasTitleBar%3Dfalse%26fbtnPlace%3Dbr%26channelId%3D90953");
                    } else {
                        BrowserHelper.startInternalWebActivity(ALALiveTextView.this.getContext(), "https://ufosdk.baidu.com/?m=Client&a=postViewNew&appid=238780&needFbtype=true&hasRt=false&hasTitleBar=false&fbtnPlace=br&channelId=90953");
                    }
                    bdAlertDialog.dismiss();
                }
            });
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.mDialog.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.mDialog.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.mDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.mDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.mDialog.create(this.aUs);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void AF() {
        this.aMA = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aMA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ee() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aUo >= 2000) {
            this.aUo = currentTimeMillis;
            String obj = this.aUk.getText().toString();
            if (obj.length() > this.aUq) {
                obj = obj.subSequence(0, this.aUq).toString();
            }
            Log.i("i", "@@@ localText normal tosd");
            s(obj, false);
            return;
        }
        BdUtilHelper.showToast(getContext(), "您按得太快，我都跟不上了~");
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.aTu = 0;
        this.aTv = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aTu != 3 && ALALiveTextView.this.aTu != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                        ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                        if (imForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + imForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aTu);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aTu == 3) {
                                ALALiveTextView.this.Ee();
                            } else if (ALALiveTextView.this.aTu == 4) {
                                ALALiveTextView.this.B(ALALiveTextView.this.aUt, ALALiveTextView.this.aUu);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aTu = 0;
                }
            }
        };
        this.aUv = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.v.a.Ge().aWF.ayB;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.v.a.Ge().aWF.ayA;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.aTs);
                if (i2 == 1) {
                    if (ALALiveTextView.this.aTs) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aTu = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.Ee();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.Ee();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aUy;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.aUy = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.aUy, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTu = 0;
        this.aTv = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aTu != 3 && ALALiveTextView.this.aTu != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                        ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                        if (imForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + imForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aTu);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aTu == 3) {
                                ALALiveTextView.this.Ee();
                            } else if (ALALiveTextView.this.aTu == 4) {
                                ALALiveTextView.this.B(ALALiveTextView.this.aUt, ALALiveTextView.this.aUu);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aTu = 0;
                }
            }
        };
        this.aUv = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.v.a.Ge().aWF.ayB;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.v.a.Ge().aWF.ayA;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.aTs);
                if (i2 == 1) {
                    if (ALALiveTextView.this.aTs) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aTu = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.Ee();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.Ee();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aUy;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.aUy = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.aUy, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aTu = 0;
        this.aTv = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aTu != 3 && ALALiveTextView.this.aTu != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                        ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                        if (imForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + imForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aTu);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aTu == 3) {
                                ALALiveTextView.this.Ee();
                            } else if (ALALiveTextView.this.aTu == 4) {
                                ALALiveTextView.this.B(ALALiveTextView.this.aUt, ALALiveTextView.this.aUu);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aTu = 0;
                }
            }
        };
        this.aUv = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i2 = com.baidu.live.v.a.Ge().aWF.ayB;
                if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i22 = com.baidu.live.v.a.Ge().aWF.ayA;
                Log.i("i", "@@@ localText send 1 isw=" + i22 + ", fb=" + ALALiveTextView.this.aTs);
                if (i22 == 1) {
                    if (ALALiveTextView.this.aTs) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aTu = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.Ee();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.Ee();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aUy;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.aUy = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.aUy, i2);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setBackgroundColor(0);
        setClickable(true);
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.h.ala_im_input_layout, (ViewGroup) this, true);
        Ef();
        Eg();
        Eh();
        this.aUq = 50;
    }

    private void Ef() {
        this.aUg = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aUi = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aUj = (Switch) findViewById(a.g.switch_barrage);
        this.aUi.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.13
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean DA() {
                return ALALiveTextView.this.aUn != null && ALALiveTextView.this.aUn.CG();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bV(int i) {
                ALALiveTextView.this.En();
                ALALiveTextView.this.bL(false);
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public int CH() {
                if (ALALiveTextView.this.aUn != null) {
                    return ALALiveTextView.this.aUn.CH();
                }
                return 0;
            }
        });
        this.aUj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.bK(z);
            }
        });
    }

    private void Eg() {
        this.aUk = (EditText) findViewById(a.g.edit_text);
        this.aUk.addTextChangedListener(this.mTextWatcher);
        this.aUk.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aUk.getText())) {
                        ALALiveTextView.this.s(ALALiveTextView.this.aUk.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.aUl = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.aUl.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.aUk, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.aUk, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.aUl.setOnClickListener(this.aUv);
        this.aUl.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.aTs = z;
        this.aTt = i;
        this.aJP = i2;
        this.mUserName = str;
    }

    private void Eh() {
        this.aUh = (QuickImInputHeaderView) findViewById(a.g.quick_input_header);
        this.aUm = (QuickImInputPanelView) findViewById(a.g.quick_input_panel);
        this.aUh.setCallback(new QuickImInputHeaderView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void C(String str, int i) {
                if (com.baidu.live.v.a.Ge().aWF.ayB == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Ge().aWF.ayA == 1) {
                    if (ALALiveTextView.this.aTs) {
                        ALALiveTextView.this.aUt = str;
                        ALALiveTextView.this.aUu = i;
                        ALALiveTextView.this.aTu = 4;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.B(str, i);
                } else {
                    ALALiveTextView.this.B(str, i);
                }
            }

            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void Ep() {
                if (ALALiveTextView.this.aUn != null) {
                    ALALiveTextView.this.aUn.CE();
                }
                LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
            }
        });
        this.aUm.setCallback(new QuickImInputPanelView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
            @Override // com.baidu.live.im.view.quick.QuickImInputPanelView.a
            public void C(String str, int i) {
                if (com.baidu.live.v.a.Ge().aWF.ayB == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Ge().aWF.ayA == 1) {
                    if (ALALiveTextView.this.aTs) {
                        ALALiveTextView.this.aUt = str;
                        ALALiveTextView.this.aUu = i;
                        ALALiveTextView.this.aTu = 4;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.B(str, i);
                } else {
                    ALALiveTextView.this.B(str, i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, int i) {
        s(str, true);
        LogManager.getCommonLogger().doClickQuickImPanelLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.aUr = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ei() {
        return this.aUj != null && this.aUj.isChecked();
    }

    public bj getBarrageInfo() {
        return this.aUi.getSelectInfo();
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.aUk.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0184a interfaceC0184a) {
        this.aUn = interfaceC0184a;
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

    public void fu(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ej() {
        return getView().getVisibility() == 0 && this.aUm.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.aUm.setVisibility(0);
            if (this.aUp < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                this.aUm.EH();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aUm.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.aUm.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.aUm.setVisibility(8);
        if (this.aUk != null) {
            this.aUk.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Ek() {
        if (this.aUk != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.aUk);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.aUp - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aUs = bdPageContext;
    }

    public void El() {
        this.aUk.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.aUk.getSelectionStart();
            Editable editableText = this.aUk.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.aUk.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aFH = map;
        Em();
        this.aUk.requestFocus();
        if (this.aUk != null) {
            this.aUk.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.aUk.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.aUk);
                }
            });
        }
        if (list == null || list.isEmpty()) {
            this.aUh.setData(list);
            this.aUm.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() >= 3) {
            this.aUh.setData(arrayList.subList(0, 3));
        } else {
            this.aUh.setData(arrayList);
        }
        this.aUh.setVisibility(Ei() ? 8 : 0);
        this.aUm.setVisibility(0);
        this.aUm.EG();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aUm.getLayoutParams();
        layoutParams.height = -2;
        this.aUm.setLayoutParams(layoutParams);
        this.aUm.setData(arrayList);
        this.aUm.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.aUp = ALALiveTextView.this.aUm.getHeight();
                ALALiveTextView.this.aUm.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public void show() {
        a((List<String>) null, (Map<String, Integer>) null);
    }

    @Override // com.baidu.live.view.input.a
    public void hide() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        this.aUk.clearFocus();
        if (this.aUg != null) {
            this.aUg.release();
        }
        setVisibility(8);
    }

    public void f(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.aUi != null) {
            this.aUi.g(map);
        }
    }

    private void Em() {
        if (this.aUr) {
            this.aUj.setVisibility(8);
            return;
        }
        final bj[] e = m.CL().e(this.aUn != null && this.aUn.CG(), this.aUn != null ? this.aUn.CH() : 0);
        if (e == null || e.length <= 0) {
            if (this.aUj.isChecked()) {
                this.aUj.setChecked(false, false);
            } else {
                bK(false);
            }
            this.aUj.setVisibility(8);
            return;
        }
        if (this.aUi.getWidth() <= 0) {
            this.aUi.setVisibility(0);
        }
        this.aUi.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
            @Override // java.lang.Runnable
            public void run() {
                if (m.CL().CN()) {
                    ALALiveTextView.this.aUi.setData(e, ALALiveTextView.this.aFH, 0);
                    if (ALALiveTextView.this.aUj.isChecked()) {
                        ALALiveTextView.this.aUi.setSelectId(m.CL().CO());
                        ALALiveTextView.this.En();
                        ALALiveTextView.this.bL(true);
                    } else {
                        ALALiveTextView.this.aUj.setChecked(true, false);
                    }
                } else if (ALALiveTextView.this.aUj.isChecked()) {
                    ALALiveTextView.this.aUj.setChecked(false, false);
                }
                ALALiveTextView.this.aUi.setVisibility(ALALiveTextView.this.aUj.isChecked() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.aUl != null) {
            if (TextUtils.isEmpty(this.aUk.getText())) {
                this.aUl.setClickable(false);
            } else {
                this.aUl.setClickable(true);
            }
        }
        if (this.aUk.getText().length() > this.aUq) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aUq)));
            if (charSequence.length() > this.aUq) {
                this.aUk.setText(charSequence.subSequence(0, this.aUq));
                this.aUk.setSelection(this.aUk.getText().length());
                return;
            }
            this.aUk.setText(charSequence);
            if (i <= charSequence.length()) {
                this.aUk.setSelection(i);
            } else {
                this.aUk.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void En() {
        bj selectInfo = this.aUi.getSelectInfo();
        if (this.aUk != null && selectInfo != null) {
            switch (selectInfo.type) {
                case 1:
                    this.aUk.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                    return;
                case 16:
                    this.aUk.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                    return;
                case 17:
                    if (selectInfo.aCc == 7) {
                        this.aUk.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_king_barrage));
                        return;
                    } else {
                        this.aUk.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_barrage));
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (z && this.aUn != null && !this.aUn.CC()) {
            this.aUj.setChecked(false, false);
            return;
        }
        this.aUq = z ? 20 : 50;
        if (z && this.aUk != null && this.aUk.getText() != null && this.aUk.getText().length() > this.aUq) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aUq)));
        }
        if (z) {
            this.aUi.setData(m.CL().e(this.aUn != null && this.aUn.CG(), this.aUn != null ? this.aUn.CH() : 0), this.aFH, 0);
            this.aUi.setSwitchStatus(true);
            if (!TextUtils.isEmpty(m.CL().CO())) {
                this.aUi.setSelectId(m.CL().CO());
            } else {
                this.aUi.setSelectPos(0);
            }
            this.aUi.setVisibility(0);
            bL(true);
            this.aUh.setVisibility(8);
            En();
            setQuickInputPanelVisible(false);
            if (this.aUs != null && this.aUs.getPageActivity() != null && this.aUk != null) {
                BdUtilHelper.showSoftKeyPad(this.aUs.getPageActivity(), this.aUk);
            }
        } else {
            this.aUi.setSwitchStatus(false);
            this.aUg.setVisibility(8);
            this.aUi.setVisibility(8);
            this.aUh.setVisibility(0);
            if (this.aUk != null) {
                this.aUk.setHint(a.i.sdk_im_sendmessage_to_host);
            }
        }
        if (this.aUn != null) {
            this.aUn.CF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (z) {
            this.aUg.setPreview();
        }
        this.aUg.setUIInfo(this.aUi.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aUg.setVisibility(8);
        } else if (this.aUj != null && this.aUj.isChecked()) {
            this.aUg.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, boolean z) {
        if (this.aUn != null) {
            Log.i("i", "@@@ localText st go");
            this.aUn.r(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aUg.setVisibility(8);
            } else if (this.aUj != null && this.aUj.isChecked()) {
                this.aUg.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Eo() {
        if (this.aUk != null) {
            this.aUk.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.aUk.requestFocus();
                }
            });
        }
    }
}

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
import com.baidu.live.data.be;
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
    private Map<String, Integer> aAo;
    private int aEo;
    public CustomMessageListener aGS;
    private ImBarrageItemView aNZ;
    private boolean aNm;
    private int aNn;
    private int aNo;
    public CustomMessageListener aNp;
    private QuickImInputHeaderView aOa;
    private ImBarrageOptionListView aOb;
    private Switch aOc;
    private EditText aOd;
    private GradientEnableTextView aOe;
    private QuickImInputPanelView aOf;
    private a.InterfaceC0151a aOg;
    private long aOh;
    private int aOi;
    private int aOj;
    private boolean aOk;
    private BdPageContext aOl;
    private String aOm;
    private int aOn;
    private View.OnClickListener aOo;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TextWatcher mTextWatcher;
    private String mUserName;
    private String mVid;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        Log.i("i", "@@@ localText swfbwtst gb=" + imForbiddenStateData.globalBan + ",cb=" + imForbiddenStateData.anchorBan + ",bl=" + imForbiddenStateData.liveBan);
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aNz == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aNA);
            }
            this.mDialog = new BdAlertDialog(this.aOl.getPageActivity());
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
            this.mDialog.create(this.aOl);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void zq() {
        this.aGS = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CH() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aOh >= 2000) {
            this.aOh = currentTimeMillis;
            String obj = this.aOd.getText().toString();
            if (obj.length() > this.aOj) {
                obj = obj.subSequence(0, this.aOj).toString();
            }
            Log.i("i", "@@@ localText normal tosd");
            o(obj, false);
            return;
        }
        BdUtilHelper.showToast(getContext(), "您按得太快，我都跟不上了~");
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.aNo = 0;
        this.aNp = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aNo != 3 && ALALiveTextView.this.aNo != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aNo);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aNo == 3) {
                                ALALiveTextView.this.CH();
                            } else if (ALALiveTextView.this.aNo == 4) {
                                ALALiveTextView.this.x(ALALiveTextView.this.aOm, ALALiveTextView.this.aOn);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aNo = 0;
                }
            }
        };
        this.aOo = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.v.a.En().aQu.atD;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.v.a.En().aQu.atC;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.aNm);
                if (i2 == 1) {
                    if (ALALiveTextView.this.aNm) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aNo = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.CH();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.CH();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aOr;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.aOr = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.aOr, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNo = 0;
        this.aNp = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aNo != 3 && ALALiveTextView.this.aNo != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aNo);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aNo == 3) {
                                ALALiveTextView.this.CH();
                            } else if (ALALiveTextView.this.aNo == 4) {
                                ALALiveTextView.this.x(ALALiveTextView.this.aOm, ALALiveTextView.this.aOn);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aNo = 0;
                }
            }
        };
        this.aOo = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.v.a.En().aQu.atD;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.v.a.En().aQu.atC;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.aNm);
                if (i2 == 1) {
                    if (ALALiveTextView.this.aNm) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aNo = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.CH();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.CH();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aOr;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.aOr = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.aOr, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNo = 0;
        this.aNp = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aNo != 3 && ALALiveTextView.this.aNo != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aNo);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aNo == 3) {
                                ALALiveTextView.this.CH();
                            } else if (ALALiveTextView.this.aNo == 4) {
                                ALALiveTextView.this.x(ALALiveTextView.this.aOm, ALALiveTextView.this.aOn);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aNo = 0;
                }
            }
        };
        this.aOo = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i2 = com.baidu.live.v.a.En().aQu.atD;
                if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i22 = com.baidu.live.v.a.En().aQu.atC;
                Log.i("i", "@@@ localText send 1 isw=" + i22 + ", fb=" + ALALiveTextView.this.aNm);
                if (i22 == 1) {
                    if (ALALiveTextView.this.aNm) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aNo = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.CH();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.CH();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aOr;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.aOr = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.aOr, i2);
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
        CI();
        CJ();
        CK();
        this.aOj = 50;
    }

    private void CI() {
        this.aNZ = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aOb = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aOc = (Switch) findViewById(a.g.switch_barrage);
        this.aOb.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.13
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean Cd() {
                return ALALiveTextView.this.aOg != null && ALALiveTextView.this.aOg.Bk();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bO(int i) {
                ALALiveTextView.this.CQ();
                ALALiveTextView.this.bC(false);
            }
        });
        this.aOc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.bB(z);
            }
        });
    }

    private void CJ() {
        this.aOd = (EditText) findViewById(a.g.edit_text);
        this.aOd.addTextChangedListener(this.mTextWatcher);
        this.aOd.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aOd.getText())) {
                        ALALiveTextView.this.o(ALALiveTextView.this.aOd.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.aOe = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.aOe.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.aOd, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.aOd, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.aOe.setOnClickListener(this.aOo);
        this.aOe.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.aNm = z;
        this.aNn = i;
        this.aEo = i2;
        this.mUserName = str;
    }

    private void CK() {
        this.aOa = (QuickImInputHeaderView) findViewById(a.g.quick_input_header);
        this.aOf = (QuickImInputPanelView) findViewById(a.g.quick_input_panel);
        this.aOa.setCallback(new QuickImInputHeaderView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void y(String str, int i) {
                if (com.baidu.live.v.a.En().aQu.atD == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.En().aQu.atC == 1) {
                    if (ALALiveTextView.this.aNm) {
                        ALALiveTextView.this.aOm = str;
                        ALALiveTextView.this.aOn = i;
                        ALALiveTextView.this.aNo = 4;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.x(str, i);
                } else {
                    ALALiveTextView.this.x(str, i);
                }
            }

            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void CS() {
                if (ALALiveTextView.this.aOg != null) {
                    ALALiveTextView.this.aOg.Bi();
                }
                LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
            }
        });
        this.aOf.setCallback(new QuickImInputPanelView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
            @Override // com.baidu.live.im.view.quick.QuickImInputPanelView.a
            public void y(String str, int i) {
                if (com.baidu.live.v.a.En().aQu.atD == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.En().aQu.atC == 1) {
                    if (ALALiveTextView.this.aNm) {
                        ALALiveTextView.this.aOm = str;
                        ALALiveTextView.this.aOn = i;
                        ALALiveTextView.this.aNo = 4;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.x(str, i);
                } else {
                    ALALiveTextView.this.x(str, i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, int i) {
        o(str, true);
        LogManager.getCommonLogger().doClickQuickImPanelLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.aOk = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean CL() {
        return this.aOc != null && this.aOc.isChecked();
    }

    public be getBarrageInfo() {
        return this.aOb.getSelectInfo();
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.aOd.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0151a interfaceC0151a) {
        this.aOg = interfaceC0151a;
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

    public void eI(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean CM() {
        return getView().getVisibility() == 0 && this.aOf.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.aOf.setVisibility(0);
            if (this.aOi < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                this.aOf.Dj();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aOf.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.aOf.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.aOf.setVisibility(8);
        if (this.aOd != null) {
            this.aOd.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void CN() {
        if (this.aOd != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.aOd);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.aOi - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aOl = bdPageContext;
    }

    public void CO() {
        this.aOd.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.aOd.getSelectionStart();
            Editable editableText = this.aOd.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.aOd.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aAo = map;
        CP();
        this.aOd.requestFocus();
        if (this.aOd != null) {
            this.aOd.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.aOd.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.aOd);
                }
            });
        }
        if (list == null || list.isEmpty()) {
            this.aOa.setData(list);
            this.aOf.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() >= 3) {
            this.aOa.setData(arrayList.subList(0, 3));
        } else {
            this.aOa.setData(arrayList);
        }
        this.aOa.setVisibility(CL() ? 8 : 0);
        this.aOf.setVisibility(0);
        this.aOf.Di();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aOf.getLayoutParams();
        layoutParams.height = -2;
        this.aOf.setLayoutParams(layoutParams);
        this.aOf.setData(arrayList);
        this.aOf.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.aOi = ALALiveTextView.this.aOf.getHeight();
                ALALiveTextView.this.aOf.setVisibility(8);
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
        this.aOd.clearFocus();
        if (this.aNZ != null) {
            this.aNZ.release();
        }
        setVisibility(8);
    }

    public void e(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.aOb != null) {
            this.aOb.f(map);
        }
    }

    private void CP() {
        if (this.aOk) {
            this.aOc.setVisibility(8);
            return;
        }
        final be[] bw = m.Bo().bw(this.aOg != null && this.aOg.Bk());
        if (bw == null || bw.length <= 0) {
            if (this.aOc.isChecked()) {
                this.aOc.setChecked(false, false);
            } else {
                bB(false);
            }
            this.aOc.setVisibility(8);
            return;
        }
        if (this.aOb.getWidth() <= 0) {
            this.aOb.setVisibility(0);
        }
        this.aOb.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
            @Override // java.lang.Runnable
            public void run() {
                if (m.Bo().Bq()) {
                    ALALiveTextView.this.aOb.setData(bw, ALALiveTextView.this.aAo, 0);
                    if (ALALiveTextView.this.aOc.isChecked()) {
                        ALALiveTextView.this.aOb.setSelectId(m.Bo().Br());
                        ALALiveTextView.this.CQ();
                        ALALiveTextView.this.bC(true);
                    } else {
                        ALALiveTextView.this.aOc.setChecked(true, false);
                    }
                } else if (ALALiveTextView.this.aOc.isChecked()) {
                    ALALiveTextView.this.aOc.setChecked(false, false);
                }
                ALALiveTextView.this.aOb.setVisibility(ALALiveTextView.this.aOc.isChecked() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.aOe != null) {
            if (TextUtils.isEmpty(this.aOd.getText())) {
                this.aOe.setClickable(false);
            } else {
                this.aOe.setClickable(true);
            }
        }
        if (this.aOd.getText().length() > this.aOj) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aOj)));
            if (charSequence.length() > this.aOj) {
                this.aOd.setText(charSequence.subSequence(0, this.aOj));
                this.aOd.setSelection(this.aOd.getText().length());
                return;
            }
            this.aOd.setText(charSequence);
            if (i <= charSequence.length()) {
                this.aOd.setSelection(i);
            } else {
                this.aOd.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CQ() {
        be selectInfo = this.aOb.getSelectInfo();
        if (this.aOd != null && selectInfo != null) {
            switch (selectInfo.type) {
                case 1:
                    this.aOd.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                    return;
                case 16:
                    this.aOd.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        if (z && this.aOg != null && !this.aOg.Bg()) {
            this.aOc.setChecked(false, false);
            return;
        }
        this.aOj = z ? 20 : 50;
        if (z && this.aOd != null && this.aOd.getText() != null && this.aOd.getText().length() > this.aOj) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aOj)));
        }
        if (z) {
            this.aOb.setData(m.Bo().bw(this.aOg != null && this.aOg.Bk()), this.aAo, 0);
            this.aOb.setSwitchStatus(true);
            if (!TextUtils.isEmpty(m.Bo().Br())) {
                this.aOb.setSelectId(m.Bo().Br());
            } else {
                this.aOb.setSelectPos(0);
            }
            this.aOb.setVisibility(0);
            bC(true);
            this.aOa.setVisibility(8);
            CQ();
            setQuickInputPanelVisible(false);
        } else {
            this.aOb.setSwitchStatus(false);
            this.aNZ.setVisibility(8);
            this.aOb.setVisibility(8);
            this.aOa.setVisibility(0);
            if (this.aOd != null) {
                this.aOd.setHint(a.i.sdk_im_sendmessage_to_host);
            }
        }
        if (this.aOg != null) {
            this.aOg.Bj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(boolean z) {
        if (z) {
            this.aNZ.setPreview();
        }
        this.aNZ.setUIInfo(this.aOb.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aNZ.setVisibility(8);
        } else if (this.aOc != null && this.aOc.isChecked()) {
            this.aNZ.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, boolean z) {
        if (this.aOg != null) {
            Log.i("i", "@@@ localText st go");
            this.aOg.n(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aNZ.setVisibility(8);
            } else if (this.aOc != null && this.aOc.isChecked()) {
                this.aNZ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void CR() {
        if (this.aOd != null) {
            this.aOd.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.aOd.requestFocus();
                }
            });
        }
    }
}

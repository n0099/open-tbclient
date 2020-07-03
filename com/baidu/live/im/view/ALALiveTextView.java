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
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.bo;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.m;
import com.baidu.live.im.view.barrage.ImBarrageItemView;
import com.baidu.live.im.view.barrage.ImBarrageOptionListView;
import com.baidu.live.im.view.quick.QuickImInputHeaderView;
import com.baidu.live.im.view.quick.QuickImInputPanelView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.view.GradientEnableTextView;
import com.baidu.live.view.Switch;
import com.baidu.live.view.input.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class ALALiveTextView extends LinearLayout implements com.baidu.live.view.input.a {
    private Map<String, Integer> aId;
    private int aMv;
    public CustomMessageListener aPg;
    private boolean aVY;
    private int aVZ;
    private ImBarrageItemView aWN;
    private QuickImInputHeaderView aWO;
    private ImBarrageOptionListView aWP;
    private Switch aWQ;
    private EditText aWR;
    private GradientEnableTextView aWS;
    private QuickImInputPanelView aWT;
    private a.InterfaceC0190a aWU;
    private long aWV;
    private int aWW;
    private int aWX;
    private boolean aWY;
    private BdPageContext aWZ;
    private int aWa;
    private AlaLiveInfoData aWb;
    public CustomMessageListener aWc;
    private String aXa;
    private int aXb;
    private View.OnClickListener aXc;
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
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aWm == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aWn);
            }
            this.mDialog = new BdAlertDialog(this.aWZ.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.10
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
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.11
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
            this.mDialog.create(this.aWZ);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aWV >= 2000) {
            this.aWV = currentTimeMillis;
            String obj = this.aWR.getText().toString();
            if (obj.length() > this.aWX) {
                obj = obj.subSequence(0, this.aWX).toString();
            }
            Log.i("i", "@@@ localText normal tosd");
            s(obj, false);
            return;
        }
        BdUtilHelper.showToast(getContext(), "您按得太快，我都跟不上了~");
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.aWa = 0;
        this.aWc = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aWa != 3 && ALALiveTextView.this.aWa != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aWa);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aWa == 3) {
                                ALALiveTextView.this.EG();
                            } else if (ALALiveTextView.this.aWa == 4) {
                                ALALiveTextView.this.B(ALALiveTextView.this.aXa, ALALiveTextView.this.aXb);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aWa = 0;
                }
            }
        };
        this.aPg = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.aXc = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.v.a.Hm().aZp.aAQ;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.v.a.Hm().aZp.aAP;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.aVY);
                if (i2 == 1) {
                    if (ALALiveTextView.this.aVY) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aWa = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.EG();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.EG();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aXf;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.aXf = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.aXf, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWa = 0;
        this.aWc = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aWa != 3 && ALALiveTextView.this.aWa != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aWa);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aWa == 3) {
                                ALALiveTextView.this.EG();
                            } else if (ALALiveTextView.this.aWa == 4) {
                                ALALiveTextView.this.B(ALALiveTextView.this.aXa, ALALiveTextView.this.aXb);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aWa = 0;
                }
            }
        };
        this.aPg = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.aXc = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.v.a.Hm().aZp.aAQ;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.v.a.Hm().aZp.aAP;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.aVY);
                if (i2 == 1) {
                    if (ALALiveTextView.this.aVY) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aWa = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.EG();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.EG();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aXf;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.aXf = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.aXf, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aWa = 0;
        this.aWc = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aWa != 3 && ALALiveTextView.this.aWa != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aWa);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aWa == 3) {
                                ALALiveTextView.this.EG();
                            } else if (ALALiveTextView.this.aWa == 4) {
                                ALALiveTextView.this.B(ALALiveTextView.this.aXa, ALALiveTextView.this.aXb);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aWa = 0;
                }
            }
        };
        this.aPg = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.aXc = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i2 = com.baidu.live.v.a.Hm().aZp.aAQ;
                if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i22 = com.baidu.live.v.a.Hm().aZp.aAP;
                Log.i("i", "@@@ localText send 1 isw=" + i22 + ", fb=" + ALALiveTextView.this.aVY);
                if (i22 == 1) {
                    if (ALALiveTextView.this.aVY) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aWa = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.EG();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.EG();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aXf;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.aXf = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.aXf, i2);
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
        EH();
        EI();
        EJ();
        this.aWX = 50;
    }

    private void EH() {
        this.aWN = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aWP = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aWQ = (Switch) findViewById(a.g.switch_barrage);
        this.aWP.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.13
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean Ec() {
                return ALALiveTextView.this.aWU != null && ALALiveTextView.this.aWU.Dh();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void cd(int i) {
                ALALiveTextView.this.ER();
                ALALiveTextView.this.bL(false);
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public int Di() {
                if (ALALiveTextView.this.aWU != null) {
                    return ALALiveTextView.this.aWU.Di();
                }
                return 0;
            }
        });
        this.aWQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.bK(z);
            }
        });
    }

    private void EI() {
        this.aWR = (EditText) findViewById(a.g.edit_text);
        this.aWR.addTextChangedListener(this.mTextWatcher);
        this.aWR.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aWR.getText())) {
                        ALALiveTextView.this.s(ALALiveTextView.this.aWR.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.aWS = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.aWS.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.aWR, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.aWR, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.aWS.setOnClickListener(this.aXc);
        this.aWS.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.aVY = z;
        this.aVZ = i;
        this.aMv = i2;
        this.mUserName = str;
    }

    private void EJ() {
        this.aWO = (QuickImInputHeaderView) findViewById(a.g.quick_input_header);
        this.aWT = (QuickImInputPanelView) findViewById(a.g.quick_input_panel);
        this.aWO.setCallback(new QuickImInputHeaderView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void C(String str, int i) {
                if (com.baidu.live.v.a.Hm().aZp.aAQ == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Hm().aZp.aAP == 1) {
                    if (ALALiveTextView.this.aVY) {
                        ALALiveTextView.this.aXa = str;
                        ALALiveTextView.this.aXb = i;
                        ALALiveTextView.this.aWa = 4;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.B(str, i);
                } else {
                    ALALiveTextView.this.B(str, i);
                }
            }

            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void ET() {
                if (ALALiveTextView.this.aWU != null) {
                    ALALiveTextView.this.aWU.Df();
                }
                LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
            }
        });
        this.aWT.setCallback(new QuickImInputPanelView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
            @Override // com.baidu.live.im.view.quick.QuickImInputPanelView.a
            public void C(String str, int i) {
                if (com.baidu.live.v.a.Hm().aZp.aAQ == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Hm().aZp.aAP == 1) {
                    if (ALALiveTextView.this.aVY) {
                        ALALiveTextView.this.aXa = str;
                        ALALiveTextView.this.aXb = i;
                        ALALiveTextView.this.aWa = 4;
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
        this.aWY = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean EK() {
        return this.aWQ != null && this.aWQ.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean EL() {
        return !EP() && this.aWO.getVisibility() == 0;
    }

    public bo getBarrageInfo() {
        return this.aWP.getSelectInfo();
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.aWR.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0190a interfaceC0190a) {
        this.aWU = interfaceC0190a;
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

    public void fz(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean EM() {
        return getView().getVisibility() == 0 && this.aWT.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.aWT.setVisibility(0);
            if (this.aWW < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                this.aWT.Fl();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aWT.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.aWT.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.aWT.setVisibility(8);
        if (this.aWR != null) {
            this.aWR.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void EN() {
        if (this.aWR != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.aWR);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.aWW - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aWZ = bdPageContext;
    }

    public void EO() {
        this.aWR.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.aWR.getSelectionStart();
            Editable editableText = this.aWR.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.aWR.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.aWb = alaLiveInfoData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aId = map;
        EQ();
        this.aWR.requestFocus();
        if (this.aWR != null) {
            this.aWR.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.aWR.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.aWR);
                }
            });
        }
        boolean EP = EP();
        if (list == null || list.isEmpty() || EP) {
            this.aWO.setData(list);
            this.aWT.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() >= 3) {
            this.aWO.setData(arrayList.subList(0, 3));
        } else {
            this.aWO.setData(arrayList);
        }
        this.aWO.setVisibility(EK() ? 8 : 0);
        this.aWT.setVisibility(0);
        this.aWT.Fk();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aWT.getLayoutParams();
        layoutParams.height = -2;
        this.aWT.setLayoutParams(layoutParams);
        this.aWT.setData(arrayList);
        this.aWT.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.aWW = ALALiveTextView.this.aWT.getHeight();
                ALALiveTextView.this.aWT.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public void show() {
        a((List<String>) null, (Map<String, Integer>) null, (AlaLiveInfoData) null);
    }

    @Override // com.baidu.live.view.input.a
    public void hide() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        this.aWR.clearFocus();
        if (this.aWN != null) {
            this.aWN.release();
        }
        setVisibility(8);
    }

    public void f(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.aWP != null) {
            this.aWP.g(map);
        }
    }

    private boolean EP() {
        return (this.aWb == null || this.aWb.mAlaLiveSwitchData == null || !this.aWb.mAlaLiveSwitchData.mQuickChatInvalid) ? false : true;
    }

    private boolean DR() {
        return (this.aWb == null || this.aWb.mAlaLiveSwitchData == null || !this.aWb.mAlaLiveSwitchData.mPayBarrageInvalid) ? false : true;
    }

    private void EQ() {
        if (this.aWY || DR()) {
            this.aWQ.setVisibility(8);
            return;
        }
        final bo[] e = m.Dm().e(this.aWU != null && this.aWU.Dh(), this.aWU != null ? this.aWU.Di() : 0);
        if (e == null || e.length <= 0) {
            if (this.aWQ.isChecked()) {
                this.aWQ.setChecked(false, false);
            } else {
                bK(false);
            }
            this.aWQ.setVisibility(8);
            return;
        }
        this.aWQ.setVisibility(0);
        if (this.aWP.getWidth() <= 0) {
            this.aWP.setVisibility(0);
        }
        this.aWP.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
            @Override // java.lang.Runnable
            public void run() {
                if (m.Dm().Do()) {
                    ALALiveTextView.this.aWP.setData(e, ALALiveTextView.this.aId, 0);
                    if (ALALiveTextView.this.aWQ.isChecked()) {
                        ALALiveTextView.this.aWP.setSelectId(m.Dm().Dp());
                        ALALiveTextView.this.ER();
                        ALALiveTextView.this.bL(true);
                    } else {
                        ALALiveTextView.this.aWQ.setChecked(true, false);
                    }
                } else if (ALALiveTextView.this.aWQ.isChecked()) {
                    ALALiveTextView.this.aWQ.setChecked(false, false);
                }
                ALALiveTextView.this.aWP.setVisibility(ALALiveTextView.this.aWQ.isChecked() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.aWS != null) {
            if (TextUtils.isEmpty(this.aWR.getText())) {
                this.aWS.setClickable(false);
            } else {
                this.aWS.setClickable(true);
            }
        }
        if (this.aWR.getText().length() > this.aWX) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aWX)));
            if (charSequence.length() > this.aWX) {
                this.aWR.setText(charSequence.subSequence(0, this.aWX));
                this.aWR.setSelection(this.aWR.getText().length());
                return;
            }
            this.aWR.setText(charSequence);
            if (i <= charSequence.length()) {
                this.aWR.setSelection(i);
            } else {
                this.aWR.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ER() {
        bo selectInfo = this.aWP.getSelectInfo();
        if (this.aWR != null && selectInfo != null) {
            switch (selectInfo.type) {
                case 1:
                    this.aWR.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                    return;
                case 16:
                    this.aWR.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                    return;
                case 17:
                    if (selectInfo.aEn == 7) {
                        this.aWR.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_king_barrage));
                        return;
                    } else {
                        this.aWR.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_barrage));
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        if (z && this.aWU != null && !this.aWU.Dd()) {
            this.aWQ.setChecked(false, false);
            return;
        }
        this.aWX = z ? 20 : 50;
        if (z && this.aWR != null && this.aWR.getText() != null && this.aWR.getText().length() > this.aWX) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aWX)));
        }
        if (z) {
            this.aWP.setData(m.Dm().e(this.aWU != null && this.aWU.Dh(), this.aWU != null ? this.aWU.Di() : 0), this.aId, 0);
            this.aWP.setSwitchStatus(true);
            if (!TextUtils.isEmpty(m.Dm().Dp())) {
                this.aWP.setSelectId(m.Dm().Dp());
            } else {
                this.aWP.setSelectPos(0);
            }
            this.aWP.setVisibility(0);
            bL(true);
            this.aWO.setVisibility(8);
            ER();
            setQuickInputPanelVisible(false);
            if (this.aWZ != null && this.aWZ.getPageActivity() != null && this.aWR != null) {
                BdUtilHelper.showSoftKeyPad(this.aWZ.getPageActivity(), this.aWR);
            }
        } else {
            this.aWP.setSwitchStatus(false);
            this.aWN.setVisibility(8);
            this.aWP.setVisibility(8);
            if (!EP()) {
                this.aWO.setVisibility(0);
            }
            if (this.aWR != null) {
                this.aWR.setHint(a.i.sdk_im_sendmessage_to_host);
            }
        }
        if (this.aWU != null) {
            this.aWU.Dg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(boolean z) {
        if (z) {
            this.aWN.setPreview();
        }
        this.aWN.setUIInfo(this.aWP.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aWN.setVisibility(8);
        } else if (this.aWQ != null && this.aWQ.isChecked()) {
            this.aWN.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, boolean z) {
        if (this.aWU != null) {
            Log.i("i", "@@@ localText st go");
            this.aWU.r(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aWN.setVisibility(8);
            } else if (this.aWQ != null && this.aWQ.isChecked()) {
                this.aWN.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void ES() {
        if (this.aWR != null) {
            this.aWR.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.aWR.requestFocus();
                }
            });
        }
    }
}

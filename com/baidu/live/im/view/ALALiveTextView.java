package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ci;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.im.d.a;
import com.baidu.live.im.d.b;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tieba.view.GradientEnableTextView;
import com.baidu.live.view.Switch;
import com.baidu.live.view.input.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ALALiveTextView extends LinearLayout implements com.baidu.live.view.input.a {
    private Map<String, Integer> aXY;
    private int bdi;
    public CustomMessageListener bgy;
    public CustomMessageListener bon;
    private FrameLayout bpQ;
    private FrameLayout bpR;
    private com.baidu.live.im.b.b bpS;
    private com.baidu.live.im.d.a bpT;
    private c bpU;
    private FrameLayout bpV;
    private FrameLayout bpW;
    private Switch bpX;
    private EditText bpY;
    private GradientEnableTextView bpZ;
    private com.baidu.live.im.d.b bqa;
    private a.InterfaceC0239a bqb;
    private long bqc;
    private int bqd;
    private int bqe;
    private boolean bqf;
    private boolean bqg;
    private int bqh;
    private BdPageContext bqi;
    private int bqj;
    private String bqk;
    private int bql;
    private AlaLiveInfoData bqm;
    private boolean bqn;
    private View.OnClickListener bqo;
    private Handler handler;
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
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bpe == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bpf);
            }
            this.mDialog = new BdAlertDialog(this.bqi.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.10
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
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.11
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.mDialog.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.mDialog.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.mDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                this.mDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.mDialog.create(this.bqi);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OK() {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.bpY.getText().toString();
        if (obj.length() > this.bqe) {
            obj = obj.subSequence(0, this.bqe).toString();
        }
        if (!TextUtils.isEmpty(obj.trim())) {
            if (currentTimeMillis - this.bqc >= 2000) {
                this.bqc = currentTimeMillis;
                this.bqn = false;
                u(obj, false);
            } else if (!this.bqn) {
                Toast makeText = Toast.makeText(getContext(), (CharSequence) null, 0);
                makeText.setText(a.h.ala_click_too_fast);
                makeText.show();
                this.bqn = true;
            }
        }
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bqj = 0;
        this.bqn = false;
        this.handler = new Handler();
        this.bon = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqj == 3 || ALALiveTextView.this.bqj == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bqj == 3) {
                                    ALALiveTextView.this.OK();
                                } else if (ALALiveTextView.this.bqj == 4) {
                                    ALALiveTextView.this.F(ALALiveTextView.this.bqk, ALALiveTextView.this.bql);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bqj = 0;
                    }
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqo = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                    if (ALALiveTextView.this.bqg) {
                        ALALiveTextView.this.bqj = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.OK();
                } else {
                    ALALiveTextView.this.OK();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bqr;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bqr = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bqr, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bqj = 0;
        this.bqn = false;
        this.handler = new Handler();
        this.bon = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqj == 3 || ALALiveTextView.this.bqj == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bqj == 3) {
                                    ALALiveTextView.this.OK();
                                } else if (ALALiveTextView.this.bqj == 4) {
                                    ALALiveTextView.this.F(ALALiveTextView.this.bqk, ALALiveTextView.this.bql);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bqj = 0;
                    }
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqo = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                    if (ALALiveTextView.this.bqg) {
                        ALALiveTextView.this.bqj = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.OK();
                } else {
                    ALALiveTextView.this.OK();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bqr;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bqr = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bqr, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.bqi = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqj = 0;
        this.bqn = false;
        this.handler = new Handler();
        this.bon = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqj == 3 || ALALiveTextView.this.bqj == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bqj == 3) {
                                    ALALiveTextView.this.OK();
                                } else if (ALALiveTextView.this.bqj == 4) {
                                    ALALiveTextView.this.F(ALALiveTextView.this.bqk, ALALiveTextView.this.bql);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bqj = 0;
                    }
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqo = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                    if (ALALiveTextView.this.bqg) {
                        ALALiveTextView.this.bqj = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.OK();
                } else {
                    ALALiveTextView.this.OK();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bqr;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bqr = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bqr, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqj = 0;
        this.bqn = false;
        this.handler = new Handler();
        this.bon = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqj == 3 || ALALiveTextView.this.bqj == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bqj == 3) {
                                    ALALiveTextView.this.OK();
                                } else if (ALALiveTextView.this.bqj == 4) {
                                    ALALiveTextView.this.F(ALALiveTextView.this.bqk, ALALiveTextView.this.bql);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bqj = 0;
                    }
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqo = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                    if (ALALiveTextView.this.bqg) {
                        ALALiveTextView.this.bqj = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.OK();
                } else {
                    ALALiveTextView.this.OK();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bqr;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.bqr = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.bqr, i2);
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
        LayoutInflater.from(context).inflate(a.g.ala_im_input_layout, (ViewGroup) this, true);
        OL();
        OM();
        ON();
        this.bqe = 50;
    }

    private void OL() {
        this.bpX = (Switch) findViewById(a.f.switch_barrage);
        this.bpV = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        this.bpW = (FrameLayout) findViewById(a.f.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bqi);
        if (runTask != null) {
            this.bpU = (c) runTask.getData();
        }
        if (this.bpU != null) {
            this.bpV.addView(this.bpU.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bqi);
        if (runTask2 != null) {
            this.bpS = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bpS != null) {
            this.bpW.addView(this.bpS.getView());
        }
        if (this.bpU != null) {
            this.bpU.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.13
                @Override // com.baidu.live.im.b.e
                public boolean NR() {
                    return ALALiveTextView.this.bqb != null && ALALiveTextView.this.bqb.Nl();
                }

                @Override // com.baidu.live.im.b.e
                public void fd(int i) {
                    ALALiveTextView.this.OW();
                    ALALiveTextView.this.co(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Nm() {
                    if (ALALiveTextView.this.bqb != null) {
                        return ALALiveTextView.this.bqb.Nm();
                    }
                    return 0;
                }
            });
        }
        this.bpX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.cn(z);
            }
        });
    }

    private void OM() {
        this.bpY = (EditText) findViewById(a.f.edit_text);
        this.bpY.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    ALALiveTextView.this.OK();
                    return true;
                }
                return false;
            }
        });
        this.bpZ = (GradientEnableTextView) findViewById(a.f.tv_send);
        this.bpZ.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.bpY, Integer.valueOf(a.e.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.bpY, Integer.valueOf(a.e.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.bpZ.setOnClickListener(this.bqo);
        this.bpZ.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bqg = z;
        this.bqh = i;
        this.bdi = i2;
        this.mUserName = str;
    }

    private void ON() {
        this.bpQ = (FrameLayout) findViewById(a.f.quick_input_header);
        this.bpR = (FrameLayout) findViewById(a.f.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, com.baidu.live.im.d.b.class, this.bqi);
        if (runTask != null) {
            this.bqa = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.bqa != null) {
            this.bpR.addView(this.bqa.getView());
            this.bqa.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void E(String str, int i) {
                    if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                        if (ALALiveTextView.this.bqg) {
                            ALALiveTextView.this.bqk = str;
                            ALALiveTextView.this.bql = i;
                            ALALiveTextView.this.bqj = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.F(str, i);
                    } else {
                        ALALiveTextView.this.F(str, i);
                    }
                }
            });
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.bqi);
        if (runTask2 != null) {
            this.bpT = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.bpT != null) {
            this.bpQ.addView(this.bpT.getView());
            this.bpT.setCallback(new a.InterfaceC0194a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0194a
                public void E(String str, int i) {
                    if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                        if (ALALiveTextView.this.bqg) {
                            ALALiveTextView.this.bqk = str;
                            ALALiveTextView.this.bql = i;
                            ALALiveTextView.this.bqj = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.F(str, i);
                    } else {
                        ALALiveTextView.this.F(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0194a
                public void Ov() {
                    if (ALALiveTextView.this.bqb != null) {
                        ALALiveTextView.this.bqb.Nj();
                    }
                    LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, int i) {
        u(str, true);
        LogManager.getCommonLogger().doClickQuickImPanelLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("msg", str);
            jSONObject.put("status", "in");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_QUICK_CLICK).setContentExt(null, "popup", jSONObject));
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.bqf = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean OO() {
        return this.bpX != null && this.bpX.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean OP() {
        return !OT() && this.bpQ.getVisibility() == 0;
    }

    public ci getBarrageInfo() {
        if (this.bpU != null) {
            return this.bpU.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.bpY.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0239a interfaceC0239a) {
        this.bqb = interfaceC0239a;
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

    public void ij(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean OQ() {
        return getView().getVisibility() == 0 && this.bpR.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.bpR.setVisibility(0);
            if (this.bqd < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.bqa != null) {
                    this.bqa.Ox();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bpR.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.bpR.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.bpR.setVisibility(8);
        if (this.bpY != null) {
            this.bpY.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void OR() {
        if (this.bpY != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.bpY);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.bqd - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bqi = bdPageContext;
    }

    @Override // com.baidu.live.view.input.a
    public void OS() {
        this.bpY.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.bpY.getSelectionStart();
            Editable editableText = this.bpY.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.bpY.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.bqm = alaLiveInfoData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aXY = map;
        OV();
        this.bpY.requestFocus();
        if (this.bpY != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bpY.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.bpY);
                }
            }, 50L);
        }
        boolean OT = OT();
        if (list == null || list.isEmpty() || OT) {
            if (this.bpT != null) {
                this.bpT.setData(list);
            }
            this.bpR.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.bpT != null) {
            if (arrayList.size() >= 3) {
                this.bpT.setData(arrayList.subList(0, 3));
            } else {
                this.bpT.setData(arrayList);
            }
        }
        this.bpQ.setVisibility(OO() ? 8 : 0);
        this.bpR.setVisibility(0);
        if (this.bqa != null) {
            this.bqa.Ow();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bpR.getLayoutParams();
        layoutParams.height = -2;
        this.bpR.setLayoutParams(layoutParams);
        if (this.bqa != null) {
            this.bqa.setData(arrayList);
        }
        this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.bqd = ALALiveTextView.this.bpR.getHeight();
                ALALiveTextView.this.bpR.setVisibility(8);
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
        this.bpY.clearFocus();
        if (this.bpS != null) {
            this.bpS.release();
        }
        setVisibility(8);
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.bpU != null) {
            this.bpU.f(map);
        }
    }

    private boolean OT() {
        return (this.bqm == null || this.bqm.mAlaLiveSwitchData == null || !this.bqm.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean OU() {
        return (this.bqm == null || this.bqm.mAlaLiveSwitchData == null || !this.bqm.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    private void OV() {
        if (this.bqf || OU()) {
            this.bpX.setVisibility(8);
            return;
        }
        final ci[] e = d.NK().e(this.bqb != null && this.bqb.Nl(), this.bqb != null ? this.bqb.Nm() : 0);
        if (e == null || e.length <= 0) {
            if (this.bpX.isChecked()) {
                this.bpX.setChecked(false, false);
            } else {
                cn(false);
            }
            this.bpX.setVisibility(8);
            return;
        }
        this.bpX.setVisibility(0);
        if (this.bpU != null) {
            if (this.bpU.getView().getWidth() <= 0) {
                this.bpV.setVisibility(0);
            }
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.NK().NN()) {
                        ALALiveTextView.this.bpU.setData(e, ALALiveTextView.this.aXY, 0);
                        if (ALALiveTextView.this.bpX.isChecked()) {
                            ALALiveTextView.this.bpU.setSelectId(d.NK().NO());
                            ALALiveTextView.this.OW();
                            ALALiveTextView.this.co(true);
                        } else {
                            ALALiveTextView.this.bpX.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.bpX.isChecked()) {
                        ALALiveTextView.this.bpX.setChecked(false, false);
                    }
                    ALALiveTextView.this.bpV.setVisibility(ALALiveTextView.this.bpX.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.bpZ != null) {
            if (TextUtils.isEmpty(this.bpY.getText())) {
                this.bpZ.setEnabled(false);
            } else {
                this.bpZ.setEnabled(true);
                this.bpZ.setClickable(true);
            }
        }
        if (this.bpY.getText().length() > this.bqe) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bqe)));
            if (charSequence.length() > this.bqe) {
                this.bpY.setText(charSequence.subSequence(0, this.bqe));
                this.bpY.setSelection(this.bpY.getText().length());
                return;
            }
            this.bpY.setText(charSequence);
            if (i <= charSequence.length()) {
                this.bpY.setSelection(i);
            } else {
                this.bpY.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OW() {
        if (this.bpU != null) {
            ci selectInfo = this.bpU.getSelectInfo();
            if (this.bpY != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.bpY.setHint(String.format(Locale.getDefault(), getResources().getString(a.h.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.bpY.setHint(getResources().getString(a.h.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aSI == 7) {
                            this.bpY.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.bpY.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_barrage));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (z && this.bqb != null && !this.bqb.Nh()) {
            this.bpX.setChecked(false, false);
            return;
        }
        this.bqe = z ? 20 : 50;
        if (z && this.bpY != null && this.bpY.getText() != null && this.bpY.getText().length() > this.bqe) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bqe)));
        }
        if (this.bpU != null) {
            if (z) {
                this.bpU.setData(d.NK().e(this.bqb != null && this.bqb.Nl(), this.bqb != null ? this.bqb.Nm() : 0), this.aXY, 0);
                this.bpU.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.NK().NO())) {
                    this.bpU.setSelectId(d.NK().NO());
                } else {
                    this.bpU.setSelectPos(0);
                }
                if (this.bpV != null) {
                    this.bpV.setVisibility(0);
                }
                co(true);
                this.bpQ.setVisibility(8);
                OW();
                setQuickInputPanelVisible(false);
                if (this.bqi != null && this.bqi.getPageActivity() != null && this.bpY != null) {
                    BdUtilHelper.showSoftKeyPad(this.bqi.getPageActivity(), this.bpY);
                }
            } else {
                this.bpU.setSwitchStatus(false);
                if (this.bpW != null) {
                    this.bpW.setVisibility(8);
                }
                if (this.bpV != null) {
                    this.bpV.setVisibility(8);
                }
                if (!OT()) {
                    this.bpQ.setVisibility(0);
                }
                if (this.bpY != null) {
                    this.bpY.setHint(a.h.sdk_im_sendmessage_to_host);
                }
            }
            if (this.bqb != null) {
                this.bqb.Nk();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(boolean z) {
        if (z && this.bpS != null) {
            this.bpS.setPreview();
        }
        if (this.bpS != null && this.bpU != null) {
            this.bpS.setUIInfo(this.bpU.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.bpW != null) {
                this.bpW.setVisibility(8);
            }
        } else if (this.bpX != null && this.bpX.isChecked() && this.bpW != null) {
            this.bpW.setVisibility(0);
        }
    }

    private void u(String str, boolean z) {
        if (this.bqb != null) {
            this.bqb.t(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                if (this.bpW != null) {
                    this.bpW.setVisibility(8);
                }
            } else if (this.bpX != null && this.bpX.isChecked() && this.bpW != null) {
                this.bpW.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void OX() {
        if (this.bpY != null) {
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bpY.requestFocus();
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bpY != null) {
            this.bpY.addTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bpY != null) {
            this.bpY.removeTextChangedListener(this.mTextWatcher);
        }
    }
}

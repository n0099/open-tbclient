package com.baidu.live.im.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
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
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ck;
import com.baidu.live.im.b.e;
import com.baidu.live.im.d.a;
import com.baidu.live.im.d.b;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.p.d;
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
import com.kwad.sdk.core.config.item.TipsConfigItem;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ALALiveTextView extends LinearLayout implements com.baidu.live.view.input.a {
    private String aKW;
    private Map<String, Integer> aUQ;
    private int bad;
    public CustomMessageListener bdo;
    public CustomMessageListener blj;
    private FrameLayout bmM;
    private FrameLayout bmN;
    private com.baidu.live.im.b.b bmO;
    private com.baidu.live.im.d.a bmP;
    private com.baidu.live.im.b.c bmQ;
    private FrameLayout bmR;
    private FrameLayout bmS;
    private Switch bmT;
    private EditText bmU;
    private GradientEnableTextView bmV;
    private com.baidu.live.im.d.b bmW;
    private a.InterfaceC0230a bmX;
    private long bmY;
    private int bmZ;
    private int bna;
    private boolean bnb;
    private boolean bnc;
    d bnd;
    private int bne;
    private BdPageContext bnf;
    private int bng;
    private String bnh;
    private boolean bni;
    private boolean bnj;
    private int bnk;
    private AlaLiveInfoData bnl;
    private boolean bnm;
    private View.OnClickListener bnn;
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
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.blY == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.blZ);
            }
            this.mDialog = new BdAlertDialog(this.bnf.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.13
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
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
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
            this.mDialog.create(this.bnf);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ku() {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.bmU.getText().toString();
        if (obj.length() > this.bna) {
            obj = obj.subSequence(0, this.bna).toString();
        }
        if (!TextUtils.isEmpty(obj.trim())) {
            if (currentTimeMillis - this.bmY >= 2000) {
                this.bmY = currentTimeMillis;
                this.bnm = false;
                u(obj, false);
            } else if (!this.bnm) {
                Toast makeText = Toast.makeText(getContext(), (CharSequence) null, 0);
                makeText.setText(a.h.ala_click_too_fast);
                makeText.show();
                this.bnm = true;
            }
        }
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bnd = null;
        this.bng = 0;
        this.bni = false;
        this.aKW = "";
        this.bnj = false;
        this.bnm = false;
        this.handler = new Handler();
        this.blj = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bng == 3 || ALALiveTextView.this.bng == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bng == 3) {
                                    ALALiveTextView.this.Ku();
                                } else if (ALALiveTextView.this.bng == 4) {
                                    ALALiveTextView.this.H(ALALiveTextView.this.bnh, ALALiveTextView.this.bnk);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bng = 0;
                    }
                }
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bnn = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                    if (ALALiveTextView.this.bnc) {
                        ALALiveTextView.this.bng = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Ku();
                } else {
                    ALALiveTextView.this.Ku();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bns;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bns = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bns, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bnd = null;
        this.bng = 0;
        this.bni = false;
        this.aKW = "";
        this.bnj = false;
        this.bnm = false;
        this.handler = new Handler();
        this.blj = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bng == 3 || ALALiveTextView.this.bng == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bng == 3) {
                                    ALALiveTextView.this.Ku();
                                } else if (ALALiveTextView.this.bng == 4) {
                                    ALALiveTextView.this.H(ALALiveTextView.this.bnh, ALALiveTextView.this.bnk);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bng = 0;
                    }
                }
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bnn = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                    if (ALALiveTextView.this.bnc) {
                        ALALiveTextView.this.bng = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Ku();
                } else {
                    ALALiveTextView.this.Ku();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bns;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bns = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bns, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.bnf = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnd = null;
        this.bng = 0;
        this.bni = false;
        this.aKW = "";
        this.bnj = false;
        this.bnm = false;
        this.handler = new Handler();
        this.blj = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bng == 3 || ALALiveTextView.this.bng == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bng == 3) {
                                    ALALiveTextView.this.Ku();
                                } else if (ALALiveTextView.this.bng == 4) {
                                    ALALiveTextView.this.H(ALALiveTextView.this.bnh, ALALiveTextView.this.bnk);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bng = 0;
                    }
                }
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bnn = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                    if (ALALiveTextView.this.bnc) {
                        ALALiveTextView.this.bng = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Ku();
                } else {
                    ALALiveTextView.this.Ku();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bns;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bns = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bns, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnd = null;
        this.bng = 0;
        this.bni = false;
        this.aKW = "";
        this.bnj = false;
        this.bnm = false;
        this.handler = new Handler();
        this.blj = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bng == 3 || ALALiveTextView.this.bng == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bng == 3) {
                                    ALALiveTextView.this.Ku();
                                } else if (ALALiveTextView.this.bng == 4) {
                                    ALALiveTextView.this.H(ALALiveTextView.this.bnh, ALALiveTextView.this.bnk);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bng = 0;
                    }
                }
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bnn = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                    if (ALALiveTextView.this.bnc) {
                        ALALiveTextView.this.bng = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Ku();
                } else {
                    ALALiveTextView.this.Ku();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bns;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.bns = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.bns, i2);
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
        Kv();
        Kw();
        Kx();
        this.bna = 50;
    }

    private void Kv() {
        this.bmT = (Switch) findViewById(a.f.switch_barrage);
        this.bmR = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        this.bmS = (FrameLayout) findViewById(a.f.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, com.baidu.live.im.b.c.class, this.bnf);
        if (runTask != null) {
            this.bmQ = (com.baidu.live.im.b.c) runTask.getData();
        }
        if (this.bmQ != null) {
            this.bmR.addView(this.bmQ.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bnf);
        if (runTask2 != null) {
            this.bmO = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bmO != null) {
            this.bmS.addView(this.bmO.getView());
        }
        if (this.bmQ != null) {
            this.bmQ.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.16
                @Override // com.baidu.live.im.b.e
                public boolean Jy() {
                    return ALALiveTextView.this.bmX != null && ALALiveTextView.this.bmX.IO();
                }

                @Override // com.baidu.live.im.b.e
                public void dv(int i) {
                    ALALiveTextView.this.KG();
                    ALALiveTextView.this.cm(false);
                }

                @Override // com.baidu.live.im.b.e
                public int IP() {
                    if (ALALiveTextView.this.bmX != null) {
                        return ALALiveTextView.this.bmX.IP();
                    }
                    return 0;
                }
            });
        }
        this.bmT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.17
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.cl(z);
            }
        });
    }

    private void Kw() {
        this.bmU = (EditText) findViewById(a.f.edit_text);
        this.bmU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.18
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    ALALiveTextView.this.Ku();
                    return true;
                }
                return false;
            }
        });
        this.bmV = (GradientEnableTextView) findViewById(a.f.tv_send);
        this.bmV.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.bmU, Integer.valueOf(a.e.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.bmU, Integer.valueOf(a.e.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.bmV.setOnClickListener(this.bnn);
        this.bmV.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bnc = z;
        this.bne = i;
        this.bad = i2;
        this.mUserName = str;
    }

    private void Kx() {
        this.bmM = (FrameLayout) findViewById(a.f.quick_input_header);
        this.bmN = (FrameLayout) findViewById(a.f.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, com.baidu.live.im.d.b.class, this.bnf);
        if (runTask != null) {
            this.bmW = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.bmW != null) {
            this.bmN.addView(this.bmW.getView());
            this.bmW.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void G(String str, int i) {
                    if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                        if (ALALiveTextView.this.bnc) {
                            ALALiveTextView.this.bnh = str;
                            ALALiveTextView.this.bnk = i;
                            ALALiveTextView.this.bng = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.H(str, i);
                    } else {
                        ALALiveTextView.this.H(str, i);
                    }
                }
            });
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.bnf);
        if (runTask2 != null) {
            this.bmP = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.bmP != null) {
            this.bmM.addView(this.bmP.getView());
            this.bmP.setCallback(new a.InterfaceC0178a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0178a
                public void G(String str, int i) {
                    if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                        if (ALALiveTextView.this.bnc) {
                            ALALiveTextView.this.bnh = str;
                            ALALiveTextView.this.bnk = i;
                            ALALiveTextView.this.bng = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.H(str, i);
                    } else {
                        ALALiveTextView.this.H(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0178a
                public void Kg() {
                    if (ALALiveTextView.this.bmX != null) {
                        ALALiveTextView.this.bmX.IL();
                    }
                    LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, int i) {
        u(str, true);
        LogManager.getCommonLogger().doClickQuickImPanelLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("msg", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_QUICK_CLICK).setContentExt(null, UbcStatConstant.SubPage.POPUP, "in", jSONObject));
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.bnb = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ky() {
        return this.bmT != null && this.bmT.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean Kz() {
        return !KD() && this.bmM.getVisibility() == 0;
    }

    public ck getBarrageInfo() {
        if (this.bmQ != null) {
            return this.bmQ.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.bmU.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0230a interfaceC0230a) {
        this.bmX = interfaceC0230a;
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

    public void gJ(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean KA() {
        return getView().getVisibility() == 0 && this.bmN.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.bmN.setVisibility(0);
            if (this.bmZ < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.bmW != null) {
                    this.bmW.Ki();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmN.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.bmN.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.bmN.setVisibility(8);
        if (this.bmU != null) {
            this.bmU.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void KB() {
        if (this.bmU != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.bmU);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.bmZ - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bnf = bdPageContext;
    }

    @Override // com.baidu.live.view.input.a
    public void KC() {
        this.bmU.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.bmU.getSelectionStart();
            Editable editableText = this.bmU.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.bmU.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.bnl = alaLiveInfoData;
        if (this.bni) {
            this.bmM.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aUQ = map;
        KF();
        this.bmU.requestFocus();
        if (this.bmU != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bmU.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.bmU);
                }
            }, 50L);
        }
        boolean KD = KD();
        if (list == null || list.isEmpty() || KD) {
            if (this.bmP != null) {
                this.bmP.setData(list);
            }
            this.bmN.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.bmP != null) {
            if (arrayList.size() >= 3) {
                this.bmP.setData(arrayList.subList(0, 3));
            } else {
                this.bmP.setData(arrayList);
            }
        }
        this.bmM.setVisibility(Ky() ? 8 : 0);
        this.bmN.setVisibility(0);
        if (this.bmW != null) {
            this.bmW.Kh();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmN.getLayoutParams();
        layoutParams.height = -2;
        this.bmN.setLayoutParams(layoutParams);
        if (this.bmW != null) {
            this.bmW.setData(arrayList);
        }
        this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.bmZ = ALALiveTextView.this.bmN.getHeight();
                ALALiveTextView.this.bmN.setVisibility(8);
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
        this.bmU.clearFocus();
        if (this.bmO != null) {
            this.bmO.release();
        }
        setVisibility(8);
        this.bni = false;
        this.bnj = false;
    }

    @Override // com.baidu.live.view.input.a
    public void destroy() {
        if (this.bnd != null) {
            this.bnd.Ni();
            this.bnd = null;
        }
    }

    @Override // com.baidu.live.view.input.a
    public View getTextView() {
        if (this.bmU == null) {
            return null;
        }
        return this.bmU;
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.bmQ != null) {
            this.bmQ.f(map);
        }
    }

    private boolean KD() {
        return (this.bnl == null || this.bnl.mAlaLiveSwitchData == null || !this.bnl.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean KE() {
        return (this.bnl == null || this.bnl.mAlaLiveSwitchData == null || !this.bnl.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    private void KF() {
        if (this.bnb || KE()) {
            this.bmT.setVisibility(8);
            return;
        }
        final ck[] b2 = com.baidu.live.im.b.d.Jp().b(this.bmX != null && this.bmX.IO(), this.bmX != null ? this.bmX.IP() : 0, this.bmX != null ? this.bmX.IQ() : false);
        if (b2 == null || b2.length <= 0) {
            if (this.bmT.isChecked()) {
                this.bmT.setChecked(false, false);
            } else {
                cl(false);
            }
            this.bmT.setVisibility(8);
            return;
        }
        this.bmT.setVisibility(0);
        if (this.bmQ != null) {
            if (this.bmQ.getView().getWidth() <= 0) {
                this.bmR.setVisibility(0);
            }
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.live.im.b.d.Jp().Js()) {
                        ALALiveTextView.this.bmQ.setData(b2, ALALiveTextView.this.aUQ, 0);
                        if (ALALiveTextView.this.bmT.isChecked()) {
                            ALALiveTextView.this.bmQ.setSelectId(com.baidu.live.im.b.d.Jp().Jt());
                            ALALiveTextView.this.KG();
                            ALALiveTextView.this.cm(true);
                        } else {
                            ALALiveTextView.this.bmT.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.bmT.isChecked()) {
                        ALALiveTextView.this.bmT.setChecked(false, false);
                    }
                    ALALiveTextView.this.bmR.setVisibility(ALALiveTextView.this.bmT.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.bmV != null) {
            if (TextUtils.isEmpty(this.bmU.getText())) {
                this.bmV.setEnabled(false);
            } else {
                this.bmV.setEnabled(true);
                this.bmV.setClickable(true);
            }
        }
        if (this.bmU.getText().length() > this.bna) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bna)));
            if (charSequence.length() > this.bna) {
                this.bmU.setText(charSequence.subSequence(0, this.bna));
                this.bmU.setSelection(this.bmU.getText().length());
                return;
            }
            this.bmU.setText(charSequence);
            if (i <= charSequence.length()) {
                this.bmU.setSelection(i);
            } else {
                this.bmU.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        if (this.bmQ != null) {
            ck selectInfo = this.bmQ.getSelectInfo();
            if (this.bmU != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.bmU.setHint(String.format(Locale.getDefault(), getResources().getString(a.h.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.bmU.setHint(getResources().getString(a.h.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aOT == 7) {
                            this.bmU.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.bmU.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_barrage));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(boolean z) {
        if (z && this.bmX != null && !this.bmX.IJ()) {
            this.bmT.setChecked(false, false);
            return;
        }
        this.bna = z ? 20 : 50;
        if (z && this.bmU != null && this.bmU.getText() != null && this.bmU.getText().length() > this.bna) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bna)));
        }
        if (this.bmQ != null) {
            if (z) {
                this.bmQ.setData(com.baidu.live.im.b.d.Jp().b(this.bmX != null && this.bmX.IO(), this.bmX != null ? this.bmX.IP() : 0, this.bmX != null ? this.bmX.IQ() : false), this.aUQ, 0);
                this.bmQ.setSwitchStatus(true);
                if (!TextUtils.isEmpty(com.baidu.live.im.b.d.Jp().Jt())) {
                    this.bmQ.setSelectId(com.baidu.live.im.b.d.Jp().Jt());
                } else {
                    this.bmQ.setSelectPos(0);
                }
                if (this.bmR != null) {
                    this.bmR.setVisibility(0);
                }
                cm(true);
                this.bmM.setVisibility(8);
                KG();
                setQuickInputPanelVisible(false);
                if (this.bnf != null && this.bnf.getPageActivity() != null && this.bmU != null) {
                    BdUtilHelper.showSoftKeyPad(this.bnf.getPageActivity(), this.bmU);
                }
            } else {
                this.bmQ.setSwitchStatus(false);
                if (this.bmS != null) {
                    this.bmS.setVisibility(8);
                }
                if (this.bmR != null) {
                    this.bmR.setVisibility(8);
                }
                if (!KD()) {
                    this.bmM.setVisibility(0);
                }
                if (this.bmU != null) {
                    this.bmU.setHint(a.h.sdk_im_sendmessage_to_host);
                }
            }
            if (this.bmX != null) {
                this.bmX.IN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(boolean z) {
        if (z && this.bmO != null) {
            this.bmO.setPreview();
        }
        if (this.bmO != null && this.bmQ != null) {
            this.bmO.setUIInfo(this.bmQ.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.bmS != null) {
                this.bmS.setVisibility(8);
            }
        } else if (this.bmT != null && this.bmT.isChecked() && this.bmS != null) {
            this.bmS.setVisibility(0);
        }
    }

    private void u(String str, boolean z) {
        if (this.bmX != null) {
            this.bmX.t(str, z);
            if (this.bni && !z && !this.bnj) {
                if (this.bnd == null) {
                    this.bnd = new d();
                    this.bnd.setTaskId(8);
                    this.bnd.a(new d.a() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                        @Override // com.baidu.live.p.d.a
                        public void KJ() {
                            if (ALALiveTextView.this.handler != null && !TextUtils.isEmpty(ALALiveTextView.this.aKW) && ALALiveTextView.this.bnf != null && ALALiveTextView.this.bnf.getPageActivity() != null) {
                                ALALiveTextView.this.a(ALALiveTextView.this.handler, ALALiveTextView.this.bnf.getPageActivity(), ALALiveTextView.this.getContext().getString(a.h.sdk_daily_task_red_packet_finish_msg), ALALiveTextView.this.getContext().getString(a.h.sdk_daily_task_red_packet_finish_tip), ALALiveTextView.this.aKW, 5L);
                                ALALiveTextView.this.bnj = true;
                            }
                            ALALiveTextView.this.bnd.setTaskId(-1);
                        }

                        @Override // com.baidu.live.p.d.a
                        public void u(int i, String str2) {
                        }
                    });
                }
                this.bnd.dE(8);
            }
        }
    }

    public void a(final Handler handler, final Activity activity, String str, String str2, String str3, long j) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            if (j <= 0) {
                j = 3;
            }
            View inflate = LayoutInflater.from(activity).inflate(a.g.sdk_dialog_task_common, (ViewGroup) null);
            final Dialog dialog = new Dialog(activity, a.i.PlayLevelDialog);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(true);
            dialog.getWindow().getAttributes().gravity = 17;
            dialog.getWindow().setFlags(8, 8);
            ((TextView) inflate.findViewById(a.f.message_textView)).setText(str);
            ((TextView) inflate.findViewById(a.f.tip_textView)).setText(str2);
            View findViewById = inflate.findViewById(a.f.result_layout);
            final Runnable runnable = new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Activity activity2 = activity;
                        if (Build.VERSION.SDK_INT >= 17) {
                            if (!activity2.isDestroyed() && !activity2.isFinishing()) {
                                dialog.dismiss();
                            }
                        } else if (!activity2.isFinishing()) {
                            dialog.dismiss();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            handler.postDelayed(runnable, 1000 * j);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BdUtilHelper.hideSoftKeyPad(ALALiveTextView.this.bnf.getPageActivity(), ALALiveTextView.this.bmU);
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aKW)) {
                        com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                        cVar.url = ALALiveTextView.this.aKW;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                        ALALiveTextView.this.KH();
                    }
                    handler.removeCallbacks(runnable);
                    try {
                        dialog.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            dialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("task_from", TipsConfigItem.TipConfigData.TOAST);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_DAILY_TASK_BUTTON_CLICK).setContentExt(jSONObject));
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                if (this.bmS != null) {
                    this.bmS.setVisibility(8);
                }
            } else if (this.bmT != null && this.bmT.isChecked() && this.bmS != null) {
                this.bmS.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void KI() {
        if (this.bmU != null) {
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.10
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bmU.requestFocus();
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bmU != null) {
            this.bmU.addTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bmU != null) {
            this.bmU.removeTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // com.baidu.live.view.input.a
    public void setFromDailyTask(boolean z, String str) {
        this.bni = z;
        this.aKW = str;
    }
}

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
import com.baidu.live.data.cr;
import com.baidu.live.im.b.e;
import com.baidu.live.im.d.a;
import com.baidu.live.im.d.b;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.o.d;
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
    private String aPs;
    private Map<String, Integer> aZy;
    private int beM;
    public CustomMessageListener bhY;
    public CustomMessageListener bqe;
    private FrameLayout brN;
    private FrameLayout brO;
    private com.baidu.live.im.b.b brP;
    private com.baidu.live.im.d.a brQ;
    private com.baidu.live.im.b.c brR;
    private FrameLayout brS;
    private FrameLayout brT;
    private Switch brU;
    private EditText brV;
    private GradientEnableTextView brW;
    private com.baidu.live.im.d.b brX;
    private a.InterfaceC0238a brY;
    private long brZ;
    private int bsa;
    private int bsb;
    private boolean bsc;
    private boolean bsd;
    d bse;
    private int bsf;
    private BdPageContext bsg;
    private int bsh;
    private String bsi;
    private boolean bsj;
    private boolean bsk;
    private int bsl;
    private AlaLiveInfoData bsm;
    private boolean bsn;
    private View.OnClickListener bso;
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
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bqT == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bqU);
            }
            this.mDialog = new BdAlertDialog(this.bsg.getPageActivity());
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
            this.mDialog.create(this.bsg);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LV() {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.brV.getText().toString();
        if (obj.length() > this.bsb) {
            obj = obj.subSequence(0, this.bsb).toString();
        }
        if (!TextUtils.isEmpty(obj.trim())) {
            if (currentTimeMillis - this.brZ >= 2000) {
                this.brZ = currentTimeMillis;
                this.bsn = false;
                u(obj, false);
            } else if (!this.bsn) {
                Toast makeText = Toast.makeText(getContext(), (CharSequence) null, 0);
                makeText.setText(a.h.ala_click_too_fast);
                makeText.show();
                this.bsn = true;
            }
        }
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bse = null;
        this.bsh = 0;
        this.bsj = false;
        this.aPs = "";
        this.bsk = false;
        this.bsn = false;
        this.handler = new Handler();
        this.bqe = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bsh == 3 || ALALiveTextView.this.bsh == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bsh == 3) {
                                    ALALiveTextView.this.LV();
                                } else if (ALALiveTextView.this.bsh == 4) {
                                    ALALiveTextView.this.I(ALALiveTextView.this.bsi, ALALiveTextView.this.bsl);
                                }
                            } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                                ALALiveTextView.this.a(imForbiddenStateData);
                                imForbiddenStateData.hasShowForbiddenToast = true;
                            }
                        }
                        ALALiveTextView.this.bsh = 0;
                    }
                }
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bso = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                    if (ALALiveTextView.this.bsd) {
                        ALALiveTextView.this.bsh = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.LV();
                } else {
                    ALALiveTextView.this.LV();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bst;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bst = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bst, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bse = null;
        this.bsh = 0;
        this.bsj = false;
        this.aPs = "";
        this.bsk = false;
        this.bsn = false;
        this.handler = new Handler();
        this.bqe = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bsh == 3 || ALALiveTextView.this.bsh == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bsh == 3) {
                                    ALALiveTextView.this.LV();
                                } else if (ALALiveTextView.this.bsh == 4) {
                                    ALALiveTextView.this.I(ALALiveTextView.this.bsi, ALALiveTextView.this.bsl);
                                }
                            } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                                ALALiveTextView.this.a(imForbiddenStateData);
                                imForbiddenStateData.hasShowForbiddenToast = true;
                            }
                        }
                        ALALiveTextView.this.bsh = 0;
                    }
                }
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bso = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                    if (ALALiveTextView.this.bsd) {
                        ALALiveTextView.this.bsh = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.LV();
                } else {
                    ALALiveTextView.this.LV();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bst;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bst = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bst, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.bsg = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bse = null;
        this.bsh = 0;
        this.bsj = false;
        this.aPs = "";
        this.bsk = false;
        this.bsn = false;
        this.handler = new Handler();
        this.bqe = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bsh == 3 || ALALiveTextView.this.bsh == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bsh == 3) {
                                    ALALiveTextView.this.LV();
                                } else if (ALALiveTextView.this.bsh == 4) {
                                    ALALiveTextView.this.I(ALALiveTextView.this.bsi, ALALiveTextView.this.bsl);
                                }
                            } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                                ALALiveTextView.this.a(imForbiddenStateData);
                                imForbiddenStateData.hasShowForbiddenToast = true;
                            }
                        }
                        ALALiveTextView.this.bsh = 0;
                    }
                }
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bso = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                    if (ALALiveTextView.this.bsd) {
                        ALALiveTextView.this.bsh = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.LV();
                } else {
                    ALALiveTextView.this.LV();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bst;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bst = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bst, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bse = null;
        this.bsh = 0;
        this.bsj = false;
        this.aPs = "";
        this.bsk = false;
        this.bsn = false;
        this.handler = new Handler();
        this.bqe = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bsh == 3 || ALALiveTextView.this.bsh == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bsh == 3) {
                                    ALALiveTextView.this.LV();
                                } else if (ALALiveTextView.this.bsh == 4) {
                                    ALALiveTextView.this.I(ALALiveTextView.this.bsi, ALALiveTextView.this.bsl);
                                }
                            } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                                ALALiveTextView.this.a(imForbiddenStateData);
                                imForbiddenStateData.hasShowForbiddenToast = true;
                            }
                        }
                        ALALiveTextView.this.bsh = 0;
                    }
                }
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bso = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                    if (ALALiveTextView.this.bsd) {
                        ALALiveTextView.this.bsh = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.LV();
                } else {
                    ALALiveTextView.this.LV();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bst;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.bst = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.bst, i2);
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
        LW();
        LX();
        LY();
        this.bsb = 50;
    }

    private void LW() {
        this.brU = (Switch) findViewById(a.f.switch_barrage);
        this.brS = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        this.brT = (FrameLayout) findViewById(a.f.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, com.baidu.live.im.b.c.class, this.bsg);
        if (runTask != null) {
            this.brR = (com.baidu.live.im.b.c) runTask.getData();
        }
        if (this.brR != null) {
            this.brS.addView(this.brR.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bsg);
        if (runTask2 != null) {
            this.brP = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.brP != null) {
            this.brT.addView(this.brP.getView());
        }
        if (this.brR != null) {
            this.brR.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.16
                @Override // com.baidu.live.im.b.e
                public boolean KZ() {
                    return ALALiveTextView.this.brY != null && ALALiveTextView.this.brY.Kp();
                }

                @Override // com.baidu.live.im.b.e
                public void dC(int i) {
                    ALALiveTextView.this.Mh();
                    ALALiveTextView.this.cv(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Kq() {
                    if (ALALiveTextView.this.brY != null) {
                        return ALALiveTextView.this.brY.Kq();
                    }
                    return 0;
                }
            });
        }
        this.brU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.17
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.cu(z);
            }
        });
    }

    private void LX() {
        this.brV = (EditText) findViewById(a.f.edit_text);
        this.brV.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.18
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    ALALiveTextView.this.LV();
                    return true;
                }
                return false;
            }
        });
        this.brW = (GradientEnableTextView) findViewById(a.f.tv_send);
        this.brW.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.brV, Integer.valueOf(a.e.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.brV, Integer.valueOf(a.e.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.brW.setOnClickListener(this.bso);
        this.brW.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bsd = z;
        this.bsf = i;
        this.beM = i2;
        this.mUserName = str;
    }

    private void LY() {
        this.brN = (FrameLayout) findViewById(a.f.quick_input_header);
        this.brO = (FrameLayout) findViewById(a.f.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, com.baidu.live.im.d.b.class, this.bsg);
        if (runTask != null) {
            this.brX = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.brX != null) {
            this.brO.addView(this.brX.getView());
            this.brX.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void H(String str, int i) {
                    if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                        if (ALALiveTextView.this.bsd) {
                            ALALiveTextView.this.bsi = str;
                            ALALiveTextView.this.bsl = i;
                            ALALiveTextView.this.bsh = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.I(str, i);
                    } else {
                        ALALiveTextView.this.I(str, i);
                    }
                }
            });
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.bsg);
        if (runTask2 != null) {
            this.brQ = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.brQ != null) {
            this.brN.addView(this.brQ.getView());
            this.brQ.setCallback(new a.InterfaceC0186a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0186a
                public void H(String str, int i) {
                    if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                        if (ALALiveTextView.this.bsd) {
                            ALALiveTextView.this.bsi = str;
                            ALALiveTextView.this.bsl = i;
                            ALALiveTextView.this.bsh = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.I(str, i);
                    } else {
                        ALALiveTextView.this.I(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0186a
                public void LI() {
                    if (ALALiveTextView.this.brY != null) {
                        ALALiveTextView.this.brY.Km();
                    }
                    LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, int i) {
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
        this.bsc = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean LZ() {
        return this.brU != null && this.brU.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ma() {
        return !Me() && this.brN.getVisibility() == 0;
    }

    public cr getBarrageInfo() {
        if (this.brR != null) {
            return this.brR.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.brV.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0238a interfaceC0238a) {
        this.brY = interfaceC0238a;
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

    public void ho(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Mb() {
        return getView().getVisibility() == 0 && this.brO.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.brO.setVisibility(0);
            if (this.bsa < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.brX != null) {
                    this.brX.LK();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brO.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.brO.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.brO.setVisibility(8);
        if (this.brV != null) {
            this.brV.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Mc() {
        if (this.brV != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.brV);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.bsa - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bsg = bdPageContext;
    }

    @Override // com.baidu.live.view.input.a
    public void Md() {
        this.brV.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.brV.getSelectionStart();
            Editable editableText = this.brV.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.brV.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.bsm = alaLiveInfoData;
        if (this.bsj) {
            this.brN.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aZy = map;
        Mg();
        this.brV.requestFocus();
        if (this.brV != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.brV.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.brV);
                }
            }, 50L);
        }
        boolean Me = Me();
        if (list == null || list.isEmpty() || Me) {
            if (this.brQ != null) {
                this.brQ.setData(list);
            }
            this.brO.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.brQ != null) {
            if (arrayList.size() >= 3) {
                this.brQ.setData(arrayList.subList(0, 3));
            } else {
                this.brQ.setData(arrayList);
            }
        }
        this.brN.setVisibility(LZ() ? 8 : 0);
        this.brO.setVisibility(0);
        if (this.brX != null) {
            this.brX.LJ();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brO.getLayoutParams();
        layoutParams.height = -2;
        this.brO.setLayoutParams(layoutParams);
        if (this.brX != null) {
            this.brX.setData(arrayList);
        }
        this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.bsa = ALALiveTextView.this.brO.getHeight();
                ALALiveTextView.this.brO.setVisibility(8);
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
        this.brV.clearFocus();
        if (this.brP != null) {
            this.brP.release();
        }
        setVisibility(8);
        this.bsj = false;
        this.bsk = false;
    }

    @Override // com.baidu.live.view.input.a
    public void destroy() {
        if (this.bse != null) {
            this.bse.OK();
            this.bse = null;
        }
    }

    @Override // com.baidu.live.view.input.a
    public View getTextView() {
        if (this.brV == null) {
            return null;
        }
        return this.brV;
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.brR != null) {
            this.brR.f(map);
        }
    }

    private boolean Me() {
        return (this.bsm == null || this.bsm.mAlaLiveSwitchData == null || !this.bsm.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean Mf() {
        return (this.bsm == null || this.bsm.mAlaLiveSwitchData == null || !this.bsm.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    private void Mg() {
        if (this.bsc || Mf()) {
            this.brU.setVisibility(8);
            return;
        }
        final cr[] a2 = com.baidu.live.im.b.d.KQ().a(this.brY != null && this.brY.Kp(), this.brY != null ? this.brY.Kq() : 0, this.brY != null ? this.brY.Kr() : false);
        if (a2 == null || a2.length <= 0) {
            if (this.brU.isChecked()) {
                this.brU.setChecked(false, false);
            } else {
                cu(false);
            }
            this.brU.setVisibility(8);
            return;
        }
        this.brU.setVisibility(0);
        if (this.brR != null) {
            if (this.brR.getView().getWidth() <= 0) {
                this.brS.setVisibility(0);
            }
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.live.im.b.d.KQ().KT()) {
                        ALALiveTextView.this.brR.setData(a2, ALALiveTextView.this.aZy, 0);
                        if (ALALiveTextView.this.brU.isChecked()) {
                            ALALiveTextView.this.brR.setSelectId(com.baidu.live.im.b.d.KQ().KU());
                            ALALiveTextView.this.Mh();
                            ALALiveTextView.this.cv(true);
                        } else {
                            ALALiveTextView.this.brU.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.brU.isChecked()) {
                        ALALiveTextView.this.brU.setChecked(false, false);
                    }
                    ALALiveTextView.this.brS.setVisibility(ALALiveTextView.this.brU.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.brW != null) {
            if (TextUtils.isEmpty(this.brV.getText())) {
                this.brW.setEnabled(false);
            } else {
                this.brW.setEnabled(true);
                this.brW.setClickable(true);
            }
        }
        if (this.brV.getText().length() > this.bsb) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bsb)));
            if (charSequence.length() > this.bsb) {
                this.brV.setText(charSequence.subSequence(0, this.bsb));
                this.brV.setSelection(this.brV.getText().length());
                return;
            }
            this.brV.setText(charSequence);
            if (i <= charSequence.length()) {
                this.brV.setSelection(i);
            } else {
                this.brV.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh() {
        if (this.brR != null) {
            cr selectInfo = this.brR.getSelectInfo();
            if (this.brV != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.brV.setHint(String.format(Locale.getDefault(), getResources().getString(a.h.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.brV.setHint(getResources().getString(a.h.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aTv == 7) {
                            this.brV.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.brV.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_barrage));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(boolean z) {
        if (z && this.brY != null && !this.brY.Kk()) {
            this.brU.setChecked(false, false);
            return;
        }
        this.bsb = z ? 20 : 50;
        if (z && this.brV != null && this.brV.getText() != null && this.brV.getText().length() > this.bsb) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bsb)));
        }
        if (this.brR != null) {
            if (z) {
                this.brR.setData(com.baidu.live.im.b.d.KQ().a(this.brY != null && this.brY.Kp(), this.brY != null ? this.brY.Kq() : 0, this.brY != null ? this.brY.Kr() : false), this.aZy, 0);
                this.brR.setSwitchStatus(true);
                if (!TextUtils.isEmpty(com.baidu.live.im.b.d.KQ().KU())) {
                    this.brR.setSelectId(com.baidu.live.im.b.d.KQ().KU());
                } else {
                    this.brR.setSelectPos(0);
                }
                if (this.brS != null) {
                    this.brS.setVisibility(0);
                }
                cv(true);
                this.brN.setVisibility(8);
                Mh();
                setQuickInputPanelVisible(false);
                if (this.bsg != null && this.bsg.getPageActivity() != null && this.brV != null) {
                    BdUtilHelper.showSoftKeyPad(this.bsg.getPageActivity(), this.brV);
                }
            } else {
                this.brR.setSwitchStatus(false);
                if (this.brT != null) {
                    this.brT.setVisibility(8);
                }
                if (this.brS != null) {
                    this.brS.setVisibility(8);
                }
                if (!Me()) {
                    this.brN.setVisibility(0);
                }
                if (this.brV != null) {
                    this.brV.setHint(a.h.sdk_im_sendmessage_to_host);
                }
            }
            if (this.brY != null) {
                this.brY.Ko();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(boolean z) {
        if (z && this.brP != null) {
            this.brP.setPreview();
        }
        if (this.brP != null && this.brR != null) {
            this.brP.setUIInfo(this.brR.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.brT != null) {
                this.brT.setVisibility(8);
            }
        } else if (this.brU != null && this.brU.isChecked() && this.brT != null) {
            this.brT.setVisibility(0);
        }
    }

    private void u(String str, boolean z) {
        if (this.brY != null) {
            this.brY.t(str, z);
            if (this.bsj && !z && !this.bsk) {
                if (this.bse == null) {
                    this.bse = new d();
                    this.bse.setTaskId(8);
                    this.bse.a(new d.b() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                        @Override // com.baidu.live.o.d.b
                        public void Mk() {
                            if (ALALiveTextView.this.handler != null && !TextUtils.isEmpty(ALALiveTextView.this.aPs) && ALALiveTextView.this.bsg != null && ALALiveTextView.this.bsg.getPageActivity() != null) {
                                ALALiveTextView.this.a(ALALiveTextView.this.handler, ALALiveTextView.this.bsg.getPageActivity(), ALALiveTextView.this.getContext().getString(a.h.sdk_daily_task_red_packet_finish_msg), ALALiveTextView.this.getContext().getString(a.h.sdk_daily_task_red_packet_finish_tip), ALALiveTextView.this.aPs, 5L);
                                ALALiveTextView.this.bsk = true;
                            }
                            ALALiveTextView.this.bse.setTaskId(-1);
                        }

                        @Override // com.baidu.live.o.d.b
                        public void x(int i, String str2) {
                        }
                    });
                }
                this.bse.dL(8);
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
                    BdUtilHelper.hideSoftKeyPad(ALALiveTextView.this.bsg.getPageActivity(), ALALiveTextView.this.brV);
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aPs)) {
                        com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                        cVar.url = ALALiveTextView.this.aPs;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                        ALALiveTextView.this.Mi();
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
    public void Mi() {
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
                if (this.brT != null) {
                    this.brT.setVisibility(8);
                }
            } else if (this.brU != null && this.brU.isChecked() && this.brT != null) {
                this.brT.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Mj() {
        if (this.brV != null) {
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.10
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.brV.requestFocus();
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.brV != null) {
            this.brV.addTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.brV != null) {
            this.brV.removeTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // com.baidu.live.view.input.a
    public void setFromDailyTask(boolean z, String str) {
        this.bsj = z;
        this.aPs = str;
    }
}

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
/* loaded from: classes11.dex */
public class ALALiveTextView extends LinearLayout implements com.baidu.live.view.input.a {
    private String aPJ;
    private Map<String, Integer> aZD;
    private int beT;
    public CustomMessageListener bih;
    public CustomMessageListener bpW;
    private com.baidu.live.im.b.b brA;
    private com.baidu.live.im.d.a brB;
    private com.baidu.live.im.b.c brC;
    private FrameLayout brD;
    private FrameLayout brE;
    private Switch brF;
    private EditText brG;
    private GradientEnableTextView brH;
    private com.baidu.live.im.d.b brI;
    private a.InterfaceC0239a brJ;
    private long brK;
    private int brL;
    private int brM;
    private boolean brN;
    private boolean brO;
    d brP;
    private int brQ;
    private BdPageContext brR;
    private int brS;
    private String brT;
    private boolean brU;
    private boolean brV;
    private int brW;
    private AlaLiveInfoData brX;
    private boolean brY;
    private View.OnClickListener brZ;
    private FrameLayout bry;
    private FrameLayout brz;
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
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bqL == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bqM);
            }
            this.mDialog = new BdAlertDialog(this.brR.getPageActivity());
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
            this.mDialog.create(this.brR);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Op() {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.brG.getText().toString();
        if (obj.length() > this.brM) {
            obj = obj.subSequence(0, this.brM).toString();
        }
        if (!TextUtils.isEmpty(obj.trim())) {
            if (currentTimeMillis - this.brK >= 2000) {
                this.brK = currentTimeMillis;
                this.brY = false;
                u(obj, false);
            } else if (!this.brY) {
                Toast makeText = Toast.makeText(getContext(), (CharSequence) null, 0);
                makeText.setText(a.h.ala_click_too_fast);
                makeText.show();
                this.brY = true;
            }
        }
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.brP = null;
        this.brS = 0;
        this.brU = false;
        this.aPJ = "";
        this.brV = false;
        this.brY = false;
        this.handler = new Handler();
        this.bpW = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.brS == 3 || ALALiveTextView.this.brS == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.brS == 3) {
                                    ALALiveTextView.this.Op();
                                } else if (ALALiveTextView.this.brS == 4) {
                                    ALALiveTextView.this.H(ALALiveTextView.this.brT, ALALiveTextView.this.brW);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.brS = 0;
                    }
                }
            }
        };
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.brZ = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                    if (ALALiveTextView.this.brO) {
                        ALALiveTextView.this.brS = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Op();
                } else {
                    ALALiveTextView.this.Op();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bse;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bse = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bse, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.brP = null;
        this.brS = 0;
        this.brU = false;
        this.aPJ = "";
        this.brV = false;
        this.brY = false;
        this.handler = new Handler();
        this.bpW = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.brS == 3 || ALALiveTextView.this.brS == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.brS == 3) {
                                    ALALiveTextView.this.Op();
                                } else if (ALALiveTextView.this.brS == 4) {
                                    ALALiveTextView.this.H(ALALiveTextView.this.brT, ALALiveTextView.this.brW);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.brS = 0;
                    }
                }
            }
        };
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.brZ = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                    if (ALALiveTextView.this.brO) {
                        ALALiveTextView.this.brS = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Op();
                } else {
                    ALALiveTextView.this.Op();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bse;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bse = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bse, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.brR = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.brP = null;
        this.brS = 0;
        this.brU = false;
        this.aPJ = "";
        this.brV = false;
        this.brY = false;
        this.handler = new Handler();
        this.bpW = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.brS == 3 || ALALiveTextView.this.brS == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.brS == 3) {
                                    ALALiveTextView.this.Op();
                                } else if (ALALiveTextView.this.brS == 4) {
                                    ALALiveTextView.this.H(ALALiveTextView.this.brT, ALALiveTextView.this.brW);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.brS = 0;
                    }
                }
            }
        };
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.brZ = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                    if (ALALiveTextView.this.brO) {
                        ALALiveTextView.this.brS = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Op();
                } else {
                    ALALiveTextView.this.Op();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bse;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bse = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bse, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.brP = null;
        this.brS = 0;
        this.brU = false;
        this.aPJ = "";
        this.brV = false;
        this.brY = false;
        this.handler = new Handler();
        this.bpW = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.brS == 3 || ALALiveTextView.this.brS == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.brS == 3) {
                                    ALALiveTextView.this.Op();
                                } else if (ALALiveTextView.this.brS == 4) {
                                    ALALiveTextView.this.H(ALALiveTextView.this.brT, ALALiveTextView.this.brW);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.brS = 0;
                    }
                }
            }
        };
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.brZ = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                    if (ALALiveTextView.this.brO) {
                        ALALiveTextView.this.brS = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Op();
                } else {
                    ALALiveTextView.this.Op();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bse;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.bse = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.bse, i2);
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
        Oq();
        Or();
        Os();
        this.brM = 50;
    }

    private void Oq() {
        this.brF = (Switch) findViewById(a.f.switch_barrage);
        this.brD = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        this.brE = (FrameLayout) findViewById(a.f.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, com.baidu.live.im.b.c.class, this.brR);
        if (runTask != null) {
            this.brC = (com.baidu.live.im.b.c) runTask.getData();
        }
        if (this.brC != null) {
            this.brD.addView(this.brC.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.brR);
        if (runTask2 != null) {
            this.brA = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.brA != null) {
            this.brE.addView(this.brA.getView());
        }
        if (this.brC != null) {
            this.brC.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.16
                @Override // com.baidu.live.im.b.e
                public boolean Nt() {
                    return ALALiveTextView.this.brJ != null && ALALiveTextView.this.brJ.MJ();
                }

                @Override // com.baidu.live.im.b.e
                public void fb(int i) {
                    ALALiveTextView.this.OB();
                    ALALiveTextView.this.cq(false);
                }

                @Override // com.baidu.live.im.b.e
                public int MK() {
                    if (ALALiveTextView.this.brJ != null) {
                        return ALALiveTextView.this.brJ.MK();
                    }
                    return 0;
                }
            });
        }
        this.brF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.17
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.cp(z);
            }
        });
    }

    private void Or() {
        this.brG = (EditText) findViewById(a.f.edit_text);
        this.brG.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.18
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    ALALiveTextView.this.Op();
                    return true;
                }
                return false;
            }
        });
        this.brH = (GradientEnableTextView) findViewById(a.f.tv_send);
        this.brH.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.brG, Integer.valueOf(a.e.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.brG, Integer.valueOf(a.e.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.brH.setOnClickListener(this.brZ);
        this.brH.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.brO = z;
        this.brQ = i;
        this.beT = i2;
        this.mUserName = str;
    }

    private void Os() {
        this.bry = (FrameLayout) findViewById(a.f.quick_input_header);
        this.brz = (FrameLayout) findViewById(a.f.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, com.baidu.live.im.d.b.class, this.brR);
        if (runTask != null) {
            this.brI = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.brI != null) {
            this.brz.addView(this.brI.getView());
            this.brI.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void G(String str, int i) {
                    if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                        if (ALALiveTextView.this.brO) {
                            ALALiveTextView.this.brT = str;
                            ALALiveTextView.this.brW = i;
                            ALALiveTextView.this.brS = 4;
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
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.brR);
        if (runTask2 != null) {
            this.brB = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.brB != null) {
            this.bry.addView(this.brB.getView());
            this.brB.setCallback(new a.InterfaceC0187a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0187a
                public void G(String str, int i) {
                    if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                        if (ALALiveTextView.this.brO) {
                            ALALiveTextView.this.brT = str;
                            ALALiveTextView.this.brW = i;
                            ALALiveTextView.this.brS = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.H(str, i);
                    } else {
                        ALALiveTextView.this.H(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0187a
                public void Ob() {
                    if (ALALiveTextView.this.brJ != null) {
                        ALALiveTextView.this.brJ.MG();
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
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_QUICK_CLICK).setContentExt(null, "popup", "in", jSONObject));
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.brN = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ot() {
        return this.brF != null && this.brF.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ou() {
        return !Oy() && this.bry.getVisibility() == 0;
    }

    public ck getBarrageInfo() {
        if (this.brC != null) {
            return this.brC.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.brG.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0239a interfaceC0239a) {
        this.brJ = interfaceC0239a;
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

    public void hU(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ov() {
        return getView().getVisibility() == 0 && this.brz.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.brz.setVisibility(0);
            if (this.brL < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.brI != null) {
                    this.brI.Od();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brz.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.brz.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.brz.setVisibility(8);
        if (this.brG != null) {
            this.brG.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Ow() {
        if (this.brG != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.brG);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.brL - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.brR = bdPageContext;
    }

    @Override // com.baidu.live.view.input.a
    public void Ox() {
        this.brG.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.brG.getSelectionStart();
            Editable editableText = this.brG.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.brG.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.brX = alaLiveInfoData;
        if (this.brU) {
            this.bry.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aZD = map;
        OA();
        this.brG.requestFocus();
        if (this.brG != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.brG.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.brG);
                }
            }, 50L);
        }
        boolean Oy = Oy();
        if (list == null || list.isEmpty() || Oy) {
            if (this.brB != null) {
                this.brB.setData(list);
            }
            this.brz.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.brB != null) {
            if (arrayList.size() >= 3) {
                this.brB.setData(arrayList.subList(0, 3));
            } else {
                this.brB.setData(arrayList);
            }
        }
        this.bry.setVisibility(Ot() ? 8 : 0);
        this.brz.setVisibility(0);
        if (this.brI != null) {
            this.brI.Oc();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brz.getLayoutParams();
        layoutParams.height = -2;
        this.brz.setLayoutParams(layoutParams);
        if (this.brI != null) {
            this.brI.setData(arrayList);
        }
        this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.brL = ALALiveTextView.this.brz.getHeight();
                ALALiveTextView.this.brz.setVisibility(8);
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
        this.brG.clearFocus();
        if (this.brA != null) {
            this.brA.release();
        }
        setVisibility(8);
        this.brU = false;
        this.brV = false;
    }

    @Override // com.baidu.live.view.input.a
    public void destroy() {
        if (this.brP != null) {
            this.brP.Rd();
            this.brP = null;
        }
    }

    @Override // com.baidu.live.view.input.a
    public View getTextView() {
        if (this.brG == null) {
            return null;
        }
        return this.brG;
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.brC != null) {
            this.brC.f(map);
        }
    }

    private boolean Oy() {
        return (this.brX == null || this.brX.mAlaLiveSwitchData == null || !this.brX.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean Oz() {
        return (this.brX == null || this.brX.mAlaLiveSwitchData == null || !this.brX.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    private void OA() {
        if (this.brN || Oz()) {
            this.brF.setVisibility(8);
            return;
        }
        final ck[] b2 = com.baidu.live.im.b.d.Nk().b(this.brJ != null && this.brJ.MJ(), this.brJ != null ? this.brJ.MK() : 0, this.brJ != null ? this.brJ.ML() : false);
        if (b2 == null || b2.length <= 0) {
            if (this.brF.isChecked()) {
                this.brF.setChecked(false, false);
            } else {
                cp(false);
            }
            this.brF.setVisibility(8);
            return;
        }
        this.brF.setVisibility(0);
        if (this.brC != null) {
            if (this.brC.getView().getWidth() <= 0) {
                this.brD.setVisibility(0);
            }
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.live.im.b.d.Nk().Nn()) {
                        ALALiveTextView.this.brC.setData(b2, ALALiveTextView.this.aZD, 0);
                        if (ALALiveTextView.this.brF.isChecked()) {
                            ALALiveTextView.this.brC.setSelectId(com.baidu.live.im.b.d.Nk().No());
                            ALALiveTextView.this.OB();
                            ALALiveTextView.this.cq(true);
                        } else {
                            ALALiveTextView.this.brF.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.brF.isChecked()) {
                        ALALiveTextView.this.brF.setChecked(false, false);
                    }
                    ALALiveTextView.this.brD.setVisibility(ALALiveTextView.this.brF.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.brH != null) {
            if (TextUtils.isEmpty(this.brG.getText())) {
                this.brH.setEnabled(false);
            } else {
                this.brH.setEnabled(true);
                this.brH.setClickable(true);
            }
        }
        if (this.brG.getText().length() > this.brM) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.brM)));
            if (charSequence.length() > this.brM) {
                this.brG.setText(charSequence.subSequence(0, this.brM));
                this.brG.setSelection(this.brG.getText().length());
                return;
            }
            this.brG.setText(charSequence);
            if (i <= charSequence.length()) {
                this.brG.setSelection(i);
            } else {
                this.brG.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OB() {
        if (this.brC != null) {
            ck selectInfo = this.brC.getSelectInfo();
            if (this.brG != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.brG.setHint(String.format(Locale.getDefault(), getResources().getString(a.h.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.brG.setHint(getResources().getString(a.h.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aTG == 7) {
                            this.brG.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.brG.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_barrage));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(boolean z) {
        if (z && this.brJ != null && !this.brJ.ME()) {
            this.brF.setChecked(false, false);
            return;
        }
        this.brM = z ? 20 : 50;
        if (z && this.brG != null && this.brG.getText() != null && this.brG.getText().length() > this.brM) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.brM)));
        }
        if (this.brC != null) {
            if (z) {
                this.brC.setData(com.baidu.live.im.b.d.Nk().b(this.brJ != null && this.brJ.MJ(), this.brJ != null ? this.brJ.MK() : 0, this.brJ != null ? this.brJ.ML() : false), this.aZD, 0);
                this.brC.setSwitchStatus(true);
                if (!TextUtils.isEmpty(com.baidu.live.im.b.d.Nk().No())) {
                    this.brC.setSelectId(com.baidu.live.im.b.d.Nk().No());
                } else {
                    this.brC.setSelectPos(0);
                }
                if (this.brD != null) {
                    this.brD.setVisibility(0);
                }
                cq(true);
                this.bry.setVisibility(8);
                OB();
                setQuickInputPanelVisible(false);
                if (this.brR != null && this.brR.getPageActivity() != null && this.brG != null) {
                    BdUtilHelper.showSoftKeyPad(this.brR.getPageActivity(), this.brG);
                }
            } else {
                this.brC.setSwitchStatus(false);
                if (this.brE != null) {
                    this.brE.setVisibility(8);
                }
                if (this.brD != null) {
                    this.brD.setVisibility(8);
                }
                if (!Oy()) {
                    this.bry.setVisibility(0);
                }
                if (this.brG != null) {
                    this.brG.setHint(a.h.sdk_im_sendmessage_to_host);
                }
            }
            if (this.brJ != null) {
                this.brJ.MI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(boolean z) {
        if (z && this.brA != null) {
            this.brA.setPreview();
        }
        if (this.brA != null && this.brC != null) {
            this.brA.setUIInfo(this.brC.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.brE != null) {
                this.brE.setVisibility(8);
            }
        } else if (this.brF != null && this.brF.isChecked() && this.brE != null) {
            this.brE.setVisibility(0);
        }
    }

    private void u(String str, boolean z) {
        if (this.brJ != null) {
            this.brJ.t(str, z);
            if (this.brU && !z && !this.brV) {
                if (this.brP == null) {
                    this.brP = new d();
                    this.brP.setTaskId(8);
                    this.brP.a(new d.a() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                        @Override // com.baidu.live.p.d.a
                        public void OE() {
                            if (ALALiveTextView.this.handler != null && !TextUtils.isEmpty(ALALiveTextView.this.aPJ) && ALALiveTextView.this.brR != null && ALALiveTextView.this.brR.getPageActivity() != null) {
                                ALALiveTextView.this.a(ALALiveTextView.this.handler, ALALiveTextView.this.brR.getPageActivity(), ALALiveTextView.this.getContext().getString(a.h.sdk_daily_task_red_packet_finish_msg), ALALiveTextView.this.getContext().getString(a.h.sdk_daily_task_red_packet_finish_tip), ALALiveTextView.this.aPJ, 5L);
                                ALALiveTextView.this.brV = true;
                            }
                            ALALiveTextView.this.brP.setTaskId(-1);
                        }

                        @Override // com.baidu.live.p.d.a
                        public void t(int i, String str2) {
                        }
                    });
                }
                this.brP.fk(8);
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
                    BdUtilHelper.hideSoftKeyPad(ALALiveTextView.this.brR.getPageActivity(), ALALiveTextView.this.brG);
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aPJ)) {
                        com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
                        cVar.url = ALALiveTextView.this.aPJ;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                        ALALiveTextView.this.OC();
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
    public void OC() {
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
                if (this.brE != null) {
                    this.brE.setVisibility(8);
                }
            } else if (this.brF != null && this.brF.isChecked() && this.brE != null) {
                this.brE.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void OD() {
        if (this.brG != null) {
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.10
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.brG.requestFocus();
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.brG != null) {
            this.brG.addTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.brG != null) {
            this.brG.removeTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // com.baidu.live.view.input.a
    public void setFromDailyTask(boolean z, String str) {
        this.brU = z;
        this.aPJ = str;
    }
}

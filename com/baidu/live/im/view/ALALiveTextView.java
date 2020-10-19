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
import com.baidu.live.data.bz;
import com.baidu.live.im.b.b;
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
import com.baidu.live.tieba.view.GradientEnableTextView;
import com.baidu.live.view.Switch;
import com.baidu.live.view.input.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes4.dex */
public class ALALiveTextView extends LinearLayout implements com.baidu.live.view.input.a {
    private Map<String, Integer> aUa;
    private int aYE;
    public CustomMessageListener bbC;
    private FrameLayout bjD;
    private FrameLayout bjE;
    private b bjF;
    private com.baidu.live.im.d.a bjG;
    private c bjH;
    private FrameLayout bjI;
    private FrameLayout bjJ;
    private Switch bjK;
    private EditText bjL;
    private GradientEnableTextView bjM;
    private com.baidu.live.im.d.b bjN;
    private a.InterfaceC0214a bjO;
    private long bjP;
    private int bjQ;
    private int bjR;
    private boolean bjS;
    private boolean bjT;
    private int bjU;
    private BdPageContext bjV;
    private int bjW;
    private String bjX;
    private int bjY;
    private AlaLiveInfoData bjZ;
    private boolean bka;
    public CustomMessageListener bkb;
    private View.OnClickListener bkc;
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
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.biW == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.biX);
            }
            this.mDialog = new BdAlertDialog(this.bjV.getPageActivity());
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
            this.mDialog.create(this.bjV);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Me() {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.bjL.getText().toString();
        if (obj.length() > this.bjR) {
            obj = obj.subSequence(0, this.bjR).toString();
        }
        if (!TextUtils.isEmpty(obj.trim())) {
            if (currentTimeMillis - this.bjP >= 2000) {
                this.bjP = currentTimeMillis;
                this.bka = false;
                s(obj, false);
            } else if (!this.bka) {
                Toast.makeText(getContext(), a.i.ala_click_too_fast, 0).show();
                this.bka = true;
            }
        }
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bjW = 0;
        this.bka = false;
        this.handler = new Handler();
        this.bkb = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bjW == 3 || ALALiveTextView.this.bjW == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bjW == 3) {
                                    ALALiveTextView.this.Me();
                                } else if (ALALiveTextView.this.bjW == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bjX, ALALiveTextView.this.bjY);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bjW = 0;
                    }
                }
            }
        };
        this.bbC = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bkc = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.x.a.OS().blo.aLK == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.OS().blo.aLJ == 1) {
                    if (ALALiveTextView.this.bjT) {
                        ALALiveTextView.this.bjW = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Me();
                } else {
                    ALALiveTextView.this.Me();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bkf;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bkf = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bkf, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bjW = 0;
        this.bka = false;
        this.handler = new Handler();
        this.bkb = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bjW == 3 || ALALiveTextView.this.bjW == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bjW == 3) {
                                    ALALiveTextView.this.Me();
                                } else if (ALALiveTextView.this.bjW == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bjX, ALALiveTextView.this.bjY);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bjW = 0;
                    }
                }
            }
        };
        this.bbC = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bkc = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.x.a.OS().blo.aLK == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.OS().blo.aLJ == 1) {
                    if (ALALiveTextView.this.bjT) {
                        ALALiveTextView.this.bjW = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Me();
                } else {
                    ALALiveTextView.this.Me();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bkf;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bkf = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bkf, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.bjV = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjW = 0;
        this.bka = false;
        this.handler = new Handler();
        this.bkb = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bjW == 3 || ALALiveTextView.this.bjW == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bjW == 3) {
                                    ALALiveTextView.this.Me();
                                } else if (ALALiveTextView.this.bjW == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bjX, ALALiveTextView.this.bjY);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bjW = 0;
                    }
                }
            }
        };
        this.bbC = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bkc = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.x.a.OS().blo.aLK == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.OS().blo.aLJ == 1) {
                    if (ALALiveTextView.this.bjT) {
                        ALALiveTextView.this.bjW = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Me();
                } else {
                    ALALiveTextView.this.Me();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bkf;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bkf = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bkf, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bjW = 0;
        this.bka = false;
        this.handler = new Handler();
        this.bkb = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bjW == 3 || ALALiveTextView.this.bjW == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bjW == 3) {
                                    ALALiveTextView.this.Me();
                                } else if (ALALiveTextView.this.bjW == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bjX, ALALiveTextView.this.bjY);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bjW = 0;
                    }
                }
            }
        };
        this.bbC = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bkc = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.x.a.OS().blo.aLK == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.OS().blo.aLJ == 1) {
                    if (ALALiveTextView.this.bjT) {
                        ALALiveTextView.this.bjW = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Me();
                } else {
                    ALALiveTextView.this.Me();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bkf;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.bkf = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.bkf, i2);
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
        Mf();
        Mg();
        Mh();
        this.bjR = 50;
    }

    private void Mf() {
        this.bjK = (Switch) findViewById(a.g.switch_barrage);
        this.bjI = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        this.bjJ = (FrameLayout) findViewById(a.g.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bjV);
        if (runTask != null) {
            this.bjH = (c) runTask.getData();
        }
        if (this.bjH != null) {
            this.bjI.addView(this.bjH.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, b.class, this.bjV);
        if (runTask2 != null) {
            this.bjF = (b) runTask2.getData();
        }
        if (this.bjF != null) {
            this.bjJ.addView(this.bjF.getView());
        }
        if (this.bjH != null) {
            this.bjH.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.13
                @Override // com.baidu.live.im.b.e
                public boolean Ls() {
                    return ALALiveTextView.this.bjO != null && ALALiveTextView.this.bjO.KW();
                }

                @Override // com.baidu.live.im.b.e
                public void eh(int i) {
                    ALALiveTextView.this.Mq();
                    ALALiveTextView.this.bZ(false);
                }

                @Override // com.baidu.live.im.b.e
                public int KX() {
                    if (ALALiveTextView.this.bjO != null) {
                        return ALALiveTextView.this.bjO.KX();
                    }
                    return 0;
                }
            });
        }
        this.bjK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.bY(z);
            }
        });
    }

    private void Mg() {
        this.bjL = (EditText) findViewById(a.g.edit_text);
        this.bjL.addTextChangedListener(this.mTextWatcher);
        this.bjL.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    ALALiveTextView.this.Me();
                    return true;
                }
                return false;
            }
        });
        this.bjM = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.bjM.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.bjL, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.bjL, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.bjM.setOnClickListener(this.bkc);
        this.bjM.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bjT = z;
        this.bjU = i;
        this.aYE = i2;
        this.mUserName = str;
    }

    private void Mh() {
        this.bjD = (FrameLayout) findViewById(a.g.quick_input_header);
        this.bjE = (FrameLayout) findViewById(a.g.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, com.baidu.live.im.d.b.class, this.bjV);
        if (runTask != null) {
            this.bjN = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.bjN != null) {
            this.bjE.addView(this.bjN.getView());
            this.bjN.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void C(String str, int i) {
                    if (com.baidu.live.x.a.OS().blo.aLK == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.x.a.OS().blo.aLJ == 1) {
                        if (ALALiveTextView.this.bjT) {
                            ALALiveTextView.this.bjX = str;
                            ALALiveTextView.this.bjY = i;
                            ALALiveTextView.this.bjW = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.D(str, i);
                    } else {
                        ALALiveTextView.this.D(str, i);
                    }
                }
            });
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.bjV);
        if (runTask2 != null) {
            this.bjG = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.bjG != null) {
            this.bjD.addView(this.bjG.getView());
            this.bjG.setCallback(new a.InterfaceC0186a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0186a
                public void C(String str, int i) {
                    if (com.baidu.live.x.a.OS().blo.aLK == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.x.a.OS().blo.aLJ == 1) {
                        if (ALALiveTextView.this.bjT) {
                            ALALiveTextView.this.bjX = str;
                            ALALiveTextView.this.bjY = i;
                            ALALiveTextView.this.bjW = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.D(str, i);
                    } else {
                        ALALiveTextView.this.D(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0186a
                public void LP() {
                    if (ALALiveTextView.this.bjO != null) {
                        ALALiveTextView.this.bjO.KU();
                    }
                    LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str, int i) {
        s(str, true);
        LogManager.getCommonLogger().doClickQuickImPanelLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.bjS = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Mi() {
        return this.bjK != null && this.bjK.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean Mj() {
        return !Mn() && this.bjD.getVisibility() == 0;
    }

    public bz getBarrageInfo() {
        if (this.bjH != null) {
            return this.bjH.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.bjL.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0214a interfaceC0214a) {
        this.bjO = interfaceC0214a;
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

    public void hy(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Mk() {
        return getView().getVisibility() == 0 && this.bjE.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.bjE.setVisibility(0);
            if (this.bjQ < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.bjN != null) {
                    this.bjN.LR();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjE.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.bjE.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.bjE.setVisibility(8);
        if (this.bjL != null) {
            this.bjL.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Ml() {
        if (this.bjL != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.bjL);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.bjQ - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bjV = bdPageContext;
    }

    public void Mm() {
        this.bjL.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.bjL.getSelectionStart();
            Editable editableText = this.bjL.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.bjL.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.bjZ = alaLiveInfoData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aUa = map;
        Mp();
        this.bjL.requestFocus();
        if (this.bjL != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bjL.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.bjL);
                }
            }, 50L);
        }
        boolean Mn = Mn();
        if (list == null || list.isEmpty() || Mn) {
            if (this.bjG != null) {
                this.bjG.setData(list);
            }
            this.bjE.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.bjG != null) {
            if (arrayList.size() >= 3) {
                this.bjG.setData(arrayList.subList(0, 3));
            } else {
                this.bjG.setData(arrayList);
            }
        }
        this.bjD.setVisibility(Mi() ? 8 : 0);
        this.bjE.setVisibility(0);
        if (this.bjN != null) {
            this.bjN.LQ();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bjE.getLayoutParams();
        layoutParams.height = -2;
        this.bjE.setLayoutParams(layoutParams);
        if (this.bjN != null) {
            this.bjN.setData(arrayList);
        }
        this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.bjQ = ALALiveTextView.this.bjE.getHeight();
                ALALiveTextView.this.bjE.setVisibility(8);
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
        this.bjL.clearFocus();
        if (this.bjF != null) {
            this.bjF.release();
        }
        setVisibility(8);
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.bjH != null) {
            this.bjH.f(map);
        }
    }

    private boolean Mn() {
        return (this.bjZ == null || this.bjZ.mAlaLiveSwitchData == null || !this.bjZ.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean Mo() {
        return (this.bjZ == null || this.bjZ.mAlaLiveSwitchData == null || !this.bjZ.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    private void Mp() {
        if (this.bjS || Mo()) {
            this.bjK.setVisibility(8);
            return;
        }
        final bz[] e = d.Lm().e(this.bjO != null && this.bjO.KW(), this.bjO != null ? this.bjO.KX() : 0);
        if (e == null || e.length <= 0) {
            if (this.bjK.isChecked()) {
                this.bjK.setChecked(false, false);
            } else {
                bY(false);
            }
            this.bjK.setVisibility(8);
            return;
        }
        this.bjK.setVisibility(0);
        if (this.bjH != null) {
            if (this.bjH.getView().getWidth() <= 0) {
                this.bjI.setVisibility(0);
            }
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.Lm().Lo()) {
                        ALALiveTextView.this.bjH.setData(e, ALALiveTextView.this.aUa, 0);
                        if (ALALiveTextView.this.bjK.isChecked()) {
                            ALALiveTextView.this.bjH.setSelectId(d.Lm().Lp());
                            ALALiveTextView.this.Mq();
                            ALALiveTextView.this.bZ(true);
                        } else {
                            ALALiveTextView.this.bjK.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.bjK.isChecked()) {
                        ALALiveTextView.this.bjK.setChecked(false, false);
                    }
                    ALALiveTextView.this.bjI.setVisibility(ALALiveTextView.this.bjK.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.bjM != null) {
            if (TextUtils.isEmpty(this.bjL.getText())) {
                this.bjM.setEnabled(false);
            } else {
                this.bjM.setEnabled(true);
                this.bjM.setClickable(true);
            }
        }
        if (this.bjL.getText().length() > this.bjR) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.bjR)));
            if (charSequence.length() > this.bjR) {
                this.bjL.setText(charSequence.subSequence(0, this.bjR));
                this.bjL.setSelection(this.bjL.getText().length());
                return;
            }
            this.bjL.setText(charSequence);
            if (i <= charSequence.length()) {
                this.bjL.setSelection(i);
            } else {
                this.bjL.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mq() {
        if (this.bjH != null) {
            bz selectInfo = this.bjH.getSelectInfo();
            if (this.bjL != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.bjL.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.bjL.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aPF == 7) {
                            this.bjL.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.bjL.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_barrage));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(boolean z) {
        if (z && this.bjO != null && !this.bjO.KS()) {
            this.bjK.setChecked(false, false);
            return;
        }
        this.bjR = z ? 20 : 50;
        if (z && this.bjL != null && this.bjL.getText() != null && this.bjL.getText().length() > this.bjR) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.bjR)));
        }
        if (this.bjH != null) {
            if (z) {
                this.bjH.setData(d.Lm().e(this.bjO != null && this.bjO.KW(), this.bjO != null ? this.bjO.KX() : 0), this.aUa, 0);
                this.bjH.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Lm().Lp())) {
                    this.bjH.setSelectId(d.Lm().Lp());
                } else {
                    this.bjH.setSelectPos(0);
                }
                if (this.bjI != null) {
                    this.bjI.setVisibility(0);
                }
                bZ(true);
                this.bjD.setVisibility(8);
                Mq();
                setQuickInputPanelVisible(false);
                if (this.bjV != null && this.bjV.getPageActivity() != null && this.bjL != null) {
                    BdUtilHelper.showSoftKeyPad(this.bjV.getPageActivity(), this.bjL);
                }
            } else {
                this.bjH.setSwitchStatus(false);
                if (this.bjJ != null) {
                    this.bjJ.setVisibility(8);
                }
                if (this.bjI != null) {
                    this.bjI.setVisibility(8);
                }
                if (!Mn()) {
                    this.bjD.setVisibility(0);
                }
                if (this.bjL != null) {
                    this.bjL.setHint(a.i.sdk_im_sendmessage_to_host);
                }
            }
            if (this.bjO != null) {
                this.bjO.KV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(boolean z) {
        if (z && this.bjF != null) {
            this.bjF.setPreview();
        }
        if (this.bjF != null && this.bjH != null) {
            this.bjF.setUIInfo(this.bjH.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.bjJ != null) {
                this.bjJ.setVisibility(8);
            }
        } else if (this.bjK != null && this.bjK.isChecked() && this.bjJ != null) {
            this.bjJ.setVisibility(0);
        }
    }

    private void s(String str, boolean z) {
        if (this.bjO != null) {
            this.bjO.r(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                if (this.bjJ != null) {
                    this.bjJ.setVisibility(8);
                }
            } else if (this.bjK != null && this.bjK.isChecked() && this.bjJ != null) {
                this.bjJ.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Mr() {
        if (this.bjL != null) {
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bjL.requestFocus();
                }
            });
        }
    }
}

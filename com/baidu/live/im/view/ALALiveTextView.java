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
import com.baidu.live.data.cg;
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
    private Map<String, Integer> aUR;
    private int aZI;
    public CustomMessageListener bcy;
    private FrameLayout bkH;
    private FrameLayout bkI;
    private b bkJ;
    private com.baidu.live.im.d.a bkK;
    private c bkL;
    private FrameLayout bkM;
    private FrameLayout bkN;
    private Switch bkO;
    private EditText bkP;
    private GradientEnableTextView bkQ;
    private com.baidu.live.im.d.b bkR;
    private a.InterfaceC0230a bkS;
    private long bkT;
    private int bkU;
    private int bkV;
    private boolean bkW;
    private boolean bkX;
    private int bkY;
    private BdPageContext bkZ;
    private int bla;
    private String blb;
    private int blc;
    private AlaLiveInfoData bld;
    private boolean ble;
    public CustomMessageListener blf;
    private View.OnClickListener blg;
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
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bka == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bkb);
            }
            this.mDialog = new BdAlertDialog(this.bkZ.getPageActivity());
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
            this.mDialog.create(this.bkZ);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mp() {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.bkP.getText().toString();
        if (obj.length() > this.bkV) {
            obj = obj.subSequence(0, this.bkV).toString();
        }
        if (!TextUtils.isEmpty(obj.trim())) {
            if (currentTimeMillis - this.bkT >= 2000) {
                this.bkT = currentTimeMillis;
                this.ble = false;
                t(obj, false);
            } else if (!this.ble) {
                Toast.makeText(getContext(), a.h.ala_click_too_fast, 0).show();
                this.ble = true;
            }
        }
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bla = 0;
        this.ble = false;
        this.handler = new Handler();
        this.blf = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bla == 3 || ALALiveTextView.this.bla == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bla == 3) {
                                    ALALiveTextView.this.Mp();
                                } else if (ALALiveTextView.this.bla == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.blb, ALALiveTextView.this.blc);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bla = 0;
                    }
                }
            }
        };
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.blg = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.aa.a.Ph().bms.aLD == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                    if (ALALiveTextView.this.bkX) {
                        ALALiveTextView.this.bla = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Mp();
                } else {
                    ALALiveTextView.this.Mp();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence blj;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.blj = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.blj, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bla = 0;
        this.ble = false;
        this.handler = new Handler();
        this.blf = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bla == 3 || ALALiveTextView.this.bla == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bla == 3) {
                                    ALALiveTextView.this.Mp();
                                } else if (ALALiveTextView.this.bla == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.blb, ALALiveTextView.this.blc);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bla = 0;
                    }
                }
            }
        };
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.blg = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.aa.a.Ph().bms.aLD == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                    if (ALALiveTextView.this.bkX) {
                        ALALiveTextView.this.bla = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Mp();
                } else {
                    ALALiveTextView.this.Mp();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence blj;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.blj = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.blj, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.bkZ = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bla = 0;
        this.ble = false;
        this.handler = new Handler();
        this.blf = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bla == 3 || ALALiveTextView.this.bla == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bla == 3) {
                                    ALALiveTextView.this.Mp();
                                } else if (ALALiveTextView.this.bla == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.blb, ALALiveTextView.this.blc);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bla = 0;
                    }
                }
            }
        };
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.blg = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.aa.a.Ph().bms.aLD == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                    if (ALALiveTextView.this.bkX) {
                        ALALiveTextView.this.bla = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Mp();
                } else {
                    ALALiveTextView.this.Mp();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence blj;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.blj = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.blj, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bla = 0;
        this.ble = false;
        this.handler = new Handler();
        this.blf = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bla == 3 || ALALiveTextView.this.bla == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bla == 3) {
                                    ALALiveTextView.this.Mp();
                                } else if (ALALiveTextView.this.bla == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.blb, ALALiveTextView.this.blc);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bla = 0;
                    }
                }
            }
        };
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.blg = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.aa.a.Ph().bms.aLD == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                    if (ALALiveTextView.this.bkX) {
                        ALALiveTextView.this.bla = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Mp();
                } else {
                    ALALiveTextView.this.Mp();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence blj;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.blj = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.blj, i2);
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
        Mq();
        Mr();
        Ms();
        this.bkV = 50;
    }

    private void Mq() {
        this.bkO = (Switch) findViewById(a.f.switch_barrage);
        this.bkM = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        this.bkN = (FrameLayout) findViewById(a.f.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bkZ);
        if (runTask != null) {
            this.bkL = (c) runTask.getData();
        }
        if (this.bkL != null) {
            this.bkM.addView(this.bkL.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, b.class, this.bkZ);
        if (runTask2 != null) {
            this.bkJ = (b) runTask2.getData();
        }
        if (this.bkJ != null) {
            this.bkN.addView(this.bkJ.getView());
        }
        if (this.bkL != null) {
            this.bkL.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.13
                @Override // com.baidu.live.im.b.e
                public boolean LE() {
                    return ALALiveTextView.this.bkS != null && ALALiveTextView.this.bkS.Lh();
                }

                @Override // com.baidu.live.im.b.e
                public void ee(int i) {
                    ALALiveTextView.this.MB();
                    ALALiveTextView.this.ce(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Li() {
                    if (ALALiveTextView.this.bkS != null) {
                        return ALALiveTextView.this.bkS.Li();
                    }
                    return 0;
                }
            });
        }
        this.bkO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.cd(z);
            }
        });
    }

    private void Mr() {
        this.bkP = (EditText) findViewById(a.f.edit_text);
        this.bkP.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    ALALiveTextView.this.Mp();
                    return true;
                }
                return false;
            }
        });
        this.bkQ = (GradientEnableTextView) findViewById(a.f.tv_send);
        this.bkQ.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.bkP, Integer.valueOf(a.e.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.bkP, Integer.valueOf(a.e.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.bkQ.setOnClickListener(this.blg);
        this.bkQ.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bkX = z;
        this.bkY = i;
        this.aZI = i2;
        this.mUserName = str;
    }

    private void Ms() {
        this.bkH = (FrameLayout) findViewById(a.f.quick_input_header);
        this.bkI = (FrameLayout) findViewById(a.f.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, com.baidu.live.im.d.b.class, this.bkZ);
        if (runTask != null) {
            this.bkR = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.bkR != null) {
            this.bkI.addView(this.bkR.getView());
            this.bkR.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void C(String str, int i) {
                    if (com.baidu.live.aa.a.Ph().bms.aLD == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                        if (ALALiveTextView.this.bkX) {
                            ALALiveTextView.this.blb = str;
                            ALALiveTextView.this.blc = i;
                            ALALiveTextView.this.bla = 4;
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
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.bkZ);
        if (runTask2 != null) {
            this.bkK = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.bkK != null) {
            this.bkH.addView(this.bkK.getView());
            this.bkK.setCallback(new a.InterfaceC0187a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0187a
                public void C(String str, int i) {
                    if (com.baidu.live.aa.a.Ph().bms.aLD == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                        if (ALALiveTextView.this.bkX) {
                            ALALiveTextView.this.blb = str;
                            ALALiveTextView.this.blc = i;
                            ALALiveTextView.this.bla = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.D(str, i);
                    } else {
                        ALALiveTextView.this.D(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0187a
                public void Ma() {
                    if (ALALiveTextView.this.bkS != null) {
                        ALALiveTextView.this.bkS.Lf();
                    }
                    LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str, int i) {
        t(str, true);
        LogManager.getCommonLogger().doClickQuickImPanelLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.bkW = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Mt() {
        return this.bkO != null && this.bkO.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean Mu() {
        return !My() && this.bkH.getVisibility() == 0;
    }

    public cg getBarrageInfo() {
        if (this.bkL != null) {
            return this.bkL.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.bkP.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0230a interfaceC0230a) {
        this.bkS = interfaceC0230a;
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

    public void hG(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Mv() {
        return getView().getVisibility() == 0 && this.bkI.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.bkI.setVisibility(0);
            if (this.bkU < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.bkR != null) {
                    this.bkR.Mc();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkI.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.bkI.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.bkI.setVisibility(8);
        if (this.bkP != null) {
            this.bkP.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Mw() {
        if (this.bkP != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.bkP);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.bkU - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bkZ = bdPageContext;
    }

    public void Mx() {
        this.bkP.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.bkP.getSelectionStart();
            Editable editableText = this.bkP.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.bkP.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.bld = alaLiveInfoData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aUR = map;
        MA();
        this.bkP.requestFocus();
        if (this.bkP != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bkP.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.bkP);
                }
            }, 50L);
        }
        boolean My = My();
        if (list == null || list.isEmpty() || My) {
            if (this.bkK != null) {
                this.bkK.setData(list);
            }
            this.bkI.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.bkK != null) {
            if (arrayList.size() >= 3) {
                this.bkK.setData(arrayList.subList(0, 3));
            } else {
                this.bkK.setData(arrayList);
            }
        }
        this.bkH.setVisibility(Mt() ? 8 : 0);
        this.bkI.setVisibility(0);
        if (this.bkR != null) {
            this.bkR.Mb();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkI.getLayoutParams();
        layoutParams.height = -2;
        this.bkI.setLayoutParams(layoutParams);
        if (this.bkR != null) {
            this.bkR.setData(arrayList);
        }
        this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.bkU = ALALiveTextView.this.bkI.getHeight();
                ALALiveTextView.this.bkI.setVisibility(8);
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
        this.bkP.clearFocus();
        if (this.bkJ != null) {
            this.bkJ.release();
        }
        setVisibility(8);
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.bkL != null) {
            this.bkL.f(map);
        }
    }

    private boolean My() {
        return (this.bld == null || this.bld.mAlaLiveSwitchData == null || !this.bld.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean Mz() {
        return (this.bld == null || this.bld.mAlaLiveSwitchData == null || !this.bld.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    private void MA() {
        if (this.bkW || Mz()) {
            this.bkO.setVisibility(8);
            return;
        }
        final cg[] e = d.Lx().e(this.bkS != null && this.bkS.Lh(), this.bkS != null ? this.bkS.Li() : 0);
        if (e == null || e.length <= 0) {
            if (this.bkO.isChecked()) {
                this.bkO.setChecked(false, false);
            } else {
                cd(false);
            }
            this.bkO.setVisibility(8);
            return;
        }
        this.bkO.setVisibility(0);
        if (this.bkL != null) {
            if (this.bkL.getView().getWidth() <= 0) {
                this.bkM.setVisibility(0);
            }
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.Lx().LA()) {
                        ALALiveTextView.this.bkL.setData(e, ALALiveTextView.this.aUR, 0);
                        if (ALALiveTextView.this.bkO.isChecked()) {
                            ALALiveTextView.this.bkL.setSelectId(d.Lx().LB());
                            ALALiveTextView.this.MB();
                            ALALiveTextView.this.ce(true);
                        } else {
                            ALALiveTextView.this.bkO.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.bkO.isChecked()) {
                        ALALiveTextView.this.bkO.setChecked(false, false);
                    }
                    ALALiveTextView.this.bkM.setVisibility(ALALiveTextView.this.bkO.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.bkQ != null) {
            if (TextUtils.isEmpty(this.bkP.getText())) {
                this.bkQ.setEnabled(false);
            } else {
                this.bkQ.setEnabled(true);
                this.bkQ.setClickable(true);
            }
        }
        if (this.bkP.getText().length() > this.bkV) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bkV)));
            if (charSequence.length() > this.bkV) {
                this.bkP.setText(charSequence.subSequence(0, this.bkV));
                this.bkP.setSelection(this.bkP.getText().length());
                return;
            }
            this.bkP.setText(charSequence);
            if (i <= charSequence.length()) {
                this.bkP.setSelection(i);
            } else {
                this.bkP.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MB() {
        if (this.bkL != null) {
            cg selectInfo = this.bkL.getSelectInfo();
            if (this.bkP != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.bkP.setHint(String.format(Locale.getDefault(), getResources().getString(a.h.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.bkP.setHint(getResources().getString(a.h.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aPG == 7) {
                            this.bkP.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.bkP.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_barrage));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cd(boolean z) {
        if (z && this.bkS != null && !this.bkS.Ld()) {
            this.bkO.setChecked(false, false);
            return;
        }
        this.bkV = z ? 20 : 50;
        if (z && this.bkP != null && this.bkP.getText() != null && this.bkP.getText().length() > this.bkV) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bkV)));
        }
        if (this.bkL != null) {
            if (z) {
                this.bkL.setData(d.Lx().e(this.bkS != null && this.bkS.Lh(), this.bkS != null ? this.bkS.Li() : 0), this.aUR, 0);
                this.bkL.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Lx().LB())) {
                    this.bkL.setSelectId(d.Lx().LB());
                } else {
                    this.bkL.setSelectPos(0);
                }
                if (this.bkM != null) {
                    this.bkM.setVisibility(0);
                }
                ce(true);
                this.bkH.setVisibility(8);
                MB();
                setQuickInputPanelVisible(false);
                if (this.bkZ != null && this.bkZ.getPageActivity() != null && this.bkP != null) {
                    BdUtilHelper.showSoftKeyPad(this.bkZ.getPageActivity(), this.bkP);
                }
            } else {
                this.bkL.setSwitchStatus(false);
                if (this.bkN != null) {
                    this.bkN.setVisibility(8);
                }
                if (this.bkM != null) {
                    this.bkM.setVisibility(8);
                }
                if (!My()) {
                    this.bkH.setVisibility(0);
                }
                if (this.bkP != null) {
                    this.bkP.setHint(a.h.sdk_im_sendmessage_to_host);
                }
            }
            if (this.bkS != null) {
                this.bkS.Lg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(boolean z) {
        if (z && this.bkJ != null) {
            this.bkJ.setPreview();
        }
        if (this.bkJ != null && this.bkL != null) {
            this.bkJ.setUIInfo(this.bkL.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.bkN != null) {
                this.bkN.setVisibility(8);
            }
        } else if (this.bkO != null && this.bkO.isChecked() && this.bkN != null) {
            this.bkN.setVisibility(0);
        }
    }

    private void t(String str, boolean z) {
        if (this.bkS != null) {
            this.bkS.s(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                if (this.bkN != null) {
                    this.bkN.setVisibility(8);
                }
            } else if (this.bkO != null && this.bkO.isChecked() && this.bkN != null) {
                this.bkN.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void MC() {
        if (this.bkP != null) {
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bkP.requestFocus();
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bkP != null) {
            this.bkP.addTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bkP != null) {
            this.bkP.removeTextChangedListener(this.mTextWatcher);
        }
    }
}

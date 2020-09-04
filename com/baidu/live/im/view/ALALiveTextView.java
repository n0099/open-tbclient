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
import com.baidu.live.data.br;
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
/* loaded from: classes7.dex */
public class ALALiveTextView extends LinearLayout implements com.baidu.live.view.input.a {
    private Map<String, Integer> aON;
    private int aTf;
    public CustomMessageListener aVP;
    private FrameLayout bcY;
    private FrameLayout bcZ;
    private b bda;
    private com.baidu.live.im.d.a bdb;
    private c bdc;
    private FrameLayout bdd;
    private FrameLayout bde;
    private Switch bdf;
    private EditText bdg;
    private GradientEnableTextView bdh;
    private com.baidu.live.im.d.b bdi;
    private a.InterfaceC0199a bdj;
    private long bdk;
    private int bdl;
    private int bdm;
    private boolean bdn;
    private boolean bdo;
    private int bdp;
    private BdPageContext bdq;
    private int bdr;
    private String bds;
    private int bdt;
    private AlaLiveInfoData bdu;
    private boolean bdv;
    public CustomMessageListener bdw;
    private View.OnClickListener bdx;
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
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bcy == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bcz);
            }
            this.mDialog = new BdAlertDialog(this.bdq.getPageActivity());
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
            this.mDialog.create(this.bdq);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ks() {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.bdg.getText().toString();
        if (obj.length() > this.bdm) {
            obj = obj.subSequence(0, this.bdm).toString();
        }
        if (!TextUtils.isEmpty(obj.trim())) {
            if (currentTimeMillis - this.bdk >= 2000) {
                this.bdk = currentTimeMillis;
                this.bdv = false;
                s(obj, false);
            } else if (!this.bdv) {
                Toast.makeText(getContext(), a.i.ala_click_too_fast, 0).show();
                this.bdv = true;
            }
        }
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bdr = 0;
        this.bdv = false;
        this.handler = new Handler();
        this.bdw = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bdr == 3 || ALALiveTextView.this.bdr == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bdr == 3) {
                                    ALALiveTextView.this.Ks();
                                } else if (ALALiveTextView.this.bdr == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bds, ALALiveTextView.this.bdt);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bdr = 0;
                    }
                }
            }
        };
        this.aVP = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bdx = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.w.a.Nk().beJ.aHp == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beJ.aHo == 1) {
                    if (ALALiveTextView.this.bdo) {
                        ALALiveTextView.this.bdr = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Ks();
                } else {
                    ALALiveTextView.this.Ks();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bdA;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bdA = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bdA, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bdr = 0;
        this.bdv = false;
        this.handler = new Handler();
        this.bdw = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bdr == 3 || ALALiveTextView.this.bdr == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bdr == 3) {
                                    ALALiveTextView.this.Ks();
                                } else if (ALALiveTextView.this.bdr == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bds, ALALiveTextView.this.bdt);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bdr = 0;
                    }
                }
            }
        };
        this.aVP = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bdx = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.w.a.Nk().beJ.aHp == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beJ.aHo == 1) {
                    if (ALALiveTextView.this.bdo) {
                        ALALiveTextView.this.bdr = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Ks();
                } else {
                    ALALiveTextView.this.Ks();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bdA;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bdA = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bdA, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.bdq = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdr = 0;
        this.bdv = false;
        this.handler = new Handler();
        this.bdw = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bdr == 3 || ALALiveTextView.this.bdr == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bdr == 3) {
                                    ALALiveTextView.this.Ks();
                                } else if (ALALiveTextView.this.bdr == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bds, ALALiveTextView.this.bdt);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bdr = 0;
                    }
                }
            }
        };
        this.aVP = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bdx = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.w.a.Nk().beJ.aHp == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beJ.aHo == 1) {
                    if (ALALiveTextView.this.bdo) {
                        ALALiveTextView.this.bdr = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Ks();
                } else {
                    ALALiveTextView.this.Ks();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bdA;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bdA = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bdA, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdr = 0;
        this.bdv = false;
        this.handler = new Handler();
        this.bdw = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bdr == 3 || ALALiveTextView.this.bdr == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bdr == 3) {
                                    ALALiveTextView.this.Ks();
                                } else if (ALALiveTextView.this.bdr == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bds, ALALiveTextView.this.bdt);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bdr = 0;
                    }
                }
            }
        };
        this.aVP = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bdx = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.w.a.Nk().beJ.aHp == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beJ.aHo == 1) {
                    if (ALALiveTextView.this.bdo) {
                        ALALiveTextView.this.bdr = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.Ks();
                } else {
                    ALALiveTextView.this.Ks();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bdA;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.bdA = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.bdA, i2);
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
        Kt();
        Ku();
        Kv();
        this.bdm = 50;
    }

    private void Kt() {
        this.bdf = (Switch) findViewById(a.g.switch_barrage);
        this.bdd = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        this.bde = (FrameLayout) findViewById(a.g.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bdq);
        if (runTask != null) {
            this.bdc = (c) runTask.getData();
        }
        if (this.bdc != null) {
            this.bdd.addView(this.bdc.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, b.class, this.bdq);
        if (runTask2 != null) {
            this.bda = (b) runTask2.getData();
        }
        if (this.bda != null) {
            this.bde.addView(this.bda.getView());
        }
        if (this.bdc != null) {
            this.bdc.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.13
                @Override // com.baidu.live.im.b.e
                public boolean JJ() {
                    return ALALiveTextView.this.bdj != null && ALALiveTextView.this.bdj.Jm();
                }

                @Override // com.baidu.live.im.b.e
                public void dY(int i) {
                    ALALiveTextView.this.KE();
                    ALALiveTextView.this.bU(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Jn() {
                    if (ALALiveTextView.this.bdj != null) {
                        return ALALiveTextView.this.bdj.Jn();
                    }
                    return 0;
                }
            });
        }
        this.bdf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.bT(z);
            }
        });
    }

    private void Ku() {
        this.bdg = (EditText) findViewById(a.g.edit_text);
        this.bdg.addTextChangedListener(this.mTextWatcher);
        this.bdg.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    ALALiveTextView.this.Ks();
                    return true;
                }
                return false;
            }
        });
        this.bdh = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.bdh.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.bdg, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.bdg, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.bdh.setOnClickListener(this.bdx);
        this.bdh.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bdo = z;
        this.bdp = i;
        this.aTf = i2;
        this.mUserName = str;
    }

    private void Kv() {
        this.bcY = (FrameLayout) findViewById(a.g.quick_input_header);
        this.bcZ = (FrameLayout) findViewById(a.g.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, com.baidu.live.im.d.b.class, this.bdq);
        if (runTask != null) {
            this.bdi = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.bdi != null) {
            this.bcZ.addView(this.bdi.getView());
            this.bdi.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void C(String str, int i) {
                    if (com.baidu.live.w.a.Nk().beJ.aHp == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.w.a.Nk().beJ.aHo == 1) {
                        if (ALALiveTextView.this.bdo) {
                            ALALiveTextView.this.bds = str;
                            ALALiveTextView.this.bdt = i;
                            ALALiveTextView.this.bdr = 4;
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
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.bdq);
        if (runTask2 != null) {
            this.bdb = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.bdb != null) {
            this.bcY.addView(this.bdb.getView());
            this.bdb.setCallback(new a.InterfaceC0176a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0176a
                public void C(String str, int i) {
                    if (com.baidu.live.w.a.Nk().beJ.aHp == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.w.a.Nk().beJ.aHo == 1) {
                        if (ALALiveTextView.this.bdo) {
                            ALALiveTextView.this.bds = str;
                            ALALiveTextView.this.bdt = i;
                            ALALiveTextView.this.bdr = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.D(str, i);
                    } else {
                        ALALiveTextView.this.D(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0176a
                public void Kd() {
                    if (ALALiveTextView.this.bdj != null) {
                        ALALiveTextView.this.bdj.Jk();
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
        this.bdn = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Kw() {
        return this.bdf != null && this.bdf.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean Kx() {
        return !KB() && this.bcY.getVisibility() == 0;
    }

    public br getBarrageInfo() {
        if (this.bdc != null) {
            return this.bdc.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.bdg.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0199a interfaceC0199a) {
        this.bdj = interfaceC0199a;
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

    public void gU(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ky() {
        return getView().getVisibility() == 0 && this.bcZ.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.bcZ.setVisibility(0);
            if (this.bdl < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.bdi != null) {
                    this.bdi.Kf();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcZ.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.bcZ.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.bcZ.setVisibility(8);
        if (this.bdg != null) {
            this.bdg.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Kz() {
        if (this.bdg != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.bdg);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.bdl - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bdq = bdPageContext;
    }

    public void KA() {
        this.bdg.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.bdg.getSelectionStart();
            Editable editableText = this.bdg.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.bdg.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.bdu = alaLiveInfoData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aON = map;
        KD();
        this.bdg.requestFocus();
        if (this.bdg != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bdg.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.bdg);
                }
            }, 50L);
        }
        boolean KB = KB();
        if (list == null || list.isEmpty() || KB) {
            if (this.bdb != null) {
                this.bdb.setData(list);
            }
            this.bcZ.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.bdb != null) {
            if (arrayList.size() >= 3) {
                this.bdb.setData(arrayList.subList(0, 3));
            } else {
                this.bdb.setData(arrayList);
            }
        }
        this.bcY.setVisibility(Kw() ? 8 : 0);
        this.bcZ.setVisibility(0);
        if (this.bdi != null) {
            this.bdi.Ke();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcZ.getLayoutParams();
        layoutParams.height = -2;
        this.bcZ.setLayoutParams(layoutParams);
        if (this.bdi != null) {
            this.bdi.setData(arrayList);
        }
        this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.bdl = ALALiveTextView.this.bcZ.getHeight();
                ALALiveTextView.this.bcZ.setVisibility(8);
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
        this.bdg.clearFocus();
        if (this.bda != null) {
            this.bda.release();
        }
        setVisibility(8);
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.bdc != null) {
            this.bdc.f(map);
        }
    }

    private boolean KB() {
        return (this.bdu == null || this.bdu.mAlaLiveSwitchData == null || !this.bdu.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean KC() {
        return (this.bdu == null || this.bdu.mAlaLiveSwitchData == null || !this.bdu.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    private void KD() {
        if (this.bdn || KC()) {
            this.bdf.setVisibility(8);
            return;
        }
        final br[] e = d.JD().e(this.bdj != null && this.bdj.Jm(), this.bdj != null ? this.bdj.Jn() : 0);
        if (e == null || e.length <= 0) {
            if (this.bdf.isChecked()) {
                this.bdf.setChecked(false, false);
            } else {
                bT(false);
            }
            this.bdf.setVisibility(8);
            return;
        }
        this.bdf.setVisibility(0);
        if (this.bdc != null) {
            if (this.bdc.getView().getWidth() <= 0) {
                this.bdd.setVisibility(0);
            }
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.JD().JF()) {
                        ALALiveTextView.this.bdc.setData(e, ALALiveTextView.this.aON, 0);
                        if (ALALiveTextView.this.bdf.isChecked()) {
                            ALALiveTextView.this.bdc.setSelectId(d.JD().JG());
                            ALALiveTextView.this.KE();
                            ALALiveTextView.this.bU(true);
                        } else {
                            ALALiveTextView.this.bdf.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.bdf.isChecked()) {
                        ALALiveTextView.this.bdf.setChecked(false, false);
                    }
                    ALALiveTextView.this.bdd.setVisibility(ALALiveTextView.this.bdf.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.bdh != null) {
            if (TextUtils.isEmpty(this.bdg.getText())) {
                this.bdh.setEnabled(false);
            } else {
                this.bdh.setEnabled(true);
                this.bdh.setClickable(true);
            }
        }
        if (this.bdg.getText().length() > this.bdm) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.bdm)));
            if (charSequence.length() > this.bdm) {
                this.bdg.setText(charSequence.subSequence(0, this.bdm));
                this.bdg.setSelection(this.bdg.getText().length());
                return;
            }
            this.bdg.setText(charSequence);
            if (i <= charSequence.length()) {
                this.bdg.setSelection(i);
            } else {
                this.bdg.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KE() {
        if (this.bdc != null) {
            br selectInfo = this.bdc.getSelectInfo();
            if (this.bdg != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.bdg.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.bdg.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aKT == 7) {
                            this.bdg.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.bdg.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_barrage));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(boolean z) {
        if (z && this.bdj != null && !this.bdj.Ji()) {
            this.bdf.setChecked(false, false);
            return;
        }
        this.bdm = z ? 20 : 50;
        if (z && this.bdg != null && this.bdg.getText() != null && this.bdg.getText().length() > this.bdm) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.bdm)));
        }
        if (this.bdc != null) {
            if (z) {
                this.bdc.setData(d.JD().e(this.bdj != null && this.bdj.Jm(), this.bdj != null ? this.bdj.Jn() : 0), this.aON, 0);
                this.bdc.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.JD().JG())) {
                    this.bdc.setSelectId(d.JD().JG());
                } else {
                    this.bdc.setSelectPos(0);
                }
                if (this.bdd != null) {
                    this.bdd.setVisibility(0);
                }
                bU(true);
                this.bcY.setVisibility(8);
                KE();
                setQuickInputPanelVisible(false);
                if (this.bdq != null && this.bdq.getPageActivity() != null && this.bdg != null) {
                    BdUtilHelper.showSoftKeyPad(this.bdq.getPageActivity(), this.bdg);
                }
            } else {
                this.bdc.setSwitchStatus(false);
                if (this.bde != null) {
                    this.bde.setVisibility(8);
                }
                if (this.bdd != null) {
                    this.bdd.setVisibility(8);
                }
                if (!KB()) {
                    this.bcY.setVisibility(0);
                }
                if (this.bdg != null) {
                    this.bdg.setHint(a.i.sdk_im_sendmessage_to_host);
                }
            }
            if (this.bdj != null) {
                this.bdj.Jl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(boolean z) {
        if (z && this.bda != null) {
            this.bda.setPreview();
        }
        if (this.bda != null && this.bdc != null) {
            this.bda.setUIInfo(this.bdc.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.bde != null) {
                this.bde.setVisibility(8);
            }
        } else if (this.bdf != null && this.bdf.isChecked() && this.bde != null) {
            this.bde.setVisibility(0);
        }
    }

    private void s(String str, boolean z) {
        if (this.bdj != null) {
            this.bdj.r(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                if (this.bde != null) {
                    this.bde.setVisibility(8);
                }
            } else if (this.bdf != null && this.bdf.isChecked() && this.bde != null) {
                this.bde.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void KF() {
        if (this.bdg != null) {
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bdg.requestFocus();
                }
            });
        }
    }
}

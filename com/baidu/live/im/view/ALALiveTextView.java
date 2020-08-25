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
    private Map<String, Integer> aOL;
    private int aTd;
    public CustomMessageListener aVN;
    private FrameLayout bcW;
    private FrameLayout bcX;
    private b bcY;
    private com.baidu.live.im.d.a bcZ;
    private c bda;
    private FrameLayout bdb;
    private FrameLayout bdc;
    private Switch bdd;
    private EditText bde;
    private GradientEnableTextView bdf;
    private com.baidu.live.im.d.b bdg;
    private a.InterfaceC0199a bdh;
    private long bdi;
    private int bdj;
    private int bdk;
    private boolean bdl;
    private boolean bdm;
    private int bdn;
    private BdPageContext bdo;
    private int bdp;
    private String bdq;
    private int bdr;
    private AlaLiveInfoData bds;
    private boolean bdt;
    public CustomMessageListener bdu;
    private View.OnClickListener bdv;
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
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bcw == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bcx);
            }
            this.mDialog = new BdAlertDialog(this.bdo.getPageActivity());
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
            this.mDialog.create(this.bdo);
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
        String obj = this.bde.getText().toString();
        if (obj.length() > this.bdk) {
            obj = obj.subSequence(0, this.bdk).toString();
        }
        if (!TextUtils.isEmpty(obj.trim())) {
            if (currentTimeMillis - this.bdi >= 2000) {
                this.bdi = currentTimeMillis;
                this.bdt = false;
                s(obj, false);
            } else if (!this.bdt) {
                Toast.makeText(getContext(), a.i.ala_click_too_fast, 0).show();
                this.bdt = true;
            }
        }
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bdp = 0;
        this.bdt = false;
        this.handler = new Handler();
        this.bdu = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bdp == 3 || ALALiveTextView.this.bdp == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bdp == 3) {
                                    ALALiveTextView.this.Ks();
                                } else if (ALALiveTextView.this.bdp == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bdq, ALALiveTextView.this.bdr);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bdp = 0;
                    }
                }
            }
        };
        this.aVN = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bdv = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.w.a.Nk().beH.aHn == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beH.aHm == 1) {
                    if (ALALiveTextView.this.bdm) {
                        ALALiveTextView.this.bdp = 3;
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
            private CharSequence bdy;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bdy = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bdy, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bdp = 0;
        this.bdt = false;
        this.handler = new Handler();
        this.bdu = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bdp == 3 || ALALiveTextView.this.bdp == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bdp == 3) {
                                    ALALiveTextView.this.Ks();
                                } else if (ALALiveTextView.this.bdp == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bdq, ALALiveTextView.this.bdr);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bdp = 0;
                    }
                }
            }
        };
        this.aVN = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bdv = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.w.a.Nk().beH.aHn == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beH.aHm == 1) {
                    if (ALALiveTextView.this.bdm) {
                        ALALiveTextView.this.bdp = 3;
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
            private CharSequence bdy;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bdy = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bdy, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.bdo = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdp = 0;
        this.bdt = false;
        this.handler = new Handler();
        this.bdu = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bdp == 3 || ALALiveTextView.this.bdp == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bdp == 3) {
                                    ALALiveTextView.this.Ks();
                                } else if (ALALiveTextView.this.bdp == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bdq, ALALiveTextView.this.bdr);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bdp = 0;
                    }
                }
            }
        };
        this.aVN = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bdv = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.w.a.Nk().beH.aHn == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beH.aHm == 1) {
                    if (ALALiveTextView.this.bdm) {
                        ALALiveTextView.this.bdp = 3;
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
            private CharSequence bdy;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bdy = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bdy, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdp = 0;
        this.bdt = false;
        this.handler = new Handler();
        this.bdu = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bdp == 3 || ALALiveTextView.this.bdp == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bdp == 3) {
                                    ALALiveTextView.this.Ks();
                                } else if (ALALiveTextView.this.bdp == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bdq, ALALiveTextView.this.bdr);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bdp = 0;
                    }
                }
            }
        };
        this.aVN = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bdv = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.w.a.Nk().beH.aHn == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beH.aHm == 1) {
                    if (ALALiveTextView.this.bdm) {
                        ALALiveTextView.this.bdp = 3;
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
            private CharSequence bdy;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.bdy = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.bdy, i2);
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
        this.bdk = 50;
    }

    private void Kt() {
        this.bdd = (Switch) findViewById(a.g.switch_barrage);
        this.bdb = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        this.bdc = (FrameLayout) findViewById(a.g.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bdo);
        if (runTask != null) {
            this.bda = (c) runTask.getData();
        }
        if (this.bda != null) {
            this.bdb.addView(this.bda.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, b.class, this.bdo);
        if (runTask2 != null) {
            this.bcY = (b) runTask2.getData();
        }
        if (this.bcY != null) {
            this.bdc.addView(this.bcY.getView());
        }
        if (this.bda != null) {
            this.bda.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.13
                @Override // com.baidu.live.im.b.e
                public boolean JJ() {
                    return ALALiveTextView.this.bdh != null && ALALiveTextView.this.bdh.Jm();
                }

                @Override // com.baidu.live.im.b.e
                public void dY(int i) {
                    ALALiveTextView.this.KE();
                    ALALiveTextView.this.bU(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Jn() {
                    if (ALALiveTextView.this.bdh != null) {
                        return ALALiveTextView.this.bdh.Jn();
                    }
                    return 0;
                }
            });
        }
        this.bdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.bT(z);
            }
        });
    }

    private void Ku() {
        this.bde = (EditText) findViewById(a.g.edit_text);
        this.bde.addTextChangedListener(this.mTextWatcher);
        this.bde.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    ALALiveTextView.this.Ks();
                    return true;
                }
                return false;
            }
        });
        this.bdf = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.bdf.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.bde, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.bde, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.bdf.setOnClickListener(this.bdv);
        this.bdf.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bdm = z;
        this.bdn = i;
        this.aTd = i2;
        this.mUserName = str;
    }

    private void Kv() {
        this.bcW = (FrameLayout) findViewById(a.g.quick_input_header);
        this.bcX = (FrameLayout) findViewById(a.g.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, com.baidu.live.im.d.b.class, this.bdo);
        if (runTask != null) {
            this.bdg = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.bdg != null) {
            this.bcX.addView(this.bdg.getView());
            this.bdg.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void C(String str, int i) {
                    if (com.baidu.live.w.a.Nk().beH.aHn == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.w.a.Nk().beH.aHm == 1) {
                        if (ALALiveTextView.this.bdm) {
                            ALALiveTextView.this.bdq = str;
                            ALALiveTextView.this.bdr = i;
                            ALALiveTextView.this.bdp = 4;
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
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.bdo);
        if (runTask2 != null) {
            this.bcZ = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.bcZ != null) {
            this.bcW.addView(this.bcZ.getView());
            this.bcZ.setCallback(new a.InterfaceC0176a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0176a
                public void C(String str, int i) {
                    if (com.baidu.live.w.a.Nk().beH.aHn == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.w.a.Nk().beH.aHm == 1) {
                        if (ALALiveTextView.this.bdm) {
                            ALALiveTextView.this.bdq = str;
                            ALALiveTextView.this.bdr = i;
                            ALALiveTextView.this.bdp = 4;
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
                    if (ALALiveTextView.this.bdh != null) {
                        ALALiveTextView.this.bdh.Jk();
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
        this.bdl = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Kw() {
        return this.bdd != null && this.bdd.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean Kx() {
        return !KB() && this.bcW.getVisibility() == 0;
    }

    public br getBarrageInfo() {
        if (this.bda != null) {
            return this.bda.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.bde.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0199a interfaceC0199a) {
        this.bdh = interfaceC0199a;
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

    public void gT(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ky() {
        return getView().getVisibility() == 0 && this.bcX.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.bcX.setVisibility(0);
            if (this.bdj < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.bdg != null) {
                    this.bdg.Kf();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcX.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.bcX.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.bcX.setVisibility(8);
        if (this.bde != null) {
            this.bde.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Kz() {
        if (this.bde != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.bde);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.bdj - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bdo = bdPageContext;
    }

    public void KA() {
        this.bde.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.bde.getSelectionStart();
            Editable editableText = this.bde.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.bde.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.bds = alaLiveInfoData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aOL = map;
        KD();
        this.bde.requestFocus();
        if (this.bde != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bde.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.bde);
                }
            }, 50L);
        }
        boolean KB = KB();
        if (list == null || list.isEmpty() || KB) {
            if (this.bcZ != null) {
                this.bcZ.setData(list);
            }
            this.bcX.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.bcZ != null) {
            if (arrayList.size() >= 3) {
                this.bcZ.setData(arrayList.subList(0, 3));
            } else {
                this.bcZ.setData(arrayList);
            }
        }
        this.bcW.setVisibility(Kw() ? 8 : 0);
        this.bcX.setVisibility(0);
        if (this.bdg != null) {
            this.bdg.Ke();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bcX.getLayoutParams();
        layoutParams.height = -2;
        this.bcX.setLayoutParams(layoutParams);
        if (this.bdg != null) {
            this.bdg.setData(arrayList);
        }
        this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.bdj = ALALiveTextView.this.bcX.getHeight();
                ALALiveTextView.this.bcX.setVisibility(8);
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
        this.bde.clearFocus();
        if (this.bcY != null) {
            this.bcY.release();
        }
        setVisibility(8);
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.bda != null) {
            this.bda.f(map);
        }
    }

    private boolean KB() {
        return (this.bds == null || this.bds.mAlaLiveSwitchData == null || !this.bds.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean KC() {
        return (this.bds == null || this.bds.mAlaLiveSwitchData == null || !this.bds.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    private void KD() {
        if (this.bdl || KC()) {
            this.bdd.setVisibility(8);
            return;
        }
        final br[] e = d.JD().e(this.bdh != null && this.bdh.Jm(), this.bdh != null ? this.bdh.Jn() : 0);
        if (e == null || e.length <= 0) {
            if (this.bdd.isChecked()) {
                this.bdd.setChecked(false, false);
            } else {
                bT(false);
            }
            this.bdd.setVisibility(8);
            return;
        }
        this.bdd.setVisibility(0);
        if (this.bda != null) {
            if (this.bda.getView().getWidth() <= 0) {
                this.bdb.setVisibility(0);
            }
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.JD().JF()) {
                        ALALiveTextView.this.bda.setData(e, ALALiveTextView.this.aOL, 0);
                        if (ALALiveTextView.this.bdd.isChecked()) {
                            ALALiveTextView.this.bda.setSelectId(d.JD().JG());
                            ALALiveTextView.this.KE();
                            ALALiveTextView.this.bU(true);
                        } else {
                            ALALiveTextView.this.bdd.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.bdd.isChecked()) {
                        ALALiveTextView.this.bdd.setChecked(false, false);
                    }
                    ALALiveTextView.this.bdb.setVisibility(ALALiveTextView.this.bdd.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.bdf != null) {
            if (TextUtils.isEmpty(this.bde.getText())) {
                this.bdf.setEnabled(false);
            } else {
                this.bdf.setEnabled(true);
                this.bdf.setClickable(true);
            }
        }
        if (this.bde.getText().length() > this.bdk) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.bdk)));
            if (charSequence.length() > this.bdk) {
                this.bde.setText(charSequence.subSequence(0, this.bdk));
                this.bde.setSelection(this.bde.getText().length());
                return;
            }
            this.bde.setText(charSequence);
            if (i <= charSequence.length()) {
                this.bde.setSelection(i);
            } else {
                this.bde.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KE() {
        if (this.bda != null) {
            br selectInfo = this.bda.getSelectInfo();
            if (this.bde != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.bde.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.bde.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aKR == 7) {
                            this.bde.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.bde.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_barrage));
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
        if (z && this.bdh != null && !this.bdh.Ji()) {
            this.bdd.setChecked(false, false);
            return;
        }
        this.bdk = z ? 20 : 50;
        if (z && this.bde != null && this.bde.getText() != null && this.bde.getText().length() > this.bdk) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.bdk)));
        }
        if (this.bda != null) {
            if (z) {
                this.bda.setData(d.JD().e(this.bdh != null && this.bdh.Jm(), this.bdh != null ? this.bdh.Jn() : 0), this.aOL, 0);
                this.bda.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.JD().JG())) {
                    this.bda.setSelectId(d.JD().JG());
                } else {
                    this.bda.setSelectPos(0);
                }
                if (this.bdb != null) {
                    this.bdb.setVisibility(0);
                }
                bU(true);
                this.bcW.setVisibility(8);
                KE();
                setQuickInputPanelVisible(false);
                if (this.bdo != null && this.bdo.getPageActivity() != null && this.bde != null) {
                    BdUtilHelper.showSoftKeyPad(this.bdo.getPageActivity(), this.bde);
                }
            } else {
                this.bda.setSwitchStatus(false);
                if (this.bdc != null) {
                    this.bdc.setVisibility(8);
                }
                if (this.bdb != null) {
                    this.bdb.setVisibility(8);
                }
                if (!KB()) {
                    this.bcW.setVisibility(0);
                }
                if (this.bde != null) {
                    this.bde.setHint(a.i.sdk_im_sendmessage_to_host);
                }
            }
            if (this.bdh != null) {
                this.bdh.Jl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(boolean z) {
        if (z && this.bcY != null) {
            this.bcY.setPreview();
        }
        if (this.bcY != null && this.bda != null) {
            this.bcY.setUIInfo(this.bda.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.bdc != null) {
                this.bdc.setVisibility(8);
            }
        } else if (this.bdd != null && this.bdd.isChecked() && this.bdc != null) {
            this.bdc.setVisibility(0);
        }
    }

    private void s(String str, boolean z) {
        if (this.bdh != null) {
            this.bdh.r(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                if (this.bdc != null) {
                    this.bdc.setVisibility(8);
                }
            } else if (this.bdd != null && this.bdd.isChecked() && this.bdc != null) {
                this.bdc.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void KF() {
        if (this.bde != null) {
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bde.requestFocus();
                }
            });
        }
    }
}

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
    private Map<String, Integer> aWC;
    private int bbu;
    public CustomMessageListener bek;
    private EditText bmA;
    private GradientEnableTextView bmB;
    private b bmC;
    private a.InterfaceC0232a bmD;
    private long bmE;
    private int bmF;
    private int bmG;
    private boolean bmH;
    private boolean bmI;
    private int bmJ;
    private BdPageContext bmK;
    private int bmL;
    private String bmM;
    private int bmN;
    private AlaLiveInfoData bmO;
    private boolean bmP;
    public CustomMessageListener bmQ;
    private View.OnClickListener bmR;
    private FrameLayout bms;
    private FrameLayout bmt;
    private com.baidu.live.im.b.b bmu;
    private com.baidu.live.im.d.a bmv;
    private c bmw;
    private FrameLayout bmx;
    private FrameLayout bmy;
    private Switch bmz;
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
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.blL == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.blM);
            }
            this.mDialog = new BdAlertDialog(this.bmK.getPageActivity());
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
            this.mDialog.create(this.bmK);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MY() {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.bmA.getText().toString();
        if (obj.length() > this.bmG) {
            obj = obj.subSequence(0, this.bmG).toString();
        }
        if (!TextUtils.isEmpty(obj.trim())) {
            if (currentTimeMillis - this.bmE >= 2000) {
                this.bmE = currentTimeMillis;
                this.bmP = false;
                t(obj, false);
            } else if (!this.bmP) {
                Toast.makeText(getContext(), a.h.ala_click_too_fast, 0).show();
                this.bmP = true;
            }
        }
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bmL = 0;
        this.bmP = false;
        this.handler = new Handler();
        this.bmQ = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bmL == 3 || ALALiveTextView.this.bmL == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bmL == 3) {
                                    ALALiveTextView.this.MY();
                                } else if (ALALiveTextView.this.bmL == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bmM, ALALiveTextView.this.bmN);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bmL = 0;
                    }
                }
            }
        };
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bmR = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.aa.a.PQ().bod.aNo == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                    if (ALALiveTextView.this.bmI) {
                        ALALiveTextView.this.bmL = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.MY();
                } else {
                    ALALiveTextView.this.MY();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bmU;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bmU = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bmU, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bmL = 0;
        this.bmP = false;
        this.handler = new Handler();
        this.bmQ = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bmL == 3 || ALALiveTextView.this.bmL == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bmL == 3) {
                                    ALALiveTextView.this.MY();
                                } else if (ALALiveTextView.this.bmL == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bmM, ALALiveTextView.this.bmN);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bmL = 0;
                    }
                }
            }
        };
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bmR = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.aa.a.PQ().bod.aNo == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                    if (ALALiveTextView.this.bmI) {
                        ALALiveTextView.this.bmL = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.MY();
                } else {
                    ALALiveTextView.this.MY();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bmU;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bmU = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bmU, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.bmK = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bmL = 0;
        this.bmP = false;
        this.handler = new Handler();
        this.bmQ = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bmL == 3 || ALALiveTextView.this.bmL == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bmL == 3) {
                                    ALALiveTextView.this.MY();
                                } else if (ALALiveTextView.this.bmL == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bmM, ALALiveTextView.this.bmN);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bmL = 0;
                    }
                }
            }
        };
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bmR = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.aa.a.PQ().bod.aNo == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                    if (ALALiveTextView.this.bmI) {
                        ALALiveTextView.this.bmL = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.MY();
                } else {
                    ALALiveTextView.this.MY();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bmU;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bmU = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bmU, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bmL = 0;
        this.bmP = false;
        this.handler = new Handler();
        this.bmQ = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bmL == 3 || ALALiveTextView.this.bmL == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bmL == 3) {
                                    ALALiveTextView.this.MY();
                                } else if (ALALiveTextView.this.bmL == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bmM, ALALiveTextView.this.bmN);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bmL = 0;
                    }
                }
            }
        };
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bmR = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.aa.a.PQ().bod.aNo == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                    if (ALALiveTextView.this.bmI) {
                        ALALiveTextView.this.bmL = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.MY();
                } else {
                    ALALiveTextView.this.MY();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bmU;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.bmU = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.bmU, i2);
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
        MZ();
        Na();
        Nb();
        this.bmG = 50;
    }

    private void MZ() {
        this.bmz = (Switch) findViewById(a.f.switch_barrage);
        this.bmx = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        this.bmy = (FrameLayout) findViewById(a.f.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bmK);
        if (runTask != null) {
            this.bmw = (c) runTask.getData();
        }
        if (this.bmw != null) {
            this.bmx.addView(this.bmw.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bmK);
        if (runTask2 != null) {
            this.bmu = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bmu != null) {
            this.bmy.addView(this.bmu.getView());
        }
        if (this.bmw != null) {
            this.bmw.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.13
                @Override // com.baidu.live.im.b.e
                public boolean Mn() {
                    return ALALiveTextView.this.bmD != null && ALALiveTextView.this.bmD.LQ();
                }

                @Override // com.baidu.live.im.b.e
                public void ei(int i) {
                    ALALiveTextView.this.Nk();
                    ALALiveTextView.this.cc(false);
                }

                @Override // com.baidu.live.im.b.e
                public int LR() {
                    if (ALALiveTextView.this.bmD != null) {
                        return ALALiveTextView.this.bmD.LR();
                    }
                    return 0;
                }
            });
        }
        this.bmz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.cb(z);
            }
        });
    }

    private void Na() {
        this.bmA = (EditText) findViewById(a.f.edit_text);
        this.bmA.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    ALALiveTextView.this.MY();
                    return true;
                }
                return false;
            }
        });
        this.bmB = (GradientEnableTextView) findViewById(a.f.tv_send);
        this.bmB.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.bmA, Integer.valueOf(a.e.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.bmA, Integer.valueOf(a.e.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.bmB.setOnClickListener(this.bmR);
        this.bmB.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bmI = z;
        this.bmJ = i;
        this.bbu = i2;
        this.mUserName = str;
    }

    private void Nb() {
        this.bms = (FrameLayout) findViewById(a.f.quick_input_header);
        this.bmt = (FrameLayout) findViewById(a.f.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, b.class, this.bmK);
        if (runTask != null) {
            this.bmC = (b) runTask.getData();
        }
        if (this.bmC != null) {
            this.bmt.addView(this.bmC.getView());
            this.bmC.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void C(String str, int i) {
                    if (com.baidu.live.aa.a.PQ().bod.aNo == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                        if (ALALiveTextView.this.bmI) {
                            ALALiveTextView.this.bmM = str;
                            ALALiveTextView.this.bmN = i;
                            ALALiveTextView.this.bmL = 4;
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
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.bmK);
        if (runTask2 != null) {
            this.bmv = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.bmv != null) {
            this.bms.addView(this.bmv.getView());
            this.bmv.setCallback(new a.InterfaceC0189a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0189a
                public void C(String str, int i) {
                    if (com.baidu.live.aa.a.PQ().bod.aNo == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                        if (ALALiveTextView.this.bmI) {
                            ALALiveTextView.this.bmM = str;
                            ALALiveTextView.this.bmN = i;
                            ALALiveTextView.this.bmL = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.D(str, i);
                    } else {
                        ALALiveTextView.this.D(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0189a
                public void MJ() {
                    if (ALALiveTextView.this.bmD != null) {
                        ALALiveTextView.this.bmD.LO();
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
        this.bmH = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Nc() {
        return this.bmz != null && this.bmz.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean Nd() {
        return !Nh() && this.bms.getVisibility() == 0;
    }

    public cg getBarrageInfo() {
        if (this.bmw != null) {
            return this.bmw.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.bmA.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0232a interfaceC0232a) {
        this.bmD = interfaceC0232a;
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

    public void hM(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ne() {
        return getView().getVisibility() == 0 && this.bmt.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.bmt.setVisibility(0);
            if (this.bmF < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.bmC != null) {
                    this.bmC.ML();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmt.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.bmt.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.bmt.setVisibility(8);
        if (this.bmA != null) {
            this.bmA.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Nf() {
        if (this.bmA != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.bmA);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.bmF - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bmK = bdPageContext;
    }

    public void Ng() {
        this.bmA.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.bmA.getSelectionStart();
            Editable editableText = this.bmA.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.bmA.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.bmO = alaLiveInfoData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aWC = map;
        Nj();
        this.bmA.requestFocus();
        if (this.bmA != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bmA.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.bmA);
                }
            }, 50L);
        }
        boolean Nh = Nh();
        if (list == null || list.isEmpty() || Nh) {
            if (this.bmv != null) {
                this.bmv.setData(list);
            }
            this.bmt.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.bmv != null) {
            if (arrayList.size() >= 3) {
                this.bmv.setData(arrayList.subList(0, 3));
            } else {
                this.bmv.setData(arrayList);
            }
        }
        this.bms.setVisibility(Nc() ? 8 : 0);
        this.bmt.setVisibility(0);
        if (this.bmC != null) {
            this.bmC.MK();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmt.getLayoutParams();
        layoutParams.height = -2;
        this.bmt.setLayoutParams(layoutParams);
        if (this.bmC != null) {
            this.bmC.setData(arrayList);
        }
        this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.bmF = ALALiveTextView.this.bmt.getHeight();
                ALALiveTextView.this.bmt.setVisibility(8);
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
        this.bmA.clearFocus();
        if (this.bmu != null) {
            this.bmu.release();
        }
        setVisibility(8);
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.bmw != null) {
            this.bmw.f(map);
        }
    }

    private boolean Nh() {
        return (this.bmO == null || this.bmO.mAlaLiveSwitchData == null || !this.bmO.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean Ni() {
        return (this.bmO == null || this.bmO.mAlaLiveSwitchData == null || !this.bmO.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    private void Nj() {
        if (this.bmH || Ni()) {
            this.bmz.setVisibility(8);
            return;
        }
        final cg[] e = d.Mg().e(this.bmD != null && this.bmD.LQ(), this.bmD != null ? this.bmD.LR() : 0);
        if (e == null || e.length <= 0) {
            if (this.bmz.isChecked()) {
                this.bmz.setChecked(false, false);
            } else {
                cb(false);
            }
            this.bmz.setVisibility(8);
            return;
        }
        this.bmz.setVisibility(0);
        if (this.bmw != null) {
            if (this.bmw.getView().getWidth() <= 0) {
                this.bmx.setVisibility(0);
            }
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.Mg().Mj()) {
                        ALALiveTextView.this.bmw.setData(e, ALALiveTextView.this.aWC, 0);
                        if (ALALiveTextView.this.bmz.isChecked()) {
                            ALALiveTextView.this.bmw.setSelectId(d.Mg().Mk());
                            ALALiveTextView.this.Nk();
                            ALALiveTextView.this.cc(true);
                        } else {
                            ALALiveTextView.this.bmz.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.bmz.isChecked()) {
                        ALALiveTextView.this.bmz.setChecked(false, false);
                    }
                    ALALiveTextView.this.bmx.setVisibility(ALALiveTextView.this.bmz.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.bmB != null) {
            if (TextUtils.isEmpty(this.bmA.getText())) {
                this.bmB.setEnabled(false);
            } else {
                this.bmB.setEnabled(true);
                this.bmB.setClickable(true);
            }
        }
        if (this.bmA.getText().length() > this.bmG) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bmG)));
            if (charSequence.length() > this.bmG) {
                this.bmA.setText(charSequence.subSequence(0, this.bmG));
                this.bmA.setSelection(this.bmA.getText().length());
                return;
            }
            this.bmA.setText(charSequence);
            if (i <= charSequence.length()) {
                this.bmA.setSelection(i);
            } else {
                this.bmA.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nk() {
        if (this.bmw != null) {
            cg selectInfo = this.bmw.getSelectInfo();
            if (this.bmA != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.bmA.setHint(String.format(Locale.getDefault(), getResources().getString(a.h.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.bmA.setHint(getResources().getString(a.h.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aRr == 7) {
                            this.bmA.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.bmA.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_barrage));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(boolean z) {
        if (z && this.bmD != null && !this.bmD.LM()) {
            this.bmz.setChecked(false, false);
            return;
        }
        this.bmG = z ? 20 : 50;
        if (z && this.bmA != null && this.bmA.getText() != null && this.bmA.getText().length() > this.bmG) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bmG)));
        }
        if (this.bmw != null) {
            if (z) {
                this.bmw.setData(d.Mg().e(this.bmD != null && this.bmD.LQ(), this.bmD != null ? this.bmD.LR() : 0), this.aWC, 0);
                this.bmw.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Mg().Mk())) {
                    this.bmw.setSelectId(d.Mg().Mk());
                } else {
                    this.bmw.setSelectPos(0);
                }
                if (this.bmx != null) {
                    this.bmx.setVisibility(0);
                }
                cc(true);
                this.bms.setVisibility(8);
                Nk();
                setQuickInputPanelVisible(false);
                if (this.bmK != null && this.bmK.getPageActivity() != null && this.bmA != null) {
                    BdUtilHelper.showSoftKeyPad(this.bmK.getPageActivity(), this.bmA);
                }
            } else {
                this.bmw.setSwitchStatus(false);
                if (this.bmy != null) {
                    this.bmy.setVisibility(8);
                }
                if (this.bmx != null) {
                    this.bmx.setVisibility(8);
                }
                if (!Nh()) {
                    this.bms.setVisibility(0);
                }
                if (this.bmA != null) {
                    this.bmA.setHint(a.h.sdk_im_sendmessage_to_host);
                }
            }
            if (this.bmD != null) {
                this.bmD.LP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cc(boolean z) {
        if (z && this.bmu != null) {
            this.bmu.setPreview();
        }
        if (this.bmu != null && this.bmw != null) {
            this.bmu.setUIInfo(this.bmw.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.bmy != null) {
                this.bmy.setVisibility(8);
            }
        } else if (this.bmz != null && this.bmz.isChecked() && this.bmy != null) {
            this.bmy.setVisibility(0);
        }
    }

    private void t(String str, boolean z) {
        if (this.bmD != null) {
            this.bmD.s(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                if (this.bmy != null) {
                    this.bmy.setVisibility(8);
                }
            } else if (this.bmz != null && this.bmz.isChecked() && this.bmy != null) {
                this.bmy.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Nl() {
        if (this.bmA != null) {
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bmA.requestFocus();
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bmA != null) {
            this.bmA.addTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bmA != null) {
            this.bmA.removeTextChangedListener(this.mTextWatcher);
        }
    }
}

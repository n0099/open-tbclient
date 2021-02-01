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
/* loaded from: classes11.dex */
public class ALALiveTextView extends LinearLayout implements com.baidu.live.view.input.a {
    private String aNS;
    private Map<String, Integer> aXY;
    private int bdk;
    public CustomMessageListener bgy;
    public CustomMessageListener boE;
    private int bqA;
    private int bqB;
    private boolean bqC;
    private boolean bqD;
    d bqE;
    private int bqF;
    private BdPageContext bqG;
    private int bqH;
    private String bqI;
    private boolean bqJ;
    private boolean bqK;
    private int bqL;
    private AlaLiveInfoData bqM;
    private boolean bqN;
    private View.OnClickListener bqO;
    private FrameLayout bqn;
    private FrameLayout bqo;
    private com.baidu.live.im.b.b bqp;
    private com.baidu.live.im.d.a bqq;
    private com.baidu.live.im.b.c bqr;
    private FrameLayout bqs;
    private FrameLayout bqt;
    private Switch bqu;
    private EditText bqv;
    private GradientEnableTextView bqw;
    private com.baidu.live.im.d.b bqx;
    private a.InterfaceC0232a bqy;
    private long bqz;
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
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bpt == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bpu);
            }
            this.mDialog = new BdAlertDialog(this.bqG.getPageActivity());
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
            this.mDialog.create(this.bqG);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LS() {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.bqv.getText().toString();
        if (obj.length() > this.bqB) {
            obj = obj.subSequence(0, this.bqB).toString();
        }
        if (!TextUtils.isEmpty(obj.trim())) {
            if (currentTimeMillis - this.bqz >= 2000) {
                this.bqz = currentTimeMillis;
                this.bqN = false;
                u(obj, false);
            } else if (!this.bqN) {
                Toast makeText = Toast.makeText(getContext(), (CharSequence) null, 0);
                makeText.setText(a.h.ala_click_too_fast);
                makeText.show();
                this.bqN = true;
            }
        }
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bqE = null;
        this.bqH = 0;
        this.bqJ = false;
        this.aNS = "";
        this.bqK = false;
        this.bqN = false;
        this.handler = new Handler();
        this.boE = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqH == 3 || ALALiveTextView.this.bqH == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bqH == 3) {
                                    ALALiveTextView.this.LS();
                                } else if (ALALiveTextView.this.bqH == 4) {
                                    ALALiveTextView.this.I(ALALiveTextView.this.bqI, ALALiveTextView.this.bqL);
                                }
                            } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                                ALALiveTextView.this.a(imForbiddenStateData);
                                imForbiddenStateData.hasShowForbiddenToast = true;
                            }
                        }
                        ALALiveTextView.this.bqH = 0;
                    }
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqO = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                    if (ALALiveTextView.this.bqD) {
                        ALALiveTextView.this.bqH = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.LS();
                } else {
                    ALALiveTextView.this.LS();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bqT;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bqT = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bqT, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bqE = null;
        this.bqH = 0;
        this.bqJ = false;
        this.aNS = "";
        this.bqK = false;
        this.bqN = false;
        this.handler = new Handler();
        this.boE = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqH == 3 || ALALiveTextView.this.bqH == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bqH == 3) {
                                    ALALiveTextView.this.LS();
                                } else if (ALALiveTextView.this.bqH == 4) {
                                    ALALiveTextView.this.I(ALALiveTextView.this.bqI, ALALiveTextView.this.bqL);
                                }
                            } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                                ALALiveTextView.this.a(imForbiddenStateData);
                                imForbiddenStateData.hasShowForbiddenToast = true;
                            }
                        }
                        ALALiveTextView.this.bqH = 0;
                    }
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqO = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                    if (ALALiveTextView.this.bqD) {
                        ALALiveTextView.this.bqH = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.LS();
                } else {
                    ALALiveTextView.this.LS();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bqT;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bqT = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bqT, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.bqG = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqE = null;
        this.bqH = 0;
        this.bqJ = false;
        this.aNS = "";
        this.bqK = false;
        this.bqN = false;
        this.handler = new Handler();
        this.boE = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqH == 3 || ALALiveTextView.this.bqH == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bqH == 3) {
                                    ALALiveTextView.this.LS();
                                } else if (ALALiveTextView.this.bqH == 4) {
                                    ALALiveTextView.this.I(ALALiveTextView.this.bqI, ALALiveTextView.this.bqL);
                                }
                            } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                                ALALiveTextView.this.a(imForbiddenStateData);
                                imForbiddenStateData.hasShowForbiddenToast = true;
                            }
                        }
                        ALALiveTextView.this.bqH = 0;
                    }
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqO = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                    if (ALALiveTextView.this.bqD) {
                        ALALiveTextView.this.bqH = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.LS();
                } else {
                    ALALiveTextView.this.LS();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bqT;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bqT = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bqT, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqE = null;
        this.bqH = 0;
        this.bqJ = false;
        this.aNS = "";
        this.bqK = false;
        this.bqN = false;
        this.handler = new Handler();
        this.boE = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqH == 3 || ALALiveTextView.this.bqH == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bqH == 3) {
                                    ALALiveTextView.this.LS();
                                } else if (ALALiveTextView.this.bqH == 4) {
                                    ALALiveTextView.this.I(ALALiveTextView.this.bqI, ALALiveTextView.this.bqL);
                                }
                            } else if (!imForbiddenStateData.hasShowForbiddenToast) {
                                ALALiveTextView.this.a(imForbiddenStateData);
                                imForbiddenStateData.hasShowForbiddenToast = true;
                            }
                        }
                        ALALiveTextView.this.bqH = 0;
                    }
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqO = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                    if (ALALiveTextView.this.bqD) {
                        ALALiveTextView.this.bqH = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.LS();
                } else {
                    ALALiveTextView.this.LS();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            private CharSequence bqT;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.bqT = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.bqT, i2);
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
        LT();
        LU();
        LV();
        this.bqB = 50;
    }

    private void LT() {
        this.bqu = (Switch) findViewById(a.f.switch_barrage);
        this.bqs = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        this.bqt = (FrameLayout) findViewById(a.f.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, com.baidu.live.im.b.c.class, this.bqG);
        if (runTask != null) {
            this.bqr = (com.baidu.live.im.b.c) runTask.getData();
        }
        if (this.bqr != null) {
            this.bqs.addView(this.bqr.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, com.baidu.live.im.b.b.class, this.bqG);
        if (runTask2 != null) {
            this.bqp = (com.baidu.live.im.b.b) runTask2.getData();
        }
        if (this.bqp != null) {
            this.bqt.addView(this.bqp.getView());
        }
        if (this.bqr != null) {
            this.bqr.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.16
                @Override // com.baidu.live.im.b.e
                public boolean KW() {
                    return ALALiveTextView.this.bqy != null && ALALiveTextView.this.bqy.Km();
                }

                @Override // com.baidu.live.im.b.e
                public void dB(int i) {
                    ALALiveTextView.this.Me();
                    ALALiveTextView.this.cv(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Kn() {
                    if (ALALiveTextView.this.bqy != null) {
                        return ALALiveTextView.this.bqy.Kn();
                    }
                    return 0;
                }
            });
        }
        this.bqu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.17
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.cu(z);
            }
        });
    }

    private void LU() {
        this.bqv = (EditText) findViewById(a.f.edit_text);
        this.bqv.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.18
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    ALALiveTextView.this.LS();
                    return true;
                }
                return false;
            }
        });
        this.bqw = (GradientEnableTextView) findViewById(a.f.tv_send);
        this.bqw.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.bqv, Integer.valueOf(a.e.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.bqv, Integer.valueOf(a.e.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.bqw.setOnClickListener(this.bqO);
        this.bqw.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bqD = z;
        this.bqF = i;
        this.bdk = i2;
        this.mUserName = str;
    }

    private void LV() {
        this.bqn = (FrameLayout) findViewById(a.f.quick_input_header);
        this.bqo = (FrameLayout) findViewById(a.f.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, com.baidu.live.im.d.b.class, this.bqG);
        if (runTask != null) {
            this.bqx = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.bqx != null) {
            this.bqo.addView(this.bqx.getView());
            this.bqx.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void H(String str, int i) {
                    if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                        if (ALALiveTextView.this.bqD) {
                            ALALiveTextView.this.bqI = str;
                            ALALiveTextView.this.bqL = i;
                            ALALiveTextView.this.bqH = 4;
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
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.bqG);
        if (runTask2 != null) {
            this.bqq = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.bqq != null) {
            this.bqn.addView(this.bqq.getView());
            this.bqq.setCallback(new a.InterfaceC0180a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0180a
                public void H(String str, int i) {
                    if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                        if (ALALiveTextView.this.bqD) {
                            ALALiveTextView.this.bqI = str;
                            ALALiveTextView.this.bqL = i;
                            ALALiveTextView.this.bqH = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.I(str, i);
                    } else {
                        ALALiveTextView.this.I(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0180a
                public void LF() {
                    if (ALALiveTextView.this.bqy != null) {
                        ALALiveTextView.this.bqy.Kj();
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
        this.bqC = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean LW() {
        return this.bqu != null && this.bqu.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean LX() {
        return !Mb() && this.bqn.getVisibility() == 0;
    }

    public cr getBarrageInfo() {
        if (this.bqr != null) {
            return this.bqr.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.bqv.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0232a interfaceC0232a) {
        this.bqy = interfaceC0232a;
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

    public void hi(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean LY() {
        return getView().getVisibility() == 0 && this.bqo.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.bqo.setVisibility(0);
            if (this.bqA < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.bqx != null) {
                    this.bqx.LH();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bqo.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.bqo.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.bqo.setVisibility(8);
        if (this.bqv != null) {
            this.bqv.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void LZ() {
        if (this.bqv != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.bqv);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.bqA - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bqG = bdPageContext;
    }

    @Override // com.baidu.live.view.input.a
    public void Ma() {
        this.bqv.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.bqv.getSelectionStart();
            Editable editableText = this.bqv.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.bqv.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.bqM = alaLiveInfoData;
        if (this.bqJ) {
            this.bqn.setVisibility(8);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aXY = map;
        Md();
        this.bqv.requestFocus();
        if (this.bqv != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bqv.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.bqv);
                }
            }, 50L);
        }
        boolean Mb = Mb();
        if (list == null || list.isEmpty() || Mb) {
            if (this.bqq != null) {
                this.bqq.setData(list);
            }
            this.bqo.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.bqq != null) {
            if (arrayList.size() >= 3) {
                this.bqq.setData(arrayList.subList(0, 3));
            } else {
                this.bqq.setData(arrayList);
            }
        }
        this.bqn.setVisibility(LW() ? 8 : 0);
        this.bqo.setVisibility(0);
        if (this.bqx != null) {
            this.bqx.LG();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bqo.getLayoutParams();
        layoutParams.height = -2;
        this.bqo.setLayoutParams(layoutParams);
        if (this.bqx != null) {
            this.bqx.setData(arrayList);
        }
        this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.bqA = ALALiveTextView.this.bqo.getHeight();
                ALALiveTextView.this.bqo.setVisibility(8);
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
        this.bqv.clearFocus();
        if (this.bqp != null) {
            this.bqp.release();
        }
        setVisibility(8);
        this.bqJ = false;
        this.bqK = false;
    }

    @Override // com.baidu.live.view.input.a
    public void destroy() {
        if (this.bqE != null) {
            this.bqE.OH();
            this.bqE = null;
        }
    }

    @Override // com.baidu.live.view.input.a
    public View getTextView() {
        if (this.bqv == null) {
            return null;
        }
        return this.bqv;
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.bqr != null) {
            this.bqr.f(map);
        }
    }

    private boolean Mb() {
        return (this.bqM == null || this.bqM.mAlaLiveSwitchData == null || !this.bqM.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean Mc() {
        return (this.bqM == null || this.bqM.mAlaLiveSwitchData == null || !this.bqM.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    private void Md() {
        if (this.bqC || Mc()) {
            this.bqu.setVisibility(8);
            return;
        }
        final cr[] b2 = com.baidu.live.im.b.d.KN().b(this.bqy != null && this.bqy.Km(), this.bqy != null ? this.bqy.Kn() : 0, this.bqy != null ? this.bqy.Ko() : false);
        if (b2 == null || b2.length <= 0) {
            if (this.bqu.isChecked()) {
                this.bqu.setChecked(false, false);
            } else {
                cu(false);
            }
            this.bqu.setVisibility(8);
            return;
        }
        this.bqu.setVisibility(0);
        if (this.bqr != null) {
            if (this.bqr.getView().getWidth() <= 0) {
                this.bqs.setVisibility(0);
            }
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.live.im.b.d.KN().KQ()) {
                        ALALiveTextView.this.bqr.setData(b2, ALALiveTextView.this.aXY, 0);
                        if (ALALiveTextView.this.bqu.isChecked()) {
                            ALALiveTextView.this.bqr.setSelectId(com.baidu.live.im.b.d.KN().KR());
                            ALALiveTextView.this.Me();
                            ALALiveTextView.this.cv(true);
                        } else {
                            ALALiveTextView.this.bqu.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.bqu.isChecked()) {
                        ALALiveTextView.this.bqu.setChecked(false, false);
                    }
                    ALALiveTextView.this.bqs.setVisibility(ALALiveTextView.this.bqu.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.bqw != null) {
            if (TextUtils.isEmpty(this.bqv.getText())) {
                this.bqw.setEnabled(false);
            } else {
                this.bqw.setEnabled(true);
                this.bqw.setClickable(true);
            }
        }
        if (this.bqv.getText().length() > this.bqB) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bqB)));
            if (charSequence.length() > this.bqB) {
                this.bqv.setText(charSequence.subSequence(0, this.bqB));
                this.bqv.setSelection(this.bqv.getText().length());
                return;
            }
            this.bqv.setText(charSequence);
            if (i <= charSequence.length()) {
                this.bqv.setSelection(i);
            } else {
                this.bqv.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Me() {
        if (this.bqr != null) {
            cr selectInfo = this.bqr.getSelectInfo();
            if (this.bqv != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.bqv.setHint(String.format(Locale.getDefault(), getResources().getString(a.h.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.bqv.setHint(getResources().getString(a.h.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aRV == 7) {
                            this.bqv.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.bqv.setHint(getResources().getString(a.h.sdk_im_sendmessage_noble_barrage));
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
        if (z && this.bqy != null && !this.bqy.Kh()) {
            this.bqu.setChecked(false, false);
            return;
        }
        this.bqB = z ? 20 : 50;
        if (z && this.bqv != null && this.bqv.getText() != null && this.bqv.getText().length() > this.bqB) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bqB)));
        }
        if (this.bqr != null) {
            if (z) {
                this.bqr.setData(com.baidu.live.im.b.d.KN().b(this.bqy != null && this.bqy.Km(), this.bqy != null ? this.bqy.Kn() : 0, this.bqy != null ? this.bqy.Ko() : false), this.aXY, 0);
                this.bqr.setSwitchStatus(true);
                if (!TextUtils.isEmpty(com.baidu.live.im.b.d.KN().KR())) {
                    this.bqr.setSelectId(com.baidu.live.im.b.d.KN().KR());
                } else {
                    this.bqr.setSelectPos(0);
                }
                if (this.bqs != null) {
                    this.bqs.setVisibility(0);
                }
                cv(true);
                this.bqn.setVisibility(8);
                Me();
                setQuickInputPanelVisible(false);
                if (this.bqG != null && this.bqG.getPageActivity() != null && this.bqv != null) {
                    BdUtilHelper.showSoftKeyPad(this.bqG.getPageActivity(), this.bqv);
                }
            } else {
                this.bqr.setSwitchStatus(false);
                if (this.bqt != null) {
                    this.bqt.setVisibility(8);
                }
                if (this.bqs != null) {
                    this.bqs.setVisibility(8);
                }
                if (!Mb()) {
                    this.bqn.setVisibility(0);
                }
                if (this.bqv != null) {
                    this.bqv.setHint(a.h.sdk_im_sendmessage_to_host);
                }
            }
            if (this.bqy != null) {
                this.bqy.Kl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(boolean z) {
        if (z && this.bqp != null) {
            this.bqp.setPreview();
        }
        if (this.bqp != null && this.bqr != null) {
            this.bqp.setUIInfo(this.bqr.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.bqt != null) {
                this.bqt.setVisibility(8);
            }
        } else if (this.bqu != null && this.bqu.isChecked() && this.bqt != null) {
            this.bqt.setVisibility(0);
        }
    }

    private void u(String str, boolean z) {
        if (this.bqy != null) {
            this.bqy.t(str, z);
            if (this.bqJ && !z && !this.bqK) {
                if (this.bqE == null) {
                    this.bqE = new d();
                    this.bqE.setTaskId(8);
                    this.bqE.a(new d.b() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                        @Override // com.baidu.live.o.d.b
                        public void Mh() {
                            if (ALALiveTextView.this.handler != null && !TextUtils.isEmpty(ALALiveTextView.this.aNS) && ALALiveTextView.this.bqG != null && ALALiveTextView.this.bqG.getPageActivity() != null) {
                                ALALiveTextView.this.a(ALALiveTextView.this.handler, ALALiveTextView.this.bqG.getPageActivity(), ALALiveTextView.this.getContext().getString(a.h.sdk_daily_task_red_packet_finish_msg), ALALiveTextView.this.getContext().getString(a.h.sdk_daily_task_red_packet_finish_tip), ALALiveTextView.this.aNS, 5L);
                                ALALiveTextView.this.bqK = true;
                            }
                            ALALiveTextView.this.bqE.setTaskId(-1);
                        }

                        @Override // com.baidu.live.o.d.b
                        public void x(int i, String str2) {
                        }
                    });
                }
                this.bqE.dK(8);
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
                    BdUtilHelper.hideSoftKeyPad(ALALiveTextView.this.bqG.getPageActivity(), ALALiveTextView.this.bqv);
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aNS)) {
                        com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                        cVar.url = ALALiveTextView.this.aNS;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                        ALALiveTextView.this.Mf();
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
    public void Mf() {
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
                if (this.bqt != null) {
                    this.bqt.setVisibility(8);
                }
            } else if (this.bqu != null && this.bqu.isChecked() && this.bqt != null) {
                this.bqt.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Mg() {
        if (this.bqv != null) {
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.10
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bqv.requestFocus();
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bqv != null) {
            this.bqv.addTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bqv != null) {
            this.bqv.removeTextChangedListener(this.mTextWatcher);
        }
    }

    @Override // com.baidu.live.view.input.a
    public void setFromDailyTask(boolean z, String str) {
        this.bqJ = z;
        this.aNS = str;
    }
}

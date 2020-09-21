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
    private Map<String, Integer> aQP;
    private int aVt;
    public CustomMessageListener aYi;
    private FrameLayout bfN;
    private FrameLayout bfO;
    private b bfP;
    private com.baidu.live.im.d.a bfQ;
    private c bfR;
    private FrameLayout bfS;
    private FrameLayout bfT;
    private Switch bfU;
    private EditText bfV;
    private GradientEnableTextView bfW;
    private com.baidu.live.im.d.b bfX;
    private a.InterfaceC0199a bfY;
    private long bfZ;
    private int bga;
    private int bgb;
    private boolean bgc;
    private boolean bgd;
    private int bge;
    private BdPageContext bgf;
    private int bgg;
    private String bgh;
    private int bgi;
    private AlaLiveInfoData bgj;
    private boolean bgk;
    public CustomMessageListener bgl;
    private View.OnClickListener bgm;
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
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bfk == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bfl);
            }
            this.mDialog = new BdAlertDialog(this.bgf.getPageActivity());
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
            this.mDialog.create(this.bgf);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZ() {
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.bfV.getText().toString();
        if (obj.length() > this.bgb) {
            obj = obj.subSequence(0, this.bgb).toString();
        }
        if (!TextUtils.isEmpty(obj.trim())) {
            if (currentTimeMillis - this.bfZ >= 2000) {
                this.bfZ = currentTimeMillis;
                this.bgk = false;
                s(obj, false);
            } else if (!this.bgk) {
                Toast.makeText(getContext(), a.i.ala_click_too_fast, 0).show();
                this.bgk = true;
            }
        }
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bgg = 0;
        this.bgk = false;
        this.handler = new Handler();
        this.bgl = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bgg == 3 || ALALiveTextView.this.bgg == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bgg == 3) {
                                    ALALiveTextView.this.KZ();
                                } else if (ALALiveTextView.this.bgg == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bgh, ALALiveTextView.this.bgi);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bgg = 0;
                    }
                }
            }
        };
        this.aYi = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bgm = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.x.a.NN().bhy.aIG == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.NN().bhy.aIF == 1) {
                    if (ALALiveTextView.this.bgd) {
                        ALALiveTextView.this.bgg = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.KZ();
                } else {
                    ALALiveTextView.this.KZ();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bgp;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bgp = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bgp, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bgg = 0;
        this.bgk = false;
        this.handler = new Handler();
        this.bgl = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bgg == 3 || ALALiveTextView.this.bgg == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bgg == 3) {
                                    ALALiveTextView.this.KZ();
                                } else if (ALALiveTextView.this.bgg == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bgh, ALALiveTextView.this.bgi);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bgg = 0;
                    }
                }
            }
        };
        this.aYi = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bgm = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.x.a.NN().bhy.aIG == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.NN().bhy.aIF == 1) {
                    if (ALALiveTextView.this.bgd) {
                        ALALiveTextView.this.bgg = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.KZ();
                } else {
                    ALALiveTextView.this.KZ();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bgp;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bgp = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bgp, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.bgf = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bgg = 0;
        this.bgk = false;
        this.handler = new Handler();
        this.bgl = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bgg == 3 || ALALiveTextView.this.bgg == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bgg == 3) {
                                    ALALiveTextView.this.KZ();
                                } else if (ALALiveTextView.this.bgg == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bgh, ALALiveTextView.this.bgi);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bgg = 0;
                    }
                }
            }
        };
        this.aYi = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bgm = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.x.a.NN().bhy.aIG == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.NN().bhy.aIF == 1) {
                    if (ALALiveTextView.this.bgd) {
                        ALALiveTextView.this.bgg = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.KZ();
                } else {
                    ALALiveTextView.this.KZ();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bgp;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bgp = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bgp, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bgg = 0;
        this.bgk = false;
        this.handler = new Handler();
        this.bgl = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bgg == 3 || ALALiveTextView.this.bgg == 4) {
                        if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                            ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                            if (imForbiddenStateData.errno != 0) {
                                BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                                return;
                            } else if (imForbiddenStateData.banState == 0) {
                                if (ALALiveTextView.this.bgg == 3) {
                                    ALALiveTextView.this.KZ();
                                } else if (ALALiveTextView.this.bgg == 4) {
                                    ALALiveTextView.this.D(ALALiveTextView.this.bgh, ALALiveTextView.this.bgi);
                                }
                            } else {
                                ALALiveTextView.this.a(imForbiddenStateData);
                            }
                        }
                        ALALiveTextView.this.bgg = 0;
                    }
                }
            }
        };
        this.aYi = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bgm = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.live.x.a.NN().bhy.aIG == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.NN().bhy.aIF == 1) {
                    if (ALALiveTextView.this.bgd) {
                        ALALiveTextView.this.bgg = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.KZ();
                } else {
                    ALALiveTextView.this.KZ();
                }
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence bgp;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.bgp = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.bgp, i2);
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
        La();
        Lb();
        Lc();
        this.bgb = 50;
    }

    private void La() {
        this.bfU = (Switch) findViewById(a.g.switch_barrage);
        this.bfS = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        this.bfT = (FrameLayout) findViewById(a.g.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.bgf);
        if (runTask != null) {
            this.bfR = (c) runTask.getData();
        }
        if (this.bfR != null) {
            this.bfS.addView(this.bfR.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, b.class, this.bgf);
        if (runTask2 != null) {
            this.bfP = (b) runTask2.getData();
        }
        if (this.bfP != null) {
            this.bfT.addView(this.bfP.getView());
        }
        if (this.bfR != null) {
            this.bfR.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.13
                @Override // com.baidu.live.im.b.e
                public boolean Kn() {
                    return ALALiveTextView.this.bfY != null && ALALiveTextView.this.bfY.JQ();
                }

                @Override // com.baidu.live.im.b.e
                public void ec(int i) {
                    ALALiveTextView.this.Ll();
                    ALALiveTextView.this.bW(false);
                }

                @Override // com.baidu.live.im.b.e
                public int JR() {
                    if (ALALiveTextView.this.bfY != null) {
                        return ALALiveTextView.this.bfY.JR();
                    }
                    return 0;
                }
            });
        }
        this.bfU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.bV(z);
            }
        });
    }

    private void Lb() {
        this.bfV = (EditText) findViewById(a.g.edit_text);
        this.bfV.addTextChangedListener(this.mTextWatcher);
        this.bfV.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    ALALiveTextView.this.KZ();
                    return true;
                }
                return false;
            }
        });
        this.bfW = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.bfW.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.bfV, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.bfV, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.bfW.setOnClickListener(this.bgm);
        this.bfW.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.bgd = z;
        this.bge = i;
        this.aVt = i2;
        this.mUserName = str;
    }

    private void Lc() {
        this.bfN = (FrameLayout) findViewById(a.g.quick_input_header);
        this.bfO = (FrameLayout) findViewById(a.g.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, com.baidu.live.im.d.b.class, this.bgf);
        if (runTask != null) {
            this.bfX = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.bfX != null) {
            this.bfO.addView(this.bfX.getView());
            this.bfX.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void C(String str, int i) {
                    if (com.baidu.live.x.a.NN().bhy.aIG == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.x.a.NN().bhy.aIF == 1) {
                        if (ALALiveTextView.this.bgd) {
                            ALALiveTextView.this.bgh = str;
                            ALALiveTextView.this.bgi = i;
                            ALALiveTextView.this.bgg = 4;
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
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.bgf);
        if (runTask2 != null) {
            this.bfQ = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.bfQ != null) {
            this.bfN.addView(this.bfQ.getView());
            this.bfQ.setCallback(new a.InterfaceC0178a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0178a
                public void C(String str, int i) {
                    if (com.baidu.live.x.a.NN().bhy.aIG == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.x.a.NN().bhy.aIF == 1) {
                        if (ALALiveTextView.this.bgd) {
                            ALALiveTextView.this.bgh = str;
                            ALALiveTextView.this.bgi = i;
                            ALALiveTextView.this.bgg = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.D(str, i);
                    } else {
                        ALALiveTextView.this.D(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0178a
                public void KK() {
                    if (ALALiveTextView.this.bfY != null) {
                        ALALiveTextView.this.bfY.JO();
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
        this.bgc = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ld() {
        return this.bfU != null && this.bfU.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean Le() {
        return !Li() && this.bfN.getVisibility() == 0;
    }

    public bz getBarrageInfo() {
        if (this.bfR != null) {
            return this.bfR.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.bfV.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0199a interfaceC0199a) {
        this.bfY = interfaceC0199a;
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

    public void hh(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Lf() {
        return getView().getVisibility() == 0 && this.bfO.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.bfO.setVisibility(0);
            if (this.bga < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.bfX != null) {
                    this.bfX.KM();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bfO.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.bfO.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.bfO.setVisibility(8);
        if (this.bfV != null) {
            this.bfV.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Lg() {
        if (this.bfV != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.bfV);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.bga - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bgf = bdPageContext;
    }

    public void Lh() {
        this.bfV.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.bfV.getSelectionStart();
            Editable editableText = this.bfV.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.bfV.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.bgj = alaLiveInfoData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aQP = map;
        Lk();
        this.bfV.requestFocus();
        if (this.bfV != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bfV.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.bfV);
                }
            }, 50L);
        }
        boolean Li = Li();
        if (list == null || list.isEmpty() || Li) {
            if (this.bfQ != null) {
                this.bfQ.setData(list);
            }
            this.bfO.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.bfQ != null) {
            if (arrayList.size() >= 3) {
                this.bfQ.setData(arrayList.subList(0, 3));
            } else {
                this.bfQ.setData(arrayList);
            }
        }
        this.bfN.setVisibility(Ld() ? 8 : 0);
        this.bfO.setVisibility(0);
        if (this.bfX != null) {
            this.bfX.KL();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bfO.getLayoutParams();
        layoutParams.height = -2;
        this.bfO.setLayoutParams(layoutParams);
        if (this.bfX != null) {
            this.bfX.setData(arrayList);
        }
        this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.bga = ALALiveTextView.this.bfO.getHeight();
                ALALiveTextView.this.bfO.setVisibility(8);
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
        this.bfV.clearFocus();
        if (this.bfP != null) {
            this.bfP.release();
        }
        setVisibility(8);
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.bfR != null) {
            this.bfR.f(map);
        }
    }

    private boolean Li() {
        return (this.bgj == null || this.bgj.mAlaLiveSwitchData == null || !this.bgj.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean Lj() {
        return (this.bgj == null || this.bgj.mAlaLiveSwitchData == null || !this.bgj.mAlaLiveSwitchData.isPayBarrageUnabled()) ? false : true;
    }

    private void Lk() {
        if (this.bgc || Lj()) {
            this.bfU.setVisibility(8);
            return;
        }
        final bz[] e = d.Kh().e(this.bfY != null && this.bfY.JQ(), this.bfY != null ? this.bfY.JR() : 0);
        if (e == null || e.length <= 0) {
            if (this.bfU.isChecked()) {
                this.bfU.setChecked(false, false);
            } else {
                bV(false);
            }
            this.bfU.setVisibility(8);
            return;
        }
        this.bfU.setVisibility(0);
        if (this.bfR != null) {
            if (this.bfR.getView().getWidth() <= 0) {
                this.bfS.setVisibility(0);
            }
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.Kh().Kj()) {
                        ALALiveTextView.this.bfR.setData(e, ALALiveTextView.this.aQP, 0);
                        if (ALALiveTextView.this.bfU.isChecked()) {
                            ALALiveTextView.this.bfR.setSelectId(d.Kh().Kk());
                            ALALiveTextView.this.Ll();
                            ALALiveTextView.this.bW(true);
                        } else {
                            ALALiveTextView.this.bfU.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.bfU.isChecked()) {
                        ALALiveTextView.this.bfU.setChecked(false, false);
                    }
                    ALALiveTextView.this.bfS.setVisibility(ALALiveTextView.this.bfU.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.bfW != null) {
            if (TextUtils.isEmpty(this.bfV.getText())) {
                this.bfW.setEnabled(false);
            } else {
                this.bfW.setEnabled(true);
                this.bfW.setClickable(true);
            }
        }
        if (this.bfV.getText().length() > this.bgb) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.bgb)));
            if (charSequence.length() > this.bgb) {
                this.bfV.setText(charSequence.subSequence(0, this.bgb));
                this.bfV.setSelection(this.bfV.getText().length());
                return;
            }
            this.bfV.setText(charSequence);
            if (i <= charSequence.length()) {
                this.bfV.setSelection(i);
            } else {
                this.bfV.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ll() {
        if (this.bfR != null) {
            bz selectInfo = this.bfR.getSelectInfo();
            if (this.bfV != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.bfV.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.bfV.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aMA == 7) {
                            this.bfV.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.bfV.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_barrage));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bV(boolean z) {
        if (z && this.bfY != null && !this.bfY.JM()) {
            this.bfU.setChecked(false, false);
            return;
        }
        this.bgb = z ? 20 : 50;
        if (z && this.bfV != null && this.bfV.getText() != null && this.bfV.getText().length() > this.bgb) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.bgb)));
        }
        if (this.bfR != null) {
            if (z) {
                this.bfR.setData(d.Kh().e(this.bfY != null && this.bfY.JQ(), this.bfY != null ? this.bfY.JR() : 0), this.aQP, 0);
                this.bfR.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Kh().Kk())) {
                    this.bfR.setSelectId(d.Kh().Kk());
                } else {
                    this.bfR.setSelectPos(0);
                }
                if (this.bfS != null) {
                    this.bfS.setVisibility(0);
                }
                bW(true);
                this.bfN.setVisibility(8);
                Ll();
                setQuickInputPanelVisible(false);
                if (this.bgf != null && this.bgf.getPageActivity() != null && this.bfV != null) {
                    BdUtilHelper.showSoftKeyPad(this.bgf.getPageActivity(), this.bfV);
                }
            } else {
                this.bfR.setSwitchStatus(false);
                if (this.bfT != null) {
                    this.bfT.setVisibility(8);
                }
                if (this.bfS != null) {
                    this.bfS.setVisibility(8);
                }
                if (!Li()) {
                    this.bfN.setVisibility(0);
                }
                if (this.bfV != null) {
                    this.bfV.setHint(a.i.sdk_im_sendmessage_to_host);
                }
            }
            if (this.bfY != null) {
                this.bfY.JP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bW(boolean z) {
        if (z && this.bfP != null) {
            this.bfP.setPreview();
        }
        if (this.bfP != null && this.bfR != null) {
            this.bfP.setUIInfo(this.bfR.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.bfT != null) {
                this.bfT.setVisibility(8);
            }
        } else if (this.bfU != null && this.bfU.isChecked() && this.bfT != null) {
            this.bfT.setVisibility(0);
        }
    }

    private void s(String str, boolean z) {
        if (this.bfY != null) {
            this.bfY.r(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                if (this.bfT != null) {
                    this.bfT.setVisibility(8);
                }
            } else if (this.bfU != null && this.bfU.isChecked() && this.bfT != null) {
                this.bfT.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Lm() {
        if (this.bfV != null) {
            this.handler.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bfV.requestFocus();
                }
            });
        }
    }
}

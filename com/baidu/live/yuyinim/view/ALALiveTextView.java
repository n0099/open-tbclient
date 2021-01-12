package com.baidu.live.yuyinim.view;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ck;
import com.baidu.live.im.b.b;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.im.data.YuyinImForbiddenStateData;
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
import com.baidu.live.view.emojiview.a;
import com.baidu.live.view.input.a;
import com.baidu.live.yuyinim.controller.EmojiconsController;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ALALiveTextView extends LinearLayout implements a.b, com.baidu.live.view.input.a {
    private Map<String, Integer> aUQ;
    private ImageView bZq;
    private EmojiconsController bZr;
    private int bZs;
    private int bad;
    public CustomMessageListener bdo;
    public CustomMessageListener blj;
    private FrameLayout bmN;
    private b bmO;
    private com.baidu.live.im.d.a bmP;
    private c bmQ;
    private FrameLayout bmR;
    private FrameLayout bmS;
    private Switch bmT;
    private EditText bmU;
    private GradientEnableTextView bmV;
    private a.InterfaceC0230a bmX;
    private long bmY;
    private int bmZ;
    private int bna;
    private boolean bnb;
    private boolean bnc;
    private int bne;
    private BdPageContext bnf;
    private int bng;
    private AlaLiveInfoData bnl;
    private View.OnClickListener bnn;
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
    public void a(YuyinImForbiddenStateData yuyinImForbiddenStateData) {
        String format;
        Log.i("i", "@@@ localText swfbwtst gb=" + yuyinImForbiddenStateData.globalBan + ",cb=" + yuyinImForbiddenStateData.anchorBan + ",bl=" + yuyinImForbiddenStateData.liveBan);
        if (yuyinImForbiddenStateData.globalBan == 1) {
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.blY == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.blZ);
            }
            this.mDialog = new BdAlertDialog(this.bnf.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.8
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
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.9
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
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ku() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bmY >= 2000) {
            this.bmY = currentTimeMillis;
            String obj = this.bmU.getText().toString();
            Log.i("i", "@@@ localText normal tosd");
            u(obj, false);
            return;
        }
        BdUtilHelper.showToast(getContext(), "您按得太快，我都跟不上了~");
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bng = 0;
        this.blj = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bng != 3 && ALALiveTextView.this.bng != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                        if (yuyinImForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + yuyinImForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bng);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bng == 3) {
                                ALALiveTextView.this.Ku();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bng = 0;
                }
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bnn = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.af.a.OJ().bru.aKs;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.af.a.OJ().bru.aKr;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.bnc);
                if (i2 == 1) {
                    if (ALALiveTextView.this.bnc) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bng = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.Ku();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.Ku();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.bZs = 1;
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bng = 0;
        this.blj = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bng != 3 && ALALiveTextView.this.bng != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                        if (yuyinImForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + yuyinImForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bng);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bng == 3) {
                                ALALiveTextView.this.Ku();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bng = 0;
                }
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bnn = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.af.a.OJ().bru.aKs;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.af.a.OJ().bru.aKr;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.bnc);
                if (i2 == 1) {
                    if (ALALiveTextView.this.bnc) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bng = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.Ku();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.Ku();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.bZs = 1;
        this.bnf = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bng = 0;
        this.blj = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bng != 3 && ALALiveTextView.this.bng != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                        if (yuyinImForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + yuyinImForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bng);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bng == 3) {
                                ALALiveTextView.this.Ku();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bng = 0;
                }
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bnn = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.af.a.OJ().bru.aKs;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.af.a.OJ().bru.aKr;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.bnc);
                if (i2 == 1) {
                    if (ALALiveTextView.this.bnc) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bng = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.Ku();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.Ku();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.bZs = 1;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bng = 0;
        this.blj = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bng != 3 && ALALiveTextView.this.bng != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                        if (yuyinImForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + yuyinImForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bng);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bng == 3) {
                                ALALiveTextView.this.Ku();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bng = 0;
                }
            }
        };
        this.bdo = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bnn = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i2 = com.baidu.live.af.a.OJ().bru.aKs;
                if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i22 = com.baidu.live.af.a.OJ().bru.aKr;
                Log.i("i", "@@@ localText send 1 isw=" + i22 + ", fb=" + ALALiveTextView.this.bnc);
                if (i22 == 1) {
                    if (ALALiveTextView.this.bnc) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bng = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.Ku();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.Ku();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.bZs = 1;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setBackgroundColor(0);
        setClickable(true);
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.g.yuyinala_im_input_layout, (ViewGroup) this, true);
        Kv();
        Kw();
        XR();
        this.bna = 50;
    }

    private void Kv() {
        this.bmT = (Switch) findViewById(a.f.switch_barrage);
        this.bmR = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        this.bmS = (FrameLayout) findViewById(a.f.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.bnf);
        if (runTask != null) {
            this.bmQ = (c) runTask.getData();
        }
        if (this.bmQ != null) {
            this.bmR.addView(this.bmQ.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, b.class, this.bnf);
        if (runTask2 != null) {
            this.bmO = (b) runTask2.getData();
        }
        if (this.bmO != null) {
            this.bmS.addView(this.bmO.getView());
        }
        if (this.bmQ != null) {
            this.bmQ.setCallback(new e() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.11
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
        this.bmT.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.12
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.cl(z);
            }
        });
    }

    private void Kw() {
        this.bmU = (EditText) findViewById(a.f.edit_text);
        this.bmU.addTextChangedListener(this.mTextWatcher);
        this.bmU.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.13
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.bmU.getText())) {
                        ALALiveTextView.this.u(ALALiveTextView.this.bmU.getText().toString(), false);
                    }
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

    private void XR() {
        this.bZq = (ImageView) findViewById(a.f.iv_emoji);
        this.bmN = (FrameLayout) findViewById(a.f.quick_input_panel);
        this.bZr = EmojiconsController.c(getContext(), this.bmN);
        com.baidu.live.view.emojiview.a.a(this);
        this.bZq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ALALiveTextView.this.bZs == 2) {
                    ALALiveTextView.this.bZs = 1;
                    ALALiveTextView.this.bZq.setImageResource(a.e.bd_im_emoji_status);
                } else {
                    ALALiveTextView.this.bZs = 2;
                    ALALiveTextView.this.bZq.setImageResource(a.e.bd_im_input_icon_status);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "chatmeme_show"));
                }
                if (ALALiveTextView.this.bmX != null) {
                    ALALiveTextView.this.bmX.IM();
                }
            }
        });
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
        if (this.bZq != null) {
            this.bZs = 1;
            this.bZq.setImageResource(a.e.bd_im_emoji_status);
        }
        if (KD()) {
        }
        return false;
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
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bmN.getLayoutParams();
            if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.bmN.setLayoutParams(layoutParams);
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
            this.bmU.post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.3
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bmU.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.bmU);
                }
            });
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.bmP != null) {
            if (arrayList.size() >= 3) {
                this.bmP.setData(arrayList.subList(0, 3));
            } else {
                this.bmP.setData(arrayList);
            }
        }
        if (this.bmN != null) {
            this.bmN.setVisibility(8);
        }
        if (this.bZq != null) {
            this.bZq.setImageResource(a.e.bd_im_emoji_status);
        }
        if (this.bZr != null) {
            this.bZr.XQ();
        }
        this.bZs = 1;
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
        return (this.bnl == null || this.bnl.mAlaLiveSwitchData == null || !this.bnl.mAlaLiveSwitchData.isYuyinPayBarrageUnabled()) ? false : true;
    }

    private void KF() {
        if (this.bnb || KE()) {
            this.bmT.setVisibility(8);
            return;
        }
        final ck[] du = d.Jp().du(this.bmX != null ? this.bmX.IP() : 0);
        if (du == null || du.length <= 0) {
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
            this.bmQ.getView().post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.Jp().Js()) {
                        ALALiveTextView.this.bmQ.setData(du, ALALiveTextView.this.aUQ, 0);
                        if (ALALiveTextView.this.bmT.isChecked()) {
                            ALALiveTextView.this.bmQ.setSelectId(d.Jp().Jt());
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
        if (com.baidu.live.view.emojiview.d.hT(this.bmU.getText().toString()) > this.bna) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bna)));
            if (com.baidu.live.view.emojiview.d.hT(charSequence.toString()) > this.bna) {
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
            if (this.bmU == null || selectInfo == null) {
                return;
            }
            switch (selectInfo.type) {
                case 1:
                case 16:
                case 17:
                default:
                    return;
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
        if (z && this.bmU != null && this.bmU.getText() != null && com.baidu.live.view.emojiview.d.hT(this.bmU.getText().toString()) > this.bna) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bna)));
        }
        if (this.bmQ != null) {
            if (z) {
                this.bmQ.setData(d.Jp().du(this.bmX != null ? this.bmX.IP() : 0), this.aUQ, 0);
                this.bmQ.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Jp().Jt())) {
                    this.bmQ.setSelectId(d.Jp().Jt());
                } else {
                    this.bmQ.setSelectPos(0);
                }
                if (this.bmR != null) {
                    this.bmR.setVisibility(0);
                }
                cm(true);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, boolean z) {
        if (this.bmX != null) {
            Log.i("i", "@@@ localText st go");
            this.bmX.t(str, z);
        }
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
            this.bmU.post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.5
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bmU.requestFocus();
                }
            });
        }
    }

    @Override // com.baidu.live.view.input.a
    public void setFromDailyTask(boolean z, String str) {
    }

    @Override // com.baidu.live.view.input.a
    public void destroy() {
    }

    @Override // com.baidu.live.view.input.a
    public View getTextView() {
        return null;
    }

    @Override // com.baidu.live.view.emojiview.a.b
    public void hR(String str) {
        com.baidu.live.view.emojiview.d.b(this.bmU, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("meme_id", com.baidu.live.view.emojiview.b.O(this.mContext, str));
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "chatmeme_clk").setContentExt(jSONObject));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.live.view.emojiview.a.b
    public void al(View view) {
        com.baidu.live.view.emojiview.d.b(this.bmU);
    }
}

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
import com.baidu.live.data.cr;
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
    private Map<String, Integer> aZy;
    private int beM;
    public CustomMessageListener bhY;
    public CustomMessageListener bqe;
    private FrameLayout brO;
    private b brP;
    private com.baidu.live.im.d.a brQ;
    private c brR;
    private FrameLayout brS;
    private FrameLayout brT;
    private Switch brU;
    private EditText brV;
    private GradientEnableTextView brW;
    private a.InterfaceC0238a brY;
    private long brZ;
    private int bsa;
    private int bsb;
    private boolean bsc;
    private boolean bsd;
    private int bsf;
    private BdPageContext bsg;
    private int bsh;
    private AlaLiveInfoData bsm;
    private View.OnClickListener bso;
    private ImageView ceW;
    private EmojiconsController ceX;
    private int ceY;
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
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bqT == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bqU);
            }
            this.mDialog = new BdAlertDialog(this.bsg.getPageActivity());
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
            this.mDialog.create(this.bsg);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LV() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.brZ >= 2000) {
            this.brZ = currentTimeMillis;
            String obj = this.brV.getText().toString();
            Log.i("i", "@@@ localText normal tosd");
            u(obj, false);
            return;
        }
        BdUtilHelper.showToast(getContext(), "您按得太快，我都跟不上了~");
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bsh = 0;
        this.bqe = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bsh != 3 && ALALiveTextView.this.bsh != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bsh);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bsh == 3) {
                                ALALiveTextView.this.LV();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bsh = 0;
                }
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bso = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.ae.a.Qm().bwx.aOF;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.ae.a.Qm().bwx.aOE;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.bsd);
                if (i2 == 1) {
                    if (ALALiveTextView.this.bsd) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bsh = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.LV();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.LV();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.ceY = 1;
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bsh = 0;
        this.bqe = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bsh != 3 && ALALiveTextView.this.bsh != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bsh);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bsh == 3) {
                                ALALiveTextView.this.LV();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bsh = 0;
                }
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bso = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.ae.a.Qm().bwx.aOF;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.ae.a.Qm().bwx.aOE;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.bsd);
                if (i2 == 1) {
                    if (ALALiveTextView.this.bsd) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bsh = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.LV();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.LV();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.ceY = 1;
        this.bsg = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsh = 0;
        this.bqe = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bsh != 3 && ALALiveTextView.this.bsh != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bsh);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bsh == 3) {
                                ALALiveTextView.this.LV();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bsh = 0;
                }
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bso = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.ae.a.Qm().bwx.aOF;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.ae.a.Qm().bwx.aOE;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.bsd);
                if (i2 == 1) {
                    if (ALALiveTextView.this.bsd) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bsh = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.LV();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.LV();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.ceY = 1;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsh = 0;
        this.bqe = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bsh != 3 && ALALiveTextView.this.bsh != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bsh);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bsh == 3) {
                                ALALiveTextView.this.LV();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bsh = 0;
                }
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bso = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i2 = com.baidu.live.ae.a.Qm().bwx.aOF;
                if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i22 = com.baidu.live.ae.a.Qm().bwx.aOE;
                Log.i("i", "@@@ localText send 1 isw=" + i22 + ", fb=" + ALALiveTextView.this.bsd);
                if (i22 == 1) {
                    if (ALALiveTextView.this.bsd) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bsh = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.LV();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.LV();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.ceY = 1;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setBackgroundColor(0);
        setClickable(true);
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.g.yuyinala_im_input_layout, (ViewGroup) this, true);
        LW();
        LX();
        ZL();
        this.bsb = 50;
    }

    private void LW() {
        this.brU = (Switch) findViewById(a.f.switch_barrage);
        this.brS = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        this.brT = (FrameLayout) findViewById(a.f.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.bsg);
        if (runTask != null) {
            this.brR = (c) runTask.getData();
        }
        if (this.brR != null) {
            this.brS.addView(this.brR.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, b.class, this.bsg);
        if (runTask2 != null) {
            this.brP = (b) runTask2.getData();
        }
        if (this.brP != null) {
            this.brT.addView(this.brP.getView());
        }
        if (this.brR != null) {
            this.brR.setCallback(new e() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.11
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
        this.brU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.12
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.cu(z);
            }
        });
    }

    private void LX() {
        this.brV = (EditText) findViewById(a.f.edit_text);
        this.brV.addTextChangedListener(this.mTextWatcher);
        this.brV.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.13
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (TextUtils.isEmpty(ALALiveTextView.this.brV.getText())) {
                        return true;
                    }
                    Log.i("i", "@@@ localText send click");
                    int i2 = com.baidu.live.ae.a.Qm().bwx.aOF;
                    if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        return true;
                    }
                    int i3 = com.baidu.live.ae.a.Qm().bwx.aOE;
                    Log.i("i", "@@@ localText send 1 isw=" + i3 + ", fb=" + ALALiveTextView.this.bsd);
                    if (i3 == 1) {
                        if (ALALiveTextView.this.bsd) {
                            Log.i("i", "@@@ localText send 2 go req ban");
                            ALALiveTextView.this.bsh = 3;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return true;
                        }
                        Log.i("i", "@@@ localText send 2 go normal");
                        ALALiveTextView.this.LV();
                        return true;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
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

    private void ZL() {
        this.ceW = (ImageView) findViewById(a.f.iv_emoji);
        this.brO = (FrameLayout) findViewById(a.f.quick_input_panel);
        this.ceX = EmojiconsController.b(getContext(), this.brO);
        com.baidu.live.view.emojiview.a.a(this);
        this.ceW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ALALiveTextView.this.ceY == 2) {
                    ALALiveTextView.this.ceY = 1;
                    ALALiveTextView.this.ceW.setImageResource(a.e.bd_im_emoji_status);
                } else {
                    ALALiveTextView.this.ceY = 2;
                    ALALiveTextView.this.ceW.setImageResource(a.e.bd_im_input_icon_status);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "chatmeme_show"));
                }
                if (ALALiveTextView.this.brY != null) {
                    ALALiveTextView.this.brY.Kn();
                }
            }
        });
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
        if (this.ceW != null) {
            this.ceY = 1;
            this.ceW.setImageResource(a.e.bd_im_emoji_status);
        }
        if (Me()) {
        }
        return false;
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
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brO.getLayoutParams();
            if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.brO.setLayoutParams(layoutParams);
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
            this.brV.post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.3
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.brV.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.brV);
                }
            });
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.brQ != null) {
            if (arrayList.size() >= 3) {
                this.brQ.setData(arrayList.subList(0, 3));
            } else {
                this.brQ.setData(arrayList);
            }
        }
        if (this.brO != null) {
            this.brO.setVisibility(8);
        }
        if (this.ceW != null) {
            this.ceW.setImageResource(a.e.bd_im_emoji_status);
        }
        if (this.ceX != null) {
            this.ceX.ZK();
        }
        this.ceY = 1;
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
        return (this.bsm == null || this.bsm.mAlaLiveSwitchData == null || !this.bsm.mAlaLiveSwitchData.isYuyinPayBarrageUnabled()) ? false : true;
    }

    private void Mg() {
        if (this.bsc || Mf()) {
            this.brU.setVisibility(8);
            return;
        }
        final cr[] dB = d.KQ().dB(this.brY != null ? this.brY.Kq() : 0);
        if (dB == null || dB.length <= 0) {
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
            this.brR.getView().post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.KQ().KT()) {
                        ALALiveTextView.this.brR.setData(dB, ALALiveTextView.this.aZy, 0);
                        if (ALALiveTextView.this.brU.isChecked()) {
                            ALALiveTextView.this.brR.setSelectId(d.KQ().KU());
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
        if (com.baidu.live.view.emojiview.d.ix(this.brV.getText().toString()) > this.bsb) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bsb)));
            if (com.baidu.live.view.emojiview.d.ix(charSequence.toString()) > this.bsb) {
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
            if (this.brV == null || selectInfo == null) {
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
    public void cu(boolean z) {
        if (z && this.brY != null && !this.brY.Kk()) {
            this.brU.setChecked(false, false);
            return;
        }
        this.bsb = z ? 20 : 50;
        if (z && this.brV != null && this.brV.getText() != null && com.baidu.live.view.emojiview.d.ix(this.brV.getText().toString()) > this.bsb) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bsb)));
        }
        if (this.brR != null) {
            if (z) {
                this.brR.setData(d.KQ().dB(this.brY != null ? this.brY.Kq() : 0), this.aZy, 0);
                this.brR.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.KQ().KU())) {
                    this.brR.setSelectId(d.KQ().KU());
                } else {
                    this.brR.setSelectPos(0);
                }
                if (this.brS != null) {
                    this.brS.setVisibility(0);
                }
                cv(true);
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
            Log.i("i", "@@@ localText st go");
            this.brY.t(str, z);
        }
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
            this.brV.post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.5
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.brV.requestFocus();
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
    public void is(String str) {
        com.baidu.live.view.emojiview.d.b(this.brV, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("meme_id", com.baidu.live.view.emojiview.b.O(this.mContext, str));
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "chatmeme_clk").setContentExt(jSONObject));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.live.view.emojiview.a.b
    public void aj(View view) {
        com.baidu.live.view.emojiview.d.b(this.brV);
    }
}

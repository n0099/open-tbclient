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
/* loaded from: classes11.dex */
public class ALALiveTextView extends LinearLayout implements a.b, com.baidu.live.view.input.a {
    private Map<String, Integer> aXY;
    private int bdk;
    public CustomMessageListener bgy;
    public CustomMessageListener boE;
    private int bqA;
    private int bqB;
    private boolean bqC;
    private boolean bqD;
    private int bqF;
    private BdPageContext bqG;
    private int bqH;
    private AlaLiveInfoData bqM;
    private View.OnClickListener bqO;
    private FrameLayout bqo;
    private b bqp;
    private com.baidu.live.im.d.a bqq;
    private c bqr;
    private FrameLayout bqs;
    private FrameLayout bqt;
    private Switch bqu;
    private EditText bqv;
    private GradientEnableTextView bqw;
    private a.InterfaceC0232a bqy;
    private long bqz;
    private ImageView cdw;
    private EmojiconsController cdx;
    private int cdy;
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
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bpt == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bpu);
            }
            this.mDialog = new BdAlertDialog(this.bqG.getPageActivity());
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
            this.mDialog.create(this.bqG);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LS() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bqz >= 2000) {
            this.bqz = currentTimeMillis;
            String obj = this.bqv.getText().toString();
            Log.i("i", "@@@ localText normal tosd");
            u(obj, false);
            return;
        }
        BdUtilHelper.showToast(getContext(), "您按得太快，我都跟不上了~");
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.bqH = 0;
        this.boE = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqH != 3 && ALALiveTextView.this.bqH != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bqH);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bqH == 3) {
                                ALALiveTextView.this.LS();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bqH = 0;
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqO = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.ae.a.Qj().buX.aNf;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.ae.a.Qj().buX.aNe;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.bqD);
                if (i2 == 1) {
                    if (ALALiveTextView.this.bqD) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bqH = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.LS();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.LS();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.cdy = 1;
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.bqH = 0;
        this.boE = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqH != 3 && ALALiveTextView.this.bqH != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bqH);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bqH == 3) {
                                ALALiveTextView.this.LS();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bqH = 0;
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqO = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.ae.a.Qj().buX.aNf;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.ae.a.Qj().buX.aNe;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.bqD);
                if (i2 == 1) {
                    if (ALALiveTextView.this.bqD) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bqH = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.LS();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.LS();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.cdy = 1;
        this.bqG = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bqH = 0;
        this.boE = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqH != 3 && ALALiveTextView.this.bqH != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bqH);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bqH == 3) {
                                ALALiveTextView.this.LS();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bqH = 0;
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqO = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.ae.a.Qj().buX.aNf;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.ae.a.Qj().buX.aNe;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.bqD);
                if (i2 == 1) {
                    if (ALALiveTextView.this.bqD) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bqH = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.LS();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.LS();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.cdy = 1;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bqH = 0;
        this.boE = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.bqH != 3 && ALALiveTextView.this.bqH != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.bqH);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.bqH == 3) {
                                ALALiveTextView.this.LS();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.bqH = 0;
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.bqO = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i2 = com.baidu.live.ae.a.Qj().buX.aNf;
                if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i22 = com.baidu.live.ae.a.Qj().buX.aNe;
                Log.i("i", "@@@ localText send 1 isw=" + i22 + ", fb=" + ALALiveTextView.this.bqD);
                if (i22 == 1) {
                    if (ALALiveTextView.this.bqD) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.bqH = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.LS();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.LS();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
        this.cdy = 1;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setBackgroundColor(0);
        setClickable(true);
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.g.yuyinala_im_input_layout, (ViewGroup) this, true);
        LT();
        LU();
        ZI();
        this.bqB = 50;
    }

    private void LT() {
        this.bqu = (Switch) findViewById(a.f.switch_barrage);
        this.bqs = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        this.bqt = (FrameLayout) findViewById(a.f.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.bqG);
        if (runTask != null) {
            this.bqr = (c) runTask.getData();
        }
        if (this.bqr != null) {
            this.bqs.addView(this.bqr.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, b.class, this.bqG);
        if (runTask2 != null) {
            this.bqp = (b) runTask2.getData();
        }
        if (this.bqp != null) {
            this.bqt.addView(this.bqp.getView());
        }
        if (this.bqr != null) {
            this.bqr.setCallback(new e() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.11
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
        this.bqu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.12
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.cu(z);
            }
        });
    }

    private void LU() {
        this.bqv = (EditText) findViewById(a.f.edit_text);
        this.bqv.addTextChangedListener(this.mTextWatcher);
        this.bqv.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.13
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (TextUtils.isEmpty(ALALiveTextView.this.bqv.getText())) {
                        return true;
                    }
                    Log.i("i", "@@@ localText send click");
                    int i2 = com.baidu.live.ae.a.Qj().buX.aNf;
                    if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                        return true;
                    }
                    int i3 = com.baidu.live.ae.a.Qj().buX.aNe;
                    Log.i("i", "@@@ localText send 1 isw=" + i3 + ", fb=" + ALALiveTextView.this.bqD);
                    if (i3 == 1) {
                        if (ALALiveTextView.this.bqD) {
                            Log.i("i", "@@@ localText send 2 go req ban");
                            ALALiveTextView.this.bqH = 3;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return true;
                        }
                        Log.i("i", "@@@ localText send 2 go normal");
                        ALALiveTextView.this.LS();
                        return true;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
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

    private void ZI() {
        this.cdw = (ImageView) findViewById(a.f.iv_emoji);
        this.bqo = (FrameLayout) findViewById(a.f.quick_input_panel);
        this.cdx = EmojiconsController.c(getContext(), this.bqo);
        com.baidu.live.view.emojiview.a.a(this);
        this.cdw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ALALiveTextView.this.cdy == 2) {
                    ALALiveTextView.this.cdy = 1;
                    ALALiveTextView.this.cdw.setImageResource(a.e.bd_im_emoji_status);
                } else {
                    ALALiveTextView.this.cdy = 2;
                    ALALiveTextView.this.cdw.setImageResource(a.e.bd_im_input_icon_status);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "chatmeme_show"));
                }
                if (ALALiveTextView.this.bqy != null) {
                    ALALiveTextView.this.bqy.Kk();
                }
            }
        });
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
        if (this.cdw != null) {
            this.cdy = 1;
            this.cdw.setImageResource(a.e.bd_im_emoji_status);
        }
        if (Mb()) {
        }
        return false;
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
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bqo.getLayoutParams();
            if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.bqo.setLayoutParams(layoutParams);
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
            this.bqv.post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.3
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bqv.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.bqv);
                }
            });
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.bqq != null) {
            if (arrayList.size() >= 3) {
                this.bqq.setData(arrayList.subList(0, 3));
            } else {
                this.bqq.setData(arrayList);
            }
        }
        if (this.bqo != null) {
            this.bqo.setVisibility(8);
        }
        if (this.cdw != null) {
            this.cdw.setImageResource(a.e.bd_im_emoji_status);
        }
        if (this.cdx != null) {
            this.cdx.ZH();
        }
        this.cdy = 1;
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
        return (this.bqM == null || this.bqM.mAlaLiveSwitchData == null || !this.bqM.mAlaLiveSwitchData.isYuyinPayBarrageUnabled()) ? false : true;
    }

    private void Md() {
        if (this.bqC || Mc()) {
            this.bqu.setVisibility(8);
            return;
        }
        final cr[] dA = d.KN().dA(this.bqy != null ? this.bqy.Kn() : 0);
        if (dA == null || dA.length <= 0) {
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
            this.bqr.getView().post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.KN().KQ()) {
                        ALALiveTextView.this.bqr.setData(dA, ALALiveTextView.this.aXY, 0);
                        if (ALALiveTextView.this.bqu.isChecked()) {
                            ALALiveTextView.this.bqr.setSelectId(d.KN().KR());
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
        if (com.baidu.live.view.emojiview.d.ir(this.bqv.getText().toString()) > this.bqB) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bqB)));
            if (com.baidu.live.view.emojiview.d.ir(charSequence.toString()) > this.bqB) {
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
            if (this.bqv == null || selectInfo == null) {
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
        if (z && this.bqy != null && !this.bqy.Kh()) {
            this.bqu.setChecked(false, false);
            return;
        }
        this.bqB = z ? 20 : 50;
        if (z && this.bqv != null && this.bqv.getText() != null && com.baidu.live.view.emojiview.d.ir(this.bqv.getText().toString()) > this.bqB) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.bqB)));
        }
        if (this.bqr != null) {
            if (z) {
                this.bqr.setData(d.KN().dA(this.bqy != null ? this.bqy.Kn() : 0), this.aXY, 0);
                this.bqr.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.KN().KR())) {
                    this.bqr.setSelectId(d.KN().KR());
                } else {
                    this.bqr.setSelectPos(0);
                }
                if (this.bqs != null) {
                    this.bqs.setVisibility(0);
                }
                cv(true);
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
            Log.i("i", "@@@ localText st go");
            this.bqy.t(str, z);
        }
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
            this.bqv.post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.5
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.bqv.requestFocus();
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
    public void im(String str) {
        com.baidu.live.view.emojiview.d.b(this.bqv, str);
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
        com.baidu.live.view.emojiview.d.b(this.bqv);
    }
}

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
/* loaded from: classes11.dex */
public class ALALiveTextView extends LinearLayout implements a.b, com.baidu.live.view.input.a {
    private Map<String, Integer> aZD;
    private int beT;
    public CustomMessageListener bih;
    public CustomMessageListener bpW;
    private b brA;
    private com.baidu.live.im.d.a brB;
    private c brC;
    private FrameLayout brD;
    private FrameLayout brE;
    private Switch brF;
    private EditText brG;
    private GradientEnableTextView brH;
    private a.InterfaceC0239a brJ;
    private long brK;
    private int brL;
    private int brM;
    private boolean brN;
    private boolean brO;
    private int brQ;
    private BdPageContext brR;
    private int brS;
    private AlaLiveInfoData brX;
    private View.OnClickListener brZ;
    private FrameLayout brz;
    private ImageView ceg;
    private EmojiconsController ceh;
    private int cei;
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
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bqL == 1) {
                format = getContext().getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.h.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bqM);
            }
            this.mDialog = new BdAlertDialog(this.brR.getPageActivity());
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
            this.mDialog.create(this.brR);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.h.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Op() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.brK >= 2000) {
            this.brK = currentTimeMillis;
            String obj = this.brG.getText().toString();
            Log.i("i", "@@@ localText normal tosd");
            u(obj, false);
            return;
        }
        BdUtilHelper.showToast(getContext(), "您按得太快，我都跟不上了~");
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.brS = 0;
        this.bpW = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.brS != 3 && ALALiveTextView.this.brS != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.brS);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.brS == 3) {
                                ALALiveTextView.this.Op();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.brS = 0;
                }
            }
        };
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.brZ = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.af.a.SE().bwi.aPf;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.af.a.SE().bwi.aPe;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.brO);
                if (i2 == 1) {
                    if (ALALiveTextView.this.brO) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.brS = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.Op();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.Op();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
            private CharSequence bse;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bse = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bse, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.cei = 1;
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.brS = 0;
        this.bpW = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.brS != 3 && ALALiveTextView.this.brS != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.brS);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.brS == 3) {
                                ALALiveTextView.this.Op();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.brS = 0;
                }
            }
        };
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.brZ = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.af.a.SE().bwi.aPf;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.af.a.SE().bwi.aPe;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.brO);
                if (i2 == 1) {
                    if (ALALiveTextView.this.brO) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.brS = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.Op();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.Op();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
            private CharSequence bse;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bse = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bse, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.cei = 1;
        this.brR = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.brS = 0;
        this.bpW = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.brS != 3 && ALALiveTextView.this.brS != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.brS);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.brS == 3) {
                                ALALiveTextView.this.Op();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.brS = 0;
                }
            }
        };
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.brZ = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.af.a.SE().bwi.aPf;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.af.a.SE().bwi.aPe;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.brO);
                if (i2 == 1) {
                    if (ALALiveTextView.this.brO) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.brS = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.Op();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.Op();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
            private CharSequence bse;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.bse = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.bse, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.cei = 1;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.brS = 0;
        this.bpW = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.brS != 3 && ALALiveTextView.this.brS != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.brS);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.brS == 3) {
                                ALALiveTextView.this.Op();
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.brS = 0;
                }
            }
        };
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.brZ = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i2 = com.baidu.live.af.a.SE().bwi.aPf;
                if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i22 = com.baidu.live.af.a.SE().bwi.aPe;
                Log.i("i", "@@@ localText send 1 isw=" + i22 + ", fb=" + ALALiveTextView.this.brO);
                if (i22 == 1) {
                    if (ALALiveTextView.this.brO) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.brS = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.Op();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.Op();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
            private CharSequence bse;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.bse = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.bse, i2);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.cei = 1;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setBackgroundColor(0);
        setClickable(true);
        setOrientation(1);
        LayoutInflater.from(context).inflate(a.g.yuyinala_im_input_layout, (ViewGroup) this, true);
        Oq();
        Or();
        abJ();
        this.brM = 50;
    }

    private void Oq() {
        this.brF = (Switch) findViewById(a.f.switch_barrage);
        this.brD = (FrameLayout) findViewById(a.f.hlv_barrage_option);
        this.brE = (FrameLayout) findViewById(a.f.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.brR);
        if (runTask != null) {
            this.brC = (c) runTask.getData();
        }
        if (this.brC != null) {
            this.brD.addView(this.brC.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, b.class, this.brR);
        if (runTask2 != null) {
            this.brA = (b) runTask2.getData();
        }
        if (this.brA != null) {
            this.brE.addView(this.brA.getView());
        }
        if (this.brC != null) {
            this.brC.setCallback(new e() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.11
                @Override // com.baidu.live.im.b.e
                public boolean Nt() {
                    return ALALiveTextView.this.brJ != null && ALALiveTextView.this.brJ.MJ();
                }

                @Override // com.baidu.live.im.b.e
                public void fb(int i) {
                    ALALiveTextView.this.OB();
                    ALALiveTextView.this.cq(false);
                }

                @Override // com.baidu.live.im.b.e
                public int MK() {
                    if (ALALiveTextView.this.brJ != null) {
                        return ALALiveTextView.this.brJ.MK();
                    }
                    return 0;
                }
            });
        }
        this.brF.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.12
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.cp(z);
            }
        });
    }

    private void Or() {
        this.brG = (EditText) findViewById(a.f.edit_text);
        this.brG.addTextChangedListener(this.mTextWatcher);
        this.brG.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.13
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.brG.getText())) {
                        ALALiveTextView.this.u(ALALiveTextView.this.brG.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.brH = (GradientEnableTextView) findViewById(a.f.tv_send);
        this.brH.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.brG, Integer.valueOf(a.e.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.brG, Integer.valueOf(a.e.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.brH.setOnClickListener(this.brZ);
        this.brH.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.brO = z;
        this.brQ = i;
        this.beT = i2;
        this.mUserName = str;
    }

    private void abJ() {
        this.ceg = (ImageView) findViewById(a.f.iv_emoji);
        this.brz = (FrameLayout) findViewById(a.f.quick_input_panel);
        this.ceh = EmojiconsController.c(getContext(), this.brz);
        com.baidu.live.view.emojiview.a.a(this);
        this.ceg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ALALiveTextView.this.cei == 2) {
                    ALALiveTextView.this.cei = 1;
                    ALALiveTextView.this.ceg.setImageResource(a.e.bd_im_emoji_status);
                } else {
                    ALALiveTextView.this.cei = 2;
                    ALALiveTextView.this.ceg.setImageResource(a.e.bd_im_input_icon_status);
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "chatmeme_show"));
                }
                if (ALALiveTextView.this.brJ != null) {
                    ALALiveTextView.this.brJ.MH();
                }
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.brN = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ot() {
        return this.brF != null && this.brF.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ou() {
        if (this.ceg != null) {
            this.cei = 1;
            this.ceg.setImageResource(a.e.bd_im_emoji_status);
        }
        if (Oy()) {
        }
        return false;
    }

    public ck getBarrageInfo() {
        if (this.brC != null) {
            return this.brC.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.brG.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0239a interfaceC0239a) {
        this.brJ = interfaceC0239a;
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

    public void hU(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean Ov() {
        return getView().getVisibility() == 0 && this.brz.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.brz.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.brz.getLayoutParams();
            if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.brz.setLayoutParams(layoutParams);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.brz.setVisibility(8);
        if (this.brG != null) {
            this.brG.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Ow() {
        if (this.brG != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.brG);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.brL - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.brR = bdPageContext;
    }

    @Override // com.baidu.live.view.input.a
    public void Ox() {
        this.brG.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.brG.getSelectionStart();
            Editable editableText = this.brG.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.brG.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.brX = alaLiveInfoData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aZD = map;
        OA();
        this.brG.requestFocus();
        if (this.brG != null) {
            this.brG.post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.3
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.brG.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.brG);
                }
            });
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.brB != null) {
            if (arrayList.size() >= 3) {
                this.brB.setData(arrayList.subList(0, 3));
            } else {
                this.brB.setData(arrayList);
            }
        }
        if (this.brz != null) {
            this.brz.setVisibility(8);
        }
        if (this.ceg != null) {
            this.ceg.setImageResource(a.e.bd_im_emoji_status);
        }
        if (this.ceh != null) {
            this.ceh.abI();
        }
        this.cei = 1;
    }

    @Override // com.baidu.live.view.input.a
    public void show() {
        a((List<String>) null, (Map<String, Integer>) null, (AlaLiveInfoData) null);
    }

    @Override // com.baidu.live.view.input.a
    public void hide() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        this.brG.clearFocus();
        if (this.brA != null) {
            this.brA.release();
        }
        setVisibility(8);
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.brC != null) {
            this.brC.f(map);
        }
    }

    private boolean Oy() {
        return (this.brX == null || this.brX.mAlaLiveSwitchData == null || !this.brX.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean Oz() {
        return (this.brX == null || this.brX.mAlaLiveSwitchData == null || !this.brX.mAlaLiveSwitchData.isYuyinPayBarrageUnabled()) ? false : true;
    }

    private void OA() {
        if (this.brN || Oz()) {
            this.brF.setVisibility(8);
            return;
        }
        final ck[] fa = d.Nk().fa(this.brJ != null ? this.brJ.MK() : 0);
        if (fa == null || fa.length <= 0) {
            if (this.brF.isChecked()) {
                this.brF.setChecked(false, false);
            } else {
                cp(false);
            }
            this.brF.setVisibility(8);
            return;
        }
        this.brF.setVisibility(0);
        if (this.brC != null) {
            if (this.brC.getView().getWidth() <= 0) {
                this.brD.setVisibility(0);
            }
            this.brC.getView().post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.Nk().Nn()) {
                        ALALiveTextView.this.brC.setData(fa, ALALiveTextView.this.aZD, 0);
                        if (ALALiveTextView.this.brF.isChecked()) {
                            ALALiveTextView.this.brC.setSelectId(d.Nk().No());
                            ALALiveTextView.this.OB();
                            ALALiveTextView.this.cq(true);
                        } else {
                            ALALiveTextView.this.brF.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.brF.isChecked()) {
                        ALALiveTextView.this.brF.setChecked(false, false);
                    }
                    ALALiveTextView.this.brD.setVisibility(ALALiveTextView.this.brF.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.brH != null) {
            if (TextUtils.isEmpty(this.brG.getText())) {
                this.brH.setEnabled(false);
            } else {
                this.brH.setEnabled(true);
                this.brH.setClickable(true);
            }
        }
        if (com.baidu.live.view.emojiview.d.je(this.brG.getText().toString()) > this.brM) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.brM)));
            if (com.baidu.live.view.emojiview.d.je(charSequence.toString()) > this.brM) {
                this.brG.setText(charSequence.subSequence(0, this.brM));
                this.brG.setSelection(this.brG.getText().length());
                return;
            }
            this.brG.setText(charSequence);
            if (i <= charSequence.length()) {
                this.brG.setSelection(i);
            } else {
                this.brG.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OB() {
        if (this.brC != null) {
            ck selectInfo = this.brC.getSelectInfo();
            if (this.brG == null || selectInfo == null) {
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
    public void cp(boolean z) {
        if (z && this.brJ != null && !this.brJ.ME()) {
            this.brF.setChecked(false, false);
            return;
        }
        this.brM = z ? 20 : 50;
        if (z && this.brG != null && this.brG.getText() != null && com.baidu.live.view.emojiview.d.je(this.brG.getText().toString()) > this.brM) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.h.sdk_send_im_over_max), Integer.valueOf(this.brM)));
        }
        if (this.brC != null) {
            if (z) {
                this.brC.setData(d.Nk().fa(this.brJ != null ? this.brJ.MK() : 0), this.aZD, 0);
                this.brC.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Nk().No())) {
                    this.brC.setSelectId(d.Nk().No());
                } else {
                    this.brC.setSelectPos(0);
                }
                if (this.brD != null) {
                    this.brD.setVisibility(0);
                }
                cq(true);
                OB();
                setQuickInputPanelVisible(false);
                if (this.brR != null && this.brR.getPageActivity() != null && this.brG != null) {
                    BdUtilHelper.showSoftKeyPad(this.brR.getPageActivity(), this.brG);
                }
            } else {
                this.brC.setSwitchStatus(false);
                if (this.brE != null) {
                    this.brE.setVisibility(8);
                }
                if (this.brD != null) {
                    this.brD.setVisibility(8);
                }
                if (this.brG != null) {
                    this.brG.setHint(a.h.sdk_im_sendmessage_to_host);
                }
            }
            if (this.brJ != null) {
                this.brJ.MI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq(boolean z) {
        if (z && this.brA != null) {
            this.brA.setPreview();
        }
        if (this.brA != null && this.brC != null) {
            this.brA.setUIInfo(this.brC.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.brE != null) {
                this.brE.setVisibility(8);
            }
        } else if (this.brF != null && this.brF.isChecked() && this.brE != null) {
            this.brE.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, boolean z) {
        if (this.brJ != null) {
            Log.i("i", "@@@ localText st go");
            this.brJ.t(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                if (this.brE != null) {
                    this.brE.setVisibility(8);
                }
            } else if (this.brF != null && this.brF.isChecked() && this.brE != null) {
                this.brE.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void OD() {
        if (this.brG != null) {
            this.brG.post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.5
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.brG.requestFocus();
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
    public void jc(String str) {
        com.baidu.live.view.emojiview.d.b(this.brG, str);
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
        com.baidu.live.view.emojiview.d.b(this.brG);
    }
}

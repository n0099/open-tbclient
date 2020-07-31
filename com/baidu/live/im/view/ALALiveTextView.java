package com.baidu.live.im.view;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.ViewCompat;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.bp;
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
    private Map<String, Integer> aJA;
    private int aNQ;
    public CustomMessageListener aQz;
    private FrameLayout aXG;
    private FrameLayout aXH;
    private b aXI;
    private com.baidu.live.im.d.a aXJ;
    private c aXK;
    private FrameLayout aXL;
    private FrameLayout aXM;
    private Switch aXN;
    private EditText aXO;
    private GradientEnableTextView aXP;
    private com.baidu.live.im.d.b aXQ;
    private a.InterfaceC0192a aXR;
    private long aXS;
    private int aXT;
    private int aXU;
    private boolean aXV;
    private boolean aXW;
    private int aXX;
    private BdPageContext aXY;
    private int aXZ;
    private String aYa;
    private int aYb;
    private AlaLiveInfoData aYc;
    public CustomMessageListener aYd;
    private View.OnClickListener aYe;
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
        Log.i("i", "@@@ localText swfbwtst gb=" + imForbiddenStateData.globalBan + ",cb=" + imForbiddenStateData.anchorBan + ",bl=" + imForbiddenStateData.liveBan);
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aXg == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aXh);
            }
            this.mDialog = new BdAlertDialog(this.aXY.getPageActivity());
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
            this.mDialog.create(this.aXY);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EN() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aXS >= 2000) {
            this.aXS = currentTimeMillis;
            String obj = this.aXO.getText().toString();
            if (obj.length() > this.aXU) {
                obj = obj.subSequence(0, this.aXU).toString();
            }
            Log.i("i", "@@@ localText normal tosd");
            s(obj, false);
            return;
        }
        BdUtilHelper.showToast(getContext(), "您按得太快，我都跟不上了~");
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.aXZ = 0;
        this.aYd = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aXZ != 3 && ALALiveTextView.this.aXZ != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                        ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                        if (imForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + imForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aXZ);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aXZ == 3) {
                                ALALiveTextView.this.EN();
                            } else if (ALALiveTextView.this.aXZ == 4) {
                                ALALiveTextView.this.C(ALALiveTextView.this.aYa, ALALiveTextView.this.aYb);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aXZ = 0;
                }
            }
        };
        this.aQz = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.aYe = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.v.a.Hs().aZn.aCd;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.v.a.Hs().aZn.aCc;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.aXW);
                if (i2 == 1) {
                    if (ALALiveTextView.this.aXW) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aXZ = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.EN();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.EN();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aYh;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.aYh = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.aYh, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.aXZ = 0;
        this.aYd = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aXZ != 3 && ALALiveTextView.this.aXZ != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                        ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                        if (imForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + imForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aXZ);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aXZ == 3) {
                                ALALiveTextView.this.EN();
                            } else if (ALALiveTextView.this.aXZ == 4) {
                                ALALiveTextView.this.C(ALALiveTextView.this.aYa, ALALiveTextView.this.aYb);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aXZ = 0;
                }
            }
        };
        this.aQz = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.aYe = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.v.a.Hs().aZn.aCd;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.v.a.Hs().aZn.aCc;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.aXW);
                if (i2 == 1) {
                    if (ALALiveTextView.this.aXW) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aXZ = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.EN();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.EN();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aYh;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.aYh = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.aYh, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.aXY = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aXZ = 0;
        this.aYd = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aXZ != 3 && ALALiveTextView.this.aXZ != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                        ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                        if (imForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + imForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aXZ);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aXZ == 3) {
                                ALALiveTextView.this.EN();
                            } else if (ALALiveTextView.this.aXZ == 4) {
                                ALALiveTextView.this.C(ALALiveTextView.this.aYa, ALALiveTextView.this.aYb);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aXZ = 0;
                }
            }
        };
        this.aQz = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.aYe = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.v.a.Hs().aZn.aCd;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.v.a.Hs().aZn.aCc;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.aXW);
                if (i2 == 1) {
                    if (ALALiveTextView.this.aXW) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aXZ = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.EN();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.EN();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aYh;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.aYh = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.aYh, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aXZ = 0;
        this.aYd = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aXZ != 3 && ALALiveTextView.this.aXZ != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                        ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                        if (imForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + imForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aXZ);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aXZ == 3) {
                                ALALiveTextView.this.EN();
                            } else if (ALALiveTextView.this.aXZ == 4) {
                                ALALiveTextView.this.C(ALALiveTextView.this.aYa, ALALiveTextView.this.aYb);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aXZ = 0;
                }
            }
        };
        this.aQz = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.aYe = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i2 = com.baidu.live.v.a.Hs().aZn.aCd;
                if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i22 = com.baidu.live.v.a.Hs().aZn.aCc;
                Log.i("i", "@@@ localText send 1 isw=" + i22 + ", fb=" + ALALiveTextView.this.aXW);
                if (i22 == 1) {
                    if (ALALiveTextView.this.aXW) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aXZ = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.EN();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.EN();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aYh;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.aYh = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.aYh, i2);
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
        EO();
        EP();
        EQ();
        this.aXU = 50;
    }

    private void EO() {
        this.aXN = (Switch) findViewById(a.g.switch_barrage);
        this.aXL = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        this.aXM = (FrameLayout) findViewById(a.g.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913216, c.class, this.aXY);
        if (runTask != null) {
            this.aXK = (c) runTask.getData();
        }
        if (this.aXK != null) {
            this.aXL.addView(this.aXK.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913215, b.class, this.aXY);
        if (runTask2 != null) {
            this.aXI = (b) runTask2.getData();
        }
        if (this.aXI != null) {
            this.aXM.addView(this.aXI.getView());
        }
        if (this.aXK != null) {
            this.aXK.setCallback(new e() { // from class: com.baidu.live.im.view.ALALiveTextView.13
                @Override // com.baidu.live.im.b.e
                public boolean Eg() {
                    return ALALiveTextView.this.aXR != null && ALALiveTextView.this.aXR.DJ();
                }

                @Override // com.baidu.live.im.b.e
                public void cj(int i) {
                    ALALiveTextView.this.EZ();
                    ALALiveTextView.this.bO(false);
                }

                @Override // com.baidu.live.im.b.e
                public int DK() {
                    if (ALALiveTextView.this.aXR != null) {
                        return ALALiveTextView.this.aXR.DK();
                    }
                    return 0;
                }
            });
        }
        this.aXN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.bN(z);
            }
        });
    }

    private void EP() {
        this.aXO = (EditText) findViewById(a.g.edit_text);
        this.aXO.addTextChangedListener(this.mTextWatcher);
        this.aXO.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aXO.getText())) {
                        ALALiveTextView.this.s(ALALiveTextView.this.aXO.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.aXP = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.aXP.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.aXO, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.aXO, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.aXP.setOnClickListener(this.aYe);
        this.aXP.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.aXW = z;
        this.aXX = i;
        this.aNQ = i2;
        this.mUserName = str;
    }

    private void EQ() {
        this.aXG = (FrameLayout) findViewById(a.g.quick_input_header);
        this.aXH = (FrameLayout) findViewById(a.g.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913217, com.baidu.live.im.d.b.class, this.aXY);
        if (runTask != null) {
            this.aXQ = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.aXQ != null) {
            this.aXH.addView(this.aXQ.getView());
            this.aXQ.setCallback(new b.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void B(String str, int i) {
                    if (com.baidu.live.v.a.Hs().aZn.aCd == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.v.a.Hs().aZn.aCc == 1) {
                        if (ALALiveTextView.this.aXW) {
                            ALALiveTextView.this.aYa = str;
                            ALALiveTextView.this.aYb = i;
                            ALALiveTextView.this.aXZ = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.C(str, i);
                    } else {
                        ALALiveTextView.this.C(str, i);
                    }
                }
            });
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913218, com.baidu.live.im.d.a.class, this.aXY);
        if (runTask2 != null) {
            this.aXJ = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.aXJ != null) {
            this.aXG.addView(this.aXJ.getView());
            this.aXJ.setCallback(new a.InterfaceC0168a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0168a
                public void B(String str, int i) {
                    if (com.baidu.live.v.a.Hs().aZn.aCd == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.v.a.Hs().aZn.aCc == 1) {
                        if (ALALiveTextView.this.aXW) {
                            ALALiveTextView.this.aYa = str;
                            ALALiveTextView.this.aYb = i;
                            ALALiveTextView.this.aXZ = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.C(str, i);
                    } else {
                        ALALiveTextView.this.C(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0168a
                public void Ey() {
                    if (ALALiveTextView.this.aXR != null) {
                        ALALiveTextView.this.aXR.DH();
                    }
                    LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(String str, int i) {
        s(str, true);
        LogManager.getCommonLogger().doClickQuickImPanelLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.aXV = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean ER() {
        return this.aXN != null && this.aXN.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean ES() {
        return !EW() && this.aXG.getVisibility() == 0;
    }

    public bp getBarrageInfo() {
        if (this.aXK != null) {
            return this.aXK.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.aXO.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0192a interfaceC0192a) {
        this.aXR = interfaceC0192a;
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

    public void fy(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean ET() {
        return getView().getVisibility() == 0 && this.aXH.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.aXH.setVisibility(0);
            if (this.aXT < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.aXQ != null) {
                    this.aXQ.EA();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXH.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.aXH.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.aXH.setVisibility(8);
        if (this.aXO != null) {
            this.aXO.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void EU() {
        if (this.aXO != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.aXO);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.aXT - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aXY = bdPageContext;
    }

    public void EV() {
        this.aXO.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.aXO.getSelectionStart();
            Editable editableText = this.aXO.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.aXO.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.aYc = alaLiveInfoData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aJA = map;
        EY();
        this.aXO.requestFocus();
        if (this.aXO != null) {
            this.aXO.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.aXO.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                    }
                    ALALiveTextView.this.getView().setVisibility(0);
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.aXO);
                }
            });
        }
        boolean EW = EW();
        if (list == null || list.isEmpty() || EW) {
            if (this.aXJ != null) {
                this.aXJ.setData(list);
            }
            this.aXH.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.aXJ != null) {
            if (arrayList.size() >= 3) {
                this.aXJ.setData(arrayList.subList(0, 3));
            } else {
                this.aXJ.setData(arrayList);
            }
        }
        this.aXG.setVisibility(ER() ? 8 : 0);
        this.aXH.setVisibility(0);
        if (this.aXQ != null) {
            this.aXQ.Ez();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aXH.getLayoutParams();
        layoutParams.height = -2;
        this.aXH.setLayoutParams(layoutParams);
        if (this.aXQ != null) {
            this.aXQ.setData(arrayList);
        }
        this.aXH.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.aXT = ALALiveTextView.this.aXH.getHeight();
                ALALiveTextView.this.aXH.setVisibility(8);
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
        this.aXO.clearFocus();
        if (this.aXI != null) {
            this.aXI.release();
        }
        setVisibility(8);
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.aXK != null) {
            this.aXK.f(map);
        }
    }

    private boolean EW() {
        return (this.aYc == null || this.aYc.mAlaLiveSwitchData == null || !this.aYc.mAlaLiveSwitchData.mQuickChatInvalid) ? false : true;
    }

    private boolean EX() {
        return (this.aYc == null || this.aYc.mAlaLiveSwitchData == null || !this.aYc.mAlaLiveSwitchData.mPayBarrageInvalid) ? false : true;
    }

    private void EY() {
        if (this.aXV || EX()) {
            this.aXN.setVisibility(8);
            return;
        }
        final bp[] e = d.Ea().e(this.aXR != null && this.aXR.DJ(), this.aXR != null ? this.aXR.DK() : 0);
        if (e == null || e.length <= 0) {
            if (this.aXN.isChecked()) {
                this.aXN.setChecked(false, false);
            } else {
                bN(false);
            }
            this.aXN.setVisibility(8);
            return;
        }
        this.aXN.setVisibility(0);
        if (this.aXK != null) {
            if (this.aXK.getView().getWidth() <= 0) {
                this.aXL.setVisibility(0);
            }
            this.aXK.getView().post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.Ea().Ec()) {
                        ALALiveTextView.this.aXK.setData(e, ALALiveTextView.this.aJA, 0);
                        if (ALALiveTextView.this.aXN.isChecked()) {
                            ALALiveTextView.this.aXK.setSelectId(d.Ea().Ed());
                            ALALiveTextView.this.EZ();
                            ALALiveTextView.this.bO(true);
                        } else {
                            ALALiveTextView.this.aXN.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.aXN.isChecked()) {
                        ALALiveTextView.this.aXN.setChecked(false, false);
                    }
                    ALALiveTextView.this.aXL.setVisibility(ALALiveTextView.this.aXN.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.aXP != null) {
            if (TextUtils.isEmpty(this.aXO.getText())) {
                this.aXP.setClickable(false);
            } else {
                this.aXP.setClickable(true);
            }
        }
        if (this.aXO.getText().length() > this.aXU) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aXU)));
            if (charSequence.length() > this.aXU) {
                this.aXO.setText(charSequence.subSequence(0, this.aXU));
                this.aXO.setSelection(this.aXO.getText().length());
                return;
            }
            this.aXO.setText(charSequence);
            if (i <= charSequence.length()) {
                this.aXO.setSelection(i);
            } else {
                this.aXO.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EZ() {
        if (this.aXK != null) {
            bp selectInfo = this.aXK.getSelectInfo();
            if (this.aXO != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.aXO.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.aXO.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aFH == 7) {
                            this.aXO.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.aXO.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_barrage));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        if (z && this.aXR != null && !this.aXR.DF()) {
            this.aXN.setChecked(false, false);
            return;
        }
        this.aXU = z ? 20 : 50;
        if (z && this.aXO != null && this.aXO.getText() != null && this.aXO.getText().length() > this.aXU) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aXU)));
        }
        if (this.aXK != null) {
            if (z) {
                this.aXK.setData(d.Ea().e(this.aXR != null && this.aXR.DJ(), this.aXR != null ? this.aXR.DK() : 0), this.aJA, 0);
                this.aXK.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.Ea().Ed())) {
                    this.aXK.setSelectId(d.Ea().Ed());
                } else {
                    this.aXK.setSelectPos(0);
                }
                if (this.aXL != null) {
                    this.aXL.setVisibility(0);
                }
                bO(true);
                this.aXG.setVisibility(8);
                EZ();
                setQuickInputPanelVisible(false);
                if (this.aXY != null && this.aXY.getPageActivity() != null && this.aXO != null) {
                    BdUtilHelper.showSoftKeyPad(this.aXY.getPageActivity(), this.aXO);
                }
            } else {
                this.aXK.setSwitchStatus(false);
                if (this.aXM != null) {
                    this.aXM.setVisibility(8);
                }
                if (this.aXL != null) {
                    this.aXL.setVisibility(8);
                }
                if (!EW()) {
                    this.aXG.setVisibility(0);
                }
                if (this.aXO != null) {
                    this.aXO.setHint(a.i.sdk_im_sendmessage_to_host);
                }
            }
            if (this.aXR != null) {
                this.aXR.DI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(boolean z) {
        if (z && this.aXI != null) {
            this.aXI.setPreview();
        }
        if (this.aXI != null && this.aXK != null) {
            this.aXI.setUIInfo(this.aXK.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.aXM != null) {
                this.aXM.setVisibility(8);
            }
        } else if (this.aXN != null && this.aXN.isChecked() && this.aXM != null) {
            this.aXM.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, boolean z) {
        if (this.aXR != null) {
            Log.i("i", "@@@ localText st go");
            this.aXR.r(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                if (this.aXM != null) {
                    this.aXM.setVisibility(8);
                }
            } else if (this.aXN != null && this.aXN.isChecked() && this.aXM != null) {
                this.aXM.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void Fa() {
        if (this.aXO != null) {
            this.aXO.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.aXO.requestFocus();
                }
            });
        }
    }
}

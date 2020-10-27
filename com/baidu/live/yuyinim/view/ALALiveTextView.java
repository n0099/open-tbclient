package com.baidu.live.yuyinim.view;

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
import com.baidu.live.data.ce;
import com.baidu.live.im.b.b;
import com.baidu.live.im.b.c;
import com.baidu.live.im.b.d;
import com.baidu.live.im.b.e;
import com.baidu.live.im.d.a;
import com.baidu.live.im.d.b;
import com.baidu.live.im.data.YuyinImForbiddenStateData;
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
    private Map<String, Integer> aVk;
    private int bab;
    public CustomMessageListener bcQ;
    private FrameLayout bkY;
    private FrameLayout bkZ;
    private b bla;
    private com.baidu.live.im.d.a blb;
    private c blc;
    private FrameLayout bld;
    private FrameLayout ble;
    private Switch blf;
    private EditText blg;
    private GradientEnableTextView blh;
    private com.baidu.live.im.d.b bli;
    private a.InterfaceC0220a blj;
    private long blk;
    private int bll;
    private int blm;
    private boolean bln;
    private boolean blo;
    private int blp;
    private BdPageContext blq;
    private int blr;
    private String bls;
    private int blt;
    private AlaLiveInfoData blu;
    public CustomMessageListener blw;
    private View.OnClickListener blx;
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
            if (yuyinImForbiddenStateData.foreverInfo != null && yuyinImForbiddenStateData.foreverInfo.bkr == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), yuyinImForbiddenStateData.foreverInfo.bks);
            }
            this.mDialog = new BdAlertDialog(this.blq.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.10
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
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.11
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
            this.mDialog.create(this.blq);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (yuyinImForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (yuyinImForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void My() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.blk >= 2000) {
            this.blk = currentTimeMillis;
            String obj = this.blg.getText().toString();
            if (obj.length() > this.blm) {
                obj = obj.subSequence(0, this.blm).toString();
            }
            Log.i("i", "@@@ localText normal tosd");
            t(obj, false);
            return;
        }
        BdUtilHelper.showToast(getContext(), "您按得太快，我都跟不上了~");
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.blr = 0;
        this.blw = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.blr != 3 && ALALiveTextView.this.blr != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                        if (yuyinImForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + yuyinImForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.blr);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.blr == 3) {
                                ALALiveTextView.this.My();
                            } else if (ALALiveTextView.this.blr == 4) {
                                ALALiveTextView.this.D(ALALiveTextView.this.bls, ALALiveTextView.this.blt);
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.blr = 0;
                }
            }
        };
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.blx = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.z.a.Pq().bmJ.aMo;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.z.a.Pq().bmJ.aMn;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.blo);
                if (i2 == 1) {
                    if (ALALiveTextView.this.blo) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.blr = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.My();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.My();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.12
            private CharSequence blA;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.blA = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.blA, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, BdPageContext bdPageContext) {
        super(context);
        this.blr = 0;
        this.blw = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.blr != 3 && ALALiveTextView.this.blr != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                        if (yuyinImForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + yuyinImForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.blr);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.blr == 3) {
                                ALALiveTextView.this.My();
                            } else if (ALALiveTextView.this.blr == 4) {
                                ALALiveTextView.this.D(ALALiveTextView.this.bls, ALALiveTextView.this.blt);
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.blr = 0;
                }
            }
        };
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.blx = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.z.a.Pq().bmJ.aMo;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.z.a.Pq().bmJ.aMn;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.blo);
                if (i2 == 1) {
                    if (ALALiveTextView.this.blo) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.blr = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.My();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.My();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.12
            private CharSequence blA;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.blA = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.blA, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        this.blq = bdPageContext;
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blr = 0;
        this.blw = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.blr != 3 && ALALiveTextView.this.blr != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                        if (yuyinImForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + yuyinImForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.blr);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.blr == 3) {
                                ALALiveTextView.this.My();
                            } else if (ALALiveTextView.this.blr == 4) {
                                ALALiveTextView.this.D(ALALiveTextView.this.bls, ALALiveTextView.this.blt);
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.blr = 0;
                }
            }
        };
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.blx = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.z.a.Pq().bmJ.aMo;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.z.a.Pq().bmJ.aMn;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.blo);
                if (i2 == 1) {
                    if (ALALiveTextView.this.blo) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.blr = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.My();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.My();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.12
            private CharSequence blA;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.blA = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.blA, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blr = 0;
        this.blw = new CustomMessageListener(2913193) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.blr != 3 && ALALiveTextView.this.blr != 4) {
                        Log.i("i", "@@@ localText pcbanreslist ret");
                        return;
                    }
                    if (customResponsedMessage.getData() instanceof YuyinImForbiddenStateData) {
                        YuyinImForbiddenStateData yuyinImForbiddenStateData = (YuyinImForbiddenStateData) customResponsedMessage.getData();
                        if (yuyinImForbiddenStateData.errno != 0) {
                            Log.i("i", "@@@ localText pcbanreslist er=" + yuyinImForbiddenStateData.errno);
                            BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_im_ban_no_net_tips));
                            return;
                        }
                        Log.i("i", "@@@ localText pcbanreslist banst=" + yuyinImForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.blr);
                        if (yuyinImForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.blr == 3) {
                                ALALiveTextView.this.My();
                            } else if (ALALiveTextView.this.blr == 4) {
                                ALALiveTextView.this.D(ALALiveTextView.this.bls, ALALiveTextView.this.blt);
                            }
                        } else {
                            ALALiveTextView.this.a(yuyinImForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.blr = 0;
                }
            }
        };
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        this.blx = new View.OnClickListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i2 = com.baidu.live.z.a.Pq().bmJ.aMo;
                if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i22 = com.baidu.live.z.a.Pq().bmJ.aMn;
                Log.i("i", "@@@ localText send 1 isw=" + i22 + ", fb=" + ALALiveTextView.this.blo);
                if (i22 == 1) {
                    if (ALALiveTextView.this.blo) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.blr = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.My();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.My();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.12
            private CharSequence blA;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.blA = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.blA, i2);
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
        LayoutInflater.from(context).inflate(a.h.yuyinala_im_input_layout, (ViewGroup) this, true);
        Mz();
        MA();
        MB();
        this.blm = 50;
    }

    private void Mz() {
        this.blf = (Switch) findViewById(a.g.switch_barrage);
        this.bld = (FrameLayout) findViewById(a.g.hlv_barrage_option);
        this.ble = (FrameLayout) findViewById(a.g.barrage_preview);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501050, c.class, this.blq);
        if (runTask != null) {
            this.blc = (c) runTask.getData();
        }
        if (this.blc != null) {
            this.bld.addView(this.blc.getView());
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501051, b.class, this.blq);
        if (runTask2 != null) {
            this.bla = (b) runTask2.getData();
        }
        if (this.bla != null) {
            this.ble.addView(this.bla.getView());
        }
        if (this.blc != null) {
            this.blc.setCallback(new e() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.13
                @Override // com.baidu.live.im.b.e
                public boolean LN() {
                    return ALALiveTextView.this.blj != null && ALALiveTextView.this.blj.Lq();
                }

                @Override // com.baidu.live.im.b.e
                public void ei(int i) {
                    ALALiveTextView.this.MK();
                    ALALiveTextView.this.cb(false);
                }

                @Override // com.baidu.live.im.b.e
                public int Lr() {
                    if (ALALiveTextView.this.blj != null) {
                        return ALALiveTextView.this.blj.Lr();
                    }
                    return 0;
                }
            });
        }
        this.blf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.ca(z);
            }
        });
    }

    private void MA() {
        this.blg = (EditText) findViewById(a.g.edit_text);
        this.blg.addTextChangedListener(this.mTextWatcher);
        this.blg.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.blg.getText())) {
                        ALALiveTextView.this.t(ALALiveTextView.this.blg.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.blh = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.blh.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.blg, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.blg, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.blh.setOnClickListener(this.blx);
        this.blh.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.blo = z;
        this.blp = i;
        this.bab = i2;
        this.mUserName = str;
    }

    private void MB() {
        this.bkY = (FrameLayout) findViewById(a.g.quick_input_header);
        this.bkZ = (FrameLayout) findViewById(a.g.quick_input_panel);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2501038, com.baidu.live.im.d.b.class, this.blq);
        if (runTask != null) {
            this.bli = (com.baidu.live.im.d.b) runTask.getData();
        }
        if (this.bli != null) {
            this.bkZ.addView(this.bli.getView());
            this.bli.setCallback(new b.a() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.2
                @Override // com.baidu.live.im.d.b.a
                public void C(String str, int i) {
                    if (com.baidu.live.z.a.Pq().bmJ.aMo == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.z.a.Pq().bmJ.aMn == 1) {
                        if (ALALiveTextView.this.blo) {
                            ALALiveTextView.this.bls = str;
                            ALALiveTextView.this.blt = i;
                            ALALiveTextView.this.blr = 4;
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
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2501039, com.baidu.live.im.d.a.class, this.blq);
        if (runTask2 != null) {
            this.blb = (com.baidu.live.im.d.a) runTask2.getData();
        }
        if (this.blb != null) {
            this.bkY.addView(this.blb.getView());
            this.blb.setCallback(new a.InterfaceC0187a() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.3
                @Override // com.baidu.live.im.d.a.InterfaceC0187a
                public void C(String str, int i) {
                    if (com.baidu.live.z.a.Pq().bmJ.aMo == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                        BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    } else if (com.baidu.live.z.a.Pq().bmJ.aMn == 1) {
                        if (ALALiveTextView.this.blo) {
                            ALALiveTextView.this.bls = str;
                            ALALiveTextView.this.blt = i;
                            ALALiveTextView.this.blr = 4;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                            return;
                        }
                        ALALiveTextView.this.D(str, i);
                    } else {
                        ALALiveTextView.this.D(str, i);
                    }
                }

                @Override // com.baidu.live.im.d.a.InterfaceC0187a
                public void Mj() {
                    if (ALALiveTextView.this.blj != null) {
                        ALALiveTextView.this.blj.Lo();
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
        this.bln = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean MC() {
        return this.blf != null && this.blf.isChecked();
    }

    @Override // com.baidu.live.view.input.a
    public boolean MD() {
        return !MH() && this.bkY.getVisibility() == 0;
    }

    public ce getBarrageInfo() {
        if (this.blc != null) {
            return this.blc.getSelectInfo();
        }
        return null;
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.blg.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0220a interfaceC0220a) {
        this.blj = interfaceC0220a;
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

    public void hF(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean ME() {
        return getView().getVisibility() == 0 && this.bkZ.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.bkZ.setVisibility(0);
            if (this.bll < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                if (this.bli != null) {
                    this.bli.Ml();
                }
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.bkZ.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.bkZ.setVisibility(8);
        if (this.blg != null) {
            this.blg.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void MF() {
        if (this.blg != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.blg);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.bll - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.blq = bdPageContext;
    }

    public void MG() {
        this.blg.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.blg.getSelectionStart();
            Editable editableText = this.blg.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.blg.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map, AlaLiveInfoData alaLiveInfoData) {
        this.blu = alaLiveInfoData;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aVk = map;
        MJ();
        this.blg.requestFocus();
        if (this.blg != null) {
            this.blg.post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.blg.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.blg);
                }
            });
        }
        boolean MH = MH();
        if (list == null || list.isEmpty() || MH) {
            if (this.blb != null) {
                this.blb.setData(list);
            }
            this.bkZ.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (this.blb != null) {
            if (arrayList.size() >= 3) {
                this.blb.setData(arrayList.subList(0, 3));
            } else {
                this.blb.setData(arrayList);
            }
        }
        this.bkY.setVisibility(MC() ? 8 : 0);
        this.bkZ.setVisibility(0);
        if (this.bli != null) {
            this.bli.Mk();
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bkZ.getLayoutParams();
        layoutParams.height = -2;
        this.bkZ.setLayoutParams(layoutParams);
        if (this.bli != null) {
            this.bli.setData(arrayList);
        }
        this.bkZ.post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.bll = ALALiveTextView.this.bkZ.getHeight();
                ALALiveTextView.this.bkZ.setVisibility(8);
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
        this.blg.clearFocus();
        if (this.bla != null) {
            this.bla.release();
        }
        setVisibility(8);
    }

    public void g(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.blc != null) {
            this.blc.f(map);
        }
    }

    private boolean MH() {
        return (this.blu == null || this.blu.mAlaLiveSwitchData == null || !this.blu.mAlaLiveSwitchData.isQuickChatUnabled()) ? false : true;
    }

    private boolean MI() {
        return (this.blu == null || this.blu.mAlaLiveSwitchData == null || !this.blu.mAlaLiveSwitchData.isYuyinPayBarrageUnabled()) ? false : true;
    }

    private void MJ() {
        if (this.bln || MI()) {
            this.blf.setVisibility(8);
            return;
        }
        final ce[] eK = d.LG().eK(this.blj != null ? this.blj.Lr() : 0);
        if (eK == null || eK.length <= 0) {
            if (this.blf.isChecked()) {
                this.blf.setChecked(false, false);
            } else {
                ca(false);
            }
            this.blf.setVisibility(8);
            return;
        }
        this.blf.setVisibility(0);
        if (this.blc != null) {
            if (this.blc.getView().getWidth() <= 0) {
                this.bld.setVisibility(0);
            }
            this.blc.getView().post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (d.LG().LJ()) {
                        ALALiveTextView.this.blc.setData(eK, ALALiveTextView.this.aVk, 0);
                        if (ALALiveTextView.this.blf.isChecked()) {
                            ALALiveTextView.this.blc.setSelectId(d.LG().LK());
                            ALALiveTextView.this.MK();
                            ALALiveTextView.this.cb(true);
                        } else {
                            ALALiveTextView.this.blf.setChecked(true, false);
                        }
                    } else if (ALALiveTextView.this.blf.isChecked()) {
                        ALALiveTextView.this.blf.setChecked(false, false);
                    }
                    ALALiveTextView.this.bld.setVisibility(ALALiveTextView.this.blf.isChecked() ? 0 : 8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.blh != null) {
            if (TextUtils.isEmpty(this.blg.getText())) {
                this.blh.setClickable(false);
            } else {
                this.blh.setClickable(true);
            }
        }
        if (this.blg.getText().length() > this.blm) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.blm)));
            if (charSequence.length() > this.blm) {
                this.blg.setText(charSequence.subSequence(0, this.blm));
                this.blg.setSelection(this.blg.getText().length());
                return;
            }
            this.blg.setText(charSequence);
            if (i <= charSequence.length()) {
                this.blg.setSelection(i);
            } else {
                this.blg.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MK() {
        if (this.blc != null) {
            ce selectInfo = this.blc.getSelectInfo();
            if (this.blg != null && selectInfo != null) {
                switch (selectInfo.type) {
                    case 1:
                        this.blg.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                        return;
                    case 16:
                        this.blg.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                        return;
                    case 17:
                        if (selectInfo.aQp == 7) {
                            this.blg.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_king_barrage));
                            return;
                        } else {
                            this.blg.setHint(getResources().getString(a.i.sdk_im_sendmessage_noble_barrage));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(boolean z) {
        if (z && this.blj != null && !this.blj.Lm()) {
            this.blf.setChecked(false, false);
            return;
        }
        this.blm = z ? 20 : 50;
        if (z && this.blg != null && this.blg.getText() != null && this.blg.getText().length() > this.blm) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.blm)));
        }
        if (this.blc != null) {
            if (z) {
                this.blc.setData(d.LG().eK(this.blj != null ? this.blj.Lr() : 0), this.aVk, 0);
                this.blc.setSwitchStatus(true);
                if (!TextUtils.isEmpty(d.LG().LK())) {
                    this.blc.setSelectId(d.LG().LK());
                } else {
                    this.blc.setSelectPos(0);
                }
                if (this.bld != null) {
                    this.bld.setVisibility(0);
                }
                cb(true);
                this.bkY.setVisibility(8);
                MK();
                setQuickInputPanelVisible(false);
                if (this.blq != null && this.blq.getPageActivity() != null && this.blg != null) {
                    BdUtilHelper.showSoftKeyPad(this.blq.getPageActivity(), this.blg);
                }
            } else {
                this.blc.setSwitchStatus(false);
                if (this.ble != null) {
                    this.ble.setVisibility(8);
                }
                if (this.bld != null) {
                    this.bld.setVisibility(8);
                }
                if (!MH()) {
                    this.bkY.setVisibility(0);
                }
                if (this.blg != null) {
                    this.blg.setHint(a.i.sdk_im_sendmessage_to_host);
                }
            }
            if (this.blj != null) {
                this.blj.Lp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(boolean z) {
        if (z && this.bla != null) {
            this.bla.setPreview();
        }
        if (this.bla != null && this.blc != null) {
            this.bla.setUIInfo(this.blc.getSelectInfo(), z);
        }
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            if (this.ble != null) {
                this.ble.setVisibility(8);
            }
        } else if (this.blf != null && this.blf.isChecked() && this.ble != null) {
            this.ble.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, boolean z) {
        if (this.blj != null) {
            Log.i("i", "@@@ localText st go");
            this.blj.s(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                if (this.ble != null) {
                    this.ble.setVisibility(8);
                }
            } else if (this.blf != null && this.blf.isChecked() && this.ble != null) {
                this.ble.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void ML() {
        if (this.blg != null) {
            this.blg.post(new Runnable() { // from class: com.baidu.live.yuyinim.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.blg.requestFocus();
                }
            });
        }
    }
}

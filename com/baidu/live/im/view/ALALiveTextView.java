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
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.be;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.m;
import com.baidu.live.im.view.barrage.ImBarrageItemView;
import com.baidu.live.im.view.barrage.ImBarrageOptionListView;
import com.baidu.live.im.view.quick.QuickImInputHeaderView;
import com.baidu.live.im.view.quick.QuickImInputPanelView;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tieba.view.GradientEnableTextView;
import com.baidu.live.u.a;
import com.baidu.live.view.Switch;
import com.baidu.live.view.input.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class ALALiveTextView extends LinearLayout implements com.baidu.live.view.input.a {
    private Map<String, Integer> aAi;
    private int aEi;
    public CustomMessageListener aGM;
    private ImBarrageItemView aNT;
    private QuickImInputHeaderView aNU;
    private ImBarrageOptionListView aNV;
    private Switch aNW;
    private EditText aNX;
    private GradientEnableTextView aNY;
    private QuickImInputPanelView aNZ;
    private boolean aNg;
    private int aNh;
    private int aNi;
    public CustomMessageListener aNj;
    private a.InterfaceC0130a aOa;
    private long aOb;
    private int aOc;
    private int aOd;
    private boolean aOe;
    private BdPageContext aOf;
    private String aOg;
    private int aOh;
    private View.OnClickListener aOi;
    private Context mContext;
    private BdAlertDialog mDialog;
    private String mOtherParams;
    private TextWatcher mTextWatcher;
    private String mUserName;
    private String mVid;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        Log.i("i", "@@@ localText swfbwtst gb=" + imForbiddenStateData.globalBan + ",cb=" + imForbiddenStateData.anchorBan + ",bl=" + imForbiddenStateData.liveBan);
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aNt == 1) {
                format = getContext().getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(getContext().getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aNu);
            }
            this.mDialog = new BdAlertDialog(this.aOf.getPageActivity());
            this.mDialog.setMessage(format);
            this.mDialog.setPositiveButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.9
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
            this.mDialog.setNegativeButton(getContext().getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.10
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
            this.mDialog.create(this.aOf);
            this.mDialog.setCanceledOnTouchOutside(false);
            this.mDialog.show();
        } else if (imForbiddenStateData.anchorBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_2));
        } else if (imForbiddenStateData.liveBan == 1) {
            BdUtilHelper.showToast(getContext(), getContext().getResources().getString(a.i.ala_forbidden_words_is_block_1));
        }
    }

    public void zr() {
        this.aGM = new CustomMessageListener(2913097) { // from class: com.baidu.live.im.view.ALALiveTextView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (ALALiveTextView.this.mDialog != null && ALALiveTextView.this.mDialog.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    ALALiveTextView.this.mDialog.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.aGM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CI() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aOb >= 2000) {
            this.aOb = currentTimeMillis;
            String obj = this.aNX.getText().toString();
            if (obj.length() > this.aOd) {
                obj = obj.subSequence(0, this.aOd).toString();
            }
            Log.i("i", "@@@ localText normal tosd");
            o(obj, false);
            return;
        }
        BdUtilHelper.showToast(getContext(), "您按得太快，我都跟不上了~");
    }

    public ALALiveTextView(Context context) {
        super(context);
        this.aNi = 0;
        this.aNj = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aNi != 3 && ALALiveTextView.this.aNi != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aNi);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aNi == 3) {
                                ALALiveTextView.this.CI();
                            } else if (ALALiveTextView.this.aNi == 4) {
                                ALALiveTextView.this.x(ALALiveTextView.this.aOg, ALALiveTextView.this.aOh);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aNi = 0;
                }
            }
        };
        this.aOi = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.v.a.Eo().aQp.atx;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.v.a.Eo().aQp.atw;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.aNg);
                if (i2 == 1) {
                    if (ALALiveTextView.this.aNg) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aNi = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.CI();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.CI();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aOl;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.aOl = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.aOl, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNi = 0;
        this.aNj = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aNi != 3 && ALALiveTextView.this.aNi != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aNi);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aNi == 3) {
                                ALALiveTextView.this.CI();
                            } else if (ALALiveTextView.this.aNi == 4) {
                                ALALiveTextView.this.x(ALALiveTextView.this.aOg, ALALiveTextView.this.aOh);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aNi = 0;
                }
            }
        };
        this.aOi = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i = com.baidu.live.v.a.Eo().aQp.atx;
                if (i == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i2 = com.baidu.live.v.a.Eo().aQp.atw;
                Log.i("i", "@@@ localText send 1 isw=" + i2 + ", fb=" + ALALiveTextView.this.aNg);
                if (i2 == 1) {
                    if (ALALiveTextView.this.aNg) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aNi = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.CI();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.CI();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aOl;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.aOl = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ALALiveTextView.this.a(this.aOl, i);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        };
        init(context);
    }

    public ALALiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNi = 0;
        this.aNj = new CustomMessageListener(2913193) { // from class: com.baidu.live.im.view.ALALiveTextView.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Log.i("i", "@@@ localText pcbanreslist");
                if (customResponsedMessage != null) {
                    if (ALALiveTextView.this.aNi != 3 && ALALiveTextView.this.aNi != 4) {
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
                        Log.i("i", "@@@ localText pcbanreslist banst=" + imForbiddenStateData.banState + ",chkbanstp=" + ALALiveTextView.this.aNi);
                        if (imForbiddenStateData.banState == 0) {
                            if (ALALiveTextView.this.aNi == 3) {
                                ALALiveTextView.this.CI();
                            } else if (ALALiveTextView.this.aNi == 4) {
                                ALALiveTextView.this.x(ALALiveTextView.this.aOg, ALALiveTextView.this.aOh);
                            }
                        } else {
                            ALALiveTextView.this.a(imForbiddenStateData);
                        }
                    }
                    ALALiveTextView.this.aNi = 0;
                }
            }
        };
        this.aOi = new View.OnClickListener() { // from class: com.baidu.live.im.view.ALALiveTextView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.i("i", "@@@ localText send click");
                int i2 = com.baidu.live.v.a.Eo().aQp.atx;
                if (i2 == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    Log.i("i", "@@@ localText send err sw=" + i2 + ", lg=" + LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined());
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                    return;
                }
                int i22 = com.baidu.live.v.a.Eo().aQp.atw;
                Log.i("i", "@@@ localText send 1 isw=" + i22 + ", fb=" + ALALiveTextView.this.aNg);
                if (i22 == 1) {
                    if (ALALiveTextView.this.aNg) {
                        Log.i("i", "@@@ localText send 2 go req ban");
                        ALALiveTextView.this.aNi = 3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    Log.i("i", "@@@ localText send 2 go normal");
                    ALALiveTextView.this.CI();
                    return;
                }
                Log.i("i", "@@@ localText send 2 go normal");
                ALALiveTextView.this.CI();
            }
        };
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.live.im.view.ALALiveTextView.12
            private CharSequence aOl;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                this.aOl = charSequence.subSequence(0, charSequence.length());
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i22, int i3) {
                ALALiveTextView.this.a(this.aOl, i2);
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
        CJ();
        CK();
        CL();
        this.aOd = 50;
    }

    private void CJ() {
        this.aNT = (ImBarrageItemView) findViewById(a.g.barrage_preview);
        this.aNV = (ImBarrageOptionListView) findViewById(a.g.hlv_barrage_option);
        this.aNW = (Switch) findViewById(a.g.switch_barrage);
        this.aNV.setCallback(new ImBarrageOptionListView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.13
            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public boolean Ce() {
                return ALALiveTextView.this.aOa != null && ALALiveTextView.this.aOa.Bl();
            }

            @Override // com.baidu.live.im.view.barrage.ImBarrageOptionListView.a
            public void bO(int i) {
                ALALiveTextView.this.CR();
                ALALiveTextView.this.bC(false);
            }
        });
        this.aNW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.live.im.view.ALALiveTextView.14
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ALALiveTextView.this.bB(z);
            }
        });
    }

    private void CK() {
        this.aNX = (EditText) findViewById(a.g.edit_text);
        this.aNX.addTextChangedListener(this.mTextWatcher);
        this.aNX.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.baidu.live.im.view.ALALiveTextView.15
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    if (!TextUtils.isEmpty(ALALiveTextView.this.aNX.getText())) {
                        ALALiveTextView.this.o(ALALiveTextView.this.aNX.getText().toString(), false);
                    }
                    return true;
                }
                return false;
            }
        });
        this.aNY = (GradientEnableTextView) findViewById(a.g.tv_send);
        this.aNY.setCheckStrEquals(false);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(this.aNX, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
            try {
                Field declaredField2 = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField2.setAccessible(true);
                declaredField2.set(this.aNX, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.aNY.setOnClickListener(this.aOi);
        this.aNY.setClickable(false);
    }

    public void b(boolean z, int i, int i2, String str) {
        this.aNg = z;
        this.aNh = i;
        this.aEi = i2;
        this.mUserName = str;
    }

    private void CL() {
        this.aNU = (QuickImInputHeaderView) findViewById(a.g.quick_input_header);
        this.aNZ = (QuickImInputPanelView) findViewById(a.g.quick_input_panel);
        this.aNU.setCallback(new QuickImInputHeaderView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.2
            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void y(String str, int i) {
                if (com.baidu.live.v.a.Eo().aQp.atx == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Eo().aQp.atw == 1) {
                    if (ALALiveTextView.this.aNg) {
                        ALALiveTextView.this.aOg = str;
                        ALALiveTextView.this.aOh = i;
                        ALALiveTextView.this.aNi = 4;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.x(str, i);
                } else {
                    ALALiveTextView.this.x(str, i);
                }
            }

            @Override // com.baidu.live.im.view.quick.QuickImInputHeaderView.a
            public void CT() {
                if (ALALiveTextView.this.aOa != null) {
                    ALALiveTextView.this.aOa.Bj();
                }
                LogManager.getCommonLogger().doClickQuickImMoreLog(ALALiveTextView.this.mVid, ALALiveTextView.this.mOtherParams);
            }
        });
        this.aNZ.setCallback(new QuickImInputPanelView.a() { // from class: com.baidu.live.im.view.ALALiveTextView.3
            @Override // com.baidu.live.im.view.quick.QuickImInputPanelView.a
            public void y(String str, int i) {
                if (com.baidu.live.v.a.Eo().aQp.atx == 1 && !LoginManager.getInstance(ALALiveTextView.this.mContext).isIMLogined()) {
                    BdUtilHelper.showToast(ALALiveTextView.this.getContext(), ALALiveTextView.this.getContext().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Eo().aQp.atw == 1) {
                    if (ALALiveTextView.this.aNg) {
                        ALALiveTextView.this.aOg = str;
                        ALALiveTextView.this.aOh = i;
                        ALALiveTextView.this.aNi = 4;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                        return;
                    }
                    ALALiveTextView.this.x(str, i);
                } else {
                    ALALiveTextView.this.x(str, i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, int i) {
        o(str, true);
        LogManager.getCommonLogger().doClickQuickImPanelLog(this.mVid, String.valueOf(i), str, this.mOtherParams);
    }

    @Override // com.baidu.live.view.input.a
    public View getView() {
        return this;
    }

    public void setFromMaster(boolean z) {
        this.aOe = z;
    }

    @Override // com.baidu.live.view.input.a
    public boolean CM() {
        return this.aNW != null && this.aNW.isChecked();
    }

    public be getBarrageInfo() {
        return this.aNV.getSelectInfo();
    }

    @Override // com.baidu.live.view.input.a
    public boolean hasText() {
        return !TextUtils.isEmpty(this.aNX.getText().toString());
    }

    public void setMsHandler(a.InterfaceC0130a interfaceC0130a) {
        this.aOa = interfaceC0130a;
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

    public void eI(String str) {
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
    }

    @Override // com.baidu.live.view.input.a
    public boolean CN() {
        return getView().getVisibility() == 0 && this.aNZ.getVisibility() == 0;
    }

    @Override // com.baidu.live.view.input.a
    public void setQuickInputPanelVisible(boolean z) {
        if (z) {
            this.aNZ.setVisibility(0);
            if (this.aOc < TbadkCoreApplication.getInst().getKeyboardHeight()) {
                this.aNZ.Dk();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aNZ.getLayoutParams();
                if (layoutParams.height != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.height = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.aNZ.setLayoutParams(layoutParams);
                }
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
            layoutParams2.bottomMargin = 0;
            getView().setLayoutParams(layoutParams2);
            LogManager.getCommonLogger().doDisplayQuickImPanelLog(this.mVid, this.mOtherParams);
            return;
        }
        this.aNZ.setVisibility(8);
        if (this.aNX != null) {
            this.aNX.requestFocus();
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) getView().getLayoutParams();
                layoutParams3.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                getView().setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void CO() {
        if (this.aNX != null) {
            BdUtilHelper.showSoftKeyPad(getContext(), this.aNX);
        }
    }

    @Override // com.baidu.live.view.input.a
    public int getQuickInputPanelExpandHeight() {
        return this.aOc - TbadkCoreApplication.getInst().getKeyboardHeight();
    }

    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aOf = bdPageContext;
    }

    public void CP() {
        this.aNX.setText("");
    }

    @Override // com.baidu.live.view.input.a
    public void setEditText(String str) {
        if (str != null) {
            int selectionStart = this.aNX.getSelectionStart();
            Editable editableText = this.aNX.getEditableText();
            if (selectionStart < 0 || selectionStart >= editableText.length()) {
                editableText.append((CharSequence) str);
            } else {
                editableText.insert(selectionStart, str);
            }
        }
    }

    public void setHintText(int i) {
        this.aNX.setHint(i);
    }

    @Override // com.baidu.live.view.input.a
    public void a(List<String> list, Map<String, Integer> map) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, true));
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1) {
            bringToFront();
        }
        setVisibility(4);
        this.aAi = map;
        CQ();
        this.aNX.requestFocus();
        if (this.aNX != null) {
            this.aNX.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.4
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.aNX.requestFocus();
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ALALiveTextView.this.getView().getLayoutParams();
                        layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                        ALALiveTextView.this.getView().setLayoutParams(layoutParams);
                        ALALiveTextView.this.getView().setVisibility(0);
                    }
                    BdUtilHelper.showSoftKeyPad(ALALiveTextView.this.getContext(), ALALiveTextView.this.aNX);
                }
            });
        }
        if (list == null || list.isEmpty()) {
            this.aNU.setData(list);
            this.aNZ.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() >= 3) {
            this.aNU.setData(arrayList.subList(0, 3));
        } else {
            this.aNU.setData(arrayList);
        }
        this.aNU.setVisibility(CM() ? 8 : 0);
        this.aNZ.setVisibility(0);
        this.aNZ.Dj();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aNZ.getLayoutParams();
        layoutParams.height = -2;
        this.aNZ.setLayoutParams(layoutParams);
        this.aNZ.setData(arrayList);
        this.aNZ.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.5
            @Override // java.lang.Runnable
            public void run() {
                ALALiveTextView.this.aOc = ALALiveTextView.this.aNZ.getHeight();
                ALALiveTextView.this.aNZ.setVisibility(8);
            }
        });
    }

    @Override // com.baidu.live.view.input.a
    public void show() {
        a((List<String>) null, (Map<String, Integer>) null);
    }

    @Override // com.baidu.live.view.input.a
    public void hide() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913169, false));
        this.aNX.clearFocus();
        if (this.aNT != null) {
            this.aNT.release();
        }
        setVisibility(8);
    }

    public void e(Map<String, Integer> map) {
        if (getVisibility() == 0 && this.aNV != null) {
            this.aNV.f(map);
        }
    }

    private void CQ() {
        if (this.aOe) {
            this.aNW.setVisibility(8);
            return;
        }
        final be[] bw = m.Bp().bw(this.aOa != null && this.aOa.Bl());
        if (bw == null || bw.length <= 0) {
            if (this.aNW.isChecked()) {
                this.aNW.setChecked(false, false);
            } else {
                bB(false);
            }
            this.aNW.setVisibility(8);
            return;
        }
        if (this.aNV.getWidth() <= 0) {
            this.aNV.setVisibility(0);
        }
        this.aNV.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.6
            @Override // java.lang.Runnable
            public void run() {
                if (m.Bp().Br()) {
                    ALALiveTextView.this.aNV.setData(bw, ALALiveTextView.this.aAi, 0);
                    if (ALALiveTextView.this.aNW.isChecked()) {
                        ALALiveTextView.this.aNV.setSelectId(m.Bp().Bs());
                        ALALiveTextView.this.CR();
                        ALALiveTextView.this.bC(true);
                    } else {
                        ALALiveTextView.this.aNW.setChecked(true, false);
                    }
                } else if (ALALiveTextView.this.aNW.isChecked()) {
                    ALALiveTextView.this.aNW.setChecked(false, false);
                }
                ALALiveTextView.this.aNV.setVisibility(ALALiveTextView.this.aNW.isChecked() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i) {
        if (this.aNY != null) {
            if (TextUtils.isEmpty(this.aNX.getText())) {
                this.aNY.setClickable(false);
            } else {
                this.aNY.setClickable(true);
            }
        }
        if (this.aNX.getText().length() > this.aOd) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aOd)));
            if (charSequence.length() > this.aOd) {
                this.aNX.setText(charSequence.subSequence(0, this.aOd));
                this.aNX.setSelection(this.aNX.getText().length());
                return;
            }
            this.aNX.setText(charSequence);
            if (i <= charSequence.length()) {
                this.aNX.setSelection(i);
            } else {
                this.aNX.setSelection(charSequence.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CR() {
        be selectInfo = this.aNV.getSelectInfo();
        if (this.aNX != null && selectInfo != null) {
            switch (selectInfo.type) {
                case 1:
                    this.aNX.setHint(String.format(Locale.getDefault(), getResources().getString(a.i.sdk_im_sendmessage_to_host_barrage), Integer.valueOf(selectInfo.price)));
                    return;
                case 16:
                    this.aNX.setHint(getResources().getString(a.i.sdk_input_hint_barrage_throne));
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        if (z && this.aOa != null && !this.aOa.Bh()) {
            this.aNW.setChecked(false, false);
            return;
        }
        this.aOd = z ? 20 : 50;
        if (z && this.aNX != null && this.aNX.getText() != null && this.aNX.getText().length() > this.aOd) {
            BdUtilHelper.showToast(getContext(), String.format(getResources().getString(a.i.sdk_send_im_over_max), Integer.valueOf(this.aOd)));
        }
        if (z) {
            this.aNV.setData(m.Bp().bw(this.aOa != null && this.aOa.Bl()), this.aAi, 0);
            this.aNV.setSwitchStatus(true);
            if (!TextUtils.isEmpty(m.Bp().Bs())) {
                this.aNV.setSelectId(m.Bp().Bs());
            } else {
                this.aNV.setSelectPos(0);
            }
            this.aNV.setVisibility(0);
            bC(true);
            this.aNU.setVisibility(8);
            CR();
            setQuickInputPanelVisible(false);
        } else {
            this.aNV.setSwitchStatus(false);
            this.aNT.setVisibility(8);
            this.aNV.setVisibility(8);
            this.aNU.setVisibility(0);
            if (this.aNX != null) {
                this.aNX.setHint(a.i.sdk_im_sendmessage_to_host);
            }
        }
        if (this.aOa != null) {
            this.aOa.Bk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(boolean z) {
        if (z) {
            this.aNT.setPreview();
        }
        this.aNT.setUIInfo(this.aNV.getSelectInfo(), z);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.aNT.setVisibility(8);
        } else if (this.aNW != null && this.aNW.isChecked()) {
            this.aNT.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, boolean z) {
        if (this.aOa != null) {
            Log.i("i", "@@@ localText st go");
            this.aOa.n(str, z);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                this.aNT.setVisibility(8);
            } else if (this.aNW != null && this.aNW.isChecked()) {
                this.aNT.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.live.view.input.a
    public void CS() {
        if (this.aNX != null) {
            this.aNX.post(new Runnable() { // from class: com.baidu.live.im.view.ALALiveTextView.7
                @Override // java.lang.Runnable
                public void run() {
                    ALALiveTextView.this.aNX.requestFocus();
                }
            });
        }
    }
}

package com.baidu.live.gift.container;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.c.p;
import com.baidu.live.data.ap;
import com.baidu.live.data.m;
import com.baidu.live.gift.container.AlaComboBtnAnimView;
import com.baidu.live.gift.container.a;
import com.baidu.live.gift.g;
import com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel;
import com.baidu.live.gift.i;
import com.baidu.live.gift.l;
import com.baidu.live.gift.widget.panel.GiftPanelNumRoundRectView;
import com.baidu.live.gift.widget.panel.GiftPanelOperationSendView;
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.BaseViewPager;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.view.GradientTextView;
import com.baidu.live.u.a;
import com.baidu.live.view.RoundRectPageIndicator;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.live.view.input.b;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, View.OnClickListener, b.a {
    private int Yv;
    private int aiM;
    private boolean aiO;
    private boolean aiT;
    public ArrayList<i> ajC;
    private ArrayList<com.baidu.live.data.d> ajD;
    private ArrayList<com.baidu.live.data.e> ajE;
    private final String ajI;
    private boolean ajJ;
    public ViewGroup ajK;
    protected ViewGroup ajL;
    protected View ajM;
    private GiftPanelNumRoundRectView ajN;
    public TextView ajO;
    protected BaseViewPager ajP;
    protected RoundRectPageIndicator ajQ;
    protected HorizontalScrollView ajR;
    protected LinearLayout ajS;
    protected View ajT;
    private CommonEmptyView ajU;
    private FrameLayout ajV;
    private FrameLayout ajW;
    private View ajX;
    private com.baidu.live.gift.container.c ajY;
    public GiftPanelTabView ajZ;
    private int akA;
    private int akB;
    private int akC;
    private SparseBooleanArray akD;
    private Set<String> akE;
    private boolean akF;
    private int akG;
    private BdAlertDialog akH;
    private boolean akI;
    private int akJ;
    private ImageButton akK;
    private AlaComboBtnAnimView akL;
    private boolean akM;
    private TextView akN;
    private View.OnClickListener akO;
    private View.OnClickListener akP;
    AdapterView.OnItemClickListener akQ;
    Runnable akR;
    Runnable akS;
    private AlaGiftDrawPanel.a akT;
    private CustomMessageListener akU;
    private CustomMessageListener akV;
    private CustomMessageListener akW;
    private CustomMessageListener akX;
    private TextView aka;
    private TextView akb;
    private TextView akc;
    public GiftPanelOperationSendView akd;
    private ImageButton ake;
    private List<View> akf;
    private AlaGiftPagerAdapter akg;
    private ArrayList<List<g>> akh;
    private c aki;
    private int akj;
    private int akk;
    private int akl;
    private boolean akm;
    private boolean akn;
    private int ako;
    private g akp;
    private int akq;
    private SparseIntArray akr;
    private SparseBooleanArray aks;
    private View.OnClickListener akt;
    private AlaLiveInputEditView aku;
    private ViewGroup akv;
    private ImageButton akw;
    private TextView akx;
    private AlaGiftDrawPanel aky;
    private boolean akz;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private ViewGroup mRoot;
    private int mSelectedPosition;
    private boolean mShowing;
    private int mType;
    private String otherParams;
    private String roomId;

    /* loaded from: classes3.dex */
    public interface c {
        void tM();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.ajI = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.akf = new ArrayList();
        this.akj = 0;
        this.akk = 0;
        this.mSelectedPosition = 0;
        this.akl = 0;
        this.akr = new SparseIntArray();
        this.aks = new SparseBooleanArray();
        this.isLandscape = false;
        this.akz = false;
        this.akA = -1;
        this.akB = -1;
        this.aiO = false;
        this.aiM = -1;
        this.akD = new SparseBooleanArray();
        this.akE = new HashSet();
        this.akI = false;
        this.akM = false;
        this.aiT = false;
        this.akO = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.akL == null || !AlaGiftTabView.this.akL.ti()) {
                    if (AlaGiftTabView.this.ajY == null) {
                        AlaGiftTabView.this.ajY = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.akQ);
                    }
                    AlaGiftTabView.this.aH(true);
                    AlaGiftTabView.this.ajY.a(AlaGiftTabView.this.ajM, AlaGiftTabView.this.ajE, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.aH(false);
                        }
                    });
                }
            }
        };
        this.akP = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabView.this.akw.setEnabled(false);
                AlaGiftTabView.this.akK.setEnabled(false);
                AlaGiftTabView.this.aK(false);
                AlaGiftTabView.this.akT.c(0, 0L);
            }
        };
        this.akQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.ajY.dismiss();
                if (AlaGiftTabView.this.ajE == null || AlaGiftTabView.this.ajE.size() <= 0) {
                    AlaGiftTabView.this.dy("1");
                } else if (i != AlaGiftTabView.this.ajE.size()) {
                    com.baidu.live.data.e eVar = (com.baidu.live.data.e) AlaGiftTabView.this.ajE.get(i);
                    if (eVar != null) {
                        int number = eVar.getNumber();
                        if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.akp.agn) != null) {
                            if (number == -1) {
                                number = aVar.agu;
                            }
                            if (number > AlaGiftTabView.this.akJ) {
                                number = AlaGiftTabView.this.akJ;
                            }
                        }
                        AlaGiftTabView.this.dy(String.valueOf(number));
                    }
                } else {
                    AlaGiftTabView.this.ty();
                }
            }
        };
        this.akR = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
            @Override // java.lang.Runnable
            public void run() {
                AlaGiftTabView.this.aku.getEditView().requestFocus();
                AlaGiftTabView.this.aku.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.aku.getEditView());
            }
        };
        this.akS = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.aku.getEditView());
            }
        };
        this.akT = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void c(int i, long j) {
                AlaGiftTabView.this.akx.setText(String.format(AlaGiftTabView.this.mContext.getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i > 0) {
                    AlaGiftTabView.this.akw.setEnabled(true);
                    AlaGiftTabView.this.akK.setEnabled(true);
                    AlaGiftTabView.this.tJ();
                    AlaGiftTabView.this.ajM.setVisibility(4);
                    AlaGiftTabView.this.akx.setVisibility(0);
                } else {
                    AlaGiftTabView.this.tJ();
                    AlaGiftTabView.this.akx.setVisibility(8);
                    AlaGiftTabView.this.akw.setEnabled(false);
                    AlaGiftTabView.this.akK.setEnabled(false);
                }
                AlaGiftTabView.this.akq = i;
            }
        };
        this.akU = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.aeW == 1 || cVar.aeW == 2 || cVar.aeW == 5 || cVar.aeW == 6) && cVar.aeX != null) {
                        AlaGiftTabView.this.X(cVar.aeX.getId(), cVar.aeX.getUrl());
                    }
                }
            }
        };
        this.akV = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.aE(true);
                if (AlaGiftTabView.this.akp != null && AlaGiftTabView.this.b(AlaGiftTabView.this.akp) && AlaGiftTabView.this.ajJ) {
                    AlaGiftTabView.this.akd.setStyle(AlaGiftTabView.this.akp.rE() ? 2 : 1);
                    AlaGiftTabView.this.ajN.setStyleEnabled(true);
                }
            }
        };
        this.akW = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m mVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null && mVar.Ye != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = mVar.Ye.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aiT != z2) {
                        AlaGiftTabView.this.aiT = z2;
                        AlaGiftTabView.this.tL();
                        AlaGiftTabView.this.tK();
                    }
                }
            }
        };
        this.akX = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.tw();
                    AlaGiftTabView.this.akd.setStyle(AlaGiftTabView.this.akp.rE() ? 4 : 3);
                    AlaGiftTabView.this.ajN.setStyleEnabled(false);
                    AlaGiftTabView.this.akv.setVisibility(8);
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.akt = onClickListener;
        this.akz = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.ako = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        if (this.isLandscape) {
            this.akG = (ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity()) - (BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds112) * 2)) - BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds16);
            this.ajP.getLayoutParams().height = this.akG;
        } else {
            this.ajP.getLayoutParams().height = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds192) * 2;
        }
        this.ajP.requestLayout();
        this.akh = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.akJ = 9999;
                break;
            case 1:
                this.akJ = 999;
                break;
        }
        this.aku.setMaxText(String.valueOf(this.akJ));
        this.aku.setHintText(String.format(Locale.getDefault(), this.mContext.getString(a.i.ala_send_gift_count_hint), Integer.valueOf(this.akJ)));
    }

    public void W(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void aD(boolean z) {
        this.mShowing = z;
    }

    public void onVisibilityChanged(boolean z) {
        aD(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        int realScreenHeight = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.ajK = (ViewGroup) this.mRoot.findViewById(a.g.gift_list_layout);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.mContext.getResources().getColor(a.d.live_gift_panel_primary));
        float dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        if (this.isLandscape) {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
        } else {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.ajK.setBackgroundDrawable(gradientDrawable);
        this.ajK.getLayoutParams().width = realScreenHeight;
        this.akN = (TextView) this.mRoot.findViewById(a.g.gift_toast);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(BdUtilHelper.dip2px(this.mContext.getPageActivity(), 5.0f));
        gradientDrawable2.setColor(-1560281088);
        this.akN.setBackgroundDrawable(gradientDrawable2);
        if (UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity()) == 2) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akN.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.addRule(2, 0);
            layoutParams.addRule(12);
            layoutParams.addRule(5, this.ajK.getId());
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds90);
            this.akN.setLayoutParams(layoutParams);
            int dimens = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds12);
            this.akN.setPadding(dimens, dimens, dimens, dimens);
            this.akN.setBackgroundColor(-1560281088);
            this.akN.setGravity(17);
        }
        this.akN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.akp != null && AlaGiftTabView.this.akp.ago && !TextUtils.isEmpty(AlaGiftTabView.this.akp.agq)) {
                    UrlManager.getInstance().dealOneLink(AlaGiftTabView.this.mContext, new String[]{AlaGiftTabView.this.akp.agq});
                }
            }
        });
        this.akN.setVisibility(8);
        this.ajL = (ViewGroup) this.mRoot.findViewById(a.g.gift_tab_input_parent);
        this.ajM = this.mRoot.findViewById(a.g.gift_count_layout);
        this.ajM.setOnClickListener(this.akO);
        this.ajN = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.ajO = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.ajO.setText("1");
        this.ajO.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.ajT = this.mRoot.findViewById(a.g.gift_lower_layout);
        this.ajP = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.ajP.setOnPageChangeListener(this);
        this.ajQ = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.ajS = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.ajR = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.akz) {
            this.ajR.setVisibility(8);
        }
        this.aka = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.aka.setOnClickListener(this.akt);
        this.akb = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.akb.setOnClickListener(this.akt);
        this.akd = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.akc = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.akc.setOnClickListener(this.akt);
        this.akd.setOnClickListener(this.akt);
        this.ajV = (FrameLayout) this.mRoot.findViewById(a.g.tab_container_view);
        this.ajW = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        this.ajW.getLayoutParams().width = realScreenHeight;
        this.ajU = new CommonEmptyView(this.mContext.getPageActivity());
        this.ajU.setVisibility(8);
        this.ajU.addToParent(this.ajW);
        this.ajZ = (GiftPanelTabView) this.mRoot.findViewById(a.g.tab);
        this.ajX = this.mRoot.findViewById(a.g.donate_layout);
        tu();
        this.akv = (ViewGroup) this.mRoot.findViewById(a.g.ala_gift_draw_layout);
        this.akv.setVisibility(8);
        this.aky = (AlaGiftDrawPanel) this.mRoot.findViewById(a.g.ala_gift_draw_panel);
        this.aky.setGiftDrawEventListener(this.akT);
        this.aky.setGiftCountRange(10, 100);
        this.ake = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_hide_btn);
        this.ake.setOnClickListener(this.akt);
        this.akw = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_clean_btn);
        this.akK = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_revert_btn);
        this.akK.setOnClickListener(this);
        this.akL = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.akL.setComboClickListener(this.akt);
        this.akL.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void tj() {
                AlaGiftTabView.this.aL(true);
            }
        });
        this.akw.setOnClickListener(this.akP);
        this.akw.setEnabled(false);
        this.akK.setEnabled(false);
        this.akx = (TextView) this.mRoot.findViewById(a.g.ala_gift_draw_title);
        View findViewById = this.mRoot.findViewById(a.g.ala_gift_draw_title_layout);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        findViewById.setLayoutParams(layoutParams2);
        findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public void tt() {
        this.akF = true;
        this.aka.setVisibility(8);
        this.akb.setVisibility(8);
        this.akc.setVisibility(8);
    }

    public void aE(boolean z) {
        this.ajJ = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.v.a.zl().zo() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.akc.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.akE.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.akE.add(str);
            }
        }
    }

    public void bh(int i) {
        this.akC = i;
    }

    private void tu() {
        this.aku = new AlaLiveInputEditView(this.mContext.getPageActivity());
        this.aku.setVisibility(8);
        this.aku.setEditViewConfirmCallBack(this);
        this.ajL.addView(this.aku, new RelativeLayout.LayoutParams(-1, -2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.akK && this.aky != null) {
            this.aky.uz();
        }
    }

    public void aF(boolean z) {
        this.akM = z;
    }

    public void bB(int i) {
        this.Yv = i;
    }

    public void aq(boolean z) {
        this.aiT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        private int mPosition;

        public b(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaGiftTabView.this.bC(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bC(int i) {
        tz();
        bD(i);
        this.ajP.setCurrentItem(this.akj);
        tD();
        tv();
    }

    private void bD(int i) {
        int min = Math.min(i, this.akr.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.akr.get(i3);
        }
        this.akj = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            g item = ((com.baidu.live.gift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.isRed()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.akk = AlaGiftTabView.this.akj;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void tv() {
        if (this.akp != null && this.akp.ago && !TextUtils.isEmpty(this.akp.agp)) {
            this.akN.setText(this.akp.agp);
            this.akN.setVisibility(0);
            return;
        }
        this.akN.setVisibility(8);
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        tz();
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.bw(i);
                aVar.notifyDataSetChanged();
                this.ajX.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                dy("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.akp.rU()) {
                        this.akd.setStyle(this.akp.rE() ? 4 : 3);
                        this.ajN.setStyleEnabled(false);
                        this.akv.setVisibility(8);
                        if (!TextUtils.isEmpty(this.akp.rH()) && this.mShowing) {
                            this.mContext.showToast(this.akp.rH());
                            return;
                        }
                        return;
                    }
                    tv();
                    this.akd.setEnabled(true);
                    if (this.akp.rX()) {
                        this.akv.setVisibility(8);
                        this.aky.ux();
                        if (this.akp.rT() == 6 && this.aiM < 3) {
                            i3 = 3;
                        } else if (this.akp.rT() == 7 && this.aiM < 7) {
                            i3 = 7;
                        } else if (this.akp.rT() == 8 && this.aiM < 13) {
                            i3 = 13;
                        } else if (this.akp.rT() == 9 && this.aiM < 22) {
                            i3 = 22;
                        } else if (this.akp.rT() == 10 && this.aiM < 29) {
                            i3 = 29;
                        } else if (this.akp.rT() == 11 && this.aiM < 39) {
                            i3 = 39;
                        } else if (this.akp.rT() == 12 && this.aiM < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.akd.setStyle(this.akp.rE() ? 2 : 1);
                    } else {
                        this.akd.setStyle(this.akp.rE() ? 4 : 3);
                    }
                    this.ajN.setStyleEnabled(z);
                    tL();
                    i2 = i3;
                } else {
                    this.akd.setStyle(this.akp.rE() ? 2 : 1);
                    if (this.akp.agn != null && this.akp.agn.agt != null && this.akp.agn.agt.equals("20")) {
                        this.akd.setText("使用");
                    } else {
                        this.akd.setText("赠送");
                    }
                    this.ajN.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.akp.rF()) {
                    aG(true);
                    if (this.aky != null && this.aky.getCurrentPointSize() > 0) {
                        this.akx.setVisibility(0);
                    } else {
                        this.akx.setVisibility(8);
                    }
                } else {
                    aG(false);
                    dy("1");
                }
                c(false, i2);
                return;
            }
            this.akd.setStyle(3);
            return;
        }
        this.akd.setStyle(3);
    }

    private void c(boolean z, int i) {
        g.a aVar;
        if (this.mShowing && this.akp != null) {
            if (this.mType == 0) {
                if (this.akp.rW() && !this.aiT) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.akp.rH()) && this.akp.rU() && !z) {
                    this.mContext.showToast(this.akp.rH());
                } else if (this.akp.rX() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.akp.rS()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (aVar = this.akp.agn) != null && !TextUtils.isEmpty(aVar.agw)) {
                this.mContext.showToast(aVar.agw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.v.a.zl().axC != null && com.baidu.live.v.a.zl().axC.acR != null) {
            String str = com.baidu.live.v.a.zl().axC.acR.acc;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.rT()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw() {
        if (!this.akn) {
            this.akH = new BdAlertDialog(this.mContext.getPageActivity());
            this.akH.setCancelable(false);
            this.akH.setCanceledOnTouchOutside(false);
            this.akH.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.akH.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.akC)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.akH.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.akH.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.akH.setPositiveButtonTextColor(-57754);
                this.akH.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.akH.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.akn = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.akH.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.akn = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.akH.create(this.mContext).show();
            this.akn = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(boolean z) {
        int i = 0;
        if (z && com.baidu.live.v.a.zl().awB.Zz) {
            if (this.aky.getVisibility() == 0) {
                tF();
            }
        } else {
            aK(true);
        }
        if (z && com.baidu.live.v.a.zl().awB.Zz) {
            if (Build.VERSION.SDK_INT != 26) {
                this.mContext.getPageActivity().setRequestedOrientation(1);
                this.akI = true;
            }
            this.akv.setVisibility(0);
            tJ();
            BdResourceLoader.getInstance().loadResource(this.akp.rA(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.container.AlaGiftTabView.22
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i2) {
                    super.onLoaded((AnonymousClass22) bdImage, str, i2);
                    if (bdImage == null || bdImage.getRawBitmap() == null) {
                        if (AlaGiftTabView.this.mShowing) {
                            BdUtilHelper.showToast(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.mContext.getPageActivity().getString(a.i.ala_gift_noimage_tip));
                        }
                    } else if (str != null && str.equals(AlaGiftTabView.this.akp.rA())) {
                        AlaGiftTabView.this.aky.setGiftBitmp(bdImage.getRawBitmap());
                    }
                }
            }, null);
            this.ajM.setVisibility(4);
            this.akd.setStyle(1);
            return;
        }
        if (Build.VERSION.SDK_INT != 26 && this.akI) {
            this.mContext.getPageActivity().setRequestedOrientation(3);
            this.akI = false;
        }
        this.akv.setVisibility(8);
        this.aky.ux();
        View view = this.ajM;
        if (this.akp == null || !this.akp.rE()) {
            i = 4;
        }
        view.setVisibility(i);
    }

    public boolean tx() {
        return this.aku.getVisibility() == 0;
    }

    public void bE(int i) {
        if (this.aku != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aku.getLayoutParams();
            layoutParams.topMargin = i;
            this.aku.setLayoutParams(layoutParams);
        }
    }

    public void ty() {
        this.aku.xS();
        this.aku.getEditView().setFocusable(true);
        this.aku.getEditView().setFocusableInTouchMode(true);
        this.aku.getEditView().postDelayed(this.akR, 100L);
    }

    public void tz() {
        this.aku.setVisibility(8);
        this.aku.getEditView().post(this.akS);
    }

    public AlaLiveInputEditView tA() {
        return this.aku;
    }

    @Override // com.baidu.live.view.input.b.a
    public void dx(String str) {
        tz();
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        dy(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(String str) {
        this.ajO.setText(str);
        this.ajO.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        aH(false);
        if (this.akp != null && this.akp.rE()) {
            this.ajM.setVisibility(0);
            this.akq = JavaTypesHelper.toInt(this.ajO.getText().toString(), 1);
            return;
        }
        this.ajM.setVisibility(4);
        this.akq = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(boolean z) {
        this.ajO.setGravity(17);
        if (z) {
            this.ajO.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.ajO.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3, boolean z2, int i) {
        if (this.ajC == null || this.ajC.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            this.ajC = arrayList;
            this.ajD = arrayList2;
            this.ajE = arrayList3;
            this.akm = false;
            if (this.ajD == null || this.ajD.isEmpty()) {
                this.ajR.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void p(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.akf != null) {
            for (View view : this.akf) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < viewGroup.getChildCount()) {
                            View childAt = viewGroup.getChildAt(i3);
                            if (!(childAt instanceof GridView)) {
                                i2 = i3 + 1;
                            } else if (((GridView) childAt).getAdapter() instanceof com.baidu.live.gift.container.a) {
                                ((com.baidu.live.gift.container.a) ((GridView) childAt).getAdapter()).p(str, i);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(boolean z, boolean z2, int i) {
        String string;
        tB();
        tI();
        if (this.ajC == null || this.ajC.size() <= 0 || !z2) {
            kY();
            if (this.ajQ != null) {
                this.ajQ.setVisibility(4);
            }
            this.ajX.setVisibility(4);
            this.ajU.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.ajU.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.ajU.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.ajU.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.v.a.zl().awB.aaV && i != 0) {
                string = string + "(" + i + ")";
            }
            this.ajU.setTitle(string);
            this.ajU.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aki != null) {
                        AlaGiftTabView.this.aki.tM();
                    }
                }
            });
            this.ajU.setVisibility(0);
            return;
        }
        this.ajU.setVisibility(8);
        this.ajT.setVisibility(0);
        if (z) {
            h(this.ajD);
        }
        ap apVar = com.baidu.live.v.a.zl().axC;
        if (this.mType == 0 && apVar != null && apVar.acV != null && apVar.acV.aeC && !this.akM && this.ajC.get(0) != null && this.ajC.get(0).rY() != null) {
            List<g> rY = this.ajC.get(0).rY();
            if (!rY.isEmpty()) {
                g gVar = new g();
                gVar.ax(true);
                gVar.setGiftName("发红包");
                rY.add(1, gVar);
            }
        }
        c(this.ajC, z);
        dy("1");
    }

    private void kY() {
        this.akj = 0;
        this.akk = 0;
        this.mSelectedPosition = 0;
        this.akl = 0;
        if (this.akr != null) {
            this.akr.clear();
        }
        if (this.akf != null) {
            this.akf.clear();
        }
        if (this.ajP != null) {
            this.ajP.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (!b(this.akp) || this.ajJ) {
            if (gVar.rX()) {
                if (gVar.rT() == 6 && this.aiM < 3) {
                    return false;
                }
                if (gVar.rT() == 7 && this.aiM < 7) {
                    return false;
                }
                if (gVar.rT() == 8 && this.aiM < 13) {
                    return false;
                }
                if (gVar.rT() == 9 && this.aiM < 22) {
                    return false;
                }
                if (gVar.rT() == 10 && this.aiM < 29) {
                    return false;
                }
                if (gVar.rT() == 11 && this.aiM < 39) {
                    return false;
                }
                if (gVar.rT() == 12 && this.aiM < 47) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void tB() {
        if (ListUtils.getCount(this.ajD) != 0 && ListUtils.getCount(this.ajC) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.d> it = this.ajD.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.d next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.qq()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.ajC.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        i next2 = it2.next();
                        if (next2 != null && next2.getCategoryId() == next.getCategoryId()) {
                            arrayList2.add(next2);
                            break;
                        }
                    }
                }
            }
            if (this.isLandscape) {
                Iterator<i> it3 = this.ajC.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().rY().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.rF()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.ajD.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.ajC.removeAll(arrayList2);
            }
        }
    }

    private void c(ArrayList<i> arrayList, boolean z) {
        boolean z2;
        int i;
        ArrayList arrayList2;
        int i2;
        int i3;
        g gVar;
        List<g> rY;
        if (arrayList != null) {
            this.akr.clear();
            this.akf.clear();
            this.ajP.setAdapter(null);
            if (this.mType != 1) {
                z2 = false;
            } else {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= arrayList.size()) {
                        z2 = true;
                        break;
                    }
                    i iVar = arrayList.get(i5);
                    if (iVar == null || (rY = iVar.rY()) == null || rY.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.akh.clear();
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < arrayList.size()) {
                    if (z2) {
                        this.akf.add(bF(i7));
                        this.akr.append(i7, 1);
                    } else {
                        i iVar2 = arrayList.get(i7);
                        iVar2.getCategoryId();
                        List<g> rY2 = iVar2.rY();
                        if (rY2 == null) {
                            i = 0;
                        } else {
                            i = rY2.size();
                        }
                        int i8 = 0;
                        if (i <= 0) {
                            i8 = 1;
                            ArrayList arrayList3 = new ArrayList();
                            if (this.aks.get(i7)) {
                                this.akf.add(aI(true));
                            } else {
                                this.akf.add(b(arrayList3, -1, i7));
                            }
                        } else if (rY2 != null) {
                            int i9 = this.isLandscape ? 12 : 8;
                            int ceil = (int) Math.ceil(i / i9);
                            for (int i10 = 0; i10 < ceil; i10++) {
                                if (i10 == ceil - 1) {
                                    if (i10 * i9 == i - 1) {
                                        ArrayList arrayList4 = new ArrayList();
                                        arrayList4.add(rY2.get(i - 1));
                                        arrayList2 = arrayList4;
                                    } else {
                                        arrayList2 = new ArrayList(rY2.subList(i10 * i9, i));
                                    }
                                } else {
                                    arrayList2 = new ArrayList(rY2.subList(i10 * i9, (i10 + 1) * i9));
                                }
                                this.akh.add(arrayList2);
                                if (i7 == 0 && i10 == 0 && z) {
                                    int i11 = 0;
                                    while (true) {
                                        i3 = i11;
                                        if (i3 >= arrayList2.size()) {
                                            gVar = null;
                                            i3 = 0;
                                            break;
                                        }
                                        gVar = arrayList2.get(i3);
                                        if (gVar == null || gVar.rx() == null || !gVar.rx().equals(String.valueOf(this.akB))) {
                                            i11 = i3 + 1;
                                        } else {
                                            this.mSelectedPosition = i3;
                                            break;
                                        }
                                    }
                                    if (gVar == null && arrayList2.size() > 0) {
                                        gVar = arrayList2.get(0);
                                    }
                                    d(gVar);
                                    this.akf.add(b(arrayList2, i3, i7));
                                    this.akv.removeCallbacks(null);
                                    this.akv.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            boolean rF = AlaGiftTabView.this.akp.rF();
                                            AlaGiftTabView.this.aG(rF);
                                            if (!rF) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.akp);
                                                if (!c2) {
                                                    AlaGiftTabView.this.akd.setStyle(AlaGiftTabView.this.akp.rE() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.akd.setStyle(AlaGiftTabView.this.akp.rE() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.ajN.setStyleEnabled(c2);
                                            }
                                        }
                                    }, 100L);
                                } else {
                                    if (!ListUtils.isEmpty(arrayList2)) {
                                        int i12 = 0;
                                        while (true) {
                                            i2 = i12;
                                            if (i2 >= arrayList2.size()) {
                                                break;
                                            }
                                            g gVar2 = arrayList2.get(i2);
                                            if (gVar2 == null || !gVar2.rx().equals(String.valueOf(this.akB))) {
                                                i12 = i2 + 1;
                                            } else {
                                                this.mSelectedPosition = i2;
                                                this.akp = gVar2;
                                                d(gVar2);
                                                break;
                                            }
                                        }
                                        this.akf.add(b(arrayList2, i2, i7));
                                    }
                                    i2 = -1;
                                    this.akf.add(b(arrayList2, i2, i7));
                                }
                            }
                            i8 = ceil;
                        }
                        this.akr.append(i7, i8);
                    }
                    i6 = i7 + 1;
                } else {
                    this.akg = new AlaGiftPagerAdapter(this.akf);
                    this.ajP.setAdapter(this.akg);
                    tC();
                    this.ajP.setCurrentItem(this.akj);
                    tD();
                    return;
                }
            }
        }
    }

    private void tC() {
        int i = 0;
        if (this.akB > 0 && !ListUtils.isEmpty(this.akh)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.akh.size() && !z; i2++) {
                Iterator<g> it = this.akh.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.rx() != null && next.rx().equals(String.valueOf(this.akB))) {
                        this.akj = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.Yv == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.akk = this.akj;
            this.akh.clear();
        } else if (this.akA > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.ajD.size()) {
                    break;
                }
                com.baidu.live.data.d dVar = this.ajD.get(i3);
                if (dVar == null || this.akA != dVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    bD(i3);
                    break;
                }
            }
            this.akk = this.akj;
        }
    }

    private View aI(boolean z) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext.getPageActivity());
        commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        } else {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aki != null) {
                    AlaGiftTabView.this.aki.tM();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.aC(this.aiO);
        aVar.setGiftItems(list);
        aVar.bv(this.aiM);
        aVar.aq(this.aiT);
        aVar.bw(i);
        if (this.isLandscape) {
            aVar.bx(this.akG / 3);
        }
        BdGridView bdGridView = new BdGridView(this.mContext.getPageActivity());
        bdGridView.setNumColumns(4);
        bdGridView.setVerticalScrollBarEnabled(false);
        bdGridView.setSelector(a.d.sdk_transparent);
        bdGridView.setAdapter((ListAdapter) aVar);
        bdGridView.setOnItemClickListener(new a());
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0085a) {
                    ((a.C0085a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout bF(int i) {
        FrameLayout b2 = b(null, -1, i);
        int i2 = 0;
        while (true) {
            if (i2 >= b2.getChildCount()) {
                break;
            } else if (!(b2.getChildAt(i2) instanceof GridView)) {
                i2++;
            } else {
                CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext.getPageActivity());
                commonEmptyView.setTitle(a.i.ala_package_empty);
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
                ((GridView) b2.getChildAt(i2)).setEmptyView(commonEmptyView);
                commonEmptyView.addToParent(b2);
                break;
            }
        }
        return b2;
    }

    @SuppressLint({"ResourceAsColor"})
    private void h(ArrayList<com.baidu.live.data.d> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.akz) {
                this.ajR.setVisibility(0);
            }
            this.ajS.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.getCategoryName()) && (this.mType != 0 || (dVar.qq() != null && dVar.qq().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(dVar.getCategoryName());
                    viewGroup.setOnClickListener(new b(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.ako;
                    }
                    if (this.ajC.size() > i && this.ajC.get(i) != null) {
                        for (g gVar : this.ajC.get(i).rY()) {
                            if (gVar != null && gVar.rD() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.ajS.addView(viewGroup, layoutParams);
                }
            }
            bG(this.akl);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f4  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bG(int i) {
        JSONArray jSONArray;
        JSONException e;
        List<g> rY;
        int childCount = this.ajS.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.akl != i || !this.akm) && this.ajD.size() > i && this.ajD.get(i) != null) {
                int min = Math.min(i, this.akr.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.akr.get(i3);
                }
                if (this.akf.size() > i2 && this.ajC.size() > i && (this.akf.get(i2) instanceof ViewGroup)) {
                    this.akk = i2;
                    i iVar = this.ajC.get(i);
                    if (iVar != null && iVar.rY() != null && !iVar.rY().isEmpty()) {
                        d(this.ajC.get(i).rY().get(0));
                        ViewGroup viewGroup = (ViewGroup) this.akf.get(i2);
                        int i4 = 0;
                        while (true) {
                            if (i4 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i4) instanceof GridView)) {
                                i4++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i4)).getAdapter();
                                if (this.akp != null && aVar != null) {
                                    a(aVar, 0);
                                    if (this.mShowing) {
                                        this.akm = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.ajD.size() > i && this.ajD.get(i) != null) {
                int categoryId = this.ajD.get(i).getCategoryId();
                if (!this.akD.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.akD.put(categoryId, true);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewGroup viewGroup2 = (ViewGroup) this.ajS.getChildAt(i5);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.ajC.get(i5);
                if (iVar2.rZ()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.ajI, "");
                    if (TextUtils.isEmpty(string)) {
                        jSONArray = null;
                    } else {
                        try {
                            jSONArray = new JSONArray(string);
                            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                                try {
                                    hashSet.add(jSONArray.optString(i6));
                                } catch (JSONException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    rY = iVar2.rY();
                                    if (rY != null) {
                                    }
                                    if (i5 == i) {
                                    }
                                    if (i5 == i) {
                                    }
                                }
                            }
                        } catch (JSONException e3) {
                            jSONArray = null;
                            e = e3;
                        }
                    }
                    rY = iVar2.rY();
                    if (rY != null) {
                        ArrayList arrayList = new ArrayList();
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= rY.size()) {
                                break;
                            }
                            g gVar = rY.get(i8);
                            if (!gVar.rU() && !hashSet.contains(gVar.rx())) {
                                arrayList.add(gVar.rx());
                            }
                            i7 = i8 + 1;
                        }
                        if (!arrayList.isEmpty()) {
                            if (i5 != i) {
                                imageView.setVisibility(0);
                            } else {
                                if (jSONArray == null) {
                                    jSONArray = new JSONArray();
                                }
                                for (int i9 = 0; i9 < arrayList.size(); i9++) {
                                    jSONArray.put(arrayList.get(i9));
                                }
                                SharedPrefHelper.getInstance().putString(this.ajI, jSONArray.toString());
                            }
                        }
                    }
                }
                if (i5 == i) {
                    gradientTextView.setGradientTextColor(-2130706433, -2130706433);
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(0));
                } else {
                    if (imageView.getVisibility() == 0) {
                        imageView.setVisibility(8);
                    }
                    gradientTextView.setGradientTextColor(-57754, -39399);
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    bH(i);
                    this.akl = i;
                    this.ajR.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i5 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            aJ(false);
                        } else {
                            aJ(true);
                        }
                    } else {
                        aJ(true);
                    }
                }
            }
        }
    }

    private void aJ(boolean z) {
        int i = 8;
        if (this.aka != null) {
            this.aka.setVisibility(z ? this.akF ? 8 : 0 : 8);
        }
        if (this.akb != null) {
            TextView textView = this.akb;
            if (!z && !this.akF) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void bH(int i) {
        int childCount = this.ajS.getChildCount();
        if (i >= 0 && i < childCount && this.ajC != null && this.ajC.size() > i && this.ajC.get(i) != null) {
            this.aks.get(i);
        }
    }

    public void t(int i, int i2) {
        this.akA = i;
        this.akB = i2;
    }

    public void z(long j) {
        if (this.aka != null) {
            if (j >= 100 && (this.aiO || com.baidu.live.v.a.zl().awB.aaq)) {
                this.aka.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aka.setText(String.valueOf(j));
        }
    }

    public void A(long j) {
        if (this.akb != null) {
            this.akb.setText(String.valueOf(j));
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.akj = i;
        tD();
        tv();
        if (i >= 0 && i < this.akf.size() && (this.akf.get(i) instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.akf.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.akk) {
                            aVar.bw(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.akk) {
                            aVar.bw(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.ajX.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void tD() {
        int i = 0;
        for (int i2 = 0; i2 < this.akr.size(); i2++) {
            for (int i3 = 0; i3 < this.akr.get(i2); i3++) {
                if (i + i3 == this.akj) {
                    if (this.akr.get(i2) <= 1) {
                        this.ajQ.setVisibility(4);
                    } else {
                        this.ajQ.setVisibility(0);
                    }
                    this.ajQ.setCount(this.akr.get(i2));
                    this.ajQ.onPageSelected(i3);
                    bG(i2);
                    return;
                }
            }
            i += this.akr.get(i2);
        }
    }

    public g tE() {
        return this.akp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(boolean z) {
        if (this.aky != null) {
            this.aky.aK(z);
        }
    }

    private void tF() {
        if (this.aky != null) {
            this.aky.tF();
            this.aky.uy();
        }
    }

    public l tG() {
        l lVar = new l();
        lVar.ahq = BdUtilHelper.dip2px(this.mContext.getPageActivity(), 32.0f);
        lVar.ahr.addAll(this.aky.getPoints());
        lVar.aho = this.aky.getMeasuredHeight();
        lVar.ahn = this.aky.getMeasuredWidth();
        Rect rect = new Rect();
        this.aky.getGlobalVisibleRect(rect);
        lVar.ahl = rect.left;
        lVar.ahm = rect.top;
        lVar.ahs = lVar.ahr.size();
        lVar.ahu = this.aky.getGraffitiPointDesDatas();
        lVar.aht = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext.getPageActivity());
        lVar.ahj = screenDimensions[0];
        lVar.ahk = screenDimensions[1];
        return lVar;
    }

    public int tH() {
        return this.akq;
    }

    public void a(DialogInterface.OnCancelListener onCancelListener) {
    }

    public void tI() {
    }

    public void a(c cVar) {
        this.aki = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ() {
        if (this.aky != null) {
            if (this.aky.getCurrentPointSize() > 0) {
                this.aky.setTipImageVisibility(8);
            } else {
                this.aky.setTipImageVisibility(0);
            }
        }
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.akU);
        MessageManager.getInstance().registerListener(this.akV);
        MessageManager.getInstance().registerListener(this.akW);
        MessageManager.getInstance().registerListener(this.akX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.akf) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.akf) {
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view;
                            int i = 0;
                            while (true) {
                                if (i >= viewGroup.getChildCount()) {
                                    break;
                                } else if (!(viewGroup.getChildAt(i) instanceof GridView)) {
                                    i++;
                                } else {
                                    GridView gridView = (GridView) viewGroup.getChildAt(i);
                                    if (gridView.getAdapter() instanceof com.baidu.live.gift.container.a) {
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, str, str2);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tK() {
        if (!ListUtils.isEmpty(this.akf)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.akf) {
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view;
                            int i = 0;
                            while (true) {
                                if (i >= viewGroup.getChildCount()) {
                                    break;
                                } else if (!(viewGroup.getChildAt(i) instanceof GridView)) {
                                    i++;
                                } else {
                                    GridView gridView = (GridView) viewGroup.getChildAt(i);
                                    if (gridView.getAdapter() instanceof com.baidu.live.gift.container.a) {
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aiT);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL() {
        if (this.akp != null && this.akp.rW()) {
            this.ajN.setStyleEnabled(this.aiT);
            if (this.aiT) {
                this.akd.setStyle(this.akp.rE() ? 2 : 1);
            } else {
                this.akd.setStyle(this.akp.rE() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.akU);
        MessageManager.getInstance().unRegisterListener(this.akV);
        MessageManager.getInstance().unRegisterListener(this.akW);
        MessageManager.getInstance().unRegisterListener(this.akX);
        kY();
        if (this.akH != null) {
            this.akH.dismiss();
        }
    }

    public void aC(boolean z) {
        this.aiO = z;
    }

    public void bI(int i) {
        this.aiM = i;
    }

    public void d(g gVar) {
        this.akp = gVar;
        if (this.aky != null) {
            this.aky.setAlaGiftItem(gVar);
        }
        if (gVar != null && !gVar.rG()) {
            this.akL.th();
        }
    }

    public void tg() {
        if (this.akL != null) {
            this.akL.tg();
        }
    }

    public void tf() {
        if (this.akL != null) {
            this.akL.tf();
        }
    }

    public void aL(boolean z) {
        if (this.akd != null) {
            this.akd.setVisibility(z ? 0 : 4);
        }
    }
}

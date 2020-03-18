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
    private int YF;
    private int aiW;
    private boolean aiY;
    public ArrayList<i> ajN;
    private ArrayList<com.baidu.live.data.d> ajO;
    private ArrayList<com.baidu.live.data.e> ajP;
    private final String ajT;
    private boolean ajU;
    public ViewGroup ajV;
    protected ViewGroup ajW;
    protected View ajX;
    private GiftPanelNumRoundRectView ajY;
    public TextView ajZ;
    private boolean ajd;
    private g akA;
    private int akB;
    private SparseIntArray akC;
    private SparseBooleanArray akD;
    private View.OnClickListener akE;
    private AlaLiveInputEditView akF;
    private ViewGroup akG;
    private ImageButton akH;
    private TextView akI;
    private AlaGiftDrawPanel akJ;
    private boolean akK;
    private int akL;
    private int akM;
    private int akN;
    private SparseBooleanArray akO;
    private Set<String> akP;
    private boolean akQ;
    private int akR;
    private BdAlertDialog akS;
    private boolean akT;
    private int akU;
    private ImageButton akV;
    private AlaComboBtnAnimView akW;
    private boolean akX;
    private TextView akY;
    private View.OnClickListener akZ;
    protected BaseViewPager aka;
    protected RoundRectPageIndicator akb;
    protected HorizontalScrollView akc;
    protected LinearLayout akd;
    protected View ake;
    private CommonEmptyView akf;
    private FrameLayout akg;
    private FrameLayout akh;
    private View aki;
    private com.baidu.live.gift.container.c akj;
    public GiftPanelTabView akk;
    private TextView akl;
    private TextView akm;
    private TextView akn;
    public GiftPanelOperationSendView ako;
    private ImageButton akp;
    private List<View> akq;
    private AlaGiftPagerAdapter akr;
    private ArrayList<List<g>> aks;
    private c akt;
    private int aku;
    private int akv;
    private int akw;
    private boolean akx;
    private boolean aky;
    private int akz;
    private View.OnClickListener ala;
    AdapterView.OnItemClickListener alb;
    Runnable alc;
    Runnable ald;
    private AlaGiftDrawPanel.a ale;
    private CustomMessageListener alf;
    private CustomMessageListener alg;
    private CustomMessageListener alh;
    private CustomMessageListener ali;
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
        void tR();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.ajT = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.akq = new ArrayList();
        this.aku = 0;
        this.akv = 0;
        this.mSelectedPosition = 0;
        this.akw = 0;
        this.akC = new SparseIntArray();
        this.akD = new SparseBooleanArray();
        this.isLandscape = false;
        this.akK = false;
        this.akL = -1;
        this.akM = -1;
        this.aiY = false;
        this.aiW = -1;
        this.akO = new SparseBooleanArray();
        this.akP = new HashSet();
        this.akT = false;
        this.akX = false;
        this.ajd = false;
        this.akZ = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.akW == null || !AlaGiftTabView.this.akW.tn()) {
                    if (AlaGiftTabView.this.akj == null) {
                        AlaGiftTabView.this.akj = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.alb);
                    }
                    AlaGiftTabView.this.aH(true);
                    AlaGiftTabView.this.akj.a(AlaGiftTabView.this.ajX, AlaGiftTabView.this.ajP, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.aH(false);
                        }
                    });
                }
            }
        };
        this.ala = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabView.this.akH.setEnabled(false);
                AlaGiftTabView.this.akV.setEnabled(false);
                AlaGiftTabView.this.aK(false);
                AlaGiftTabView.this.ale.c(0, 0L);
            }
        };
        this.alb = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.akj.dismiss();
                if (AlaGiftTabView.this.ajP == null || AlaGiftTabView.this.ajP.size() <= 0) {
                    AlaGiftTabView.this.dx("1");
                } else if (i != AlaGiftTabView.this.ajP.size()) {
                    com.baidu.live.data.e eVar = (com.baidu.live.data.e) AlaGiftTabView.this.ajP.get(i);
                    if (eVar != null) {
                        int number = eVar.getNumber();
                        if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.akA.agx) != null) {
                            if (number == -1) {
                                number = aVar.agE;
                            }
                            if (number > AlaGiftTabView.this.akU) {
                                number = AlaGiftTabView.this.akU;
                            }
                        }
                        AlaGiftTabView.this.dx(String.valueOf(number));
                    }
                } else {
                    AlaGiftTabView.this.tD();
                }
            }
        };
        this.alc = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
            @Override // java.lang.Runnable
            public void run() {
                AlaGiftTabView.this.akF.getEditView().requestFocus();
                AlaGiftTabView.this.akF.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.akF.getEditView());
            }
        };
        this.ald = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.akF.getEditView());
            }
        };
        this.ale = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void c(int i, long j) {
                AlaGiftTabView.this.akI.setText(String.format(AlaGiftTabView.this.mContext.getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i > 0) {
                    AlaGiftTabView.this.akH.setEnabled(true);
                    AlaGiftTabView.this.akV.setEnabled(true);
                    AlaGiftTabView.this.tO();
                    AlaGiftTabView.this.ajX.setVisibility(4);
                    AlaGiftTabView.this.akI.setVisibility(0);
                } else {
                    AlaGiftTabView.this.tO();
                    AlaGiftTabView.this.akI.setVisibility(8);
                    AlaGiftTabView.this.akH.setEnabled(false);
                    AlaGiftTabView.this.akV.setEnabled(false);
                }
                AlaGiftTabView.this.akB = i;
            }
        };
        this.alf = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.afg == 1 || cVar.afg == 2 || cVar.afg == 5 || cVar.afg == 6) && cVar.afh != null) {
                        AlaGiftTabView.this.W(cVar.afh.getId(), cVar.afh.getUrl());
                    }
                }
            }
        };
        this.alg = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.aE(true);
                if (AlaGiftTabView.this.akA != null && AlaGiftTabView.this.b(AlaGiftTabView.this.akA) && AlaGiftTabView.this.ajU) {
                    AlaGiftTabView.this.ako.setStyle(AlaGiftTabView.this.akA.rJ() ? 2 : 1);
                    AlaGiftTabView.this.ajY.setStyleEnabled(true);
                }
            }
        };
        this.alh = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                m mVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof m) && (mVar = (m) customResponsedMessage.getData()) != null && mVar.Yo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = mVar.Yo.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.ajd != z2) {
                        AlaGiftTabView.this.ajd = z2;
                        AlaGiftTabView.this.tQ();
                        AlaGiftTabView.this.tP();
                    }
                }
            }
        };
        this.ali = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.tB();
                    AlaGiftTabView.this.ako.setStyle(AlaGiftTabView.this.akA.rJ() ? 4 : 3);
                    AlaGiftTabView.this.ajY.setStyleEnabled(false);
                    AlaGiftTabView.this.akG.setVisibility(8);
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.akE = onClickListener;
        this.akK = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.akz = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        if (this.isLandscape) {
            this.akR = (ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity()) - (BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds112) * 2)) - BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds16);
            this.aka.getLayoutParams().height = this.akR;
        } else {
            this.aka.getLayoutParams().height = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds192) * 2;
        }
        this.aka.requestLayout();
        this.aks = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.akU = 9999;
                break;
            case 1:
                this.akU = 999;
                break;
        }
        this.akF.setMaxText(String.valueOf(this.akU));
        this.akF.setHintText(String.format(Locale.getDefault(), this.mContext.getString(a.i.ala_send_gift_count_hint), Integer.valueOf(this.akU)));
    }

    public void V(String str, String str2) {
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
        this.ajV = (ViewGroup) this.mRoot.findViewById(a.g.gift_list_layout);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.mContext.getResources().getColor(a.d.live_gift_panel_primary));
        float dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        if (this.isLandscape) {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
        } else {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.ajV.setBackgroundDrawable(gradientDrawable);
        this.ajV.getLayoutParams().width = realScreenHeight;
        this.akY = (TextView) this.mRoot.findViewById(a.g.gift_toast);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(BdUtilHelper.dip2px(this.mContext.getPageActivity(), 5.0f));
        gradientDrawable2.setColor(-1560281088);
        this.akY.setBackgroundDrawable(gradientDrawable2);
        if (UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity()) == 2) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akY.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.addRule(2, 0);
            layoutParams.addRule(12);
            layoutParams.addRule(5, this.ajV.getId());
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds90);
            this.akY.setLayoutParams(layoutParams);
            int dimens = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds12);
            this.akY.setPadding(dimens, dimens, dimens, dimens);
            this.akY.setBackgroundColor(-1560281088);
            this.akY.setGravity(17);
        }
        this.akY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.akA != null && AlaGiftTabView.this.akA.agy && !TextUtils.isEmpty(AlaGiftTabView.this.akA.agA)) {
                    UrlManager.getInstance().dealOneLink(AlaGiftTabView.this.mContext, new String[]{AlaGiftTabView.this.akA.agA});
                }
            }
        });
        this.akY.setVisibility(8);
        this.ajW = (ViewGroup) this.mRoot.findViewById(a.g.gift_tab_input_parent);
        this.ajX = this.mRoot.findViewById(a.g.gift_count_layout);
        this.ajX.setOnClickListener(this.akZ);
        this.ajY = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.ajZ = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.ajZ.setText("1");
        this.ajZ.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.ake = this.mRoot.findViewById(a.g.gift_lower_layout);
        this.aka = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.aka.setOnPageChangeListener(this);
        this.akb = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.akd = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.akc = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.akK) {
            this.akc.setVisibility(8);
        }
        this.akl = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.akl.setOnClickListener(this.akE);
        this.akm = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.akm.setOnClickListener(this.akE);
        this.ako = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.akn = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.akn.setOnClickListener(this.akE);
        this.ako.setOnClickListener(this.akE);
        this.akg = (FrameLayout) this.mRoot.findViewById(a.g.tab_container_view);
        this.akh = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        this.akh.getLayoutParams().width = realScreenHeight;
        this.akf = new CommonEmptyView(this.mContext.getPageActivity());
        this.akf.setVisibility(8);
        this.akf.addToParent(this.akh);
        this.akk = (GiftPanelTabView) this.mRoot.findViewById(a.g.tab);
        this.aki = this.mRoot.findViewById(a.g.donate_layout);
        tz();
        this.akG = (ViewGroup) this.mRoot.findViewById(a.g.ala_gift_draw_layout);
        this.akG.setVisibility(8);
        this.akJ = (AlaGiftDrawPanel) this.mRoot.findViewById(a.g.ala_gift_draw_panel);
        this.akJ.setGiftDrawEventListener(this.ale);
        this.akJ.setGiftCountRange(10, 100);
        this.akp = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_hide_btn);
        this.akp.setOnClickListener(this.akE);
        this.akH = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_clean_btn);
        this.akV = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_revert_btn);
        this.akV.setOnClickListener(this);
        this.akW = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.akW.setComboClickListener(this.akE);
        this.akW.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void tp() {
                AlaGiftTabView.this.aL(true);
            }
        });
        this.akH.setOnClickListener(this.ala);
        this.akH.setEnabled(false);
        this.akV.setEnabled(false);
        this.akI = (TextView) this.mRoot.findViewById(a.g.ala_gift_draw_title);
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

    public void ty() {
        this.akQ = true;
        this.akl.setVisibility(8);
        this.akm.setVisibility(8);
        this.akn.setVisibility(8);
    }

    public void aE(boolean z) {
        this.ajU = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.v.a.zs().zv() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.akn.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.akP.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.akP.add(str);
            }
        }
    }

    public void bh(int i) {
        this.akN = i;
    }

    private void tz() {
        this.akF = new AlaLiveInputEditView(this.mContext.getPageActivity());
        this.akF.setVisibility(8);
        this.akF.setEditViewConfirmCallBack(this);
        this.ajW.addView(this.akF, new RelativeLayout.LayoutParams(-1, -2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.akV && this.akJ != null) {
            this.akJ.uE();
        }
    }

    public void aF(boolean z) {
        this.akX = z;
    }

    public void bB(int i) {
        this.YF = i;
    }

    public void aq(boolean z) {
        this.ajd = z;
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
        tE();
        bD(i);
        this.aka.setCurrentItem(this.aku);
        tI();
        tA();
    }

    private void bD(int i) {
        int min = Math.min(i, this.akC.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.akC.get(i3);
        }
        this.aku = i2;
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
            AlaGiftTabView.this.akv = AlaGiftTabView.this.aku;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void tA() {
        if (this.akA != null && this.akA.agy && !TextUtils.isEmpty(this.akA.agz)) {
            this.akY.setText(this.akA.agz);
            this.akY.setVisibility(0);
            return;
        }
        this.akY.setVisibility(8);
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        tE();
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.bw(i);
                aVar.notifyDataSetChanged();
                this.aki.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                dx("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.akA.rZ()) {
                        this.ako.setStyle(this.akA.rJ() ? 4 : 3);
                        this.ajY.setStyleEnabled(false);
                        this.akG.setVisibility(8);
                        if (!TextUtils.isEmpty(this.akA.rM()) && this.mShowing) {
                            this.mContext.showToast(this.akA.rM());
                            return;
                        }
                        return;
                    }
                    tA();
                    this.ako.setEnabled(true);
                    if (this.akA.sc()) {
                        this.akG.setVisibility(8);
                        this.akJ.uC();
                        if (this.akA.rY() == 6 && this.aiW < 3) {
                            i3 = 3;
                        } else if (this.akA.rY() == 7 && this.aiW < 7) {
                            i3 = 7;
                        } else if (this.akA.rY() == 8 && this.aiW < 13) {
                            i3 = 13;
                        } else if (this.akA.rY() == 9 && this.aiW < 22) {
                            i3 = 22;
                        } else if (this.akA.rY() == 10 && this.aiW < 29) {
                            i3 = 29;
                        } else if (this.akA.rY() == 11 && this.aiW < 39) {
                            i3 = 39;
                        } else if (this.akA.rY() == 12 && this.aiW < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.ako.setStyle(this.akA.rJ() ? 2 : 1);
                    } else {
                        this.ako.setStyle(this.akA.rJ() ? 4 : 3);
                    }
                    this.ajY.setStyleEnabled(z);
                    tQ();
                    i2 = i3;
                } else {
                    this.ako.setStyle(this.akA.rJ() ? 2 : 1);
                    if (this.akA.agx != null && this.akA.agx.agD != null && this.akA.agx.agD.equals("20")) {
                        this.ako.setText("使用");
                    } else {
                        this.ako.setText("赠送");
                    }
                    this.ajY.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.akA.rK()) {
                    aG(true);
                    if (this.akJ != null && this.akJ.getCurrentPointSize() > 0) {
                        this.akI.setVisibility(0);
                    } else {
                        this.akI.setVisibility(8);
                    }
                } else {
                    aG(false);
                    dx("1");
                }
                c(false, i2);
                return;
            }
            this.ako.setStyle(3);
            return;
        }
        this.ako.setStyle(3);
    }

    private void c(boolean z, int i) {
        g.a aVar;
        if (this.mShowing && this.akA != null) {
            if (this.mType == 0) {
                if (this.akA.sb() && !this.ajd) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.akA.rM()) && this.akA.rZ() && !z) {
                    this.mContext.showToast(this.akA.rM());
                } else if (this.akA.sc() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.akA.rX()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (aVar = this.akA.agx) != null && !TextUtils.isEmpty(aVar.agG)) {
                this.mContext.showToast(aVar.agG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.v.a.zs().axR != null && com.baidu.live.v.a.zs().axR.adb != null) {
            String str = com.baidu.live.v.a.zs().axR.adb.aco;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.rY()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tB() {
        if (!this.aky) {
            this.akS = new BdAlertDialog(this.mContext.getPageActivity());
            this.akS.setCancelable(false);
            this.akS.setCanceledOnTouchOutside(false);
            this.akS.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.akS.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.akN)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.akS.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.akS.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.akS.setPositiveButtonTextColor(-57754);
                this.akS.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.akS.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aky = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.akS.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aky = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.akS.create(this.mContext).show();
            this.aky = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(boolean z) {
        int i = 0;
        if (z && com.baidu.live.v.a.zs().awM.ZJ) {
            if (this.akJ.getVisibility() == 0) {
                tK();
            }
        } else {
            aK(true);
        }
        if (z && com.baidu.live.v.a.zs().awM.ZJ) {
            if (Build.VERSION.SDK_INT != 26) {
                this.mContext.getPageActivity().setRequestedOrientation(1);
                this.akT = true;
            }
            this.akG.setVisibility(0);
            tO();
            BdResourceLoader.getInstance().loadResource(this.akA.rF(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.container.AlaGiftTabView.22
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i2) {
                    super.onLoaded((AnonymousClass22) bdImage, str, i2);
                    if (bdImage == null || bdImage.getRawBitmap() == null) {
                        if (AlaGiftTabView.this.mShowing) {
                            BdUtilHelper.showToast(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.mContext.getPageActivity().getString(a.i.ala_gift_noimage_tip));
                        }
                    } else if (str != null && str.equals(AlaGiftTabView.this.akA.rF())) {
                        AlaGiftTabView.this.akJ.setGiftBitmp(bdImage.getRawBitmap());
                    }
                }
            }, null);
            this.ajX.setVisibility(4);
            this.ako.setStyle(1);
            return;
        }
        if (Build.VERSION.SDK_INT != 26 && this.akT) {
            this.mContext.getPageActivity().setRequestedOrientation(3);
            this.akT = false;
        }
        this.akG.setVisibility(8);
        this.akJ.uC();
        View view = this.ajX;
        if (this.akA == null || !this.akA.rJ()) {
            i = 4;
        }
        view.setVisibility(i);
    }

    public boolean tC() {
        return this.akF.getVisibility() == 0;
    }

    public void bE(int i) {
        if (this.akF != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akF.getLayoutParams();
            layoutParams.topMargin = i;
            this.akF.setLayoutParams(layoutParams);
        }
    }

    public void tD() {
        this.akF.xX();
        this.akF.getEditView().setFocusable(true);
        this.akF.getEditView().setFocusableInTouchMode(true);
        this.akF.getEditView().postDelayed(this.alc, 100L);
    }

    public void tE() {
        this.akF.setVisibility(8);
        this.akF.getEditView().post(this.ald);
    }

    public AlaLiveInputEditView tF() {
        return this.akF;
    }

    @Override // com.baidu.live.view.input.b.a
    public void dw(String str) {
        tE();
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        dx(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(String str) {
        this.ajZ.setText(str);
        this.ajZ.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        aH(false);
        if (this.akA != null && this.akA.rJ()) {
            this.ajX.setVisibility(0);
            this.akB = JavaTypesHelper.toInt(this.ajZ.getText().toString(), 1);
            return;
        }
        this.ajX.setVisibility(4);
        this.akB = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(boolean z) {
        this.ajZ.setGravity(17);
        if (z) {
            this.ajZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.ajZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3, boolean z2, int i) {
        if (this.ajN == null || this.ajN.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            this.ajN = arrayList;
            this.ajO = arrayList2;
            this.ajP = arrayList3;
            this.akx = false;
            if (this.ajO == null || this.ajO.isEmpty()) {
                this.akc.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void p(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.akq != null) {
            for (View view : this.akq) {
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
        tG();
        tN();
        if (this.ajN == null || this.ajN.size() <= 0 || !z2) {
            kY();
            if (this.akb != null) {
                this.akb.setVisibility(4);
            }
            this.aki.setVisibility(4);
            this.akf.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.akf.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.akf.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.akf.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.v.a.zs().awM.abg && i != 0) {
                string = string + "(" + i + ")";
            }
            this.akf.setTitle(string);
            this.akf.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.akt != null) {
                        AlaGiftTabView.this.akt.tR();
                    }
                }
            });
            this.akf.setVisibility(0);
            return;
        }
        this.akf.setVisibility(8);
        this.ake.setVisibility(0);
        if (z) {
            h(this.ajO);
        }
        ap apVar = com.baidu.live.v.a.zs().axR;
        if (this.mType == 0 && apVar != null && apVar.adg != null && apVar.adg.aeM && !this.akX && this.ajN.get(0) != null && this.ajN.get(0).sd() != null) {
            List<g> sd = this.ajN.get(0).sd();
            if (!sd.isEmpty()) {
                g gVar = new g();
                gVar.ax(true);
                gVar.setGiftName("发红包");
                sd.add(1, gVar);
            }
        }
        c(this.ajN, z);
        dx("1");
    }

    private void kY() {
        this.aku = 0;
        this.akv = 0;
        this.mSelectedPosition = 0;
        this.akw = 0;
        if (this.akC != null) {
            this.akC.clear();
        }
        if (this.akq != null) {
            this.akq.clear();
        }
        if (this.aka != null) {
            this.aka.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (!b(this.akA) || this.ajU) {
            if (gVar.sc()) {
                if (gVar.rY() == 6 && this.aiW < 3) {
                    return false;
                }
                if (gVar.rY() == 7 && this.aiW < 7) {
                    return false;
                }
                if (gVar.rY() == 8 && this.aiW < 13) {
                    return false;
                }
                if (gVar.rY() == 9 && this.aiW < 22) {
                    return false;
                }
                if (gVar.rY() == 10 && this.aiW < 29) {
                    return false;
                }
                if (gVar.rY() == 11 && this.aiW < 39) {
                    return false;
                }
                if (gVar.rY() == 12 && this.aiW < 47) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void tG() {
        if (ListUtils.getCount(this.ajO) != 0 && ListUtils.getCount(this.ajN) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.d> it = this.ajO.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.d next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.qv()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.ajN.iterator();
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
                Iterator<i> it3 = this.ajN.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().sd().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.rK()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.ajO.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.ajN.removeAll(arrayList2);
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
        List<g> sd;
        if (arrayList != null) {
            this.akC.clear();
            this.akq.clear();
            this.aka.setAdapter(null);
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
                    if (iVar == null || (sd = iVar.sd()) == null || sd.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aks.clear();
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < arrayList.size()) {
                    if (z2) {
                        this.akq.add(bF(i7));
                        this.akC.append(i7, 1);
                    } else {
                        i iVar2 = arrayList.get(i7);
                        iVar2.getCategoryId();
                        List<g> sd2 = iVar2.sd();
                        if (sd2 == null) {
                            i = 0;
                        } else {
                            i = sd2.size();
                        }
                        int i8 = 0;
                        if (i <= 0) {
                            i8 = 1;
                            ArrayList arrayList3 = new ArrayList();
                            if (this.akD.get(i7)) {
                                this.akq.add(aI(true));
                            } else {
                                this.akq.add(b(arrayList3, -1, i7));
                            }
                        } else if (sd2 != null) {
                            int i9 = this.isLandscape ? 12 : 8;
                            int ceil = (int) Math.ceil(i / i9);
                            for (int i10 = 0; i10 < ceil; i10++) {
                                if (i10 == ceil - 1) {
                                    if (i10 * i9 == i - 1) {
                                        ArrayList arrayList4 = new ArrayList();
                                        arrayList4.add(sd2.get(i - 1));
                                        arrayList2 = arrayList4;
                                    } else {
                                        arrayList2 = new ArrayList(sd2.subList(i10 * i9, i));
                                    }
                                } else {
                                    arrayList2 = new ArrayList(sd2.subList(i10 * i9, (i10 + 1) * i9));
                                }
                                this.aks.add(arrayList2);
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
                                        if (gVar == null || gVar.rC() == null || !gVar.rC().equals(String.valueOf(this.akM))) {
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
                                    this.akq.add(b(arrayList2, i3, i7));
                                    this.akG.removeCallbacks(null);
                                    this.akG.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            boolean rK = AlaGiftTabView.this.akA.rK();
                                            AlaGiftTabView.this.aG(rK);
                                            if (!rK) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.akA);
                                                if (!c2) {
                                                    AlaGiftTabView.this.ako.setStyle(AlaGiftTabView.this.akA.rJ() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.ako.setStyle(AlaGiftTabView.this.akA.rJ() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.ajY.setStyleEnabled(c2);
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
                                            if (gVar2 == null || !gVar2.rC().equals(String.valueOf(this.akM))) {
                                                i12 = i2 + 1;
                                            } else {
                                                this.mSelectedPosition = i2;
                                                this.akA = gVar2;
                                                d(gVar2);
                                                break;
                                            }
                                        }
                                        this.akq.add(b(arrayList2, i2, i7));
                                    }
                                    i2 = -1;
                                    this.akq.add(b(arrayList2, i2, i7));
                                }
                            }
                            i8 = ceil;
                        }
                        this.akC.append(i7, i8);
                    }
                    i6 = i7 + 1;
                } else {
                    this.akr = new AlaGiftPagerAdapter(this.akq);
                    this.aka.setAdapter(this.akr);
                    tH();
                    this.aka.setCurrentItem(this.aku);
                    tI();
                    return;
                }
            }
        }
    }

    private void tH() {
        int i = 0;
        if (this.akM > 0 && !ListUtils.isEmpty(this.aks)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aks.size() && !z; i2++) {
                Iterator<g> it = this.aks.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.rC() != null && next.rC().equals(String.valueOf(this.akM))) {
                        this.aku = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.YF == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.akv = this.aku;
            this.aks.clear();
        } else if (this.akL > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.ajO.size()) {
                    break;
                }
                com.baidu.live.data.d dVar = this.ajO.get(i3);
                if (dVar == null || this.akL != dVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    bD(i3);
                    break;
                }
            }
            this.akv = this.aku;
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
                if (AlaGiftTabView.this.akt != null) {
                    AlaGiftTabView.this.akt.tR();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.aC(this.aiY);
        aVar.setGiftItems(list);
        aVar.bv(this.aiW);
        aVar.aq(this.ajd);
        aVar.bw(i);
        if (this.isLandscape) {
            aVar.bx(this.akR / 3);
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
            if (!this.akK) {
                this.akc.setVisibility(0);
            }
            this.akd.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.getCategoryName()) && (this.mType != 0 || (dVar.qv() != null && dVar.qv().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(dVar.getCategoryName());
                    viewGroup.setOnClickListener(new b(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.akz;
                    }
                    if (this.ajN.size() > i && this.ajN.get(i) != null) {
                        for (g gVar : this.ajN.get(i).sd()) {
                            if (gVar != null && gVar.rI() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.akd.addView(viewGroup, layoutParams);
                }
            }
            bG(this.akw);
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
        List<g> sd;
        int childCount = this.akd.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.akw != i || !this.akx) && this.ajO.size() > i && this.ajO.get(i) != null) {
                int min = Math.min(i, this.akC.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.akC.get(i3);
                }
                if (this.akq.size() > i2 && this.ajN.size() > i && (this.akq.get(i2) instanceof ViewGroup)) {
                    this.akv = i2;
                    i iVar = this.ajN.get(i);
                    if (iVar != null && iVar.sd() != null && !iVar.sd().isEmpty()) {
                        d(this.ajN.get(i).sd().get(0));
                        ViewGroup viewGroup = (ViewGroup) this.akq.get(i2);
                        int i4 = 0;
                        while (true) {
                            if (i4 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i4) instanceof GridView)) {
                                i4++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i4)).getAdapter();
                                if (this.akA != null && aVar != null) {
                                    a(aVar, 0);
                                    if (this.mShowing) {
                                        this.akx = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.ajO.size() > i && this.ajO.get(i) != null) {
                int categoryId = this.ajO.get(i).getCategoryId();
                if (!this.akO.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.akO.put(categoryId, true);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewGroup viewGroup2 = (ViewGroup) this.akd.getChildAt(i5);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.ajN.get(i5);
                if (iVar2.se()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.ajT, "");
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
                                    sd = iVar2.sd();
                                    if (sd != null) {
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
                    sd = iVar2.sd();
                    if (sd != null) {
                        ArrayList arrayList = new ArrayList();
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= sd.size()) {
                                break;
                            }
                            g gVar = sd.get(i8);
                            if (!gVar.rZ() && !hashSet.contains(gVar.rC())) {
                                arrayList.add(gVar.rC());
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
                                SharedPrefHelper.getInstance().putString(this.ajT, jSONArray.toString());
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
                    this.akw = i;
                    this.akc.scrollTo(viewGroup2.getLeft(), 0);
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
        if (this.akl != null) {
            this.akl.setVisibility(z ? this.akQ ? 8 : 0 : 8);
        }
        if (this.akm != null) {
            TextView textView = this.akm;
            if (!z && !this.akQ) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void bH(int i) {
        int childCount = this.akd.getChildCount();
        if (i >= 0 && i < childCount && this.ajN != null && this.ajN.size() > i && this.ajN.get(i) != null) {
            this.akD.get(i);
        }
    }

    public void t(int i, int i2) {
        this.akL = i;
        this.akM = i2;
    }

    public void z(long j) {
        if (this.akl != null) {
            if (j >= 100 && (this.aiY || com.baidu.live.v.a.zs().awM.aaA)) {
                this.akl.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.akl.setText(String.valueOf(j));
        }
    }

    public void A(long j) {
        if (this.akm != null) {
            this.akm.setText(String.valueOf(j));
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
        this.aku = i;
        tI();
        tA();
        if (i >= 0 && i < this.akq.size() && (this.akq.get(i) instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.akq.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.akv) {
                            aVar.bw(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.akv) {
                            aVar.bw(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.aki.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void tI() {
        int i = 0;
        for (int i2 = 0; i2 < this.akC.size(); i2++) {
            for (int i3 = 0; i3 < this.akC.get(i2); i3++) {
                if (i + i3 == this.aku) {
                    if (this.akC.get(i2) <= 1) {
                        this.akb.setVisibility(4);
                    } else {
                        this.akb.setVisibility(0);
                    }
                    this.akb.setCount(this.akC.get(i2));
                    this.akb.onPageSelected(i3);
                    bG(i2);
                    return;
                }
            }
            i += this.akC.get(i2);
        }
    }

    public g tJ() {
        return this.akA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(boolean z) {
        if (this.akJ != null) {
            this.akJ.aK(z);
        }
    }

    private void tK() {
        if (this.akJ != null) {
            this.akJ.tK();
            this.akJ.uD();
        }
    }

    public l tL() {
        l lVar = new l();
        lVar.ahA = BdUtilHelper.dip2px(this.mContext.getPageActivity(), 32.0f);
        lVar.ahB.addAll(this.akJ.getPoints());
        lVar.ahy = this.akJ.getMeasuredHeight();
        lVar.ahx = this.akJ.getMeasuredWidth();
        Rect rect = new Rect();
        this.akJ.getGlobalVisibleRect(rect);
        lVar.ahv = rect.left;
        lVar.ahw = rect.top;
        lVar.ahC = lVar.ahB.size();
        lVar.ahE = this.akJ.getGraffitiPointDesDatas();
        lVar.ahD = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext.getPageActivity());
        lVar.aht = screenDimensions[0];
        lVar.ahu = screenDimensions[1];
        return lVar;
    }

    public int tM() {
        return this.akB;
    }

    public void a(DialogInterface.OnCancelListener onCancelListener) {
    }

    public void tN() {
    }

    public void a(c cVar) {
        this.akt = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tO() {
        if (this.akJ != null) {
            if (this.akJ.getCurrentPointSize() > 0) {
                this.akJ.setTipImageVisibility(8);
            } else {
                this.akJ.setTipImageVisibility(0);
            }
        }
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.alf);
        MessageManager.getInstance().registerListener(this.alg);
        MessageManager.getInstance().registerListener(this.alh);
        MessageManager.getInstance().registerListener(this.ali);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.akq) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.akq) {
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
    public void tP() {
        if (!ListUtils.isEmpty(this.akq)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.akq) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.ajd);
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
    public void tQ() {
        if (this.akA != null && this.akA.sb()) {
            this.ajY.setStyleEnabled(this.ajd);
            if (this.ajd) {
                this.ako.setStyle(this.akA.rJ() ? 2 : 1);
            } else {
                this.ako.setStyle(this.akA.rJ() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.alf);
        MessageManager.getInstance().unRegisterListener(this.alg);
        MessageManager.getInstance().unRegisterListener(this.alh);
        MessageManager.getInstance().unRegisterListener(this.ali);
        kY();
        if (this.akS != null) {
            this.akS.dismiss();
        }
    }

    public void aC(boolean z) {
        this.aiY = z;
    }

    public void bI(int i) {
        this.aiW = i;
    }

    public void d(g gVar) {
        this.akA = gVar;
        if (this.akJ != null) {
            this.akJ.setAlaGiftItem(gVar);
        }
        if (gVar != null && !gVar.rL()) {
            this.akW.tm();
        }
    }

    public void tl() {
        if (this.akW != null) {
            this.akW.tl();
        }
    }

    public void tk() {
        if (this.akW != null) {
            this.akW.tk();
        }
    }

    public void aL(boolean z) {
        if (this.ako != null) {
            this.ako.setVisibility(z ? 0 : 4);
        }
    }
}

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
import com.baidu.live.c.o;
import com.baidu.live.data.ak;
import com.baidu.live.data.k;
import com.baidu.live.gift.container.AlaComboBtnAnimView;
import com.baidu.live.gift.container.a;
import com.baidu.live.gift.g;
import com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel;
import com.baidu.live.gift.i;
import com.baidu.live.gift.l;
import com.baidu.live.gift.widget.panel.GiftPanelNumRoundRectView;
import com.baidu.live.gift.widget.panel.GiftPanelOperationSendView;
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import com.baidu.live.q.a;
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
/* loaded from: classes2.dex */
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, View.OnClickListener, b.a {
    private int Wq;
    private int afT;
    private boolean afV;
    public ArrayList<i> agK;
    private ArrayList<com.baidu.live.data.c> agL;
    private ArrayList<com.baidu.live.data.d> agM;
    private final String agQ;
    private final int agR;
    private final int agS;
    private boolean agT;
    public ViewGroup agU;
    protected ViewGroup agV;
    protected View agW;
    private GiftPanelNumRoundRectView agX;
    public TextView agY;
    protected BaseViewPager agZ;
    private boolean aga;
    private int ahA;
    private SparseIntArray ahB;
    private SparseBooleanArray ahC;
    private View.OnClickListener ahD;
    private AlaLiveInputEditView ahE;
    private ViewGroup ahF;
    private ImageButton ahG;
    private TextView ahH;
    private AlaGiftDrawPanel ahI;
    private boolean ahJ;
    private int ahK;
    private int ahL;
    private int ahM;
    private SparseBooleanArray ahN;
    private Set<String> ahO;
    private boolean ahP;
    private boolean ahQ;
    private int ahR;
    private BdAlertDialog ahS;
    private boolean ahT;
    private int ahU;
    private ImageButton ahV;
    private AlaComboBtnAnimView ahW;
    private boolean ahX;
    private TextView ahY;
    private View.OnClickListener ahZ;
    protected RoundRectPageIndicator aha;
    protected HorizontalScrollView ahb;
    protected LinearLayout ahc;
    protected View ahd;
    private CommonEmptyView ahe;
    private FrameLayout ahf;
    private FrameLayout ahg;
    private View ahh;
    private com.baidu.live.gift.container.c ahi;
    public GiftPanelTabView ahj;
    private TextView ahk;
    private TextView ahl;
    private TextView ahm;
    public GiftPanelOperationSendView ahn;
    private ImageButton aho;
    private List<View> ahp;
    private AlaGiftPagerAdapter ahq;
    private ArrayList<List<g>> ahr;
    private c ahs;
    private int aht;
    private int ahu;
    private int ahv;
    private boolean ahw;
    private boolean ahx;
    private int ahy;
    private g ahz;
    private View.OnClickListener aia;
    AdapterView.OnItemClickListener aib;
    Runnable aic;
    Runnable aie;
    private AlaGiftDrawPanel.a aif;
    private CustomMessageListener aig;
    private CustomMessageListener aih;
    private CustomMessageListener aii;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private ViewGroup mRoot;
    private int mSelectedPosition;
    private int mType;
    private String otherParams;
    private String roomId;

    /* loaded from: classes2.dex */
    public interface c {
        void sk();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.agQ = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.agR = 10;
        this.agS = 100;
        this.ahp = new ArrayList();
        this.aht = 0;
        this.ahu = 0;
        this.mSelectedPosition = 0;
        this.ahv = 0;
        this.ahB = new SparseIntArray();
        this.ahC = new SparseBooleanArray();
        this.isLandscape = false;
        this.ahJ = false;
        this.ahK = -1;
        this.ahL = -1;
        this.afV = false;
        this.afT = -1;
        this.ahN = new SparseBooleanArray();
        this.ahO = new HashSet();
        this.ahT = false;
        this.ahX = false;
        this.aga = false;
        this.ahZ = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.ahW == null || !AlaGiftTabView.this.ahW.rK()) {
                    if (AlaGiftTabView.this.ahi == null) {
                        AlaGiftTabView.this.ahi = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aib);
                    }
                    AlaGiftTabView.this.aC(true);
                    AlaGiftTabView.this.ahi.a(AlaGiftTabView.this.agW, AlaGiftTabView.this.agM, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.aC(false);
                        }
                    });
                }
            }
        };
        this.aia = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabView.this.ahG.setEnabled(false);
                AlaGiftTabView.this.ahV.setEnabled(false);
                AlaGiftTabView.this.aF(false);
                AlaGiftTabView.this.aif.c(0, 0L);
            }
        };
        this.aib = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.ahi.dismiss();
                if (AlaGiftTabView.this.agM == null || AlaGiftTabView.this.agM.size() <= 0) {
                    AlaGiftTabView.this.dl("1");
                } else if (i != AlaGiftTabView.this.agM.size()) {
                    com.baidu.live.data.d dVar = (com.baidu.live.data.d) AlaGiftTabView.this.agM.get(i);
                    if (dVar != null) {
                        int number = dVar.getNumber();
                        if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.ahz.adR) != null) {
                            if (number == -1) {
                                number = aVar.adY;
                            }
                            if (number > AlaGiftTabView.this.ahU) {
                                number = AlaGiftTabView.this.ahU;
                            }
                        }
                        AlaGiftTabView.this.dl(String.valueOf(number));
                    }
                } else {
                    AlaGiftTabView.this.rW();
                }
            }
        };
        this.aic = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
            @Override // java.lang.Runnable
            public void run() {
                AlaGiftTabView.this.ahE.getEditView().requestFocus();
                AlaGiftTabView.this.ahE.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.ahE.getEditView());
            }
        };
        this.aie = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.ahE.getEditView());
            }
        };
        this.aif = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void c(int i, long j) {
                AlaGiftTabView.this.ahH.setText(String.format(AlaGiftTabView.this.mContext.getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i > 0) {
                    AlaGiftTabView.this.ahG.setEnabled(true);
                    AlaGiftTabView.this.ahV.setEnabled(true);
                    AlaGiftTabView.this.sh();
                    AlaGiftTabView.this.agW.setVisibility(4);
                    AlaGiftTabView.this.ahH.setVisibility(0);
                } else {
                    AlaGiftTabView.this.sh();
                    AlaGiftTabView.this.ahH.setVisibility(8);
                    AlaGiftTabView.this.ahG.setEnabled(false);
                    AlaGiftTabView.this.ahV.setEnabled(false);
                }
                AlaGiftTabView.this.ahA = i;
            }
        };
        this.aig = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.acH == 1 || cVar.acH == 2 || cVar.acH == 5 || cVar.acH == 6) && cVar.acI != null) {
                        AlaGiftTabView.this.dm(cVar.acI.getId());
                    }
                }
            }
        };
        this.aih = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.az(true);
                if (AlaGiftTabView.this.ahz != null && AlaGiftTabView.this.a(AlaGiftTabView.this.ahz) && AlaGiftTabView.this.agT) {
                    AlaGiftTabView.this.ahn.setStyle(AlaGiftTabView.this.ahz.qE() ? 2 : 1);
                    AlaGiftTabView.this.agX.setStyleEnabled(true);
                }
            }
        };
        this.aii = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                k kVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && (kVar = (k) customResponsedMessage.getData()) != null && kVar.Wc != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = kVar.Wc.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aga != z2) {
                        AlaGiftTabView.this.aga = z2;
                        AlaGiftTabView.this.sj();
                        AlaGiftTabView.this.si();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.ahD = onClickListener;
        this.ahJ = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.ahy = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        if (this.isLandscape) {
            this.ahR = (ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity()) - (BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds112) * 2)) - BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds16);
            this.agZ.getLayoutParams().height = this.ahR;
        } else {
            this.agZ.getLayoutParams().height = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds192) * 2;
        }
        this.agZ.requestLayout();
        this.ahr = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.ahU = 9999;
                break;
            case 1:
                this.ahU = 999;
                break;
        }
        this.ahE.setMaxText(String.valueOf(this.ahU));
        this.ahE.setHintText(String.format(Locale.getDefault(), this.mContext.getString(a.i.ala_send_gift_count_hint), Integer.valueOf(this.ahU)));
    }

    public void S(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void ay(boolean z) {
        this.ahQ = z;
    }

    public void onVisibilityChanged(boolean z) {
        ay(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        int realScreenHeight = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.agU = (ViewGroup) this.mRoot.findViewById(a.g.gift_list_layout);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.mContext.getResources().getColor(a.d.live_gift_panel_primary));
        float dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        if (this.isLandscape) {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
        } else {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.agU.setBackgroundDrawable(gradientDrawable);
        this.agU.getLayoutParams().width = realScreenHeight;
        this.ahY = (TextView) this.mRoot.findViewById(a.g.gift_toast);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(BdUtilHelper.dip2px(this.mContext.getPageActivity(), 5.0f));
        gradientDrawable2.setColor(-1560281088);
        this.ahY.setBackgroundDrawable(gradientDrawable2);
        if (UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity()) == 2) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahY.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.addRule(2, 0);
            layoutParams.addRule(12);
            layoutParams.addRule(5, this.agU.getId());
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds90);
            this.ahY.setLayoutParams(layoutParams);
            int dimens = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds12);
            this.ahY.setPadding(dimens, dimens, dimens, dimens);
            this.ahY.setBackgroundColor(-1560281088);
            this.ahY.setGravity(17);
        }
        this.ahY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.ahz != null && AlaGiftTabView.this.ahz.adS && !TextUtils.isEmpty(AlaGiftTabView.this.ahz.adU)) {
                    UrlManager.getInstance().dealOneLink(AlaGiftTabView.this.mContext, new String[]{AlaGiftTabView.this.ahz.adU});
                }
            }
        });
        this.agV = (ViewGroup) this.mRoot.findViewById(a.g.gift_tab_input_parent);
        this.agW = this.mRoot.findViewById(a.g.gift_count_layout);
        this.agW.setOnClickListener(this.ahZ);
        this.agX = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.agY = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.agY.setText("1");
        this.agY.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.ahd = this.mRoot.findViewById(a.g.gift_lower_layout);
        this.agZ = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.agZ.setOnPageChangeListener(this);
        this.aha = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.ahc = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.ahb = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.ahJ) {
            this.ahb.setVisibility(8);
        }
        this.ahk = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.ahk.setOnClickListener(this.ahD);
        this.ahl = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.ahl.setOnClickListener(this.ahD);
        this.ahn = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.ahm = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.ahm.setOnClickListener(this.ahD);
        this.ahn.setOnClickListener(this.ahD);
        this.ahf = (FrameLayout) this.mRoot.findViewById(a.g.tab_container_view);
        this.ahg = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        this.ahg.getLayoutParams().width = realScreenHeight;
        this.ahe = new CommonEmptyView(this.mContext.getPageActivity());
        this.ahe.setVisibility(8);
        this.ahe.addToParent(this.ahg);
        this.ahj = (GiftPanelTabView) this.mRoot.findViewById(a.g.tab);
        this.ahh = this.mRoot.findViewById(a.g.donate_layout);
        rS();
        this.ahF = (ViewGroup) this.mRoot.findViewById(a.g.ala_gift_draw_layout);
        this.ahF.setVisibility(8);
        this.ahI = (AlaGiftDrawPanel) this.mRoot.findViewById(a.g.ala_gift_draw_panel);
        this.ahI.setGiftDrawEventListener(this.aif);
        this.ahI.setGiftCountRange(10, 100);
        this.aho = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_hide_btn);
        this.aho.setOnClickListener(this.ahD);
        this.ahG = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_clean_btn);
        this.ahV = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_revert_btn);
        this.ahV.setOnClickListener(this);
        this.ahW = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.ahW.setComboClickListener(this.ahD);
        this.ahW.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void rL() {
                AlaGiftTabView.this.aG(true);
            }
        });
        this.ahG.setOnClickListener(this.aia);
        this.ahG.setEnabled(false);
        this.ahV.setEnabled(false);
        this.ahH = (TextView) this.mRoot.findViewById(a.g.ala_gift_draw_title);
        View findViewById = this.mRoot.findViewById(a.g.ala_gift_draw_title_layout);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds128);
        } else {
            layoutParams2.height = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) - UtilHelper.getStatusBarHeight();
        }
        findViewById.setLayoutParams(layoutParams2);
        findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public void rR() {
        this.ahP = true;
        this.ahk.setVisibility(8);
        this.ahl.setVisibility(8);
        this.ahm.setVisibility(8);
    }

    public void az(boolean z) {
        this.agT = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.r.a.wA().wD() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.ahm.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.ahO.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.ahO.add(str);
            }
        }
    }

    public void ba(int i) {
        this.ahM = i;
    }

    private void rS() {
        this.ahE = new AlaLiveInputEditView(this.mContext.getPageActivity());
        this.ahE.setVisibility(8);
        this.ahE.setEditViewConfirmCallBack(this);
        this.agV.addView(this.ahE, new RelativeLayout.LayoutParams(-1, -2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ahV && this.ahI != null) {
            this.ahI.sR();
        }
    }

    public void aA(boolean z) {
        this.ahX = z;
    }

    public void bu(int i) {
        this.Wq = i;
    }

    public void an(boolean z) {
        this.aga = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        private int mPosition;

        public b(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaGiftTabView.this.bv(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(int i) {
        rX();
        bw(i);
        this.agZ.setCurrentItem(this.aht);
        sb();
        rT();
    }

    private void bw(int i) {
        int min = Math.min(i, this.ahB.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.ahB.get(i3);
        }
        this.aht = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        private a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            g item = ((com.baidu.live.gift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.isRed()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new o(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.ahu = AlaGiftTabView.this.aht;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void rT() {
        if (this.ahz != null && this.ahz.adS && !TextUtils.isEmpty(this.ahz.adT)) {
            this.ahY.setText(this.ahz.adT);
            this.ahY.setVisibility(0);
            return;
        }
        this.ahY.setVisibility(8);
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        boolean z;
        boolean z2;
        g.a aVar2;
        boolean z3 = true;
        if (this.ahQ) {
            this.mSelectedPosition = i;
            rX();
            if (aVar != null) {
                g item = aVar.getItem(i);
                if (item != null) {
                    c(item);
                    aVar.bp(i);
                    aVar.notifyDataSetChanged();
                    this.ahh.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                    dl("1");
                    if (this.mType == 1 && (aVar2 = this.ahz.adR) != null && !TextUtils.isEmpty(aVar2.aea)) {
                        this.mContext.showToast(aVar2.aea);
                    }
                    int i3 = -1;
                    if (this.mType == 0) {
                        if (this.ahz.qM()) {
                            this.ahn.setStyle(this.ahz.qE() ? 4 : 3);
                            this.agX.setStyleEnabled(false);
                            this.ahF.setVisibility(8);
                            if (!TextUtils.isEmpty(this.ahz.qH())) {
                                this.mContext.showToast(this.ahz.qH());
                                return;
                            }
                            return;
                        }
                        rT();
                        boolean a2 = a(this.ahz);
                        if (a2 && !this.agT) {
                            rU();
                            this.ahn.setStyle(this.ahz.qE() ? 4 : 3);
                            this.agX.setStyleEnabled(false);
                            this.ahF.setVisibility(8);
                            return;
                        }
                        this.ahn.setEnabled(true);
                        if (this.ahz.qP()) {
                            this.ahF.setVisibility(8);
                            this.ahI.sP();
                            if (this.ahz.qL() == 6 && this.afT < 3) {
                                i3 = 3;
                            } else if (this.ahz.qL() == 7 && this.afT < 7) {
                                i3 = 7;
                            } else if (this.ahz.qL() == 8 && this.afT < 13) {
                                i3 = 13;
                            } else if (this.ahz.qL() == 9 && this.afT < 22) {
                                i3 = 22;
                            } else if (this.ahz.qL() == 10 && this.afT < 29) {
                                i3 = 29;
                            } else if (this.ahz.qL() == 11 && this.afT < 39) {
                                i3 = 39;
                            } else if (this.ahz.qL() == 12 && this.afT < 47) {
                                i3 = 47;
                            }
                        }
                        boolean z4 = i3 == -1;
                        if (z4) {
                            this.ahn.setStyle(this.ahz.qE() ? 2 : 1);
                        } else {
                            this.ahn.setStyle(this.ahz.qE() ? 4 : 3);
                        }
                        this.agX.setStyleEnabled(z4);
                        sj();
                        i2 = i3;
                        z = a2;
                    } else {
                        this.ahn.setStyle(this.ahz.qE() ? 2 : 1);
                        if (this.ahz.adR != null && this.ahz.adR.adX != null && this.ahz.adR.adX.equals("20")) {
                            this.ahn.setText("使用");
                        } else {
                            this.ahn.setText("赠送");
                        }
                        this.agX.setStyleEnabled(true);
                        i2 = -1;
                        z = false;
                    }
                    if (this.ahz.qF()) {
                        aB(true);
                        if (this.ahI != null && this.ahI.getCurrentPointSize() > 0) {
                            this.ahH.setVisibility(0);
                        } else {
                            this.ahH.setVisibility(8);
                        }
                    } else {
                        aB(false);
                    }
                    if (this.mType == 0) {
                        if (TextUtils.isEmpty(this.ahz.qH()) || !this.ahz.qM() || z) {
                            z2 = false;
                        } else {
                            this.mContext.showToast(this.ahz.qH());
                            z2 = true;
                        }
                        if (z2 || !this.ahz.qP() || i2 == -1) {
                            z3 = z2;
                        } else {
                            this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i2)));
                        }
                        if (!z3 && this.ahz.qK()) {
                            BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.ahn.setStyle(3);
                return;
            }
            this.ahn.setStyle(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(g gVar) {
        if (com.baidu.live.r.a.wA().asy != null && com.baidu.live.r.a.wA().asy.aaG != null) {
            String str = com.baidu.live.r.a.wA().asy.aaG.ZU;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.qL()))) {
                return true;
            }
        }
        return false;
    }

    private void rU() {
        if (!this.ahx) {
            this.ahS = new BdAlertDialog(this.mContext.getPageActivity());
            this.ahS.setCancelable(false);
            this.ahS.setCanceledOnTouchOutside(false);
            this.ahS.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.ahS.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.ahM)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ahS.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.ahS.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.ahS.setPositiveButtonTextColor(-57754);
                this.ahS.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.ahS.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.ahx = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.ahS.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.ahx = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.ahS.create(this.mContext).show();
            this.ahx = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(boolean z) {
        int i = 0;
        if (z && com.baidu.live.r.a.wA().arE.Xp) {
            if (this.ahI.getVisibility() == 0) {
                sd();
            }
        } else {
            aF(true);
        }
        if (z && com.baidu.live.r.a.wA().arE.Xp) {
            if (Build.VERSION.SDK_INT != 26) {
                this.mContext.getPageActivity().setRequestedOrientation(1);
                this.ahT = true;
            }
            this.ahF.setVisibility(0);
            sh();
            BdResourceLoader.getInstance().loadResource(this.ahz.qA(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i2) {
                    super.onLoaded((AnonymousClass21) bdImage, str, i2);
                    if (bdImage == null || bdImage.getRawBitmap() == null) {
                        BdUtilHelper.showToast(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.mContext.getPageActivity().getString(a.i.ala_gift_noimage_tip));
                    } else if (str != null && str.equals(AlaGiftTabView.this.ahz.qA())) {
                        AlaGiftTabView.this.ahI.setGiftBitmp(bdImage.getRawBitmap());
                    }
                }
            }, null);
            this.agW.setVisibility(4);
            this.ahn.setStyle(1);
            return;
        }
        if (Build.VERSION.SDK_INT != 26 && this.ahT) {
            this.mContext.getPageActivity().setRequestedOrientation(3);
            this.ahT = false;
        }
        this.ahF.setVisibility(8);
        this.ahI.sP();
        View view = this.agW;
        if (this.ahz == null || !this.ahz.qE()) {
            i = 4;
        }
        view.setVisibility(i);
    }

    public boolean rV() {
        return this.ahE.getVisibility() == 0;
    }

    public void bx(int i) {
        if (this.ahE != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ahE.getLayoutParams();
            layoutParams.topMargin = i;
            this.ahE.setLayoutParams(layoutParams);
        }
    }

    public void rW() {
        this.ahE.vC();
        this.ahE.getEditView().setFocusable(true);
        this.ahE.getEditView().setFocusableInTouchMode(true);
        this.ahE.getEditView().postDelayed(this.aic, 100L);
    }

    public void rX() {
        this.ahE.setVisibility(8);
        this.ahE.getEditView().post(this.aie);
    }

    public AlaLiveInputEditView rY() {
        return this.ahE;
    }

    @Override // com.baidu.live.view.input.b.a
    public void dk(String str) {
        rX();
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        dl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(String str) {
        this.agY.setText(str);
        this.agY.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        aC(false);
        if (this.ahz != null && this.ahz.qE()) {
            this.agW.setVisibility(0);
            this.ahA = JavaTypesHelper.toInt(this.agY.getText().toString(), 1);
            return;
        }
        this.agW.setVisibility(4);
        this.ahA = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aC(boolean z) {
        this.agY.setGravity(17);
        if (z) {
            this.agY.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.agY.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.c> arrayList2, ArrayList<com.baidu.live.data.d> arrayList3, boolean z2) {
        this.agK = arrayList;
        this.agL = arrayList2;
        this.agM = arrayList3;
        this.ahw = false;
        if (this.agL == null || this.agL.isEmpty()) {
            this.ahb.setVisibility(8);
        }
        e(z, z2);
    }

    public void p(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.ahp != null) {
            for (View view : this.ahp) {
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

    public void e(boolean z, boolean z2) {
        rZ();
        sg();
        if (this.agK == null || this.agK.size() <= 0 || !z2) {
            kI();
            if (this.aha != null) {
                this.aha.setVisibility(4);
            }
            this.ahh.setVisibility(4);
            this.ahe.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                this.ahe.setTitle(a.i.sdk_net_fail_tip_rank);
                this.ahe.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                this.ahe.setTitle(a.i.sdk_net_fail_tip_rank);
                this.ahe.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                this.ahe.setTitle(a.i.sdk_net_no);
                this.ahe.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            this.ahe.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.ahs != null) {
                        AlaGiftTabView.this.ahs.sk();
                    }
                }
            });
            this.ahe.setVisibility(0);
            return;
        }
        this.ahe.setVisibility(8);
        this.ahd.setVisibility(0);
        if (z) {
            g(this.agL);
        }
        ak akVar = com.baidu.live.r.a.wA().asy;
        if (this.mType == 0 && akVar != null && akVar.aaK != null && akVar.aaK.aco && !this.ahX && this.agK.get(0) != null && this.agK.get(0).qQ() != null) {
            List<g> qQ = this.agK.get(0).qQ();
            if (!qQ.isEmpty()) {
                g gVar = new g();
                gVar.au(true);
                gVar.setGiftName("发红包");
                qQ.add(1, gVar);
            }
        }
        c(this.agK, z);
        dl("1");
    }

    private void kI() {
        this.aht = 0;
        this.ahu = 0;
        this.mSelectedPosition = 0;
        this.ahv = 0;
        if (this.ahB != null) {
            this.ahB.clear();
        }
        if (this.ahp != null) {
            this.ahp.clear();
        }
        if (this.agZ != null) {
            this.agZ.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (!a(this.ahz) || this.agT) {
            if (gVar.qP()) {
                if (gVar.qL() == 6 && this.afT < 3) {
                    return false;
                }
                if (gVar.qL() == 7 && this.afT < 7) {
                    return false;
                }
                if (gVar.qL() == 8 && this.afT < 13) {
                    return false;
                }
                if (gVar.qL() == 9 && this.afT < 22) {
                    return false;
                }
                if (gVar.qL() == 10 && this.afT < 29) {
                    return false;
                }
                if (gVar.qL() == 11 && this.afT < 39) {
                    return false;
                }
                if (gVar.qL() == 12 && this.afT < 47) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void rZ() {
        if (ListUtils.getCount(this.agL) != 0 && ListUtils.getCount(this.agK) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.c> it = this.agL.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.c next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.pB()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.agK.iterator();
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
                Iterator<i> it3 = this.agK.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().qQ().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.qF()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.agL.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.agK.removeAll(arrayList2);
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
        List<g> qQ;
        if (arrayList != null) {
            this.ahB.clear();
            this.ahp.clear();
            this.agZ.setAdapter(null);
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
                    if (iVar == null || (qQ = iVar.qQ()) == null || qQ.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.ahr.clear();
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < arrayList.size()) {
                    if (z2) {
                        this.ahp.add(by(i7));
                        this.ahB.append(i7, 1);
                    } else {
                        i iVar2 = arrayList.get(i7);
                        iVar2.getCategoryId();
                        List<g> qQ2 = iVar2.qQ();
                        if (qQ2 == null) {
                            i = 0;
                        } else {
                            i = qQ2.size();
                        }
                        int i8 = 0;
                        if (i <= 0) {
                            i8 = 1;
                            ArrayList arrayList3 = new ArrayList();
                            if (this.ahC.get(i7)) {
                                this.ahp.add(aD(true));
                            } else {
                                this.ahp.add(b(arrayList3, -1, i7));
                            }
                        } else if (qQ2 != null) {
                            int i9 = this.isLandscape ? 12 : 8;
                            int ceil = (int) Math.ceil(i / i9);
                            for (int i10 = 0; i10 < ceil; i10++) {
                                if (i10 == ceil - 1) {
                                    if (i10 * i9 == i - 1) {
                                        ArrayList arrayList4 = new ArrayList();
                                        arrayList4.add(qQ2.get(i - 1));
                                        arrayList2 = arrayList4;
                                    } else {
                                        arrayList2 = new ArrayList(qQ2.subList(i10 * i9, i));
                                    }
                                } else {
                                    arrayList2 = new ArrayList(qQ2.subList(i10 * i9, (i10 + 1) * i9));
                                }
                                this.ahr.add(arrayList2);
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
                                        if (gVar == null || gVar.qx() == null || !gVar.qx().equals(String.valueOf(this.ahL))) {
                                            i11 = i3 + 1;
                                        } else {
                                            this.mSelectedPosition = i3;
                                            break;
                                        }
                                    }
                                    if (gVar == null && arrayList2.size() > 0) {
                                        gVar = arrayList2.get(0);
                                    }
                                    c(gVar);
                                    this.ahp.add(b(arrayList2, i3, i7));
                                    this.ahF.removeCallbacks(null);
                                    this.ahF.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            boolean qF = AlaGiftTabView.this.ahz.qF();
                                            AlaGiftTabView.this.aB(qF);
                                            if (!qF) {
                                                boolean b2 = AlaGiftTabView.this.b(AlaGiftTabView.this.ahz);
                                                if (!b2) {
                                                    AlaGiftTabView.this.ahn.setStyle(AlaGiftTabView.this.ahz.qE() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.ahn.setStyle(AlaGiftTabView.this.ahz.qE() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.agX.setStyleEnabled(b2);
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
                                            if (gVar2 == null || !gVar2.qx().equals(String.valueOf(this.ahL))) {
                                                i12 = i2 + 1;
                                            } else {
                                                this.mSelectedPosition = i2;
                                                this.ahz = gVar2;
                                                c(gVar2);
                                                break;
                                            }
                                        }
                                        this.ahp.add(b(arrayList2, i2, i7));
                                    }
                                    i2 = -1;
                                    this.ahp.add(b(arrayList2, i2, i7));
                                }
                            }
                            i8 = ceil;
                        }
                        this.ahB.append(i7, i8);
                    }
                    i6 = i7 + 1;
                } else {
                    this.ahq = new AlaGiftPagerAdapter(this.ahp);
                    this.agZ.setAdapter(this.ahq);
                    sa();
                    this.agZ.setCurrentItem(this.aht);
                    sb();
                    return;
                }
            }
        }
    }

    private void sa() {
        int i = 0;
        if (this.ahL > 0 && !ListUtils.isEmpty(this.ahr)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.ahr.size() && !z; i2++) {
                Iterator<g> it = this.ahr.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.qx() != null && next.qx().equals(String.valueOf(this.ahL))) {
                        this.aht = i2;
                        z = true;
                        c(next);
                        break;
                    }
                }
            }
            if (this.Wq == 111 && !z) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.ahu = this.aht;
            this.ahr.clear();
        } else if (this.ahK > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.agL.size()) {
                    break;
                }
                com.baidu.live.data.c cVar = this.agL.get(i3);
                if (cVar == null || this.ahK != cVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    bw(i3);
                    break;
                }
            }
            this.ahu = this.aht;
        }
    }

    private View aD(boolean z) {
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
                if (AlaGiftTabView.this.ahs != null) {
                    AlaGiftTabView.this.ahs.sk();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.ax(this.afV);
        aVar.setGiftItems(list);
        aVar.bo(this.afT);
        aVar.an(this.aga);
        aVar.bp(i);
        if (this.isLandscape) {
            aVar.bq(this.ahR / 3);
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
                if (tag instanceof a.C0078a) {
                    ((a.C0078a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout by(int i) {
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
    private void g(ArrayList<com.baidu.live.data.c> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.ahJ) {
                this.ahb.setVisibility(0);
            }
            this.ahc.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.c cVar = arrayList.get(i);
                if (!TextUtils.isEmpty(cVar.getCategoryName()) && (this.mType != 0 || (cVar.pB() != null && cVar.pB().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(cVar.getCategoryName());
                    viewGroup.setOnClickListener(new b(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.ahy;
                    }
                    if (this.agK.size() > i && this.agK.get(i) != null) {
                        for (g gVar : this.agK.get(i).qQ()) {
                            if (gVar != null && gVar.qD() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.ahc.addView(viewGroup, layoutParams);
                }
            }
            bz(this.ahv);
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
    private void bz(int i) {
        JSONArray jSONArray;
        JSONException e;
        List<g> qQ;
        int childCount = this.ahc.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.ahv != i || !this.ahw) && this.agL.size() > i && this.agL.get(i) != null) {
                int min = Math.min(i, this.ahB.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.ahB.get(i3);
                }
                if (this.ahp.size() > i2 && this.agK.size() > i && (this.ahp.get(i2) instanceof ViewGroup)) {
                    this.ahu = i2;
                    i iVar = this.agK.get(i);
                    if (iVar != null && iVar.qQ() != null && !iVar.qQ().isEmpty()) {
                        c(this.agK.get(i).qQ().get(0));
                        ViewGroup viewGroup = (ViewGroup) this.ahp.get(i2);
                        int i4 = 0;
                        while (true) {
                            if (i4 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i4) instanceof GridView)) {
                                i4++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i4)).getAdapter();
                                if (this.ahz != null && aVar != null) {
                                    a(aVar, 0);
                                    if (this.ahQ) {
                                        this.ahw = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.agL.size() > i && this.agL.get(i) != null) {
                int categoryId = this.agL.get(i).getCategoryId();
                if (!this.ahN.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.ahN.put(categoryId, true);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewGroup viewGroup2 = (ViewGroup) this.ahc.getChildAt(i5);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.agK.get(i5);
                if (iVar2.qR()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.agQ, "");
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
                                    qQ = iVar2.qQ();
                                    if (qQ != null) {
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
                    qQ = iVar2.qQ();
                    if (qQ != null) {
                        ArrayList arrayList = new ArrayList();
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= qQ.size()) {
                                break;
                            }
                            g gVar = qQ.get(i8);
                            if (!gVar.qM() && !hashSet.contains(gVar.qx())) {
                                arrayList.add(gVar.qx());
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
                                SharedPrefHelper.getInstance().putString(this.agQ, jSONArray.toString());
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
                    bA(i);
                    this.ahv = i;
                    this.ahb.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i5 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            aE(false);
                        } else {
                            aE(true);
                        }
                    } else {
                        aE(true);
                    }
                }
            }
        }
    }

    private void aE(boolean z) {
        int i = 8;
        if (this.ahk != null) {
            this.ahk.setVisibility(z ? this.ahP ? 8 : 0 : 8);
        }
        if (this.ahl != null) {
            TextView textView = this.ahl;
            if (!z && !this.ahP) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void bA(int i) {
        int childCount = this.ahc.getChildCount();
        if (i >= 0 && i < childCount && this.agK != null && this.agK.size() > i && this.agK.get(i) != null) {
            this.ahC.get(i);
        }
    }

    public void o(int i, int i2) {
        this.ahK = i;
        this.ahL = i2;
    }

    public void y(long j) {
        if (this.ahk != null) {
            if (j >= 100 && (this.afV || com.baidu.live.r.a.wA().arE.Ym)) {
                this.ahk.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.ahk.setText(String.valueOf(j));
        }
    }

    public void z(long j) {
        if (this.ahl != null) {
            this.ahl.setText(String.valueOf(j));
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
        this.aht = i;
        sb();
        rT();
        if (i >= 0 && i < this.ahp.size() && (this.ahp.get(i) instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.ahp.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.ahu) {
                            aVar.bp(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.ahu) {
                            aVar.bp(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.ahh.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void sb() {
        int i = 0;
        for (int i2 = 0; i2 < this.ahB.size(); i2++) {
            for (int i3 = 0; i3 < this.ahB.get(i2); i3++) {
                if (i + i3 == this.aht) {
                    if (this.ahB.get(i2) <= 1) {
                        this.aha.setVisibility(4);
                    } else {
                        this.aha.setVisibility(0);
                    }
                    this.aha.setCount(this.ahB.get(i2));
                    this.aha.onPageSelected(i3);
                    bz(i2);
                    return;
                }
            }
            i += this.ahB.get(i2);
        }
    }

    public g sc() {
        return this.ahz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(boolean z) {
        if (this.ahI != null) {
            this.ahI.aF(z);
        }
    }

    private void sd() {
        if (this.ahI != null) {
            this.ahI.sd();
            this.ahI.sQ();
        }
    }

    public l se() {
        l lVar = new l();
        lVar.aeA = BdUtilHelper.dip2px(this.mContext.getPageActivity(), 32.0f);
        lVar.aeB.addAll(this.ahI.getPoints());
        lVar.aey = this.ahI.getMeasuredHeight();
        lVar.aex = this.ahI.getMeasuredWidth();
        Rect rect = new Rect();
        this.ahI.getGlobalVisibleRect(rect);
        lVar.aev = rect.left;
        lVar.aew = rect.top;
        lVar.aeC = lVar.aeB.size();
        lVar.aeE = this.ahI.getGraffitiPointDesDatas();
        lVar.aeD = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext.getPageActivity());
        lVar.aet = screenDimensions[0];
        lVar.aeu = screenDimensions[1];
        return lVar;
    }

    public int sf() {
        return this.ahA;
    }

    public void a(DialogInterface.OnCancelListener onCancelListener) {
    }

    public void sg() {
    }

    public void a(c cVar) {
        this.ahs = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        if (this.ahI != null) {
            if (this.ahI.getCurrentPointSize() > 0) {
                this.ahI.setTipImageVisibility(8);
            } else {
                this.ahI.setTipImageVisibility(0);
            }
        }
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aig);
        MessageManager.getInstance().registerListener(this.aih);
        MessageManager.getInstance().registerListener(this.aii);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(final String str) {
        if (!ListUtils.isEmpty(this.ahp) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.ahp) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, str);
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
    public void si() {
        if (!ListUtils.isEmpty(this.ahp)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.ahp) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aga);
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
    public void sj() {
        if (this.ahz != null && this.ahz.qO()) {
            this.agX.setStyleEnabled(this.aga);
            if (this.aga) {
                this.ahn.setStyle(this.ahz.qE() ? 2 : 1);
                return;
            }
            this.ahn.setStyle(this.ahz.qE() ? 4 : 3);
            BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.sdk_throne_disabled_alert);
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aig);
        MessageManager.getInstance().unRegisterListener(this.aih);
        MessageManager.getInstance().unRegisterListener(this.aii);
        if (this.ahS != null) {
            this.ahS.dismiss();
        }
    }

    public void ax(boolean z) {
        this.afV = z;
    }

    public void bB(int i) {
        this.afT = i;
    }

    public void c(g gVar) {
        this.ahz = gVar;
        if (this.ahI != null) {
            this.ahI.setAlaGiftItem(gVar);
        }
        if (gVar != null && !gVar.qG()) {
            this.ahW.rJ();
        }
    }

    public void rI() {
        if (this.ahW != null) {
            this.ahW.rI();
        }
    }

    public void rH() {
        if (this.ahW != null) {
            this.ahW.rH();
        }
    }

    public void aG(boolean z) {
        if (this.ahn != null) {
            this.ahn.setVisibility(z ? 0 : 4);
        }
    }
}

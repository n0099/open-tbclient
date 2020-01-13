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
import com.baidu.live.data.ao;
import com.baidu.live.data.l;
import com.baidu.live.gift.container.AlaComboBtnAnimView;
import com.baidu.live.gift.container.a;
import com.baidu.live.gift.g;
import com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel;
import com.baidu.live.gift.i;
import com.baidu.live.gift.widget.panel.GiftPanelNumRoundRectView;
import com.baidu.live.gift.widget.panel.GiftPanelOperationSendView;
import com.baidu.live.gift.widget.panel.GiftPanelTabView;
import com.baidu.live.r.a;
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
    private int WJ;
    private int agD;
    private boolean agF;
    private boolean agK;
    private final int ahA;
    private final int ahB;
    private boolean ahC;
    public ViewGroup ahD;
    protected ViewGroup ahE;
    protected View ahF;
    private GiftPanelNumRoundRectView ahG;
    public TextView ahH;
    protected BaseViewPager ahI;
    protected RoundRectPageIndicator ahJ;
    protected HorizontalScrollView ahK;
    protected LinearLayout ahL;
    protected View ahM;
    private CommonEmptyView ahN;
    private FrameLayout ahO;
    private FrameLayout ahP;
    private View ahQ;
    private com.baidu.live.gift.container.c ahR;
    public GiftPanelTabView ahS;
    private TextView ahT;
    private TextView ahU;
    private TextView ahV;
    public GiftPanelOperationSendView ahW;
    private ImageButton ahX;
    private List<View> ahY;
    private AlaGiftPagerAdapter ahZ;
    public ArrayList<i> aht;
    private ArrayList<com.baidu.live.data.c> ahu;
    private ArrayList<com.baidu.live.data.d> ahv;
    private final String ahz;
    private int aiA;
    private BdAlertDialog aiB;
    private boolean aiC;
    private int aiD;
    private ImageButton aiE;
    private AlaComboBtnAnimView aiF;
    private boolean aiG;
    private TextView aiH;
    private View.OnClickListener aiI;
    private View.OnClickListener aiJ;
    AdapterView.OnItemClickListener aiK;
    Runnable aiL;
    Runnable aiM;
    private AlaGiftDrawPanel.a aiN;
    private CustomMessageListener aiO;
    private CustomMessageListener aiP;
    private CustomMessageListener aiQ;
    private ArrayList<List<g>> aia;
    private c aib;
    private int aic;
    private int aie;
    private int aif;
    private boolean aig;
    private boolean aih;
    private int aii;
    private g aij;
    private int aik;
    private SparseIntArray ail;
    private SparseBooleanArray aim;
    private View.OnClickListener ain;
    private AlaLiveInputEditView aio;
    private ViewGroup aip;
    private ImageButton aiq;
    private TextView air;
    private AlaGiftDrawPanel ais;
    private boolean ait;
    private int aiu;
    private int aiv;
    private int aiw;
    private SparseBooleanArray aix;
    private Set<String> aiy;
    private boolean aiz;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private ViewGroup mRoot;
    private int mSelectedPosition;
    private boolean mShowing;
    private int mType;
    private String otherParams;
    private String roomId;

    /* loaded from: classes2.dex */
    public interface c {
        void sA();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.ahz = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.ahA = 10;
        this.ahB = 100;
        this.ahY = new ArrayList();
        this.aic = 0;
        this.aie = 0;
        this.mSelectedPosition = 0;
        this.aif = 0;
        this.ail = new SparseIntArray();
        this.aim = new SparseBooleanArray();
        this.isLandscape = false;
        this.ait = false;
        this.aiu = -1;
        this.aiv = -1;
        this.agF = false;
        this.agD = -1;
        this.aix = new SparseBooleanArray();
        this.aiy = new HashSet();
        this.aiC = false;
        this.aiG = false;
        this.agK = false;
        this.aiI = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aiF == null || !AlaGiftTabView.this.aiF.rX()) {
                    if (AlaGiftTabView.this.ahR == null) {
                        AlaGiftTabView.this.ahR = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aiK);
                    }
                    AlaGiftTabView.this.aE(true);
                    AlaGiftTabView.this.ahR.a(AlaGiftTabView.this.ahF, AlaGiftTabView.this.ahv, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.aE(false);
                        }
                    });
                }
            }
        };
        this.aiJ = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabView.this.aiq.setEnabled(false);
                AlaGiftTabView.this.aiE.setEnabled(false);
                AlaGiftTabView.this.aH(false);
                AlaGiftTabView.this.aiN.c(0, 0L);
            }
        };
        this.aiK = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.ahR.dismiss();
                if (AlaGiftTabView.this.ahv == null || AlaGiftTabView.this.ahv.size() <= 0) {
                    AlaGiftTabView.this.dn("1");
                } else if (i != AlaGiftTabView.this.ahv.size()) {
                    com.baidu.live.data.d dVar = (com.baidu.live.data.d) AlaGiftTabView.this.ahv.get(i);
                    if (dVar != null) {
                        int number = dVar.getNumber();
                        if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.aij.aeg) != null) {
                            if (number == -1) {
                                number = aVar.aen;
                            }
                            if (number > AlaGiftTabView.this.aiD) {
                                number = AlaGiftTabView.this.aiD;
                            }
                        }
                        AlaGiftTabView.this.dn(String.valueOf(number));
                    }
                } else {
                    AlaGiftTabView.this.sm();
                }
            }
        };
        this.aiL = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
            @Override // java.lang.Runnable
            public void run() {
                AlaGiftTabView.this.aio.getEditView().requestFocus();
                AlaGiftTabView.this.aio.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.aio.getEditView());
            }
        };
        this.aiM = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.aio.getEditView());
            }
        };
        this.aiN = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void c(int i, long j) {
                AlaGiftTabView.this.air.setText(String.format(AlaGiftTabView.this.mContext.getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i > 0) {
                    AlaGiftTabView.this.aiq.setEnabled(true);
                    AlaGiftTabView.this.aiE.setEnabled(true);
                    AlaGiftTabView.this.sx();
                    AlaGiftTabView.this.ahF.setVisibility(4);
                    AlaGiftTabView.this.air.setVisibility(0);
                } else {
                    AlaGiftTabView.this.sx();
                    AlaGiftTabView.this.air.setVisibility(8);
                    AlaGiftTabView.this.aiq.setEnabled(false);
                    AlaGiftTabView.this.aiE.setEnabled(false);
                }
                AlaGiftTabView.this.aik = i;
            }
        };
        this.aiO = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.acT == 1 || cVar.acT == 2 || cVar.acT == 5 || cVar.acT == 6) && cVar.acU != null) {
                        AlaGiftTabView.this.m15do(cVar.acU.getId());
                    }
                }
            }
        };
        this.aiP = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.aB(true);
                if (AlaGiftTabView.this.aij != null && AlaGiftTabView.this.a(AlaGiftTabView.this.aij) && AlaGiftTabView.this.ahC) {
                    AlaGiftTabView.this.ahW.setStyle(AlaGiftTabView.this.aij.qL() ? 2 : 1);
                    AlaGiftTabView.this.ahG.setStyleEnabled(true);
                }
            }
        };
        this.aiQ = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l lVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l) && (lVar = (l) customResponsedMessage.getData()) != null && lVar.Wt != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = lVar.Wt.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.agK != z2) {
                        AlaGiftTabView.this.agK = z2;
                        AlaGiftTabView.this.sz();
                        AlaGiftTabView.this.sy();
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.ain = onClickListener;
        this.ait = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aii = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        if (this.isLandscape) {
            this.aiA = (ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity()) - (BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds112) * 2)) - BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds16);
            this.ahI.getLayoutParams().height = this.aiA;
        } else {
            this.ahI.getLayoutParams().height = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds192) * 2;
        }
        this.ahI.requestLayout();
        this.aia = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aiD = 9999;
                break;
            case 1:
                this.aiD = 999;
                break;
        }
        this.aio.setMaxText(String.valueOf(this.aiD));
        this.aio.setHintText(String.format(Locale.getDefault(), this.mContext.getString(a.i.ala_send_gift_count_hint), Integer.valueOf(this.aiD)));
    }

    public void R(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void aA(boolean z) {
        this.mShowing = z;
    }

    public void onVisibilityChanged(boolean z) {
        aA(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        int realScreenHeight = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.ahD = (ViewGroup) this.mRoot.findViewById(a.g.gift_list_layout);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.mContext.getResources().getColor(a.d.live_gift_panel_primary));
        float dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        if (this.isLandscape) {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
        } else {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.ahD.setBackgroundDrawable(gradientDrawable);
        this.ahD.getLayoutParams().width = realScreenHeight;
        this.aiH = (TextView) this.mRoot.findViewById(a.g.gift_toast);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(BdUtilHelper.dip2px(this.mContext.getPageActivity(), 5.0f));
        gradientDrawable2.setColor(-1560281088);
        this.aiH.setBackgroundDrawable(gradientDrawable2);
        if (UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity()) == 2) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aiH.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.addRule(2, 0);
            layoutParams.addRule(12);
            layoutParams.addRule(5, this.ahD.getId());
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds90);
            this.aiH.setLayoutParams(layoutParams);
            int dimens = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds12);
            this.aiH.setPadding(dimens, dimens, dimens, dimens);
            this.aiH.setBackgroundColor(-1560281088);
            this.aiH.setGravity(17);
        }
        this.aiH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aij != null && AlaGiftTabView.this.aij.aeh && !TextUtils.isEmpty(AlaGiftTabView.this.aij.aej)) {
                    UrlManager.getInstance().dealOneLink(AlaGiftTabView.this.mContext, new String[]{AlaGiftTabView.this.aij.aej});
                }
            }
        });
        this.aiH.setVisibility(8);
        this.ahE = (ViewGroup) this.mRoot.findViewById(a.g.gift_tab_input_parent);
        this.ahF = this.mRoot.findViewById(a.g.gift_count_layout);
        this.ahF.setOnClickListener(this.aiI);
        this.ahG = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.ahH = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.ahH.setText("1");
        this.ahH.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.ahM = this.mRoot.findViewById(a.g.gift_lower_layout);
        this.ahI = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.ahI.setOnPageChangeListener(this);
        this.ahJ = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.ahL = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.ahK = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.ait) {
            this.ahK.setVisibility(8);
        }
        this.ahT = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.ahT.setOnClickListener(this.ain);
        this.ahU = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.ahU.setOnClickListener(this.ain);
        this.ahW = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.ahV = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.ahV.setOnClickListener(this.ain);
        this.ahW.setOnClickListener(this.ain);
        this.ahO = (FrameLayout) this.mRoot.findViewById(a.g.tab_container_view);
        this.ahP = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        this.ahP.getLayoutParams().width = realScreenHeight;
        this.ahN = new CommonEmptyView(this.mContext.getPageActivity());
        this.ahN.setVisibility(8);
        this.ahN.addToParent(this.ahP);
        this.ahS = (GiftPanelTabView) this.mRoot.findViewById(a.g.tab);
        this.ahQ = this.mRoot.findViewById(a.g.donate_layout);
        si();
        this.aip = (ViewGroup) this.mRoot.findViewById(a.g.ala_gift_draw_layout);
        this.aip.setVisibility(8);
        this.ais = (AlaGiftDrawPanel) this.mRoot.findViewById(a.g.ala_gift_draw_panel);
        this.ais.setGiftDrawEventListener(this.aiN);
        this.ais.setGiftCountRange(10, 100);
        this.ahX = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_hide_btn);
        this.ahX.setOnClickListener(this.ain);
        this.aiq = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_clean_btn);
        this.aiE = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_revert_btn);
        this.aiE.setOnClickListener(this);
        this.aiF = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.aiF.setComboClickListener(this.ain);
        this.aiF.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void rY() {
                AlaGiftTabView.this.aI(true);
            }
        });
        this.aiq.setOnClickListener(this.aiJ);
        this.aiq.setEnabled(false);
        this.aiE.setEnabled(false);
        this.air = (TextView) this.mRoot.findViewById(a.g.ala_gift_draw_title);
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

    public void sh() {
        this.aiz = true;
        this.ahT.setVisibility(8);
        this.ahU.setVisibility(8);
        this.ahV.setVisibility(8);
    }

    public void aB(boolean z) {
        this.ahC = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.s.a.wR().wU() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.ahV.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aiy.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aiy.add(str);
            }
        }
    }

    public void ba(int i) {
        this.aiw = i;
    }

    private void si() {
        this.aio = new AlaLiveInputEditView(this.mContext.getPageActivity());
        this.aio.setVisibility(8);
        this.aio.setEditViewConfirmCallBack(this);
        this.ahE.addView(this.aio, new RelativeLayout.LayoutParams(-1, -2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aiE && this.ais != null) {
            this.ais.th();
        }
    }

    public void aC(boolean z) {
        this.aiG = z;
    }

    public void bu(int i) {
        this.WJ = i;
    }

    public void an(boolean z) {
        this.agK = z;
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
        sn();
        bw(i);
        this.ahI.setCurrentItem(this.aic);
        sr();
        sj();
    }

    private void bw(int i) {
        int min = Math.min(i, this.ail.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.ail.get(i3);
        }
        this.aic = i2;
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.aie = AlaGiftTabView.this.aic;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void sj() {
        if (this.aij != null && this.aij.aeh && !TextUtils.isEmpty(this.aij.aei)) {
            this.aiH.setText(this.aij.aei);
            this.aiH.setVisibility(0);
            return;
        }
        this.aiH.setVisibility(8);
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        boolean z;
        this.mSelectedPosition = i;
        sn();
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                c(item);
                aVar.bp(i);
                aVar.notifyDataSetChanged();
                this.ahQ.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                dn("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aij.qT()) {
                        this.ahW.setStyle(this.aij.qL() ? 4 : 3);
                        this.ahG.setStyleEnabled(false);
                        this.aip.setVisibility(8);
                        if (!TextUtils.isEmpty(this.aij.qO()) && this.mShowing) {
                            this.mContext.showToast(this.aij.qO());
                            return;
                        }
                        return;
                    }
                    sj();
                    boolean a2 = a(this.aij);
                    if (a2 && !this.ahC) {
                        sk();
                        this.ahW.setStyle(this.aij.qL() ? 4 : 3);
                        this.ahG.setStyleEnabled(false);
                        this.aip.setVisibility(8);
                        return;
                    }
                    this.ahW.setEnabled(true);
                    if (this.aij.qW()) {
                        this.aip.setVisibility(8);
                        this.ais.tf();
                        if (this.aij.qS() == 6 && this.agD < 3) {
                            i3 = 3;
                        } else if (this.aij.qS() == 7 && this.agD < 7) {
                            i3 = 7;
                        } else if (this.aij.qS() == 8 && this.agD < 13) {
                            i3 = 13;
                        } else if (this.aij.qS() == 9 && this.agD < 22) {
                            i3 = 22;
                        } else if (this.aij.qS() == 10 && this.agD < 29) {
                            i3 = 29;
                        } else if (this.aij.qS() == 11 && this.agD < 39) {
                            i3 = 39;
                        } else if (this.aij.qS() == 12 && this.agD < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z2 = i3 == -1;
                    if (z2) {
                        this.ahW.setStyle(this.aij.qL() ? 2 : 1);
                    } else {
                        this.ahW.setStyle(this.aij.qL() ? 4 : 3);
                    }
                    this.ahG.setStyleEnabled(z2);
                    sz();
                    i2 = i3;
                    z = a2;
                } else {
                    this.ahW.setStyle(this.aij.qL() ? 2 : 1);
                    if (this.aij.aeg != null && this.aij.aeg.aem != null && this.aij.aeg.aem.equals("20")) {
                        this.ahW.setText("使用");
                    } else {
                        this.ahW.setText("赠送");
                    }
                    this.ahG.setStyleEnabled(true);
                    i2 = -1;
                    z = false;
                }
                if (this.aij.qM()) {
                    aD(true);
                    if (this.ais != null && this.ais.getCurrentPointSize() > 0) {
                        this.air.setVisibility(0);
                    } else {
                        this.air.setVisibility(8);
                    }
                } else {
                    aD(false);
                    dn("1");
                }
                c(z, i2);
                return;
            }
            this.ahW.setStyle(3);
            return;
        }
        this.ahW.setStyle(3);
    }

    private void c(boolean z, int i) {
        g.a aVar;
        if (this.mShowing && this.aij != null) {
            if (this.mType == 0) {
                if (this.aij.qV() && !this.agK) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aij.qO()) && this.aij.qT() && !z) {
                    this.mContext.showToast(this.aij.qO());
                } else if (this.aij.qW() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aij.qR()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (aVar = this.aij.aeg) != null && !TextUtils.isEmpty(aVar.aep)) {
                this.mContext.showToast(aVar.aep);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(g gVar) {
        if (com.baidu.live.s.a.wR().atk != null && com.baidu.live.s.a.wR().atk.aaT != null) {
            String str = com.baidu.live.s.a.wR().atk.aaT.aai;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.qS()))) {
                return true;
            }
        }
        return false;
    }

    private void sk() {
        if (!this.aih) {
            this.aiB = new BdAlertDialog(this.mContext.getPageActivity());
            this.aiB.setCancelable(false);
            this.aiB.setCanceledOnTouchOutside(false);
            this.aiB.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.aiB.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aiw)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aiB.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.aiB.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aiB.setPositiveButtonTextColor(-57754);
                this.aiB.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aiB.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aih = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aiB.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aih = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aiB.create(this.mContext).show();
            this.aih = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(boolean z) {
        int i = 0;
        if (z && com.baidu.live.s.a.wR().asq.XI) {
            if (this.ais.getVisibility() == 0) {
                st();
            }
        } else {
            aH(true);
        }
        if (z && com.baidu.live.s.a.wR().asq.XI) {
            if (Build.VERSION.SDK_INT != 26) {
                this.mContext.getPageActivity().setRequestedOrientation(1);
                this.aiC = true;
            }
            this.aip.setVisibility(0);
            sx();
            BdResourceLoader.getInstance().loadResource(this.aij.qH(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i2) {
                    super.onLoaded((AnonymousClass21) bdImage, str, i2);
                    if (bdImage == null || bdImage.getRawBitmap() == null) {
                        if (AlaGiftTabView.this.mShowing) {
                            BdUtilHelper.showToast(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.mContext.getPageActivity().getString(a.i.ala_gift_noimage_tip));
                        }
                    } else if (str != null && str.equals(AlaGiftTabView.this.aij.qH())) {
                        AlaGiftTabView.this.ais.setGiftBitmp(bdImage.getRawBitmap());
                    }
                }
            }, null);
            this.ahF.setVisibility(4);
            this.ahW.setStyle(1);
            return;
        }
        if (Build.VERSION.SDK_INT != 26 && this.aiC) {
            this.mContext.getPageActivity().setRequestedOrientation(3);
            this.aiC = false;
        }
        this.aip.setVisibility(8);
        this.ais.tf();
        View view = this.ahF;
        if (this.aij == null || !this.aij.qL()) {
            i = 4;
        }
        view.setVisibility(i);
    }

    public boolean sl() {
        return this.aio.getVisibility() == 0;
    }

    public void bx(int i) {
        if (this.aio != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aio.getLayoutParams();
            layoutParams.topMargin = i;
            this.aio.setLayoutParams(layoutParams);
        }
    }

    public void sm() {
        this.aio.vT();
        this.aio.getEditView().setFocusable(true);
        this.aio.getEditView().setFocusableInTouchMode(true);
        this.aio.getEditView().postDelayed(this.aiL, 100L);
    }

    public void sn() {
        this.aio.setVisibility(8);
        this.aio.getEditView().post(this.aiM);
    }

    public AlaLiveInputEditView so() {
        return this.aio;
    }

    @Override // com.baidu.live.view.input.b.a
    public void dm(String str) {
        sn();
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        dn(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(String str) {
        this.ahH.setText(str);
        this.ahH.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        aE(false);
        if (this.aij != null && this.aij.qL()) {
            this.ahF.setVisibility(0);
            this.aik = JavaTypesHelper.toInt(this.ahH.getText().toString(), 1);
            return;
        }
        this.ahF.setVisibility(4);
        this.aik = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(boolean z) {
        this.ahH.setGravity(17);
        if (z) {
            this.ahH.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.ahH.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.c> arrayList2, ArrayList<com.baidu.live.data.d> arrayList3, boolean z2, int i) {
        if (this.aht == null || this.aht.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            this.aht = arrayList;
            this.ahu = arrayList2;
            this.ahv = arrayList3;
            this.aig = false;
            if (this.ahu == null || this.ahu.isEmpty()) {
                this.ahK.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void p(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.ahY != null) {
            for (View view : this.ahY) {
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
        sp();
        sw();
        if (this.aht == null || this.aht.size() <= 0 || !z2) {
            kJ();
            if (this.ahJ != null) {
                this.ahJ.setVisibility(4);
            }
            this.ahQ.setVisibility(4);
            this.ahN.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.ahN.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.ahN.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.ahN.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.s.a.wR().asq.Zd && i != 0) {
                string = string + "(" + i + ")";
            }
            this.ahN.setTitle(string);
            this.ahN.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aib != null) {
                        AlaGiftTabView.this.aib.sA();
                    }
                }
            });
            this.ahN.setVisibility(0);
            return;
        }
        this.ahN.setVisibility(8);
        this.ahM.setVisibility(0);
        if (z) {
            g(this.ahu);
        }
        ao aoVar = com.baidu.live.s.a.wR().atk;
        if (this.mType == 0 && aoVar != null && aoVar.aaX != null && aoVar.aaX.acB && !this.aiG && this.aht.get(0) != null && this.aht.get(0).qX() != null) {
            List<g> qX = this.aht.get(0).qX();
            if (!qX.isEmpty()) {
                g gVar = new g();
                gVar.au(true);
                gVar.setGiftName("发红包");
                qX.add(1, gVar);
            }
        }
        c(this.aht, z);
        dn("1");
    }

    private void kJ() {
        this.aic = 0;
        this.aie = 0;
        this.mSelectedPosition = 0;
        this.aif = 0;
        if (this.ail != null) {
            this.ail.clear();
        }
        if (this.ahY != null) {
            this.ahY.clear();
        }
        if (this.ahI != null) {
            this.ahI.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (!a(this.aij) || this.ahC) {
            if (gVar.qW()) {
                if (gVar.qS() == 6 && this.agD < 3) {
                    return false;
                }
                if (gVar.qS() == 7 && this.agD < 7) {
                    return false;
                }
                if (gVar.qS() == 8 && this.agD < 13) {
                    return false;
                }
                if (gVar.qS() == 9 && this.agD < 22) {
                    return false;
                }
                if (gVar.qS() == 10 && this.agD < 29) {
                    return false;
                }
                if (gVar.qS() == 11 && this.agD < 39) {
                    return false;
                }
                if (gVar.qS() == 12 && this.agD < 47) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private void sp() {
        if (ListUtils.getCount(this.ahu) != 0 && ListUtils.getCount(this.aht) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.c> it = this.ahu.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.c next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.pF()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.aht.iterator();
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
                Iterator<i> it3 = this.aht.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().qX().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.qM()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.ahu.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aht.removeAll(arrayList2);
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
        List<g> qX;
        if (arrayList != null) {
            this.ail.clear();
            this.ahY.clear();
            this.ahI.setAdapter(null);
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
                    if (iVar == null || (qX = iVar.qX()) == null || qX.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aia.clear();
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < arrayList.size()) {
                    if (z2) {
                        this.ahY.add(by(i7));
                        this.ail.append(i7, 1);
                    } else {
                        i iVar2 = arrayList.get(i7);
                        iVar2.getCategoryId();
                        List<g> qX2 = iVar2.qX();
                        if (qX2 == null) {
                            i = 0;
                        } else {
                            i = qX2.size();
                        }
                        int i8 = 0;
                        if (i <= 0) {
                            i8 = 1;
                            ArrayList arrayList3 = new ArrayList();
                            if (this.aim.get(i7)) {
                                this.ahY.add(aF(true));
                            } else {
                                this.ahY.add(b(arrayList3, -1, i7));
                            }
                        } else if (qX2 != null) {
                            int i9 = this.isLandscape ? 12 : 8;
                            int ceil = (int) Math.ceil(i / i9);
                            for (int i10 = 0; i10 < ceil; i10++) {
                                if (i10 == ceil - 1) {
                                    if (i10 * i9 == i - 1) {
                                        ArrayList arrayList4 = new ArrayList();
                                        arrayList4.add(qX2.get(i - 1));
                                        arrayList2 = arrayList4;
                                    } else {
                                        arrayList2 = new ArrayList(qX2.subList(i10 * i9, i));
                                    }
                                } else {
                                    arrayList2 = new ArrayList(qX2.subList(i10 * i9, (i10 + 1) * i9));
                                }
                                this.aia.add(arrayList2);
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
                                        if (gVar == null || gVar.qE() == null || !gVar.qE().equals(String.valueOf(this.aiv))) {
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
                                    this.ahY.add(b(arrayList2, i3, i7));
                                    this.aip.removeCallbacks(null);
                                    this.aip.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            boolean qM = AlaGiftTabView.this.aij.qM();
                                            AlaGiftTabView.this.aD(qM);
                                            if (!qM) {
                                                boolean b2 = AlaGiftTabView.this.b(AlaGiftTabView.this.aij);
                                                if (!b2) {
                                                    AlaGiftTabView.this.ahW.setStyle(AlaGiftTabView.this.aij.qL() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.ahW.setStyle(AlaGiftTabView.this.aij.qL() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.ahG.setStyleEnabled(b2);
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
                                            if (gVar2 == null || !gVar2.qE().equals(String.valueOf(this.aiv))) {
                                                i12 = i2 + 1;
                                            } else {
                                                this.mSelectedPosition = i2;
                                                this.aij = gVar2;
                                                c(gVar2);
                                                break;
                                            }
                                        }
                                        this.ahY.add(b(arrayList2, i2, i7));
                                    }
                                    i2 = -1;
                                    this.ahY.add(b(arrayList2, i2, i7));
                                }
                            }
                            i8 = ceil;
                        }
                        this.ail.append(i7, i8);
                    }
                    i6 = i7 + 1;
                } else {
                    this.ahZ = new AlaGiftPagerAdapter(this.ahY);
                    this.ahI.setAdapter(this.ahZ);
                    sq();
                    this.ahI.setCurrentItem(this.aic);
                    sr();
                    return;
                }
            }
        }
    }

    private void sq() {
        int i = 0;
        if (this.aiv > 0 && !ListUtils.isEmpty(this.aia)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aia.size() && !z; i2++) {
                Iterator<g> it = this.aia.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.qE() != null && next.qE().equals(String.valueOf(this.aiv))) {
                        this.aic = i2;
                        z = true;
                        c(next);
                        break;
                    }
                }
            }
            if (this.WJ == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.aie = this.aic;
            this.aia.clear();
        } else if (this.aiu > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.ahu.size()) {
                    break;
                }
                com.baidu.live.data.c cVar = this.ahu.get(i3);
                if (cVar == null || this.aiu != cVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    bw(i3);
                    break;
                }
            }
            this.aie = this.aic;
        }
    }

    private View aF(boolean z) {
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
                if (AlaGiftTabView.this.aib != null) {
                    AlaGiftTabView.this.aib.sA();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.az(this.agF);
        aVar.setGiftItems(list);
        aVar.bo(this.agD);
        aVar.an(this.agK);
        aVar.bp(i);
        if (this.isLandscape) {
            aVar.bq(this.aiA / 3);
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
            if (!this.ait) {
                this.ahK.setVisibility(0);
            }
            this.ahL.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.c cVar = arrayList.get(i);
                if (!TextUtils.isEmpty(cVar.getCategoryName()) && (this.mType != 0 || (cVar.pF() != null && cVar.pF().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(cVar.getCategoryName());
                    viewGroup.setOnClickListener(new b(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aii;
                    }
                    if (this.aht.size() > i && this.aht.get(i) != null) {
                        for (g gVar : this.aht.get(i).qX()) {
                            if (gVar != null && gVar.qK() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.ahL.addView(viewGroup, layoutParams);
                }
            }
            bz(this.aif);
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
        List<g> qX;
        int childCount = this.ahL.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aif != i || !this.aig) && this.ahu.size() > i && this.ahu.get(i) != null) {
                int min = Math.min(i, this.ail.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.ail.get(i3);
                }
                if (this.ahY.size() > i2 && this.aht.size() > i && (this.ahY.get(i2) instanceof ViewGroup)) {
                    this.aie = i2;
                    i iVar = this.aht.get(i);
                    if (iVar != null && iVar.qX() != null && !iVar.qX().isEmpty()) {
                        c(this.aht.get(i).qX().get(0));
                        ViewGroup viewGroup = (ViewGroup) this.ahY.get(i2);
                        int i4 = 0;
                        while (true) {
                            if (i4 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i4) instanceof GridView)) {
                                i4++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i4)).getAdapter();
                                if (this.aij != null && aVar != null) {
                                    a(aVar, 0);
                                    if (this.mShowing) {
                                        this.aig = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.ahu.size() > i && this.ahu.get(i) != null) {
                int categoryId = this.ahu.get(i).getCategoryId();
                if (!this.aix.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aix.put(categoryId, true);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewGroup viewGroup2 = (ViewGroup) this.ahL.getChildAt(i5);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.aht.get(i5);
                if (iVar2.qY()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.ahz, "");
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
                                    qX = iVar2.qX();
                                    if (qX != null) {
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
                    qX = iVar2.qX();
                    if (qX != null) {
                        ArrayList arrayList = new ArrayList();
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= qX.size()) {
                                break;
                            }
                            g gVar = qX.get(i8);
                            if (!gVar.qT() && !hashSet.contains(gVar.qE())) {
                                arrayList.add(gVar.qE());
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
                                SharedPrefHelper.getInstance().putString(this.ahz, jSONArray.toString());
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
                    this.aif = i;
                    this.ahK.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i5 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            aG(false);
                        } else {
                            aG(true);
                        }
                    } else {
                        aG(true);
                    }
                }
            }
        }
    }

    private void aG(boolean z) {
        int i = 8;
        if (this.ahT != null) {
            this.ahT.setVisibility(z ? this.aiz ? 8 : 0 : 8);
        }
        if (this.ahU != null) {
            TextView textView = this.ahU;
            if (!z && !this.aiz) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void bA(int i) {
        int childCount = this.ahL.getChildCount();
        if (i >= 0 && i < childCount && this.aht != null && this.aht.size() > i && this.aht.get(i) != null) {
            this.aim.get(i);
        }
    }

    public void s(int i, int i2) {
        this.aiu = i;
        this.aiv = i2;
    }

    public void y(long j) {
        if (this.ahT != null) {
            if (j >= 100 && (this.agF || com.baidu.live.s.a.wR().asq.Yy)) {
                this.ahT.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.ahT.setText(String.valueOf(j));
        }
    }

    public void z(long j) {
        if (this.ahU != null) {
            this.ahU.setText(String.valueOf(j));
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
        this.aic = i;
        sr();
        sj();
        if (i >= 0 && i < this.ahY.size() && (this.ahY.get(i) instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.ahY.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aie) {
                            aVar.bp(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aie) {
                            aVar.bp(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.ahQ.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void sr() {
        int i = 0;
        for (int i2 = 0; i2 < this.ail.size(); i2++) {
            for (int i3 = 0; i3 < this.ail.get(i2); i3++) {
                if (i + i3 == this.aic) {
                    if (this.ail.get(i2) <= 1) {
                        this.ahJ.setVisibility(4);
                    } else {
                        this.ahJ.setVisibility(0);
                    }
                    this.ahJ.setCount(this.ail.get(i2));
                    this.ahJ.onPageSelected(i3);
                    bz(i2);
                    return;
                }
            }
            i += this.ail.get(i2);
        }
    }

    public g ss() {
        return this.aij;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(boolean z) {
        if (this.ais != null) {
            this.ais.aH(z);
        }
    }

    private void st() {
        if (this.ais != null) {
            this.ais.st();
            this.ais.tg();
        }
    }

    public com.baidu.live.gift.l su() {
        com.baidu.live.gift.l lVar = new com.baidu.live.gift.l();
        lVar.afj = BdUtilHelper.dip2px(this.mContext.getPageActivity(), 32.0f);
        lVar.afk.addAll(this.ais.getPoints());
        lVar.afh = this.ais.getMeasuredHeight();
        lVar.afg = this.ais.getMeasuredWidth();
        Rect rect = new Rect();
        this.ais.getGlobalVisibleRect(rect);
        lVar.afe = rect.left;
        lVar.aff = rect.top;
        lVar.afl = lVar.afk.size();
        lVar.afn = this.ais.getGraffitiPointDesDatas();
        lVar.afm = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext.getPageActivity());
        lVar.afc = screenDimensions[0];
        lVar.afd = screenDimensions[1];
        return lVar;
    }

    public int sv() {
        return this.aik;
    }

    public void a(DialogInterface.OnCancelListener onCancelListener) {
    }

    public void sw() {
    }

    public void a(c cVar) {
        this.aib = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sx() {
        if (this.ais != null) {
            if (this.ais.getCurrentPointSize() > 0) {
                this.ais.setTipImageVisibility(8);
            } else {
                this.ais.setTipImageVisibility(0);
            }
        }
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aiO);
        MessageManager.getInstance().registerListener(this.aiP);
        MessageManager.getInstance().registerListener(this.aiQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: do  reason: not valid java name */
    public void m15do(final String str) {
        if (!ListUtils.isEmpty(this.ahY) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.ahY) {
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
    public void sy() {
        if (!ListUtils.isEmpty(this.ahY)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.ahY) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.agK);
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
    public void sz() {
        if (this.aij != null && this.aij.qV()) {
            this.ahG.setStyleEnabled(this.agK);
            if (this.agK) {
                this.ahW.setStyle(this.aij.qL() ? 2 : 1);
            } else {
                this.ahW.setStyle(this.aij.qL() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.aiO);
        MessageManager.getInstance().unRegisterListener(this.aiP);
        MessageManager.getInstance().unRegisterListener(this.aiQ);
        kJ();
        if (this.aiB != null) {
            this.aiB.dismiss();
        }
    }

    public void az(boolean z) {
        this.agF = z;
    }

    public void bB(int i) {
        this.agD = i;
    }

    public void c(g gVar) {
        this.aij = gVar;
        if (this.ais != null) {
            this.ais.setAlaGiftItem(gVar);
        }
        if (gVar != null && !gVar.qN()) {
            this.aiF.rW();
        }
    }

    public void rV() {
        if (this.aiF != null) {
            this.aiF.rV();
        }
    }

    public void rU() {
        if (this.aiF != null) {
            this.aiF.rU();
        }
    }

    public void aI(boolean z) {
        if (this.ahW != null) {
            this.ahW.setVisibility(z ? 0 : 4);
        }
    }
}

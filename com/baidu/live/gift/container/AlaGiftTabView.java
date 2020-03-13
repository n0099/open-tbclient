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
    public ArrayList<i> ajD;
    private ArrayList<com.baidu.live.data.d> ajE;
    private ArrayList<com.baidu.live.data.e> ajF;
    private final String ajJ;
    private boolean ajK;
    public ViewGroup ajL;
    protected ViewGroup ajM;
    protected View ajN;
    private GiftPanelNumRoundRectView ajO;
    public TextView ajP;
    protected BaseViewPager ajQ;
    protected RoundRectPageIndicator ajR;
    protected HorizontalScrollView ajS;
    protected LinearLayout ajT;
    protected View ajU;
    private CommonEmptyView ajV;
    private FrameLayout ajW;
    private FrameLayout ajX;
    private View ajY;
    private com.baidu.live.gift.container.c ajZ;
    private boolean akA;
    private int akB;
    private int akC;
    private int akD;
    private SparseBooleanArray akE;
    private Set<String> akF;
    private boolean akG;
    private int akH;
    private BdAlertDialog akI;
    private boolean akJ;
    private int akK;
    private ImageButton akL;
    private AlaComboBtnAnimView akM;
    private boolean akN;
    private TextView akO;
    private View.OnClickListener akP;
    private View.OnClickListener akQ;
    AdapterView.OnItemClickListener akR;
    Runnable akS;
    Runnable akT;
    private AlaGiftDrawPanel.a akU;
    private CustomMessageListener akV;
    private CustomMessageListener akW;
    private CustomMessageListener akX;
    private CustomMessageListener akY;
    public GiftPanelTabView aka;
    private TextView akb;
    private TextView akc;
    private TextView akd;
    public GiftPanelOperationSendView ake;
    private ImageButton akf;
    private List<View> akg;
    private AlaGiftPagerAdapter akh;
    private ArrayList<List<g>> aki;
    private c akj;
    private int akk;
    private int akl;
    private int akm;
    private boolean akn;
    private boolean ako;
    private int akp;
    private g akq;
    private int akr;
    private SparseIntArray aks;
    private SparseBooleanArray akt;
    private View.OnClickListener aku;
    private AlaLiveInputEditView akv;
    private ViewGroup akw;
    private ImageButton akx;
    private TextView aky;
    private AlaGiftDrawPanel akz;
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
        this.ajJ = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.akg = new ArrayList();
        this.akk = 0;
        this.akl = 0;
        this.mSelectedPosition = 0;
        this.akm = 0;
        this.aks = new SparseIntArray();
        this.akt = new SparseBooleanArray();
        this.isLandscape = false;
        this.akA = false;
        this.akB = -1;
        this.akC = -1;
        this.aiO = false;
        this.aiM = -1;
        this.akE = new SparseBooleanArray();
        this.akF = new HashSet();
        this.akJ = false;
        this.akN = false;
        this.aiT = false;
        this.akP = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.akM == null || !AlaGiftTabView.this.akM.ti()) {
                    if (AlaGiftTabView.this.ajZ == null) {
                        AlaGiftTabView.this.ajZ = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.akR);
                    }
                    AlaGiftTabView.this.aH(true);
                    AlaGiftTabView.this.ajZ.a(AlaGiftTabView.this.ajN, AlaGiftTabView.this.ajF, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.aH(false);
                        }
                    });
                }
            }
        };
        this.akQ = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabView.this.akx.setEnabled(false);
                AlaGiftTabView.this.akL.setEnabled(false);
                AlaGiftTabView.this.aK(false);
                AlaGiftTabView.this.akU.c(0, 0L);
            }
        };
        this.akR = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.ajZ.dismiss();
                if (AlaGiftTabView.this.ajF == null || AlaGiftTabView.this.ajF.size() <= 0) {
                    AlaGiftTabView.this.dy("1");
                } else if (i != AlaGiftTabView.this.ajF.size()) {
                    com.baidu.live.data.e eVar = (com.baidu.live.data.e) AlaGiftTabView.this.ajF.get(i);
                    if (eVar != null) {
                        int number = eVar.getNumber();
                        if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.akq.agn) != null) {
                            if (number == -1) {
                                number = aVar.agu;
                            }
                            if (number > AlaGiftTabView.this.akK) {
                                number = AlaGiftTabView.this.akK;
                            }
                        }
                        AlaGiftTabView.this.dy(String.valueOf(number));
                    }
                } else {
                    AlaGiftTabView.this.ty();
                }
            }
        };
        this.akS = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
            @Override // java.lang.Runnable
            public void run() {
                AlaGiftTabView.this.akv.getEditView().requestFocus();
                AlaGiftTabView.this.akv.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.akv.getEditView());
            }
        };
        this.akT = new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.akv.getEditView());
            }
        };
        this.akU = new AlaGiftDrawPanel.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
            @Override // com.baidu.live.gift.graffitiGift.AlaGiftDrawPanel.a
            public void c(int i, long j) {
                AlaGiftTabView.this.aky.setText(String.format(AlaGiftTabView.this.mContext.getString(a.i.ala_gift_draw_title_drawing), Long.valueOf(j)));
                if (i > 0) {
                    AlaGiftTabView.this.akx.setEnabled(true);
                    AlaGiftTabView.this.akL.setEnabled(true);
                    AlaGiftTabView.this.tJ();
                    AlaGiftTabView.this.ajN.setVisibility(4);
                    AlaGiftTabView.this.aky.setVisibility(0);
                } else {
                    AlaGiftTabView.this.tJ();
                    AlaGiftTabView.this.aky.setVisibility(8);
                    AlaGiftTabView.this.akx.setEnabled(false);
                    AlaGiftTabView.this.akL.setEnabled(false);
                }
                AlaGiftTabView.this.akr = i;
            }
        };
        this.akV = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
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
        this.akW = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.aE(true);
                if (AlaGiftTabView.this.akq != null && AlaGiftTabView.this.b(AlaGiftTabView.this.akq) && AlaGiftTabView.this.ajK) {
                    AlaGiftTabView.this.ake.setStyle(AlaGiftTabView.this.akq.rE() ? 2 : 1);
                    AlaGiftTabView.this.ajO.setStyleEnabled(true);
                }
            }
        };
        this.akX = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
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
        this.akY = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.tw();
                    AlaGiftTabView.this.ake.setStyle(AlaGiftTabView.this.akq.rE() ? 4 : 3);
                    AlaGiftTabView.this.ajO.setStyleEnabled(false);
                    AlaGiftTabView.this.akw.setVisibility(8);
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aku = onClickListener;
        this.akA = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.akp = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        if (this.isLandscape) {
            this.akH = (ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity()) - (BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds112) * 2)) - BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds16);
            this.ajQ.getLayoutParams().height = this.akH;
        } else {
            this.ajQ.getLayoutParams().height = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds192) * 2;
        }
        this.ajQ.requestLayout();
        this.aki = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.akK = 9999;
                break;
            case 1:
                this.akK = 999;
                break;
        }
        this.akv.setMaxText(String.valueOf(this.akK));
        this.akv.setHintText(String.format(Locale.getDefault(), this.mContext.getString(a.i.ala_send_gift_count_hint), Integer.valueOf(this.akK)));
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
        this.ajL = (ViewGroup) this.mRoot.findViewById(a.g.gift_list_layout);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(this.mContext.getResources().getColor(a.d.live_gift_panel_primary));
        float dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds26);
        if (this.isLandscape) {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelOffset, dimensionPixelOffset});
        } else {
            gradientDrawable.setCornerRadii(new float[]{dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        this.ajL.setBackgroundDrawable(gradientDrawable);
        this.ajL.getLayoutParams().width = realScreenHeight;
        this.akO = (TextView) this.mRoot.findViewById(a.g.gift_toast);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(BdUtilHelper.dip2px(this.mContext.getPageActivity(), 5.0f));
        gradientDrawable2.setColor(-1560281088);
        this.akO.setBackgroundDrawable(gradientDrawable2);
        if (UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity()) == 2) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akO.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.addRule(2, 0);
            layoutParams.addRule(12);
            layoutParams.addRule(5, this.ajL.getId());
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds90);
            this.akO.setLayoutParams(layoutParams);
            int dimens = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds12);
            this.akO.setPadding(dimens, dimens, dimens, dimens);
            this.akO.setBackgroundColor(-1560281088);
            this.akO.setGravity(17);
        }
        this.akO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.akq != null && AlaGiftTabView.this.akq.ago && !TextUtils.isEmpty(AlaGiftTabView.this.akq.agq)) {
                    UrlManager.getInstance().dealOneLink(AlaGiftTabView.this.mContext, new String[]{AlaGiftTabView.this.akq.agq});
                }
            }
        });
        this.akO.setVisibility(8);
        this.ajM = (ViewGroup) this.mRoot.findViewById(a.g.gift_tab_input_parent);
        this.ajN = this.mRoot.findViewById(a.g.gift_count_layout);
        this.ajN.setOnClickListener(this.akP);
        this.ajO = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.ajP = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.ajP.setText("1");
        this.ajP.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.ajU = this.mRoot.findViewById(a.g.gift_lower_layout);
        this.ajQ = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.ajQ.setOnPageChangeListener(this);
        this.ajR = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.ajT = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.ajS = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.akA) {
            this.ajS.setVisibility(8);
        }
        this.akb = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.akb.setOnClickListener(this.aku);
        this.akc = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.akc.setOnClickListener(this.aku);
        this.ake = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.akd = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.akd.setOnClickListener(this.aku);
        this.ake.setOnClickListener(this.aku);
        this.ajW = (FrameLayout) this.mRoot.findViewById(a.g.tab_container_view);
        this.ajX = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        this.ajX.getLayoutParams().width = realScreenHeight;
        this.ajV = new CommonEmptyView(this.mContext.getPageActivity());
        this.ajV.setVisibility(8);
        this.ajV.addToParent(this.ajX);
        this.aka = (GiftPanelTabView) this.mRoot.findViewById(a.g.tab);
        this.ajY = this.mRoot.findViewById(a.g.donate_layout);
        tu();
        this.akw = (ViewGroup) this.mRoot.findViewById(a.g.ala_gift_draw_layout);
        this.akw.setVisibility(8);
        this.akz = (AlaGiftDrawPanel) this.mRoot.findViewById(a.g.ala_gift_draw_panel);
        this.akz.setGiftDrawEventListener(this.akU);
        this.akz.setGiftCountRange(10, 100);
        this.akf = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_hide_btn);
        this.akf.setOnClickListener(this.aku);
        this.akx = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_clean_btn);
        this.akL = (ImageButton) this.mRoot.findViewById(a.g.ala_gift_draw_revert_btn);
        this.akL.setOnClickListener(this);
        this.akM = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.akM.setComboClickListener(this.aku);
        this.akM.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void tj() {
                AlaGiftTabView.this.aL(true);
            }
        });
        this.akx.setOnClickListener(this.akQ);
        this.akx.setEnabled(false);
        this.akL.setEnabled(false);
        this.aky = (TextView) this.mRoot.findViewById(a.g.ala_gift_draw_title);
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
        this.akG = true;
        this.akb.setVisibility(8);
        this.akc.setVisibility(8);
        this.akd.setVisibility(8);
    }

    public void aE(boolean z) {
        this.ajK = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.v.a.zl().zo() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.akd.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.akF.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.akF.add(str);
            }
        }
    }

    public void bh(int i) {
        this.akD = i;
    }

    private void tu() {
        this.akv = new AlaLiveInputEditView(this.mContext.getPageActivity());
        this.akv.setVisibility(8);
        this.akv.setEditViewConfirmCallBack(this);
        this.ajM.addView(this.akv, new RelativeLayout.LayoutParams(-1, -2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.akL && this.akz != null) {
            this.akz.uz();
        }
    }

    public void aF(boolean z) {
        this.akN = z;
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
        this.ajQ.setCurrentItem(this.akk);
        tD();
        tv();
    }

    private void bD(int i) {
        int min = Math.min(i, this.aks.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aks.get(i3);
        }
        this.akk = i2;
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
            AlaGiftTabView.this.akl = AlaGiftTabView.this.akk;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void tv() {
        if (this.akq != null && this.akq.ago && !TextUtils.isEmpty(this.akq.agp)) {
            this.akO.setText(this.akq.agp);
            this.akO.setVisibility(0);
            return;
        }
        this.akO.setVisibility(8);
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
                this.ajY.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                dy("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.akq.rU()) {
                        this.ake.setStyle(this.akq.rE() ? 4 : 3);
                        this.ajO.setStyleEnabled(false);
                        this.akw.setVisibility(8);
                        if (!TextUtils.isEmpty(this.akq.rH()) && this.mShowing) {
                            this.mContext.showToast(this.akq.rH());
                            return;
                        }
                        return;
                    }
                    tv();
                    this.ake.setEnabled(true);
                    if (this.akq.rX()) {
                        this.akw.setVisibility(8);
                        this.akz.ux();
                        if (this.akq.rT() == 6 && this.aiM < 3) {
                            i3 = 3;
                        } else if (this.akq.rT() == 7 && this.aiM < 7) {
                            i3 = 7;
                        } else if (this.akq.rT() == 8 && this.aiM < 13) {
                            i3 = 13;
                        } else if (this.akq.rT() == 9 && this.aiM < 22) {
                            i3 = 22;
                        } else if (this.akq.rT() == 10 && this.aiM < 29) {
                            i3 = 29;
                        } else if (this.akq.rT() == 11 && this.aiM < 39) {
                            i3 = 39;
                        } else if (this.akq.rT() == 12 && this.aiM < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.ake.setStyle(this.akq.rE() ? 2 : 1);
                    } else {
                        this.ake.setStyle(this.akq.rE() ? 4 : 3);
                    }
                    this.ajO.setStyleEnabled(z);
                    tL();
                    i2 = i3;
                } else {
                    this.ake.setStyle(this.akq.rE() ? 2 : 1);
                    if (this.akq.agn != null && this.akq.agn.agt != null && this.akq.agn.agt.equals("20")) {
                        this.ake.setText("使用");
                    } else {
                        this.ake.setText("赠送");
                    }
                    this.ajO.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.akq.rF()) {
                    aG(true);
                    if (this.akz != null && this.akz.getCurrentPointSize() > 0) {
                        this.aky.setVisibility(0);
                    } else {
                        this.aky.setVisibility(8);
                    }
                } else {
                    aG(false);
                    dy("1");
                }
                c(false, i2);
                return;
            }
            this.ake.setStyle(3);
            return;
        }
        this.ake.setStyle(3);
    }

    private void c(boolean z, int i) {
        g.a aVar;
        if (this.mShowing && this.akq != null) {
            if (this.mType == 0) {
                if (this.akq.rW() && !this.aiT) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.akq.rH()) && this.akq.rU() && !z) {
                    this.mContext.showToast(this.akq.rH());
                } else if (this.akq.rX() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.akq.rS()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (aVar = this.akq.agn) != null && !TextUtils.isEmpty(aVar.agw)) {
                this.mContext.showToast(aVar.agw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.v.a.zl().axD != null && com.baidu.live.v.a.zl().axD.acR != null) {
            String str = com.baidu.live.v.a.zl().axD.acR.acc;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.rT()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw() {
        if (!this.ako) {
            this.akI = new BdAlertDialog(this.mContext.getPageActivity());
            this.akI.setCancelable(false);
            this.akI.setCanceledOnTouchOutside(false);
            this.akI.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.akI.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.akD)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.akI.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.akI.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.akI.setPositiveButtonTextColor(-57754);
                this.akI.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.akI.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.ako = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.akI.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.ako = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.akI.create(this.mContext).show();
            this.ako = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(boolean z) {
        int i = 0;
        if (z && com.baidu.live.v.a.zl().awC.Zz) {
            if (this.akz.getVisibility() == 0) {
                tF();
            }
        } else {
            aK(true);
        }
        if (z && com.baidu.live.v.a.zl().awC.Zz) {
            if (Build.VERSION.SDK_INT != 26) {
                this.mContext.getPageActivity().setRequestedOrientation(1);
                this.akJ = true;
            }
            this.akw.setVisibility(0);
            tJ();
            BdResourceLoader.getInstance().loadResource(this.akq.rA(), 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.gift.container.AlaGiftTabView.22
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
                public void onLoaded(BdImage bdImage, String str, int i2) {
                    super.onLoaded((AnonymousClass22) bdImage, str, i2);
                    if (bdImage == null || bdImage.getRawBitmap() == null) {
                        if (AlaGiftTabView.this.mShowing) {
                            BdUtilHelper.showToast(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.mContext.getPageActivity().getString(a.i.ala_gift_noimage_tip));
                        }
                    } else if (str != null && str.equals(AlaGiftTabView.this.akq.rA())) {
                        AlaGiftTabView.this.akz.setGiftBitmp(bdImage.getRawBitmap());
                    }
                }
            }, null);
            this.ajN.setVisibility(4);
            this.ake.setStyle(1);
            return;
        }
        if (Build.VERSION.SDK_INT != 26 && this.akJ) {
            this.mContext.getPageActivity().setRequestedOrientation(3);
            this.akJ = false;
        }
        this.akw.setVisibility(8);
        this.akz.ux();
        View view = this.ajN;
        if (this.akq == null || !this.akq.rE()) {
            i = 4;
        }
        view.setVisibility(i);
    }

    public boolean tx() {
        return this.akv.getVisibility() == 0;
    }

    public void bE(int i) {
        if (this.akv != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.akv.getLayoutParams();
            layoutParams.topMargin = i;
            this.akv.setLayoutParams(layoutParams);
        }
    }

    public void ty() {
        this.akv.xS();
        this.akv.getEditView().setFocusable(true);
        this.akv.getEditView().setFocusableInTouchMode(true);
        this.akv.getEditView().postDelayed(this.akS, 100L);
    }

    public void tz() {
        this.akv.setVisibility(8);
        this.akv.getEditView().post(this.akT);
    }

    public AlaLiveInputEditView tA() {
        return this.akv;
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
        this.ajP.setText(str);
        this.ajP.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        aH(false);
        if (this.akq != null && this.akq.rE()) {
            this.ajN.setVisibility(0);
            this.akr = JavaTypesHelper.toInt(this.ajP.getText().toString(), 1);
            return;
        }
        this.ajN.setVisibility(4);
        this.akr = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(boolean z) {
        this.ajP.setGravity(17);
        if (z) {
            this.ajP.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.ajP.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3, boolean z2, int i) {
        if (this.ajD == null || this.ajD.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            this.ajD = arrayList;
            this.ajE = arrayList2;
            this.ajF = arrayList3;
            this.akn = false;
            if (this.ajE == null || this.ajE.isEmpty()) {
                this.ajS.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void p(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.akg != null) {
            for (View view : this.akg) {
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
        if (this.ajD == null || this.ajD.size() <= 0 || !z2) {
            kY();
            if (this.ajR != null) {
                this.ajR.setVisibility(4);
            }
            this.ajY.setVisibility(4);
            this.ajV.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.ajV.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.ajV.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.ajV.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.v.a.zl().awC.aaV && i != 0) {
                string = string + "(" + i + ")";
            }
            this.ajV.setTitle(string);
            this.ajV.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.akj != null) {
                        AlaGiftTabView.this.akj.tM();
                    }
                }
            });
            this.ajV.setVisibility(0);
            return;
        }
        this.ajV.setVisibility(8);
        this.ajU.setVisibility(0);
        if (z) {
            h(this.ajE);
        }
        ap apVar = com.baidu.live.v.a.zl().axD;
        if (this.mType == 0 && apVar != null && apVar.acV != null && apVar.acV.aeC && !this.akN && this.ajD.get(0) != null && this.ajD.get(0).rY() != null) {
            List<g> rY = this.ajD.get(0).rY();
            if (!rY.isEmpty()) {
                g gVar = new g();
                gVar.ax(true);
                gVar.setGiftName("发红包");
                rY.add(1, gVar);
            }
        }
        c(this.ajD, z);
        dy("1");
    }

    private void kY() {
        this.akk = 0;
        this.akl = 0;
        this.mSelectedPosition = 0;
        this.akm = 0;
        if (this.aks != null) {
            this.aks.clear();
        }
        if (this.akg != null) {
            this.akg.clear();
        }
        if (this.ajQ != null) {
            this.ajQ.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (!b(this.akq) || this.ajK) {
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
        if (ListUtils.getCount(this.ajE) != 0 && ListUtils.getCount(this.ajD) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.d> it = this.ajE.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.d next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.qq()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.ajD.iterator();
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
                Iterator<i> it3 = this.ajD.iterator();
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
                this.ajE.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.ajD.removeAll(arrayList2);
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
            this.aks.clear();
            this.akg.clear();
            this.ajQ.setAdapter(null);
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
            this.aki.clear();
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 < arrayList.size()) {
                    if (z2) {
                        this.akg.add(bF(i7));
                        this.aks.append(i7, 1);
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
                            if (this.akt.get(i7)) {
                                this.akg.add(aI(true));
                            } else {
                                this.akg.add(b(arrayList3, -1, i7));
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
                                this.aki.add(arrayList2);
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
                                        if (gVar == null || gVar.rx() == null || !gVar.rx().equals(String.valueOf(this.akC))) {
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
                                    this.akg.add(b(arrayList2, i3, i7));
                                    this.akw.removeCallbacks(null);
                                    this.akw.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            boolean rF = AlaGiftTabView.this.akq.rF();
                                            AlaGiftTabView.this.aG(rF);
                                            if (!rF) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.akq);
                                                if (!c2) {
                                                    AlaGiftTabView.this.ake.setStyle(AlaGiftTabView.this.akq.rE() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.ake.setStyle(AlaGiftTabView.this.akq.rE() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.ajO.setStyleEnabled(c2);
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
                                            if (gVar2 == null || !gVar2.rx().equals(String.valueOf(this.akC))) {
                                                i12 = i2 + 1;
                                            } else {
                                                this.mSelectedPosition = i2;
                                                this.akq = gVar2;
                                                d(gVar2);
                                                break;
                                            }
                                        }
                                        this.akg.add(b(arrayList2, i2, i7));
                                    }
                                    i2 = -1;
                                    this.akg.add(b(arrayList2, i2, i7));
                                }
                            }
                            i8 = ceil;
                        }
                        this.aks.append(i7, i8);
                    }
                    i6 = i7 + 1;
                } else {
                    this.akh = new AlaGiftPagerAdapter(this.akg);
                    this.ajQ.setAdapter(this.akh);
                    tC();
                    this.ajQ.setCurrentItem(this.akk);
                    tD();
                    return;
                }
            }
        }
    }

    private void tC() {
        int i = 0;
        if (this.akC > 0 && !ListUtils.isEmpty(this.aki)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aki.size() && !z; i2++) {
                Iterator<g> it = this.aki.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.rx() != null && next.rx().equals(String.valueOf(this.akC))) {
                        this.akk = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.Yv == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.akl = this.akk;
            this.aki.clear();
        } else if (this.akB > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.ajE.size()) {
                    break;
                }
                com.baidu.live.data.d dVar = this.ajE.get(i3);
                if (dVar == null || this.akB != dVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    bD(i3);
                    break;
                }
            }
            this.akl = this.akk;
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
                if (AlaGiftTabView.this.akj != null) {
                    AlaGiftTabView.this.akj.tM();
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
            aVar.bx(this.akH / 3);
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
            if (!this.akA) {
                this.ajS.setVisibility(0);
            }
            this.ajT.removeAllViews();
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
                        layoutParams.leftMargin = this.akp;
                    }
                    if (this.ajD.size() > i && this.ajD.get(i) != null) {
                        for (g gVar : this.ajD.get(i).rY()) {
                            if (gVar != null && gVar.rD() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.ajT.addView(viewGroup, layoutParams);
                }
            }
            bG(this.akm);
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
        int childCount = this.ajT.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.akm != i || !this.akn) && this.ajE.size() > i && this.ajE.get(i) != null) {
                int min = Math.min(i, this.aks.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.aks.get(i3);
                }
                if (this.akg.size() > i2 && this.ajD.size() > i && (this.akg.get(i2) instanceof ViewGroup)) {
                    this.akl = i2;
                    i iVar = this.ajD.get(i);
                    if (iVar != null && iVar.rY() != null && !iVar.rY().isEmpty()) {
                        d(this.ajD.get(i).rY().get(0));
                        ViewGroup viewGroup = (ViewGroup) this.akg.get(i2);
                        int i4 = 0;
                        while (true) {
                            if (i4 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i4) instanceof GridView)) {
                                i4++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i4)).getAdapter();
                                if (this.akq != null && aVar != null) {
                                    a(aVar, 0);
                                    if (this.mShowing) {
                                        this.akn = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.ajE.size() > i && this.ajE.get(i) != null) {
                int categoryId = this.ajE.get(i).getCategoryId();
                if (!this.akE.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.akE.put(categoryId, true);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewGroup viewGroup2 = (ViewGroup) this.ajT.getChildAt(i5);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.ajD.get(i5);
                if (iVar2.rZ()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.ajJ, "");
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
                                SharedPrefHelper.getInstance().putString(this.ajJ, jSONArray.toString());
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
                    this.akm = i;
                    this.ajS.scrollTo(viewGroup2.getLeft(), 0);
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
        if (this.akb != null) {
            this.akb.setVisibility(z ? this.akG ? 8 : 0 : 8);
        }
        if (this.akc != null) {
            TextView textView = this.akc;
            if (!z && !this.akG) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void bH(int i) {
        int childCount = this.ajT.getChildCount();
        if (i >= 0 && i < childCount && this.ajD != null && this.ajD.size() > i && this.ajD.get(i) != null) {
            this.akt.get(i);
        }
    }

    public void t(int i, int i2) {
        this.akB = i;
        this.akC = i2;
    }

    public void z(long j) {
        if (this.akb != null) {
            if (j >= 100 && (this.aiO || com.baidu.live.v.a.zl().awC.aaq)) {
                this.akb.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.akb.setText(String.valueOf(j));
        }
    }

    public void A(long j) {
        if (this.akc != null) {
            this.akc.setText(String.valueOf(j));
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
        this.akk = i;
        tD();
        tv();
        if (i >= 0 && i < this.akg.size() && (this.akg.get(i) instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.akg.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.akl) {
                            aVar.bw(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.akl) {
                            aVar.bw(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.ajY.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void tD() {
        int i = 0;
        for (int i2 = 0; i2 < this.aks.size(); i2++) {
            for (int i3 = 0; i3 < this.aks.get(i2); i3++) {
                if (i + i3 == this.akk) {
                    if (this.aks.get(i2) <= 1) {
                        this.ajR.setVisibility(4);
                    } else {
                        this.ajR.setVisibility(0);
                    }
                    this.ajR.setCount(this.aks.get(i2));
                    this.ajR.onPageSelected(i3);
                    bG(i2);
                    return;
                }
            }
            i += this.aks.get(i2);
        }
    }

    public g tE() {
        return this.akq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(boolean z) {
        if (this.akz != null) {
            this.akz.aK(z);
        }
    }

    private void tF() {
        if (this.akz != null) {
            this.akz.tF();
            this.akz.uy();
        }
    }

    public l tG() {
        l lVar = new l();
        lVar.ahq = BdUtilHelper.dip2px(this.mContext.getPageActivity(), 32.0f);
        lVar.ahr.addAll(this.akz.getPoints());
        lVar.aho = this.akz.getMeasuredHeight();
        lVar.ahn = this.akz.getMeasuredWidth();
        Rect rect = new Rect();
        this.akz.getGlobalVisibleRect(rect);
        lVar.ahl = rect.left;
        lVar.ahm = rect.top;
        lVar.ahs = lVar.ahr.size();
        lVar.ahu = this.akz.getGraffitiPointDesDatas();
        lVar.aht = new Rect(0, 0, rect.width(), rect.height());
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.mContext.getPageActivity());
        lVar.ahj = screenDimensions[0];
        lVar.ahk = screenDimensions[1];
        return lVar;
    }

    public int tH() {
        return this.akr;
    }

    public void a(DialogInterface.OnCancelListener onCancelListener) {
    }

    public void tI() {
    }

    public void a(c cVar) {
        this.akj = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ() {
        if (this.akz != null) {
            if (this.akz.getCurrentPointSize() > 0) {
                this.akz.setTipImageVisibility(8);
            } else {
                this.akz.setTipImageVisibility(0);
            }
        }
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.akV);
        MessageManager.getInstance().registerListener(this.akW);
        MessageManager.getInstance().registerListener(this.akX);
        MessageManager.getInstance().registerListener(this.akY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.akg) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.akg) {
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
        if (!ListUtils.isEmpty(this.akg)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.akg) {
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
        if (this.akq != null && this.akq.rW()) {
            this.ajO.setStyleEnabled(this.aiT);
            if (this.aiT) {
                this.ake.setStyle(this.akq.rE() ? 2 : 1);
            } else {
                this.ake.setStyle(this.akq.rE() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.akV);
        MessageManager.getInstance().unRegisterListener(this.akW);
        MessageManager.getInstance().unRegisterListener(this.akX);
        MessageManager.getInstance().unRegisterListener(this.akY);
        kY();
        if (this.akI != null) {
            this.akI.dismiss();
        }
    }

    public void aC(boolean z) {
        this.aiO = z;
    }

    public void bI(int i) {
        this.aiM = i;
    }

    public void d(g gVar) {
        this.akq = gVar;
        if (this.akz != null) {
            this.akz.setAlaGiftItem(gVar);
        }
        if (gVar != null && !gVar.rG()) {
            this.akM.th();
        }
    }

    public void tg() {
        if (this.akM != null) {
            this.akM.tg();
        }
    }

    public void tf() {
        if (this.akM != null) {
            this.akM.tf();
        }
    }

    public void aL(boolean z) {
        if (this.ake != null) {
            this.ake.setVisibility(z ? 0 : 4);
        }
    }
}

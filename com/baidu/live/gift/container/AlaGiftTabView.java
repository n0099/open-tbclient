package com.baidu.live.gift.container;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.b.t;
import com.baidu.live.data.bn;
import com.baidu.live.data.j;
import com.baidu.live.data.w;
import com.baidu.live.data.y;
import com.baidu.live.gift.container.AlaComboBtnAnimView;
import com.baidu.live.gift.container.a;
import com.baidu.live.gift.container.a.a;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.widget.panel.GiftPanelNumRoundRectView;
import com.baidu.live.gift.widget.panel.GiftPanelOperationSendView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.BaseViewPager;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.GradientTextView;
import com.baidu.live.view.RoundRectPageIndicator;
import com.baidu.live.view.input.b;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, b.a {
    private int aIJ;
    private int aWo;
    private boolean aWq;
    private boolean aWw;
    public ArrayList<h> aXD;
    private ArrayList<com.baidu.live.data.h> aXE;
    private ArrayList<j> aXF;
    private final String aXJ;
    private boolean aXK;
    private View aXL;
    private GiftPanelNumRoundRectView aXM;
    public TextView aXN;
    private BaseViewPager aXO;
    private RoundRectPageIndicator aXP;
    private HorizontalScrollView aXQ;
    private LinearLayout aXR;
    private CommonEmptyView aXS;
    private View aXT;
    private com.baidu.live.gift.container.c aXU;
    private TextView aXV;
    private TextView aXW;
    private TextView aXX;
    public GiftPanelOperationSendView aXY;
    private List<View> aXZ;
    private com.baidu.live.gift.container.d aYA;
    private boolean aYB;
    private boolean aYC;
    private boolean aYD;
    private AnimatorSet aYE;
    private View.OnClickListener aYG;
    AdapterView.OnItemClickListener aYH;
    private CustomMessageListener aYI;
    private CustomMessageListener aYJ;
    private CustomMessageListener aYK;
    private CustomMessageListener aYL;
    private ArrayList<List<g>> aYa;
    private e aYb;
    private int aYc;
    private int aYd;
    private int aYe;
    private boolean aYf;
    private boolean aYg;
    private int aYh;
    private g aYi;
    private int aYj;
    private SparseIntArray aYk;
    private SparseBooleanArray aYl;
    private View.OnClickListener aYm;
    private boolean aYn;
    private int aYo;
    private int aYp;
    private int aYq;
    private SparseBooleanArray aYr;
    private Set<String> aYs;
    private boolean aYt;
    private BdAlertDialog aYu;
    private int aYv;
    private a aYw;
    private int aYx;
    private AlaComboBtnAnimView aYy;
    private TbImageView aYz;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private ViewGroup mRoot;
    private int mSelectedPosition;
    private boolean mShowing;
    private int mType;
    private String otherParams;
    private String roomId;
    public static int page = 0;
    public static ArrayList<String> aYF = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface a {
        void a(g gVar);

        void as(String str, String str2);

        void c(boolean z, int i);

        void f(boolean z, String str);

        void q(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void HO();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aXJ = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aXZ = new ArrayList();
        this.aYc = 0;
        this.aYd = 0;
        this.mSelectedPosition = 0;
        this.aYe = 0;
        this.aYk = new SparseIntArray();
        this.aYl = new SparseBooleanArray();
        this.isLandscape = false;
        this.aYn = false;
        this.aYo = -1;
        this.aYp = -1;
        this.aWq = false;
        this.aWo = -1;
        this.aYr = new SparseBooleanArray();
        this.aYs = new HashSet();
        this.aYB = false;
        this.aWw = false;
        this.aYC = false;
        this.aYD = false;
        this.aYG = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aYy == null || !AlaGiftTabView.this.aYy.Hh()) {
                    if (AlaGiftTabView.this.aXU == null) {
                        AlaGiftTabView.this.aXU = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aYH);
                    }
                    AlaGiftTabView.this.bK(true);
                    AlaGiftTabView.this.aXU.a(AlaGiftTabView.this.aXL, AlaGiftTabView.this.aXF, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bK(false);
                        }
                    });
                }
            }
        };
        this.aYH = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.aXU.dismiss();
                if (AlaGiftTabView.this.aXF != null && AlaGiftTabView.this.aXF.size() > 0) {
                    if (i != AlaGiftTabView.this.aXF.size()) {
                        j jVar = (j) AlaGiftTabView.this.aXF.get(i);
                        if (jVar != null) {
                            int number = jVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (bVar = AlaGiftTabView.this.aYi.aSX) != null) {
                                if (number == -1) {
                                    number = bVar.aTk;
                                }
                                if (number > AlaGiftTabView.this.aYv) {
                                    number = AlaGiftTabView.this.aYv;
                                }
                            }
                            AlaGiftTabView.this.hk(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.HE();
                    return;
                }
                AlaGiftTabView.this.hk("1");
            }
        };
        this.aYI = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.aRp == 1 || cVar.aRp == 2 || cVar.aRp == 5 || cVar.aRp == 6) && cVar.aRq != null) {
                        AlaGiftTabView.this.au(cVar.aRq.getId(), cVar.aRq.getUrl());
                    }
                }
            }
        };
        this.aYJ = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bF(true);
                if (AlaGiftTabView.this.aYi != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aYi) && AlaGiftTabView.this.aXK) {
                    AlaGiftTabView.this.aXY.setStyle(AlaGiftTabView.this.aYi.Fq() ? 2 : 1);
                    AlaGiftTabView.this.aXM.setStyleEnabled(true);
                }
            }
        };
        this.aYK = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                w wVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && (wVar = (w) customResponsedMessage.getData()) != null && wVar.aHG != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = wVar.aHG.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aWw != z2) {
                        AlaGiftTabView.this.aWw = z2;
                        AlaGiftTabView.this.HN();
                        AlaGiftTabView.this.HM();
                    }
                }
            }
        };
        this.aYL = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.HD();
                    AlaGiftTabView.this.aXY.setStyle(AlaGiftTabView.this.aYi.Fq() ? 4 : 3);
                    AlaGiftTabView.this.aXM.setStyleEnabled(false);
                    if (AlaGiftTabView.this.aYw != null) {
                        AlaGiftTabView.this.aYw.f(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aYm = onClickListener;
        this.aYn = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aYh = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.d.sdk_ds36);
        this.aYa = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aYv = 9999;
                return;
            case 1:
                this.aYv = 999;
                return;
            default:
                return;
        }
    }

    public void eg(int i) {
        int childCount;
        this.aYx = i;
        if (this.aXR != null && (childCount = this.aXR.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aYe) {
                    ((GradientTextView) ((ViewGroup) this.aXR.getChildAt(i2)).findViewById(a.f.text_view)).setGradientTextColor(this.aYx, this.aYx);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aYw = aVar;
    }

    public void at(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bE(boolean z) {
        this.mShowing = z;
    }

    public void onVisibilityChanged(boolean z) {
        bE(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        this.aXL = this.mRoot.findViewById(a.f.gift_count_layout);
        this.aXL.setOnClickListener(this.aYG);
        this.aXM = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.f.gift_count_round);
        this.aXN = (TextView) this.mRoot.findViewById(a.f.gift_count_input);
        this.aXN.setText("1");
        this.aXN.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.aXO = (BaseViewPager) this.mRoot.findViewById(a.f.gift_viewpager);
        this.aXO.setOnPageChangeListener(this);
        this.aXP = (RoundRectPageIndicator) this.mRoot.findViewById(a.f.gift_tab_indicator);
        this.aXR = (LinearLayout) this.mRoot.findViewById(a.f.gift_tab_layout);
        this.aXQ = (HorizontalScrollView) this.mRoot.findViewById(a.f.gift_tab_scrollview);
        if (this.aYn) {
            this.aXQ.setVisibility(8);
        }
        this.aXV = (TextView) this.mRoot.findViewById(a.f.current_money);
        this.aXV.setOnClickListener(this.aYm);
        this.aXW = (TextView) this.mRoot.findViewById(a.f.current_flower);
        this.aXW.setOnClickListener(this.aYm);
        this.aXY = (GiftPanelOperationSendView) this.mRoot.findViewById(a.f.donate);
        this.aXX = (TextView) this.mRoot.findViewById(a.f.current_recharge);
        this.aXX.setOnClickListener(this.aYm);
        this.aXY.setOnClickListener(this.aYm);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.f.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.aXS = new CommonEmptyView(this.mContext.getPageActivity());
        this.aXS.setVisibility(8);
        this.aXS.addToParent(frameLayout);
        this.aXT = this.mRoot.findViewById(a.f.donate_layout);
        this.aYy = (AlaComboBtnAnimView) this.mRoot.findViewById(a.f.combo_layout);
        this.aYy.setComboClickListener(this.aYm);
        this.aYy.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void Hi() {
                AlaGiftTabView.this.bN(true);
            }
        });
        this.aYz = (TbImageView) this.mRoot.findViewById(a.f.iv_official);
    }

    public void HB() {
        this.aYt = true;
        this.aXV.setVisibility(8);
        this.aXW.setVisibility(8);
        this.aXX.setVisibility(8);
    }

    public void bF(boolean z) {
        this.aXK = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.aa.a.Ph().Pl() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aXX.setText(this.mContext.getPageActivity().getString(a.h.first_recharge_text));
            if (!this.aYs.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aYs.add(str);
            }
        }
    }

    public void be(boolean z) {
    }

    public void dC(int i) {
        this.aYq = i;
    }

    public void bG(boolean z) {
        this.aYC = z;
        if (!z && this.aYE != null) {
            this.aYE.cancel();
        }
        if (z && !ListUtils.isEmpty(this.aXE)) {
            HH();
            this.aYD = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y yVar) {
        if (yVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_pop_show"));
            if (this.aYA == null) {
                this.aYA = new com.baidu.live.gift.container.d(this.mContext);
            }
            this.aYA.n(yVar.dialogTitle, yVar.aIs + yVar.aIt, yVar.aIt);
        }
    }

    private void Q(View view) {
        if (this.aYA == null) {
            this.aYA = new com.baidu.live.gift.container.d(this.mContext);
        }
        this.aYA.O(view);
    }

    public void bH(boolean z) {
        this.aYB = z;
    }

    public void eh(int i) {
        this.aIJ = i;
    }

    public void bg(boolean z) {
        this.aWw = z;
    }

    public void bI(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.aXO.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24);
                this.aXO.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        private int mPosition;

        public d(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaGiftTabView.this.ei(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei(int i) {
        if (this.aYw != null) {
            this.aYw.c(false, this.aYv);
        }
        ej(i);
        this.aXO.setCurrentItem(this.aYc);
        HI();
        HC();
    }

    private void ej(int i) {
        int min = Math.min(i, this.aYk.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aYk.get(i3);
        }
        this.aYc = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            g item = ((com.baidu.live.gift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.isRed()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.aYd = AlaGiftTabView.this.aYc;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        private c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            g item = ((com.baidu.live.gift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.aTb != null && item.aTb.enabled && !TextUtils.isEmpty(item.aTb.detailUrl) && AlaGiftTabView.this.aYw != null) {
                AlaGiftTabView.this.aYw.q(item.aTb.aTh, item.aTb.detailUrl);
            }
            return false;
        }
    }

    private void HC() {
        if (this.mShowing && this.aYw != null) {
            if (this.aYi != null && this.aYi.aSY) {
                this.aYw.as(this.aYi.aSZ, this.aYi.aTa);
            } else {
                this.aYw.as(null, null);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.aYw != null) {
            this.aYw.c(false, this.aYv);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.dZ(i);
                aVar.notifyDataSetChanged();
                this.aXT.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                hk("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aYi.FH()) {
                        this.aXY.setStyle(this.aYi.Fq() ? 4 : 3);
                        this.aXM.setStyleEnabled(false);
                        if (this.aYw != null) {
                            this.aYw.f(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aYi.Ft()) && this.mShowing) {
                            this.mContext.showToast(this.aYi.Ft());
                            return;
                        }
                        return;
                    }
                    HC();
                    this.aXY.setEnabled(true);
                    if (this.aYi.FK()) {
                        if (this.aYw != null) {
                            this.aYw.f(false, null);
                        }
                        if (this.aYi.FG() == 6 && this.aWo < 3) {
                            i3 = 3;
                        } else if (this.aYi.FG() == 7 && this.aWo < 7) {
                            i3 = 7;
                        } else if (this.aYi.FG() == 8 && this.aWo < 13) {
                            i3 = 13;
                        } else if (this.aYi.FG() == 9 && this.aWo < 22) {
                            i3 = 22;
                        } else if (this.aYi.FG() == 10 && this.aWo < 29) {
                            i3 = 29;
                        } else if (this.aYi.FG() == 11 && this.aWo < 39) {
                            i3 = 39;
                        } else if (this.aYi.FG() == 12 && this.aWo < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.aXY.setStyle(this.aYi.Fq() ? 2 : 1);
                    } else {
                        this.aXY.setStyle(this.aYi.Fq() ? 4 : 3);
                    }
                    this.aXM.setStyleEnabled(z);
                    HN();
                    i2 = i3;
                } else {
                    this.aXY.setStyle(this.aYi.Fq() ? 2 : 1);
                    if (this.aYi.aSX != null && this.aYi.aSX.aTj != null && this.aYi.aSX.aTj.equals("20")) {
                        if (this.aYi.aSX.aTn != null && this.aYi.aSX.aTn.key == 11) {
                            this.aXY.setText("激活");
                        } else {
                            this.aXY.setText("使用");
                        }
                    } else {
                        this.aXY.setText("赠送");
                    }
                    this.aXM.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aYi.Fr()) {
                    bJ(true);
                } else {
                    bJ(false);
                    hk("1");
                }
                d(false, i2);
                return;
            }
            this.aXY.setStyle(3);
            return;
        }
        this.aXY.setStyle(3);
    }

    private void d(boolean z, int i) {
        if (this.mShowing && this.aYi != null) {
            if (this.mType == 0) {
                if (this.aYi.FJ() && !this.aWw) {
                    this.mContext.showToast(a.h.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aYi.Ft()) && this.aYi.FH() && !z) {
                    this.mContext.showToast(this.aYi.Ft());
                } else if (this.aYi.FK() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.h.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aYi.FF()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.h.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1) {
                g.b bVar = this.aYi.aSX;
                if (bVar != null && !TextUtils.isEmpty(bVar.aTm)) {
                    this.mContext.showToast(bVar.aTm);
                } else if (!TextUtils.isEmpty(this.aYi.Ft())) {
                    BdUtilHelper.showToast(this.mContext.getPageActivity(), this.aYi.Ft());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.aa.a.Ph().bsh != null && com.baidu.live.aa.a.Ph().bsh.aNL != null) {
            String str = com.baidu.live.aa.a.Ph().bsh.aNL.aNd;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.FG()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD() {
        if (!this.aYg) {
            this.aYu = new BdAlertDialog(this.mContext.getPageActivity());
            this.aYu.setCancelable(false);
            this.aYu.setCanceledOnTouchOutside(false);
            this.aYu.setTitle(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_title));
            this.aYu.setMessage(String.format(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_content), Integer.valueOf(this.aYq)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aYu.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.aYu.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aYu.setPositiveButtonTextColor(-57754);
                this.aYu.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aYu.setPositiveButton(this.mContext.getPageActivity().getString(a.h.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aYg = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aYu.setNegativeButton(this.mContext.getPageActivity().getString(a.h.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aYg = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aYu.create(this.mContext).show();
            this.aYg = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJ(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.aa.a.Ph().bms.aJX;
        if (z2) {
            this.aXL.setVisibility(4);
            this.aXY.setStyle(1);
        } else {
            View view = this.aXL;
            if (this.aYi == null || !this.aYi.Fq()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.aYw != null) {
            this.aYw.f(z2, this.aYi != null ? this.aYi.getThumbnail_url() : null);
        }
    }

    public void HE() {
        if (this.aYw != null) {
            this.aYw.c(true, this.aYv);
        }
    }

    @Override // com.baidu.live.view.input.b.a
    public void hh(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        hk(str);
    }

    public void hk(String str) {
        this.aXN.setText(str);
        this.aXN.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.d.sdk_fontsize20 : a.d.sdk_fontsize24));
        bK(false);
        if (this.aYi != null && this.aYi.Fq()) {
            this.aXL.setVisibility(0);
            this.aYj = JavaTypesHelper.toInt(this.aXN.getText().toString(), 1);
            return;
        }
        this.aXL.setVisibility(4);
        this.aYj = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(boolean z) {
        this.aXN.setGravity(17);
        if (z) {
            this.aXN.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aXN.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, boolean z2, int i) {
        if (this.aXD == null || this.aXD.isEmpty()) {
            if (this.aXD == null) {
                this.aXD = new ArrayList<>();
            }
            this.aXD.clear();
            if (arrayList != null) {
                this.aXD.addAll(arrayList);
            }
            this.aXE = arrayList2;
            this.aXF = arrayList3;
            this.aYf = false;
            if (this.aXE == null || this.aXE.isEmpty()) {
                this.aXQ.setVisibility(8);
            }
            a(z, z2, i);
            onPageSelected(this.aXO.getCurrentItem());
        }
    }

    public void A(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aXZ != null) {
            for (View view : this.aXZ) {
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
                                ((com.baidu.live.gift.container.a) ((GridView) childAt).getAdapter()).A(str, i);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(boolean z, boolean z2, int i) {
        String string;
        boolean z3;
        HF();
        if (this.aXD == null || this.aXD.size() <= 0 || !z2) {
            rE();
            if (this.aXP != null) {
                this.aXP.setVisibility(4);
            }
            this.aXT.setVisibility(4);
            this.aXS.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                this.aXS.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aXS.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_no);
                this.aXS.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.aa.a.Ph().bms.aLB && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aXS.setTitle(string);
            this.aXS.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aYb != null) {
                        AlaGiftTabView.this.aYb.HO();
                    }
                }
            });
            this.aXS.setVisibility(0);
            return;
        }
        this.aXS.setVisibility(8);
        if (z) {
            m(this.aXE);
        }
        bn bnVar = com.baidu.live.aa.a.Ph().bsh;
        if (this.mType == 0 && bnVar != null && bnVar.aNP != null && bnVar.aNP.aQi && !this.aYB && this.aXD.get(0) != null && this.aXD.get(0).FL() != null) {
            List<g> FL = this.aXD.get(0).FL();
            if (FL.size() <= 1 || FL.get(1) == null) {
                z3 = true;
            } else {
                z3 = !FL.get(1).isRed();
            }
            if (!FL.isEmpty() && z3) {
                g gVar = new g();
                gVar.bs(true);
                gVar.setGiftName("发红包");
                FL.add(1, gVar);
            }
        }
        c(this.aXD, z);
        hk("1");
    }

    private void rE() {
        this.aYc = 0;
        this.aYd = 0;
        this.mSelectedPosition = 0;
        this.aYe = 0;
        if (this.aYk != null) {
            this.aYk.clear();
        }
        if (this.aXZ != null) {
            this.aXZ.clear();
        }
        if (this.aXO != null) {
            this.aXO.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.FK()) {
            if (gVar.FG() == 6 && this.aWo < 3) {
                return false;
            }
            if (gVar.FG() == 7 && this.aWo < 7) {
                return false;
            }
            if (gVar.FG() == 8 && this.aWo < 13) {
                return false;
            }
            if (gVar.FG() == 9 && this.aWo < 22) {
                return false;
            }
            if (gVar.FG() == 10 && this.aWo < 29) {
                return false;
            }
            if (gVar.FG() == 11 && this.aWo < 39) {
                return false;
            }
            if (gVar.FG() == 12 && this.aWo < 47) {
                return false;
            }
        }
        if (gVar.FJ()) {
            return this.aWw;
        }
        return true;
    }

    public void b(final y yVar) {
        if (yVar == null || TextUtils.isEmpty(yVar.iconUrl)) {
            this.aYz.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_show"));
            this.aYz.setVisibility(0);
            this.aYz.startLoad(yVar.iconUrl, 10, false);
            this.aYz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_clk"));
                    AlaGiftTabView.this.a(yVar);
                }
            });
            String str = "key_live_official_tip" + currentAccount;
            if (com.baidu.live.d.Aq().getInt(str, 0) == 0 && this.aYC) {
                Q(this.aYz);
                com.baidu.live.d.Aq().putInt(str, 1);
            }
        }
    }

    private void HF() {
        if (ListUtils.getCount(this.aXE) != 0 && ListUtils.getCount(this.aXD) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.h> it = this.aXE.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.h next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.Dx()) == 0))) {
                    arrayList.add(next);
                    Iterator<h> it2 = this.aXD.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        h next2 = it2.next();
                        if (next2 != null && next2.getCategoryId() == next.getCategoryId()) {
                            arrayList2.add(next2);
                            break;
                        }
                    }
                }
            }
            if (this.isLandscape) {
                Iterator<h> it3 = this.aXD.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().FL().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.Fr()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aXE.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aXD.removeAll(arrayList2);
            }
        }
    }

    private void c(ArrayList<h> arrayList, boolean z) {
        boolean z2;
        int i;
        ArrayList arrayList2;
        int i2;
        boolean z3;
        g gVar;
        boolean z4;
        int i3;
        List<g> FL;
        if (arrayList != null) {
            this.aYk.clear();
            this.aXZ.clear();
            this.aXO.setAdapter(null);
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
                    h hVar = arrayList.get(i5);
                    if (hVar == null || (FL = hVar.FL()) == null || FL.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aYa.clear();
            int i6 = 0;
            boolean z5 = false;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aXZ.add(ek(i7));
                    this.aYk.append(i7, 1);
                } else {
                    h hVar2 = arrayList.get(i7);
                    hVar2.getCategoryId();
                    List<g> FL2 = hVar2.FL();
                    if (FL2 == null) {
                        i = 0;
                    } else {
                        i = FL2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aYl.get(i7)) {
                            this.aXZ.add(bL(true));
                        } else {
                            this.aXZ.add(b(arrayList3, -1, i7));
                        }
                    } else if (FL2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        int i10 = 0;
                        boolean z6 = z5;
                        while (i10 < ceil) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(FL2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(FL2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(FL2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aYa.add(arrayList2);
                            if (i7 == 0 && i10 == 0 && z) {
                                if (!z6) {
                                    int i11 = 0;
                                    while (true) {
                                        int i12 = i11;
                                        if (i12 >= arrayList2.size()) {
                                            break;
                                        }
                                        gVar = arrayList2.get(i12);
                                        if (gVar == null || gVar.Fk() == null || !gVar.Fk().equals(String.valueOf(this.aYp))) {
                                            i11 = i12 + 1;
                                        } else {
                                            this.mSelectedPosition = i12;
                                            i3 = i12;
                                            z4 = true;
                                            break;
                                        }
                                    }
                                    if (gVar == null && arrayList2.size() > 0) {
                                        arrayList2.get(0);
                                    }
                                    this.aXZ.add(b(arrayList2, i3, i7));
                                    this.aXY.removeCallbacks(null);
                                    this.aXY.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.22
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (AlaGiftTabView.this.aYi != null) {
                                                boolean Fr = AlaGiftTabView.this.aYi.Fr();
                                                AlaGiftTabView.this.bJ(Fr);
                                                if (!Fr) {
                                                    boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aYi);
                                                    if (!c2) {
                                                        AlaGiftTabView.this.aXY.setStyle(AlaGiftTabView.this.aYi.Fq() ? 4 : 3);
                                                    } else {
                                                        AlaGiftTabView.this.aXY.setStyle(AlaGiftTabView.this.aYi.Fq() ? 2 : 1);
                                                    }
                                                    AlaGiftTabView.this.aXM.setStyleEnabled(c2);
                                                }
                                            }
                                        }
                                    }, 100L);
                                    z3 = z4;
                                }
                                gVar = null;
                                z4 = z6;
                                i3 = 0;
                                if (gVar == null) {
                                    arrayList2.get(0);
                                }
                                this.aXZ.add(b(arrayList2, i3, i7));
                                this.aXY.removeCallbacks(null);
                                this.aXY.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.22
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aYi != null) {
                                            boolean Fr = AlaGiftTabView.this.aYi.Fr();
                                            AlaGiftTabView.this.bJ(Fr);
                                            if (!Fr) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aYi);
                                                if (!c2) {
                                                    AlaGiftTabView.this.aXY.setStyle(AlaGiftTabView.this.aYi.Fq() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.aXY.setStyle(AlaGiftTabView.this.aYi.Fq() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.aXM.setStyleEnabled(c2);
                                            }
                                        }
                                    }
                                }, 100L);
                                z3 = z4;
                            } else {
                                if (!ListUtils.isEmpty(arrayList2) && !z6) {
                                    int i13 = 0;
                                    while (true) {
                                        i2 = i13;
                                        if (i2 >= arrayList2.size()) {
                                            break;
                                        }
                                        g gVar2 = arrayList2.get(i2);
                                        if (gVar2 == null || !gVar2.Fk().equals(String.valueOf(this.aYp))) {
                                            i13 = i2 + 1;
                                        } else {
                                            z3 = true;
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                }
                                i2 = -1;
                                z3 = z6;
                                this.aXZ.add(b(arrayList2, i2, i7));
                            }
                            i10++;
                            z6 = z3;
                        }
                        i8 = ceil;
                        z5 = z6;
                    }
                    this.aYk.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aXO.setAdapter(new AlaGiftPagerAdapter(this.aXZ));
            HG();
            this.aXO.setCurrentItem(this.aYc);
            HI();
            if (z && !this.aYD && this.aYC) {
                this.aYD = true;
                HH();
            }
        }
    }

    private void HG() {
        int i = 0;
        if (this.aYp > 0 && !ListUtils.isEmpty(this.aYa)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aYa.size() && !z; i2++) {
                Iterator<g> it = this.aYa.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.Fk() != null && next.Fk().equals(String.valueOf(this.aYp))) {
                        this.aYc = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aIJ == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_not_find_gift_toast);
            }
            this.aYd = this.aYc;
            this.aYa.clear();
        } else if (this.aYo > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aXE.size()) {
                    break;
                }
                com.baidu.live.data.h hVar = this.aXE.get(i3);
                if (hVar == null || this.aYo != hVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    ej(i3);
                    break;
                }
            }
            this.aYd = this.aYc;
        }
    }

    private View bL(boolean z) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext.getPageActivity());
        commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        } else {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aYb != null) {
                    AlaGiftTabView.this.aYb.HO();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.bx(this.aWq);
        aVar.setGiftItems(list);
        aVar.dY(this.aWo);
        aVar.bg(this.aWw);
        aVar.dZ(i);
        if (this.isLandscape) {
            if (this.aXO.getHeight() > 0) {
                aVar.ea(this.aXO.getHeight() / 3);
            } else {
                this.aXO.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.ea(AlaGiftTabView.this.aXO.getHeight() / 3);
                        aVar.notifyDataSetChanged();
                    }
                });
            }
        }
        BdGridView bdGridView = new BdGridView(this.mContext.getPageActivity());
        bdGridView.setNumColumns(4);
        bdGridView.setVerticalScrollBarEnabled(false);
        bdGridView.setSelector(a.c.sdk_transparent);
        bdGridView.setAdapter((ListAdapter) aVar);
        bdGridView.setOnItemClickListener(new b());
        bdGridView.setOnItemLongClickListener(new c());
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0182a) {
                    ((a.C0182a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout ek(int i) {
        FrameLayout b2 = b(null, -1, i);
        int i2 = 0;
        while (true) {
            if (i2 >= b2.getChildCount()) {
                break;
            } else if (!(b2.getChildAt(i2) instanceof GridView)) {
                i2++;
            } else {
                CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext.getPageActivity());
                commonEmptyView.setTitle(a.h.ala_package_empty);
                commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
                ((GridView) b2.getChildAt(i2)).setEmptyView(commonEmptyView);
                commonEmptyView.addToParent(b2);
                break;
            }
        }
        return b2;
    }

    @SuppressLint({"ResourceAsColor"})
    private void m(ArrayList<com.baidu.live.data.h> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.aYn) {
                this.aXQ.setVisibility(0);
            }
            this.aXR.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.h hVar = arrayList.get(i);
                if (!TextUtils.isEmpty(hVar.getCategoryName()) && (this.mType != 0 || (hVar.Dx() != null && hVar.Dx().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.f.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(hVar.getCategoryName());
                    viewGroup.setOnClickListener(new d(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aYh;
                    }
                    if (this.aXD.size() > i && this.aXD.get(i) != null) {
                        for (g gVar : this.aXD.get(i).FL()) {
                            if (gVar != null && gVar.Fp() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aXR.addView(viewGroup, layoutParams);
                }
            }
            el(this.aYe);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01e0  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void el(int i) {
        JSONArray jSONArray;
        JSONException e2;
        List<g> FL;
        int childCount = this.aXR.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aYe != i || !this.aYf) && this.aXE.size() > i && this.aXE.get(i) != null) {
                int min = Math.min(i, this.aYk.size());
                int i2 = 0;
                int i3 = 0;
                while (i3 < min) {
                    int i4 = this.aYk.get(i3) + i2;
                    i3++;
                    i2 = i4;
                }
                if (this.aXZ.size() > i2 && this.aXD.size() > i && (this.aXZ.get(i2) instanceof ViewGroup)) {
                    if (!this.aYf) {
                        i2 = this.aYc;
                    }
                    this.aYd = i2;
                    h hVar = this.aXD.get(i);
                    if (hVar != null && hVar.FL() != null && !hVar.FL().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aXZ.get(this.aYd);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    a(aVar, !this.aYf ? this.mSelectedPosition : 0);
                                    if (this.mShowing) {
                                        this.aYf = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aXE.size() > i && this.aXE.get(i) != null) {
                int categoryId = this.aXE.get(i).getCategoryId();
                if (!this.aYr.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aYr.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aXR.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.f.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.f.icon_new_unlock_gift);
                imageView.setVisibility(8);
                h hVar2 = this.aXD.get(i6);
                if (hVar2.FM() || hVar2.getCategoryId() == 20) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aXJ, "");
                    JSONArray jSONArray2 = null;
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            jSONArray = new JSONArray(string);
                            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                                try {
                                    hashSet.add(jSONArray.optString(i7));
                                } catch (JSONException e3) {
                                    e2 = e3;
                                    e2.printStackTrace();
                                    jSONArray2 = jSONArray;
                                    FL = hVar2.FL();
                                    if (FL != null) {
                                    }
                                    if (i6 == i) {
                                    }
                                    if (i6 == i) {
                                    }
                                }
                            }
                            jSONArray2 = jSONArray;
                        } catch (JSONException e4) {
                            jSONArray = null;
                            e2 = e4;
                        }
                    }
                    FL = hVar2.FL();
                    if (FL != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= FL.size()) {
                                break;
                            }
                            g gVar = FL.get(i9);
                            if (!gVar.FH() && !hashSet.contains(gVar.Fk())) {
                                arrayList.add(gVar.Fk());
                            }
                            i8 = i9 + 1;
                        }
                        if (!arrayList.isEmpty()) {
                            if (i6 != i) {
                                if (hVar2.getCategoryId() == 20 && !aYF.containsAll(arrayList)) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913228, true));
                                    aYF.addAll(arrayList);
                                }
                                imageView.setVisibility(0);
                            } else {
                                if (jSONArray2 == null) {
                                    jSONArray2 = new JSONArray();
                                }
                                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                                    jSONArray2.put(arrayList.get(i10));
                                }
                                SharedPrefHelper.getInstance().putString(this.aXJ, jSONArray2.toString());
                            }
                        }
                    }
                }
                if (i6 == i) {
                    gradientTextView.setGradientTextColor(-2130706433, -2130706433);
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(0));
                } else {
                    if (imageView.getVisibility() == 0) {
                        imageView.setVisibility(8);
                    }
                    if (this.aYx != 0) {
                        gradientTextView.setGradientTextColor(this.aYx, this.aYx);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    em(i);
                    this.aYe = i;
                    this.aXQ.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bM(false);
                        } else {
                            bM(true);
                        }
                    } else {
                        bM(true);
                    }
                }
            }
        }
    }

    private void bM(boolean z) {
        int i = 8;
        if (this.aXV != null) {
            this.aXV.setVisibility(z ? this.aYt ? 8 : 0 : 8);
        }
        if (this.aXW != null) {
            TextView textView = this.aXW;
            if (!z && !this.aYt) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void em(int i) {
        int childCount = this.aXR.getChildCount();
        if (i >= 0 && i < childCount && this.aXD != null && this.aXD.size() > i && this.aXD.get(i) != null) {
            this.aYl.get(i);
        }
    }

    public void x(int i, int i2) {
        this.aYo = i;
        this.aYp = i2;
    }

    public void aq(long j) {
        if (this.aXV != null) {
            if (j >= 100 && (this.aWq || com.baidu.live.aa.a.Ph().bms.aKV)) {
                this.aXV.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aXV.setText(String.valueOf(j));
        }
    }

    public void ar(long j) {
        if (this.aXW != null) {
            this.aXW.setText(String.valueOf(j));
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
        this.aYc = i;
        HI();
        HC();
        if (i >= 0 && i < this.aXZ.size() && (this.aXZ.get(i) instanceof ViewGroup)) {
            HH();
            ViewGroup viewGroup = (ViewGroup) this.aXZ.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aYd) {
                            aVar.dZ(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aYd) {
                            aVar.dZ(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        a(gridView);
                        this.aXT.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void a(final AbsListView absListView) {
        if (this.aYE != null) {
            this.aYE.cancel();
        }
        if (absListView != null) {
            absListView.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                @Override // java.lang.Runnable
                public void run() {
                    g gVar;
                    ArrayList arrayList = null;
                    int childCount = absListView.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = absListView.getChildAt(i);
                        if (childAt != null && (childAt.getTag() instanceof a.C0182a)) {
                            a.C0182a c0182a = (a.C0182a) childAt.getTag();
                            if (c0182a.aWD != null && (c0182a.aWD.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (gVar = (g) c0182a.aWD.getTag(a.f.TAG_GIFT_ITEM)) != null && gVar.aTb != null && gVar.aTb.enabled && gVar.aTb.aTf && !TextUtils.isEmpty(gVar.aTb.detailUrl)) {
                                String Fk = gVar.Fk();
                                if (!com.baidu.live.gift.w.Gr().gK(Fk)) {
                                    com.baidu.live.gift.w.Gr().gL(Fk);
                                    AlaGiftTabView.this.a(c0182a.aWD, !TextUtils.isEmpty(gVar.aTb.aTg) ? gVar.aTb.aTg : "长按查看规则");
                                    AnimatorSet a2 = AlaGiftTabView.this.a(absListView, c0182a);
                                    a2.playTogether(AlaGiftTabView.this.R(c0182a.aWy), AlaGiftTabView.this.S(c0182a.aWD));
                                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                                    arrayList2.add(a2);
                                    arrayList = arrayList2;
                                }
                            }
                        }
                    }
                    AlaGiftTabView.this.K(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-39424);
        gradientDrawable.setCornerRadius(textView.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet a(final AbsListView absListView, final a.C0182a c0182a) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                if (c0182a != null && c0182a.aWD != null) {
                    c0182a.aWD.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c0182a != null && c0182a.aWD != null) {
                    c0182a.aWD.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c0182a != null) {
                    c0182a.Hl();
                }
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator R(final View view) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.baidu.live.gift.container.a.b(), Float.valueOf(0.0f), Float.valueOf(1.0f));
        ofObject.setDuration(1250L);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view != null && (valueAnimator.getAnimatedValue() instanceof Float)) {
                    view.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    view.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        return ofObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator S(final View view) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.baidu.live.gift.container.a.a(), new a.C0183a(), new a.C0183a());
        ofObject.setDuration(3541L);
        ofObject.setStartDelay(1000L);
        ofObject.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (view != null) {
                    view.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (view != null) {
                    view.setVisibility(0);
                }
            }
        });
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view != null && (valueAnimator.getAnimatedValue() instanceof a.C0183a)) {
                    a.C0183a c0183a = (a.C0183a) valueAnimator.getAnimatedValue();
                    view.setScaleX(c0183a.scale);
                    view.setScaleY(c0183a.scale);
                    view.setAlpha(c0183a.alpha);
                }
            }
        });
        return ofObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(List<Animator> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aYE == null) {
                this.aYE = new AnimatorSet();
                this.aYE.setInterpolator(new LinearInterpolator());
            }
            this.aYE.playTogether(list);
            this.aYE.start();
        }
    }

    private void HH() {
        JSONObject jSONObject = new JSONObject();
        com.baidu.live.data.h hVar = (com.baidu.live.data.h) ListUtils.getItem(this.aXE, this.aYe);
        if (hVar != null) {
            try {
                jSONObject.put("tabid", hVar.getCategoryId());
                jSONObject.put("tabname", hVar.getCategoryName());
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "giftpanel_show").setContentExt(null, "giftpanel", jSONObject));
    }

    private void HI() {
        int i = 0;
        for (int i2 = 0; i2 < this.aYk.size(); i2++) {
            for (int i3 = 0; i3 < this.aYk.get(i2); i3++) {
                if (i + i3 == this.aYc) {
                    if (this.aYk.get(i2) <= 1) {
                        this.aXP.setVisibility(4);
                    } else {
                        this.aXP.setVisibility(0);
                    }
                    this.aXP.setCount(this.aYk.get(i2));
                    this.aXP.onPageSelected(i3);
                    el(i2);
                    return;
                }
            }
            i += this.aYk.get(i2);
        }
    }

    public g HJ() {
        return this.aYi;
    }

    public int HK() {
        return this.aYj;
    }

    public void a(e eVar) {
        this.aYb = eVar;
    }

    public void en(int i) {
        this.aYj = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aYI);
        MessageManager.getInstance().registerListener(this.aYJ);
        MessageManager.getInstance().registerListener(this.aYK);
        MessageManager.getInstance().registerListener(this.aYL);
    }

    public void HL() {
        if (!ListUtils.isEmpty(this.aXZ)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aXZ) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).notifyDataSetChanged();
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
    public void au(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.aXZ) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aXZ) {
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
    public void HM() {
        if (!ListUtils.isEmpty(this.aXZ)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aXZ) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aWw);
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
    public void HN() {
        if (this.aYi != null && this.aYi.FJ()) {
            this.aXM.setStyleEnabled(this.aWw);
            if (this.aWw) {
                this.aXY.setStyle(this.aYi.Fq() ? 2 : 1);
            } else {
                this.aXY.setStyle(this.aYi.Fq() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.aYw = null;
        MessageManager.getInstance().unRegisterListener(this.aYI);
        MessageManager.getInstance().unRegisterListener(this.aYJ);
        MessageManager.getInstance().unRegisterListener(this.aYK);
        MessageManager.getInstance().unRegisterListener(this.aYL);
        rE();
        if (this.aYu != null) {
            this.aYu.dismiss();
        }
        if (this.aYE != null) {
            this.aYE.cancel();
        }
    }

    public void bx(boolean z) {
        this.aWq = z;
    }

    public void eo(int i) {
        this.aWo = i;
    }

    public void d(g gVar) {
        this.aYi = gVar;
        if (this.aYi.Fk().equals("")) {
            BdUtilHelper.showToast(this.mContext.getPageActivity(), "该礼物已下线");
            return;
        }
        this.aYp = Integer.valueOf(this.aYi.Fk()).intValue();
        if (this.aYw != null) {
            this.aYw.a(gVar);
        }
        if (gVar != null && !gVar.Fs()) {
            this.aYy.Hg();
        }
    }

    public void Hf() {
        if (this.aYy != null) {
            this.aYy.Hf();
        }
        g gVar = this.aYi;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Fk());
                jSONObject.putOpt("gift_name", gVar.Fl());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "combosend_show").setContentExt(null, "popup", jSONObject));
        }
    }

    public void He() {
        if (this.aYy != null) {
            this.aYy.He();
        }
        g gVar = this.aYi;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Fk());
                jSONObject.putOpt("gift_name", gVar.Fl());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "click", "liveroom", "combosend_clk").setContentExt(null, "popup", jSONObject));
        }
    }

    public void bN(boolean z) {
        if (this.aXY != null) {
            this.aXY.setVisibility(z ? 0 : 4);
        }
    }
}

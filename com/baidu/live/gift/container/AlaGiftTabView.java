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
import com.baidu.live.b.r;
import com.baidu.live.data.bj;
import com.baidu.live.data.g;
import com.baidu.live.data.u;
import com.baidu.live.data.w;
import com.baidu.live.gift.container.AlaComboBtnAnimView;
import com.baidu.live.gift.container.a;
import com.baidu.live.gift.container.a.a;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.s;
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
import com.baidu.platform.comapi.map.MapController;
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
    private int aIS;
    private int aVm;
    private boolean aVo;
    private boolean aVu;
    public ArrayList<i> aWB;
    private ArrayList<g> aWC;
    private ArrayList<com.baidu.live.data.i> aWD;
    private final String aWH;
    private boolean aWI;
    private View aWJ;
    private GiftPanelNumRoundRectView aWK;
    public TextView aWL;
    private BaseViewPager aWM;
    private RoundRectPageIndicator aWN;
    private HorizontalScrollView aWO;
    private LinearLayout aWP;
    private CommonEmptyView aWQ;
    private View aWR;
    private com.baidu.live.gift.container.c aWS;
    private TextView aWT;
    private TextView aWU;
    private TextView aWV;
    public GiftPanelOperationSendView aWW;
    private List<View> aWX;
    private ArrayList<List<com.baidu.live.gift.g>> aWY;
    private e aWZ;
    private boolean aXA;
    private boolean aXB;
    private AnimatorSet aXC;
    private View.OnClickListener aXE;
    AdapterView.OnItemClickListener aXF;
    private CustomMessageListener aXG;
    private CustomMessageListener aXH;
    private CustomMessageListener aXI;
    private CustomMessageListener aXJ;
    private int aXa;
    private int aXb;
    private int aXc;
    private boolean aXd;
    private boolean aXe;
    private int aXf;
    private com.baidu.live.gift.g aXg;
    private int aXh;
    private SparseIntArray aXi;
    private SparseBooleanArray aXj;
    private View.OnClickListener aXk;
    private boolean aXl;
    private int aXm;
    private int aXn;
    private int aXo;
    private SparseBooleanArray aXp;
    private Set<String> aXq;
    private boolean aXr;
    private BdAlertDialog aXs;
    private int aXt;
    private a aXu;
    private int aXv;
    private AlaComboBtnAnimView aXw;
    private TbImageView aXx;
    private com.baidu.live.gift.container.d aXy;
    private boolean aXz;
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
    public static ArrayList<String> aXD = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.live.gift.g gVar);

        void aq(String str, String str2);

        void c(boolean z, int i);

        void e(boolean z, String str);

        void q(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void HB();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aWH = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aWX = new ArrayList();
        this.aXa = 0;
        this.aXb = 0;
        this.mSelectedPosition = 0;
        this.aXc = 0;
        this.aXi = new SparseIntArray();
        this.aXj = new SparseBooleanArray();
        this.isLandscape = false;
        this.aXl = false;
        this.aXm = -1;
        this.aXn = -1;
        this.aVo = false;
        this.aVm = -1;
        this.aXp = new SparseBooleanArray();
        this.aXq = new HashSet();
        this.aXz = false;
        this.aVu = false;
        this.aXA = false;
        this.aXB = false;
        this.aXE = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aXw == null || !AlaGiftTabView.this.aXw.GT()) {
                    if (AlaGiftTabView.this.aWS == null) {
                        AlaGiftTabView.this.aWS = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aXF);
                    }
                    AlaGiftTabView.this.bF(true);
                    AlaGiftTabView.this.aWS.a(AlaGiftTabView.this.aWJ, AlaGiftTabView.this.aWD, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bF(false);
                        }
                    });
                }
            }
        };
        this.aXF = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.aWS.dismiss();
                if (AlaGiftTabView.this.aWD != null && AlaGiftTabView.this.aWD.size() > 0) {
                    if (i != AlaGiftTabView.this.aWD.size()) {
                        com.baidu.live.data.i iVar = (com.baidu.live.data.i) AlaGiftTabView.this.aWD.get(i);
                        if (iVar != null) {
                            int number = iVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (bVar = AlaGiftTabView.this.aXg.aSt) != null) {
                                if (number == -1) {
                                    number = bVar.aSG;
                                }
                                if (number > AlaGiftTabView.this.aXt) {
                                    number = AlaGiftTabView.this.aXt;
                                }
                            }
                            AlaGiftTabView.this.gY(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.Hr();
                    return;
                }
                AlaGiftTabView.this.gY("1");
            }
        };
        this.aXG = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.aQU == 1 || cVar.aQU == 2 || cVar.aQU == 5 || cVar.aQU == 6) && cVar.aQV != null) {
                        AlaGiftTabView.this.as(cVar.aQV.getId(), cVar.aQV.getUrl());
                    }
                }
            }
        };
        this.aXH = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bA(true);
                if (AlaGiftTabView.this.aXg != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aXg) && AlaGiftTabView.this.aWI) {
                    AlaGiftTabView.this.aWW.setStyle(AlaGiftTabView.this.aXg.Fj() ? 2 : 1);
                    AlaGiftTabView.this.aWK.setStyleEnabled(true);
                }
            }
        };
        this.aXI = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                u uVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof u) && (uVar = (u) customResponsedMessage.getData()) != null && uVar.aIf != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = uVar.aIf.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aVu != z2) {
                        AlaGiftTabView.this.aVu = z2;
                        AlaGiftTabView.this.HA();
                        AlaGiftTabView.this.Hz();
                    }
                }
            }
        };
        this.aXJ = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.Hq();
                    AlaGiftTabView.this.aWW.setStyle(AlaGiftTabView.this.aXg.Fj() ? 4 : 3);
                    AlaGiftTabView.this.aWK.setStyleEnabled(false);
                    if (AlaGiftTabView.this.aXu != null) {
                        AlaGiftTabView.this.aXu.e(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aXk = onClickListener;
        this.aXl = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aXf = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        this.aWY = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aXt = 9999;
                return;
            case 1:
                this.aXt = 999;
                return;
            default:
                return;
        }
    }

    public void ej(int i) {
        int childCount;
        this.aXv = i;
        if (this.aWP != null && (childCount = this.aWP.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aXc) {
                    ((GradientTextView) ((ViewGroup) this.aWP.getChildAt(i2)).findViewById(a.g.text_view)).setGradientTextColor(this.aXv, this.aXv);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aXu = aVar;
    }

    public void ar(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bz(boolean z) {
        this.mShowing = z;
    }

    public void onVisibilityChanged(boolean z) {
        bz(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        this.aWJ = this.mRoot.findViewById(a.g.gift_count_layout);
        this.aWJ.setOnClickListener(this.aXE);
        this.aWK = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.aWL = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.aWL.setText("1");
        this.aWL.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.aWM = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.aWM.setOnPageChangeListener(this);
        this.aWN = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.aWP = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.aWO = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.aXl) {
            this.aWO.setVisibility(8);
        }
        this.aWT = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.aWT.setOnClickListener(this.aXk);
        this.aWU = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.aWU.setOnClickListener(this.aXk);
        this.aWW = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.aWV = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.aWV.setOnClickListener(this.aXk);
        this.aWW.setOnClickListener(this.aXk);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.aWQ = new CommonEmptyView(this.mContext.getPageActivity());
        this.aWQ.setVisibility(8);
        this.aWQ.addToParent(frameLayout);
        this.aWR = this.mRoot.findViewById(a.g.donate_layout);
        this.aXw = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.aXw.setComboClickListener(this.aXk);
        this.aXw.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void GU() {
                AlaGiftTabView.this.bI(true);
            }
        });
        this.aXx = (TbImageView) this.mRoot.findViewById(a.g.iv_official);
    }

    public void Ho() {
        this.aXr = true;
        this.aWT.setVisibility(8);
        this.aWU.setVisibility(8);
        this.aWV.setVisibility(8);
    }

    public void bA(boolean z) {
        this.aWI = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.x.a.OS().OV() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aWV.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aXq.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aXq.add(str);
            }
        }
    }

    public void ba(boolean z) {
    }

    public void dG(int i) {
        this.aXo = i;
    }

    public void bB(boolean z) {
        this.aXA = z;
        if (!z && this.aXC != null) {
            this.aXC.cancel();
        }
        if (z && !ListUtils.isEmpty(this.aWC)) {
            Hu();
            this.aXB = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar) {
        if (wVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_pop_show"));
            if (this.aXy == null) {
                this.aXy = new com.baidu.live.gift.container.d(this.mContext);
            }
            this.aXy.n(wVar.dialogTitle, wVar.aIF + wVar.aIG, wVar.aIG);
        }
    }

    private void Q(View view) {
        if (this.aXy == null) {
            this.aXy = new com.baidu.live.gift.container.d(this.mContext);
        }
        this.aXy.O(view);
    }

    public void bC(boolean z) {
        this.aXz = z;
    }

    public void ek(int i) {
        this.aIS = i;
    }

    public void bc(boolean z) {
        this.aVu = z;
    }

    public void bD(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.aWM.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24);
                this.aWM.setLayoutParams(layoutParams);
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
            AlaGiftTabView.this.el(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void el(int i) {
        if (this.aXu != null) {
            this.aXu.c(false, this.aXt);
        }
        em(i);
        this.aWM.setCurrentItem(this.aXa);
        Hv();
        Hp();
    }

    private void em(int i) {
        int min = Math.min(i, this.aXi.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aXi.get(i3);
        }
        this.aXa = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.live.gift.g item = ((com.baidu.live.gift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.isRed()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.aXb = AlaGiftTabView.this.aXa;
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
            com.baidu.live.gift.g item = ((com.baidu.live.gift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.aSx != null && item.aSx.enabled && !TextUtils.isEmpty(item.aSx.detailUrl) && AlaGiftTabView.this.aXu != null) {
                AlaGiftTabView.this.aXu.q(item.aSx.aSD, item.aSx.detailUrl);
            }
            return false;
        }
    }

    private void Hp() {
        if (this.aXu != null) {
            if (this.aXg != null && this.aXg.aSu) {
                this.aXu.aq(this.aXg.aSv, this.aXg.aSw);
            } else {
                this.aXu.aq(null, null);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.aXu != null) {
            this.aXu.c(false, this.aXt);
        }
        if (aVar != null) {
            com.baidu.live.gift.g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.ec(i);
                aVar.notifyDataSetChanged();
                this.aWR.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                gY("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aXg.FA()) {
                        this.aWW.setStyle(this.aXg.Fj() ? 4 : 3);
                        this.aWK.setStyleEnabled(false);
                        if (this.aXu != null) {
                            this.aXu.e(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aXg.Fm()) && this.mShowing) {
                            this.mContext.showToast(this.aXg.Fm());
                            return;
                        }
                        return;
                    }
                    Hp();
                    this.aWW.setEnabled(true);
                    if (this.aXg.FD()) {
                        if (this.aXu != null) {
                            this.aXu.e(false, null);
                        }
                        if (this.aXg.Fz() == 6 && this.aVm < 3) {
                            i3 = 3;
                        } else if (this.aXg.Fz() == 7 && this.aVm < 7) {
                            i3 = 7;
                        } else if (this.aXg.Fz() == 8 && this.aVm < 13) {
                            i3 = 13;
                        } else if (this.aXg.Fz() == 9 && this.aVm < 22) {
                            i3 = 22;
                        } else if (this.aXg.Fz() == 10 && this.aVm < 29) {
                            i3 = 29;
                        } else if (this.aXg.Fz() == 11 && this.aVm < 39) {
                            i3 = 39;
                        } else if (this.aXg.Fz() == 12 && this.aVm < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.aWW.setStyle(this.aXg.Fj() ? 2 : 1);
                    } else {
                        this.aWW.setStyle(this.aXg.Fj() ? 4 : 3);
                    }
                    this.aWK.setStyleEnabled(z);
                    HA();
                    i2 = i3;
                } else {
                    this.aWW.setStyle(this.aXg.Fj() ? 2 : 1);
                    if (this.aXg.aSt != null && this.aXg.aSt.aSF != null && this.aXg.aSt.aSF.equals("20")) {
                        this.aWW.setText("使用");
                    } else {
                        this.aWW.setText("赠送");
                    }
                    this.aWK.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aXg.Fk()) {
                    bE(true);
                } else {
                    bE(false);
                    gY("1");
                }
                d(false, i2);
                return;
            }
            this.aWW.setStyle(3);
            return;
        }
        this.aWW.setStyle(3);
    }

    private void d(boolean z, int i) {
        if (this.mShowing && this.aXg != null) {
            if (this.mType == 0) {
                if (this.aXg.FC() && !this.aVu) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aXg.Fm()) && this.aXg.FA() && !z) {
                    this.mContext.showToast(this.aXg.Fm());
                } else if (this.aXg.FD() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aXg.Fy()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1) {
                g.b bVar = this.aXg.aSt;
                if (bVar != null && !TextUtils.isEmpty(bVar.aSI)) {
                    this.mContext.showToast(bVar.aSI);
                } else if (!TextUtils.isEmpty(this.aXg.Fm())) {
                    BdUtilHelper.showToast(this.mContext.getPageActivity(), this.aXg.Fm());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.live.gift.g gVar) {
        if (com.baidu.live.x.a.OS().bqJ != null && com.baidu.live.x.a.OS().bqJ.aNU != null) {
            String str = com.baidu.live.x.a.OS().bqJ.aNU.aNg;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Fz()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hq() {
        if (!this.aXe) {
            this.aXs = new BdAlertDialog(this.mContext.getPageActivity());
            this.aXs.setCancelable(false);
            this.aXs.setCanceledOnTouchOutside(false);
            this.aXs.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.aXs.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aXo)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aXs.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.aXs.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aXs.setPositiveButtonTextColor(-57754);
                this.aXs.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aXs.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aXe = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aXs.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aXe = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aXs.create(this.mContext).show();
            this.aXe = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.x.a.OS().blo.aKg;
        if (z2) {
            this.aWJ.setVisibility(4);
            this.aWW.setStyle(1);
        } else {
            View view = this.aWJ;
            if (this.aXg == null || !this.aXg.Fj()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.aXu != null) {
            this.aXu.e(z2, this.aXg != null ? this.aXg.getThumbnail_url() : null);
        }
    }

    public void Hr() {
        if (this.aXu != null) {
            this.aXu.c(true, this.aXt);
        }
    }

    @Override // com.baidu.live.view.input.b.a
    public void gV(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        gY(str);
    }

    public void gY(String str) {
        this.aWL.setText(str);
        this.aWL.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        bF(false);
        if (this.aXg != null && this.aXg.Fj()) {
            this.aWJ.setVisibility(0);
            this.aXh = JavaTypesHelper.toInt(this.aWL.getText().toString(), 1);
            return;
        }
        this.aWJ.setVisibility(4);
        this.aXh = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        this.aWL.setGravity(17);
        if (z) {
            this.aWL.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aWL.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.g> arrayList2, ArrayList<com.baidu.live.data.i> arrayList3, boolean z2, int i) {
        if (this.aWB == null || this.aWB.isEmpty()) {
            if (this.aWB == null) {
                this.aWB = new ArrayList<>();
            }
            this.aWB.clear();
            if (arrayList != null) {
                this.aWB.addAll(arrayList);
            }
            this.aWC = arrayList2;
            this.aWD = arrayList3;
            this.aXd = false;
            if (this.aWC == null || this.aWC.isEmpty()) {
                this.aWO.setVisibility(8);
            }
            a(z, z2, i);
            onPageSelected(this.aWM.getCurrentItem());
        }
    }

    public void A(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aWX != null) {
            for (View view : this.aWX) {
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
        Hs();
        if (this.aWB == null || this.aWB.size() <= 0 || !z2) {
            rE();
            if (this.aWN != null) {
                this.aWN.setVisibility(4);
            }
            this.aWR.setVisibility(4);
            this.aWQ.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.aWQ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aWQ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.aWQ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.x.a.OS().blo.aLI && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aWQ.setTitle(string);
            this.aWQ.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aWZ != null) {
                        AlaGiftTabView.this.aWZ.HB();
                    }
                }
            });
            this.aWQ.setVisibility(0);
            return;
        }
        this.aWQ.setVisibility(8);
        if (z) {
            m(this.aWC);
        }
        bj bjVar = com.baidu.live.x.a.OS().bqJ;
        if (this.mType == 0 && bjVar != null && bjVar.aNY != null && bjVar.aNY.aQh && !this.aXz && this.aWB.get(0) != null && this.aWB.get(0).FE() != null) {
            List<com.baidu.live.gift.g> FE = this.aWB.get(0).FE();
            if (FE.size() <= 1 || FE.get(1) == null) {
                z3 = true;
            } else {
                z3 = !FE.get(1).isRed();
            }
            if (!FE.isEmpty() && z3) {
                com.baidu.live.gift.g gVar = new com.baidu.live.gift.g();
                gVar.bn(true);
                gVar.setGiftName("发红包");
                FE.add(1, gVar);
            }
        }
        c(this.aWB, z);
        gY("1");
    }

    private void rE() {
        this.aXa = 0;
        this.aXb = 0;
        this.mSelectedPosition = 0;
        this.aXc = 0;
        if (this.aXi != null) {
            this.aXi.clear();
        }
        if (this.aWX != null) {
            this.aWX.clear();
        }
        if (this.aWM != null) {
            this.aWM.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.live.gift.g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.FD()) {
            if (gVar.Fz() == 6 && this.aVm < 3) {
                return false;
            }
            if (gVar.Fz() == 7 && this.aVm < 7) {
                return false;
            }
            if (gVar.Fz() == 8 && this.aVm < 13) {
                return false;
            }
            if (gVar.Fz() == 9 && this.aVm < 22) {
                return false;
            }
            if (gVar.Fz() == 10 && this.aVm < 29) {
                return false;
            }
            if (gVar.Fz() == 11 && this.aVm < 39) {
                return false;
            }
            if (gVar.Fz() == 12 && this.aVm < 47) {
                return false;
            }
        }
        if (gVar.FC()) {
            return this.aVu;
        }
        return true;
    }

    public void b(final w wVar) {
        if (wVar == null || TextUtils.isEmpty(wVar.iconUrl)) {
            this.aXx.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_show"));
            this.aXx.setVisibility(0);
            this.aXx.startLoad(wVar.iconUrl, 10, false);
            this.aXx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_clk"));
                    AlaGiftTabView.this.a(wVar);
                }
            });
            String str = "key_live_official_tip" + currentAccount;
            if (com.baidu.live.c.AZ().getInt(str, 0) == 0 && this.aXA) {
                Q(this.aXx);
                com.baidu.live.c.AZ().putInt(str, 1);
            }
        }
    }

    private void Hs() {
        if (ListUtils.getCount(this.aWC) != 0 && ListUtils.getCount(this.aWB) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.g> it = this.aWC.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.g next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.DG()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.aWB.iterator();
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
                Iterator<i> it3 = this.aWB.iterator();
                while (it3.hasNext()) {
                    ListIterator<com.baidu.live.gift.g> listIterator = it3.next().FE().listIterator();
                    while (listIterator.hasNext()) {
                        com.baidu.live.gift.g next3 = listIterator.next();
                        if (next3 != null && next3.Fk()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aWC.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aWB.removeAll(arrayList2);
            }
        }
    }

    private void c(ArrayList<i> arrayList, boolean z) {
        boolean z2;
        int i;
        ArrayList arrayList2;
        int i2;
        int i3;
        com.baidu.live.gift.g gVar;
        List<com.baidu.live.gift.g> FE;
        if (arrayList != null) {
            this.aXi.clear();
            this.aWX.clear();
            this.aWM.setAdapter(null);
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
                    if (iVar == null || (FE = iVar.FE()) == null || FE.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aWY.clear();
            K(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aWX.add(en(i7));
                    this.aXi.append(i7, 1);
                } else {
                    i iVar2 = arrayList.get(i7);
                    iVar2.getCategoryId();
                    List<com.baidu.live.gift.g> FE2 = iVar2.FE();
                    if (FE2 == null) {
                        i = 0;
                    } else {
                        i = FE2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aXj.get(i7)) {
                            this.aWX.add(bG(true));
                        } else {
                            this.aWX.add(b(arrayList3, -1, i7));
                        }
                    } else if (FE2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(FE2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(FE2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(FE2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aWY.add(arrayList2);
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
                                    if (gVar == null || gVar.Fd() == null || !gVar.Fd().equals(String.valueOf(this.aXn))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aWX.add(b(arrayList2, i3, i7));
                                this.aWW.removeCallbacks(null);
                                this.aWW.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.22
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aXg != null) {
                                            boolean Fk = AlaGiftTabView.this.aXg.Fk();
                                            AlaGiftTabView.this.bE(Fk);
                                            if (!Fk) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aXg);
                                                if (!c2) {
                                                    AlaGiftTabView.this.aWW.setStyle(AlaGiftTabView.this.aXg.Fj() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.aWW.setStyle(AlaGiftTabView.this.aXg.Fj() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.aWK.setStyleEnabled(c2);
                                            }
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
                                        com.baidu.live.gift.g gVar2 = arrayList2.get(i2);
                                        if (gVar2 == null || !gVar2.Fd().equals(String.valueOf(this.aXn))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aWX.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aWX.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.aXi.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aWM.setAdapter(new AlaGiftPagerAdapter(this.aWX));
            Ht();
            this.aWM.setCurrentItem(this.aXa);
            Hv();
            if (z && !this.aXB && this.aXA) {
                this.aXB = true;
                Hu();
            }
        }
    }

    private void Ht() {
        int i = 0;
        if (this.aXn > 0 && !ListUtils.isEmpty(this.aWY)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aWY.size() && !z; i2++) {
                Iterator<com.baidu.live.gift.g> it = this.aWY.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.live.gift.g next = it.next();
                    if (next != null && next.Fd() != null && next.Fd().equals(String.valueOf(this.aXn))) {
                        this.aXa = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aIS == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.aXb = this.aXa;
            this.aWY.clear();
        } else if (this.aXm > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aWC.size()) {
                    break;
                }
                com.baidu.live.data.g gVar = this.aWC.get(i3);
                if (gVar == null || this.aXm != gVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    em(i3);
                    break;
                }
            }
            this.aXb = this.aXa;
        }
    }

    private void K(List<i> list) {
        if (list != null && this.aXm > 0 && this.aXn <= 0) {
            for (i iVar : list) {
                if (iVar.getCategoryId() == this.aXm) {
                    List<com.baidu.live.gift.g> FE = iVar.FE();
                    if (FE != null && !FE.isEmpty() && FE.get(0) != null) {
                        this.aXn = Integer.valueOf(FE.get(0).Fd()).intValue();
                        return;
                    }
                    return;
                }
            }
        }
    }

    private View bG(boolean z) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext.getPageActivity());
        commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        } else {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aWZ != null) {
                    AlaGiftTabView.this.aWZ.HB();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<com.baidu.live.gift.g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.bs(this.aVo);
        aVar.setGiftItems(list);
        aVar.eb(this.aVm);
        aVar.bc(this.aVu);
        aVar.ec(i);
        if (this.isLandscape) {
            if (this.aWM.getHeight() > 0) {
                aVar.ed(this.aWM.getHeight() / 3);
            } else {
                this.aWM.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.ed(AlaGiftTabView.this.aWM.getHeight() / 3);
                        aVar.notifyDataSetChanged();
                    }
                });
            }
        }
        BdGridView bdGridView = new BdGridView(this.mContext.getPageActivity());
        bdGridView.setNumColumns(4);
        bdGridView.setVerticalScrollBarEnabled(false);
        bdGridView.setSelector(a.d.sdk_transparent);
        bdGridView.setAdapter((ListAdapter) aVar);
        bdGridView.setOnItemClickListener(new b());
        bdGridView.setOnItemLongClickListener(new c());
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0181a) {
                    ((a.C0181a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout en(int i) {
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
    private void m(ArrayList<com.baidu.live.data.g> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.aXl) {
                this.aWO.setVisibility(0);
            }
            this.aWP.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.g gVar = arrayList.get(i);
                if (!TextUtils.isEmpty(gVar.getCategoryName()) && (this.mType != 0 || (gVar.DG() != null && gVar.DG().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(gVar.getCategoryName());
                    viewGroup.setOnClickListener(new d(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aXf;
                    }
                    if (this.aWB.size() > i && this.aWB.get(i) != null) {
                        for (com.baidu.live.gift.g gVar2 : this.aWB.get(i).FE()) {
                            if (gVar2 != null && gVar2.Fi() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aWP.addView(viewGroup, layoutParams);
                }
            }
            eo(this.aXc);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e0  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eo(int i) {
        int i2;
        JSONArray jSONArray;
        JSONException e2;
        List<com.baidu.live.gift.g> FE;
        int childCount = this.aWP.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aXc != i || !this.aXd) && this.aWC.size() > i && this.aWC.get(i) != null) {
                int min = Math.min(i, this.aXi.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aXi.get(i4);
                }
                if (this.aWX.size() > i3 && this.aWB.size() > i && (this.aWX.get(i3) instanceof ViewGroup)) {
                    this.aXb = i3;
                    i iVar = this.aWB.get(i);
                    if (iVar != null && iVar.FE() != null && !iVar.FE().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aWX.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aXd) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aXa) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.mShowing) {
                                        this.aXd = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aWC.size() > i && this.aWC.get(i) != null) {
                int categoryId = this.aWC.get(i).getCategoryId();
                if (!this.aXp.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aXp.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aWP.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.aWB.get(i6);
                if (iVar2.FF() || iVar2.getCategoryId() == 20) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aWH, "");
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
                                    FE = iVar2.FE();
                                    if (FE != null) {
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
                    FE = iVar2.FE();
                    if (FE != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= FE.size()) {
                                break;
                            }
                            com.baidu.live.gift.g gVar = FE.get(i9);
                            if (!gVar.FA() && !hashSet.contains(gVar.Fd())) {
                                arrayList.add(gVar.Fd());
                            }
                            i8 = i9 + 1;
                        }
                        if (!arrayList.isEmpty()) {
                            if (i6 != i) {
                                if (iVar2.getCategoryId() == 20 && !aXD.containsAll(arrayList)) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913228, true));
                                    aXD.addAll(arrayList);
                                }
                                imageView.setVisibility(0);
                            } else {
                                if (jSONArray2 == null) {
                                    jSONArray2 = new JSONArray();
                                }
                                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                                    jSONArray2.put(arrayList.get(i10));
                                }
                                SharedPrefHelper.getInstance().putString(this.aWH, jSONArray2.toString());
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
                    if (this.aXv != 0) {
                        gradientTextView.setGradientTextColor(this.aXv, this.aXv);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    ep(i);
                    this.aXc = i;
                    this.aWO.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bH(false);
                        } else {
                            bH(true);
                        }
                    } else {
                        bH(true);
                    }
                }
            }
        }
    }

    private void bH(boolean z) {
        int i = 8;
        if (this.aWT != null) {
            this.aWT.setVisibility(z ? this.aXr ? 8 : 0 : 8);
        }
        if (this.aWU != null) {
            TextView textView = this.aWU;
            if (!z && !this.aXr) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void ep(int i) {
        int childCount = this.aWP.getChildCount();
        if (i >= 0 && i < childCount && this.aWB != null && this.aWB.size() > i && this.aWB.get(i) != null) {
            this.aXj.get(i);
        }
    }

    public void x(int i, int i2) {
        this.aXm = i;
        this.aXn = i2;
    }

    public void ad(long j) {
        if (this.aWT != null) {
            if (j >= 100 && (this.aVo || com.baidu.live.x.a.OS().blo.aLc)) {
                this.aWT.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aWT.setText(String.valueOf(j));
        }
    }

    public void ae(long j) {
        if (this.aWU != null) {
            this.aWU.setText(String.valueOf(j));
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
        this.aXa = i;
        Hv();
        Hp();
        if (i >= 0 && i < this.aWX.size() && (this.aWX.get(i) instanceof ViewGroup)) {
            Hu();
            ViewGroup viewGroup = (ViewGroup) this.aWX.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aXb) {
                            aVar.ec(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aXb) {
                            aVar.ec(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        a(gridView);
                        this.aWR.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void a(final AbsListView absListView) {
        if (this.aXC != null) {
            this.aXC.cancel();
        }
        if (absListView != null) {
            absListView.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.live.gift.g gVar;
                    ArrayList arrayList = null;
                    int childCount = absListView.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = absListView.getChildAt(i);
                        if (childAt != null && (childAt.getTag() instanceof a.C0181a)) {
                            a.C0181a c0181a = (a.C0181a) childAt.getTag();
                            if (c0181a.aVB != null && (c0181a.aVB.getTag(a.g.TAG_GIFT_ITEM) instanceof com.baidu.live.gift.g) && (gVar = (com.baidu.live.gift.g) c0181a.aVB.getTag(a.g.TAG_GIFT_ITEM)) != null && gVar.aSx != null && gVar.aSx.enabled && gVar.aSx.aSB && !TextUtils.isEmpty(gVar.aSx.detailUrl)) {
                                String Fd = gVar.Fd();
                                if (!s.Ge().gC(Fd)) {
                                    s.Ge().gD(Fd);
                                    AlaGiftTabView.this.a(c0181a.aVB, !TextUtils.isEmpty(gVar.aSx.aSC) ? gVar.aSx.aSC : "长按查看规则");
                                    AnimatorSet a2 = AlaGiftTabView.this.a(absListView, c0181a);
                                    a2.playTogether(AlaGiftTabView.this.R(c0181a.aVw), AlaGiftTabView.this.S(c0181a.aVB));
                                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                                    arrayList2.add(a2);
                                    arrayList = arrayList2;
                                }
                            }
                        }
                    }
                    AlaGiftTabView.this.L(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-39424);
        gradientDrawable.setCornerRadius(textView.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet a(final AbsListView absListView, final a.C0181a c0181a) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                if (c0181a != null && c0181a.aVB != null) {
                    c0181a.aVB.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c0181a != null && c0181a.aVB != null) {
                    c0181a.aVB.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c0181a != null) {
                    c0181a.GX();
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
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.baidu.live.gift.container.a.a(), new a.C0182a(), new a.C0182a());
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
                if (view != null && (valueAnimator.getAnimatedValue() instanceof a.C0182a)) {
                    a.C0182a c0182a = (a.C0182a) valueAnimator.getAnimatedValue();
                    view.setScaleX(c0182a.scale);
                    view.setScaleY(c0182a.scale);
                    view.setAlpha(c0182a.alpha);
                }
            }
        });
        return ofObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(List<Animator> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aXC == null) {
                this.aXC = new AnimatorSet();
                this.aXC.setInterpolator(new LinearInterpolator());
            }
            this.aXC.playTogether(list);
            this.aXC.start();
        }
    }

    private void Hu() {
        JSONObject jSONObject = new JSONObject();
        com.baidu.live.data.g gVar = (com.baidu.live.data.g) ListUtils.getItem(this.aWC, this.aXc);
        if (gVar != null) {
            try {
                jSONObject.put("tabid", gVar.getCategoryId());
                jSONObject.put("tabname", gVar.getCategoryName());
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "giftpanel_show").setContentExt(null, "giftpanel", jSONObject));
    }

    private void Hv() {
        int i = 0;
        for (int i2 = 0; i2 < this.aXi.size(); i2++) {
            for (int i3 = 0; i3 < this.aXi.get(i2); i3++) {
                if (i + i3 == this.aXa) {
                    if (this.aXi.get(i2) <= 1) {
                        this.aWN.setVisibility(4);
                    } else {
                        this.aWN.setVisibility(0);
                    }
                    this.aWN.setCount(this.aXi.get(i2));
                    this.aWN.onPageSelected(i3);
                    eo(i2);
                    return;
                }
            }
            i += this.aXi.get(i2);
        }
    }

    public com.baidu.live.gift.g Hw() {
        return this.aXg;
    }

    public int Hx() {
        return this.aXh;
    }

    public void a(e eVar) {
        this.aWZ = eVar;
    }

    public void eq(int i) {
        this.aXh = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aXG);
        MessageManager.getInstance().registerListener(this.aXH);
        MessageManager.getInstance().registerListener(this.aXI);
        MessageManager.getInstance().registerListener(this.aXJ);
    }

    public void Hy() {
        if (!ListUtils.isEmpty(this.aWX)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aWX) {
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
    public void as(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.aWX) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aWX) {
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
    public void Hz() {
        if (!ListUtils.isEmpty(this.aWX)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aWX) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aVu);
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
    public void HA() {
        if (this.aXg != null && this.aXg.FC()) {
            this.aWK.setStyleEnabled(this.aVu);
            if (this.aVu) {
                this.aWW.setStyle(this.aXg.Fj() ? 2 : 1);
            } else {
                this.aWW.setStyle(this.aXg.Fj() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.aXu = null;
        MessageManager.getInstance().unRegisterListener(this.aXG);
        MessageManager.getInstance().unRegisterListener(this.aXH);
        MessageManager.getInstance().unRegisterListener(this.aXI);
        MessageManager.getInstance().unRegisterListener(this.aXJ);
        rE();
        if (this.aXs != null) {
            this.aXs.dismiss();
        }
        if (this.aXC != null) {
            this.aXC.cancel();
        }
    }

    public void bs(boolean z) {
        this.aVo = z;
    }

    public void er(int i) {
        this.aVm = i;
    }

    public void d(com.baidu.live.gift.g gVar) {
        this.aXg = gVar;
        if (this.aXg.Fd().equals("")) {
            BdUtilHelper.showToast(this.mContext.getPageActivity(), "该礼物已下线");
            return;
        }
        this.aXn = Integer.valueOf(this.aXg.Fd()).intValue();
        if (this.aXu != null) {
            this.aXu.a(gVar);
        }
        if (gVar != null && !gVar.Fl()) {
            this.aXw.GS();
        }
    }

    public void GR() {
        if (this.aXw != null) {
            this.aXw.GR();
        }
        com.baidu.live.gift.g gVar = this.aXg;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Fd());
                jSONObject.putOpt("gift_name", gVar.Fe());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "combosend_show").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
        }
    }

    public void GQ() {
        if (this.aXw != null) {
            this.aXw.GQ();
        }
        com.baidu.live.gift.g gVar = this.aXg;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Fd());
                jSONObject.putOpt("gift_name", gVar.Fe());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "click", "liveroom", "combosend_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
        }
    }

    public void bI(boolean z) {
        if (this.aWW != null) {
            this.aWW.setVisibility(z ? 0 : 4);
        }
    }
}

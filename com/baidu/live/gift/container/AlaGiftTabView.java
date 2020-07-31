package com.baidu.live.gift.container;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
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
import com.baidu.live.c.r;
import com.baidu.live.data.bc;
import com.baidu.live.data.q;
import com.baidu.live.data.s;
import com.baidu.live.gift.container.AlaComboBtnAnimView;
import com.baidu.live.gift.container.a;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
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
    private int aKK;
    private boolean aKM;
    private boolean aKT;
    public ArrayList<i> aLY;
    private ArrayList<com.baidu.live.data.f> aLZ;
    private boolean aMA;
    private boolean aMB;
    private int aMC;
    private g aMD;
    private int aME;
    private SparseIntArray aMF;
    private SparseBooleanArray aMG;
    private View.OnClickListener aMH;
    private boolean aMI;
    private int aMJ;
    private int aMK;
    private int aML;
    private SparseBooleanArray aMM;
    private Set<String> aMN;
    private boolean aMO;
    private BdAlertDialog aMP;
    private int aMQ;
    private a aMR;
    private int aMS;
    private AlaComboBtnAnimView aMT;
    private TbImageView aMU;
    private com.baidu.live.gift.container.d aMV;
    private boolean aMW;
    private boolean aMX;
    private boolean aMY;
    private View.OnClickListener aMZ;
    private ArrayList<com.baidu.live.data.g> aMa;
    private final String aMe;
    private boolean aMf;
    private View aMg;
    private GiftPanelNumRoundRectView aMh;
    public TextView aMi;
    private BaseViewPager aMj;
    private RoundRectPageIndicator aMk;
    private HorizontalScrollView aMl;
    private LinearLayout aMm;
    private CommonEmptyView aMn;
    private View aMo;
    private com.baidu.live.gift.container.c aMp;
    private TextView aMq;
    private TextView aMr;
    private TextView aMs;
    public GiftPanelOperationSendView aMt;
    private List<View> aMu;
    private ArrayList<List<g>> aMv;
    private d aMw;
    private int aMx;
    private int aMy;
    private int aMz;
    AdapterView.OnItemClickListener aNa;
    private CustomMessageListener aNb;
    private CustomMessageListener aNc;
    private CustomMessageListener aNd;
    private CustomMessageListener aNe;
    private int azq;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private ViewGroup mRoot;
    private int mSelectedPosition;
    private boolean mShowing;
    private int mType;
    private String otherParams;
    private String roomId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(g gVar);

        void ak(String str, String str2);

        void c(boolean z, int i);

        void e(boolean z, String str);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void AC();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aMe = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aMu = new ArrayList();
        this.aMx = 0;
        this.aMy = 0;
        this.mSelectedPosition = 0;
        this.aMz = 0;
        this.aMF = new SparseIntArray();
        this.aMG = new SparseBooleanArray();
        this.isLandscape = false;
        this.aMI = false;
        this.aMJ = -1;
        this.aMK = -1;
        this.aKM = false;
        this.aKK = -1;
        this.aMM = new SparseBooleanArray();
        this.aMN = new HashSet();
        this.aMW = false;
        this.aKT = false;
        this.aMX = false;
        this.aMY = false;
        this.aMZ = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aMT == null || !AlaGiftTabView.this.aMT.zU()) {
                    if (AlaGiftTabView.this.aMp == null) {
                        AlaGiftTabView.this.aMp = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aNa);
                    }
                    AlaGiftTabView.this.bv(true);
                    AlaGiftTabView.this.aMp.a(AlaGiftTabView.this.aMg, AlaGiftTabView.this.aMa, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bv(false);
                        }
                    });
                }
            }
        };
        this.aNa = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.aMp.dismiss();
                if (AlaGiftTabView.this.aMa != null && AlaGiftTabView.this.aMa.size() > 0) {
                    if (i != AlaGiftTabView.this.aMa.size()) {
                        com.baidu.live.data.g gVar = (com.baidu.live.data.g) AlaGiftTabView.this.aMa.get(i);
                        if (gVar != null) {
                            int number = gVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.aMD.aIc) != null) {
                                if (number == -1) {
                                    number = aVar.aIj;
                                }
                                if (number > AlaGiftTabView.this.aMQ) {
                                    number = AlaGiftTabView.this.aMQ;
                                }
                            }
                            AlaGiftTabView.this.fe(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.As();
                    return;
                }
                AlaGiftTabView.this.fe("1");
            }
        };
        this.aNb = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.aGF == 1 || cVar.aGF == 2 || cVar.aGF == 5 || cVar.aGF == 6) && cVar.aGG != null) {
                        AlaGiftTabView.this.am(cVar.aGG.getId(), cVar.aGG.getUrl());
                    }
                }
            }
        };
        this.aNc = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bq(true);
                if (AlaGiftTabView.this.aMD != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aMD) && AlaGiftTabView.this.aMf) {
                    AlaGiftTabView.this.aMt.setStyle(AlaGiftTabView.this.aMD.yu() ? 2 : 1);
                    AlaGiftTabView.this.aMh.setStyleEnabled(true);
                }
            }
        };
        this.aNd = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                q qVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof q) && (qVar = (q) customResponsedMessage.getData()) != null && qVar.ayV != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = qVar.ayV.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aKT != z2) {
                        AlaGiftTabView.this.aKT = z2;
                        AlaGiftTabView.this.AB();
                        AlaGiftTabView.this.AA();
                    }
                }
            }
        };
        this.aNe = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.Ar();
                    AlaGiftTabView.this.aMt.setStyle(AlaGiftTabView.this.aMD.yu() ? 4 : 3);
                    AlaGiftTabView.this.aMh.setStyleEnabled(false);
                    if (AlaGiftTabView.this.aMR != null) {
                        AlaGiftTabView.this.aMR.e(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aMH = onClickListener;
        this.aMI = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aMC = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        this.aMv = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aMQ = 9999;
                return;
            case 1:
                this.aMQ = 999;
                return;
            default:
                return;
        }
    }

    public void cl(int i) {
        int childCount;
        this.aMS = i;
        if (this.aMm != null && (childCount = this.aMm.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aMz) {
                    ((GradientTextView) ((ViewGroup) this.aMm.getChildAt(i2)).findViewById(a.g.text_view)).setGradientTextColor(this.aMS, this.aMS);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aMR = aVar;
    }

    public void al(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bp(boolean z) {
        this.mShowing = z;
    }

    public void onVisibilityChanged(boolean z) {
        bp(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        this.aMg = this.mRoot.findViewById(a.g.gift_count_layout);
        this.aMg.setOnClickListener(this.aMZ);
        this.aMh = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.aMi = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.aMi.setText("1");
        this.aMi.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.aMj = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.aMj.setOnPageChangeListener(this);
        this.aMk = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.aMm = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.aMl = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.aMI) {
            this.aMl.setVisibility(8);
        }
        this.aMq = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.aMq.setOnClickListener(this.aMH);
        this.aMr = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.aMr.setOnClickListener(this.aMH);
        this.aMt = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.aMs = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.aMs.setOnClickListener(this.aMH);
        this.aMt.setOnClickListener(this.aMH);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.aMn = new CommonEmptyView(this.mContext.getPageActivity());
        this.aMn.setVisibility(8);
        this.aMn.addToParent(frameLayout);
        this.aMo = this.mRoot.findViewById(a.g.donate_layout);
        this.aMT = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.aMT.setComboClickListener(this.aMH);
        this.aMT.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void zV() {
                AlaGiftTabView.this.by(true);
            }
        });
        this.aMU = (TbImageView) this.mRoot.findViewById(a.g.iv_official);
    }

    public void Ap() {
        this.aMO = true;
        this.aMq.setVisibility(8);
        this.aMr.setVisibility(8);
        this.aMs.setVisibility(8);
    }

    public void bq(boolean z) {
        this.aMf = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.v.a.Hs().Hv() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aMs.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aMN.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aMN.add(str);
            }
        }
    }

    public void aR(boolean z) {
    }

    public void bL(int i) {
        this.aML = i;
    }

    public void br(boolean z) {
        this.aMX = z;
        if (z && !ListUtils.isEmpty(this.aLZ)) {
            Av();
            this.aMY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar) {
        if (sVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_pop_show"));
            if (this.aMV == null) {
                this.aMV = new com.baidu.live.gift.container.d(this.mContext);
            }
            this.aMV.m(sVar.dialogTitle, sVar.azk + sVar.azl, sVar.azl);
        }
    }

    private void Q(View view) {
        if (this.aMV == null) {
            this.aMV = new com.baidu.live.gift.container.d(this.mContext);
        }
        this.aMV.O(view);
    }

    public void bs(boolean z) {
        this.aMW = z;
    }

    public void cm(int i) {
        this.azq = i;
    }

    public void aT(boolean z) {
        this.aKT = z;
    }

    public void bt(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.aMj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24);
                this.aMj.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        private int mPosition;

        public c(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaGiftTabView.this.cn(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(int i) {
        if (this.aMR != null) {
            this.aMR.c(false, this.aMQ);
        }
        co(i);
        this.aMj.setCurrentItem(this.aMx);
        Aw();
        Aq();
    }

    private void co(int i) {
        int min = Math.min(i, this.aMF.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aMF.get(i3);
        }
        this.aMx = i2;
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.aMy = AlaGiftTabView.this.aMx;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void Aq() {
        if (this.aMR != null) {
            if (this.aMD != null && this.aMD.aId) {
                this.aMR.ak(this.aMD.aIe, this.aMD.aIf);
            } else {
                this.aMR.ak(null, null);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.aMR != null) {
            this.aMR.c(false, this.aMQ);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.ce(i);
                aVar.notifyDataSetChanged();
                this.aMo.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                fe("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aMD.yK()) {
                        this.aMt.setStyle(this.aMD.yu() ? 4 : 3);
                        this.aMh.setStyleEnabled(false);
                        if (this.aMR != null) {
                            this.aMR.e(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aMD.yx()) && this.mShowing) {
                            this.mContext.showToast(this.aMD.yx());
                            return;
                        }
                        return;
                    }
                    Aq();
                    this.aMt.setEnabled(true);
                    if (this.aMD.yN()) {
                        if (this.aMR != null) {
                            this.aMR.e(false, null);
                        }
                        if (this.aMD.yJ() == 6 && this.aKK < 3) {
                            i3 = 3;
                        } else if (this.aMD.yJ() == 7 && this.aKK < 7) {
                            i3 = 7;
                        } else if (this.aMD.yJ() == 8 && this.aKK < 13) {
                            i3 = 13;
                        } else if (this.aMD.yJ() == 9 && this.aKK < 22) {
                            i3 = 22;
                        } else if (this.aMD.yJ() == 10 && this.aKK < 29) {
                            i3 = 29;
                        } else if (this.aMD.yJ() == 11 && this.aKK < 39) {
                            i3 = 39;
                        } else if (this.aMD.yJ() == 12 && this.aKK < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.aMt.setStyle(this.aMD.yu() ? 2 : 1);
                    } else {
                        this.aMt.setStyle(this.aMD.yu() ? 4 : 3);
                    }
                    this.aMh.setStyleEnabled(z);
                    AB();
                    i2 = i3;
                } else {
                    this.aMt.setStyle(this.aMD.yu() ? 2 : 1);
                    if (this.aMD.aIc != null && this.aMD.aIc.aIi != null && this.aMD.aIc.aIi.equals("20")) {
                        this.aMt.setText("使用");
                    } else {
                        this.aMt.setText("赠送");
                    }
                    this.aMh.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aMD.yv()) {
                    bu(true);
                } else {
                    bu(false);
                    fe("1");
                }
                d(false, i2);
                return;
            }
            this.aMt.setStyle(3);
            return;
        }
        this.aMt.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.a aVar;
        if (this.mShowing && this.aMD != null) {
            if (this.mType == 0) {
                if (this.aMD.yM() && !this.aKT) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aMD.yx()) && this.aMD.yK() && !z) {
                    this.mContext.showToast(this.aMD.yx());
                } else if (this.aMD.yN() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aMD.yI()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (aVar = this.aMD.aIc) != null && !TextUtils.isEmpty(aVar.aIl)) {
                this.mContext.showToast(aVar.aIl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.v.a.Hs().beo != null && com.baidu.live.v.a.Hs().beo.aEn != null) {
            String str = com.baidu.live.v.a.Hs().beo.aEn.aDz;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.yJ()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ar() {
        if (!this.aMB) {
            this.aMP = new BdAlertDialog(this.mContext.getPageActivity());
            this.aMP.setCancelable(false);
            this.aMP.setCanceledOnTouchOutside(false);
            this.aMP.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.aMP.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aML)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aMP.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.aMP.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aMP.setPositiveButtonTextColor(-57754);
                this.aMP.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aMP.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aMB = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aMP.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aMB = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aMP.create(this.mContext).show();
            this.aMB = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.v.a.Hs().aZn.aAB;
        if (z2) {
            this.aMg.setVisibility(4);
            this.aMt.setStyle(1);
        } else {
            View view = this.aMg;
            if (this.aMD == null || !this.aMD.yu()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.aMR != null) {
            this.aMR.e(z2, this.aMD != null ? this.aMD.getThumbnail_url() : null);
        }
    }

    public void As() {
        if (this.aMR != null) {
            this.aMR.c(true, this.aMQ);
        }
    }

    @Override // com.baidu.live.view.input.b.a
    public void fb(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        fe(str);
    }

    public void fe(String str) {
        this.aMi.setText(str);
        this.aMi.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        bv(false);
        if (this.aMD != null && this.aMD.yu()) {
            this.aMg.setVisibility(0);
            this.aME = JavaTypesHelper.toInt(this.aMi.getText().toString(), 1);
            return;
        }
        this.aMg.setVisibility(4);
        this.aME = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(boolean z) {
        this.aMi.setGravity(17);
        if (z) {
            this.aMi.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aMi.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<com.baidu.live.data.g> arrayList3, boolean z2, int i) {
        if (this.aLY == null || this.aLY.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            if (this.aLY == null) {
                this.aLY = new ArrayList<>();
            }
            this.aLY.clear();
            if (arrayList != null) {
                this.aLY.addAll(arrayList);
            }
            this.aLZ = arrayList2;
            this.aMa = arrayList3;
            this.aMA = false;
            if (this.aLZ == null || this.aLZ.isEmpty()) {
                this.aMl.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void z(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aMu != null) {
            for (View view : this.aMu) {
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
                                ((com.baidu.live.gift.container.a) ((GridView) childAt).getAdapter()).z(str, i);
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
        At();
        if (this.aLY == null || this.aLY.size() <= 0 || !z2) {
            qa();
            if (this.aMk != null) {
                this.aMk.setVisibility(4);
            }
            this.aMo.setVisibility(4);
            this.aMn.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.aMn.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aMn.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.aMn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.v.a.Hs().aZn.aCb && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aMn.setTitle(string);
            this.aMn.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aMw != null) {
                        AlaGiftTabView.this.aMw.AC();
                    }
                }
            });
            this.aMn.setVisibility(0);
            return;
        }
        this.aMn.setVisibility(8);
        if (z) {
            h(this.aLZ);
        }
        bc bcVar = com.baidu.live.v.a.Hs().beo;
        if (this.mType == 0 && bcVar != null && bcVar.aEr != null && bcVar.aEr.aGi && !this.aMW && this.aLY.get(0) != null && this.aLY.get(0).yO() != null) {
            List<g> yO = this.aLY.get(0).yO();
            if (yO.size() <= 1 || yO.get(1) == null) {
                z3 = true;
            } else {
                z3 = !yO.get(1).isRed();
            }
            if (!yO.isEmpty() && z3) {
                g gVar = new g();
                gVar.bd(true);
                gVar.setGiftName("发红包");
                yO.add(1, gVar);
            }
        }
        c(this.aLY, z);
        fe("1");
    }

    private void qa() {
        this.aMx = 0;
        this.aMy = 0;
        this.mSelectedPosition = 0;
        this.aMz = 0;
        if (this.aMF != null) {
            this.aMF.clear();
        }
        if (this.aMu != null) {
            this.aMu.clear();
        }
        if (this.aMj != null) {
            this.aMj.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.yN()) {
            if (gVar.yJ() == 6 && this.aKK < 3) {
                return false;
            }
            if (gVar.yJ() == 7 && this.aKK < 7) {
                return false;
            }
            if (gVar.yJ() == 8 && this.aKK < 13) {
                return false;
            }
            if (gVar.yJ() == 9 && this.aKK < 22) {
                return false;
            }
            if (gVar.yJ() == 10 && this.aKK < 29) {
                return false;
            }
            if (gVar.yJ() == 11 && this.aKK < 39) {
                return false;
            }
            if (gVar.yJ() == 12 && this.aKK < 47) {
                return false;
            }
        }
        if (gVar.yM()) {
            return this.aKT;
        }
        return true;
    }

    public void b(final s sVar) {
        if (sVar == null || TextUtils.isEmpty(sVar.iconUrl)) {
            this.aMU.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_show"));
            this.aMU.setVisibility(0);
            this.aMU.startLoad(sVar.iconUrl, 10, false);
            this.aMU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_clk"));
                    AlaGiftTabView.this.a(sVar);
                }
            });
            String str = "key_live_official_tip" + currentAccount;
            if (com.baidu.live.c.vf().getInt(str, 0) == 0 && this.aMX) {
                Q(this.aMU);
                com.baidu.live.c.vf().putInt(str, 1);
            }
        }
    }

    private void At() {
        if (ListUtils.getCount(this.aLZ) != 0 && ListUtils.getCount(this.aLY) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.f> it = this.aLZ.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.f next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.wW()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.aLY.iterator();
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
                Iterator<i> it3 = this.aLY.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().yO().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.yv()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aLZ.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aLY.removeAll(arrayList2);
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
        List<g> yO;
        if (arrayList != null) {
            this.aMF.clear();
            this.aMu.clear();
            this.aMj.setAdapter(null);
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
                    if (iVar == null || (yO = iVar.yO()) == null || yO.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aMv.clear();
            F(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aMu.add(cp(i7));
                    this.aMF.append(i7, 1);
                } else {
                    i iVar2 = arrayList.get(i7);
                    iVar2.getCategoryId();
                    List<g> yO2 = iVar2.yO();
                    if (yO2 == null) {
                        i = 0;
                    } else {
                        i = yO2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aMG.get(i7)) {
                            this.aMu.add(bw(true));
                        } else {
                            this.aMu.add(b(arrayList3, -1, i7));
                        }
                    } else if (yO2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(yO2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(yO2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(yO2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aMv.add(arrayList2);
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
                                    if (gVar == null || gVar.yo() == null || !gVar.yo().equals(String.valueOf(this.aMK))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aMu.add(b(arrayList2, i3, i7));
                                this.aMt.removeCallbacks(null);
                                this.aMt.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aMD != null) {
                                            boolean yv = AlaGiftTabView.this.aMD.yv();
                                            AlaGiftTabView.this.bu(yv);
                                            if (!yv) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aMD);
                                                if (!c2) {
                                                    AlaGiftTabView.this.aMt.setStyle(AlaGiftTabView.this.aMD.yu() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.aMt.setStyle(AlaGiftTabView.this.aMD.yu() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.aMh.setStyleEnabled(c2);
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
                                        g gVar2 = arrayList2.get(i2);
                                        if (gVar2 == null || !gVar2.yo().equals(String.valueOf(this.aMK))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aMu.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aMu.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.aMF.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aMj.setAdapter(new AlaGiftPagerAdapter(this.aMu));
            Au();
            this.aMj.setCurrentItem(this.aMx);
            Aw();
            if (z && !this.aMY && this.aMX) {
                this.aMY = true;
                Av();
            }
        }
    }

    private void Au() {
        int i = 0;
        if (this.aMK > 0 && !ListUtils.isEmpty(this.aMv)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aMv.size() && !z; i2++) {
                Iterator<g> it = this.aMv.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.yo() != null && next.yo().equals(String.valueOf(this.aMK))) {
                        this.aMx = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.azq == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.aMy = this.aMx;
            this.aMv.clear();
        } else if (this.aMJ > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aLZ.size()) {
                    break;
                }
                com.baidu.live.data.f fVar = this.aLZ.get(i3);
                if (fVar == null || this.aMJ != fVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    co(i3);
                    break;
                }
            }
            this.aMy = this.aMx;
        }
    }

    private void F(List<i> list) {
        if (list != null && this.aMJ > 0 && this.aMK <= 0) {
            for (i iVar : list) {
                if (iVar.getCategoryId() == this.aMJ) {
                    List<g> yO = iVar.yO();
                    if (yO != null && !yO.isEmpty() && yO.get(0) != null) {
                        this.aMK = Integer.valueOf(yO.get(0).yo()).intValue();
                        return;
                    }
                    return;
                }
            }
        }
    }

    private View bw(boolean z) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext.getPageActivity());
        commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        } else {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aMw != null) {
                    AlaGiftTabView.this.aMw.AC();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.bi(this.aKM);
        aVar.setGiftItems(list);
        aVar.cd(this.aKK);
        aVar.aT(this.aKT);
        aVar.ce(i);
        if (this.isLandscape) {
            if (this.aMj.getHeight() > 0) {
                aVar.cf(this.aMj.getHeight() / 3);
            } else {
                this.aMj.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.cf(AlaGiftTabView.this.aMj.getHeight() / 3);
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
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0164a) {
                    ((a.C0164a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout cp(int i) {
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
    private void h(ArrayList<com.baidu.live.data.f> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.aMI) {
                this.aMl.setVisibility(0);
            }
            this.aMm.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.f fVar = arrayList.get(i);
                if (!TextUtils.isEmpty(fVar.getCategoryName()) && (this.mType != 0 || (fVar.wW() != null && fVar.wW().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(fVar.getCategoryName());
                    viewGroup.setOnClickListener(new c(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aMC;
                    }
                    if (this.aLY.size() > i && this.aLY.get(i) != null) {
                        for (g gVar : this.aLY.get(i).yO()) {
                            if (gVar != null && gVar.yt() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aMm.addView(viewGroup, layoutParams);
                }
            }
            cq(this.aMz);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ac  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cq(int i) {
        int i2;
        JSONArray jSONArray;
        JSONException e;
        List<g> yO;
        int childCount = this.aMm.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aMz != i || !this.aMA) && this.aLZ.size() > i && this.aLZ.get(i) != null) {
                int min = Math.min(i, this.aMF.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aMF.get(i4);
                }
                if (this.aMu.size() > i3 && this.aLY.size() > i && (this.aMu.get(i3) instanceof ViewGroup)) {
                    this.aMy = i3;
                    i iVar = this.aLY.get(i);
                    if (iVar != null && iVar.yO() != null && !iVar.yO().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aMu.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aMA) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aMx) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.mShowing) {
                                        this.aMA = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aLZ.size() > i && this.aLZ.get(i) != null) {
                int categoryId = this.aLZ.get(i).getCategoryId();
                if (!this.aMM.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aMM.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aMm.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.aLY.get(i6);
                if (iVar2.yP()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aMe, "");
                    if (TextUtils.isEmpty(string)) {
                        jSONArray = null;
                    } else {
                        try {
                            jSONArray = new JSONArray(string);
                            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                                try {
                                    hashSet.add(jSONArray.optString(i7));
                                } catch (JSONException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    yO = iVar2.yO();
                                    if (yO != null) {
                                    }
                                    if (i6 == i) {
                                    }
                                    if (i6 == i) {
                                    }
                                }
                            }
                        } catch (JSONException e3) {
                            jSONArray = null;
                            e = e3;
                        }
                    }
                    yO = iVar2.yO();
                    if (yO != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= yO.size()) {
                                break;
                            }
                            g gVar = yO.get(i9);
                            if (!gVar.yK() && !hashSet.contains(gVar.yo())) {
                                arrayList.add(gVar.yo());
                            }
                            i8 = i9 + 1;
                        }
                        if (!arrayList.isEmpty()) {
                            if (i6 != i) {
                                imageView.setVisibility(0);
                            } else {
                                if (jSONArray == null) {
                                    jSONArray = new JSONArray();
                                }
                                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                                    jSONArray.put(arrayList.get(i10));
                                }
                                SharedPrefHelper.getInstance().putString(this.aMe, jSONArray.toString());
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
                    if (this.aMS != 0) {
                        gradientTextView.setGradientTextColor(this.aMS, this.aMS);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    cr(i);
                    this.aMz = i;
                    this.aMl.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bx(false);
                        } else {
                            bx(true);
                        }
                    } else {
                        bx(true);
                    }
                }
            }
        }
    }

    private void bx(boolean z) {
        int i = 8;
        if (this.aMq != null) {
            this.aMq.setVisibility(z ? this.aMO ? 8 : 0 : 8);
        }
        if (this.aMr != null) {
            TextView textView = this.aMr;
            if (!z && !this.aMO) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void cr(int i) {
        int childCount = this.aMm.getChildCount();
        if (i >= 0 && i < childCount && this.aLY != null && this.aLY.size() > i && this.aLY.get(i) != null) {
            this.aMG.get(i);
        }
    }

    public void u(int i, int i2) {
        this.aMJ = i;
        this.aMK = i2;
    }

    public void ab(long j) {
        if (this.aMq != null) {
            if (j >= 100 && (this.aKM || com.baidu.live.v.a.Hs().aZn.aBx)) {
                this.aMq.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aMq.setText(String.valueOf(j));
        }
    }

    public void ac(long j) {
        if (this.aMr != null) {
            this.aMr.setText(String.valueOf(j));
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
        this.aMx = i;
        Aw();
        Aq();
        if (i >= 0 && i < this.aMu.size() && (this.aMu.get(i) instanceof ViewGroup)) {
            Av();
            ViewGroup viewGroup = (ViewGroup) this.aMu.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aMy) {
                            aVar.ce(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aMy) {
                            aVar.ce(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.aMo.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void Av() {
        JSONObject jSONObject = new JSONObject();
        com.baidu.live.data.f fVar = (com.baidu.live.data.f) ListUtils.getItem(this.aLZ, this.aMz);
        if (fVar != null) {
            try {
                jSONObject.put("tabid", fVar.getCategoryId());
                jSONObject.put("tabname", fVar.getCategoryName());
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "giftpanel_show").setContentExt(null, "giftpanel", jSONObject));
    }

    private void Aw() {
        int i = 0;
        for (int i2 = 0; i2 < this.aMF.size(); i2++) {
            for (int i3 = 0; i3 < this.aMF.get(i2); i3++) {
                if (i + i3 == this.aMx) {
                    if (this.aMF.get(i2) <= 1) {
                        this.aMk.setVisibility(4);
                    } else {
                        this.aMk.setVisibility(0);
                    }
                    this.aMk.setCount(this.aMF.get(i2));
                    this.aMk.onPageSelected(i3);
                    cq(i2);
                    return;
                }
            }
            i += this.aMF.get(i2);
        }
    }

    public g Ax() {
        return this.aMD;
    }

    public int Ay() {
        return this.aME;
    }

    public void a(d dVar) {
        this.aMw = dVar;
    }

    public void cs(int i) {
        this.aME = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aNb);
        MessageManager.getInstance().registerListener(this.aNc);
        MessageManager.getInstance().registerListener(this.aNd);
        MessageManager.getInstance().registerListener(this.aNe);
    }

    public void Az() {
        if (!ListUtils.isEmpty(this.aMu)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aMu) {
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
    public void am(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.aMu) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aMu) {
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
    public void AA() {
        if (!ListUtils.isEmpty(this.aMu)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aMu) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aKT);
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
    public void AB() {
        if (this.aMD != null && this.aMD.yM()) {
            this.aMh.setStyleEnabled(this.aKT);
            if (this.aKT) {
                this.aMt.setStyle(this.aMD.yu() ? 2 : 1);
            } else {
                this.aMt.setStyle(this.aMD.yu() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.aMR = null;
        MessageManager.getInstance().unRegisterListener(this.aNb);
        MessageManager.getInstance().unRegisterListener(this.aNc);
        MessageManager.getInstance().unRegisterListener(this.aNd);
        MessageManager.getInstance().unRegisterListener(this.aNe);
        qa();
        if (this.aMP != null) {
            this.aMP.dismiss();
        }
    }

    public void bi(boolean z) {
        this.aKM = z;
    }

    public void ct(int i) {
        this.aKK = i;
    }

    public void d(g gVar) {
        this.aMD = gVar;
        this.aMK = Integer.valueOf(this.aMD.yo()).intValue();
        if (this.aMR != null) {
            this.aMR.a(gVar);
        }
        if (gVar != null && !gVar.yw()) {
            this.aMT.zT();
        }
    }

    public void zS() {
        if (this.aMT != null) {
            this.aMT.zS();
        }
    }

    public void zR() {
        if (this.aMT != null) {
            this.aMT.zR();
        }
    }

    public void by(boolean z) {
        if (this.aMt != null) {
            this.aMt.setVisibility(z ? 0 : 4);
        }
    }
}

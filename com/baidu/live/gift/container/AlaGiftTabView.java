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
import com.baidu.live.data.bb;
import com.baidu.live.data.g;
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
/* loaded from: classes3.dex */
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, b.a {
    private int aJo;
    private boolean aJq;
    private boolean aJx;
    public ArrayList<i> aKC;
    private ArrayList<com.baidu.live.data.f> aKD;
    private ArrayList<g> aKE;
    private final String aKI;
    private boolean aKJ;
    private View aKK;
    private GiftPanelNumRoundRectView aKL;
    public TextView aKM;
    private BaseViewPager aKN;
    private RoundRectPageIndicator aKO;
    private HorizontalScrollView aKP;
    private LinearLayout aKQ;
    private CommonEmptyView aKR;
    private View aKS;
    private com.baidu.live.gift.container.c aKT;
    private TextView aKU;
    private TextView aKV;
    private TextView aKW;
    public GiftPanelOperationSendView aKX;
    private List<View> aKY;
    private ArrayList<List<com.baidu.live.gift.g>> aKZ;
    private boolean aLA;
    private boolean aLB;
    private boolean aLC;
    private View.OnClickListener aLD;
    AdapterView.OnItemClickListener aLE;
    private CustomMessageListener aLF;
    private CustomMessageListener aLG;
    private CustomMessageListener aLH;
    private CustomMessageListener aLI;
    private d aLa;
    private int aLb;
    private int aLc;
    private int aLd;
    private boolean aLe;
    private boolean aLf;
    private int aLg;
    private com.baidu.live.gift.g aLh;
    private int aLi;
    private SparseIntArray aLj;
    private SparseBooleanArray aLk;
    private View.OnClickListener aLl;
    private boolean aLm;
    private int aLn;
    private int aLo;
    private int aLp;
    private SparseBooleanArray aLq;
    private Set<String> aLr;
    private boolean aLs;
    private BdAlertDialog aLt;
    private int aLu;
    private a aLv;
    private int aLw;
    private AlaComboBtnAnimView aLx;
    private TbImageView aLy;
    private com.baidu.live.gift.container.d aLz;
    private int ayd;
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
    public interface a {
        void a(com.baidu.live.gift.g gVar);

        void al(String str, String str2);

        void c(boolean z, int i);

        void e(boolean z, String str);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void Aa();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aKI = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aKY = new ArrayList();
        this.aLb = 0;
        this.aLc = 0;
        this.mSelectedPosition = 0;
        this.aLd = 0;
        this.aLj = new SparseIntArray();
        this.aLk = new SparseBooleanArray();
        this.isLandscape = false;
        this.aLm = false;
        this.aLn = -1;
        this.aLo = -1;
        this.aJq = false;
        this.aJo = -1;
        this.aLq = new SparseBooleanArray();
        this.aLr = new HashSet();
        this.aLA = false;
        this.aJx = false;
        this.aLB = false;
        this.aLC = false;
        this.aLD = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aLx == null || !AlaGiftTabView.this.aLx.zs()) {
                    if (AlaGiftTabView.this.aKT == null) {
                        AlaGiftTabView.this.aKT = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aLE);
                    }
                    AlaGiftTabView.this.bs(true);
                    AlaGiftTabView.this.aKT.a(AlaGiftTabView.this.aKK, AlaGiftTabView.this.aKE, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bs(false);
                        }
                    });
                }
            }
        };
        this.aLE = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.aKT.dismiss();
                if (AlaGiftTabView.this.aKE != null && AlaGiftTabView.this.aKE.size() > 0) {
                    if (i != AlaGiftTabView.this.aKE.size()) {
                        com.baidu.live.data.g gVar = (com.baidu.live.data.g) AlaGiftTabView.this.aKE.get(i);
                        if (gVar != null) {
                            int number = gVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.aLh.aGH) != null) {
                                if (number == -1) {
                                    number = aVar.aGO;
                                }
                                if (number > AlaGiftTabView.this.aLu) {
                                    number = AlaGiftTabView.this.aLu;
                                }
                            }
                            AlaGiftTabView.this.ff(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.zQ();
                    return;
                }
                AlaGiftTabView.this.ff("1");
            }
        };
        this.aLF = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.aFk == 1 || cVar.aFk == 2 || cVar.aFk == 5 || cVar.aFk == 6) && cVar.aFl != null) {
                        AlaGiftTabView.this.an(cVar.aFl.getId(), cVar.aFl.getUrl());
                    }
                }
            }
        };
        this.aLG = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bn(true);
                if (AlaGiftTabView.this.aLh != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aLh) && AlaGiftTabView.this.aKJ) {
                    AlaGiftTabView.this.aKX.setStyle(AlaGiftTabView.this.aLh.xS() ? 2 : 1);
                    AlaGiftTabView.this.aKL.setStyleEnabled(true);
                }
            }
        };
        this.aLH = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                q qVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof q) && (qVar = (q) customResponsedMessage.getData()) != null && qVar.axI != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = qVar.axI.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aJx != z2) {
                        AlaGiftTabView.this.aJx = z2;
                        AlaGiftTabView.this.zZ();
                        AlaGiftTabView.this.zY();
                    }
                }
            }
        };
        this.aLI = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.zP();
                    AlaGiftTabView.this.aKX.setStyle(AlaGiftTabView.this.aLh.xS() ? 4 : 3);
                    AlaGiftTabView.this.aKL.setStyleEnabled(false);
                    if (AlaGiftTabView.this.aLv != null) {
                        AlaGiftTabView.this.aLv.e(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aLl = onClickListener;
        this.aLm = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aLg = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        this.aKZ = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aLu = 9999;
                return;
            case 1:
                this.aLu = 999;
                return;
            default:
                return;
        }
    }

    public void cf(int i) {
        int childCount;
        this.aLw = i;
        if (this.aKQ != null && (childCount = this.aKQ.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aLd) {
                    ((GradientTextView) ((ViewGroup) this.aKQ.getChildAt(i2)).findViewById(a.g.text_view)).setGradientTextColor(this.aLw, this.aLw);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aLv = aVar;
    }

    public void am(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bm(boolean z) {
        this.mShowing = z;
    }

    public void onVisibilityChanged(boolean z) {
        bm(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        this.aKK = this.mRoot.findViewById(a.g.gift_count_layout);
        this.aKK.setOnClickListener(this.aLD);
        this.aKL = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.aKM = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.aKM.setText("1");
        this.aKM.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.aKN = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.aKN.setOnPageChangeListener(this);
        this.aKO = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.aKQ = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.aKP = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.aLm) {
            this.aKP.setVisibility(8);
        }
        this.aKU = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.aKU.setOnClickListener(this.aLl);
        this.aKV = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.aKV.setOnClickListener(this.aLl);
        this.aKX = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.aKW = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.aKW.setOnClickListener(this.aLl);
        this.aKX.setOnClickListener(this.aLl);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.aKR = new CommonEmptyView(this.mContext.getPageActivity());
        this.aKR.setVisibility(8);
        this.aKR.addToParent(frameLayout);
        this.aKS = this.mRoot.findViewById(a.g.donate_layout);
        this.aLx = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.aLx.setComboClickListener(this.aLl);
        this.aLx.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void zt() {
                AlaGiftTabView.this.bv(true);
            }
        });
        this.aLy = (TbImageView) this.mRoot.findViewById(a.g.iv_official);
    }

    public void zN() {
        this.aLs = true;
        this.aKU.setVisibility(8);
        this.aKV.setVisibility(8);
        this.aKW.setVisibility(8);
    }

    public void bn(boolean z) {
        this.aKJ = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.v.a.Hm().Hp() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aKW.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aLr.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aLr.add(str);
            }
        }
    }

    public void aP(boolean z) {
    }

    public void bJ(int i) {
        this.aLp = i;
    }

    public void bo(boolean z) {
        this.aLB = z;
        if (z && !ListUtils.isEmpty(this.aKD)) {
            zT();
            this.aLC = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar) {
        if (sVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_pop_show"));
            if (this.aLz == null) {
                this.aLz = new com.baidu.live.gift.container.d(this.mContext);
            }
            this.aLz.m(sVar.dialogTitle, sVar.axX + sVar.axY, sVar.axY);
        }
    }

    private void N(View view) {
        if (this.aLz == null) {
            this.aLz = new com.baidu.live.gift.container.d(this.mContext);
        }
        this.aLz.L(view);
    }

    public void bp(boolean z) {
        this.aLA = z;
    }

    public void cg(int i) {
        this.ayd = i;
    }

    public void aR(boolean z) {
        this.aJx = z;
    }

    public void bq(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.aKN.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24);
                this.aKN.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        private int mPosition;

        public c(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaGiftTabView.this.ch(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(int i) {
        if (this.aLv != null) {
            this.aLv.c(false, this.aLu);
        }
        ci(i);
        this.aKN.setCurrentItem(this.aLb);
        zU();
        zO();
    }

    private void ci(int i) {
        int min = Math.min(i, this.aLj.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aLj.get(i3);
        }
        this.aLb = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.baidu.live.gift.g item = ((com.baidu.live.gift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.isRed()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.q(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.aLc = AlaGiftTabView.this.aLb;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void zO() {
        if (this.aLv != null) {
            if (this.aLh != null && this.aLh.aGI) {
                this.aLv.al(this.aLh.aGJ, this.aLh.aGK);
            } else {
                this.aLv.al(null, null);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.aLv != null) {
            this.aLv.c(false, this.aLu);
        }
        if (aVar != null) {
            com.baidu.live.gift.g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.bY(i);
                aVar.notifyDataSetChanged();
                this.aKS.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                ff("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aLh.yi()) {
                        this.aKX.setStyle(this.aLh.xS() ? 4 : 3);
                        this.aKL.setStyleEnabled(false);
                        if (this.aLv != null) {
                            this.aLv.e(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aLh.xV()) && this.mShowing) {
                            this.mContext.showToast(this.aLh.xV());
                            return;
                        }
                        return;
                    }
                    zO();
                    this.aKX.setEnabled(true);
                    if (this.aLh.yl()) {
                        if (this.aLv != null) {
                            this.aLv.e(false, null);
                        }
                        if (this.aLh.yh() == 6 && this.aJo < 3) {
                            i3 = 3;
                        } else if (this.aLh.yh() == 7 && this.aJo < 7) {
                            i3 = 7;
                        } else if (this.aLh.yh() == 8 && this.aJo < 13) {
                            i3 = 13;
                        } else if (this.aLh.yh() == 9 && this.aJo < 22) {
                            i3 = 22;
                        } else if (this.aLh.yh() == 10 && this.aJo < 29) {
                            i3 = 29;
                        } else if (this.aLh.yh() == 11 && this.aJo < 39) {
                            i3 = 39;
                        } else if (this.aLh.yh() == 12 && this.aJo < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.aKX.setStyle(this.aLh.xS() ? 2 : 1);
                    } else {
                        this.aKX.setStyle(this.aLh.xS() ? 4 : 3);
                    }
                    this.aKL.setStyleEnabled(z);
                    zZ();
                    i2 = i3;
                } else {
                    this.aKX.setStyle(this.aLh.xS() ? 2 : 1);
                    if (this.aLh.aGH != null && this.aLh.aGH.aGN != null && this.aLh.aGH.aGN.equals("20")) {
                        this.aKX.setText("使用");
                    } else {
                        this.aKX.setText("赠送");
                    }
                    this.aKL.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aLh.xT()) {
                    br(true);
                } else {
                    br(false);
                    ff("1");
                }
                d(false, i2);
                return;
            }
            this.aKX.setStyle(3);
            return;
        }
        this.aKX.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.a aVar;
        if (this.mShowing && this.aLh != null) {
            if (this.mType == 0) {
                if (this.aLh.yk() && !this.aJx) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aLh.xV()) && this.aLh.yi() && !z) {
                    this.mContext.showToast(this.aLh.xV());
                } else if (this.aLh.yl() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aLh.yg()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (aVar = this.aLh.aGH) != null && !TextUtils.isEmpty(aVar.aGQ)) {
                this.mContext.showToast(aVar.aGQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.baidu.live.gift.g gVar) {
        if (com.baidu.live.v.a.Hm().bdV != null && com.baidu.live.v.a.Hm().bdV.aCS != null) {
            String str = com.baidu.live.v.a.Hm().bdV.aCS.aCe;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.yh()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zP() {
        if (!this.aLf) {
            this.aLt = new BdAlertDialog(this.mContext.getPageActivity());
            this.aLt.setCancelable(false);
            this.aLt.setCanceledOnTouchOutside(false);
            this.aLt.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.aLt.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aLp)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aLt.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.aLt.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aLt.setPositiveButtonTextColor(-57754);
                this.aLt.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aLt.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aLf = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aLt.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aLf = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aLt.create(this.mContext).show();
            this.aLf = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.v.a.Hm().aZp.azo;
        if (z2) {
            this.aKK.setVisibility(4);
            this.aKX.setStyle(1);
        } else {
            View view = this.aKK;
            if (this.aLh == null || !this.aLh.xS()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.aLv != null) {
            this.aLv.e(z2, this.aLh != null ? this.aLh.getThumbnail_url() : null);
        }
    }

    public void zQ() {
        if (this.aLv != null) {
            this.aLv.c(true, this.aLu);
        }
    }

    @Override // com.baidu.live.view.input.b.a
    public void fc(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        ff(str);
    }

    public void ff(String str) {
        this.aKM.setText(str);
        this.aKM.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        bs(false);
        if (this.aLh != null && this.aLh.xS()) {
            this.aKK.setVisibility(0);
            this.aLi = JavaTypesHelper.toInt(this.aKM.getText().toString(), 1);
            return;
        }
        this.aKK.setVisibility(4);
        this.aLi = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(boolean z) {
        this.aKM.setGravity(17);
        if (z) {
            this.aKM.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aKM.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<com.baidu.live.data.g> arrayList3, boolean z2, int i) {
        if (this.aKC == null || this.aKC.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            if (this.aKC == null) {
                this.aKC = new ArrayList<>();
            }
            this.aKC.clear();
            if (arrayList != null) {
                this.aKC.addAll(arrayList);
            }
            this.aKD = arrayList2;
            this.aKE = arrayList3;
            this.aLe = false;
            if (this.aKD == null || this.aKD.isEmpty()) {
                this.aKP.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void z(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aKY != null) {
            for (View view : this.aKY) {
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
        zR();
        if (this.aKC == null || this.aKC.size() <= 0 || !z2) {
            pZ();
            if (this.aKO != null) {
                this.aKO.setVisibility(4);
            }
            this.aKS.setVisibility(4);
            this.aKR.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.aKR.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aKR.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.aKR.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.v.a.Hm().aZp.aAO && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aKR.setTitle(string);
            this.aKR.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aLa != null) {
                        AlaGiftTabView.this.aLa.Aa();
                    }
                }
            });
            this.aKR.setVisibility(0);
            return;
        }
        this.aKR.setVisibility(8);
        if (z) {
            h(this.aKD);
        }
        bb bbVar = com.baidu.live.v.a.Hm().bdV;
        if (this.mType == 0 && bbVar != null && bbVar.aCW != null && bbVar.aCW.aEO && !this.aLA && this.aKC.get(0) != null && this.aKC.get(0).ym() != null) {
            List<com.baidu.live.gift.g> ym = this.aKC.get(0).ym();
            if (ym.size() <= 1 || ym.get(1) == null) {
                z3 = true;
            } else {
                z3 = !ym.get(1).isRed();
            }
            if (!ym.isEmpty() && z3) {
                com.baidu.live.gift.g gVar = new com.baidu.live.gift.g();
                gVar.ba(true);
                gVar.setGiftName("发红包");
                ym.add(1, gVar);
            }
        }
        c(this.aKC, z);
        ff("1");
    }

    private void pZ() {
        this.aLb = 0;
        this.aLc = 0;
        this.mSelectedPosition = 0;
        this.aLd = 0;
        if (this.aLj != null) {
            this.aLj.clear();
        }
        if (this.aKY != null) {
            this.aKY.clear();
        }
        if (this.aKN != null) {
            this.aKN.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.baidu.live.gift.g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.yl()) {
            if (gVar.yh() == 6 && this.aJo < 3) {
                return false;
            }
            if (gVar.yh() == 7 && this.aJo < 7) {
                return false;
            }
            if (gVar.yh() == 8 && this.aJo < 13) {
                return false;
            }
            if (gVar.yh() == 9 && this.aJo < 22) {
                return false;
            }
            if (gVar.yh() == 10 && this.aJo < 29) {
                return false;
            }
            if (gVar.yh() == 11 && this.aJo < 39) {
                return false;
            }
            if (gVar.yh() == 12 && this.aJo < 47) {
                return false;
            }
        }
        if (gVar.yk()) {
            return this.aJx;
        }
        return true;
    }

    public void b(final s sVar) {
        if (sVar == null || TextUtils.isEmpty(sVar.iconUrl)) {
            this.aLy.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_show"));
            this.aLy.setVisibility(0);
            this.aLy.startLoad(sVar.iconUrl, 10, false);
            this.aLy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_clk"));
                    AlaGiftTabView.this.a(sVar);
                }
            });
            String str = "key_live_official_tip" + currentAccount;
            if (com.baidu.live.c.vf().getInt(str, 0) == 0 && this.aLB) {
                N(this.aLy);
                com.baidu.live.c.vf().putInt(str, 1);
            }
        }
    }

    private void zR() {
        if (ListUtils.getCount(this.aKD) != 0 && ListUtils.getCount(this.aKC) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.f> it = this.aKD.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.f next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.wu()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.aKC.iterator();
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
                Iterator<i> it3 = this.aKC.iterator();
                while (it3.hasNext()) {
                    ListIterator<com.baidu.live.gift.g> listIterator = it3.next().ym().listIterator();
                    while (listIterator.hasNext()) {
                        com.baidu.live.gift.g next3 = listIterator.next();
                        if (next3 != null && next3.xT()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aKD.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aKC.removeAll(arrayList2);
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
        List<com.baidu.live.gift.g> ym;
        if (arrayList != null) {
            this.aLj.clear();
            this.aKY.clear();
            this.aKN.setAdapter(null);
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
                    if (iVar == null || (ym = iVar.ym()) == null || ym.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aKZ.clear();
            D(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aKY.add(cj(i7));
                    this.aLj.append(i7, 1);
                } else {
                    i iVar2 = arrayList.get(i7);
                    iVar2.getCategoryId();
                    List<com.baidu.live.gift.g> ym2 = iVar2.ym();
                    if (ym2 == null) {
                        i = 0;
                    } else {
                        i = ym2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aLk.get(i7)) {
                            this.aKY.add(bt(true));
                        } else {
                            this.aKY.add(b(arrayList3, -1, i7));
                        }
                    } else if (ym2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(ym2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(ym2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(ym2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aKZ.add(arrayList2);
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
                                    if (gVar == null || gVar.xM() == null || !gVar.xM().equals(String.valueOf(this.aLo))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aKY.add(b(arrayList2, i3, i7));
                                this.aKX.removeCallbacks(null);
                                this.aKX.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aLh != null) {
                                            boolean xT = AlaGiftTabView.this.aLh.xT();
                                            AlaGiftTabView.this.br(xT);
                                            if (!xT) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aLh);
                                                if (!c2) {
                                                    AlaGiftTabView.this.aKX.setStyle(AlaGiftTabView.this.aLh.xS() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.aKX.setStyle(AlaGiftTabView.this.aLh.xS() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.aKL.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.xM().equals(String.valueOf(this.aLo))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aKY.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aKY.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.aLj.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aKN.setAdapter(new AlaGiftPagerAdapter(this.aKY));
            zS();
            this.aKN.setCurrentItem(this.aLb);
            zU();
            if (z && !this.aLC && this.aLB) {
                this.aLC = true;
                zT();
            }
        }
    }

    private void zS() {
        int i = 0;
        if (this.aLo > 0 && !ListUtils.isEmpty(this.aKZ)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aKZ.size() && !z; i2++) {
                Iterator<com.baidu.live.gift.g> it = this.aKZ.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.baidu.live.gift.g next = it.next();
                    if (next != null && next.xM() != null && next.xM().equals(String.valueOf(this.aLo))) {
                        this.aLb = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.ayd == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.aLc = this.aLb;
            this.aKZ.clear();
        } else if (this.aLn > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aKD.size()) {
                    break;
                }
                com.baidu.live.data.f fVar = this.aKD.get(i3);
                if (fVar == null || this.aLn != fVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    ci(i3);
                    break;
                }
            }
            this.aLc = this.aLb;
        }
    }

    private void D(List<i> list) {
        if (list != null && this.aLn > 0 && this.aLo <= 0) {
            for (i iVar : list) {
                if (iVar.getCategoryId() == this.aLn) {
                    List<com.baidu.live.gift.g> ym = iVar.ym();
                    if (ym != null && !ym.isEmpty() && ym.get(0) != null) {
                        this.aLo = Integer.valueOf(ym.get(0).xM()).intValue();
                        return;
                    }
                    return;
                }
            }
        }
    }

    private View bt(boolean z) {
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
                if (AlaGiftTabView.this.aLa != null) {
                    AlaGiftTabView.this.aLa.Aa();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<com.baidu.live.gift.g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.bf(this.aJq);
        aVar.setGiftItems(list);
        aVar.bX(this.aJo);
        aVar.aR(this.aJx);
        aVar.bY(i);
        if (this.isLandscape) {
            if (this.aKN.getHeight() > 0) {
                aVar.bZ(this.aKN.getHeight() / 3);
            } else {
                this.aKN.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.bZ(AlaGiftTabView.this.aKN.getHeight() / 3);
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
                if (tag instanceof a.C0165a) {
                    ((a.C0165a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout cj(int i) {
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
            if (!this.aLm) {
                this.aKP.setVisibility(0);
            }
            this.aKQ.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.f fVar = arrayList.get(i);
                if (!TextUtils.isEmpty(fVar.getCategoryName()) && (this.mType != 0 || (fVar.wu() != null && fVar.wu().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(fVar.getCategoryName());
                    viewGroup.setOnClickListener(new c(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aLg;
                    }
                    if (this.aKC.size() > i && this.aKC.get(i) != null) {
                        for (com.baidu.live.gift.g gVar : this.aKC.get(i).ym()) {
                            if (gVar != null && gVar.xR() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aKQ.addView(viewGroup, layoutParams);
                }
            }
            ck(this.aLd);
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
    private void ck(int i) {
        int i2;
        JSONArray jSONArray;
        JSONException e;
        List<com.baidu.live.gift.g> ym;
        int childCount = this.aKQ.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aLd != i || !this.aLe) && this.aKD.size() > i && this.aKD.get(i) != null) {
                int min = Math.min(i, this.aLj.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aLj.get(i4);
                }
                if (this.aKY.size() > i3 && this.aKC.size() > i && (this.aKY.get(i3) instanceof ViewGroup)) {
                    this.aLc = i3;
                    i iVar = this.aKC.get(i);
                    if (iVar != null && iVar.ym() != null && !iVar.ym().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aKY.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aLe) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aLb) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.mShowing) {
                                        this.aLe = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aKD.size() > i && this.aKD.get(i) != null) {
                int categoryId = this.aKD.get(i).getCategoryId();
                if (!this.aLq.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aLq.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aKQ.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.aKC.get(i6);
                if (iVar2.yn()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aKI, "");
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
                                    ym = iVar2.ym();
                                    if (ym != null) {
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
                    ym = iVar2.ym();
                    if (ym != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= ym.size()) {
                                break;
                            }
                            com.baidu.live.gift.g gVar = ym.get(i9);
                            if (!gVar.yi() && !hashSet.contains(gVar.xM())) {
                                arrayList.add(gVar.xM());
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
                                SharedPrefHelper.getInstance().putString(this.aKI, jSONArray.toString());
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
                    if (this.aLw != 0) {
                        gradientTextView.setGradientTextColor(this.aLw, this.aLw);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    cl(i);
                    this.aLd = i;
                    this.aKP.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bu(false);
                        } else {
                            bu(true);
                        }
                    } else {
                        bu(true);
                    }
                }
            }
        }
    }

    private void bu(boolean z) {
        int i = 8;
        if (this.aKU != null) {
            this.aKU.setVisibility(z ? this.aLs ? 8 : 0 : 8);
        }
        if (this.aKV != null) {
            TextView textView = this.aKV;
            if (!z && !this.aLs) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void cl(int i) {
        int childCount = this.aKQ.getChildCount();
        if (i >= 0 && i < childCount && this.aKC != null && this.aKC.size() > i && this.aKC.get(i) != null) {
            this.aLk.get(i);
        }
    }

    public void u(int i, int i2) {
        this.aLn = i;
        this.aLo = i2;
    }

    public void ab(long j) {
        if (this.aKU != null) {
            if (j >= 100 && (this.aJq || com.baidu.live.v.a.Hm().aZp.aAk)) {
                this.aKU.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aKU.setText(String.valueOf(j));
        }
    }

    public void ac(long j) {
        if (this.aKV != null) {
            this.aKV.setText(String.valueOf(j));
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
        this.aLb = i;
        zU();
        zO();
        if (i >= 0 && i < this.aKY.size() && (this.aKY.get(i) instanceof ViewGroup)) {
            zT();
            ViewGroup viewGroup = (ViewGroup) this.aKY.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aLc) {
                            aVar.bY(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aLc) {
                            aVar.bY(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.aKS.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void zT() {
        JSONObject jSONObject = new JSONObject();
        com.baidu.live.data.f fVar = (com.baidu.live.data.f) ListUtils.getItem(this.aKD, this.aLd);
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

    private void zU() {
        int i = 0;
        for (int i2 = 0; i2 < this.aLj.size(); i2++) {
            for (int i3 = 0; i3 < this.aLj.get(i2); i3++) {
                if (i + i3 == this.aLb) {
                    if (this.aLj.get(i2) <= 1) {
                        this.aKO.setVisibility(4);
                    } else {
                        this.aKO.setVisibility(0);
                    }
                    this.aKO.setCount(this.aLj.get(i2));
                    this.aKO.onPageSelected(i3);
                    ck(i2);
                    return;
                }
            }
            i += this.aLj.get(i2);
        }
    }

    public com.baidu.live.gift.g zV() {
        return this.aLh;
    }

    public int zW() {
        return this.aLi;
    }

    public void a(d dVar) {
        this.aLa = dVar;
    }

    public void cm(int i) {
        this.aLi = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aLF);
        MessageManager.getInstance().registerListener(this.aLG);
        MessageManager.getInstance().registerListener(this.aLH);
        MessageManager.getInstance().registerListener(this.aLI);
    }

    public void zX() {
        if (!ListUtils.isEmpty(this.aKY)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aKY) {
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
    public void an(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.aKY) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aKY) {
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
    public void zY() {
        if (!ListUtils.isEmpty(this.aKY)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aKY) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aJx);
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
    public void zZ() {
        if (this.aLh != null && this.aLh.yk()) {
            this.aKL.setStyleEnabled(this.aJx);
            if (this.aJx) {
                this.aKX.setStyle(this.aLh.xS() ? 2 : 1);
            } else {
                this.aKX.setStyle(this.aLh.xS() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.aLv = null;
        MessageManager.getInstance().unRegisterListener(this.aLF);
        MessageManager.getInstance().unRegisterListener(this.aLG);
        MessageManager.getInstance().unRegisterListener(this.aLH);
        MessageManager.getInstance().unRegisterListener(this.aLI);
        pZ();
        if (this.aLt != null) {
            this.aLt.dismiss();
        }
    }

    public void bf(boolean z) {
        this.aJq = z;
    }

    public void cn(int i) {
        this.aJo = i;
    }

    public void d(com.baidu.live.gift.g gVar) {
        this.aLh = gVar;
        this.aLo = Integer.valueOf(this.aLh.xM()).intValue();
        if (this.aLv != null) {
            this.aLv.a(gVar);
        }
        if (gVar != null && !gVar.xU()) {
            this.aLx.zr();
        }
    }

    public void zq() {
        if (this.aLx != null) {
            this.aLx.zq();
        }
    }

    public void zp() {
        if (this.aLx != null) {
            this.aLx.zp();
        }
    }

    public void bv(boolean z) {
        if (this.aKX != null) {
            this.aKX.setVisibility(z ? 0 : 4);
        }
    }
}

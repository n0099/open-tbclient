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
import com.baidu.live.c.p;
import com.baidu.live.data.as;
import com.baidu.live.data.n;
import com.baidu.live.gift.container.AlaComboBtnAnimView;
import com.baidu.live.gift.container.a;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.widget.panel.GiftPanelNumRoundRectView;
import com.baidu.live.gift.widget.panel.GiftPanelOperationSendView;
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
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tieba.view.GradientTextView;
import com.baidu.live.u.a;
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
    private int aBp;
    private boolean aBr;
    private boolean aBw;
    private boolean aCA;
    private View aCB;
    private GiftPanelNumRoundRectView aCC;
    public TextView aCD;
    private BaseViewPager aCE;
    private RoundRectPageIndicator aCF;
    private HorizontalScrollView aCG;
    private LinearLayout aCH;
    private CommonEmptyView aCI;
    private View aCJ;
    private com.baidu.live.gift.container.c aCK;
    private TextView aCL;
    private TextView aCM;
    private TextView aCN;
    public GiftPanelOperationSendView aCO;
    private List<View> aCP;
    private ArrayList<List<g>> aCQ;
    private d aCR;
    private int aCS;
    private int aCT;
    private int aCU;
    private boolean aCV;
    private boolean aCW;
    private int aCX;
    private g aCY;
    private int aCZ;
    public ArrayList<i> aCt;
    private ArrayList<com.baidu.live.data.d> aCu;
    private ArrayList<com.baidu.live.data.e> aCv;
    private final String aCz;
    private SparseIntArray aDa;
    private SparseBooleanArray aDb;
    private View.OnClickListener aDc;
    private boolean aDd;
    private int aDe;
    private int aDf;
    private int aDg;
    private SparseBooleanArray aDh;
    private Set<String> aDi;
    private boolean aDj;
    private BdAlertDialog aDk;
    private int aDl;
    private a aDm;
    private int aDn;
    private AlaComboBtnAnimView aDo;
    private boolean aDp;
    private boolean aDq;
    private boolean aDr;
    private View.OnClickListener aDs;
    AdapterView.OnItemClickListener aDt;
    private CustomMessageListener aDu;
    private CustomMessageListener aDv;
    private CustomMessageListener aDw;
    private CustomMessageListener aDx;
    private int aqP;
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
        void Y(String str, String str2);

        void a(g gVar);

        void c(boolean z, int i);

        void d(boolean z, String str);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void yl();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aCz = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aCP = new ArrayList();
        this.aCS = 0;
        this.aCT = 0;
        this.mSelectedPosition = 0;
        this.aCU = 0;
        this.aDa = new SparseIntArray();
        this.aDb = new SparseBooleanArray();
        this.isLandscape = false;
        this.aDd = false;
        this.aDe = -1;
        this.aDf = -1;
        this.aBr = false;
        this.aBp = -1;
        this.aDh = new SparseBooleanArray();
        this.aDi = new HashSet();
        this.aDp = false;
        this.aBw = false;
        this.aDq = false;
        this.aDr = false;
        this.aDs = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aDo == null || !AlaGiftTabView.this.aDo.xG()) {
                    if (AlaGiftTabView.this.aCK == null) {
                        AlaGiftTabView.this.aCK = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aDt);
                    }
                    AlaGiftTabView.this.bk(true);
                    AlaGiftTabView.this.aCK.a(AlaGiftTabView.this.aCB, AlaGiftTabView.this.aCv, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bk(false);
                        }
                    });
                }
            }
        };
        this.aDt = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.aCK.dismiss();
                if (AlaGiftTabView.this.aCv != null && AlaGiftTabView.this.aCv.size() > 0) {
                    if (i != AlaGiftTabView.this.aCv.size()) {
                        com.baidu.live.data.e eVar = (com.baidu.live.data.e) AlaGiftTabView.this.aCv.get(i);
                        if (eVar != null) {
                            int number = eVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.aCY.ayN) != null) {
                                if (number == -1) {
                                    number = aVar.ayU;
                                }
                                if (number > AlaGiftTabView.this.aDl) {
                                    number = AlaGiftTabView.this.aDl;
                                }
                            }
                            AlaGiftTabView.this.ep(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.yb();
                    return;
                }
                AlaGiftTabView.this.ep("1");
            }
        };
        this.aDu = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.axw == 1 || cVar.axw == 2 || cVar.axw == 5 || cVar.axw == 6) && cVar.axx != null) {
                        AlaGiftTabView.this.aa(cVar.axx.getId(), cVar.axx.getUrl());
                    }
                }
            }
        };
        this.aDv = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bg(true);
                if (AlaGiftTabView.this.aCY != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aCY) && AlaGiftTabView.this.aCA) {
                    AlaGiftTabView.this.aCO.setStyle(AlaGiftTabView.this.aCY.wc() ? 2 : 1);
                    AlaGiftTabView.this.aCC.setStyleEnabled(true);
                }
            }
        };
        this.aDw = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                n nVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && (nVar = (n) customResponsedMessage.getData()) != null && nVar.aqx != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = nVar.aqx.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aBw != z2) {
                        AlaGiftTabView.this.aBw = z2;
                        AlaGiftTabView.this.yk();
                        AlaGiftTabView.this.yj();
                    }
                }
            }
        };
        this.aDx = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.ya();
                    AlaGiftTabView.this.aCO.setStyle(AlaGiftTabView.this.aCY.wc() ? 4 : 3);
                    AlaGiftTabView.this.aCC.setStyleEnabled(false);
                    if (AlaGiftTabView.this.aDm != null) {
                        AlaGiftTabView.this.aDm.d(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aDc = onClickListener;
        this.aDd = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aCX = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        this.aCE.requestLayout();
        this.aCQ = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aDl = 9999;
                return;
            case 1:
                this.aDl = 999;
                return;
            default:
                return;
        }
    }

    public void bQ(int i) {
        int childCount;
        this.aDn = i;
        if (this.aCH != null && (childCount = this.aCH.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aCU) {
                    ((GradientTextView) ((ViewGroup) this.aCH.getChildAt(i2)).findViewById(a.g.text_view)).setGradientTextColor(this.aDn, this.aDn);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aDm = aVar;
    }

    public void Z(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bf(boolean z) {
        this.mShowing = z;
    }

    public void onVisibilityChanged(boolean z) {
        bf(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        this.aCB = this.mRoot.findViewById(a.g.gift_count_layout);
        this.aCB.setOnClickListener(this.aDs);
        this.aCC = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.aCD = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.aCD.setText("1");
        this.aCD.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.aCE = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.aCE.setOnPageChangeListener(this);
        this.aCF = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.aCH = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.aCG = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.aDd) {
            this.aCG.setVisibility(8);
        }
        this.aCL = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.aCL.setOnClickListener(this.aDc);
        this.aCM = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.aCM.setOnClickListener(this.aDc);
        this.aCO = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.aCN = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.aCN.setOnClickListener(this.aDc);
        this.aCO.setOnClickListener(this.aDc);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.aCI = new CommonEmptyView(this.mContext.getPageActivity());
        this.aCI.setVisibility(8);
        this.aCI.addToParent(frameLayout);
        this.aCJ = this.mRoot.findViewById(a.g.donate_layout);
        this.aDo = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.aDo.setComboClickListener(this.aDc);
        this.aDo.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void xH() {
                AlaGiftTabView.this.bn(true);
            }
        });
    }

    public void xY() {
        this.aDj = true;
        this.aCL.setVisibility(8);
        this.aCM.setVisibility(8);
        this.aCN.setVisibility(8);
    }

    public void bg(boolean z) {
        this.aCA = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.v.a.Eo().Er() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aCN.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aDi.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aDi.add(str);
            }
        }
    }

    public void aM(boolean z) {
    }

    public void bu(int i) {
        this.aDg = i;
    }

    public void bh(boolean z) {
        this.aDq = z;
        if (z && !ListUtils.isEmpty(this.aCu)) {
            ye();
            this.aDr = true;
        }
    }

    public void bi(boolean z) {
        this.aDp = z;
    }

    public void bR(int i) {
        this.aqP = i;
    }

    public void aO(boolean z) {
        this.aBw = z;
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
            AlaGiftTabView.this.bS(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(int i) {
        if (this.aDm != null) {
            this.aDm.c(false, this.aDl);
        }
        bT(i);
        this.aCE.setCurrentItem(this.aCS);
        yf();
        xZ();
    }

    private void bT(int i) {
        int min = Math.min(i, this.aDa.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aDa.get(i3);
        }
        this.aCS = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            g item = ((com.baidu.live.gift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.isRed()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.aCT = AlaGiftTabView.this.aCS;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void xZ() {
        if (this.aDm != null) {
            if (this.aCY != null && this.aCY.ayO) {
                this.aDm.Y(this.aCY.ayP, this.aCY.ayQ);
            } else {
                this.aDm.Y(null, null);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.aDm != null) {
            this.aDm.c(false, this.aDl);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.bJ(i);
                aVar.notifyDataSetChanged();
                this.aCJ.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                ep("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aCY.ws()) {
                        this.aCO.setStyle(this.aCY.wc() ? 4 : 3);
                        this.aCC.setStyleEnabled(false);
                        if (this.aDm != null) {
                            this.aDm.d(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aCY.wf()) && this.mShowing) {
                            this.mContext.showToast(this.aCY.wf());
                            return;
                        }
                        return;
                    }
                    xZ();
                    this.aCO.setEnabled(true);
                    if (this.aCY.wv()) {
                        if (this.aDm != null) {
                            this.aDm.d(false, null);
                        }
                        if (this.aCY.wr() == 6 && this.aBp < 3) {
                            i3 = 3;
                        } else if (this.aCY.wr() == 7 && this.aBp < 7) {
                            i3 = 7;
                        } else if (this.aCY.wr() == 8 && this.aBp < 13) {
                            i3 = 13;
                        } else if (this.aCY.wr() == 9 && this.aBp < 22) {
                            i3 = 22;
                        } else if (this.aCY.wr() == 10 && this.aBp < 29) {
                            i3 = 29;
                        } else if (this.aCY.wr() == 11 && this.aBp < 39) {
                            i3 = 39;
                        } else if (this.aCY.wr() == 12 && this.aBp < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.aCO.setStyle(this.aCY.wc() ? 2 : 1);
                    } else {
                        this.aCO.setStyle(this.aCY.wc() ? 4 : 3);
                    }
                    this.aCC.setStyleEnabled(z);
                    yk();
                    i2 = i3;
                } else {
                    this.aCO.setStyle(this.aCY.wc() ? 2 : 1);
                    if (this.aCY.ayN != null && this.aCY.ayN.ayT != null && this.aCY.ayN.ayT.equals("20")) {
                        this.aCO.setText("使用");
                    } else {
                        this.aCO.setText("赠送");
                    }
                    this.aCC.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aCY.wd()) {
                    bj(true);
                } else {
                    bj(false);
                    ep("1");
                }
                d(false, i2);
                return;
            }
            this.aCO.setStyle(3);
            return;
        }
        this.aCO.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.a aVar;
        if (this.mShowing && this.aCY != null) {
            if (this.mType == 0) {
                if (this.aCY.wu() && !this.aBw) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aCY.wf()) && this.aCY.ws() && !z) {
                    this.mContext.showToast(this.aCY.wf());
                } else if (this.aCY.wv() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aCY.wq()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (aVar = this.aCY.ayN) != null && !TextUtils.isEmpty(aVar.ayW)) {
                this.mContext.showToast(aVar.ayW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.v.a.Eo().aRw != null && com.baidu.live.v.a.Eo().aRw.avt != null) {
            String str = com.baidu.live.v.a.Eo().aRw.avt.auJ;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.wr()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ya() {
        if (!this.aCW) {
            this.aDk = new BdAlertDialog(this.mContext.getPageActivity());
            this.aDk.setCancelable(false);
            this.aDk.setCanceledOnTouchOutside(false);
            this.aDk.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.aDk.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aDg)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aDk.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.aDk.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aDk.setPositiveButtonTextColor(-57754);
                this.aDk.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aDk.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aCW = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aDk.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aCW = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aDk.create(this.mContext).show();
            this.aCW = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.v.a.Eo().aQp.arY;
        if (z2) {
            this.aCB.setVisibility(4);
            this.aCO.setStyle(1);
        } else {
            View view = this.aCB;
            if (this.aCY == null || !this.aCY.wc()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.aDm != null) {
            this.aDm.d(z2, this.aCY != null ? this.aCY.vY() : null);
        }
    }

    public void yb() {
        if (this.aDm != null) {
            this.aDm.c(true, this.aDl);
        }
    }

    @Override // com.baidu.live.view.input.b.a
    public void em(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        ep(str);
    }

    public void ep(String str) {
        this.aCD.setText(str);
        this.aCD.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        bk(false);
        if (this.aCY != null && this.aCY.wc()) {
            this.aCB.setVisibility(0);
            this.aCZ = JavaTypesHelper.toInt(this.aCD.getText().toString(), 1);
            return;
        }
        this.aCB.setVisibility(4);
        this.aCZ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(boolean z) {
        this.aCD.setGravity(17);
        if (z) {
            this.aCD.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aCD.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3, boolean z2, int i) {
        if (this.aCt == null || this.aCt.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            if (this.aCt == null) {
                this.aCt = new ArrayList<>();
            }
            this.aCt.clear();
            if (arrayList != null) {
                this.aCt.addAll(arrayList);
            }
            this.aCu = arrayList2;
            this.aCv = arrayList3;
            this.aCV = false;
            if (this.aCu == null || this.aCu.isEmpty()) {
                this.aCG.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void v(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aCP != null) {
            for (View view : this.aCP) {
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
                                ((com.baidu.live.gift.container.a) ((GridView) childAt).getAdapter()).v(str, i);
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
        yc();
        if (this.aCt == null || this.aCt.size() <= 0 || !z2) {
            pC();
            if (this.aCF != null) {
                this.aCF.setVisibility(4);
            }
            this.aCJ.setVisibility(4);
            this.aCI.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.aCI.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aCI.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.aCI.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.v.a.Eo().aQp.atv && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aCI.setTitle(string);
            this.aCI.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aCR != null) {
                        AlaGiftTabView.this.aCR.yl();
                    }
                }
            });
            this.aCI.setVisibility(0);
            return;
        }
        this.aCI.setVisibility(8);
        if (z) {
            h(this.aCu);
        }
        as asVar = com.baidu.live.v.a.Eo().aRw;
        if (this.mType == 0 && asVar != null && asVar.avx != null && asVar.avx.axc && !this.aDp && this.aCt.get(0) != null && this.aCt.get(0).ww() != null) {
            List<g> ww = this.aCt.get(0).ww();
            if (ww.size() <= 1 || ww.get(1) == null) {
                z3 = true;
            } else {
                z3 = !ww.get(1).isRed();
            }
            if (!ww.isEmpty() && z3) {
                g gVar = new g();
                gVar.aV(true);
                gVar.setGiftName("发红包");
                ww.add(1, gVar);
            }
        }
        c(this.aCt, z);
        ep("1");
    }

    private void pC() {
        this.aCS = 0;
        this.aCT = 0;
        this.mSelectedPosition = 0;
        this.aCU = 0;
        if (this.aDa != null) {
            this.aDa.clear();
        }
        if (this.aCP != null) {
            this.aCP.clear();
        }
        if (this.aCE != null) {
            this.aCE.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.wv()) {
            if (gVar.wr() == 6 && this.aBp < 3) {
                return false;
            }
            if (gVar.wr() == 7 && this.aBp < 7) {
                return false;
            }
            if (gVar.wr() == 8 && this.aBp < 13) {
                return false;
            }
            if (gVar.wr() == 9 && this.aBp < 22) {
                return false;
            }
            if (gVar.wr() == 10 && this.aBp < 29) {
                return false;
            }
            if (gVar.wr() == 11 && this.aBp < 39) {
                return false;
            }
            if (gVar.wr() == 12 && this.aBp < 47) {
                return false;
            }
        }
        if (gVar.wu()) {
            return this.aBw;
        }
        return true;
    }

    private void yc() {
        if (ListUtils.getCount(this.aCu) != 0 && ListUtils.getCount(this.aCt) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.d> it = this.aCu.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.d next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.uM()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.aCt.iterator();
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
                Iterator<i> it3 = this.aCt.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().ww().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.wd()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aCu.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aCt.removeAll(arrayList2);
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
        List<g> ww;
        if (arrayList != null) {
            this.aDa.clear();
            this.aCP.clear();
            this.aCE.setAdapter(null);
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
                    if (iVar == null || (ww = iVar.ww()) == null || ww.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aCQ.clear();
            z(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aCP.add(bU(i7));
                    this.aDa.append(i7, 1);
                } else {
                    i iVar2 = arrayList.get(i7);
                    iVar2.getCategoryId();
                    List<g> ww2 = iVar2.ww();
                    if (ww2 == null) {
                        i = 0;
                    } else {
                        i = ww2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aDb.get(i7)) {
                            this.aCP.add(bl(true));
                        } else {
                            this.aCP.add(b(arrayList3, -1, i7));
                        }
                    } else if (ww2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(ww2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(ww2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(ww2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aCQ.add(arrayList2);
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
                                    if (gVar == null || gVar.vV() == null || !gVar.vV().equals(String.valueOf(this.aDf))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aCP.add(b(arrayList2, i3, i7));
                                this.aCO.removeCallbacks(null);
                                this.aCO.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aCY != null) {
                                            boolean wd = AlaGiftTabView.this.aCY.wd();
                                            AlaGiftTabView.this.bj(wd);
                                            if (!wd) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aCY);
                                                if (!c2) {
                                                    AlaGiftTabView.this.aCO.setStyle(AlaGiftTabView.this.aCY.wc() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.aCO.setStyle(AlaGiftTabView.this.aCY.wc() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.aCC.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.vV().equals(String.valueOf(this.aDf))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aCP.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aCP.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.aDa.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aCE.setAdapter(new AlaGiftPagerAdapter(this.aCP));
            yd();
            this.aCE.setCurrentItem(this.aCS);
            yf();
            if (z && !this.aDr && this.aDq) {
                this.aDr = true;
                ye();
            }
        }
    }

    private void yd() {
        int i = 0;
        if (this.aDf > 0 && !ListUtils.isEmpty(this.aCQ)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aCQ.size() && !z; i2++) {
                Iterator<g> it = this.aCQ.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.vV() != null && next.vV().equals(String.valueOf(this.aDf))) {
                        this.aCS = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aqP == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.aCT = this.aCS;
            this.aCQ.clear();
        } else if (this.aDe > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aCu.size()) {
                    break;
                }
                com.baidu.live.data.d dVar = this.aCu.get(i3);
                if (dVar == null || this.aDe != dVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    bT(i3);
                    break;
                }
            }
            this.aCT = this.aCS;
        }
    }

    private void z(List<i> list) {
        if (list != null && this.aDe > 0 && this.aDf <= 0) {
            for (i iVar : list) {
                if (iVar.getCategoryId() == this.aDe) {
                    List<g> ww = iVar.ww();
                    if (ww != null && !ww.isEmpty() && ww.get(0) != null) {
                        this.aDf = Integer.valueOf(ww.get(0).vV()).intValue();
                        return;
                    }
                    return;
                }
            }
        }
    }

    private View bl(boolean z) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext.getPageActivity());
        commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        } else {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aCR != null) {
                    AlaGiftTabView.this.aCR.yl();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.ba(this.aBr);
        aVar.setGiftItems(list);
        aVar.bI(this.aBp);
        aVar.aO(this.aBw);
        aVar.bJ(i);
        if (this.isLandscape) {
            if (this.aCE.getHeight() > 0) {
                aVar.bK(this.aCE.getHeight() / 3);
            } else {
                this.aCE.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.bK(AlaGiftTabView.this.aCE.getHeight() / 3);
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
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0111a) {
                    ((a.C0111a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout bU(int i) {
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
            if (!this.aDd) {
                this.aCG.setVisibility(0);
            }
            this.aCH.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.getCategoryName()) && (this.mType != 0 || (dVar.uM() != null && dVar.uM().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(dVar.getCategoryName());
                    viewGroup.setOnClickListener(new c(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aCX;
                    }
                    if (this.aCt.size() > i && this.aCt.get(i) != null) {
                        for (g gVar : this.aCt.get(i).ww()) {
                            if (gVar != null && gVar.wb() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aCH.addView(viewGroup, layoutParams);
                }
            }
            bV(this.aCU);
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
    private void bV(int i) {
        int i2;
        JSONArray jSONArray;
        JSONException e;
        List<g> ww;
        int childCount = this.aCH.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aCU != i || !this.aCV) && this.aCu.size() > i && this.aCu.get(i) != null) {
                int min = Math.min(i, this.aDa.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aDa.get(i4);
                }
                if (this.aCP.size() > i3 && this.aCt.size() > i && (this.aCP.get(i3) instanceof ViewGroup)) {
                    this.aCT = i3;
                    i iVar = this.aCt.get(i);
                    if (iVar != null && iVar.ww() != null && !iVar.ww().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aCP.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aCV) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aCS) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.mShowing) {
                                        this.aCV = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aCu.size() > i && this.aCu.get(i) != null) {
                int categoryId = this.aCu.get(i).getCategoryId();
                if (!this.aDh.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aDh.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aCH.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.aCt.get(i6);
                if (iVar2.wx()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aCz, "");
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
                                    ww = iVar2.ww();
                                    if (ww != null) {
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
                    ww = iVar2.ww();
                    if (ww != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= ww.size()) {
                                break;
                            }
                            g gVar = ww.get(i9);
                            if (!gVar.ws() && !hashSet.contains(gVar.vV())) {
                                arrayList.add(gVar.vV());
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
                                SharedPrefHelper.getInstance().putString(this.aCz, jSONArray.toString());
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
                    if (this.aDn != 0) {
                        gradientTextView.setGradientTextColor(this.aDn, this.aDn);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    bW(i);
                    this.aCU = i;
                    this.aCG.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bm(false);
                        } else {
                            bm(true);
                        }
                    } else {
                        bm(true);
                    }
                }
            }
        }
    }

    private void bm(boolean z) {
        int i = 8;
        if (this.aCL != null) {
            this.aCL.setVisibility(z ? this.aDj ? 8 : 0 : 8);
        }
        if (this.aCM != null) {
            TextView textView = this.aCM;
            if (!z && !this.aDj) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void bW(int i) {
        int childCount = this.aCH.getChildCount();
        if (i >= 0 && i < childCount && this.aCt != null && this.aCt.size() > i && this.aCt.get(i) != null) {
            this.aDb.get(i);
        }
    }

    public void s(int i, int i2) {
        this.aDe = i;
        this.aDf = i2;
    }

    public void X(long j) {
        if (this.aCL != null) {
            if (j >= 100 && (this.aBr || com.baidu.live.v.a.Eo().aQp.asP)) {
                this.aCL.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aCL.setText(String.valueOf(j));
        }
    }

    public void Y(long j) {
        if (this.aCM != null) {
            this.aCM.setText(String.valueOf(j));
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
        this.aCS = i;
        yf();
        xZ();
        if (i >= 0 && i < this.aCP.size() && (this.aCP.get(i) instanceof ViewGroup)) {
            ye();
            ViewGroup viewGroup = (ViewGroup) this.aCP.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aCT) {
                            aVar.bJ(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aCT) {
                            aVar.bJ(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.aCJ.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void ye() {
        JSONObject jSONObject = new JSONObject();
        com.baidu.live.data.d dVar = (com.baidu.live.data.d) ListUtils.getItem(this.aCu, this.aCU);
        if (dVar != null) {
            try {
                jSONObject.put("tabid", dVar.getCategoryId());
                jSONObject.put("tabname", dVar.getCategoryName());
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", "liveroom", "giftpanel_show").setContentExt(null, "giftpanel", jSONObject));
    }

    private void yf() {
        int i = 0;
        for (int i2 = 0; i2 < this.aDa.size(); i2++) {
            for (int i3 = 0; i3 < this.aDa.get(i2); i3++) {
                if (i + i3 == this.aCS) {
                    if (this.aDa.get(i2) <= 1) {
                        this.aCF.setVisibility(4);
                    } else {
                        this.aCF.setVisibility(0);
                    }
                    this.aCF.setCount(this.aDa.get(i2));
                    this.aCF.onPageSelected(i3);
                    bV(i2);
                    return;
                }
            }
            i += this.aDa.get(i2);
        }
    }

    public g yg() {
        return this.aCY;
    }

    public int yh() {
        return this.aCZ;
    }

    public void a(d dVar) {
        this.aCR = dVar;
    }

    public void bX(int i) {
        this.aCZ = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aDu);
        MessageManager.getInstance().registerListener(this.aDv);
        MessageManager.getInstance().registerListener(this.aDw);
        MessageManager.getInstance().registerListener(this.aDx);
    }

    public void yi() {
        if (!ListUtils.isEmpty(this.aCP)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aCP) {
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
    public void aa(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.aCP) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aCP) {
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
    public void yj() {
        if (!ListUtils.isEmpty(this.aCP)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aCP) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aBw);
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
    public void yk() {
        if (this.aCY != null && this.aCY.wu()) {
            this.aCC.setStyleEnabled(this.aBw);
            if (this.aBw) {
                this.aCO.setStyle(this.aCY.wc() ? 2 : 1);
            } else {
                this.aCO.setStyle(this.aCY.wc() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.aDm = null;
        MessageManager.getInstance().unRegisterListener(this.aDu);
        MessageManager.getInstance().unRegisterListener(this.aDv);
        MessageManager.getInstance().unRegisterListener(this.aDw);
        MessageManager.getInstance().unRegisterListener(this.aDx);
        pC();
        if (this.aDk != null) {
            this.aDk.dismiss();
        }
    }

    public void ba(boolean z) {
        this.aBr = z;
    }

    public void bY(int i) {
        this.aBp = i;
    }

    public void d(g gVar) {
        this.aCY = gVar;
        this.aDf = Integer.valueOf(this.aCY.vV()).intValue();
        if (this.aDm != null) {
            this.aDm.a(gVar);
        }
        if (gVar != null && !gVar.we()) {
            this.aDo.xF();
        }
    }

    public void xE() {
        if (this.aDo != null) {
            this.aDo.xE();
        }
    }

    public void xD() {
        if (this.aDo != null) {
            this.aDo.xD();
        }
    }

    public void bn(boolean z) {
        if (this.aCO != null) {
            this.aCO.setVisibility(z ? 0 : 4);
        }
    }
}

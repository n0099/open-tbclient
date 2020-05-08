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
    private boolean aBC;
    private int aBv;
    private boolean aBx;
    private ArrayList<com.baidu.live.data.d> aCA;
    private ArrayList<com.baidu.live.data.e> aCB;
    private final String aCF;
    private boolean aCG;
    private View aCH;
    private GiftPanelNumRoundRectView aCI;
    public TextView aCJ;
    private BaseViewPager aCK;
    private RoundRectPageIndicator aCL;
    private HorizontalScrollView aCM;
    private LinearLayout aCN;
    private CommonEmptyView aCO;
    private View aCP;
    private com.baidu.live.gift.container.c aCQ;
    private TextView aCR;
    private TextView aCS;
    private TextView aCT;
    public GiftPanelOperationSendView aCU;
    private List<View> aCV;
    private ArrayList<List<g>> aCW;
    private d aCX;
    private int aCY;
    private int aCZ;
    public ArrayList<i> aCz;
    private CustomMessageListener aDA;
    private CustomMessageListener aDB;
    private CustomMessageListener aDC;
    private CustomMessageListener aDD;
    private int aDa;
    private boolean aDb;
    private boolean aDc;
    private int aDd;
    private g aDe;
    private int aDf;
    private SparseIntArray aDg;
    private SparseBooleanArray aDh;
    private View.OnClickListener aDi;
    private boolean aDj;
    private int aDk;
    private int aDl;
    private int aDm;
    private SparseBooleanArray aDn;
    private Set<String> aDo;
    private boolean aDp;
    private BdAlertDialog aDq;
    private int aDr;
    private a aDs;
    private int aDt;
    private AlaComboBtnAnimView aDu;
    private boolean aDv;
    private boolean aDw;
    private boolean aDx;
    private View.OnClickListener aDy;
    AdapterView.OnItemClickListener aDz;
    private int aqV;
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
        void yk();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aCF = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aCV = new ArrayList();
        this.aCY = 0;
        this.aCZ = 0;
        this.mSelectedPosition = 0;
        this.aDa = 0;
        this.aDg = new SparseIntArray();
        this.aDh = new SparseBooleanArray();
        this.isLandscape = false;
        this.aDj = false;
        this.aDk = -1;
        this.aDl = -1;
        this.aBx = false;
        this.aBv = -1;
        this.aDn = new SparseBooleanArray();
        this.aDo = new HashSet();
        this.aDv = false;
        this.aBC = false;
        this.aDw = false;
        this.aDx = false;
        this.aDy = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aDu == null || !AlaGiftTabView.this.aDu.xF()) {
                    if (AlaGiftTabView.this.aCQ == null) {
                        AlaGiftTabView.this.aCQ = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aDz);
                    }
                    AlaGiftTabView.this.bk(true);
                    AlaGiftTabView.this.aCQ.a(AlaGiftTabView.this.aCH, AlaGiftTabView.this.aCB, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bk(false);
                        }
                    });
                }
            }
        };
        this.aDz = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.aCQ.dismiss();
                if (AlaGiftTabView.this.aCB != null && AlaGiftTabView.this.aCB.size() > 0) {
                    if (i != AlaGiftTabView.this.aCB.size()) {
                        com.baidu.live.data.e eVar = (com.baidu.live.data.e) AlaGiftTabView.this.aCB.get(i);
                        if (eVar != null) {
                            int number = eVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.aDe.ayT) != null) {
                                if (number == -1) {
                                    number = aVar.aza;
                                }
                                if (number > AlaGiftTabView.this.aDr) {
                                    number = AlaGiftTabView.this.aDr;
                                }
                            }
                            AlaGiftTabView.this.ep(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.ya();
                    return;
                }
                AlaGiftTabView.this.ep("1");
            }
        };
        this.aDA = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.axC == 1 || cVar.axC == 2 || cVar.axC == 5 || cVar.axC == 6) && cVar.axD != null) {
                        AlaGiftTabView.this.aa(cVar.axD.getId(), cVar.axD.getUrl());
                    }
                }
            }
        };
        this.aDB = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bg(true);
                if (AlaGiftTabView.this.aDe != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aDe) && AlaGiftTabView.this.aCG) {
                    AlaGiftTabView.this.aCU.setStyle(AlaGiftTabView.this.aDe.wb() ? 2 : 1);
                    AlaGiftTabView.this.aCI.setStyleEnabled(true);
                }
            }
        };
        this.aDC = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                n nVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof n) && (nVar = (n) customResponsedMessage.getData()) != null && nVar.aqD != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = nVar.aqD.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aBC != z2) {
                        AlaGiftTabView.this.aBC = z2;
                        AlaGiftTabView.this.yj();
                        AlaGiftTabView.this.yi();
                    }
                }
            }
        };
        this.aDD = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.xZ();
                    AlaGiftTabView.this.aCU.setStyle(AlaGiftTabView.this.aDe.wb() ? 4 : 3);
                    AlaGiftTabView.this.aCI.setStyleEnabled(false);
                    if (AlaGiftTabView.this.aDs != null) {
                        AlaGiftTabView.this.aDs.d(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aDi = onClickListener;
        this.aDj = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aDd = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        this.aCK.requestLayout();
        this.aCW = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aDr = 9999;
                return;
            case 1:
                this.aDr = 999;
                return;
            default:
                return;
        }
    }

    public void bQ(int i) {
        int childCount;
        this.aDt = i;
        if (this.aCN != null && (childCount = this.aCN.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aDa) {
                    ((GradientTextView) ((ViewGroup) this.aCN.getChildAt(i2)).findViewById(a.g.text_view)).setGradientTextColor(this.aDt, this.aDt);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aDs = aVar;
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
        this.aCH = this.mRoot.findViewById(a.g.gift_count_layout);
        this.aCH.setOnClickListener(this.aDy);
        this.aCI = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.aCJ = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.aCJ.setText("1");
        this.aCJ.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.aCK = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.aCK.setOnPageChangeListener(this);
        this.aCL = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.aCN = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.aCM = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.aDj) {
            this.aCM.setVisibility(8);
        }
        this.aCR = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.aCR.setOnClickListener(this.aDi);
        this.aCS = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.aCS.setOnClickListener(this.aDi);
        this.aCU = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.aCT = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.aCT.setOnClickListener(this.aDi);
        this.aCU.setOnClickListener(this.aDi);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.aCO = new CommonEmptyView(this.mContext.getPageActivity());
        this.aCO.setVisibility(8);
        this.aCO.addToParent(frameLayout);
        this.aCP = this.mRoot.findViewById(a.g.donate_layout);
        this.aDu = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.aDu.setComboClickListener(this.aDi);
        this.aDu.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void xG() {
                AlaGiftTabView.this.bn(true);
            }
        });
    }

    public void xX() {
        this.aDp = true;
        this.aCR.setVisibility(8);
        this.aCS.setVisibility(8);
        this.aCT.setVisibility(8);
    }

    public void bg(boolean z) {
        this.aCG = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.v.a.En().Eq() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aCT.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aDo.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aDo.add(str);
            }
        }
    }

    public void aM(boolean z) {
    }

    public void bu(int i) {
        this.aDm = i;
    }

    public void bh(boolean z) {
        this.aDw = z;
        if (z && !ListUtils.isEmpty(this.aCA)) {
            yd();
            this.aDx = true;
        }
    }

    public void bi(boolean z) {
        this.aDv = z;
    }

    public void bR(int i) {
        this.aqV = i;
    }

    public void aO(boolean z) {
        this.aBC = z;
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
        if (this.aDs != null) {
            this.aDs.c(false, this.aDr);
        }
        bT(i);
        this.aCK.setCurrentItem(this.aCY);
        ye();
        xY();
    }

    private void bT(int i) {
        int min = Math.min(i, this.aDg.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aDg.get(i3);
        }
        this.aCY = i2;
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
            AlaGiftTabView.this.aCZ = AlaGiftTabView.this.aCY;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void xY() {
        if (this.aDs != null) {
            if (this.aDe != null && this.aDe.ayU) {
                this.aDs.Y(this.aDe.ayV, this.aDe.ayW);
            } else {
                this.aDs.Y(null, null);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.aDs != null) {
            this.aDs.c(false, this.aDr);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.bJ(i);
                aVar.notifyDataSetChanged();
                this.aCP.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                ep("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aDe.wr()) {
                        this.aCU.setStyle(this.aDe.wb() ? 4 : 3);
                        this.aCI.setStyleEnabled(false);
                        if (this.aDs != null) {
                            this.aDs.d(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aDe.we()) && this.mShowing) {
                            this.mContext.showToast(this.aDe.we());
                            return;
                        }
                        return;
                    }
                    xY();
                    this.aCU.setEnabled(true);
                    if (this.aDe.wu()) {
                        if (this.aDs != null) {
                            this.aDs.d(false, null);
                        }
                        if (this.aDe.wq() == 6 && this.aBv < 3) {
                            i3 = 3;
                        } else if (this.aDe.wq() == 7 && this.aBv < 7) {
                            i3 = 7;
                        } else if (this.aDe.wq() == 8 && this.aBv < 13) {
                            i3 = 13;
                        } else if (this.aDe.wq() == 9 && this.aBv < 22) {
                            i3 = 22;
                        } else if (this.aDe.wq() == 10 && this.aBv < 29) {
                            i3 = 29;
                        } else if (this.aDe.wq() == 11 && this.aBv < 39) {
                            i3 = 39;
                        } else if (this.aDe.wq() == 12 && this.aBv < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.aCU.setStyle(this.aDe.wb() ? 2 : 1);
                    } else {
                        this.aCU.setStyle(this.aDe.wb() ? 4 : 3);
                    }
                    this.aCI.setStyleEnabled(z);
                    yj();
                    i2 = i3;
                } else {
                    this.aCU.setStyle(this.aDe.wb() ? 2 : 1);
                    if (this.aDe.ayT != null && this.aDe.ayT.ayZ != null && this.aDe.ayT.ayZ.equals("20")) {
                        this.aCU.setText("使用");
                    } else {
                        this.aCU.setText("赠送");
                    }
                    this.aCI.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aDe.wc()) {
                    bj(true);
                } else {
                    bj(false);
                    ep("1");
                }
                d(false, i2);
                return;
            }
            this.aCU.setStyle(3);
            return;
        }
        this.aCU.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.a aVar;
        if (this.mShowing && this.aDe != null) {
            if (this.mType == 0) {
                if (this.aDe.wt() && !this.aBC) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aDe.we()) && this.aDe.wr() && !z) {
                    this.mContext.showToast(this.aDe.we());
                } else if (this.aDe.wu() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aDe.wp()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (aVar = this.aDe.ayT) != null && !TextUtils.isEmpty(aVar.azc)) {
                this.mContext.showToast(aVar.azc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.v.a.En().aRB != null && com.baidu.live.v.a.En().aRB.avz != null) {
            String str = com.baidu.live.v.a.En().aRB.avz.auP;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.wq()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xZ() {
        if (!this.aDc) {
            this.aDq = new BdAlertDialog(this.mContext.getPageActivity());
            this.aDq.setCancelable(false);
            this.aDq.setCanceledOnTouchOutside(false);
            this.aDq.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.aDq.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aDm)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aDq.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.aDq.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aDq.setPositiveButtonTextColor(-57754);
                this.aDq.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aDq.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aDc = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aDq.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aDc = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aDq.create(this.mContext).show();
            this.aDc = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.v.a.En().aQu.ase;
        if (z2) {
            this.aCH.setVisibility(4);
            this.aCU.setStyle(1);
        } else {
            View view = this.aCH;
            if (this.aDe == null || !this.aDe.wb()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.aDs != null) {
            this.aDs.d(z2, this.aDe != null ? this.aDe.vX() : null);
        }
    }

    public void ya() {
        if (this.aDs != null) {
            this.aDs.c(true, this.aDr);
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
        this.aCJ.setText(str);
        this.aCJ.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        bk(false);
        if (this.aDe != null && this.aDe.wb()) {
            this.aCH.setVisibility(0);
            this.aDf = JavaTypesHelper.toInt(this.aCJ.getText().toString(), 1);
            return;
        }
        this.aCH.setVisibility(4);
        this.aDf = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(boolean z) {
        this.aCJ.setGravity(17);
        if (z) {
            this.aCJ.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aCJ.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.d> arrayList2, ArrayList<com.baidu.live.data.e> arrayList3, boolean z2, int i) {
        if (this.aCz == null || this.aCz.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            if (this.aCz == null) {
                this.aCz = new ArrayList<>();
            }
            this.aCz.clear();
            if (arrayList != null) {
                this.aCz.addAll(arrayList);
            }
            this.aCA = arrayList2;
            this.aCB = arrayList3;
            this.aDb = false;
            if (this.aCA == null || this.aCA.isEmpty()) {
                this.aCM.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void v(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aCV != null) {
            for (View view : this.aCV) {
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
        yb();
        if (this.aCz == null || this.aCz.size() <= 0 || !z2) {
            pC();
            if (this.aCL != null) {
                this.aCL.setVisibility(4);
            }
            this.aCP.setVisibility(4);
            this.aCO.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.aCO.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aCO.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.aCO.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.v.a.En().aQu.atB && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aCO.setTitle(string);
            this.aCO.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aCX != null) {
                        AlaGiftTabView.this.aCX.yk();
                    }
                }
            });
            this.aCO.setVisibility(0);
            return;
        }
        this.aCO.setVisibility(8);
        if (z) {
            h(this.aCA);
        }
        as asVar = com.baidu.live.v.a.En().aRB;
        if (this.mType == 0 && asVar != null && asVar.avD != null && asVar.avD.axi && !this.aDv && this.aCz.get(0) != null && this.aCz.get(0).wv() != null) {
            List<g> wv = this.aCz.get(0).wv();
            if (wv.size() <= 1 || wv.get(1) == null) {
                z3 = true;
            } else {
                z3 = !wv.get(1).isRed();
            }
            if (!wv.isEmpty() && z3) {
                g gVar = new g();
                gVar.aV(true);
                gVar.setGiftName("发红包");
                wv.add(1, gVar);
            }
        }
        c(this.aCz, z);
        ep("1");
    }

    private void pC() {
        this.aCY = 0;
        this.aCZ = 0;
        this.mSelectedPosition = 0;
        this.aDa = 0;
        if (this.aDg != null) {
            this.aDg.clear();
        }
        if (this.aCV != null) {
            this.aCV.clear();
        }
        if (this.aCK != null) {
            this.aCK.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.wu()) {
            if (gVar.wq() == 6 && this.aBv < 3) {
                return false;
            }
            if (gVar.wq() == 7 && this.aBv < 7) {
                return false;
            }
            if (gVar.wq() == 8 && this.aBv < 13) {
                return false;
            }
            if (gVar.wq() == 9 && this.aBv < 22) {
                return false;
            }
            if (gVar.wq() == 10 && this.aBv < 29) {
                return false;
            }
            if (gVar.wq() == 11 && this.aBv < 39) {
                return false;
            }
            if (gVar.wq() == 12 && this.aBv < 47) {
                return false;
            }
        }
        if (gVar.wt()) {
            return this.aBC;
        }
        return true;
    }

    private void yb() {
        if (ListUtils.getCount(this.aCA) != 0 && ListUtils.getCount(this.aCz) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.d> it = this.aCA.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.d next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.uL()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.aCz.iterator();
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
                Iterator<i> it3 = this.aCz.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().wv().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.wc()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aCA.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aCz.removeAll(arrayList2);
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
        List<g> wv;
        if (arrayList != null) {
            this.aDg.clear();
            this.aCV.clear();
            this.aCK.setAdapter(null);
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
                    if (iVar == null || (wv = iVar.wv()) == null || wv.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aCW.clear();
            z(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aCV.add(bU(i7));
                    this.aDg.append(i7, 1);
                } else {
                    i iVar2 = arrayList.get(i7);
                    iVar2.getCategoryId();
                    List<g> wv2 = iVar2.wv();
                    if (wv2 == null) {
                        i = 0;
                    } else {
                        i = wv2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aDh.get(i7)) {
                            this.aCV.add(bl(true));
                        } else {
                            this.aCV.add(b(arrayList3, -1, i7));
                        }
                    } else if (wv2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(wv2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(wv2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(wv2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aCW.add(arrayList2);
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
                                    if (gVar == null || gVar.vU() == null || !gVar.vU().equals(String.valueOf(this.aDl))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aCV.add(b(arrayList2, i3, i7));
                                this.aCU.removeCallbacks(null);
                                this.aCU.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aDe != null) {
                                            boolean wc = AlaGiftTabView.this.aDe.wc();
                                            AlaGiftTabView.this.bj(wc);
                                            if (!wc) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aDe);
                                                if (!c2) {
                                                    AlaGiftTabView.this.aCU.setStyle(AlaGiftTabView.this.aDe.wb() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.aCU.setStyle(AlaGiftTabView.this.aDe.wb() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.aCI.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.vU().equals(String.valueOf(this.aDl))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aCV.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aCV.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.aDg.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aCK.setAdapter(new AlaGiftPagerAdapter(this.aCV));
            yc();
            this.aCK.setCurrentItem(this.aCY);
            ye();
            if (z && !this.aDx && this.aDw) {
                this.aDx = true;
                yd();
            }
        }
    }

    private void yc() {
        int i = 0;
        if (this.aDl > 0 && !ListUtils.isEmpty(this.aCW)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aCW.size() && !z; i2++) {
                Iterator<g> it = this.aCW.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.vU() != null && next.vU().equals(String.valueOf(this.aDl))) {
                        this.aCY = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aqV == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.aCZ = this.aCY;
            this.aCW.clear();
        } else if (this.aDk > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aCA.size()) {
                    break;
                }
                com.baidu.live.data.d dVar = this.aCA.get(i3);
                if (dVar == null || this.aDk != dVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    bT(i3);
                    break;
                }
            }
            this.aCZ = this.aCY;
        }
    }

    private void z(List<i> list) {
        if (list != null && this.aDk > 0 && this.aDl <= 0) {
            for (i iVar : list) {
                if (iVar.getCategoryId() == this.aDk) {
                    List<g> wv = iVar.wv();
                    if (wv != null && !wv.isEmpty() && wv.get(0) != null) {
                        this.aDl = Integer.valueOf(wv.get(0).vU()).intValue();
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
                if (AlaGiftTabView.this.aCX != null) {
                    AlaGiftTabView.this.aCX.yk();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.ba(this.aBx);
        aVar.setGiftItems(list);
        aVar.bI(this.aBv);
        aVar.aO(this.aBC);
        aVar.bJ(i);
        if (this.isLandscape) {
            if (this.aCK.getHeight() > 0) {
                aVar.bK(this.aCK.getHeight() / 3);
            } else {
                this.aCK.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.bK(AlaGiftTabView.this.aCK.getHeight() / 3);
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
                if (tag instanceof a.C0132a) {
                    ((a.C0132a) tag).recycle();
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
            if (!this.aDj) {
                this.aCM.setVisibility(0);
            }
            this.aCN.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.d dVar = arrayList.get(i);
                if (!TextUtils.isEmpty(dVar.getCategoryName()) && (this.mType != 0 || (dVar.uL() != null && dVar.uL().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(dVar.getCategoryName());
                    viewGroup.setOnClickListener(new c(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aDd;
                    }
                    if (this.aCz.size() > i && this.aCz.get(i) != null) {
                        for (g gVar : this.aCz.get(i).wv()) {
                            if (gVar != null && gVar.wa() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aCN.addView(viewGroup, layoutParams);
                }
            }
            bV(this.aDa);
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
        List<g> wv;
        int childCount = this.aCN.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aDa != i || !this.aDb) && this.aCA.size() > i && this.aCA.get(i) != null) {
                int min = Math.min(i, this.aDg.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aDg.get(i4);
                }
                if (this.aCV.size() > i3 && this.aCz.size() > i && (this.aCV.get(i3) instanceof ViewGroup)) {
                    this.aCZ = i3;
                    i iVar = this.aCz.get(i);
                    if (iVar != null && iVar.wv() != null && !iVar.wv().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aCV.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aDb) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aCY) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.mShowing) {
                                        this.aDb = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aCA.size() > i && this.aCA.get(i) != null) {
                int categoryId = this.aCA.get(i).getCategoryId();
                if (!this.aDn.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aDn.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aCN.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.aCz.get(i6);
                if (iVar2.ww()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aCF, "");
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
                                    wv = iVar2.wv();
                                    if (wv != null) {
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
                    wv = iVar2.wv();
                    if (wv != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= wv.size()) {
                                break;
                            }
                            g gVar = wv.get(i9);
                            if (!gVar.wr() && !hashSet.contains(gVar.vU())) {
                                arrayList.add(gVar.vU());
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
                                SharedPrefHelper.getInstance().putString(this.aCF, jSONArray.toString());
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
                    if (this.aDt != 0) {
                        gradientTextView.setGradientTextColor(this.aDt, this.aDt);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    bW(i);
                    this.aDa = i;
                    this.aCM.scrollTo(viewGroup2.getLeft(), 0);
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
        if (this.aCR != null) {
            this.aCR.setVisibility(z ? this.aDp ? 8 : 0 : 8);
        }
        if (this.aCS != null) {
            TextView textView = this.aCS;
            if (!z && !this.aDp) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void bW(int i) {
        int childCount = this.aCN.getChildCount();
        if (i >= 0 && i < childCount && this.aCz != null && this.aCz.size() > i && this.aCz.get(i) != null) {
            this.aDh.get(i);
        }
    }

    public void s(int i, int i2) {
        this.aDk = i;
        this.aDl = i2;
    }

    public void X(long j) {
        if (this.aCR != null) {
            if (j >= 100 && (this.aBx || com.baidu.live.v.a.En().aQu.asV)) {
                this.aCR.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aCR.setText(String.valueOf(j));
        }
    }

    public void Y(long j) {
        if (this.aCS != null) {
            this.aCS.setText(String.valueOf(j));
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
        this.aCY = i;
        ye();
        xY();
        if (i >= 0 && i < this.aCV.size() && (this.aCV.get(i) instanceof ViewGroup)) {
            yd();
            ViewGroup viewGroup = (ViewGroup) this.aCV.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aCZ) {
                            aVar.bJ(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aCZ) {
                            aVar.bJ(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.aCP.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void yd() {
        JSONObject jSONObject = new JSONObject();
        com.baidu.live.data.d dVar = (com.baidu.live.data.d) ListUtils.getItem(this.aCA, this.aDa);
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

    private void ye() {
        int i = 0;
        for (int i2 = 0; i2 < this.aDg.size(); i2++) {
            for (int i3 = 0; i3 < this.aDg.get(i2); i3++) {
                if (i + i3 == this.aCY) {
                    if (this.aDg.get(i2) <= 1) {
                        this.aCL.setVisibility(4);
                    } else {
                        this.aCL.setVisibility(0);
                    }
                    this.aCL.setCount(this.aDg.get(i2));
                    this.aCL.onPageSelected(i3);
                    bV(i2);
                    return;
                }
            }
            i += this.aDg.get(i2);
        }
    }

    public g yf() {
        return this.aDe;
    }

    public int yg() {
        return this.aDf;
    }

    public void a(d dVar) {
        this.aCX = dVar;
    }

    public void bX(int i) {
        this.aDf = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aDA);
        MessageManager.getInstance().registerListener(this.aDB);
        MessageManager.getInstance().registerListener(this.aDC);
        MessageManager.getInstance().registerListener(this.aDD);
    }

    public void yh() {
        if (!ListUtils.isEmpty(this.aCV)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aCV) {
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
        if (!ListUtils.isEmpty(this.aCV) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aCV) {
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
    public void yi() {
        if (!ListUtils.isEmpty(this.aCV)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aCV) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aBC);
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
        if (this.aDe != null && this.aDe.wt()) {
            this.aCI.setStyleEnabled(this.aBC);
            if (this.aBC) {
                this.aCU.setStyle(this.aDe.wb() ? 2 : 1);
            } else {
                this.aCU.setStyle(this.aDe.wb() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.aDs = null;
        MessageManager.getInstance().unRegisterListener(this.aDA);
        MessageManager.getInstance().unRegisterListener(this.aDB);
        MessageManager.getInstance().unRegisterListener(this.aDC);
        MessageManager.getInstance().unRegisterListener(this.aDD);
        pC();
        if (this.aDq != null) {
            this.aDq.dismiss();
        }
    }

    public void ba(boolean z) {
        this.aBx = z;
    }

    public void bY(int i) {
        this.aBv = i;
    }

    public void d(g gVar) {
        this.aDe = gVar;
        this.aDl = Integer.valueOf(this.aDe.vU()).intValue();
        if (this.aDs != null) {
            this.aDs.a(gVar);
        }
        if (gVar != null && !gVar.wd()) {
            this.aDu.xE();
        }
    }

    public void xD() {
        if (this.aDu != null) {
            this.aDu.xD();
        }
    }

    public void xC() {
        if (this.aDu != null) {
            this.aDu.xC();
        }
    }

    public void bn(boolean z) {
        if (this.aCU != null) {
            this.aCU.setVisibility(z ? 0 : 4);
        }
    }
}

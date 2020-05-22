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
import com.baidu.live.data.ax;
import com.baidu.live.data.f;
import com.baidu.live.data.q;
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
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
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
    private int aGQ;
    private boolean aGS;
    private boolean aGZ;
    public ArrayList<i> aHY;
    private ArrayList<f> aHZ;
    private boolean aIA;
    private boolean aIB;
    private int aIC;
    private g aID;
    private int aIE;
    private SparseIntArray aIF;
    private SparseBooleanArray aIG;
    private View.OnClickListener aIH;
    private boolean aII;
    private int aIJ;
    private int aIK;
    private int aIL;
    private SparseBooleanArray aIM;
    private Set<String> aIN;
    private boolean aIO;
    private BdAlertDialog aIP;
    private int aIQ;
    private a aIR;
    private int aIS;
    private AlaComboBtnAnimView aIT;
    private boolean aIU;
    private boolean aIV;
    private boolean aIW;
    private View.OnClickListener aIX;
    AdapterView.OnItemClickListener aIY;
    private CustomMessageListener aIZ;
    private ArrayList<com.baidu.live.data.g> aIa;
    private final String aIe;
    private boolean aIf;
    private View aIg;
    private GiftPanelNumRoundRectView aIh;
    public TextView aIi;
    private BaseViewPager aIj;
    private RoundRectPageIndicator aIk;
    private HorizontalScrollView aIl;
    private LinearLayout aIm;
    private CommonEmptyView aIn;
    private View aIo;
    private com.baidu.live.gift.container.c aIp;
    private TextView aIq;
    private TextView aIr;
    private TextView aIs;
    public GiftPanelOperationSendView aIt;
    private List<View> aIu;
    private ArrayList<List<g>> aIv;
    private d aIw;
    private int aIx;
    private int aIy;
    private int aIz;
    private CustomMessageListener aJa;
    private CustomMessageListener aJb;
    private CustomMessageListener aJc;
    private int avV;
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
        void a(g gVar);

        void ak(String str, String str2);

        void c(boolean z, int i);

        void d(boolean z, String str);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void zA();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aIe = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aIu = new ArrayList();
        this.aIx = 0;
        this.aIy = 0;
        this.mSelectedPosition = 0;
        this.aIz = 0;
        this.aIF = new SparseIntArray();
        this.aIG = new SparseBooleanArray();
        this.isLandscape = false;
        this.aII = false;
        this.aIJ = -1;
        this.aIK = -1;
        this.aGS = false;
        this.aGQ = -1;
        this.aIM = new SparseBooleanArray();
        this.aIN = new HashSet();
        this.aIU = false;
        this.aGZ = false;
        this.aIV = false;
        this.aIW = false;
        this.aIX = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aIT == null || !AlaGiftTabView.this.aIT.yS()) {
                    if (AlaGiftTabView.this.aIp == null) {
                        AlaGiftTabView.this.aIp = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aIY);
                    }
                    AlaGiftTabView.this.bs(true);
                    AlaGiftTabView.this.aIp.a(AlaGiftTabView.this.aIg, AlaGiftTabView.this.aIa, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bs(false);
                        }
                    });
                }
            }
        };
        this.aIY = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.aIp.dismiss();
                if (AlaGiftTabView.this.aIa != null && AlaGiftTabView.this.aIa.size() > 0) {
                    if (i != AlaGiftTabView.this.aIa.size()) {
                        com.baidu.live.data.g gVar = (com.baidu.live.data.g) AlaGiftTabView.this.aIa.get(i);
                        if (gVar != null) {
                            int number = gVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.aID.aEl) != null) {
                                if (number == -1) {
                                    number = aVar.aEs;
                                }
                                if (number > AlaGiftTabView.this.aIQ) {
                                    number = AlaGiftTabView.this.aIQ;
                                }
                            }
                            AlaGiftTabView.this.eZ(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.zq();
                    return;
                }
                AlaGiftTabView.this.eZ("1");
            }
        };
        this.aIZ = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.aCS == 1 || cVar.aCS == 2 || cVar.aCS == 5 || cVar.aCS == 6) && cVar.aCT != null) {
                        AlaGiftTabView.this.am(cVar.aCT.getId(), cVar.aCT.getUrl());
                    }
                }
            }
        };
        this.aJa = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bn(true);
                if (AlaGiftTabView.this.aID != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aID) && AlaGiftTabView.this.aIf) {
                    AlaGiftTabView.this.aIt.setStyle(AlaGiftTabView.this.aID.xs() ? 2 : 1);
                    AlaGiftTabView.this.aIh.setStyleEnabled(true);
                }
            }
        };
        this.aJb = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                q qVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof q) && (qVar = (q) customResponsedMessage.getData()) != null && qVar.avC != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = qVar.avC.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aGZ != z2) {
                        AlaGiftTabView.this.aGZ = z2;
                        AlaGiftTabView.this.zz();
                        AlaGiftTabView.this.zy();
                    }
                }
            }
        };
        this.aJc = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.zp();
                    AlaGiftTabView.this.aIt.setStyle(AlaGiftTabView.this.aID.xs() ? 4 : 3);
                    AlaGiftTabView.this.aIh.setStyleEnabled(false);
                    if (AlaGiftTabView.this.aIR != null) {
                        AlaGiftTabView.this.aIR.d(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aIH = onClickListener;
        this.aII = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aIC = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        this.aIv = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aIQ = 9999;
                return;
            case 1:
                this.aIQ = 999;
                return;
            default:
                return;
        }
    }

    public void bX(int i) {
        int childCount;
        this.aIS = i;
        if (this.aIm != null && (childCount = this.aIm.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aIz) {
                    ((GradientTextView) ((ViewGroup) this.aIm.getChildAt(i2)).findViewById(a.g.text_view)).setGradientTextColor(this.aIS, this.aIS);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aIR = aVar;
    }

    public void al(String str, String str2) {
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
        this.aIg = this.mRoot.findViewById(a.g.gift_count_layout);
        this.aIg.setOnClickListener(this.aIX);
        this.aIh = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.aIi = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.aIi.setText("1");
        this.aIi.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.aIj = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.aIj.setOnPageChangeListener(this);
        this.aIk = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.aIm = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.aIl = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.aII) {
            this.aIl.setVisibility(8);
        }
        this.aIq = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.aIq.setOnClickListener(this.aIH);
        this.aIr = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.aIr.setOnClickListener(this.aIH);
        this.aIt = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.aIs = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.aIs.setOnClickListener(this.aIH);
        this.aIt.setOnClickListener(this.aIH);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.aIn = new CommonEmptyView(this.mContext.getPageActivity());
        this.aIn.setVisibility(8);
        this.aIn.addToParent(frameLayout);
        this.aIo = this.mRoot.findViewById(a.g.donate_layout);
        this.aIT = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.aIT.setComboClickListener(this.aIH);
        this.aIT.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void yT() {
                AlaGiftTabView.this.bv(true);
            }
        });
    }

    public void zn() {
        this.aIO = true;
        this.aIq.setVisibility(8);
        this.aIr.setVisibility(8);
        this.aIs.setVisibility(8);
    }

    public void bn(boolean z) {
        this.aIf = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.v.a.Ge().Gh() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aIs.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aIN.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aIN.add(str);
            }
        }
    }

    public void aO(boolean z) {
    }

    public void bB(int i) {
        this.aIL = i;
    }

    public void bo(boolean z) {
        this.aIV = z;
        if (z && !ListUtils.isEmpty(this.aHZ)) {
            zt();
            this.aIW = true;
        }
    }

    public void bp(boolean z) {
        this.aIU = z;
    }

    public void bY(int i) {
        this.avV = i;
    }

    public void aQ(boolean z) {
        this.aGZ = z;
    }

    public void bq(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.aIj.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24);
                this.aIj.setLayoutParams(layoutParams);
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
            AlaGiftTabView.this.bZ(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(int i) {
        if (this.aIR != null) {
            this.aIR.c(false, this.aIQ);
        }
        ca(i);
        this.aIj.setCurrentItem(this.aIx);
        zu();
        zo();
    }

    private void ca(int i) {
        int min = Math.min(i, this.aIF.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aIF.get(i3);
        }
        this.aIx = i2;
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
            AlaGiftTabView.this.aIy = AlaGiftTabView.this.aIx;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void zo() {
        if (this.aIR != null) {
            if (this.aID != null && this.aID.aEm) {
                this.aIR.ak(this.aID.aEn, this.aID.aEo);
            } else {
                this.aIR.ak(null, null);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.aIR != null) {
            this.aIR.c(false, this.aIQ);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.bQ(i);
                aVar.notifyDataSetChanged();
                this.aIo.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                eZ("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aID.xI()) {
                        this.aIt.setStyle(this.aID.xs() ? 4 : 3);
                        this.aIh.setStyleEnabled(false);
                        if (this.aIR != null) {
                            this.aIR.d(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aID.xv()) && this.mShowing) {
                            this.mContext.showToast(this.aID.xv());
                            return;
                        }
                        return;
                    }
                    zo();
                    this.aIt.setEnabled(true);
                    if (this.aID.xL()) {
                        if (this.aIR != null) {
                            this.aIR.d(false, null);
                        }
                        if (this.aID.xH() == 6 && this.aGQ < 3) {
                            i3 = 3;
                        } else if (this.aID.xH() == 7 && this.aGQ < 7) {
                            i3 = 7;
                        } else if (this.aID.xH() == 8 && this.aGQ < 13) {
                            i3 = 13;
                        } else if (this.aID.xH() == 9 && this.aGQ < 22) {
                            i3 = 22;
                        } else if (this.aID.xH() == 10 && this.aGQ < 29) {
                            i3 = 29;
                        } else if (this.aID.xH() == 11 && this.aGQ < 39) {
                            i3 = 39;
                        } else if (this.aID.xH() == 12 && this.aGQ < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.aIt.setStyle(this.aID.xs() ? 2 : 1);
                    } else {
                        this.aIt.setStyle(this.aID.xs() ? 4 : 3);
                    }
                    this.aIh.setStyleEnabled(z);
                    zz();
                    i2 = i3;
                } else {
                    this.aIt.setStyle(this.aID.xs() ? 2 : 1);
                    if (this.aID.aEl != null && this.aID.aEl.aEr != null && this.aID.aEl.aEr.equals("20")) {
                        this.aIt.setText("使用");
                    } else {
                        this.aIt.setText("赠送");
                    }
                    this.aIh.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aID.xt()) {
                    br(true);
                } else {
                    br(false);
                    eZ("1");
                }
                d(false, i2);
                return;
            }
            this.aIt.setStyle(3);
            return;
        }
        this.aIt.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.a aVar;
        if (this.mShowing && this.aID != null) {
            if (this.mType == 0) {
                if (this.aID.xK() && !this.aGZ) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aID.xv()) && this.aID.xI() && !z) {
                    this.mContext.showToast(this.aID.xv());
                } else if (this.aID.xL() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aID.xG()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (aVar = this.aID.aEl) != null && !TextUtils.isEmpty(aVar.aEu)) {
                this.mContext.showToast(aVar.aEu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.v.a.Ge().aYP != null && com.baidu.live.v.a.Ge().aYP.aAH != null) {
            String str = com.baidu.live.v.a.Ge().aYP.aAH.azT;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.xH()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zp() {
        if (!this.aIB) {
            this.aIP = new BdAlertDialog(this.mContext.getPageActivity());
            this.aIP.setCancelable(false);
            this.aIP.setCanceledOnTouchOutside(false);
            this.aIP.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.aIP.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aIL)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aIP.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.aIP.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aIP.setPositiveButtonTextColor(-57754);
                this.aIP.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aIP.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aIB = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aIP.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aIB = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aIP.create(this.mContext).show();
            this.aIB = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.v.a.Ge().aWF.axf;
        if (z2) {
            this.aIg.setVisibility(4);
            this.aIt.setStyle(1);
        } else {
            View view = this.aIg;
            if (this.aID == null || !this.aID.xs()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.aIR != null) {
            this.aIR.d(z2, this.aID != null ? this.aID.xo() : null);
        }
    }

    public void zq() {
        if (this.aIR != null) {
            this.aIR.c(true, this.aIQ);
        }
    }

    @Override // com.baidu.live.view.input.b.a
    public void eW(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        eZ(str);
    }

    public void eZ(String str) {
        this.aIi.setText(str);
        this.aIi.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        bs(false);
        if (this.aID != null && this.aID.xs()) {
            this.aIg.setVisibility(0);
            this.aIE = JavaTypesHelper.toInt(this.aIi.getText().toString(), 1);
            return;
        }
        this.aIg.setVisibility(4);
        this.aIE = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(boolean z) {
        this.aIi.setGravity(17);
        if (z) {
            this.aIi.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aIi.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<f> arrayList2, ArrayList<com.baidu.live.data.g> arrayList3, boolean z2, int i) {
        if (this.aHY == null || this.aHY.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            if (this.aHY == null) {
                this.aHY = new ArrayList<>();
            }
            this.aHY.clear();
            if (arrayList != null) {
                this.aHY.addAll(arrayList);
            }
            this.aHZ = arrayList2;
            this.aIa = arrayList3;
            this.aIA = false;
            if (this.aHZ == null || this.aHZ.isEmpty()) {
                this.aIl.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void z(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aIu != null) {
            for (View view : this.aIu) {
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
        zr();
        if (this.aHY == null || this.aHY.size() <= 0 || !z2) {
            pI();
            if (this.aIk != null) {
                this.aIk.setVisibility(4);
            }
            this.aIo.setVisibility(4);
            this.aIn.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.aIn.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aIn.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.aIn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.v.a.Ge().aWF.ayz && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aIn.setTitle(string);
            this.aIn.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aIw != null) {
                        AlaGiftTabView.this.aIw.zA();
                    }
                }
            });
            this.aIn.setVisibility(0);
            return;
        }
        this.aIn.setVisibility(8);
        if (z) {
            h(this.aHZ);
        }
        ax axVar = com.baidu.live.v.a.Ge().aYP;
        if (this.mType == 0 && axVar != null && axVar.aAL != null && axVar.aAL.aCx && !this.aIU && this.aHY.get(0) != null && this.aHY.get(0).xM() != null) {
            List<g> xM = this.aHY.get(0).xM();
            if (xM.size() <= 1 || xM.get(1) == null) {
                z3 = true;
            } else {
                z3 = !xM.get(1).isRed();
            }
            if (!xM.isEmpty() && z3) {
                g gVar = new g();
                gVar.ba(true);
                gVar.setGiftName("发红包");
                xM.add(1, gVar);
            }
        }
        c(this.aHY, z);
        eZ("1");
    }

    private void pI() {
        this.aIx = 0;
        this.aIy = 0;
        this.mSelectedPosition = 0;
        this.aIz = 0;
        if (this.aIF != null) {
            this.aIF.clear();
        }
        if (this.aIu != null) {
            this.aIu.clear();
        }
        if (this.aIj != null) {
            this.aIj.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.xL()) {
            if (gVar.xH() == 6 && this.aGQ < 3) {
                return false;
            }
            if (gVar.xH() == 7 && this.aGQ < 7) {
                return false;
            }
            if (gVar.xH() == 8 && this.aGQ < 13) {
                return false;
            }
            if (gVar.xH() == 9 && this.aGQ < 22) {
                return false;
            }
            if (gVar.xH() == 10 && this.aGQ < 29) {
                return false;
            }
            if (gVar.xH() == 11 && this.aGQ < 39) {
                return false;
            }
            if (gVar.xH() == 12 && this.aGQ < 47) {
                return false;
            }
        }
        if (gVar.xK()) {
            return this.aGZ;
        }
        return true;
    }

    private void zr() {
        if (ListUtils.getCount(this.aHZ) != 0 && ListUtils.getCount(this.aHY) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<f> it = this.aHZ.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.vW()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.aHY.iterator();
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
                Iterator<i> it3 = this.aHY.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().xM().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.xt()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aHZ.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aHY.removeAll(arrayList2);
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
        List<g> xM;
        if (arrayList != null) {
            this.aIF.clear();
            this.aIu.clear();
            this.aIj.setAdapter(null);
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
                    if (iVar == null || (xM = iVar.xM()) == null || xM.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aIv.clear();
            z(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aIu.add(cb(i7));
                    this.aIF.append(i7, 1);
                } else {
                    i iVar2 = arrayList.get(i7);
                    iVar2.getCategoryId();
                    List<g> xM2 = iVar2.xM();
                    if (xM2 == null) {
                        i = 0;
                    } else {
                        i = xM2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aIG.get(i7)) {
                            this.aIu.add(bt(true));
                        } else {
                            this.aIu.add(b(arrayList3, -1, i7));
                        }
                    } else if (xM2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(xM2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(xM2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(xM2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aIv.add(arrayList2);
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
                                    if (gVar == null || gVar.xl() == null || !gVar.xl().equals(String.valueOf(this.aIK))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aIu.add(b(arrayList2, i3, i7));
                                this.aIt.removeCallbacks(null);
                                this.aIt.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aID != null) {
                                            boolean xt = AlaGiftTabView.this.aID.xt();
                                            AlaGiftTabView.this.br(xt);
                                            if (!xt) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aID);
                                                if (!c2) {
                                                    AlaGiftTabView.this.aIt.setStyle(AlaGiftTabView.this.aID.xs() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.aIt.setStyle(AlaGiftTabView.this.aID.xs() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.aIh.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.xl().equals(String.valueOf(this.aIK))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aIu.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aIu.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.aIF.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aIj.setAdapter(new AlaGiftPagerAdapter(this.aIu));
            zs();
            this.aIj.setCurrentItem(this.aIx);
            zu();
            if (z && !this.aIW && this.aIV) {
                this.aIW = true;
                zt();
            }
        }
    }

    private void zs() {
        int i = 0;
        if (this.aIK > 0 && !ListUtils.isEmpty(this.aIv)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aIv.size() && !z; i2++) {
                Iterator<g> it = this.aIv.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.xl() != null && next.xl().equals(String.valueOf(this.aIK))) {
                        this.aIx = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.avV == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.aIy = this.aIx;
            this.aIv.clear();
        } else if (this.aIJ > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aHZ.size()) {
                    break;
                }
                f fVar = this.aHZ.get(i3);
                if (fVar == null || this.aIJ != fVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    ca(i3);
                    break;
                }
            }
            this.aIy = this.aIx;
        }
    }

    private void z(List<i> list) {
        if (list != null && this.aIJ > 0 && this.aIK <= 0) {
            for (i iVar : list) {
                if (iVar.getCategoryId() == this.aIJ) {
                    List<g> xM = iVar.xM();
                    if (xM != null && !xM.isEmpty() && xM.get(0) != null) {
                        this.aIK = Integer.valueOf(xM.get(0).xl()).intValue();
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
        commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aIw != null) {
                    AlaGiftTabView.this.aIw.zA();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.bf(this.aGS);
        aVar.setGiftItems(list);
        aVar.bP(this.aGQ);
        aVar.aQ(this.aGZ);
        aVar.bQ(i);
        if (this.isLandscape) {
            if (this.aIj.getHeight() > 0) {
                aVar.bR(this.aIj.getHeight() / 3);
            } else {
                this.aIj.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.bR(AlaGiftTabView.this.aIj.getHeight() / 3);
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
                if (tag instanceof a.C0163a) {
                    ((a.C0163a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout cb(int i) {
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
    private void h(ArrayList<f> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.aII) {
                this.aIl.setVisibility(0);
            }
            this.aIm.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                f fVar = arrayList.get(i);
                if (!TextUtils.isEmpty(fVar.getCategoryName()) && (this.mType != 0 || (fVar.vW() != null && fVar.vW().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(fVar.getCategoryName());
                    viewGroup.setOnClickListener(new c(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aIC;
                    }
                    if (this.aHY.size() > i && this.aHY.get(i) != null) {
                        for (g gVar : this.aHY.get(i).xM()) {
                            if (gVar != null && gVar.xr() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aIm.addView(viewGroup, layoutParams);
                }
            }
            cc(this.aIz);
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
    private void cc(int i) {
        int i2;
        JSONArray jSONArray;
        JSONException e;
        List<g> xM;
        int childCount = this.aIm.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aIz != i || !this.aIA) && this.aHZ.size() > i && this.aHZ.get(i) != null) {
                int min = Math.min(i, this.aIF.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aIF.get(i4);
                }
                if (this.aIu.size() > i3 && this.aHY.size() > i && (this.aIu.get(i3) instanceof ViewGroup)) {
                    this.aIy = i3;
                    i iVar = this.aHY.get(i);
                    if (iVar != null && iVar.xM() != null && !iVar.xM().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aIu.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aIA) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aIx) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.mShowing) {
                                        this.aIA = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aHZ.size() > i && this.aHZ.get(i) != null) {
                int categoryId = this.aHZ.get(i).getCategoryId();
                if (!this.aIM.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aIM.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aIm.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.aHY.get(i6);
                if (iVar2.xN()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aIe, "");
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
                                    xM = iVar2.xM();
                                    if (xM != null) {
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
                    xM = iVar2.xM();
                    if (xM != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= xM.size()) {
                                break;
                            }
                            g gVar = xM.get(i9);
                            if (!gVar.xI() && !hashSet.contains(gVar.xl())) {
                                arrayList.add(gVar.xl());
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
                                SharedPrefHelper.getInstance().putString(this.aIe, jSONArray.toString());
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
                    if (this.aIS != 0) {
                        gradientTextView.setGradientTextColor(this.aIS, this.aIS);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    cd(i);
                    this.aIz = i;
                    this.aIl.scrollTo(viewGroup2.getLeft(), 0);
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
        if (this.aIq != null) {
            this.aIq.setVisibility(z ? this.aIO ? 8 : 0 : 8);
        }
        if (this.aIr != null) {
            TextView textView = this.aIr;
            if (!z && !this.aIO) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void cd(int i) {
        int childCount = this.aIm.getChildCount();
        if (i >= 0 && i < childCount && this.aHY != null && this.aHY.size() > i && this.aHY.get(i) != null) {
            this.aIG.get(i);
        }
    }

    public void s(int i, int i2) {
        this.aIJ = i;
        this.aIK = i2;
    }

    public void ab(long j) {
        if (this.aIq != null) {
            if (j >= 100 && (this.aGS || com.baidu.live.v.a.Ge().aWF.axV)) {
                this.aIq.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aIq.setText(String.valueOf(j));
        }
    }

    public void ac(long j) {
        if (this.aIr != null) {
            this.aIr.setText(String.valueOf(j));
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
        this.aIx = i;
        zu();
        zo();
        if (i >= 0 && i < this.aIu.size() && (this.aIu.get(i) instanceof ViewGroup)) {
            zt();
            ViewGroup viewGroup = (ViewGroup) this.aIu.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aIy) {
                            aVar.bQ(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aIy) {
                            aVar.bQ(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.aIo.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void zt() {
        JSONObject jSONObject = new JSONObject();
        f fVar = (f) ListUtils.getItem(this.aHZ, this.aIz);
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

    private void zu() {
        int i = 0;
        for (int i2 = 0; i2 < this.aIF.size(); i2++) {
            for (int i3 = 0; i3 < this.aIF.get(i2); i3++) {
                if (i + i3 == this.aIx) {
                    if (this.aIF.get(i2) <= 1) {
                        this.aIk.setVisibility(4);
                    } else {
                        this.aIk.setVisibility(0);
                    }
                    this.aIk.setCount(this.aIF.get(i2));
                    this.aIk.onPageSelected(i3);
                    cc(i2);
                    return;
                }
            }
            i += this.aIF.get(i2);
        }
    }

    public g zv() {
        return this.aID;
    }

    public int zw() {
        return this.aIE;
    }

    public void a(d dVar) {
        this.aIw = dVar;
    }

    public void ce(int i) {
        this.aIE = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aIZ);
        MessageManager.getInstance().registerListener(this.aJa);
        MessageManager.getInstance().registerListener(this.aJb);
        MessageManager.getInstance().registerListener(this.aJc);
    }

    public void zx() {
        if (!ListUtils.isEmpty(this.aIu)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aIu) {
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
        if (!ListUtils.isEmpty(this.aIu) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aIu) {
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
    public void zy() {
        if (!ListUtils.isEmpty(this.aIu)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aIu) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aGZ);
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
    public void zz() {
        if (this.aID != null && this.aID.xK()) {
            this.aIh.setStyleEnabled(this.aGZ);
            if (this.aGZ) {
                this.aIt.setStyle(this.aID.xs() ? 2 : 1);
            } else {
                this.aIt.setStyle(this.aID.xs() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.aIR = null;
        MessageManager.getInstance().unRegisterListener(this.aIZ);
        MessageManager.getInstance().unRegisterListener(this.aJa);
        MessageManager.getInstance().unRegisterListener(this.aJb);
        MessageManager.getInstance().unRegisterListener(this.aJc);
        pI();
        if (this.aIP != null) {
            this.aIP.dismiss();
        }
    }

    public void bf(boolean z) {
        this.aGS = z;
    }

    public void cf(int i) {
        this.aGQ = i;
    }

    public void d(g gVar) {
        this.aID = gVar;
        this.aIK = Integer.valueOf(this.aID.xl()).intValue();
        if (this.aIR != null) {
            this.aIR.a(gVar);
        }
        if (gVar != null && !gVar.xu()) {
            this.aIT.yR();
        }
    }

    public void yQ() {
        if (this.aIT != null) {
            this.aIT.yQ();
        }
    }

    public void yP() {
        if (this.aIT != null) {
            this.aIT.yP();
        }
    }

    public void bv(boolean z) {
        if (this.aIt != null) {
            this.aIt.setVisibility(z ? 0 : 4);
        }
    }
}

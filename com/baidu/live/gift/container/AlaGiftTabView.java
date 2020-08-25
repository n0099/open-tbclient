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
import com.baidu.live.data.be;
import com.baidu.live.data.r;
import com.baidu.live.data.t;
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
/* loaded from: classes7.dex */
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, b.a {
    private int aEB;
    private int aPX;
    private boolean aPZ;
    private boolean aQg;
    private CommonEmptyView aRA;
    private View aRB;
    private com.baidu.live.gift.container.c aRC;
    private TextView aRD;
    private TextView aRE;
    private TextView aRF;
    public GiftPanelOperationSendView aRG;
    private List<View> aRH;
    private ArrayList<List<g>> aRI;
    private d aRJ;
    private int aRK;
    private int aRL;
    private int aRM;
    private boolean aRN;
    private boolean aRO;
    private int aRP;
    private g aRQ;
    private int aRR;
    private SparseIntArray aRS;
    private SparseBooleanArray aRT;
    private View.OnClickListener aRU;
    private boolean aRV;
    private int aRW;
    private int aRX;
    private int aRY;
    private SparseBooleanArray aRZ;
    public ArrayList<i> aRl;
    private ArrayList<com.baidu.live.data.f> aRm;
    private ArrayList<com.baidu.live.data.g> aRn;
    private final String aRr;
    private boolean aRs;
    private View aRt;
    private GiftPanelNumRoundRectView aRu;
    public TextView aRv;
    private BaseViewPager aRw;
    private RoundRectPageIndicator aRx;
    private HorizontalScrollView aRy;
    private LinearLayout aRz;
    private Set<String> aSa;
    private boolean aSb;
    private BdAlertDialog aSc;
    private int aSd;
    private a aSe;
    private int aSf;
    private AlaComboBtnAnimView aSg;
    private TbImageView aSh;
    private com.baidu.live.gift.container.d aSi;
    private boolean aSj;
    private boolean aSk;
    private boolean aSl;
    private View.OnClickListener aSm;
    AdapterView.OnItemClickListener aSn;
    private CustomMessageListener aSo;
    private CustomMessageListener aSp;
    private CustomMessageListener aSq;
    private CustomMessageListener aSr;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private ViewGroup mRoot;
    private int mSelectedPosition;
    private boolean mShowing;
    private int mType;
    private String otherParams;
    private String roomId;

    /* loaded from: classes7.dex */
    public interface a {
        void a(g gVar);

        void ao(String str, String str2);

        void c(boolean z, int i);

        void e(boolean z, String str);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void Gf();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aRr = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aRH = new ArrayList();
        this.aRK = 0;
        this.aRL = 0;
        this.mSelectedPosition = 0;
        this.aRM = 0;
        this.aRS = new SparseIntArray();
        this.aRT = new SparseBooleanArray();
        this.isLandscape = false;
        this.aRV = false;
        this.aRW = -1;
        this.aRX = -1;
        this.aPZ = false;
        this.aPX = -1;
        this.aRZ = new SparseBooleanArray();
        this.aSa = new HashSet();
        this.aSj = false;
        this.aQg = false;
        this.aSk = false;
        this.aSl = false;
        this.aSm = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aSg == null || !AlaGiftTabView.this.aSg.Fx()) {
                    if (AlaGiftTabView.this.aRC == null) {
                        AlaGiftTabView.this.aRC = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aSn);
                    }
                    AlaGiftTabView.this.bA(true);
                    AlaGiftTabView.this.aRC.a(AlaGiftTabView.this.aRt, AlaGiftTabView.this.aRn, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bA(false);
                        }
                    });
                }
            }
        };
        this.aSn = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.aRC.dismiss();
                if (AlaGiftTabView.this.aRn != null && AlaGiftTabView.this.aRn.size() > 0) {
                    if (i != AlaGiftTabView.this.aRn.size()) {
                        com.baidu.live.data.g gVar = (com.baidu.live.data.g) AlaGiftTabView.this.aRn.get(i);
                        if (gVar != null) {
                            int number = gVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.aRQ.aNn) != null) {
                                if (number == -1) {
                                    number = aVar.aNu;
                                }
                                if (number > AlaGiftTabView.this.aSd) {
                                    number = AlaGiftTabView.this.aSd;
                                }
                            }
                            AlaGiftTabView.this.gz(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.FV();
                    return;
                }
                AlaGiftTabView.this.gz("1");
            }
        };
        this.aSo = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.aLP == 1 || cVar.aLP == 2 || cVar.aLP == 5 || cVar.aLP == 6) && cVar.aLQ != null) {
                        AlaGiftTabView.this.aq(cVar.aLQ.getId(), cVar.aLQ.getUrl());
                    }
                }
            }
        };
        this.aSp = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bv(true);
                if (AlaGiftTabView.this.aRQ != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aRQ) && AlaGiftTabView.this.aRs) {
                    AlaGiftTabView.this.aRG.setStyle(AlaGiftTabView.this.aRQ.DX() ? 2 : 1);
                    AlaGiftTabView.this.aRu.setStyleEnabled(true);
                }
            }
        };
        this.aSq = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                r rVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null && rVar.aEd != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = rVar.aEd.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aQg != z2) {
                        AlaGiftTabView.this.aQg = z2;
                        AlaGiftTabView.this.Ge();
                        AlaGiftTabView.this.Gd();
                    }
                }
            }
        };
        this.aSr = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.FU();
                    AlaGiftTabView.this.aRG.setStyle(AlaGiftTabView.this.aRQ.DX() ? 4 : 3);
                    AlaGiftTabView.this.aRu.setStyleEnabled(false);
                    if (AlaGiftTabView.this.aSe != null) {
                        AlaGiftTabView.this.aSe.e(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aRU = onClickListener;
        this.aRV = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aRP = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        this.aRI = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aSd = 9999;
                return;
            case 1:
                this.aSd = 999;
                return;
            default:
                return;
        }
    }

    public void ea(int i) {
        int childCount;
        this.aSf = i;
        if (this.aRz != null && (childCount = this.aRz.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aRM) {
                    ((GradientTextView) ((ViewGroup) this.aRz.getChildAt(i2)).findViewById(a.g.text_view)).setGradientTextColor(this.aSf, this.aSf);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aSe = aVar;
    }

    public void ap(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bu(boolean z) {
        this.mShowing = z;
    }

    public void onVisibilityChanged(boolean z) {
        bu(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        this.aRt = this.mRoot.findViewById(a.g.gift_count_layout);
        this.aRt.setOnClickListener(this.aSm);
        this.aRu = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.aRv = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.aRv.setText("1");
        this.aRv.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.aRw = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.aRw.setOnPageChangeListener(this);
        this.aRx = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.aRz = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.aRy = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.aRV) {
            this.aRy.setVisibility(8);
        }
        this.aRD = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.aRD.setOnClickListener(this.aRU);
        this.aRE = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.aRE.setOnClickListener(this.aRU);
        this.aRG = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.aRF = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.aRF.setOnClickListener(this.aRU);
        this.aRG.setOnClickListener(this.aRU);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.aRA = new CommonEmptyView(this.mContext.getPageActivity());
        this.aRA.setVisibility(8);
        this.aRA.addToParent(frameLayout);
        this.aRB = this.mRoot.findViewById(a.g.donate_layout);
        this.aSg = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.aSg.setComboClickListener(this.aRU);
        this.aSg.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void Fy() {
                AlaGiftTabView.this.bD(true);
            }
        });
        this.aSh = (TbImageView) this.mRoot.findViewById(a.g.iv_official);
    }

    public void FS() {
        this.aSb = true;
        this.aRD.setVisibility(8);
        this.aRE.setVisibility(8);
        this.aRF.setVisibility(8);
    }

    public void bv(boolean z) {
        this.aRs = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.w.a.Nk().Nn() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aRF.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aSa.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aSa.add(str);
            }
        }
    }

    public void aW(boolean z) {
    }

    public void dx(int i) {
        this.aRY = i;
    }

    public void bw(boolean z) {
        this.aSk = z;
        if (z && !ListUtils.isEmpty(this.aRm)) {
            FY();
            this.aSl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar) {
        if (tVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_pop_show"));
            if (this.aSi == null) {
                this.aSi = new com.baidu.live.gift.container.d(this.mContext);
            }
            this.aSi.n(tVar.dialogTitle, tVar.aEu + tVar.aEv, tVar.aEv);
        }
    }

    private void Q(View view) {
        if (this.aSi == null) {
            this.aSi = new com.baidu.live.gift.container.d(this.mContext);
        }
        this.aSi.O(view);
    }

    public void bx(boolean z) {
        this.aSj = z;
    }

    public void eb(int i) {
        this.aEB = i;
    }

    public void aY(boolean z) {
        this.aQg = z;
    }

    public void by(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.aRw.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24);
                this.aRw.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        private int mPosition;

        public c(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaGiftTabView.this.ec(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ec(int i) {
        if (this.aSe != null) {
            this.aSe.c(false, this.aSd);
        }
        ed(i);
        this.aRw.setCurrentItem(this.aRK);
        FZ();
        FT();
    }

    private void ed(int i) {
        int min = Math.min(i, this.aRS.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aRS.get(i3);
        }
        this.aRK = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            g item = ((com.baidu.live.gift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.isRed()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.r(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.aRL = AlaGiftTabView.this.aRK;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void FT() {
        if (this.aSe != null) {
            if (this.aRQ != null && this.aRQ.aNo) {
                this.aSe.ao(this.aRQ.aNp, this.aRQ.aNq);
            } else {
                this.aSe.ao(null, null);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.aSe != null) {
            this.aSe.c(false, this.aSd);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.dT(i);
                aVar.notifyDataSetChanged();
                this.aRB.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                gz("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aRQ.En()) {
                        this.aRG.setStyle(this.aRQ.DX() ? 4 : 3);
                        this.aRu.setStyleEnabled(false);
                        if (this.aSe != null) {
                            this.aSe.e(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aRQ.Ea()) && this.mShowing) {
                            this.mContext.showToast(this.aRQ.Ea());
                            return;
                        }
                        return;
                    }
                    FT();
                    this.aRG.setEnabled(true);
                    if (this.aRQ.Eq()) {
                        if (this.aSe != null) {
                            this.aSe.e(false, null);
                        }
                        if (this.aRQ.Em() == 6 && this.aPX < 3) {
                            i3 = 3;
                        } else if (this.aRQ.Em() == 7 && this.aPX < 7) {
                            i3 = 7;
                        } else if (this.aRQ.Em() == 8 && this.aPX < 13) {
                            i3 = 13;
                        } else if (this.aRQ.Em() == 9 && this.aPX < 22) {
                            i3 = 22;
                        } else if (this.aRQ.Em() == 10 && this.aPX < 29) {
                            i3 = 29;
                        } else if (this.aRQ.Em() == 11 && this.aPX < 39) {
                            i3 = 39;
                        } else if (this.aRQ.Em() == 12 && this.aPX < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.aRG.setStyle(this.aRQ.DX() ? 2 : 1);
                    } else {
                        this.aRG.setStyle(this.aRQ.DX() ? 4 : 3);
                    }
                    this.aRu.setStyleEnabled(z);
                    Ge();
                    i2 = i3;
                } else {
                    this.aRG.setStyle(this.aRQ.DX() ? 2 : 1);
                    if (this.aRQ.aNn != null && this.aRQ.aNn.aNt != null && this.aRQ.aNn.aNt.equals("20")) {
                        this.aRG.setText("使用");
                    } else {
                        this.aRG.setText("赠送");
                    }
                    this.aRu.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aRQ.DY()) {
                    bz(true);
                } else {
                    bz(false);
                    gz("1");
                }
                d(false, i2);
                return;
            }
            this.aRG.setStyle(3);
            return;
        }
        this.aRG.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.a aVar;
        if (this.mShowing && this.aRQ != null) {
            if (this.mType == 0) {
                if (this.aRQ.Ep() && !this.aQg) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aRQ.Ea()) && this.aRQ.En() && !z) {
                    this.mContext.showToast(this.aRQ.Ea());
                } else if (this.aRQ.Eq() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aRQ.El()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (aVar = this.aRQ.aNn) != null && !TextUtils.isEmpty(aVar.aNw)) {
                this.mContext.showToast(aVar.aNw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.w.a.Nk().bka != null && com.baidu.live.w.a.Nk().bka.aJx != null) {
            String str = com.baidu.live.w.a.Nk().bka.aJx.aIJ;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Em()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FU() {
        if (!this.aRO) {
            this.aSc = new BdAlertDialog(this.mContext.getPageActivity());
            this.aSc.setCancelable(false);
            this.aSc.setCanceledOnTouchOutside(false);
            this.aSc.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.aSc.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aRY)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aSc.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.aSc.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aSc.setPositiveButtonTextColor(-57754);
                this.aSc.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aSc.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aRO = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aSc.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aRO = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aSc.create(this.mContext).show();
            this.aRO = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.w.a.Nk().beH.aFL;
        if (z2) {
            this.aRt.setVisibility(4);
            this.aRG.setStyle(1);
        } else {
            View view = this.aRt;
            if (this.aRQ == null || !this.aRQ.DX()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.aSe != null) {
            this.aSe.e(z2, this.aRQ != null ? this.aRQ.getThumbnail_url() : null);
        }
    }

    public void FV() {
        if (this.aSe != null) {
            this.aSe.c(true, this.aSd);
        }
    }

    @Override // com.baidu.live.view.input.b.a
    public void gw(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        gz(str);
    }

    public void gz(String str) {
        this.aRv.setText(str);
        this.aRv.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        bA(false);
        if (this.aRQ != null && this.aRQ.DX()) {
            this.aRt.setVisibility(0);
            this.aRR = JavaTypesHelper.toInt(this.aRv.getText().toString(), 1);
            return;
        }
        this.aRt.setVisibility(4);
        this.aRR = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(boolean z) {
        this.aRv.setGravity(17);
        if (z) {
            this.aRv.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aRv.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<com.baidu.live.data.g> arrayList3, boolean z2, int i) {
        if (this.aRl == null || this.aRl.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            if (this.aRl == null) {
                this.aRl = new ArrayList<>();
            }
            this.aRl.clear();
            if (arrayList != null) {
                this.aRl.addAll(arrayList);
            }
            this.aRm = arrayList2;
            this.aRn = arrayList3;
            this.aRN = false;
            if (this.aRm == null || this.aRm.isEmpty()) {
                this.aRy.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void A(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aRH != null) {
            for (View view : this.aRH) {
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
        FW();
        if (this.aRl == null || this.aRl.size() <= 0 || !z2) {
            rz();
            if (this.aRx != null) {
                this.aRx.setVisibility(4);
            }
            this.aRB.setVisibility(4);
            this.aRA.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.aRA.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aRA.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.aRA.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.w.a.Nk().beH.aHl && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aRA.setTitle(string);
            this.aRA.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aRJ != null) {
                        AlaGiftTabView.this.aRJ.Gf();
                    }
                }
            });
            this.aRA.setVisibility(0);
            return;
        }
        this.aRA.setVisibility(8);
        if (z) {
            m(this.aRm);
        }
        be beVar = com.baidu.live.w.a.Nk().bka;
        if (this.mType == 0 && beVar != null && beVar.aJB != null && beVar.aJB.aLs && !this.aSj && this.aRl.get(0) != null && this.aRl.get(0).Er() != null) {
            List<g> Er = this.aRl.get(0).Er();
            if (Er.size() <= 1 || Er.get(1) == null) {
                z3 = true;
            } else {
                z3 = !Er.get(1).isRed();
            }
            if (!Er.isEmpty() && z3) {
                g gVar = new g();
                gVar.bi(true);
                gVar.setGiftName("发红包");
                Er.add(1, gVar);
            }
        }
        c(this.aRl, z);
        gz("1");
    }

    private void rz() {
        this.aRK = 0;
        this.aRL = 0;
        this.mSelectedPosition = 0;
        this.aRM = 0;
        if (this.aRS != null) {
            this.aRS.clear();
        }
        if (this.aRH != null) {
            this.aRH.clear();
        }
        if (this.aRw != null) {
            this.aRw.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.Eq()) {
            if (gVar.Em() == 6 && this.aPX < 3) {
                return false;
            }
            if (gVar.Em() == 7 && this.aPX < 7) {
                return false;
            }
            if (gVar.Em() == 8 && this.aPX < 13) {
                return false;
            }
            if (gVar.Em() == 9 && this.aPX < 22) {
                return false;
            }
            if (gVar.Em() == 10 && this.aPX < 29) {
                return false;
            }
            if (gVar.Em() == 11 && this.aPX < 39) {
                return false;
            }
            if (gVar.Em() == 12 && this.aPX < 47) {
                return false;
            }
        }
        if (gVar.Ep()) {
            return this.aQg;
        }
        return true;
    }

    public void b(final t tVar) {
        if (tVar == null || TextUtils.isEmpty(tVar.iconUrl)) {
            this.aSh.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_show"));
            this.aSh.setVisibility(0);
            this.aSh.startLoad(tVar.iconUrl, 10, false);
            this.aSh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_clk"));
                    AlaGiftTabView.this.a(tVar);
                }
            });
            String str = "key_live_official_tip" + currentAccount;
            if (com.baidu.live.c.AD().getInt(str, 0) == 0 && this.aSk) {
                Q(this.aSh);
                com.baidu.live.c.AD().putInt(str, 1);
            }
        }
    }

    private void FW() {
        if (ListUtils.getCount(this.aRm) != 0 && ListUtils.getCount(this.aRl) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.f> it = this.aRm.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.f next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.Cu()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.aRl.iterator();
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
                Iterator<i> it3 = this.aRl.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().Er().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.DY()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aRm.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aRl.removeAll(arrayList2);
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
        List<g> Er;
        if (arrayList != null) {
            this.aRS.clear();
            this.aRH.clear();
            this.aRw.setAdapter(null);
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
                    if (iVar == null || (Er = iVar.Er()) == null || Er.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aRI.clear();
            G(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aRH.add(ee(i7));
                    this.aRS.append(i7, 1);
                } else {
                    i iVar2 = arrayList.get(i7);
                    iVar2.getCategoryId();
                    List<g> Er2 = iVar2.Er();
                    if (Er2 == null) {
                        i = 0;
                    } else {
                        i = Er2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aRT.get(i7)) {
                            this.aRH.add(bB(true));
                        } else {
                            this.aRH.add(b(arrayList3, -1, i7));
                        }
                    } else if (Er2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(Er2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(Er2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(Er2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aRI.add(arrayList2);
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
                                    if (gVar == null || gVar.DR() == null || !gVar.DR().equals(String.valueOf(this.aRX))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aRH.add(b(arrayList2, i3, i7));
                                this.aRG.removeCallbacks(null);
                                this.aRG.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aRQ != null) {
                                            boolean DY = AlaGiftTabView.this.aRQ.DY();
                                            AlaGiftTabView.this.bz(DY);
                                            if (!DY) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aRQ);
                                                if (!c2) {
                                                    AlaGiftTabView.this.aRG.setStyle(AlaGiftTabView.this.aRQ.DX() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.aRG.setStyle(AlaGiftTabView.this.aRQ.DX() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.aRu.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.DR().equals(String.valueOf(this.aRX))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aRH.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aRH.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.aRS.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aRw.setAdapter(new AlaGiftPagerAdapter(this.aRH));
            FX();
            this.aRw.setCurrentItem(this.aRK);
            FZ();
            if (z && !this.aSl && this.aSk) {
                this.aSl = true;
                FY();
            }
        }
    }

    private void FX() {
        int i = 0;
        if (this.aRX > 0 && !ListUtils.isEmpty(this.aRI)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aRI.size() && !z; i2++) {
                Iterator<g> it = this.aRI.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.DR() != null && next.DR().equals(String.valueOf(this.aRX))) {
                        this.aRK = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aEB == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.aRL = this.aRK;
            this.aRI.clear();
        } else if (this.aRW > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aRm.size()) {
                    break;
                }
                com.baidu.live.data.f fVar = this.aRm.get(i3);
                if (fVar == null || this.aRW != fVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    ed(i3);
                    break;
                }
            }
            this.aRL = this.aRK;
        }
    }

    private void G(List<i> list) {
        if (list != null && this.aRW > 0 && this.aRX <= 0) {
            for (i iVar : list) {
                if (iVar.getCategoryId() == this.aRW) {
                    List<g> Er = iVar.Er();
                    if (Er != null && !Er.isEmpty() && Er.get(0) != null) {
                        this.aRX = Integer.valueOf(Er.get(0).DR()).intValue();
                        return;
                    }
                    return;
                }
            }
        }
    }

    private View bB(boolean z) {
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
                if (AlaGiftTabView.this.aRJ != null) {
                    AlaGiftTabView.this.aRJ.Gf();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.bn(this.aPZ);
        aVar.setGiftItems(list);
        aVar.dS(this.aPX);
        aVar.aY(this.aQg);
        aVar.dT(i);
        if (this.isLandscape) {
            if (this.aRw.getHeight() > 0) {
                aVar.dU(this.aRw.getHeight() / 3);
            } else {
                this.aRw.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.dU(AlaGiftTabView.this.aRw.getHeight() / 3);
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
                if (tag instanceof a.C0172a) {
                    ((a.C0172a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout ee(int i) {
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
    private void m(ArrayList<com.baidu.live.data.f> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.aRV) {
                this.aRy.setVisibility(0);
            }
            this.aRz.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.f fVar = arrayList.get(i);
                if (!TextUtils.isEmpty(fVar.getCategoryName()) && (this.mType != 0 || (fVar.Cu() != null && fVar.Cu().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(fVar.getCategoryName());
                    viewGroup.setOnClickListener(new c(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aRP;
                    }
                    if (this.aRl.size() > i && this.aRl.get(i) != null) {
                        for (g gVar : this.aRl.get(i).Er()) {
                            if (gVar != null && gVar.DW() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aRz.addView(viewGroup, layoutParams);
                }
            }
            ef(this.aRM);
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
    private void ef(int i) {
        int i2;
        JSONArray jSONArray;
        JSONException e;
        List<g> Er;
        int childCount = this.aRz.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aRM != i || !this.aRN) && this.aRm.size() > i && this.aRm.get(i) != null) {
                int min = Math.min(i, this.aRS.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aRS.get(i4);
                }
                if (this.aRH.size() > i3 && this.aRl.size() > i && (this.aRH.get(i3) instanceof ViewGroup)) {
                    this.aRL = i3;
                    i iVar = this.aRl.get(i);
                    if (iVar != null && iVar.Er() != null && !iVar.Er().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aRH.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aRN) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aRK) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.mShowing) {
                                        this.aRN = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aRm.size() > i && this.aRm.get(i) != null) {
                int categoryId = this.aRm.get(i).getCategoryId();
                if (!this.aRZ.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aRZ.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aRz.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.aRl.get(i6);
                if (iVar2.Es()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aRr, "");
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
                                    Er = iVar2.Er();
                                    if (Er != null) {
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
                    Er = iVar2.Er();
                    if (Er != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= Er.size()) {
                                break;
                            }
                            g gVar = Er.get(i9);
                            if (!gVar.En() && !hashSet.contains(gVar.DR())) {
                                arrayList.add(gVar.DR());
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
                                SharedPrefHelper.getInstance().putString(this.aRr, jSONArray.toString());
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
                    if (this.aSf != 0) {
                        gradientTextView.setGradientTextColor(this.aSf, this.aSf);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    eg(i);
                    this.aRM = i;
                    this.aRy.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bC(false);
                        } else {
                            bC(true);
                        }
                    } else {
                        bC(true);
                    }
                }
            }
        }
    }

    private void bC(boolean z) {
        int i = 8;
        if (this.aRD != null) {
            this.aRD.setVisibility(z ? this.aSb ? 8 : 0 : 8);
        }
        if (this.aRE != null) {
            TextView textView = this.aRE;
            if (!z && !this.aSb) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void eg(int i) {
        int childCount = this.aRz.getChildCount();
        if (i >= 0 && i < childCount && this.aRl != null && this.aRl.size() > i && this.aRl.get(i) != null) {
            this.aRT.get(i);
        }
    }

    public void x(int i, int i2) {
        this.aRW = i;
        this.aRX = i2;
    }

    public void ac(long j) {
        if (this.aRD != null) {
            if (j >= 100 && (this.aPZ || com.baidu.live.w.a.Nk().beH.aGH)) {
                this.aRD.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aRD.setText(String.valueOf(j));
        }
    }

    public void ad(long j) {
        if (this.aRE != null) {
            this.aRE.setText(String.valueOf(j));
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
        this.aRK = i;
        FZ();
        FT();
        if (i >= 0 && i < this.aRH.size() && (this.aRH.get(i) instanceof ViewGroup)) {
            FY();
            ViewGroup viewGroup = (ViewGroup) this.aRH.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aRL) {
                            aVar.dT(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aRL) {
                            aVar.dT(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.aRB.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void FY() {
        JSONObject jSONObject = new JSONObject();
        com.baidu.live.data.f fVar = (com.baidu.live.data.f) ListUtils.getItem(this.aRm, this.aRM);
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

    private void FZ() {
        int i = 0;
        for (int i2 = 0; i2 < this.aRS.size(); i2++) {
            for (int i3 = 0; i3 < this.aRS.get(i2); i3++) {
                if (i + i3 == this.aRK) {
                    if (this.aRS.get(i2) <= 1) {
                        this.aRx.setVisibility(4);
                    } else {
                        this.aRx.setVisibility(0);
                    }
                    this.aRx.setCount(this.aRS.get(i2));
                    this.aRx.onPageSelected(i3);
                    ef(i2);
                    return;
                }
            }
            i += this.aRS.get(i2);
        }
    }

    public g Ga() {
        return this.aRQ;
    }

    public int Gb() {
        return this.aRR;
    }

    public void a(d dVar) {
        this.aRJ = dVar;
    }

    public void eh(int i) {
        this.aRR = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aSo);
        MessageManager.getInstance().registerListener(this.aSp);
        MessageManager.getInstance().registerListener(this.aSq);
        MessageManager.getInstance().registerListener(this.aSr);
    }

    public void Gc() {
        if (!ListUtils.isEmpty(this.aRH)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aRH) {
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
    public void aq(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.aRH) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aRH) {
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
    public void Gd() {
        if (!ListUtils.isEmpty(this.aRH)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aRH) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aQg);
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
    public void Ge() {
        if (this.aRQ != null && this.aRQ.Ep()) {
            this.aRu.setStyleEnabled(this.aQg);
            if (this.aQg) {
                this.aRG.setStyle(this.aRQ.DX() ? 2 : 1);
            } else {
                this.aRG.setStyle(this.aRQ.DX() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.aSe = null;
        MessageManager.getInstance().unRegisterListener(this.aSo);
        MessageManager.getInstance().unRegisterListener(this.aSp);
        MessageManager.getInstance().unRegisterListener(this.aSq);
        MessageManager.getInstance().unRegisterListener(this.aSr);
        rz();
        if (this.aSc != null) {
            this.aSc.dismiss();
        }
    }

    public void bn(boolean z) {
        this.aPZ = z;
    }

    public void ei(int i) {
        this.aPX = i;
    }

    public void d(g gVar) {
        this.aRQ = gVar;
        this.aRX = Integer.valueOf(this.aRQ.DR()).intValue();
        if (this.aSe != null) {
            this.aSe.a(gVar);
        }
        if (gVar != null && !gVar.DZ()) {
            this.aSg.Fw();
        }
    }

    public void Fv() {
        if (this.aSg != null) {
            this.aSg.Fv();
        }
    }

    public void Fu() {
        if (this.aSg != null) {
            this.aSg.Fu();
        }
    }

    public void bD(boolean z) {
        if (this.aRG != null) {
            this.aRG.setVisibility(z ? 0 : 4);
        }
    }
}

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
    private int aED;
    private int aPZ;
    private boolean aQb;
    private boolean aQi;
    private HorizontalScrollView aRA;
    private LinearLayout aRB;
    private CommonEmptyView aRC;
    private View aRD;
    private com.baidu.live.gift.container.c aRE;
    private TextView aRF;
    private TextView aRG;
    private TextView aRH;
    public GiftPanelOperationSendView aRI;
    private List<View> aRJ;
    private ArrayList<List<g>> aRK;
    private d aRL;
    private int aRM;
    private int aRN;
    private int aRO;
    private boolean aRP;
    private boolean aRQ;
    private int aRR;
    private g aRS;
    private int aRT;
    private SparseIntArray aRU;
    private SparseBooleanArray aRV;
    private View.OnClickListener aRW;
    private boolean aRX;
    private int aRY;
    private int aRZ;
    public ArrayList<i> aRn;
    private ArrayList<com.baidu.live.data.f> aRo;
    private ArrayList<com.baidu.live.data.g> aRp;
    private final String aRt;
    private boolean aRu;
    private View aRv;
    private GiftPanelNumRoundRectView aRw;
    public TextView aRx;
    private BaseViewPager aRy;
    private RoundRectPageIndicator aRz;
    private int aSa;
    private SparseBooleanArray aSb;
    private Set<String> aSc;
    private boolean aSd;
    private BdAlertDialog aSe;
    private int aSf;
    private a aSg;
    private int aSh;
    private AlaComboBtnAnimView aSi;
    private TbImageView aSj;
    private com.baidu.live.gift.container.d aSk;
    private boolean aSl;
    private boolean aSm;
    private boolean aSn;
    private View.OnClickListener aSo;
    AdapterView.OnItemClickListener aSp;
    private CustomMessageListener aSq;
    private CustomMessageListener aSr;
    private CustomMessageListener aSs;
    private CustomMessageListener aSt;
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
        this.aRt = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aRJ = new ArrayList();
        this.aRM = 0;
        this.aRN = 0;
        this.mSelectedPosition = 0;
        this.aRO = 0;
        this.aRU = new SparseIntArray();
        this.aRV = new SparseBooleanArray();
        this.isLandscape = false;
        this.aRX = false;
        this.aRY = -1;
        this.aRZ = -1;
        this.aQb = false;
        this.aPZ = -1;
        this.aSb = new SparseBooleanArray();
        this.aSc = new HashSet();
        this.aSl = false;
        this.aQi = false;
        this.aSm = false;
        this.aSn = false;
        this.aSo = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aSi == null || !AlaGiftTabView.this.aSi.Fx()) {
                    if (AlaGiftTabView.this.aRE == null) {
                        AlaGiftTabView.this.aRE = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aSp);
                    }
                    AlaGiftTabView.this.bA(true);
                    AlaGiftTabView.this.aRE.a(AlaGiftTabView.this.aRv, AlaGiftTabView.this.aRp, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.11.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bA(false);
                        }
                    });
                }
            }
        };
        this.aSp = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.a aVar;
                AlaGiftTabView.this.aRE.dismiss();
                if (AlaGiftTabView.this.aRp != null && AlaGiftTabView.this.aRp.size() > 0) {
                    if (i != AlaGiftTabView.this.aRp.size()) {
                        com.baidu.live.data.g gVar = (com.baidu.live.data.g) AlaGiftTabView.this.aRp.get(i);
                        if (gVar != null) {
                            int number = gVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (aVar = AlaGiftTabView.this.aRS.aNp) != null) {
                                if (number == -1) {
                                    number = aVar.aNw;
                                }
                                if (number > AlaGiftTabView.this.aSf) {
                                    number = AlaGiftTabView.this.aSf;
                                }
                            }
                            AlaGiftTabView.this.gA(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.FV();
                    return;
                }
                AlaGiftTabView.this.gA("1");
            }
        };
        this.aSq = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.aLR == 1 || cVar.aLR == 2 || cVar.aLR == 5 || cVar.aLR == 6) && cVar.aLS != null) {
                        AlaGiftTabView.this.aq(cVar.aLS.getId(), cVar.aLS.getUrl());
                    }
                }
            }
        };
        this.aSr = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bv(true);
                if (AlaGiftTabView.this.aRS != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aRS) && AlaGiftTabView.this.aRu) {
                    AlaGiftTabView.this.aRI.setStyle(AlaGiftTabView.this.aRS.DX() ? 2 : 1);
                    AlaGiftTabView.this.aRw.setStyleEnabled(true);
                }
            }
        };
        this.aSs = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                r rVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof r) && (rVar = (r) customResponsedMessage.getData()) != null && rVar.aEf != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = rVar.aEf.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aQi != z2) {
                        AlaGiftTabView.this.aQi = z2;
                        AlaGiftTabView.this.Ge();
                        AlaGiftTabView.this.Gd();
                    }
                }
            }
        };
        this.aSt = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.FU();
                    AlaGiftTabView.this.aRI.setStyle(AlaGiftTabView.this.aRS.DX() ? 4 : 3);
                    AlaGiftTabView.this.aRw.setStyleEnabled(false);
                    if (AlaGiftTabView.this.aSg != null) {
                        AlaGiftTabView.this.aSg.e(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aRW = onClickListener;
        this.aRX = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aRR = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        this.aRK = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aSf = 9999;
                return;
            case 1:
                this.aSf = 999;
                return;
            default:
                return;
        }
    }

    public void ea(int i) {
        int childCount;
        this.aSh = i;
        if (this.aRB != null && (childCount = this.aRB.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aRO) {
                    ((GradientTextView) ((ViewGroup) this.aRB.getChildAt(i2)).findViewById(a.g.text_view)).setGradientTextColor(this.aSh, this.aSh);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aSg = aVar;
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
        this.aRv = this.mRoot.findViewById(a.g.gift_count_layout);
        this.aRv.setOnClickListener(this.aSo);
        this.aRw = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.aRx = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.aRx.setText("1");
        this.aRx.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.aRy = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.aRy.setOnPageChangeListener(this);
        this.aRz = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.aRB = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.aRA = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.aRX) {
            this.aRA.setVisibility(8);
        }
        this.aRF = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.aRF.setOnClickListener(this.aRW);
        this.aRG = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.aRG.setOnClickListener(this.aRW);
        this.aRI = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.aRH = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.aRH.setOnClickListener(this.aRW);
        this.aRI.setOnClickListener(this.aRW);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.aRC = new CommonEmptyView(this.mContext.getPageActivity());
        this.aRC.setVisibility(8);
        this.aRC.addToParent(frameLayout);
        this.aRD = this.mRoot.findViewById(a.g.donate_layout);
        this.aSi = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.aSi.setComboClickListener(this.aRW);
        this.aSi.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void Fy() {
                AlaGiftTabView.this.bD(true);
            }
        });
        this.aSj = (TbImageView) this.mRoot.findViewById(a.g.iv_official);
    }

    public void FS() {
        this.aSd = true;
        this.aRF.setVisibility(8);
        this.aRG.setVisibility(8);
        this.aRH.setVisibility(8);
    }

    public void bv(boolean z) {
        this.aRu = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.w.a.Nk().Nn() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aRH.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aSc.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aSc.add(str);
            }
        }
    }

    public void aW(boolean z) {
    }

    public void dx(int i) {
        this.aSa = i;
    }

    public void bw(boolean z) {
        this.aSm = z;
        if (z && !ListUtils.isEmpty(this.aRo)) {
            FY();
            this.aSn = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar) {
        if (tVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_pop_show"));
            if (this.aSk == null) {
                this.aSk = new com.baidu.live.gift.container.d(this.mContext);
            }
            this.aSk.n(tVar.dialogTitle, tVar.aEw + tVar.aEx, tVar.aEx);
        }
    }

    private void Q(View view) {
        if (this.aSk == null) {
            this.aSk = new com.baidu.live.gift.container.d(this.mContext);
        }
        this.aSk.O(view);
    }

    public void bx(boolean z) {
        this.aSl = z;
    }

    public void eb(int i) {
        this.aED = i;
    }

    public void aY(boolean z) {
        this.aQi = z;
    }

    public void by(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.aRy.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24);
                this.aRy.setLayoutParams(layoutParams);
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
        if (this.aSg != null) {
            this.aSg.c(false, this.aSf);
        }
        ed(i);
        this.aRy.setCurrentItem(this.aRM);
        FZ();
        FT();
    }

    private void ed(int i) {
        int min = Math.min(i, this.aRU.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aRU.get(i3);
        }
        this.aRM = i2;
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
            AlaGiftTabView.this.aRN = AlaGiftTabView.this.aRM;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void FT() {
        if (this.aSg != null) {
            if (this.aRS != null && this.aRS.aNq) {
                this.aSg.ao(this.aRS.aNr, this.aRS.aNs);
            } else {
                this.aSg.ao(null, null);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.aSg != null) {
            this.aSg.c(false, this.aSf);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.dT(i);
                aVar.notifyDataSetChanged();
                this.aRD.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                gA("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aRS.En()) {
                        this.aRI.setStyle(this.aRS.DX() ? 4 : 3);
                        this.aRw.setStyleEnabled(false);
                        if (this.aSg != null) {
                            this.aSg.e(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aRS.Ea()) && this.mShowing) {
                            this.mContext.showToast(this.aRS.Ea());
                            return;
                        }
                        return;
                    }
                    FT();
                    this.aRI.setEnabled(true);
                    if (this.aRS.Eq()) {
                        if (this.aSg != null) {
                            this.aSg.e(false, null);
                        }
                        if (this.aRS.Em() == 6 && this.aPZ < 3) {
                            i3 = 3;
                        } else if (this.aRS.Em() == 7 && this.aPZ < 7) {
                            i3 = 7;
                        } else if (this.aRS.Em() == 8 && this.aPZ < 13) {
                            i3 = 13;
                        } else if (this.aRS.Em() == 9 && this.aPZ < 22) {
                            i3 = 22;
                        } else if (this.aRS.Em() == 10 && this.aPZ < 29) {
                            i3 = 29;
                        } else if (this.aRS.Em() == 11 && this.aPZ < 39) {
                            i3 = 39;
                        } else if (this.aRS.Em() == 12 && this.aPZ < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.aRI.setStyle(this.aRS.DX() ? 2 : 1);
                    } else {
                        this.aRI.setStyle(this.aRS.DX() ? 4 : 3);
                    }
                    this.aRw.setStyleEnabled(z);
                    Ge();
                    i2 = i3;
                } else {
                    this.aRI.setStyle(this.aRS.DX() ? 2 : 1);
                    if (this.aRS.aNp != null && this.aRS.aNp.aNv != null && this.aRS.aNp.aNv.equals("20")) {
                        this.aRI.setText("使用");
                    } else {
                        this.aRI.setText("赠送");
                    }
                    this.aRw.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aRS.DY()) {
                    bz(true);
                } else {
                    bz(false);
                    gA("1");
                }
                d(false, i2);
                return;
            }
            this.aRI.setStyle(3);
            return;
        }
        this.aRI.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.a aVar;
        if (this.mShowing && this.aRS != null) {
            if (this.mType == 0) {
                if (this.aRS.Ep() && !this.aQi) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aRS.Ea()) && this.aRS.En() && !z) {
                    this.mContext.showToast(this.aRS.Ea());
                } else if (this.aRS.Eq() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aRS.El()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (aVar = this.aRS.aNp) != null && !TextUtils.isEmpty(aVar.aNy)) {
                this.mContext.showToast(aVar.aNy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.w.a.Nk().bkd != null && com.baidu.live.w.a.Nk().bkd.aJz != null) {
            String str = com.baidu.live.w.a.Nk().bkd.aJz.aIL;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Em()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FU() {
        if (!this.aRQ) {
            this.aSe = new BdAlertDialog(this.mContext.getPageActivity());
            this.aSe.setCancelable(false);
            this.aSe.setCanceledOnTouchOutside(false);
            this.aSe.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.aSe.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aSa)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aSe.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.aSe.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aSe.setPositiveButtonTextColor(-57754);
                this.aSe.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aSe.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aRQ = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aSe.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aRQ = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aSe.create(this.mContext).show();
            this.aRQ = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.w.a.Nk().beJ.aFN;
        if (z2) {
            this.aRv.setVisibility(4);
            this.aRI.setStyle(1);
        } else {
            View view = this.aRv;
            if (this.aRS == null || !this.aRS.DX()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.aSg != null) {
            this.aSg.e(z2, this.aRS != null ? this.aRS.getThumbnail_url() : null);
        }
    }

    public void FV() {
        if (this.aSg != null) {
            this.aSg.c(true, this.aSf);
        }
    }

    @Override // com.baidu.live.view.input.b.a
    public void gx(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        gA(str);
    }

    public void gA(String str) {
        this.aRx.setText(str);
        this.aRx.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        bA(false);
        if (this.aRS != null && this.aRS.DX()) {
            this.aRv.setVisibility(0);
            this.aRT = JavaTypesHelper.toInt(this.aRx.getText().toString(), 1);
            return;
        }
        this.aRv.setVisibility(4);
        this.aRT = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(boolean z) {
        this.aRx.setGravity(17);
        if (z) {
            this.aRx.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aRx.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.f> arrayList2, ArrayList<com.baidu.live.data.g> arrayList3, boolean z2, int i) {
        if (this.aRn == null || this.aRn.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            if (this.aRn == null) {
                this.aRn = new ArrayList<>();
            }
            this.aRn.clear();
            if (arrayList != null) {
                this.aRn.addAll(arrayList);
            }
            this.aRo = arrayList2;
            this.aRp = arrayList3;
            this.aRP = false;
            if (this.aRo == null || this.aRo.isEmpty()) {
                this.aRA.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void A(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aRJ != null) {
            for (View view : this.aRJ) {
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
        if (this.aRn == null || this.aRn.size() <= 0 || !z2) {
            rz();
            if (this.aRz != null) {
                this.aRz.setVisibility(4);
            }
            this.aRD.setVisibility(4);
            this.aRC.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.aRC.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aRC.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.aRC.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.w.a.Nk().beJ.aHn && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aRC.setTitle(string);
            this.aRC.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aRL != null) {
                        AlaGiftTabView.this.aRL.Gf();
                    }
                }
            });
            this.aRC.setVisibility(0);
            return;
        }
        this.aRC.setVisibility(8);
        if (z) {
            m(this.aRo);
        }
        be beVar = com.baidu.live.w.a.Nk().bkd;
        if (this.mType == 0 && beVar != null && beVar.aJD != null && beVar.aJD.aLu && !this.aSl && this.aRn.get(0) != null && this.aRn.get(0).Er() != null) {
            List<g> Er = this.aRn.get(0).Er();
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
        c(this.aRn, z);
        gA("1");
    }

    private void rz() {
        this.aRM = 0;
        this.aRN = 0;
        this.mSelectedPosition = 0;
        this.aRO = 0;
        if (this.aRU != null) {
            this.aRU.clear();
        }
        if (this.aRJ != null) {
            this.aRJ.clear();
        }
        if (this.aRy != null) {
            this.aRy.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.Eq()) {
            if (gVar.Em() == 6 && this.aPZ < 3) {
                return false;
            }
            if (gVar.Em() == 7 && this.aPZ < 7) {
                return false;
            }
            if (gVar.Em() == 8 && this.aPZ < 13) {
                return false;
            }
            if (gVar.Em() == 9 && this.aPZ < 22) {
                return false;
            }
            if (gVar.Em() == 10 && this.aPZ < 29) {
                return false;
            }
            if (gVar.Em() == 11 && this.aPZ < 39) {
                return false;
            }
            if (gVar.Em() == 12 && this.aPZ < 47) {
                return false;
            }
        }
        if (gVar.Ep()) {
            return this.aQi;
        }
        return true;
    }

    public void b(final t tVar) {
        if (tVar == null || TextUtils.isEmpty(tVar.iconUrl)) {
            this.aSj.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_show"));
            this.aSj.setVisibility(0);
            this.aSj.startLoad(tVar.iconUrl, 10, false);
            this.aSj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_clk"));
                    AlaGiftTabView.this.a(tVar);
                }
            });
            String str = "key_live_official_tip" + currentAccount;
            if (com.baidu.live.c.AD().getInt(str, 0) == 0 && this.aSm) {
                Q(this.aSj);
                com.baidu.live.c.AD().putInt(str, 1);
            }
        }
    }

    private void FW() {
        if (ListUtils.getCount(this.aRo) != 0 && ListUtils.getCount(this.aRn) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.f> it = this.aRo.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.f next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.Cu()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.aRn.iterator();
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
                Iterator<i> it3 = this.aRn.iterator();
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
                this.aRo.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aRn.removeAll(arrayList2);
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
            this.aRU.clear();
            this.aRJ.clear();
            this.aRy.setAdapter(null);
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
            this.aRK.clear();
            G(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aRJ.add(ee(i7));
                    this.aRU.append(i7, 1);
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
                        if (this.aRV.get(i7)) {
                            this.aRJ.add(bB(true));
                        } else {
                            this.aRJ.add(b(arrayList3, -1, i7));
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
                            this.aRK.add(arrayList2);
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
                                    if (gVar == null || gVar.DR() == null || !gVar.DR().equals(String.valueOf(this.aRZ))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aRJ.add(b(arrayList2, i3, i7));
                                this.aRI.removeCallbacks(null);
                                this.aRI.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aRS != null) {
                                            boolean DY = AlaGiftTabView.this.aRS.DY();
                                            AlaGiftTabView.this.bz(DY);
                                            if (!DY) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aRS);
                                                if (!c2) {
                                                    AlaGiftTabView.this.aRI.setStyle(AlaGiftTabView.this.aRS.DX() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.aRI.setStyle(AlaGiftTabView.this.aRS.DX() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.aRw.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.DR().equals(String.valueOf(this.aRZ))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aRJ.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aRJ.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.aRU.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aRy.setAdapter(new AlaGiftPagerAdapter(this.aRJ));
            FX();
            this.aRy.setCurrentItem(this.aRM);
            FZ();
            if (z && !this.aSn && this.aSm) {
                this.aSn = true;
                FY();
            }
        }
    }

    private void FX() {
        int i = 0;
        if (this.aRZ > 0 && !ListUtils.isEmpty(this.aRK)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aRK.size() && !z; i2++) {
                Iterator<g> it = this.aRK.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.DR() != null && next.DR().equals(String.valueOf(this.aRZ))) {
                        this.aRM = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aED == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.aRN = this.aRM;
            this.aRK.clear();
        } else if (this.aRY > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aRo.size()) {
                    break;
                }
                com.baidu.live.data.f fVar = this.aRo.get(i3);
                if (fVar == null || this.aRY != fVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    ed(i3);
                    break;
                }
            }
            this.aRN = this.aRM;
        }
    }

    private void G(List<i> list) {
        if (list != null && this.aRY > 0 && this.aRZ <= 0) {
            for (i iVar : list) {
                if (iVar.getCategoryId() == this.aRY) {
                    List<g> Er = iVar.Er();
                    if (Er != null && !Er.isEmpty() && Er.get(0) != null) {
                        this.aRZ = Integer.valueOf(Er.get(0).DR()).intValue();
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
                if (AlaGiftTabView.this.aRL != null) {
                    AlaGiftTabView.this.aRL.Gf();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.bn(this.aQb);
        aVar.setGiftItems(list);
        aVar.dS(this.aPZ);
        aVar.aY(this.aQi);
        aVar.dT(i);
        if (this.isLandscape) {
            if (this.aRy.getHeight() > 0) {
                aVar.dU(this.aRy.getHeight() / 3);
            } else {
                this.aRy.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.dU(AlaGiftTabView.this.aRy.getHeight() / 3);
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
            if (!this.aRX) {
                this.aRA.setVisibility(0);
            }
            this.aRB.removeAllViews();
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
                        layoutParams.leftMargin = this.aRR;
                    }
                    if (this.aRn.size() > i && this.aRn.get(i) != null) {
                        for (g gVar : this.aRn.get(i).Er()) {
                            if (gVar != null && gVar.DW() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aRB.addView(viewGroup, layoutParams);
                }
            }
            ef(this.aRO);
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
        int childCount = this.aRB.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aRO != i || !this.aRP) && this.aRo.size() > i && this.aRo.get(i) != null) {
                int min = Math.min(i, this.aRU.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aRU.get(i4);
                }
                if (this.aRJ.size() > i3 && this.aRn.size() > i && (this.aRJ.get(i3) instanceof ViewGroup)) {
                    this.aRN = i3;
                    i iVar = this.aRn.get(i);
                    if (iVar != null && iVar.Er() != null && !iVar.Er().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aRJ.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aRP) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aRM) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.mShowing) {
                                        this.aRP = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aRo.size() > i && this.aRo.get(i) != null) {
                int categoryId = this.aRo.get(i).getCategoryId();
                if (!this.aSb.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aSb.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aRB.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.aRn.get(i6);
                if (iVar2.Es()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aRt, "");
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
                                SharedPrefHelper.getInstance().putString(this.aRt, jSONArray.toString());
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
                    if (this.aSh != 0) {
                        gradientTextView.setGradientTextColor(this.aSh, this.aSh);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    eg(i);
                    this.aRO = i;
                    this.aRA.scrollTo(viewGroup2.getLeft(), 0);
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
        if (this.aRF != null) {
            this.aRF.setVisibility(z ? this.aSd ? 8 : 0 : 8);
        }
        if (this.aRG != null) {
            TextView textView = this.aRG;
            if (!z && !this.aSd) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void eg(int i) {
        int childCount = this.aRB.getChildCount();
        if (i >= 0 && i < childCount && this.aRn != null && this.aRn.size() > i && this.aRn.get(i) != null) {
            this.aRV.get(i);
        }
    }

    public void x(int i, int i2) {
        this.aRY = i;
        this.aRZ = i2;
    }

    public void ac(long j) {
        if (this.aRF != null) {
            if (j >= 100 && (this.aQb || com.baidu.live.w.a.Nk().beJ.aGJ)) {
                this.aRF.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aRF.setText(String.valueOf(j));
        }
    }

    public void ad(long j) {
        if (this.aRG != null) {
            this.aRG.setText(String.valueOf(j));
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
        this.aRM = i;
        FZ();
        FT();
        if (i >= 0 && i < this.aRJ.size() && (this.aRJ.get(i) instanceof ViewGroup)) {
            FY();
            ViewGroup viewGroup = (ViewGroup) this.aRJ.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aRN) {
                            aVar.dT(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aRN) {
                            aVar.dT(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.aRD.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void FY() {
        JSONObject jSONObject = new JSONObject();
        com.baidu.live.data.f fVar = (com.baidu.live.data.f) ListUtils.getItem(this.aRo, this.aRO);
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
        for (int i2 = 0; i2 < this.aRU.size(); i2++) {
            for (int i3 = 0; i3 < this.aRU.get(i2); i3++) {
                if (i + i3 == this.aRM) {
                    if (this.aRU.get(i2) <= 1) {
                        this.aRz.setVisibility(4);
                    } else {
                        this.aRz.setVisibility(0);
                    }
                    this.aRz.setCount(this.aRU.get(i2));
                    this.aRz.onPageSelected(i3);
                    ef(i2);
                    return;
                }
            }
            i += this.aRU.get(i2);
        }
    }

    public g Ga() {
        return this.aRS;
    }

    public int Gb() {
        return this.aRT;
    }

    public void a(d dVar) {
        this.aRL = dVar;
    }

    public void eh(int i) {
        this.aRT = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aSq);
        MessageManager.getInstance().registerListener(this.aSr);
        MessageManager.getInstance().registerListener(this.aSs);
        MessageManager.getInstance().registerListener(this.aSt);
    }

    public void Gc() {
        if (!ListUtils.isEmpty(this.aRJ)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aRJ) {
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
        if (!ListUtils.isEmpty(this.aRJ) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aRJ) {
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
        if (!ListUtils.isEmpty(this.aRJ)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aRJ) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aQi);
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
        if (this.aRS != null && this.aRS.Ep()) {
            this.aRw.setStyleEnabled(this.aQi);
            if (this.aQi) {
                this.aRI.setStyle(this.aRS.DX() ? 2 : 1);
            } else {
                this.aRI.setStyle(this.aRS.DX() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.aSg = null;
        MessageManager.getInstance().unRegisterListener(this.aSq);
        MessageManager.getInstance().unRegisterListener(this.aSr);
        MessageManager.getInstance().unRegisterListener(this.aSs);
        MessageManager.getInstance().unRegisterListener(this.aSt);
        rz();
        if (this.aSe != null) {
            this.aSe.dismiss();
        }
    }

    public void bn(boolean z) {
        this.aQb = z;
    }

    public void ei(int i) {
        this.aPZ = i;
    }

    public void d(g gVar) {
        this.aRS = gVar;
        this.aRZ = Integer.valueOf(this.aRS.DR()).intValue();
        if (this.aSg != null) {
            this.aSg.a(gVar);
        }
        if (gVar != null && !gVar.DZ()) {
            this.aSi.Fw();
        }
    }

    public void Fv() {
        if (this.aSi != null) {
            this.aSi.Fv();
        }
    }

    public void Fu() {
        if (this.aSi != null) {
            this.aSi.Fu();
        }
    }

    public void bD(boolean z) {
        if (this.aRI != null) {
            this.aRI.setVisibility(z ? 0 : 4);
        }
    }
}

package com.baidu.live.gift.container;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
import com.baidu.ala.recorder.video.AlaRecorderLog;
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
import com.baidu.live.d.u;
import com.baidu.live.data.bo;
import com.baidu.live.data.j;
import com.baidu.live.data.w;
import com.baidu.live.data.z;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.container.AlaComboBtnAnimView;
import com.baidu.live.gift.container.a;
import com.baidu.live.gift.container.a.a;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.gift.widget.panel.GiftPanelNumRoundRectView;
import com.baidu.live.gift.widget.panel.GiftPanelOperationSendView;
import com.baidu.live.gift.x;
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
import com.baidu.live.view.input.c;
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
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, c.a {
    private int aLC;
    private int aZE;
    private boolean aZG;
    private boolean aZM;
    public ArrayList<h> baV;
    private ArrayList<com.baidu.live.data.h> baW;
    private ArrayList<j> baX;
    private boolean bbA;
    private boolean bbB;
    private int bbC;
    private g bbD;
    private int bbE;
    private SparseIntArray bbF;
    private SparseBooleanArray bbG;
    private View.OnClickListener bbH;
    private boolean bbI;
    private int bbJ;
    private int bbK;
    private int bbL;
    private SparseBooleanArray bbM;
    private Set<String> bbN;
    private boolean bbO;
    private boolean bbP;
    private BdAlertDialog bbQ;
    private int bbR;
    private a bbS;
    private int bbT;
    private AlaComboBtnAnimView bbU;
    private TbImageView bbV;
    private com.baidu.live.gift.container.d bbW;
    private boolean bbX;
    private boolean bbY;
    private boolean bbZ;
    private final String bbb;
    private boolean bbc;
    private View bbd;
    private GiftPanelNumRoundRectView bbe;
    public TextView bbf;
    private ImageView bbg;
    private BaseViewPager bbh;
    private RoundRectPageIndicator bbi;
    private HorizontalScrollView bbj;
    private LinearLayout bbk;
    private FrameLayout bbl;
    private CommonEmptyView bbm;
    private View bbn;
    private com.baidu.live.gift.container.c bbo;
    private TextView bbp;
    private TextView bbq;
    private TextView bbr;
    public GiftPanelOperationSendView bbs;
    private List<View> bbt;
    ArrayList<j> bbu;
    private ArrayList<List<g>> bbv;
    private e bbw;
    private int bbx;
    private int bby;
    private int bbz;
    private AnimatorSet bca;
    private View.OnClickListener bcc;
    AdapterView.OnItemClickListener bcd;
    private CustomMessageListener bce;
    private CustomMessageListener bcf;
    private CustomMessageListener bcg;
    private CustomMessageListener bch;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private ViewGroup mRoot;
    private int mSelectedPosition;
    private int mType;
    private String otherParams;
    private String roomId;
    public static int page = 0;
    public static ArrayList<String> bcb = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface a {
        void Jc();

        void a(g gVar);

        void c(boolean z, int i);

        void ex(int i);

        void f(String str, String str2, boolean z);

        void f(boolean z, String str);

        void q(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void JF();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.bbb = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.bbt = new ArrayList();
        this.bbu = new ArrayList<>();
        this.bbx = 0;
        this.bby = 0;
        this.mSelectedPosition = 0;
        this.bbz = 0;
        this.bbF = new SparseIntArray();
        this.bbG = new SparseBooleanArray();
        this.isLandscape = false;
        this.bbI = false;
        this.bbJ = -1;
        this.bbK = -1;
        this.aZG = false;
        this.aZE = -1;
        this.bbM = new SparseBooleanArray();
        this.bbN = new HashSet();
        this.bbX = false;
        this.aZM = false;
        this.bbY = false;
        this.bbZ = false;
        this.bcc = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabView.this.bbu.clear();
                if (AlaGiftTabView.this.bbU == null || !AlaGiftTabView.this.bbU.IX()) {
                    if (AlaGiftTabView.this.bbo == null) {
                        AlaGiftTabView.this.bbo = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.mType, AlaGiftTabView.this.bcd);
                    }
                    AlaGiftTabView.this.bT(true);
                    if (AlaGiftTabView.this.bbD.Hc() == 10) {
                        Iterator it = AlaGiftTabView.this.baX.iterator();
                        while (it.hasNext()) {
                            j jVar = (j) it.next();
                            if (jVar.number <= AlaGiftTabView.this.bbD.aWe) {
                                AlaGiftTabView.this.bbu.add(jVar);
                            }
                        }
                    } else {
                        Iterator it2 = AlaGiftTabView.this.baX.iterator();
                        while (it2.hasNext()) {
                            AlaGiftTabView.this.bbu.add((j) it2.next());
                        }
                    }
                    AlaGiftTabView.this.bbo.a(AlaGiftTabView.this.bbd, AlaGiftTabView.this.bbu, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bT(false);
                        }
                    });
                }
            }
        };
        this.bcd = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.bbo.dismiss();
                if (AlaGiftTabView.this.bbu == null || AlaGiftTabView.this.bbu.size() <= 0) {
                    AlaGiftTabView.this.hF("1");
                } else if (i == AlaGiftTabView.this.bbu.size()) {
                    AlaGiftTabView.this.Jv();
                } else {
                    j jVar = AlaGiftTabView.this.bbu.get(i);
                    if (jVar != null) {
                        int number = jVar.getNumber();
                        if (AlaGiftTabView.this.mType == 1 && (bVar = AlaGiftTabView.this.bbD.aVZ) != null) {
                            if (number == -1) {
                                number = bVar.aWo;
                            }
                            if (number > AlaGiftTabView.this.bbR) {
                                number = AlaGiftTabView.this.bbR;
                            }
                        }
                        AlaGiftTabView.this.hF(String.valueOf(number));
                    }
                }
            }
        };
        this.bce = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.h.c)) {
                    com.baidu.live.h.c cVar = (com.baidu.live.h.c) customResponsedMessage.getData();
                    if ((cVar.aUr == 1 || cVar.aUr == 2 || cVar.aUr == 5 || cVar.aUr == 6) && cVar.aUs != null) {
                        AlaGiftTabView.this.ay(cVar.aUs.getId(), cVar.aUs.getUrl());
                    }
                }
            }
        };
        this.bcf = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bO(true);
                if (AlaGiftTabView.this.bbD != null && AlaGiftTabView.this.b(AlaGiftTabView.this.bbD) && AlaGiftTabView.this.bbc) {
                    AlaGiftTabView.this.bbs.setStyle(AlaGiftTabView.this.bbD.He() ? 2 : 1);
                    AlaGiftTabView.this.bbe.setStyleEnabled(true);
                }
            }
        };
        this.bcg = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                w wVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && (wVar = (w) customResponsedMessage.getData()) != null && wVar.aKr != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = wVar.aKr.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aZM != z2) {
                        AlaGiftTabView.this.aZM = z2;
                        AlaGiftTabView.this.JE();
                        AlaGiftTabView.this.JD();
                    }
                }
            }
        };
        this.bch = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.Ju();
                    AlaGiftTabView.this.bbs.setStyle(AlaGiftTabView.this.bbD.He() ? 4 : 3);
                    AlaGiftTabView.this.bbe.setStyleEnabled(false);
                    if (AlaGiftTabView.this.bbS != null) {
                        AlaGiftTabView.this.bbS.f(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.bbH = onClickListener;
        this.bbI = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.bbC = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.d.sdk_ds36);
        this.bbv = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.bbR = AlaRecorderLog.ErrorCode.ERROR_RECORDER_NOT_DEFINE_ERROR;
                this.bbg.setVisibility(8);
                return;
            case 1:
                this.bbR = 999;
                this.bbg.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public void eA(int i) {
        int childCount;
        this.bbT = i;
        if (this.bbk != null && (childCount = this.bbk.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.bbz) {
                    ((GradientTextView) ((ViewGroup) this.bbk.getChildAt(i2)).findViewById(a.f.text_view)).setGradientTextColor(this.bbT, this.bbT);
                }
            }
        }
    }

    public void a(a aVar) {
        this.bbS = aVar;
    }

    public void ax(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bN(boolean z) {
        this.bbP = z;
    }

    public void onVisibilityChanged(boolean z) {
        bN(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        this.bbd = this.mRoot.findViewById(a.f.gift_count_layout);
        this.bbd.setOnClickListener(this.bcc);
        this.bbe = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.f.gift_count_round);
        this.bbf = (TextView) this.mRoot.findViewById(a.f.gift_count_input);
        this.bbf.setText("1");
        this.bbf.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bbg = (ImageView) this.mRoot.findViewById(a.f.gift_tab_back);
        this.bbg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.bbS != null) {
                    AlaGiftTabView.this.bbS.Jc();
                }
            }
        });
        this.bbh = (BaseViewPager) this.mRoot.findViewById(a.f.gift_viewpager);
        this.bbh.setOnPageChangeListener(this);
        this.bbi = (RoundRectPageIndicator) this.mRoot.findViewById(a.f.gift_tab_indicator);
        this.bbk = (LinearLayout) this.mRoot.findViewById(a.f.gift_tab_layout);
        this.bbj = (HorizontalScrollView) this.mRoot.findViewById(a.f.gift_tab_scrollview);
        if (this.bbI) {
            this.bbj.setVisibility(8);
        }
        this.bbp = (TextView) this.mRoot.findViewById(a.f.current_money);
        this.bbp.setOnClickListener(this.bbH);
        this.bbq = (TextView) this.mRoot.findViewById(a.f.current_flower);
        this.bbq.setOnClickListener(this.bbH);
        this.bbs = (GiftPanelOperationSendView) this.mRoot.findViewById(a.f.donate);
        this.bbr = (TextView) this.mRoot.findViewById(a.f.current_recharge);
        this.bbr.setOnClickListener(this.bbH);
        this.bbs.setOnClickListener(this.bbH);
        this.bbl = (FrameLayout) this.mRoot.findViewById(a.f.layout_error);
        this.bbl.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.bbm = new CommonEmptyView(this.mContext.getPageActivity());
        this.bbm.setVisibility(8);
        this.bbm.addToParent(this.bbl);
        this.bbn = this.mRoot.findViewById(a.f.donate_layout);
        this.bbU = (AlaComboBtnAnimView) this.mRoot.findViewById(a.f.combo_layout);
        this.bbU.setComboClickListener(this.bbH);
        this.bbU.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void IY() {
                AlaGiftTabView.this.bW(true);
            }
        });
        this.bbV = (TbImageView) this.mRoot.findViewById(a.f.iv_official);
    }

    public void Js() {
        this.bbO = true;
        this.bbp.setVisibility(8);
        this.bbq.setVisibility(8);
        this.bbr.setVisibility(8);
    }

    public void bO(boolean z) {
        this.bbc = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.ae.a.RB().RF() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.bbr.setText(this.mContext.getPageActivity().getString(a.h.first_recharge_text));
            if (!this.bbN.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.bbN.add(str);
            }
        }
    }

    public void bm(boolean z) {
    }

    public void dV(int i) {
        this.bbL = i;
    }

    public void bP(boolean z) {
        this.bbP = z;
        this.bbY = z;
        if (z) {
            Jt();
        }
        if (!z && this.bca != null) {
            this.bca.cancel();
        }
        if (z && !ListUtils.isEmpty(this.baW)) {
            Jy();
            this.bbZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(z zVar) {
        if (zVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_pop_show"));
            if (this.bbW == null) {
                this.bbW = new com.baidu.live.gift.container.d(this.mContext);
            }
            this.bbW.n(zVar.dialogTitle, zVar.aLh + zVar.aLi, zVar.aLi);
        }
    }

    private void Q(View view) {
        if (this.bbW == null) {
            this.bbW = new com.baidu.live.gift.container.d(this.mContext);
        }
        this.bbW.O(view);
    }

    public void bQ(boolean z) {
        this.bbX = z;
    }

    public void eB(int i) {
        this.aLC = i;
    }

    public void bo(boolean z) {
        this.aZM = z;
    }

    public void bR(boolean z) {
        if (z) {
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24);
            ViewGroup.LayoutParams layoutParams = this.bbh.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
                this.bbh.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.bbl.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelOffset;
                this.bbl.setLayoutParams(layoutParams2);
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
            AlaGiftTabView.this.eC(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(int i) {
        if (this.bbS != null) {
            this.bbS.c(false, this.bbR);
        }
        eD(i);
        this.bbh.setCurrentItem(this.bbx);
        Jz();
        Jt();
    }

    private void eD(int i) {
        int min = Math.min(i, this.bbF.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.bbF.get(i3);
        }
        this.bbx = i2;
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.bby = AlaGiftTabView.this.bbx;
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
            if (item != null && item.aWd != null && item.aWd.enabled && !TextUtils.isEmpty(item.aWd.detailUrl) && AlaGiftTabView.this.bbS != null) {
                AlaGiftTabView.this.bbS.q(item.aWd.aWl, item.aWd.detailUrl);
            }
            return false;
        }
    }

    private void Jt() {
        if (this.bbP && this.bbS != null) {
            if (this.bbD != null && this.bbD.aWa) {
                this.bbS.f(this.bbD.aWb, this.bbD.aWc, false);
            } else {
                this.bbS.f(null, null, false);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.bbS != null) {
            this.bbS.c(false, this.bbR);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.et(i);
                aVar.notifyDataSetChanged();
                this.bbn.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                hF("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.bbD.Hv()) {
                        this.bbs.setStyle(this.bbD.He() ? 4 : 3);
                        this.bbe.setStyleEnabled(false);
                        if (this.bbS != null) {
                            this.bbS.f(false, null);
                        }
                        if (!TextUtils.isEmpty(this.bbD.Hh()) && this.bbP) {
                            this.mContext.showToast(this.bbD.Hh());
                            return;
                        }
                        return;
                    }
                    this.bbs.setEnabled(true);
                    if (this.bbD.Hz()) {
                        if (this.bbS != null) {
                            this.bbS.f(false, null);
                        }
                        if (this.bbD.Hu() == 6 && this.aZE < 3) {
                            i3 = 3;
                        } else if (this.bbD.Hu() == 7 && this.aZE < 7) {
                            i3 = 7;
                        } else if (this.bbD.Hu() == 8 && this.aZE < 13) {
                            i3 = 13;
                        } else if (this.bbD.Hu() == 9 && this.aZE < 22) {
                            i3 = 22;
                        } else if (this.bbD.Hu() == 10 && this.aZE < 29) {
                            i3 = 29;
                        } else if (this.bbD.Hu() == 11 && this.aZE < 39) {
                            i3 = 39;
                        } else if (this.bbD.Hu() == 12 && this.aZE < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.bbs.setStyle(this.bbD.He() ? 2 : 1);
                    } else {
                        this.bbs.setStyle(this.bbD.He() ? 4 : 3);
                    }
                    this.bbe.setStyleEnabled(z);
                    JE();
                    i2 = i3;
                } else {
                    this.bbs.setStyle(this.bbD.He() ? 2 : 1);
                    if ((this.bbD instanceof aa) && ((aa) this.bbD).Io()) {
                        this.bbs.setText("查看详情");
                    } else if (this.bbD.aVZ != null && this.bbD.aVZ.aWn != null && this.bbD.aVZ.aWn.equals("20")) {
                        if (this.bbD.aVZ.aWr != null && this.bbD.aVZ.aWr.key == 11) {
                            this.bbs.setText("激活");
                        } else {
                            this.bbs.setText("使用");
                        }
                    } else {
                        this.bbs.setText("赠送");
                    }
                    this.bbe.setStyleEnabled(true);
                    i2 = -1;
                }
                Jt();
                if (this.bbD.Hf()) {
                    bS(true);
                } else {
                    bS(false);
                    hF("1");
                }
                d(false, i2);
                return;
            }
            this.bbs.setStyle(3);
            return;
        }
        this.bbs.setStyle(3);
    }

    private void d(boolean z, int i) {
        if (this.bbP && this.bbD != null) {
            if (this.mType == 0) {
                if (this.bbD.Hx() && !this.aZM) {
                    this.mContext.showToast(a.h.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.bbD.Hh()) && this.bbD.Hv() && !z) {
                    this.mContext.showToast(this.bbD.Hh());
                } else if (this.bbD.Hz() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.h.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.bbD.Ht()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.h.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1) {
                g.b bVar = this.bbD.aVZ;
                if (bVar != null && !TextUtils.isEmpty(bVar.aWq)) {
                    this.mContext.showToast(bVar.aWq);
                } else if (!TextUtils.isEmpty(this.bbD.Hh())) {
                    BdUtilHelper.showToast(this.mContext.getPageActivity(), this.bbD.Hh());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.ae.a.RB().bxq != null && com.baidu.live.ae.a.RB().bxq.aQL != null) {
            String str = com.baidu.live.ae.a.RB().bxq.aQL.aQc;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Hu()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ju() {
        if (!this.bbB) {
            this.bbQ = new BdAlertDialog(this.mContext.getPageActivity());
            this.bbQ.setCancelable(false);
            this.bbQ.setCanceledOnTouchOutside(false);
            this.bbQ.setTitle(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_title));
            this.bbQ.setMessage(String.format(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_content), Integer.valueOf(this.bbL)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.bbQ.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.bbQ.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.bbQ.setPositiveButtonTextColor(-57754);
                this.bbQ.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.bbQ.setPositiveButton(this.mContext.getPageActivity().getString(a.h.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.bbB = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.bbQ.setNegativeButton(this.mContext.getPageActivity().getString(a.h.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.22
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.bbB = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.bbQ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.23
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    AlaGiftTabView.this.bbs.setStyle(AlaGiftTabView.this.bbD.He() ? 2 : 1);
                    AlaGiftTabView.this.bbe.setStyleEnabled(true);
                }
            });
            this.bbQ.create(this.mContext).show();
            this.bbB = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.ae.a.RB().brA.aMS;
        if (z2) {
            this.bbd.setVisibility(4);
            this.bbs.setStyle(1);
        } else {
            View view = this.bbd;
            if (this.bbD == null || !this.bbD.He()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.bbS != null) {
            this.bbS.f(z2, this.bbD != null ? this.bbD.getThumbnail_url() : null);
        }
    }

    public void Jv() {
        if (this.bbS != null && this.bbD != null) {
            if (this.bbD.Hc() == 10) {
                this.bbS.c(true, this.bbD.aWe);
            } else {
                this.bbS.c(true, this.bbR);
            }
        }
    }

    @Override // com.baidu.live.view.input.c.a
    public void hC(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        hF(str);
    }

    public void hF(String str) {
        this.bbf.setText(str);
        this.bbf.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.d.sdk_fontsize20 : a.d.sdk_fontsize24));
        bT(false);
        if (this.bbD != null && this.bbD.He()) {
            this.bbd.setVisibility(0);
            this.bbE = JavaTypesHelper.toInt(this.bbf.getText().toString(), 1);
            return;
        }
        this.bbd.setVisibility(4);
        this.bbE = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(boolean z) {
        this.bbf.setGravity(17);
        if (z) {
            this.bbf.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.bbf.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, boolean z2, int i) {
        if (this.mType != 0 || this.baV == null || this.baV.isEmpty()) {
            rG();
            if (this.baV == null) {
                this.baV = new ArrayList<>();
            }
            this.baV.clear();
            if (arrayList != null) {
                this.baV.addAll(arrayList);
            }
            this.baW = arrayList2;
            this.baX = arrayList3;
            this.bbA = false;
            if (this.baW == null || this.baW.isEmpty()) {
                this.bbj.setVisibility(8);
            }
            a(z, z2, i);
            onPageSelected(this.bbh.getCurrentItem());
        }
    }

    public void C(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.bbt != null) {
            for (View view : this.bbt) {
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
                                ((com.baidu.live.gift.container.a) ((GridView) childAt).getAdapter()).C(str, i);
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
        Jw();
        if (this.baV == null || this.baV.size() <= 0 || !z2) {
            rG();
            if (this.bbi != null) {
                this.bbi.setVisibility(4);
            }
            this.bbn.setVisibility(4);
            this.bbm.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                this.bbm.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.bbm.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_no);
                this.bbm.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.ae.a.RB().brA.aOw && i != 0) {
                string = string + "(" + i + ")";
            }
            this.bbm.setTitle(string);
            this.bbm.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.bbw != null) {
                        AlaGiftTabView.this.bbw.JF();
                    }
                }
            });
            this.bbm.setVisibility(0);
            return;
        }
        this.bbm.setVisibility(8);
        if (z) {
            m(this.baW);
        }
        bo boVar = com.baidu.live.ae.a.RB().bxq;
        if (this.mType == 0 && boVar != null && boVar.aQP != null && boVar.aQP.aTk && !this.bbX && this.baV.get(0) != null && this.baV.get(0).HA() != null) {
            List<g> HA = this.baV.get(0).HA();
            if (HA.size() <= 1 || HA.get(1) == null) {
                z3 = true;
            } else {
                z3 = !HA.get(1).isRed();
            }
            if (!HA.isEmpty() && z3) {
                g gVar = new g();
                gVar.bB(true);
                gVar.setGiftName("发红包");
                HA.add(1, gVar);
            }
        }
        c(this.baV, z);
        hF("1");
    }

    public void eE(int i) {
        A(-1, i);
        Jx();
        if (this.bbh != null) {
            this.bbh.setCurrentItem(this.bbx);
        }
    }

    private void rG() {
        this.bbx = 0;
        this.bby = 0;
        this.mSelectedPosition = 0;
        this.bbz = 0;
        if (this.bbF != null) {
            this.bbF.clear();
        }
        if (this.bbt != null) {
            this.bbt.clear();
        }
        if (this.bbh != null) {
            this.bbh.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.Hz()) {
            if (gVar.Hu() == 6 && this.aZE < 3) {
                return false;
            }
            if (gVar.Hu() == 7 && this.aZE < 7) {
                return false;
            }
            if (gVar.Hu() == 8 && this.aZE < 13) {
                return false;
            }
            if (gVar.Hu() == 9 && this.aZE < 22) {
                return false;
            }
            if (gVar.Hu() == 10 && this.aZE < 29) {
                return false;
            }
            if (gVar.Hu() == 11 && this.aZE < 39) {
                return false;
            }
            if (gVar.Hu() == 12 && this.aZE < 47) {
                return false;
            }
        }
        if (gVar.Hx()) {
            return this.aZM;
        }
        return true;
    }

    public void b(final z zVar) {
        if (zVar == null || TextUtils.isEmpty(zVar.iconUrl)) {
            this.bbV.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_show"));
            this.bbV.setVisibility(0);
            this.bbV.startLoad(zVar.iconUrl, 10, false);
            this.bbV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_clk"));
                    AlaGiftTabView.this.a(zVar);
                }
            });
            String str = "key_live_official_tip" + currentAccount;
            if (com.baidu.live.d.BM().getInt(str, 0) == 0 && this.bbY) {
                Q(this.bbV);
                com.baidu.live.d.BM().putInt(str, 1);
            }
        }
    }

    private void Jw() {
        if (ListUtils.getCount(this.baW) != 0 && ListUtils.getCount(this.baV) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.h> it = this.baW.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.h next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.Fi()) == 0))) {
                    arrayList.add(next);
                    Iterator<h> it2 = this.baV.iterator();
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
                Iterator<h> it3 = this.baV.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().HA().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.Hf()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.baW.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.baV.removeAll(arrayList2);
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
        List<g> HA;
        if (arrayList != null) {
            this.bbF.clear();
            this.bbt.clear();
            this.bbh.setAdapter(null);
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
                    if (hVar == null || (HA = hVar.HA()) == null || HA.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.bbv.clear();
            int i6 = 0;
            boolean z5 = false;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.bbt.add(eF(i7));
                    this.bbF.append(i7, 1);
                } else {
                    h hVar2 = arrayList.get(i7);
                    hVar2.getCategoryId();
                    List<g> HA2 = hVar2.HA();
                    if (HA2 == null) {
                        i = 0;
                    } else {
                        i = HA2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.bbG.get(i7)) {
                            this.bbt.add(bU(true));
                        } else {
                            this.bbt.add(b(arrayList3, -1, i7));
                        }
                    } else if (HA2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        int i10 = 0;
                        boolean z6 = z5;
                        while (i10 < ceil) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(HA2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(HA2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(HA2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.bbv.add(arrayList2);
                            if (i7 == 0 && i10 == 0 && z) {
                                if (!z6) {
                                    int i11 = 0;
                                    while (true) {
                                        int i12 = i11;
                                        if (i12 >= arrayList2.size()) {
                                            break;
                                        }
                                        gVar = arrayList2.get(i12);
                                        if (gVar == null || gVar.GX() == null || !gVar.GX().equals(String.valueOf(this.bbK))) {
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
                                    this.bbt.add(b(arrayList2, i3, i7));
                                    this.bbs.removeCallbacks(null);
                                    this.bbs.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (AlaGiftTabView.this.bbD != null) {
                                                boolean Hf = AlaGiftTabView.this.bbD.Hf();
                                                AlaGiftTabView.this.bS(Hf);
                                                if (!Hf) {
                                                    boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.bbD);
                                                    if (!c2) {
                                                        AlaGiftTabView.this.bbs.setStyle(AlaGiftTabView.this.bbD.He() ? 4 : 3);
                                                    } else {
                                                        AlaGiftTabView.this.bbs.setStyle(AlaGiftTabView.this.bbD.He() ? 2 : 1);
                                                    }
                                                    AlaGiftTabView.this.bbe.setStyleEnabled(c2);
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
                                this.bbt.add(b(arrayList2, i3, i7));
                                this.bbs.removeCallbacks(null);
                                this.bbs.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.bbD != null) {
                                            boolean Hf = AlaGiftTabView.this.bbD.Hf();
                                            AlaGiftTabView.this.bS(Hf);
                                            if (!Hf) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.bbD);
                                                if (!c2) {
                                                    AlaGiftTabView.this.bbs.setStyle(AlaGiftTabView.this.bbD.He() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.bbs.setStyle(AlaGiftTabView.this.bbD.He() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.bbe.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.GX().equals(String.valueOf(this.bbK))) {
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
                                this.bbt.add(b(arrayList2, i2, i7));
                            }
                            i10++;
                            z6 = z3;
                        }
                        i8 = ceil;
                        z5 = z6;
                    }
                    this.bbF.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.bbh.setAdapter(new AlaGiftPagerAdapter(this.bbt));
            Jx();
            this.bbh.setCurrentItem(this.bbx);
            Jz();
            if (z && !this.bbZ && this.bbY) {
                this.bbZ = true;
                Jy();
            }
        }
    }

    private void Jx() {
        int i = 0;
        if (this.bbK > 0 && !ListUtils.isEmpty(this.bbv)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.bbv.size() && !z; i2++) {
                Iterator<g> it = this.bbv.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.GX() != null && next.GX().equals(String.valueOf(this.bbK))) {
                        this.bbx = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aLC == 111 && !z && this.bbP) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_not_find_gift_toast);
            }
            this.bby = this.bbx;
            this.bbv.clear();
        } else if (this.bbJ > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.baW.size()) {
                    break;
                }
                com.baidu.live.data.h hVar = this.baW.get(i3);
                if (hVar == null || this.bbJ != hVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    eD(i3);
                    break;
                }
            }
            this.bby = this.bbx;
        }
    }

    private View bU(boolean z) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext.getPageActivity());
        commonEmptyView.setTitle(a.h.sdk_net_fail_tip_rank);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        } else {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.bbw != null) {
                    AlaGiftTabView.this.bbw.JF();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext.getPageActivity());
        aVar.bG(this.aZG);
        aVar.setGiftItems(list);
        aVar.es(this.aZE);
        aVar.bo(this.aZM);
        aVar.et(i);
        if (this.isLandscape) {
            if (this.bbh.getHeight() > 0) {
                aVar.eu(this.bbh.getHeight() / 3);
            } else {
                this.bbh.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.eu(AlaGiftTabView.this.bbh.getHeight() / 3);
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
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0187a) {
                    ((a.C0187a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout eF(int i) {
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
            if (!this.bbI) {
                this.bbj.setVisibility(0);
            }
            this.bbk.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.h hVar = arrayList.get(i);
                if (!TextUtils.isEmpty(hVar.getCategoryName()) && (this.mType != 0 || (hVar.Fi() != null && hVar.Fi().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.f.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(hVar.getCategoryName());
                    viewGroup.setOnClickListener(new d(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.bbC;
                    }
                    if (this.baV.size() > i && this.baV.get(i) != null) {
                        for (g gVar : this.baV.get(i).HA()) {
                            if (gVar != null && gVar.Hc() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.bbk.addView(viewGroup, layoutParams);
                }
            }
            eG(this.bbz);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01dc  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void eG(int i) {
        JSONArray jSONArray;
        JSONException e2;
        List<g> HA;
        int childCount = this.bbk.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.bbz != i || !this.bbA) && this.baW.size() > i && this.baW.get(i) != null) {
                int min = Math.min(i, this.bbF.size());
                int i2 = 0;
                int i3 = 0;
                while (i3 < min) {
                    int i4 = this.bbF.get(i3) + i2;
                    i3++;
                    i2 = i4;
                }
                if (this.bbt.size() > i2 && this.baV.size() > i && (this.bbt.get(i2) instanceof ViewGroup)) {
                    if (!this.bbA) {
                        i2 = this.bbx;
                    }
                    this.bby = i2;
                    h hVar = this.baV.get(i);
                    if (hVar != null && hVar.HA() != null && !hVar.HA().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.bbt.get(this.bby);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    a(aVar, !this.bbA ? this.mSelectedPosition : 0);
                                    this.bbA = true;
                                }
                            }
                        }
                    }
                }
            }
            if (this.baW.size() > i && this.baW.get(i) != null) {
                int categoryId = this.baW.get(i).getCategoryId();
                if (!this.bbM.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.bbM.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.bbk.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.f.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.f.icon_new_unlock_gift);
                imageView.setVisibility(8);
                h hVar2 = this.baV.get(i6);
                if (hVar2.HB() || hVar2.getCategoryId() == 20) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.bbb, "");
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
                                    HA = hVar2.HA();
                                    if (HA != null) {
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
                    HA = hVar2.HA();
                    if (HA != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= HA.size()) {
                                break;
                            }
                            g gVar = HA.get(i9);
                            if (!gVar.Hv() && !hashSet.contains(gVar.GX())) {
                                arrayList.add(gVar.GX());
                            }
                            i8 = i9 + 1;
                        }
                        if (!arrayList.isEmpty()) {
                            if (i6 != i) {
                                if (hVar2.getCategoryId() == 20 && !bcb.containsAll(arrayList)) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913228, true));
                                    bcb.addAll(arrayList);
                                }
                                imageView.setVisibility(0);
                            } else {
                                if (jSONArray2 == null) {
                                    jSONArray2 = new JSONArray();
                                }
                                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                                    jSONArray2.put(arrayList.get(i10));
                                }
                                SharedPrefHelper.getInstance().putString(this.bbb, jSONArray2.toString());
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
                    if (this.bbT != 0) {
                        gradientTextView.setGradientTextColor(this.bbT, this.bbT);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    eH(i);
                    this.bbz = i;
                    this.bbj.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bV(false);
                        } else {
                            bV(true);
                        }
                    } else {
                        bV(true);
                    }
                }
            }
        }
    }

    private void bV(boolean z) {
        int i = 8;
        if (this.bbp != null) {
            this.bbp.setVisibility(z ? this.bbO ? 8 : 0 : 8);
        }
        if (this.bbq != null) {
            TextView textView = this.bbq;
            if (!z && !this.bbO) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void eH(int i) {
        int childCount = this.bbk.getChildCount();
        if (i >= 0 && i < childCount && this.baV != null && this.baV.size() > i && this.baV.get(i) != null) {
            this.bbG.get(i);
        }
    }

    public void A(int i, int i2) {
        this.bbJ = i;
        this.bbK = i2;
    }

    public void aO(long j) {
        if (this.bbp != null) {
            if (j >= 100 && (this.aZG || com.baidu.live.ae.a.RB().brA.aNQ)) {
                this.bbp.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.bbp.setText(String.valueOf(j));
        }
    }

    public void aP(long j) {
        if (this.bbq != null) {
            this.bbq.setText(String.valueOf(j));
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
        this.bbx = i;
        Jz();
        Jt();
        if (i >= 0 && i < this.bbt.size() && (this.bbt.get(i) instanceof ViewGroup)) {
            Jy();
            ViewGroup viewGroup = (ViewGroup) this.bbt.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.bby) {
                            aVar.et(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.bby) {
                            aVar.et(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        a(gridView);
                        this.bbn.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void a(final AbsListView absListView) {
        if (this.bca != null) {
            this.bca.cancel();
        }
        if (absListView != null) {
            absListView.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
                @Override // java.lang.Runnable
                public void run() {
                    g gVar;
                    ArrayList arrayList = null;
                    int childCount = absListView.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = absListView.getChildAt(i);
                        if (childAt != null && (childAt.getTag() instanceof a.C0187a)) {
                            a.C0187a c0187a = (a.C0187a) childAt.getTag();
                            if (c0187a.aZT != null && (c0187a.aZT.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (gVar = (g) c0187a.aZT.getTag(a.f.TAG_GIFT_ITEM)) != null && gVar.aWd != null && gVar.aWd.enabled && gVar.aWd.aWj && !TextUtils.isEmpty(gVar.aWd.detailUrl)) {
                                String GX = gVar.GX();
                                if (!x.Ig().hf(GX)) {
                                    x.Ig().hg(GX);
                                    AlaGiftTabView.this.a(c0187a.aZT, !TextUtils.isEmpty(gVar.aWd.aWk) ? gVar.aWd.aWk : "长按查看规则");
                                    AnimatorSet a2 = AlaGiftTabView.this.a(absListView, c0187a);
                                    a2.playTogether(AlaGiftTabView.this.R(c0187a.aZO), AlaGiftTabView.this.S(c0187a.aZT));
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
        gradientDrawable.setCornerRadius(textView.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet a(final AbsListView absListView, final a.C0187a c0187a) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                if (c0187a != null && c0187a.aZT != null) {
                    c0187a.aZT.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c0187a != null && c0187a.aZT != null) {
                    c0187a.aZT.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c0187a != null) {
                    c0187a.Jb();
                }
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator R(final View view) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.baidu.live.gift.container.a.b(), Float.valueOf(0.0f), Float.valueOf(1.0f));
        ofObject.setDuration(1250L);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
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
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.baidu.live.gift.container.a.a(), new a.C0188a(), new a.C0188a());
        ofObject.setDuration(3541L);
        ofObject.setStartDelay(1000L);
        ofObject.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
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
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view != null && (valueAnimator.getAnimatedValue() instanceof a.C0188a)) {
                    a.C0188a c0188a = (a.C0188a) valueAnimator.getAnimatedValue();
                    view.setScaleX(c0188a.scale);
                    view.setScaleY(c0188a.scale);
                    view.setAlpha(c0188a.bcD);
                }
            }
        });
        return ofObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(List<Animator> list) {
        if (list != null && !list.isEmpty()) {
            if (this.bca == null) {
                this.bca = new AnimatorSet();
                this.bca.setInterpolator(new LinearInterpolator());
            }
            this.bca.playTogether(list);
            this.bca.start();
        }
    }

    private void Jy() {
        JSONObject jSONObject = new JSONObject();
        com.baidu.live.data.h hVar = (com.baidu.live.data.h) ListUtils.getItem(this.baW, this.bbz);
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

    private void Jz() {
        int i = 0;
        for (int i2 = 0; i2 < this.bbF.size(); i2++) {
            for (int i3 = 0; i3 < this.bbF.get(i2); i3++) {
                if (i + i3 == this.bbx) {
                    if (this.bbF.get(i2) <= 1) {
                        this.bbi.setVisibility(4);
                    } else {
                        this.bbi.setVisibility(0);
                    }
                    this.bbi.setCount(this.bbF.get(i2));
                    this.bbi.onPageSelected(i3);
                    eG(i2);
                    return;
                }
            }
            i += this.bbF.get(i2);
        }
    }

    public g JA() {
        return this.bbD;
    }

    public int JB() {
        return this.bbE;
    }

    public void a(e eVar) {
        this.bbw = eVar;
    }

    public void eI(int i) {
        this.bbE = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bce);
        MessageManager.getInstance().registerListener(this.bcf);
        MessageManager.getInstance().registerListener(this.bcg);
        MessageManager.getInstance().registerListener(this.bch);
    }

    public void JC() {
        if (!ListUtils.isEmpty(this.bbt)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bbt) {
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
    public void ay(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.bbt) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bbt) {
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
    public void JD() {
        if (!ListUtils.isEmpty(this.bbt)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bbt) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aZM);
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
    public void JE() {
        if (this.bbD != null && this.bbD.Hx()) {
            this.bbe.setStyleEnabled(this.aZM);
            if (this.aZM) {
                this.bbs.setStyle(this.bbD.He() ? 2 : 1);
            } else {
                this.bbs.setStyle(this.bbD.He() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.bbS = null;
        MessageManager.getInstance().unRegisterListener(this.bce);
        MessageManager.getInstance().unRegisterListener(this.bcf);
        MessageManager.getInstance().unRegisterListener(this.bcg);
        MessageManager.getInstance().unRegisterListener(this.bch);
        rG();
        if (this.bbQ != null) {
            this.bbQ.dismiss();
        }
        if (this.bca != null) {
            this.bca.cancel();
        }
    }

    public void bG(boolean z) {
        this.aZG = z;
    }

    public void eJ(int i) {
        this.aZE = i;
    }

    public void d(g gVar) {
        this.bbD = gVar;
        if (this.bbD.GX().equals("")) {
            BdUtilHelper.showToast(this.mContext.getPageActivity(), "该礼物已下线");
            return;
        }
        this.bbK = Integer.valueOf(this.bbD.GX()).intValue();
        if (this.bbS != null) {
            this.bbS.a(gVar);
        }
        if (gVar != null && !gVar.Hg()) {
            this.bbU.IW();
        }
    }

    public void IV() {
        if (this.bbU != null) {
            this.bbU.IV();
        }
        g gVar = this.bbD;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.GX());
                jSONObject.putOpt("gift_name", gVar.GY());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "combosend_show").setContentExt(null, "popup", jSONObject));
        }
    }

    public void IU() {
        if (this.bbU != null) {
            this.bbU.IU();
        }
        g gVar = this.bbD;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.GX());
                jSONObject.putOpt("gift_name", gVar.GY());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "combosend_clk").setContentExt(null, null, jSONObject));
        }
    }

    public void bW(boolean z) {
        if (this.bbs != null) {
            this.bbs.setVisibility(z ? 0 : 4);
        }
    }
}

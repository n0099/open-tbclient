package com.baidu.live.gift.container;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
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
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.live.data.ab;
import com.baidu.live.data.ae;
import com.baidu.live.data.bv;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
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
/* loaded from: classes10.dex */
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, c.a {
    private int aLy;
    private int bbe;
    private boolean bbg;
    private boolean bbm;
    private final String bcB;
    private boolean bcC;
    private ViewGroup bcD;
    private View bcE;
    private GiftPanelNumRoundRectView bcF;
    public TextView bcG;
    private ImageView bcH;
    private BaseViewPager bcI;
    private RoundRectPageIndicator bcJ;
    private HorizontalScrollView bcK;
    private LinearLayout bcL;
    private FrameLayout bcM;
    private CommonEmptyView bcN;
    private View bcO;
    private com.baidu.live.gift.container.c bcP;
    private TextView bcQ;
    private TextView bcR;
    private TextView bcS;
    public GiftPanelOperationSendView bcT;
    private List<View> bcU;
    ArrayList<l> bcV;
    private ArrayList<List<g>> bcW;
    private e bcX;
    private int bcY;
    private int bcZ;
    public ArrayList<h> bcv;
    public ArrayList<i> bcw;
    public ArrayList<l> bcx;
    private boolean bdA;
    private AnimatorSet bdB;
    private int bdD;
    private View.OnClickListener bdE;
    AdapterView.OnItemClickListener bdF;
    private CustomMessageListener bdG;
    private CustomMessageListener bdH;
    private CustomMessageListener bdI;
    private CustomMessageListener bdJ;
    private int bda;
    private boolean bdb;
    private boolean bdc;
    private int bdd;
    private g bde;
    private int bdf;
    private SparseIntArray bdg;
    private SparseBooleanArray bdh;
    private View.OnClickListener bdi;
    private boolean bdj;
    private int bdk;
    private int bdl;
    private int bdm;
    private SparseBooleanArray bdn;
    private Set<String> bdo;
    private boolean bdp;
    private boolean bdq;
    private BdAlertDialog bdr;
    private int bds;
    private a bdt;
    private int bdu;
    private AlaComboBtnAnimView bdv;
    private TbImageView bdw;
    private com.baidu.live.gift.container.d bdx;
    private boolean bdy;
    private boolean bdz;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private int mSelectedPosition;
    private int mType;
    private String otherParams;
    private String roomId;
    public static int page = 0;
    public static ArrayList<String> bdC = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface a {
        void Gc();

        void a(g gVar);

        void c(boolean z, int i);

        void cV(int i);

        void g(String str, String str2, boolean z);

        void j(boolean z, String str);

        void u(int i, String str);
    }

    /* loaded from: classes10.dex */
    public interface e {
        void GF();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.bcB = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.bcU = new ArrayList();
        this.bcV = new ArrayList<>();
        this.bcY = 0;
        this.bcZ = 0;
        this.mSelectedPosition = 0;
        this.bda = 0;
        this.bdg = new SparseIntArray();
        this.bdh = new SparseBooleanArray();
        this.isLandscape = false;
        this.bdj = false;
        this.bdk = -1;
        this.bdl = -1;
        this.bbg = false;
        this.bbe = -1;
        this.bdn = new SparseBooleanArray();
        this.bdo = new HashSet();
        this.bdy = false;
        this.bbm = false;
        this.bdz = false;
        this.bdA = false;
        this.bdE = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabView.this.bcV.clear();
                if (AlaGiftTabView.this.bdv == null || !AlaGiftTabView.this.bdv.FW()) {
                    if (AlaGiftTabView.this.bcP == null) {
                        AlaGiftTabView.this.bcP = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.mType, AlaGiftTabView.this.bdF);
                    }
                    AlaGiftTabView.this.bS(true);
                    if (AlaGiftTabView.this.bde.Eb() == 10) {
                        Iterator<l> it = AlaGiftTabView.this.bcx.iterator();
                        while (it.hasNext()) {
                            l next = it.next();
                            if (next.number <= AlaGiftTabView.this.bde.aXC) {
                                AlaGiftTabView.this.bcV.add(next);
                            }
                        }
                    } else {
                        Iterator<l> it2 = AlaGiftTabView.this.bcx.iterator();
                        while (it2.hasNext()) {
                            AlaGiftTabView.this.bcV.add(it2.next());
                        }
                    }
                    AlaGiftTabView.this.bcP.a(AlaGiftTabView.this.bcE, AlaGiftTabView.this.bcV, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bS(false);
                        }
                    });
                }
            }
        };
        this.bdF = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.bcP.dismiss();
                if (AlaGiftTabView.this.bcV == null || AlaGiftTabView.this.bcV.size() <= 0) {
                    AlaGiftTabView.this.gI("1");
                } else if (i == AlaGiftTabView.this.bcV.size()) {
                    AlaGiftTabView.this.Gv();
                } else {
                    l lVar = AlaGiftTabView.this.bcV.get(i);
                    if (lVar != null) {
                        int number = lVar.getNumber();
                        if (AlaGiftTabView.this.mType == 1 && (bVar = AlaGiftTabView.this.bde.aXx) != null) {
                            if (number == -1) {
                                number = bVar.aXM;
                            }
                            if (number > AlaGiftTabView.this.bds) {
                                number = AlaGiftTabView.this.bds;
                            }
                        }
                        AlaGiftTabView.this.gI(String.valueOf(number));
                    }
                }
            }
        };
        this.bdG = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.h.c)) {
                    com.baidu.live.h.c cVar = (com.baidu.live.h.c) customResponsedMessage.getData();
                    if ((cVar.aVB == 1 || cVar.aVB == 2 || cVar.aVB == 5 || cVar.aVB == 6) && cVar.aVC != null) {
                        AlaGiftTabView.this.av(cVar.aVC.getId(), cVar.aVC.getUrl());
                    }
                }
            }
        };
        this.bdH = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bN(true);
                if (AlaGiftTabView.this.bde != null && AlaGiftTabView.this.b(AlaGiftTabView.this.bde) && AlaGiftTabView.this.bcC) {
                    AlaGiftTabView.this.bcT.setStyle(AlaGiftTabView.this.bde.Ed() ? 2 : 1);
                    AlaGiftTabView.this.bcF.setStyleEnabled(true);
                }
            }
        };
        this.bdI = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ab abVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab) && (abVar = (ab) customResponsedMessage.getData()) != null && abVar.aJZ != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = abVar.aJZ.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.bbm != z2) {
                        AlaGiftTabView.this.bbm = z2;
                        AlaGiftTabView.this.GE();
                        AlaGiftTabView.this.GD();
                    }
                }
            }
        };
        this.bdJ = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.Gu();
                    AlaGiftTabView.this.bcT.setStyle(AlaGiftTabView.this.bde.Ed() ? 4 : 3);
                    AlaGiftTabView.this.bcF.setStyleEnabled(false);
                    if (AlaGiftTabView.this.bdt != null) {
                        AlaGiftTabView.this.bdt.j(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.bdi = onClickListener;
        this.bdj = z;
        this.bcD = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.bdd = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.d.sdk_ds36);
        this.bcW = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.bds = AlaRecorderLog.ErrorCode.ERROR_RECORDER_NOT_DEFINE_ERROR;
                this.bcH.setVisibility(8);
                return;
            case 1:
                this.bds = 999;
                this.bcH.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public void cY(int i) {
        int childCount;
        this.bdu = i;
        if (this.bcL != null && (childCount = this.bcL.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.bda) {
                    ((GradientTextView) ((ViewGroup) this.bcL.getChildAt(i2)).findViewById(a.f.text_view)).setGradientTextColor(this.bdu, this.bdu);
                }
            }
        }
    }

    public void a(a aVar) {
        this.bdt = aVar;
    }

    public void au(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bM(boolean z) {
        this.bdq = z;
    }

    public void onVisibilityChanged(boolean z) {
        bM(z);
    }

    public View getRootView() {
        return this.bcD;
    }

    private void initViews() {
        this.bcE = this.bcD.findViewById(a.f.gift_count_layout);
        this.bcE.setOnClickListener(this.bdE);
        this.bcF = (GiftPanelNumRoundRectView) this.bcD.findViewById(a.f.gift_count_round);
        this.bcG = (TextView) this.bcD.findViewById(a.f.gift_count_input);
        this.bcG.setText("1");
        this.bcG.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bcH = (ImageView) this.bcD.findViewById(a.f.gift_tab_back);
        this.bcH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.bdt != null) {
                    AlaGiftTabView.this.bdt.Gc();
                }
            }
        });
        this.bcI = (BaseViewPager) this.bcD.findViewById(a.f.gift_viewpager);
        this.bcI.setOnPageChangeListener(this);
        this.bcJ = (RoundRectPageIndicator) this.bcD.findViewById(a.f.gift_tab_indicator);
        this.bcL = (LinearLayout) this.bcD.findViewById(a.f.gift_tab_layout);
        this.bcK = (HorizontalScrollView) this.bcD.findViewById(a.f.gift_tab_scrollview);
        if (this.bdj) {
            this.bcK.setVisibility(8);
        }
        this.bcQ = (TextView) this.bcD.findViewById(a.f.current_money);
        this.bcQ.setOnClickListener(this.bdi);
        this.bcR = (TextView) this.bcD.findViewById(a.f.current_flower);
        this.bcR.setOnClickListener(this.bdi);
        this.bcT = (GiftPanelOperationSendView) this.bcD.findViewById(a.f.donate);
        this.bcS = (TextView) this.bcD.findViewById(a.f.current_recharge);
        this.bcS.setOnClickListener(this.bdi);
        this.bcT.setOnClickListener(this.bdi);
        this.bcM = (FrameLayout) this.bcD.findViewById(a.f.layout_error);
        this.bcM.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.bcN = new CommonEmptyView(this.mContext.getPageActivity());
        this.bcN.setVisibility(8);
        this.bcN.addToParent(this.bcM);
        this.bcO = this.bcD.findViewById(a.f.donate_layout);
        this.bdv = (AlaComboBtnAnimView) this.bcD.findViewById(a.f.combo_layout);
        this.bdv.setComboClickListener(this.bdi);
        this.bdv.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void FX() {
                AlaGiftTabView.this.bV(true);
            }
        });
        this.bdw = (TbImageView) this.bcD.findViewById(a.f.iv_official);
    }

    public void Gs() {
        this.bdp = true;
        this.bcQ.setVisibility(8);
        this.bcR.setVisibility(8);
        this.bcS.setVisibility(8);
    }

    public void bN(boolean z) {
        this.bcC = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.ae.a.Qm().Qr() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.bcS.setText(this.mContext.getPageActivity().getString(a.h.first_recharge_text));
            if (!this.bdo.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.bdo.add(str);
            }
        }
    }

    public void bh(boolean z) {
    }

    public void cq(int i) {
        this.bdm = i;
    }

    public void bO(boolean z) {
        this.bdq = z;
        this.bdz = z;
        if (z) {
            Gt();
        }
        if (!z && this.bdB != null) {
            this.bdB.cancel();
        }
        if (z && !ListUtils.isEmpty(this.bcw)) {
            Gy();
            this.bdA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ae aeVar) {
        if (aeVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_pop_show"));
            if (this.bdx == null) {
                this.bdx = new com.baidu.live.gift.container.d(this.mContext);
            }
            this.bdx.n(aeVar.dialogTitle, aeVar.aLa + aeVar.aLb, aeVar.aLb);
        }
    }

    private void Q(View view) {
        if (this.bdx == null) {
            this.bdx = new com.baidu.live.gift.container.d(this.mContext);
        }
        this.bdx.O(view);
    }

    public void bP(boolean z) {
        this.bdy = z;
    }

    public void cZ(int i) {
        this.aLy = i;
    }

    public void bj(boolean z) {
        this.bbm = z;
    }

    public void bQ(boolean z) {
        if (z) {
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24);
            ViewGroup.LayoutParams layoutParams = this.bcI.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
                this.bcI.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.bcM.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelOffset;
                this.bcM.setLayoutParams(layoutParams2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        private int mPosition;

        public d(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaGiftTabView.this.da(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(int i) {
        if (this.bdt != null) {
            this.bdt.c(false, this.bds);
        }
        db(i);
        this.bcI.setCurrentItem(this.bcY);
        Gz();
        Gt();
    }

    private void db(int i) {
        int min = Math.min(i, this.bdg.size());
        int i2 = 0;
        int i3 = 0;
        while (i2 < min) {
            i2++;
            i3 = this.bdg.get(i2) + i3;
        }
        this.bcY = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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
            AlaGiftTabView.this.bcZ = AlaGiftTabView.this.bcY;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        private c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            g item = ((com.baidu.live.gift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.aXB != null && item.aXB.enabled && !TextUtils.isEmpty(item.aXB.detailUrl) && AlaGiftTabView.this.bdt != null) {
                AlaGiftTabView.this.bdt.u(item.aXB.aXJ, item.aXB.detailUrl);
            }
            return false;
        }
    }

    private void Gt() {
        if (this.bdq && this.bdt != null) {
            if (this.bde != null && this.bde.aXy) {
                this.bdt.g(this.bde.aXz, this.bde.aXA, false);
            } else {
                this.bdt.g(null, null, false);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.bdt != null) {
            this.bdt.c(false, this.bds);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.cR(i);
                aVar.notifyDataSetChanged();
                this.bcO.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                gI("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.bde.Eu()) {
                        this.bcT.setStyle(this.bde.Ed() ? 4 : 3);
                        this.bcF.setStyleEnabled(false);
                        if (this.bdt != null) {
                            this.bdt.j(false, null);
                        }
                        if (!TextUtils.isEmpty(this.bde.Eg()) && this.bdq) {
                            this.mContext.showToast(this.bde.Eg());
                            return;
                        }
                        return;
                    }
                    this.bcT.setEnabled(true);
                    if (this.bde.Ey()) {
                        if (this.bdt != null) {
                            this.bdt.j(false, null);
                        }
                        if (this.bde.Et() == 6 && this.bbe < 3) {
                            i3 = 3;
                        } else if (this.bde.Et() == 7 && this.bbe < 7) {
                            i3 = 7;
                        } else if (this.bde.Et() == 8 && this.bbe < 13) {
                            i3 = 13;
                        } else if (this.bde.Et() == 9 && this.bbe < 22) {
                            i3 = 22;
                        } else if (this.bde.Et() == 10 && this.bbe < 29) {
                            i3 = 29;
                        } else if (this.bde.Et() == 11 && this.bbe < 39) {
                            i3 = 39;
                        } else if (this.bde.Et() == 12 && this.bbe < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.bcT.setStyle(this.bde.Ed() ? 2 : 1);
                    } else {
                        this.bcT.setStyle(this.bde.Ed() ? 4 : 3);
                    }
                    this.bcF.setStyleEnabled(z);
                    GE();
                    i2 = i3;
                } else {
                    this.bcT.setStyle(this.bde.Ed() ? 2 : 1);
                    if ((this.bde instanceof aa) && ((aa) this.bde).Fn()) {
                        this.bcT.setText("查看详情");
                    } else if (this.bde.aXx != null && this.bde.aXx.aXL != null && this.bde.aXx.aXL.equals("20")) {
                        if (this.bde.aXx.aXP != null && this.bde.aXx.aXP.key == 11) {
                            this.bcT.setText("激活");
                        } else if (this.bde.aXx.aXP != null && this.bde.aXx.aXP.key == 12) {
                            this.bcT.setText("立即激活");
                        } else {
                            this.bcT.setText("使用");
                        }
                    } else {
                        this.bcT.setText("赠送");
                    }
                    this.bcF.setStyleEnabled(true);
                    i2 = -1;
                }
                Gt();
                if (this.bde.Ee()) {
                    bR(true);
                } else {
                    bR(false);
                    gI("1");
                }
                d(false, i2);
                return;
            }
            this.bcT.setStyle(3);
            return;
        }
        this.bcT.setStyle(3);
    }

    private void d(boolean z, int i) {
        if (this.bdq && this.bde != null) {
            if (this.mType == 0) {
                if (this.bde.Ew() && !this.bbm) {
                    this.mContext.showToast(a.h.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.bde.Eg()) && this.bde.Eu() && !z) {
                    this.mContext.showToast(this.bde.Eg());
                } else if (this.bde.Ey() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.h.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.bde.Es()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.h.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1) {
                g.b bVar = this.bde.aXx;
                if (bVar != null && !TextUtils.isEmpty(bVar.aXO)) {
                    this.mContext.showToast(bVar.aXO);
                } else if (!TextUtils.isEmpty(this.bde.Eg())) {
                    BdUtilHelper.showToast(this.mContext.getPageActivity(), this.bde.Eg());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.ae.a.Qm().bCs != null && com.baidu.live.ae.a.Qm().bCs.aRl != null) {
            String str = com.baidu.live.ae.a.Qm().bCs.aRl.aQC;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Et()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gu() {
        if (!this.bdc) {
            this.bdr = new BdAlertDialog(this.mContext.getPageActivity());
            this.bdr.setCancelable(false);
            this.bdr.setCanceledOnTouchOutside(false);
            this.bdr.setTitle(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_title));
            this.bdr.setMessage(String.format(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_content), Integer.valueOf(this.bdm)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.bdr.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.bdr.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.bdr.setPositiveButtonTextColor(-57754);
                this.bdr.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.bdr.setPositiveButton(this.mContext.getPageActivity().getString(a.h.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.bdc = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.bdr.setNegativeButton(this.mContext.getPageActivity().getString(a.h.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.22
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.bdc = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.bdr.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.23
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    AlaGiftTabView.this.bcT.setStyle(AlaGiftTabView.this.bde.Ed() ? 2 : 1);
                    AlaGiftTabView.this.bcF.setStyleEnabled(true);
                }
            });
            this.bdr.create(this.mContext).show();
            this.bdc = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.ae.a.Qm().bwx.aMT;
        if (z2) {
            this.bcE.setVisibility(4);
            this.bcT.setStyle(1);
        } else {
            View view = this.bcE;
            if (this.bde == null || !this.bde.Ed()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.bdt != null) {
            this.bdt.j(z2, this.bde != null ? this.bde.getThumbnail_url() : null);
        }
    }

    public void Gv() {
        if (this.bdt != null && this.bde != null) {
            if (this.bde.Eb() == 10) {
                this.bdt.c(true, this.bde.aXC);
            } else {
                this.bdt.c(true, this.bds);
            }
        }
    }

    @Override // com.baidu.live.view.input.c.a
    public void gF(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        gI(str);
    }

    public void gI(String str) {
        this.bcG.setText(str);
        this.bcG.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.d.sdk_fontsize20 : a.d.sdk_fontsize24));
        bS(false);
        if (this.bde != null && this.bde.Ed()) {
            this.bcE.setVisibility(0);
            this.bdf = JavaTypesHelper.toInt(this.bcG.getText().toString(), 1);
            return;
        }
        this.bcE.setVisibility(4);
        this.bdf = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(boolean z) {
        this.bcG.setGravity(17);
        if (z) {
            this.bcG.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.bcG.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, boolean z2, int i) {
        if (this.mType != 0 || this.bcv == null || this.bcv.isEmpty()) {
            rf();
            if (this.bcv == null) {
                this.bcv = new ArrayList<>();
            }
            this.bcv.clear();
            if (arrayList != null) {
                this.bcv.addAll(arrayList);
            }
            this.bcw = arrayList2;
            this.bcx = arrayList3;
            this.bdb = false;
            if (this.bcw == null || this.bcw.isEmpty()) {
                this.bcK.setVisibility(8);
            }
            b(z, z2, i);
            onPageSelected(this.bcI.getCurrentItem());
        }
    }

    public void E(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.bcU != null) {
            for (View view : this.bcU) {
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
                                ((com.baidu.live.gift.container.a) ((GridView) childAt).getAdapter()).E(str, i);
                            }
                        }
                    }
                }
            }
        }
    }

    public void b(boolean z, boolean z2, int i) {
        String string;
        boolean z3;
        Gw();
        if (this.bcv == null || this.bcv.size() <= 0 || !z2) {
            rf();
            if (this.bcJ != null) {
                this.bcJ.setVisibility(4);
            }
            if (this.bdt != null) {
                this.bdt.g("", "", false);
            }
            this.bcO.setVisibility(4);
            this.bcN.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                this.bcN.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.bcN.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_no);
                this.bcN.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.ae.a.Qm().bwx.aOD && i != 0) {
                string = string + "(" + i + ")";
            }
            this.bcN.setTitle(string);
            this.bcN.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.bcX != null) {
                        AlaGiftTabView.this.bcX.GF();
                    }
                }
            });
            this.bcN.setVisibility(0);
            return;
        }
        this.bcN.setVisibility(8);
        if (z) {
            h(this.bcw);
        }
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        if (this.mType == 0 && bvVar != null && bvVar.aRp != null && bvVar.aRp.aTX && !this.bdy && this.bcv.get(0) != null && this.bcv.get(0).Ez() != null) {
            List<g> Ez = this.bcv.get(0).Ez();
            if (Ez.size() <= 1 || Ez.get(1) == null) {
                z3 = true;
            } else {
                z3 = !Ez.get(1).isRed();
            }
            if (!Ez.isEmpty() && z3) {
                g gVar = new g();
                gVar.bA(true);
                gVar.setGiftName("发红包");
                Ez.add(1, gVar);
            }
        }
        c(this.bcv, z);
        gI("1");
    }

    public void dc(int i) {
        A(-1, i);
        Gx();
        if (this.bcI != null) {
            this.bcI.setCurrentItem(this.bcY);
        }
    }

    private void rf() {
        this.bcY = 0;
        this.bcZ = 0;
        this.mSelectedPosition = 0;
        this.bda = 0;
        if (this.bdg != null) {
            this.bdg.clear();
        }
        if (this.bcU != null) {
            this.bcU.clear();
        }
        if (this.bcI != null) {
            this.bcI.setAdapter(null);
        }
        if (this.bdv != null) {
            this.bdv.FV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.Ey()) {
            if (gVar.Et() == 6 && this.bbe < 3) {
                return false;
            }
            if (gVar.Et() == 7 && this.bbe < 7) {
                return false;
            }
            if (gVar.Et() == 8 && this.bbe < 13) {
                return false;
            }
            if (gVar.Et() == 9 && this.bbe < 22) {
                return false;
            }
            if (gVar.Et() == 10 && this.bbe < 29) {
                return false;
            }
            if (gVar.Et() == 11 && this.bbe < 39) {
                return false;
            }
            if (gVar.Et() == 12 && this.bbe < 47) {
                return false;
            }
        }
        if (gVar.Ew()) {
            return this.bbm;
        }
        return true;
    }

    public void b(final ae aeVar) {
        if (aeVar == null || TextUtils.isEmpty(aeVar.iconUrl)) {
            this.bdw.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_show"));
            this.bdw.setVisibility(0);
            this.bdw.startLoad(aeVar.iconUrl, 10, false);
            this.bdw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_clk"));
                    AlaGiftTabView.this.a(aeVar);
                }
            });
            String str = "key_live_official_tip" + currentAccount;
            if (com.baidu.live.d.xf().getInt(str, 0) == 0 && this.bdz) {
                Q(this.bdw);
                com.baidu.live.d.xf().putInt(str, 1);
            }
        }
    }

    private void Gw() {
        if (ListUtils.getCount(this.bcw) != 0 && ListUtils.getCount(this.bcv) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<i> it = this.bcw.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.Bq()) == 0))) {
                    arrayList.add(next);
                    Iterator<h> it2 = this.bcv.iterator();
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
                Iterator<h> it3 = this.bcv.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().Ez().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.Ee()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.bcw.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.bcv.removeAll(arrayList2);
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
        int i3;
        boolean z4;
        List<g> Ez;
        if (arrayList != null) {
            this.bdg.clear();
            this.bcU.clear();
            this.bcI.setAdapter(null);
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
                    if (hVar == null || (Ez = hVar.Ez()) == null || Ez.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.bcW.clear();
            boolean z5 = false;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.bcU.add(dd(i7));
                    this.bdg.append(i7, 1);
                } else {
                    h hVar2 = arrayList.get(i7);
                    hVar2.getCategoryId();
                    List<g> Ez2 = hVar2.Ez();
                    if (Ez2 == null) {
                        i = 0;
                    } else {
                        i = Ez2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.bdh.get(i7)) {
                            this.bcU.add(bT(true));
                        } else {
                            this.bcU.add(b(arrayList3, -1, i7));
                        }
                        this.bcW.add(arrayList3);
                    } else if (Ez2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        int i10 = 0;
                        boolean z6 = z5;
                        while (i10 < ceil) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(Ez2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(Ez2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(Ez2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.bcW.add(arrayList2);
                            if (i7 == 0 && i10 == 0 && z) {
                                if (!z6) {
                                    int i11 = 0;
                                    while (true) {
                                        i3 = i11;
                                        if (i3 >= arrayList2.size()) {
                                            break;
                                        }
                                        gVar = arrayList2.get(i3);
                                        if (gVar == null || gVar.DU() == null || !gVar.DU().equals(String.valueOf(this.bdl))) {
                                            i11 = i3 + 1;
                                        } else {
                                            this.mSelectedPosition = i3;
                                            z4 = true;
                                            break;
                                        }
                                    }
                                }
                                gVar = null;
                                i3 = 0;
                                z4 = z6;
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.bcU.add(b(arrayList2, i3, i7));
                                this.bcT.removeCallbacks(null);
                                this.bcT.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.bde != null) {
                                            boolean Ee = AlaGiftTabView.this.bde.Ee();
                                            AlaGiftTabView.this.bR(Ee);
                                            if (!Ee) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.bde);
                                                if (!c2) {
                                                    AlaGiftTabView.this.bcT.setStyle(AlaGiftTabView.this.bde.Ed() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.bcT.setStyle(AlaGiftTabView.this.bde.Ed() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.bcF.setStyleEnabled(c2);
                                            }
                                        }
                                    }
                                }, 100L);
                                z3 = z4;
                            } else {
                                if (!ListUtils.isEmpty(arrayList2) && !z6) {
                                    int i12 = 0;
                                    while (true) {
                                        i2 = i12;
                                        if (i2 >= arrayList2.size()) {
                                            break;
                                        }
                                        g gVar2 = arrayList2.get(i2);
                                        if (gVar2 == null || !gVar2.DU().equals(String.valueOf(this.bdl))) {
                                            i12 = i2 + 1;
                                        } else {
                                            z3 = true;
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.bcU.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                z3 = z6;
                                this.bcU.add(b(arrayList2, i2, i7));
                            }
                            i10++;
                            z6 = z3;
                        }
                        i8 = ceil;
                        z5 = z6;
                    }
                    this.bdg.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.bcI.setAdapter(new AlaGiftPagerAdapter(this.bcU));
            Gx();
            this.bcI.setCurrentItem(this.bcY);
            Gz();
            if (z && !this.bdA && this.bdz) {
                this.bdA = true;
                Gy();
            }
        }
    }

    private void Gx() {
        int i = 0;
        if (this.bdl > 0 && !ListUtils.isEmpty(this.bcW)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.bcW.size() && !z; i2++) {
                Iterator<g> it = this.bcW.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.DU() != null && next.DU().equals(String.valueOf(this.bdl))) {
                        this.bcY = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aLy == 111 && !z && this.bdq) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_not_find_gift_toast);
            }
            this.bcZ = this.bcY;
            this.bcW.clear();
        } else if (this.bdk > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.bcw.size()) {
                    break;
                }
                i iVar = this.bcw.get(i3);
                if (iVar == null || this.bdk != iVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    db(i3);
                    break;
                }
            }
            this.bcZ = this.bcY;
        }
    }

    private View bT(boolean z) {
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
                if (AlaGiftTabView.this.bcX != null) {
                    AlaGiftTabView.this.bcX.GF();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext.getPageActivity());
        aVar.bF(this.bbg);
        aVar.setGiftItems(list);
        aVar.cQ(this.bbe);
        aVar.bj(this.bbm);
        aVar.cR(i);
        if (this.isLandscape) {
            if (this.bcI.getHeight() > this.bdD) {
                this.bdD = this.bcI.getHeight();
            }
            if (this.bdD > 0) {
                aVar.cS(this.bdD / 3);
            } else {
                this.bcI.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaGiftTabView.this.bcI.getHeight() > AlaGiftTabView.this.bdD) {
                            AlaGiftTabView.this.bdD = AlaGiftTabView.this.bcI.getHeight();
                        }
                        if (AlaGiftTabView.this.bdD > 0) {
                            aVar.cS(AlaGiftTabView.this.bdD / 3);
                            aVar.notifyDataSetChanged();
                        }
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
                if (tag instanceof a.C0179a) {
                    ((a.C0179a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout dd(int i) {
        FrameLayout b2 = b((List<g>) null, -1, i);
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
    private void h(ArrayList<i> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.bdj) {
                this.bcK.setVisibility(0);
            }
            this.bcL.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                i iVar = arrayList.get(i);
                if (!TextUtils.isEmpty(iVar.getCategoryName()) && (this.mType != 0 || (iVar.Bq() != null && iVar.Bq().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.f.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(iVar.getCategoryName());
                    viewGroup.setOnClickListener(new d(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.bdd;
                    }
                    if (this.bcv.size() > i && this.bcv.get(i) != null) {
                        for (g gVar : this.bcv.get(i).Ez()) {
                            if (gVar != null && gVar.Eb() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.bcL.addView(viewGroup, layoutParams);
                }
            }
            de(this.bda);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d5  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void de(int i) {
        JSONArray jSONArray;
        List<g> Ez;
        int childCount = this.bcL.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.bda != i || !this.bdb) && this.bcw.size() > i && this.bcw.get(i) != null) {
                int min = Math.min(i, this.bdg.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.bdg.get(i3);
                }
                if (this.bcU.size() > i2 && this.bcv.size() > i && (this.bcU.get(i2) instanceof ViewGroup)) {
                    if (!this.bdb) {
                        i2 = this.bcY;
                    }
                    this.bcZ = i2;
                    h hVar = this.bcv.get(i);
                    if (hVar != null && hVar.Ez() != null && !hVar.Ez().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.bcU.get(this.bcZ);
                        int i4 = 0;
                        while (true) {
                            if (i4 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i4) instanceof GridView)) {
                                i4++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i4)).getAdapter();
                                if (aVar != null) {
                                    a(aVar, !this.bdb ? this.mSelectedPosition : 0);
                                    this.bdb = true;
                                }
                            }
                        }
                    }
                }
            }
            if (this.bcw.size() > i && this.bcw.get(i) != null) {
                int categoryId = this.bcw.get(i).getCategoryId();
                if (!this.bdn.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.bdn.put(categoryId, true);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewGroup viewGroup2 = (ViewGroup) this.bcL.getChildAt(i5);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.f.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.f.icon_new_unlock_gift);
                imageView.setVisibility(8);
                h hVar2 = this.bcv.get(i5);
                if (hVar2.EA() || hVar2.getCategoryId() == 20) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.bcB, "");
                    JSONArray jSONArray2 = null;
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            jSONArray = new JSONArray(string);
                            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                                try {
                                    hashSet.add(jSONArray.optString(i6));
                                } catch (JSONException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    jSONArray2 = jSONArray;
                                    Ez = hVar2.Ez();
                                    if (Ez != null) {
                                    }
                                    if (i5 == i) {
                                    }
                                    if (i5 == i) {
                                    }
                                }
                            }
                            jSONArray2 = jSONArray;
                        } catch (JSONException e3) {
                            e = e3;
                            jSONArray = null;
                        }
                    }
                    Ez = hVar2.Ez();
                    if (Ez != null) {
                        ArrayList arrayList = new ArrayList();
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= Ez.size()) {
                                break;
                            }
                            g gVar = Ez.get(i8);
                            if (!gVar.Eu() && !hashSet.contains(gVar.DU())) {
                                arrayList.add(gVar.DU());
                            }
                            i7 = i8 + 1;
                        }
                        if (!arrayList.isEmpty()) {
                            if (i5 != i) {
                                if (hVar2.getCategoryId() == 20 && !bdC.containsAll(arrayList)) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913228, true));
                                    bdC.addAll(arrayList);
                                }
                                imageView.setVisibility(0);
                            } else {
                                if (jSONArray2 == null) {
                                    jSONArray2 = new JSONArray();
                                }
                                for (int i9 = 0; i9 < arrayList.size(); i9++) {
                                    jSONArray2.put(arrayList.get(i9));
                                }
                                SharedPrefHelper.getInstance().putString(this.bcB, jSONArray2.toString());
                            }
                        }
                    }
                }
                if (i5 == i) {
                    gradientTextView.setGradientTextColor(-2130706433, -2130706433);
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(0));
                } else {
                    if (imageView.getVisibility() == 0) {
                        imageView.setVisibility(8);
                    }
                    if (this.bdu != 0) {
                        gradientTextView.setGradientTextColor(this.bdu, this.bdu);
                    } else {
                        gradientTextView.setGradientTextColor(-52429, -52429);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    df(i);
                    this.bda = i;
                    this.bcK.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i5 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bU(false);
                        } else {
                            bU(true);
                        }
                    } else {
                        bU(true);
                    }
                }
            }
        }
    }

    private void bU(boolean z) {
        int i = 8;
        if (this.bcQ != null) {
            this.bcQ.setVisibility(z ? this.bdp ? 8 : 0 : 8);
        }
        if (this.bcR != null) {
            TextView textView = this.bcR;
            if (!z && !this.bdp) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void df(int i) {
        int childCount = this.bcL.getChildCount();
        if (i >= 0 && i < childCount && this.bcv != null && this.bcv.size() > i && this.bcv.get(i) != null) {
            this.bdh.get(i);
        }
    }

    public void A(int i, int i2) {
        this.bdk = i;
        this.bdl = i2;
    }

    public void aQ(long j) {
        if (this.bcQ != null) {
            if (j >= 100 && (this.bbg || com.baidu.live.ae.a.Qm().bwx.aNR)) {
                this.bcQ.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.bcQ.setText(String.valueOf(j));
        }
    }

    public void aR(long j) {
        if (this.bcR != null) {
            this.bcR.setText(String.valueOf(j));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.bcY = i;
        Gz();
        Gt();
        if (i >= 0 && i < this.bcU.size() && (this.bcU.get(i) instanceof ViewGroup)) {
            Gy();
            ViewGroup viewGroup = (ViewGroup) this.bcU.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.FY() >= 0 && i != this.bcZ) {
                            aVar.cR(-1);
                        }
                        if (aVar.FY() < 0 && i == this.bcZ) {
                            aVar.cR(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        a(gridView);
                        this.bcO.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void a(final AbsListView absListView) {
        if (this.bdB != null) {
            this.bdB.cancel();
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
                        if (childAt != null && (childAt.getTag() instanceof a.C0179a)) {
                            a.C0179a c0179a = (a.C0179a) childAt.getTag();
                            if (c0179a.bbt != null && (c0179a.bbt.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (gVar = (g) c0179a.bbt.getTag(a.f.TAG_GIFT_ITEM)) != null && gVar.aXB != null && gVar.aXB.enabled && gVar.aXB.aXH && !TextUtils.isEmpty(gVar.aXB.detailUrl)) {
                                String DU = gVar.DU();
                                if (!x.Ff().gf(DU)) {
                                    x.Ff().gg(DU);
                                    AlaGiftTabView.this.b(c0179a.bbt, !TextUtils.isEmpty(gVar.aXB.aXI) ? gVar.aXB.aXI : "长按查看规则");
                                    AnimatorSet a2 = AlaGiftTabView.this.a(absListView, c0179a);
                                    a2.playTogether(AlaGiftTabView.this.R(c0179a.bbo), AlaGiftTabView.this.S(c0179a.bbt));
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
    public void b(TextView textView, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-39424);
        gradientDrawable.setCornerRadius(textView.getResources().getDimensionPixelOffset(a.d.sdk_ds24));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet a(final AbsListView absListView, final a.C0179a c0179a) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                if (c0179a != null && c0179a.bbt != null) {
                    c0179a.bbt.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c0179a != null && c0179a.bbt != null) {
                    c0179a.bbt.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c0179a != null) {
                    c0179a.Gb();
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
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.baidu.live.gift.container.a.a(), new a.C0180a(), new a.C0180a());
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
                if (view != null && (valueAnimator.getAnimatedValue() instanceof a.C0180a)) {
                    a.C0180a c0180a = (a.C0180a) valueAnimator.getAnimatedValue();
                    view.setScaleX(c0180a.scale);
                    view.setScaleY(c0180a.scale);
                    view.setAlpha(c0180a.alpha);
                }
            }
        });
        return ofObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(List<Animator> list) {
        if (list != null && !list.isEmpty()) {
            if (this.bdB == null) {
                this.bdB = new AnimatorSet();
                this.bdB.setInterpolator(new LinearInterpolator());
            }
            this.bdB.playTogether(list);
            this.bdB.start();
        }
    }

    private void Gy() {
        JSONObject jSONObject = new JSONObject();
        i iVar = (i) ListUtils.getItem(this.bcw, this.bda);
        if (iVar != null) {
            try {
                jSONObject.put("tabid", iVar.getCategoryId());
                jSONObject.put("tabname", iVar.getCategoryName());
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "giftpanel_show").setContentExt(null, "giftpanel", jSONObject));
    }

    private void Gz() {
        int i = 0;
        for (int i2 = 0; i2 < this.bdg.size(); i2++) {
            for (int i3 = 0; i3 < this.bdg.get(i2); i3++) {
                if (i + i3 == this.bcY) {
                    if (this.bdg.get(i2) <= 1) {
                        this.bcJ.setVisibility(4);
                    } else {
                        this.bcJ.setVisibility(0);
                    }
                    this.bcJ.setCount(this.bdg.get(i2));
                    this.bcJ.onPageSelected(i3);
                    de(i2);
                    return;
                }
            }
            i += this.bdg.get(i2);
        }
    }

    public g GA() {
        return this.bde;
    }

    public int GB() {
        return this.bdf;
    }

    public void a(e eVar) {
        this.bcX = eVar;
    }

    public void dg(int i) {
        this.bdf = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bdG);
        MessageManager.getInstance().registerListener(this.bdH);
        MessageManager.getInstance().registerListener(this.bdI);
        MessageManager.getInstance().registerListener(this.bdJ);
    }

    public void GC() {
        if (!ListUtils.isEmpty(this.bcU)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bcU) {
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
    public void av(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.bcU) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bcU) {
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
    public void GD() {
        if (!ListUtils.isEmpty(this.bcU)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bcU) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.bbm);
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
    public void GE() {
        if (this.bde != null && this.bde.Ew()) {
            this.bcF.setStyleEnabled(this.bbm);
            if (this.bbm) {
                this.bcT.setStyle(this.bde.Ed() ? 2 : 1);
            } else {
                this.bcT.setStyle(this.bde.Ed() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.bdt = null;
        MessageManager.getInstance().unRegisterListener(this.bdG);
        MessageManager.getInstance().unRegisterListener(this.bdH);
        MessageManager.getInstance().unRegisterListener(this.bdI);
        MessageManager.getInstance().unRegisterListener(this.bdJ);
        rf();
        if (this.bdr != null) {
            this.bdr.dismiss();
        }
        if (this.bdB != null) {
            this.bdB.cancel();
        }
    }

    public void bF(boolean z) {
        this.bbg = z;
    }

    public void dh(int i) {
        this.bbe = i;
    }

    public void d(g gVar) {
        this.bde = gVar;
        if (this.bde.DU().equals("")) {
            BdUtilHelper.showToast(this.mContext.getPageActivity(), "该礼物已下线");
            return;
        }
        this.bdl = Integer.valueOf(this.bde.DU()).intValue();
        if (this.bdt != null) {
            this.bdt.a(gVar);
        }
        if (gVar != null && !gVar.Ef()) {
            this.bdv.FV();
        }
    }

    public void FU() {
        if (this.bdv != null) {
            this.bdv.FU();
        }
        g gVar = this.bde;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.DU());
                jSONObject.putOpt("gift_name", gVar.DV());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "combosend_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
        }
    }

    public void FT() {
        if (this.bdv != null) {
            this.bdv.FT();
        }
        g gVar = this.bde;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.DU());
                jSONObject.putOpt("gift_name", gVar.DV());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "combosend_clk").setContentExt(null, null, jSONObject));
        }
    }

    public void bV(boolean z) {
        if (this.bcT != null) {
            this.bcT.setVisibility(z ? 0 : 4);
        }
    }
}

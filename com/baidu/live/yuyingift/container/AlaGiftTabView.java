package com.baidu.live.yuyingift.container;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
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
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d.ai;
import com.baidu.live.data.ab;
import com.baidu.live.data.ae;
import com.baidu.live.data.bv;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.gift.am;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
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
import com.baidu.live.yuyingift.container.AlaComboBtnAnimView;
import com.baidu.live.yuyingift.container.a;
import com.baidu.live.yuyingift.widget.panel.GiftPanelNumRoundRectView;
import com.baidu.live.yuyingift.widget.panel.GiftPanelOperationSendView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
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
    public TextView bcG;
    private BaseViewPager bcI;
    private RoundRectPageIndicator bcJ;
    private HorizontalScrollView bcK;
    private LinearLayout bcL;
    private CommonEmptyView bcN;
    private View bcO;
    private TextView bcQ;
    private TextView bcR;
    private TextView bcS;
    private List<View> bcU;
    private ArrayList<List<g>> bcW;
    private int bcY;
    private int bcZ;
    public ArrayList<h> bcv;
    private ArrayList<i> bcw;
    private ArrayList<l> bcx;
    private boolean bdA;
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
    private int bdu;
    private TbImageView bdw;
    private boolean bdy;
    private boolean bdz;
    private GiftPanelNumRoundRectView caq;
    private com.baidu.live.yuyingift.container.c car;
    public GiftPanelOperationSendView cas;
    private e cat;
    private a cau;
    private AlaComboBtnAnimView cav;
    private com.baidu.live.yuyingift.container.d caw;
    private b cax;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private int mSelectedPosition;
    private int mType;
    private String otherParams;
    private String roomId;

    /* loaded from: classes10.dex */
    public interface a {
        void YH();

        void YI();

        void YJ();

        void YK();

        void YL();

        void YM();

        void YN();

        void a(g gVar);

        void aT(String str, String str2);

        void aU(String str, String str2);

        void c(boolean z, int i);

        void j(boolean z, String str);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void j(g gVar);
    }

    /* loaded from: classes10.dex */
    public interface e {
        void GF();
    }

    public void a(b bVar) {
        this.cax = bVar;
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.bcB = "live_key_privilege_tab_unlock_giftid_array_yuyin_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.bcU = new ArrayList();
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
        this.bdE = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.cav == null || !AlaGiftTabView.this.cav.FW()) {
                    if (AlaGiftTabView.this.car == null) {
                        AlaGiftTabView.this.car = new com.baidu.live.yuyingift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.bdF);
                    }
                    if (AlaGiftTabView.this.cau != null) {
                        AlaGiftTabView.this.cau.YM();
                    }
                    AlaGiftTabView.this.bS(true);
                    AlaGiftTabView.this.car.a(AlaGiftTabView.this.bcE, AlaGiftTabView.this.bcx, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.11.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bS(false);
                        }
                    });
                }
            }
        };
        this.bdF = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.car.dismiss();
                if (AlaGiftTabView.this.bcx != null && AlaGiftTabView.this.bcx.size() > 0) {
                    if (i != AlaGiftTabView.this.bcx.size()) {
                        l lVar = (l) AlaGiftTabView.this.bcx.get(i);
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
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.Gv();
                    return;
                }
                AlaGiftTabView.this.gI("1");
            }
        };
        this.bdG = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.h.c)) {
                    com.baidu.live.h.c cVar = (com.baidu.live.h.c) customResponsedMessage.getData();
                    if (cVar.aVB == 1 || cVar.aVB == 2 || cVar.aVB == 5 || cVar.aVB == 6 || cVar.aVB == 7) {
                        if (cVar.aVB == 2) {
                            cVar.aVC.setLength(0L);
                        } else {
                            long size = cVar.aVC.getSize() / 10;
                            if (size == 0) {
                                cVar.aVC.setLength(1L);
                                cVar.aVC.setSize(10L);
                            } else if (cVar.aVC.getLength() < size) {
                                cVar.aVC.setLength(size);
                            }
                        }
                        if (cVar.aVC != null) {
                            AlaGiftTabView.this.e(cVar.aVC.getId(), cVar.aVC.getUrl(), cVar.aVC.getProcess());
                        }
                    }
                }
            }
        };
        this.bdH = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bN(true);
                if (AlaGiftTabView.this.bde != null && AlaGiftTabView.this.b(AlaGiftTabView.this.bde) && AlaGiftTabView.this.bcC) {
                    AlaGiftTabView.this.cas.setStyle(AlaGiftTabView.this.bde.Ed() ? 2 : 1);
                    AlaGiftTabView.this.caq.setStyleEnabled(true);
                }
            }
        };
        this.bdI = new CustomMessageListener(2501033) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.6
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
        this.bdJ = new CustomMessageListener(2913179) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.Gu();
                    AlaGiftTabView.this.cas.setStyle(AlaGiftTabView.this.bde.Ed() ? 4 : 3);
                    AlaGiftTabView.this.caq.setStyleEnabled(false);
                    if (AlaGiftTabView.this.cau != null) {
                        AlaGiftTabView.this.cau.j(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.bdi = onClickListener;
        this.bdj = z;
        this.bcD = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_live_gift_panel_fragment, (ViewGroup) null);
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
                return;
            case 1:
                this.bds = 999;
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
        this.cau = aVar;
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
        this.caq = (GiftPanelNumRoundRectView) this.bcD.findViewById(a.f.gift_count_round);
        this.bcG = (TextView) this.bcD.findViewById(a.f.gift_count_input);
        this.bcG.setText("1");
        this.bdf = 1;
        this.bcG.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
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
        this.cas = (GiftPanelOperationSendView) this.bcD.findViewById(a.f.donate);
        this.bcS = (TextView) this.bcD.findViewById(a.f.current_recharge);
        this.bcS.setOnClickListener(this.bdi);
        this.cas.setOnClickListener(this.bdi);
        FrameLayout frameLayout = (FrameLayout) this.bcD.findViewById(a.f.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        frameLayout.setPadding(0, BdUtilHelper.dip2px(this.mContext.getPageActivity(), 48.0f), 0, 0);
        this.bcN = new CommonEmptyView(this.mContext.getPageActivity());
        this.bcN.setVisibility(8);
        this.bcN.addToParent(frameLayout);
        this.bcO = this.bcD.findViewById(a.f.donate_layout);
        this.cav = (AlaComboBtnAnimView) this.bcD.findViewById(a.f.combo_layout);
        this.cav.setComboClickListener(this.bdi);
        this.cav.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.1
            @Override // com.baidu.live.yuyingift.container.AlaComboBtnAnimView.a
            public void j(g gVar) {
                AlaGiftTabView.this.bV(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501075, false));
                if (AlaGiftTabView.this.cax != null) {
                    AlaGiftTabView.this.cax.j(gVar);
                }
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
        if (com.baidu.live.ae.a.Qm().Qs() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
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
        this.bdz = z;
        if (z && !ListUtils.isEmpty(this.bcw)) {
            Gy();
            this.bdA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ae aeVar) {
        if (aeVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "tycoon_pop_show"));
            if (this.caw == null) {
                this.caw = new com.baidu.live.yuyingift.container.d(this.mContext);
            }
            this.caw.n(aeVar.dialogTitle, aeVar.aLa + aeVar.aLb, aeVar.aLb);
        }
    }

    private void Q(View view) {
        if (this.caw == null) {
            this.caw = new com.baidu.live.yuyingift.container.d(this.mContext);
        }
        this.caw.O(view);
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
            ViewGroup.LayoutParams layoutParams = this.bcI.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height) + this.mContext.getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom);
                this.bcI.setLayoutParams(layoutParams);
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
        if (this.cau != null) {
            this.cau.c(false, this.bds);
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
    public class c implements AdapterView.OnItemClickListener {
        private c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            g item = ((com.baidu.live.yuyingift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.isRed()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ai(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.bcZ = AlaGiftTabView.this.bcY;
            AlaGiftTabView.this.a((com.baidu.live.yuyingift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void Gt() {
        if (this.cau != null) {
            if (this.bde != null && this.bde.aXy) {
                this.cau.aT(this.bde.aXz, this.bde.aXA);
            } else {
                this.cau.aT(null, null);
            }
        }
    }

    public void a(com.baidu.live.yuyingift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.cau != null) {
            this.cau.c(false, this.bds);
            this.cau.YH();
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
                        this.cas.setStyle(this.bde.Ed() ? 4 : 3);
                        this.caq.setStyleEnabled(false);
                        if (this.cau != null) {
                            this.cau.j(false, null);
                        }
                        if (!TextUtils.isEmpty(this.bde.Eg()) && this.bdq) {
                            this.mContext.showToast(this.bde.Eg());
                            return;
                        }
                        return;
                    }
                    Gt();
                    this.cas.setEnabled(true);
                    if (this.bde.Ey()) {
                        if (this.cau != null) {
                            this.cau.j(false, null);
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
                        this.cas.setStyle(this.bde.Ed() ? 2 : 1);
                    } else {
                        this.cas.setStyle(this.bde.Ed() ? 4 : 3);
                    }
                    this.caq.setStyleEnabled(z);
                    GE();
                    i2 = i3;
                } else {
                    this.cas.setStyle(this.bde.Ed() ? 2 : 1);
                    if (this.bde.aXx != null && this.bde.aXx.aXL != null && this.bde.aXx.aXL.equals("20")) {
                        this.cas.setText("使用");
                    } else {
                        this.cas.setText("赠送");
                    }
                    this.caq.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.bde.Ee()) {
                    bR(true);
                } else {
                    bR(false);
                    gI("1");
                }
                d(false, i2);
                return;
            }
            this.cas.setStyle(3);
            return;
        }
        this.cas.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.b bVar;
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
            } else if (this.mType == 1 && (bVar = this.bde.aXx) != null && !TextUtils.isEmpty(bVar.aXO)) {
                this.mContext.showToast(bVar.aXO);
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
            this.bdr.setPositiveButton(this.mContext.getPageActivity().getString(a.h.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.bdc = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.bdr.setNegativeButton(this.mContext.getPageActivity().getString(a.h.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.bdc = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.bdr.create(this.mContext).show();
            this.bdc = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(boolean z) {
        boolean z2 = z && com.baidu.live.ae.a.Qm().bwx.aMT;
        if (z2) {
            this.bcE.setVisibility(4);
            this.cas.setStyle(1);
        } else if (this.bde != null && this.bde.Ed()) {
            if (this.cau != null) {
                this.cau.YL();
            }
            this.bcE.setVisibility(0);
        } else {
            this.bcE.setVisibility(4);
        }
        if (this.cau != null) {
            this.cau.j(z2, this.bde != null ? this.bde.getThumbnail_url() : null);
        }
    }

    public void Gv() {
        if (this.cau != null) {
            this.cau.c(true, this.bds);
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
        if (this.bcv == null || this.bcv.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
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
                            } else if (((GridView) childAt).getAdapter() instanceof com.baidu.live.yuyingift.container.a) {
                                ((com.baidu.live.yuyingift.container.a) ((GridView) childAt).getAdapter()).E(str, i);
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
            this.bcN.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.cat != null) {
                        AlaGiftTabView.this.cat.GF();
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
                gVar.aXG = 100;
                gVar.setGiftName("发红包");
                Ez.add(1, gVar);
            }
        }
        c(this.bcv, z);
        gI("1");
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
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "tycoon_show"));
            this.bdw.setVisibility(0);
            this.bdw.startLoad(aeVar.iconUrl, 10, false);
            this.bdw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "tycoon_clk"));
                    AlaGiftTabView.this.a(aeVar);
                }
            });
            String str = "key_live_official_tip_yuyin" + currentAccount;
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
        int i3;
        g gVar;
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
            as(arrayList);
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
                    } else if (Ez2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
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
                                int i11 = 0;
                                while (true) {
                                    i3 = i11;
                                    if (i3 >= arrayList2.size()) {
                                        gVar = null;
                                        i3 = 0;
                                        break;
                                    }
                                    gVar = arrayList2.get(i3);
                                    if (gVar == null || gVar.DU() == null || !gVar.DU().equals(String.valueOf(this.bdl))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.bcU.add(b(arrayList2, i3, i7));
                                this.cas.removeCallbacks(null);
                                this.cas.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.17
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.bde != null) {
                                            boolean Ee = AlaGiftTabView.this.bde.Ee();
                                            AlaGiftTabView.this.bR(Ee);
                                            if (!Ee) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.bde);
                                                if (!c2) {
                                                    AlaGiftTabView.this.cas.setStyle(AlaGiftTabView.this.bde.Ed() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.cas.setStyle(AlaGiftTabView.this.bde.Ed() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.caq.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.DU().equals(String.valueOf(this.bdl))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.bcU.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.bcU.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
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

    private void as(List<h> list) {
        if (list != null && this.bdk > 0 && this.bdl <= 0) {
            for (h hVar : list) {
                if (hVar.getCategoryId() == this.bdk) {
                    List<g> Ez = hVar.Ez();
                    if (Ez != null && !Ez.isEmpty() && Ez.get(0) != null) {
                        this.bdl = Integer.valueOf(Ez.get(0).DU()).intValue();
                        return;
                    }
                    return;
                }
            }
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
        commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.cat != null) {
                    AlaGiftTabView.this.cat.GF();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.yuyingift.container.a aVar = new com.baidu.live.yuyingift.container.a(this.mContext, this.mType);
        aVar.bF(this.bbg);
        aVar.setGiftItems(list);
        aVar.cQ(this.bbe);
        aVar.bj(this.bbm);
        aVar.cR(i);
        if (this.isLandscape) {
            if (this.bcI.getHeight() > 0) {
                aVar.cS(this.bcI.getHeight() / 3);
            } else {
                this.bcI.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.cS(AlaGiftTabView.this.bcI.getHeight() / 3);
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
        bdGridView.setOnItemClickListener(new c());
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.3
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0242a) {
                    ((a.C0242a) tag).recycle();
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

    /* JADX WARN: Removed duplicated region for block: B:101:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01aa  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void de(int i) {
        int i2;
        JSONArray jSONArray;
        List<g> Ez;
        int childCount = this.bcL.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.bda != i || !this.bdb) && this.bcw.size() > i && this.bcw.get(i) != null) {
                int min = Math.min(i, this.bdg.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.bdg.get(i4);
                }
                if (this.bcU.size() > i3 && this.bcv.size() > i && (this.bcU.get(i3) instanceof ViewGroup)) {
                    this.bcZ = i3;
                    h hVar = this.bcv.get(i);
                    if (hVar != null && hVar.Ez() != null && !hVar.Ez().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.bcU.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.yuyingift.container.a aVar = (com.baidu.live.yuyingift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.bdb) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.bcY) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.bdq) {
                                        this.bdb = true;
                                    }
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
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.bcL.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.f.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.f.icon_new_unlock_gift);
                imageView.setVisibility(8);
                h hVar2 = this.bcv.get(i6);
                if (hVar2.EA()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.bcB, "");
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
                                    Ez = hVar2.Ez();
                                    if (Ez != null) {
                                    }
                                    if (i6 == i) {
                                    }
                                    if (i6 == i) {
                                    }
                                }
                            }
                        } catch (JSONException e3) {
                            e = e3;
                            jSONArray = null;
                        }
                    }
                    Ez = hVar2.Ez();
                    if (Ez != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= Ez.size()) {
                                break;
                            }
                            g gVar = Ez.get(i9);
                            if (!gVar.Eu() && !hashSet.contains(gVar.DU())) {
                                arrayList.add(gVar.DU());
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
                                SharedPrefHelper.getInstance().putString(this.bcB, jSONArray.toString());
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
                    if (this.bdu != 0) {
                        gradientTextView.setGradientTextColor(this.bdu, this.bdu);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    df(i);
                    this.bda = i;
                    this.bcK.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
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
                        com.baidu.live.yuyingift.container.a aVar = (com.baidu.live.yuyingift.container.a) gridView.getAdapter();
                        if (aVar.FY() >= 0 && i != this.bcZ) {
                            aVar.cR(-1);
                        }
                        if (aVar.FY() < 0 && i == this.bcZ) {
                            aVar.cR(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.bcO.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void Gy() {
        i iVar = (i) ListUtils.getItem(this.bcw, this.bda);
        if (this.cau != null && iVar != null) {
            this.cau.aU(String.valueOf(iVar.getCategoryId()), iVar.getCategoryName());
        }
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
        this.cat = eVar;
    }

    public void dg(int i) {
        if (i <= 0) {
            i = 1;
        }
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
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.8
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
                                    if (gridView.getAdapter() instanceof com.baidu.live.yuyingift.container.a) {
                                        ((com.baidu.live.yuyingift.container.a) gridView.getAdapter()).notifyDataSetChanged();
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
    public void e(final String str, final String str2, final int i) {
        if (!ListUtils.isEmpty(this.bcU) && !TextUtils.isEmpty(str)) {
            new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bcU) {
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) view;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= viewGroup.getChildCount()) {
                                    break;
                                } else if (!(viewGroup.getChildAt(i2) instanceof GridView)) {
                                    i2++;
                                } else {
                                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                                    if (gridView.getAdapter() instanceof com.baidu.live.yuyingift.container.a) {
                                        ((com.baidu.live.yuyingift.container.a) gridView.getAdapter()).a(gridView, str, str2, i);
                                    }
                                }
                            }
                        }
                    }
                }
            }.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GD() {
        if (!ListUtils.isEmpty(this.bcU)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.10
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
                                    if (gridView.getAdapter() instanceof com.baidu.live.yuyingift.container.a) {
                                        ((com.baidu.live.yuyingift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.bbm);
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
            this.caq.setStyleEnabled(this.bbm);
            if (this.bbm) {
                this.cas.setStyle(this.bde.Ed() ? 2 : 1);
            } else {
                this.cas.setStyle(this.bde.Ed() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.cau = null;
        MessageManager.getInstance().unRegisterListener(this.bdG);
        MessageManager.getInstance().unRegisterListener(this.bdH);
        MessageManager.getInstance().unRegisterListener(this.bdI);
        MessageManager.getInstance().unRegisterListener(this.bdJ);
        rf();
        if (this.bdr != null) {
            this.bdr.dismiss();
        }
    }

    public void bF(boolean z) {
        this.bbg = z;
    }

    public void dh(int i) {
        this.bbe = i;
    }

    public void d(g gVar) {
        com.baidu.live.gift.c gS;
        if (this.cav != null) {
            this.cav.FV();
        }
        this.bde = gVar;
        this.bdl = Integer.valueOf(this.bde.DU()).intValue();
        if (this.cau != null) {
            this.cau.a(gVar);
        }
        if (BdNetTypeUtil.isNetWorkAvailable() && this.bde.Ei() && !com.baidu.live.yuyingift.b.b.Za().gk(this.bde.DU()) && (gS = com.baidu.live.yuyingift.b.b.Za().gS(this.bde.DU())) != null) {
            am.FF().a(gS.aWS, true);
        }
    }

    public void YS() {
        if (this.cav != null && this.cav.FW()) {
            this.cav.FV();
        }
    }

    public void FU() {
        if (this.cav != null) {
            this.cav.i(GA());
        }
    }

    public void FT() {
        if (this.cav != null) {
            this.cav.h(GA());
        }
    }

    public void bV(boolean z) {
        if (this.cas != null) {
            this.cas.setVisibility(z ? 0 : 4);
        }
        if (this.bcE != null) {
            this.bcE.setVisibility(z ? 0 : 4);
        }
    }
}

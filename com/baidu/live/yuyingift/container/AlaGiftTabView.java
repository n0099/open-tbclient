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
import com.baidu.live.data.aa;
import com.baidu.live.data.bq;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.data.x;
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
/* loaded from: classes11.dex */
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, c.a {
    private int aMg;
    private GiftPanelNumRoundRectView bZA;
    private com.baidu.live.yuyingift.container.c bZB;
    public GiftPanelOperationSendView bZC;
    private e bZD;
    private a bZE;
    private AlaComboBtnAnimView bZF;
    private com.baidu.live.yuyingift.container.d bZG;
    private b bZH;
    private int bbl;
    private boolean bbn;
    private boolean bbt;
    public ArrayList<h> bcC;
    private ArrayList<i> bcD;
    private ArrayList<k> bcE;
    private final String bcI;
    private boolean bcJ;
    private ViewGroup bcK;
    private View bcL;
    public TextView bcN;
    private BaseViewPager bcP;
    private RoundRectPageIndicator bcQ;
    private HorizontalScrollView bcR;
    private LinearLayout bcS;
    private CommonEmptyView bcU;
    private View bcV;
    private TextView bcX;
    private TextView bcY;
    private TextView bcZ;
    private int bdB;
    private TbImageView bdD;
    private boolean bdF;
    private boolean bdG;
    private boolean bdH;
    private View.OnClickListener bdK;
    AdapterView.OnItemClickListener bdL;
    private CustomMessageListener bdM;
    private CustomMessageListener bdN;
    private CustomMessageListener bdO;
    private CustomMessageListener bdP;
    private List<View> bdb;
    private ArrayList<List<g>> bdd;
    private int bdf;
    private int bdg;
    private int bdh;
    private boolean bdi;
    private boolean bdj;
    private int bdk;
    private g bdl;
    private int bdm;
    private SparseIntArray bdn;
    private SparseBooleanArray bdo;
    private View.OnClickListener bdp;
    private boolean bdq;
    private int bdr;
    private int bds;
    private int bdt;
    private SparseBooleanArray bdu;
    private Set<String> bdv;
    private boolean bdw;
    private boolean bdx;
    private BdAlertDialog bdy;
    private int bdz;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private int mSelectedPosition;
    private int mType;
    private String otherParams;
    private String roomId;

    /* loaded from: classes11.dex */
    public interface a {
        void a(g gVar);

        void aV(String str, String str2);

        void aW(String str, String str2);

        void aaG();

        void aaH();

        void aaI();

        void aaJ();

        void aaK();

        void aaL();

        void aaM();

        void c(boolean z, int i);

        void f(boolean z, String str);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void j(g gVar);
    }

    /* loaded from: classes11.dex */
    public interface e {
        void Jh();
    }

    public void a(b bVar) {
        this.bZH = bVar;
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.bcI = "live_key_privilege_tab_unlock_giftid_array_yuyin_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.bdb = new ArrayList();
        this.bdf = 0;
        this.bdg = 0;
        this.mSelectedPosition = 0;
        this.bdh = 0;
        this.bdn = new SparseIntArray();
        this.bdo = new SparseBooleanArray();
        this.isLandscape = false;
        this.bdq = false;
        this.bdr = -1;
        this.bds = -1;
        this.bbn = false;
        this.bbl = -1;
        this.bdu = new SparseBooleanArray();
        this.bdv = new HashSet();
        this.bdF = false;
        this.bbt = false;
        this.bdG = false;
        this.bdH = false;
        this.bdK = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.bZF == null || !AlaGiftTabView.this.bZF.Iy()) {
                    if (AlaGiftTabView.this.bZB == null) {
                        AlaGiftTabView.this.bZB = new com.baidu.live.yuyingift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.bdL);
                    }
                    if (AlaGiftTabView.this.bZE != null) {
                        AlaGiftTabView.this.bZE.aaL();
                    }
                    AlaGiftTabView.this.bR(true);
                    AlaGiftTabView.this.bZB.a(AlaGiftTabView.this.bcL, AlaGiftTabView.this.bcE, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.11.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bR(false);
                        }
                    });
                }
            }
        };
        this.bdL = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.bZB.dismiss();
                if (AlaGiftTabView.this.bcE != null && AlaGiftTabView.this.bcE.size() > 0) {
                    if (i != AlaGiftTabView.this.bcE.size()) {
                        k kVar = (k) AlaGiftTabView.this.bcE.get(i);
                        if (kVar != null) {
                            int number = kVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (bVar = AlaGiftTabView.this.bdl.aXF) != null) {
                                if (number == -1) {
                                    number = bVar.aXU;
                                }
                                if (number > AlaGiftTabView.this.bdz) {
                                    number = AlaGiftTabView.this.bdz;
                                }
                            }
                            AlaGiftTabView.this.hq(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.IX();
                    return;
                }
                AlaGiftTabView.this.hq("1");
            }
        };
        this.bdM = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.i.c)) {
                    com.baidu.live.i.c cVar = (com.baidu.live.i.c) customResponsedMessage.getData();
                    if (cVar.aVJ == 1 || cVar.aVJ == 2 || cVar.aVJ == 5 || cVar.aVJ == 6 || cVar.aVJ == 7) {
                        if (cVar.aVJ == 2) {
                            cVar.aVK.setLength(0L);
                        } else {
                            long size = cVar.aVK.getSize() / 10;
                            if (size == 0) {
                                cVar.aVK.setLength(1L);
                                cVar.aVK.setSize(10L);
                            } else if (cVar.aVK.getLength() < size) {
                                cVar.aVK.setLength(size);
                            }
                        }
                        if (cVar.aVK != null) {
                            AlaGiftTabView.this.e(cVar.aVK.getId(), cVar.aVK.getUrl(), cVar.aVK.getProcess());
                        }
                    }
                }
            }
        };
        this.bdN = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bM(true);
                if (AlaGiftTabView.this.bdl != null && AlaGiftTabView.this.b(AlaGiftTabView.this.bdl) && AlaGiftTabView.this.bcJ) {
                    AlaGiftTabView.this.bZC.setStyle(AlaGiftTabView.this.bdl.GF() ? 2 : 1);
                    AlaGiftTabView.this.bZA.setStyleEnabled(true);
                }
            }
        };
        this.bdO = new CustomMessageListener(2501033) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                x xVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x) && (xVar = (x) customResponsedMessage.getData()) != null && xVar.aKQ != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = xVar.aKQ.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.bbt != z2) {
                        AlaGiftTabView.this.bbt = z2;
                        AlaGiftTabView.this.Jg();
                        AlaGiftTabView.this.Jf();
                    }
                }
            }
        };
        this.bdP = new CustomMessageListener(2913179) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.IW();
                    AlaGiftTabView.this.bZC.setStyle(AlaGiftTabView.this.bdl.GF() ? 4 : 3);
                    AlaGiftTabView.this.bZA.setStyleEnabled(false);
                    if (AlaGiftTabView.this.bZE != null) {
                        AlaGiftTabView.this.bZE.f(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.bdp = onClickListener;
        this.bdq = z;
        this.bcK = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.bdk = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.d.sdk_ds36);
        this.bdd = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.bdz = AlaRecorderLog.ErrorCode.ERROR_RECORDER_NOT_DEFINE_ERROR;
                return;
            case 1:
                this.bdz = 999;
                return;
            default:
                return;
        }
    }

    public void ey(int i) {
        int childCount;
        this.bdB = i;
        if (this.bcS != null && (childCount = this.bcS.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.bdh) {
                    ((GradientTextView) ((ViewGroup) this.bcS.getChildAt(i2)).findViewById(a.f.text_view)).setGradientTextColor(this.bdB, this.bdB);
                }
            }
        }
    }

    public void a(a aVar) {
        this.bZE = aVar;
    }

    public void av(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bL(boolean z) {
        this.bdx = z;
    }

    public void onVisibilityChanged(boolean z) {
        bL(z);
    }

    public View getRootView() {
        return this.bcK;
    }

    private void initViews() {
        this.bcL = this.bcK.findViewById(a.f.gift_count_layout);
        this.bcL.setOnClickListener(this.bdK);
        this.bZA = (GiftPanelNumRoundRectView) this.bcK.findViewById(a.f.gift_count_round);
        this.bcN = (TextView) this.bcK.findViewById(a.f.gift_count_input);
        this.bcN.setText("1");
        this.bdm = 1;
        this.bcN.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bcP = (BaseViewPager) this.bcK.findViewById(a.f.gift_viewpager);
        this.bcP.setOnPageChangeListener(this);
        this.bcQ = (RoundRectPageIndicator) this.bcK.findViewById(a.f.gift_tab_indicator);
        this.bcS = (LinearLayout) this.bcK.findViewById(a.f.gift_tab_layout);
        this.bcR = (HorizontalScrollView) this.bcK.findViewById(a.f.gift_tab_scrollview);
        if (this.bdq) {
            this.bcR.setVisibility(8);
        }
        this.bcX = (TextView) this.bcK.findViewById(a.f.current_money);
        this.bcX.setOnClickListener(this.bdp);
        this.bcY = (TextView) this.bcK.findViewById(a.f.current_flower);
        this.bcY.setOnClickListener(this.bdp);
        this.bZC = (GiftPanelOperationSendView) this.bcK.findViewById(a.f.donate);
        this.bcZ = (TextView) this.bcK.findViewById(a.f.current_recharge);
        this.bcZ.setOnClickListener(this.bdp);
        this.bZC.setOnClickListener(this.bdp);
        FrameLayout frameLayout = (FrameLayout) this.bcK.findViewById(a.f.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        frameLayout.setPadding(0, BdUtilHelper.dip2px(this.mContext.getPageActivity(), 48.0f), 0, 0);
        this.bcU = new CommonEmptyView(this.mContext.getPageActivity());
        this.bcU.setVisibility(8);
        this.bcU.addToParent(frameLayout);
        this.bcV = this.bcK.findViewById(a.f.donate_layout);
        this.bZF = (AlaComboBtnAnimView) this.bcK.findViewById(a.f.combo_layout);
        this.bZF.setComboClickListener(this.bdp);
        this.bZF.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.1
            @Override // com.baidu.live.yuyingift.container.AlaComboBtnAnimView.a
            public void j(g gVar) {
                AlaGiftTabView.this.bU(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501075, false));
                if (AlaGiftTabView.this.bZH != null) {
                    AlaGiftTabView.this.bZH.j(gVar);
                }
            }
        });
        this.bdD = (TbImageView) this.bcK.findViewById(a.f.iv_official);
    }

    public void IU() {
        this.bdw = true;
        this.bcX.setVisibility(8);
        this.bcY.setVisibility(8);
        this.bcZ.setVisibility(8);
    }

    public void bM(boolean z) {
        this.bcJ = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.af.a.SE().SJ() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.bcZ.setText(this.mContext.getPageActivity().getString(a.h.first_recharge_text));
            if (!this.bdv.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.bdv.add(str);
            }
        }
    }

    public void bj(boolean z) {
    }

    public void dS(int i) {
        this.bdt = i;
    }

    public void bN(boolean z) {
        this.bdG = z;
        if (z && !ListUtils.isEmpty(this.bcD)) {
            Ja();
            this.bdH = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aa aaVar) {
        if (aaVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "tycoon_pop_show"));
            if (this.bZG == null) {
                this.bZG = new com.baidu.live.yuyingift.container.d(this.mContext);
            }
            this.bZG.o(aaVar.dialogTitle, aaVar.aLJ + aaVar.aLK, aaVar.aLK);
        }
    }

    private void Q(View view) {
        if (this.bZG == null) {
            this.bZG = new com.baidu.live.yuyingift.container.d(this.mContext);
        }
        this.bZG.O(view);
    }

    public void bO(boolean z) {
        this.bdF = z;
    }

    public void ez(int i) {
        this.aMg = i;
    }

    public void bl(boolean z) {
        this.bbt = z;
    }

    public void bP(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.bcP.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height) + this.mContext.getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom);
                this.bcP.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        private int mPosition;

        public d(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaGiftTabView.this.eA(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(int i) {
        if (this.bZE != null) {
            this.bZE.c(false, this.bdz);
        }
        eB(i);
        this.bcP.setCurrentItem(this.bdf);
        Jb();
        IV();
    }

    private void eB(int i) {
        int min = Math.min(i, this.bdn.size());
        int i2 = 0;
        int i3 = 0;
        while (i2 < min) {
            i2++;
            i3 = this.bdn.get(i2) + i3;
        }
        this.bdf = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
            AlaGiftTabView.this.bdg = AlaGiftTabView.this.bdf;
            AlaGiftTabView.this.a((com.baidu.live.yuyingift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void IV() {
        if (this.bZE != null) {
            if (this.bdl != null && this.bdl.aXG) {
                this.bZE.aV(this.bdl.aXH, this.bdl.aXI);
            } else {
                this.bZE.aV(null, null);
            }
        }
    }

    public void a(com.baidu.live.yuyingift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.bZE != null) {
            this.bZE.c(false, this.bdz);
            this.bZE.aaG();
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.er(i);
                aVar.notifyDataSetChanged();
                this.bcV.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                hq("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.bdl.GW()) {
                        this.bZC.setStyle(this.bdl.GF() ? 4 : 3);
                        this.bZA.setStyleEnabled(false);
                        if (this.bZE != null) {
                            this.bZE.f(false, null);
                        }
                        if (!TextUtils.isEmpty(this.bdl.GI()) && this.bdx) {
                            this.mContext.showToast(this.bdl.GI());
                            return;
                        }
                        return;
                    }
                    IV();
                    this.bZC.setEnabled(true);
                    if (this.bdl.Ha()) {
                        if (this.bZE != null) {
                            this.bZE.f(false, null);
                        }
                        if (this.bdl.GV() == 6 && this.bbl < 3) {
                            i3 = 3;
                        } else if (this.bdl.GV() == 7 && this.bbl < 7) {
                            i3 = 7;
                        } else if (this.bdl.GV() == 8 && this.bbl < 13) {
                            i3 = 13;
                        } else if (this.bdl.GV() == 9 && this.bbl < 22) {
                            i3 = 22;
                        } else if (this.bdl.GV() == 10 && this.bbl < 29) {
                            i3 = 29;
                        } else if (this.bdl.GV() == 11 && this.bbl < 39) {
                            i3 = 39;
                        } else if (this.bdl.GV() == 12 && this.bbl < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.bZC.setStyle(this.bdl.GF() ? 2 : 1);
                    } else {
                        this.bZC.setStyle(this.bdl.GF() ? 4 : 3);
                    }
                    this.bZA.setStyleEnabled(z);
                    Jg();
                    i2 = i3;
                } else {
                    this.bZC.setStyle(this.bdl.GF() ? 2 : 1);
                    if (this.bdl.aXF != null && this.bdl.aXF.aXT != null && this.bdl.aXF.aXT.equals("20")) {
                        this.bZC.setText("使用");
                    } else {
                        this.bZC.setText("赠送");
                    }
                    this.bZA.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.bdl.GG()) {
                    bQ(true);
                } else {
                    bQ(false);
                    hq("1");
                }
                d(false, i2);
                return;
            }
            this.bZC.setStyle(3);
            return;
        }
        this.bZC.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.b bVar;
        if (this.bdx && this.bdl != null) {
            if (this.mType == 0) {
                if (this.bdl.GY() && !this.bbt) {
                    this.mContext.showToast(a.h.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.bdl.GI()) && this.bdl.GW() && !z) {
                    this.mContext.showToast(this.bdl.GI());
                } else if (this.bdl.Ha() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.h.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.bdl.GU()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.h.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (bVar = this.bdl.aXF) != null && !TextUtils.isEmpty(bVar.aXW)) {
                this.mContext.showToast(bVar.aXW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.af.a.SE().bCb != null && com.baidu.live.af.a.SE().bCb.aRA != null) {
            String str = com.baidu.live.af.a.SE().bCb.aRA.aQR;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.GV()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IW() {
        if (!this.bdj) {
            this.bdy = new BdAlertDialog(this.mContext.getPageActivity());
            this.bdy.setCancelable(false);
            this.bdy.setCanceledOnTouchOutside(false);
            this.bdy.setTitle(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_title));
            this.bdy.setMessage(String.format(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_content), Integer.valueOf(this.bdt)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.bdy.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.bdy.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.bdy.setPositiveButtonTextColor(-57754);
                this.bdy.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.bdy.setPositiveButton(this.mContext.getPageActivity().getString(a.h.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.bdj = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.bdy.setNegativeButton(this.mContext.getPageActivity().getString(a.h.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.bdj = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.bdy.create(this.mContext).show();
            this.bdj = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQ(boolean z) {
        boolean z2 = z && com.baidu.live.af.a.SE().bwi.aNw;
        if (z2) {
            this.bcL.setVisibility(4);
            this.bZC.setStyle(1);
        } else if (this.bdl != null && this.bdl.GF()) {
            if (this.bZE != null) {
                this.bZE.aaK();
            }
            this.bcL.setVisibility(0);
        } else {
            this.bcL.setVisibility(4);
        }
        if (this.bZE != null) {
            this.bZE.f(z2, this.bdl != null ? this.bdl.getThumbnail_url() : null);
        }
    }

    public void IX() {
        if (this.bZE != null) {
            this.bZE.c(true, this.bdz);
        }
    }

    @Override // com.baidu.live.view.input.c.a
    public void hn(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        hq(str);
    }

    public void hq(String str) {
        this.bcN.setText(str);
        this.bcN.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.d.sdk_fontsize20 : a.d.sdk_fontsize24));
        bR(false);
        if (this.bdl != null && this.bdl.GF()) {
            this.bcL.setVisibility(0);
            this.bdm = JavaTypesHelper.toInt(this.bcN.getText().toString(), 1);
            return;
        }
        this.bcL.setVisibility(4);
        this.bdm = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(boolean z) {
        this.bcN.setGravity(17);
        if (z) {
            this.bcN.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.bcN.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, boolean z2, int i) {
        if (this.bcC == null || this.bcC.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            if (this.bcC == null) {
                this.bcC = new ArrayList<>();
            }
            this.bcC.clear();
            if (arrayList != null) {
                this.bcC.addAll(arrayList);
            }
            this.bcD = arrayList2;
            this.bcE = arrayList3;
            this.bdi = false;
            if (this.bcD == null || this.bcD.isEmpty()) {
                this.bcR.setVisibility(8);
            }
            b(z, z2, i);
        }
    }

    public void D(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.bdb != null) {
            for (View view : this.bdb) {
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
                                ((com.baidu.live.yuyingift.container.a) ((GridView) childAt).getAdapter()).D(str, i);
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
        IY();
        if (this.bcC == null || this.bcC.size() <= 0 || !z2) {
            rh();
            if (this.bcQ != null) {
                this.bcQ.setVisibility(4);
            }
            this.bcV.setVisibility(4);
            this.bcU.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                this.bcU.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.bcU.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_no);
                this.bcU.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.af.a.SE().bwi.aPd && i != 0) {
                string = string + "(" + i + ")";
            }
            this.bcU.setTitle(string);
            this.bcU.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.bZD != null) {
                        AlaGiftTabView.this.bZD.Jh();
                    }
                }
            });
            this.bcU.setVisibility(0);
            return;
        }
        this.bcU.setVisibility(8);
        if (z) {
            m(this.bcD);
        }
        bq bqVar = com.baidu.live.af.a.SE().bCb;
        if (this.mType == 0 && bqVar != null && bqVar.aRE != null && bqVar.aRE.aUi && !this.bdF && this.bcC.get(0) != null && this.bcC.get(0).Hb() != null) {
            List<g> Hb = this.bcC.get(0).Hb();
            if (Hb.size() <= 1 || Hb.get(1) == null) {
                z3 = true;
            } else {
                z3 = !Hb.get(1).isRed();
            }
            if (!Hb.isEmpty() && z3) {
                g gVar = new g();
                gVar.bz(true);
                gVar.aXO = 100;
                gVar.setGiftName("发红包");
                Hb.add(1, gVar);
            }
        }
        c(this.bcC, z);
        hq("1");
    }

    private void rh() {
        this.bdf = 0;
        this.bdg = 0;
        this.mSelectedPosition = 0;
        this.bdh = 0;
        if (this.bdn != null) {
            this.bdn.clear();
        }
        if (this.bdb != null) {
            this.bdb.clear();
        }
        if (this.bcP != null) {
            this.bcP.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.Ha()) {
            if (gVar.GV() == 6 && this.bbl < 3) {
                return false;
            }
            if (gVar.GV() == 7 && this.bbl < 7) {
                return false;
            }
            if (gVar.GV() == 8 && this.bbl < 13) {
                return false;
            }
            if (gVar.GV() == 9 && this.bbl < 22) {
                return false;
            }
            if (gVar.GV() == 10 && this.bbl < 29) {
                return false;
            }
            if (gVar.GV() == 11 && this.bbl < 39) {
                return false;
            }
            if (gVar.GV() == 12 && this.bbl < 47) {
                return false;
            }
        }
        if (gVar.GY()) {
            return this.bbt;
        }
        return true;
    }

    public void b(final aa aaVar) {
        if (aaVar == null || TextUtils.isEmpty(aaVar.iconUrl)) {
            this.bdD.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "tycoon_show"));
            this.bdD.setVisibility(0);
            this.bdD.startLoad(aaVar.iconUrl, 10, false);
            this.bdD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "tycoon_clk"));
                    AlaGiftTabView.this.a(aaVar);
                }
            });
            String str = "key_live_official_tip_yuyin" + currentAccount;
            if (com.baidu.live.d.Ba().getInt(str, 0) == 0 && this.bdG) {
                Q(this.bdD);
                com.baidu.live.d.Ba().putInt(str, 1);
            }
        }
    }

    private void IY() {
        if (ListUtils.getCount(this.bcD) != 0 && ListUtils.getCount(this.bcC) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<i> it = this.bcD.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.Ey()) == 0))) {
                    arrayList.add(next);
                    Iterator<h> it2 = this.bcC.iterator();
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
                Iterator<h> it3 = this.bcC.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().Hb().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.GG()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.bcD.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.bcC.removeAll(arrayList2);
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
        List<g> Hb;
        if (arrayList != null) {
            this.bdn.clear();
            this.bdb.clear();
            this.bcP.setAdapter(null);
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
                    if (hVar == null || (Hb = hVar.Hb()) == null || Hb.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.bdd.clear();
            ar(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.bdb.add(eD(i7));
                    this.bdn.append(i7, 1);
                } else {
                    h hVar2 = arrayList.get(i7);
                    hVar2.getCategoryId();
                    List<g> Hb2 = hVar2.Hb();
                    if (Hb2 == null) {
                        i = 0;
                    } else {
                        i = Hb2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.bdo.get(i7)) {
                            this.bdb.add(bS(true));
                        } else {
                            this.bdb.add(b(arrayList3, -1, i7));
                        }
                    } else if (Hb2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(Hb2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(Hb2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(Hb2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.bdd.add(arrayList2);
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
                                    if (gVar == null || gVar.Gx() == null || !gVar.Gx().equals(String.valueOf(this.bds))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.bdb.add(b(arrayList2, i3, i7));
                                this.bZC.removeCallbacks(null);
                                this.bZC.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.17
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.bdl != null) {
                                            boolean GG = AlaGiftTabView.this.bdl.GG();
                                            AlaGiftTabView.this.bQ(GG);
                                            if (!GG) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.bdl);
                                                if (!c2) {
                                                    AlaGiftTabView.this.bZC.setStyle(AlaGiftTabView.this.bdl.GF() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.bZC.setStyle(AlaGiftTabView.this.bdl.GF() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.bZA.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.Gx().equals(String.valueOf(this.bds))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.bdb.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.bdb.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.bdn.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.bcP.setAdapter(new AlaGiftPagerAdapter(this.bdb));
            IZ();
            this.bcP.setCurrentItem(this.bdf);
            Jb();
            if (z && !this.bdH && this.bdG) {
                this.bdH = true;
                Ja();
            }
        }
    }

    private void IZ() {
        int i = 0;
        if (this.bds > 0 && !ListUtils.isEmpty(this.bdd)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.bdd.size() && !z; i2++) {
                Iterator<g> it = this.bdd.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.Gx() != null && next.Gx().equals(String.valueOf(this.bds))) {
                        this.bdf = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aMg == 111 && !z && this.bdx) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_not_find_gift_toast);
            }
            this.bdg = this.bdf;
            this.bdd.clear();
        } else if (this.bdr > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.bcD.size()) {
                    break;
                }
                i iVar = this.bcD.get(i3);
                if (iVar == null || this.bdr != iVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    eB(i3);
                    break;
                }
            }
            this.bdg = this.bdf;
        }
    }

    private void ar(List<h> list) {
        if (list != null && this.bdr > 0 && this.bds <= 0) {
            for (h hVar : list) {
                if (hVar.getCategoryId() == this.bdr) {
                    List<g> Hb = hVar.Hb();
                    if (Hb != null && !Hb.isEmpty() && Hb.get(0) != null) {
                        this.bds = Integer.valueOf(Hb.get(0).Gx()).intValue();
                        return;
                    }
                    return;
                }
            }
        }
    }

    private View bS(boolean z) {
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
                if (AlaGiftTabView.this.bZD != null) {
                    AlaGiftTabView.this.bZD.Jh();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.yuyingift.container.a aVar = new com.baidu.live.yuyingift.container.a(this.mContext, this.mType);
        aVar.bE(this.bbn);
        aVar.setGiftItems(list);
        aVar.eq(this.bbl);
        aVar.bl(this.bbt);
        aVar.er(i);
        if (this.isLandscape) {
            if (this.bcP.getHeight() > 0) {
                aVar.es(this.bcP.getHeight() / 3);
            } else {
                this.bcP.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.es(AlaGiftTabView.this.bcP.getHeight() / 3);
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
                if (tag instanceof a.C0244a) {
                    ((a.C0244a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout eD(int i) {
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
    private void m(ArrayList<i> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.bdq) {
                this.bcR.setVisibility(0);
            }
            this.bcS.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                i iVar = arrayList.get(i);
                if (!TextUtils.isEmpty(iVar.getCategoryName()) && (this.mType != 0 || (iVar.Ey() != null && iVar.Ey().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.f.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(iVar.getCategoryName());
                    viewGroup.setOnClickListener(new d(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.bdk;
                    }
                    if (this.bcC.size() > i && this.bcC.get(i) != null) {
                        for (g gVar : this.bcC.get(i).Hb()) {
                            if (gVar != null && gVar.GD() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.bcS.addView(viewGroup, layoutParams);
                }
            }
            eE(this.bdh);
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
    private void eE(int i) {
        int i2;
        JSONArray jSONArray;
        List<g> Hb;
        int childCount = this.bcS.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.bdh != i || !this.bdi) && this.bcD.size() > i && this.bcD.get(i) != null) {
                int min = Math.min(i, this.bdn.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.bdn.get(i4);
                }
                if (this.bdb.size() > i3 && this.bcC.size() > i && (this.bdb.get(i3) instanceof ViewGroup)) {
                    this.bdg = i3;
                    h hVar = this.bcC.get(i);
                    if (hVar != null && hVar.Hb() != null && !hVar.Hb().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.bdb.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.yuyingift.container.a aVar = (com.baidu.live.yuyingift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.bdi) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.bdf) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.bdx) {
                                        this.bdi = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.bcD.size() > i && this.bcD.get(i) != null) {
                int categoryId = this.bcD.get(i).getCategoryId();
                if (!this.bdu.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.bdu.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.bcS.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.f.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.f.icon_new_unlock_gift);
                imageView.setVisibility(8);
                h hVar2 = this.bcC.get(i6);
                if (hVar2.Hc()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.bcI, "");
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
                                    Hb = hVar2.Hb();
                                    if (Hb != null) {
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
                    Hb = hVar2.Hb();
                    if (Hb != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= Hb.size()) {
                                break;
                            }
                            g gVar = Hb.get(i9);
                            if (!gVar.GW() && !hashSet.contains(gVar.Gx())) {
                                arrayList.add(gVar.Gx());
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
                                SharedPrefHelper.getInstance().putString(this.bcI, jSONArray.toString());
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
                    if (this.bdB != 0) {
                        gradientTextView.setGradientTextColor(this.bdB, this.bdB);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    eF(i);
                    this.bdh = i;
                    this.bcR.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bT(false);
                        } else {
                            bT(true);
                        }
                    } else {
                        bT(true);
                    }
                }
            }
        }
    }

    private void bT(boolean z) {
        int i = 8;
        if (this.bcX != null) {
            this.bcX.setVisibility(z ? this.bdw ? 8 : 0 : 8);
        }
        if (this.bcY != null) {
            TextView textView = this.bcY;
            if (!z && !this.bdw) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void eF(int i) {
        int childCount = this.bcS.getChildCount();
        if (i >= 0 && i < childCount && this.bcC != null && this.bcC.size() > i && this.bcC.get(i) != null) {
            this.bdo.get(i);
        }
    }

    public void A(int i, int i2) {
        this.bdr = i;
        this.bds = i2;
    }

    public void aN(long j) {
        if (this.bcX != null) {
            if (j >= 100 && (this.bbn || com.baidu.live.af.a.SE().bwi.aOu)) {
                this.bcX.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.bcX.setText(String.valueOf(j));
        }
    }

    public void aO(long j) {
        if (this.bcY != null) {
            this.bcY.setText(String.valueOf(j));
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
        this.bdf = i;
        Jb();
        IV();
        if (i >= 0 && i < this.bdb.size() && (this.bdb.get(i) instanceof ViewGroup)) {
            Ja();
            ViewGroup viewGroup = (ViewGroup) this.bdb.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.yuyingift.container.a aVar = (com.baidu.live.yuyingift.container.a) gridView.getAdapter();
                        if (aVar.IA() >= 0 && i != this.bdg) {
                            aVar.er(-1);
                        }
                        if (aVar.IA() < 0 && i == this.bdg) {
                            aVar.er(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.bcV.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void Ja() {
        i iVar = (i) ListUtils.getItem(this.bcD, this.bdh);
        if (this.bZE != null && iVar != null) {
            this.bZE.aW(String.valueOf(iVar.getCategoryId()), iVar.getCategoryName());
        }
    }

    private void Jb() {
        int i = 0;
        for (int i2 = 0; i2 < this.bdn.size(); i2++) {
            for (int i3 = 0; i3 < this.bdn.get(i2); i3++) {
                if (i + i3 == this.bdf) {
                    if (this.bdn.get(i2) <= 1) {
                        this.bcQ.setVisibility(4);
                    } else {
                        this.bcQ.setVisibility(0);
                    }
                    this.bcQ.setCount(this.bdn.get(i2));
                    this.bcQ.onPageSelected(i3);
                    eE(i2);
                    return;
                }
            }
            i += this.bdn.get(i2);
        }
    }

    public g Jc() {
        return this.bdl;
    }

    public int Jd() {
        return this.bdm;
    }

    public void a(e eVar) {
        this.bZD = eVar;
    }

    public void eG(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.bdm = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bdM);
        MessageManager.getInstance().registerListener(this.bdN);
        MessageManager.getInstance().registerListener(this.bdO);
        MessageManager.getInstance().registerListener(this.bdP);
    }

    public void Je() {
        if (!ListUtils.isEmpty(this.bdb)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bdb) {
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
        if (!ListUtils.isEmpty(this.bdb) && !TextUtils.isEmpty(str)) {
            new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bdb) {
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
    public void Jf() {
        if (!ListUtils.isEmpty(this.bdb)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.10
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bdb) {
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
                                        ((com.baidu.live.yuyingift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.bbt);
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
    public void Jg() {
        if (this.bdl != null && this.bdl.GY()) {
            this.bZA.setStyleEnabled(this.bbt);
            if (this.bbt) {
                this.bZC.setStyle(this.bdl.GF() ? 2 : 1);
            } else {
                this.bZC.setStyle(this.bdl.GF() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.bZE = null;
        MessageManager.getInstance().unRegisterListener(this.bdM);
        MessageManager.getInstance().unRegisterListener(this.bdN);
        MessageManager.getInstance().unRegisterListener(this.bdO);
        MessageManager.getInstance().unRegisterListener(this.bdP);
        rh();
        if (this.bdy != null) {
            this.bdy.dismiss();
        }
    }

    public void bE(boolean z) {
        this.bbn = z;
    }

    public void eH(int i) {
        this.bbl = i;
    }

    public void d(g gVar) {
        com.baidu.live.gift.c hA;
        if (this.bZF != null) {
            this.bZF.Ix();
        }
        this.bdl = gVar;
        this.bds = Integer.valueOf(this.bdl.Gx()).intValue();
        if (this.bZE != null) {
            this.bZE.a(gVar);
        }
        if (BdNetTypeUtil.isNetWorkAvailable() && this.bdl.GK() && !com.baidu.live.yuyingift.b.b.aaZ().gV(this.bdl.Gx()) && (hA = com.baidu.live.yuyingift.b.b.aaZ().hA(this.bdl.Gx())) != null) {
            am.Ih().a(hA.aXb, true);
        }
    }

    public void aaR() {
        if (this.bZF != null && this.bZF.Iy()) {
            this.bZF.Ix();
        }
    }

    public void Iw() {
        if (this.bZF != null) {
            this.bZF.i(Jc());
        }
    }

    public void Iv() {
        if (this.bZF != null) {
            this.bZF.h(Jc());
        }
    }

    public void bU(boolean z) {
        if (this.bZC != null) {
            this.bZC.setVisibility(z ? 0 : 4);
        }
        if (this.bcL != null) {
            this.bcL.setVisibility(z ? 0 : 4);
        }
    }
}

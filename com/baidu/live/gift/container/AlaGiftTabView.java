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
/* loaded from: classes11.dex */
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, c.a {
    private int aJY;
    private int aZD;
    private boolean aZF;
    private boolean aZL;
    public ArrayList<h> baV;
    public ArrayList<i> baW;
    public ArrayList<l> baX;
    private int bbA;
    private boolean bbB;
    private boolean bbC;
    private int bbD;
    private g bbE;
    private int bbF;
    private SparseIntArray bbG;
    private SparseBooleanArray bbH;
    private View.OnClickListener bbI;
    private boolean bbJ;
    private int bbK;
    private int bbL;
    private int bbM;
    private SparseBooleanArray bbN;
    private Set<String> bbO;
    private boolean bbP;
    private boolean bbQ;
    private BdAlertDialog bbR;
    private int bbS;
    private a bbT;
    private int bbU;
    private AlaComboBtnAnimView bbV;
    private TbImageView bbW;
    private com.baidu.live.gift.container.d bbX;
    private boolean bbY;
    private boolean bbZ;
    private final String bbb;
    private boolean bbc;
    private ViewGroup bbd;
    private View bbe;
    private GiftPanelNumRoundRectView bbf;
    public TextView bbg;
    private ImageView bbh;
    private BaseViewPager bbi;
    private RoundRectPageIndicator bbj;
    private HorizontalScrollView bbk;
    private LinearLayout bbl;
    private FrameLayout bbm;
    private CommonEmptyView bbn;
    private View bbo;
    private com.baidu.live.gift.container.c bbp;
    private TextView bbq;
    private TextView bbr;
    private TextView bbs;
    public GiftPanelOperationSendView bbt;
    private List<View> bbu;
    ArrayList<l> bbv;
    private ArrayList<List<g>> bbw;
    private e bbx;
    private int bby;
    private int bbz;
    private boolean bca;
    private AnimatorSet bcb;
    private int bcd;
    private View.OnClickListener bce;
    AdapterView.OnItemClickListener bcf;
    private CustomMessageListener bcg;
    private CustomMessageListener bch;
    private CustomMessageListener bci;
    private CustomMessageListener bcj;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private int mSelectedPosition;
    private int mType;
    private String otherParams;
    private String roomId;
    public static int page = 0;
    public static ArrayList<String> bcc = new ArrayList<>();

    /* loaded from: classes11.dex */
    public interface a {
        void FZ();

        void a(g gVar);

        void c(boolean z, int i);

        void cU(int i);

        void g(String str, String str2, boolean z);

        void j(boolean z, String str);

        void u(int i, String str);
    }

    /* loaded from: classes11.dex */
    public interface e {
        void GC();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.bbb = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.bbu = new ArrayList();
        this.bbv = new ArrayList<>();
        this.bby = 0;
        this.bbz = 0;
        this.mSelectedPosition = 0;
        this.bbA = 0;
        this.bbG = new SparseIntArray();
        this.bbH = new SparseBooleanArray();
        this.isLandscape = false;
        this.bbJ = false;
        this.bbK = -1;
        this.bbL = -1;
        this.aZF = false;
        this.aZD = -1;
        this.bbN = new SparseBooleanArray();
        this.bbO = new HashSet();
        this.bbY = false;
        this.aZL = false;
        this.bbZ = false;
        this.bca = false;
        this.bce = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabView.this.bbv.clear();
                if (AlaGiftTabView.this.bbV == null || !AlaGiftTabView.this.bbV.FT()) {
                    if (AlaGiftTabView.this.bbp == null) {
                        AlaGiftTabView.this.bbp = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.mType, AlaGiftTabView.this.bcf);
                    }
                    AlaGiftTabView.this.bS(true);
                    if (AlaGiftTabView.this.bbE.DY() == 10) {
                        Iterator<l> it = AlaGiftTabView.this.baX.iterator();
                        while (it.hasNext()) {
                            l next = it.next();
                            if (next.number <= AlaGiftTabView.this.bbE.aWc) {
                                AlaGiftTabView.this.bbv.add(next);
                            }
                        }
                    } else {
                        Iterator<l> it2 = AlaGiftTabView.this.baX.iterator();
                        while (it2.hasNext()) {
                            AlaGiftTabView.this.bbv.add(it2.next());
                        }
                    }
                    AlaGiftTabView.this.bbp.a(AlaGiftTabView.this.bbe, AlaGiftTabView.this.bbv, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bS(false);
                        }
                    });
                }
            }
        };
        this.bcf = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.bbp.dismiss();
                if (AlaGiftTabView.this.bbv == null || AlaGiftTabView.this.bbv.size() <= 0) {
                    AlaGiftTabView.this.gC("1");
                } else if (i == AlaGiftTabView.this.bbv.size()) {
                    AlaGiftTabView.this.Gs();
                } else {
                    l lVar = AlaGiftTabView.this.bbv.get(i);
                    if (lVar != null) {
                        int number = lVar.getNumber();
                        if (AlaGiftTabView.this.mType == 1 && (bVar = AlaGiftTabView.this.bbE.aVX) != null) {
                            if (number == -1) {
                                number = bVar.aWm;
                            }
                            if (number > AlaGiftTabView.this.bbS) {
                                number = AlaGiftTabView.this.bbS;
                            }
                        }
                        AlaGiftTabView.this.gC(String.valueOf(number));
                    }
                }
            }
        };
        this.bcg = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.h.c)) {
                    com.baidu.live.h.c cVar = (com.baidu.live.h.c) customResponsedMessage.getData();
                    if ((cVar.aUb == 1 || cVar.aUb == 2 || cVar.aUb == 5 || cVar.aUb == 6) && cVar.aUc != null) {
                        AlaGiftTabView.this.av(cVar.aUc.getId(), cVar.aUc.getUrl());
                    }
                }
            }
        };
        this.bch = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bN(true);
                if (AlaGiftTabView.this.bbE != null && AlaGiftTabView.this.b(AlaGiftTabView.this.bbE) && AlaGiftTabView.this.bbc) {
                    AlaGiftTabView.this.bbt.setStyle(AlaGiftTabView.this.bbE.Ea() ? 2 : 1);
                    AlaGiftTabView.this.bbf.setStyleEnabled(true);
                }
            }
        };
        this.bci = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ab abVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ab) && (abVar = (ab) customResponsedMessage.getData()) != null && abVar.aIz != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = abVar.aIz.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aZL != z2) {
                        AlaGiftTabView.this.aZL = z2;
                        AlaGiftTabView.this.GB();
                        AlaGiftTabView.this.GA();
                    }
                }
            }
        };
        this.bcj = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.Gr();
                    AlaGiftTabView.this.bbt.setStyle(AlaGiftTabView.this.bbE.Ea() ? 4 : 3);
                    AlaGiftTabView.this.bbf.setStyleEnabled(false);
                    if (AlaGiftTabView.this.bbT != null) {
                        AlaGiftTabView.this.bbT.j(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.bbI = onClickListener;
        this.bbJ = z;
        this.bbd = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.bbD = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.d.sdk_ds36);
        this.bbw = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.bbS = AlaRecorderLog.ErrorCode.ERROR_RECORDER_NOT_DEFINE_ERROR;
                this.bbh.setVisibility(8);
                return;
            case 1:
                this.bbS = 999;
                this.bbh.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public void cX(int i) {
        int childCount;
        this.bbU = i;
        if (this.bbl != null && (childCount = this.bbl.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.bbA) {
                    ((GradientTextView) ((ViewGroup) this.bbl.getChildAt(i2)).findViewById(a.f.text_view)).setGradientTextColor(this.bbU, this.bbU);
                }
            }
        }
    }

    public void a(a aVar) {
        this.bbT = aVar;
    }

    public void au(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bM(boolean z) {
        this.bbQ = z;
    }

    public void onVisibilityChanged(boolean z) {
        bM(z);
    }

    public View getRootView() {
        return this.bbd;
    }

    private void initViews() {
        this.bbe = this.bbd.findViewById(a.f.gift_count_layout);
        this.bbe.setOnClickListener(this.bce);
        this.bbf = (GiftPanelNumRoundRectView) this.bbd.findViewById(a.f.gift_count_round);
        this.bbg = (TextView) this.bbd.findViewById(a.f.gift_count_input);
        this.bbg.setText("1");
        this.bbg.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.bbh = (ImageView) this.bbd.findViewById(a.f.gift_tab_back);
        this.bbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.bbT != null) {
                    AlaGiftTabView.this.bbT.FZ();
                }
            }
        });
        this.bbi = (BaseViewPager) this.bbd.findViewById(a.f.gift_viewpager);
        this.bbi.setOnPageChangeListener(this);
        this.bbj = (RoundRectPageIndicator) this.bbd.findViewById(a.f.gift_tab_indicator);
        this.bbl = (LinearLayout) this.bbd.findViewById(a.f.gift_tab_layout);
        this.bbk = (HorizontalScrollView) this.bbd.findViewById(a.f.gift_tab_scrollview);
        if (this.bbJ) {
            this.bbk.setVisibility(8);
        }
        this.bbq = (TextView) this.bbd.findViewById(a.f.current_money);
        this.bbq.setOnClickListener(this.bbI);
        this.bbr = (TextView) this.bbd.findViewById(a.f.current_flower);
        this.bbr.setOnClickListener(this.bbI);
        this.bbt = (GiftPanelOperationSendView) this.bbd.findViewById(a.f.donate);
        this.bbs = (TextView) this.bbd.findViewById(a.f.current_recharge);
        this.bbs.setOnClickListener(this.bbI);
        this.bbt.setOnClickListener(this.bbI);
        this.bbm = (FrameLayout) this.bbd.findViewById(a.f.layout_error);
        this.bbm.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.bbn = new CommonEmptyView(this.mContext.getPageActivity());
        this.bbn.setVisibility(8);
        this.bbn.addToParent(this.bbm);
        this.bbo = this.bbd.findViewById(a.f.donate_layout);
        this.bbV = (AlaComboBtnAnimView) this.bbd.findViewById(a.f.combo_layout);
        this.bbV.setComboClickListener(this.bbI);
        this.bbV.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void FU() {
                AlaGiftTabView.this.bV(true);
            }
        });
        this.bbW = (TbImageView) this.bbd.findViewById(a.f.iv_official);
    }

    public void Gp() {
        this.bbP = true;
        this.bbq.setVisibility(8);
        this.bbr.setVisibility(8);
        this.bbs.setVisibility(8);
    }

    public void bN(boolean z) {
        this.bbc = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.ae.a.Qj().Qo() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.bbs.setText(this.mContext.getPageActivity().getString(a.h.first_recharge_text));
            if (!this.bbO.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.bbO.add(str);
            }
        }
    }

    public void bh(boolean z) {
    }

    public void cp(int i) {
        this.bbM = i;
    }

    public void bO(boolean z) {
        this.bbQ = z;
        this.bbZ = z;
        if (z) {
            Gq();
        }
        if (!z && this.bcb != null) {
            this.bcb.cancel();
        }
        if (z && !ListUtils.isEmpty(this.baW)) {
            Gv();
            this.bca = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ae aeVar) {
        if (aeVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_pop_show"));
            if (this.bbX == null) {
                this.bbX = new com.baidu.live.gift.container.d(this.mContext);
            }
            this.bbX.n(aeVar.dialogTitle, aeVar.aJA + aeVar.aJB, aeVar.aJB);
        }
    }

    private void Q(View view) {
        if (this.bbX == null) {
            this.bbX = new com.baidu.live.gift.container.d(this.mContext);
        }
        this.bbX.O(view);
    }

    public void bP(boolean z) {
        this.bbY = z;
    }

    public void cY(int i) {
        this.aJY = i;
    }

    public void bj(boolean z) {
        this.aZL = z;
    }

    public void bQ(boolean z) {
        if (z) {
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24);
            ViewGroup.LayoutParams layoutParams = this.bbi.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
                this.bbi.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.bbm.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelOffset;
                this.bbm.setLayoutParams(layoutParams2);
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
            AlaGiftTabView.this.cZ(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(int i) {
        if (this.bbT != null) {
            this.bbT.c(false, this.bbS);
        }
        da(i);
        this.bbi.setCurrentItem(this.bby);
        Gw();
        Gq();
    }

    private void da(int i) {
        int min = Math.min(i, this.bbG.size());
        int i2 = 0;
        int i3 = 0;
        while (i2 < min) {
            i2++;
            i3 = this.bbG.get(i2) + i3;
        }
        this.bby = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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
            AlaGiftTabView.this.bbz = AlaGiftTabView.this.bby;
            AlaGiftTabView.this.a((com.baidu.live.gift.container.a) adapterView.getAdapter(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        private c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            g item = ((com.baidu.live.gift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.aWb != null && item.aWb.enabled && !TextUtils.isEmpty(item.aWb.detailUrl) && AlaGiftTabView.this.bbT != null) {
                AlaGiftTabView.this.bbT.u(item.aWb.aWj, item.aWb.detailUrl);
            }
            return false;
        }
    }

    private void Gq() {
        if (this.bbQ && this.bbT != null) {
            if (this.bbE != null && this.bbE.aVY) {
                this.bbT.g(this.bbE.aVZ, this.bbE.aWa, false);
            } else {
                this.bbT.g(null, null, false);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.bbT != null) {
            this.bbT.c(false, this.bbS);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.cQ(i);
                aVar.notifyDataSetChanged();
                this.bbo.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                gC("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.bbE.Er()) {
                        this.bbt.setStyle(this.bbE.Ea() ? 4 : 3);
                        this.bbf.setStyleEnabled(false);
                        if (this.bbT != null) {
                            this.bbT.j(false, null);
                        }
                        if (!TextUtils.isEmpty(this.bbE.Ed()) && this.bbQ) {
                            this.mContext.showToast(this.bbE.Ed());
                            return;
                        }
                        return;
                    }
                    this.bbt.setEnabled(true);
                    if (this.bbE.Ev()) {
                        if (this.bbT != null) {
                            this.bbT.j(false, null);
                        }
                        if (this.bbE.Eq() == 6 && this.aZD < 3) {
                            i3 = 3;
                        } else if (this.bbE.Eq() == 7 && this.aZD < 7) {
                            i3 = 7;
                        } else if (this.bbE.Eq() == 8 && this.aZD < 13) {
                            i3 = 13;
                        } else if (this.bbE.Eq() == 9 && this.aZD < 22) {
                            i3 = 22;
                        } else if (this.bbE.Eq() == 10 && this.aZD < 29) {
                            i3 = 29;
                        } else if (this.bbE.Eq() == 11 && this.aZD < 39) {
                            i3 = 39;
                        } else if (this.bbE.Eq() == 12 && this.aZD < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.bbt.setStyle(this.bbE.Ea() ? 2 : 1);
                    } else {
                        this.bbt.setStyle(this.bbE.Ea() ? 4 : 3);
                    }
                    this.bbf.setStyleEnabled(z);
                    GB();
                    i2 = i3;
                } else {
                    this.bbt.setStyle(this.bbE.Ea() ? 2 : 1);
                    if ((this.bbE instanceof aa) && ((aa) this.bbE).Fk()) {
                        this.bbt.setText("查看详情");
                    } else if (this.bbE.aVX != null && this.bbE.aVX.aWl != null && this.bbE.aVX.aWl.equals("20")) {
                        if (this.bbE.aVX.aWp != null && this.bbE.aVX.aWp.key == 11) {
                            this.bbt.setText("激活");
                        } else if (this.bbE.aVX.aWp != null && this.bbE.aVX.aWp.key == 12) {
                            this.bbt.setText("立即激活");
                        } else {
                            this.bbt.setText("使用");
                        }
                    } else {
                        this.bbt.setText("赠送");
                    }
                    this.bbf.setStyleEnabled(true);
                    i2 = -1;
                }
                Gq();
                if (this.bbE.Eb()) {
                    bR(true);
                } else {
                    bR(false);
                    gC("1");
                }
                d(false, i2);
                return;
            }
            this.bbt.setStyle(3);
            return;
        }
        this.bbt.setStyle(3);
    }

    private void d(boolean z, int i) {
        if (this.bbQ && this.bbE != null) {
            if (this.mType == 0) {
                if (this.bbE.Et() && !this.aZL) {
                    this.mContext.showToast(a.h.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.bbE.Ed()) && this.bbE.Er() && !z) {
                    this.mContext.showToast(this.bbE.Ed());
                } else if (this.bbE.Ev() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.h.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.bbE.Ep()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.h.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1) {
                g.b bVar = this.bbE.aVX;
                if (bVar != null && !TextUtils.isEmpty(bVar.aWo)) {
                    this.mContext.showToast(bVar.aWo);
                } else if (!TextUtils.isEmpty(this.bbE.Ed())) {
                    BdUtilHelper.showToast(this.mContext.getPageActivity(), this.bbE.Ed());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.ae.a.Qj().bAS != null && com.baidu.live.ae.a.Qj().bAS.aPL != null) {
            String str = com.baidu.live.ae.a.Qj().bAS.aPL.aPc;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Eq()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gr() {
        if (!this.bbC) {
            this.bbR = new BdAlertDialog(this.mContext.getPageActivity());
            this.bbR.setCancelable(false);
            this.bbR.setCanceledOnTouchOutside(false);
            this.bbR.setTitle(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_title));
            this.bbR.setMessage(String.format(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_content), Integer.valueOf(this.bbM)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.bbR.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.bbR.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.bbR.setPositiveButtonTextColor(-57754);
                this.bbR.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.bbR.setPositiveButton(this.mContext.getPageActivity().getString(a.h.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.bbC = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.bbR.setNegativeButton(this.mContext.getPageActivity().getString(a.h.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.22
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.bbC = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.bbR.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.23
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    AlaGiftTabView.this.bbt.setStyle(AlaGiftTabView.this.bbE.Ea() ? 2 : 1);
                    AlaGiftTabView.this.bbf.setStyleEnabled(true);
                }
            });
            this.bbR.create(this.mContext).show();
            this.bbC = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.ae.a.Qj().buX.aLt;
        if (z2) {
            this.bbe.setVisibility(4);
            this.bbt.setStyle(1);
        } else {
            View view = this.bbe;
            if (this.bbE == null || !this.bbE.Ea()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.bbT != null) {
            this.bbT.j(z2, this.bbE != null ? this.bbE.getThumbnail_url() : null);
        }
    }

    public void Gs() {
        if (this.bbT != null && this.bbE != null) {
            if (this.bbE.DY() == 10) {
                this.bbT.c(true, this.bbE.aWc);
            } else {
                this.bbT.c(true, this.bbS);
            }
        }
    }

    @Override // com.baidu.live.view.input.c.a
    public void gz(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        gC(str);
    }

    public void gC(String str) {
        this.bbg.setText(str);
        this.bbg.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.d.sdk_fontsize20 : a.d.sdk_fontsize24));
        bS(false);
        if (this.bbE != null && this.bbE.Ea()) {
            this.bbe.setVisibility(0);
            this.bbF = JavaTypesHelper.toInt(this.bbg.getText().toString(), 1);
            return;
        }
        this.bbe.setVisibility(4);
        this.bbF = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(boolean z) {
        this.bbg.setGravity(17);
        if (z) {
            this.bbg.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.bbg.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<l> arrayList3, boolean z2, int i) {
        if (this.mType != 0 || this.baV == null || this.baV.isEmpty()) {
            rf();
            if (this.baV == null) {
                this.baV = new ArrayList<>();
            }
            this.baV.clear();
            if (arrayList != null) {
                this.baV.addAll(arrayList);
            }
            this.baW = arrayList2;
            this.baX = arrayList3;
            this.bbB = false;
            if (this.baW == null || this.baW.isEmpty()) {
                this.bbk.setVisibility(8);
            }
            b(z, z2, i);
            onPageSelected(this.bbi.getCurrentItem());
        }
    }

    public void E(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.bbu != null) {
            for (View view : this.bbu) {
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
        Gt();
        if (this.baV == null || this.baV.size() <= 0 || !z2) {
            rf();
            if (this.bbj != null) {
                this.bbj.setVisibility(4);
            }
            if (this.bbT != null) {
                this.bbT.g("", "", false);
            }
            this.bbo.setVisibility(4);
            this.bbn.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                this.bbn.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.bbn.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_no);
                this.bbn.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.ae.a.Qj().buX.aNd && i != 0) {
                string = string + "(" + i + ")";
            }
            this.bbn.setTitle(string);
            this.bbn.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.bbx != null) {
                        AlaGiftTabView.this.bbx.GC();
                    }
                }
            });
            this.bbn.setVisibility(0);
            return;
        }
        this.bbn.setVisibility(8);
        if (z) {
            h(this.baW);
        }
        bv bvVar = com.baidu.live.ae.a.Qj().bAS;
        if (this.mType == 0 && bvVar != null && bvVar.aPP != null && bvVar.aPP.aSx && !this.bbY && this.baV.get(0) != null && this.baV.get(0).Ew() != null) {
            List<g> Ew = this.baV.get(0).Ew();
            if (Ew.size() <= 1 || Ew.get(1) == null) {
                z3 = true;
            } else {
                z3 = !Ew.get(1).isRed();
            }
            if (!Ew.isEmpty() && z3) {
                g gVar = new g();
                gVar.bA(true);
                gVar.setGiftName("发红包");
                Ew.add(1, gVar);
            }
        }
        c(this.baV, z);
        gC("1");
    }

    public void db(int i) {
        A(-1, i);
        Gu();
        if (this.bbi != null) {
            this.bbi.setCurrentItem(this.bby);
        }
    }

    private void rf() {
        this.bby = 0;
        this.bbz = 0;
        this.mSelectedPosition = 0;
        this.bbA = 0;
        if (this.bbG != null) {
            this.bbG.clear();
        }
        if (this.bbu != null) {
            this.bbu.clear();
        }
        if (this.bbi != null) {
            this.bbi.setAdapter(null);
        }
        if (this.bbV != null) {
            this.bbV.FS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.Ev()) {
            if (gVar.Eq() == 6 && this.aZD < 3) {
                return false;
            }
            if (gVar.Eq() == 7 && this.aZD < 7) {
                return false;
            }
            if (gVar.Eq() == 8 && this.aZD < 13) {
                return false;
            }
            if (gVar.Eq() == 9 && this.aZD < 22) {
                return false;
            }
            if (gVar.Eq() == 10 && this.aZD < 29) {
                return false;
            }
            if (gVar.Eq() == 11 && this.aZD < 39) {
                return false;
            }
            if (gVar.Eq() == 12 && this.aZD < 47) {
                return false;
            }
        }
        if (gVar.Et()) {
            return this.aZL;
        }
        return true;
    }

    public void b(final ae aeVar) {
        if (aeVar == null || TextUtils.isEmpty(aeVar.iconUrl)) {
            this.bbW.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_show"));
            this.bbW.setVisibility(0);
            this.bbW.startLoad(aeVar.iconUrl, 10, false);
            this.bbW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_clk"));
                    AlaGiftTabView.this.a(aeVar);
                }
            });
            String str = "key_live_official_tip" + currentAccount;
            if (com.baidu.live.d.xc().getInt(str, 0) == 0 && this.bbZ) {
                Q(this.bbW);
                com.baidu.live.d.xc().putInt(str, 1);
            }
        }
    }

    private void Gt() {
        if (ListUtils.getCount(this.baW) != 0 && ListUtils.getCount(this.baV) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<i> it = this.baW.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.Bn()) == 0))) {
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
                    ListIterator<g> listIterator = it3.next().Ew().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.Eb()) {
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
        int i3;
        boolean z4;
        List<g> Ew;
        if (arrayList != null) {
            this.bbG.clear();
            this.bbu.clear();
            this.bbi.setAdapter(null);
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
                    if (hVar == null || (Ew = hVar.Ew()) == null || Ew.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.bbw.clear();
            boolean z5 = false;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.bbu.add(dc(i7));
                    this.bbG.append(i7, 1);
                } else {
                    h hVar2 = arrayList.get(i7);
                    hVar2.getCategoryId();
                    List<g> Ew2 = hVar2.Ew();
                    if (Ew2 == null) {
                        i = 0;
                    } else {
                        i = Ew2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.bbH.get(i7)) {
                            this.bbu.add(bT(true));
                        } else {
                            this.bbu.add(b(arrayList3, -1, i7));
                        }
                        this.bbw.add(arrayList3);
                    } else if (Ew2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        int i10 = 0;
                        boolean z6 = z5;
                        while (i10 < ceil) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(Ew2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(Ew2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(Ew2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.bbw.add(arrayList2);
                            if (i7 == 0 && i10 == 0 && z) {
                                if (!z6) {
                                    int i11 = 0;
                                    while (true) {
                                        i3 = i11;
                                        if (i3 >= arrayList2.size()) {
                                            break;
                                        }
                                        gVar = arrayList2.get(i3);
                                        if (gVar == null || gVar.DR() == null || !gVar.DR().equals(String.valueOf(this.bbL))) {
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
                                this.bbu.add(b(arrayList2, i3, i7));
                                this.bbt.removeCallbacks(null);
                                this.bbt.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.bbE != null) {
                                            boolean Eb = AlaGiftTabView.this.bbE.Eb();
                                            AlaGiftTabView.this.bR(Eb);
                                            if (!Eb) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.bbE);
                                                if (!c2) {
                                                    AlaGiftTabView.this.bbt.setStyle(AlaGiftTabView.this.bbE.Ea() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.bbt.setStyle(AlaGiftTabView.this.bbE.Ea() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.bbf.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.DR().equals(String.valueOf(this.bbL))) {
                                            i12 = i2 + 1;
                                        } else {
                                            z3 = true;
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.bbu.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                z3 = z6;
                                this.bbu.add(b(arrayList2, i2, i7));
                            }
                            i10++;
                            z6 = z3;
                        }
                        i8 = ceil;
                        z5 = z6;
                    }
                    this.bbG.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.bbi.setAdapter(new AlaGiftPagerAdapter(this.bbu));
            Gu();
            this.bbi.setCurrentItem(this.bby);
            Gw();
            if (z && !this.bca && this.bbZ) {
                this.bca = true;
                Gv();
            }
        }
    }

    private void Gu() {
        int i = 0;
        if (this.bbL > 0 && !ListUtils.isEmpty(this.bbw)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.bbw.size() && !z; i2++) {
                Iterator<g> it = this.bbw.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.DR() != null && next.DR().equals(String.valueOf(this.bbL))) {
                        this.bby = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aJY == 111 && !z && this.bbQ) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_not_find_gift_toast);
            }
            this.bbz = this.bby;
            this.bbw.clear();
        } else if (this.bbK > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.baW.size()) {
                    break;
                }
                i iVar = this.baW.get(i3);
                if (iVar == null || this.bbK != iVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    da(i3);
                    break;
                }
            }
            this.bbz = this.bby;
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
                if (AlaGiftTabView.this.bbx != null) {
                    AlaGiftTabView.this.bbx.GC();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext.getPageActivity());
        aVar.bF(this.aZF);
        aVar.setGiftItems(list);
        aVar.cP(this.aZD);
        aVar.bj(this.aZL);
        aVar.cQ(i);
        if (this.isLandscape) {
            if (this.bbi.getHeight() > this.bcd) {
                this.bcd = this.bbi.getHeight();
            }
            if (this.bcd > 0) {
                aVar.cR(this.bcd / 3);
            } else {
                this.bbi.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaGiftTabView.this.bbi.getHeight() > AlaGiftTabView.this.bcd) {
                            AlaGiftTabView.this.bcd = AlaGiftTabView.this.bbi.getHeight();
                        }
                        if (AlaGiftTabView.this.bcd > 0) {
                            aVar.cR(AlaGiftTabView.this.bcd / 3);
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
                if (tag instanceof a.C0173a) {
                    ((a.C0173a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout dc(int i) {
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
            if (!this.bbJ) {
                this.bbk.setVisibility(0);
            }
            this.bbl.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                i iVar = arrayList.get(i);
                if (!TextUtils.isEmpty(iVar.getCategoryName()) && (this.mType != 0 || (iVar.Bn() != null && iVar.Bn().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.f.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(iVar.getCategoryName());
                    viewGroup.setOnClickListener(new d(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.bbD;
                    }
                    if (this.baV.size() > i && this.baV.get(i) != null) {
                        for (g gVar : this.baV.get(i).Ew()) {
                            if (gVar != null && gVar.DY() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.bbl.addView(viewGroup, layoutParams);
                }
            }
            dd(this.bbA);
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
    private void dd(int i) {
        JSONArray jSONArray;
        List<g> Ew;
        int childCount = this.bbl.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.bbA != i || !this.bbB) && this.baW.size() > i && this.baW.get(i) != null) {
                int min = Math.min(i, this.bbG.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.bbG.get(i3);
                }
                if (this.bbu.size() > i2 && this.baV.size() > i && (this.bbu.get(i2) instanceof ViewGroup)) {
                    if (!this.bbB) {
                        i2 = this.bby;
                    }
                    this.bbz = i2;
                    h hVar = this.baV.get(i);
                    if (hVar != null && hVar.Ew() != null && !hVar.Ew().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.bbu.get(this.bbz);
                        int i4 = 0;
                        while (true) {
                            if (i4 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i4) instanceof GridView)) {
                                i4++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i4)).getAdapter();
                                if (aVar != null) {
                                    a(aVar, !this.bbB ? this.mSelectedPosition : 0);
                                    this.bbB = true;
                                }
                            }
                        }
                    }
                }
            }
            if (this.baW.size() > i && this.baW.get(i) != null) {
                int categoryId = this.baW.get(i).getCategoryId();
                if (!this.bbN.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.bbN.put(categoryId, true);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewGroup viewGroup2 = (ViewGroup) this.bbl.getChildAt(i5);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.f.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.f.icon_new_unlock_gift);
                imageView.setVisibility(8);
                h hVar2 = this.baV.get(i5);
                if (hVar2.Ex() || hVar2.getCategoryId() == 20) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.bbb, "");
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
                                    Ew = hVar2.Ew();
                                    if (Ew != null) {
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
                    Ew = hVar2.Ew();
                    if (Ew != null) {
                        ArrayList arrayList = new ArrayList();
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= Ew.size()) {
                                break;
                            }
                            g gVar = Ew.get(i8);
                            if (!gVar.Er() && !hashSet.contains(gVar.DR())) {
                                arrayList.add(gVar.DR());
                            }
                            i7 = i8 + 1;
                        }
                        if (!arrayList.isEmpty()) {
                            if (i5 != i) {
                                if (hVar2.getCategoryId() == 20 && !bcc.containsAll(arrayList)) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913228, true));
                                    bcc.addAll(arrayList);
                                }
                                imageView.setVisibility(0);
                            } else {
                                if (jSONArray2 == null) {
                                    jSONArray2 = new JSONArray();
                                }
                                for (int i9 = 0; i9 < arrayList.size(); i9++) {
                                    jSONArray2.put(arrayList.get(i9));
                                }
                                SharedPrefHelper.getInstance().putString(this.bbb, jSONArray2.toString());
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
                    if (this.bbU != 0) {
                        gradientTextView.setGradientTextColor(this.bbU, this.bbU);
                    } else {
                        gradientTextView.setGradientTextColor(-52429, -52429);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    de(i);
                    this.bbA = i;
                    this.bbk.scrollTo(viewGroup2.getLeft(), 0);
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
        if (this.bbq != null) {
            this.bbq.setVisibility(z ? this.bbP ? 8 : 0 : 8);
        }
        if (this.bbr != null) {
            TextView textView = this.bbr;
            if (!z && !this.bbP) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void de(int i) {
        int childCount = this.bbl.getChildCount();
        if (i >= 0 && i < childCount && this.baV != null && this.baV.size() > i && this.baV.get(i) != null) {
            this.bbH.get(i);
        }
    }

    public void A(int i, int i2) {
        this.bbK = i;
        this.bbL = i2;
    }

    public void aQ(long j) {
        if (this.bbq != null) {
            if (j >= 100 && (this.aZF || com.baidu.live.ae.a.Qj().buX.aMr)) {
                this.bbq.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.bbq.setText(String.valueOf(j));
        }
    }

    public void aR(long j) {
        if (this.bbr != null) {
            this.bbr.setText(String.valueOf(j));
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
        this.bby = i;
        Gw();
        Gq();
        if (i >= 0 && i < this.bbu.size() && (this.bbu.get(i) instanceof ViewGroup)) {
            Gv();
            ViewGroup viewGroup = (ViewGroup) this.bbu.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.FV() >= 0 && i != this.bbz) {
                            aVar.cQ(-1);
                        }
                        if (aVar.FV() < 0 && i == this.bbz) {
                            aVar.cQ(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        a(gridView);
                        this.bbo.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void a(final AbsListView absListView) {
        if (this.bcb != null) {
            this.bcb.cancel();
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
                        if (childAt != null && (childAt.getTag() instanceof a.C0173a)) {
                            a.C0173a c0173a = (a.C0173a) childAt.getTag();
                            if (c0173a.aZS != null && (c0173a.aZS.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (gVar = (g) c0173a.aZS.getTag(a.f.TAG_GIFT_ITEM)) != null && gVar.aWb != null && gVar.aWb.enabled && gVar.aWb.aWh && !TextUtils.isEmpty(gVar.aWb.detailUrl)) {
                                String DR = gVar.DR();
                                if (!x.Fc().fZ(DR)) {
                                    x.Fc().ga(DR);
                                    AlaGiftTabView.this.b(c0173a.aZS, !TextUtils.isEmpty(gVar.aWb.aWi) ? gVar.aWb.aWi : "长按查看规则");
                                    AnimatorSet a2 = AlaGiftTabView.this.a(absListView, c0173a);
                                    a2.playTogether(AlaGiftTabView.this.R(c0173a.aZN), AlaGiftTabView.this.S(c0173a.aZS));
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
    public AnimatorSet a(final AbsListView absListView, final a.C0173a c0173a) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                if (c0173a != null && c0173a.aZS != null) {
                    c0173a.aZS.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c0173a != null && c0173a.aZS != null) {
                    c0173a.aZS.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c0173a != null) {
                    c0173a.FY();
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
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.baidu.live.gift.container.a.a(), new a.C0174a(), new a.C0174a());
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
                if (view != null && (valueAnimator.getAnimatedValue() instanceof a.C0174a)) {
                    a.C0174a c0174a = (a.C0174a) valueAnimator.getAnimatedValue();
                    view.setScaleX(c0174a.scale);
                    view.setScaleY(c0174a.scale);
                    view.setAlpha(c0174a.alpha);
                }
            }
        });
        return ofObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(List<Animator> list) {
        if (list != null && !list.isEmpty()) {
            if (this.bcb == null) {
                this.bcb = new AnimatorSet();
                this.bcb.setInterpolator(new LinearInterpolator());
            }
            this.bcb.playTogether(list);
            this.bcb.start();
        }
    }

    private void Gv() {
        JSONObject jSONObject = new JSONObject();
        i iVar = (i) ListUtils.getItem(this.baW, this.bbA);
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

    private void Gw() {
        int i = 0;
        for (int i2 = 0; i2 < this.bbG.size(); i2++) {
            for (int i3 = 0; i3 < this.bbG.get(i2); i3++) {
                if (i + i3 == this.bby) {
                    if (this.bbG.get(i2) <= 1) {
                        this.bbj.setVisibility(4);
                    } else {
                        this.bbj.setVisibility(0);
                    }
                    this.bbj.setCount(this.bbG.get(i2));
                    this.bbj.onPageSelected(i3);
                    dd(i2);
                    return;
                }
            }
            i += this.bbG.get(i2);
        }
    }

    public g Gx() {
        return this.bbE;
    }

    public int Gy() {
        return this.bbF;
    }

    public void a(e eVar) {
        this.bbx = eVar;
    }

    public void df(int i) {
        this.bbF = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bcg);
        MessageManager.getInstance().registerListener(this.bch);
        MessageManager.getInstance().registerListener(this.bci);
        MessageManager.getInstance().registerListener(this.bcj);
    }

    public void Gz() {
        if (!ListUtils.isEmpty(this.bbu)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bbu) {
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
        if (!ListUtils.isEmpty(this.bbu) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bbu) {
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
    public void GA() {
        if (!ListUtils.isEmpty(this.bbu)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.bbu) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aZL);
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
    public void GB() {
        if (this.bbE != null && this.bbE.Et()) {
            this.bbf.setStyleEnabled(this.aZL);
            if (this.aZL) {
                this.bbt.setStyle(this.bbE.Ea() ? 2 : 1);
            } else {
                this.bbt.setStyle(this.bbE.Ea() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.bbT = null;
        MessageManager.getInstance().unRegisterListener(this.bcg);
        MessageManager.getInstance().unRegisterListener(this.bch);
        MessageManager.getInstance().unRegisterListener(this.bci);
        MessageManager.getInstance().unRegisterListener(this.bcj);
        rf();
        if (this.bbR != null) {
            this.bbR.dismiss();
        }
        if (this.bcb != null) {
            this.bcb.cancel();
        }
    }

    public void bF(boolean z) {
        this.aZF = z;
    }

    public void dg(int i) {
        this.aZD = i;
    }

    public void d(g gVar) {
        this.bbE = gVar;
        if (this.bbE.DR().equals("")) {
            BdUtilHelper.showToast(this.mContext.getPageActivity(), "该礼物已下线");
            return;
        }
        this.bbL = Integer.valueOf(this.bbE.DR()).intValue();
        if (this.bbT != null) {
            this.bbT.a(gVar);
        }
        if (gVar != null && !gVar.Ec()) {
            this.bbV.FS();
        }
    }

    public void FR() {
        if (this.bbV != null) {
            this.bbV.FR();
        }
        g gVar = this.bbE;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.DR());
                jSONObject.putOpt("gift_name", gVar.DS());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "combosend_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
        }
    }

    public void FQ() {
        if (this.bbV != null) {
            this.bbV.FQ();
        }
        g gVar = this.bbE;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.DR());
                jSONObject.putOpt("gift_name", gVar.DS());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "combosend_clk").setContentExt(null, null, jSONObject));
        }
    }

    public void bV(boolean z) {
        if (this.bbt != null) {
            this.bbt.setVisibility(z ? 0 : 4);
        }
    }
}

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
import com.baidu.live.data.aa;
import com.baidu.live.data.bq;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.data.x;
import com.baidu.live.gift.container.AlaComboBtnAnimView;
import com.baidu.live.gift.container.a;
import com.baidu.live.gift.container.a.a;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
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
    private int aHt;
    private boolean aWF;
    private int aWx;
    private boolean aWz;
    public ArrayList<h> aXO;
    public ArrayList<i> aXP;
    public ArrayList<k> aXQ;
    private final String aXU;
    private boolean aXV;
    private ViewGroup aXW;
    private View aXX;
    private GiftPanelNumRoundRectView aXY;
    public TextView aXZ;
    private SparseBooleanArray aYA;
    private View.OnClickListener aYB;
    private boolean aYC;
    private int aYD;
    private int aYE;
    private int aYF;
    private SparseBooleanArray aYG;
    private Set<String> aYH;
    private boolean aYI;
    private boolean aYJ;
    private BdAlertDialog aYK;
    private int aYL;
    private a aYM;
    private int aYN;
    private AlaComboBtnAnimView aYO;
    private TbImageView aYP;
    private com.baidu.live.gift.container.d aYQ;
    private boolean aYR;
    private boolean aYS;
    private boolean aYT;
    private AnimatorSet aYU;
    private View.OnClickListener aYW;
    AdapterView.OnItemClickListener aYX;
    private CustomMessageListener aYY;
    private CustomMessageListener aYZ;
    private ImageView aYa;
    private BaseViewPager aYb;
    private RoundRectPageIndicator aYc;
    private HorizontalScrollView aYd;
    private LinearLayout aYe;
    private FrameLayout aYf;
    private CommonEmptyView aYg;
    private View aYh;
    private com.baidu.live.gift.container.c aYi;
    private TextView aYj;
    private TextView aYk;
    private TextView aYl;
    public GiftPanelOperationSendView aYm;
    private List<View> aYn;
    ArrayList<k> aYo;
    private ArrayList<List<g>> aYp;
    private e aYq;
    private int aYr;
    private int aYs;
    private int aYt;
    private boolean aYu;
    private boolean aYv;
    private int aYw;
    private g aYx;
    private int aYy;
    private SparseIntArray aYz;
    private CustomMessageListener aZa;
    private CustomMessageListener aZb;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private int mSelectedPosition;
    private int mType;
    private String otherParams;
    private String roomId;
    public static int page = 0;
    public static ArrayList<String> aYV = new ArrayList<>();

    /* loaded from: classes10.dex */
    public interface a {
        void EJ();

        void a(g gVar);

        void c(boolean z, int i);

        void cP(int i);

        void f(boolean z, String str);

        void g(String str, String str2, boolean z);

        void r(int i, String str);
    }

    /* loaded from: classes10.dex */
    public interface e {
        void Fm();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aXU = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aYn = new ArrayList();
        this.aYo = new ArrayList<>();
        this.aYr = 0;
        this.aYs = 0;
        this.mSelectedPosition = 0;
        this.aYt = 0;
        this.aYz = new SparseIntArray();
        this.aYA = new SparseBooleanArray();
        this.isLandscape = false;
        this.aYC = false;
        this.aYD = -1;
        this.aYE = -1;
        this.aWz = false;
        this.aWx = -1;
        this.aYG = new SparseBooleanArray();
        this.aYH = new HashSet();
        this.aYR = false;
        this.aWF = false;
        this.aYS = false;
        this.aYT = false;
        this.aYW = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGiftTabView.this.aYo.clear();
                if (AlaGiftTabView.this.aYO == null || !AlaGiftTabView.this.aYO.ED()) {
                    if (AlaGiftTabView.this.aYi == null) {
                        AlaGiftTabView.this.aYi = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext.getPageActivity(), AlaGiftTabView.this.mType, AlaGiftTabView.this.aYX);
                    }
                    AlaGiftTabView.this.bN(true);
                    if (AlaGiftTabView.this.aYx.CI() == 10) {
                        Iterator<k> it = AlaGiftTabView.this.aXQ.iterator();
                        while (it.hasNext()) {
                            k next = it.next();
                            if (next.number <= AlaGiftTabView.this.aYx.aSX) {
                                AlaGiftTabView.this.aYo.add(next);
                            }
                        }
                    } else {
                        Iterator<k> it2 = AlaGiftTabView.this.aXQ.iterator();
                        while (it2.hasNext()) {
                            AlaGiftTabView.this.aYo.add(it2.next());
                        }
                    }
                    AlaGiftTabView.this.aYi.a(AlaGiftTabView.this.aXX, AlaGiftTabView.this.aYo, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bN(false);
                        }
                    });
                }
            }
        };
        this.aYX = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.aYi.dismiss();
                if (AlaGiftTabView.this.aYo == null || AlaGiftTabView.this.aYo.size() <= 0) {
                    AlaGiftTabView.this.ge("1");
                } else if (i == AlaGiftTabView.this.aYo.size()) {
                    AlaGiftTabView.this.Fc();
                } else {
                    k kVar = AlaGiftTabView.this.aYo.get(i);
                    if (kVar != null) {
                        int number = kVar.getNumber();
                        if (AlaGiftTabView.this.mType == 1 && (bVar = AlaGiftTabView.this.aYx.aSS) != null) {
                            if (number == -1) {
                                number = bVar.aTh;
                            }
                            if (number > AlaGiftTabView.this.aYL) {
                                number = AlaGiftTabView.this.aYL;
                            }
                        }
                        AlaGiftTabView.this.ge(String.valueOf(number));
                    }
                }
            }
        };
        this.aYY = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.i.c)) {
                    com.baidu.live.i.c cVar = (com.baidu.live.i.c) customResponsedMessage.getData();
                    if ((cVar.aQW == 1 || cVar.aQW == 2 || cVar.aQW == 5 || cVar.aQW == 6) && cVar.aQX != null) {
                        AlaGiftTabView.this.av(cVar.aQX.getId(), cVar.aQX.getUrl());
                    }
                }
            }
        };
        this.aYZ = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bI(true);
                if (AlaGiftTabView.this.aYx != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aYx) && AlaGiftTabView.this.aXV) {
                    AlaGiftTabView.this.aYm.setStyle(AlaGiftTabView.this.aYx.CK() ? 2 : 1);
                    AlaGiftTabView.this.aXY.setStyleEnabled(true);
                }
            }
        };
        this.aZa = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                x xVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x) && (xVar = (x) customResponsedMessage.getData()) != null && xVar.aGd != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = xVar.aGd.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aWF != z2) {
                        AlaGiftTabView.this.aWF = z2;
                        AlaGiftTabView.this.Fl();
                        AlaGiftTabView.this.Fk();
                    }
                }
            }
        };
        this.aZb = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.Fb();
                    AlaGiftTabView.this.aYm.setStyle(AlaGiftTabView.this.aYx.CK() ? 4 : 3);
                    AlaGiftTabView.this.aXY.setStyleEnabled(false);
                    if (AlaGiftTabView.this.aYM != null) {
                        AlaGiftTabView.this.aYM.f(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aYB = onClickListener;
        this.aYC = z;
        this.aXW = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aYw = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.d.sdk_ds36);
        this.aYp = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aYL = AlaRecorderLog.ErrorCode.ERROR_RECORDER_NOT_DEFINE_ERROR;
                this.aYa.setVisibility(8);
                return;
            case 1:
                this.aYL = 999;
                this.aYa.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public void cS(int i) {
        int childCount;
        this.aYN = i;
        if (this.aYe != null && (childCount = this.aYe.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aYt) {
                    ((GradientTextView) ((ViewGroup) this.aYe.getChildAt(i2)).findViewById(a.f.text_view)).setGradientTextColor(this.aYN, this.aYN);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aYM = aVar;
    }

    public void au(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bH(boolean z) {
        this.aYJ = z;
    }

    public void onVisibilityChanged(boolean z) {
        bH(z);
    }

    public View getRootView() {
        return this.aXW;
    }

    private void initViews() {
        this.aXX = this.aXW.findViewById(a.f.gift_count_layout);
        this.aXX.setOnClickListener(this.aYW);
        this.aXY = (GiftPanelNumRoundRectView) this.aXW.findViewById(a.f.gift_count_round);
        this.aXZ = (TextView) this.aXW.findViewById(a.f.gift_count_input);
        this.aXZ.setText("1");
        this.aXZ.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.aYa = (ImageView) this.aXW.findViewById(a.f.gift_tab_back);
        this.aYa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aYM != null) {
                    AlaGiftTabView.this.aYM.EJ();
                }
            }
        });
        this.aYb = (BaseViewPager) this.aXW.findViewById(a.f.gift_viewpager);
        this.aYb.setOnPageChangeListener(this);
        this.aYc = (RoundRectPageIndicator) this.aXW.findViewById(a.f.gift_tab_indicator);
        this.aYe = (LinearLayout) this.aXW.findViewById(a.f.gift_tab_layout);
        this.aYd = (HorizontalScrollView) this.aXW.findViewById(a.f.gift_tab_scrollview);
        if (this.aYC) {
            this.aYd.setVisibility(8);
        }
        this.aYj = (TextView) this.aXW.findViewById(a.f.current_money);
        this.aYj.setOnClickListener(this.aYB);
        this.aYk = (TextView) this.aXW.findViewById(a.f.current_flower);
        this.aYk.setOnClickListener(this.aYB);
        this.aYm = (GiftPanelOperationSendView) this.aXW.findViewById(a.f.donate);
        this.aYl = (TextView) this.aXW.findViewById(a.f.current_recharge);
        this.aYl.setOnClickListener(this.aYB);
        this.aYm.setOnClickListener(this.aYB);
        this.aYf = (FrameLayout) this.aXW.findViewById(a.f.layout_error);
        this.aYf.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.aYg = new CommonEmptyView(this.mContext.getPageActivity());
        this.aYg.setVisibility(8);
        this.aYg.addToParent(this.aYf);
        this.aYh = this.aXW.findViewById(a.f.donate_layout);
        this.aYO = (AlaComboBtnAnimView) this.aXW.findViewById(a.f.combo_layout);
        this.aYO.setComboClickListener(this.aYB);
        this.aYO.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void EE() {
                AlaGiftTabView.this.bQ(true);
            }
        });
        this.aYP = (TbImageView) this.aXW.findViewById(a.f.iv_official);
    }

    public void EZ() {
        this.aYI = true;
        this.aYj.setVisibility(8);
        this.aYk.setVisibility(8);
        this.aYl.setVisibility(8);
    }

    public void bI(boolean z) {
        this.aXV = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.af.a.OJ().ON() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aYl.setText(this.mContext.getPageActivity().getString(a.h.first_recharge_text));
            if (!this.aYH.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aYH.add(str);
            }
        }
    }

    public void bf(boolean z) {
    }

    public void cm(int i) {
        this.aYF = i;
    }

    public void bJ(boolean z) {
        this.aYJ = z;
        this.aYS = z;
        if (z) {
            Fa();
        }
        if (!z && this.aYU != null) {
            this.aYU.cancel();
        }
        if (z && !ListUtils.isEmpty(this.aXP)) {
            Ff();
            this.aYT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aa aaVar) {
        if (aaVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_pop_show"));
            if (this.aYQ == null) {
                this.aYQ = new com.baidu.live.gift.container.d(this.mContext);
            }
            this.aYQ.n(aaVar.dialogTitle, aaVar.aGW + aaVar.aGX, aaVar.aGX);
        }
    }

    private void Q(View view) {
        if (this.aYQ == null) {
            this.aYQ = new com.baidu.live.gift.container.d(this.mContext);
        }
        this.aYQ.O(view);
    }

    public void bK(boolean z) {
        this.aYR = z;
    }

    public void cT(int i) {
        this.aHt = i;
    }

    public void bh(boolean z) {
        this.aWF = z;
    }

    public void bL(boolean z) {
        if (z) {
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds24);
            ViewGroup.LayoutParams layoutParams = this.aYb.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
                this.aYb.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.aYf.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = dimensionPixelOffset;
                this.aYf.setLayoutParams(layoutParams2);
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
            AlaGiftTabView.this.cU(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(int i) {
        if (this.aYM != null) {
            this.aYM.c(false, this.aYL);
        }
        cV(i);
        this.aYb.setCurrentItem(this.aYr);
        Fg();
        Fa();
    }

    private void cV(int i) {
        int min = Math.min(i, this.aYz.size());
        int i2 = 0;
        int i3 = 0;
        while (i2 < min) {
            i2++;
            i3 = this.aYz.get(i2) + i3;
        }
        this.aYr = i3;
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
            AlaGiftTabView.this.aYs = AlaGiftTabView.this.aYr;
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
            if (item != null && item.aSW != null && item.aSW.enabled && !TextUtils.isEmpty(item.aSW.detailUrl) && AlaGiftTabView.this.aYM != null) {
                AlaGiftTabView.this.aYM.r(item.aSW.aTe, item.aSW.detailUrl);
            }
            return false;
        }
    }

    private void Fa() {
        if (this.aYJ && this.aYM != null) {
            if (this.aYx != null && this.aYx.aST) {
                this.aYM.g(this.aYx.aSU, this.aYx.aSV, false);
            } else {
                this.aYM.g(null, null, false);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.aYM != null) {
            this.aYM.c(false, this.aYL);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.cL(i);
                aVar.notifyDataSetChanged();
                this.aYh.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                ge("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aYx.Db()) {
                        this.aYm.setStyle(this.aYx.CK() ? 4 : 3);
                        this.aXY.setStyleEnabled(false);
                        if (this.aYM != null) {
                            this.aYM.f(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aYx.CN()) && this.aYJ) {
                            this.mContext.showToast(this.aYx.CN());
                            return;
                        }
                        return;
                    }
                    this.aYm.setEnabled(true);
                    if (this.aYx.Df()) {
                        if (this.aYM != null) {
                            this.aYM.f(false, null);
                        }
                        if (this.aYx.Da() == 6 && this.aWx < 3) {
                            i3 = 3;
                        } else if (this.aYx.Da() == 7 && this.aWx < 7) {
                            i3 = 7;
                        } else if (this.aYx.Da() == 8 && this.aWx < 13) {
                            i3 = 13;
                        } else if (this.aYx.Da() == 9 && this.aWx < 22) {
                            i3 = 22;
                        } else if (this.aYx.Da() == 10 && this.aWx < 29) {
                            i3 = 29;
                        } else if (this.aYx.Da() == 11 && this.aWx < 39) {
                            i3 = 39;
                        } else if (this.aYx.Da() == 12 && this.aWx < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.aYm.setStyle(this.aYx.CK() ? 2 : 1);
                    } else {
                        this.aYm.setStyle(this.aYx.CK() ? 4 : 3);
                    }
                    this.aXY.setStyleEnabled(z);
                    Fl();
                    i2 = i3;
                } else {
                    this.aYm.setStyle(this.aYx.CK() ? 2 : 1);
                    if ((this.aYx instanceof com.baidu.live.gift.aa) && ((com.baidu.live.gift.aa) this.aYx).DU()) {
                        this.aYm.setText("查看详情");
                    } else if (this.aYx.aSS != null && this.aYx.aSS.aTg != null && this.aYx.aSS.aTg.equals("20")) {
                        if (this.aYx.aSS.aTk != null && this.aYx.aSS.aTk.key == 11) {
                            this.aYm.setText("激活");
                        } else if (this.aYx.aSS.aTk != null && this.aYx.aSS.aTk.key == 12) {
                            this.aYm.setText("立即激活");
                        } else {
                            this.aYm.setText("使用");
                        }
                    } else {
                        this.aYm.setText("赠送");
                    }
                    this.aXY.setStyleEnabled(true);
                    i2 = -1;
                }
                Fa();
                if (this.aYx.CL()) {
                    bM(true);
                } else {
                    bM(false);
                    ge("1");
                }
                d(false, i2);
                return;
            }
            this.aYm.setStyle(3);
            return;
        }
        this.aYm.setStyle(3);
    }

    private void d(boolean z, int i) {
        if (this.aYJ && this.aYx != null) {
            if (this.mType == 0) {
                if (this.aYx.Dd() && !this.aWF) {
                    this.mContext.showToast(a.h.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aYx.CN()) && this.aYx.Db() && !z) {
                    this.mContext.showToast(this.aYx.CN());
                } else if (this.aYx.Df() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.h.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aYx.CZ()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.h.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1) {
                g.b bVar = this.aYx.aSS;
                if (bVar != null && !TextUtils.isEmpty(bVar.aTj)) {
                    this.mContext.showToast(bVar.aTj);
                } else if (!TextUtils.isEmpty(this.aYx.CN())) {
                    BdUtilHelper.showToast(this.mContext.getPageActivity(), this.aYx.CN());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.af.a.OJ().bxp != null && com.baidu.live.af.a.OJ().bxp.aMN != null) {
            String str = com.baidu.live.af.a.OJ().bxp.aMN.aMe;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Da()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fb() {
        if (!this.aYv) {
            this.aYK = new BdAlertDialog(this.mContext.getPageActivity());
            this.aYK.setCancelable(false);
            this.aYK.setCanceledOnTouchOutside(false);
            this.aYK.setTitle(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_title));
            this.aYK.setMessage(String.format(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_content), Integer.valueOf(this.aYF)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aYK.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.aYK.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aYK.setPositiveButtonTextColor(-57754);
                this.aYK.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aYK.setPositiveButton(this.mContext.getPageActivity().getString(a.h.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aYv = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aYK.setNegativeButton(this.mContext.getPageActivity().getString(a.h.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.22
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aYv = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aYK.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.23
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    AlaGiftTabView.this.aYm.setStyle(AlaGiftTabView.this.aYx.CK() ? 2 : 1);
                    AlaGiftTabView.this.aXY.setStyleEnabled(true);
                }
            });
            this.aYK.create(this.mContext).show();
            this.aYv = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.af.a.OJ().bru.aIJ;
        if (z2) {
            this.aXX.setVisibility(4);
            this.aYm.setStyle(1);
        } else {
            View view = this.aXX;
            if (this.aYx == null || !this.aYx.CK()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.aYM != null) {
            this.aYM.f(z2, this.aYx != null ? this.aYx.getThumbnail_url() : null);
        }
    }

    public void Fc() {
        if (this.aYM != null && this.aYx != null) {
            if (this.aYx.CI() == 10) {
                this.aYM.c(true, this.aYx.aSX);
            } else {
                this.aYM.c(true, this.aYL);
            }
        }
    }

    @Override // com.baidu.live.view.input.c.a
    public void gb(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        ge(str);
    }

    public void ge(String str) {
        this.aXZ.setText(str);
        this.aXZ.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.d.sdk_fontsize20 : a.d.sdk_fontsize24));
        bN(false);
        if (this.aYx != null && this.aYx.CK()) {
            this.aXX.setVisibility(0);
            this.aYy = JavaTypesHelper.toInt(this.aXZ.getText().toString(), 1);
            return;
        }
        this.aXX.setVisibility(4);
        this.aYy = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        this.aXZ.setGravity(17);
        if (z) {
            this.aXZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aXZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<h> arrayList, ArrayList<i> arrayList2, ArrayList<k> arrayList3, boolean z2, int i) {
        if (this.mType != 0 || this.aXO == null || this.aXO.isEmpty()) {
            rh();
            if (this.aXO == null) {
                this.aXO = new ArrayList<>();
            }
            this.aXO.clear();
            if (arrayList != null) {
                this.aXO.addAll(arrayList);
            }
            this.aXP = arrayList2;
            this.aXQ = arrayList3;
            this.aYu = false;
            if (this.aXP == null || this.aXP.isEmpty()) {
                this.aYd.setVisibility(8);
            }
            b(z, z2, i);
            onPageSelected(this.aYb.getCurrentItem());
        }
    }

    public void D(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aYn != null) {
            for (View view : this.aYn) {
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
                                ((com.baidu.live.gift.container.a) ((GridView) childAt).getAdapter()).D(str, i);
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
        Fd();
        if (this.aXO == null || this.aXO.size() <= 0 || !z2) {
            rh();
            if (this.aYc != null) {
                this.aYc.setVisibility(4);
            }
            if (this.aYM != null) {
                this.aYM.g("", "", false);
            }
            this.aYh.setVisibility(4);
            this.aYg.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                this.aYg.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aYg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_no);
                this.aYg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.af.a.OJ().bru.aKq && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aYg.setTitle(string);
            this.aYg.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.24
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aYq != null) {
                        AlaGiftTabView.this.aYq.Fm();
                    }
                }
            });
            this.aYg.setVisibility(0);
            return;
        }
        this.aYg.setVisibility(8);
        if (z) {
            h(this.aXP);
        }
        bq bqVar = com.baidu.live.af.a.OJ().bxp;
        if (this.mType == 0 && bqVar != null && bqVar.aMR != null && bqVar.aMR.aPv && !this.aYR && this.aXO.get(0) != null && this.aXO.get(0).Dg() != null) {
            List<g> Dg = this.aXO.get(0).Dg();
            if (Dg.size() <= 1 || Dg.get(1) == null) {
                z3 = true;
            } else {
                z3 = !Dg.get(1).isRed();
            }
            if (!Dg.isEmpty() && z3) {
                g gVar = new g();
                gVar.bv(true);
                gVar.setGiftName("发红包");
                Dg.add(1, gVar);
            }
        }
        c(this.aXO, z);
        ge("1");
    }

    public void cW(int i) {
        A(-1, i);
        Fe();
        if (this.aYb != null) {
            this.aYb.setCurrentItem(this.aYr);
        }
    }

    private void rh() {
        this.aYr = 0;
        this.aYs = 0;
        this.mSelectedPosition = 0;
        this.aYt = 0;
        if (this.aYz != null) {
            this.aYz.clear();
        }
        if (this.aYn != null) {
            this.aYn.clear();
        }
        if (this.aYb != null) {
            this.aYb.setAdapter(null);
        }
        if (this.aYO != null) {
            this.aYO.EC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.Df()) {
            if (gVar.Da() == 6 && this.aWx < 3) {
                return false;
            }
            if (gVar.Da() == 7 && this.aWx < 7) {
                return false;
            }
            if (gVar.Da() == 8 && this.aWx < 13) {
                return false;
            }
            if (gVar.Da() == 9 && this.aWx < 22) {
                return false;
            }
            if (gVar.Da() == 10 && this.aWx < 29) {
                return false;
            }
            if (gVar.Da() == 11 && this.aWx < 39) {
                return false;
            }
            if (gVar.Da() == 12 && this.aWx < 47) {
                return false;
            }
        }
        if (gVar.Dd()) {
            return this.aWF;
        }
        return true;
    }

    public void b(final aa aaVar) {
        if (aaVar == null || TextUtils.isEmpty(aaVar.iconUrl)) {
            this.aYP.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_show"));
            this.aYP.setVisibility(0);
            this.aYP.startLoad(aaVar.iconUrl, 10, false);
            this.aYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_clk"));
                    AlaGiftTabView.this.a(aaVar);
                }
            });
            String str = "key_live_official_tip" + currentAccount;
            if (com.baidu.live.d.xf().getInt(str, 0) == 0 && this.aYS) {
                Q(this.aYP);
                com.baidu.live.d.xf().putInt(str, 1);
            }
        }
    }

    private void Fd() {
        if (ListUtils.getCount(this.aXP) != 0 && ListUtils.getCount(this.aXO) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<i> it = this.aXP.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.AD()) == 0))) {
                    arrayList.add(next);
                    Iterator<h> it2 = this.aXO.iterator();
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
                Iterator<h> it3 = this.aXO.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().Dg().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.CL()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aXP.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aXO.removeAll(arrayList2);
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
        List<g> Dg;
        if (arrayList != null) {
            this.aYz.clear();
            this.aYn.clear();
            this.aYb.setAdapter(null);
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
                    if (hVar == null || (Dg = hVar.Dg()) == null || Dg.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aYp.clear();
            boolean z5 = false;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aYn.add(cX(i7));
                    this.aYz.append(i7, 1);
                } else {
                    h hVar2 = arrayList.get(i7);
                    hVar2.getCategoryId();
                    List<g> Dg2 = hVar2.Dg();
                    if (Dg2 == null) {
                        i = 0;
                    } else {
                        i = Dg2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aYA.get(i7)) {
                            this.aYn.add(bO(true));
                        } else {
                            this.aYn.add(b(arrayList3, -1, i7));
                        }
                    } else if (Dg2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        int i10 = 0;
                        boolean z6 = z5;
                        while (i10 < ceil) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(Dg2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(Dg2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(Dg2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aYp.add(arrayList2);
                            if (i7 == 0 && i10 == 0 && z) {
                                if (!z6) {
                                    int i11 = 0;
                                    while (true) {
                                        i3 = i11;
                                        if (i3 >= arrayList2.size()) {
                                            break;
                                        }
                                        gVar = arrayList2.get(i3);
                                        if (gVar == null || gVar.CC() == null || !gVar.CC().equals(String.valueOf(this.aYE))) {
                                            i11 = i3 + 1;
                                        } else {
                                            this.mSelectedPosition = i3;
                                            z4 = true;
                                            break;
                                        }
                                    }
                                    if (gVar == null && arrayList2.size() > 0) {
                                        arrayList2.get(0);
                                    }
                                    this.aYn.add(b(arrayList2, i3, i7));
                                    this.aYm.removeCallbacks(null);
                                    this.aYm.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (AlaGiftTabView.this.aYx != null) {
                                                boolean CL = AlaGiftTabView.this.aYx.CL();
                                                AlaGiftTabView.this.bM(CL);
                                                if (!CL) {
                                                    boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aYx);
                                                    if (!c2) {
                                                        AlaGiftTabView.this.aYm.setStyle(AlaGiftTabView.this.aYx.CK() ? 4 : 3);
                                                    } else {
                                                        AlaGiftTabView.this.aYm.setStyle(AlaGiftTabView.this.aYx.CK() ? 2 : 1);
                                                    }
                                                    AlaGiftTabView.this.aXY.setStyleEnabled(c2);
                                                }
                                            }
                                        }
                                    }, 100L);
                                    z3 = z4;
                                }
                                gVar = null;
                                i3 = 0;
                                z4 = z6;
                                if (gVar == null) {
                                    arrayList2.get(0);
                                }
                                this.aYn.add(b(arrayList2, i3, i7));
                                this.aYm.removeCallbacks(null);
                                this.aYm.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aYx != null) {
                                            boolean CL = AlaGiftTabView.this.aYx.CL();
                                            AlaGiftTabView.this.bM(CL);
                                            if (!CL) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aYx);
                                                if (!c2) {
                                                    AlaGiftTabView.this.aYm.setStyle(AlaGiftTabView.this.aYx.CK() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.aYm.setStyle(AlaGiftTabView.this.aYx.CK() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.aXY.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.CC().equals(String.valueOf(this.aYE))) {
                                            i12 = i2 + 1;
                                        } else {
                                            z3 = true;
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                }
                                i2 = -1;
                                z3 = z6;
                                this.aYn.add(b(arrayList2, i2, i7));
                            }
                            i10++;
                            z6 = z3;
                        }
                        i8 = ceil;
                        z5 = z6;
                    }
                    this.aYz.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aYb.setAdapter(new AlaGiftPagerAdapter(this.aYn));
            Fe();
            this.aYb.setCurrentItem(this.aYr);
            Fg();
            if (z && !this.aYT && this.aYS) {
                this.aYT = true;
                Ff();
            }
        }
    }

    private void Fe() {
        int i = 0;
        if (this.aYE > 0 && !ListUtils.isEmpty(this.aYp)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aYp.size() && !z; i2++) {
                Iterator<g> it = this.aYp.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.CC() != null && next.CC().equals(String.valueOf(this.aYE))) {
                        this.aYr = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aHt == 111 && !z && this.aYJ) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_not_find_gift_toast);
            }
            this.aYs = this.aYr;
            this.aYp.clear();
        } else if (this.aYD > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aXP.size()) {
                    break;
                }
                i iVar = this.aXP.get(i3);
                if (iVar == null || this.aYD != iVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    cV(i3);
                    break;
                }
            }
            this.aYs = this.aYr;
        }
    }

    private View bO(boolean z) {
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
                if (AlaGiftTabView.this.aYq != null) {
                    AlaGiftTabView.this.aYq.Fm();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext.getPageActivity());
        aVar.bA(this.aWz);
        aVar.setGiftItems(list);
        aVar.cK(this.aWx);
        aVar.bh(this.aWF);
        aVar.cL(i);
        if (this.isLandscape) {
            if (this.aYb.getHeight() > 0) {
                aVar.cM(this.aYb.getHeight() / 3);
            } else {
                this.aYb.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.cM(AlaGiftTabView.this.aYb.getHeight() / 3);
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
                if (tag instanceof a.C0172a) {
                    ((a.C0172a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout cX(int i) {
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
            if (!this.aYC) {
                this.aYd.setVisibility(0);
            }
            this.aYe.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                i iVar = arrayList.get(i);
                if (!TextUtils.isEmpty(iVar.getCategoryName()) && (this.mType != 0 || (iVar.AD() != null && iVar.AD().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.f.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(iVar.getCategoryName());
                    viewGroup.setOnClickListener(new d(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aYw;
                    }
                    if (this.aXO.size() > i && this.aXO.get(i) != null) {
                        for (g gVar : this.aXO.get(i).Dg()) {
                            if (gVar != null && gVar.CI() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aYe.addView(viewGroup, layoutParams);
                }
            }
            cY(this.aYt);
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
    private void cY(int i) {
        JSONArray jSONArray;
        List<g> Dg;
        int childCount = this.aYe.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aYt != i || !this.aYu) && this.aXP.size() > i && this.aXP.get(i) != null) {
                int min = Math.min(i, this.aYz.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.aYz.get(i3);
                }
                if (this.aYn.size() > i2 && this.aXO.size() > i && (this.aYn.get(i2) instanceof ViewGroup)) {
                    if (!this.aYu) {
                        i2 = this.aYr;
                    }
                    this.aYs = i2;
                    h hVar = this.aXO.get(i);
                    if (hVar != null && hVar.Dg() != null && !hVar.Dg().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aYn.get(this.aYs);
                        int i4 = 0;
                        while (true) {
                            if (i4 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i4) instanceof GridView)) {
                                i4++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i4)).getAdapter();
                                if (aVar != null) {
                                    a(aVar, !this.aYu ? this.mSelectedPosition : 0);
                                    this.aYu = true;
                                }
                            }
                        }
                    }
                }
            }
            if (this.aXP.size() > i && this.aXP.get(i) != null) {
                int categoryId = this.aXP.get(i).getCategoryId();
                if (!this.aYG.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aYG.put(categoryId, true);
                }
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aYe.getChildAt(i5);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.f.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.f.icon_new_unlock_gift);
                imageView.setVisibility(8);
                h hVar2 = this.aXO.get(i5);
                if (hVar2.Dh() || hVar2.getCategoryId() == 20) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aXU, "");
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
                                    Dg = hVar2.Dg();
                                    if (Dg != null) {
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
                    Dg = hVar2.Dg();
                    if (Dg != null) {
                        ArrayList arrayList = new ArrayList();
                        int i7 = 0;
                        while (true) {
                            int i8 = i7;
                            if (i8 >= Dg.size()) {
                                break;
                            }
                            g gVar = Dg.get(i8);
                            if (!gVar.Db() && !hashSet.contains(gVar.CC())) {
                                arrayList.add(gVar.CC());
                            }
                            i7 = i8 + 1;
                        }
                        if (!arrayList.isEmpty()) {
                            if (i5 != i) {
                                if (hVar2.getCategoryId() == 20 && !aYV.containsAll(arrayList)) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913228, true));
                                    aYV.addAll(arrayList);
                                }
                                imageView.setVisibility(0);
                            } else {
                                if (jSONArray2 == null) {
                                    jSONArray2 = new JSONArray();
                                }
                                for (int i9 = 0; i9 < arrayList.size(); i9++) {
                                    jSONArray2.put(arrayList.get(i9));
                                }
                                SharedPrefHelper.getInstance().putString(this.aXU, jSONArray2.toString());
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
                    if (this.aYN != 0) {
                        gradientTextView.setGradientTextColor(this.aYN, this.aYN);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    cZ(i);
                    this.aYt = i;
                    this.aYd.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i5 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bP(false);
                        } else {
                            bP(true);
                        }
                    } else {
                        bP(true);
                    }
                }
            }
        }
    }

    private void bP(boolean z) {
        int i = 8;
        if (this.aYj != null) {
            this.aYj.setVisibility(z ? this.aYI ? 8 : 0 : 8);
        }
        if (this.aYk != null) {
            TextView textView = this.aYk;
            if (!z && !this.aYI) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void cZ(int i) {
        int childCount = this.aYe.getChildCount();
        if (i >= 0 && i < childCount && this.aXO != null && this.aXO.size() > i && this.aXO.get(i) != null) {
            this.aYA.get(i);
        }
    }

    public void A(int i, int i2) {
        this.aYD = i;
        this.aYE = i2;
    }

    public void aN(long j) {
        if (this.aYj != null) {
            if (j >= 100 && (this.aWz || com.baidu.live.af.a.OJ().bru.aJH)) {
                this.aYj.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aYj.setText(String.valueOf(j));
        }
    }

    public void aO(long j) {
        if (this.aYk != null) {
            this.aYk.setText(String.valueOf(j));
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
        this.aYr = i;
        Fg();
        Fa();
        if (i >= 0 && i < this.aYn.size() && (this.aYn.get(i) instanceof ViewGroup)) {
            Ff();
            ViewGroup viewGroup = (ViewGroup) this.aYn.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.EF() >= 0 && i != this.aYs) {
                            aVar.cL(-1);
                        }
                        if (aVar.EF() < 0 && i == this.aYs) {
                            aVar.cL(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        a(gridView);
                        this.aYh.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void a(final AbsListView absListView) {
        if (this.aYU != null) {
            this.aYU.cancel();
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
                        if (childAt != null && (childAt.getTag() instanceof a.C0172a)) {
                            a.C0172a c0172a = (a.C0172a) childAt.getTag();
                            if (c0172a.aWM != null && (c0172a.aWM.getTag(a.f.TAG_GIFT_ITEM) instanceof g) && (gVar = (g) c0172a.aWM.getTag(a.f.TAG_GIFT_ITEM)) != null && gVar.aSW != null && gVar.aSW.enabled && gVar.aSW.aTc && !TextUtils.isEmpty(gVar.aSW.detailUrl)) {
                                String CC = gVar.CC();
                                if (!com.baidu.live.gift.x.DM().fE(CC)) {
                                    com.baidu.live.gift.x.DM().fF(CC);
                                    AlaGiftTabView.this.b(c0172a.aWM, !TextUtils.isEmpty(gVar.aSW.aTd) ? gVar.aSW.aTd : "长按查看规则");
                                    AnimatorSet a2 = AlaGiftTabView.this.a(absListView, c0172a);
                                    a2.playTogether(AlaGiftTabView.this.R(c0172a.aWH), AlaGiftTabView.this.S(c0172a.aWM));
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
    public AnimatorSet a(final AbsListView absListView, final a.C0172a c0172a) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                if (c0172a != null && c0172a.aWM != null) {
                    c0172a.aWM.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c0172a != null && c0172a.aWM != null) {
                    c0172a.aWM.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c0172a != null) {
                    c0172a.EI();
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
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.baidu.live.gift.container.a.a(), new a.C0173a(), new a.C0173a());
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
                if (view != null && (valueAnimator.getAnimatedValue() instanceof a.C0173a)) {
                    a.C0173a c0173a = (a.C0173a) valueAnimator.getAnimatedValue();
                    view.setScaleX(c0173a.scale);
                    view.setScaleY(c0173a.scale);
                    view.setAlpha(c0173a.aZx);
                }
            }
        });
        return ofObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(List<Animator> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aYU == null) {
                this.aYU = new AnimatorSet();
                this.aYU.setInterpolator(new LinearInterpolator());
            }
            this.aYU.playTogether(list);
            this.aYU.start();
        }
    }

    private void Ff() {
        JSONObject jSONObject = new JSONObject();
        i iVar = (i) ListUtils.getItem(this.aXP, this.aYt);
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

    private void Fg() {
        int i = 0;
        for (int i2 = 0; i2 < this.aYz.size(); i2++) {
            for (int i3 = 0; i3 < this.aYz.get(i2); i3++) {
                if (i + i3 == this.aYr) {
                    if (this.aYz.get(i2) <= 1) {
                        this.aYc.setVisibility(4);
                    } else {
                        this.aYc.setVisibility(0);
                    }
                    this.aYc.setCount(this.aYz.get(i2));
                    this.aYc.onPageSelected(i3);
                    cY(i2);
                    return;
                }
            }
            i += this.aYz.get(i2);
        }
    }

    public g Fh() {
        return this.aYx;
    }

    public int Fi() {
        return this.aYy;
    }

    public void a(e eVar) {
        this.aYq = eVar;
    }

    public void da(int i) {
        this.aYy = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aYY);
        MessageManager.getInstance().registerListener(this.aYZ);
        MessageManager.getInstance().registerListener(this.aZa);
        MessageManager.getInstance().registerListener(this.aZb);
    }

    public void Fj() {
        if (!ListUtils.isEmpty(this.aYn)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aYn) {
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
        if (!ListUtils.isEmpty(this.aYn) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aYn) {
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
    public void Fk() {
        if (!ListUtils.isEmpty(this.aYn)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aYn) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aWF);
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
    public void Fl() {
        if (this.aYx != null && this.aYx.Dd()) {
            this.aXY.setStyleEnabled(this.aWF);
            if (this.aWF) {
                this.aYm.setStyle(this.aYx.CK() ? 2 : 1);
            } else {
                this.aYm.setStyle(this.aYx.CK() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.aYM = null;
        MessageManager.getInstance().unRegisterListener(this.aYY);
        MessageManager.getInstance().unRegisterListener(this.aYZ);
        MessageManager.getInstance().unRegisterListener(this.aZa);
        MessageManager.getInstance().unRegisterListener(this.aZb);
        rh();
        if (this.aYK != null) {
            this.aYK.dismiss();
        }
        if (this.aYU != null) {
            this.aYU.cancel();
        }
    }

    public void bA(boolean z) {
        this.aWz = z;
    }

    public void db(int i) {
        this.aWx = i;
    }

    public void d(g gVar) {
        this.aYx = gVar;
        if (this.aYx.CC().equals("")) {
            BdUtilHelper.showToast(this.mContext.getPageActivity(), "该礼物已下线");
            return;
        }
        this.aYE = Integer.valueOf(this.aYx.CC()).intValue();
        if (this.aYM != null) {
            this.aYM.a(gVar);
        }
        if (gVar != null && !gVar.CM()) {
            this.aYO.EC();
        }
    }

    public void EB() {
        if (this.aYO != null) {
            this.aYO.EB();
        }
        g gVar = this.aYx;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.CC());
                jSONObject.putOpt("gift_name", gVar.CD());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "combosend_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
        }
    }

    public void EA() {
        if (this.aYO != null) {
            this.aYO.EA();
        }
        g gVar = this.aYx;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.CC());
                jSONObject.putOpt("gift_name", gVar.CD());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "combosend_clk").setContentExt(null, null, jSONObject));
        }
    }

    public void bQ(boolean z) {
        if (this.aYm != null) {
            this.aYm.setVisibility(z ? 0 : 4);
        }
    }
}

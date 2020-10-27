package com.baidu.live.yuyingift.container;

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
import com.baidu.live.b.ah;
import com.baidu.live.data.bm;
import com.baidu.live.data.h;
import com.baidu.live.data.j;
import com.baidu.live.data.w;
import com.baidu.live.data.y;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
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
import com.baidu.live.view.input.b;
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
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, b.a {
    private int aJu;
    private int aWH;
    private boolean aWJ;
    private boolean aWP;
    public ArrayList<i> aXW;
    private ArrayList<h> aXX;
    private ArrayList<j> aXY;
    private int aYA;
    private g aYB;
    private int aYC;
    private SparseIntArray aYD;
    private SparseBooleanArray aYE;
    private View.OnClickListener aYF;
    private boolean aYG;
    private int aYH;
    private int aYI;
    private int aYJ;
    private SparseBooleanArray aYK;
    private Set<String> aYL;
    private boolean aYM;
    private BdAlertDialog aYN;
    private int aYO;
    private int aYQ;
    private TbImageView aYS;
    private boolean aYU;
    private boolean aYV;
    private boolean aYW;
    private View.OnClickListener aYZ;
    private final String aYc;
    private boolean aYd;
    private View aYe;
    public TextView aYg;
    private BaseViewPager aYh;
    private RoundRectPageIndicator aYi;
    private HorizontalScrollView aYj;
    private LinearLayout aYk;
    private CommonEmptyView aYl;
    private View aYm;
    private TextView aYo;
    private TextView aYp;
    private TextView aYq;
    private List<View> aYs;
    private ArrayList<List<g>> aYt;
    private int aYv;
    private int aYw;
    private int aYx;
    private boolean aYy;
    private boolean aYz;
    AdapterView.OnItemClickListener aZa;
    private CustomMessageListener aZb;
    private CustomMessageListener aZc;
    private CustomMessageListener aZd;
    private CustomMessageListener aZe;
    private GiftPanelNumRoundRectView bKG;
    private com.baidu.live.yuyingift.container.c bKH;
    public GiftPanelOperationSendView bKI;
    private d bKJ;
    private a bKK;
    private AlaComboBtnAnimView bKL;
    private com.baidu.live.yuyingift.container.d bKM;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private ViewGroup mRoot;
    private int mSelectedPosition;
    private boolean mShowing;
    private int mType;
    private String otherParams;
    private String roomId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(g gVar);

        void as(String str, String str2);

        void c(boolean z, int i);

        void f(boolean z, String str);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void HW();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aYc = "live_key_privilege_tab_unlock_giftid_array_yuyin_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aYs = new ArrayList();
        this.aYv = 0;
        this.aYw = 0;
        this.mSelectedPosition = 0;
        this.aYx = 0;
        this.aYD = new SparseIntArray();
        this.aYE = new SparseBooleanArray();
        this.isLandscape = false;
        this.aYG = false;
        this.aYH = -1;
        this.aYI = -1;
        this.aWJ = false;
        this.aWH = -1;
        this.aYK = new SparseBooleanArray();
        this.aYL = new HashSet();
        this.aYU = false;
        this.aWP = false;
        this.aYV = false;
        this.aYW = false;
        this.aYZ = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.bKL == null || !AlaGiftTabView.this.bKL.Hp()) {
                    if (AlaGiftTabView.this.bKH == null) {
                        AlaGiftTabView.this.bKH = new com.baidu.live.yuyingift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aZa);
                    }
                    AlaGiftTabView.this.bH(true);
                    AlaGiftTabView.this.bKH.a(AlaGiftTabView.this.aYe, AlaGiftTabView.this.aXY, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.11.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bH(false);
                        }
                    });
                }
            }
        };
        this.aZa = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.bKH.dismiss();
                if (AlaGiftTabView.this.aXY != null && AlaGiftTabView.this.aXY.size() > 0) {
                    if (i != AlaGiftTabView.this.aXY.size()) {
                        j jVar = (j) AlaGiftTabView.this.aXY.get(i);
                        if (jVar != null) {
                            int number = jVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (bVar = AlaGiftTabView.this.aYB.aTp) != null) {
                                if (number == -1) {
                                    number = bVar.aTC;
                                }
                                if (number > AlaGiftTabView.this.aYO) {
                                    number = AlaGiftTabView.this.aYO;
                                }
                            }
                            AlaGiftTabView.this.hj(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.HM();
                    return;
                }
                AlaGiftTabView.this.hj("1");
            }
        };
        this.aZb = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    BdLog.e("dynamicgift收到下载状态通知：" + cVar.aRI);
                    if ((cVar.aRI == 1 || cVar.aRI == 2 || cVar.aRI == 5 || cVar.aRI == 6) && cVar.aRJ != null) {
                        AlaGiftTabView.this.au(cVar.aRJ.getId(), cVar.aRJ.getUrl());
                    }
                }
            }
        };
        this.aZc = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bC(true);
                if (AlaGiftTabView.this.aYB != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aYB) && AlaGiftTabView.this.aYd) {
                    AlaGiftTabView.this.bKI.setStyle(AlaGiftTabView.this.aYB.Fy() ? 2 : 1);
                    AlaGiftTabView.this.bKG.setStyleEnabled(true);
                }
            }
        };
        this.aZd = new CustomMessageListener(2501033) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                w wVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && (wVar = (w) customResponsedMessage.getData()) != null && wVar.aIA != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = wVar.aIA.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aWP != z2) {
                        AlaGiftTabView.this.aWP = z2;
                        AlaGiftTabView.this.HV();
                        AlaGiftTabView.this.HU();
                    }
                }
            }
        };
        this.aZe = new CustomMessageListener(2913179) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.HL();
                    AlaGiftTabView.this.bKI.setStyle(AlaGiftTabView.this.aYB.Fy() ? 4 : 3);
                    AlaGiftTabView.this.bKG.setStyleEnabled(false);
                    if (AlaGiftTabView.this.bKK != null) {
                        AlaGiftTabView.this.bKK.f(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aYF = onClickListener;
        this.aYG = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.yuyin_live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aYA = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        this.aYt = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aYO = 9999;
                return;
            case 1:
                this.aYO = 999;
                return;
            default:
                return;
        }
    }

    public void ek(int i) {
        int childCount;
        this.aYQ = i;
        if (this.aYk != null && (childCount = this.aYk.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aYx) {
                    ((GradientTextView) ((ViewGroup) this.aYk.getChildAt(i2)).findViewById(a.g.text_view)).setGradientTextColor(this.aYQ, this.aYQ);
                }
            }
        }
    }

    public void a(a aVar) {
        this.bKK = aVar;
    }

    public void at(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bB(boolean z) {
        this.mShowing = z;
    }

    public void onVisibilityChanged(boolean z) {
        bB(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        this.aYe = this.mRoot.findViewById(a.g.gift_count_layout);
        this.aYe.setOnClickListener(this.aYZ);
        this.bKG = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.aYg = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.aYg.setText("1");
        this.aYC = 1;
        this.aYg.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.aYh = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.aYh.setOnPageChangeListener(this);
        this.aYi = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.aYk = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.aYj = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.aYG) {
            this.aYj.setVisibility(8);
        }
        this.aYo = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.aYo.setOnClickListener(this.aYF);
        this.aYp = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.aYp.setOnClickListener(this.aYF);
        this.bKI = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.aYq = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.aYq.setOnClickListener(this.aYF);
        this.bKI.setOnClickListener(this.aYF);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        frameLayout.setPadding(0, BdUtilHelper.dip2px(this.mContext.getPageActivity(), 48.0f), 0, 0);
        this.aYl = new CommonEmptyView(this.mContext.getPageActivity());
        this.aYl.setVisibility(8);
        this.aYl.addToParent(frameLayout);
        this.aYm = this.mRoot.findViewById(a.g.donate_layout);
        this.bKL = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.bKL.setComboClickListener(this.aYF);
        this.bKL.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.1
            @Override // com.baidu.live.yuyingift.container.AlaComboBtnAnimView.a
            public void Hq() {
                AlaGiftTabView.this.bK(true);
            }
        });
        this.aYS = (TbImageView) this.mRoot.findViewById(a.g.iv_official);
    }

    public void HJ() {
        this.aYM = true;
        this.aYo.setVisibility(8);
        this.aYp.setVisibility(8);
        this.aYq.setVisibility(8);
    }

    public void bC(boolean z) {
        this.aYd = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.z.a.Pq().Pu() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aYq.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aYL.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aYL.add(str);
            }
        }
    }

    public void bb(boolean z) {
    }

    public void dG(int i) {
        this.aYJ = i;
    }

    public void bD(boolean z) {
        this.aYV = z;
        if (z && !ListUtils.isEmpty(this.aXX)) {
            HP();
            this.aYW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y yVar) {
        if (yVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "tycoon_pop_show"));
            if (this.bKM == null) {
                this.bKM = new com.baidu.live.yuyingift.container.d(this.mContext);
            }
            this.bKM.n(yVar.dialogTitle, yVar.aJg + yVar.aJh, yVar.aJh);
        }
    }

    private void Q(View view) {
        if (this.bKM == null) {
            this.bKM = new com.baidu.live.yuyingift.container.d(this.mContext);
        }
        this.bKM.O(view);
    }

    public void bE(boolean z) {
        this.aYU = z;
    }

    public void el(int i) {
        this.aJu = i;
    }

    public void bd(boolean z) {
        this.aWP = z;
    }

    public void bF(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.aYh.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.yuyin_ala_dimen_gift_noble_height) + this.mContext.getResources().getDimensionPixelOffset(a.e.yuyin_ala_dimen_gift_noblr_maginbottom);
                this.aYh.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        private int mPosition;

        public c(int i) {
            this.mPosition = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaGiftTabView.this.em(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void em(int i) {
        if (this.bKK != null) {
            this.bKK.c(false, this.aYO);
        }
        en(i);
        this.aYh.setCurrentItem(this.aYv);
        HQ();
        HK();
    }

    private void en(int i) {
        int min = Math.min(i, this.aYD.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aYD.get(i3);
        }
        this.aYv = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemClickListener {
        private b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            g item = ((com.baidu.live.yuyingift.container.a) adapterView.getAdapter()).getItem(i);
            if (item != null && item.isRed()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ah(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.aYw = AlaGiftTabView.this.aYv;
            AlaGiftTabView.this.a((com.baidu.live.yuyingift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void HK() {
        if (this.bKK != null) {
            if (this.aYB != null && this.aYB.aTq) {
                this.bKK.as(this.aYB.aTr, this.aYB.aTs);
            } else {
                this.bKK.as(null, null);
            }
        }
    }

    public void a(com.baidu.live.yuyingift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.bKK != null) {
            this.bKK.c(false, this.aYO);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.ed(i);
                aVar.notifyDataSetChanged();
                this.aYm.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                hj("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aYB.FP()) {
                        this.bKI.setStyle(this.aYB.Fy() ? 4 : 3);
                        this.bKG.setStyleEnabled(false);
                        if (this.bKK != null) {
                            this.bKK.f(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aYB.FB()) && this.mShowing) {
                            this.mContext.showToast(this.aYB.FB());
                            return;
                        }
                        return;
                    }
                    HK();
                    this.bKI.setEnabled(true);
                    if (this.aYB.FS()) {
                        if (this.bKK != null) {
                            this.bKK.f(false, null);
                        }
                        if (this.aYB.FO() == 6 && this.aWH < 3) {
                            i3 = 3;
                        } else if (this.aYB.FO() == 7 && this.aWH < 7) {
                            i3 = 7;
                        } else if (this.aYB.FO() == 8 && this.aWH < 13) {
                            i3 = 13;
                        } else if (this.aYB.FO() == 9 && this.aWH < 22) {
                            i3 = 22;
                        } else if (this.aYB.FO() == 10 && this.aWH < 29) {
                            i3 = 29;
                        } else if (this.aYB.FO() == 11 && this.aWH < 39) {
                            i3 = 39;
                        } else if (this.aYB.FO() == 12 && this.aWH < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.bKI.setStyle(this.aYB.Fy() ? 2 : 1);
                    } else {
                        this.bKI.setStyle(this.aYB.Fy() ? 4 : 3);
                    }
                    this.bKG.setStyleEnabled(z);
                    HV();
                    i2 = i3;
                } else {
                    this.bKI.setStyle(this.aYB.Fy() ? 2 : 1);
                    if (this.aYB.aTp != null && this.aYB.aTp.aTB != null && this.aYB.aTp.aTB.equals("20")) {
                        this.bKI.setText("使用");
                    } else {
                        this.bKI.setText("赠送");
                    }
                    this.bKG.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aYB.Fz()) {
                    bG(true);
                } else {
                    bG(false);
                    hj("1");
                }
                d(false, i2);
                return;
            }
            this.bKI.setStyle(3);
            return;
        }
        this.bKI.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.b bVar;
        if (this.mShowing && this.aYB != null) {
            if (this.mType == 0) {
                if (this.aYB.FR() && !this.aWP) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aYB.FB()) && this.aYB.FP() && !z) {
                    this.mContext.showToast(this.aYB.FB());
                } else if (this.aYB.FS() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aYB.FN()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (bVar = this.aYB.aTp) != null && !TextUtils.isEmpty(bVar.aTE)) {
                this.mContext.showToast(bVar.aTE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.z.a.Pq().bsy != null && com.baidu.live.z.a.Pq().bsy.aOz != null) {
            String str = com.baidu.live.z.a.Pq().bsy.aOz.aNL;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.FO()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL() {
        if (!this.aYz) {
            this.aYN = new BdAlertDialog(this.mContext.getPageActivity());
            this.aYN.setCancelable(false);
            this.aYN.setCanceledOnTouchOutside(false);
            this.aYN.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.aYN.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aYJ)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aYN.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.aYN.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aYN.setPositiveButtonTextColor(-57754);
                this.aYN.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aYN.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aYz = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aYN.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aYz = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aYN.create(this.mContext).show();
            this.aYz = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.z.a.Pq().bmJ.aKI;
        if (z2) {
            this.aYe.setVisibility(4);
            this.bKI.setStyle(1);
        } else {
            View view = this.aYe;
            if (this.aYB == null || !this.aYB.Fy()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.bKK != null) {
            this.bKK.f(z2, this.aYB != null ? this.aYB.getThumbnail_url() : null);
        }
    }

    public void HM() {
        if (this.bKK != null) {
            this.bKK.c(true, this.aYO);
        }
    }

    @Override // com.baidu.live.view.input.b.a
    public void hg(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        hj(str);
    }

    public void hj(String str) {
        this.aYg.setText(str);
        this.aYg.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        bH(false);
        if (this.aYB != null && this.aYB.Fy()) {
            this.aYe.setVisibility(0);
            this.aYC = JavaTypesHelper.toInt(this.aYg.getText().toString(), 1);
            return;
        }
        this.aYe.setVisibility(4);
        this.aYC = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(boolean z) {
        this.aYg.setGravity(17);
        if (z) {
            this.aYg.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aYg.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<h> arrayList2, ArrayList<j> arrayList3, boolean z2, int i) {
        if (this.aXW == null || this.aXW.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            if (this.aXW == null) {
                this.aXW = new ArrayList<>();
            }
            this.aXW.clear();
            if (arrayList != null) {
                this.aXW.addAll(arrayList);
            }
            this.aXX = arrayList2;
            this.aXY = arrayList3;
            this.aYy = false;
            if (this.aXX == null || this.aXX.isEmpty()) {
                this.aYj.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void A(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aYs != null) {
            for (View view : this.aYs) {
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
                                ((com.baidu.live.yuyingift.container.a) ((GridView) childAt).getAdapter()).A(str, i);
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
        HN();
        if (this.aXW == null || this.aXW.size() <= 0 || !z2) {
            rE();
            if (this.aYi != null) {
                this.aYi.setVisibility(4);
            }
            this.aYm.setVisibility(4);
            this.aYl.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.aYl.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aYl.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.aYl.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.z.a.Pq().bmJ.aMm && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aYl.setTitle(string);
            this.aYl.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.bKJ != null) {
                        AlaGiftTabView.this.bKJ.HW();
                    }
                }
            });
            this.aYl.setVisibility(0);
            return;
        }
        this.aYl.setVisibility(8);
        if (z) {
            m(this.aXX);
        }
        bm bmVar = com.baidu.live.z.a.Pq().bsy;
        if (this.mType == 0 && bmVar != null && bmVar.aOD != null && bmVar.aOD.aQR && !this.aYU && this.aXW.get(0) != null && this.aXW.get(0).FT() != null) {
            List<g> FT = this.aXW.get(0).FT();
            if (FT.size() <= 1 || FT.get(1) == null) {
                z3 = true;
            } else {
                z3 = !FT.get(1).isRed();
            }
            if (!FT.isEmpty() && z3) {
                g gVar = new g();
                gVar.bp(true);
                gVar.setGiftName("发红包");
                FT.add(1, gVar);
            }
        }
        c(this.aXW, z);
        hj("1");
    }

    private void rE() {
        this.aYv = 0;
        this.aYw = 0;
        this.mSelectedPosition = 0;
        this.aYx = 0;
        if (this.aYD != null) {
            this.aYD.clear();
        }
        if (this.aYs != null) {
            this.aYs.clear();
        }
        if (this.aYh != null) {
            this.aYh.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.FS()) {
            if (gVar.FO() == 6 && this.aWH < 3) {
                return false;
            }
            if (gVar.FO() == 7 && this.aWH < 7) {
                return false;
            }
            if (gVar.FO() == 8 && this.aWH < 13) {
                return false;
            }
            if (gVar.FO() == 9 && this.aWH < 22) {
                return false;
            }
            if (gVar.FO() == 10 && this.aWH < 29) {
                return false;
            }
            if (gVar.FO() == 11 && this.aWH < 39) {
                return false;
            }
            if (gVar.FO() == 12 && this.aWH < 47) {
                return false;
            }
        }
        if (gVar.FR()) {
            return this.aWP;
        }
        return true;
    }

    public void b(final y yVar) {
        if (yVar == null || TextUtils.isEmpty(yVar.iconUrl)) {
            this.aYS.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "tycoon_show"));
            this.aYS.setVisibility(0);
            this.aYS.startLoad(yVar.iconUrl, 10, false);
            this.aYS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "tycoon_clk"));
                    AlaGiftTabView.this.a(yVar);
                }
            });
            String str = "key_live_official_tip_yuyin" + currentAccount;
            if (com.baidu.live.d.AZ().getInt(str, 0) == 0 && this.aYV) {
                Q(this.aYS);
                com.baidu.live.d.AZ().putInt(str, 1);
            }
        }
    }

    private void HN() {
        if (ListUtils.getCount(this.aXX) != 0 && ListUtils.getCount(this.aXW) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<h> it = this.aXX.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.DN()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.aXW.iterator();
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
                Iterator<i> it3 = this.aXW.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().FT().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.Fz()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aXX.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aXW.removeAll(arrayList2);
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
        List<g> FT;
        if (arrayList != null) {
            this.aYD.clear();
            this.aYs.clear();
            this.aYh.setAdapter(null);
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
                    if (iVar == null || (FT = iVar.FT()) == null || FT.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aYt.clear();
            ag(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aYs.add(eo(i7));
                    this.aYD.append(i7, 1);
                } else {
                    i iVar2 = arrayList.get(i7);
                    iVar2.getCategoryId();
                    List<g> FT2 = iVar2.FT();
                    if (FT2 == null) {
                        i = 0;
                    } else {
                        i = FT2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aYE.get(i7)) {
                            this.aYs.add(bI(true));
                        } else {
                            this.aYs.add(b(arrayList3, -1, i7));
                        }
                    } else if (FT2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(FT2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(FT2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(FT2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aYt.add(arrayList2);
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
                                    if (gVar == null || gVar.Fs() == null || !gVar.Fs().equals(String.valueOf(this.aYI))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aYs.add(b(arrayList2, i3, i7));
                                this.bKI.removeCallbacks(null);
                                this.bKI.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.17
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aYB != null) {
                                            boolean Fz = AlaGiftTabView.this.aYB.Fz();
                                            AlaGiftTabView.this.bG(Fz);
                                            if (!Fz) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aYB);
                                                if (!c2) {
                                                    AlaGiftTabView.this.bKI.setStyle(AlaGiftTabView.this.aYB.Fy() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.bKI.setStyle(AlaGiftTabView.this.aYB.Fy() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.bKG.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.Fs().equals(String.valueOf(this.aYI))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aYs.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aYs.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.aYD.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aYh.setAdapter(new AlaGiftPagerAdapter(this.aYs));
            HO();
            this.aYh.setCurrentItem(this.aYv);
            HQ();
            if (z && !this.aYW && this.aYV) {
                this.aYW = true;
                HP();
            }
        }
    }

    private void HO() {
        int i = 0;
        if (this.aYI > 0 && !ListUtils.isEmpty(this.aYt)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aYt.size() && !z; i2++) {
                Iterator<g> it = this.aYt.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.Fs() != null && next.Fs().equals(String.valueOf(this.aYI))) {
                        this.aYv = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aJu == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.aYw = this.aYv;
            this.aYt.clear();
        } else if (this.aYH > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aXX.size()) {
                    break;
                }
                h hVar = this.aXX.get(i3);
                if (hVar == null || this.aYH != hVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    en(i3);
                    break;
                }
            }
            this.aYw = this.aYv;
        }
    }

    private void ag(List<i> list) {
        if (list != null && this.aYH > 0 && this.aYI <= 0) {
            for (i iVar : list) {
                if (iVar.getCategoryId() == this.aYH) {
                    List<g> FT = iVar.FT();
                    if (FT != null && !FT.isEmpty() && FT.get(0) != null) {
                        this.aYI = Integer.valueOf(FT.get(0).Fs()).intValue();
                        return;
                    }
                    return;
                }
            }
        }
    }

    private View bI(boolean z) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext.getPageActivity());
        commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        } else {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.bKJ != null) {
                    AlaGiftTabView.this.bKJ.HW();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.yuyingift.container.a aVar = new com.baidu.live.yuyingift.container.a(this.mContext, this.mType);
        aVar.bu(this.aWJ);
        aVar.setGiftItems(list);
        aVar.ec(this.aWH);
        aVar.bd(this.aWP);
        aVar.ed(i);
        if (this.isLandscape) {
            if (this.aYh.getHeight() > 0) {
                aVar.ee(this.aYh.getHeight() / 3);
            } else {
                this.aYh.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.ee(AlaGiftTabView.this.aYh.getHeight() / 3);
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
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.3
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0225a) {
                    ((a.C0225a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout eo(int i) {
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
    private void m(ArrayList<h> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.aYG) {
                this.aYj.setVisibility(0);
            }
            this.aYk.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                h hVar = arrayList.get(i);
                if (!TextUtils.isEmpty(hVar.getCategoryName()) && (this.mType != 0 || (hVar.DN() != null && hVar.DN().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(hVar.getCategoryName());
                    viewGroup.setOnClickListener(new c(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aYA;
                    }
                    if (this.aXW.size() > i && this.aXW.get(i) != null) {
                        for (g gVar : this.aXW.get(i).FT()) {
                            if (gVar != null && gVar.Fx() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aYk.addView(viewGroup, layoutParams);
                }
            }
            ep(this.aYx);
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
    private void ep(int i) {
        int i2;
        JSONArray jSONArray;
        JSONException e;
        List<g> FT;
        int childCount = this.aYk.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aYx != i || !this.aYy) && this.aXX.size() > i && this.aXX.get(i) != null) {
                int min = Math.min(i, this.aYD.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aYD.get(i4);
                }
                if (this.aYs.size() > i3 && this.aXW.size() > i && (this.aYs.get(i3) instanceof ViewGroup)) {
                    this.aYw = i3;
                    i iVar = this.aXW.get(i);
                    if (iVar != null && iVar.FT() != null && !iVar.FT().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aYs.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.yuyingift.container.a aVar = (com.baidu.live.yuyingift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aYy) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aYv) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.mShowing) {
                                        this.aYy = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aXX.size() > i && this.aXX.get(i) != null) {
                int categoryId = this.aXX.get(i).getCategoryId();
                if (!this.aYK.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aYK.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aYk.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.aXW.get(i6);
                if (iVar2.FU()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aYc, "");
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
                                    FT = iVar2.FT();
                                    if (FT != null) {
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
                    FT = iVar2.FT();
                    if (FT != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= FT.size()) {
                                break;
                            }
                            g gVar = FT.get(i9);
                            if (!gVar.FP() && !hashSet.contains(gVar.Fs())) {
                                arrayList.add(gVar.Fs());
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
                                SharedPrefHelper.getInstance().putString(this.aYc, jSONArray.toString());
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
                    if (this.aYQ != 0) {
                        gradientTextView.setGradientTextColor(this.aYQ, this.aYQ);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    eq(i);
                    this.aYx = i;
                    this.aYj.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bJ(false);
                        } else {
                            bJ(true);
                        }
                    } else {
                        bJ(true);
                    }
                }
            }
        }
    }

    private void bJ(boolean z) {
        int i = 8;
        if (this.aYo != null) {
            this.aYo.setVisibility(z ? this.aYM ? 8 : 0 : 8);
        }
        if (this.aYp != null) {
            TextView textView = this.aYp;
            if (!z && !this.aYM) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void eq(int i) {
        int childCount = this.aYk.getChildCount();
        if (i >= 0 && i < childCount && this.aXW != null && this.aXW.size() > i && this.aXW.get(i) != null) {
            this.aYE.get(i);
        }
    }

    public void x(int i, int i2) {
        this.aYH = i;
        this.aYI = i2;
    }

    public void ae(long j) {
        if (this.aYo != null) {
            if (j >= 100 && (this.aWJ || com.baidu.live.z.a.Pq().bmJ.aLG)) {
                this.aYo.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aYo.setText(String.valueOf(j));
        }
    }

    public void af(long j) {
        if (this.aYp != null) {
            this.aYp.setText(String.valueOf(j));
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
        this.aYv = i;
        HQ();
        HK();
        if (i >= 0 && i < this.aYs.size() && (this.aYs.get(i) instanceof ViewGroup)) {
            HP();
            ViewGroup viewGroup = (ViewGroup) this.aYs.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.yuyingift.container.a aVar = (com.baidu.live.yuyingift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aYw) {
                            aVar.ed(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aYw) {
                            aVar.ed(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.aYm.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void HP() {
        JSONObject jSONObject = new JSONObject();
        h hVar = (h) ListUtils.getItem(this.aXX, this.aYx);
        if (hVar != null) {
            try {
                jSONObject.put("tabid", hVar.getCategoryId());
                jSONObject.put("tabname", hVar.getCategoryName());
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "giftpanel_show").setContentExt(null, "giftpanel", jSONObject));
    }

    private void HQ() {
        int i = 0;
        for (int i2 = 0; i2 < this.aYD.size(); i2++) {
            for (int i3 = 0; i3 < this.aYD.get(i2); i3++) {
                if (i + i3 == this.aYv) {
                    if (this.aYD.get(i2) <= 1) {
                        this.aYi.setVisibility(4);
                    } else {
                        this.aYi.setVisibility(0);
                    }
                    this.aYi.setCount(this.aYD.get(i2));
                    this.aYi.onPageSelected(i3);
                    ep(i2);
                    return;
                }
            }
            i += this.aYD.get(i2);
        }
    }

    public g HR() {
        return this.aYB;
    }

    public int HS() {
        return this.aYC;
    }

    public void a(d dVar) {
        this.bKJ = dVar;
    }

    public void er(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.aYC = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aZb);
        MessageManager.getInstance().registerListener(this.aZc);
        MessageManager.getInstance().registerListener(this.aZd);
        MessageManager.getInstance().registerListener(this.aZe);
    }

    public void HT() {
        if (!ListUtils.isEmpty(this.aYs)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aYs) {
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
    public void au(final String str, final String str2) {
        if (!ListUtils.isEmpty(this.aYs) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aYs) {
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
                                        ((com.baidu.live.yuyingift.container.a) gridView.getAdapter()).a(gridView, str, str2);
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
    public void HU() {
        if (!ListUtils.isEmpty(this.aYs)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.10
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aYs) {
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
                                        ((com.baidu.live.yuyingift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aWP);
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
    public void HV() {
        if (this.aYB != null && this.aYB.FR()) {
            this.bKG.setStyleEnabled(this.aWP);
            if (this.aWP) {
                this.bKI.setStyle(this.aYB.Fy() ? 2 : 1);
            } else {
                this.bKI.setStyle(this.aYB.Fy() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.bKK = null;
        MessageManager.getInstance().unRegisterListener(this.aZb);
        MessageManager.getInstance().unRegisterListener(this.aZc);
        MessageManager.getInstance().unRegisterListener(this.aZd);
        MessageManager.getInstance().unRegisterListener(this.aZe);
        rE();
        if (this.aYN != null) {
            this.aYN.dismiss();
        }
    }

    public void bu(boolean z) {
        this.aWJ = z;
    }

    public void es(int i) {
        this.aWH = i;
    }

    public void d(g gVar) {
        this.aYB = gVar;
        this.aYI = Integer.valueOf(this.aYB.Fs()).intValue();
        if (this.bKK != null) {
            this.bKK.a(gVar);
        }
        if (gVar != null && !gVar.FA()) {
            this.bKL.Ho();
        }
    }

    public void Hn() {
        if (this.bKL != null) {
            this.bKL.Hn();
        }
    }

    public void Hm() {
        if (this.bKL != null) {
            this.bKL.Hm();
        }
    }

    public void bK(boolean z) {
        if (this.bKI != null) {
            this.bKI.setVisibility(z ? 0 : 4);
        }
    }
}

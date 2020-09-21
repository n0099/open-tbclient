package com.baidu.live.gift.container;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import com.baidu.live.b.r;
import com.baidu.live.data.bj;
import com.baidu.live.data.u;
import com.baidu.live.data.w;
import com.baidu.live.gift.container.AlaComboBtnAnimView;
import com.baidu.live.gift.container.a;
import com.baidu.live.gift.container.a.a;
import com.baidu.live.gift.g;
import com.baidu.live.gift.i;
import com.baidu.live.gift.s;
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
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.tieba.view.GradientTextView;
import com.baidu.live.view.RoundRectPageIndicator;
import com.baidu.live.view.input.b;
import com.baidu.platform.comapi.map.MapController;
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
    private int aFO;
    private int aSb;
    private boolean aSd;
    private boolean aSj;
    public TextView aTA;
    private BaseViewPager aTB;
    private RoundRectPageIndicator aTC;
    private HorizontalScrollView aTD;
    private LinearLayout aTE;
    private CommonEmptyView aTF;
    private View aTG;
    private com.baidu.live.gift.container.c aTH;
    private TextView aTI;
    private TextView aTJ;
    private TextView aTK;
    public GiftPanelOperationSendView aTL;
    private List<View> aTM;
    private ArrayList<List<g>> aTN;
    private e aTO;
    private int aTP;
    private int aTQ;
    private int aTR;
    private boolean aTS;
    private boolean aTT;
    private int aTU;
    private g aTV;
    private int aTW;
    private SparseIntArray aTX;
    private SparseBooleanArray aTY;
    private View.OnClickListener aTZ;
    public ArrayList<i> aTq;
    private ArrayList<com.baidu.live.data.g> aTr;
    private ArrayList<com.baidu.live.data.i> aTs;
    private final String aTw;
    private boolean aTx;
    private View aTy;
    private GiftPanelNumRoundRectView aTz;
    private boolean aUa;
    private int aUb;
    private int aUc;
    private int aUd;
    private SparseBooleanArray aUe;
    private Set<String> aUf;
    private boolean aUg;
    private BdAlertDialog aUh;
    private int aUi;
    private a aUj;
    private int aUk;
    private AlaComboBtnAnimView aUl;
    private TbImageView aUm;
    private com.baidu.live.gift.container.d aUn;
    private boolean aUo;
    private boolean aUp;
    private boolean aUq;
    private AnimatorSet aUr;
    private View.OnClickListener aUt;
    AdapterView.OnItemClickListener aUu;
    private CustomMessageListener aUv;
    private CustomMessageListener aUw;
    private CustomMessageListener aUx;
    private CustomMessageListener aUy;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private ViewGroup mRoot;
    private int mSelectedPosition;
    private boolean mShowing;
    private int mType;
    private String otherParams;
    private String roomId;
    public static int page = 0;
    public static ArrayList<String> aUs = new ArrayList<>();

    /* loaded from: classes4.dex */
    public interface a {
        void a(g gVar);

        void ao(String str, String str2);

        void c(boolean z, int i);

        void e(boolean z, String str);

        void o(int i, String str);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void GF();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aTw = "live_key_privilege_tab_unlock_giftid_array_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aTM = new ArrayList();
        this.aTP = 0;
        this.aTQ = 0;
        this.mSelectedPosition = 0;
        this.aTR = 0;
        this.aTX = new SparseIntArray();
        this.aTY = new SparseBooleanArray();
        this.isLandscape = false;
        this.aUa = false;
        this.aUb = -1;
        this.aUc = -1;
        this.aSd = false;
        this.aSb = -1;
        this.aUe = new SparseBooleanArray();
        this.aUf = new HashSet();
        this.aUo = false;
        this.aSj = false;
        this.aUp = false;
        this.aUq = false;
        this.aUt = new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aUl == null || !AlaGiftTabView.this.aUl.FX()) {
                    if (AlaGiftTabView.this.aTH == null) {
                        AlaGiftTabView.this.aTH = new com.baidu.live.gift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aUu);
                    }
                    AlaGiftTabView.this.bB(true);
                    AlaGiftTabView.this.aTH.a(AlaGiftTabView.this.aTy, AlaGiftTabView.this.aTs, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.12.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bB(false);
                        }
                    });
                }
            }
        };
        this.aUu = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.17
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.aTH.dismiss();
                if (AlaGiftTabView.this.aTs != null && AlaGiftTabView.this.aTs.size() > 0) {
                    if (i != AlaGiftTabView.this.aTs.size()) {
                        com.baidu.live.data.i iVar = (com.baidu.live.data.i) AlaGiftTabView.this.aTs.get(i);
                        if (iVar != null) {
                            int number = iVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (bVar = AlaGiftTabView.this.aTV.aPi) != null) {
                                if (number == -1) {
                                    number = bVar.aPv;
                                }
                                if (number > AlaGiftTabView.this.aUi) {
                                    number = AlaGiftTabView.this.aUi;
                                }
                            }
                            AlaGiftTabView.this.gK(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.Gv();
                    return;
                }
                AlaGiftTabView.this.gK("1");
            }
        };
        this.aUv = new CustomMessageListener(2913078) { // from class: com.baidu.live.gift.container.AlaGiftTabView.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if ((cVar.aNJ == 1 || cVar.aNJ == 2 || cVar.aNJ == 5 || cVar.aNJ == 6) && cVar.aNK != null) {
                        AlaGiftTabView.this.aq(cVar.aNK.getId(), cVar.aNK.getUrl());
                    }
                }
            }
        };
        this.aUw = new CustomMessageListener(2913120) { // from class: com.baidu.live.gift.container.AlaGiftTabView.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bw(true);
                if (AlaGiftTabView.this.aTV != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aTV) && AlaGiftTabView.this.aTx) {
                    AlaGiftTabView.this.aTL.setStyle(AlaGiftTabView.this.aTV.En() ? 2 : 1);
                    AlaGiftTabView.this.aTz.setStyleEnabled(true);
                }
            }
        };
        this.aUx = new CustomMessageListener(2913082) { // from class: com.baidu.live.gift.container.AlaGiftTabView.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                u uVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof u) && (uVar = (u) customResponsedMessage.getData()) != null && uVar.aFb != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = uVar.aFb.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aSj != z2) {
                        AlaGiftTabView.this.aSj = z2;
                        AlaGiftTabView.this.GE();
                        AlaGiftTabView.this.GD();
                    }
                }
            }
        };
        this.aUy = new CustomMessageListener(2913179) { // from class: com.baidu.live.gift.container.AlaGiftTabView.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.Gu();
                    AlaGiftTabView.this.aTL.setStyle(AlaGiftTabView.this.aTV.En() ? 4 : 3);
                    AlaGiftTabView.this.aTz.setStyleEnabled(false);
                    if (AlaGiftTabView.this.aUj != null) {
                        AlaGiftTabView.this.aUj.e(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aTZ = onClickListener;
        this.aUa = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aTU = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.e.sdk_ds36);
        this.aTN = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.aUi = 9999;
                return;
            case 1:
                this.aUi = 999;
                return;
            default:
                return;
        }
    }

    public void ee(int i) {
        int childCount;
        this.aUk = i;
        if (this.aTE != null && (childCount = this.aTE.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aTR) {
                    ((GradientTextView) ((ViewGroup) this.aTE.getChildAt(i2)).findViewById(a.g.text_view)).setGradientTextColor(this.aUk, this.aUk);
                }
            }
        }
    }

    public void a(a aVar) {
        this.aUj = aVar;
    }

    public void ap(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bv(boolean z) {
        this.mShowing = z;
    }

    public void onVisibilityChanged(boolean z) {
        bv(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        this.aTy = this.mRoot.findViewById(a.g.gift_count_layout);
        this.aTy.setOnClickListener(this.aUt);
        this.aTz = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.g.gift_count_round);
        this.aTA = (TextView) this.mRoot.findViewById(a.g.gift_count_input);
        this.aTA.setText("1");
        this.aTA.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_fontsize24));
        this.aTB = (BaseViewPager) this.mRoot.findViewById(a.g.gift_viewpager);
        this.aTB.setOnPageChangeListener(this);
        this.aTC = (RoundRectPageIndicator) this.mRoot.findViewById(a.g.gift_tab_indicator);
        this.aTE = (LinearLayout) this.mRoot.findViewById(a.g.gift_tab_layout);
        this.aTD = (HorizontalScrollView) this.mRoot.findViewById(a.g.gift_tab_scrollview);
        if (this.aUa) {
            this.aTD.setVisibility(8);
        }
        this.aTI = (TextView) this.mRoot.findViewById(a.g.current_money);
        this.aTI.setOnClickListener(this.aTZ);
        this.aTJ = (TextView) this.mRoot.findViewById(a.g.current_flower);
        this.aTJ.setOnClickListener(this.aTZ);
        this.aTL = (GiftPanelOperationSendView) this.mRoot.findViewById(a.g.donate);
        this.aTK = (TextView) this.mRoot.findViewById(a.g.current_recharge);
        this.aTK.setOnClickListener(this.aTZ);
        this.aTL.setOnClickListener(this.aTZ);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.g.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        this.aTF = new CommonEmptyView(this.mContext.getPageActivity());
        this.aTF.setVisibility(8);
        this.aTF.addToParent(frameLayout);
        this.aTG = this.mRoot.findViewById(a.g.donate_layout);
        this.aUl = (AlaComboBtnAnimView) this.mRoot.findViewById(a.g.combo_layout);
        this.aUl.setComboClickListener(this.aTZ);
        this.aUl.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.gift.container.AlaGiftTabView.1
            @Override // com.baidu.live.gift.container.AlaComboBtnAnimView.a
            public void FY() {
                AlaGiftTabView.this.bE(true);
            }
        });
        this.aUm = (TbImageView) this.mRoot.findViewById(a.g.iv_official);
    }

    public void Gs() {
        this.aUg = true;
        this.aTI.setVisibility(8);
        this.aTJ.setVisibility(8);
        this.aTK.setVisibility(8);
    }

    public void bw(boolean z) {
        this.aTx = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.x.a.NN().NQ() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aTK.setText(this.mContext.getPageActivity().getString(a.i.first_recharge_text));
            if (!this.aUf.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.aUf.add(str);
            }
        }
    }

    public void aW(boolean z) {
    }

    public void dB(int i) {
        this.aUd = i;
    }

    public void bx(boolean z) {
        this.aUp = z;
        if (!z && this.aUr != null) {
            this.aUr.cancel();
        }
        if (z && !ListUtils.isEmpty(this.aTr)) {
            Gy();
            this.aUq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar) {
        if (wVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_pop_show"));
            if (this.aUn == null) {
                this.aUn = new com.baidu.live.gift.container.d(this.mContext);
            }
            this.aUn.n(wVar.dialogTitle, wVar.aFB + wVar.aFC, wVar.aFC);
        }
    }

    private void Q(View view) {
        if (this.aUn == null) {
            this.aUn = new com.baidu.live.gift.container.d(this.mContext);
        }
        this.aUn.O(view);
    }

    public void by(boolean z) {
        this.aUo = z;
    }

    public void ef(int i) {
        this.aFO = i;
    }

    public void aY(boolean z) {
        this.aSj = z;
    }

    public void bz(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.aTB.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds72) + this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds24);
                this.aTB.setLayoutParams(layoutParams);
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
            AlaGiftTabView.this.eg(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eg(int i) {
        if (this.aUj != null) {
            this.aUj.c(false, this.aUi);
        }
        eh(i);
        this.aTB.setCurrentItem(this.aTP);
        Gz();
        Gt();
    }

    private void eh(int i) {
        int min = Math.min(i, this.aTX.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aTX.get(i3);
        }
        this.aTP = i2;
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
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(AlaGiftTabView.this.mContext, AlaGiftTabView.this.liveId, AlaGiftTabView.this.roomId)));
                AlaGiftTabView.this.mContext.getPageActivity().finish();
                return;
            }
            AlaGiftTabView.this.aTQ = AlaGiftTabView.this.aTP;
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
            if (item != null && item.aPm != null && item.aPm.enabled && !TextUtils.isEmpty(item.aPm.detailUrl) && AlaGiftTabView.this.aUj != null) {
                AlaGiftTabView.this.aUj.o(item.aPm.aPs, item.aPm.detailUrl);
            }
            return false;
        }
    }

    private void Gt() {
        if (this.aUj != null) {
            if (this.aTV != null && this.aTV.aPj) {
                this.aUj.ao(this.aTV.aPk, this.aTV.aPl);
            } else {
                this.aUj.ao(null, null);
            }
        }
    }

    public void a(com.baidu.live.gift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.aUj != null) {
            this.aUj.c(false, this.aUi);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.dX(i);
                aVar.notifyDataSetChanged();
                this.aTG.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                gK("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aTV.EE()) {
                        this.aTL.setStyle(this.aTV.En() ? 4 : 3);
                        this.aTz.setStyleEnabled(false);
                        if (this.aUj != null) {
                            this.aUj.e(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aTV.Eq()) && this.mShowing) {
                            this.mContext.showToast(this.aTV.Eq());
                            return;
                        }
                        return;
                    }
                    Gt();
                    this.aTL.setEnabled(true);
                    if (this.aTV.EH()) {
                        if (this.aUj != null) {
                            this.aUj.e(false, null);
                        }
                        if (this.aTV.ED() == 6 && this.aSb < 3) {
                            i3 = 3;
                        } else if (this.aTV.ED() == 7 && this.aSb < 7) {
                            i3 = 7;
                        } else if (this.aTV.ED() == 8 && this.aSb < 13) {
                            i3 = 13;
                        } else if (this.aTV.ED() == 9 && this.aSb < 22) {
                            i3 = 22;
                        } else if (this.aTV.ED() == 10 && this.aSb < 29) {
                            i3 = 29;
                        } else if (this.aTV.ED() == 11 && this.aSb < 39) {
                            i3 = 39;
                        } else if (this.aTV.ED() == 12 && this.aSb < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.aTL.setStyle(this.aTV.En() ? 2 : 1);
                    } else {
                        this.aTL.setStyle(this.aTV.En() ? 4 : 3);
                    }
                    this.aTz.setStyleEnabled(z);
                    GE();
                    i2 = i3;
                } else {
                    this.aTL.setStyle(this.aTV.En() ? 2 : 1);
                    if (this.aTV.aPi != null && this.aTV.aPi.aPu != null && this.aTV.aPi.aPu.equals("20")) {
                        this.aTL.setText("使用");
                    } else {
                        this.aTL.setText("赠送");
                    }
                    this.aTz.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aTV.Eo()) {
                    bA(true);
                } else {
                    bA(false);
                    gK("1");
                }
                d(false, i2);
                return;
            }
            this.aTL.setStyle(3);
            return;
        }
        this.aTL.setStyle(3);
    }

    private void d(boolean z, int i) {
        if (this.mShowing && this.aTV != null) {
            if (this.mType == 0) {
                if (this.aTV.EG() && !this.aSj) {
                    this.mContext.showToast(a.i.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aTV.Eq()) && this.aTV.EE() && !z) {
                    this.mContext.showToast(this.aTV.Eq());
                } else if (this.aTV.EH() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.i.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aTV.EC()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.i.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1) {
                g.b bVar = this.aTV.aPi;
                if (bVar != null && !TextUtils.isEmpty(bVar.aPx)) {
                    this.mContext.showToast(bVar.aPx);
                } else if (!TextUtils.isEmpty(this.aTV.Eq())) {
                    BdUtilHelper.showToast(this.mContext.getPageActivity(), this.aTV.Eq());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.x.a.NN().bmW != null && com.baidu.live.x.a.NN().bmW.aKP != null) {
            String str = com.baidu.live.x.a.NN().bmW.aKP.aKb;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.ED()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gu() {
        if (!this.aTT) {
            this.aUh = new BdAlertDialog(this.mContext.getPageActivity());
            this.aUh.setCancelable(false);
            this.aUh.setCanceledOnTouchOutside(false);
            this.aUh.setTitle(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_title));
            this.aUh.setMessage(String.format(this.mContext.getPageActivity().getString(a.i.need_join_guard_club_content), Integer.valueOf(this.aUd)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.aUh.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                this.aUh.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                this.aUh.setPositiveButtonTextColor(-57754);
                this.aUh.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.aUh.setPositiveButton(this.mContext.getPageActivity().getString(a.i.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aTT = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aUh.setNegativeButton(this.mContext.getPageActivity().getString(a.i.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.19
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aTT = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aUh.create(this.mContext).show();
            this.aTT = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.x.a.NN().bhy.aHc;
        if (z2) {
            this.aTy.setVisibility(4);
            this.aTL.setStyle(1);
        } else {
            View view = this.aTy;
            if (this.aTV == null || !this.aTV.En()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.aUj != null) {
            this.aUj.e(z2, this.aTV != null ? this.aTV.getThumbnail_url() : null);
        }
    }

    public void Gv() {
        if (this.aUj != null) {
            this.aUj.c(true, this.aUi);
        }
    }

    @Override // com.baidu.live.view.input.b.a
    public void gH(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        gK(str);
    }

    public void gK(String str) {
        this.aTA.setText(str);
        this.aTA.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.e.sdk_fontsize20 : a.e.sdk_fontsize24));
        bB(false);
        if (this.aTV != null && this.aTV.En()) {
            this.aTy.setVisibility(0);
            this.aTW = JavaTypesHelper.toInt(this.aTA.getText().toString(), 1);
            return;
        }
        this.aTy.setVisibility(4);
        this.aTW = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        this.aTA.setGravity(17);
        if (z) {
            this.aTA.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aTA.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.f.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<i> arrayList, ArrayList<com.baidu.live.data.g> arrayList2, ArrayList<com.baidu.live.data.i> arrayList3, boolean z2, int i) {
        if (this.aTq == null || this.aTq.isEmpty()) {
            if (this.aTq == null) {
                this.aTq = new ArrayList<>();
            }
            this.aTq.clear();
            if (arrayList != null) {
                this.aTq.addAll(arrayList);
            }
            this.aTr = arrayList2;
            this.aTs = arrayList3;
            this.aTS = false;
            if (this.aTr == null || this.aTr.isEmpty()) {
                this.aTD.setVisibility(8);
            }
            a(z, z2, i);
            onPageSelected(this.aTB.getCurrentItem());
        }
    }

    public void A(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aTM != null) {
            for (View view : this.aTM) {
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
        Gw();
        if (this.aTq == null || this.aTq.size() <= 0 || !z2) {
            rE();
            if (this.aTC != null) {
                this.aTC.setVisibility(4);
            }
            this.aTG.setVisibility(4);
            this.aTF.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                this.aTF.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aTF.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.i.sdk_net_no);
                this.aTF.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.x.a.NN().bhy.aIE && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aTF.setTitle(string);
            this.aTF.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.aTO != null) {
                        AlaGiftTabView.this.aTO.GF();
                    }
                }
            });
            this.aTF.setVisibility(0);
            return;
        }
        this.aTF.setVisibility(8);
        if (z) {
            m(this.aTr);
        }
        bj bjVar = com.baidu.live.x.a.NN().bmW;
        if (this.mType == 0 && bjVar != null && bjVar.aKT != null && bjVar.aKT.aNc && !this.aUo && this.aTq.get(0) != null && this.aTq.get(0).EI() != null) {
            List<g> EI = this.aTq.get(0).EI();
            if (EI.size() <= 1 || EI.get(1) == null) {
                z3 = true;
            } else {
                z3 = !EI.get(1).isRed();
            }
            if (!EI.isEmpty() && z3) {
                g gVar = new g();
                gVar.bj(true);
                gVar.setGiftName("发红包");
                EI.add(1, gVar);
            }
        }
        c(this.aTq, z);
        gK("1");
    }

    private void rE() {
        this.aTP = 0;
        this.aTQ = 0;
        this.mSelectedPosition = 0;
        this.aTR = 0;
        if (this.aTX != null) {
            this.aTX.clear();
        }
        if (this.aTM != null) {
            this.aTM.clear();
        }
        if (this.aTB != null) {
            this.aTB.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.EH()) {
            if (gVar.ED() == 6 && this.aSb < 3) {
                return false;
            }
            if (gVar.ED() == 7 && this.aSb < 7) {
                return false;
            }
            if (gVar.ED() == 8 && this.aSb < 13) {
                return false;
            }
            if (gVar.ED() == 9 && this.aSb < 22) {
                return false;
            }
            if (gVar.ED() == 10 && this.aSb < 29) {
                return false;
            }
            if (gVar.ED() == 11 && this.aSb < 39) {
                return false;
            }
            if (gVar.ED() == 12 && this.aSb < 47) {
                return false;
            }
        }
        if (gVar.EG()) {
            return this.aSj;
        }
        return true;
    }

    public void b(final w wVar) {
        if (wVar == null || TextUtils.isEmpty(wVar.iconUrl)) {
            this.aUm.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "tycoon_show"));
            this.aUm.setVisibility(0);
            this.aUm.startLoad(wVar.iconUrl, 10, false);
            this.aUm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "tycoon_clk"));
                    AlaGiftTabView.this.a(wVar);
                }
            });
            String str = "key_live_official_tip" + currentAccount;
            if (com.baidu.live.c.AR().getInt(str, 0) == 0 && this.aUp) {
                Q(this.aUm);
                com.baidu.live.c.AR().putInt(str, 1);
            }
        }
    }

    private void Gw() {
        if (ListUtils.getCount(this.aTr) != 0 && ListUtils.getCount(this.aTq) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.g> it = this.aTr.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.g next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.CJ()) == 0))) {
                    arrayList.add(next);
                    Iterator<i> it2 = this.aTq.iterator();
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
                Iterator<i> it3 = this.aTq.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().EI().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.Eo()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aTr.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aTq.removeAll(arrayList2);
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
        List<g> EI;
        if (arrayList != null) {
            this.aTX.clear();
            this.aTM.clear();
            this.aTB.setAdapter(null);
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
                    if (iVar == null || (EI = iVar.EI()) == null || EI.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aTN.clear();
            I(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aTM.add(ei(i7));
                    this.aTX.append(i7, 1);
                } else {
                    i iVar2 = arrayList.get(i7);
                    iVar2.getCategoryId();
                    List<g> EI2 = iVar2.EI();
                    if (EI2 == null) {
                        i = 0;
                    } else {
                        i = EI2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aTY.get(i7)) {
                            this.aTM.add(bC(true));
                        } else {
                            this.aTM.add(b(arrayList3, -1, i7));
                        }
                    } else if (EI2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(EI2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(EI2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(EI2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aTN.add(arrayList2);
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
                                    if (gVar == null || gVar.Eh() == null || !gVar.Eh().equals(String.valueOf(this.aUc))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aTM.add(b(arrayList2, i3, i7));
                                this.aTL.removeCallbacks(null);
                                this.aTL.postDelayed(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.22
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aTV != null) {
                                            boolean Eo = AlaGiftTabView.this.aTV.Eo();
                                            AlaGiftTabView.this.bA(Eo);
                                            if (!Eo) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aTV);
                                                if (!c2) {
                                                    AlaGiftTabView.this.aTL.setStyle(AlaGiftTabView.this.aTV.En() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.aTL.setStyle(AlaGiftTabView.this.aTV.En() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.aTz.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.Eh().equals(String.valueOf(this.aUc))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aTM.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aTM.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.aTX.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aTB.setAdapter(new AlaGiftPagerAdapter(this.aTM));
            Gx();
            this.aTB.setCurrentItem(this.aTP);
            Gz();
            if (z && !this.aUq && this.aUp) {
                this.aUq = true;
                Gy();
            }
        }
    }

    private void Gx() {
        int i = 0;
        if (this.aUc > 0 && !ListUtils.isEmpty(this.aTN)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aTN.size() && !z; i2++) {
                Iterator<g> it = this.aTN.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.Eh() != null && next.Eh().equals(String.valueOf(this.aUc))) {
                        this.aTP = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aFO == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.i.ala_not_find_gift_toast);
            }
            this.aTQ = this.aTP;
            this.aTN.clear();
        } else if (this.aUb > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aTr.size()) {
                    break;
                }
                com.baidu.live.data.g gVar = this.aTr.get(i3);
                if (gVar == null || this.aUb != gVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    eh(i3);
                    break;
                }
            }
            this.aTQ = this.aTP;
        }
    }

    private void I(List<i> list) {
        if (list != null && this.aUb > 0 && this.aUc <= 0) {
            for (i iVar : list) {
                if (iVar.getCategoryId() == this.aUb) {
                    List<g> EI = iVar.EI();
                    if (EI != null && !EI.isEmpty() && EI.get(0) != null) {
                        this.aUc = Integer.valueOf(EI.get(0).Eh()).intValue();
                        return;
                    }
                    return;
                }
            }
        }
    }

    private View bC(boolean z) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        CommonEmptyView commonEmptyView = new CommonEmptyView(this.mContext.getPageActivity());
        commonEmptyView.setTitle(a.i.sdk_net_fail_tip_rank);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        } else {
            commonEmptyView.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        commonEmptyView.setRefreshButton(a.i.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.aTO != null) {
                    AlaGiftTabView.this.aTO.GF();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.gift.container.a aVar = new com.baidu.live.gift.container.a(this.mContext, this.mType);
        aVar.bo(this.aSd);
        aVar.setGiftItems(list);
        aVar.dW(this.aSb);
        aVar.aY(this.aSj);
        aVar.dX(i);
        if (this.isLandscape) {
            if (this.aTB.getHeight() > 0) {
                aVar.dY(this.aTB.getHeight() / 3);
            } else {
                this.aTB.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.dY(AlaGiftTabView.this.aTB.getHeight() / 3);
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
        bdGridView.setOnItemLongClickListener(new c());
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.3
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0174a) {
                    ((a.C0174a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout ei(int i) {
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
    private void m(ArrayList<com.baidu.live.data.g> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.aUa) {
                this.aTD.setVisibility(0);
            }
            this.aTE.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.g gVar = arrayList.get(i);
                if (!TextUtils.isEmpty(gVar.getCategoryName()) && (this.mType != 0 || (gVar.CJ() != null && gVar.CJ().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.g.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(gVar.getCategoryName());
                    viewGroup.setOnClickListener(new d(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aTU;
                    }
                    if (this.aTq.size() > i && this.aTq.get(i) != null) {
                        for (g gVar2 : this.aTq.get(i).EI()) {
                            if (gVar2 != null && gVar2.Em() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aTE.addView(viewGroup, layoutParams);
                }
            }
            ej(this.aTR);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e0  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void ej(int i) {
        int i2;
        JSONArray jSONArray;
        JSONException e2;
        List<g> EI;
        int childCount = this.aTE.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aTR != i || !this.aTS) && this.aTr.size() > i && this.aTr.get(i) != null) {
                int min = Math.min(i, this.aTX.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aTX.get(i4);
                }
                if (this.aTM.size() > i3 && this.aTq.size() > i && (this.aTM.get(i3) instanceof ViewGroup)) {
                    this.aTQ = i3;
                    i iVar = this.aTq.get(i);
                    if (iVar != null && iVar.EI() != null && !iVar.EI().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aTM.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aTS) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aTP) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.mShowing) {
                                        this.aTS = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aTr.size() > i && this.aTr.get(i) != null) {
                int categoryId = this.aTr.get(i).getCategoryId();
                if (!this.aUe.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.aUe.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aTE.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.g.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.g.icon_new_unlock_gift);
                imageView.setVisibility(8);
                i iVar2 = this.aTq.get(i6);
                if (iVar2.EJ() || iVar2.getCategoryId() == 20) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aTw, "");
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
                                    EI = iVar2.EI();
                                    if (EI != null) {
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
                    EI = iVar2.EI();
                    if (EI != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= EI.size()) {
                                break;
                            }
                            g gVar = EI.get(i9);
                            if (!gVar.EE() && !hashSet.contains(gVar.Eh())) {
                                arrayList.add(gVar.Eh());
                            }
                            i8 = i9 + 1;
                        }
                        if (!arrayList.isEmpty()) {
                            if (i6 != i) {
                                if (iVar2.getCategoryId() == 20 && !aUs.containsAll(arrayList)) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2913228, true));
                                    aUs.addAll(arrayList);
                                }
                                imageView.setVisibility(0);
                            } else {
                                if (jSONArray2 == null) {
                                    jSONArray2 = new JSONArray();
                                }
                                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                                    jSONArray2.put(arrayList.get(i10));
                                }
                                SharedPrefHelper.getInstance().putString(this.aTw, jSONArray2.toString());
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
                    if (this.aUk != 0) {
                        gradientTextView.setGradientTextColor(this.aUk, this.aUk);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    ek(i);
                    this.aTR = i;
                    this.aTD.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bD(false);
                        } else {
                            bD(true);
                        }
                    } else {
                        bD(true);
                    }
                }
            }
        }
    }

    private void bD(boolean z) {
        int i = 8;
        if (this.aTI != null) {
            this.aTI.setVisibility(z ? this.aUg ? 8 : 0 : 8);
        }
        if (this.aTJ != null) {
            TextView textView = this.aTJ;
            if (!z && !this.aUg) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void ek(int i) {
        int childCount = this.aTE.getChildCount();
        if (i >= 0 && i < childCount && this.aTq != null && this.aTq.size() > i && this.aTq.get(i) != null) {
            this.aTY.get(i);
        }
    }

    public void x(int i, int i2) {
        this.aUb = i;
        this.aUc = i2;
    }

    public void ab(long j) {
        if (this.aTI != null) {
            if (j >= 100 && (this.aSd || com.baidu.live.x.a.NN().bhy.aHY)) {
                this.aTI.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aTI.setText(String.valueOf(j));
        }
    }

    public void ac(long j) {
        if (this.aTJ != null) {
            this.aTJ.setText(String.valueOf(j));
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
        this.aTP = i;
        Gz();
        Gt();
        if (i >= 0 && i < this.aTM.size() && (this.aTM.get(i) instanceof ViewGroup)) {
            Gy();
            ViewGroup viewGroup = (ViewGroup) this.aTM.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.gift.container.a aVar = (com.baidu.live.gift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aTQ) {
                            aVar.dX(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aTQ) {
                            aVar.dX(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        a(gridView);
                        this.aTG.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void a(final AbsListView absListView) {
        if (this.aUr != null) {
            this.aUr.cancel();
        }
        if (absListView != null) {
            absListView.post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.4
                @Override // java.lang.Runnable
                public void run() {
                    g gVar;
                    ArrayList arrayList = null;
                    int childCount = absListView.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = absListView.getChildAt(i);
                        if (childAt != null && (childAt.getTag() instanceof a.C0174a)) {
                            a.C0174a c0174a = (a.C0174a) childAt.getTag();
                            if (c0174a.aSq != null && (c0174a.aSq.getTag(a.g.TAG_GIFT_ITEM) instanceof g) && (gVar = (g) c0174a.aSq.getTag(a.g.TAG_GIFT_ITEM)) != null && gVar.aPm != null && gVar.aPm.enabled && gVar.aPm.aPq && !TextUtils.isEmpty(gVar.aPm.detailUrl)) {
                                String Eh = gVar.Eh();
                                if (!s.Fi().gn(Eh)) {
                                    s.Fi().go(Eh);
                                    AlaGiftTabView.this.a(c0174a.aSq, !TextUtils.isEmpty(gVar.aPm.aPr) ? gVar.aPm.aPr : "长按查看规则");
                                    AnimatorSet a2 = AlaGiftTabView.this.a(absListView, c0174a);
                                    a2.playTogether(AlaGiftTabView.this.R(c0174a.aSl), AlaGiftTabView.this.S(c0174a.aSq));
                                    ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                                    arrayList2.add(a2);
                                    arrayList = arrayList2;
                                }
                            }
                        }
                    }
                    AlaGiftTabView.this.J(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-39424);
        gradientDrawable.setCornerRadius(textView.getResources().getDimensionPixelOffset(a.e.sdk_ds24));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimatorSet a(final AbsListView absListView, final a.C0174a c0174a) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaGiftTabView.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                if (c0174a != null && c0174a.aSq != null) {
                    c0174a.aSq.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c0174a != null && c0174a.aSq != null) {
                    c0174a.aSq.setVisibility(4);
                }
                if (absListView != null && (absListView.getAdapter() instanceof BaseAdapter)) {
                    ((BaseAdapter) absListView.getAdapter()).notifyDataSetChanged();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c0174a != null) {
                    c0174a.Gb();
                }
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator R(final View view) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.baidu.live.gift.container.a.b(), Float.valueOf(0.0f), Float.valueOf(1.0f));
        ofObject.setDuration(1250L);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.6
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
        ValueAnimator ofObject = ValueAnimator.ofObject(new com.baidu.live.gift.container.a.a(), new a.C0175a(), new a.C0175a());
        ofObject.setDuration(3541L);
        ofObject.setStartDelay(1000L);
        ofObject.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.gift.container.AlaGiftTabView.7
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
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.gift.container.AlaGiftTabView.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view != null && (valueAnimator.getAnimatedValue() instanceof a.C0175a)) {
                    a.C0175a c0175a = (a.C0175a) valueAnimator.getAnimatedValue();
                    view.setScaleX(c0175a.scale);
                    view.setScaleY(c0175a.scale);
                    view.setAlpha(c0175a.alpha);
                }
            }
        });
        return ofObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(List<Animator> list) {
        if (list != null && !list.isEmpty()) {
            if (this.aUr == null) {
                this.aUr = new AnimatorSet();
                this.aUr.setInterpolator(new LinearInterpolator());
            }
            this.aUr.playTogether(list);
            this.aUr.start();
        }
    }

    private void Gy() {
        JSONObject jSONObject = new JSONObject();
        com.baidu.live.data.g gVar = (com.baidu.live.data.g) ListUtils.getItem(this.aTr, this.aTR);
        if (gVar != null) {
            try {
                jSONObject.put("tabid", gVar.getCategoryId());
                jSONObject.put("tabname", gVar.getCategoryName());
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "giftpanel_show").setContentExt(null, "giftpanel", jSONObject));
    }

    private void Gz() {
        int i = 0;
        for (int i2 = 0; i2 < this.aTX.size(); i2++) {
            for (int i3 = 0; i3 < this.aTX.get(i2); i3++) {
                if (i + i3 == this.aTP) {
                    if (this.aTX.get(i2) <= 1) {
                        this.aTC.setVisibility(4);
                    } else {
                        this.aTC.setVisibility(0);
                    }
                    this.aTC.setCount(this.aTX.get(i2));
                    this.aTC.onPageSelected(i3);
                    ej(i2);
                    return;
                }
            }
            i += this.aTX.get(i2);
        }
    }

    public g GA() {
        return this.aTV;
    }

    public int GB() {
        return this.aTW;
    }

    public void a(e eVar) {
        this.aTO = eVar;
    }

    public void el(int i) {
        this.aTW = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.aUv);
        MessageManager.getInstance().registerListener(this.aUw);
        MessageManager.getInstance().registerListener(this.aUx);
        MessageManager.getInstance().registerListener(this.aUy);
    }

    public void GC() {
        if (!ListUtils.isEmpty(this.aTM)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.14
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aTM) {
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
        if (!ListUtils.isEmpty(this.aTM) && !TextUtils.isEmpty(str)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.15
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aTM) {
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
        if (!ListUtils.isEmpty(this.aTM)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.gift.container.AlaGiftTabView.16
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aTM) {
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
                                        ((com.baidu.live.gift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aSj);
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
        if (this.aTV != null && this.aTV.EG()) {
            this.aTz.setStyleEnabled(this.aSj);
            if (this.aSj) {
                this.aTL.setStyle(this.aTV.En() ? 2 : 1);
            } else {
                this.aTL.setStyle(this.aTV.En() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.aUj = null;
        MessageManager.getInstance().unRegisterListener(this.aUv);
        MessageManager.getInstance().unRegisterListener(this.aUw);
        MessageManager.getInstance().unRegisterListener(this.aUx);
        MessageManager.getInstance().unRegisterListener(this.aUy);
        rE();
        if (this.aUh != null) {
            this.aUh.dismiss();
        }
        if (this.aUr != null) {
            this.aUr.cancel();
        }
    }

    public void bo(boolean z) {
        this.aSd = z;
    }

    public void em(int i) {
        this.aSb = i;
    }

    public void d(g gVar) {
        this.aTV = gVar;
        if (this.aTV.Eh().equals("")) {
            BdUtilHelper.showToast(this.mContext.getPageActivity(), "该礼物已下线");
            return;
        }
        this.aUc = Integer.valueOf(this.aTV.Eh()).intValue();
        if (this.aUj != null) {
            this.aUj.a(gVar);
        }
        if (gVar != null && !gVar.Ep()) {
            this.aUl.FW();
        }
    }

    public void FV() {
        if (this.aUl != null) {
            this.aUl.FV();
        }
        g gVar = this.aTV;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Eh());
                jSONObject.putOpt("gift_name", gVar.Ei());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "combosend_show").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
        }
    }

    public void FU() {
        if (this.aUl != null) {
            this.aUl.FU();
        }
        g gVar = this.aTV;
        if (gVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(LogConfig.LOG_GIFT_ID, gVar.Eh());
                jSONObject.putOpt("gift_name", gVar.Ei());
                jSONObject.putOpt(LogConfig.LOG_GIFT_VALUE, gVar.getPrice());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "click", "liveroom", "combosend_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
        }
    }

    public void bE(boolean z) {
        if (this.aTL != null) {
            this.aTL.setVisibility(z ? 0 : 4);
        }
    }
}

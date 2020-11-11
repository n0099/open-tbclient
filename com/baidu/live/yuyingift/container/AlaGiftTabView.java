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
import com.baidu.live.data.bn;
import com.baidu.live.data.j;
import com.baidu.live.data.w;
import com.baidu.live.data.y;
import com.baidu.live.gift.ak;
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
    private int aKu;
    private int aXZ;
    private boolean aYb;
    private boolean aYh;
    private RoundRectPageIndicator aZA;
    private HorizontalScrollView aZB;
    private LinearLayout aZC;
    private CommonEmptyView aZD;
    private View aZE;
    private TextView aZG;
    private TextView aZH;
    private TextView aZI;
    private List<View> aZK;
    private ArrayList<List<g>> aZL;
    private int aZN;
    private int aZO;
    private int aZP;
    private boolean aZQ;
    private boolean aZR;
    private int aZS;
    private g aZT;
    private int aZU;
    private SparseIntArray aZV;
    private SparseBooleanArray aZW;
    private View.OnClickListener aZX;
    private boolean aZY;
    private int aZZ;
    public ArrayList<h> aZo;
    private ArrayList<com.baidu.live.data.h> aZp;
    private ArrayList<j> aZq;
    private final String aZu;
    private boolean aZv;
    private View aZw;
    public TextView aZy;
    private BaseViewPager aZz;
    private GiftPanelNumRoundRectView bQo;
    private com.baidu.live.yuyingift.container.c bQp;
    public GiftPanelOperationSendView bQq;
    private d bQr;
    private a bQs;
    private AlaComboBtnAnimView bQt;
    private com.baidu.live.yuyingift.container.d bQu;
    private int baa;
    private int bab;
    private SparseBooleanArray bac;
    private Set<String> bad;
    private boolean bae;
    private BdAlertDialog baf;
    private int bag;
    private int bai;
    private TbImageView bak;
    private boolean bam;
    private boolean ban;
    private boolean bao;
    private View.OnClickListener bas;
    AdapterView.OnItemClickListener bat;
    private CustomMessageListener bau;
    private CustomMessageListener bav;
    private CustomMessageListener baw;
    private CustomMessageListener bax;
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

        void at(String str, String str2);

        void c(boolean z, int i);

        void f(boolean z, String str);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void Ix();
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aZu = "live_key_privilege_tab_unlock_giftid_array_yuyin_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aZK = new ArrayList();
        this.aZN = 0;
        this.aZO = 0;
        this.mSelectedPosition = 0;
        this.aZP = 0;
        this.aZV = new SparseIntArray();
        this.aZW = new SparseBooleanArray();
        this.isLandscape = false;
        this.aZY = false;
        this.aZZ = -1;
        this.baa = -1;
        this.aYb = false;
        this.aXZ = -1;
        this.bac = new SparseBooleanArray();
        this.bad = new HashSet();
        this.bam = false;
        this.aYh = false;
        this.ban = false;
        this.bao = false;
        this.bas = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.bQt == null || !AlaGiftTabView.this.bQt.HQ()) {
                    if (AlaGiftTabView.this.bQp == null) {
                        AlaGiftTabView.this.bQp = new com.baidu.live.yuyingift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.bat);
                    }
                    AlaGiftTabView.this.bI(true);
                    AlaGiftTabView.this.bQp.a(AlaGiftTabView.this.aZw, AlaGiftTabView.this.aZq, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.11.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bI(false);
                        }
                    });
                }
            }
        };
        this.bat = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.bQp.dismiss();
                if (AlaGiftTabView.this.aZq != null && AlaGiftTabView.this.aZq.size() > 0) {
                    if (i != AlaGiftTabView.this.aZq.size()) {
                        j jVar = (j) AlaGiftTabView.this.aZq.get(i);
                        if (jVar != null) {
                            int number = jVar.getNumber();
                            if (AlaGiftTabView.this.mType == 1 && (bVar = AlaGiftTabView.this.aZT.aUI) != null) {
                                if (number == -1) {
                                    number = bVar.aUV;
                                }
                                if (number > AlaGiftTabView.this.bag) {
                                    number = AlaGiftTabView.this.bag;
                                }
                            }
                            AlaGiftTabView.this.hq(String.valueOf(number));
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.In();
                    return;
                }
                AlaGiftTabView.this.hq("1");
            }
        };
        this.bau = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.f.c)) {
                    com.baidu.live.f.c cVar = (com.baidu.live.f.c) customResponsedMessage.getData();
                    if (cVar.aTa == 1 || cVar.aTa == 2 || cVar.aTa == 5 || cVar.aTa == 6 || cVar.aTa == 7) {
                        if (cVar.aTa == 2) {
                            cVar.aTb.setLength(0L);
                        } else {
                            long size = cVar.aTb.getSize() / 10;
                            if (size == 0) {
                                cVar.aTb.setLength(1L);
                                cVar.aTb.setSize(10L);
                            } else if (cVar.aTb.getLength() < size) {
                                cVar.aTb.setLength(size);
                            }
                        }
                        if (cVar.aTb != null) {
                            AlaGiftTabView.this.b(cVar.aTb.getId(), cVar.aTb.getUrl(), cVar.aTb.getProcess());
                        }
                    }
                }
            }
        };
        this.bav = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bD(true);
                if (AlaGiftTabView.this.aZT != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aZT) && AlaGiftTabView.this.aZv) {
                    AlaGiftTabView.this.bQq.setStyle(AlaGiftTabView.this.aZT.FZ() ? 2 : 1);
                    AlaGiftTabView.this.bQo.setStyleEnabled(true);
                }
            }
        };
        this.baw = new CustomMessageListener(2501033) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                w wVar;
                if (AlaGiftTabView.this.mType == 0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof w) && (wVar = (w) customResponsedMessage.getData()) != null && wVar.aJr != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str2 = wVar.aJr.throneUid;
                    boolean z2 = (TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(str2) || !currentAccount.equals(str2)) ? false : true;
                    if (AlaGiftTabView.this.aYh != z2) {
                        AlaGiftTabView.this.aYh = z2;
                        AlaGiftTabView.this.Iw();
                        AlaGiftTabView.this.Iv();
                    }
                }
            }
        };
        this.bax = new CustomMessageListener(2913179) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.Im();
                    AlaGiftTabView.this.bQq.setStyle(AlaGiftTabView.this.aZT.FZ() ? 4 : 3);
                    AlaGiftTabView.this.bQo.setStyleEnabled(false);
                    if (AlaGiftTabView.this.bQs != null) {
                        AlaGiftTabView.this.bQs.f(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aZX = onClickListener;
        this.aZY = z;
        this.mRoot = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_live_gift_panel_fragment, (ViewGroup) null);
        this.isLandscape = 2 == UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity());
        initViews();
        initListener();
        this.aZS = BdUtilHelper.getDimens(this.mContext.getPageActivity(), a.d.sdk_ds36);
        this.aZL = new ArrayList<>();
    }

    public void setType(int i) {
        this.mType = i;
        switch (this.mType) {
            case 0:
                this.bag = 9999;
                return;
            case 1:
                this.bag = 999;
                return;
            default:
                return;
        }
    }

    public void ek(int i) {
        int childCount;
        this.bai = i;
        if (this.aZC != null && (childCount = this.aZC.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 == this.aZP) {
                    ((GradientTextView) ((ViewGroup) this.aZC.getChildAt(i2)).findViewById(a.f.text_view)).setGradientTextColor(this.bai, this.bai);
                }
            }
        }
    }

    public void a(a aVar) {
        this.bQs = aVar;
    }

    public void au(String str, String str2) {
        this.liveId = str;
        this.roomId = str2;
    }

    public void bC(boolean z) {
        this.mShowing = z;
    }

    public void onVisibilityChanged(boolean z) {
        bC(z);
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initViews() {
        this.aZw = this.mRoot.findViewById(a.f.gift_count_layout);
        this.aZw.setOnClickListener(this.bas);
        this.bQo = (GiftPanelNumRoundRectView) this.mRoot.findViewById(a.f.gift_count_round);
        this.aZy = (TextView) this.mRoot.findViewById(a.f.gift_count_input);
        this.aZy.setText("1");
        this.aZU = 1;
        this.aZy.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
        this.aZz = (BaseViewPager) this.mRoot.findViewById(a.f.gift_viewpager);
        this.aZz.setOnPageChangeListener(this);
        this.aZA = (RoundRectPageIndicator) this.mRoot.findViewById(a.f.gift_tab_indicator);
        this.aZC = (LinearLayout) this.mRoot.findViewById(a.f.gift_tab_layout);
        this.aZB = (HorizontalScrollView) this.mRoot.findViewById(a.f.gift_tab_scrollview);
        if (this.aZY) {
            this.aZB.setVisibility(8);
        }
        this.aZG = (TextView) this.mRoot.findViewById(a.f.current_money);
        this.aZG.setOnClickListener(this.aZX);
        this.aZH = (TextView) this.mRoot.findViewById(a.f.current_flower);
        this.aZH.setOnClickListener(this.aZX);
        this.bQq = (GiftPanelOperationSendView) this.mRoot.findViewById(a.f.donate);
        this.aZI = (TextView) this.mRoot.findViewById(a.f.current_recharge);
        this.aZI.setOnClickListener(this.aZX);
        this.bQq.setOnClickListener(this.aZX);
        FrameLayout frameLayout = (FrameLayout) this.mRoot.findViewById(a.f.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        frameLayout.setPadding(0, BdUtilHelper.dip2px(this.mContext.getPageActivity(), 48.0f), 0, 0);
        this.aZD = new CommonEmptyView(this.mContext.getPageActivity());
        this.aZD.setVisibility(8);
        this.aZD.addToParent(frameLayout);
        this.aZE = this.mRoot.findViewById(a.f.donate_layout);
        this.bQt = (AlaComboBtnAnimView) this.mRoot.findViewById(a.f.combo_layout);
        this.bQt.setComboClickListener(this.aZX);
        this.bQt.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.1
            @Override // com.baidu.live.yuyingift.container.AlaComboBtnAnimView.a
            public void HR() {
                AlaGiftTabView.this.bL(true);
            }
        });
        this.bak = (TbImageView) this.mRoot.findViewById(a.f.iv_official);
    }

    public void Ik() {
        this.bae = true;
        this.aZG.setVisibility(8);
        this.aZH.setVisibility(8);
        this.aZI.setVisibility(8);
    }

    public void bD(boolean z) {
        this.aZv = z;
    }

    public void b(boolean z, String str, String str2, String str3) {
        if (com.baidu.live.aa.a.PQ().PV() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
            this.aZI.setText(this.mContext.getPageActivity().getString(a.h.first_recharge_text));
            if (!this.bad.contains(str)) {
                LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePanelEntryLog(str, str2, str3, this.otherParams);
                this.bad.add(str);
            }
        }
    }

    public void bc(boolean z) {
    }

    public void dG(int i) {
        this.bab = i;
    }

    public void bE(boolean z) {
        this.ban = z;
        if (z && !ListUtils.isEmpty(this.aZp)) {
            Iq();
            this.bao = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y yVar) {
        if (yVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "tycoon_pop_show"));
            if (this.bQu == null) {
                this.bQu = new com.baidu.live.yuyingift.container.d(this.mContext);
            }
            this.bQu.n(yVar.dialogTitle, yVar.aKd + yVar.aKe, yVar.aKe);
        }
    }

    private void Q(View view) {
        if (this.bQu == null) {
            this.bQu = new com.baidu.live.yuyingift.container.d(this.mContext);
        }
        this.bQu.O(view);
    }

    public void bF(boolean z) {
        this.bam = z;
    }

    public void el(int i) {
        this.aKu = i;
    }

    public void be(boolean z) {
        this.aYh = z;
    }

    public void bG(boolean z) {
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.aZz.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height) + this.mContext.getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom);
                this.aZz.setLayoutParams(layoutParams);
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
        if (this.bQs != null) {
            this.bQs.c(false, this.bag);
        }
        en(i);
        this.aZz.setCurrentItem(this.aZN);
        Ir();
        Il();
    }

    private void en(int i) {
        int min = Math.min(i, this.aZV.size());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            i2 += this.aZV.get(i3);
        }
        this.aZN = i2;
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
            AlaGiftTabView.this.aZO = AlaGiftTabView.this.aZN;
            AlaGiftTabView.this.a((com.baidu.live.yuyingift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void Il() {
        if (this.bQs != null) {
            if (this.aZT != null && this.aZT.aUJ) {
                this.bQs.at(this.aZT.aUK, this.aZT.aUL);
            } else {
                this.bQs.at(null, null);
            }
        }
    }

    public void a(com.baidu.live.yuyingift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.bQs != null) {
            this.bQs.c(false, this.bag);
        }
        if (aVar != null) {
            g item = aVar.getItem(i);
            if (item != null) {
                d(item);
                aVar.ed(i);
                aVar.notifyDataSetChanged();
                this.aZE.setVisibility(aVar.getCount() > 0 ? 0 : 4);
                hq("1");
                int i3 = -1;
                if (this.mType == 0) {
                    if (this.aZT.Gq()) {
                        this.bQq.setStyle(this.aZT.FZ() ? 4 : 3);
                        this.bQo.setStyleEnabled(false);
                        if (this.bQs != null) {
                            this.bQs.f(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aZT.Gc()) && this.mShowing) {
                            this.mContext.showToast(this.aZT.Gc());
                            return;
                        }
                        return;
                    }
                    Il();
                    this.bQq.setEnabled(true);
                    if (this.aZT.Gt()) {
                        if (this.bQs != null) {
                            this.bQs.f(false, null);
                        }
                        if (this.aZT.Gp() == 6 && this.aXZ < 3) {
                            i3 = 3;
                        } else if (this.aZT.Gp() == 7 && this.aXZ < 7) {
                            i3 = 7;
                        } else if (this.aZT.Gp() == 8 && this.aXZ < 13) {
                            i3 = 13;
                        } else if (this.aZT.Gp() == 9 && this.aXZ < 22) {
                            i3 = 22;
                        } else if (this.aZT.Gp() == 10 && this.aXZ < 29) {
                            i3 = 29;
                        } else if (this.aZT.Gp() == 11 && this.aXZ < 39) {
                            i3 = 39;
                        } else if (this.aZT.Gp() == 12 && this.aXZ < 47) {
                            i3 = 47;
                        }
                    }
                    boolean z = i3 == -1;
                    if (z) {
                        this.bQq.setStyle(this.aZT.FZ() ? 2 : 1);
                    } else {
                        this.bQq.setStyle(this.aZT.FZ() ? 4 : 3);
                    }
                    this.bQo.setStyleEnabled(z);
                    Iw();
                    i2 = i3;
                } else {
                    this.bQq.setStyle(this.aZT.FZ() ? 2 : 1);
                    if (this.aZT.aUI != null && this.aZT.aUI.aUU != null && this.aZT.aUI.aUU.equals("20")) {
                        this.bQq.setText("使用");
                    } else {
                        this.bQq.setText("赠送");
                    }
                    this.bQo.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aZT.Ga()) {
                    bH(true);
                } else {
                    bH(false);
                    hq("1");
                }
                d(false, i2);
                return;
            }
            this.bQq.setStyle(3);
            return;
        }
        this.bQq.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.b bVar;
        if (this.mShowing && this.aZT != null) {
            if (this.mType == 0) {
                if (this.aZT.Gs() && !this.aYh) {
                    this.mContext.showToast(a.h.sdk_throne_disabled_alert);
                } else if (!TextUtils.isEmpty(this.aZT.Gc()) && this.aZT.Gq() && !z) {
                    this.mContext.showToast(this.aZT.Gc());
                } else if (this.aZT.Gt() && i != -1) {
                    this.mContext.showToast(String.format(this.mContext.getString(a.h.send_family_level_gift_toast_live), Integer.valueOf(i)));
                } else if (this.aZT.Go()) {
                    BdUtilHelper.showLongToast(this.mContext.getPageActivity(), this.mContext.getString(a.h.send_broadcast_gift_toast));
                }
            } else if (this.mType == 1 && (bVar = this.aZT.aUI) != null && !TextUtils.isEmpty(bVar.aUX)) {
                this.mContext.showToast(bVar.aUX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(g gVar) {
        if (com.baidu.live.aa.a.PQ().btT != null && com.baidu.live.aa.a.PQ().btT.aPw != null) {
            String str = com.baidu.live.aa.a.PQ().btT.aPw.aOO;
            if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(gVar.Gp()))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Im() {
        if (!this.aZR) {
            this.baf = new BdAlertDialog(this.mContext.getPageActivity());
            this.baf.setCancelable(false);
            this.baf.setCanceledOnTouchOutside(false);
            this.baf.setTitle(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_title));
            this.baf.setMessage(String.format(this.mContext.getPageActivity().getString(a.h.need_join_guard_club_content), Integer.valueOf(this.bab)));
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.baf.setPositiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                this.baf.setNagetiveButtonTextColor(this.mContext.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                this.baf.setPositiveButtonTextColor(-57754);
                this.baf.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            this.baf.setPositiveButton(this.mContext.getPageActivity().getString(a.h.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aZR = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.baf.setNegativeButton(this.mContext.getPageActivity().getString(a.h.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aZR = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.baf.create(this.mContext).show();
            this.aZR = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(boolean z) {
        int i = 0;
        boolean z2 = z && com.baidu.live.aa.a.PQ().bod.aLI;
        if (z2) {
            this.aZw.setVisibility(4);
            this.bQq.setStyle(1);
        } else {
            View view = this.aZw;
            if (this.aZT == null || !this.aZT.FZ()) {
                i = 4;
            }
            view.setVisibility(i);
        }
        if (this.bQs != null) {
            this.bQs.f(z2, this.aZT != null ? this.aZT.getThumbnail_url() : null);
        }
    }

    public void In() {
        if (this.bQs != null) {
            this.bQs.c(true, this.bag);
        }
    }

    @Override // com.baidu.live.view.input.b.a
    public void hn(String str) {
        if (JavaTypesHelper.toInt(str, 0) <= 0) {
            str = "1";
        }
        hq(str);
    }

    public void hq(String str) {
        this.aZy.setText(str);
        this.aZy.setTextSize(0, this.mContext.getResources().getDimensionPixelOffset(str.length() >= 4 ? a.d.sdk_fontsize20 : a.d.sdk_fontsize24));
        bI(false);
        if (this.aZT != null && this.aZT.FZ()) {
            this.aZw.setVisibility(0);
            this.aZU = JavaTypesHelper.toInt(this.aZy.getText().toString(), 1);
            return;
        }
        this.aZw.setVisibility(4);
        this.aZU = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(boolean z) {
        this.aZy.setGravity(17);
        if (z) {
            this.aZy.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_down, 0);
        } else {
            this.aZy.setCompoundDrawablesWithIntrinsicBounds(0, 0, a.e.sdk_icon_tabbar_arrow_up, 0);
        }
    }

    public void a(boolean z, ArrayList<h> arrayList, ArrayList<com.baidu.live.data.h> arrayList2, ArrayList<j> arrayList3, boolean z2, int i) {
        if (this.aZo == null || this.aZo.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
            if (this.aZo == null) {
                this.aZo = new ArrayList<>();
            }
            this.aZo.clear();
            if (arrayList != null) {
                this.aZo.addAll(arrayList);
            }
            this.aZp = arrayList2;
            this.aZq = arrayList3;
            this.aZQ = false;
            if (this.aZp == null || this.aZp.isEmpty()) {
                this.aZB.setVisibility(8);
            }
            a(z, z2, i);
        }
    }

    public void A(String str, int i) {
        if (!TextUtils.isEmpty(str) && this.mType == 1 && this.aZK != null) {
            for (View view : this.aZK) {
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
        Io();
        if (this.aZo == null || this.aZo.size() <= 0 || !z2) {
            rE();
            if (this.aZA != null) {
                this.aZA.setVisibility(4);
            }
            this.aZE.setVisibility(4);
            this.aZD.reset();
            if (!z2 && BdNetTypeUtil.isNetWorkAvailable()) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                this.aZD.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
            } else if (z2) {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_fail_tip_rank);
                i = MessageConfig.GITT_NO_DATA;
                this.aZD.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
            } else {
                string = this.mContext.getPageActivity().getString(a.h.sdk_net_no);
                this.aZD.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
            }
            if (com.baidu.live.aa.a.PQ().bod.aNm && i != 0) {
                string = string + "(" + i + ")";
            }
            this.aZD.setTitle(string);
            this.aZD.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.bQr != null) {
                        AlaGiftTabView.this.bQr.Ix();
                    }
                }
            });
            this.aZD.setVisibility(0);
            return;
        }
        this.aZD.setVisibility(8);
        if (z) {
            m(this.aZp);
        }
        bn bnVar = com.baidu.live.aa.a.PQ().btT;
        if (this.mType == 0 && bnVar != null && bnVar.aPA != null && bnVar.aPA.aRT && !this.bam && this.aZo.get(0) != null && this.aZo.get(0).Gu() != null) {
            List<g> Gu = this.aZo.get(0).Gu();
            if (Gu.size() <= 1 || Gu.get(1) == null) {
                z3 = true;
            } else {
                z3 = !Gu.get(1).isRed();
            }
            if (!Gu.isEmpty() && z3) {
                g gVar = new g();
                gVar.bq(true);
                gVar.aUP = 100;
                gVar.setGiftName("发红包");
                Gu.add(1, gVar);
            }
        }
        c(this.aZo, z);
        hq("1");
    }

    private void rE() {
        this.aZN = 0;
        this.aZO = 0;
        this.mSelectedPosition = 0;
        this.aZP = 0;
        if (this.aZV != null) {
            this.aZV.clear();
        }
        if (this.aZK != null) {
            this.aZK.clear();
        }
        if (this.aZz != null) {
            this.aZz.setAdapter(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(g gVar) {
        if (gVar == null) {
            return false;
        }
        if (gVar.Gt()) {
            if (gVar.Gp() == 6 && this.aXZ < 3) {
                return false;
            }
            if (gVar.Gp() == 7 && this.aXZ < 7) {
                return false;
            }
            if (gVar.Gp() == 8 && this.aXZ < 13) {
                return false;
            }
            if (gVar.Gp() == 9 && this.aXZ < 22) {
                return false;
            }
            if (gVar.Gp() == 10 && this.aXZ < 29) {
                return false;
            }
            if (gVar.Gp() == 11 && this.aXZ < 39) {
                return false;
            }
            if (gVar.Gp() == 12 && this.aXZ < 47) {
                return false;
            }
        }
        if (gVar.Gs()) {
            return this.aYh;
        }
        return true;
    }

    public void b(final y yVar) {
        if (yVar == null || TextUtils.isEmpty(yVar.iconUrl)) {
            this.bak.setVisibility(8);
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!TextUtils.isEmpty(currentAccount)) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "tycoon_show"));
            this.bak.setVisibility(0);
            this.bak.startLoad(yVar.iconUrl, 10, false);
            this.bak.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "tycoon_clk"));
                    AlaGiftTabView.this.a(yVar);
                }
            });
            String str = "key_live_official_tip_yuyin" + currentAccount;
            if (com.baidu.live.d.AZ().getInt(str, 0) == 0 && this.ban) {
                Q(this.bak);
                com.baidu.live.d.AZ().putInt(str, 1);
            }
        }
    }

    private void Io() {
        if (ListUtils.getCount(this.aZp) != 0 && ListUtils.getCount(this.aZo) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<com.baidu.live.data.h> it = this.aZp.iterator();
            while (it.hasNext()) {
                com.baidu.live.data.h next = it.next();
                if (next != null && (TextUtils.isEmpty(next.getCategoryName()) || (this.mType == 0 && ListUtils.getCount(next.Eg()) == 0))) {
                    arrayList.add(next);
                    Iterator<h> it2 = this.aZo.iterator();
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
                Iterator<h> it3 = this.aZo.iterator();
                while (it3.hasNext()) {
                    ListIterator<g> listIterator = it3.next().Gu().listIterator();
                    while (listIterator.hasNext()) {
                        g next3 = listIterator.next();
                        if (next3 != null && next3.Ga()) {
                            listIterator.remove();
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.aZp.removeAll(arrayList);
            }
            if (arrayList2.size() > 0) {
                this.aZo.removeAll(arrayList2);
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
        List<g> Gu;
        if (arrayList != null) {
            this.aZV.clear();
            this.aZK.clear();
            this.aZz.setAdapter(null);
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
                    if (hVar == null || (Gu = hVar.Gu()) == null || Gu.isEmpty()) {
                        i4 = i5 + 1;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            this.aZL.clear();
            al(arrayList);
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= arrayList.size()) {
                    break;
                }
                if (z2) {
                    this.aZK.add(eo(i7));
                    this.aZV.append(i7, 1);
                } else {
                    h hVar2 = arrayList.get(i7);
                    hVar2.getCategoryId();
                    List<g> Gu2 = hVar2.Gu();
                    if (Gu2 == null) {
                        i = 0;
                    } else {
                        i = Gu2.size();
                    }
                    int i8 = 0;
                    if (i <= 0) {
                        i8 = 1;
                        ArrayList arrayList3 = new ArrayList();
                        if (this.aZW.get(i7)) {
                            this.aZK.add(bJ(true));
                        } else {
                            this.aZK.add(b(arrayList3, -1, i7));
                        }
                    } else if (Gu2 != null) {
                        int i9 = this.isLandscape ? 12 : 8;
                        int ceil = (int) Math.ceil(i / i9);
                        for (int i10 = 0; i10 < ceil; i10++) {
                            if (i10 == ceil - 1) {
                                if (i10 * i9 == i - 1) {
                                    ArrayList arrayList4 = new ArrayList();
                                    arrayList4.add(Gu2.get(i - 1));
                                    arrayList2 = arrayList4;
                                } else {
                                    arrayList2 = new ArrayList(Gu2.subList(i10 * i9, i));
                                }
                            } else {
                                arrayList2 = new ArrayList(Gu2.subList(i10 * i9, (i10 + 1) * i9));
                            }
                            this.aZL.add(arrayList2);
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
                                    if (gVar == null || gVar.FT() == null || !gVar.FT().equals(String.valueOf(this.baa))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aZK.add(b(arrayList2, i3, i7));
                                this.bQq.removeCallbacks(null);
                                this.bQq.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.17
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aZT != null) {
                                            boolean Ga = AlaGiftTabView.this.aZT.Ga();
                                            AlaGiftTabView.this.bH(Ga);
                                            if (!Ga) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aZT);
                                                if (!c2) {
                                                    AlaGiftTabView.this.bQq.setStyle(AlaGiftTabView.this.aZT.FZ() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.bQq.setStyle(AlaGiftTabView.this.aZT.FZ() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.bQo.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.FT().equals(String.valueOf(this.baa))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aZK.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aZK.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
                    }
                    this.aZV.append(i7, i8);
                }
                i6 = i7 + 1;
            }
            this.aZz.setAdapter(new AlaGiftPagerAdapter(this.aZK));
            Ip();
            this.aZz.setCurrentItem(this.aZN);
            Ir();
            if (z && !this.bao && this.ban) {
                this.bao = true;
                Iq();
            }
        }
    }

    private void Ip() {
        int i = 0;
        if (this.baa > 0 && !ListUtils.isEmpty(this.aZL)) {
            boolean z = false;
            for (int i2 = 0; i2 < this.aZL.size() && !z; i2++) {
                Iterator<g> it = this.aZL.get(i2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    g next = it.next();
                    if (next != null && next.FT() != null && next.FT().equals(String.valueOf(this.baa))) {
                        this.aZN = i2;
                        z = true;
                        d(next);
                        break;
                    }
                }
            }
            if (this.aKu == 111 && !z && this.mShowing) {
                BdUtilHelper.showToast(this.mContext.getPageActivity(), a.h.ala_not_find_gift_toast);
            }
            this.aZO = this.aZN;
            this.aZL.clear();
        } else if (this.aZZ > 0) {
            while (true) {
                int i3 = i;
                if (i3 >= this.aZp.size()) {
                    break;
                }
                com.baidu.live.data.h hVar = this.aZp.get(i3);
                if (hVar == null || this.aZZ != hVar.getCategoryId()) {
                    i = i3 + 1;
                } else {
                    en(i3);
                    break;
                }
            }
            this.aZO = this.aZN;
        }
    }

    private void al(List<h> list) {
        if (list != null && this.aZZ > 0 && this.baa <= 0) {
            for (h hVar : list) {
                if (hVar.getCategoryId() == this.aZZ) {
                    List<g> Gu = hVar.Gu();
                    if (Gu != null && !Gu.isEmpty() && Gu.get(0) != null) {
                        this.baa = Integer.valueOf(Gu.get(0).FT()).intValue();
                        return;
                    }
                    return;
                }
            }
        }
    }

    private View bJ(boolean z) {
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
                if (AlaGiftTabView.this.bQr != null) {
                    AlaGiftTabView.this.bQr.Ix();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.yuyingift.container.a aVar = new com.baidu.live.yuyingift.container.a(this.mContext, this.mType);
        aVar.bv(this.aYb);
        aVar.setGiftItems(list);
        aVar.ec(this.aXZ);
        aVar.be(this.aYh);
        aVar.ed(i);
        if (this.isLandscape) {
            if (this.aZz.getHeight() > 0) {
                aVar.ee(this.aZz.getHeight() / 3);
            } else {
                this.aZz.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.ee(AlaGiftTabView.this.aZz.getHeight() / 3);
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
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.3
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0237a) {
                    ((a.C0237a) tag).recycle();
                }
            }
        });
        frameLayout.addView(bdGridView, new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    private FrameLayout eo(int i) {
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
    private void m(ArrayList<com.baidu.live.data.h> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.size() > 0) {
            if (!this.aZY) {
                this.aZB.setVisibility(0);
            }
            this.aZC.removeAllViews();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                com.baidu.live.data.h hVar = arrayList.get(i);
                if (!TextUtils.isEmpty(hVar.getCategoryName()) && (this.mType != 0 || (hVar.Eg() != null && hVar.Eg().size() > 0))) {
                    ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.ala_gift_tab_item, (ViewGroup) null);
                    GradientTextView gradientTextView = (GradientTextView) viewGroup.findViewById(a.f.text_view);
                    gradientTextView.setCheckStrEquals(false);
                    gradientTextView.setText(hVar.getCategoryName());
                    viewGroup.setOnClickListener(new c(i));
                    if (i != 0) {
                        layoutParams.leftMargin = this.aZS;
                    }
                    if (this.aZo.size() > i && this.aZo.get(i) != null) {
                        for (g gVar : this.aZo.get(i).Gu()) {
                            if (gVar != null && gVar.FY() != 6) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    viewGroup.setTag(Boolean.valueOf(z));
                    this.aZC.addView(viewGroup, layoutParams);
                }
            }
            ep(this.aZP);
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
        List<g> Gu;
        int childCount = this.aZC.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aZP != i || !this.aZQ) && this.aZp.size() > i && this.aZp.get(i) != null) {
                int min = Math.min(i, this.aZV.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aZV.get(i4);
                }
                if (this.aZK.size() > i3 && this.aZo.size() > i && (this.aZK.get(i3) instanceof ViewGroup)) {
                    this.aZO = i3;
                    h hVar = this.aZo.get(i);
                    if (hVar != null && hVar.Gu() != null && !hVar.Gu().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aZK.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.yuyingift.container.a aVar = (com.baidu.live.yuyingift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aZQ) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aZN) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.mShowing) {
                                        this.aZQ = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (this.aZp.size() > i && this.aZp.get(i) != null) {
                int categoryId = this.aZp.get(i).getCategoryId();
                if (!this.bac.get(categoryId)) {
                    LogManager.getGiftLogger().doDisplayGiftTabLog(null, this.otherParams, String.valueOf(categoryId));
                    this.bac.put(categoryId, true);
                }
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aZC.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.f.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.f.icon_new_unlock_gift);
                imageView.setVisibility(8);
                h hVar2 = this.aZo.get(i6);
                if (hVar2.Gv()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aZu, "");
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
                                    Gu = hVar2.Gu();
                                    if (Gu != null) {
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
                    Gu = hVar2.Gu();
                    if (Gu != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= Gu.size()) {
                                break;
                            }
                            g gVar = Gu.get(i9);
                            if (!gVar.Gq() && !hashSet.contains(gVar.FT())) {
                                arrayList.add(gVar.FT());
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
                                SharedPrefHelper.getInstance().putString(this.aZu, jSONArray.toString());
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
                    if (this.bai != 0) {
                        gradientTextView.setGradientTextColor(this.bai, this.bai);
                    } else {
                        gradientTextView.setGradientTextColor(-57754, -39399);
                    }
                    gradientTextView.setTypeface(Typeface.defaultFromStyle(1));
                    eq(i);
                    this.aZP = i;
                    this.aZB.scrollTo(viewGroup2.getLeft(), 0);
                }
                if (i6 == i) {
                    if (viewGroup2.getTag() instanceof Boolean) {
                        if (((Boolean) viewGroup2.getTag()).booleanValue()) {
                            bK(false);
                        } else {
                            bK(true);
                        }
                    } else {
                        bK(true);
                    }
                }
            }
        }
    }

    private void bK(boolean z) {
        int i = 8;
        if (this.aZG != null) {
            this.aZG.setVisibility(z ? this.bae ? 8 : 0 : 8);
        }
        if (this.aZH != null) {
            TextView textView = this.aZH;
            if (!z && !this.bae) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    private void eq(int i) {
        int childCount = this.aZC.getChildCount();
        if (i >= 0 && i < childCount && this.aZo != null && this.aZo.size() > i && this.aZo.get(i) != null) {
            this.aZW.get(i);
        }
    }

    public void x(int i, int i2) {
        this.aZZ = i;
        this.baa = i2;
    }

    public void aq(long j) {
        if (this.aZG != null) {
            if (j >= 100 && (this.aYb || com.baidu.live.aa.a.PQ().bod.aMG)) {
                this.aZG.setText(new DecimalFormat("0.###K").format(JavaTypesHelper.toDouble(String.valueOf(j), 0.0d) / 1000.0d));
                return;
            }
            this.aZG.setText(String.valueOf(j));
        }
    }

    public void ar(long j) {
        if (this.aZH != null) {
            this.aZH.setText(String.valueOf(j));
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
        this.aZN = i;
        Ir();
        Il();
        if (i >= 0 && i < this.aZK.size() && (this.aZK.get(i) instanceof ViewGroup)) {
            Iq();
            ViewGroup viewGroup = (ViewGroup) this.aZK.get(i);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (viewGroup.getChildAt(i2) instanceof GridView) {
                    GridView gridView = (GridView) viewGroup.getChildAt(i2);
                    if (gridView.getAdapter() != null) {
                        com.baidu.live.yuyingift.container.a aVar = (com.baidu.live.yuyingift.container.a) gridView.getAdapter();
                        if (aVar.getSelectedPosition() >= 0 && i != this.aZO) {
                            aVar.ed(-1);
                        }
                        if (aVar.getSelectedPosition() < 0 && i == this.aZO) {
                            aVar.ed(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.aZE.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void Iq() {
        JSONObject jSONObject = new JSONObject();
        com.baidu.live.data.h hVar = (com.baidu.live.data.h) ListUtils.getItem(this.aZp, this.aZP);
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

    private void Ir() {
        int i = 0;
        for (int i2 = 0; i2 < this.aZV.size(); i2++) {
            for (int i3 = 0; i3 < this.aZV.get(i2); i3++) {
                if (i + i3 == this.aZN) {
                    if (this.aZV.get(i2) <= 1) {
                        this.aZA.setVisibility(4);
                    } else {
                        this.aZA.setVisibility(0);
                    }
                    this.aZA.setCount(this.aZV.get(i2));
                    this.aZA.onPageSelected(i3);
                    ep(i2);
                    return;
                }
            }
            i += this.aZV.get(i2);
        }
    }

    public g Is() {
        return this.aZT;
    }

    public int It() {
        return this.aZU;
    }

    public void a(d dVar) {
        this.bQr = dVar;
    }

    public void er(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.aZU = i;
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.bau);
        MessageManager.getInstance().registerListener(this.bav);
        MessageManager.getInstance().registerListener(this.baw);
        MessageManager.getInstance().registerListener(this.bax);
    }

    public void Iu() {
        if (!ListUtils.isEmpty(this.aZK)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.8
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aZK) {
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
    public void b(final String str, final String str2, final int i) {
        if (!ListUtils.isEmpty(this.aZK) && !TextUtils.isEmpty(str)) {
            new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aZK) {
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
    public void Iv() {
        if (!ListUtils.isEmpty(this.aZK)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.10
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aZK) {
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
                                        ((com.baidu.live.yuyingift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aYh);
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
    public void Iw() {
        if (this.aZT != null && this.aZT.Gs()) {
            this.bQo.setStyleEnabled(this.aYh);
            if (this.aYh) {
                this.bQq.setStyle(this.aZT.FZ() ? 2 : 1);
            } else {
                this.bQq.setStyle(this.aZT.FZ() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.bQs = null;
        MessageManager.getInstance().unRegisterListener(this.bau);
        MessageManager.getInstance().unRegisterListener(this.bav);
        MessageManager.getInstance().unRegisterListener(this.baw);
        MessageManager.getInstance().unRegisterListener(this.bax);
        rE();
        if (this.baf != null) {
            this.baf.dismiss();
        }
    }

    public void bv(boolean z) {
        this.aYb = z;
    }

    public void es(int i) {
        this.aXZ = i;
    }

    public void d(g gVar) {
        com.baidu.live.gift.c hx;
        this.aZT = gVar;
        this.baa = Integer.valueOf(this.aZT.FT()).intValue();
        if (this.bQs != null) {
            this.bQs.a(gVar);
        }
        if (gVar != null && !gVar.Gb()) {
            this.bQt.HP();
        }
        if (BdNetTypeUtil.isNetWorkAvailable() && this.aZT.Ge() && !com.baidu.live.yuyingift.b.b.XE().gV(this.aZT.FT()) && (hx = com.baidu.live.yuyingift.b.b.XE().hx(this.aZT.FT())) != null) {
            ak.Hx().a(hx.aUe, true, true);
        }
    }

    public void HO() {
        if (this.bQt != null) {
            this.bQt.HO();
        }
    }

    public void HN() {
        if (this.bQt != null) {
            this.bQt.HN();
        }
    }

    public void bL(boolean z) {
        if (this.bQq != null) {
            this.bQq.setVisibility(z ? 0 : 4);
        }
    }
}

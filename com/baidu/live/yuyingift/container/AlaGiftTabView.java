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
/* loaded from: classes10.dex */
public class AlaGiftTabView implements ViewPager.OnPageChangeListener, c.a {
    private int aHt;
    private boolean aWF;
    private int aWx;
    private boolean aWz;
    public ArrayList<h> aXO;
    private ArrayList<i> aXP;
    private ArrayList<k> aXQ;
    private final String aXU;
    private boolean aXV;
    private ViewGroup aXW;
    private View aXX;
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
    private int aYN;
    private TbImageView aYP;
    private boolean aYR;
    private boolean aYS;
    private boolean aYT;
    private View.OnClickListener aYW;
    AdapterView.OnItemClickListener aYX;
    private CustomMessageListener aYY;
    private CustomMessageListener aYZ;
    private BaseViewPager aYb;
    private RoundRectPageIndicator aYc;
    private HorizontalScrollView aYd;
    private LinearLayout aYe;
    private CommonEmptyView aYg;
    private View aYh;
    private TextView aYj;
    private TextView aYk;
    private TextView aYl;
    private List<View> aYn;
    private ArrayList<List<g>> aYp;
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
    private GiftPanelNumRoundRectView bUO;
    private com.baidu.live.yuyingift.container.c bUP;
    public GiftPanelOperationSendView bUQ;
    private e bUR;
    private a bUS;
    private AlaComboBtnAnimView bUT;
    private com.baidu.live.yuyingift.container.d bUU;
    private b bUV;
    private boolean isLandscape;
    private String liveId;
    private TbPageContext mContext;
    private int mSelectedPosition;
    private int mType;
    private String otherParams;
    private String roomId;

    /* loaded from: classes10.dex */
    public interface a {
        void WO();

        void WP();

        void WQ();

        void WR();

        void WS();

        void WT();

        void WU();

        void a(g gVar);

        void aU(String str, String str2);

        void aV(String str, String str2);

        void c(boolean z, int i);

        void f(boolean z, String str);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void j(g gVar);
    }

    /* loaded from: classes10.dex */
    public interface e {
        void Fm();
    }

    public void a(b bVar) {
        this.bUV = bVar;
    }

    public AlaGiftTabView(TbPageContext tbPageContext, View.OnClickListener onClickListener, boolean z, String str) {
        this.aXU = "live_key_privilege_tab_unlock_giftid_array_yuyin_" + (TbadkCoreApplication.getCurrentAccountInfo() == null ? "" : TbadkCoreApplication.getCurrentAccountInfo().getID());
        this.aYn = new ArrayList();
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
        this.aYW = new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.bUT == null || !AlaGiftTabView.this.bUT.ED()) {
                    if (AlaGiftTabView.this.bUP == null) {
                        AlaGiftTabView.this.bUP = new com.baidu.live.yuyingift.container.c(AlaGiftTabView.this.mContext, AlaGiftTabView.this.mType, AlaGiftTabView.this.aYX);
                    }
                    if (AlaGiftTabView.this.bUS != null) {
                        AlaGiftTabView.this.bUS.WT();
                    }
                    AlaGiftTabView.this.bN(true);
                    AlaGiftTabView.this.bUP.a(AlaGiftTabView.this.aXX, AlaGiftTabView.this.aXQ, AlaGiftTabView.this.isLandscape, new PopupWindow.OnDismissListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.11.1
                        @Override // android.widget.PopupWindow.OnDismissListener
                        public void onDismiss() {
                            AlaGiftTabView.this.bN(false);
                        }
                    });
                }
            }
        };
        this.aYX = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.12
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g.b bVar;
                AlaGiftTabView.this.bUP.dismiss();
                if (AlaGiftTabView.this.aXQ != null && AlaGiftTabView.this.aXQ.size() > 0) {
                    if (i != AlaGiftTabView.this.aXQ.size()) {
                        k kVar = (k) AlaGiftTabView.this.aXQ.get(i);
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
                            return;
                        }
                        return;
                    }
                    AlaGiftTabView.this.Fc();
                    return;
                }
                AlaGiftTabView.this.ge("1");
            }
        };
        this.aYY = new CustomMessageListener(2913078) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.i.c)) {
                    com.baidu.live.i.c cVar = (com.baidu.live.i.c) customResponsedMessage.getData();
                    if (cVar.aQW == 1 || cVar.aQW == 2 || cVar.aQW == 5 || cVar.aQW == 6 || cVar.aQW == 7) {
                        if (cVar.aQW == 2) {
                            cVar.aQX.setLength(0L);
                        } else {
                            long size = cVar.aQX.getSize() / 10;
                            if (size == 0) {
                                cVar.aQX.setLength(1L);
                                cVar.aQX.setSize(10L);
                            } else if (cVar.aQX.getLength() < size) {
                                cVar.aQX.setLength(size);
                            }
                        }
                        if (cVar.aQX != null) {
                            AlaGiftTabView.this.e(cVar.aQX.getId(), cVar.aQX.getUrl(), cVar.aQX.getProcess());
                        }
                    }
                }
            }
        };
        this.aYZ = new CustomMessageListener(2913120) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                AlaGiftTabView.this.bI(true);
                if (AlaGiftTabView.this.aYx != null && AlaGiftTabView.this.b(AlaGiftTabView.this.aYx) && AlaGiftTabView.this.aXV) {
                    AlaGiftTabView.this.bUQ.setStyle(AlaGiftTabView.this.aYx.CK() ? 2 : 1);
                    AlaGiftTabView.this.bUO.setStyleEnabled(true);
                }
            }
        };
        this.aZa = new CustomMessageListener(2501033) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.6
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
        this.aZb = new CustomMessageListener(2913179) { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913179 && AlaGiftTabView.this.mType == 0) {
                    AlaGiftTabView.this.Fb();
                    AlaGiftTabView.this.bUQ.setStyle(AlaGiftTabView.this.aYx.CK() ? 4 : 3);
                    AlaGiftTabView.this.bUO.setStyleEnabled(false);
                    if (AlaGiftTabView.this.bUS != null) {
                        AlaGiftTabView.this.bUS.f(false, null);
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.otherParams = str;
        this.aYB = onClickListener;
        this.aYC = z;
        this.aXW = (ViewGroup) LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.g.yuyin_live_gift_panel_fragment, (ViewGroup) null);
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
                return;
            case 1:
                this.aYL = 999;
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
        this.bUS = aVar;
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
        this.bUO = (GiftPanelNumRoundRectView) this.aXW.findViewById(a.f.gift_count_round);
        this.aXZ = (TextView) this.aXW.findViewById(a.f.gift_count_input);
        this.aXZ.setText("1");
        this.aYy = 1;
        this.aXZ.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_fontsize24));
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
        this.bUQ = (GiftPanelOperationSendView) this.aXW.findViewById(a.f.donate);
        this.aYl = (TextView) this.aXW.findViewById(a.f.current_recharge);
        this.aYl.setOnClickListener(this.aYB);
        this.bUQ.setOnClickListener(this.aYB);
        FrameLayout frameLayout = (FrameLayout) this.aXW.findViewById(a.f.layout_error);
        frameLayout.getLayoutParams().width = ScreenHelper.getRealScreenHeight(this.mContext.getPageActivity());
        frameLayout.setPadding(0, BdUtilHelper.dip2px(this.mContext.getPageActivity(), 48.0f), 0, 0);
        this.aYg = new CommonEmptyView(this.mContext.getPageActivity());
        this.aYg.setVisibility(8);
        this.aYg.addToParent(frameLayout);
        this.aYh = this.aXW.findViewById(a.f.donate_layout);
        this.bUT = (AlaComboBtnAnimView) this.aXW.findViewById(a.f.combo_layout);
        this.bUT.setComboClickListener(this.aYB);
        this.bUT.setComboListener(new AlaComboBtnAnimView.a() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.1
            @Override // com.baidu.live.yuyingift.container.AlaComboBtnAnimView.a
            public void j(g gVar) {
                AlaGiftTabView.this.bQ(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501075, false));
                if (AlaGiftTabView.this.bUV != null) {
                    AlaGiftTabView.this.bUV.j(gVar);
                }
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
        if (com.baidu.live.af.a.OJ().OO() && !TbadkCoreApplication.getInst().isMobileBaidu() && z) {
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
        this.aYS = z;
        if (z && !ListUtils.isEmpty(this.aXP)) {
            Ff();
            this.aYT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aa aaVar) {
        if (aaVar != null) {
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "tycoon_pop_show"));
            if (this.bUU == null) {
                this.bUU = new com.baidu.live.yuyingift.container.d(this.mContext);
            }
            this.bUU.n(aaVar.dialogTitle, aaVar.aGW + aaVar.aGX, aaVar.aGX);
        }
    }

    private void Q(View view) {
        if (this.bUU == null) {
            this.bUU = new com.baidu.live.yuyingift.container.d(this.mContext);
        }
        this.bUU.O(view);
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
            ViewGroup.LayoutParams layoutParams = this.aYb.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mContext.getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noble_height) + this.mContext.getResources().getDimensionPixelOffset(a.d.yuyin_ala_dimen_gift_noblr_maginbottom);
                this.aYb.setLayoutParams(layoutParams);
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
        if (this.bUS != null) {
            this.bUS.c(false, this.aYL);
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
            AlaGiftTabView.this.aYs = AlaGiftTabView.this.aYr;
            AlaGiftTabView.this.a((com.baidu.live.yuyingift.container.a) adapterView.getAdapter(), i);
        }
    }

    private void Fa() {
        if (this.bUS != null) {
            if (this.aYx != null && this.aYx.aST) {
                this.bUS.aU(this.aYx.aSU, this.aYx.aSV);
            } else {
                this.bUS.aU(null, null);
            }
        }
    }

    public void a(com.baidu.live.yuyingift.container.a aVar, int i) {
        int i2;
        this.mSelectedPosition = i;
        if (this.bUS != null) {
            this.bUS.c(false, this.aYL);
            this.bUS.WO();
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
                        this.bUQ.setStyle(this.aYx.CK() ? 4 : 3);
                        this.bUO.setStyleEnabled(false);
                        if (this.bUS != null) {
                            this.bUS.f(false, null);
                        }
                        if (!TextUtils.isEmpty(this.aYx.CN()) && this.aYJ) {
                            this.mContext.showToast(this.aYx.CN());
                            return;
                        }
                        return;
                    }
                    Fa();
                    this.bUQ.setEnabled(true);
                    if (this.aYx.Df()) {
                        if (this.bUS != null) {
                            this.bUS.f(false, null);
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
                        this.bUQ.setStyle(this.aYx.CK() ? 2 : 1);
                    } else {
                        this.bUQ.setStyle(this.aYx.CK() ? 4 : 3);
                    }
                    this.bUO.setStyleEnabled(z);
                    Fl();
                    i2 = i3;
                } else {
                    this.bUQ.setStyle(this.aYx.CK() ? 2 : 1);
                    if (this.aYx.aSS != null && this.aYx.aSS.aTg != null && this.aYx.aSS.aTg.equals("20")) {
                        this.bUQ.setText("使用");
                    } else {
                        this.bUQ.setText("赠送");
                    }
                    this.bUO.setStyleEnabled(true);
                    i2 = -1;
                }
                if (this.aYx.CL()) {
                    bM(true);
                } else {
                    bM(false);
                    ge("1");
                }
                d(false, i2);
                return;
            }
            this.bUQ.setStyle(3);
            return;
        }
        this.bUQ.setStyle(3);
    }

    private void d(boolean z, int i) {
        g.b bVar;
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
            } else if (this.mType == 1 && (bVar = this.aYx.aSS) != null && !TextUtils.isEmpty(bVar.aTj)) {
                this.mContext.showToast(bVar.aTj);
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
            this.aYK.setPositiveButton(this.mContext.getPageActivity().getString(a.h.ala_gift_join_now), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aYv = false;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913119));
                    bdAlertDialog.dismiss();
                }
            });
            this.aYK.setNegativeButton(this.mContext.getPageActivity().getString(a.h.ala_gift_think), new BdAlertDialog.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaGiftTabView.this.aYv = false;
                    bdAlertDialog.dismiss();
                }
            });
            this.aYK.create(this.mContext).show();
            this.aYv = true;
            LogManager.getGuardClubLogger().doDisplayLiveGiftPopupLog(null, null, null, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(boolean z) {
        boolean z2 = z && com.baidu.live.af.a.OJ().bru.aIJ;
        if (z2) {
            this.aXX.setVisibility(4);
            this.bUQ.setStyle(1);
        } else if (this.aYx != null && this.aYx.CK()) {
            if (this.bUS != null) {
                this.bUS.WS();
            }
            this.aXX.setVisibility(0);
        } else {
            this.aXX.setVisibility(4);
        }
        if (this.bUS != null) {
            this.bUS.f(z2, this.aYx != null ? this.aYx.getThumbnail_url() : null);
        }
    }

    public void Fc() {
        if (this.bUS != null) {
            this.bUS.c(true, this.aYL);
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
        if (this.aXO == null || this.aXO.isEmpty() || (z2 && arrayList != null && !arrayList.isEmpty())) {
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
        Fd();
        if (this.aXO == null || this.aXO.size() <= 0 || !z2) {
            rh();
            if (this.aYc != null) {
                this.aYc.setVisibility(4);
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
            this.aYg.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (AlaGiftTabView.this.bUR != null) {
                        AlaGiftTabView.this.bUR.Fm();
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
                gVar.aTb = 100;
                gVar.setGiftName("发红包");
                Dg.add(1, gVar);
            }
        }
        c(this.aXO, z);
        ge("1");
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
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "tycoon_show"));
            this.aYP.setVisibility(0);
            this.aYP.startLoad(aaVar.iconUrl, 10, false);
            this.aYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "tycoon_clk"));
                    AlaGiftTabView.this.a(aaVar);
                }
            });
            String str = "key_live_official_tip_yuyin" + currentAccount;
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
        int i3;
        g gVar;
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
            ar(arrayList);
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
                        for (int i10 = 0; i10 < ceil; i10++) {
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
                                int i11 = 0;
                                while (true) {
                                    i3 = i11;
                                    if (i3 >= arrayList2.size()) {
                                        gVar = null;
                                        i3 = 0;
                                        break;
                                    }
                                    gVar = arrayList2.get(i3);
                                    if (gVar == null || gVar.CC() == null || !gVar.CC().equals(String.valueOf(this.aYE))) {
                                        i11 = i3 + 1;
                                    } else {
                                        this.mSelectedPosition = i3;
                                        break;
                                    }
                                }
                                if (gVar == null && arrayList2.size() > 0) {
                                    arrayList2.get(0);
                                }
                                this.aYn.add(b(arrayList2, i3, i7));
                                this.bUQ.removeCallbacks(null);
                                this.bUQ.postDelayed(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.17
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AlaGiftTabView.this.aYx != null) {
                                            boolean CL = AlaGiftTabView.this.aYx.CL();
                                            AlaGiftTabView.this.bM(CL);
                                            if (!CL) {
                                                boolean c2 = AlaGiftTabView.this.c(AlaGiftTabView.this.aYx);
                                                if (!c2) {
                                                    AlaGiftTabView.this.bUQ.setStyle(AlaGiftTabView.this.aYx.CK() ? 4 : 3);
                                                } else {
                                                    AlaGiftTabView.this.bUQ.setStyle(AlaGiftTabView.this.aYx.CK() ? 2 : 1);
                                                }
                                                AlaGiftTabView.this.bUO.setStyleEnabled(c2);
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
                                        if (gVar2 == null || !gVar2.CC().equals(String.valueOf(this.aYE))) {
                                            i12 = i2 + 1;
                                        } else {
                                            this.mSelectedPosition = i2;
                                            break;
                                        }
                                    }
                                    this.aYn.add(b(arrayList2, i2, i7));
                                }
                                i2 = -1;
                                this.aYn.add(b(arrayList2, i2, i7));
                            }
                        }
                        i8 = ceil;
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

    private void ar(List<h> list) {
        if (list != null && this.aYD > 0 && this.aYE <= 0) {
            for (h hVar : list) {
                if (hVar.getCategoryId() == this.aYD) {
                    List<g> Dg = hVar.Dg();
                    if (Dg != null && !Dg.isEmpty() && Dg.get(0) != null) {
                        this.aYE = Integer.valueOf(Dg.get(0).CC()).intValue();
                        return;
                    }
                    return;
                }
            }
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
        commonEmptyView.setRefreshButton(a.h.sdk_click_refresh_net_text, new View.OnClickListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGiftTabView.this.bUR != null) {
                    AlaGiftTabView.this.bUR.Fm();
                }
            }
        });
        commonEmptyView.addToParent(frameLayout);
        return frameLayout;
    }

    private FrameLayout b(List<g> list, int i, int i2) {
        FrameLayout frameLayout = new FrameLayout(this.mContext.getPageActivity());
        final com.baidu.live.yuyingift.container.a aVar = new com.baidu.live.yuyingift.container.a(this.mContext, this.mType);
        aVar.bA(this.aWz);
        aVar.setGiftItems(list);
        aVar.cK(this.aWx);
        aVar.bh(this.aWF);
        aVar.cL(i);
        if (this.isLandscape) {
            if (this.aYb.getHeight() > 0) {
                aVar.cM(this.aYb.getHeight() / 3);
            } else {
                this.aYb.post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.2
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
        bdGridView.setOnItemClickListener(new c());
        bdGridView.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.3
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof a.C0235a) {
                    ((a.C0235a) tag).recycle();
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

    /* JADX WARN: Removed duplicated region for block: B:101:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01aa  */
    @SuppressLint({"ResourceAsColor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void cY(int i) {
        int i2;
        JSONArray jSONArray;
        List<g> Dg;
        int childCount = this.aYe.getChildCount();
        if (i >= 0 && i < childCount) {
            if ((this.aYt != i || !this.aYu) && this.aXP.size() > i && this.aXP.get(i) != null) {
                int min = Math.min(i, this.aYz.size());
                int i3 = 0;
                for (int i4 = 0; i4 < min; i4++) {
                    i3 += this.aYz.get(i4);
                }
                if (this.aYn.size() > i3 && this.aXO.size() > i && (this.aYn.get(i3) instanceof ViewGroup)) {
                    this.aYs = i3;
                    h hVar = this.aXO.get(i);
                    if (hVar != null && hVar.Dg() != null && !hVar.Dg().isEmpty()) {
                        ViewGroup viewGroup = (ViewGroup) this.aYn.get(i3);
                        int i5 = 0;
                        while (true) {
                            if (i5 >= viewGroup.getChildCount()) {
                                break;
                            } else if (!(viewGroup.getChildAt(i5) instanceof GridView)) {
                                i5++;
                            } else {
                                com.baidu.live.yuyingift.container.a aVar = (com.baidu.live.yuyingift.container.a) ((GridView) viewGroup.getChildAt(i5)).getAdapter();
                                if (aVar != null) {
                                    if (this.aYu) {
                                        i2 = 0;
                                    } else {
                                        i2 = ((this.isLandscape ? 12 : 8) * this.aYr) + this.mSelectedPosition;
                                    }
                                    a(aVar, i2);
                                    if (this.aYJ) {
                                        this.aYu = true;
                                    }
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
            for (int i6 = 0; i6 < childCount; i6++) {
                ViewGroup viewGroup2 = (ViewGroup) this.aYe.getChildAt(i6);
                GradientTextView gradientTextView = (GradientTextView) viewGroup2.findViewById(a.f.text_view);
                ImageView imageView = (ImageView) viewGroup2.findViewById(a.f.icon_new_unlock_gift);
                imageView.setVisibility(8);
                h hVar2 = this.aXO.get(i6);
                if (hVar2.Dh()) {
                    HashSet hashSet = new HashSet();
                    String string = SharedPrefHelper.getInstance().getString(this.aXU, "");
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
                                    Dg = hVar2.Dg();
                                    if (Dg != null) {
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
                    Dg = hVar2.Dg();
                    if (Dg != null) {
                        ArrayList arrayList = new ArrayList();
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            if (i9 >= Dg.size()) {
                                break;
                            }
                            g gVar = Dg.get(i9);
                            if (!gVar.Db() && !hashSet.contains(gVar.CC())) {
                                arrayList.add(gVar.CC());
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
                                SharedPrefHelper.getInstance().putString(this.aXU, jSONArray.toString());
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
                if (i6 == i) {
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
                        com.baidu.live.yuyingift.container.a aVar = (com.baidu.live.yuyingift.container.a) gridView.getAdapter();
                        if (aVar.EF() >= 0 && i != this.aYs) {
                            aVar.cL(-1);
                        }
                        if (aVar.EF() < 0 && i == this.aYs) {
                            aVar.cL(this.mSelectedPosition);
                        }
                        aVar.notifyDataSetChanged();
                        this.aYh.setVisibility(aVar.getCount() <= 0 ? 4 : 0);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void Ff() {
        i iVar = (i) ListUtils.getItem(this.aXP, this.aYt);
        if (this.bUS != null && iVar != null) {
            this.bUS.aV(String.valueOf(iVar.getCategoryId()), iVar.getCategoryName());
        }
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
        this.bUR = eVar;
    }

    public void da(int i) {
        if (i <= 0) {
            i = 1;
        }
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
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.8
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
        if (!ListUtils.isEmpty(this.aYn) && !TextUtils.isEmpty(str)) {
            new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.9
                @Override // java.lang.Runnable
                public void run() {
                    for (View view : AlaGiftTabView.this.aYn) {
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
    public void Fk() {
        if (!ListUtils.isEmpty(this.aYn)) {
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.live.yuyingift.container.AlaGiftTabView.10
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
                                    if (gridView.getAdapter() instanceof com.baidu.live.yuyingift.container.a) {
                                        ((com.baidu.live.yuyingift.container.a) gridView.getAdapter()).a(gridView, AlaGiftTabView.this.aWF);
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
            this.bUO.setStyleEnabled(this.aWF);
            if (this.aWF) {
                this.bUQ.setStyle(this.aYx.CK() ? 2 : 1);
            } else {
                this.bUQ.setStyle(this.aYx.CK() ? 4 : 3);
            }
        }
    }

    public void onDestroy() {
        this.bUS = null;
        MessageManager.getInstance().unRegisterListener(this.aYY);
        MessageManager.getInstance().unRegisterListener(this.aYZ);
        MessageManager.getInstance().unRegisterListener(this.aZa);
        MessageManager.getInstance().unRegisterListener(this.aZb);
        rh();
        if (this.aYK != null) {
            this.aYK.dismiss();
        }
    }

    public void bA(boolean z) {
        this.aWz = z;
    }

    public void db(int i) {
        this.aWx = i;
    }

    public void d(g gVar) {
        com.baidu.live.gift.c go;
        if (this.bUT != null) {
            this.bUT.EC();
        }
        this.aYx = gVar;
        this.aYE = Integer.valueOf(this.aYx.CC()).intValue();
        if (this.bUS != null) {
            this.bUS.a(gVar);
        }
        if (BdNetTypeUtil.isNetWorkAvailable() && this.aYx.CP() && !com.baidu.live.yuyingift.b.b.Xh().fJ(this.aYx.CC()) && (go = com.baidu.live.yuyingift.b.b.Xh().go(this.aYx.CC())) != null) {
            am.Em().a(go.aSo, true);
        }
    }

    public void WZ() {
        if (this.bUT != null && this.bUT.ED()) {
            this.bUT.EC();
        }
    }

    public void EB() {
        if (this.bUT != null) {
            this.bUT.i(Fh());
        }
    }

    public void EA() {
        if (this.bUT != null) {
            this.bUT.h(Fh());
        }
    }

    public void bQ(boolean z) {
        if (this.bUQ != null) {
            this.bUQ.setVisibility(z ? 0 : 4);
        }
        if (this.aXX != null) {
            this.aXX.setVisibility(z ? 0 : 4);
        }
    }
}
